package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzbdu;
import com.google.android.gms.internal.ads.zzbdv;
import com.google.android.gms.internal.ads.zzbfb;
import com.google.android.gms.internal.ads.zzts;
import java.io.InputStream;
import java.util.Map;

@TargetApi(21)
public class zzaa extends zzx {
    public final WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }

    public final zzbdu zza(zzbdv zzbdv, zzts zzts, boolean z) {
        return new zzbfb(zzbdv, zzts, z);
    }

    public final CookieManager zzbh(Context context) {
        if (zzyl()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzd.zzc("Failed to obtain CookieManager.", th);
            zzp.zzku().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public final int zzym() {
        return 16974374;
    }
}
