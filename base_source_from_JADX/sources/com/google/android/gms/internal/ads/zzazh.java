package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "VersionInfoParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzazh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzazh> CREATOR = new zzazg();
    @SafeParcelable.Field(mo11699id = 2)
    public String zzbrf;
    @SafeParcelable.Field(mo11699id = 3)
    public int zzegl;
    @SafeParcelable.Field(mo11699id = 4)
    public int zzegm;
    @SafeParcelable.Field(mo11699id = 5)
    public boolean zzegn;
    @SafeParcelable.Field(mo11699id = 6)
    public boolean zzego;

    public zzazh(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzazh(int i, int i2, boolean z, boolean z2) {
        this(203404000, i2, true, false, false);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzazh(int r8, int r9, boolean r10, boolean r11, boolean r12) {
        /*
            r7 = this;
            if (r10 == 0) goto L_0x0005
            java.lang.String r11 = "0"
            goto L_0x0007
        L_0x0005:
            java.lang.String r11 = "1"
        L_0x0007:
            java.lang.String r12 = java.lang.String.valueOf(r11)
            int r12 = r12.length()
            int r12 = r12 + 36
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r12)
            java.lang.String r12 = "afma-sdk-a-v"
            r0.append(r12)
            r0.append(r8)
            java.lang.String r12 = "."
            r0.append(r12)
            r0.append(r9)
            java.lang.String r12 = "."
            r0.append(r12)
            r0.append(r11)
            java.lang.String r2 = r0.toString()
            r6 = 0
            r1 = r7
            r3 = r8
            r4 = r9
            r5 = r10
            r1.<init>((java.lang.String) r2, (int) r3, (int) r4, (boolean) r5, (boolean) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzazh.<init>(int, int, boolean, boolean, boolean):void");
    }

    @SafeParcelable.Constructor
    zzazh(@SafeParcelable.Param(mo11702id = 2) String str, @SafeParcelable.Param(mo11702id = 3) int i, @SafeParcelable.Param(mo11702id = 4) int i2, @SafeParcelable.Param(mo11702id = 5) boolean z, @SafeParcelable.Param(mo11702id = 6) boolean z2) {
        this.zzbrf = str;
        this.zzegl = i;
        this.zzegm = i2;
        this.zzegn = z;
        this.zzego = z2;
    }

    public static zzazh zzzi() {
        return new zzazh(12451009, 12451009, true);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzbrf, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzegl);
        SafeParcelWriter.writeInt(parcel, 4, this.zzegm);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzegn);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzego);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
