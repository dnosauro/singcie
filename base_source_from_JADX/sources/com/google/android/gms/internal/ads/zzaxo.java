package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;

public abstract class zzaxo extends zzgw implements zzaxp {
    public zzaxo() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zzk(parcel.readString(), parcel.readString());
                break;
            case 2:
                onError(parcel.readString());
                break;
            case 3:
                zza(parcel.readString(), parcel.readString(), (Bundle) zzgv.zza(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
