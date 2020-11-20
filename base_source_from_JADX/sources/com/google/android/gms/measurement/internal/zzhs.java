package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zzhs implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzhe zzb;

    zzhs(zzhe zzhe, Bundle bundle) {
        this.zzb = zzhe;
        this.zza = bundle;
    }

    public final void run() {
        this.zzb.zzd(this.zza);
    }
}
