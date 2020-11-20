package com.google.android.gms.internal.ads;

final class zzcyk implements zzcyn<zzboc> {
    private final /* synthetic */ zzcyh zzgwv;

    zzcyk(zzcyh zzcyh) {
        this.zzgwv = zzcyh;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzboc zzboc = (zzboc) obj;
        synchronized (this.zzgwv) {
            boolean unused = this.zzgwv.zzafb = false;
            zzyn unused2 = this.zzgwv.zzads = zzboc.zzajz();
            zzboc.zzajj();
        }
    }

    public final void zzarx() {
        synchronized (this.zzgwv) {
            boolean unused = this.zzgwv.zzafb = false;
        }
    }
}
