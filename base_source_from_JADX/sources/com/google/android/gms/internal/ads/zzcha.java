package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

public final class zzcha implements zzaij {
    private final zzbsu zzfvh;
    private final zzava zzgic;
    private final String zzgid;
    private final String zzgie;

    public zzcha(zzbsu zzbsu, zzdmu zzdmu) {
        this.zzfvh = zzbsu;
        this.zzgic = zzdmu.zzdvb;
        this.zzgid = zzdmu.zzdli;
        this.zzgie = zzdmu.zzdlj;
    }

    @ParametersAreNonnullByDefault
    public final void zza(zzava zzava) {
        int i;
        String str = "";
        zzava zzava2 = this.zzgic;
        if (zzava2 != null) {
            zzava = zzava2;
        }
        if (zzava != null) {
            str = zzava.type;
            i = zzava.zzdxu;
        } else {
            i = 1;
        }
        this.zzfvh.zzb(new zzaud(str, i), this.zzgid, this.zzgie);
    }

    public final void zztl() {
        this.zzfvh.onRewardedVideoStarted();
    }

    public final void zztm() {
        this.zzfvh.onRewardedVideoCompleted();
    }
}
