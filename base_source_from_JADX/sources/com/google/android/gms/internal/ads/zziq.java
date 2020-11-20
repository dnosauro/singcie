package com.google.android.gms.internal.ads;

final class zziq implements Runnable {
    private final /* synthetic */ zzik zzajb;
    private final /* synthetic */ int zzaln;

    zziq(zzik zzik, int i) {
        this.zzajb = zzik;
        this.zzaln = i;
    }

    public final void run() {
        this.zzajb.zzajc.zzw(this.zzaln);
    }
}
