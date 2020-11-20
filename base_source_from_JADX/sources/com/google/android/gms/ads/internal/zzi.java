package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzh();
    @SafeParcelable.Field(mo11699id = 2)
    public final boolean zzbou;
    @SafeParcelable.Field(mo11699id = 3)
    public final boolean zzbov;
    @SafeParcelable.Field(mo11699id = 4)
    private final String zzbow;
    @SafeParcelable.Field(mo11699id = 5)
    public final boolean zzbox;
    @SafeParcelable.Field(mo11699id = 6)
    public final float zzboy;
    @SafeParcelable.Field(mo11699id = 7)
    public final int zzboz;
    @SafeParcelable.Field(mo11699id = 8)
    public final boolean zzbpa;
    @SafeParcelable.Field(mo11699id = 9)
    public final boolean zzbpb;
    @SafeParcelable.Field(mo11699id = 10)
    public final boolean zzbpc;

    @SafeParcelable.Constructor
    zzi(@SafeParcelable.Param(mo11702id = 2) boolean z, @SafeParcelable.Param(mo11702id = 3) boolean z2, @SafeParcelable.Param(mo11702id = 4) String str, @SafeParcelable.Param(mo11702id = 5) boolean z3, @SafeParcelable.Param(mo11702id = 6) float f, @SafeParcelable.Param(mo11702id = 7) int i, @SafeParcelable.Param(mo11702id = 8) boolean z4, @SafeParcelable.Param(mo11702id = 9) boolean z5, @SafeParcelable.Param(mo11702id = 10) boolean z6) {
        this.zzbou = z;
        this.zzbov = z2;
        this.zzbow = str;
        this.zzbox = z3;
        this.zzboy = f;
        this.zzboz = i;
        this.zzbpa = z4;
        this.zzbpb = z5;
        this.zzbpc = z6;
    }

    public zzi(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(z, z2, (String) null, false, 0.0f, -1, z4, z5, z6);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzbou);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbov);
        SafeParcelWriter.writeString(parcel, 4, this.zzbow, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzbox);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzboy);
        SafeParcelWriter.writeInt(parcel, 7, this.zzboz);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbpa);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbpb);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzbpc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
