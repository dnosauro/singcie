package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class zzdxq<I, O, F, T> extends zzdyl<O> implements Runnable {
    @NullableDecl
    private zzdyz<? extends I> zzhvz;
    @NullableDecl
    private F zzhwq;

    zzdxq(zzdyz<? extends I> zzdyz, F f) {
        this.zzhvz = (zzdyz) zzdvv.checkNotNull(zzdyz);
        this.zzhwq = zzdvv.checkNotNull(f);
    }

    static <I, O> zzdyz<O> zza(zzdyz<I> zzdyz, zzdvm<? super I, ? extends O> zzdvm, Executor executor) {
        zzdvv.checkNotNull(zzdvm);
        zzdxs zzdxs = new zzdxs(zzdyz, zzdvm);
        zzdyz.addListener(zzdxs, zzdzb.zza(executor, zzdxs));
        return zzdxs;
    }

    static <I, O> zzdyz<O> zza(zzdyz<I> zzdyz, zzdyb<? super I, ? extends O> zzdyb, Executor executor) {
        zzdvv.checkNotNull(executor);
        zzdxt zzdxt = new zzdxt(zzdyz, zzdyb);
        zzdyz.addListener(zzdxt, zzdzb.zza(executor, zzdxt));
        return zzdxt;
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        maybePropagateCancellationTo(this.zzhvz);
        this.zzhvz = null;
        this.zzhwq = null;
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzdyz<? extends I> zzdyz = this.zzhvz;
        F f = this.zzhwq;
        String pendingToString = super.pendingToString();
        String str = "";
        if (zzdyz != null) {
            String valueOf = String.valueOf(zzdyz);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("inputFuture=[");
            sb.append(valueOf);
            sb.append("], ");
            str = sb.toString();
        }
        if (f != null) {
            String valueOf2 = String.valueOf(f);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(valueOf2).length());
            sb2.append(str);
            sb2.append("function=[");
            sb2.append(valueOf2);
            sb2.append("]");
            return sb2.toString();
        } else if (pendingToString == null) {
            return null;
        } else {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf(pendingToString);
            return valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
        }
    }

    public final void run() {
        zzdyz<? extends I> zzdyz = this.zzhvz;
        F f = this.zzhwq;
        boolean z = true;
        boolean isCancelled = isCancelled() | (zzdyz == null);
        if (f != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.zzhvz = null;
            if (zzdyz.isCancelled()) {
                setFuture(zzdyz);
                return;
            }
            try {
                try {
                    Object zzd = zzd(f, zzdyr.zza(zzdyz));
                    this.zzhwq = null;
                    setResult(zzd);
                } catch (Throwable th) {
                    this.zzhwq = null;
                    throw th;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                setException(e.getCause());
            } catch (RuntimeException e2) {
                setException(e2);
            } catch (Error e3) {
                setException(e3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void setResult(@NullableDecl T t);

    /* access modifiers changed from: package-private */
    @NullableDecl
    public abstract T zzd(F f, @NullableDecl I i);
}
