package com.google.android.gms.internal.ads;

public final class zzbro implements zzepf<zzbrp> {
    private final zzeps<zzcrg> zzfdm;
    private final zzeps<zzdmu> zzfuk;
    private final zzeps<String> zzfxm;

    private zzbro(zzeps<zzdmu> zzeps, zzeps<String> zzeps2, zzeps<zzcrg> zzeps3) {
        this.zzfuk = zzeps;
        this.zzfxm = zzeps2;
        this.zzfdm = zzeps3;
    }

    public static zzbro zzi(zzeps<zzdmu> zzeps, zzeps<String> zzeps2, zzeps<zzcrg> zzeps3) {
        return new zzbro(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzbrp(this.zzfuk.get(), this.zzfxm.get(), this.zzfdm.get());
    }
}
