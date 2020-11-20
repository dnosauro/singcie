package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConnectionInfoCreator")
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();
    @SafeParcelable.Field(mo11699id = 1)
    Bundle zza;
    @SafeParcelable.Field(mo11699id = 2)
    Feature[] zzb;
    @SafeParcelable.Field(defaultValue = "0", mo11699id = 3)
    private int zzc;

    public zzc() {
    }

    @SafeParcelable.Constructor
    zzc(@SafeParcelable.Param(mo11702id = 1) Bundle bundle, @SafeParcelable.Param(mo11702id = 2) Feature[] featureArr, @SafeParcelable.Param(mo11702id = 3) int i) {
        this.zza = bundle;
        this.zzb = featureArr;
        this.zzc = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zza, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
