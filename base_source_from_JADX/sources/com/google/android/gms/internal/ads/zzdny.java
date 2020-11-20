package com.google.android.gms.internal.ads;

public final class zzdny implements zzepf<zzdnv> {
    private final zzeps<zzdrz> zzewl;
    private final zzeps<zzdmu> zzfuk;
    private final zzeps<zzcqo> zzgia;
    private final zzeps<zzdmz> zzgib;

    private zzdny(zzeps<zzcqo> zzeps, zzeps<zzdrz> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzdmz> zzeps4) {
        this.zzgia = zzeps;
        this.zzewl = zzeps2;
        this.zzfuk = zzeps3;
        this.zzgib = zzeps4;
    }

    public static zzdny zzj(zzeps<zzcqo> zzeps, zzeps<zzdrz> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzdmz> zzeps4) {
        return new zzdny(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzdnv(this.zzgia.get(), this.zzewl.get(), this.zzfuk.get(), this.zzgib.get());
    }
}
