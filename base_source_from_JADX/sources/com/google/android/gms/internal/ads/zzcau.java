package com.google.android.gms.internal.ads;

public final class zzcau implements zzepf<zzccl> {
    private final zzcap zzgal;

    private zzcau(zzcap zzcap) {
        this.zzgal = zzcap;
    }

    public static zzcau zzd(zzcap zzcap) {
        return new zzcau(zzcap);
    }

    public static zzccl zze(zzcap zzcap) {
        return (zzccl) zzepl.zza(zzcap.zzamj(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zze(this.zzgal);
    }
}
