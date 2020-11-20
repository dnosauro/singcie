package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzyo extends zzgu implements zzym {
    zzyo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public final void zza(zzvp zzvp) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzvp);
        zzb(1, zzdo);
    }
}
