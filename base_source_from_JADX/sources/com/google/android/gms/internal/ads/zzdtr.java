package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassRequestParcelCreator")
public final class zzdtr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdtr> CREATOR = new zzdtu();
    @SafeParcelable.Field(mo11699id = 2)
    private final String packageName;
    @SafeParcelable.VersionField(mo11705id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo11699id = 3)
    private final String zzhre;

    @SafeParcelable.Constructor
    zzdtr(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) String str, @SafeParcelable.Param(mo11702id = 3) String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.zzhre = str2;
    }

    public zzdtr(String str, String str2) {
        this(1, str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzhre, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
