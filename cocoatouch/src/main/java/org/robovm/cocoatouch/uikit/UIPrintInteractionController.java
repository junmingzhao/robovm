/*
 * Copyright (C) 2012 RoboVM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.robovm.cocoatouch.uikit;

/*<imports>*/
import org.robovm.cocoatouch.coreanimation.*;
import org.robovm.cocoatouch.coredata.*;
import org.robovm.cocoatouch.coregraphics.*;
import org.robovm.cocoatouch.coreimage.*;
import org.robovm.cocoatouch.foundation.*;
import java.util.*;
import org.robovm.objc.*;
import org.robovm.objc.annotation.*;
import org.robovm.objc.block.*;
import org.robovm.rt.bro.annotation.*;
import org.robovm.rt.bro.ptr.*;
/*</imports>*/

/**
 *
 *
 * <div class="javadoc">
 *   @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html">UIPrintInteractionController Class Reference</a>
 *   @since Available in iOS 4.2 and later.
 * </div>
 */
/*<library>*/@Library("UIKit")/*</library>*/
public class /*<name>*/ UIPrintInteractionController /*</name>*/ 
    extends /*<extends>*/ NSObject /*</extends>*/ 
    /*<implements>*/ /*</implements>*/ {

    static {
        ObjCRuntime.bind(/*<name>*/ UIPrintInteractionController /*</name>*/.class);
    }

    private static final ObjCClass objCClass = ObjCClass.getByType(/*<name>*/ UIPrintInteractionController /*</name>*/.class);

    /*<constructors>*/
    protected UIPrintInteractionController(SkipInit skipInit) { super(skipInit); }
    public UIPrintInteractionController() {}
    
    /*</constructors>*/
    /*<properties>*/
    
    private static final Selector delegate = Selector.register("delegate");
    @Bridge(symbol = "objc_msgSend") private native static UIPrintInteractionControllerDelegate objc_getDelegate(UIPrintInteractionController __self__, Selector __cmd__);
    @Bridge(symbol = "objc_msgSendSuper") private native static UIPrintInteractionControllerDelegate objc_getDelegateSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/delegate">@property(nonatomic, assign) id&amp;lt;UIPrintInteractionControllerDelegate&amp;gt; delegate</a>
     * @since Available in iOS 4.2 and later.
     */
    public UIPrintInteractionControllerDelegate getDelegate() {
        if (customClass) { return objc_getDelegateSuper(getSuper(), this, delegate); } else { return objc_getDelegate(this, delegate); }
    }
    
    private static final Selector setDelegate$ = Selector.register("setDelegate:");
    @Bridge(symbol = "objc_msgSend") private native static void objc_setDelegate(UIPrintInteractionController __self__, Selector __cmd__, UIPrintInteractionControllerDelegate delegate);
    @Bridge(symbol = "objc_msgSendSuper") private native static void objc_setDelegateSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__, UIPrintInteractionControllerDelegate delegate);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/delegate">@property(nonatomic, assign) id&amp;lt;UIPrintInteractionControllerDelegate&amp;gt; delegate</a>
     * @since Available in iOS 4.2 and later.
     */
    public void setDelegate(UIPrintInteractionControllerDelegate delegate) {
        if (customClass) { objc_setDelegateSuper(getSuper(), this, setDelegate$, delegate); } else { objc_setDelegate(this, setDelegate$, delegate); }
    }
    
    private static final Selector printFormatter = Selector.register("printFormatter");
    @Bridge(symbol = "objc_msgSend") private native static UIPrintFormatter objc_getPrintFormatter(UIPrintInteractionController __self__, Selector __cmd__);
    @Bridge(symbol = "objc_msgSendSuper") private native static UIPrintFormatter objc_getPrintFormatterSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/printFormatter">@property(nonatomic, retain) UIPrintFormatter *printFormatter</a>
     * @since Available in iOS 4.2 and later.
     */
    public UIPrintFormatter getPrintFormatter() {
        if (customClass) { return objc_getPrintFormatterSuper(getSuper(), this, printFormatter); } else { return objc_getPrintFormatter(this, printFormatter); }
    }
    
    private static final Selector setPrintFormatter$ = Selector.register("setPrintFormatter:");
    @Bridge(symbol = "objc_msgSend") private native static void objc_setPrintFormatter(UIPrintInteractionController __self__, Selector __cmd__, UIPrintFormatter printFormatter);
    @Bridge(symbol = "objc_msgSendSuper") private native static void objc_setPrintFormatterSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__, UIPrintFormatter printFormatter);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/printFormatter">@property(nonatomic, retain) UIPrintFormatter *printFormatter</a>
     * @since Available in iOS 4.2 and later.
     */
    public void setPrintFormatter(UIPrintFormatter printFormatter) {
        if (customClass) { objc_setPrintFormatterSuper(getSuper(), this, setPrintFormatter$, printFormatter); } else { objc_setPrintFormatter(this, setPrintFormatter$, printFormatter); }
    }
    
    private static final Selector printInfo = Selector.register("printInfo");
    @Bridge(symbol = "objc_msgSend") private native static UIPrintInfo objc_getPrintInfo(UIPrintInteractionController __self__, Selector __cmd__);
    @Bridge(symbol = "objc_msgSendSuper") private native static UIPrintInfo objc_getPrintInfoSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/printInfo">@property(nonatomic, retain) UIPrintInfo *printInfo</a>
     * @since Available in iOS 4.2 and later.
     */
    public UIPrintInfo getPrintInfo() {
        if (customClass) { return objc_getPrintInfoSuper(getSuper(), this, printInfo); } else { return objc_getPrintInfo(this, printInfo); }
    }
    
    private static final Selector setPrintInfo$ = Selector.register("setPrintInfo:");
    @Bridge(symbol = "objc_msgSend") private native static void objc_setPrintInfo(UIPrintInteractionController __self__, Selector __cmd__, UIPrintInfo printInfo);
    @Bridge(symbol = "objc_msgSendSuper") private native static void objc_setPrintInfoSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__, UIPrintInfo printInfo);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/printInfo">@property(nonatomic, retain) UIPrintInfo *printInfo</a>
     * @since Available in iOS 4.2 and later.
     */
    public void setPrintInfo(UIPrintInfo printInfo) {
        if (customClass) { objc_setPrintInfoSuper(getSuper(), this, setPrintInfo$, printInfo); } else { objc_setPrintInfo(this, setPrintInfo$, printInfo); }
    }
    
    private static final Selector printPageRenderer = Selector.register("printPageRenderer");
    @Bridge(symbol = "objc_msgSend") private native static UIPrintPageRenderer objc_getPrintPageRenderer(UIPrintInteractionController __self__, Selector __cmd__);
    @Bridge(symbol = "objc_msgSendSuper") private native static UIPrintPageRenderer objc_getPrintPageRendererSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/printPageRenderer">@property(nonatomic, retain) UIPrintPageRenderer printPageRenderer</a>
     * @since Available in iOS 4.2 and later.
     */
    public UIPrintPageRenderer getPrintPageRenderer() {
        if (customClass) { return objc_getPrintPageRendererSuper(getSuper(), this, printPageRenderer); } else { return objc_getPrintPageRenderer(this, printPageRenderer); }
    }
    
    private static final Selector setPrintPageRenderer$ = Selector.register("setPrintPageRenderer:");
    @Bridge(symbol = "objc_msgSend") private native static void objc_setPrintPageRenderer(UIPrintInteractionController __self__, Selector __cmd__, UIPrintPageRenderer printPageRenderer);
    @Bridge(symbol = "objc_msgSendSuper") private native static void objc_setPrintPageRendererSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__, UIPrintPageRenderer printPageRenderer);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/printPageRenderer">@property(nonatomic, retain) UIPrintPageRenderer printPageRenderer</a>
     * @since Available in iOS 4.2 and later.
     */
    public void setPrintPageRenderer(UIPrintPageRenderer printPageRenderer) {
        if (customClass) { objc_setPrintPageRendererSuper(getSuper(), this, setPrintPageRenderer$, printPageRenderer); } else { objc_setPrintPageRenderer(this, setPrintPageRenderer$, printPageRenderer); }
    }
    
    private static final Selector printPaper = Selector.register("printPaper");
    @Bridge(symbol = "objc_msgSend") private native static UIPrintPaper objc_getPrintPaper(UIPrintInteractionController __self__, Selector __cmd__);
    @Bridge(symbol = "objc_msgSendSuper") private native static UIPrintPaper objc_getPrintPaperSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/printPaper">@property(nonatomic, readonly) UIPrintPaper *printPaper</a>
     * @since Available in iOS 4.2 and later.
     */
    public UIPrintPaper getPrintPaper() {
        if (customClass) { return objc_getPrintPaperSuper(getSuper(), this, printPaper); } else { return objc_getPrintPaper(this, printPaper); }
    }
    
    private static final Selector printingItem = Selector.register("printingItem");
    @Bridge(symbol = "objc_msgSend") private native static NSObject objc_getPrintingItem(UIPrintInteractionController __self__, Selector __cmd__);
    @Bridge(symbol = "objc_msgSendSuper") private native static NSObject objc_getPrintingItemSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/printingItem">@property(nonatomic, copy) id printingItem</a>
     * @since Available in iOS 4.2 and later.
     */
    public NSObject getPrintingItem() {
        if (customClass) { return objc_getPrintingItemSuper(getSuper(), this, printingItem); } else { return objc_getPrintingItem(this, printingItem); }
    }
    
    private static final Selector setPrintingItem$ = Selector.register("setPrintingItem:");
    @Bridge(symbol = "objc_msgSend") private native static void objc_setPrintingItem(UIPrintInteractionController __self__, Selector __cmd__, NSObject printingItem);
    @Bridge(symbol = "objc_msgSendSuper") private native static void objc_setPrintingItemSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__, NSObject printingItem);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/printingItem">@property(nonatomic, copy) id printingItem</a>
     * @since Available in iOS 4.2 and later.
     */
    public void setPrintingItem(NSObject printingItem) {
        if (customClass) { objc_setPrintingItemSuper(getSuper(), this, setPrintingItem$, printingItem); } else { objc_setPrintingItem(this, setPrintingItem$, printingItem); }
    }
    
    private static final Selector printingItems = Selector.register("printingItems");
    @Bridge(symbol = "objc_msgSend") private native static NSArray objc_getPrintingItems(UIPrintInteractionController __self__, Selector __cmd__);
    @Bridge(symbol = "objc_msgSendSuper") private native static NSArray objc_getPrintingItemsSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/printingItems">@property(nonatomic, copy) NSArray *printingItems</a>
     * @since Available in iOS 4.2 and later.
     */
    public NSArray getPrintingItems() {
        if (customClass) { return objc_getPrintingItemsSuper(getSuper(), this, printingItems); } else { return objc_getPrintingItems(this, printingItems); }
    }
    
    private static final Selector setPrintingItems$ = Selector.register("setPrintingItems:");
    @Bridge(symbol = "objc_msgSend") private native static void objc_setPrintingItems(UIPrintInteractionController __self__, Selector __cmd__, NSArray printingItems);
    @Bridge(symbol = "objc_msgSendSuper") private native static void objc_setPrintingItemsSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__, NSArray printingItems);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/printingItems">@property(nonatomic, copy) NSArray *printingItems</a>
     * @since Available in iOS 4.2 and later.
     */
    public void setPrintingItems(NSArray printingItems) {
        if (customClass) { objc_setPrintingItemsSuper(getSuper(), this, setPrintingItems$, printingItems); } else { objc_setPrintingItems(this, setPrintingItems$, printingItems); }
    }
    
    private static final Selector showsPageRange = Selector.register("showsPageRange");
    @Bridge(symbol = "objc_msgSend") private native static boolean objc_isShowsPageRange(UIPrintInteractionController __self__, Selector __cmd__);
    @Bridge(symbol = "objc_msgSendSuper") private native static boolean objc_isShowsPageRangeSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/showsPageRange">@property(nonatomic) BOOL showsPageRange</a>
     * @since Available in iOS 4.2 and later.
     */
    public boolean isShowsPageRange() {
        if (customClass) { return objc_isShowsPageRangeSuper(getSuper(), this, showsPageRange); } else { return objc_isShowsPageRange(this, showsPageRange); }
    }
    
    private static final Selector setShowsPageRange$ = Selector.register("setShowsPageRange:");
    @Bridge(symbol = "objc_msgSend") private native static void objc_setShowsPageRange(UIPrintInteractionController __self__, Selector __cmd__, boolean showsPageRange);
    @Bridge(symbol = "objc_msgSendSuper") private native static void objc_setShowsPageRangeSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__, boolean showsPageRange);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instp/UIPrintInteractionController/showsPageRange">@property(nonatomic) BOOL showsPageRange</a>
     * @since Available in iOS 4.2 and later.
     */
    public void setShowsPageRange(boolean showsPageRange) {
        if (customClass) { objc_setShowsPageRangeSuper(getSuper(), this, setShowsPageRange$, showsPageRange); } else { objc_setShowsPageRange(this, setShowsPageRange$, showsPageRange); }
    }
    /*</properties>*/
    /*<methods>*/
    
    private static final Selector canPrintData$ = Selector.register("canPrintData:");
    @Bridge(symbol = "objc_msgSend") private native static boolean objc_canPrint(ObjCClass __self__, Selector __cmd__, NSData data);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/clm/UIPrintInteractionController/canPrintData:">+ (BOOL)canPrintData:(NSData *)data</a>
     * @since Available in iOS 4.2 and later.
     */
    public static boolean canPrint(NSData data) {
        return objc_canPrint(objCClass, canPrintData$, data);
    }
    
    private static final Selector canPrintURL$ = Selector.register("canPrintURL:");
    @Bridge(symbol = "objc_msgSend") private native static boolean objc_canPrint(ObjCClass __self__, Selector __cmd__, NSURL url);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/clm/UIPrintInteractionController/canPrintURL:">+ (BOOL)canPrintURL:(NSURL *)url</a>
     * @since Available in iOS 4.2 and later.
     */
    public static boolean canPrint(NSURL url) {
        return objc_canPrint(objCClass, canPrintURL$, url);
    }
    
    private static final Selector printableUTIs = Selector.register("printableUTIs");
    @Bridge(symbol = "objc_msgSend") private native static NSSet objc_getPrintableUTIs(ObjCClass __self__, Selector __cmd__);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/clm/UIPrintInteractionController/printableUTIs">+ (NSSet *)printableUTIs</a>
     * @since Available in iOS 4.2 and later.
     */
    public static NSSet getPrintableUTIs() {
        return objc_getPrintableUTIs(objCClass, printableUTIs);
    }
    
    private static final Selector sharedPrintController = Selector.register("sharedPrintController");
    @Bridge(symbol = "objc_msgSend") private native static UIPrintInteractionController objc_getSharedPrintController(ObjCClass __self__, Selector __cmd__);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/clm/UIPrintInteractionController/sharedPrintController">+ (UIPrintInteractionController *)sharedPrintController</a>
     * @since Available in iOS 4.2 and later.
     */
    public static UIPrintInteractionController getSharedPrintController() {
        return objc_getSharedPrintController(objCClass, sharedPrintController);
    }
    
    private static final Selector isPrintingAvailable = Selector.register("isPrintingAvailable");
    @Bridge(symbol = "objc_msgSend") private native static boolean objc_isPrintingAvailable(ObjCClass __self__, Selector __cmd__);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/clm/UIPrintInteractionController/isPrintingAvailable">+ (BOOL)isPrintingAvailable</a>
     * @since Available in iOS 4.2 and later.
     */
    public static boolean isPrintingAvailable() {
        return objc_isPrintingAvailable(objCClass, isPrintingAvailable);
    }
    
    private static final Selector dismissAnimated$ = Selector.register("dismissAnimated:");
    @Bridge(symbol = "objc_msgSend") private native static void objc_dismiss(UIPrintInteractionController __self__, Selector __cmd__, boolean animated);
    @Bridge(symbol = "objc_msgSendSuper") private native static void objc_dismissSuper(ObjCSuper __super__, UIPrintInteractionController __self__, Selector __cmd__, boolean animated);
    /**
     * @see <a href="http://developer.apple.com/library/ios/documentation/uikit/reference/UIKit_Framework/../UIPrintInteractionController_Class/Reference/Reference.html#//apple_ref/occ/instm/UIPrintInteractionController/dismissAnimated:">- (void)dismissAnimated:(BOOL)animated</a>
     * @since Available in iOS 4.2 and later.
     */
    public void dismiss(boolean animated) {
        if (customClass) { objc_dismissSuper(getSuper(), this, dismissAnimated$, animated); } else { objc_dismiss(this, dismissAnimated$, animated); }
    }
    /*</methods>*/
    /*<callbacks>*/
    static class Callbacks {
        @Callback @BindSelector("dismissAnimated:") public static void dismiss(UIPrintInteractionController __self__, Selector __cmd__, boolean animated) { __self__.dismiss(animated); }
    }
    /*</callbacks>*/

}
