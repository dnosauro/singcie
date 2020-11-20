package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzss extends zzgu implements zzsq {
    zzss(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    public final void onAdDismissedFullScreenContent() {
        zzb(2, zzdo());
    }

    public final void onAdShowedFullScreenContent() {
        zzb(1, zzdo());
    }

    public final void zzb(zzve zzve) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzve);
        zzb(3, zzdo);
    }
}
