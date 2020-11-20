package com.google.android.gms.internal.ads;

final class zzp implements Runnable {
    private final /* synthetic */ zzaa zzaa;
    private final /* synthetic */ zzm zzab;

    zzp(zzm zzm, zzaa zzaa2) {
        this.zzab = zzm;
        this.zzaa = zzaa2;
    }

    public final void run() {
        try {
            this.zzab.zzm.put(this.zzaa);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
