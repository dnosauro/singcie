package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbre;
import com.google.android.gms.internal.ads.zzue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class zzdjp<R extends zzbre<AdT>, AdT extends zzboc> implements zzdkl<R, AdT> {
    private final Executor executor;
    private final zzdkl<R, AdT> zzhdo;
    private final zzdkl<R, zzdjy<AdT>> zzheq;
    private final zzdpv<AdT> zzher;
    @GuardedBy("this")
    private R zzhes;

    public zzdjp(zzdkl<R, AdT> zzdkl, zzdkl<R, zzdjy<AdT>> zzdkl2, zzdpv<AdT> zzdpv, Executor executor2) {
        this.zzhdo = zzdkl;
        this.zzheq = zzdkl2;
        this.zzher = zzdpv;
        this.executor = executor2;
    }

    private final zzdyz<AdT> zza(zzdpn<AdT> zzdpn, zzdkm zzdkm, zzdkn<R> zzdkn) {
        zzbrd<R> zzc = zzdkn.zzc(zzdkm.zzhfk);
        if (zzdpn.zzhmc != null) {
            zzbre zzbre = (zzbre) zzc.zzafp();
            if (zzbre.zzagp() != null) {
                zzdpn.zzhmc.zzaka().zzb(zzbre.zzagp());
            }
            return zzdyr.zzag(zzdpn.zzhmc);
        }
        zzc.zza(zzdpn.zzext);
        zzdyz<AdT> zza = this.zzhdo.zza(zzdkm, new zzdjr(zzc));
        this.zzhes = (zzbre) this.zzhdo.zzaty();
        return zza;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzatz */
    public final synchronized R zzaty() {
        return this.zzhes;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzdkm zzdkm, zzdjs zzdjs, zzdkn zzdkn, zzdjy zzdjy) {
        if (zzdjy != null) {
            zzdjs zzdjs2 = new zzdjs(zzdjs.zzhev, zzdjs.zzhew, zzdjs.zzdsr, zzdjs.zzbum, zzdjs.executor, zzdjs.zzgyt, zzdjy.zzhex);
            if (zzdjy.zzhfe != null) {
                this.zzhes = null;
                this.zzher.zzb((zzdqb) zzdjs2);
                return zza(zzdjy.zzhfe, zzdkm, zzdkn);
            }
            zzdyz<zzdpz<AdT>> zzc = this.zzher.zzc((zzdqb) zzdjs2);
            if (zzc != null) {
                this.zzhes = (zzbre) zzdkn.zzc(zzdkm.zzhfk).zzafp();
                return zzdyr.zzb(zzc, new zzdjq(this, zzdkn), this.executor);
            }
            this.zzher.zzb((zzdqb) zzdjs2);
            zzdkm = new zzdkm(zzdkm.zzhfk, zzdjy.zzgnh);
        }
        zzdyz<AdT> zza = this.zzhdo.zza(zzdkm, zzdkn);
        this.zzhes = (zzbre) this.zzhdo.zzaty();
        return zza;
    }

    public final synchronized zzdyz<AdT> zza(zzdkm zzdkm, zzdkn<R> zzdkn) {
        zzdnn zzago;
        zzdkn<R> zzdkn2;
        zzdkm zzdkm2;
        zzago = ((zzbre) zzdkn.zzc(zzdkm.zzhfk).zzafp()).zzago();
        zzdkn2 = zzdkn;
        zzdkm2 = zzdkm;
        return zzdyi.zzg(this.zzheq.zza(zzdkm, zzdkn)).zzb(new zzdjo(this, zzdkm, new zzdjs(zzdkn2, zzdkm2, zzago.zzhio, zzago.zzhip, this.executor, zzago.zzhis, (zzdpq) null), zzdkn), this.executor);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzdkn zzdkn, zzdpz zzdpz) {
        if (zzdpz == null || zzdpz.zzhfe == null || zzdpz.zzhmr == null) {
            throw new zzcme(zzdok.INTERNAL_ERROR, "Empty prefetch");
        }
        zzdpz.zzhfe.zzhmb.zzakk().zze((zzue.zzb) ((zzekh) zzue.zzb.zznk().zza(zzue.zzb.zza.zznm().zza(zzue.zzb.C3721zzb.IN_MEMORY).zza(zzue.zzb.zzd.zzno())).zzbhv()));
        return zza(zzdpz.zzhfe, ((zzdjs) zzdpz.zzhmr).zzhew, zzdkn);
    }
}
