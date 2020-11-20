package com.google.android.gms.internal.ads;

final class zzfe implements Runnable {
    private final /* synthetic */ zzfa zzzl;

    zzfe(zzfa zzfa) {
        this.zzzl = zzfa;
    }

    public final void run() {
        zzabf.initialize(this.zzzl.context);
    }
}
