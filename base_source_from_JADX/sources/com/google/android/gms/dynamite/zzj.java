package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzd;

public final class zzj extends zzb implements zzk {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int zza(IObjectWrapper iObjectWrapper, String str, boolean z) {
        Parcel a_ = mo17030a_();
        zzd.zza(a_, (IInterface) iObjectWrapper);
        a_.writeString(str);
        zzd.zza(a_, z);
        Parcel zza = zza(3, a_);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i) {
        Parcel a_ = mo17030a_();
        zzd.zza(a_, (IInterface) iObjectWrapper);
        a_.writeString(str);
        a_.writeInt(i);
        Parcel zza = zza(2, a_);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final int zzb() {
        Parcel zza = zza(6, mo17030a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final int zzb(IObjectWrapper iObjectWrapper, String str, boolean z) {
        Parcel a_ = mo17030a_();
        zzd.zza(a_, (IInterface) iObjectWrapper);
        a_.writeString(str);
        zzd.zza(a_, z);
        Parcel zza = zza(5, a_);
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, String str, int i) {
        Parcel a_ = mo17030a_();
        zzd.zza(a_, (IInterface) iObjectWrapper);
        a_.writeString(str);
        a_.writeInt(i);
        Parcel zza = zza(4, a_);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }
}
