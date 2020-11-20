package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzapk extends zzgu implements zzapi {
    zzapk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    public final void zza(zzaob zzaob) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzaob);
        zzb(1, zzdo);
    }

    public final void zzdm(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(2, zzdo);
    }

    public final void zzf(zzve zzve) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzve);
        zzb(3, zzdo);
    }
}
