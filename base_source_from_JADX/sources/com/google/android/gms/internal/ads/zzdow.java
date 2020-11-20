package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzf;

public final class zzdow implements zzepf<zzf> {
    private final zzdot zzhkd;
    private final zzeps<zzdor> zzhkf;

    private zzdow(zzdot zzdot, zzeps<zzdor> zzeps) {
        this.zzhkd = zzdot;
        this.zzhkf = zzeps;
    }

    public static zzf zza(zzdot zzdot, zzdor zzdor) {
        return (zzf) zzepl.zza(zzdor.zzebt, "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzdow zza(zzdot zzdot, zzeps<zzdor> zzeps) {
        return new zzdow(zzdot, zzeps);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzhkd, this.zzhkf.get());
    }
}
