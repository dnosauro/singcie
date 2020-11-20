package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

final class zzalk implements zzazu<zzako> {
    private final /* synthetic */ zzalb zzdjc;
    private final /* synthetic */ zzals zzdjg;

    zzalk(zzalb zzalb, zzals zzals) {
        this.zzdjc = zzalb;
        this.zzdjg = zzals;
    }

    public final /* synthetic */ void zzh(Object obj) {
        zzako zzako = (zzako) obj;
        synchronized (this.zzdjc.lock) {
            int unused = this.zzdjc.status = 0;
            if (!(this.zzdjc.zzdiw == null || this.zzdjg == this.zzdjc.zzdiw)) {
                zzd.zzee("New JS engine is loaded, marking previous one as destroyable.");
                this.zzdjc.zzdiw.zztx();
            }
            zzals unused2 = this.zzdjc.zzdiw = this.zzdjg;
        }
    }
}
