package com.google.android.gms.ads.internal.util;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzgu;
import com.google.android.gms.internal.ads.zzgv;

public final class zzbh extends zzgu implements zzbf {
    zzbh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    public final void zzap(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(2, zzdo);
    }

    public final boolean zzd(IObjectWrapper iObjectWrapper, String str, String str2) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        Parcel zza = zza(1, zzdo);
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }
}
