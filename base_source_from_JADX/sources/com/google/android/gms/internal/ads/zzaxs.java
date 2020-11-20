package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public final class zzaxs extends zzgu implements zzaxq {
    zzaxs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzaxw zzaxw, zzaxp zzaxp) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (Parcelable) zzaxw);
        zzgv.zza(zzdo, (IInterface) zzaxp);
        zzb(1, zzdo);
    }

    public final void zza(zzasl zzasl) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzasl);
        zzb(7, zzdo);
    }

    public final void zza(List<Uri> list, IObjectWrapper iObjectWrapper, zzasa zzasa) {
        Parcel zzdo = zzdo();
        zzdo.writeTypedList(list);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzasa);
        zzb(5, zzdo);
    }

    public final void zzan(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(2, zzdo);
    }

    public final IObjectWrapper zzao(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        Parcel zza = zza(4, zzdo);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper2);
        Parcel zza = zza(3, zzdo);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final void zzb(List<Uri> list, IObjectWrapper iObjectWrapper, zzasa zzasa) {
        Parcel zzdo = zzdo();
        zzdo.writeTypedList(list);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzasa);
        zzb(6, zzdo);
    }
}
