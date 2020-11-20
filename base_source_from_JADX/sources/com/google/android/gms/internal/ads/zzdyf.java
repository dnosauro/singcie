package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxv;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdyf<V> extends zzdxv<Object, V> {
    /* access modifiers changed from: private */
    public zzdyh<?> zzhxh;

    zzdyf(zzdwl<? extends zzdyz<?>> zzdwl, boolean z, Executor executor, Callable<V> callable) {
        super(zzdwl, z, false);
        this.zzhxh = new zzdye(this, callable, executor);
        zzazf();
    }

    /* access modifiers changed from: protected */
    public final void interruptTask() {
        zzdyh<?> zzdyh = this.zzhxh;
        if (zzdyh != null) {
            zzdyh.interruptTask();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdxv.zza zza) {
        super.zza(zza);
        if (zza == zzdxv.zza.OUTPUT_FUTURE_DONE) {
            this.zzhxh = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzazg() {
        zzdyh<?> zzdyh = this.zzhxh;
        if (zzdyh != null) {
            zzdyh.execute();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, @NullableDecl Object obj) {
    }
}
