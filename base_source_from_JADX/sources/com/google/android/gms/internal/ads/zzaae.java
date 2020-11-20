package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "RequestConfigurationParcelCreator")
public final class zzaae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaae> CREATOR = new zzaah();
    @SafeParcelable.Field(mo11699id = 1)
    private final int zzadl;
    @SafeParcelable.Field(mo11699id = 2)
    private final int zzadm;

    @SafeParcelable.Constructor
    public zzaae(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) int i2) {
        this.zzadl = i;
        this.zzadm = i2;
    }

    public zzaae(RequestConfiguration requestConfiguration) {
        this.zzadl = requestConfiguration.getTagForChildDirectedTreatment();
        this.zzadm = requestConfiguration.getTagForUnderAgeOfConsent();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzadl);
        SafeParcelWriter.writeInt(parcel, 2, this.zzadm);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
