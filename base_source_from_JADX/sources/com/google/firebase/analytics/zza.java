package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzm;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zza extends ThreadPoolExecutor {
    zza(FirebaseAnalytics firebaseAnalytics, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        super(0, 1, 30, timeUnit, blockingQueue);
    }

    public final void execute(Runnable runnable) {
        super.execute(zzm.zza().zza(runnable));
    }
}
