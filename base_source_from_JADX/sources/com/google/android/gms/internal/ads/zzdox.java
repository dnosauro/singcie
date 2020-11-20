package com.google.android.gms.internal.ads;

public final class zzdox implements zzepf<zzayq> {
    private final zzdot zzhkd;
    private final zzeps<zzdor> zzhkf;

    private zzdox(zzdot zzdot, zzeps<zzdor> zzeps) {
        this.zzhkd = zzdot;
        this.zzhkf = zzeps;
    }

    public static zzdox zzb(zzdot zzdot, zzeps<zzdor> zzeps) {
        return new zzdox(zzdot, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzayq) zzepl.zza(this.zzhkf.get().zzeaj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
