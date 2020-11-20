package com.google.android.gms.internal.ads;

final class zzio implements Runnable {
    private final /* synthetic */ zzik zzajb;
    private final /* synthetic */ int zzaji;
    private final /* synthetic */ long zzajj;
    private final /* synthetic */ long zzajk;

    zzio(zzik zzik, int i, long j, long j2) {
        this.zzajb = zzik;
        this.zzaji = i;
        this.zzajj = j;
        this.zzajk = j2;
    }

    public final void run() {
        this.zzajb.zzajc.zza(this.zzaji, this.zzajj, this.zzajk);
    }
}
