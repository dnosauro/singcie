package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzapq extends zzgu implements zzapo {
    zzapq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final zzys getVideoController() {
        Parcel zza = zza(5, zzdo());
        zzys zzk = zzyr.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvn zzvn, zzapt zzapt) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzdo.writeString(str);
        zzgv.zza(zzdo, (Parcelable) bundle);
        zzgv.zza(zzdo, (Parcelable) bundle2);
        zzgv.zza(zzdo, (Parcelable) zzvn);
        zzgv.zza(zzdo, (IInterface) zzapt);
        zzb(1, zzdo);
    }

    public final void zza(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzapc zzapc, zzano zzano, zzvn zzvn) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzapc);
        zzgv.zza(zzdo, (IInterface) zzano);
        zzgv.zza(zzdo, (Parcelable) zzvn);
        zzb(13, zzdo);
    }

    public final void zza(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzaph zzaph, zzano zzano) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzaph);
        zzgv.zza(zzdo, (IInterface) zzano);
        zzb(14, zzdo);
    }

    public final void zza(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzapi zzapi, zzano zzano) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzapi);
        zzgv.zza(zzdo, (IInterface) zzano);
        zzb(18, zzdo);
    }

    public final void zza(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzapn zzapn, zzano zzano) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzapn);
        zzgv.zza(zzdo, (IInterface) zzano);
        zzb(16, zzdo);
    }

    public final void zza(String[] strArr, Bundle[] bundleArr) {
        Parcel zzdo = zzdo();
        zzdo.writeStringArray(strArr);
        zzdo.writeTypedArray(bundleArr, 0);
        zzb(11, zzdo);
    }

    public final boolean zzaa(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        Parcel zza = zza(17, zzdo);
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void zzb(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzapn zzapn, zzano zzano) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzgv.zza(zzdo, (Parcelable) zzvk);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) zzapn);
        zzgv.zza(zzdo, (IInterface) zzano);
        zzb(20, zzdo);
    }

    public final void zzdn(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(19, zzdo);
    }

    public final zzaqc zzul() {
        Parcel zza = zza(2, zzdo());
        zzaqc zzaqc = (zzaqc) zzgv.zza(zza, zzaqc.CREATOR);
        zza.recycle();
        return zzaqc;
    }

    public final zzaqc zzum() {
        Parcel zza = zza(3, zzdo());
        zzaqc zzaqc = (zzaqc) zzgv.zza(zza, zzaqc.CREATOR);
        zza.recycle();
        return zzaqc;
    }

    public final void zzy(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(10, zzdo);
    }

    public final boolean zzz(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        Parcel zza = zza(15, zzdo);
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }
}
