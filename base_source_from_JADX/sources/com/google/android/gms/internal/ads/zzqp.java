package com.google.android.gms.internal.ads;

import android.view.Surface;

final class zzqp implements Runnable {
    private final /* synthetic */ zzqj zzbmw;
    private final /* synthetic */ Surface zzbne;

    zzqp(zzqj zzqj, Surface surface) {
        this.zzbmw = zzqj;
        this.zzbne = surface;
    }

    public final void run() {
        this.zzbmw.zzbmx.zza(this.zzbne);
    }
}
