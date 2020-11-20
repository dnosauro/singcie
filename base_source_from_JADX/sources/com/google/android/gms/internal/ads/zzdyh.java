package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

abstract class zzdyh<T> extends zzdyy<T> {
    private final /* synthetic */ zzdyf zzhxg;
    private final Executor zzhxk;

    zzdyh(zzdyf zzdyf, Executor executor) {
        this.zzhxg = zzdyf;
        this.zzhxk = (Executor) zzdvv.checkNotNull(executor);
    }

    /* access modifiers changed from: package-private */
    public final void execute() {
        try {
            this.zzhxk.execute(this);
        } catch (RejectedExecutionException e) {
            this.zzhxg.setException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean isDone() {
        return this.zzhxg.isDone();
    }

    /* access modifiers changed from: package-private */
    public abstract void setValue(T t);

    /* access modifiers changed from: package-private */
    public final void zzb(T t, Throwable th) {
        zzdyh unused = this.zzhxg.zzhxh = null;
        if (th == null) {
            setValue(t);
        } else if (th instanceof ExecutionException) {
            this.zzhxg.setException(th.getCause());
        } else if (th instanceof CancellationException) {
            this.zzhxg.cancel(false);
        } else {
            this.zzhxg.setException(th);
        }
    }
}
