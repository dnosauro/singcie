package com.google.android.gms.internal.ads;

import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import javax.annotation.concurrent.GuardedBy;

public final class zzdod<T> {
    private final zzdzc zzggb;
    @GuardedBy("this")
    private final Deque<zzdyz<T>> zzhjf = new LinkedBlockingDeque();
    private final Callable<T> zzhjg;

    public zzdod(Callable<T> callable, zzdzc zzdzc) {
        this.zzhjg = callable;
        this.zzggb = zzdzc;
    }

    public final synchronized void ensureSize(int i) {
        int size = i - this.zzhjf.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.zzhjf.add(this.zzggb.zze(this.zzhjg));
        }
    }

    public final synchronized zzdyz<T> zzaux() {
        ensureSize(1);
        return this.zzhjf.poll();
    }

    public final synchronized void zzd(zzdyz<T> zzdyz) {
        this.zzhjf.addFirst(zzdyz);
    }
}
