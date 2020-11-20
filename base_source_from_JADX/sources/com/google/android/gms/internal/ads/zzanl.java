package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class zzanl extends zzgw implements zzani {
    public zzanl() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzani zzac(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return queryLocalInterface instanceof zzani ? (zzani) queryLocalInterface : new zzank(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface iInterface;
        switch (i) {
            case 1:
                iInterface = zzde(parcel.readString());
                break;
            case 2:
                boolean zzdf = zzdf(parcel.readString());
                parcel2.writeNoException();
                zzgv.writeBoolean(parcel2, zzdf);
                return true;
            case 3:
                iInterface = zzdg(parcel.readString());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        zzgv.zza(parcel2, iInterface);
        return true;
    }
}
