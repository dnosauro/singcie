package com.google.android.gms.internal.ads;

final class zzdmk implements zzcyn<zzchc> {
    private final /* synthetic */ zzdmi zzhgj;

    zzdmk(zzdmi zzdmi) {
        this.zzhgj = zzdmi;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzchc zzchc = (zzchc) obj;
        synchronized (this.zzhgj) {
            zzchc unused = this.zzhgj.zzhgi = zzchc;
            this.zzhgj.zzhgi.zzajj();
        }
    }

    public final void zzarx() {
        synchronized (this.zzhgj) {
            zzchc unused = this.zzhgj.zzhgi = null;
        }
    }
}
