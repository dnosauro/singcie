package com.google.android.gms.internal.ads;

public final class zzbzk implements zzepf<zzbxy<zzbtj>> {
    private final zzeps<zzcah> zzfse;
    private final zzbzc zzfzx;

    private zzbzk(zzbzc zzbzc, zzeps<zzcah> zzeps) {
        this.zzfzx = zzbzc;
        this.zzfse = zzeps;
    }

    public static zzbzk zzd(zzbzc zzbzc, zzeps<zzcah> zzeps) {
        return new zzbzk(zzbzc, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfse.get(), zzazj.zzegt), "Cannot return null from a non-@Nullable @Provides method");
    }
}
