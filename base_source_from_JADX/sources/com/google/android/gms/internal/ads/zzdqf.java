package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzdqf implements ThreadFactory {
    private final AtomicInteger zzyu = new AtomicInteger(1);

    zzdqf() {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.zzyu.getAndIncrement();
        StringBuilder sb = new StringBuilder(25);
        sb.append("AdWorker(NG) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
