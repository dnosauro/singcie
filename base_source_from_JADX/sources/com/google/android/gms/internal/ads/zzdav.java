package com.google.android.gms.internal.ads;

public final class zzdav implements zzepf<zzdat> {
    private final zzeps<zzciq> zzevd;
    private final zzeps<zzdzc> zzgyf;
    private final zzeps<String> zzgyu;

    private zzdav(zzeps<String> zzeps, zzeps<zzdzc> zzeps2, zzeps<zzciq> zzeps3) {
        this.zzgyu = zzeps;
        this.zzgyf = zzeps2;
        this.zzevd = zzeps3;
    }

    public static zzdav zzr(zzeps<String> zzeps, zzeps<zzdzc> zzeps2, zzeps<zzciq> zzeps3) {
        return new zzdav(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdat(this.zzgyu.get(), this.zzgyf.get(), this.zzevd.get());
    }
}
