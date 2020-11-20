package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class zzaps extends zzgw implements zzapt {
    public zzaps() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zzdo(parcel.readString());
                break;
            case 2:
                onFailure(parcel.readString());
                break;
            case 3:
                zzg((zzve) zzgv.zza(parcel, zzve.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
