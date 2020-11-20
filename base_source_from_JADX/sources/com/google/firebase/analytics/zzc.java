package com.google.firebase.analytics;

import java.util.concurrent.Callable;

final class zzc implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zza;

    zzc(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    public final /* synthetic */ Object call() {
        String zza2 = this.zza.zzb();
        if (zza2 != null) {
            return zza2;
        }
        String zzh = this.zza.zzb.zzh();
        this.zza.zza(zzh);
        return zzh;
    }
}
