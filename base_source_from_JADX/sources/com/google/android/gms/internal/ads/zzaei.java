package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzaei extends zzgw implements zzaej {
    public zzaei() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public static zzaej zzo(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
        return queryLocalInterface instanceof zzaej ? (zzaej) queryLocalInterface : new zzael(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        int i3;
        switch (i) {
            case 1:
                IObjectWrapper zzsr = zzsr();
                parcel2.writeNoException();
                zzgv.zza(parcel2, (IInterface) zzsr);
                return true;
            case 2:
                Uri uri = getUri();
                parcel2.writeNoException();
                zzgv.zzb(parcel2, uri);
                return true;
            case 3:
                double scale = getScale();
                parcel2.writeNoException();
                parcel2.writeDouble(scale);
                return true;
            case 4:
                i3 = getWidth();
                break;
            case 5:
                i3 = getHeight();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        parcel2.writeInt(i3);
        return true;
    }
}
