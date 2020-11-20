package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzdsf extends zzgu implements zzdse {
    zzdsf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    public final String getVersion() {
        Parcel zza = zza(6, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final IObjectWrapper zza(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzdo.writeString(str2);
        zzdo.writeString(str3);
        zzdo.writeString(str4);
        zzdo.writeString(str5);
        Parcel zza = zza(9, zzdo);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final IObjectWrapper zza(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzdo.writeString(str2);
        zzdo.writeString(str3);
        zzdo.writeString(str4);
        zzdo.writeString(str5);
        zzdo.writeString(str6);
        zzdo.writeString(str7);
        zzdo.writeString(str8);
        Parcel zza = zza(10, zzdo);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final void zzab(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(4, zzdo);
    }

    public final void zzac(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(7, zzdo);
    }

    public final boolean zzav(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        Parcel zza = zza(2, zzdo);
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final IObjectWrapper zzb(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzdo.writeString(str2);
        zzdo.writeString(str3);
        zzdo.writeString(str4);
        zzdo.writeString(str5);
        zzdo.writeString(str6);
        zzdo.writeString(str7);
        zzdo.writeString(str8);
        Parcel zza = zza(11, zzdo);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper2);
        zzb(5, zzdo);
    }

    public final void zzd(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper2);
        zzb(8, zzdo);
    }
}
