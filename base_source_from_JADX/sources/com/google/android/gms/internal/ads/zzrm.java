package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

final class zzrm implements Runnable {
    private ValueCallback<String> zzbth = new zzrp(this);
    final /* synthetic */ zzre zzbti;
    final /* synthetic */ WebView zzbtj;
    final /* synthetic */ boolean zzbtk;
    final /* synthetic */ zzrk zzbtl;

    zzrm(zzrk zzrk, zzre zzre, WebView webView, boolean z) {
        this.zzbtl = zzrk;
        this.zzbti = zzre;
        this.zzbtj = webView;
        this.zzbtk = z;
    }

    public final void run() {
        if (this.zzbtj.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzbtj.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzbth);
            } catch (Throwable unused) {
                this.zzbth.onReceiveValue("");
            }
        }
    }
}
