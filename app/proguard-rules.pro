# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\program\studio\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

#指定代码的压缩级别
-optimizationpasses 5

#包明不混合大小写
-dontusemixedcaseclassnames

#不去忽略非公共的库类
-dontskipnonpubliclibraryclasses

 #优化  不优化输入的类文件
-dontoptimize

 #预校验
-dontpreverify

 #混淆时是否记录日志
-verbose

 # 混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

#保护注解
-keepattributes *Annotation*

#忽略警告
#-ignorewarning
-ignorewarnings
#如果引用了v4或者v7包
-dontwarn android.support.**
-keepattributes Signature

-repackageclasses com.t

-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v4.app.Fragment
-keep public class com.android.vending.licensing.ILicensingService

-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class com.uuhelper.Application.** { *; }
-keep class net.sourceforge.zbar.** { *; }
-keep class com.google.android.gms.** { *; }
-keep class com.bank.pingan.model.** { *; }


-keep class com.android.vending.licensing.ILicensingService
-keep class android.support.v4.** { *; }
-keep class org.apache.commons.net.** { *; }


-dontwarn android.support.v4.**
-dontwarn org.apache.commons.net.**

-keep class android.support.v4.** { *; }
-keep interface android.support.v4.app.** { *; }
-keep public class * extends android.support.v4.**
-keep public class * extends android.app.Fragment

-keepclasseswithmembernames class * {
native <methods>;
}

-keepclasseswithmembernames class * {
public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembernames class * {
public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclassmembers enum * {
public static **[] values();
public static ** valueOf(java.lang.String);
}

-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclasseswithmembers class * {
public <init>(android.content.Context);
}

-keepattributes InnerClasses
-keep class **$Properties

-keepclassmembers class **.R$* {
       public static <fields>;
}
-keep class **.R$* {*;}
-keepattributes InnerClasses
-keep class * extends android.app.Dialog

-dontshrink
-dontoptimize
-dontwarn com.google.android.maps.**
-dontwarn android.webkit.WebView
-dontwarn com.umeng.**
-dontwarn com.tencent.weibo.sdk.**
-dontwarn com.facebook.**

-keep enum com.facebook.**
-keepattributes Exceptions,InnerClasses,Signature
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable

-keep public interface com.facebook.**
-keep public interface com.tencent.**
-keep public interface com.umeng.socialize.**
-keep public interface com.umeng.socialize.sensor.**
-keep public interface com.umeng.scrshot.**

-keep public class com.umeng.socialize.* {*;}
-keep public class javax.**
-keep public class android.webkit.**

-keep class com.facebook.**
-keep class com.umeng.scrshot.**
-keep public class com.tencent.** {*;}
-keep class com.umeng.socialize.sensor.**

-keep class com.tencent.mm.sdk.openapi.WXMediaMessage {*;}

-keep class com.tencent.mm.sdk.openapi.** implements com.tencent.mm.sdk.openapi.WXMediaMessage$IMediaObject {*;}

-keep class im.yixin.sdk.api.YXMessage {*;}
-keep class im.yixin.sdk.api.** implements im.yixin.sdk.api.YXMessage$YXMessageData{*;}

-dontwarn android.support.**
-keep class * extends java.lang.annotation.Annotation { *; }

##---------------Gson----------
-keep class sun.misc.Unsafe { *; }
# Explicitly preserve all serialization members. The Serializable interface
# is only a marker interface, so it wouldn't collect them.
-keepclassmembers class * implements java.io.Serializable {
static final long serialVersionUID;
private static final java.io.ObjectStreamField[] serialPersistentFields;
private void writeObject(java.io.ObjectOutputStream);
private void readObject(java.io.ObjectInputStream);
java.lang.Object writeReplace();
java.lang.Object readResolve();
}

##---------------  android-logging-log4j-1.0.3 ----------
-keep class de.mindpipe.android.logging.** { *; }

##---------------  commons-codec-1.3 ----------
-keep class org.apache.commons.codec.** { *; }

##---------------  commons-lang3-3.4 ----------
-keep class org.apache.commons.lang3.** { *; }

#---------------GetuiSDK2.10.2.0.jar-------------------------
-dontwarn com.igexin.**
-keep class com.igexin.**{*;}
-keep class org.json.** { *; }

##---------------  log4j-1.2.17 ----------
-keep class org.apache.log4j.** { *; }

##---------------   nineoldandroids   ---------------
-dontwarn com.nineoldandroids.*
-keep class com.nineoldandroids.** { *;}

##---------------  pinyin4j-2.5.0.jar  ---------------
-dontwarn demo.**
-keep class demo.**{*;}
-dontwarn net.sourceforge.pinyin4j.**
-keep class net.sourceforge.pinyin4j.**{*;}
-keep class net.sourceforge.pinyin4j.format.**{*;}
-keep class net.sourceforge.pinyin4j.format.exception.**{*;}


##---------------universal-image-loader-------------
-keep class com.nostra13.universalimageloader.** { *; }
-keepclassmembers class com.nostra13.universalimageloader.** {*;}

##---------------qq_open_sdk-------------
-keep class com.tencent.**{*;}
-dontwarn com.tencent.**

##---------------wechat-sdk-android-without-mta-------------
-keep class com.tencent.mm.**{*;}
-dontwarn com.tencent.mm.**

##---------------weiboSDKCore_3.1.4-------------
-keep class com.sina.**{*;}
-dontwarn com.sina.**

##---------------greenDao---------------
-keep class org.greenrobot.** {*;}
-keep class org.greenrobot.greendao.**{*;}
-keepclassmembers class * extends org.greenrobot.greendao.AbstractDao {
public static java.lang.String TABLENAME;
}
-keep class **$Properties
-keep class **$Properties
##---------------  Gson ----------
-keep class com.google.gson.** { *; }
-keep class sun.misc.Unsafe { *; }

##---------------  ijk ----------
-keep class tv.danmaku.ijk.** { *; }
-dontwarn tv.danmaku.ijk.**

##---------------OkHttp---------------
-dontwarn okhttp3.**
-keep class okhttp3.**{*;}
-keepattributes SourceFile,LineNumberTable
-keep class com.parse.*{ *; }
-dontwarn com.parse.**
-dontwarn com.squareup.picasso.**
-keepclasseswithmembernames class * {
    native <methods>;
}
-dontwarn okio.**
-keep class okio.**{*;}

#---------------jsoup混淆-------------------------
-keep class org.jsoup.**

##---------------rxjava---------------
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
 long producerIndex;
 long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
 rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

#---------------GetuiSDK2.10.2.0.jar-------------------------
-dontwarn com.igexin.**
-keep class com.igexin.**{*;}
-keep class org.json.** { *; }

#---------------Webview-------------------------
-keepattributes *Annotation*
-keepattributes *JavascriptInterface*
-keepclassmembers class fqcn.of.javascript.interface.for.Webview {
   public *;
}
-keep class com.mop.assassin.module.web.helper.JsApi { *; }
-keep class * extends com.mop.assassin.module.web.helper.JsApi { *; }
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, jav.lang.String);
}

##---------------  TencentLocationSDK ----------
-keep class c.t.m.**{*;}
-keep class com.tencent.**{*;}
-keep class com.tencent.map.**{*;}
-keep class com.tencent.tencentmap.**{*;}
-keep class com.tencent.mapsdk.**{*;}
-keep class com.tencent.lbssearch.**{*;}
-keep class com.google.gson.examples.android.model.** { *; }
-keepclassmembers class ** {
    public void on*Event(...);
}
-keep class c.t.**{*;}
-keep class com.tencent.map.geolocation.**{*;}
-keep class com.tencent.tencentmap.lbssdk.service.**{*;}

-dontwarn  org.eclipse.jdt.annotation.**
-dontwarn  c.t.**

#---------------ARouter-------------------------
-keep public class com.alibaba.android.arouter.**{*;}
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}

#---------------QQ广点通广告sdk混淆-------------------------
-keep class com.qq.e.** {
    public protected *;
}
-keep class android.support.v4.**{
    public *;
}
-keep class android.support.v7.**{
    public *;
}

##---------------  腾讯云上传 ----------
-keep class com.tencent.**{*;}

#---------------Bugtags-------------------------
-keepattributes LineNumberTable,SourceFile
-keep class com.bugtags.library.** {*;}
-dontwarn com.bugtags.library.**
-keep class io.bugtags.** {*;}
-dontwarn io.bugtags.**
-dontwarn org.apache.http.**
-dontwarn android.net.http.AndroidHttpClient

#---------------个推-------------------------
-dontwarn com.igexin.**
-keep class com.igexin.** { *; }
-keep class org.json.** { *; }

#---------------ButterKnife-------------------------
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

#--------------BaseRecyclerViewAdapterHelper---------------
-keep class com.maiya.core.common.widget.base_recyclerview_adapter_helper.** {
*;
}
-keep public class * extends com.maiya.core.common.widget.base_recyclerview_adapter_helper.BaseQuickAdapter
-keep public class * extends com.maiya.core.common.widget.base_recyclerview_adapter_helper.BaseViewHolder
-keepclassmembers  class **$** extends com.maiya.core.common.widget.base_recyclerview_adapter_helper.BaseViewHolder {
     <init>(...);
}


# for DexGuard only
#-keepresourcexmlelements manifest/application/meta-data@value=GlideModule
-keep class org.aspectj.** {
*;
}
#--------------百川电商SDK---------------
-keepattributes Signature
-keep class sun.misc.Unsafe { *; }
-keep class com.taobao.** {*;}
-keep class com.alibaba.** {*;}
-keep class com.alipay.** {*;}
-dontwarn com.taobao.**
-dontwarn com.alibaba.**
-dontwarn com.alipay.**
-keep class com.ut.** {*;}
-dontwarn com.ut.**
-keep class com.ta.** {*;}
-dontwarn com.ta.**
-keep class org.json.** {*;}
-keep class com.ali.auth.**  {*;}

#---------------shareinstall-------------------------
-keep class com.sh.sdk.shareinstall.**  {*;}

#---------------jsoup-------------------------
-dontwarn org.jsoup.**
-keep class org.jsoup.**{*;}
-keeppackagenames org.jsoup.nodes

#---------------umeng-------------------------
-keep class com.umeng.** {*;}

-keepclassmembers class * {
   public <init> (org.json.JSONObject);
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keep public class  com.maiya.suixingou.R$*{
public static final int *;
}

#---------------穿山甲-------------------------
-keep class com.bytedance.sdk.openadsdk.** { *; }
-keep public interface com.bytedance.sdk.openadsdk.downloadnew.** {*;}
-keep class com.pgl.sys.ces.* {*;}

#---------------中辉-------------------------
-keep class com.my.sxg.** { *; }
-keep class com.xm.** { *; }


#---------------数美-------------------------
-keep class com.ishumei.** { *; }

#---------------一键登录---------------------
#联通免密登录混淆
-dontwarn com.unicom.xiaowo.account.shield.**
-keep class com.unicom.xiaowo.account.shield.**{*;}

#移动免密登录混淆
-keep class com.cmic.sso.sdk.**{*;}
-dontwarn com.cmic.sso.sdk.**

#电信免密登录混淆
-keep class cn.com.chinatelecom.account.**{*;}
-dontwarn cn.com.chinatelecom.account.**

#---------------高德---------------------
# 3D 地图 V5.0.0之前：
-keep   class com.amap.api.maps.**{*;}
-keep   class com.autonavi.amap.mapcore.*{*;}
-keep   class com.amap.api.trace.**{*;}

# 3D 地图 V5.0.0之后：
-keep   class com.amap.api.maps.**{*;}
-keep   class com.autonavi.**{*;}
-keep   class com.amap.api.trace.**{*;}

# 定位
-keep class com.amap.api.location.**{*;}
-keep class com.amap.api.fence.**{*;}
-keep class com.amap.**{*;}
-keep class com.autonavi.**{*;}
-keep class com.loc.**{*;}
-keep class com.autonavi.aps.amapapi.model.**{*;}

# 搜索
-keep   class com.amap.api.seRrvices.**{*;}

# 2D地图
-keep class com.amap.api.maps2d.**{*;}
-keep class com.amap.api.mapcore2d.**{*;}

# 导航
-keep class com.amap.api.navi.**{*;}
-keep class com.autonavi.**{*;}

#---------------miit_mdid_1.0.10.aar-------------------------
-keep class com.bun.miitmdid.** {*;}
-keep class com.asus.msa.** {*;}
-keep class com.heytap.openid.** {*;}
-keep class com.huawei.android.hms.** {*;}
-keep class com.meizu.flyme.openidsdk.** {*;}
-keep class com.samsung.android.** {*;}
-keep class com.zui.deviceidservice.** {*;}
-keep class com.zui.opendeviceidlibrary.** {*;}

-dontwarn com.bun.miitmdid.**
-dontwarn com.asus.msa.**
-dontwarn com.heytap.openid.**
-dontwarn com.huawei.android.hms.**
-dontwarn com.meizu.flyme.openidsdk.**
-dontwarn com.samsung.android.**
-dontwarn com.zui.deviceidservice.**
-dontwarn com.zui.opendeviceidlibrary.**

#---------------android.support.shadow-------------------------
-dontwarn android.support.shadow.bean.**
-keep class android.support.shadow.bean.** { *; }

#---------------HealthDetect_v1.0-------------------------
-dontwarn com.songwo.libdetect.**
-keep class com.songwo.libdetect.** { *; }

#---------------BugReport-------------------------
-dontwarn com.my.sdk.bug_report.**
-keep class com.my.sdk.bug_report.** { *; }

#---------------App-------------------------
-keepattributes *Annotation*
-keepclassmembers class ** {
    @com.gx.dfttsdk.news.core_framework.bus.Subscribe <methods>;
}
-keep class com.maiya.core.common.widget.loading_indicator_view.** { *; }

-keep enum com.gx.dfttsdk.news.core_framework.bus.ThreadMode { *; }
-keep class com.songwo.luckycat.business.manager.UserWrapper {
*;
}

-keep class com.songheng.library.app.util.** { *; }
-keep class com.maiya.core.common.dsbridge.** { *; }
-keep class com.maiya.core.common.widget.imagepicker.bean.ImageItem { *; }


-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class com.songwo.luckycat.serverbean.** { *; }
-keep class com.songwo.luckycat.business.serverbean.** { *; }
-keep class com.songwo.luckycat.common.bean.** { *; }
-keep public class * implements java.io.Serializable {*;}

-keep class com.mop.assassin.**.bean.** { *; }


#---------------bugly-------------------------
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}

#Tinker start
-keepclasseswithmembernames class com.tencent.tinker.** {*;}
#Tinker end


-keep  class * implements java.io.Serializable {*;}

# 定位
-keep class com.amap.api.location.**{*;}
-keep class com.amap.api.fence.**{*;}
-keep class com.amap.**{*;}
-keep class com.autonavi.**{*;}
-keep class com.loc.**{*;}
-keep class com.autonavi.aps.amapapi.model.**{*;}

#---------------数美-------------------------
-keep class com.ishumei.** { *; }
#---------------miit_mdid_1.0.10.aar-------------------------
-keep class com.bun.miitmdid.** {*;}

#---------------瞬推 推送-------------------------
-dontwarn com.my.sdk.**
-keep class com.my.sdk.** { *; }
-dontwarn com.my.sdk.stpush.**
-keep class com.my.sdk.stpush.** { *; }
-keep class com.adplus.sdk.AdPlusManager { *; }

#---------------华为 推送-------------------------
-dontwarn com.huawei.hms.**
-keep class com.huawei.hms.** { *; }
-keep class com.huawei.android.** { *; }
-dontwarn com.huawei.android.**
-keep class com.hianalytics.android.** { *; }
-dontwarn com.hianalytics.android.**
-keep class com.huawei.updatesdk.** { *; }
-dontwarn com.huawei.updatesdk.**
#-ignorewarning
-ignorewarnings
-keepattributes *Annotation*
-keepattributes Exceptions
-keepattributes InnerClasses
-keepattributes Signature
-keepattributes SourceFile,LineNumberTable
-keep class com.huawei.android.hms.agent.**{*;}
-dontwarn com.huawei.android.hms.agent.**

#---------------小米 推送-------------------------
-keep class com.xiaomi.** { *; }
-dontwarn com.xiaomi.**
-keep class org.apache.thrift.** { *; }

#---------------魅族 推送-------------------------
-keep class com.meizu.** { *; }
-dontwarn com.meizu.**

#---------------oppo 1.5.0  sdk 1.0.7之前的版本-------------------------
-keep class com.coloros.mcssdk.** { *; }
-dontwarn com.coloros.mcssdk.**

#---------------oppo 2.1.0  sdk 1.0.7及后续版本-------------------------
-keep class com.heytap.msp.** { *;}
-dontwarn  com.heytap.msp.**

#---------------vivo 推送-------------------------
-keep class com.vivo.** { *; }
-dontwarn com.vivo.**
#---------------Egret Native-------------------------
-keep class org.egret.runtime.launcherInterface.** {
    *;
}
-keep class org.egret.** {
    *;
}
#---------------移动安全联盟-------------------------
-keep class com.bun.miitmdid.core.**{*;}

#---------------glide-------------------------
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
 <init>(...);
}
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep class com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$InternalRewinder {
  *** rewind();
}

# for DexGuard only
#-keepresourcexmlelements manifest/application/meta-data@value=GlideModule

-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep class com.bumptech.glide.GeneratedAppGlideModuleImpl
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}




# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#
#-------------------------------------------基本不用动区域----------------------------------------------
#
#
# -----------------------------基本 -----------------------------
#

# 指定代码的压缩级别 0 - 7(指定代码进行迭代优化的次数，在Android里面默认是5，这条指令也只有在可以优化时起作用。)
-optimizationpasses 5
# 混淆时不会产生形形色色的类名(混淆时不使用大小写混合类名)
-dontusemixedcaseclassnames
# 指定不去忽略非公共的库类(不跳过library中的非public的类)
-dontskipnonpubliclibraryclasses
# 指定不去忽略包可见的库类的成员
-dontskipnonpubliclibraryclassmembers
#不进行优化，建议使用此选项，
-dontoptimize
 # 不进行预校验,Android不需要,可加快混淆速度。
-dontpreverify
# 屏蔽警告
-ignorewarnings
#如果引用了v4或者v7包
-dontwarn android.support.**
# 指定混淆是采用的算法，后面的参数是一个过滤器
# 这个过滤器是谷歌推荐的算法，一般不做更改
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
# 保护代码中的Annotation不被混淆,保护注解
-keepattributes *Annotation*
# 避免混淆泛型, 这在JSON实体映射时非常重要
-keepattributes Signature
# 抛出异常时保留代码行号
-keepattributes SourceFile,LineNumberTable
 #优化时允许访问并修改有修饰符的类和类的成员，这可以提高优化步骤的结果。
# 比如，当内联一个公共的getter方法时，这也可能需要外地公共访问。
# 虽然java二进制规范不需要这个，要不然有的虚拟机处理这些代码会有问题。当有优化和使用-repackageclasses时才适用。
#指示语：不能用这个指令处理库中的代码，因为有的类和类成员没有设计成public ,而在api中可能变成public
-allowaccessmodification
#当有优化和使用-repackageclasses时才适用。
#-repackageclasses
 # 混淆时记录日志(打印混淆的详细信息)
 # 这句话能够使我们的项目混淆后产生映射文件
 # 包含有类名->混淆后类名的映射关系
  #混淆时是否记录日志
-verbose

#
# ----------------------------- 默认保留 -----------------------------
#
#----------------------------------------------------
# 保持哪些类不被混淆
#继承activity,application,service,broadcastReceiver,contentprovider....不进行混淆
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.support.multidex.MultiDexApplication
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.app.backup.BackupAgentHelper
-keep public class * extends android.preference.Preference
-keep public class * extends android.view.View
#-keep class android.support.** {*;}## 保留support下的所有类及其内部类

-keep public class com.google.vending.licensing.ILicensingService
-keep public class com.android.vending.licensing.ILicensingService
#表示不混淆上面声明的类，最后这两个类我们基本也用不上，是接入Google原生的一些服务时使用的。
#----------------------------------------------------

# 保留继承的
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.v7.**
-keep public class * extends android.support.annotation.**


#表示不混淆任何包含native方法的类的类名以及native方法名，这个和我们刚才验证的结果是一致
-keepclasseswithmembernames class * {
    native <methods>;
}


#这个主要是在layout 中写的onclick方法android:onclick="onClick"，不进行混淆
#表示不混淆Activity中参数是View的方法，因为有这样一种用法，在XML中配置android:onClick=”buttonClick”属性，
#当用户点击该按钮时就会调用Activity中的buttonClick(View view)方法，如果这个方法被混淆的话就找不到了
-keepclassmembers class * extends android.app.Activity{
    public void *(android.view.View);
}

#表示不混淆枚举中的values()和valueOf()方法，枚举我用的非常少，这个就不评论了
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#表示不混淆任何一个View中的setXxx()和getXxx()方法，
#因为属性动画需要有相应的setter和getter的方法实现，混淆了就无法工作了。
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

#表示不混淆Parcelable实现类中的CREATOR字段，
#毫无疑问，CREATOR字段是绝对不能改变的，包括大小写都不能变，不然整个Parcelable工作机制都会失败。
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}
# 这指定了继承Serizalizable的类的如下成员不被移除混淆
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
# 保留R下面的资源
#-keep class **.R$* {
# *;
#}
#不混淆资源类下static的
-keepclassmembers class **.R$* {
    public static <fields>;
}

# 对于带有回调函数的onXXEvent、**On*Listener的，不能被混淆
-keepclassmembers class * {
    void *(**On*Event);
    void *(**On*Listener);
}

# 保留我们自定义控件（继承自View）不被混淆
-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

#
#----------------------------- WebView(项目中没有可以忽略) -----------------------------
#
#webView需要进行特殊处理
-keepclassmembers class fqcn.of.javascript.interface.for.Webview {
   public *;
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, java.lang.String);
}
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, jav.lang.String);
}
#在app中与HTML5的JavaScript的交互进行特殊处理
#我们需要确保这些js要调用的原生方法不能够被混淆，于是我们需要做如下处理：
-keepclassmembers class com.ljd.example.JSInterface {
    <methods>;
}
# ----------------------------- webview -----------------------------
-keepattributes *Annotation*
-keepattributes *JavascriptInterface*
# ----------------------------- 其他的 -----------------------------
#
# 删除代码中Log相关的代码
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}

# 保持测试相关的代码
-dontnote junit.framework.**
-dontnote junit.runner.**
-dontwarn android.test.**
-dontwarn android.support.test.**
-dontwarn org.junit.**

-keepclassmembernames class android.view.LayoutInflater {
    *** inflate(...);
}
#-keep class com.github.themvp.**.*.IView
#-keep class com.github.themvp.presenter.IPresenter
#-keep class com.github.themvp.**.*.IDelegate
#-keep class com.github.themvp.reflection.ViewBindingUtils

#-keep public class * extends com.github.themvp.**.*.IView
-keep public class * extends com.github.themvp.presenter.IPresenter
#-keep   class   com.github.themvp.activity.Test
#-keep public class * extends com.github.themvp.**.*.IDelegate
-keepclassmembers class * implements **.*.ViewBinding {
  public static ** inflate(...);
  public static ** bind(***);
}
-keep class **.response.**{*;}