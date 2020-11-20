package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;

public final class zzdtz {
    private final SharedPreferences zzclm;
    private final File zzhrl;
    @VisibleForTesting
    private final File zzhrm;
    private final zzgn zzvu;

    public zzdtz(Context context, zzgn zzgn) {
        this.zzclm = context.getSharedPreferences("pcvmspf", 0);
        this.zzhrl = zzduc.zza(context.getDir("pccache", 0), false);
        this.zzhrm = zzduc.zza(context.getDir("tmppccache", 0), true);
        this.zzvu = zzgn;
    }

    @VisibleForTesting
    private static String zza(zzgt zzgt) {
        return Hex.bytesToStringLowercase(zzgt.zzbfg().toByteArray());
    }

    private final File zzaxw() {
        File file = new File(this.zzhrl, Integer.toString(this.zzvu.zzv()));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zzaxx() {
        int zzv = this.zzvu.zzv();
        StringBuilder sb = new StringBuilder(17);
        sb.append("FBAMTD");
        sb.append(zzv);
        return sb.toString();
    }

    private final String zzaxy() {
        int zzv = this.zzvu.zzv();
        StringBuilder sb = new StringBuilder(17);
        sb.append("LATMTD");
        sb.append(zzv);
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0022 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023 A[SYNTHETIC, Splitter:B:11:0x0023] */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzgt zzej(int r6) {
        /*
            r5 = this;
            int r0 = com.google.android.gms.internal.ads.zzduh.zzhru
            r1 = 0
            if (r6 != r0) goto L_0x0010
            android.content.SharedPreferences r6 = r5.zzclm
            java.lang.String r0 = r5.zzaxy()
        L_0x000b:
            java.lang.String r6 = r6.getString(r0, r1)
            goto L_0x001c
        L_0x0010:
            int r0 = com.google.android.gms.internal.ads.zzduh.zzhrv
            if (r6 != r0) goto L_0x001b
            android.content.SharedPreferences r6 = r5.zzclm
            java.lang.String r0 = r5.zzaxx()
            goto L_0x000b
        L_0x001b:
            r6 = r1
        L_0x001c:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x0023
            return r1
        L_0x0023:
            byte[] r6 = com.google.android.gms.common.util.Hex.stringToBytes(r6)     // Catch:{ zzeks -> 0x0069 }
            com.google.android.gms.internal.ads.zzeiu r6 = com.google.android.gms.internal.ads.zzeiu.zzt(r6)     // Catch:{ zzeks -> 0x0069 }
            com.google.android.gms.internal.ads.zzgt r6 = com.google.android.gms.internal.ads.zzgt.zzl(r6)     // Catch:{ zzeks -> 0x0069 }
            java.lang.String r0 = r6.zzdg()     // Catch:{ zzeks -> 0x0069 }
            java.lang.String r2 = "pcam.jar"
            java.io.File r3 = r5.zzaxw()     // Catch:{ zzeks -> 0x0069 }
            java.io.File r2 = com.google.android.gms.internal.ads.zzduc.zza(r0, r2, r3)     // Catch:{ zzeks -> 0x0069 }
            boolean r3 = r2.exists()     // Catch:{ zzeks -> 0x0069 }
            if (r3 != 0) goto L_0x004d
            java.lang.String r2 = "pcam"
            java.io.File r3 = r5.zzaxw()     // Catch:{ zzeks -> 0x0069 }
            java.io.File r2 = com.google.android.gms.internal.ads.zzduc.zza(r0, r2, r3)     // Catch:{ zzeks -> 0x0069 }
        L_0x004d:
            java.lang.String r3 = "pcbc"
            java.io.File r4 = r5.zzaxw()     // Catch:{ zzeks -> 0x0069 }
            java.io.File r0 = com.google.android.gms.internal.ads.zzduc.zza(r0, r3, r4)     // Catch:{ zzeks -> 0x0069 }
            boolean r2 = r2.exists()     // Catch:{ zzeks -> 0x0069 }
            if (r2 == 0) goto L_0x0065
            boolean r0 = r0.exists()     // Catch:{ zzeks -> 0x0069 }
            if (r0 == 0) goto L_0x0065
            r0 = 1
            goto L_0x0066
        L_0x0065:
            r0 = 0
        L_0x0066:
            if (r0 == 0) goto L_0x0069
            return r6
        L_0x0069:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdtz.zzej(int):com.google.android.gms.internal.ads.zzgt");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x014a, code lost:
        if (r0.commit() != false) goto L_0x014e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x017c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzgp r8, com.google.android.gms.internal.ads.zzduf r9) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzgt r0 = r8.zzdc()
            java.lang.String r0 = r0.zzdg()
            com.google.android.gms.internal.ads.zzeiu r1 = r8.zzdd()
            byte[] r1 = r1.toByteArray()
            com.google.android.gms.internal.ads.zzeiu r2 = r8.zzde()
            byte[] r2 = r2.toByteArray()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            r4 = 0
            if (r3 != 0) goto L_0x0059
            if (r2 == 0) goto L_0x0059
            int r3 = r2.length
            if (r3 != 0) goto L_0x0025
            goto L_0x0059
        L_0x0025:
            java.io.File r3 = r7.zzhrm
            com.google.android.gms.internal.ads.zzduc.zze(r3)
            java.io.File r3 = r7.zzhrm
            r3.mkdirs()
            java.io.File r3 = r7.zzhrm
            java.io.File r3 = com.google.android.gms.internal.ads.zzduc.zza((java.lang.String) r0, (java.io.File) r3)
            r3.mkdirs()
            java.lang.String r3 = "pcam.jar"
            java.io.File r5 = r7.zzhrm
            java.io.File r3 = com.google.android.gms.internal.ads.zzduc.zza(r0, r3, r5)
            if (r1 == 0) goto L_0x004c
            int r5 = r1.length
            if (r5 <= 0) goto L_0x004c
            boolean r1 = com.google.android.gms.internal.ads.zzduc.zza((java.io.File) r3, (byte[]) r1)
            if (r1 != 0) goto L_0x004c
            goto L_0x0059
        L_0x004c:
            java.lang.String r1 = "pcbc"
            java.io.File r3 = r7.zzhrm
            java.io.File r0 = com.google.android.gms.internal.ads.zzduc.zza(r0, r1, r3)
            boolean r0 = com.google.android.gms.internal.ads.zzduc.zza((java.io.File) r0, (byte[]) r2)
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            if (r0 != 0) goto L_0x005d
            return r4
        L_0x005d:
            com.google.android.gms.internal.ads.zzgt r0 = r8.zzdc()
            java.lang.String r0 = r0.zzdg()
            java.lang.String r1 = "pcam.jar"
            java.io.File r2 = r7.zzhrm
            java.io.File r0 = com.google.android.gms.internal.ads.zzduc.zza(r0, r1, r2)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x007c
            if (r9 == 0) goto L_0x007c
            boolean r9 = r9.zzb(r0)
            if (r9 != 0) goto L_0x007c
            return r4
        L_0x007c:
            com.google.android.gms.internal.ads.zzgt r9 = r8.zzdc()
            java.lang.String r9 = r9.zzdg()
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            r1 = 1
            if (r0 != 0) goto L_0x00c9
            java.lang.String r0 = "pcam.jar"
            java.io.File r2 = r7.zzhrm
            java.io.File r0 = com.google.android.gms.internal.ads.zzduc.zza(r9, r0, r2)
            java.lang.String r2 = "pcbc"
            java.io.File r3 = r7.zzhrm
            java.io.File r2 = com.google.android.gms.internal.ads.zzduc.zza(r9, r2, r3)
            java.lang.String r3 = "pcam.jar"
            java.io.File r5 = r7.zzaxw()
            java.io.File r3 = com.google.android.gms.internal.ads.zzduc.zza(r9, r3, r5)
            java.lang.String r5 = "pcbc"
            java.io.File r6 = r7.zzaxw()
            java.io.File r9 = com.google.android.gms.internal.ads.zzduc.zza(r9, r5, r6)
            boolean r5 = r0.exists()
            if (r5 == 0) goto L_0x00bb
            boolean r0 = r0.renameTo(r3)
            if (r0 == 0) goto L_0x00c9
        L_0x00bb:
            boolean r0 = r2.exists()
            if (r0 == 0) goto L_0x00c9
            boolean r9 = r2.renameTo(r9)
            if (r9 == 0) goto L_0x00c9
            r9 = 1
            goto L_0x00ca
        L_0x00c9:
            r9 = 0
        L_0x00ca:
            if (r9 == 0) goto L_0x014d
            com.google.android.gms.internal.ads.zzgt$zza r9 = com.google.android.gms.internal.ads.zzgt.zzdl()
            com.google.android.gms.internal.ads.zzgt r0 = r8.zzdc()
            java.lang.String r0 = r0.zzdg()
            com.google.android.gms.internal.ads.zzgt$zza r9 = r9.zzav(r0)
            com.google.android.gms.internal.ads.zzgt r0 = r8.zzdc()
            java.lang.String r0 = r0.zzdh()
            com.google.android.gms.internal.ads.zzgt$zza r9 = r9.zzaw(r0)
            com.google.android.gms.internal.ads.zzgt r0 = r8.zzdc()
            long r2 = r0.zzdj()
            com.google.android.gms.internal.ads.zzgt$zza r9 = r9.zzdk(r2)
            com.google.android.gms.internal.ads.zzgt r0 = r8.zzdc()
            long r2 = r0.zzdk()
            com.google.android.gms.internal.ads.zzgt$zza r9 = r9.zzdl(r2)
            com.google.android.gms.internal.ads.zzgt r8 = r8.zzdc()
            long r2 = r8.zzdi()
            com.google.android.gms.internal.ads.zzgt$zza r8 = r9.zzdj(r2)
            com.google.android.gms.internal.ads.zzels r8 = r8.zzbhv()
            com.google.android.gms.internal.ads.zzekh r8 = (com.google.android.gms.internal.ads.zzekh) r8
            com.google.android.gms.internal.ads.zzgt r8 = (com.google.android.gms.internal.ads.zzgt) r8
            int r9 = com.google.android.gms.internal.ads.zzduh.zzhru
            com.google.android.gms.internal.ads.zzgt r9 = r7.zzej(r9)
            android.content.SharedPreferences r0 = r7.zzclm
            android.content.SharedPreferences$Editor r0 = r0.edit()
            if (r9 == 0) goto L_0x013b
            java.lang.String r2 = r8.zzdg()
            java.lang.String r3 = r9.zzdg()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x013b
            java.lang.String r2 = r7.zzaxx()
            java.lang.String r9 = zza(r9)
            r0.putString(r2, r9)
        L_0x013b:
            java.lang.String r9 = r7.zzaxy()
            java.lang.String r8 = zza(r8)
            r0.putString(r9, r8)
            boolean r8 = r0.commit()
            if (r8 == 0) goto L_0x014d
            goto L_0x014e
        L_0x014d:
            r1 = 0
        L_0x014e:
            java.util.HashSet r8 = new java.util.HashSet
            r8.<init>()
            int r9 = com.google.android.gms.internal.ads.zzduh.zzhru
            com.google.android.gms.internal.ads.zzgt r9 = r7.zzej(r9)
            if (r9 == 0) goto L_0x0162
            java.lang.String r9 = r9.zzdg()
            r8.add(r9)
        L_0x0162:
            int r9 = com.google.android.gms.internal.ads.zzduh.zzhrv
            com.google.android.gms.internal.ads.zzgt r9 = r7.zzej(r9)
            if (r9 == 0) goto L_0x0171
            java.lang.String r9 = r9.zzdg()
            r8.add(r9)
        L_0x0171:
            java.io.File r9 = r7.zzaxw()
            java.io.File[] r9 = r9.listFiles()
            int r0 = r9.length
        L_0x017a:
            if (r4 >= r0) goto L_0x0196
            r2 = r9[r4]
            java.lang.String r2 = r2.getName()
            boolean r3 = r8.contains(r2)
            if (r3 != 0) goto L_0x0193
            java.io.File r3 = r7.zzaxw()
            java.io.File r2 = com.google.android.gms.internal.ads.zzduc.zza((java.lang.String) r2, (java.io.File) r3)
            com.google.android.gms.internal.ads.zzduc.zze(r2)
        L_0x0193:
            int r4 = r4 + 1
            goto L_0x017a
        L_0x0196:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdtz.zza(com.google.android.gms.internal.ads.zzgp, com.google.android.gms.internal.ads.zzduf):boolean");
    }

    public final zzdua zzp(int i) {
        zzgt zzej = zzej(i);
        if (zzej == null) {
            return null;
        }
        String zzdg = zzej.zzdg();
        File zza = zzduc.zza(zzdg, "pcam.jar", zzaxw());
        if (!zza.exists()) {
            zza = zzduc.zza(zzdg, "pcam", zzaxw());
        }
        return new zzdua(zzej, zza, zzduc.zza(zzdg, "pcbc", zzaxw()), zzduc.zza(zzdg, "pcopt", zzaxw()));
    }
}
