package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxo;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzdxy<OutputT> extends zzdxo.zzj<OutputT> {
    private static final Logger zzhwc = Logger.getLogger(zzdxy.class.getName());
    private static final zzb zzhxb;
    private volatile int remaining;
    /* access modifiers changed from: private */
    public volatile Set<Throwable> seenExceptions = null;

    static final class zza extends zzb {
        private final AtomicReferenceFieldUpdater<zzdxy, Set<Throwable>> zzhxc;
        private final AtomicIntegerFieldUpdater<zzdxy> zzhxd;

        zza(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.zzhxc = atomicReferenceFieldUpdater;
            this.zzhxd = atomicIntegerFieldUpdater;
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzdxy zzdxy, Set<Throwable> set, Set<Throwable> set2) {
            this.zzhxc.compareAndSet(zzdxy, (Object) null, set2);
        }

        /* access modifiers changed from: package-private */
        public final int zzc(zzdxy zzdxy) {
            return this.zzhxd.decrementAndGet(zzdxy);
        }
    }

    static abstract class zzb {
        private zzb() {
        }

        /* access modifiers changed from: package-private */
        public abstract void zza(zzdxy zzdxy, Set<Throwable> set, Set<Throwable> set2);

        /* access modifiers changed from: package-private */
        public abstract int zzc(zzdxy zzdxy);
    }

    static final class zzc extends zzb {
        private zzc() {
            super();
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzdxy zzdxy, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (zzdxy) {
                if (zzdxy.seenExceptions == null) {
                    Set unused = zzdxy.seenExceptions = set2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final int zzc(zzdxy zzdxy) {
            int zzb;
            synchronized (zzdxy) {
                zzb = zzdxy.zzb(zzdxy);
            }
            return zzb;
        }
    }

    static {
        Throwable th;
        zzb zzb2;
        try {
            zzb2 = new zza(AtomicReferenceFieldUpdater.newUpdater(zzdxy.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(zzdxy.class, "remaining"));
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzb2 = new zzc();
        }
        zzhxb = zzb2;
        if (th != null) {
            zzhwc.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzdxy(int i) {
        this.remaining = i;
    }

    static /* synthetic */ int zzb(zzdxy zzdxy) {
        int i = zzdxy.remaining - 1;
        zzdxy.remaining = i;
        return i;
    }

    /* access modifiers changed from: package-private */
    public final Set<Throwable> zzazh() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzh(newSetFromMap);
        zzhxb.zza(this, (Set<Throwable>) null, newSetFromMap);
        return this.seenExceptions;
    }

    /* access modifiers changed from: package-private */
    public final int zzazi() {
        return zzhxb.zzc(this);
    }

    /* access modifiers changed from: package-private */
    public final void zzazj() {
        this.seenExceptions = null;
    }

    /* access modifiers changed from: package-private */
    public abstract void zzh(Set<Throwable> set);
}
