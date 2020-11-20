package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;

final class zzazk implements Executor {
    private final Handler zzegv = new zzg(Looper.getMainLooper());

    zzazk() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzp.zzkq();
                zzm.zza(zzp.zzku().getApplicationContext(), th);
                throw th;
            }
        } else {
            this.zzegv.post(runnable);
        }
    }
}
