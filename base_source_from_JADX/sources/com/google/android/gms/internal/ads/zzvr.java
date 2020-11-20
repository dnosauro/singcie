package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdapterResponseInfoParcelCreator")
public final class zzvr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvr> CREATOR = new zzvu();
    @SafeParcelable.Field(mo11699id = 1)
    public String zzchy;
    @SafeParcelable.Field(mo11699id = 2)
    public long zzchz;
    @SafeParcelable.Field(mo11699id = 3)
    public zzve zzcia;
    @SafeParcelable.Field(mo11699id = 4)
    public Bundle zzcib;

    @SafeParcelable.Constructor
    public zzvr(@SafeParcelable.Param(mo11702id = 1) String str, @SafeParcelable.Param(mo11702id = 2) long j, @SafeParcelable.Param(mo11702id = 3) zzve zzve, @SafeParcelable.Param(mo11702id = 4) Bundle bundle) {
        this.zzchy = str;
        this.zzchz = j;
        this.zzcia = zzve;
        this.zzcib = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzchy, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzchz);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzcia, i, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzcib, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
