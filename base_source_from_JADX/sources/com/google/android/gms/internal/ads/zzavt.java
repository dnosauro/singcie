package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzavt extends zzgu implements zzavq {
    zzavt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    public final void zza(zzavc zzavc, String str, String str2) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzavc);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzb(2, zzdo);
    }
}
