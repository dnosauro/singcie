package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class zzajr extends zzgw implements zzajo {
    public zzajr() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zztn();
                break;
            case 2:
                zzdb(parcel.readInt());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
