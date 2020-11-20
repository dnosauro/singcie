package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzms implements Runnable {
    private final /* synthetic */ zzmo zzbei;
    private final /* synthetic */ IOException zzbej;

    zzms(zzmo zzmo, IOException iOException) {
        this.zzbei = zzmo;
        this.zzbej = iOException;
    }

    public final void run() {
        this.zzbei.zzbdi.zzb(this.zzbej);
    }
}
