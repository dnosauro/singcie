package com.google.android.gms.internal.ads;

final class zzin implements Runnable {
    private final /* synthetic */ zzik zzajb;
    private final /* synthetic */ zzjm zzajh;

    zzin(zzik zzik, zzjm zzjm) {
        this.zzajb = zzik;
        this.zzajh = zzjm;
    }

    public final void run() {
        this.zzajh.zzgn();
        this.zzajb.zzajc.zzb(this.zzajh);
    }
}
