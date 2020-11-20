package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;

@SafeParcelable.Class(creator = "HttpRequestParcelCreator")
public final class zzail extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzail> CREATOR = new zzaik();
    @SafeParcelable.Field(mo11699id = 1)
    private final String url;
    @SafeParcelable.Field(mo11699id = 2)
    private final String[] zzdhh;
    @SafeParcelable.Field(mo11699id = 3)
    private final String[] zzdhi;

    @SafeParcelable.Constructor
    zzail(@SafeParcelable.Param(mo11702id = 1) String str, @SafeParcelable.Param(mo11702id = 2) String[] strArr, @SafeParcelable.Param(mo11702id = 3) String[] strArr2) {
        this.url = str;
        this.zzdhh = strArr;
        this.zzdhi = strArr2;
    }

    public static zzail zzh(zzaa<?> zzaa) {
        Map<String, String> headers = zzaa.getHeaders();
        int size = headers.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry next : headers.entrySet()) {
            strArr[i] = (String) next.getKey();
            strArr2[i] = (String) next.getValue();
            i++;
        }
        return new zzail(zzaa.getUrl(), strArr, strArr2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzdhh, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.zzdhi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
