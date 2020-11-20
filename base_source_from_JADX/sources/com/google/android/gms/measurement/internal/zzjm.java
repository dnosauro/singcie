package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

final class zzjm implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ boolean zze;
    private final /* synthetic */ zzn zzf;
    private final /* synthetic */ zziv zzg;

    zzjm(zziv zziv, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzn zzn) {
        this.zzg = zziv;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
        this.zzf = zzn;
    }

    public final void run() {
        AtomicReference atomicReference;
        AtomicReference atomicReference2;
        List<zzkw> zza2;
        synchronized (this.zza) {
            try {
                zzep zzd2 = this.zzg.zzb;
                if (zzd2 == null) {
                    this.zzg.zzq().zze().zza("(legacy) Failed to get user properties; not connected to service", zzex.zza(this.zzb), this.zzc, this.zzd);
                    this.zza.set(Collections.emptyList());
                    this.zza.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.zzb)) {
                    atomicReference2 = this.zza;
                    zza2 = zzd2.zza(this.zzc, this.zzd, this.zze, this.zzf);
                } else {
                    atomicReference2 = this.zza;
                    zza2 = zzd2.zza(this.zzb, this.zzc, this.zzd, this.zze);
                }
                atomicReference2.set(zza2);
                this.zzg.zzaj();
                atomicReference = this.zza;
                atomicReference.notify();
            } catch (RemoteException e) {
                try {
                    this.zzg.zzq().zze().zza("(legacy) Failed to get user properties; remote exception", zzex.zza(this.zzb), this.zzc, e);
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
