package com.google.android.gms.internal.ads;

final class zzcyu implements zzdyo<zzboc> {
    private final /* synthetic */ zzcyn zzgxc;
    private final /* synthetic */ zzcat zzgxd;
    final /* synthetic */ zzcyp zzgxe;

    zzcyu(zzcyp zzcyp, zzcyn zzcyn, zzcat zzcat) {
        this.zzgxe = zzcyp;
        this.zzgxc = zzcyn;
        this.zzgxd = zzcat;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzboc zzboc = (zzboc) obj;
        synchronized (this.zzgxe) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyt)).booleanValue()) {
                zzboc.zzakb().zza(this.zzgxe.zzgwx.zzasa());
            }
            this.zzgxc.onSuccess(zzboc);
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyt)).booleanValue()) {
                this.zzgxe.zzgss.zzaek().execute(new zzcyt(this));
            }
        }
    }

    public final void zzb(Throwable th) {
        zzve zze = this.zzgxd.zzagh().zze(th);
        this.zzgxd.zzagi().zzk(zze);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyt)).booleanValue()) {
            this.zzgxe.zzgss.zzaek().execute(new zzcyw(this, zze));
        }
        zzdob.zza(zze.errorCode, th, "NativeAdLoader.onFailure");
        this.zzgxc.zzarx();
    }
}
