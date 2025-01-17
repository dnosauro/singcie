package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzw;
import java.util.ArrayList;

final class zzjn implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzn zzc;
    private final /* synthetic */ zzw zzd;
    private final /* synthetic */ zziv zze;

    zzjn(zziv zziv, String str, String str2, zzn zzn, zzw zzw) {
        this.zze = zziv;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzn;
        this.zzd = zzw;
    }

    public final void run() {
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzep zzd2 = this.zze.zzb;
            if (zzd2 == null) {
                this.zze.zzq().zze().zza("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
            } else {
                arrayList = zzkx.zzb(zzd2.zza(this.zza, this.zzb, this.zzc));
                this.zze.zzaj();
            }
        } catch (RemoteException e) {
            this.zze.zzq().zze().zza("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
        } catch (Throwable th) {
            this.zze.zzo().zza(this.zzd, arrayList);
            throw th;
        }
        this.zze.zzo().zza(this.zzd, arrayList);
    }
}
