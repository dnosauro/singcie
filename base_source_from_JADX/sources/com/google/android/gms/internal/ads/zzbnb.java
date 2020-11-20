package com.google.android.gms.internal.ads;

public final class zzbnb implements zzepf<zzcqz<zzbme>> {
    private final zzeps<zzcvy<zzbme, zzdoe, zzcst>> zzfgd;
    private final zzeps<Boolean> zzflo;
    private final zzeps<zzcug> zzflq;

    public zzbnb(zzeps<Boolean> zzeps, zzeps<zzcug> zzeps2, zzeps<zzcvy<zzbme, zzdoe, zzcst>> zzeps3) {
        this.zzflo = zzeps;
        this.zzflq = zzeps2;
        this.zzfgd = zzeps3;
    }

    public final /* synthetic */ Object get() {
        boolean booleanValue = this.zzflo.get().booleanValue();
        Object obj = (zzcug) this.zzflq.get();
        Object obj2 = (zzcvy) this.zzfgd.get();
        if (!booleanValue) {
            obj = obj2;
        }
        return (zzcqz) zzepl.zza(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
