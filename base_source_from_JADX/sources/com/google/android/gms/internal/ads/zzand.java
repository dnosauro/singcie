package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzand {
    private static zzand zzdks;
    private AtomicBoolean zzdkt = new AtomicBoolean(false);

    zzand() {
    }

    public static zzand zzuc() {
        if (zzdks == null) {
            zzdks = new zzand();
        }
        return zzdks;
    }

    public final Thread zzc(Context context, String str) {
        if (!this.zzdkt.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new zzanc(this, context, str));
        thread.start();
        return thread;
    }
}
