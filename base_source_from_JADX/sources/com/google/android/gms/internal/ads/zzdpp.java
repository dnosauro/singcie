package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public final class zzdpp implements zzdpq {
    private final Object[] zzhme;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x017d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzdpp(com.google.android.gms.internal.ads.zzvk r3, java.lang.String r4, int r5, java.lang.String r6, com.google.android.gms.internal.ads.zzvw r7) {
        /*
            r2 = this;
            r2.<init>()
            java.util.HashSet r0 = new java.util.HashSet
            java.lang.String r1 = ","
            java.lang.String[] r1 = r6.split(r1)
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.add(r6)
            r1.add(r4)
            java.lang.String r4 = "networkType"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x002c
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)
            r1.add(r4)
        L_0x002c:
            java.lang.String r4 = "birthday"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x003d
            long r4 = r3.zzcgy
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.add(r4)
        L_0x003d:
            java.lang.String r4 = "extras"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x004f
            android.os.Bundle r4 = r3.extras
            java.lang.String r4 = zzq(r4)
        L_0x004b:
            r1.add(r4)
            goto L_0x0060
        L_0x004f:
            java.lang.String r4 = "npa"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0060
            android.os.Bundle r4 = r3.extras
            java.lang.String r5 = "npa"
            java.lang.String r4 = r4.getString(r5)
            goto L_0x004b
        L_0x0060:
            java.lang.String r4 = "gender"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0071
            int r4 = r3.zzcgz
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.add(r4)
        L_0x0071:
            java.lang.String r4 = "keywords"
            boolean r4 = r0.contains(r4)
            r5 = 0
            if (r4 == 0) goto L_0x008b
            java.util.List<java.lang.String> r4 = r3.zzcha
            if (r4 == 0) goto L_0x0088
            java.util.List<java.lang.String> r4 = r3.zzcha
            java.lang.String r4 = r4.toString()
            r1.add(r4)
            goto L_0x008b
        L_0x0088:
            r1.add(r5)
        L_0x008b:
            java.lang.String r4 = "isTestDevice"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x009c
            boolean r4 = r3.zzchb
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r1.add(r4)
        L_0x009c:
            java.lang.String r4 = "tagForChildDirectedTreatment"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x00ad
            int r4 = r3.zzadl
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.add(r4)
        L_0x00ad:
            java.lang.String r4 = "manualImpressionsEnabled"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x00be
            boolean r4 = r3.zzbnx
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r1.add(r4)
        L_0x00be:
            java.lang.String r4 = "publisherProvidedId"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x00cb
            java.lang.String r4 = r3.zzchc
            r1.add(r4)
        L_0x00cb:
            java.lang.String r4 = "location"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x00e4
            android.location.Location r4 = r3.zzmy
            if (r4 == 0) goto L_0x00e1
            android.location.Location r4 = r3.zzmy
            java.lang.String r4 = r4.toString()
            r1.add(r4)
            goto L_0x00e4
        L_0x00e1:
            r1.add(r5)
        L_0x00e4:
            java.lang.String r4 = "contentUrl"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x00f1
            java.lang.String r4 = r3.zzche
            r1.add(r4)
        L_0x00f1:
            java.lang.String r4 = "networkExtras"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0102
            android.os.Bundle r4 = r3.zzchf
            java.lang.String r4 = zzq(r4)
            r1.add(r4)
        L_0x0102:
            java.lang.String r4 = "customTargeting"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0113
            android.os.Bundle r4 = r3.zzchg
            java.lang.String r4 = zzq(r4)
            r1.add(r4)
        L_0x0113:
            java.lang.String r4 = "categoryExclusions"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x012c
            java.util.List<java.lang.String> r4 = r3.zzchh
            if (r4 == 0) goto L_0x0129
            java.util.List<java.lang.String> r4 = r3.zzchh
            java.lang.String r4 = r4.toString()
            r1.add(r4)
            goto L_0x012c
        L_0x0129:
            r1.add(r5)
        L_0x012c:
            java.lang.String r4 = "requestAgent"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0139
            java.lang.String r4 = r3.zzchi
            r1.add(r4)
        L_0x0139:
            java.lang.String r4 = "requestPackage"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0146
            java.lang.String r4 = r3.zzchj
            r1.add(r4)
        L_0x0146:
            java.lang.String r4 = "isDesignedForFamilies"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0157
            boolean r4 = r3.zzchk
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r1.add(r4)
        L_0x0157:
            java.lang.String r4 = "tagForUnderAgeOfConsent"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0168
            int r4 = r3.zzadm
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.add(r4)
        L_0x0168:
            java.lang.String r4 = "maxAdContentRating"
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x0175
            java.lang.String r3 = r3.zzadn
            r1.add(r3)
        L_0x0175:
            java.lang.String r3 = "orientation"
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto L_0x018c
            if (r7 == 0) goto L_0x0189
            int r3 = r7.orientation
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.add(r3)
            goto L_0x018c
        L_0x0189:
            r1.add(r5)
        L_0x018c:
            java.lang.Object[] r3 = r1.toArray()
            r2.zzhme = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpp.<init>(com.google.android.gms.internal.ads.zzvk, java.lang.String, int, java.lang.String, com.google.android.gms.internal.ads.zzvw):void");
    }

    private static String zzq(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            sb.append(obj == null ? "null" : obj instanceof Bundle ? zzq((Bundle) obj) : obj.toString());
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzdpp)) {
            return false;
        }
        return Arrays.equals(this.zzhme, ((zzdpp) obj).zzhme);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzhme);
    }

    public final String toString() {
        int hashCode = hashCode();
        String arrays = Arrays.toString(this.zzhme);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 22);
        sb.append("[PoolKey#");
        sb.append(hashCode);
        sb.append(" ");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
