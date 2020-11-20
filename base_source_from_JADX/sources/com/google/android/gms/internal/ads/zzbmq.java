package com.google.android.gms.internal.ads;

public final class zzbmq implements zzepf<zzbme> {
    private final zzeps<zzbmg> zzfmp;
    private final zzbmh zzftq;

    public zzbmq(zzbmh zzbmh, zzeps<zzbmg> zzeps) {
        this.zzftq = zzbmh;
        this.zzfmp = zzeps;
    }

    public static zzbme zza(zzbmh zzbmh, Object obj) {
        return (zzbme) zzepl.zza((zzbmg) obj, "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzftq, this.zzfmp.get());
    }
}
