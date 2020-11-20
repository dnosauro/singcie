package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbre;
import java.util.concurrent.Executor;

final class zzdkf<R extends zzbre<? extends zzboc>> {
    private final Executor executor;
    private final zzdkn<R> zzhev;
    private final zzdpd zzhez;
    private final zzdkk zzhfg;
    /* access modifiers changed from: private */
    public zzdkj zzhfh;

    public zzdkf(zzdpd zzdpd, zzdkk zzdkk, zzdkn<R> zzdkn, Executor executor2) {
        this.zzhez = zzdpd;
        this.zzhfg = zzdkk;
        this.zzhev = zzdkn;
        this.executor = executor2;
    }

    /* access modifiers changed from: private */
    @Deprecated
    public final zzdpq zzaue() {
        zzdnn zzago = ((zzbre) this.zzhev.zzc(this.zzhfg).zzafp()).zzago();
        return this.zzhez.zza(zzago.zzhio, zzago.zzhip, zzago.zzhis);
    }

    public final zzdyz<zzdkj> zzaud() {
        zzdyz zzdyz;
        zzdkj zzdkj = this.zzhfh;
        if (zzdkj != null) {
            return zzdyr.zzag(zzdkj);
        }
        if (!zzadf.zzddc.get().booleanValue()) {
            this.zzhfh = new zzdkj((zzatl) null, zzaue(), (zzdkh) null);
            zzdyz = zzdyr.zzag(this.zzhfh);
        } else {
            zzdyz = zzdyi.zzg(((zzbre) this.zzhev.zzc(this.zzhfg).zza(new zzdjv(this.zzhez.zzavc().zzhlq)).zzafp()).zzagh().zza(this.zzhez.zzavc())).zza(new zzdkg(this), this.executor).zza(zzcoh.class, new zzdkh(this), this.executor);
        }
        return zzdyr.zzb(zzdyz, zzdke.zzdza, this.executor);
    }
}
