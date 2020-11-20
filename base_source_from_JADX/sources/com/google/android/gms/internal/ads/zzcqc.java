package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;

public final class zzcqc implements zzdru {
    private final zzcpx zzgpm;

    zzcqc(zzcpx zzcpx) {
        this.zzgpm = zzcpx;
    }

    public final void zza(zzdrl zzdrl, String str) {
    }

    public final void zza(zzdrl zzdrl, String str, Throwable th) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue() && zzdrl.RENDERER == zzdrl && this.zzgpm.zzare() != 0) {
            this.zzgpm.zzer(zzp.zzkx().elapsedRealtime() - this.zzgpm.zzare());
        }
    }

    public final void zzb(zzdrl zzdrl, String str) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue() && zzdrl.RENDERER == zzdrl) {
            this.zzgpm.zzfe(zzp.zzkx().elapsedRealtime());
        }
    }

    public final void zzc(zzdrl zzdrl, String str) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue() && zzdrl.RENDERER == zzdrl && this.zzgpm.zzare() != 0) {
            this.zzgpm.zzer(zzp.zzkx().elapsedRealtime() - this.zzgpm.zzare());
        }
    }
}
