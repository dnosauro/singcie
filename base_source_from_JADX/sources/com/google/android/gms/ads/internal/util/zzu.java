package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzbdu;
import com.google.android.gms.internal.ads.zzbdv;
import com.google.android.gms.internal.ads.zzbez;
import com.google.android.gms.internal.ads.zzts;
import com.google.android.gms.internal.ads.zzuo;
import java.io.InputStream;
import java.util.Map;

@TargetApi(16)
public class zzu {
    private zzu() {
    }

    public static boolean zza(zzbdv zzbdv) {
        if (zzbdv == null) {
            return false;
        }
        zzbdv.onPause();
        return true;
    }

    public static boolean zzb(zzbdv zzbdv) {
        if (zzbdv == null) {
            return false;
        }
        zzbdv.onResume();
        return true;
    }

    public static zzu zzdh(int i) {
        return i >= 28 ? new zzab() : i >= 26 ? new zzac() : i >= 24 ? new zzz() : i >= 21 ? new zzaa() : i >= 19 ? new zzx() : i >= 18 ? new zzy() : i >= 17 ? new zzv() : new zzu();
    }

    public static boolean zzyl() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public int zza(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "wifi_on", 0);
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }

    public zzbdu zza(zzbdv zzbdv, zzts zzts, boolean z) {
        return new zzbez(zzbdv, zzts, z);
    }

    public zzuo zza(Context context, TelephonyManager telephonyManager) {
        return zzuo.ENUM_UNKNOWN;
    }

    public boolean zza(Activity activity, Configuration configuration) {
        return false;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        zzbu.zza(context, new zzt(context, webSettings));
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }

    public int zzb(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "airplane_mode_on", 0);
    }

    public void zzbg(Context context) {
    }

    public CookieManager zzbh(Context context) {
        if (zzyl()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzd.zzc("Failed to obtain CookieManager.", th);
            zzp.zzku().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public void zzi(Activity activity) {
    }

    public int zzyj() {
        return 5;
    }

    public ViewGroup.LayoutParams zzyk() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public int zzym() {
        return 1;
    }

    public long zzyn() {
        return -1;
    }
}
