package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public abstract class zzdym<V> extends zzdyn<V> implements zzdyz<V> {
    protected zzdym() {
    }

    public void addListener(Runnable runnable, Executor executor) {
        zzazn().addListener(runnable, executor);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzazm */
    public abstract zzdyz<? extends V> zzazn();
}
