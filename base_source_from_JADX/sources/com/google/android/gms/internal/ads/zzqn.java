package com.google.android.gms.internal.ads;

final class zzqn implements Runnable {
    private final /* synthetic */ zzqj zzbmw;
    private final /* synthetic */ int zzbnc;
    private final /* synthetic */ long zzbnd;

    zzqn(zzqj zzqj, int i, long j) {
        this.zzbmw = zzqj;
        this.zzbnc = i;
        this.zzbnd = j;
    }

    public final void run() {
        this.zzbmw.zzbmx.zzf(this.zzbnc, this.zzbnd);
    }
}
