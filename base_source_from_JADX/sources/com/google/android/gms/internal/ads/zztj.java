package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class zztj extends zzgu implements zztg {
    zztj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zzta zza(zztf zztf) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zztf);
        Parcel zza = zza(1, zzdo);
        zzta zzta = (zzta) zzgv.zza(zza, zzta.CREATOR);
        zza.recycle();
        return zzta;
    }

    public final long zzb(zztf zztf) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zztf);
        Parcel zza = zza(3, zzdo);
        long readLong = zza.readLong();
        zza.recycle();
        return readLong;
    }

    public final zzta zzc(zztf zztf) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zztf);
        Parcel zza = zza(2, zzdo);
        zzta zzta = (zzta) zzgv.zza(zza, zzta.CREATOR);
        zza.recycle();
        return zzta;
    }
}
