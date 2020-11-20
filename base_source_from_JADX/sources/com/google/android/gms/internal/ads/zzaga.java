package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzaga extends zzgu implements zzafy {
    zzaga(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public final void zza(zzagj zzagj) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzagj);
        zzb(1, zzdo);
    }
}
