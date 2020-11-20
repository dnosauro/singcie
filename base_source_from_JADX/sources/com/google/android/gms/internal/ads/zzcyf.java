package com.google.android.gms.internal.ads;

final class zzcyf implements zzcyn<zzbyx> {
    private final /* synthetic */ zzcyg zzgwi;

    zzcyf(zzcyg zzcyg) {
        this.zzgwi = zzcyg;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbyx zzbyx = (zzbyx) obj;
        synchronized (this.zzgwi) {
            zzbyx unused = this.zzgwi.zzgwl = zzbyx;
            this.zzgwi.zzgwl.zzajj();
        }
    }

    public final void zzarx() {
        synchronized (this.zzgwi) {
            zzbyx unused = this.zzgwi.zzgwl = null;
        }
    }
}
