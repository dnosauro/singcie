package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzap;

public abstract class zzate extends zzgw implements zzatf {
    public zzate() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zzb((ParcelFileDescriptor) zzgv.zza(parcel, ParcelFileDescriptor.CREATOR));
                break;
            case 2:
                zza((zzap) zzgv.zza(parcel, zzap.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
