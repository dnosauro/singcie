package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzdqx<E, V> implements zzdyz<V> {
    private final E zzhnm;
    private final String zzhnn;
    private final zzdyz<V> zzhno;

    public zzdqx(E e, String str, zzdyz<V> zzdyz) {
        this.zzhnm = e;
        this.zzhnn = str;
        this.zzhno = zzdyz;
    }

    public final void addListener(Runnable runnable, Executor executor) {
        this.zzhno.addListener(runnable, executor);
    }

    public final boolean cancel(boolean z) {
        return this.zzhno.cancel(z);
    }

    public final V get() {
        return this.zzhno.get();
    }

    public final V get(long j, TimeUnit timeUnit) {
        return this.zzhno.get(j, timeUnit);
    }

    public final boolean isCancelled() {
        return this.zzhno.isCancelled();
    }

    public final boolean isDone() {
        return this.zzhno.isDone();
    }

    public final String toString() {
        String str = this.zzhnn;
        int identityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(identityHashCode);
        return sb.toString();
    }

    public final E zzawt() {
        return this.zzhnm;
    }

    public final String zzawu() {
        return this.zzhnn;
    }
}
