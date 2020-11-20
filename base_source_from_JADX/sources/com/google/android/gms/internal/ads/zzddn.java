package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.android.gms.ads.internal.util.zzf;
import java.util.ArrayList;

public final class zzddn implements zzdfi<zzddk> {
    private final PackageInfo zzdss;
    private final zzf zzebt;
    private final zzdnn zzfvl;
    private final zzdzc zzggb;

    public zzddn(zzdzc zzdzc, zzdnn zzdnn, PackageInfo packageInfo, zzf zzf) {
        this.zzggb = zzdzc;
        this.zzfvl = zzdnn;
        this.zzdss = packageInfo;
        this.zzebt = zzf;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011b, code lost:
        r5 = "p";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(java.util.ArrayList r5, android.os.Bundle r6) {
        /*
            r4 = this;
            java.lang.String r0 = "native_version"
            r1 = 3
            r6.putInt(r0, r1)
            java.lang.String r0 = "native_templates"
            r6.putStringArrayList(r0, r5)
            java.lang.String r5 = "native_custom_templates"
            com.google.android.gms.internal.ads.zzdnn r0 = r4.zzfvl
            java.util.ArrayList<java.lang.String> r0 = r0.zzhir
            r6.putStringArrayList(r5, r0)
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zzabf.zzcsc
            com.google.android.gms.internal.ads.zzabb r0 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r5 = r0.zzd(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            r0 = 1
            if (r5 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzdnn r5 = r4.zzfvl
            com.google.android.gms.internal.ads.zzadz r5 = r5.zzdnh
            int r5 = r5.versionCode
            if (r5 <= r1) goto L_0x0058
            java.lang.String r5 = "enable_native_media_orientation"
            r6.putBoolean(r5, r0)
            com.google.android.gms.internal.ads.zzdnn r5 = r4.zzfvl
            com.google.android.gms.internal.ads.zzadz r5 = r5.zzdnh
            int r5 = r5.zzbnn
            switch(r5) {
                case 1: goto L_0x0049;
                case 2: goto L_0x0046;
                case 3: goto L_0x0043;
                case 4: goto L_0x0040;
                default: goto L_0x003d;
            }
        L_0x003d:
            java.lang.String r5 = "unknown"
            goto L_0x004b
        L_0x0040:
            java.lang.String r5 = "square"
            goto L_0x004b
        L_0x0043:
            java.lang.String r5 = "portrait"
            goto L_0x004b
        L_0x0046:
            java.lang.String r5 = "landscape"
            goto L_0x004b
        L_0x0049:
            java.lang.String r5 = "any"
        L_0x004b:
            java.lang.String r1 = "unknown"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0058
            java.lang.String r1 = "native_media_orientation"
            r6.putString(r1, r5)
        L_0x0058:
            com.google.android.gms.internal.ads.zzdnn r5 = r4.zzfvl
            com.google.android.gms.internal.ads.zzadz r5 = r5.zzdnh
            int r5 = r5.zzbnm
            switch(r5) {
                case 0: goto L_0x006a;
                case 1: goto L_0x0067;
                case 2: goto L_0x0064;
                default: goto L_0x0061;
            }
        L_0x0061:
            java.lang.String r5 = "unknown"
            goto L_0x006c
        L_0x0064:
            java.lang.String r5 = "landscape"
            goto L_0x006c
        L_0x0067:
            java.lang.String r5 = "portrait"
            goto L_0x006c
        L_0x006a:
            java.lang.String r5 = "any"
        L_0x006c:
            java.lang.String r1 = "unknown"
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x0079
            java.lang.String r1 = "native_image_orientation"
            r6.putString(r1, r5)
        L_0x0079:
            java.lang.String r5 = "native_multiple_images"
            com.google.android.gms.internal.ads.zzdnn r1 = r4.zzfvl
            com.google.android.gms.internal.ads.zzadz r1 = r1.zzdnh
            boolean r1 = r1.zzbno
            r6.putBoolean(r5, r1)
            java.lang.String r5 = "use_custom_mute"
            com.google.android.gms.internal.ads.zzdnn r1 = r4.zzfvl
            com.google.android.gms.internal.ads.zzadz r1 = r1.zzdnh
            boolean r1 = r1.zzbnr
            r6.putBoolean(r5, r1)
            android.content.pm.PackageInfo r5 = r4.zzdss
            if (r5 != 0) goto L_0x0095
            r5 = 0
            goto L_0x0097
        L_0x0095:
            int r5 = r5.versionCode
        L_0x0097:
            com.google.android.gms.ads.internal.util.zzf r1 = r4.zzebt
            int r1 = r1.zzxu()
            if (r5 <= r1) goto L_0x00a9
            com.google.android.gms.ads.internal.util.zzf r1 = r4.zzebt
            r1.zzya()
            com.google.android.gms.ads.internal.util.zzf r1 = r4.zzebt
            r1.zzde(r5)
        L_0x00a9:
            com.google.android.gms.ads.internal.util.zzf r5 = r4.zzebt
            org.json.JSONObject r5 = r5.zzxz()
            if (r5 == 0) goto L_0x00c0
            com.google.android.gms.internal.ads.zzdnn r1 = r4.zzfvl
            java.lang.String r1 = r1.zzhip
            org.json.JSONArray r5 = r5.optJSONArray(r1)
            if (r5 == 0) goto L_0x00c0
            java.lang.String r5 = r5.toString()
            goto L_0x00c1
        L_0x00c0:
            r5 = 0
        L_0x00c1:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L_0x00cc
            java.lang.String r1 = "native_advanced_settings"
            r6.putString(r1, r5)
        L_0x00cc:
            com.google.android.gms.internal.ads.zzdnn r5 = r4.zzfvl
            int r5 = r5.zzgwz
            if (r5 <= r0) goto L_0x00db
            java.lang.String r5 = "max_num_ads"
            com.google.android.gms.internal.ads.zzdnn r1 = r4.zzfvl
            int r1 = r1.zzgwz
            r6.putInt(r5, r1)
        L_0x00db:
            com.google.android.gms.internal.ads.zzdnn r5 = r4.zzfvl
            com.google.android.gms.internal.ads.zzajl r5 = r5.zzdui
            if (r5 == 0) goto L_0x012a
            java.lang.String r1 = r5.zzdhu
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x011e
            java.lang.String r1 = "ia_var"
            int r2 = r5.versionCode
            r3 = 2
            if (r2 < r3) goto L_0x00f6
            int r5 = r5.zzbnn
            switch(r5) {
                case 2: goto L_0x0118;
                case 3: goto L_0x011b;
                default: goto L_0x00f5;
            }
        L_0x00f5:
            goto L_0x0118
        L_0x00f6:
            int r2 = r5.zzdht
            switch(r2) {
                case 1: goto L_0x0118;
                case 2: goto L_0x011b;
                default: goto L_0x00fb;
            }
        L_0x00fb:
            int r5 = r5.zzdht
            r2 = 52
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Instream ad video aspect ratio "
            r3.append(r2)
            r3.append(r5)
            java.lang.String r5 = " is wrong."
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            com.google.android.gms.internal.ads.zzaza.zzey(r5)
        L_0x0118:
            java.lang.String r5 = "l"
            goto L_0x0122
        L_0x011b:
            java.lang.String r5 = "p"
            goto L_0x0122
        L_0x011e:
            java.lang.String r1 = "ad_tag"
            java.lang.String r5 = r5.zzdhu
        L_0x0122:
            r6.putString(r1, r5)
            java.lang.String r5 = "instr"
            r6.putBoolean(r5, r0)
        L_0x012a:
            com.google.android.gms.internal.ads.zzdnn r5 = r4.zzfvl
            com.google.android.gms.internal.ads.zzagd r5 = r5.zzaun()
            if (r5 == 0) goto L_0x0137
            java.lang.String r5 = "has_delayed_banner_listener"
            r6.putBoolean(r5, r0)
        L_0x0137:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzddn.zza(java.util.ArrayList, android.os.Bundle):void");
    }

    public final zzdyz<zzddk> zzasm() {
        return this.zzggb.zze(new zzddm(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzddk zzasw() {
        ArrayList<String> arrayList = this.zzfvl.zzhiq;
        return arrayList == null ? zzddp.zzhag : arrayList.isEmpty() ? zzddo.zzhag : new zzddr(this, arrayList);
    }
}
