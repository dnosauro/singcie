package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzavk extends zzgu implements zzavi {
    zzavk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    public final void onRewardedAdClosed() {
        zzb(2, zzdo());
    }

    public final void onRewardedAdFailedToShow(int i) {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i);
        zzb(4, zzdo);
    }

    public final void onRewardedAdOpened() {
        zzb(1, zzdo());
    }

    public final void zza(zzavc zzavc) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzavc);
        zzb(3, zzdo);
    }

    public final void zzh(zzve zzve) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzve);
        zzb(5, zzdo);
    }
}
