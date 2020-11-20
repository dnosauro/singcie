package com.google.android.gms.internal.ads;

final class zzdjj implements zzcyn<zzblv> {
    private final /* synthetic */ zzdjf zzheg;

    zzdjj(zzdjf zzdjf) {
        this.zzheg = zzdjf;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzblv zzblv = (zzblv) obj;
        synchronized (this.zzheg) {
            if (this.zzheg.zzhee != null) {
                this.zzheg.zzhee.destroy();
            }
            this.zzheg.zzhee = zzblv;
            this.zzheg.zza(zzblv);
            this.zzheg.zzhdf.zzb((zzsg) new zzbly(zzblv, this.zzheg, this.zzheg.zzhdf));
            zzblv.zzajj();
        }
    }

    public final void zzarx() {
        synchronized (this.zzheg) {
            this.zzheg.zzhee = null;
        }
    }
}
