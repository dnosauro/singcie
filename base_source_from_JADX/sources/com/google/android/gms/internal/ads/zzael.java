package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzael extends zzgu implements zzaej {
    zzael(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public final int getHeight() {
        Parcel zza = zza(5, zzdo());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final double getScale() {
        Parcel zza = zza(3, zzdo());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    public final Uri getUri() {
        Parcel zza = zza(2, zzdo());
        Uri uri = (Uri) zzgv.zza(zza, Uri.CREATOR);
        zza.recycle();
        return uri;
    }

    public final int getWidth() {
        Parcel zza = zza(4, zzdo());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final IObjectWrapper zzsr() {
        Parcel zza = zza(1, zzdo());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }
}
