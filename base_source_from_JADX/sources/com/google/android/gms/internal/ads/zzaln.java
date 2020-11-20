package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;

final class zzaln implements zzazs {
    private final /* synthetic */ zzalb zzdjc;
    private final /* synthetic */ zzals zzdjg;

    zzaln(zzalb zzalb, zzals zzals) {
        this.zzdjc = zzalb;
        this.zzdjg = zzals;
    }

    public final void run() {
        synchronized (this.zzdjc.lock) {
            int unused = this.zzdjc.status = 1;
            zzd.zzee("Failed loading new engine. Marking new engine destroyable.");
            this.zzdjg.zztx();
        }
    }
}
