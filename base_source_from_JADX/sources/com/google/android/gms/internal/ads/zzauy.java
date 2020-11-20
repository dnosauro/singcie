package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzauy extends zzgu implements zzauw {
    zzauy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzava zzava) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzgv.zza(zzdo, (Parcelable) zzava);
        zzb(7, zzdo);
    }

    public final void zzaf(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(1, zzdo);
    }

    public final void zzag(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(3, zzdo);
    }

    public final void zzah(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(4, zzdo);
    }

    public final void zzai(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(5, zzdo);
    }

    public final void zzaj(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(6, zzdo);
    }

    public final void zzak(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(8, zzdo);
    }

    public final void zzal(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(10, zzdo);
    }

    public final void zzam(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(11, zzdo);
    }

    public final void zzb(Bundle bundle) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) bundle);
        zzb(12, zzdo);
    }

    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzdo.writeInt(i);
        zzb(2, zzdo);
    }

    public final void zze(IObjectWrapper iObjectWrapper, int i) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzdo.writeInt(i);
        zzb(9, zzdo);
    }
}
