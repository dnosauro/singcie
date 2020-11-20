package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzxa extends zzgu implements zzwy {
    zzxa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final String getMediationAdapterClassName() {
        Parcel zza = zza(2, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final boolean isLoading() {
        Parcel zza = zza(3, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zza(zzvk zzvk, int i) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzdo.writeInt(i);
        zzb(5, zzdo);
    }

    public final void zzb(zzvk zzvk) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzb(1, zzdo);
    }

    public final String zzkg() {
        Parcel zza = zza(4, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }
}
