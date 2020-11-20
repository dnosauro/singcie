package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaep extends zzgu implements zzaen {
    zzaep(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public final void destroy() {
        zzb(4, zzdo());
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(3, zzdo);
    }

    public final void zza(zzaee zzaee) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzaee);
        zzb(8, zzdo);
    }

    public final void zzb(String str, IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(1, zzdo);
    }

    public final void zzc(IObjectWrapper iObjectWrapper, int i) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzdo.writeInt(i);
        zzb(5, zzdo);
    }

    public final IObjectWrapper zzco(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        Parcel zza = zza(2, zzdo);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(6, zzdo);
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(7, zzdo);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(9, zzdo);
    }
}
