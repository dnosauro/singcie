package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

public abstract class zzyq extends zzgw implements zzyn {
    public zzyq() {
        super("com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public static zzyn zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        return queryLocalInterface instanceof zzyn ? (zzyn) queryLocalInterface : new zzyp(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        String str;
        switch (i) {
            case 1:
                str = getMediationAdapterClassName();
                break;
            case 2:
                str = getResponseId();
                break;
            case 3:
                List<zzvr> adapterResponses = getAdapterResponses();
                parcel2.writeNoException();
                parcel2.writeTypedList(adapterResponses);
                return true;
            default:
                return false;
        }
        parcel2.writeNoException();
        parcel2.writeString(str);
        return true;
    }
}
