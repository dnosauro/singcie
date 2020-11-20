package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzdoi;
import com.google.android.gms.internal.ads.zzdwc;
import com.google.android.gms.internal.ads.zzve;

@SafeParcelable.Class(creator = "ExceptionParcelCreator")
public final class zzap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzap> CREATOR = new zzar();
    @SafeParcelable.Field(mo11699id = 2)
    public final int errorCode;
    @SafeParcelable.Field(mo11699id = 1)
    public final String zzacm;

    @SafeParcelable.Constructor
    zzap(@SafeParcelable.Param(mo11702id = 1) String str, @SafeParcelable.Param(mo11702id = 2) int i) {
        this.zzacm = str == null ? "" : str;
        this.errorCode = i;
    }

    public static zzap zzc(Throwable th) {
        zzve zzh = zzdoi.zzh(th);
        return new zzap(zzdwc.zzar(th.getMessage()) ? zzh.zzcgs : th.getMessage(), zzh.errorCode);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzacm, false);
        SafeParcelWriter.writeInt(parcel, 2, this.errorCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
