package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

final class zzjf implements Runnable {
    private final /* synthetic */ Bundle zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zziv zzc;

    zzjf(zziv zziv, Bundle bundle, zzn zzn) {
        this.zzc = zziv;
        this.zza = bundle;
        this.zzb = zzn;
    }

    public final void run() {
        zzep zzd = this.zzc.zzb;
        if (zzd == null) {
            this.zzc.zzq().zze().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            zzd.zza(this.zza, this.zzb);
        } catch (RemoteException e) {
            this.zzc.zzq().zze().zza("Failed to send default event parameters to service", e);
        }
    }
}
