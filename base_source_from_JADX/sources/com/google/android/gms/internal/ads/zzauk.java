package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzauk extends zzgu implements zzaui {
    zzauk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public final void destroy() {
        zzb(8, zzdo());
    }

    public final Bundle getAdMetadata() {
        Parcel zza = zza(15, zzdo());
        Bundle bundle = (Bundle) zzgv.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final String getMediationAdapterClassName() {
        Parcel zza = zza(12, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final boolean isLoaded() {
        Parcel zza = zza(5, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void pause() {
        zzb(6, zzdo());
    }

    public final void resume() {
        zzb(7, zzdo());
    }

    public final void setAppPackageName(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(17, zzdo);
    }

    public final void setCustomData(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(19, zzdo);
    }

    public final void setImmersiveMode(boolean z) {
        Parcel zzdo = zzdo();
        zzgv.writeBoolean(zzdo, z);
        zzb(34, zzdo);
    }

    public final void setUserId(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(13, zzdo);
    }

    public final void show() {
        zzb(2, zzdo());
    }

    public final void zza(zzaug zzaug) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzaug);
        zzb(16, zzdo);
    }

    public final void zza(zzaup zzaup) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzaup);
        zzb(3, zzdo);
    }

    public final void zza(zzauv zzauv) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzauv);
        zzb(1, zzdo);
    }

    public final void zza(zzxj zzxj) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzxj);
        zzb(14, zzdo);
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(18, zzdo);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(9, zzdo);
    }

    public final void zzk(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(10, zzdo);
    }

    public final zzyn zzkh() {
        Parcel zza = zza(21, zzdo());
        zzyn zzj = zzyq.zzj(zza.readStrongBinder());
        zza.recycle();
        return zzj;
    }

    public final void zzl(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(11, zzdo);
    }

    public final boolean zzrf() {
        Parcel zza = zza(20, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }
}
