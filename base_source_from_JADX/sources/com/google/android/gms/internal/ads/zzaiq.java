package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzaiq extends zzgu implements zzair {
    zzaiq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zza(zzail zzail, zzaip zzaip) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzail);
        zzgv.zza(zzdo, (IInterface) zzaip);
        zzc(2, zzdo);
    }
}
