package com.google.android.gms.internal.ads;

final class zzbag implements Runnable {
    private final /* synthetic */ zzbac zzeib;
    private final /* synthetic */ String zzeid;
    private final /* synthetic */ String zzeie;

    zzbag(zzbac zzbac, String str, String str2) {
        this.zzeib = zzbac;
        this.zzeid = str;
        this.zzeie = str2;
    }

    public final void run() {
        if (this.zzeib.zzehx != null) {
            this.zzeib.zzehx.zzm(this.zzeid, this.zzeie);
        }
    }
}
