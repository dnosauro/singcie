package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbbv implements Runnable {
    private final boolean zzejc;
    private final zzbbl zzels;
    private final long zzeme;

    zzbbv(zzbbl zzbbl, boolean z, long j) {
        this.zzels = zzbbl;
        this.zzejc = z;
        this.zzeme = j;
    }

    public final void run() {
        this.zzels.zzc(this.zzejc, this.zzeme);
    }
}
