package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;

public final class zzbqf implements zzepf<zzbxy<zzp>> {
    private final zzeps<zzbov> zzfse;
    private final zzbpx zzfwh;

    private zzbqf(zzbpx zzbpx, zzeps<zzbov> zzeps) {
        this.zzfwh = zzbpx;
        this.zzfse = zzeps;
    }

    public static zzbqf zza(zzbpx zzbpx, zzeps<zzbov> zzeps) {
        return new zzbqf(zzbpx, zzeps);
    }

    public final /* synthetic */ Object get() {
        return (zzbxy) zzepl.zza(new zzbxy(this.zzfse.get(), zzazj.zzegu), "Cannot return null from a non-@Nullable @Provides method");
    }
}
