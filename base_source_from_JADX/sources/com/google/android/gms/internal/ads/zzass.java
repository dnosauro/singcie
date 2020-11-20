package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "AdRequestInfoParcelCreator")
@ParametersAreNonnullByDefault
public final class zzass extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzass> CREATOR = new zzasv();
    @SafeParcelable.Field(mo11699id = 6)
    private final ApplicationInfo applicationInfo;
    @SafeParcelable.Field(mo11699id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo11699id = 11)
    private final zzazh zzbpd;
    @SafeParcelable.Field(mo11699id = 4)
    private final zzvn zzbpe;
    @SafeParcelable.Field(mo11699id = 20)
    private final float zzbrt;
    @SafeParcelable.Field(mo11699id = 5)
    private final String zzbum;
    @SafeParcelable.Field(mo11699id = 10)
    private final String zzciz;
    @SafeParcelable.Field(mo11699id = 42)
    private final boolean zzdlx;
    @SafeParcelable.Field(mo11699id = 29)
    private final zzadz zzdnh;
    @SafeParcelable.Field(mo11699id = 14)
    private final List<String> zzdni;
    @SafeParcelable.Field(mo11699id = 18)
    private final int zzdpl;
    @SafeParcelable.Field(mo11699id = 19)
    private final int zzdpm;
    @SafeParcelable.Field(mo11699id = 2)
    private final Bundle zzdsq;
    @SafeParcelable.Field(mo11699id = 3)
    private final zzvk zzdsr;
    @SafeParcelable.Field(mo11699id = 7)
    private final PackageInfo zzdss;
    @SafeParcelable.Field(mo11699id = 8)
    private final String zzdst;
    @SafeParcelable.Field(mo11699id = 9)
    private final String zzdsu;
    @SafeParcelable.Field(mo11699id = 12)
    private final Bundle zzdsv;
    @SafeParcelable.Field(mo11699id = 13)
    private final int zzdsw;
    @SafeParcelable.Field(mo11699id = 15)
    private final Bundle zzdsx;
    @SafeParcelable.Field(mo11699id = 16)
    private final boolean zzdsy;
    @SafeParcelable.Field(mo11699id = 21)
    private final String zzdsz;
    @SafeParcelable.Field(mo11699id = 25)
    private final long zzdta;
    @SafeParcelable.Field(mo11699id = 26)
    private final String zzdtb;
    @SafeParcelable.Field(mo11699id = 27)
    private final List<String> zzdtc;
    @SafeParcelable.Field(mo11699id = 28)
    private final String zzdtd;
    @SafeParcelable.Field(mo11699id = 30)
    private final List<String> zzdte;
    @SafeParcelable.Field(mo11699id = 31)
    private final long zzdtf;
    @SafeParcelable.Field(mo11699id = 33)
    private final String zzdtg;
    @SafeParcelable.Field(mo11699id = 34)
    private final float zzdth;
    @SafeParcelable.Field(mo11699id = 35)
    private final int zzdti;
    @SafeParcelable.Field(mo11699id = 36)
    private final int zzdtj;
    @SafeParcelable.Field(mo11699id = 37)
    private final boolean zzdtk;
    @SafeParcelable.Field(mo11699id = 38)
    private final boolean zzdtl;
    @SafeParcelable.Field(mo11699id = 39)
    private final String zzdtm;
    @SafeParcelable.Field(mo11699id = 40)
    private final boolean zzdtn;
    @SafeParcelable.Field(mo11699id = 41)
    private final String zzdto;
    @SafeParcelable.Field(mo11699id = 43)
    private final int zzdtp;
    @SafeParcelable.Field(mo11699id = 44)
    private final Bundle zzdtq;
    @SafeParcelable.Field(mo11699id = 45)
    private final String zzdtr;
    @SafeParcelable.Field(mo11699id = 46)
    private final zzyy zzdts;
    @SafeParcelable.Field(mo11699id = 47)
    private final boolean zzdtt;
    @SafeParcelable.Field(mo11699id = 48)
    private final Bundle zzdtu;
    @SafeParcelable.Field(mo11699id = 49)
    private final String zzdtv;
    @SafeParcelable.Field(mo11699id = 50)
    private final String zzdtw;
    @SafeParcelable.Field(mo11699id = 51)
    private final String zzdtx;
    @SafeParcelable.Field(mo11699id = 52)
    private final boolean zzdty;
    @SafeParcelable.Field(mo11699id = 53)
    private final List<Integer> zzdtz;
    @SafeParcelable.Field(mo11699id = 54)
    private final String zzdua;
    @SafeParcelable.Field(mo11699id = 55)
    private final List<String> zzdub;
    @SafeParcelable.Field(mo11699id = 56)
    private final int zzduc;
    @SafeParcelable.Field(mo11699id = 57)
    private final boolean zzdud;
    @SafeParcelable.Field(mo11699id = 58)
    private final boolean zzdue;
    @SafeParcelable.Field(mo11699id = 59)
    private final boolean zzduf;
    @SafeParcelable.Field(mo11699id = 60)
    private final ArrayList<String> zzdug;
    @SafeParcelable.Field(mo11699id = 61)
    private final String zzduh;
    @SafeParcelable.Field(mo11699id = 63)
    private final zzajl zzdui;
    @SafeParcelable.Field(mo11699id = 64)
    private final String zzduj;
    @SafeParcelable.Field(mo11699id = 65)
    private final Bundle zzduk;

    @SafeParcelable.Constructor
    zzass(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) Bundle bundle, @SafeParcelable.Param(mo11702id = 3) zzvk zzvk, @SafeParcelable.Param(mo11702id = 4) zzvn zzvn, @SafeParcelable.Param(mo11702id = 5) String str, @SafeParcelable.Param(mo11702id = 6) ApplicationInfo applicationInfo2, @SafeParcelable.Param(mo11702id = 7) PackageInfo packageInfo, @SafeParcelable.Param(mo11702id = 8) String str2, @SafeParcelable.Param(mo11702id = 9) String str3, @SafeParcelable.Param(mo11702id = 10) String str4, @SafeParcelable.Param(mo11702id = 11) zzazh zzazh, @SafeParcelable.Param(mo11702id = 12) Bundle bundle2, @SafeParcelable.Param(mo11702id = 13) int i2, @SafeParcelable.Param(mo11702id = 14) List<String> list, @SafeParcelable.Param(mo11702id = 15) Bundle bundle3, @SafeParcelable.Param(mo11702id = 16) boolean z, @SafeParcelable.Param(mo11702id = 18) int i3, @SafeParcelable.Param(mo11702id = 19) int i4, @SafeParcelable.Param(mo11702id = 20) float f, @SafeParcelable.Param(mo11702id = 21) String str5, @SafeParcelable.Param(mo11702id = 25) long j, @SafeParcelable.Param(mo11702id = 26) String str6, @SafeParcelable.Param(mo11702id = 27) List<String> list2, @SafeParcelable.Param(mo11702id = 28) String str7, @SafeParcelable.Param(mo11702id = 29) zzadz zzadz, @SafeParcelable.Param(mo11702id = 30) List<String> list3, @SafeParcelable.Param(mo11702id = 31) long j2, @SafeParcelable.Param(mo11702id = 33) String str8, @SafeParcelable.Param(mo11702id = 34) float f2, @SafeParcelable.Param(mo11702id = 40) boolean z2, @SafeParcelable.Param(mo11702id = 35) int i5, @SafeParcelable.Param(mo11702id = 36) int i6, @SafeParcelable.Param(mo11702id = 37) boolean z3, @SafeParcelable.Param(mo11702id = 38) boolean z4, @SafeParcelable.Param(mo11702id = 39) String str9, @SafeParcelable.Param(mo11702id = 41) String str10, @SafeParcelable.Param(mo11702id = 42) boolean z5, @SafeParcelable.Param(mo11702id = 43) int i7, @SafeParcelable.Param(mo11702id = 44) Bundle bundle4, @SafeParcelable.Param(mo11702id = 45) String str11, @SafeParcelable.Param(mo11702id = 46) zzyy zzyy, @SafeParcelable.Param(mo11702id = 47) boolean z6, @SafeParcelable.Param(mo11702id = 48) Bundle bundle5, @SafeParcelable.Param(mo11702id = 49) String str12, @SafeParcelable.Param(mo11702id = 50) String str13, @SafeParcelable.Param(mo11702id = 51) String str14, @SafeParcelable.Param(mo11702id = 52) boolean z7, @SafeParcelable.Param(mo11702id = 53) List<Integer> list4, @SafeParcelable.Param(mo11702id = 54) String str15, @SafeParcelable.Param(mo11702id = 55) List<String> list5, @SafeParcelable.Param(mo11702id = 56) int i8, @SafeParcelable.Param(mo11702id = 57) boolean z8, @SafeParcelable.Param(mo11702id = 58) boolean z9, @SafeParcelable.Param(mo11702id = 59) boolean z10, @SafeParcelable.Param(mo11702id = 60) ArrayList<String> arrayList, @SafeParcelable.Param(mo11702id = 61) String str16, @SafeParcelable.Param(mo11702id = 63) zzajl zzajl, @SafeParcelable.Param(mo11702id = 64) String str17, @SafeParcelable.Param(mo11702id = 65) Bundle bundle6) {
        this.versionCode = i;
        this.zzdsq = bundle;
        this.zzdsr = zzvk;
        this.zzbpe = zzvn;
        this.zzbum = str;
        this.applicationInfo = applicationInfo2;
        this.zzdss = packageInfo;
        this.zzdst = str2;
        this.zzdsu = str3;
        this.zzciz = str4;
        this.zzbpd = zzazh;
        this.zzdsv = bundle2;
        this.zzdsw = i2;
        this.zzdni = list;
        this.zzdte = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.zzdsx = bundle3;
        this.zzdsy = z;
        this.zzdpl = i3;
        this.zzdpm = i4;
        this.zzbrt = f;
        this.zzdsz = str5;
        this.zzdta = j;
        this.zzdtb = str6;
        this.zzdtc = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzdtd = str7;
        this.zzdnh = zzadz;
        this.zzdtf = j2;
        this.zzdtg = str8;
        this.zzdth = f2;
        this.zzdtn = z2;
        this.zzdti = i5;
        this.zzdtj = i6;
        this.zzdtk = z3;
        this.zzdtl = z4;
        this.zzdtm = str9;
        this.zzdto = str10;
        this.zzdlx = z5;
        this.zzdtp = i7;
        this.zzdtq = bundle4;
        this.zzdtr = str11;
        this.zzdts = zzyy;
        this.zzdtt = z6;
        this.zzdtu = bundle5;
        this.zzdtv = str12;
        this.zzdtw = str13;
        this.zzdtx = str14;
        this.zzdty = z7;
        this.zzdtz = list4;
        this.zzdua = str15;
        this.zzdub = list5;
        this.zzduc = i8;
        this.zzdud = z8;
        this.zzdue = z9;
        this.zzduf = z10;
        this.zzdug = arrayList;
        this.zzduh = str16;
        this.zzdui = zzajl;
        this.zzduj = str17;
        this.zzduk = bundle6;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzdsq, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdsr, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbpe, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbum, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.applicationInfo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzdss, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzdst, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzdsu, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzciz, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzbpd, i, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.zzdsv, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzdsw);
        SafeParcelWriter.writeStringList(parcel, 14, this.zzdni, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.zzdsx, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzdsy);
        SafeParcelWriter.writeInt(parcel, 18, this.zzdpl);
        SafeParcelWriter.writeInt(parcel, 19, this.zzdpm);
        SafeParcelWriter.writeFloat(parcel, 20, this.zzbrt);
        SafeParcelWriter.writeString(parcel, 21, this.zzdsz, false);
        SafeParcelWriter.writeLong(parcel, 25, this.zzdta);
        SafeParcelWriter.writeString(parcel, 26, this.zzdtb, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.zzdtc, false);
        SafeParcelWriter.writeString(parcel, 28, this.zzdtd, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.zzdnh, i, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.zzdte, false);
        SafeParcelWriter.writeLong(parcel, 31, this.zzdtf);
        SafeParcelWriter.writeString(parcel, 33, this.zzdtg, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.zzdth);
        SafeParcelWriter.writeInt(parcel, 35, this.zzdti);
        SafeParcelWriter.writeInt(parcel, 36, this.zzdtj);
        SafeParcelWriter.writeBoolean(parcel, 37, this.zzdtk);
        SafeParcelWriter.writeBoolean(parcel, 38, this.zzdtl);
        SafeParcelWriter.writeString(parcel, 39, this.zzdtm, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.zzdtn);
        SafeParcelWriter.writeString(parcel, 41, this.zzdto, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdlx);
        SafeParcelWriter.writeInt(parcel, 43, this.zzdtp);
        SafeParcelWriter.writeBundle(parcel, 44, this.zzdtq, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdtr, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.zzdts, i, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdtt);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdtu, false);
        SafeParcelWriter.writeString(parcel, 49, this.zzdtv, false);
        SafeParcelWriter.writeString(parcel, 50, this.zzdtw, false);
        SafeParcelWriter.writeString(parcel, 51, this.zzdtx, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.zzdty);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.zzdtz, false);
        SafeParcelWriter.writeString(parcel, 54, this.zzdua, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.zzdub, false);
        SafeParcelWriter.writeInt(parcel, 56, this.zzduc);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdud);
        SafeParcelWriter.writeBoolean(parcel, 58, this.zzdue);
        SafeParcelWriter.writeBoolean(parcel, 59, this.zzduf);
        SafeParcelWriter.writeStringList(parcel, 60, this.zzdug, false);
        SafeParcelWriter.writeString(parcel, 61, this.zzduh, false);
        SafeParcelWriter.writeParcelable(parcel, 63, this.zzdui, i, false);
        SafeParcelWriter.writeString(parcel, 64, this.zzduj, false);
        SafeParcelWriter.writeBundle(parcel, 65, this.zzduk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
