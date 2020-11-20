package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzm();
    @SafeParcelable.Field(getter = "getCallingPackage", mo11699id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getCallingCertificateBinder", mo11699id = 2, type = "android.os.IBinder")
    @Nullable
    private final zzd zzb;
    @SafeParcelable.Field(getter = "getAllowTestKeys", mo11699id = 3)
    private final boolean zzc;
    @SafeParcelable.Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", mo11699id = 4)
    private final boolean zzd;

    @SafeParcelable.Constructor
    zzj(@SafeParcelable.Param(mo11702id = 1) String str, @SafeParcelable.Param(mo11702id = 2) @Nullable IBinder iBinder, @SafeParcelable.Param(mo11702id = 3) boolean z, @SafeParcelable.Param(mo11702id = 4) boolean z2) {
        this.zza = str;
        this.zzb = zza(iBinder);
        this.zzc = z;
        this.zzd = z2;
    }

    zzj(String str, @Nullable zzd zzd2, boolean z, boolean z2) {
        this.zza = str;
        this.zzb = zzd2;
        this.zzc = z;
        this.zzd = z2;
    }

    @Nullable
    private static zzd zza(@Nullable IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper zzb2 = zzn.zza(iBinder).zzb();
            byte[] bArr = zzb2 == null ? null : (byte[]) ObjectWrapper.unwrap(zzb2);
            if (bArr != null) {
                return new zzg(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        zzd zzd2 = this.zzb;
        if (zzd2 == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            iBinder = null;
        } else {
            iBinder = zzd2.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, iBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
