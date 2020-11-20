package com.google.android.gms.internal.ads;

import android.os.IBinder;

public final class zzxl extends zzgu implements zzxj {
    zzxl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdMetadataListener");
    }

    public final void onAdMetadataChanged() {
        zzb(1, zzdo());
    }
}
