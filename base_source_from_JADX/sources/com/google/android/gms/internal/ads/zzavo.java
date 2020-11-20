package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class zzavo extends zzgw implements zzavp {
    public zzavo() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                onRewardedAdLoaded();
                break;
            case 2:
                onRewardedAdFailedToLoad(parcel.readInt());
                break;
            case 3:
                zzi((zzve) zzgv.zza(parcel, zzve.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
