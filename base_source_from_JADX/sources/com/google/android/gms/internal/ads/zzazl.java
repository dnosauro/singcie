package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzazl implements ThreadFactory {
    private final /* synthetic */ String zzegw;
    private final AtomicInteger zzyu = new AtomicInteger(1);

    zzazl(String str) {
        this.zzegw = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.zzegw;
        int andIncrement = this.zzyu.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
