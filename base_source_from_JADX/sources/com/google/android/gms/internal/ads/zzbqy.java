package com.google.android.gms.internal.ads;

public final class zzbqy implements zzepf<zzbua> {
    private final zzeps<zzbua> zzfwv;

    private zzbqy(zzeps<zzbua> zzeps) {
        this.zzfwv = zzeps;
    }

    public static zzbqy zzf(zzeps<zzbua> zzeps) {
        return new zzbqy(zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbua) zzepl.zza(this.zzfwv.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
