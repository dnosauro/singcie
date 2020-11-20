package com.google.android.gms.internal.ads;

public final class zzbow implements zzepf<zzdnj> {
    private final zzbos zzfvg;

    private zzbow(zzbos zzbos) {
        this.zzfvg = zzbos;
    }

    public static zzbow zzf(zzbos zzbos) {
        return new zzbow(zzbos);
    }

    public static zzdnj zzg(zzbos zzbos) {
        return (zzdnj) zzepl.zza(zzbos.zzake(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzg(this.zzfvg);
    }
}
