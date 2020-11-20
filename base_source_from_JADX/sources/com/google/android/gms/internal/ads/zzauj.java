package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzauj extends zzgu implements zzaug {
    zzauj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    public final void zza(zzauf zzauf, String str, String str2) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzauf);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzb(2, zzdo);
    }
}
