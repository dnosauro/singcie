package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zzw;

final class zzja implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzw zzb;
    private final /* synthetic */ zziv zzc;

    zzja(zziv zziv, zzn zzn, zzw zzw) {
        this.zzc = zziv;
        this.zza = zzn;
        this.zzb = zzw;
    }

    public final void run() {
        String str = null;
        try {
            if (!zzmb.zzb() || !this.zzc.zzs().zza(zzat.zzco) || this.zzc.zzr().zzw().zze()) {
                zzep zzd = this.zzc.zzb;
                if (zzd == null) {
                    this.zzc.zzq().zze().zza("Failed to get app instance id");
                } else {
                    str = zzd.zzc(this.zza);
                    if (str != null) {
                        this.zzc.zze().zza(str);
                        this.zzc.zzr().zzj.zza(str);
                    }
                    this.zzc.zzaj();
                }
                this.zzc.zzo().zza(this.zzb, str);
            }
            this.zzc.zzq().zzj().zza("Analytics storage consent denied; will not get app instance id");
            this.zzc.zze().zza((String) null);
            this.zzc.zzr().zzj.zza((String) null);
            this.zzc.zzo().zza(this.zzb, str);
        } catch (RemoteException e) {
            this.zzc.zzq().zze().zza("Failed to get app instance id", e);
        } catch (Throwable th) {
            this.zzc.zzo().zza(this.zzb, (String) null);
            throw th;
        }
    }
}
