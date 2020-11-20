package com.google.android.gms.ads.internal.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzduw;

public final class zzbo {
    private Handler handler = null;
    private final Object lock = new Object();
    private HandlerThread zzefd = null;
    private int zzefe = 0;

    public final Handler getHandler() {
        return this.handler;
    }

    public final Looper zzyw() {
        Looper looper;
        synchronized (this.lock) {
            if (this.zzefe != 0) {
                Preconditions.checkNotNull(this.zzefd, "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzefd == null) {
                zzd.zzee("Starting the looper thread.");
                this.zzefd = new HandlerThread("LooperProvider");
                this.zzefd.start();
                this.handler = new zzduw(this.zzefd.getLooper());
                zzd.zzee("Looper thread started.");
            } else {
                zzd.zzee("Resuming the looper thread");
                this.lock.notifyAll();
            }
            this.zzefe++;
            looper = this.zzefd.getLooper();
        }
        return looper;
    }
}
