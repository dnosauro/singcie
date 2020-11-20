package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzaur extends zzgu implements zzaup {
    zzaur(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public final void onRewardedVideoAdClosed() {
        zzb(4, zzdo());
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i);
        zzb(7, zzdo);
    }

    public final void onRewardedVideoAdLeftApplication() {
        zzb(6, zzdo());
    }

    public final void onRewardedVideoAdLoaded() {
        zzb(1, zzdo());
    }

    public final void onRewardedVideoAdOpened() {
        zzb(2, zzdo());
    }

    public final void onRewardedVideoCompleted() {
        zzb(8, zzdo());
    }

    public final void onRewardedVideoStarted() {
        zzb(3, zzdo());
    }

    public final void zza(zzauf zzauf) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzauf);
        zzb(5, zzdo);
    }
}
