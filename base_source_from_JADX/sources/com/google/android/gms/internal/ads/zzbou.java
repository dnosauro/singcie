package com.google.android.gms.internal.ads;

public final class zzbou implements zzepf<String> {
    private final zzbos zzfvg;

    private zzbou(zzbos zzbos) {
        this.zzfvg = zzbos;
    }

    public static zzbou zzd(zzbos zzbos) {
        return new zzbou(zzbos);
    }

    public static String zze(zzbos zzbos) {
        return (String) zzepl.zza(zzbos.zzakh(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zze(this.zzfvg);
    }
}
