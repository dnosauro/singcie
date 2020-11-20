package com.google.android.gms.internal.ads;

import android.os.IBinder;

public final class zzwu extends zzgu implements zzws {
    zzwu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    public final void onAdClicked() {
        zzb(1, zzdo());
    }
}
