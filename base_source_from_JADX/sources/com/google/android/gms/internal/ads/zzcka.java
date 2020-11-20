package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzcka implements zzdru {
    private zzts zzgjl;
    private Map<zzdrl, zzckc> zzgju;

    zzcka(zzts zzts, Map<zzdrl, zzckc> map) {
        this.zzgju = map;
        this.zzgjl = zzts;
    }

    public final void zza(zzdrl zzdrl, String str) {
    }

    public final void zza(zzdrl zzdrl, String str, Throwable th) {
        if (this.zzgju.containsKey(zzdrl)) {
            this.zzgjl.zza(this.zzgju.get(zzdrl).zzgjy);
        }
    }

    public final void zzb(zzdrl zzdrl, String str) {
        if (this.zzgju.containsKey(zzdrl)) {
            this.zzgjl.zza(this.zzgju.get(zzdrl).zzgjw);
        }
    }

    public final void zzc(zzdrl zzdrl, String str) {
        if (this.zzgju.containsKey(zzdrl)) {
            this.zzgjl.zza(this.zzgju.get(zzdrl).zzgjx);
        }
    }
}
