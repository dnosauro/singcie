package com.google.android.gms.internal.ads;

public final class zzbib {
    private zzbim zzevl;
    private zzbgl zzevm;
    private zzdrv zzfms;
    private zzbiy zzfmt;
    private zzdoj zzfmu;

    private zzbib() {
    }

    public final zzbib zza(zzbim zzbim) {
        this.zzevl = (zzbim) zzepl.checkNotNull(zzbim);
        return this;
    }

    public final zzbgm zzahg() {
        zzepl.zza(this.zzevm, zzbgl.class);
        zzepl.zza(this.zzevl, zzbim.class);
        if (this.zzfms == null) {
            this.zzfms = new zzdrv();
        }
        if (this.zzfmt == null) {
            this.zzfmt = new zzbiy();
        }
        if (this.zzfmu == null) {
            this.zzfmu = new zzdoj();
        }
        return new zzbhg(this.zzevm, this.zzevl, this.zzfms, this.zzfmt, this.zzfmu);
    }

    public final zzbib zzc(zzbgl zzbgl) {
        this.zzevm = (zzbgl) zzepl.checkNotNull(zzbgl);
        return this;
    }
}
