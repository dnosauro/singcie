package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "StringParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzatn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatn> CREATOR = new zzatm();
    @SafeParcelable.Field(mo11699id = 2)
    String zzdwc;

    @SafeParcelable.Constructor
    public zzatn(@SafeParcelable.Param(mo11702id = 2) String str) {
        this.zzdwc = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdwc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
