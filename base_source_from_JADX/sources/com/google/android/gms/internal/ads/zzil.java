package com.google.android.gms.internal.ads;

final class zzil implements Runnable {
    private final /* synthetic */ zzik zzajb;
    private final /* synthetic */ zzhp zzajd;

    zzil(zzik zzik, zzhp zzhp) {
        this.zzajb = zzik;
        this.zzajd = zzhp;
    }

    public final void run() {
        this.zzajb.zzajc.zzb(this.zzajd);
    }
}
