package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.zzd;

public final class zzbyw implements zzsu {
    private zzdva zzfzp;

    public final View getView() {
        return this.zzfzp;
    }

    public final WebView getWebView() {
        if (this.zzfzp == null) {
            return null;
        }
        return zzdva.getWebView();
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.zzfzp != null) {
            zzdva.onPageStarted(webView, str, bitmap);
        }
    }

    public final void zza(Activity activity, WebView webView) {
        try {
            this.zzfzp = new zzdva(activity, webView);
        } catch (RuntimeException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46);
            sb.append(" Failed to initialize the internal ArWebView: ");
            sb.append(valueOf);
            zzd.zzey(sb.toString());
        }
    }

    public final void zzc(String str, String str2) {
        if (this.zzfzp == null) {
            zzd.zzey("ArWebView is not initialized.");
        } else {
            zzdva.getWebView().loadDataWithBaseURL(str, str2, "text/html", "UTF-8", (String) null);
        }
    }
}
