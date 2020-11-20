package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzwv extends zzgu implements zzwt {
    zzwv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final void onAdClicked() {
        zzb(6, zzdo());
    }

    public final void onAdClosed() {
        zzb(1, zzdo());
    }

    public final void onAdFailedToLoad(int i) {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i);
        zzb(2, zzdo);
    }

    public final void onAdImpression() {
        zzb(7, zzdo());
    }

    public final void onAdLeftApplication() {
        zzb(3, zzdo());
    }

    public final void onAdLoaded() {
        zzb(4, zzdo());
    }

    public final void onAdOpened() {
        zzb(5, zzdo());
    }

    public final void zzc(zzve zzve) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzve);
        zzb(8, zzdo);
    }
}
