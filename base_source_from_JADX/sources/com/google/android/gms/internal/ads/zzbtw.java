package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbtw extends zzbwk<zzbub> implements zzbsm, zzbto {
    private final zzdmu zzfps;
    private AtomicBoolean zzfya = new AtomicBoolean();

    public zzbtw(Set<zzbxy<zzbub>> set, zzdmu zzdmu) {
        super(set);
        this.zzfps = zzdmu;
    }

    private final void zzala() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyd)).booleanValue() && this.zzfya.compareAndSet(false, true) && this.zzfps.zzhhm != null && this.zzfps.zzhhm.type == 3) {
            zza(new zzbtz(this));
        }
    }

    public final void onAdImpression() {
        if (this.zzfps.zzhgp == 2 || this.zzfps.zzhgp == 5 || this.zzfps.zzhgp == 4) {
            zzala();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbub zzbub) {
        zzbub.zzb(this.zzfps.zzhhm);
    }

    public final void zzakz() {
        if (this.zzfps.zzhgp == 1) {
            zzala();
        }
    }
}
