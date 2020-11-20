package com.google.android.gms.internal.ads;

final class zzdim implements zzdyo<AppOpenAd> {
    private final /* synthetic */ zzcyn zzgxc;
    private final /* synthetic */ zzdio zzhdp;
    final /* synthetic */ zzdil zzhdq;

    zzdim(zzdil zzdil, zzcyn zzcyn, zzdio zzdio) {
        this.zzhdq = zzdil;
        this.zzgxc = zzcyn;
        this.zzhdp = zzdio;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzboc zzboc = (zzboc) obj;
        synchronized (this.zzhdq) {
            zzdyz unused = this.zzhdq.zzgvx = null;
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyr)).booleanValue()) {
                zzboc.zzakb().zza(this.zzhdq.zzhdn);
            }
            this.zzgxc.onSuccess(zzboc);
        }
    }

    public final void zzb(Throwable th) {
        zzblm zzblm = (zzblm) this.zzhdq.zzhdo.zzaty();
        zzve zza = zzblm == null ? zzdoi.zza(th, (zzcrg) null) : zzblm.zzagh().zze(th);
        synchronized (this.zzhdq) {
            zzdyz unused = this.zzhdq.zzgvx = null;
            if (zzblm != null) {
                zzblm.zzagi().zzk(zza);
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyr)).booleanValue()) {
                    this.zzhdq.zzfqx.execute(new zzdip(this, zza));
                }
            } else {
                this.zzhdq.zzhdn.zzk(zza);
                ((zzblm) this.zzhdq.zzb((zzdkk) this.zzhdp).zzafp()).zzagh().zzakk().zzalg();
            }
            zzdob.zza(zza.errorCode, th, "AppOpenAdLoader.onFailure");
            this.zzgxc.zzarx();
        }
    }
}
