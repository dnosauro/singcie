package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class zzst extends zzgw implements zzsq {
    public zzst() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                onAdShowedFullScreenContent();
                break;
            case 2:
                onAdDismissedFullScreenContent();
                break;
            case 3:
                zzb((zzve) zzgv.zza(parcel, zzve.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
