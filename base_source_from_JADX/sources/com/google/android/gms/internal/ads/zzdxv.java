package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class zzdxv<InputT, OutputT> extends zzdxy<OutputT> {
    private static final Logger logger = Logger.getLogger(zzdxv.class.getName());
    /* access modifiers changed from: private */
    @NullableDecl
    public zzdwl<? extends zzdyz<? extends InputT>> zzhwu;
    private final boolean zzhwv;
    private final boolean zzhww;

    enum zza {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    zzdxv(zzdwl<? extends zzdyz<? extends InputT>> zzdwl, boolean z, boolean z2) {
        super(zzdwl.size());
        this.zzhwu = (zzdwl) zzdvv.checkNotNull(zzdwl);
        this.zzhwv = z;
        this.zzhww = z2;
    }

    private final void handleException(Throwable th) {
        zzdvv.checkNotNull(th);
        if (this.zzhwv && !setException(th) && zza(zzazh(), th)) {
            zzk(th);
        } else if (th instanceof Error) {
            zzk(th);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(int i, Future<? extends InputT> future) {
        try {
            zzb(i, zzdyr.zza(future));
        } catch (ExecutionException e) {
            handleException(e.getCause());
        } catch (Throwable th) {
            handleException(th);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(@NullableDecl zzdwl<? extends Future<? extends InputT>> zzdwl) {
        int zzazi = zzazi();
        int i = 0;
        if (!(zzazi >= 0)) {
            throw new IllegalStateException(String.valueOf("Less than 0 remaining futures"));
        } else if (zzazi == 0) {
            if (zzdwl != null) {
                zzdxh zzdxh = (zzdxh) zzdwl.iterator();
                while (zzdxh.hasNext()) {
                    Future future = (Future) zzdxh.next();
                    if (!future.isCancelled()) {
                        zza(i, future);
                    }
                    i++;
                }
            }
            zzazj();
            zzazg();
            zza(zza.ALL_INPUT_FUTURES_PROCESSED);
        }
    }

    private static boolean zza(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }

    private static void zzk(Throwable th) {
        logger.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", "log", th instanceof Error ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first", th);
    }

    /* access modifiers changed from: protected */
    public final void afterDone() {
        super.afterDone();
        zzdwl<? extends zzdyz<? extends InputT>> zzdwl = this.zzhwu;
        zza(zza.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (zzdwl != null)) {
            boolean wasInterrupted = wasInterrupted();
            zzdxh zzdxh = (zzdxh) zzdwl.iterator();
            while (zzdxh.hasNext()) {
                ((Future) zzdxh.next()).cancel(wasInterrupted);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final String pendingToString() {
        zzdwl<? extends zzdyz<? extends InputT>> zzdwl = this.zzhwu;
        if (zzdwl == null) {
            return super.pendingToString();
        }
        String valueOf = String.valueOf(zzdwl);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("futures=");
        sb.append(valueOf);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void zza(zza zza2) {
        zzdvv.checkNotNull(zza2);
        this.zzhwu = null;
    }

    /* access modifiers changed from: package-private */
    public final void zzazf() {
        if (this.zzhwu.isEmpty()) {
            zzazg();
        } else if (this.zzhwv) {
            int i = 0;
            zzdxh zzdxh = (zzdxh) this.zzhwu.iterator();
            while (zzdxh.hasNext()) {
                zzdyz zzdyz = (zzdyz) zzdxh.next();
                zzdyz.addListener(new zzdxu(this, zzdyz, i), zzdyg.INSTANCE);
                i++;
            }
        } else {
            zzdxw zzdxw = new zzdxw(this, this.zzhww ? this.zzhwu : null);
            zzdxh zzdxh2 = (zzdxh) this.zzhwu.iterator();
            while (zzdxh2.hasNext()) {
                ((zzdyz) zzdxh2.next()).addListener(zzdxw, zzdyg.INSTANCE);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void zzazg();

    /* access modifiers changed from: package-private */
    public abstract void zzb(int i, @NullableDecl InputT inputt);

    /* access modifiers changed from: package-private */
    public final void zzh(Set<Throwable> set) {
        zzdvv.checkNotNull(set);
        if (!isCancelled()) {
            zza(set, zzazc());
        }
    }
}
