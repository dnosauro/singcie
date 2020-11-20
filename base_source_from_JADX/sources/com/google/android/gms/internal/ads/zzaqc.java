package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "RtbVersionInfoParcelCreator")
@ParametersAreNonnullByDefault
public final class zzaqc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaqc> CREATOR = new zzaqf();
    @SafeParcelable.Field(mo11699id = 1)
    private final int major;
    @SafeParcelable.Field(mo11699id = 2)
    private final int minor;
    @SafeParcelable.Field(mo11699id = 3)
    private final int zzdnz;

    @SafeParcelable.Constructor
    zzaqc(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) int i2, @SafeParcelable.Param(mo11702id = 3) int i3) {
        this.major = i;
        this.minor = i2;
        this.zzdnz = i3;
    }

    public static zzaqc zza(VersionInfo versionInfo) {
        return new zzaqc(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzaqc)) {
            zzaqc zzaqc = (zzaqc) obj;
            return zzaqc.zzdnz == this.zzdnz && zzaqc.minor == this.minor && zzaqc.major == this.major;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.major, this.minor, this.zzdnz});
    }

    public final String toString() {
        int i = this.major;
        int i2 = this.minor;
        int i3 = this.zzdnz;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.major);
        SafeParcelWriter.writeInt(parcel, 2, this.minor);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdnz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
