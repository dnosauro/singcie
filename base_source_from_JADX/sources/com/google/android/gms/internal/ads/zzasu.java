package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "AdResponseParcelCreator")
@ParametersAreNonnullByDefault
public final class zzasu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasu> CREATOR = new zzasx();
    @SafeParcelable.Field(mo11699id = 5)
    private final int errorCode;
    @SafeParcelable.Field(mo11699id = 12)
    private final int orientation;
    @SafeParcelable.Field(mo11699id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo11699id = 37)
    private final zzasw zzbog;
    @SafeParcelable.Field(mo11699id = 49)
    private final boolean zzbpb;
    @SafeParcelable.Field(mo11699id = 53)
    private final boolean zzbpc;
    @SafeParcelable.Field(mo11699id = 23)
    private final boolean zzbrh;
    @SafeParcelable.Field(mo11699id = 30)
    private final String zzbvf;
    @SafeParcelable.Field(mo11699id = 31)
    private final boolean zzchr;
    @SafeParcelable.Field(mo11699id = 32)
    private final boolean zzchs;
    @SafeParcelable.Field(mo11699id = 4)
    private final List<String> zzdls;
    @SafeParcelable.Field(mo11699id = 6)
    private final List<String> zzdlt;
    @SafeParcelable.Field(mo11699id = 52)
    private final List<String> zzdlu;
    @SafeParcelable.Field(mo11699id = 40)
    private final List<String> zzdlw;
    @SafeParcelable.Field(mo11699id = 42)
    private final boolean zzdlx;
    @SafeParcelable.Field(mo11699id = 11)
    private final long zzdlz;
    @SafeParcelable.Field(mo11699id = 2)
    private final String zzdrn;
    @SafeParcelable.Field(mo11699id = 24)
    private final boolean zzdsy;
    @SafeParcelable.Field(mo11699id = 38)
    private final boolean zzdtl;
    @SafeParcelable.Field(mo11699id = 39)
    private String zzdtm;
    @SafeParcelable.Field(mo11699id = 47)
    private final boolean zzdty;
    @SafeParcelable.Field(mo11699id = 3)
    private String zzdul;
    @SafeParcelable.Field(mo11699id = 7)
    private final long zzdum;
    @SafeParcelable.Field(mo11699id = 8)
    private final boolean zzdun;
    @SafeParcelable.Field(mo11699id = 9)
    private final long zzduo;
    @SafeParcelable.Field(mo11699id = 10)
    private final List<String> zzdup;
    @SafeParcelable.Field(mo11699id = 13)
    private final String zzduq;
    @SafeParcelable.Field(mo11699id = 14)
    private final long zzdur;
    @SafeParcelable.Field(mo11699id = 15)
    private final String zzdus;
    @SafeParcelable.Field(mo11699id = 18)
    private final boolean zzdut;
    @SafeParcelable.Field(mo11699id = 19)
    private final String zzduu;
    @SafeParcelable.Field(mo11699id = 21)
    private final String zzduv;
    @SafeParcelable.Field(mo11699id = 22)
    private final boolean zzduw;
    @SafeParcelable.Field(mo11699id = 25)
    private final boolean zzdux;
    @SafeParcelable.Field(mo11699id = 26)
    private final boolean zzduy;
    @SafeParcelable.Field(mo11699id = 28)
    private zzatg zzduz;
    @SafeParcelable.Field(mo11699id = 29)
    private String zzdva;
    @SafeParcelable.Field(mo11699id = 33)
    private final zzava zzdvb;
    @SafeParcelable.Field(mo11699id = 34)
    private final List<String> zzdvc;
    @SafeParcelable.Field(mo11699id = 35)
    private final List<String> zzdvd;
    @SafeParcelable.Field(mo11699id = 36)
    private final boolean zzdve;
    @SafeParcelable.Field(mo11699id = 43)
    private final String zzdvf;
    @SafeParcelable.Field(mo11699id = 44)
    private final zzawp zzdvg;
    @SafeParcelable.Field(mo11699id = 45)
    private final String zzdvh;
    @SafeParcelable.Field(mo11699id = 46)
    private final boolean zzdvi;
    @SafeParcelable.Field(mo11699id = 48)
    private Bundle zzdvj;
    @SafeParcelable.Field(mo11699id = 50)
    private final int zzdvk;
    @SafeParcelable.Field(mo11699id = 51)
    private final boolean zzdvl;
    @SafeParcelable.Field(mo11699id = 54)
    private final String zzdvm;
    @SafeParcelable.Field(mo11699id = 55)
    private String zzdvn;
    @SafeParcelable.Field(mo11699id = 56)
    private boolean zzdvo;
    @SafeParcelable.Field(mo11699id = 57)
    private boolean zzdvp;

    @SafeParcelable.Constructor
    zzasu(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) String str, @SafeParcelable.Param(mo11702id = 3) String str2, @SafeParcelable.Param(mo11702id = 4) List<String> list, @SafeParcelable.Param(mo11702id = 5) int i2, @SafeParcelable.Param(mo11702id = 6) List<String> list2, @SafeParcelable.Param(mo11702id = 7) long j, @SafeParcelable.Param(mo11702id = 8) boolean z, @SafeParcelable.Param(mo11702id = 9) long j2, @SafeParcelable.Param(mo11702id = 10) List<String> list3, @SafeParcelable.Param(mo11702id = 11) long j3, @SafeParcelable.Param(mo11702id = 12) int i3, @SafeParcelable.Param(mo11702id = 13) String str3, @SafeParcelable.Param(mo11702id = 14) long j4, @SafeParcelable.Param(mo11702id = 15) String str4, @SafeParcelable.Param(mo11702id = 18) boolean z2, @SafeParcelable.Param(mo11702id = 19) String str5, @SafeParcelable.Param(mo11702id = 21) String str6, @SafeParcelable.Param(mo11702id = 22) boolean z3, @SafeParcelable.Param(mo11702id = 23) boolean z4, @SafeParcelable.Param(mo11702id = 24) boolean z5, @SafeParcelable.Param(mo11702id = 25) boolean z6, @SafeParcelable.Param(mo11702id = 26) boolean z7, @SafeParcelable.Param(mo11702id = 28) zzatg zzatg, @SafeParcelable.Param(mo11702id = 29) String str7, @SafeParcelable.Param(mo11702id = 30) String str8, @SafeParcelable.Param(mo11702id = 31) boolean z8, @SafeParcelable.Param(mo11702id = 32) boolean z9, @SafeParcelable.Param(mo11702id = 33) zzava zzava, @SafeParcelable.Param(mo11702id = 34) List<String> list4, @SafeParcelable.Param(mo11702id = 35) List<String> list5, @SafeParcelable.Param(mo11702id = 36) boolean z10, @SafeParcelable.Param(mo11702id = 37) zzasw zzasw, @SafeParcelable.Param(mo11702id = 38) boolean z11, @SafeParcelable.Param(mo11702id = 39) String str9, @SafeParcelable.Param(mo11702id = 40) List<String> list6, @SafeParcelable.Param(mo11702id = 42) boolean z12, @SafeParcelable.Param(mo11702id = 43) String str10, @SafeParcelable.Param(mo11702id = 44) zzawp zzawp, @SafeParcelable.Param(mo11702id = 45) String str11, @SafeParcelable.Param(mo11702id = 46) boolean z13, @SafeParcelable.Param(mo11702id = 47) boolean z14, @SafeParcelable.Param(mo11702id = 48) Bundle bundle, @SafeParcelable.Param(mo11702id = 49) boolean z15, @SafeParcelable.Param(mo11702id = 50) int i4, @SafeParcelable.Param(mo11702id = 51) boolean z16, @SafeParcelable.Param(mo11702id = 52) List<String> list7, @SafeParcelable.Param(mo11702id = 53) boolean z17, @SafeParcelable.Param(mo11702id = 54) String str12, @SafeParcelable.Param(mo11702id = 55) String str13, @SafeParcelable.Param(mo11702id = 56) boolean z18, @SafeParcelable.Param(mo11702id = 57) boolean z19) {
        zzatg zzatg2;
        zzatn zzatn;
        this.versionCode = i;
        this.zzdrn = str;
        this.zzdul = str2;
        List<String> list8 = null;
        this.zzdls = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzdlt = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzdum = j;
        this.zzdun = z;
        this.zzduo = j2;
        this.zzdup = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzdlz = j3;
        this.orientation = i3;
        this.zzduq = str3;
        this.zzdur = j4;
        this.zzdus = str4;
        this.zzdut = z2;
        this.zzduu = str5;
        this.zzduv = str6;
        this.zzduw = z3;
        this.zzbrh = z4;
        this.zzdsy = z5;
        this.zzdux = z6;
        this.zzdvi = z13;
        this.zzduy = z7;
        this.zzduz = zzatg;
        this.zzdva = str7;
        this.zzbvf = str8;
        if (this.zzdul == null && (zzatg2 = this.zzduz) != null && (zzatn = (zzatn) zzatg2.zza(zzatn.CREATOR)) != null && !TextUtils.isEmpty(zzatn.zzdwc)) {
            this.zzdul = zzatn.zzdwc;
        }
        this.zzchr = z8;
        this.zzchs = z9;
        this.zzdvb = zzava;
        this.zzdvc = list4;
        this.zzdvd = list5;
        this.zzdve = z10;
        this.zzbog = zzasw;
        this.zzdtl = z11;
        this.zzdtm = str9;
        this.zzdlw = list6;
        this.zzdlx = z12;
        this.zzdvf = str10;
        this.zzdvg = zzawp;
        this.zzdvh = str11;
        this.zzdty = z14;
        this.zzdvj = bundle;
        this.zzbpb = z15;
        this.zzdvk = i4;
        this.zzdvl = z16;
        this.zzdlu = list7 != null ? Collections.unmodifiableList(list7) : list8;
        this.zzbpc = z17;
        this.zzdvm = str12;
        this.zzdvn = str13;
        this.zzdvo = z18;
        this.zzdvp = z19;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzdrn, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdul, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzdls, false);
        SafeParcelWriter.writeInt(parcel, 5, this.errorCode);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdlt, false);
        SafeParcelWriter.writeLong(parcel, 7, this.zzdum);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdun);
        SafeParcelWriter.writeLong(parcel, 9, this.zzduo);
        SafeParcelWriter.writeStringList(parcel, 10, this.zzdup, false);
        SafeParcelWriter.writeLong(parcel, 11, this.zzdlz);
        SafeParcelWriter.writeInt(parcel, 12, this.orientation);
        SafeParcelWriter.writeString(parcel, 13, this.zzduq, false);
        SafeParcelWriter.writeLong(parcel, 14, this.zzdur);
        SafeParcelWriter.writeString(parcel, 15, this.zzdus, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzdut);
        SafeParcelWriter.writeString(parcel, 19, this.zzduu, false);
        SafeParcelWriter.writeString(parcel, 21, this.zzduv, false);
        SafeParcelWriter.writeBoolean(parcel, 22, this.zzduw);
        SafeParcelWriter.writeBoolean(parcel, 23, this.zzbrh);
        SafeParcelWriter.writeBoolean(parcel, 24, this.zzdsy);
        SafeParcelWriter.writeBoolean(parcel, 25, this.zzdux);
        SafeParcelWriter.writeBoolean(parcel, 26, this.zzduy);
        SafeParcelWriter.writeParcelable(parcel, 28, this.zzduz, i, false);
        SafeParcelWriter.writeString(parcel, 29, this.zzdva, false);
        SafeParcelWriter.writeString(parcel, 30, this.zzbvf, false);
        SafeParcelWriter.writeBoolean(parcel, 31, this.zzchr);
        SafeParcelWriter.writeBoolean(parcel, 32, this.zzchs);
        SafeParcelWriter.writeParcelable(parcel, 33, this.zzdvb, i, false);
        SafeParcelWriter.writeStringList(parcel, 34, this.zzdvc, false);
        SafeParcelWriter.writeStringList(parcel, 35, this.zzdvd, false);
        SafeParcelWriter.writeBoolean(parcel, 36, this.zzdve);
        SafeParcelWriter.writeParcelable(parcel, 37, this.zzbog, i, false);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdtl);
        SafeParcelWriter.writeString(parcel, 39, this.zzdtm, false);
        SafeParcelWriter.writeStringList(parcel, 40, this.zzdlw, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdlx);
        SafeParcelWriter.writeString(parcel, 43, this.zzdvf, false);
        SafeParcelWriter.writeParcelable(parcel, 44, this.zzdvg, i, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdvh, false);
        SafeParcelWriter.writeBoolean(parcel, 46, this.zzdvi);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdty);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdvj, false);
        SafeParcelWriter.writeBoolean(parcel, 49, this.zzbpb);
        SafeParcelWriter.writeInt(parcel, 50, this.zzdvk);
        SafeParcelWriter.writeBoolean(parcel, 51, this.zzdvl);
        SafeParcelWriter.writeStringList(parcel, 52, this.zzdlu, false);
        SafeParcelWriter.writeBoolean(parcel, 53, this.zzbpc);
        SafeParcelWriter.writeString(parcel, 54, this.zzdvm, false);
        SafeParcelWriter.writeString(parcel, 55, this.zzdvn, false);
        SafeParcelWriter.writeBoolean(parcel, 56, this.zzdvo);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdvp);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
