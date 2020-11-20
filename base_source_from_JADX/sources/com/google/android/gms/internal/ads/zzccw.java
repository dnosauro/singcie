package com.google.android.gms.internal.ads;

public final class zzccw implements zzepf<zzcce> {
    private final zzccq zzgds;

    private zzccw(zzccq zzccq) {
        this.zzgds = zzccq;
    }

    public static zzccw zzb(zzccq zzccq) {
        return new zzccw(zzccq);
    }

    public static zzcce zzc(zzccq zzccq) {
        return (zzcce) zzepl.zza(zzccq.zzaoa(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzc(this.zzgds);
    }
}
