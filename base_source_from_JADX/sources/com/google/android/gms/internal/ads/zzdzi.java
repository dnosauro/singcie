package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxo;

final class zzdzi extends zzdxo.zzj<Void> implements Runnable {
    private final Runnable zzhxy;

    public zzdzi(Runnable runnable) {
        this.zzhxy = (Runnable) zzdvv.checkNotNull(runnable);
    }

    public final void run() {
        try {
            this.zzhxy.run();
        } catch (Throwable th) {
            setException(th);
            throw zzdwe.zzj(th);
        }
    }
}
