package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

final class zzjr implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zzjp zzb;

    zzjr(zzjp zzjp, ComponentName componentName) {
        this.zzb = zzjp;
        this.zza = componentName;
    }

    public final void run() {
        this.zzb.zza.zza(this.zza);
    }
}
