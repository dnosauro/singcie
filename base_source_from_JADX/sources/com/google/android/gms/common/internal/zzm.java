package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;

public final class zzm extends zzb implements zzl {
    zzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    public final IObjectWrapper zzb() {
        Parcel zza = zza(1, mo17030a_());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final int zzc() {
        Parcel zza = zza(2, mo17030a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }
}
