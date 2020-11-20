package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "AdRequestParcelCreator")
public final class zzvk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvk> CREATOR = new zzvm();
    @SafeParcelable.Field(mo11699id = 3)
    public final Bundle extras;
    @SafeParcelable.Field(mo11699id = 1)
    public final int versionCode;
    @SafeParcelable.Field(mo11699id = 7)
    public final int zzadl;
    @SafeParcelable.Field(mo11699id = 20)
    public final int zzadm;
    @SafeParcelable.Field(mo11699id = 21)
    public final String zzadn;
    @SafeParcelable.Field(mo11699id = 8)
    public final boolean zzbnx;
    @SafeParcelable.Field(mo11699id = 2)
    @Deprecated
    public final long zzcgy;
    @SafeParcelable.Field(mo11699id = 4)
    @Deprecated
    public final int zzcgz;
    @SafeParcelable.Field(mo11699id = 5)
    public final List<String> zzcha;
    @SafeParcelable.Field(mo11699id = 6)
    public final boolean zzchb;
    @SafeParcelable.Field(mo11699id = 9)
    public final String zzchc;
    @SafeParcelable.Field(mo11699id = 10)
    public final zzaag zzchd;
    @SafeParcelable.Field(mo11699id = 12)
    public final String zzche;
    @SafeParcelable.Field(mo11699id = 13)
    public final Bundle zzchf;
    @SafeParcelable.Field(mo11699id = 14)
    public final Bundle zzchg;
    @SafeParcelable.Field(mo11699id = 15)
    public final List<String> zzchh;
    @SafeParcelable.Field(mo11699id = 16)
    public final String zzchi;
    @SafeParcelable.Field(mo11699id = 17)
    public final String zzchj;
    @SafeParcelable.Field(mo11699id = 18)
    @Deprecated
    public final boolean zzchk;
    @SafeParcelable.Field(mo11699id = 22)
    public final List<String> zzchl;
    @SafeParcelable.Field(mo11699id = 23)
    public final int zzchm;
    @SafeParcelable.Field(mo11699id = 19)
    public final zzvc zzchn;
    @SafeParcelable.Field(mo11699id = 11)
    public final Location zzmy;

    @SafeParcelable.Constructor
    public zzvk(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) long j, @SafeParcelable.Param(mo11702id = 3) Bundle bundle, @SafeParcelable.Param(mo11702id = 4) int i2, @SafeParcelable.Param(mo11702id = 5) List<String> list, @SafeParcelable.Param(mo11702id = 6) boolean z, @SafeParcelable.Param(mo11702id = 7) int i3, @SafeParcelable.Param(mo11702id = 8) boolean z2, @SafeParcelable.Param(mo11702id = 9) String str, @SafeParcelable.Param(mo11702id = 10) zzaag zzaag, @SafeParcelable.Param(mo11702id = 11) Location location, @SafeParcelable.Param(mo11702id = 12) String str2, @SafeParcelable.Param(mo11702id = 13) Bundle bundle2, @SafeParcelable.Param(mo11702id = 14) Bundle bundle3, @SafeParcelable.Param(mo11702id = 15) List<String> list2, @SafeParcelable.Param(mo11702id = 16) String str3, @SafeParcelable.Param(mo11702id = 17) String str4, @SafeParcelable.Param(mo11702id = 18) boolean z3, @SafeParcelable.Param(mo11702id = 19) zzvc zzvc, @SafeParcelable.Param(mo11702id = 20) int i4, @SafeParcelable.Param(mo11702id = 21) String str5, @SafeParcelable.Param(mo11702id = 22) List<String> list3, @SafeParcelable.Param(mo11702id = 23) int i5) {
        this.versionCode = i;
        this.zzcgy = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzcgz = i2;
        this.zzcha = list;
        this.zzchb = z;
        this.zzadl = i3;
        this.zzbnx = z2;
        this.zzchc = str;
        this.zzchd = zzaag;
        this.zzmy = location;
        this.zzche = str2;
        this.zzchf = bundle2 == null ? new Bundle() : bundle2;
        this.zzchg = bundle3;
        this.zzchh = list2;
        this.zzchi = str3;
        this.zzchj = str4;
        this.zzchk = z3;
        this.zzchn = zzvc;
        this.zzadm = i4;
        this.zzadn = str5;
        this.zzchl = list3 == null ? new ArrayList<>() : list3;
        this.zzchm = i5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzvk)) {
            return false;
        }
        zzvk zzvk = (zzvk) obj;
        return this.versionCode == zzvk.versionCode && this.zzcgy == zzvk.zzcgy && Objects.equal(this.extras, zzvk.extras) && this.zzcgz == zzvk.zzcgz && Objects.equal(this.zzcha, zzvk.zzcha) && this.zzchb == zzvk.zzchb && this.zzadl == zzvk.zzadl && this.zzbnx == zzvk.zzbnx && Objects.equal(this.zzchc, zzvk.zzchc) && Objects.equal(this.zzchd, zzvk.zzchd) && Objects.equal(this.zzmy, zzvk.zzmy) && Objects.equal(this.zzche, zzvk.zzche) && Objects.equal(this.zzchf, zzvk.zzchf) && Objects.equal(this.zzchg, zzvk.zzchg) && Objects.equal(this.zzchh, zzvk.zzchh) && Objects.equal(this.zzchi, zzvk.zzchi) && Objects.equal(this.zzchj, zzvk.zzchj) && this.zzchk == zzvk.zzchk && this.zzadm == zzvk.zzadm && Objects.equal(this.zzadn, zzvk.zzadn) && Objects.equal(this.zzchl, zzvk.zzchl) && this.zzchm == zzvk.zzchm;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzcgy), this.extras, Integer.valueOf(this.zzcgz), this.zzcha, Boolean.valueOf(this.zzchb), Integer.valueOf(this.zzadl), Boolean.valueOf(this.zzbnx), this.zzchc, this.zzchd, this.zzmy, this.zzche, this.zzchf, this.zzchg, this.zzchh, this.zzchi, this.zzchj, Boolean.valueOf(this.zzchk), Integer.valueOf(this.zzadm), this.zzadn, this.zzchl, Integer.valueOf(this.zzchm));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, this.zzcgy);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzcgz);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzcha, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzchb);
        SafeParcelWriter.writeInt(parcel, 7, this.zzadl);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbnx);
        SafeParcelWriter.writeString(parcel, 9, this.zzchc, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzchd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzmy, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzche, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzchf, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzchg, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzchh, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzchi, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzchj, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzchk);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzchn, i, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzadm);
        SafeParcelWriter.writeString(parcel, 21, this.zzadn, false);
        SafeParcelWriter.writeStringList(parcel, 22, this.zzchl, false);
        SafeParcelWriter.writeInt(parcel, 23, this.zzchm);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
