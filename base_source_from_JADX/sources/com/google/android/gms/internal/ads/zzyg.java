package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class zzyg extends zzgw implements zzyd {
    public zzyg() {
        super("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public static zzyd zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMuteThisAdReason");
        return queryLocalInterface instanceof zzyd ? (zzyd) queryLocalInterface : new zzyf(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        String str;
        switch (i) {
            case 1:
                str = getDescription();
                break;
            case 2:
                str = zzqo();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        parcel2.writeString(str);
        return true;
    }
}
