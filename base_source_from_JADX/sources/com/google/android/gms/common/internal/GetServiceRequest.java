package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzd();
    @SafeParcelable.Field(mo11699id = 4)
    String zza;
    @SafeParcelable.Field(mo11699id = 5)
    IBinder zzb;
    @SafeParcelable.Field(mo11699id = 6)
    Scope[] zzc;
    @SafeParcelable.Field(mo11699id = 7)
    Bundle zzd;
    @SafeParcelable.Field(mo11699id = 8)
    Account zze;
    @SafeParcelable.Field(mo11699id = 10)
    Feature[] zzf;
    @SafeParcelable.Field(mo11699id = 11)
    Feature[] zzg;
    @SafeParcelable.VersionField(mo11705id = 1)
    private final int zzh;
    @SafeParcelable.Field(mo11699id = 2)
    private final int zzi;
    @SafeParcelable.Field(mo11699id = 3)
    private int zzj;
    @SafeParcelable.Field(mo11699id = 12)
    private boolean zzk;
    @SafeParcelable.Field(defaultValue = "0", mo11699id = 13)
    private int zzl;

    public GetServiceRequest(int i) {
        this.zzh = 4;
        this.zzj = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzi = i;
        this.zzk = true;
    }

    @SafeParcelable.Constructor
    GetServiceRequest(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) int i2, @SafeParcelable.Param(mo11702id = 3) int i3, @SafeParcelable.Param(mo11702id = 4) String str, @SafeParcelable.Param(mo11702id = 5) IBinder iBinder, @SafeParcelable.Param(mo11702id = 6) Scope[] scopeArr, @SafeParcelable.Param(mo11702id = 7) Bundle bundle, @SafeParcelable.Param(mo11702id = 8) Account account, @SafeParcelable.Param(mo11702id = 10) Feature[] featureArr, @SafeParcelable.Param(mo11702id = 11) Feature[] featureArr2, @SafeParcelable.Param(mo11702id = 12) boolean z, @SafeParcelable.Param(mo11702id = 13) int i4) {
        this.zzh = i;
        this.zzi = i2;
        this.zzj = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zza = "com.google.android.gms";
        } else {
            this.zza = str;
        }
        if (i < 2) {
            this.zze = iBinder != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.zzb = iBinder;
            this.zze = account;
        }
        this.zzc = scopeArr;
        this.zzd = bundle;
        this.zzf = featureArr;
        this.zzg = featureArr2;
        this.zzk = z;
        this.zzl = i4;
    }

    @KeepForSdk
    public Bundle getExtraArgs() {
        return this.zzd;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzh);
        SafeParcelWriter.writeInt(parcel, 2, this.zzi);
        SafeParcelWriter.writeInt(parcel, 3, this.zzj);
        SafeParcelWriter.writeString(parcel, 4, this.zza, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zzb, false);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zzc, i, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzd, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zze, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 10, this.zzf, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 11, this.zzg, i, false);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeInt(parcel, 13, this.zzl);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
