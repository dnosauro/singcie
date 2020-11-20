package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

final /* synthetic */ class zztp implements Runnable {
    private final zzazq zzbvq;
    private final Future zzbvr;

    zztp(zzazq zzazq, Future future) {
        this.zzbvq = zzazq;
        this.zzbvr = future;
    }

    public final void run() {
        zzazq zzazq = this.zzbvq;
        Future future = this.zzbvr;
        if (zzazq.isCancelled()) {
            future.cancel(true);
        }
    }
}
