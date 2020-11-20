package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@TargetApi(11)
public class zzbey extends zzbdu {
    public zzbey(zzbdv zzbdv, zzts zzts, boolean z) {
        super(zzbdv, zzts, z);
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zza(WebView webView, String str, Map<String, String> map) {
        if (!(webView instanceof zzbdv)) {
            zzd.zzfa("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbdv zzbdv = (zzbdv) webView;
        if (this.zzepr != null) {
            this.zzepr.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzd(str, map);
        }
        if (zzbdv.zzacs() != null) {
            zzbdv.zzacs().zzvf();
        }
        String str2 = (String) zzwq.zzqe().zzd(zzbdv.zzacq().zzady() ? zzabf.zzcmz : zzbdv.zzacx() ? zzabf.zzcmy : zzabf.zzcmx);
        zzp.zzkq();
        return zzm.zzd(zzbdv.getContext(), zzbdv.zzaao().zzbrf, str2);
    }
}
