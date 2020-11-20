package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zzap;

public final class zzath extends zzgu implements zzatf {
    zzath(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    public final void zza(zzap zzap) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzap);
        zzb(2, zzdo);
    }

    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) parcelFileDescriptor);
        zzb(1, zzdo);
    }
}
