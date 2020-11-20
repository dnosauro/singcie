package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzata extends zzgu implements zzasy {
    zzata(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final zzasu zza(zzass zzass) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzass);
        Parcel zza = zza(1, zzdo);
        zzasu zzasu = (zzasu) zzgv.zza(zza, zzasu.CREATOR);
        zza.recycle();
        return zzasu;
    }

    public final void zza(zzass zzass, zzatd zzatd) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzass);
        zzgv.zza(zzdo, (IInterface) zzatd);
        zzb(2, zzdo);
    }

    public final void zza(zzatl zzatl, zzatf zzatf) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzatl);
        zzgv.zza(zzdo, (IInterface) zzatf);
        zzb(4, zzdo);
    }

    public final void zza(String str, zzatf zzatf) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzgv.zza(zzdo, (IInterface) zzatf);
        zzb(7, zzdo);
    }

    public final void zzb(zzatl zzatl, zzatf zzatf) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzatl);
        zzgv.zza(zzdo, (IInterface) zzatf);
        zzb(5, zzdo);
    }

    public final void zzc(zzatl zzatl, zzatf zzatf) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzatl);
        zzgv.zza(zzdo, (IInterface) zzatf);
        zzb(6, zzdo);
    }
}
