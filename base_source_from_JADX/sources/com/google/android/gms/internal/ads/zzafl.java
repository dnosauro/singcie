package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzafl extends zzgu implements zzafj {
    zzafl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    public final void zza(zzaex zzaex) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzaex);
        zzb(1, zzdo);
    }
}
