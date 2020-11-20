package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbre;
import java.util.concurrent.Executor;

public final class zzdjk<R extends zzbre<AdT>, AdT extends zzboc> implements zzdkl<R, zzdpn<AdT>> {
    private final Executor executor = zzdzb.zzazo();
    private R zzheh;

    public final zzdyz<zzdpn<AdT>> zza(zzdkm zzdkm, zzdkn<R> zzdkn) {
        zzbrd<R> zzc = zzdkn.zzc(zzdkm.zzhfk);
        zzc.zza(new zzdkt(true));
        this.zzheh = (zzbre) zzc.zzafp();
        zzboz zzagh = this.zzheh.zzagh();
        zzdpn zzdpn = new zzdpn();
        return zzdyi.zzg(zzdkm.zzhfj != null ? zzagh.zza(zzdkm.zzhfj) : zzagh.zzaki()).zzb(new zzdjn(this, zzdpn, zzagh), this.executor).zza(new zzdjm(zzdpn), this.executor);
    }

    public final /* synthetic */ Object zzaty() {
        return this.zzheh;
    }
}
