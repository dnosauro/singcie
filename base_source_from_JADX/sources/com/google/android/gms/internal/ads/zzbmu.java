package com.google.android.gms.internal.ads;

public final class zzbmu implements zzepf<zzbxy<zzbtj>> {
    private final zzeps<zzbnr> zzfse;
    private final zzbmh zzftq;

    public zzbmu(zzbmh zzbmh, zzeps<zzbnr> zzeps) {
        this.zzftq = zzbmh;
        this.zzfse = zzeps;
    }

    public static zzbxy<zzbtj> zza(zzbmh zzbmh, zzbnr zzbnr) {
        return (zzbxy) zzepl.zza(new zzbxy(zzbnr, zzazj.zzegt), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzftq, this.zzfse.get());
    }
}
