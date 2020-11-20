package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassEventParcelCreator")
public final class zzdtq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdtq> CREATOR = new zzdtp();
    @SafeParcelable.VersionField(mo11705id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo11699id = 2)
    private final byte[] zzhrd;

    @SafeParcelable.Constructor
    zzdtq(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) byte[] bArr) {
        this.versionCode = i;
        this.zzhrd = bArr;
    }

    public zzdtq(byte[] bArr) {
        this(1, bArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzhrd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
