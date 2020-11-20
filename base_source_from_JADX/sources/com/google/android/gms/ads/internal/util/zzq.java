package com.google.android.gms.ads.internal.util;

import android.content.Context;

final class zzq implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzm zzedj;

    zzq(zzm zzm, Context context) {
        this.zzedj = zzm;
        this.val$context = context;
    }

    public final void run() {
        synchronized (this.zzedj.zzede) {
            String unused = this.zzedj.zzbih = zzm.zzao(this.val$context);
            this.zzedj.zzede.notifyAll();
        }
    }
}
