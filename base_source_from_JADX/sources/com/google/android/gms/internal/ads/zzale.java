package com.google.android.gms.internal.ads;

final /* synthetic */ class zzale implements Runnable {
    private final zzalb zzdiq;
    private final zzals zzdiy;
    private final zzako zzdiz;

    zzale(zzalb zzalb, zzals zzals, zzako zzako) {
        this.zzdiq = zzalb;
        this.zzdiy = zzals;
        this.zzdiz = zzako;
    }

    public final void run() {
        this.zzdiq.zza(this.zzdiy, this.zzdiz);
    }
}
