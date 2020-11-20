package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

final /* synthetic */ class zzt implements Callable {
    private final Context zzclq;
    private final WebSettings zzedk;

    zzt(Context context, WebSettings webSettings) {
        this.zzclq = context;
        this.zzedk = webSettings;
    }

    public final Object call() {
        Context context = this.zzclq;
        WebSettings webSettings = this.zzedk;
        if (context.getCacheDir() != null) {
            webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
            webSettings.setAppCacheMaxSize(0);
            webSettings.setAppCacheEnabled(true);
        }
        webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setAllowContentAccess(false);
        return true;
    }
}
