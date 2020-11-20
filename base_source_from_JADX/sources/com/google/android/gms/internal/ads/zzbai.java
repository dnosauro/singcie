package com.google.android.gms.internal.ads;

final class zzbai implements Runnable {
    private final /* synthetic */ zzbac zzeib;
    private final /* synthetic */ int zzeif;
    private final /* synthetic */ int zzeig;

    zzbai(zzbac zzbac, int i, int i2) {
        this.zzeib = zzbac;
        this.zzeif = i;
        this.zzeig = i2;
    }

    public final void run() {
        if (this.zzeib.zzehx != null) {
            this.zzeib.zzehx.zzk(this.zzeif, this.zzeig);
        }
    }
}
