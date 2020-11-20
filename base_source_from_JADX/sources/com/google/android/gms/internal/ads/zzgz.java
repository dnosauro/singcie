package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzgz extends zzgu implements zzgy {
    zzgz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    public final void log() {
        zzb(3, zzdo());
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzdo.writeString(str);
        zzb(2, zzdo);
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, String str2) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzdo.writeString(str);
        zzdo.writeString((String) null);
        zzb(8, zzdo);
    }

    public final void zza(int[] iArr) {
        Parcel zzdo = zzdo();
        zzdo.writeIntArray((int[]) null);
        zzb(4, zzdo);
    }

    public final void zzc(byte[] bArr) {
        Parcel zzdo = zzdo();
        zzdo.writeByteArray(bArr);
        zzb(5, zzdo);
    }

    public final void zzs(int i) {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i);
        zzb(6, zzdo);
    }

    public final void zzt(int i) {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i);
        zzb(7, zzdo);
    }
}
