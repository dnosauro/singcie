package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

final /* synthetic */ class zzbnj implements Runnable {
    private final AtomicReference zzftz;

    zzbnj(AtomicReference atomicReference) {
        this.zzftz = atomicReference;
    }

    public final void run() {
        Runnable runnable = (Runnable) this.zzftz.getAndSet((Object) null);
        if (runnable != null) {
            runnable.run();
        }
    }
}
