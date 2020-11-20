package com.google.android.gms.internal.ads;

public final class zzbpj implements zzepf<zzbxy<zzbtj>> {
    private final zzbpf zzfvz;
    private final zzeps<zzbpo> zzfwa;

    private zzbpj(zzbpf zzbpf, zzeps<zzbpo> zzeps) {
        this.zzfvz = zzbpf;
        this.zzfwa = zzeps;
    }

    public static zzbpj zzc(zzbpf zzbpf, zzeps<zzbpo> zzeps) {
        return new zzbpj(zzbpf, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfwa.get(), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }
}
