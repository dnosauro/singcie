package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbre;
import java.util.concurrent.Executor;

public final class zzdju<R extends zzbre<AdT>, AdT extends zzboc> implements zzdkl<R, zzdjy<AdT>> {
    private final Executor executor;
    private final zzdpd zzhez;
    private zzdyo<Void> zzhfa = new zzdjz(this);

    public zzdju(zzdpd zzdpd, Executor executor2) {
        this.zzhez = zzdpd;
        this.executor = executor2;
    }

    public final zzdyz<zzdjy<AdT>> zza(zzdkm zzdkm, zzdkn<R> zzdkn) {
        return zzdyi.zzg(new zzdkf(this.zzhez, zzdkm.zzhfk, zzdkn, this.executor).zzaud()).zzb(new zzdjx(this, zzdkm, zzdkn), this.executor).zza(Exception.class, new zzdjw(this), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzdkm zzdkm, zzdkn zzdkn, zzdkj zzdkj) {
        zzdpq zzdpq = zzdkj.zzhex;
        zzatl zzatl = zzdkj.zzgnh;
        zzdpn<?> zza = zzdpq != null ? this.zzhez.zza(zzdpq) : null;
        if (zzdpq == null) {
            return zzdyr.zzag(null);
        }
        if (!(zza == null || zzatl == null)) {
            zzdyr.zza(((zzbre) zzdkn.zzc(zzdkm.zzhfk).zzafp()).zzagh().zzc(zzatl), this.zzhfa, this.executor);
        }
        return zzdyr.zzag(new zzdjy(zzdpq, zzatl, zza));
    }

    public final /* bridge */ /* synthetic */ Object zzaty() {
        return null;
    }
}
