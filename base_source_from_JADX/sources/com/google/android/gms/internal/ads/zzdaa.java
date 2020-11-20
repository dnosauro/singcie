package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

public final class zzdaa implements zzdfj<Bundle> {
    private final zzdnn zzfvl;

    public zzdaa(zzdnn zzdnn) {
        Preconditions.checkNotNull(zzdnn, "the targeting must not be null");
        this.zzfvl = zzdnn;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzs(java.lang.Object r14) {
        /*
            r13 = this;
            android.os.Bundle r14 = (android.os.Bundle) r14
            com.google.android.gms.internal.ads.zzdnn r0 = r13.zzfvl
            com.google.android.gms.internal.ads.zzvk r0 = r0.zzhio
            java.lang.String r1 = "http_timeout_millis"
            com.google.android.gms.internal.ads.zzdnn r2 = r13.zzfvl
            com.google.android.gms.internal.ads.zzvk r2 = r2.zzhio
            int r2 = r2.zzchm
            r14.putInt(r1, r2)
            java.lang.String r1 = "slotname"
            com.google.android.gms.internal.ads.zzdnn r2 = r13.zzfvl
            java.lang.String r2 = r2.zzhip
            r14.putString(r1, r2)
            int[] r1 = com.google.android.gms.internal.ads.zzdad.zzgif
            com.google.android.gms.internal.ads.zzdnn r2 = r13.zzfvl
            com.google.android.gms.internal.ads.zzdna r2 = r2.zzhiv
            int r2 = r2.zzhia
            r3 = 1
            int r2 = r2 - r3
            r1 = r1[r2]
            switch(r1) {
                case 1: goto L_0x002d;
                case 2: goto L_0x002a;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0032
        L_0x002a:
            java.lang.String r1 = "is_rewarded_interstitial"
            goto L_0x002f
        L_0x002d:
            java.lang.String r1 = "is_new_rewarded"
        L_0x002f:
            r14.putBoolean(r1, r3)
        L_0x0032:
            java.lang.String r1 = "cust_age"
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMdd"
            java.util.Locale r5 = java.util.Locale.US
            r2.<init>(r4, r5)
            java.util.Date r4 = new java.util.Date
            long r5 = r0.zzcgy
            r4.<init>(r5)
            java.lang.String r2 = r2.format(r4)
            long r4 = r0.zzcgy
            r6 = -1
            r8 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 == 0) goto L_0x0053
            r4 = 1
            goto L_0x0054
        L_0x0053:
            r4 = 0
        L_0x0054:
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.lang.String) r2, (boolean) r4)
            java.lang.String r1 = "extras"
            android.os.Bundle r2 = r0.extras
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (android.os.Bundle) r2)
            java.lang.String r1 = "cust_gender"
            int r2 = r0.zzcgz
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r4 = r0.zzcgz
            r5 = -1
            if (r4 == r5) goto L_0x006d
            r4 = 1
            goto L_0x006e
        L_0x006d:
            r4 = 0
        L_0x006e:
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.lang.Integer) r2, (boolean) r4)
            java.lang.String r1 = "kw"
            java.util.List<java.lang.String> r2 = r0.zzcha
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.util.List<java.lang.String>) r2)
            java.lang.String r1 = "tag_for_child_directed_treatment"
            int r2 = r0.zzadl
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r4 = r0.zzadl
            if (r4 == r5) goto L_0x0086
            r4 = 1
            goto L_0x0087
        L_0x0086:
            r4 = 0
        L_0x0087:
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.lang.Integer) r2, (boolean) r4)
            boolean r1 = r0.zzchb
            if (r1 == 0) goto L_0x0095
            java.lang.String r1 = "test_request"
            boolean r2 = r0.zzchb
            r14.putBoolean(r1, r2)
        L_0x0095:
            java.lang.String r1 = "d_imp_hdr"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            int r4 = r0.versionCode
            r6 = 2
            if (r4 < r6) goto L_0x00a6
            boolean r4 = r0.zzbnx
            if (r4 == 0) goto L_0x00a6
            r4 = 1
            goto L_0x00a7
        L_0x00a6:
            r4 = 0
        L_0x00a7:
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.lang.Integer) r2, (boolean) r4)
            java.lang.String r1 = "ppid"
            java.lang.String r2 = r0.zzchc
            int r4 = r0.versionCode
            if (r4 < r6) goto L_0x00bc
            java.lang.String r4 = r0.zzchc
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00bc
            r4 = 1
            goto L_0x00bd
        L_0x00bc:
            r4 = 0
        L_0x00bd:
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.lang.String) r2, (boolean) r4)
            android.location.Location r1 = r0.zzmy
            if (r1 == 0) goto L_0x0127
            android.location.Location r1 = r0.zzmy
            float r2 = r1.getAccuracy()
            r4 = 1148846080(0x447a0000, float:1000.0)
            float r2 = r2 * r4
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            long r6 = r1.getTime()
            r9 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 * r9
            java.lang.Long r4 = java.lang.Long.valueOf(r6)
            double r6 = r1.getLatitude()
            r9 = 4711630319722168320(0x416312d000000000, double:1.0E7)
            double r6 = r6 * r9
            long r6 = (long) r6
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            double r11 = r1.getLongitude()
            double r11 = r11 * r9
            long r9 = (long) r11
            java.lang.Long r1 = java.lang.Long.valueOf(r9)
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            java.lang.String r9 = "radius"
            float r2 = r2.floatValue()
            r7.putFloat(r9, r2)
            java.lang.String r2 = "lat"
            long r9 = r6.longValue()
            r7.putLong(r2, r9)
            java.lang.String r2 = "long"
            long r9 = r1.longValue()
            r7.putLong(r2, r9)
            java.lang.String r1 = "time"
            long r9 = r4.longValue()
            r7.putLong(r1, r9)
            java.lang.String r1 = "uule"
            r14.putBundle(r1, r7)
        L_0x0127:
            java.lang.String r1 = "url"
            java.lang.String r2 = r0.zzche
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r1 = "neighboring_content_urls"
            java.util.List<java.lang.String> r2 = r0.zzchl
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.util.List<java.lang.String>) r2)
            java.lang.String r1 = "custom_targeting"
            android.os.Bundle r2 = r0.zzchg
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (android.os.Bundle) r2)
            java.lang.String r1 = "category_exclusions"
            java.util.List<java.lang.String> r2 = r0.zzchh
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.util.List<java.lang.String>) r2)
            java.lang.String r1 = "request_agent"
            java.lang.String r2 = r0.zzchi
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r1 = "request_pkg"
            java.lang.String r2 = r0.zzchj
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r1 = "is_designed_for_families"
            boolean r2 = r0.zzchk
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            int r4 = r0.versionCode
            r6 = 7
            if (r4 < r6) goto L_0x0160
            r4 = 1
            goto L_0x0161
        L_0x0160:
            r4 = 0
        L_0x0161:
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.lang.Boolean) r2, (boolean) r4)
            int r1 = r0.versionCode
            r2 = 8
            if (r1 < r2) goto L_0x0182
            java.lang.String r1 = "tag_for_under_age_of_consent"
            int r2 = r0.zzadm
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r4 = r0.zzadm
            if (r4 == r5) goto L_0x0177
            goto L_0x0178
        L_0x0177:
            r3 = 0
        L_0x0178:
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.lang.Integer) r2, (boolean) r3)
            java.lang.String r1 = "max_ad_content_rating"
            java.lang.String r0 = r0.zzadn
            com.google.android.gms.internal.ads.zzdnx.zza((android.os.Bundle) r14, (java.lang.String) r1, (java.lang.String) r0)
        L_0x0182:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdaa.zzs(java.lang.Object):void");
    }
}
