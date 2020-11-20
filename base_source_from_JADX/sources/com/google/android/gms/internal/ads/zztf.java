package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "CacheOfferingCreator")
@SafeParcelable.Reserved({1})
public final class zztf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zztf> CREATOR = new zzte();
    @SafeParcelable.Field(mo11699id = 2)
    public final String url;
    @SafeParcelable.Field(mo11699id = 3)
    private final long zzbuy;
    @SafeParcelable.Field(mo11699id = 4)
    private final String zzbuz;
    @SafeParcelable.Field(mo11699id = 5)
    private final String zzbva;
    @SafeParcelable.Field(mo11699id = 6)
    private final String zzbvb;
    @SafeParcelable.Field(mo11699id = 7)
    private final Bundle zzbvc;
    @SafeParcelable.Field(mo11699id = 8)
    public final boolean zzbvd;
    @SafeParcelable.Field(mo11699id = 9)
    public long zzbve;
    @SafeParcelable.Field(mo11699id = 10)
    public String zzbvf;
    @SafeParcelable.Field(mo11699id = 11)
    public int zzbvg;

    @SafeParcelable.Constructor
    zztf(@SafeParcelable.Param(mo11702id = 2) String str, @SafeParcelable.Param(mo11702id = 3) long j, @SafeParcelable.Param(mo11702id = 4) String str2, @SafeParcelable.Param(mo11702id = 5) String str3, @SafeParcelable.Param(mo11702id = 6) String str4, @SafeParcelable.Param(mo11702id = 7) Bundle bundle, @SafeParcelable.Param(mo11702id = 8) boolean z, @SafeParcelable.Param(mo11702id = 9) long j2, @SafeParcelable.Param(mo11702id = 10) String str5, @SafeParcelable.Param(mo11702id = 11) int i) {
        this.url = str;
        this.zzbuy = j;
        this.zzbuz = str2 == null ? "" : str2;
        this.zzbva = str3 == null ? "" : str3;
        this.zzbvb = str4 == null ? "" : str4;
        this.zzbvc = bundle == null ? new Bundle() : bundle;
        this.zzbvd = z;
        this.zzbve = j2;
        this.zzbvf = str5;
        this.zzbvg = i;
    }

    public static zztf zzbs(String str) {
        return zzd(Uri.parse(str));
    }

    public static zztf zzd(Uri uri) {
        Uri uri2 = uri;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzd.zzfa(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri2.getQueryParameter(ImagesContract.URL);
            boolean equals = "1".equals(uri2.getQueryParameter("read_only"));
            String queryParameter2 = uri2.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0 : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            zzp.zzks();
            for (String next : uri.getQueryParameterNames()) {
                if (next.startsWith("tag.")) {
                    bundle.putString(next.substring(4), uri2.getQueryParameter(next));
                }
            }
            return new zztf(queryParameter, parseLong, host, str, str2, bundle, equals, 0, "", 0);
        } catch (NullPointerException | NumberFormatException e) {
            zzd.zzd("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.url, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzbuy);
        SafeParcelWriter.writeString(parcel, 4, this.zzbuz, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbva, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzbvb, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzbvc, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbvd);
        SafeParcelWriter.writeLong(parcel, 9, this.zzbve);
        SafeParcelWriter.writeString(parcel, 10, this.zzbvf, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzbvg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
