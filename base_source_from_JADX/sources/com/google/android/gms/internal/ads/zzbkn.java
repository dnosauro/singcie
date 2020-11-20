package com.google.android.gms.internal.ads;

public final class zzbkn implements zzepf<zzamq> {
    private final zzeps<zzaml> zzfro;

    private zzbkn(zzeps<zzaml> zzeps) {
        this.zzfro = zzeps;
    }

    public static zzbkn zzb(zzeps<zzaml> zzeps) {
        return new zzbkn(zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzamq) zzepl.zza(this.zzfro.get().zzua(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
