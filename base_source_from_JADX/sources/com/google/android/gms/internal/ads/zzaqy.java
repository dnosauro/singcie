package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaqy extends zzgu implements zzaqw {
    zzaqy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public final void zzc(Intent intent) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) intent);
        zzb(1, zzdo);
    }

    public final void zzc(IObjectWrapper iObjectWrapper, String str, String str2) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzb(2, zzdo);
    }

    public final void zzuz() {
        zzb(3, zzdo());
    }
}
