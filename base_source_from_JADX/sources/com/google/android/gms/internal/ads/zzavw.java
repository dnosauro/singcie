package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

final /* synthetic */ class zzavw implements zzazc {
    static final zzazc zzbxv = new zzavw();

    private zzavw() {
    }

    public final Object apply(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        return queryLocalInterface instanceof zzavn ? (zzavn) queryLocalInterface : new zzavm(iBinder);
    }
}
