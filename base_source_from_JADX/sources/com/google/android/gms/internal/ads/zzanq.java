package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public final class zzanq extends zzgu implements zzano {
    zzanq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public final void onAdClicked() {
        zzb(1, zzdo());
    }

    public final void onAdClosed() {
        zzb(2, zzdo());
    }

    public final void onAdFailedToLoad(int i) {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i);
        zzb(3, zzdo);
    }

    public final void onAdImpression() {
        zzb(8, zzdo());
    }

    public final void onAdLeftApplication() {
        zzb(4, zzdo());
    }

    public final void onAdLoaded() {
        zzb(6, zzdo());
    }

    public final void onAdOpened() {
        zzb(5, zzdo());
    }

    public final void onAppEvent(String str, String str2) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzdo.writeString(str2);
        zzb(9, zzdo);
    }

    public final void onVideoEnd() {
        zzb(11, zzdo());
    }

    public final void onVideoPause() {
        zzb(15, zzdo());
    }

    public final void onVideoPlay() {
        zzb(20, zzdo());
    }

    public final void zza(zzaff zzaff, String str) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzaff);
        zzdo.writeString(str);
        zzb(10, zzdo);
    }

    public final void zza(zzant zzant) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzant);
        zzb(7, zzdo);
    }

    public final void zza(zzavc zzavc) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) zzavc);
        zzb(16, zzdo);
    }

    public final void zzb(Bundle bundle) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) bundle);
        zzb(19, zzdo);
    }

    public final void zzb(zzava zzava) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzava);
        zzb(14, zzdo);
    }

    public final void zzc(int i, String str) {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i);
        zzdo.writeString(str);
        zzb(22, zzdo);
    }

    public final void zzc(zzve zzve) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzve);
        zzb(23, zzdo);
    }

    public final void zzdc(int i) {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i);
        zzb(17, zzdo);
    }

    public final void zzdj(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(12, zzdo);
    }

    public final void zzdk(String str) {
        Parcel zzdo = zzdo();
        zzdo.writeString(str);
        zzb(21, zzdo);
    }

    public final void zze(zzve zzve) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) zzve);
        zzb(24, zzdo);
    }

    public final void zzun() {
        zzb(13, zzdo());
    }

    public final void zzuo() {
        zzb(18, zzdo());
    }
}
