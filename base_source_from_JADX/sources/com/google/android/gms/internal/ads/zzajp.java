package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzajp extends zzgu implements zzajn {
    zzajp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    public final void destroy() {
        zzb(4, zzdo());
    }

    public final zzys getVideoController() {
        Parcel zza = zza(3, zzdo());
        zzys zzk = zzyr.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzajo zzajo) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzajo);
        zzb(5, zzdo);
    }

    public final void zzr(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(6, zzdo);
    }

    public final zzaee zzth() {
        Parcel zza = zza(7, zzdo());
        zzaee zzn = zzaeh.zzn(zza.readStrongBinder());
        zza.recycle();
        return zzn;
    }
}
