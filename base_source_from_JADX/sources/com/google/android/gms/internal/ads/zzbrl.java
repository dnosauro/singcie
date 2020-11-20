package com.google.android.gms.internal.ads;

public final class zzbrl implements zzepf<String> {
    private final zzeps<zzbpo> zzfcd;
    private final zzbrg zzfxl;

    private zzbrl(zzbrg zzbrg, zzeps<zzbpo> zzeps) {
        this.zzfxl = zzbrg;
        this.zzfcd = zzeps;
    }

    public static String zza(zzbrg zzbrg, zzbpo zzbpo) {
        return (String) zzepl.zza(zzbpo.zzws(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzbrl zzb(zzbrg zzbrg, zzeps<zzbpo> zzeps) {
        return new zzbrl(zzbrg, zzeps);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfxl, this.zzfcd.get());
    }
}
