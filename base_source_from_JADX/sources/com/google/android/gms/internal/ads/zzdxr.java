package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzdxr extends AbstractExecutorService implements zzdzc {
    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return zzdzo.zza(runnable, t);
    }

    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return zzdzo.zzf(callable);
    }

    public /* synthetic */ Future submit(Runnable runnable, @NullableDecl Object obj) {
        return (zzdyz) super.submit(runnable, obj);
    }

    /* renamed from: zze */
    public final <T> zzdyz<T> submit(Callable<T> callable) {
        return (zzdyz) super.submit(callable);
    }

    /* renamed from: zzg */
    public final zzdyz<?> submit(Runnable runnable) {
        return (zzdyz) super.submit(runnable);
    }
}
