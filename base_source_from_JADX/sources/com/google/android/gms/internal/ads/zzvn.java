package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
public class zzvn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvn> CREATOR = new zzvq();
    @SafeParcelable.Field(mo11699id = 3)
    public final int height;
    @SafeParcelable.Field(mo11699id = 4)
    public final int heightPixels;
    @SafeParcelable.Field(mo11699id = 6)
    public final int width;
    @SafeParcelable.Field(mo11699id = 7)
    public final int widthPixels;
    @SafeParcelable.Field(mo11699id = 2)
    public final String zzacv;
    @SafeParcelable.Field(mo11699id = 9)
    public final boolean zzbrh;
    @SafeParcelable.Field(mo11699id = 5)
    public final boolean zzchp;
    @SafeParcelable.Field(mo11699id = 8)
    public final zzvn[] zzchq;
    @SafeParcelable.Field(mo11699id = 10)
    public final boolean zzchr;
    @SafeParcelable.Field(mo11699id = 11)
    public boolean zzchs;
    @SafeParcelable.Field(mo11699id = 12)
    public boolean zzcht;
    @SafeParcelable.Field(mo11699id = 13)
    private boolean zzchu;
    @SafeParcelable.Field(mo11699id = 14)
    public boolean zzchv;
    @SafeParcelable.Field(mo11699id = 15)
    public boolean zzchw;

    public zzvn() {
        this("interstitial_mb", 0, 0, true, 0, 0, (zzvn[]) null, false, false, false, false, false, false, false);
    }

    public zzvn(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzvn(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            r12 = this;
            r12.<init>()
            r0 = 0
            r1 = r14[r0]
            r12.zzchp = r0
            boolean r2 = r1.isFluid()
            r12.zzchr = r2
            boolean r2 = com.google.android.gms.ads.zzb.zza(r1)
            r12.zzchv = r2
            boolean r2 = com.google.android.gms.ads.zzb.zzb(r1)
            r12.zzchw = r2
            boolean r2 = r12.zzchr
            if (r2 == 0) goto L_0x002f
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getWidth()
            r12.width = r2
            com.google.android.gms.ads.AdSize r2 = com.google.android.gms.ads.AdSize.BANNER
            int r2 = r2.getHeight()
        L_0x002c:
            r12.height = r2
            goto L_0x0049
        L_0x002f:
            boolean r2 = r12.zzchw
            if (r2 == 0) goto L_0x003e
            int r2 = r1.getWidth()
            r12.width = r2
            int r2 = com.google.android.gms.ads.zzb.zzc(r1)
            goto L_0x002c
        L_0x003e:
            int r2 = r1.getWidth()
            r12.width = r2
            int r2 = r1.getHeight()
            goto L_0x002c
        L_0x0049:
            int r2 = r12.width
            r3 = -1
            r4 = 1
            if (r2 != r3) goto L_0x0051
            r2 = 1
            goto L_0x0052
        L_0x0051:
            r2 = 0
        L_0x0052:
            int r3 = r12.height
            r5 = -2
            if (r3 != r5) goto L_0x0059
            r3 = 1
            goto L_0x005a
        L_0x0059:
            r3 = 0
        L_0x005a:
            android.content.res.Resources r5 = r13.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            if (r2 == 0) goto L_0x009b
            com.google.android.gms.internal.ads.zzwq.zzqa()
            boolean r6 = com.google.android.gms.internal.ads.zzayr.zzbq(r13)
            if (r6 == 0) goto L_0x0081
            com.google.android.gms.internal.ads.zzwq.zzqa()
            boolean r6 = com.google.android.gms.internal.ads.zzayr.zzbr(r13)
            if (r6 == 0) goto L_0x0081
            int r6 = r5.widthPixels
            com.google.android.gms.internal.ads.zzwq.zzqa()
            int r7 = com.google.android.gms.internal.ads.zzayr.zzbs(r13)
            int r6 = r6 - r7
            goto L_0x0083
        L_0x0081:
            int r6 = r5.widthPixels
        L_0x0083:
            r12.widthPixels = r6
            int r6 = r12.widthPixels
            float r6 = (float) r6
            float r7 = r5.density
            float r6 = r6 / r7
            double r6 = (double) r6
            int r8 = (int) r6
            double r9 = (double) r8
            double r6 = r6 - r9
            r9 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
            int r11 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x00a8
            int r8 = r8 + 1
            goto L_0x00a8
        L_0x009b:
            int r8 = r12.width
            com.google.android.gms.internal.ads.zzwq.zzqa()
            int r6 = r12.width
            int r6 = com.google.android.gms.internal.ads.zzayr.zza((android.util.DisplayMetrics) r5, (int) r6)
            r12.widthPixels = r6
        L_0x00a8:
            if (r3 == 0) goto L_0x00af
            int r6 = zzd(r5)
            goto L_0x00b1
        L_0x00af:
            int r6 = r12.height
        L_0x00b1:
            com.google.android.gms.internal.ads.zzwq.zzqa()
            int r5 = com.google.android.gms.internal.ads.zzayr.zza((android.util.DisplayMetrics) r5, (int) r6)
            r12.heightPixels = r5
            r5 = 26
            if (r2 != 0) goto L_0x00ef
            if (r3 == 0) goto L_0x00c1
            goto L_0x00ef
        L_0x00c1:
            boolean r2 = r12.zzchw
            if (r2 == 0) goto L_0x00e3
            int r1 = r12.width
            int r2 = r12.height
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r5)
            r3.append(r1)
            java.lang.String r1 = "x"
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = "_as"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            goto L_0x0108
        L_0x00e3:
            boolean r2 = r12.zzchr
            if (r2 == 0) goto L_0x00ea
            java.lang.String r1 = "320x50_mb"
            goto L_0x0108
        L_0x00ea:
            java.lang.String r1 = r1.toString()
            goto L_0x0108
        L_0x00ef:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            r1.append(r8)
            java.lang.String r2 = "x"
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = "_as"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
        L_0x0108:
            r12.zzacv = r1
            int r1 = r14.length
            if (r1 <= r4) goto L_0x0124
            int r1 = r14.length
            com.google.android.gms.internal.ads.zzvn[] r1 = new com.google.android.gms.internal.ads.zzvn[r1]
            r12.zzchq = r1
            r1 = 0
        L_0x0113:
            int r2 = r14.length
            if (r1 >= r2) goto L_0x0127
            com.google.android.gms.internal.ads.zzvn[] r2 = r12.zzchq
            com.google.android.gms.internal.ads.zzvn r3 = new com.google.android.gms.internal.ads.zzvn
            r4 = r14[r1]
            r3.<init>((android.content.Context) r13, (com.google.android.gms.ads.AdSize) r4)
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x0113
        L_0x0124:
            r13 = 0
            r12.zzchq = r13
        L_0x0127:
            r12.zzbrh = r0
            r12.zzchs = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvn.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    @SafeParcelable.Constructor
    zzvn(@SafeParcelable.Param(mo11702id = 2) String str, @SafeParcelable.Param(mo11702id = 3) int i, @SafeParcelable.Param(mo11702id = 4) int i2, @SafeParcelable.Param(mo11702id = 5) boolean z, @SafeParcelable.Param(mo11702id = 6) int i3, @SafeParcelable.Param(mo11702id = 7) int i4, @SafeParcelable.Param(mo11702id = 8) zzvn[] zzvnArr, @SafeParcelable.Param(mo11702id = 9) boolean z2, @SafeParcelable.Param(mo11702id = 10) boolean z3, @SafeParcelable.Param(mo11702id = 11) boolean z4, @SafeParcelable.Param(mo11702id = 12) boolean z5, @SafeParcelable.Param(mo11702id = 13) boolean z6, @SafeParcelable.Param(mo11702id = 14) boolean z7, @SafeParcelable.Param(mo11702id = 15) boolean z8) {
        this.zzacv = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzchp = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzchq = zzvnArr;
        this.zzbrh = z2;
        this.zzchr = z3;
        this.zzchs = z4;
        this.zzcht = z5;
        this.zzchu = z6;
        this.zzchv = z7;
        this.zzchw = z8;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (((float) zzd(displayMetrics)) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzvn zzpo() {
        return new zzvn("320x50_mb", 0, 0, false, 0, 0, (zzvn[]) null, true, false, false, false, false, false, false);
    }

    public static zzvn zzpp() {
        return new zzvn("reward_mb", 0, 0, true, 0, 0, (zzvn[]) null, false, false, false, false, false, false, false);
    }

    public static zzvn zzpq() {
        return new zzvn("interstitial_mb", 0, 0, false, 0, 0, (zzvn[]) null, false, false, false, false, true, false, false);
    }

    public static zzvn zzpr() {
        return new zzvn("invalid", 0, 0, false, 0, 0, (zzvn[]) null, false, false, false, true, false, false, false);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzacv, false);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.heightPixels);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzchp);
        SafeParcelWriter.writeInt(parcel, 6, this.width);
        SafeParcelWriter.writeInt(parcel, 7, this.widthPixels);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzchq, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbrh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzchr);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzchs);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzcht);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzchu);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzchv);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzchw);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AdSize zzps() {
        return zzb.zza(this.width, this.height, this.zzacv);
    }
}
