package com.google.android.gms.internal.ads;

public final class zzdax implements zzdfi<zzdau> {
    private final zzazh zzdsm;
    private final zzdnn zzfvl;
    private final zzdzc zzggb;

    public zzdax(zzdzc zzdzc, zzdnn zzdnn, zzazh zzazh) {
        this.zzggb = zzdzc;
        this.zzfvl = zzdnn;
        this.zzdsm = zzazh;
    }

    public final zzdyz<zzdau> zzasm() {
        return this.zzggb.zze(new zzdaw(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdau zzasp() {
        return new zzdau(this.zzfvl.zzhis, this.zzdsm);
    }
}
