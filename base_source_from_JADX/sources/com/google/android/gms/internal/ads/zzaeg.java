package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaeg extends zzgu implements zzaee {
    zzaeg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    public final float getAspectRatio() {
        Parcel zza = zza(2, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getCurrentTime() {
        Parcel zza = zza(6, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getDuration() {
        Parcel zza = zza(5, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final zzys getVideoController() {
        Parcel zza = zza(7, zzdo());
        zzys zzk = zzyr.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    public final boolean hasVideoContent() {
        Parcel zza = zza(8, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zza(zzafv zzafv) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzafv);
        zzb(9, zzdo);
    }

    public final void zzo(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(3, zzdo);
    }

    public final IObjectWrapper zzsu() {
        Parcel zza = zza(4, zzdo());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }
}
