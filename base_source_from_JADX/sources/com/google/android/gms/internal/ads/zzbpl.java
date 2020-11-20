package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzbpl implements zzepf<zzayf> {
    private final zzeps<zzayq> zzfca;
    private final zzeps<Clock> zzfrf;
    private final zzeps<zzdnn> zzfts;

    private zzbpl(zzeps<Clock> zzeps, zzeps<zzayq> zzeps2, zzeps<zzdnn> zzeps3) {
        this.zzfrf = zzeps;
        this.zzfca = zzeps2;
        this.zzfts = zzeps3;
    }

    public static zzbpl zzg(zzeps<Clock> zzeps, zzeps<zzayq> zzeps2, zzeps<zzdnn> zzeps3) {
        return new zzbpl(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return (zzayf) zzepl.zza(this.zzfca.get().zza(this.zzfrf.get(), this.zzfts.get().zzhip), "Cannot return null from a non-@Nullable @Provides method");
    }
}
