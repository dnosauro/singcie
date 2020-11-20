package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class zzjk implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzn zze;
    private final /* synthetic */ zziv zzf;

    zzjk(zziv zziv, AtomicReference atomicReference, String str, String str2, String str3, zzn zzn) {
        this.zzf = zziv;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = zzn;
    }

    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        List<zzw> zza2;
        synchronized (this.zza) {
            try {
                zzep zzd2 = this.zzf.zzb;
                if (zzd2 == null) {
                    this.zzf.zzq().zze().zza("(legacy) Failed to get conditional properties; not connected to service", zzex.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    atomicReference2 = this.zza;
                    zza2 = zzd2.zza(this.zzc, this.zzd, this.zze);
                } else {
                    atomicReference2 = this.zza;
                    zza2 = zzd2.zza(this.zzb, this.zzc, this.zzd);
                }
                atomicReference2.set(zza2);
                this.zzf.zzaj();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e) {
                try {
                    this.zzf.zzq().zze().zza("(legacy) Failed to get conditional properties; remote exception", zzex.zza(this.zzb), this.zzc, e);
                    this.zza.set(Collections.emptyList());
                    atomicReference = this.zza;
                } catch (Throwable th) {
                    this.zza.notify();
                    throw th;
                }
            }
        }
    }
}
