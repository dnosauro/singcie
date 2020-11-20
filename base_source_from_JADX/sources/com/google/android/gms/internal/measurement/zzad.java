package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzad extends zza implements zzab {
    zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final int zza() {
        Parcel zza = zza(2, mo17056a_());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        Parcel a_ = mo17056a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, (Parcelable) bundle);
        a_.writeLong(j);
        zzb(1, a_);
    }
}
