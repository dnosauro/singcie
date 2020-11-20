package com.google.android.gms.internal.ads;

final class zzdmf implements zzdyo<zzchc> {
    private final /* synthetic */ zzcyn zzgxc;
    private final /* synthetic */ zzdmg zzhge;
    final /* synthetic */ zzdma zzhgf;

    zzdmf(zzdma zzdma, zzcyn zzcyn, zzdmg zzdmg) {
        this.zzhgf = zzdma;
        this.zzgxc = zzcyn;
        this.zzhge = zzdmg;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzchc zzchc = (zzchc) obj;
        synchronized (this.zzhgf) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyq)).booleanValue()) {
                zzchc.zzakb().zza(this.zzhgf.zzhga);
            }
            this.zzgxc.onSuccess(zzchc);
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyq)).booleanValue()) {
                this.zzhgf.zzfqx.execute(new zzdme(this));
            }
            this.zzhgf.zzhga.onAdMetadataChanged();
        }
    }

    public final void zzb(Throwable th) {
        zzchf zzchf = (zzchf) this.zzhgf.zzhdo.zzaty();
        zzve zza = zzchf == null ? zzdoi.zza(th, (zzcrg) null) : zzchf.zzagh().zze(th);
        synchronized (this.zzhgf) {
            if (zzchf != null) {
                zzchf.zzagi().zzk(zza);
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyq)).booleanValue()) {
                    this.zzhgf.zzfqx.execute(new zzdmh(this, zza));
                }
            } else {
                this.zzhgf.zzhga.zzk(zza);
                this.zzhgf.zze(this.zzhge).zzaho().zzagh().zzakk().zzalg();
            }
            zzdob.zza(zza.errorCode, th, "RewardedAdLoader.onFailure");
            this.zzgxc.zzarx();
        }
    }
}
