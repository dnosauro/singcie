package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzacd extends zzgu implements zzacb {
    zzacd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    public final void zza(zzabw zzabw) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzabw);
        zzb(1, zzdo);
    }
}
