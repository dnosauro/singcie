package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class zzagh extends zzgw implements zzage {
    public zzagh() {
        super("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                onUnconfirmedClickReceived(parcel.readString());
                break;
            case 2:
                onUnconfirmedClickCancelled();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
