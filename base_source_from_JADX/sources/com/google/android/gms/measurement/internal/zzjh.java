package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;

final class zzjh implements Runnable {
    private final /* synthetic */ zzar zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzw zzc;
    private final /* synthetic */ zziv zzd;

    zzjh(zziv zziv, zzar zzar, String str, zzw zzw) {
        this.zzd = zziv;
        this.zza = zzar;
        this.zzb = str;
        this.zzc = zzw;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            zzep zzd2 = this.zzd.zzb;
            if (zzd2 == null) {
                this.zzd.zzq().zze().zza("Discarding data. Failed to send event to service to bundle");
            } else {
                bArr = zzd2.zza(this.zza, this.zzb);
                this.zzd.zzaj();
            }
        } catch (RemoteException e) {
            this.zzd.zzq().zze().zza("Failed to send event to the service to bundle", e);
        } catch (Throwable th) {
            this.zzd.zzo().zza(this.zzc, bArr);
            throw th;
        }
        this.zzd.zzo().zza(this.zzc, bArr);
    }
}
