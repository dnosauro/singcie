package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzafr extends zzgu implements zzafp {
    zzafr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public final void zza(zzaff zzaff, String str) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzaff);
        zzdo.writeString(str);
        zzb(1, zzdo);
    }
}
