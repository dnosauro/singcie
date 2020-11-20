package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.zzd;

final class zzm extends WebViewClient {
    private final /* synthetic */ zzj zzbpl;

    zzm(zzj zzj) {
        this.zzbpl = zzj;
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.zzbpl.zzbpi != null) {
            try {
                this.zzbpl.zzbpi.onAdFailedToLoad(0);
            } catch (RemoteException e) {
                zzd.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.zzbpl.zzkl())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            if (this.zzbpl.zzbpi != null) {
                try {
                    this.zzbpl.zzbpi.onAdFailedToLoad(3);
                } catch (RemoteException e) {
                    zzd.zze("#007 Could not call remote method.", e);
                }
            }
            this.zzbpl.zzbq(0);
            return true;
        } else if (str.startsWith("gmsg://scriptLoadFailed")) {
            if (this.zzbpl.zzbpi != null) {
                try {
                    this.zzbpl.zzbpi.onAdFailedToLoad(0);
                } catch (RemoteException e2) {
                    zzd.zze("#007 Could not call remote method.", e2);
                }
            }
            this.zzbpl.zzbq(0);
            return true;
        } else if (str.startsWith("gmsg://adResized")) {
            if (this.zzbpl.zzbpi != null) {
                try {
                    this.zzbpl.zzbpi.onAdLoaded();
                } catch (RemoteException e3) {
                    zzd.zze("#007 Could not call remote method.", e3);
                }
            }
            this.zzbpl.zzbq(this.zzbpl.zzbm(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            if (this.zzbpl.zzbpi != null) {
                try {
                    this.zzbpl.zzbpi.onAdLeftApplication();
                } catch (RemoteException e4) {
                    zzd.zze("#007 Could not call remote method.", e4);
                }
            }
            this.zzbpl.zzbo(this.zzbpl.zzbn(str));
            return true;
        }
    }
}
