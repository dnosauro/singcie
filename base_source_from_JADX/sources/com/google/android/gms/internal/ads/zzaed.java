package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

public final class zzaed extends zzgu implements zzaeb {
    zzaed(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public final String getText() {
        Parcel zza = zza(2, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final List<zzaej> zzsm() {
        Parcel zza = zza(3, zzdo());
        ArrayList zzb = zzgv.zzb(zza);
        zza.recycle();
        return zzb;
    }
}
