package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzjc implements Runnable {
    private final /* synthetic */ zzin zza;
    private final /* synthetic */ zziv zzb;

    zzjc(zziv zziv, zzin zzin) {
        this.zzb = zziv;
        this.zza = zzin;
    }

    public final void run() {
        long j;
        String str;
        String str2;
        String packageName;
        zzep zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzq().zze().zza("Failed to send current screen to service");
            return;
        }
        try {
            if (this.zza == null) {
                j = 0;
                str = null;
                str2 = null;
                packageName = this.zzb.zzm().getPackageName();
            } else {
                j = this.zza.zzc;
                str = this.zza.zza;
                str2 = this.zza.zzb;
                packageName = this.zzb.zzm().getPackageName();
            }
            zzd.zza(j, str, str2, packageName);
            this.zzb.zzaj();
        } catch (RemoteException e) {
            this.zzb.zzq().zze().zza("Failed to send current screen to the service", e);
        }
    }
}
