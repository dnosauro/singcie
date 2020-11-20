package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "HttpResponseParcelCreator")
public final class zzain extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzain> CREATOR = new zzaim();
    @SafeParcelable.Field(mo11699id = 4)
    public final byte[] data;
    @SafeParcelable.Field(mo11699id = 3)
    public final int statusCode;
    @SafeParcelable.Field(mo11699id = 7)
    public final boolean zzam;
    @SafeParcelable.Field(mo11699id = 8)
    public final long zzan;
    @SafeParcelable.Field(mo11699id = 2)
    public final String zzcgs;
    @SafeParcelable.Field(mo11699id = 5)
    public final String[] zzdhh;
    @SafeParcelable.Field(mo11699id = 6)
    public final String[] zzdhi;
    @SafeParcelable.Field(mo11699id = 1)
    public final boolean zzdhj;

    @SafeParcelable.Constructor
    zzain(@SafeParcelable.Param(mo11702id = 1) boolean z, @SafeParcelable.Param(mo11702id = 2) String str, @SafeParcelable.Param(mo11702id = 3) int i, @SafeParcelable.Param(mo11702id = 4) byte[] bArr, @SafeParcelable.Param(mo11702id = 5) String[] strArr, @SafeParcelable.Param(mo11702id = 6) String[] strArr2, @SafeParcelable.Param(mo11702id = 7) boolean z2, @SafeParcelable.Param(mo11702id = 8) long j) {
        this.zzdhj = z;
        this.zzcgs = str;
        this.statusCode = i;
        this.data = bArr;
        this.zzdhh = strArr;
        this.zzdhi = strArr2;
        this.zzam = z2;
        this.zzan = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zzdhj);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgs, false);
        SafeParcelWriter.writeInt(parcel, 3, this.statusCode);
        SafeParcelWriter.writeByteArray(parcel, 4, this.data, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.zzdhh, false);
        SafeParcelWriter.writeStringArray(parcel, 6, this.zzdhi, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzam);
        SafeParcelWriter.writeLong(parcel, 8, this.zzan);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
