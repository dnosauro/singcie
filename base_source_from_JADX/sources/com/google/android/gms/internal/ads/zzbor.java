package com.google.android.gms.internal.ads;

public final class zzbor implements zzepf<zzdmu> {
    private final zzbos zzfvg;

    private zzbor(zzbos zzbos) {
        this.zzfvg = zzbos;
    }

    public static zzbor zza(zzbos zzbos) {
        return new zzbor(zzbos);
    }

    public static zzdmu zzb(zzbos zzbos) {
        return (zzdmu) zzepl.zza(zzbos.zzakf(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzb(this.zzfvg);
    }
}
