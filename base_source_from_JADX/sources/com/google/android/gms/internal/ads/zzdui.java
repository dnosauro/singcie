package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.Hex;
import java.io.File;

public final class zzdui {
    private static final Object zzhsa = new Object();
    private final Context context;
    private final SharedPreferences zzclm;
    private final String zzhry;
    private final zzdtn zzhrz;

    public zzdui(Context context2, zzgn zzgn, zzdtn zzdtn) {
        this.context = context2;
        this.zzhry = Integer.toString(zzgn.zzv());
        this.zzclm = context2.getSharedPreferences("pcvmspf", 0);
        this.zzhrz = zzdtn;
    }

    private final void zza(int i, long j) {
        zzdtn zzdtn = this.zzhrz;
        if (zzdtn != null) {
            zzdtn.zza(i, j);
        }
    }

    private final void zza(int i, long j, String str) {
        zzdtn zzdtn = this.zzhrz;
        if (zzdtn != null) {
            zzdtn.zza(i, j, str);
        }
    }

    private final String zzaxx() {
        String valueOf = String.valueOf("FBAMTD");
        String valueOf2 = String.valueOf(this.zzhry);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final String zzaxy() {
        String valueOf = String.valueOf("LATMTD");
        String valueOf2 = String.valueOf(this.zzhry);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private static String zzb(zzgp zzgp) {
        return Hex.bytesToStringLowercase(((zzgt) ((zzekh) zzgt.zzdl().zzav(zzgp.zzdc().zzdg()).zzaw(zzgp.zzdc().zzdh()).zzdk(zzgp.zzdc().zzdj()).zzdl(zzgp.zzdc().zzdk()).zzdj(zzgp.zzdc().zzdi()).zzbhv())).zzbfg().toByteArray());
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001f A[SYNTHETIC, Splitter:B:10:0x001f] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.ads.zzgt zzej(int r3) {
        /*
            r2 = this;
            int r0 = com.google.android.gms.internal.ads.zzduh.zzhru
            r1 = 0
            if (r3 != r0) goto L_0x0010
            android.content.SharedPreferences r3 = r2.zzclm
            java.lang.String r0 = r2.zzaxy()
        L_0x000b:
            java.lang.String r3 = r3.getString(r0, r1)
            goto L_0x001c
        L_0x0010:
            int r0 = com.google.android.gms.internal.ads.zzduh.zzhrv
            if (r3 != r0) goto L_0x001b
            android.content.SharedPreferences r3 = r2.zzclm
            java.lang.String r0 = r2.zzaxx()
            goto L_0x000b
        L_0x001b:
            r3 = r1
        L_0x001c:
            if (r3 != 0) goto L_0x001f
            return r1
        L_0x001f:
            byte[] r3 = com.google.android.gms.common.util.Hex.stringToBytes(r3)     // Catch:{ zzeks -> 0x0030 }
            com.google.android.gms.internal.ads.zzeiu r3 = com.google.android.gms.internal.ads.zzeiu.zzt(r3)     // Catch:{ zzeks -> 0x0030 }
            com.google.android.gms.internal.ads.zzeju r0 = com.google.android.gms.internal.ads.zzeju.zzbhf()     // Catch:{ zzeks -> 0x0030 }
            com.google.android.gms.internal.ads.zzgt r3 = com.google.android.gms.internal.ads.zzgt.zzb((com.google.android.gms.internal.ads.zzeiu) r3, (com.google.android.gms.internal.ads.zzeju) r0)     // Catch:{ zzeks -> 0x0030 }
            return r3
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdui.zzej(int):com.google.android.gms.internal.ads.zzgt");
    }

    private final File zzhd(String str) {
        return new File(new File(this.context.getDir("pccache", 0), this.zzhry), str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzgp r7) {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Object r2 = zzhsa
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzgt r3 = r7.zzdc()     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = r3.zzdg()     // Catch:{ all -> 0x0054 }
            java.io.File r3 = r6.zzhd(r3)     // Catch:{ all -> 0x0054 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "pcbc"
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzeiu r3 = r7.zzde()     // Catch:{ all -> 0x0054 }
            byte[] r3 = r3.toByteArray()     // Catch:{ all -> 0x0054 }
            boolean r3 = com.google.android.gms.internal.ads.zzduc.zza((java.io.File) r4, (byte[]) r3)     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x0030
            r7 = 4020(0xfb4, float:5.633E-42)
            r6.zza((int) r7, (long) r0)     // Catch:{ all -> 0x0054 }
            r7 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            return r7
        L_0x0030:
            java.lang.String r7 = zzb(r7)     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences r3 = r6.zzclm     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r6.zzaxy()     // Catch:{ all -> 0x0054 }
            r3.putString(r4, r7)     // Catch:{ all -> 0x0054 }
            boolean r7 = r3.commit()     // Catch:{ all -> 0x0054 }
            if (r7 == 0) goto L_0x004d
            r3 = 5015(0x1397, float:7.028E-42)
            r6.zza((int) r3, (long) r0)     // Catch:{ all -> 0x0054 }
            goto L_0x0052
        L_0x004d:
            r3 = 4021(0xfb5, float:5.635E-42)
            r6.zza((int) r3, (long) r0)     // Catch:{ all -> 0x0054 }
        L_0x0052:
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            return r7
        L_0x0054:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdui.zza(com.google.android.gms.internal.ads.zzgp):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bd A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzgp r17, com.google.android.gms.internal.ads.zzduf r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r18
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Object r4 = zzhsa
            monitor-enter(r4)
            int r5 = com.google.android.gms.internal.ads.zzduh.zzhru     // Catch:{ all -> 0x0197 }
            com.google.android.gms.internal.ads.zzgt r5 = r1.zzej(r5)     // Catch:{ all -> 0x0197 }
            com.google.android.gms.internal.ads.zzgt r6 = r17.zzdc()     // Catch:{ all -> 0x0197 }
            java.lang.String r6 = r6.zzdg()     // Catch:{ all -> 0x0197 }
            r7 = 0
            if (r5 == 0) goto L_0x002d
            java.lang.String r5 = r5.zzdg()     // Catch:{ all -> 0x0197 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0197 }
            if (r5 == 0) goto L_0x002d
            r0 = 4014(0xfae, float:5.625E-42)
            r1.zza((int) r0, (long) r2)     // Catch:{ all -> 0x0197 }
            monitor-exit(r4)     // Catch:{ all -> 0x0197 }
            return r7
        L_0x002d:
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0197 }
            java.io.File r5 = r1.zzhd(r6)     // Catch:{ all -> 0x0197 }
            boolean r10 = r5.exists()     // Catch:{ all -> 0x0197 }
            r11 = 4015(0xfaf, float:5.626E-42)
            r12 = 1
            if (r10 == 0) goto L_0x0089
            r10 = 4023(0xfb7, float:5.637E-42)
            boolean r13 = r5.isDirectory()     // Catch:{ all -> 0x0197 }
            if (r13 == 0) goto L_0x0049
            java.lang.String r13 = "1"
            goto L_0x004b
        L_0x0049:
            java.lang.String r13 = "0"
        L_0x004b:
            boolean r5 = r5.isFile()     // Catch:{ all -> 0x0197 }
            if (r5 == 0) goto L_0x0054
            java.lang.String r5 = "1"
            goto L_0x0056
        L_0x0054:
            java.lang.String r5 = "0"
        L_0x0056:
            java.lang.String r14 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x0197 }
            int r14 = r14.length()     // Catch:{ all -> 0x0197 }
            int r14 = r14 + 5
            java.lang.String r15 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0197 }
            int r15 = r15.length()     // Catch:{ all -> 0x0197 }
            int r14 = r14 + r15
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
            r15.<init>(r14)     // Catch:{ all -> 0x0197 }
            java.lang.String r14 = "d:"
            r15.append(r14)     // Catch:{ all -> 0x0197 }
            r15.append(r13)     // Catch:{ all -> 0x0197 }
            java.lang.String r13 = ",f:"
            r15.append(r13)     // Catch:{ all -> 0x0197 }
            r15.append(r5)     // Catch:{ all -> 0x0197 }
            java.lang.String r5 = r15.toString()     // Catch:{ all -> 0x0197 }
            r1.zza(r10, r8, r5)     // Catch:{ all -> 0x0197 }
            r1.zza((int) r11, (long) r8)     // Catch:{ all -> 0x0197 }
            goto L_0x00ba
        L_0x0089:
            boolean r10 = r5.mkdirs()     // Catch:{ all -> 0x0197 }
            if (r10 != 0) goto L_0x00ba
            r10 = 4024(0xfb8, float:5.639E-42)
            java.lang.String r13 = "cw:"
            boolean r5 = r5.canWrite()     // Catch:{ all -> 0x0197 }
            if (r5 == 0) goto L_0x009c
            java.lang.String r5 = "1"
            goto L_0x009e
        L_0x009c:
            java.lang.String r5 = "0"
        L_0x009e:
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0197 }
            int r14 = r5.length()     // Catch:{ all -> 0x0197 }
            if (r14 == 0) goto L_0x00ad
            java.lang.String r5 = r13.concat(r5)     // Catch:{ all -> 0x0197 }
            goto L_0x00b2
        L_0x00ad:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0197 }
            r5.<init>(r13)     // Catch:{ all -> 0x0197 }
        L_0x00b2:
            r1.zza(r10, r8, r5)     // Catch:{ all -> 0x0197 }
            r1.zza((int) r11, (long) r8)     // Catch:{ all -> 0x0197 }
            r5 = 0
            goto L_0x00bb
        L_0x00ba:
            r5 = 1
        L_0x00bb:
            if (r5 != 0) goto L_0x00bf
            monitor-exit(r4)     // Catch:{ all -> 0x0197 }
            return r7
        L_0x00bf:
            java.io.File r5 = r1.zzhd(r6)     // Catch:{ all -> 0x0197 }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x0197 }
            java.lang.String r8 = "pcam.jar"
            r6.<init>(r5, r8)     // Catch:{ all -> 0x0197 }
            java.io.File r8 = new java.io.File     // Catch:{ all -> 0x0197 }
            java.lang.String r9 = "pcbc"
            r8.<init>(r5, r9)     // Catch:{ all -> 0x0197 }
            com.google.android.gms.internal.ads.zzeiu r9 = r17.zzdd()     // Catch:{ all -> 0x0197 }
            byte[] r9 = r9.toByteArray()     // Catch:{ all -> 0x0197 }
            boolean r9 = com.google.android.gms.internal.ads.zzduc.zza((java.io.File) r6, (byte[]) r9)     // Catch:{ all -> 0x0197 }
            if (r9 != 0) goto L_0x00e6
            r0 = 4016(0xfb0, float:5.628E-42)
            r1.zza((int) r0, (long) r2)     // Catch:{ all -> 0x0197 }
            monitor-exit(r4)     // Catch:{ all -> 0x0197 }
            return r7
        L_0x00e6:
            com.google.android.gms.internal.ads.zzeiu r9 = r17.zzde()     // Catch:{ all -> 0x0197 }
            byte[] r9 = r9.toByteArray()     // Catch:{ all -> 0x0197 }
            boolean r8 = com.google.android.gms.internal.ads.zzduc.zza((java.io.File) r8, (byte[]) r9)     // Catch:{ all -> 0x0197 }
            if (r8 != 0) goto L_0x00fb
            r0 = 4017(0xfb1, float:5.629E-42)
            r1.zza((int) r0, (long) r2)     // Catch:{ all -> 0x0197 }
            monitor-exit(r4)     // Catch:{ all -> 0x0197 }
            return r7
        L_0x00fb:
            if (r0 == 0) goto L_0x010d
            boolean r0 = r0.zzb(r6)     // Catch:{ all -> 0x0197 }
            if (r0 != 0) goto L_0x010d
            r0 = 4018(0xfb2, float:5.63E-42)
            r1.zza((int) r0, (long) r2)     // Catch:{ all -> 0x0197 }
            com.google.android.gms.internal.ads.zzduc.zze(r5)     // Catch:{ all -> 0x0197 }
            monitor-exit(r4)     // Catch:{ all -> 0x0197 }
            return r7
        L_0x010d:
            java.lang.String r0 = zzb(r17)     // Catch:{ all -> 0x0197 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0197 }
            android.content.SharedPreferences r8 = r1.zzclm     // Catch:{ all -> 0x0197 }
            java.lang.String r9 = r16.zzaxy()     // Catch:{ all -> 0x0197 }
            r10 = 0
            java.lang.String r8 = r8.getString(r9, r10)     // Catch:{ all -> 0x0197 }
            android.content.SharedPreferences r9 = r1.zzclm     // Catch:{ all -> 0x0197 }
            android.content.SharedPreferences$Editor r9 = r9.edit()     // Catch:{ all -> 0x0197 }
            java.lang.String r10 = r16.zzaxy()     // Catch:{ all -> 0x0197 }
            r9.putString(r10, r0)     // Catch:{ all -> 0x0197 }
            if (r8 == 0) goto L_0x0136
            java.lang.String r0 = r16.zzaxx()     // Catch:{ all -> 0x0197 }
            r9.putString(r0, r8)     // Catch:{ all -> 0x0197 }
        L_0x0136:
            boolean r0 = r9.commit()     // Catch:{ all -> 0x0197 }
            if (r0 != 0) goto L_0x0141
            r8 = 4019(0xfb3, float:5.632E-42)
            r1.zza((int) r8, (long) r5)     // Catch:{ all -> 0x0197 }
        L_0x0141:
            if (r0 != 0) goto L_0x0145
            monitor-exit(r4)     // Catch:{ all -> 0x0197 }
            return r7
        L_0x0145:
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x0197 }
            r0.<init>()     // Catch:{ all -> 0x0197 }
            int r5 = com.google.android.gms.internal.ads.zzduh.zzhru     // Catch:{ all -> 0x0197 }
            com.google.android.gms.internal.ads.zzgt r5 = r1.zzej(r5)     // Catch:{ all -> 0x0197 }
            if (r5 == 0) goto L_0x0159
            java.lang.String r5 = r5.zzdg()     // Catch:{ all -> 0x0197 }
            r0.add(r5)     // Catch:{ all -> 0x0197 }
        L_0x0159:
            int r5 = com.google.android.gms.internal.ads.zzduh.zzhrv     // Catch:{ all -> 0x0197 }
            com.google.android.gms.internal.ads.zzgt r5 = r1.zzej(r5)     // Catch:{ all -> 0x0197 }
            if (r5 == 0) goto L_0x0168
            java.lang.String r5 = r5.zzdg()     // Catch:{ all -> 0x0197 }
            r0.add(r5)     // Catch:{ all -> 0x0197 }
        L_0x0168:
            java.io.File r5 = new java.io.File     // Catch:{ all -> 0x0197 }
            android.content.Context r6 = r1.context     // Catch:{ all -> 0x0197 }
            java.lang.String r8 = "pccache"
            java.io.File r6 = r6.getDir(r8, r7)     // Catch:{ all -> 0x0197 }
            java.lang.String r8 = r1.zzhry     // Catch:{ all -> 0x0197 }
            r5.<init>(r6, r8)     // Catch:{ all -> 0x0197 }
            java.io.File[] r5 = r5.listFiles()     // Catch:{ all -> 0x0197 }
            int r6 = r5.length     // Catch:{ all -> 0x0197 }
        L_0x017c:
            if (r7 >= r6) goto L_0x0190
            r8 = r5[r7]     // Catch:{ all -> 0x0197 }
            java.lang.String r9 = r8.getName()     // Catch:{ all -> 0x0197 }
            boolean r9 = r0.contains(r9)     // Catch:{ all -> 0x0197 }
            if (r9 != 0) goto L_0x018d
            com.google.android.gms.internal.ads.zzduc.zze(r8)     // Catch:{ all -> 0x0197 }
        L_0x018d:
            int r7 = r7 + 1
            goto L_0x017c
        L_0x0190:
            r0 = 5014(0x1396, float:7.026E-42)
            r1.zza((int) r0, (long) r2)     // Catch:{ all -> 0x0197 }
            monitor-exit(r4)     // Catch:{ all -> 0x0197 }
            return r12
        L_0x0197:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0197 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdui.zza(com.google.android.gms.internal.ads.zzgp, com.google.android.gms.internal.ads.zzduf):boolean");
    }

    public final zzdua zzp(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zzhsa) {
            zzgt zzej = zzej(i);
            if (zzej == null) {
                zza(4022, currentTimeMillis);
                return null;
            }
            File zzhd = zzhd(zzej.zzdg());
            File file = new File(zzhd, "pcam.jar");
            if (!file.exists()) {
                file = new File(zzhd, "pcam");
            }
            File file2 = new File(zzhd, "pcbc");
            File file3 = new File(zzhd, "pcopt");
            zza(5016, currentTimeMillis);
            zzdua zzdua = new zzdua(zzej, file, file2, file3);
            return zzdua;
        }
    }
}
