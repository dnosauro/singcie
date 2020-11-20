package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;

public final class zzbzj implements zzepf<zzbxy<zzp>> {
    private final zzeps<zzcah> zzfse;
    private final zzbzc zzfzx;

    private zzbzj(zzbzc zzbzc, zzeps<zzcah> zzeps) {
        this.zzfzx = zzbzc;
        this.zzfse = zzeps;
    }

    public static zzbzj zzc(zzbzc zzbzc, zzeps<zzcah> zzeps) {
        return new zzbzj(zzbzc, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfse.get(), zzazj.zzegt), "Cannot return null from a non-@Nullable @Provides method");
    }
}
