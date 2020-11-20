package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

final class zzps implements ThreadFactory {
    private final /* synthetic */ String zzbkk;

    zzps(String str) {
        this.zzbkk = str;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zzbkk);
    }
}
