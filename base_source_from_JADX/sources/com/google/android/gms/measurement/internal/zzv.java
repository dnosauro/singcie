package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbv;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

abstract class zzv {
    String zza;
    int zzb;
    Boolean zzc;
    Boolean zzd;
    Long zze;
    Long zzf;

    zzv(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    static Boolean zza(double d, zzbv.zzd zzd2) {
        try {
            return zza(new BigDecimal(d), zzd2, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(long j, zzbv.zzd zzd2) {
        try {
            return zza(new BigDecimal(j), zzd2, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @VisibleForTesting
    static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    static Boolean zza(String str, zzbv.zzd zzd2) {
        if (!zzkt.zza(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzd2, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static Boolean zza(String str, zzbv.zzf.zzb zzb2, boolean z, String str2, List<String> list, String str3, zzex zzex) {
        boolean startsWith;
        if (str == null) {
            return null;
        }
        if (zzb2 == zzbv.zzf.zzb.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzb2 != zzbv.zzf.zzb.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzb2) {
            case REGEXP:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzex != null) {
                        zzex.zzh().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case BEGINS_WITH:
                startsWith = str.startsWith(str2);
                break;
            case ENDS_WITH:
                startsWith = str.endsWith(str2);
                break;
            case PARTIAL:
                startsWith = str.contains(str2);
                break;
            case EXACT:
                startsWith = str.equals(str2);
                break;
            case IN_LIST:
                startsWith = list.contains(str);
                break;
            default:
                return null;
        }
        return Boolean.valueOf(startsWith);
    }

    @VisibleForTesting
    static Boolean zza(String str, zzbv.zzf zzf2, zzex zzex) {
        List<String> list;
        Preconditions.checkNotNull(zzf2);
        if (str == null || !zzf2.zza() || zzf2.zzb() == zzbv.zzf.zzb.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (zzf2.zzb() == zzbv.zzf.zzb.IN_LIST) {
            if (zzf2.zzh() == 0) {
                return null;
            }
        } else if (!zzf2.zzc()) {
            return null;
        }
        zzbv.zzf.zzb zzb2 = zzf2.zzb();
        boolean zzf3 = zzf2.zzf();
        String zzd2 = (zzf3 || zzb2 == zzbv.zzf.zzb.REGEXP || zzb2 == zzbv.zzf.zzb.IN_LIST) ? zzf2.zzd() : zzf2.zzd().toUpperCase(Locale.ENGLISH);
        if (zzf2.zzh() == 0) {
            list = null;
        } else {
            List<String> zzg = zzf2.zzg();
            if (!zzf3) {
                ArrayList arrayList = new ArrayList(zzg.size());
                for (String upperCase : zzg) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                zzg = Collections.unmodifiableList(arrayList);
            }
            list = zzg;
        }
        return zza(str, zzb2, zzf3, zzd2, list, zzb2 == zzbv.zzf.zzb.REGEXP ? zzd2 : null, zzex);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r2 != null) goto L_0x0086;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean zza(java.math.BigDecimal r7, com.google.android.gms.internal.measurement.zzbv.zzd r8, double r9) {
        /*
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            boolean r0 = r8.zza()
            r1 = 0
            if (r0 == 0) goto L_0x0108
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r0 = r8.zzb()
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r2 = com.google.android.gms.internal.measurement.zzbv.zzd.zza.UNKNOWN_COMPARISON_TYPE
            if (r0 != r2) goto L_0x0014
            goto L_0x0108
        L_0x0014:
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r0 = r8.zzb()
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r2 = com.google.android.gms.internal.measurement.zzbv.zzd.zza.BETWEEN
            if (r0 != r2) goto L_0x0029
            boolean r0 = r8.zzg()
            if (r0 == 0) goto L_0x0028
            boolean r0 = r8.zzi()
            if (r0 != 0) goto L_0x0030
        L_0x0028:
            return r1
        L_0x0029:
            boolean r0 = r8.zze()
            if (r0 != 0) goto L_0x0030
            return r1
        L_0x0030:
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r0 = r8.zzb()
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r2 = r8.zzb()
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r3 = com.google.android.gms.internal.measurement.zzbv.zzd.zza.BETWEEN
            if (r2 != r3) goto L_0x0067
            java.lang.String r2 = r8.zzh()
            boolean r2 = com.google.android.gms.measurement.internal.zzkt.zza((java.lang.String) r2)
            if (r2 == 0) goto L_0x0066
            java.lang.String r2 = r8.zzj()
            boolean r2 = com.google.android.gms.measurement.internal.zzkt.zza((java.lang.String) r2)
            if (r2 != 0) goto L_0x0051
            goto L_0x0066
        L_0x0051:
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0066 }
            java.lang.String r3 = r8.zzh()     // Catch:{ NumberFormatException -> 0x0066 }
            r2.<init>(r3)     // Catch:{ NumberFormatException -> 0x0066 }
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0066 }
            java.lang.String r8 = r8.zzj()     // Catch:{ NumberFormatException -> 0x0066 }
            r3.<init>(r8)     // Catch:{ NumberFormatException -> 0x0066 }
            r8 = r2
            r2 = r1
            goto L_0x007d
        L_0x0066:
            return r1
        L_0x0067:
            java.lang.String r2 = r8.zzf()
            boolean r2 = com.google.android.gms.measurement.internal.zzkt.zza((java.lang.String) r2)
            if (r2 != 0) goto L_0x0072
            return r1
        L_0x0072:
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0108 }
            java.lang.String r8 = r8.zzf()     // Catch:{ NumberFormatException -> 0x0108 }
            r2.<init>(r8)     // Catch:{ NumberFormatException -> 0x0108 }
            r8 = r1
            r3 = r8
        L_0x007d:
            com.google.android.gms.internal.measurement.zzbv$zzd$zza r4 = com.google.android.gms.internal.measurement.zzbv.zzd.zza.BETWEEN
            if (r0 != r4) goto L_0x0084
            if (r8 != 0) goto L_0x0086
            return r1
        L_0x0084:
            if (r2 == 0) goto L_0x0108
        L_0x0086:
            int[] r4 = com.google.android.gms.measurement.internal.zzr.zzb
            int r0 = r0.ordinal()
            r0 = r4[r0]
            r4 = -1
            r5 = 0
            r6 = 1
            switch(r0) {
                case 1: goto L_0x00fc;
                case 2: goto L_0x00f0;
                case 3: goto L_0x00a7;
                case 4: goto L_0x0095;
                default: goto L_0x0094;
            }
        L_0x0094:
            goto L_0x0108
        L_0x0095:
            int r8 = r7.compareTo(r8)
            if (r8 == r4) goto L_0x00a2
            int r7 = r7.compareTo(r3)
            if (r7 == r6) goto L_0x00a2
            r5 = 1
        L_0x00a2:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x00a7:
            r0 = 0
            int r8 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r8 == 0) goto L_0x00e4
            java.math.BigDecimal r8 = new java.math.BigDecimal
            r8.<init>(r9)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r1 = 2
            r0.<init>(r1)
            java.math.BigDecimal r8 = r8.multiply(r0)
            java.math.BigDecimal r8 = r2.subtract(r8)
            int r8 = r7.compareTo(r8)
            if (r8 != r6) goto L_0x00df
            java.math.BigDecimal r8 = new java.math.BigDecimal
            r8.<init>(r9)
            java.math.BigDecimal r9 = new java.math.BigDecimal
            r9.<init>(r1)
            java.math.BigDecimal r8 = r8.multiply(r9)
            java.math.BigDecimal r8 = r2.add(r8)
            int r7 = r7.compareTo(r8)
            if (r7 != r4) goto L_0x00df
            r5 = 1
        L_0x00df:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x00e4:
            int r7 = r7.compareTo(r2)
            if (r7 != 0) goto L_0x00eb
            r5 = 1
        L_0x00eb:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x00f0:
            int r7 = r7.compareTo(r2)
            if (r7 != r6) goto L_0x00f7
            r5 = 1
        L_0x00f7:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x00fc:
            int r7 = r7.compareTo(r2)
            if (r7 != r4) goto L_0x0103
            r5 = 1
        L_0x0103:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r5)
            return r7
        L_0x0108:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzv.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzbv$zzd, double):java.lang.Boolean");
    }

    /* access modifiers changed from: package-private */
    public abstract int zza();

    /* access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* access modifiers changed from: package-private */
    public abstract boolean zzc();
}
