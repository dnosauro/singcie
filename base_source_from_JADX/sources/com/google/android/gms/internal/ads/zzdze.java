package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class zzdze implements Executor {
    private final /* synthetic */ Executor zzhxu;
    private final /* synthetic */ zzdxo zzhxv;

    zzdze(Executor executor, zzdxo zzdxo) {
        this.zzhxu = executor;
        this.zzhxv = zzdxo;
    }

    public final void execute(Runnable runnable) {
        try {
            this.zzhxu.execute(runnable);
        } catch (RejectedExecutionException e) {
            this.zzhxv.setException(e);
        }
    }
}
