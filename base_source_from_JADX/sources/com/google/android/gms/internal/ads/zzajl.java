package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.parse.ParseQuery;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "InstreamAdConfigurationParcelCreator")
@ParametersAreNonnullByDefault
public final class zzajl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzajl> CREATOR = new zzajk();
    @SafeParcelable.VersionField(mo11705id = 1000)
    public final int versionCode;
    @SafeParcelable.Field(mo11699id = 3)
    public final int zzbnn;
    @SafeParcelable.Field(mo11699id = 1)
    public final int zzdht;
    @SafeParcelable.Field(mo11699id = 2)
    public final String zzdhu;

    @SafeParcelable.Constructor
    public zzajl(@SafeParcelable.Param(mo11702id = 1000) int i, @SafeParcelable.Param(mo11702id = 1) int i2, @SafeParcelable.Param(mo11702id = 2) String str, @SafeParcelable.Param(mo11702id = 3) int i3) {
        this.versionCode = i;
        this.zzdht = i2;
        this.zzdhu = str;
        this.zzbnn = i3;
    }

    public zzajl(zzajx zzajx) {
        this(2, 1, zzajx.zztq(), zzajx.getMediaAspectRatio());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzdht);
        SafeParcelWriter.writeString(parcel, 2, this.zzdhu, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbnn);
        SafeParcelWriter.writeInt(parcel, ParseQuery.MAX_LIMIT, this.versionCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
