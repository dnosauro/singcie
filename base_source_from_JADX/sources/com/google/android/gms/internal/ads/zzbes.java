package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzd;

final /* synthetic */ class zzbes implements zzbeu {
    private final zzbdv zzesw;

    zzbes(zzbdv zzbdv) {
        this.zzesw = zzbdv;
    }

    public final void zzh(Uri uri) {
        zzbfg zzacs = this.zzesw.zzacs();
        if (zzacs == null) {
            zzd.zzey("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzacs.zzh(uri);
        }
    }
}
