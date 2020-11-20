package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ProgramRequestCreator")
public final class zzdub extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdub> CREATOR = new zzdue();
    @SafeParcelable.VersionField(mo11705id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo11699id = 3)
    private final String zzhqb;
    @SafeParcelable.Field(mo11699id = 4)
    private final String zzhqc;
    @SafeParcelable.Field(mo11699id = 2)
    private final int zzhqd;
    @SafeParcelable.Field(mo11699id = 5)
    private final int zzhrs;

    @SafeParcelable.Constructor
    zzdub(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) int i2, @SafeParcelable.Param(mo11702id = 5) int i3, @SafeParcelable.Param(mo11702id = 3) String str, @SafeParcelable.Param(mo11702id = 4) String str2) {
        this.versionCode = i;
        this.zzhqd = i2;
        this.zzhqb = str;
        this.zzhqc = str2;
        this.zzhrs = i3;
    }

    public zzdub(int i, zzgn zzgn, String str, String str2) {
        this(1, i, zzgn.zzv(), str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.zzhqd);
        SafeParcelWriter.writeString(parcel, 3, this.zzhqb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzhqc, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zzhrs);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
