package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdyw;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzdyr extends zzdyu {
    public static <V> zzdyz<V> immediateFailedFuture(Throwable th) {
        zzdvv.checkNotNull(th);
        return new zzdyw.zza(th);
    }

    @SafeVarargs
    public static <V> zzdys<V> zza(zzdyz<? extends V>... zzdyzArr) {
        return new zzdys<>(false, zzdwm.zzb((E[]) zzdyzArr), (zzdyq) null);
    }

    public static <O> zzdyz<O> zza(zzdxz<O> zzdxz, Executor executor) {
        zzdzo zzdzo = new zzdzo(zzdxz);
        executor.execute(zzdzo);
        return zzdzo;
    }

    public static <V> zzdyz<V> zza(zzdyz<V> zzdyz, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return zzdyz.isDone() ? zzdyz : zzdzk.zzb(zzdyz, j, timeUnit, scheduledExecutorService);
    }

    public static <V> V zza(Future<V> future) {
        if (future.isDone()) {
            return zzdzs.getUninterruptibly(future);
        }
        throw new IllegalStateException(zzdwc.zzb("Future was expected to be done: %s", future));
    }

    public static <V> void zza(zzdyz<V> zzdyz, zzdyo<? super V> zzdyo, Executor executor) {
        zzdvv.checkNotNull(zzdyo);
        zzdyz.addListener(new zzdyt(zzdyz, zzdyo), executor);
    }

    public static <V> zzdyz<V> zzag(@NullableDecl V v) {
        return v == null ? zzdyw.zzhxp : new zzdyw(v);
    }

    @SafeVarargs
    public static <V> zzdys<V> zzb(zzdyz<? extends V>... zzdyzArr) {
        return new zzdys<>(true, zzdwm.zzb((E[]) zzdyzArr), (zzdyq) null);
    }

    public static <I, O> zzdyz<O> zzb(zzdyz<I> zzdyz, zzdvm<? super I, ? extends O> zzdvm, Executor executor) {
        return zzdxq.zza(zzdyz, zzdvm, executor);
    }

    public static <I, O> zzdyz<O> zzb(zzdyz<I> zzdyz, zzdyb<? super I, ? extends O> zzdyb, Executor executor) {
        return zzdxq.zza(zzdyz, zzdyb, executor);
    }

    public static <V, X extends Throwable> zzdyz<V> zzb(zzdyz<? extends V> zzdyz, Class<X> cls, zzdyb<? super X, ? extends V> zzdyb, Executor executor) {
        return zzdxn.zza(zzdyz, cls, zzdyb, executor);
    }

    public static <V> V zzb(Future<V> future) {
        zzdvv.checkNotNull(future);
        try {
            return zzdzs.getUninterruptibly(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzdyj((Error) cause);
            }
            throw new zzdzp(cause);
        }
    }

    public static <V> zzdyz<List<V>> zzi(Iterable<? extends zzdyz<? extends V>> iterable) {
        return new zzdyd(zzdwm.zzh(iterable), true);
    }

    public static <V> zzdys<V> zzj(Iterable<? extends zzdyz<? extends V>> iterable) {
        return new zzdys<>(false, zzdwm.zzh(iterable), (zzdyq) null);
    }

    public static <V> zzdys<V> zzk(Iterable<? extends zzdyz<? extends V>> iterable) {
        return new zzdys<>(true, zzdwm.zzh(iterable), (zzdyq) null);
    }
}
