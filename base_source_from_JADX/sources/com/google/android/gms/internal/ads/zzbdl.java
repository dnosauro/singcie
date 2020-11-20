package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbdl implements Runnable {
    private final boolean zzejc;
    private final long zzeme;
    private final zzbbe zzenn;

    zzbdl(zzbbe zzbbe, boolean z, long j) {
        this.zzenn = zzbbe;
        this.zzejc = z;
        this.zzeme = j;
    }

    public final void run() {
        this.zzenn.zza(this.zzejc, this.zzeme);
    }
}
