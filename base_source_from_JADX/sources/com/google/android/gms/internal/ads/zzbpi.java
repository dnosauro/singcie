package com.google.android.gms.internal.ads;

public final class zzbpi implements zzepf<zzbxy<zzva>> {
    private final zzbpf zzfvz;
    private final zzeps<zzbpo> zzfwa;

    private zzbpi(zzbpf zzbpf, zzeps<zzbpo> zzeps) {
        this.zzfvz = zzbpf;
        this.zzfwa = zzeps;
    }

    public static zzbpi zzb(zzbpf zzbpf, zzeps<zzbpo> zzeps) {
        return new zzbpi(zzbpf, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfwa.get(), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }
}
