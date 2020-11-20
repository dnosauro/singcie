package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbff;
import com.google.android.gms.internal.ads.zzbfh;

@TargetApi(17)
public final class zzbet<WebViewT extends zzbex & zzbff & zzbfh> {
    private final zzbeu zzesx;
    private final WebViewT zzesy;

    private zzbet(WebViewT webviewt, zzbeu zzbeu) {
        this.zzesx = zzbeu;
        this.zzesy = webviewt;
    }

    public static zzbet<zzbdv> zzc(zzbdv zzbdv) {
        return new zzbet<>(zzbdv, new zzbes(zzbdv));
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zzd.zzee("Click string is empty, not proceeding.");
            return "";
        }
        zzef zzacv = ((zzbff) this.zzesy).zzacv();
        if (zzacv == null) {
            zzd.zzee("Signal utils is empty, ignoring.");
            return "";
        }
        zzdv zzca = zzacv.zzca();
        if (zzca == null) {
            zzd.zzee("Signals object is empty, ignoring.");
            return "";
        } else if (this.zzesy.getContext() != null) {
            return zzca.zza(this.zzesy.getContext(), str, ((zzbfh) this.zzesy).getView(), this.zzesy.zzaaj());
        } else {
            zzd.zzee("Context is null, ignoring.");
            return "";
        }
    }

    @JavascriptInterface
    public final void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzd.zzfa("URL is empty, ignoring message");
        } else {
            zzm.zzedd.post(new zzbev(this, str));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzfq(String str) {
        this.zzesx.zzh(Uri.parse(str));
    }
}
