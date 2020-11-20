package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdoy implements zzepf<Context> {
    private final zzdot zzhkd;
    private final zzeps<zzdor> zzhkf;

    private zzdoy(zzdot zzdot, zzeps<zzdor> zzeps) {
        this.zzhkd = zzdot;
        this.zzhkf = zzeps;
    }

    public static Context zzb(zzdot zzdot, zzdor zzdor) {
        return (Context) zzepl.zza(zzdor.zzaaa, "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzdoy zzc(zzdot zzdot, zzeps<zzdor> zzeps) {
        return new zzdoy(zzdot, zzeps);
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzhkd, this.zzhkf.get());
    }
}
