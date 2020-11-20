package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzafm extends zzgu implements zzafk {
    zzafm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public final void zza(zzafb zzafb) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzafb);
        zzb(1, zzdo);
    }
}
