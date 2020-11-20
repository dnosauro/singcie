package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class zzyv extends zzgu implements zzyt {
    zzyv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final void onVideoEnd() {
        zzb(4, zzdo());
    }

    public final void onVideoMute(boolean z) {
        Parcel zzdo = zzdo();
        zzgv.writeBoolean(zzdo, z);
        zzb(5, zzdo);
    }

    public final void onVideoPause() {
        zzb(3, zzdo());
    }

    public final void onVideoPlay() {
        zzb(2, zzdo());
    }

    public final void onVideoStart() {
        zzb(1, zzdo());
    }
}
