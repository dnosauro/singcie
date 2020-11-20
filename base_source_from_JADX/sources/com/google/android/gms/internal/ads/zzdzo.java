package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdzo<V> extends zzdyl<V> implements RunnableFuture<V> {
    private volatile zzdyy<?> zzhye;

    zzdzo(zzdxz<V> zzdxz) {
        this.zzhye = new zzdzn(this, zzdxz);
    }

    private zzdzo(Callable<V> callable) {
        this.zzhye = new zzdzq(this, callable);
    }

    static <V> zzdzo<V> zza(Runnable runnable, @NullableDecl V v) {
        return new zzdzo<>(Executors.callable(runnable, v));
    }

    static <V> zzdzo<V> zzf(Callable<V> callable) {
        return new zzdzo<>(callable);
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        zzdyy<?> zzdyy;
        super.afterDone();
        if (wasInterrupted() && (zzdyy = this.zzhye) != null) {
            zzdyy.interruptTask();
        }
        this.zzhye = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzdyy<?> zzdyy = this.zzhye;
        if (zzdyy == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(zzdyy);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
        sb.append("task=[");
        sb.append(valueOf);
        sb.append("]");
        return sb.toString();
    }

    public final void run() {
        zzdyy<?> zzdyy = this.zzhye;
        if (zzdyy != null) {
            zzdyy.run();
        }
        this.zzhye = null;
    }
}
