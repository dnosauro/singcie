package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzsi extends zzgu implements zzsg {
    zzsi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzsq zzsq) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzsq);
        zzb(4, zzdo);
    }

    public final void zza(zzsm zzsm) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzsm);
        zzb(3, zzdo);
    }

    public final zzxg zzdx() {
        Parcel zza = zza(2, zzdo());
        zzxg zzc = zzxf.zzc(zza.readStrongBinder());
        zza.recycle();
        return zzc;
    }

    public final zzyn zzkh() {
        Parcel zza = zza(5, zzdo());
        zzyn zzj = zzyq.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }
}
