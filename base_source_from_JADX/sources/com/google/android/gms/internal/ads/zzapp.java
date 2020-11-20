package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzapp extends zzgu implements zzapn {
    zzapp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    public final void zzdm(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(3, zzdo);
    }

    public final void zzf(zzve zzve) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzve);
        zzb(4, zzdo);
    }

    public final void zzuw() {
        zzb(2, zzdo());
    }
}
