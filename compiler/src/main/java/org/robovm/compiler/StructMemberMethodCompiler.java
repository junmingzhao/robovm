/*
 * Copyright (C) 2012 Trillian AB
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/gpl-2.0.html>.
 */
package org.robovm.compiler;


import static org.robovm.compiler.Annotations.*;
import static org.robovm.compiler.Bro.*;
import static org.robovm.compiler.Functions.*;
import static org.robovm.compiler.Types.*;
import static org.robovm.compiler.llvm.Type.*;

import org.robovm.compiler.Bro.StructMemberPair;
import org.robovm.compiler.llvm.Function;
import org.robovm.compiler.llvm.Getelementptr;
import org.robovm.compiler.llvm.Inttoptr;
import org.robovm.compiler.llvm.Load;
import org.robovm.compiler.llvm.PointerType;
import org.robovm.compiler.llvm.PrimitiveType;
import org.robovm.compiler.llvm.Ret;
import org.robovm.compiler.llvm.Store;
import org.robovm.compiler.llvm.StructureType;
import org.robovm.compiler.llvm.Type;
import org.robovm.compiler.llvm.Value;
import org.robovm.compiler.llvm.Variable;
import org.robovm.compiler.llvm.VariableRef;

import soot.SootClass;
import soot.SootMethod;
import soot.VoidType;

/**
 * @author niklas
 *
 */
public class StructMemberMethodCompiler extends BroMethodCompiler {

    public StructMemberMethodCompiler(Config config) {
        super(config);
    }

    @Override
    protected void doCompile(ModuleBuilder moduleBuilder, SootMethod method) {
        if ("_sizeOf".equals(method.getName()) || "sizeOf".equals(method.getName())) {
            structSizeOf(moduleBuilder, method);
        } else {
            structMember(moduleBuilder, method);
        }
    }
    
    private void structSizeOf(ModuleBuilder moduleBuilder, SootMethod method) {
        SootClass sootClass = method.getDeclaringClass();
        StructureType type = getStructType(sootClass);
        if (type == null) {
            throw new IllegalArgumentException("Struct class " + sootClass + " has no @StructMember annotated methods");
        }
        Function fn = FunctionBuilder.structSizeOf(method);
        moduleBuilder.addFunction(fn);
        fn.add(new Ret(sizeof(type)));
    }

    private void structMember(ModuleBuilder moduleBuilder, SootMethod method) {
        SootClass sootClass = method.getDeclaringClass();
        StructureType structType = getStructType(sootClass);
        if (structType == null) {
            throw new IllegalArgumentException("Struct class " + sootClass + " has no @StructMember annotated methods");
        }
        Function function = FunctionBuilder.structMember(method);
        moduleBuilder.addFunction(function);
        
        // Get the value of the handle field in the Struct base class and cast it to a <structType>*
        Variable handleI64 = function.newVariable(I64);
        function.add(new Load(handleI64, getFieldPtr(function, function.getParameterRef(1), 
                offsetof(new StructureType(DATA_OBJECT, new StructureType(I64)), 1, 0), I64)));
        Variable handlePtr = function.newVariable(new PointerType(structType));
        function.add(new Inttoptr(handlePtr, handleI64.ref(), handlePtr.getType()));
        
        int offset = getStructMemberOffset(method);      
        Type memberType = structType.getTypeAt(offset);
        Variable memberPtr = function.newVariable(new PointerType(memberType));
        function.add(new Getelementptr(memberPtr, handlePtr.ref(), 0, offset));
        
        StructMemberPair pair = getStructMemberPair(sootClass, offset);
        
        VariableRef env = function.getParameterRef(0);
        if (method == pair.getGetter()) {
            soot.Type type = method.getReturnType();
            
            Value result = null;
            if (memberType instanceof StructureType) {
                // The member is a child struct contained in the current struct
                result = memberPtr.ref();
            } else {
                Variable tmp = function.newVariable(memberType);
                function.add(new Load(tmp, memberPtr.ref()));
                result = tmp.ref();
            }
            
            if (needsMarshaler(type)) {
                String marshalerClassName = getMarshalerClassName(method, true);
                String targetClassName = getInternalName(type);
                
                if (memberType instanceof PrimitiveType) {
                    if (isEnum(type)) {
                        result = marshalNativeToEnumObject(function, marshalerClassName, env, targetClassName, result);
                    } else {
                        result = marshalNativeToValueObject(function, marshalerClassName, env, targetClassName, result);
                    }
                } else {
                    if (isPtr(type)) {
                        result = marshalNativeToPtr(function, marshalerClassName, null, env, 
                                getPtrTargetClass(method), result, getPtrWrapCount(method));
                    } else {
                        result = marshalNativeToObject(function, marshalerClassName, null, env, 
                                targetClassName, result, false);
                    }
                }
            } else if (hasPointerAnnotation(method)) {
                // @Pointer long
                result = marshalPointerToLong(function, result);
            }
            function.add(new Ret(result));
            
        } else {
            
            Value nativeValue = function.getParameterRef(2); // 'env' is parameter 0, 'this' is at 1, the value we're interested in is at index 2
            soot.Type type = method.getParameterType(0);
            
            if (needsMarshaler(type)) {
                String marshalerClassName = getMarshalerClassName(method, 0, false);
                
                if (memberType instanceof PrimitiveType) {
                    if (isEnum(type)) {
                        nativeValue = marshalEnumObjectToNative(function, marshalerClassName, memberType, env, nativeValue);
                    } else {
                        nativeValue = marshalValueObjectToNative(function, marshalerClassName, memberType, env, nativeValue);
                    }
                } else {
                    if (memberType instanceof StructureType) {
                        // The parameter must not be null. We assume that Structs 
                        // never have a NULL handle so we just check that the Java
                        // Object isn't null.
                        call(function, CHECK_NULL, env, nativeValue);
                    }
                    
                    nativeValue = marshalObjectToNative(function, marshalerClassName, null, memberType, env, nativeValue);
                }
            } else if (hasPointerAnnotation(method, 0)) {
                nativeValue = marshalLongToPointer(function, nativeValue);
            }
            function.add(new Store(nativeValue, memberPtr.ref()));
            
            if (method.getReturnType().equals(VoidType.v())) {
                function.add(new Ret());
            } else {
                function.add(new Ret(function.getParameterRef(1)));
            }
        }
    }
}
