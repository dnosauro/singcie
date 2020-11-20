package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzez implements ThreadFactory {
    private final ThreadFactory zzyt = Executors.defaultThreadFactory();
    private final AtomicInteger zzyu = new AtomicInteger(1);

    zzez() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zzyt.newThread(runnable);
        int andIncrement = this.zzyu.getAndIncrement();
        StringBuilder sb = new StringBuilder(16);
        sb.append("gads-");
        sb.append(andIncrement);
        newThread.setName(sb.toString());
        return newThread;
    }
}
