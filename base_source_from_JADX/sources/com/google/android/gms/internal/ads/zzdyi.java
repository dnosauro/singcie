package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class zzdyi<V> extends zzdyv<V> {
    zzdyi() {
    }

    public static <V> zzdyi<V> zzg(zzdyz<V> zzdyz) {
        return zzdyz instanceof zzdyi ? (zzdyi) zzdyz : new zzdyk(zzdyz);
    }

    public final zzdyi<V> zza(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (zzdyi) zzdyr.zza(this, j, timeUnit, scheduledExecutorService);
    }

    public final <T> zzdyi<T> zza(zzdvm<? super V, T> zzdvm, Executor executor) {
        zzdvv.checkNotNull(zzdvm);
        zzdxs zzdxs = new zzdxs(this, zzdvm);
        addListener(zzdxs, zzdzb.zza(executor, zzdxs));
        return zzdxs;
    }

    public final <X extends Throwable> zzdyi<V> zza(Class<X> cls, zzdvm<? super X, ? extends V> zzdvm, Executor executor) {
        zzdxp zzdxp = new zzdxp(this, cls, zzdvm);
        addListener(zzdxp, zzdzb.zza(executor, zzdxp));
        return zzdxp;
    }

    public final <X extends Throwable> zzdyi<V> zza(Class<X> cls, zzdyb<? super X, ? extends V> zzdyb, Executor executor) {
        zzdxm zzdxm = new zzdxm(this, cls, zzdyb);
        addListener(zzdxm, zzdzb.zza(executor, zzdxm));
        return zzdxm;
    }

    public final <T> zzdyi<T> zzb(zzdyb<? super V, T> zzdyb, Executor executor) {
        zzdvv.checkNotNull(executor);
        zzdxt zzdxt = new zzdxt(this, zzdyb);
        addListener(zzdxt, zzdzb.zza(executor, zzdxt));
        return zzdxt;
    }
}
