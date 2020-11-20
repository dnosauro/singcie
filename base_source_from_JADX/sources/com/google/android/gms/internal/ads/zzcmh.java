package com.google.android.gms.internal.ads;

public final class zzcmh implements zzepf<zzcmd> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<zzdzc> zzgmf;
    private final zzeps<zzcns> zzgmg;
    private final zzeps<zzcou> zzgmh;

    private zzcmh(zzeps<zzdzc> zzeps, zzeps<zzdzc> zzeps2, zzeps<zzcns> zzeps3, zzeps<zzcou> zzeps4) {
        this.zzgmf = zzeps;
        this.zzevg = zzeps2;
        this.zzgmg = zzeps3;
        this.zzgmh = zzeps4;
    }

    public static zzcmh zzd(zzeps<zzdzc> zzeps, zzeps<zzdzc> zzeps2, zzeps<zzcns> zzeps3, zzeps<zzcou> zzeps4) {
        return new zzcmh(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzcmd(this.zzgmf.get(), this.zzevg.get(), this.zzgmg.get(), zzepg.zzat(this.zzgmh));
    }
}
