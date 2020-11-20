package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzaqz extends zzgw implements zzaqw {
    public zzaqz() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzaqw zzag(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        return queryLocalInterface instanceof zzaqw ? (zzaqw) queryLocalInterface : new zzaqy(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zzc((Intent) zzgv.zza(parcel, Intent.CREATOR));
                break;
            case 2:
                zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                break;
            case 3:
                zzuz();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
