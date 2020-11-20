package com.google.android.gms.internal.ads;

import android.webkit.CookieManager;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcmj implements Callable {
    private final CookieManager zzgmi;

    zzcmj(CookieManager cookieManager) {
        this.zzgmi = cookieManager;
    }

    public final Object call() {
        CookieManager cookieManager = this.zzgmi;
        if (cookieManager == null) {
            return "";
        }
        return cookieManager.getCookie((String) zzwq.zzqe().zzd(zzabf.zzcoi));
    }
}
