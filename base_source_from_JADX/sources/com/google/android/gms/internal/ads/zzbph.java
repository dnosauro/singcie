package com.google.android.gms.internal.ads;

public final class zzbph implements zzepf<zzbxy<zzbru>> {
    private final zzbpf zzfvz;
    private final zzeps<zzbpo> zzfwa;

    private zzbph(zzbpf zzbpf, zzeps<zzbpo> zzeps) {
        this.zzfvz = zzbpf;
        this.zzfwa = zzeps;
    }

    public static zzbph zza(zzbpf zzbpf, zzeps<zzbpo> zzeps) {
        return new zzbph(zzbpf, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfwa.get(), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }
}
