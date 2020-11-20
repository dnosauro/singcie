package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;

final /* synthetic */ class zzbwn implements Runnable {
    private final Object zzdko;
    private final zzbwm zzfyr;

    zzbwn(zzbwm zzbwm, Object obj) {
        this.zzfyr = zzbwm;
        this.zzdko = obj;
    }

    public final void run() {
        try {
            this.zzfyr.zzp(this.zzdko);
        } catch (Throwable th) {
            zzp.zzku().zzb(th, "EventEmitter.notify");
            zzd.zza("Event emitter exception.", th);
        }
    }
}
