package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzdty extends zzgu implements zzdtv {
    zzdty(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzdtt zza(zzdtr zzdtr) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzdtr);
        Parcel zza = zza(1, zzdo);
        zzdtt zzdtt = (zzdtt) zzgv.zza(zza, zzdtt.CREATOR);
        zza.recycle();
        return zzdtt;
    }

    public final zzdud zza(zzdub zzdub) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzdub);
        Parcel zza = zza(3, zzdo);
        zzdud zzdud = (zzdud) zzgv.zza(zza, zzdud.CREATOR);
        zza.recycle();
        return zzdud;
    }

    public final void zza(zzdtq zzdtq) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzdtq);
        zzb(2, zzdo);
    }
}
