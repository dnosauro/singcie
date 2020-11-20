package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzaxl implements ThreadFactory {
    private final AtomicInteger zzyu = new AtomicInteger(1);

    zzaxl(zzawx zzawx) {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.zzyu.getAndIncrement();
        StringBuilder sb = new StringBuilder(42);
        sb.append("AdWorker(SCION_TASK_EXECUTOR) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
