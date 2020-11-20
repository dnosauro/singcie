package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzap;
import com.google.android.gms.ads.internal.util.zzd;

final class zzcpg implements zzdyo<ParcelFileDescriptor> {
    private final /* synthetic */ zzatf zzgoj;

    zzcpg(zzcou zzcou, zzatf zzatf) {
        this.zzgoj = zzatf;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        try {
            this.zzgoj.zzb((ParcelFileDescriptor) obj);
        } catch (RemoteException e) {
            zzd.zza("Service can't call client", e);
        }
    }

    public final void zzb(Throwable th) {
        try {
            this.zzgoj.zza(zzap.zzc(th));
        } catch (RemoteException e) {
            zzd.zza("Service can't call client", e);
        }
    }
}
