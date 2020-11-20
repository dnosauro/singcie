package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzb;
import java.util.ArrayList;
import java.util.List;

public final class zzer extends zza implements zzep {
    zzer(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final List<zzkw> zza(zzn zzn, boolean z) {
        Parcel a_ = mo17056a_();
        zzb.zza(a_, (Parcelable) zzn);
        zzb.zza(a_, z);
        Parcel zza = zza(7, a_);
        ArrayList<zzkw> createTypedArrayList = zza.createTypedArrayList(zzkw.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzw> zza(String str, String str2, zzn zzn) {
        Parcel a_ = mo17056a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, (Parcelable) zzn);
        Parcel zza = zza(16, a_);
        ArrayList<zzw> createTypedArrayList = zza.createTypedArrayList(zzw.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzw> zza(String str, String str2, String str3) {
        Parcel a_ = mo17056a_();
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        Parcel zza = zza(17, a_);
        ArrayList<zzw> createTypedArrayList = zza.createTypedArrayList(zzw.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzkw> zza(String str, String str2, String str3, boolean z) {
        Parcel a_ = mo17056a_();
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        zzb.zza(a_, z);
        Parcel zza = zza(15, a_);
        ArrayList<zzkw> createTypedArrayList = zza.createTypedArrayList(zzkw.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzkw> zza(String str, String str2, boolean z, zzn zzn) {
        Parcel a_ = mo17056a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzb.zza(a_, z);
        zzb.zza(a_, (Parcelable) zzn);
        Parcel zza = zza(14, a_);
        ArrayList<zzkw> createTypedArrayList = zza.createTypedArrayList(zzkw.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final void zza(long j, String str, String str2, String str3) {
        Parcel a_ = mo17056a_();
        a_.writeLong(j);
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        zzb(10, a_);
    }

    public final void zza(Bundle bundle, zzn zzn) {
        Parcel a_ = mo17056a_();
        zzb.zza(a_, (Parcelable) bundle);
        zzb.zza(a_, (Parcelable) zzn);
        zzb(19, a_);
    }

    public final void zza(zzar zzar, zzn zzn) {
        Parcel a_ = mo17056a_();
        zzb.zza(a_, (Parcelable) zzar);
        zzb.zza(a_, (Parcelable) zzn);
        zzb(1, a_);
    }

    public final void zza(zzar zzar, String str, String str2) {
        Parcel a_ = mo17056a_();
        zzb.zza(a_, (Parcelable) zzar);
        a_.writeString(str);
        a_.writeString(str2);
        zzb(5, a_);
    }

    public final void zza(zzkw zzkw, zzn zzn) {
        Parcel a_ = mo17056a_();
        zzb.zza(a_, (Parcelable) zzkw);
        zzb.zza(a_, (Parcelable) zzn);
        zzb(2, a_);
    }

    public final void zza(zzn zzn) {
        Parcel a_ = mo17056a_();
        zzb.zza(a_, (Parcelable) zzn);
        zzb(4, a_);
    }

    public final void zza(zzw zzw) {
        Parcel a_ = mo17056a_();
        zzb.zza(a_, (Parcelable) zzw);
        zzb(13, a_);
    }

    public final void zza(zzw zzw, zzn zzn) {
        Parcel a_ = mo17056a_();
        zzb.zza(a_, (Parcelable) zzw);
        zzb.zza(a_, (Parcelable) zzn);
        zzb(12, a_);
    }

    public final byte[] zza(zzar zzar, String str) {
        Parcel a_ = mo17056a_();
        zzb.zza(a_, (Parcelable) zzar);
        a_.writeString(str);
        Parcel zza = zza(9, a_);
        byte[] createByteArray = zza.createByteArray();
        zza.recycle();
        return createByteArray;
    }

    public final void zzb(zzn zzn) {
        Parcel a_ = mo17056a_();
        zzb.zza(a_, (Parcelable) zzn);
        zzb(6, a_);
    }

    public final String zzc(zzn zzn) {
        Parcel a_ = mo17056a_();
        zzb.zza(a_, (Parcelable) zzn);
        Parcel zza = zza(11, a_);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zzd(zzn zzn) {
        Parcel a_ = mo17056a_();
        zzb.zza(a_, (Parcelable) zzn);
        zzb(18, a_);
    }

    public final void zze(zzn zzn) {
        Parcel a_ = mo17056a_();
        zzb.zza(a_, (Parcelable) zzn);
        zzb(20, a_);
    }
}
