package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzagy;
import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzbdv;
import com.google.android.gms.internal.ads.zzva;

@SafeParcelable.Class(creator = "AdOverlayInfoCreator")
@SafeParcelable.Reserved({1})
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzn();
    @SafeParcelable.Field(mo11699id = 11)
    public final int orientation;
    @SafeParcelable.Field(mo11699id = 13)
    public final String url;
    @SafeParcelable.Field(mo11699id = 14)
    public final zzazh zzbpd;
    @SafeParcelable.Field(getter = "getAdClickListenerAsBinder", mo11699id = 3, type = "android.os.IBinder")
    public final zzva zzcgp;
    @SafeParcelable.Field(getter = "getAdMetadataGmsgListenerAsBinder", mo11699id = 18, type = "android.os.IBinder")
    public final zzagy zzdfr;
    @SafeParcelable.Field(getter = "getAppEventGmsgListenerAsBinder", mo11699id = 6, type = "android.os.IBinder")
    public final zzaha zzdfs;
    @SafeParcelable.Field(getter = "getAdWebViewAsBinder", mo11699id = 5, type = "android.os.IBinder")
    public final zzbdv zzdii;
    @SafeParcelable.Field(mo11699id = 2)
    public final zzb zzdrl;
    @SafeParcelable.Field(getter = "getAdOverlayListenerAsBinder", mo11699id = 4, type = "android.os.IBinder")
    public final zzp zzdrm;
    @SafeParcelable.Field(mo11699id = 7)
    public final String zzdrn;
    @SafeParcelable.Field(mo11699id = 8)
    public final boolean zzdro;
    @SafeParcelable.Field(mo11699id = 9)
    public final String zzdrp;
    @SafeParcelable.Field(getter = "getLeaveApplicationListenerAsBinder", mo11699id = 10, type = "android.os.IBinder")
    public final zzu zzdrq;
    @SafeParcelable.Field(mo11699id = 12)
    public final int zzdrr;
    @SafeParcelable.Field(mo11699id = 16)
    public final String zzdrs;
    @SafeParcelable.Field(mo11699id = 17)
    public final zzi zzdrt;

    @SafeParcelable.Constructor
    AdOverlayInfoParcel(@SafeParcelable.Param(mo11702id = 2) zzb zzb, @SafeParcelable.Param(mo11702id = 3) IBinder iBinder, @SafeParcelable.Param(mo11702id = 4) IBinder iBinder2, @SafeParcelable.Param(mo11702id = 5) IBinder iBinder3, @SafeParcelable.Param(mo11702id = 6) IBinder iBinder4, @SafeParcelable.Param(mo11702id = 7) String str, @SafeParcelable.Param(mo11702id = 8) boolean z, @SafeParcelable.Param(mo11702id = 9) String str2, @SafeParcelable.Param(mo11702id = 10) IBinder iBinder5, @SafeParcelable.Param(mo11702id = 11) int i, @SafeParcelable.Param(mo11702id = 12) int i2, @SafeParcelable.Param(mo11702id = 13) String str3, @SafeParcelable.Param(mo11702id = 14) zzazh zzazh, @SafeParcelable.Param(mo11702id = 16) String str4, @SafeParcelable.Param(mo11702id = 17) zzi zzi, @SafeParcelable.Param(mo11702id = 18) IBinder iBinder6) {
        this.zzdrl = zzb;
        this.zzcgp = (zzva) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzdrm = (zzp) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzdii = (zzbdv) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzdfr = (zzagy) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zzdfs = (zzaha) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzdrn = str;
        this.zzdro = z;
        this.zzdrp = str2;
        this.zzdrq = (zzu) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.orientation = i;
        this.zzdrr = i2;
        this.url = str3;
        this.zzbpd = zzazh;
        this.zzdrs = str4;
        this.zzdrt = zzi;
    }

    public AdOverlayInfoParcel(zzb zzb, zzva zzva, zzp zzp, zzu zzu, zzazh zzazh) {
        this.zzdrl = zzb;
        this.zzcgp = zzva;
        this.zzdrm = zzp;
        this.zzdii = null;
        this.zzdfr = null;
        this.zzdfs = null;
        this.zzdrn = null;
        this.zzdro = false;
        this.zzdrp = null;
        this.zzdrq = zzu;
        this.orientation = -1;
        this.zzdrr = 4;
        this.url = null;
        this.zzbpd = zzazh;
        this.zzdrs = null;
        this.zzdrt = null;
    }

    public AdOverlayInfoParcel(zzva zzva, zzp zzp, zzu zzu, zzbdv zzbdv, int i, zzazh zzazh, String str, zzi zzi, String str2, String str3) {
        this.zzdrl = null;
        this.zzcgp = null;
        this.zzdrm = zzp;
        this.zzdii = zzbdv;
        this.zzdfr = null;
        this.zzdfs = null;
        this.zzdrn = str2;
        this.zzdro = false;
        this.zzdrp = str3;
        this.zzdrq = null;
        this.orientation = i;
        this.zzdrr = 1;
        this.url = null;
        this.zzbpd = zzazh;
        this.zzdrs = str;
        this.zzdrt = zzi;
    }

    public AdOverlayInfoParcel(zzva zzva, zzp zzp, zzu zzu, zzbdv zzbdv, boolean z, int i, zzazh zzazh) {
        this.zzdrl = null;
        this.zzcgp = zzva;
        this.zzdrm = zzp;
        this.zzdii = zzbdv;
        this.zzdfr = null;
        this.zzdfs = null;
        this.zzdrn = null;
        this.zzdro = z;
        this.zzdrp = null;
        this.zzdrq = zzu;
        this.orientation = i;
        this.zzdrr = 2;
        this.url = null;
        this.zzbpd = zzazh;
        this.zzdrs = null;
        this.zzdrt = null;
    }

    public AdOverlayInfoParcel(zzva zzva, zzp zzp, zzagy zzagy, zzaha zzaha, zzu zzu, zzbdv zzbdv, boolean z, int i, String str, zzazh zzazh) {
        this.zzdrl = null;
        this.zzcgp = zzva;
        this.zzdrm = zzp;
        this.zzdii = zzbdv;
        this.zzdfr = zzagy;
        this.zzdfs = zzaha;
        this.zzdrn = null;
        this.zzdro = z;
        this.zzdrp = null;
        this.zzdrq = zzu;
        this.orientation = i;
        this.zzdrr = 3;
        this.url = str;
        this.zzbpd = zzazh;
        this.zzdrs = null;
        this.zzdrt = null;
    }

    public AdOverlayInfoParcel(zzva zzva, zzp zzp, zzagy zzagy, zzaha zzaha, zzu zzu, zzbdv zzbdv, boolean z, int i, String str, String str2, zzazh zzazh) {
        this.zzdrl = null;
        this.zzcgp = zzva;
        this.zzdrm = zzp;
        this.zzdii = zzbdv;
        this.zzdfr = zzagy;
        this.zzdfs = zzaha;
        this.zzdrn = str2;
        this.zzdro = z;
        this.zzdrp = str;
        this.zzdrq = zzu;
        this.orientation = i;
        this.zzdrr = 3;
        this.url = null;
        this.zzbpd = zzazh;
        this.zzdrs = null;
        this.zzdrt = null;
    }

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzd(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdrl, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzcgp).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzdrm).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzdii).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zzdfs).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdrn, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdro);
        SafeParcelWriter.writeString(parcel, 9, this.zzdrp, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzdrq).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.orientation);
        SafeParcelWriter.writeInt(parcel, 12, this.zzdrr);
        SafeParcelWriter.writeString(parcel, 13, this.url, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzbpd, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzdrs, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzdrt, i, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzdfr).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
