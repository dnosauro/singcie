package com.google.android.gms.internal.ads;

final /* synthetic */ class zzcbx implements Runnable {
    private final boolean zzejc;
    private final zzcbt zzgch;

    zzcbx(zzcbt zzcbt, boolean z) {
        this.zzgch = zzcbt;
        this.zzejc = z;
    }

    public final void run() {
        this.zzgch.zzbi(this.zzejc);
    }
}
