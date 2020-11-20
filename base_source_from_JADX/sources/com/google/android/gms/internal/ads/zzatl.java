package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "NonagonRequestParcelCreator")
@ParametersAreNonnullByDefault
public final class zzatl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatl> CREATOR = new zzatk();
    @SafeParcelable.Field(mo11699id = 3)
    public final ApplicationInfo applicationInfo;
    @SafeParcelable.Field(mo11699id = 4)
    public final String packageName;
    @SafeParcelable.Field(mo11699id = 2)
    public final zzazh zzdsm;
    @SafeParcelable.Field(mo11699id = 6)
    public final PackageInfo zzdss;
    @SafeParcelable.Field(mo11699id = 5)
    public final List<String> zzdtc;
    @SafeParcelable.Field(mo11699id = 7)
    public final String zzdtm;
    @SafeParcelable.Field(mo11699id = 1)
    public final Bundle zzdvx;
    @SafeParcelable.Field(mo11699id = 8)
    public final boolean zzdvy;
    @SafeParcelable.Field(mo11699id = 9)
    public final String zzdvz;
    @SafeParcelable.Field(mo11699id = 10)
    public zzdpk zzdwa;
    @SafeParcelable.Field(mo11699id = 11)
    public String zzdwb;

    @SafeParcelable.Constructor
    public zzatl(@SafeParcelable.Param(mo11702id = 1) Bundle bundle, @SafeParcelable.Param(mo11702id = 2) zzazh zzazh, @SafeParcelable.Param(mo11702id = 3) ApplicationInfo applicationInfo2, @SafeParcelable.Param(mo11702id = 4) String str, @SafeParcelable.Param(mo11702id = 5) List<String> list, @SafeParcelable.Param(mo11702id = 6) PackageInfo packageInfo, @SafeParcelable.Param(mo11702id = 7) String str2, @SafeParcelable.Param(mo11702id = 8) boolean z, @SafeParcelable.Param(mo11702id = 9) String str3, @SafeParcelable.Param(mo11702id = 10) zzdpk zzdpk, @SafeParcelable.Param(mo11702id = 11) String str4) {
        this.zzdvx = bundle;
        this.zzdsm = zzazh;
        this.packageName = str;
        this.applicationInfo = applicationInfo2;
        this.zzdtc = list;
        this.zzdss = packageInfo;
        this.zzdtm = str2;
        this.zzdvy = z;
        this.zzdvz = str3;
        this.zzdwa = zzdpk;
        this.zzdwb = str4;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzdvx, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdsm, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.applicationInfo, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzdtc, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdss, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdtm, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdvy);
        SafeParcelWriter.writeString(parcel, 9, this.zzdvz, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzdwa, i, false);
        SafeParcelWriter.writeString(parcel, 11, this.zzdwb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
