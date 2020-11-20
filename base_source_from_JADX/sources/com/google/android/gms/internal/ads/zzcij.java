package com.google.android.gms.internal.ads;

public final class zzcij implements zzepf<zzbxy<zzbsp>> {
    private final zzeps<zzcii> zzfse;
    private final zzcik zzgiv;

    private zzcij(zzcik zzcik, zzeps<zzcii> zzeps) {
        this.zzgiv = zzcik;
        this.zzfse = zzeps;
    }

    public static zzcij zza(zzcik zzcik, zzeps<zzcii> zzeps) {
        return new zzcij(zzcik, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfse.get(), zzazj.zzegt), "Cannot return null from a non-@Nullable @Provides method");
    }
}
