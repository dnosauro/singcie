package com.google.android.gms.internal.ads;

import android.os.IBinder;

public final class zzso extends zzgu implements zzsm {
    zzso(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
    }

    public final void onAppOpenAdClosed() {
        zzb(1, zzdo());
    }
}
