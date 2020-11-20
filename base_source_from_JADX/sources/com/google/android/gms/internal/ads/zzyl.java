package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class zzyl extends zzgw implements zzym {
    public zzyl() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzym zzi(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        return queryLocalInterface instanceof zzym ? (zzym) queryLocalInterface : new zzyo(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zza((zzvp) zzgv.zza(parcel, zzvp.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
