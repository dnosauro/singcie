package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SearchAdRequestParcelCreator")
@SafeParcelable.Reserved({1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14})
public final class zzaag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaag> CREATOR = new zzaaj();
    @SafeParcelable.Field(mo11699id = 15)
    public final String zzbqr;

    public zzaag(SearchAdRequest searchAdRequest) {
        this.zzbqr = searchAdRequest.getQuery();
    }

    @SafeParcelable.Constructor
    zzaag(@SafeParcelable.Param(mo11702id = 15) String str) {
        this.zzbqr = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 15, this.zzbqr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
