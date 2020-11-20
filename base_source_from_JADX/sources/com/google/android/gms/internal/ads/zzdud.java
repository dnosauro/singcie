package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "ProgramResponseCreator")
public final class zzdud extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdud> CREATOR = new zzdug();
    @SafeParcelable.Field(mo11699id = 3)
    public final int status;
    @SafeParcelable.VersionField(mo11705id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo11699id = 2)
    public final byte[] zzhrt;

    @SafeParcelable.Constructor
    zzdud(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) byte[] bArr, @SafeParcelable.Param(mo11702id = 3) int i2) {
        this.versionCode = i;
        this.zzhrt = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.status = i2;
    }

    public zzdud(byte[] bArr, int i) {
        this(1, (byte[]) null, 1);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzhrt, false);
        SafeParcelWriter.writeInt(parcel, 3, this.status);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
