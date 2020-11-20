package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

public final class zzaod extends zzgu implements zzaob {
    zzaod(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public final String getAdvertiser() {
        Parcel zza = zza(7, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final String getBody() {
        Parcel zza = zza(4, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final String getCallToAction() {
        Parcel zza = zza(6, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final Bundle getExtras() {
        Parcel zza = zza(16, zzdo());
        Bundle bundle = (Bundle) zzgv.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final String getHeadline() {
        Parcel zza = zza(2, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final List getImages() {
        Parcel zza = zza(3, zzdo());
        ArrayList zzb = zzgv.zzb(zza);
        zza.recycle();
        return zzb;
    }

    public final float getMediaContentAspectRatio() {
        Parcel zza = zza(23, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final boolean getOverrideClickHandling() {
        Parcel zza = zza(18, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean getOverrideImpressionRecording() {
        Parcel zza = zza(17, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final String getPrice() {
        Parcel zza = zza(10, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final double getStarRating() {
        Parcel zza = zza(8, zzdo());
        double readDouble = zza.readDouble();
        zza.recycle();
        return readDouble;
    }

    public final String getStore() {
        Parcel zza = zza(9, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final zzys getVideoController() {
        Parcel zza = zza(11, zzdo());
        zzys zzk = zzyr.zzk(zza.readStrongBinder());
        zza.recycle();
        return zzk;
    }

    public final float getVideoCurrentTime() {
        Parcel zza = zza(25, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getVideoDuration() {
        Parcel zza = zza(24, zzdo());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final void recordImpression() {
        zzb(19, zzdo());
    }

    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper2);
        zzgv.zza(zzdo, (IInterface) iObjectWrapper3);
        zzb(21, zzdo);
    }

    public final zzaej zzsw() {
        Parcel zza = zza(5, zzdo());
        zzaej zzo = zzaei.zzo(zza.readStrongBinder());
        zza.recycle();
        return zzo;
    }

    public final zzaeb zzsx() {
        Parcel zza = zza(12, zzdo());
        zzaeb zzm = zzaea.zzm(zza.readStrongBinder());
        zza.recycle();
        return zzm;
    }

    public final IObjectWrapper zzsy() {
        Parcel zza = zza(15, zzdo());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final void zzu(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(20, zzdo);
    }

    public final IObjectWrapper zzup() {
        Parcel zza = zza(13, zzdo());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzuq() {
        Parcel zza = zza(14, zzdo());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
        zza.recycle();
        return asInterface;
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(22, zzdo);
    }
}
