package com.google.android.gms.internal.ads;

final class zzdmr implements zzcyn<zzchc> {
    private final /* synthetic */ zzdmo zzhgm;

    zzdmr(zzdmo zzdmo) {
        this.zzhgm = zzdmo;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzchc zzchc = (zzchc) obj;
        synchronized (this.zzhgm) {
            zzchc unused = this.zzhgm.zzhgi = zzchc;
            this.zzhgm.zzhgi.zzajj();
        }
    }

    public final void zzarx() {
        synchronized (this.zzhgm) {
            zzchc unused = this.zzhgm.zzhgi = null;
        }
    }
}
