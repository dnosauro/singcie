package com.google.android.gms.internal.ads;

final class zzdkx implements zzdyo<zzbyx> {
    private final /* synthetic */ zzcyn zzgxc;
    private final /* synthetic */ zzbzx zzhfp;
    final /* synthetic */ zzdkv zzhfq;

    zzdkx(zzdkv zzdkv, zzcyn zzcyn, zzbzx zzbzx) {
        this.zzhfq = zzdkv;
        this.zzgxc = zzcyn;
        this.zzhfp = zzbzx;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbyx zzbyx = (zzbyx) obj;
        synchronized (this.zzhfq) {
            zzdyz unused = this.zzhfq.zzhfn = null;
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcys)).booleanValue()) {
                zzbyx.zzakb().zza(this.zzhfq.zzgvs).zza(this.zzhfq.zzhfm);
            }
            this.zzgxc.onSuccess(zzbyx);
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcys)).booleanValue()) {
                this.zzhfq.zzfqx.execute(new zzdkw(this));
                this.zzhfq.zzfqx.execute(new zzdkz(this));
            }
        }
    }

    public final void zzb(Throwable th) {
        zzve zze = this.zzhfp.zzagh().zze(th);
        synchronized (this.zzhfq) {
            zzdyz unused = this.zzhfq.zzhfn = null;
            this.zzhfp.zzagi().zzk(zze);
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcys)).booleanValue()) {
                this.zzhfq.zzfqx.execute(new zzdky(this, zze));
                this.zzhfq.zzfqx.execute(new zzdlb(this, zze));
            }
            zzdob.zza(zze.errorCode, th, "InterstitialAdLoader.onFailure");
            this.zzgxc.zzarx();
        }
    }
}
