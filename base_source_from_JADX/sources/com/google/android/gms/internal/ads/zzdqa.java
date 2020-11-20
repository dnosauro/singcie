package com.google.android.gms.internal.ads;

final class zzdqa implements zzdyo<zzdpn<AdT>> {
    private final /* synthetic */ zzdpv zzhms;

    zzdqa(zzdpv zzdpv) {
        this.zzhms = zzdpv;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdpn zzdpn = (zzdpn) obj;
        synchronized (this.zzhms) {
            this.zzhms.zzhmm.zza(zzdpn);
            if (this.zzhms.zzhml != zzdqe.zzhna) {
                this.zzhms.zzhez.zza(this.zzhms.zzhmi.zzaua(), zzdpn);
            }
            if (this.zzhms.zzhml == zzdqe.zzhmz) {
                this.zzhms.zzd(this.zzhms.zzhmi);
            }
            int unused = this.zzhms.zzhml = zzdqe.zzhmz;
            this.zzhms.zzhmj.set(zzdpn);
        }
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzhms) {
            this.zzhms.zzhmm.zzb(th);
            this.zzhms.zzhmj.setException(th);
        }
    }
}
