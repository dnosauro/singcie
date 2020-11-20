package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxo;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class zzdyw<V> implements zzdyz<V> {
    private static final Logger zzhwc = Logger.getLogger(zzdyw.class.getName());
    static final zzdyz<?> zzhxp = new zzdyw((Object) null);
    @NullableDecl
    private final V value;

    static final class zza<V> extends zzdxo.zzj<V> {
        zza(Throwable th) {
            setException(th);
        }
    }

    zzdyw(@NullableDecl V v) {
        this.value = v;
    }

    public void addListener(Runnable runnable, Executor executor) {
        zzdvv.checkNotNull(runnable, "Runnable was null.");
        zzdvv.checkNotNull(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = zzhwc;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(valueOf);
            sb.append(" with executor ");
            sb.append(valueOf2);
            logger.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", sb.toString(), e);
        }
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public V get() {
        return this.value;
    }

    public V get(long j, TimeUnit timeUnit) {
        zzdvv.checkNotNull(timeUnit);
        return get();
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public String toString() {
        String obj = super.toString();
        String valueOf = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 27 + String.valueOf(valueOf).length());
        sb.append(obj);
        sb.append("[status=SUCCESS, result=[");
        sb.append(valueOf);
        sb.append("]]");
        return sb.toString();
    }
}
