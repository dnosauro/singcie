package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

final class zzri implements Runnable {
    private final /* synthetic */ zzrj zzbsp;

    zzri(zzrj zzrj) {
        this.zzbsp = zzrj;
    }

    public final void run() {
        synchronized (this.zzbsp.lock) {
            if (!this.zzbsp.foreground || !this.zzbsp.zzbsq) {
                zzd.zzeb("App is still foreground");
            } else {
                boolean unused = this.zzbsp.foreground = false;
                zzd.zzeb("App went background");
                for (zzrl zzp : this.zzbsp.zzbsr) {
                    try {
                        zzp.zzp(false);
                    } catch (Exception e) {
                        zzaza.zzc("", e);
                    }
                }
            }
        }
    }
}
