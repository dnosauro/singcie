package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzxy extends zzgu implements zzxw {
    zzxy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    public final String getVersionString() {
        Parcel zza = zza(9, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void initialize() {
        zzb(1, zzdo());
    }

    public final void setAppMuted(boolean z) {
        Parcel zzdo = zzdo();
        zzgv.writeBoolean(zzdo, z);
        zzb(4, zzdo);
    }

    public final void setAppVolume(float f) {
        Parcel zzdo = zzdo();
        zzdo.writeFloat(f);
        zzb(2, zzdo);
    }

    public final void zza(zzaae zzaae) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzaae);
        zzb(14, zzdo);
    }

    public final void zza(zzajc zzajc) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzajc);
        zzb(12, zzdo);
    }

    public final void zza(zzani zzani) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzani);
        zzb(11, zzdo);
    }

    public final void zza(String str, IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(6, zzdo);
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzdo.writeString(str);
        zzb(5, zzdo);
    }

    public final void zzcd(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(3, zzdo);
    }

    public final void zzce(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(10, zzdo);
    }

    public final float zzqk() {
        Parcel zza = zza(7, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final boolean zzql() {
        Parcel zza = zza(8, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final List<zzaiz> zzqm() {
        Parcel zza = zza(13, zzdo());
        ArrayList<zzaiz> createTypedArrayList = zza.createTypedArrayList(zzaiz.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final void zzqn() {
        zzb(15, zzdo());
    }
}
