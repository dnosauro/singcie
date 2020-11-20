package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import sun.misc.Unsafe;

final class zzjk<T> implements zzjv<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzkt.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzjg zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzjo zzo;
    private final zziq zzp;
    private final zzkn<?, ?> zzq;
    private final zzhk<?> zzr;
    private final zziz zzs;

    private zzjk(int[] iArr, Object[] objArr, int i, int i2, zzjg zzjg, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzjo zzjo, zziq zziq, zzkn<?, ?> zzkn, zzhk<?> zzhk, zziz zziz) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzjg instanceof zzhv;
        this.zzj = z;
        this.zzh = zzhk != null && zzhk.zza(zzjg);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzjo;
        this.zzp = zziq;
        this.zzq = zzkn;
        this.zzr = zzhk;
        this.zzg = zzjg;
        this.zzs = zziz;
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private static <UT, UB> int zza(zzkn<UT, UB> zzkn, T t) {
        return zzkn.zzf(zzkn.zzb(t));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a7, code lost:
        r3 = r11.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0134, code lost:
        r3 = java.lang.Integer.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0141, code lost:
        r3 = java.lang.Long.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0145, code lost:
        r12.putObject(r1, r9, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0153, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0164, code lost:
        r12.putObject(r1, r9, r2);
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0169, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.measurement.zzgl r29) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzb
            int[] r7 = r0.zzc
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x0159;
                case 52: goto L_0x0149;
                case 53: goto L_0x0139;
                case 54: goto L_0x0139;
                case 55: goto L_0x012c;
                case 56: goto L_0x0120;
                case 57: goto L_0x0115;
                case 58: goto L_0x00ff;
                case 59: goto L_0x00d1;
                case 60: goto L_0x00ab;
                case 61: goto L_0x00a1;
                case 62: goto L_0x012c;
                case 63: goto L_0x0073;
                case 64: goto L_0x0115;
                case 65: goto L_0x0120;
                case 66: goto L_0x0065;
                case 67: goto L_0x0057;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x016d
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x016d
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.measurement.zzjv r2 = r0.zza((int) r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.measurement.zzgl) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x004f
            goto L_0x00a7
        L_0x004f:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r15, (java.lang.Object) r3)
            goto L_0x0145
        L_0x0057:
            if (r5 != 0) goto L_0x016d
            int r2 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r11)
            long r3 = r11.zzb
            long r3 = com.google.android.gms.internal.measurement.zzgy.zza((long) r3)
            goto L_0x0141
        L_0x0065:
            if (r5 != 0) goto L_0x016d
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r11)
            int r3 = r11.zza
            int r3 = com.google.android.gms.internal.measurement.zzgy.zze(r3)
            goto L_0x0134
        L_0x0073:
            if (r5 != 0) goto L_0x016d
            int r3 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r11)
            int r4 = r11.zza
            com.google.android.gms.internal.measurement.zzic r5 = r0.zzc((int) r6)
            if (r5 == 0) goto L_0x0097
            boolean r5 = r5.zza(r4)
            if (r5 == 0) goto L_0x0088
            goto L_0x0097
        L_0x0088:
            com.google.android.gms.internal.measurement.zzkq r1 = zze((java.lang.Object) r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zza((int) r2, (java.lang.Object) r4)
            r2 = r3
            goto L_0x016e
        L_0x0097:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x0169
        L_0x00a1:
            if (r5 != r15) goto L_0x016d
            int r2 = com.google.android.gms.internal.measurement.zzgi.zze(r3, r4, r11)
        L_0x00a7:
            java.lang.Object r3 = r11.zzc
            goto L_0x0145
        L_0x00ab:
            if (r5 != r15) goto L_0x016d
            com.google.android.gms.internal.measurement.zzjv r2 = r0.zza((int) r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzgl) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00c2
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00c3
        L_0x00c2:
            r15 = 0
        L_0x00c3:
            if (r15 != 0) goto L_0x00c9
            java.lang.Object r3 = r11.zzc
            goto L_0x0145
        L_0x00c9:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r15, (java.lang.Object) r3)
            goto L_0x0145
        L_0x00d1:
            if (r5 != r15) goto L_0x016d
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r11)
            int r4 = r11.zza
            if (r4 != 0) goto L_0x00de
            java.lang.String r3 = ""
            goto L_0x0145
        L_0x00de:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x00f2
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.measurement.zzkw.zza((byte[]) r3, (int) r2, (int) r5)
            if (r5 == 0) goto L_0x00ed
            goto L_0x00f2
        L_0x00ed:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzh()
            throw r1
        L_0x00f2:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.measurement.zzhx.zza
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
            goto L_0x0169
        L_0x00ff:
            if (r5 != 0) goto L_0x016d
            int r2 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r11)
            long r3 = r11.zzb
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x010f
            r15 = 1
            goto L_0x0110
        L_0x010f:
            r15 = 0
        L_0x0110:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            goto L_0x0145
        L_0x0115:
            if (r5 != r7) goto L_0x016d
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0153
        L_0x0120:
            r2 = 1
            if (r5 != r2) goto L_0x016d
            long r2 = com.google.android.gms.internal.measurement.zzgi.zzb(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            goto L_0x0164
        L_0x012c:
            if (r5 != 0) goto L_0x016d
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r11)
            int r3 = r11.zza
        L_0x0134:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0145
        L_0x0139:
            if (r5 != 0) goto L_0x016d
            int r2 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r11)
            long r3 = r11.zzb
        L_0x0141:
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
        L_0x0145:
            r12.putObject(r1, r9, r3)
            goto L_0x0169
        L_0x0149:
            if (r5 != r7) goto L_0x016d
            float r2 = com.google.android.gms.internal.measurement.zzgi.zzd(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
        L_0x0153:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 4
            goto L_0x0169
        L_0x0159:
            r2 = 1
            if (r5 != r2) goto L_0x016d
            double r2 = com.google.android.gms.internal.measurement.zzgi.zzc(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
        L_0x0164:
            r12.putObject(r1, r9, r2)
            int r2 = r4 + 8
        L_0x0169:
            r12.putInt(r1, r13, r8)
            goto L_0x016e
        L_0x016d:
            r2 = r4
        L_0x016e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.measurement.zzgl):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:139:0x026a, code lost:
        if (r7.zzb != 0) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x026c, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x026e, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x026f, code lost:
        r11.zza(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0272, code lost:
        if (r4 >= r5) goto L_0x03d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0274, code lost:
        r6 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x027a, code lost:
        if (r2 != r7.zza) goto L_0x03d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x027c, code lost:
        r4 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0284, code lost:
        if (r7.zzb == 0) goto L_0x026e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0136, code lost:
        if (r4 == 0) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0138, code lost:
        r11.add(com.google.android.gms.internal.measurement.zzgm.zza);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x013e, code lost:
        r11.add(com.google.android.gms.internal.measurement.zzgm.zza(r3, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0146, code lost:
        if (r1 >= r5) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0148, code lost:
        r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x014e, code lost:
        if (r2 != r7.zza) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0150, code lost:
        r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7);
        r4 = r7.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0156, code lost:
        if (r4 < 0) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015a, code lost:
        if (r4 > (r3.length - r1)) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x015c, code lost:
        if (r4 != 0) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0163, code lost:
        throw com.google.android.gms.internal.measurement.zzig.zza();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0168, code lost:
        throw com.google.android.gms.internal.measurement.zzig.zzb();
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.measurement.zzgl r30) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzid r11 = (com.google.android.gms.internal.measurement.zzid) r11
            boolean r12 = r11.zza()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.measurement.zzid r11 = r11.zza(r12)
            sun.misc.Unsafe r12 = zzb
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x0395;
                case 19: goto L_0x0357;
                case 20: goto L_0x031f;
                case 21: goto L_0x031f;
                case 22: goto L_0x0305;
                case 23: goto L_0x02c6;
                case 24: goto L_0x0287;
                case 25: goto L_0x0236;
                case 26: goto L_0x018d;
                case 27: goto L_0x0173;
                case 28: goto L_0x0128;
                case 29: goto L_0x0305;
                case 30: goto L_0x00f0;
                case 31: goto L_0x0287;
                case 32: goto L_0x02c6;
                case 33: goto L_0x00b0;
                case 34: goto L_0x0070;
                case 35: goto L_0x0395;
                case 36: goto L_0x0357;
                case 37: goto L_0x031f;
                case 38: goto L_0x031f;
                case 39: goto L_0x0305;
                case 40: goto L_0x02c6;
                case 41: goto L_0x0287;
                case 42: goto L_0x0236;
                case 43: goto L_0x0305;
                case 44: goto L_0x00f0;
                case 45: goto L_0x0287;
                case 46: goto L_0x02c6;
                case 47: goto L_0x00b0;
                case 48: goto L_0x0070;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x03d3
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x03d3
            com.google.android.gms.internal.measurement.zzjv r1 = r0.zza((int) r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
        L_0x0050:
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.measurement.zzgl) r27)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            if (r4 >= r5) goto L_0x03d3
            int r8 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r9 = r7.zza
            if (r2 != r9) goto L_0x03d3
            r22 = r1
            r23 = r18
            r24 = r8
            goto L_0x0050
        L_0x0070:
            if (r6 != r10) goto L_0x0094
            com.google.android.gms.internal.measurement.zziu r11 = (com.google.android.gms.internal.measurement.zziu) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x007b:
            if (r1 >= r2) goto L_0x008b
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzgy.zza((long) r4)
            r11.zza((long) r4)
            goto L_0x007b
        L_0x008b:
            if (r1 != r2) goto L_0x008f
            goto L_0x03d4
        L_0x008f:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x0094:
            if (r6 != 0) goto L_0x03d3
            com.google.android.gms.internal.measurement.zziu r11 = (com.google.android.gms.internal.measurement.zziu) r11
        L_0x0098:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzgy.zza((long) r8)
            r11.zza((long) r8)
            if (r1 >= r5) goto L_0x03d4
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d4
            goto L_0x0098
        L_0x00b0:
            if (r6 != r10) goto L_0x00d4
            com.google.android.gms.internal.measurement.zzhy r11 = (com.google.android.gms.internal.measurement.zzhy) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00bb:
            if (r1 >= r2) goto L_0x00cb
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzgy.zze(r4)
            r11.zzd(r4)
            goto L_0x00bb
        L_0x00cb:
            if (r1 != r2) goto L_0x00cf
            goto L_0x03d4
        L_0x00cf:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x00d4:
            if (r6 != 0) goto L_0x03d3
            com.google.android.gms.internal.measurement.zzhy r11 = (com.google.android.gms.internal.measurement.zzhy) r11
        L_0x00d8:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzgy.zze(r4)
            r11.zzd(r4)
            if (r1 >= r5) goto L_0x03d4
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d4
            goto L_0x00d8
        L_0x00f0:
            if (r6 != r10) goto L_0x00f7
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.measurement.zzid<?>) r11, (com.google.android.gms.internal.measurement.zzgl) r7)
            goto L_0x0108
        L_0x00f7:
            if (r6 != 0) goto L_0x03d3
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzid<?>) r6, (com.google.android.gms.internal.measurement.zzgl) r7)
        L_0x0108:
            com.google.android.gms.internal.measurement.zzhv r1 = (com.google.android.gms.internal.measurement.zzhv) r1
            com.google.android.gms.internal.measurement.zzkq r3 = r1.zzb
            com.google.android.gms.internal.measurement.zzkq r4 = com.google.android.gms.internal.measurement.zzkq.zza()
            if (r3 != r4) goto L_0x0113
            r3 = 0
        L_0x0113:
            com.google.android.gms.internal.measurement.zzic r4 = r0.zzc((int) r8)
            com.google.android.gms.internal.measurement.zzkn<?, ?> r5 = r0.zzq
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzjx.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.measurement.zzkq r3 = (com.google.android.gms.internal.measurement.zzkq) r3
            if (r3 == 0) goto L_0x0125
            r1.zzb = r3
        L_0x0125:
            r1 = r2
            goto L_0x03d4
        L_0x0128:
            if (r6 != r10) goto L_0x03d3
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x016e
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0169
            if (r4 != 0) goto L_0x013e
        L_0x0138:
            com.google.android.gms.internal.measurement.zzgm r4 = com.google.android.gms.internal.measurement.zzgm.zza
            r11.add(r4)
            goto L_0x0146
        L_0x013e:
            com.google.android.gms.internal.measurement.zzgm r6 = com.google.android.gms.internal.measurement.zzgm.zza((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
            int r1 = r1 + r4
        L_0x0146:
            if (r1 >= r5) goto L_0x03d4
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d4
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0164
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x015f
            if (r4 != 0) goto L_0x013e
            goto L_0x0138
        L_0x015f:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x0164:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzb()
            throw r1
        L_0x0169:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x016e:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzb()
            throw r1
        L_0x0173:
            if (r6 != r10) goto L_0x03d3
            com.google.android.gms.internal.measurement.zzjv r1 = r0.zza((int) r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x03d4
        L_0x018d:
            if (r6 != r10) goto L_0x03d3
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            int r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r1 != 0) goto L_0x01da
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01d5
            if (r4 != 0) goto L_0x01a8
        L_0x01a2:
            java.lang.String r4 = ""
            r11.add(r4)
            goto L_0x01b3
        L_0x01a8:
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r8 = com.google.android.gms.internal.measurement.zzhx.zza
            r6.<init>(r3, r1, r4, r8)
        L_0x01af:
            r11.add(r6)
            int r1 = r1 + r4
        L_0x01b3:
            if (r1 >= r5) goto L_0x03d4
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d4
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01d0
            if (r4 != 0) goto L_0x01c8
            goto L_0x01a2
        L_0x01c8:
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r8 = com.google.android.gms.internal.measurement.zzhx.zza
            r6.<init>(r3, r1, r4, r8)
            goto L_0x01af
        L_0x01d0:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzb()
            throw r1
        L_0x01d5:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzb()
            throw r1
        L_0x01da:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0231
            if (r4 != 0) goto L_0x01ea
        L_0x01e4:
            java.lang.String r4 = ""
            r11.add(r4)
            goto L_0x01fd
        L_0x01ea:
            int r6 = r1 + r4
            boolean r8 = com.google.android.gms.internal.measurement.zzkw.zza((byte[]) r3, (int) r1, (int) r6)
            if (r8 == 0) goto L_0x022c
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzhx.zza
            r8.<init>(r3, r1, r4, r9)
        L_0x01f9:
            r11.add(r8)
            r1 = r6
        L_0x01fd:
            if (r1 >= r5) goto L_0x03d4
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d4
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0227
            if (r4 != 0) goto L_0x0212
            goto L_0x01e4
        L_0x0212:
            int r6 = r1 + r4
            boolean r8 = com.google.android.gms.internal.measurement.zzkw.zza((byte[]) r3, (int) r1, (int) r6)
            if (r8 == 0) goto L_0x0222
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzhx.zza
            r8.<init>(r3, r1, r4, r9)
            goto L_0x01f9
        L_0x0222:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzh()
            throw r1
        L_0x0227:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzb()
            throw r1
        L_0x022c:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzh()
            throw r1
        L_0x0231:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzb()
            throw r1
        L_0x0236:
            r1 = 0
            if (r6 != r10) goto L_0x025e
            com.google.android.gms.internal.measurement.zzgk r11 = (com.google.android.gms.internal.measurement.zzgk) r11
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0242:
            if (r2 >= r4) goto L_0x0255
            int r2 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0250
            r5 = 1
            goto L_0x0251
        L_0x0250:
            r5 = 0
        L_0x0251:
            r11.zza((boolean) r5)
            goto L_0x0242
        L_0x0255:
            if (r2 != r4) goto L_0x0259
            goto L_0x0125
        L_0x0259:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x025e:
            if (r6 != 0) goto L_0x03d3
            com.google.android.gms.internal.measurement.zzgk r11 = (com.google.android.gms.internal.measurement.zzgk) r11
            int r4 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x026e
        L_0x026c:
            r6 = 1
            goto L_0x026f
        L_0x026e:
            r6 = 0
        L_0x026f:
            r11.zza((boolean) r6)
            if (r4 >= r5) goto L_0x03d3
            int r6 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x03d3
            int r4 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x026e
            goto L_0x026c
        L_0x0287:
            if (r6 != r10) goto L_0x02a7
            com.google.android.gms.internal.measurement.zzhy r11 = (com.google.android.gms.internal.measurement.zzhy) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0292:
            if (r1 >= r2) goto L_0x029e
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1)
            r11.zzd(r4)
            int r1 = r1 + 4
            goto L_0x0292
        L_0x029e:
            if (r1 != r2) goto L_0x02a2
            goto L_0x03d4
        L_0x02a2:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x02a7:
            if (r6 != r9) goto L_0x03d3
            com.google.android.gms.internal.measurement.zzhy r11 = (com.google.android.gms.internal.measurement.zzhy) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r18, r19)
            r11.zzd(r1)
        L_0x02b2:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03d4
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d4
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4)
            r11.zzd(r1)
            goto L_0x02b2
        L_0x02c6:
            if (r6 != r10) goto L_0x02e6
            com.google.android.gms.internal.measurement.zziu r11 = (com.google.android.gms.internal.measurement.zziu) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02d1:
            if (r1 >= r2) goto L_0x02dd
            long r4 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r1)
            r11.zza((long) r4)
            int r1 = r1 + 8
            goto L_0x02d1
        L_0x02dd:
            if (r1 != r2) goto L_0x02e1
            goto L_0x03d4
        L_0x02e1:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x02e6:
            if (r6 != r13) goto L_0x03d3
            com.google.android.gms.internal.measurement.zziu r11 = (com.google.android.gms.internal.measurement.zziu) r11
            long r8 = com.google.android.gms.internal.measurement.zzgi.zzb(r18, r19)
            r11.zza((long) r8)
        L_0x02f1:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x03d4
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d4
            long r8 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4)
            r11.zza((long) r8)
            goto L_0x02f1
        L_0x0305:
            if (r6 != r10) goto L_0x030d
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.measurement.zzid<?>) r11, (com.google.android.gms.internal.measurement.zzgl) r7)
            goto L_0x03d4
        L_0x030d:
            if (r6 != 0) goto L_0x03d3
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.android.gms.internal.measurement.zzid<?>) r25, (com.google.android.gms.internal.measurement.zzgl) r26)
            goto L_0x03d4
        L_0x031f:
            if (r6 != r10) goto L_0x033f
            com.google.android.gms.internal.measurement.zziu r11 = (com.google.android.gms.internal.measurement.zziu) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x032a:
            if (r1 >= r2) goto L_0x0336
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r1, r7)
            long r4 = r7.zzb
            r11.zza((long) r4)
            goto L_0x032a
        L_0x0336:
            if (r1 != r2) goto L_0x033a
            goto L_0x03d4
        L_0x033a:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x033f:
            if (r6 != 0) goto L_0x03d3
            com.google.android.gms.internal.measurement.zziu r11 = (com.google.android.gms.internal.measurement.zziu) r11
        L_0x0343:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r7)
            long r8 = r7.zzb
            r11.zza((long) r8)
            if (r1 >= r5) goto L_0x03d4
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d4
            goto L_0x0343
        L_0x0357:
            if (r6 != r10) goto L_0x0376
            com.google.android.gms.internal.measurement.zzhu r11 = (com.google.android.gms.internal.measurement.zzhu) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0362:
            if (r1 >= r2) goto L_0x036e
            float r4 = com.google.android.gms.internal.measurement.zzgi.zzd(r3, r1)
            r11.zza((float) r4)
            int r1 = r1 + 4
            goto L_0x0362
        L_0x036e:
            if (r1 != r2) goto L_0x0371
            goto L_0x03d4
        L_0x0371:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x0376:
            if (r6 != r9) goto L_0x03d3
            com.google.android.gms.internal.measurement.zzhu r11 = (com.google.android.gms.internal.measurement.zzhu) r11
            float r1 = com.google.android.gms.internal.measurement.zzgi.zzd(r18, r19)
            r11.zza((float) r1)
        L_0x0381:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03d4
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d4
            float r1 = com.google.android.gms.internal.measurement.zzgi.zzd(r3, r4)
            r11.zza((float) r1)
            goto L_0x0381
        L_0x0395:
            if (r6 != r10) goto L_0x03b4
            com.google.android.gms.internal.measurement.zzhg r11 = (com.google.android.gms.internal.measurement.zzhg) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03a0:
            if (r1 >= r2) goto L_0x03ac
            double r4 = com.google.android.gms.internal.measurement.zzgi.zzc(r3, r1)
            r11.zza((double) r4)
            int r1 = r1 + 8
            goto L_0x03a0
        L_0x03ac:
            if (r1 != r2) goto L_0x03af
            goto L_0x03d4
        L_0x03af:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x03b4:
            if (r6 != r13) goto L_0x03d3
            com.google.android.gms.internal.measurement.zzhg r11 = (com.google.android.gms.internal.measurement.zzhg) r11
            double r8 = com.google.android.gms.internal.measurement.zzgi.zzc(r18, r19)
            r11.zza((double) r8)
        L_0x03bf:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x03d4
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x03d4
            double r8 = com.google.android.gms.internal.measurement.zzgi.zzc(r3, r4)
            r11.zza((double) r8)
            goto L_0x03bf
        L_0x03d3:
            r1 = r4
        L_0x03d4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzgl):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.measurement.zzgl r15) {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzb
            java.lang.Object r12 = r7.zzb((int) r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.measurement.zziz r2 = r7.zzs
            boolean r2 = r2.zzc(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.measurement.zziz r2 = r7.zzs
            java.lang.Object r2 = r2.zze(r12)
            com.google.android.gms.internal.measurement.zziz r3 = r7.zzs
            r3.zza(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.measurement.zziz r8 = r7.zzs
            com.google.android.gms.internal.measurement.zzix r8 = r8.zzf(r12)
            com.google.android.gms.internal.measurement.zziz r12 = r7.zzs
            java.util.Map r12 = r12.zza(r1)
            int r10 = com.google.android.gms.internal.measurement.zzgi.zza(r9, r10, r15)
            int r13 = r15.zza
            if (r13 < 0) goto L_0x0094
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0094
            int r13 = r13 + r10
            K r14 = r8.zzb
            V r0 = r8.zzd
        L_0x003e:
            if (r10 >= r13) goto L_0x0089
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.measurement.zzgl) r15)
            int r10 = r15.zza
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            switch(r1) {
                case 1: goto L_0x006f;
                case 2: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x0084
        L_0x0055:
            com.google.android.gms.internal.measurement.zzle r1 = r8.zzc
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0084
            com.google.android.gms.internal.measurement.zzle r4 = r8.zzc
            V r10 = r8.zzd
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzle) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzgl) r6)
            java.lang.Object r0 = r15.zzc
            goto L_0x003e
        L_0x006f:
            com.google.android.gms.internal.measurement.zzle r1 = r8.zza
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0084
            com.google.android.gms.internal.measurement.zzle r4 = r8.zza
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzle) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzgl) r6)
            java.lang.Object r14 = r15.zzc
            goto L_0x003e
        L_0x0084:
            int r10 = com.google.android.gms.internal.measurement.zzgi.zza((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.measurement.zzgl) r15)
            goto L_0x003e
        L_0x0089:
            if (r10 != r13) goto L_0x008f
            r12.put(r14, r0)
            return r13
        L_0x008f:
            com.google.android.gms.internal.measurement.zzig r8 = com.google.android.gms.internal.measurement.zzig.zzg()
            throw r8
        L_0x0094:
            com.google.android.gms.internal.measurement.zzig r8 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.measurement.zzgl):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004d, code lost:
        r2 = java.lang.Integer.valueOf(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0051, code lost:
        r6.zzc = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        r6.zzc = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007b, code lost:
        r6.zzc = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        r2 = java.lang.Long.valueOf(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.measurement.zzle r4, java.lang.Class<?> r5, com.google.android.gms.internal.measurement.zzgl r6) {
        /*
            int[] r0 = com.google.android.gms.internal.measurement.zzjj.zza
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0085;
                case 2: goto L_0x0080;
                case 3: goto L_0x0073;
                case 4: goto L_0x0066;
                case 5: goto L_0x0066;
                case 6: goto L_0x005d;
                case 7: goto L_0x005d;
                case 8: goto L_0x0054;
                case 9: goto L_0x0047;
                case 10: goto L_0x0047;
                case 11: goto L_0x0047;
                case 12: goto L_0x003c;
                case 13: goto L_0x003c;
                case 14: goto L_0x002f;
                case 15: goto L_0x0024;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0013:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzd(r1, r2, r6)
            goto L_0x0099
        L_0x0019:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r1, r2, r6)
            long r2 = r6.zzb
            long r2 = com.google.android.gms.internal.measurement.zzgy.zza((long) r2)
            goto L_0x0042
        L_0x0024:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r1, r2, r6)
            int r2 = r6.zza
            int r2 = com.google.android.gms.internal.measurement.zzgy.zze(r2)
            goto L_0x004d
        L_0x002f:
            com.google.android.gms.internal.measurement.zzjr r4 = com.google.android.gms.internal.measurement.zzjr.zza()
            com.google.android.gms.internal.measurement.zzjv r4 = r4.zza(r5)
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzgl) r6)
            goto L_0x0099
        L_0x003c:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r1, r2, r6)
            long r2 = r6.zzb
        L_0x0042:
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            goto L_0x0051
        L_0x0047:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r1, r2, r6)
            int r2 = r6.zza
        L_0x004d:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0051:
            r6.zzc = r2
            goto L_0x0099
        L_0x0054:
            float r1 = com.google.android.gms.internal.measurement.zzgi.zzd(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            goto L_0x006e
        L_0x005d:
            long r3 = com.google.android.gms.internal.measurement.zzgi.zzb(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            goto L_0x007b
        L_0x0066:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L_0x006e:
            r6.zzc = r1
            int r1 = r2 + 4
            goto L_0x0099
        L_0x0073:
            double r3 = com.google.android.gms.internal.measurement.zzgi.zzc(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
        L_0x007b:
            r6.zzc = r1
            int r1 = r2 + 8
            goto L_0x0099
        L_0x0080:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zze(r1, r2, r6)
            goto L_0x0099
        L_0x0085:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r1, r2, r6)
            long r2 = r6.zzb
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0093
            r2 = 1
            goto L_0x0094
        L_0x0093:
            r2 = 0
        L_0x0094:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x0051
        L_0x0099:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(byte[], int, int, com.google.android.gms.internal.measurement.zzle, java.lang.Class, com.google.android.gms.internal.measurement.zzgl):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:164:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0396  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.measurement.zzjk<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.measurement.zzje r34, com.google.android.gms.internal.measurement.zzjo r35, com.google.android.gms.internal.measurement.zziq r36, com.google.android.gms.internal.measurement.zzkn<?, ?> r37, com.google.android.gms.internal.measurement.zzhk<?> r38, com.google.android.gms.internal.measurement.zziz r39) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzjt
            if (r1 == 0) goto L_0x040d
            com.google.android.gms.internal.measurement.zzjt r0 = (com.google.android.gms.internal.measurement.zzjt) r0
            int r1 = r0.zza()
            int r2 = com.google.android.gms.internal.measurement.zzhv.zze.zzi
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x0014
            r11 = 1
            goto L_0x0015
        L_0x0014:
            r11 = 0
        L_0x0015:
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r6) goto L_0x0031
            r5 = 1
        L_0x0027:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x0032
            r5 = r7
            goto L_0x0027
        L_0x0031:
            r7 = 1
        L_0x0032:
            int r5 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0051
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x003e:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x004e
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r7 = r7 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x003e
        L_0x004e:
            int r5 = r5 << r9
            r7 = r7 | r5
            goto L_0x0052
        L_0x0051:
            r10 = r5
        L_0x0052:
            if (r7 != 0) goto L_0x0061
            int[] r5 = zza
            r15 = r5
            r5 = 0
            r7 = 0
            r9 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            goto L_0x018a
        L_0x0061:
            int r5 = r10 + 1
            char r7 = r1.charAt(r10)
            if (r7 < r6) goto L_0x0080
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x006d:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x007d
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r7 = r7 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x006d
        L_0x007d:
            int r5 = r5 << r9
            r5 = r5 | r7
            goto L_0x0082
        L_0x0080:
            r10 = r5
            r5 = r7
        L_0x0082:
            int r7 = r10 + 1
            char r9 = r1.charAt(r10)
            if (r9 < r6) goto L_0x00a1
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x008e:
            int r12 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x009e
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r10
            r9 = r9 | r7
            int r10 = r10 + 13
            r7 = r12
            goto L_0x008e
        L_0x009e:
            int r7 = r7 << r10
            r9 = r9 | r7
            goto L_0x00a2
        L_0x00a1:
            r12 = r7
        L_0x00a2:
            int r7 = r12 + 1
            char r10 = r1.charAt(r12)
            if (r10 < r6) goto L_0x00c2
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00ae:
            int r13 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x00be
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r12
            r10 = r10 | r7
            int r12 = r12 + 13
            r7 = r13
            goto L_0x00ae
        L_0x00be:
            int r7 = r7 << r12
            r7 = r7 | r10
            r10 = r7
            goto L_0x00c3
        L_0x00c2:
            r13 = r7
        L_0x00c3:
            int r7 = r13 + 1
            char r12 = r1.charAt(r13)
            if (r12 < r6) goto L_0x00e3
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00cf:
            int r14 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x00df
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r13
            r12 = r12 | r7
            int r13 = r13 + 13
            r7 = r14
            goto L_0x00cf
        L_0x00df:
            int r7 = r7 << r13
            r7 = r7 | r12
            r12 = r7
            goto L_0x00e4
        L_0x00e3:
            r14 = r7
        L_0x00e4:
            int r7 = r14 + 1
            char r13 = r1.charAt(r14)
            if (r13 < r6) goto L_0x0104
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00f0:
            int r15 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0100
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r14
            r13 = r13 | r7
            int r14 = r14 + 13
            r7 = r15
            goto L_0x00f0
        L_0x0100:
            int r7 = r7 << r14
            r7 = r7 | r13
            r13 = r7
            goto L_0x0105
        L_0x0104:
            r15 = r7
        L_0x0105:
            int r7 = r15 + 1
            char r14 = r1.charAt(r15)
            if (r14 < r6) goto L_0x0127
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0111:
            int r16 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0122
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r15
            r14 = r14 | r7
            int r15 = r15 + 13
            r7 = r16
            goto L_0x0111
        L_0x0122:
            int r7 = r7 << r15
            r7 = r7 | r14
            r14 = r7
            r7 = r16
        L_0x0127:
            int r15 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x014a
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0133:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0145
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r7 = r7 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0133
        L_0x0145:
            int r15 = r15 << r16
            r7 = r7 | r15
            r15 = r17
        L_0x014a:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0175
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r32 = r16
            r16 = r15
            r15 = r32
        L_0x015c:
            int r18 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x016f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r17
            r16 = r16 | r15
            int r17 = r17 + 13
            r15 = r18
            goto L_0x015c
        L_0x016f:
            int r15 = r15 << r17
            r15 = r16 | r15
            r16 = r18
        L_0x0175:
            int r17 = r15 + r14
            int r7 = r17 + r7
            int[] r7 = new int[r7]
            int r17 = r5 << 1
            int r9 = r17 + r9
            r32 = r16
            r16 = r5
            r5 = r14
            r14 = r15
            r15 = r7
            r7 = r9
            r9 = r10
            r10 = r32
        L_0x018a:
            sun.misc.Unsafe r3 = zzb
            java.lang.Object[] r17 = r0.zze()
            com.google.android.gms.internal.measurement.zzjg r18 = r0.zzc()
            java.lang.Class r8 = r18.getClass()
            int r6 = r13 * 3
            int[] r6 = new int[r6]
            int r13 = r13 << r4
            java.lang.Object[] r13 = new java.lang.Object[r13]
            int r19 = r14 + r5
            r21 = r14
            r22 = r19
            r5 = 0
            r20 = 0
        L_0x01a8:
            if (r10 >= r2) goto L_0x03ea
            int r23 = r10 + 1
            char r10 = r1.charAt(r10)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r10 < r4) goto L_0x01dc
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r25 = 13
            r32 = r23
            r23 = r10
            r10 = r32
        L_0x01bf:
            int r26 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r4) goto L_0x01d5
            r4 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r25
            r23 = r23 | r4
            int r25 = r25 + 13
            r10 = r26
            r4 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01bf
        L_0x01d5:
            int r4 = r10 << r25
            r10 = r23 | r4
            r4 = r26
            goto L_0x01de
        L_0x01dc:
            r4 = r23
        L_0x01de:
            int r23 = r4 + 1
            char r4 = r1.charAt(r4)
            r25 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r2) goto L_0x0212
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
            r32 = r23
            r23 = r4
            r4 = r32
        L_0x01f5:
            int r27 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r2) goto L_0x020b
            r2 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r26
            r23 = r23 | r2
            int r26 = r26 + 13
            r4 = r27
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01f5
        L_0x020b:
            int r2 = r4 << r26
            r4 = r23 | r2
            r2 = r27
            goto L_0x0214
        L_0x0212:
            r2 = r23
        L_0x0214:
            r23 = r14
            r14 = r4 & 255(0xff, float:3.57E-43)
            r26 = r12
            r12 = r4 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0223
            int r12 = r5 + 1
            r15[r5] = r20
            r5 = r12
        L_0x0223:
            r12 = 51
            r29 = r5
            if (r14 < r12) goto L_0x02bc
            int r12 = r2 + 1
            char r2 = r1.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r5) goto L_0x0252
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r30 = 13
        L_0x0238:
            int r31 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x024d
            r5 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r30
            r2 = r2 | r5
            int r30 = r30 + 13
            r12 = r31
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0238
        L_0x024d:
            int r5 = r12 << r30
            r2 = r2 | r5
            r12 = r31
        L_0x0252:
            int r5 = r14 + -51
            r30 = r12
            r12 = 9
            if (r5 == r12) goto L_0x0273
            r12 = 17
            if (r5 != r12) goto L_0x025f
            goto L_0x0273
        L_0x025f:
            r12 = 12
            if (r5 != r12) goto L_0x0271
            if (r11 != 0) goto L_0x0271
            int r5 = r20 / 3
            r12 = 1
            int r5 = r5 << r12
            int r5 = r5 + r12
            int r12 = r7 + 1
            r7 = r17[r7]
            r13[r5] = r7
            r7 = r12
        L_0x0271:
            r12 = 1
            goto L_0x0280
        L_0x0273:
            int r5 = r20 / 3
            r12 = 1
            int r5 = r5 << r12
            int r5 = r5 + r12
            int r24 = r7 + 1
            r7 = r17[r7]
            r13[r5] = r7
            r7 = r24
        L_0x0280:
            int r2 = r2 << r12
            r5 = r17[r2]
            boolean r12 = r5 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x028a
            java.lang.reflect.Field r5 = (java.lang.reflect.Field) r5
            goto L_0x0292
        L_0x028a:
            java.lang.String r5 = (java.lang.String) r5
            java.lang.reflect.Field r5 = zza((java.lang.Class<?>) r8, (java.lang.String) r5)
            r17[r2] = r5
        L_0x0292:
            r12 = r6
            long r5 = r3.objectFieldOffset(r5)
            int r6 = (int) r5
            int r2 = r2 + 1
            r5 = r17[r2]
            r27 = r6
            boolean r6 = r5 instanceof java.lang.reflect.Field
            if (r6 == 0) goto L_0x02a5
            java.lang.reflect.Field r5 = (java.lang.reflect.Field) r5
            goto L_0x02ad
        L_0x02a5:
            java.lang.String r5 = (java.lang.String) r5
            java.lang.reflect.Field r5 = zza((java.lang.Class<?>) r8, (java.lang.String) r5)
            r17[r2] = r5
        L_0x02ad:
            long r5 = r3.objectFieldOffset(r5)
            int r2 = (int) r5
            r5 = r2
            r18 = r8
            r6 = r27
            r28 = r30
            r2 = 0
            goto L_0x03ae
        L_0x02bc:
            r12 = r6
            int r5 = r7 + 1
            r6 = r17[r7]
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = zza((java.lang.Class<?>) r8, (java.lang.String) r6)
            r7 = 9
            if (r14 == r7) goto L_0x032e
            r7 = 17
            if (r14 != r7) goto L_0x02d0
            goto L_0x032e
        L_0x02d0:
            r7 = 27
            if (r14 == r7) goto L_0x031f
            r7 = 49
            if (r14 != r7) goto L_0x02d9
            goto L_0x031f
        L_0x02d9:
            r7 = 12
            if (r14 == r7) goto L_0x030b
            r7 = 30
            if (r14 == r7) goto L_0x030b
            r7 = 44
            if (r14 != r7) goto L_0x02e6
            goto L_0x030b
        L_0x02e6:
            r7 = 50
            if (r14 != r7) goto L_0x033c
            int r7 = r21 + 1
            r15[r21] = r20
            int r21 = r20 / 3
            r24 = 1
            int r21 = r21 << 1
            int r27 = r5 + 1
            r5 = r17[r5]
            r13[r21] = r5
            r5 = r4 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0308
            int r21 = r21 + 1
            int r5 = r27 + 1
            r27 = r17[r27]
            r13[r21] = r27
            r27 = r5
        L_0x0308:
            r21 = r7
            goto L_0x033e
        L_0x030b:
            if (r11 != 0) goto L_0x031c
            int r7 = r20 / 3
            r24 = 1
            int r7 = r7 << 1
            int r7 = r7 + 1
            int r27 = r5 + 1
            r5 = r17[r5]
            r13[r7] = r5
            goto L_0x033e
        L_0x031c:
            r24 = 1
            goto L_0x033c
        L_0x031f:
            r24 = 1
            int r7 = r20 / 3
            int r7 = r7 << 1
            int r7 = r7 + 1
            int r27 = r5 + 1
            r5 = r17[r5]
            r13[r7] = r5
            goto L_0x033e
        L_0x032e:
            r24 = 1
            int r7 = r20 / 3
            int r7 = r7 << 1
            int r7 = r7 + 1
            java.lang.Class r27 = r6.getType()
            r13[r7] = r27
        L_0x033c:
            r27 = r5
        L_0x033e:
            long r5 = r3.objectFieldOffset(r6)
            int r6 = (int) r5
            r5 = r4 & 4096(0x1000, float:5.74E-42)
            r7 = 4096(0x1000, float:5.74E-42)
            if (r5 != r7) goto L_0x0396
            r5 = 17
            if (r14 > r5) goto L_0x0396
            int r5 = r2 + 1
            char r2 = r1.charAt(r2)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r7) goto L_0x0372
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r18 = 13
        L_0x035c:
            int r28 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r7) goto L_0x036e
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r18
            r2 = r2 | r5
            int r18 = r18 + 13
            r5 = r28
            goto L_0x035c
        L_0x036e:
            int r5 = r5 << r18
            r2 = r2 | r5
            goto L_0x0374
        L_0x0372:
            r28 = r5
        L_0x0374:
            r5 = 1
            int r18 = r16 << 1
            int r24 = r2 / 32
            int r18 = r18 + r24
            r5 = r17[r18]
            boolean r7 = r5 instanceof java.lang.reflect.Field
            if (r7 == 0) goto L_0x0384
            java.lang.reflect.Field r5 = (java.lang.reflect.Field) r5
            goto L_0x038c
        L_0x0384:
            java.lang.String r5 = (java.lang.String) r5
            java.lang.reflect.Field r5 = zza((java.lang.Class<?>) r8, (java.lang.String) r5)
            r17[r18] = r5
        L_0x038c:
            r18 = r8
            long r7 = r3.objectFieldOffset(r5)
            int r5 = (int) r7
            int r2 = r2 % 32
            goto L_0x039e
        L_0x0396:
            r18 = r8
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r28 = r2
            r2 = 0
        L_0x039e:
            r7 = 18
            if (r14 < r7) goto L_0x03ac
            r7 = 49
            if (r14 > r7) goto L_0x03ac
            int r7 = r22 + 1
            r15[r22] = r6
            r22 = r7
        L_0x03ac:
            r7 = r27
        L_0x03ae:
            int r8 = r20 + 1
            r12[r20] = r10
            int r10 = r8 + 1
            r20 = r1
            r1 = r4 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x03bd
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03be
        L_0x03bd:
            r1 = 0
        L_0x03be:
            r4 = r4 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x03c5
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03c6
        L_0x03c5:
            r4 = 0
        L_0x03c6:
            r1 = r1 | r4
            int r4 = r14 << 20
            r1 = r1 | r4
            r1 = r1 | r6
            r12[r8] = r1
            int r1 = r10 + 1
            int r2 = r2 << 20
            r2 = r2 | r5
            r12[r10] = r2
            r6 = r12
            r8 = r18
            r14 = r23
            r2 = r25
            r12 = r26
            r10 = r28
            r5 = r29
            r4 = 1
            r32 = r20
            r20 = r1
            r1 = r32
            goto L_0x01a8
        L_0x03ea:
            r26 = r12
            r23 = r14
            r12 = r6
            com.google.android.gms.internal.measurement.zzjk r1 = new com.google.android.gms.internal.measurement.zzjk
            com.google.android.gms.internal.measurement.zzjg r10 = r0.zzc()
            r0 = 0
            r5 = r1
            r7 = r13
            r8 = r9
            r9 = r26
            r12 = r0
            r13 = r15
            r15 = r19
            r16 = r35
            r17 = r36
            r18 = r37
            r19 = r38
            r20 = r39
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x040d:
            com.google.android.gms.internal.measurement.zzkk r0 = (com.google.android.gms.internal.measurement.zzkk) r0
            int r0 = r0.zza()
            int r1 = com.google.android.gms.internal.measurement.zzhv.zze.zzi
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzje, com.google.android.gms.internal.measurement.zzjo, com.google.android.gms.internal.measurement.zziq, com.google.android.gms.internal.measurement.zzkn, com.google.android.gms.internal.measurement.zzhk, com.google.android.gms.internal.measurement.zziz):com.google.android.gms.internal.measurement.zzjk");
    }

    private final zzjv zza(int i) {
        int i2 = (i / 3) << 1;
        zzjv zzjv = (zzjv) this.zzd[i2];
        if (zzjv != null) {
            return zzjv;
        }
        zzjv zza2 = zzjr.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzic zzic, UB ub, zzkn<UT, UB> zzkn) {
        zzix<?, ?> zzf2 = this.zzs.zzf(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzic.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzkn.zza();
                }
                zzgu zzc2 = zzgm.zzc(zziy.zza(zzf2, next.getKey(), next.getValue()));
                try {
                    zziy.zza(zzc2.zzb(), zzf2, next.getKey(), next.getValue());
                    zzkn.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzkn<UT, UB> zzkn) {
        zzic zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzkt.zzf(obj, (long) (zzd(i) & 1048575));
        if (zzf2 == null || (zzc2 = zzc(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzs.zza(zzf2), zzc2, ub, zzkn);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzkt.zzf(obj, j);
    }

    private static void zza(int i, Object obj, zzlk zzlk) {
        if (obj instanceof String) {
            zzlk.zza(i, (String) obj);
        } else {
            zzlk.zza(i, (zzgm) obj);
        }
    }

    private static <UT, UB> void zza(zzkn<UT, UB> zzkn, T t, zzlk zzlk) {
        zzkn.zza(zzkn.zzb(t), zzlk);
    }

    private final <K, V> void zza(zzlk zzlk, int i, Object obj, int i2) {
        if (obj != null) {
            zzlk.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private final void zza(Object obj, int i, zzjw zzjw) {
        long j;
        Object zzn2;
        if (zzf(i)) {
            j = (long) (i & 1048575);
            zzn2 = zzjw.zzm();
        } else if (this.zzi) {
            j = (long) (i & 1048575);
            zzn2 = zzjw.zzl();
        } else {
            j = (long) (i & 1048575);
            zzn2 = zzjw.zzn();
        }
        zzkt.zza(obj, j, zzn2);
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza(t2, i)) {
            Object zzf2 = zzkt.zzf(t, zzd2);
            Object zzf3 = zzkt.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzkt.zza((Object) t, zzd2, zzhx.zza(zzf2, zzf3));
                zzb(t, i);
            } else if (zzf3 != null) {
                zzkt.zza((Object) t, zzd2, zzf3);
                zzb(t, i);
            }
        }
    }

    private final boolean zza(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (zze2 & 1048575);
        if (j == 1048575) {
            int zzd2 = zzd(i);
            long j2 = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzkt.zze(t, j2) != 0.0d;
                case 1:
                    return zzkt.zzd(t, j2) != 0.0f;
                case 2:
                    return zzkt.zzb(t, j2) != 0;
                case 3:
                    return zzkt.zzb(t, j2) != 0;
                case 4:
                    return zzkt.zza((Object) t, j2) != 0;
                case 5:
                    return zzkt.zzb(t, j2) != 0;
                case 6:
                    return zzkt.zza((Object) t, j2) != 0;
                case 7:
                    return zzkt.zzc(t, j2);
                case 8:
                    Object zzf2 = zzkt.zzf(t, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzgm) {
                        return !zzgm.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzkt.zzf(t, j2) != null;
                case 10:
                    return !zzgm.zza.equals(zzkt.zzf(t, j2));
                case 11:
                    return zzkt.zza((Object) t, j2) != 0;
                case 12:
                    return zzkt.zza((Object) t, j2) != 0;
                case 13:
                    return zzkt.zza((Object) t, j2) != 0;
                case 14:
                    return zzkt.zzb(t, j2) != 0;
                case 15:
                    return zzkt.zza((Object) t, j2) != 0;
                case 16:
                    return zzkt.zzb(t, j2) != 0;
                case 17:
                    return zzkt.zzf(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzkt.zza((Object) t, j) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzkt.zza((Object) t, (long) (zze(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zza(t, i) : (i3 & i4) != 0;
    }

    private static boolean zza(Object obj, int i, zzjv zzjv) {
        return zzjv.zzd(zzkt.zzf(obj, (long) (i & 1048575)));
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzkt.zzf(t, j)).doubleValue();
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final void zzb(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (1048575 & zze2);
        if (j != 1048575) {
            zzkt.zza((Object) t, j, (1 << (zze2 >>> 20)) | zzkt.zza((Object) t, j));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzkt.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x023e, code lost:
        com.google.android.gms.internal.measurement.zzjx.zzj(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x024e, code lost:
        com.google.android.gms.internal.measurement.zzjx.zzg(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x025e, code lost:
        com.google.android.gms.internal.measurement.zzjx.zzl(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x026e, code lost:
        com.google.android.gms.internal.measurement.zzjx.zzm(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x027e, code lost:
        com.google.android.gms.internal.measurement.zzjx.zzi(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02c5, code lost:
        com.google.android.gms.internal.measurement.zzjx.zzn(r4, r9, r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02cf, code lost:
        com.google.android.gms.internal.measurement.zzjx.zzk(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02df, code lost:
        com.google.android.gms.internal.measurement.zzjx.zzf(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02ef, code lost:
        com.google.android.gms.internal.measurement.zzjx.zzh(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02ff, code lost:
        com.google.android.gms.internal.measurement.zzjx.zzd(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x030f, code lost:
        com.google.android.gms.internal.measurement.zzjx.zzc(r4, (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x031f, code lost:
        com.google.android.gms.internal.measurement.zzjx.zzb(r4, (java.util.List<java.lang.Float>) (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x032f, code lost:
        com.google.android.gms.internal.measurement.zzjx.zza(r4, (java.util.List<java.lang.Double>) (java.util.List) r7.getObject(r1, r13), r2, r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0424, code lost:
        r5 = r5 + 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0234, code lost:
        com.google.android.gms.internal.measurement.zzjx.zze(r4, r9, r2, r15);
     */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x042b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.measurement.zzlk r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.measurement.zzhk<?> r3 = r0.zzr
            com.google.android.gms.internal.measurement.zzho r3 = r3.zza((java.lang.Object) r1)
            com.google.android.gms.internal.measurement.zzka<T, java.lang.Object> r5 = r3.zza
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.zzd()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            int[] r6 = r0.zzc
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzb
            r11 = r5
            r5 = 0
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x0030:
            if (r5 >= r6) goto L_0x0428
            int r13 = r0.zzd((int) r5)
            int[] r14 = r0.zzc
            r15 = r14[r5]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r16 = r13 & r16
            int r4 = r16 >>> 20
            boolean r9 = r0.zzj
            if (r9 != 0) goto L_0x0064
            r9 = 17
            if (r4 > r9) goto L_0x0064
            int r9 = r5 + 2
            r9 = r14[r9]
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r9 & r14
            if (r8 == r10) goto L_0x005a
            r14 = r11
            long r10 = (long) r8
            int r12 = r7.getInt(r1, r10)
            goto L_0x005c
        L_0x005a:
            r14 = r11
            r8 = r10
        L_0x005c:
            int r9 = r9 >>> 20
            r10 = 1
            int r9 = r10 << r9
            r10 = r8
            r11 = r14
            goto L_0x0067
        L_0x0064:
            r14 = r11
            r11 = r14
            r9 = 0
        L_0x0067:
            if (r11 == 0) goto L_0x0086
            com.google.android.gms.internal.measurement.zzhk<?> r8 = r0.zzr
            int r8 = r8.zza((java.util.Map.Entry<?, ?>) r11)
            if (r8 > r15) goto L_0x0086
            com.google.android.gms.internal.measurement.zzhk<?> r8 = r0.zzr
            r8.zza(r2, r11)
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x0084
            java.lang.Object r8 = r3.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            r11 = r8
            goto L_0x0067
        L_0x0084:
            r11 = 0
            goto L_0x0067
        L_0x0086:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r13 & r8
            long r13 = (long) r13
            switch(r4) {
                case 0: goto L_0x0419;
                case 1: goto L_0x040d;
                case 2: goto L_0x0401;
                case 3: goto L_0x03f5;
                case 4: goto L_0x03e9;
                case 5: goto L_0x03dd;
                case 6: goto L_0x03d1;
                case 7: goto L_0x03c5;
                case 8: goto L_0x03b9;
                case 9: goto L_0x03a8;
                case 10: goto L_0x0399;
                case 11: goto L_0x038c;
                case 12: goto L_0x037f;
                case 13: goto L_0x0372;
                case 14: goto L_0x0365;
                case 15: goto L_0x0358;
                case 16: goto L_0x034b;
                case 17: goto L_0x033a;
                case 18: goto L_0x032a;
                case 19: goto L_0x031a;
                case 20: goto L_0x030a;
                case 21: goto L_0x02fa;
                case 22: goto L_0x02ea;
                case 23: goto L_0x02da;
                case 24: goto L_0x02ca;
                case 25: goto L_0x02ba;
                case 26: goto L_0x02ab;
                case 27: goto L_0x0298;
                case 28: goto L_0x0289;
                case 29: goto L_0x0279;
                case 30: goto L_0x0269;
                case 31: goto L_0x0259;
                case 32: goto L_0x0249;
                case 33: goto L_0x0239;
                case 34: goto L_0x0229;
                case 35: goto L_0x0222;
                case 36: goto L_0x021b;
                case 37: goto L_0x0214;
                case 38: goto L_0x020d;
                case 39: goto L_0x0206;
                case 40: goto L_0x01ff;
                case 41: goto L_0x01f8;
                case 42: goto L_0x01eb;
                case 43: goto L_0x01e4;
                case 44: goto L_0x01dd;
                case 45: goto L_0x01d6;
                case 46: goto L_0x01cf;
                case 47: goto L_0x01c9;
                case 48: goto L_0x01bd;
                case 49: goto L_0x01aa;
                case 50: goto L_0x01a1;
                case 51: goto L_0x0192;
                case 52: goto L_0x0183;
                case 53: goto L_0x0174;
                case 54: goto L_0x0165;
                case 55: goto L_0x0156;
                case 56: goto L_0x0147;
                case 57: goto L_0x0138;
                case 58: goto L_0x0129;
                case 59: goto L_0x011a;
                case 60: goto L_0x0107;
                case 61: goto L_0x00f7;
                case 62: goto L_0x00e9;
                case 63: goto L_0x00db;
                case 64: goto L_0x00cd;
                case 65: goto L_0x00bf;
                case 66: goto L_0x00b1;
                case 67: goto L_0x00a3;
                case 68: goto L_0x0091;
                default: goto L_0x008e;
            }
        L_0x008e:
            r4 = 0
            goto L_0x0424
        L_0x0091:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzjv r9 = r0.zza((int) r5)
            r2.zzb((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzjv) r9)
            goto L_0x008e
        L_0x00a3:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zze(r1, r13)
            r2.zze((int) r15, (long) r13)
            goto L_0x008e
        L_0x00b1:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r13)
            r2.zzf(r15, r4)
            goto L_0x008e
        L_0x00bf:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zze(r1, r13)
            r2.zzb((int) r15, (long) r13)
            goto L_0x008e
        L_0x00cd:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r13)
            r2.zza((int) r15, (int) r4)
            goto L_0x008e
        L_0x00db:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r13)
            r2.zzb((int) r15, (int) r4)
            goto L_0x008e
        L_0x00e9:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r13)
            r2.zze((int) r15, (int) r4)
            goto L_0x008e
        L_0x00f7:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzgm r4 = (com.google.android.gms.internal.measurement.zzgm) r4
            r2.zza((int) r15, (com.google.android.gms.internal.measurement.zzgm) r4)
            goto L_0x008e
        L_0x0107:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzjv r9 = r0.zza((int) r5)
            r2.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzjv) r9)
            goto L_0x008e
        L_0x011a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzlk) r2)
            goto L_0x008e
        L_0x0129:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            boolean r4 = zzf(r1, r13)
            r2.zza((int) r15, (boolean) r4)
            goto L_0x008e
        L_0x0138:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r13)
            r2.zzd((int) r15, (int) r4)
            goto L_0x008e
        L_0x0147:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zze(r1, r13)
            r2.zzd((int) r15, (long) r13)
            goto L_0x008e
        L_0x0156:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r13)
            r2.zzc((int) r15, (int) r4)
            goto L_0x008e
        L_0x0165:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zze(r1, r13)
            r2.zzc((int) r15, (long) r13)
            goto L_0x008e
        L_0x0174:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zze(r1, r13)
            r2.zza((int) r15, (long) r13)
            goto L_0x008e
        L_0x0183:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            float r4 = zzc(r1, r13)
            r2.zza((int) r15, (float) r4)
            goto L_0x008e
        L_0x0192:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            double r13 = zzb(r1, (long) r13)
            r2.zza((int) r15, (double) r13)
            goto L_0x008e
        L_0x01a1:
            java.lang.Object r4 = r7.getObject(r1, r13)
            r0.zza((com.google.android.gms.internal.measurement.zzlk) r2, (int) r15, (java.lang.Object) r4, (int) r5)
            goto L_0x008e
        L_0x01aa:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjv r13 = r0.zza((int) r5)
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzlk) r2, (com.google.android.gms.internal.measurement.zzjv) r13)
            goto L_0x008e
        L_0x01bd:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 1
            goto L_0x0234
        L_0x01c9:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            goto L_0x023e
        L_0x01cf:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            goto L_0x024e
        L_0x01d6:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            goto L_0x025e
        L_0x01dd:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            goto L_0x026e
        L_0x01e4:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            goto L_0x027e
        L_0x01eb:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            goto L_0x02c5
        L_0x01f8:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            goto L_0x02cf
        L_0x01ff:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            goto L_0x02df
        L_0x0206:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            goto L_0x02ef
        L_0x020d:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            goto L_0x02ff
        L_0x0214:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            goto L_0x030f
        L_0x021b:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            goto L_0x031f
        L_0x0222:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            goto L_0x032f
        L_0x0229:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
        L_0x0234:
            com.google.android.gms.internal.measurement.zzjx.zze(r4, r9, r2, r15)
            goto L_0x008e
        L_0x0239:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
        L_0x023e:
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzj(r4, r9, r2, r15)
            goto L_0x008e
        L_0x0249:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
        L_0x024e:
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzg(r4, r9, r2, r15)
            goto L_0x008e
        L_0x0259:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
        L_0x025e:
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzl(r4, r9, r2, r15)
            goto L_0x008e
        L_0x0269:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
        L_0x026e:
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzm(r4, r9, r2, r15)
            goto L_0x008e
        L_0x0279:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
        L_0x027e:
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzi(r4, r9, r2, r15)
            goto L_0x008e
        L_0x0289:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzgm>) r9, (com.google.android.gms.internal.measurement.zzlk) r2)
            goto L_0x008e
        L_0x0298:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjv r13 = r0.zza((int) r5)
            com.google.android.gms.internal.measurement.zzjx.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzlk) r2, (com.google.android.gms.internal.measurement.zzjv) r13)
            goto L_0x008e
        L_0x02ab:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.measurement.zzlk) r2)
            goto L_0x008e
        L_0x02ba:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
        L_0x02c5:
            com.google.android.gms.internal.measurement.zzjx.zzn(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02ca:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
        L_0x02cf:
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzk(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02da:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
        L_0x02df:
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzf(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02ea:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
        L_0x02ef:
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzh(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02fa:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
        L_0x02ff:
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzd(r4, r9, r2, r15)
            goto L_0x008e
        L_0x030a:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
        L_0x030f:
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzc(r4, r9, r2, r15)
            goto L_0x008e
        L_0x031a:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
        L_0x031f:
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzlk) r2, (boolean) r15)
            goto L_0x008e
        L_0x032a:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
        L_0x032f:
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzlk) r2, (boolean) r15)
            goto L_0x008e
        L_0x033a:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzjv r13 = r0.zza((int) r5)
            r2.zzb((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzjv) r13)
            goto L_0x0424
        L_0x034b:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            long r13 = r7.getLong(r1, r13)
            r2.zze((int) r15, (long) r13)
            goto L_0x0424
        L_0x0358:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            int r9 = r7.getInt(r1, r13)
            r2.zzf(r15, r9)
            goto L_0x0424
        L_0x0365:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            long r13 = r7.getLong(r1, r13)
            r2.zzb((int) r15, (long) r13)
            goto L_0x0424
        L_0x0372:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            int r9 = r7.getInt(r1, r13)
            r2.zza((int) r15, (int) r9)
            goto L_0x0424
        L_0x037f:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            int r9 = r7.getInt(r1, r13)
            r2.zzb((int) r15, (int) r9)
            goto L_0x0424
        L_0x038c:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            int r9 = r7.getInt(r1, r13)
            r2.zze((int) r15, (int) r9)
            goto L_0x0424
        L_0x0399:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzgm r9 = (com.google.android.gms.internal.measurement.zzgm) r9
            r2.zza((int) r15, (com.google.android.gms.internal.measurement.zzgm) r9)
            goto L_0x0424
        L_0x03a8:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzjv r13 = r0.zza((int) r5)
            r2.zza((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzjv) r13)
            goto L_0x0424
        L_0x03b9:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            java.lang.Object r9 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzlk) r2)
            goto L_0x0424
        L_0x03c5:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            boolean r9 = com.google.android.gms.internal.measurement.zzkt.zzc(r1, r13)
            r2.zza((int) r15, (boolean) r9)
            goto L_0x0424
        L_0x03d1:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            int r9 = r7.getInt(r1, r13)
            r2.zzd((int) r15, (int) r9)
            goto L_0x0424
        L_0x03dd:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            long r13 = r7.getLong(r1, r13)
            r2.zzd((int) r15, (long) r13)
            goto L_0x0424
        L_0x03e9:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            int r9 = r7.getInt(r1, r13)
            r2.zzc((int) r15, (int) r9)
            goto L_0x0424
        L_0x03f5:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            long r13 = r7.getLong(r1, r13)
            r2.zzc((int) r15, (long) r13)
            goto L_0x0424
        L_0x0401:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            long r13 = r7.getLong(r1, r13)
            r2.zza((int) r15, (long) r13)
            goto L_0x0424
        L_0x040d:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            float r9 = com.google.android.gms.internal.measurement.zzkt.zzd(r1, r13)
            r2.zza((int) r15, (float) r9)
            goto L_0x0424
        L_0x0419:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0424
            double r13 = com.google.android.gms.internal.measurement.zzkt.zze(r1, r13)
            r2.zza((int) r15, (double) r13)
        L_0x0424:
            int r5 = r5 + 3
            goto L_0x0030
        L_0x0428:
            r14 = r11
        L_0x0429:
            if (r14 == 0) goto L_0x0440
            com.google.android.gms.internal.measurement.zzhk<?> r4 = r0.zzr
            r4.zza(r2, r14)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x043e
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r14 = r4
            goto L_0x0429
        L_0x043e:
            r14 = 0
            goto L_0x0429
        L_0x0440:
            com.google.android.gms.internal.measurement.zzkn<?, ?> r3 = r0.zzq
            zza(r3, r1, (com.google.android.gms.internal.measurement.zzlk) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzlk):void");
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zzkt.zzf(t, j);
            Object zzf3 = zzkt.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzkt.zza((Object) t, j, zzhx.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zzkt.zza((Object) t, j, zzf3);
                zzb(t, i2, i);
            }
        }
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzkt.zzf(t, j)).floatValue();
    }

    private final zzic zzc(int i) {
        return (zzic) this.zzd[((i / 3) << 1) + 1];
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzkt.zzf(t, j)).intValue();
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzkt.zzf(t, j)).longValue();
    }

    private static zzkq zze(Object obj) {
        zzhv zzhv = (zzhv) obj;
        zzkq zzkq = zzhv.zzb;
        if (zzkq != zzkq.zza()) {
            return zzkq;
        }
        zzkq zzb2 = zzkq.zzb();
        zzhv.zzb = zzb2;
        return zzb2;
    }

    private static boolean zzf(int i) {
        return (i & PKIFailureInfo.duplicateCertReq) != 0;
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzkt.zzf(t, j)).booleanValue();
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
        r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5);
        r2 = r2 * 53;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0093, code lost:
        r2 = r2 * 53;
        r3 = zzd(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a8, code lost:
        r2 = r2 * 53;
        r3 = zze(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d1, code lost:
        r2 = r2 * 53;
        r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d7, code lost:
        r3 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ea, code lost:
        r2 = r2 * 53;
        r3 = ((java.lang.String) com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)).hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fd, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhx.zza(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0116, code lost:
        r3 = java.lang.Float.floatToIntBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0121, code lost:
        r3 = java.lang.Double.doubleToLongBits(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0125, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhx.zza(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0129, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012a, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x012e
            int r3 = r8.zzd((int) r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x011b;
                case 1: goto L_0x0110;
                case 2: goto L_0x0109;
                case 3: goto L_0x0109;
                case 4: goto L_0x0102;
                case 5: goto L_0x0109;
                case 6: goto L_0x0102;
                case 7: goto L_0x00f7;
                case 8: goto L_0x00ea;
                case 9: goto L_0x00dc;
                case 10: goto L_0x00d1;
                case 11: goto L_0x0102;
                case 12: goto L_0x0102;
                case 13: goto L_0x0102;
                case 14: goto L_0x0109;
                case 15: goto L_0x0102;
                case 16: goto L_0x0109;
                case 17: goto L_0x00ca;
                case 18: goto L_0x00d1;
                case 19: goto L_0x00d1;
                case 20: goto L_0x00d1;
                case 21: goto L_0x00d1;
                case 22: goto L_0x00d1;
                case 23: goto L_0x00d1;
                case 24: goto L_0x00d1;
                case 25: goto L_0x00d1;
                case 26: goto L_0x00d1;
                case 27: goto L_0x00d1;
                case 28: goto L_0x00d1;
                case 29: goto L_0x00d1;
                case 30: goto L_0x00d1;
                case 31: goto L_0x00d1;
                case 32: goto L_0x00d1;
                case 33: goto L_0x00d1;
                case 34: goto L_0x00d1;
                case 35: goto L_0x00d1;
                case 36: goto L_0x00d1;
                case 37: goto L_0x00d1;
                case 38: goto L_0x00d1;
                case 39: goto L_0x00d1;
                case 40: goto L_0x00d1;
                case 41: goto L_0x00d1;
                case 42: goto L_0x00d1;
                case 43: goto L_0x00d1;
                case 44: goto L_0x00d1;
                case 45: goto L_0x00d1;
                case 46: goto L_0x00d1;
                case 47: goto L_0x00d1;
                case 48: goto L_0x00d1;
                case 49: goto L_0x00d1;
                case 50: goto L_0x00d1;
                case 51: goto L_0x00bd;
                case 52: goto L_0x00b0;
                case 53: goto L_0x00a2;
                case 54: goto L_0x009b;
                case 55: goto L_0x008d;
                case 56: goto L_0x0086;
                case 57: goto L_0x007f;
                case 58: goto L_0x0071;
                case 59: goto L_0x0069;
                case 60: goto L_0x005b;
                case 61: goto L_0x0053;
                case 62: goto L_0x004c;
                case 63: goto L_0x0045;
                case 64: goto L_0x003e;
                case 65: goto L_0x0036;
                case 66: goto L_0x002f;
                case 67: goto L_0x0027;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x012a
        L_0x0020:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x0061
        L_0x0027:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x002f:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x004b
        L_0x0036:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x003e:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x004b
        L_0x0045:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
        L_0x004b:
            goto L_0x0093
        L_0x004c:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x0093
        L_0x0053:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00d1
        L_0x005b:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
        L_0x0061:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            int r2 = r2 * 53
            goto L_0x00d7
        L_0x0069:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00ea
        L_0x0071:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            int r2 = r2 * 53
            boolean r3 = zzf(r9, r5)
            goto L_0x00fd
        L_0x007f:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x0093
        L_0x0086:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x008d:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
        L_0x0093:
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0129
        L_0x009b:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x00a2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
        L_0x00a8:
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            goto L_0x0125
        L_0x00b0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            int r2 = r2 * 53
            float r3 = zzc(r9, r5)
            goto L_0x0116
        L_0x00bd:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x012a
            int r2 = r2 * 53
            double r3 = zzb(r9, (long) r5)
            goto L_0x0121
        L_0x00ca:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            if (r3 == 0) goto L_0x00e6
            goto L_0x00e2
        L_0x00d1:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
        L_0x00d7:
            int r3 = r3.hashCode()
            goto L_0x0129
        L_0x00dc:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            if (r3 == 0) goto L_0x00e6
        L_0x00e2:
            int r7 = r3.hashCode()
        L_0x00e6:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x012a
        L_0x00ea:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0129
        L_0x00f7:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zzkt.zzc(r9, r5)
        L_0x00fd:
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((boolean) r3)
            goto L_0x0129
        L_0x0102:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0129
        L_0x0109:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzkt.zzb(r9, r5)
            goto L_0x0125
        L_0x0110:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zzkt.zzd(r9, r5)
        L_0x0116:
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0129
        L_0x011b:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zzkt.zze(r9, r5)
        L_0x0121:
            long r3 = java.lang.Double.doubleToLongBits(r3)
        L_0x0125:
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((long) r3)
        L_0x0129:
            int r2 = r2 + r3
        L_0x012a:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x012e:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzkn<?, ?> r0 = r8.zzq
            java.lang.Object r0 = r0.zzb(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x014c
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r8.zzr
            com.google.android.gms.internal.measurement.zzho r9 = r0.zza((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x014c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v44, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x03c1, code lost:
        if (r0 == r15) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0404, code lost:
        if (r0 == r15) goto L_0x0428;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x014d, code lost:
        r10.putInt(r14, r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01ac, code lost:
        r5 = r6 | r22;
        r6 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01b0, code lost:
        r3 = r8;
        r1 = r9;
        r2 = r11;
        r9 = r13;
        r11 = r32;
        r13 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0213, code lost:
        r10.putObject(r14, r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0261, code lost:
        r5 = r6 | r22;
        r6 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0265, code lost:
        r3 = r8;
        r1 = r9;
        r9 = r13;
        r13 = r2;
        r2 = r11;
        r11 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0313, code lost:
        r5 = r6 | r22;
        r6 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0317, code lost:
        r3 = r8;
        r1 = r9;
        r2 = r11;
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x031d, code lost:
        r23 = r30;
        r2 = r3;
        r22 = r6;
        r7 = r8;
        r30 = r9;
        r26 = r10;
        r17 = r11;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.measurement.zzgl r33) {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r33
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            if (r0 >= r13) goto L_0x04c3
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.measurement.zzgl) r9)
            int r3 = r9.zza
            r4 = r3
            r3 = r0
            goto L_0x002b
        L_0x002a:
            r4 = r0
        L_0x002b:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r1) goto L_0x0038
            int r2 = r2 / r8
            int r1 = r15.zza((int) r0, (int) r2)
            goto L_0x003c
        L_0x0038:
            int r1 = r15.zzg(r0)
        L_0x003c:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x0051
            r30 = r0
            r2 = r3
            r7 = r4
            r22 = r5
            r23 = r6
            r26 = r10
            r6 = r11
            r17 = 0
            r18 = -1
            goto L_0x042a
        L_0x0051:
            int[] r1 = r15.zzc
            int r19 = r2 + 1
            r8 = r1[r19]
            r19 = 267386880(0xff00000, float:2.3665827E-29)
            r19 = r8 & r19
            int r11 = r19 >>> 20
            r19 = r4
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r8 & r17
            long r12 = (long) r4
            r4 = 17
            r20 = r8
            if (r11 > r4) goto L_0x032b
            int r4 = r2 + 2
            r1 = r1[r4]
            int r4 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r4
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r4
            if (r1 == r6) goto L_0x0087
            if (r6 == r4) goto L_0x0080
            long r8 = (long) r6
            r10.putInt(r14, r8, r5)
        L_0x0080:
            long r5 = (long) r1
            int r5 = r10.getInt(r14, r5)
            r8 = r1
            goto L_0x0088
        L_0x0087:
            r8 = r6
        L_0x0088:
            r6 = r5
            r1 = 5
            switch(r11) {
                case 0: goto L_0x02f7;
                case 1: goto L_0x02db;
                case 2: goto L_0x02b2;
                case 3: goto L_0x02b2;
                case 4: goto L_0x0295;
                case 5: goto L_0x026e;
                case 6: goto L_0x0244;
                case 7: goto L_0x0217;
                case 8: goto L_0x01ed;
                case 9: goto L_0x01ba;
                case 10: goto L_0x0190;
                case 11: goto L_0x0295;
                case 12: goto L_0x0152;
                case 13: goto L_0x0244;
                case 14: goto L_0x026e;
                case 15: goto L_0x0131;
                case 16: goto L_0x00f8;
                case 17: goto L_0x009e;
                default: goto L_0x008d;
            }
        L_0x008d:
            r9 = r0
            r11 = r2
            r30 = r8
            r8 = r19
            r12 = r29
            r13 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x031d
        L_0x009e:
            r5 = 3
            if (r7 != r5) goto L_0x00e6
            int r1 = r0 << 3
            r5 = r1 | 4
            com.google.android.gms.internal.measurement.zzjv r1 = r15.zza((int) r2)
            r9 = r0
            r0 = r1
            r18 = -1
            r1 = r29
            r11 = r2
            r2 = r3
            r3 = r31
            r7 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r5
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.measurement.zzgl) r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00c8
            r4 = r33
            java.lang.Object r1 = r4.zzc
            goto L_0x00d4
        L_0x00c8:
            r4 = r33
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r4.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r1, (java.lang.Object) r2)
        L_0x00d4:
            r10.putObject(r14, r12, r1)
            r5 = r6 | r22
            r3 = r7
            r6 = r8
            r1 = r9
            r2 = r11
            r11 = r32
            r12 = r29
            r13 = r31
            r9 = r4
            goto L_0x0019
        L_0x00e6:
            r9 = r0
            r11 = r2
            r7 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r8
            r12 = r29
            r13 = r33
            r8 = r7
            goto L_0x031d
        L_0x00f8:
            r9 = r0
            r11 = r2
            r5 = r19
            r4 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x0129
            r1 = r12
            r12 = r29
            int r7 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r3, r4)
            r20 = r1
            long r0 = r4.zzb
            long r23 = com.google.android.gms.internal.measurement.zzgy.zza((long) r0)
            r0 = r10
            r2 = r20
            r1 = r28
            r13 = r4
            r30 = r8
            r8 = r5
            r4 = r23
            r0.putLong(r1, r2, r4)
            r5 = r6 | r22
            r6 = r30
            r0 = r7
            goto L_0x01b0
        L_0x0129:
            r13 = r4
            r30 = r8
            r12 = r29
            r8 = r5
            goto L_0x031d
        L_0x0131:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r12 = r29
            r13 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x031d
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r3, r13)
            int r1 = r13.zza
            int r1 = com.google.android.gms.internal.measurement.zzgy.zze(r1)
        L_0x014d:
            r10.putInt(r14, r4, r1)
            goto L_0x01ac
        L_0x0152:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r12 = r29
            r13 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x031d
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r3, r13)
            int r1 = r13.zza
            com.google.android.gms.internal.measurement.zzic r2 = r15.zzc((int) r11)
            if (r2 == 0) goto L_0x014d
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x0177
            goto L_0x014d
        L_0x0177:
            com.google.android.gms.internal.measurement.zzkq r2 = zze((java.lang.Object) r28)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zza((int) r8, (java.lang.Object) r1)
            r5 = r6
            r3 = r8
            r1 = r9
            r2 = r11
            r9 = r13
            r11 = r32
            r13 = r31
            r6 = r30
            goto L_0x0019
        L_0x0190:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r12 = r29
            r13 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x031d
            int r0 = com.google.android.gms.internal.measurement.zzgi.zze(r12, r3, r13)
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r4, r1)
        L_0x01ac:
            r5 = r6 | r22
            r6 = r30
        L_0x01b0:
            r3 = r8
            r1 = r9
            r2 = r11
            r9 = r13
            r11 = r32
            r13 = r31
            goto L_0x0019
        L_0x01ba:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r12 = r29
            r13 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x01e9
            com.google.android.gms.internal.measurement.zzjv r0 = r15.zza((int) r11)
            r2 = r31
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r0, (byte[]) r12, (int) r3, (int) r2, (com.google.android.gms.internal.measurement.zzgl) r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x01de
            java.lang.Object r1 = r13.zzc
            goto L_0x0213
        L_0x01de:
            java.lang.Object r1 = r10.getObject(r14, r4)
            java.lang.Object r3 = r13.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r1, (java.lang.Object) r3)
            goto L_0x0213
        L_0x01e9:
            r2 = r31
            goto L_0x031d
        L_0x01ed:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r2 = r31
            r12 = r29
            r13 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x031d
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x020d
            int r0 = com.google.android.gms.internal.measurement.zzgi.zzc(r12, r3, r13)
            goto L_0x0211
        L_0x020d:
            int r0 = com.google.android.gms.internal.measurement.zzgi.zzd(r12, r3, r13)
        L_0x0211:
            java.lang.Object r1 = r13.zzc
        L_0x0213:
            r10.putObject(r14, r4, r1)
            goto L_0x0261
        L_0x0217:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r2 = r31
            r12 = r29
            r13 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x031d
            int r0 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r3, r13)
            r3 = r0
            long r0 = r13.zzb
            r20 = 0
            int r7 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r7 == 0) goto L_0x023a
            r0 = 1
            goto L_0x023b
        L_0x023a:
            r0 = 0
        L_0x023b:
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r4, (boolean) r0)
            r5 = r6 | r22
            r6 = r30
            r0 = r3
            goto L_0x0265
        L_0x0244:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r2 = r31
            r12 = r29
            r13 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r1) goto L_0x031d
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r3)
            r10.putInt(r14, r4, r0)
            int r0 = r3 + 4
        L_0x0261:
            r5 = r6 | r22
            r6 = r30
        L_0x0265:
            r3 = r8
            r1 = r9
            r9 = r13
            r13 = r2
            r2 = r11
            r11 = r32
            goto L_0x0019
        L_0x026e:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 1
            r2 = r31
            r12 = r29
            r13 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x031d
            long r20 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r3)
            r0 = r10
            r1 = r28
            r7 = r3
            r2 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x0313
        L_0x0295:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r12 = r29
            r13 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x031d
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r3, r13)
            int r1 = r13.zza
            r10.putInt(r14, r4, r1)
            goto L_0x0313
        L_0x02b2:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r12 = r29
            r13 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x031d
            int r7 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r3, r13)
            long r2 = r13.zzb
            r0 = r10
            r1 = r28
            r20 = r2
            r2 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
            r5 = r6 | r22
            r6 = r30
            r0 = r7
            goto L_0x0317
        L_0x02db:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r12 = r29
            r13 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r1) goto L_0x031d
            float r0 = com.google.android.gms.internal.measurement.zzgi.zzd(r12, r3)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r4, (float) r0)
            int r0 = r3 + 4
            goto L_0x0313
        L_0x02f7:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 1
            r12 = r29
            r13 = r33
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x031d
            double r0 = com.google.android.gms.internal.measurement.zzgi.zzc(r12, r3)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r4, (double) r0)
            int r0 = r3 + 8
        L_0x0313:
            r5 = r6 | r22
            r6 = r30
        L_0x0317:
            r3 = r8
            r1 = r9
            r2 = r11
            r9 = r13
            goto L_0x037d
        L_0x031d:
            r23 = r30
            r2 = r3
            r22 = r6
            r7 = r8
            r30 = r9
            r26 = r10
            r17 = r11
            goto L_0x040a
        L_0x032b:
            r4 = r2
            r1 = r12
            r8 = r19
            r12 = r29
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r9
            r9 = r0
            r0 = 27
            if (r11 != r0) goto L_0x0392
            r0 = 2
            if (r7 != r0) goto L_0x0383
            java.lang.Object r0 = r10.getObject(r14, r1)
            com.google.android.gms.internal.measurement.zzid r0 = (com.google.android.gms.internal.measurement.zzid) r0
            boolean r7 = r0.zza()
            if (r7 != 0) goto L_0x035d
            int r7 = r0.size()
            if (r7 != 0) goto L_0x0354
            r7 = 10
            goto L_0x0356
        L_0x0354:
            int r7 = r7 << 1
        L_0x0356:
            com.google.android.gms.internal.measurement.zzid r0 = r0.zza(r7)
            r10.putObject(r14, r1, r0)
        L_0x035d:
            r7 = r0
            com.google.android.gms.internal.measurement.zzjv r0 = r15.zza((int) r4)
            r1 = r8
            r2 = r29
            r17 = r4
            r4 = r31
            r22 = r5
            r5 = r7
            r23 = r6
            r6 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r0, r1, r2, r3, r4, r5, r6)
            r3 = r8
            r1 = r9
            r9 = r13
            r2 = r17
            r5 = r22
            r6 = r23
        L_0x037d:
            r11 = r32
            r13 = r31
            goto L_0x0019
        L_0x0383:
            r17 = r4
            r22 = r5
            r23 = r6
            r15 = r3
            r19 = r8
            r30 = r9
            r26 = r10
            goto L_0x0407
        L_0x0392:
            r17 = r4
            r22 = r5
            r23 = r6
            r0 = 49
            if (r11 > r0) goto L_0x03df
            r6 = r20
            long r5 = (long) r6
            r0 = r27
            r24 = r1
            r1 = r28
            r2 = r29
            r4 = r3
            r15 = r4
            r4 = r31
            r20 = r5
            r5 = r8
            r6 = r9
            r19 = r8
            r8 = r17
            r30 = r9
            r26 = r10
            r9 = r20
            r12 = r24
            r14 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.measurement.zzgl) r14)
            if (r0 != r15) goto L_0x03c5
            goto L_0x0428
        L_0x03c5:
            r12 = r29
            r1 = r30
            r2 = r17
            r3 = r19
        L_0x03cd:
            r5 = r22
            r6 = r23
            r10 = r26
            r9 = r33
            r11 = r32
            r13 = r31
            r14 = r28
            r15 = r27
            goto L_0x0019
        L_0x03df:
            r24 = r1
            r15 = r3
            r19 = r8
            r30 = r9
            r26 = r10
            r6 = r20
            r0 = 50
            if (r11 != r0) goto L_0x040d
            r0 = 2
            if (r7 != r0) goto L_0x0407
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r17
            r6 = r24
            r8 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.measurement.zzgl) r8)
            if (r0 != r15) goto L_0x03c5
            goto L_0x0428
        L_0x0407:
            r2 = r15
        L_0x0408:
            r7 = r19
        L_0x040a:
            r6 = r32
            goto L_0x042a
        L_0x040d:
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r8 = r6
            r6 = r30
            r9 = r11
            r10 = r24
            r12 = r17
            r13 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.measurement.zzgl) r13)
            if (r0 != r15) goto L_0x04b7
        L_0x0428:
            r2 = r0
            goto L_0x0408
        L_0x042a:
            if (r7 != r6) goto L_0x043d
            if (r6 != 0) goto L_0x042f
            goto L_0x043d
        L_0x042f:
            r3 = r7
            r1 = r22
            r0 = r23
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r27
            r11 = r28
            goto L_0x04d4
        L_0x043d:
            r8 = r27
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x048f
            r9 = r33
            com.google.android.gms.internal.measurement.zzhi r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzhi r1 = com.google.android.gms.internal.measurement.zzhi.zza()
            if (r0 == r1) goto L_0x048c
            com.google.android.gms.internal.measurement.zzjg r0 = r8.zzg
            com.google.android.gms.internal.measurement.zzhi r1 = r9.zzd
            r10 = r30
            com.google.android.gms.internal.measurement.zzhv$zzf r0 = r1.zza(r0, r10)
            if (r0 != 0) goto L_0x047c
            com.google.android.gms.internal.measurement.zzkq r4 = zze((java.lang.Object) r28)
            r0 = r7
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzkq) r4, (com.google.android.gms.internal.measurement.zzgl) r5)
            r12 = r29
            r11 = r6
            r3 = r7
            r15 = r8
            r1 = r10
            r2 = r17
            r5 = r22
            r6 = r23
            r10 = r26
            r13 = r31
            r14 = r28
            goto L_0x0019
        L_0x047c:
            r11 = r28
            r0 = r11
            com.google.android.gms.internal.measurement.zzhv$zzd r0 = (com.google.android.gms.internal.measurement.zzhv.zzd) r0
            r0.zza()
            com.google.android.gms.internal.measurement.zzho<com.google.android.gms.internal.measurement.zzhv$zzc> r0 = r0.zzc
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x048c:
            r10 = r30
            goto L_0x0493
        L_0x048f:
            r10 = r30
            r9 = r33
        L_0x0493:
            r11 = r28
            com.google.android.gms.internal.measurement.zzkq r4 = zze((java.lang.Object) r28)
            r0 = r7
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzkq) r4, (com.google.android.gms.internal.measurement.zzgl) r5)
            r12 = r29
            r3 = r7
            r15 = r8
            r1 = r10
            r14 = r11
            r2 = r17
            r5 = r22
            r10 = r26
            r13 = r31
            r11 = r6
            r6 = r23
            goto L_0x0019
        L_0x04b7:
            r10 = r30
            r7 = r19
            r12 = r29
            r3 = r7
            r1 = r10
            r2 = r17
            goto L_0x03cd
        L_0x04c3:
            r22 = r5
            r23 = r6
            r26 = r10
            r6 = r11
            r11 = r14
            r8 = r15
            r2 = r0
            r1 = r22
            r0 = r23
            r4 = 1048575(0xfffff, float:1.469367E-39)
        L_0x04d4:
            if (r0 == r4) goto L_0x04dc
            long r4 = (long) r0
            r0 = r26
            r0.putInt(r11, r4, r1)
        L_0x04dc:
            r0 = 0
            int r1 = r8.zzm
        L_0x04df:
            int r4 = r8.zzn
            if (r1 >= r4) goto L_0x04f2
            int[] r4 = r8.zzl
            r4 = r4[r1]
            com.google.android.gms.internal.measurement.zzkn<?, ?> r5 = r8.zzq
            java.lang.Object r0 = r8.zza((java.lang.Object) r11, (int) r4, r0, r5)
            com.google.android.gms.internal.measurement.zzkq r0 = (com.google.android.gms.internal.measurement.zzkq) r0
            int r1 = r1 + 1
            goto L_0x04df
        L_0x04f2:
            if (r0 == 0) goto L_0x04f9
            com.google.android.gms.internal.measurement.zzkn<?, ?> r1 = r8.zzq
            r1.zzb((java.lang.Object) r11, r0)
        L_0x04f9:
            if (r6 != 0) goto L_0x0505
            r0 = r31
            if (r2 != r0) goto L_0x0500
            goto L_0x050b
        L_0x0500:
            com.google.android.gms.internal.measurement.zzig r0 = com.google.android.gms.internal.measurement.zzig.zzg()
            throw r0
        L_0x0505:
            r0 = r31
            if (r2 > r0) goto L_0x050c
            if (r3 != r6) goto L_0x050c
        L_0x050b:
            return r2
        L_0x050c:
            com.google.android.gms.internal.measurement.zzig r0 = com.google.android.gms.internal.measurement.zzig.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzgl):int");
    }

    public final T zza() {
        return this.zzo.zza(this.zzg);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:162|163|(1:165)|166|(5:185|168|(2:171|169)|220|(2:173|228)(1:229))(1:216)) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02c9, code lost:
        r14.zzb(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02d7, code lost:
        r14.zza(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03d7, code lost:
        com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x03ea, code lost:
        zzb(r13, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:?, code lost:
        r7.zza(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x04f8, code lost:
        if (r10 == null) goto L_0x04fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x04fa, code lost:
        r10 = r7.zzc(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0503, code lost:
        if (r7.zza(r10, r14) == false) goto L_0x0505;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0505, code lost:
        r14 = r12.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0509, code lost:
        if (r14 < r12.zzn) goto L_0x050b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x050b, code lost:
        r10 = zza((java.lang.Object) r13, r12.zzl[r14], r10, r7);
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x0516, code lost:
        if (r10 != null) goto L_0x0518;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0518, code lost:
        r7.zzb((java.lang.Object) r13, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009b, code lost:
        zzb(r13, r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e9, code lost:
        r10 = com.google.android.gms.internal.measurement.zzjx.zza(r1, r4, r10, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x021a, code lost:
        r14.zzq(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0228, code lost:
        r14.zzp(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0236, code lost:
        r14.zzo(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0244, code lost:
        r14.zzn(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0258, code lost:
        r10 = com.google.android.gms.internal.measurement.zzjx.zza(r1, r3, r2, r10, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0267, code lost:
        r14.zzl(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0275, code lost:
        r14.zzh(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0283, code lost:
        r14.zzg(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0291, code lost:
        r14.zzf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x029f, code lost:
        r14.zze(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02ad, code lost:
        r14.zzc(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02bb, code lost:
        r14.zzd(r1);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:162:0x04f5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r13, com.google.android.gms.internal.measurement.zzjw r14, com.google.android.gms.internal.measurement.zzhi r15) {
        /*
            r12 = this;
            if (r15 == 0) goto L_0x0534
            com.google.android.gms.internal.measurement.zzkn<?, ?> r7 = r12.zzq
            com.google.android.gms.internal.measurement.zzhk<?> r8 = r12.zzr
            r9 = 0
            r0 = r9
            r10 = r0
        L_0x0009:
            int r1 = r14.zza()     // Catch:{ all -> 0x051c }
            int r2 = r12.zzg(r1)     // Catch:{ all -> 0x051c }
            if (r2 >= 0) goto L_0x0077
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x002f
            int r14 = r12.zzm
        L_0x001a:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x002e
            r7.zzb((java.lang.Object) r13, r10)
        L_0x002e:
            return
        L_0x002f:
            boolean r2 = r12.zzh     // Catch:{ all -> 0x051c }
            if (r2 != 0) goto L_0x0035
            r2 = r9
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.measurement.zzjg r2 = r12.zzg     // Catch:{ all -> 0x051c }
            java.lang.Object r1 = r8.zza(r15, r2, r1)     // Catch:{ all -> 0x051c }
            r2 = r1
        L_0x003c:
            if (r2 == 0) goto L_0x0051
            if (r0 != 0) goto L_0x0044
            com.google.android.gms.internal.measurement.zzho r0 = r8.zzb(r13)     // Catch:{ all -> 0x051c }
        L_0x0044:
            r11 = r0
            r0 = r8
            r1 = r14
            r3 = r15
            r4 = r11
            r5 = r10
            r6 = r7
            java.lang.Object r10 = r0.zza(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x051c }
            r0 = r11
            goto L_0x0009
        L_0x0051:
            r7.zza((com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ all -> 0x051c }
            if (r10 != 0) goto L_0x005a
            java.lang.Object r10 = r7.zzc(r13)     // Catch:{ all -> 0x051c }
        L_0x005a:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ all -> 0x051c }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x0062:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0071
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0062
        L_0x0071:
            if (r10 == 0) goto L_0x0076
            r7.zzb((java.lang.Object) r13, r10)
        L_0x0076:
            return
        L_0x0077:
            int r3 = r12.zzd((int) r2)     // Catch:{ all -> 0x051c }
            r4 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r3
            int r4 = r4 >>> 20
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x04cc;
                case 1: goto L_0x04c0;
                case 2: goto L_0x04b4;
                case 3: goto L_0x04a8;
                case 4: goto L_0x049c;
                case 5: goto L_0x0490;
                case 6: goto L_0x0484;
                case 7: goto L_0x0478;
                case 8: goto L_0x0473;
                case 9: goto L_0x0448;
                case 10: goto L_0x043d;
                case 11: goto L_0x0432;
                case 12: goto L_0x041b;
                case 13: goto L_0x0410;
                case 14: goto L_0x0405;
                case 15: goto L_0x03fa;
                case 16: goto L_0x03ef;
                case 17: goto L_0x03be;
                case 18: goto L_0x03b3;
                case 19: goto L_0x03a8;
                case 20: goto L_0x039d;
                case 21: goto L_0x0392;
                case 22: goto L_0x0387;
                case 23: goto L_0x037c;
                case 24: goto L_0x0371;
                case 25: goto L_0x0366;
                case 26: goto L_0x0344;
                case 27: goto L_0x0332;
                case 28: goto L_0x0324;
                case 29: goto L_0x0319;
                case 30: goto L_0x0308;
                case 31: goto L_0x02fd;
                case 32: goto L_0x02f2;
                case 33: goto L_0x02e7;
                case 34: goto L_0x02dc;
                case 35: goto L_0x02ce;
                case 36: goto L_0x02c0;
                case 37: goto L_0x02b2;
                case 38: goto L_0x02a4;
                case 39: goto L_0x0296;
                case 40: goto L_0x0288;
                case 41: goto L_0x027a;
                case 42: goto L_0x026c;
                case 43: goto L_0x025e;
                case 44: goto L_0x0249;
                case 45: goto L_0x023b;
                case 46: goto L_0x022d;
                case 47: goto L_0x021f;
                case 48: goto L_0x0211;
                case 49: goto L_0x01ff;
                case 50: goto L_0x01bd;
                case 51: goto L_0x01ae;
                case 52: goto L_0x019f;
                case 53: goto L_0x0190;
                case 54: goto L_0x0181;
                case 55: goto L_0x0172;
                case 56: goto L_0x0163;
                case 57: goto L_0x0154;
                case 58: goto L_0x0145;
                case 59: goto L_0x0140;
                case 60: goto L_0x0111;
                case 61: goto L_0x0107;
                case 62: goto L_0x00f9;
                case 63: goto L_0x00d8;
                case 64: goto L_0x00ca;
                case 65: goto L_0x00bc;
                case 66: goto L_0x00ae;
                case 67: goto L_0x00a0;
                case 68: goto L_0x008e;
                default: goto L_0x0086;
            }
        L_0x0086:
            if (r10 != 0) goto L_0x04d8
            java.lang.Object r10 = r7.zza()     // Catch:{ zzif -> 0x04f5 }
            goto L_0x04d8
        L_0x008e:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzjv r5 = r12.zza((int) r2)     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r5 = r14.zzb(r5, r15)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
        L_0x009b:
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x00a0:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            long r5 = r14.zzt()     // Catch:{ zzif -> 0x04f5 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x00ae:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            int r5 = r14.zzs()     // Catch:{ zzif -> 0x04f5 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x00bc:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            long r5 = r14.zzr()     // Catch:{ zzif -> 0x04f5 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x00ca:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            int r5 = r14.zzq()     // Catch:{ zzif -> 0x04f5 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x00d8:
            int r4 = r14.zzp()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzic r6 = r12.zzc((int) r2)     // Catch:{ zzif -> 0x04f5 }
            if (r6 == 0) goto L_0x00ef
            boolean r6 = r6.zza(r4)     // Catch:{ zzif -> 0x04f5 }
            if (r6 == 0) goto L_0x00e9
            goto L_0x00ef
        L_0x00e9:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzjx.zza((int) r1, (int) r4, r10, r7)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x00ef:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r5, (java.lang.Object) r3)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x00f9:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            int r5 = r14.zzo()     // Catch:{ zzif -> 0x04f5 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x0107:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzgm r5 = r14.zzn()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x0111:
            boolean r4 = r12.zza(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x04f5 }
            if (r4 == 0) goto L_0x012e
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r13, r3)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzjv r6 = r12.zza((int) r2)     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r6 = r14.zza(r6, r15)     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x012e:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzjv r5 = r12.zza((int) r2)     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r5 = r14.zza(r5, r15)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x0140:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x0145:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            boolean r5 = r14.zzk()     // Catch:{ zzif -> 0x04f5 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x0154:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            int r5 = r14.zzj()     // Catch:{ zzif -> 0x04f5 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x0163:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            long r5 = r14.zzi()     // Catch:{ zzif -> 0x04f5 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x0172:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            int r5 = r14.zzh()     // Catch:{ zzif -> 0x04f5 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x0181:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            long r5 = r14.zzf()     // Catch:{ zzif -> 0x04f5 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x0190:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            long r5 = r14.zzg()     // Catch:{ zzif -> 0x04f5 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x019f:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            float r5 = r14.zze()     // Catch:{ zzif -> 0x04f5 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x01ae:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            double r5 = r14.zzd()     // Catch:{ zzif -> 0x04f5 }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x009b
        L_0x01bd:
            java.lang.Object r1 = r12.zzb((int) r2)     // Catch:{ zzif -> 0x04f5 }
            int r2 = r12.zzd((int) r2)     // Catch:{ zzif -> 0x04f5 }
            r2 = r2 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            if (r4 != 0) goto L_0x01d7
            com.google.android.gms.internal.measurement.zziz r4 = r12.zzs     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r4 = r4.zze(r1)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r4)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x01ee
        L_0x01d7:
            com.google.android.gms.internal.measurement.zziz r5 = r12.zzs     // Catch:{ zzif -> 0x04f5 }
            boolean r5 = r5.zzc(r4)     // Catch:{ zzif -> 0x04f5 }
            if (r5 == 0) goto L_0x01ee
            com.google.android.gms.internal.measurement.zziz r5 = r12.zzs     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r5 = r5.zze(r1)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zziz r6 = r12.zzs     // Catch:{ zzif -> 0x04f5 }
            r6.zza(r5, r4)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r5)     // Catch:{ zzif -> 0x04f5 }
            r4 = r5
        L_0x01ee:
            com.google.android.gms.internal.measurement.zziz r2 = r12.zzs     // Catch:{ zzif -> 0x04f5 }
            java.util.Map r2 = r2.zza(r4)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zziz r3 = r12.zzs     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzix r1 = r3.zzf(r1)     // Catch:{ zzif -> 0x04f5 }
            r14.zza(r2, r1, (com.google.android.gms.internal.measurement.zzhi) r15)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x01ff:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzjv r1 = r12.zza((int) r2)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zziq r2 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzif -> 0x04f5 }
            r14.zzb(r2, r1, r15)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x0211:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x021a:
            r14.zzq(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x021f:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x0228:
            r14.zzp(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x022d:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x0236:
            r14.zzo(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x023b:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x0244:
            r14.zzn(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x0249:
            com.google.android.gms.internal.measurement.zziq r4 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzif -> 0x04f5 }
            r14.zzm(r3)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzic r2 = r12.zzc((int) r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x0258:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzjx.zza(r1, r3, r2, r10, r7)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x025e:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x0267:
            r14.zzl(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x026c:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x0275:
            r14.zzh(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x027a:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x0283:
            r14.zzg(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x0288:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x0291:
            r14.zzf(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x0296:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x029f:
            r14.zze(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x02a4:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x02ad:
            r14.zzc(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x02b2:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x02bb:
            r14.zzd(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x02c0:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x02c9:
            r14.zzb(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x02ce:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x02d7:
            r14.zza(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x02dc:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x021a
        L_0x02e7:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0228
        L_0x02f2:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0236
        L_0x02fd:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0244
        L_0x0308:
            com.google.android.gms.internal.measurement.zziq r4 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzif -> 0x04f5 }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzif -> 0x04f5 }
            r14.zzm(r3)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzic r2 = r12.zzc((int) r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0258
        L_0x0319:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0267
        L_0x0324:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            r14.zzk(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x0332:
            com.google.android.gms.internal.measurement.zzjv r1 = r12.zza((int) r2)     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zziq r4 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            java.util.List r2 = r4.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            r14.zza(r2, r1, (com.google.android.gms.internal.measurement.zzhi) r15)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x0344:
            boolean r1 = zzf(r3)     // Catch:{ zzif -> 0x04f5 }
            if (r1 == 0) goto L_0x0358
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            r14.zzj(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x0358:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            r14.zzi(r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x0366:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0275
        L_0x0371:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0283
        L_0x037c:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0291
        L_0x0387:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x029f
        L_0x0392:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x02ad
        L_0x039d:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x02bb
        L_0x03a8:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x02c9
        L_0x03b3:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x04f5 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x04f5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x02d7
        L_0x03be:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzif -> 0x04f5 }
            if (r1 == 0) goto L_0x03dc
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkt.zzf(r13, r3)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzjv r2 = r12.zza((int) r2)     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r2 = r14.zzb(r2, r15)     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ zzif -> 0x04f5 }
        L_0x03d7:
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x03dc:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzjv r1 = r12.zza((int) r2)     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r1 = r14.zzb(r1, r15)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzif -> 0x04f5 }
        L_0x03ea:
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x0009
        L_0x03ef:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            long r5 = r14.zzt()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x03fa:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            int r1 = r14.zzs()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x0405:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            long r5 = r14.zzr()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x0410:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            int r1 = r14.zzq()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x041b:
            int r4 = r14.zzp()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzic r6 = r12.zzc((int) r2)     // Catch:{ zzif -> 0x04f5 }
            if (r6 == 0) goto L_0x042b
            boolean r6 = r6.zza(r4)     // Catch:{ zzif -> 0x04f5 }
            if (r6 == 0) goto L_0x00e9
        L_0x042b:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r5, (int) r4)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x0432:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            int r1 = r14.zzo()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x043d:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzgm r1 = r14.zzn()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x0448:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzif -> 0x04f5 }
            if (r1 == 0) goto L_0x0463
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkt.zzf(r13, r3)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzjv r2 = r12.zza((int) r2)     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03d7
        L_0x0463:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzjv r1 = r12.zza((int) r2)     // Catch:{ zzif -> 0x04f5 }
            java.lang.Object r1 = r14.zza(r1, r15)     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x0473:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x0478:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            boolean r1 = r14.zzk()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (boolean) r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x0484:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            int r1 = r14.zzj()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x0490:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            long r5 = r14.zzi()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x049c:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            int r1 = r14.zzh()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x04a8:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            long r5 = r14.zzf()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x04b4:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            long r5 = r14.zzg()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x04c0:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            float r1 = r14.zze()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (float) r1)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x04cc:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x04f5 }
            double r5 = r14.zzd()     // Catch:{ zzif -> 0x04f5 }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (double) r5)     // Catch:{ zzif -> 0x04f5 }
            goto L_0x03ea
        L_0x04d8:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ zzif -> 0x04f5 }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x04e0:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x04ef
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x04e0
        L_0x04ef:
            if (r10 == 0) goto L_0x04f4
            r7.zzb((java.lang.Object) r13, r10)
        L_0x04f4:
            return
        L_0x04f5:
            r7.zza((com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ all -> 0x051c }
            if (r10 != 0) goto L_0x04ff
            java.lang.Object r1 = r7.zzc(r13)     // Catch:{ all -> 0x051c }
            r10 = r1
        L_0x04ff:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ all -> 0x051c }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x0507:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0516
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0507
        L_0x0516:
            if (r10 == 0) goto L_0x051b
            r7.zzb((java.lang.Object) r13, r10)
        L_0x051b:
            return
        L_0x051c:
            r14 = move-exception
            int r15 = r12.zzm
        L_0x051f:
            int r0 = r12.zzn
            if (r15 >= r0) goto L_0x052e
            int[] r0 = r12.zzl
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r0, r10, r7)
            int r15 = r15 + 1
            goto L_0x051f
        L_0x052e:
            if (r10 == 0) goto L_0x0533
            r7.zzb((java.lang.Object) r13, r10)
        L_0x0533:
            throw r14
        L_0x0534:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            r13.<init>()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzjw, com.google.android.gms.internal.measurement.zzhi):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0387, code lost:
        r15.zzb(r9, com.google.android.gms.internal.measurement.zzkt.zzf(r14, (long) (r8 & 1048575)), zza(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x03a2, code lost:
        r15.zze(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03b3, code lost:
        r15.zzf(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x03c4, code lost:
        r15.zzb(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03d5, code lost:
        r15.zza(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x03e6, code lost:
        r15.zzb(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x03f7, code lost:
        r15.zze(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0402, code lost:
        r15.zza(r9, (com.google.android.gms.internal.measurement.zzgm) com.google.android.gms.internal.measurement.zzkt.zzf(r14, (long) (r8 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0415, code lost:
        r15.zza(r9, com.google.android.gms.internal.measurement.zzkt.zzf(r14, (long) (r8 & 1048575)), zza(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x042a, code lost:
        zza(r9, com.google.android.gms.internal.measurement.zzkt.zzf(r14, (long) (r8 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0441, code lost:
        r15.zza(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0452, code lost:
        r15.zzd(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0462, code lost:
        r15.zzd(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0472, code lost:
        r15.zzc(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0482, code lost:
        r15.zzc(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0492, code lost:
        r15.zza(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x04a2, code lost:
        r15.zza(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x04b2, code lost:
        r15.zza(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0847, code lost:
        r15.zzb(r10, com.google.android.gms.internal.measurement.zzkt.zzf(r14, (long) (r9 & 1048575)), zza(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0862, code lost:
        r15.zze(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x0873, code lost:
        r15.zzf(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0884, code lost:
        r15.zzb(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0895, code lost:
        r15.zza(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x08a6, code lost:
        r15.zzb(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x08b7, code lost:
        r15.zze(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x08c2, code lost:
        r15.zza(r10, (com.google.android.gms.internal.measurement.zzgm) com.google.android.gms.internal.measurement.zzkt.zzf(r14, (long) (r9 & 1048575)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x08d5, code lost:
        r15.zza(r10, com.google.android.gms.internal.measurement.zzkt.zzf(r14, (long) (r9 & 1048575)), zza(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x08ea, code lost:
        zza(r10, com.google.android.gms.internal.measurement.zzkt.zzf(r14, (long) (r9 & 1048575)), r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x0901, code lost:
        r15.zza(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x0912, code lost:
        r15.zzd(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x0922, code lost:
        r15.zzd(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:332:0x0932, code lost:
        r15.zzc(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x0942, code lost:
        r15.zzc(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x0952, code lost:
        r15.zza(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x0962, code lost:
        r15.zza(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x0972, code lost:
        r15.zza(r10, r11);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04bb  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04fb  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x097b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.measurement.zzlk r15) {
        /*
            r13 = this;
            int r0 = r15.zza()
            int r1 = com.google.android.gms.internal.measurement.zzhv.zze.zzk
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x04d1
            com.google.android.gms.internal.measurement.zzkn<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.measurement.zzlk) r15)
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzho r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.measurement.zzka<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.zze()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zzc
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x04b9
            int r8 = r13.zzd((int) r7)
            int[] r9 = r13.zzc
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.measurement.zzhk<?> r10 = r13.zzr
            int r10 = r10.zza((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.measurement.zzhk<?> r10 = r13.zzr
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04a6;
                case 1: goto L_0x0496;
                case 2: goto L_0x0486;
                case 3: goto L_0x0476;
                case 4: goto L_0x0466;
                case 5: goto L_0x0456;
                case 6: goto L_0x0446;
                case 7: goto L_0x0435;
                case 8: goto L_0x0424;
                case 9: goto L_0x040f;
                case 10: goto L_0x03fc;
                case 11: goto L_0x03eb;
                case 12: goto L_0x03da;
                case 13: goto L_0x03c9;
                case 14: goto L_0x03b8;
                case 15: goto L_0x03a7;
                case 16: goto L_0x0396;
                case 17: goto L_0x0381;
                case 18: goto L_0x0370;
                case 19: goto L_0x035f;
                case 20: goto L_0x034e;
                case 21: goto L_0x033d;
                case 22: goto L_0x032c;
                case 23: goto L_0x031b;
                case 24: goto L_0x030a;
                case 25: goto L_0x02f9;
                case 26: goto L_0x02e8;
                case 27: goto L_0x02d3;
                case 28: goto L_0x02c2;
                case 29: goto L_0x02b1;
                case 30: goto L_0x02a0;
                case 31: goto L_0x028f;
                case 32: goto L_0x027e;
                case 33: goto L_0x026d;
                case 34: goto L_0x025c;
                case 35: goto L_0x024b;
                case 36: goto L_0x023a;
                case 37: goto L_0x0229;
                case 38: goto L_0x0218;
                case 39: goto L_0x0207;
                case 40: goto L_0x01f6;
                case 41: goto L_0x01e5;
                case 42: goto L_0x01d4;
                case 43: goto L_0x01c3;
                case 44: goto L_0x01b2;
                case 45: goto L_0x01a1;
                case 46: goto L_0x0190;
                case 47: goto L_0x017f;
                case 48: goto L_0x016e;
                case 49: goto L_0x0159;
                case 50: goto L_0x014e;
                case 51: goto L_0x0140;
                case 52: goto L_0x0132;
                case 53: goto L_0x0124;
                case 54: goto L_0x0116;
                case 55: goto L_0x0108;
                case 56: goto L_0x00fa;
                case 57: goto L_0x00ec;
                case 58: goto L_0x00de;
                case 59: goto L_0x00d6;
                case 60: goto L_0x00ce;
                case 61: goto L_0x00c6;
                case 62: goto L_0x00b8;
                case 63: goto L_0x00aa;
                case 64: goto L_0x009c;
                case 65: goto L_0x008e;
                case 66: goto L_0x0080;
                case 67: goto L_0x0072;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x04b5
        L_0x006a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            goto L_0x0387
        L_0x0072:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            goto L_0x03a2
        L_0x0080:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            goto L_0x03b3
        L_0x008e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            goto L_0x03c4
        L_0x009c:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            goto L_0x03d5
        L_0x00aa:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            goto L_0x03e6
        L_0x00b8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            goto L_0x03f7
        L_0x00c6:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            goto L_0x0402
        L_0x00ce:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            goto L_0x0415
        L_0x00d6:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            goto L_0x042a
        L_0x00de:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzf(r14, r10)
            goto L_0x0441
        L_0x00ec:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            goto L_0x0452
        L_0x00fa:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            goto L_0x0462
        L_0x0108:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            goto L_0x0472
        L_0x0116:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            goto L_0x0482
        L_0x0124:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            goto L_0x0492
        L_0x0132:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzc(r14, r10)
            goto L_0x04a2
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzb(r14, (long) r10)
            goto L_0x04b2
        L_0x014e:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            r13.zza((com.google.android.gms.internal.measurement.zzlk) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x04b5
        L_0x0159:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjv r10 = r13.zza((int) r7)
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzlk) r15, (com.google.android.gms.internal.measurement.zzjv) r10)
            goto L_0x04b5
        L_0x016e:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zze(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x017f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzj(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0190:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzg(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01a1:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzl(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01b2:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzm(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01c3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzi(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01d4:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzn(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01e5:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzk(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x01f6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzf(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0207:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzh(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0218:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzd(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x0229:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzc(r9, r8, r15, r4)
            goto L_0x04b5
        L_0x023a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r4)
            goto L_0x04b5
        L_0x024b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r4)
            goto L_0x04b5
        L_0x025c:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zze(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x026d:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzj(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x027e:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzg(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x028f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzl(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x02a0:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzm(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x02b1:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzi(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x02c2:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r9, (java.util.List<com.google.android.gms.internal.measurement.zzgm>) r8, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x04b5
        L_0x02d3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjv r10 = r13.zza((int) r7)
            com.google.android.gms.internal.measurement.zzjx.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzlk) r15, (com.google.android.gms.internal.measurement.zzjv) r10)
            goto L_0x04b5
        L_0x02e8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x04b5
        L_0x02f9:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzn(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x030a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzk(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x031b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzf(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x032c:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzh(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x033d:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzd(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x034e:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzc(r9, r8, r15, r5)
            goto L_0x04b5
        L_0x035f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r5)
            goto L_0x04b5
        L_0x0370:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r5)
            goto L_0x04b5
        L_0x0381:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x0387:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzjv r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzjv) r10)
            goto L_0x04b5
        L_0x0396:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r10)
        L_0x03a2:
            r15.zze((int) r9, (long) r10)
            goto L_0x04b5
        L_0x03a7:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r10)
        L_0x03b3:
            r15.zzf(r9, r8)
            goto L_0x04b5
        L_0x03b8:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r10)
        L_0x03c4:
            r15.zzb((int) r9, (long) r10)
            goto L_0x04b5
        L_0x03c9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r10)
        L_0x03d5:
            r15.zza((int) r9, (int) r8)
            goto L_0x04b5
        L_0x03da:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r10)
        L_0x03e6:
            r15.zzb((int) r9, (int) r8)
            goto L_0x04b5
        L_0x03eb:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r10)
        L_0x03f7:
            r15.zze((int) r9, (int) r8)
            goto L_0x04b5
        L_0x03fc:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x0402:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzgm r8 = (com.google.android.gms.internal.measurement.zzgm) r8
            r15.zza((int) r9, (com.google.android.gms.internal.measurement.zzgm) r8)
            goto L_0x04b5
        L_0x040f:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x0415:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzjv r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzjv) r10)
            goto L_0x04b5
        L_0x0424:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
        L_0x042a:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x04b5
        L_0x0435:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.measurement.zzkt.zzc(r14, r10)
        L_0x0441:
            r15.zza((int) r9, (boolean) r8)
            goto L_0x04b5
        L_0x0446:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r10)
        L_0x0452:
            r15.zzd((int) r9, (int) r8)
            goto L_0x04b5
        L_0x0456:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r10)
        L_0x0462:
            r15.zzd((int) r9, (long) r10)
            goto L_0x04b5
        L_0x0466:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r10)
        L_0x0472:
            r15.zzc((int) r9, (int) r8)
            goto L_0x04b5
        L_0x0476:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r10)
        L_0x0482:
            r15.zzc((int) r9, (long) r10)
            goto L_0x04b5
        L_0x0486:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r10)
        L_0x0492:
            r15.zza((int) r9, (long) r10)
            goto L_0x04b5
        L_0x0496:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.measurement.zzkt.zzd(r14, r10)
        L_0x04a2:
            r15.zza((int) r9, (float) r8)
            goto L_0x04b5
        L_0x04a6:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x04b5
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.measurement.zzkt.zze(r14, r10)
        L_0x04b2:
            r15.zza((int) r9, (double) r10)
        L_0x04b5:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x04b9:
            if (r1 == 0) goto L_0x04d0
            com.google.android.gms.internal.measurement.zzhk<?> r14 = r13.zzr
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x04ce
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x04b9
        L_0x04ce:
            r1 = r3
            goto L_0x04b9
        L_0x04d0:
            return
        L_0x04d1:
            boolean r0 = r13.zzj
            if (r0 == 0) goto L_0x0996
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x04f2
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzho r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.measurement.zzka<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x04f2
            java.util.Iterator r0 = r0.zzd()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x04f4
        L_0x04f2:
            r0 = r3
            r1 = r0
        L_0x04f4:
            int[] r7 = r13.zzc
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x04f9:
            if (r1 >= r7) goto L_0x0979
            int r9 = r13.zzd((int) r1)
            int[] r10 = r13.zzc
            r10 = r10[r1]
        L_0x0503:
            if (r8 == 0) goto L_0x0521
            com.google.android.gms.internal.measurement.zzhk<?> r11 = r13.zzr
            int r11 = r11.zza((java.util.Map.Entry<?, ?>) r8)
            if (r11 > r10) goto L_0x0521
            com.google.android.gms.internal.measurement.zzhk<?> r11 = r13.zzr
            r11.zza(r15, r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x051f
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x0503
        L_0x051f:
            r8 = r3
            goto L_0x0503
        L_0x0521:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0966;
                case 1: goto L_0x0956;
                case 2: goto L_0x0946;
                case 3: goto L_0x0936;
                case 4: goto L_0x0926;
                case 5: goto L_0x0916;
                case 6: goto L_0x0906;
                case 7: goto L_0x08f5;
                case 8: goto L_0x08e4;
                case 9: goto L_0x08cf;
                case 10: goto L_0x08bc;
                case 11: goto L_0x08ab;
                case 12: goto L_0x089a;
                case 13: goto L_0x0889;
                case 14: goto L_0x0878;
                case 15: goto L_0x0867;
                case 16: goto L_0x0856;
                case 17: goto L_0x0841;
                case 18: goto L_0x0830;
                case 19: goto L_0x081f;
                case 20: goto L_0x080e;
                case 21: goto L_0x07fd;
                case 22: goto L_0x07ec;
                case 23: goto L_0x07db;
                case 24: goto L_0x07ca;
                case 25: goto L_0x07b9;
                case 26: goto L_0x07a8;
                case 27: goto L_0x0793;
                case 28: goto L_0x0782;
                case 29: goto L_0x0771;
                case 30: goto L_0x0760;
                case 31: goto L_0x074f;
                case 32: goto L_0x073e;
                case 33: goto L_0x072d;
                case 34: goto L_0x071c;
                case 35: goto L_0x070b;
                case 36: goto L_0x06fa;
                case 37: goto L_0x06e9;
                case 38: goto L_0x06d8;
                case 39: goto L_0x06c7;
                case 40: goto L_0x06b6;
                case 41: goto L_0x06a5;
                case 42: goto L_0x0694;
                case 43: goto L_0x0683;
                case 44: goto L_0x0672;
                case 45: goto L_0x0661;
                case 46: goto L_0x0650;
                case 47: goto L_0x063f;
                case 48: goto L_0x062e;
                case 49: goto L_0x0619;
                case 50: goto L_0x060e;
                case 51: goto L_0x0600;
                case 52: goto L_0x05f2;
                case 53: goto L_0x05e4;
                case 54: goto L_0x05d6;
                case 55: goto L_0x05c8;
                case 56: goto L_0x05ba;
                case 57: goto L_0x05ac;
                case 58: goto L_0x059e;
                case 59: goto L_0x0596;
                case 60: goto L_0x058e;
                case 61: goto L_0x0586;
                case 62: goto L_0x0578;
                case 63: goto L_0x056a;
                case 64: goto L_0x055c;
                case 65: goto L_0x054e;
                case 66: goto L_0x0540;
                case 67: goto L_0x0532;
                case 68: goto L_0x052a;
                default: goto L_0x0528;
            }
        L_0x0528:
            goto L_0x0975
        L_0x052a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            goto L_0x0847
        L_0x0532:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            goto L_0x0862
        L_0x0540:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            goto L_0x0873
        L_0x054e:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            goto L_0x0884
        L_0x055c:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            goto L_0x0895
        L_0x056a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            goto L_0x08a6
        L_0x0578:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            goto L_0x08b7
        L_0x0586:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            goto L_0x08c2
        L_0x058e:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            goto L_0x08d5
        L_0x0596:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            goto L_0x08ea
        L_0x059e:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzf(r14, r11)
            goto L_0x0901
        L_0x05ac:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            goto L_0x0912
        L_0x05ba:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            goto L_0x0922
        L_0x05c8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            goto L_0x0932
        L_0x05d6:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            goto L_0x0942
        L_0x05e4:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            goto L_0x0952
        L_0x05f2:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzc(r14, r11)
            goto L_0x0962
        L_0x0600:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzb(r14, (long) r11)
            goto L_0x0972
        L_0x060e:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            r13.zza((com.google.android.gms.internal.measurement.zzlk) r15, (int) r10, (java.lang.Object) r9, (int) r1)
            goto L_0x0975
        L_0x0619:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjv r11 = r13.zza((int) r1)
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzlk) r15, (com.google.android.gms.internal.measurement.zzjv) r11)
            goto L_0x0975
        L_0x062e:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zze(r10, r9, r15, r4)
            goto L_0x0975
        L_0x063f:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzj(r10, r9, r15, r4)
            goto L_0x0975
        L_0x0650:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzg(r10, r9, r15, r4)
            goto L_0x0975
        L_0x0661:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzl(r10, r9, r15, r4)
            goto L_0x0975
        L_0x0672:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzm(r10, r9, r15, r4)
            goto L_0x0975
        L_0x0683:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzi(r10, r9, r15, r4)
            goto L_0x0975
        L_0x0694:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzn(r10, r9, r15, r4)
            goto L_0x0975
        L_0x06a5:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzk(r10, r9, r15, r4)
            goto L_0x0975
        L_0x06b6:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzf(r10, r9, r15, r4)
            goto L_0x0975
        L_0x06c7:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzh(r10, r9, r15, r4)
            goto L_0x0975
        L_0x06d8:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzd(r10, r9, r15, r4)
            goto L_0x0975
        L_0x06e9:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzc(r10, r9, r15, r4)
            goto L_0x0975
        L_0x06fa:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r4)
            goto L_0x0975
        L_0x070b:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r4)
            goto L_0x0975
        L_0x071c:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zze(r10, r9, r15, r5)
            goto L_0x0975
        L_0x072d:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzj(r10, r9, r15, r5)
            goto L_0x0975
        L_0x073e:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzg(r10, r9, r15, r5)
            goto L_0x0975
        L_0x074f:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzl(r10, r9, r15, r5)
            goto L_0x0975
        L_0x0760:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzm(r10, r9, r15, r5)
            goto L_0x0975
        L_0x0771:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzi(r10, r9, r15, r5)
            goto L_0x0975
        L_0x0782:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r10, (java.util.List<com.google.android.gms.internal.measurement.zzgm>) r9, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x0975
        L_0x0793:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjv r11 = r13.zza((int) r1)
            com.google.android.gms.internal.measurement.zzjx.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzlk) r15, (com.google.android.gms.internal.measurement.zzjv) r11)
            goto L_0x0975
        L_0x07a8:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x0975
        L_0x07b9:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzn(r10, r9, r15, r5)
            goto L_0x0975
        L_0x07ca:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzk(r10, r9, r15, r5)
            goto L_0x0975
        L_0x07db:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzf(r10, r9, r15, r5)
            goto L_0x0975
        L_0x07ec:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzh(r10, r9, r15, r5)
            goto L_0x0975
        L_0x07fd:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzd(r10, r9, r15, r5)
            goto L_0x0975
        L_0x080e:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzc(r10, r9, r15, r5)
            goto L_0x0975
        L_0x081f:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r5)
            goto L_0x0975
        L_0x0830:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r5)
            goto L_0x0975
        L_0x0841:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
        L_0x0847:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzjv r11 = r13.zza((int) r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzjv) r11)
            goto L_0x0975
        L_0x0856:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r11)
        L_0x0862:
            r15.zze((int) r10, (long) r11)
            goto L_0x0975
        L_0x0867:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r11)
        L_0x0873:
            r15.zzf(r10, r9)
            goto L_0x0975
        L_0x0878:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r11)
        L_0x0884:
            r15.zzb((int) r10, (long) r11)
            goto L_0x0975
        L_0x0889:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r11)
        L_0x0895:
            r15.zza((int) r10, (int) r9)
            goto L_0x0975
        L_0x089a:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r11)
        L_0x08a6:
            r15.zzb((int) r10, (int) r9)
            goto L_0x0975
        L_0x08ab:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r11)
        L_0x08b7:
            r15.zze((int) r10, (int) r9)
            goto L_0x0975
        L_0x08bc:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
        L_0x08c2:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzgm r9 = (com.google.android.gms.internal.measurement.zzgm) r9
            r15.zza((int) r10, (com.google.android.gms.internal.measurement.zzgm) r9)
            goto L_0x0975
        L_0x08cf:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
        L_0x08d5:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzjv r11 = r13.zza((int) r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzjv) r11)
            goto L_0x0975
        L_0x08e4:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
        L_0x08ea:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x0975
        L_0x08f5:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.measurement.zzkt.zzc(r14, r11)
        L_0x0901:
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0975
        L_0x0906:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r11)
        L_0x0912:
            r15.zzd((int) r10, (int) r9)
            goto L_0x0975
        L_0x0916:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r11)
        L_0x0922:
            r15.zzd((int) r10, (long) r11)
            goto L_0x0975
        L_0x0926:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r11)
        L_0x0932:
            r15.zzc((int) r10, (int) r9)
            goto L_0x0975
        L_0x0936:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r11)
        L_0x0942:
            r15.zzc((int) r10, (long) r11)
            goto L_0x0975
        L_0x0946:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r11)
        L_0x0952:
            r15.zza((int) r10, (long) r11)
            goto L_0x0975
        L_0x0956:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.measurement.zzkt.zzd(r14, r11)
        L_0x0962:
            r15.zza((int) r10, (float) r9)
            goto L_0x0975
        L_0x0966:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0975
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.measurement.zzkt.zze(r14, r11)
        L_0x0972:
            r15.zza((int) r10, (double) r11)
        L_0x0975:
            int r1 = r1 + 3
            goto L_0x04f9
        L_0x0979:
            if (r8 == 0) goto L_0x0990
            com.google.android.gms.internal.measurement.zzhk<?> r1 = r13.zzr
            r1.zza(r15, r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x098e
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0979
        L_0x098e:
            r8 = r3
            goto L_0x0979
        L_0x0990:
            com.google.android.gms.internal.measurement.zzkn<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.measurement.zzlk) r15)
            return
        L_0x0996:
            r13.zzb(r14, (com.google.android.gms.internal.measurement.zzlk) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzlk):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02f0, code lost:
        if (r0 == r15) goto L_0x0358;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0333, code lost:
        if (r0 == r15) goto L_0x0358;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0356, code lost:
        if (r0 == r15) goto L_0x0358;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0358, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0123, code lost:
        r1 = r11.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0125, code lost:
        r10.putObject(r14, r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01cc, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01e2, code lost:
        r1 = r11.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01e4, code lost:
        r10.putInt(r14, r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x023f, code lost:
        r6 = r6 | r23;
        r2 = r7;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0245, code lost:
        r2 = r5;
        r29 = r10;
        r30 = r20;
        r20 = r7;
        r7 = r30;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r32, byte[] r33, int r34, int r35, com.google.android.gms.internal.measurement.zzgl r36) {
        /*
            r31 = this;
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            boolean r0 = r15.zzj
            if (r0 == 0) goto L_0x039d
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r34
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001e:
            if (r0 >= r13) goto L_0x0380
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0030
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.measurement.zzgl) r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x0033
        L_0x0030:
            r17 = r0
            r4 = r3
        L_0x0033:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x0040
            int r2 = r2 / 3
            int r0 = r15.zza((int) r5, (int) r2)
            goto L_0x0044
        L_0x0040:
            int r0 = r15.zzg(r5)
        L_0x0044:
            r2 = r0
            if (r2 != r10) goto L_0x0052
            r2 = r4
            r25 = r5
            r29 = r9
            r19 = -1
            r20 = 0
            goto L_0x035a
        L_0x0052:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r1 & r18
            int r10 = r18 >>> 20
            r34 = r5
            r5 = r1 & r8
            r18 = r9
            long r8 = (long) r5
            r5 = 17
            r21 = r1
            if (r10 > r5) goto L_0x0252
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r1 = 1
            int r23 = r1 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            if (r0 == r7) goto L_0x0094
            if (r7 == r5) goto L_0x0085
            r20 = r2
            long r1 = (long) r7
            r7 = r18
            r7.putInt(r14, r1, r6)
            goto L_0x0089
        L_0x0085:
            r20 = r2
            r7 = r18
        L_0x0089:
            if (r0 == r5) goto L_0x0091
            long r1 = (long) r0
            int r1 = r7.getInt(r14, r1)
            r6 = r1
        L_0x0091:
            r2 = r7
            r7 = r0
            goto L_0x0098
        L_0x0094:
            r20 = r2
            r2 = r18
        L_0x0098:
            r0 = 5
            switch(r10) {
                case 0: goto L_0x0226;
                case 1: goto L_0x020d;
                case 2: goto L_0x01e9;
                case 3: goto L_0x01e9;
                case 4: goto L_0x01cf;
                case 5: goto L_0x01ab;
                case 6: goto L_0x0192;
                case 7: goto L_0x0170;
                case 8: goto L_0x0151;
                case 9: goto L_0x012a;
                case 10: goto L_0x0110;
                case 11: goto L_0x01cf;
                case 12: goto L_0x00fc;
                case 13: goto L_0x0192;
                case 14: goto L_0x01ab;
                case 15: goto L_0x00e2;
                case 16: goto L_0x00ab;
                default: goto L_0x009c;
            }
        L_0x009c:
            r25 = r34
            r10 = r2
            r5 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            goto L_0x0245
        L_0x00ab:
            if (r3 != 0) goto L_0x00d4
            int r10 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r4, r11)
            long r0 = r11.zzb
            long r17 = com.google.android.gms.internal.measurement.zzgy.zza((long) r0)
            r0 = r2
            r1 = r32
            r4 = r2
            r30 = r20
            r20 = r7
            r7 = r30
            r2 = r8
            r25 = r34
            r8 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r17
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r2 = r7
            r9 = r8
            r0 = r10
            goto L_0x029c
        L_0x00d4:
            r25 = r34
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            r10 = r2
            goto L_0x01cc
        L_0x00e2:
            r25 = r34
            r10 = r2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x01cc
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzgy.zze(r1)
            goto L_0x01e4
        L_0x00fc:
            r25 = r34
            r10 = r2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x01cc
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r4, r11)
            goto L_0x01e2
        L_0x0110:
            r25 = r34
            r10 = r2
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01cc
            int r0 = com.google.android.gms.internal.measurement.zzgi.zze(r12, r4, r11)
        L_0x0123:
            java.lang.Object r1 = r11.zzc
        L_0x0125:
            r10.putObject(r14, r8, r1)
            goto L_0x023f
        L_0x012a:
            r25 = r34
            r10 = r2
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01cc
            com.google.android.gms.internal.measurement.zzjv r0 = r15.zza((int) r7)
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r0, (byte[]) r12, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzgl) r11)
            java.lang.Object r1 = r10.getObject(r14, r8)
            if (r1 != 0) goto L_0x014a
            java.lang.Object r1 = r11.zzc
            goto L_0x0125
        L_0x014a:
            java.lang.Object r2 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r1, (java.lang.Object) r2)
            goto L_0x0125
        L_0x0151:
            r25 = r34
            r10 = r2
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01cc
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r21 & r0
            if (r0 != 0) goto L_0x016b
            int r0 = com.google.android.gms.internal.measurement.zzgi.zzc(r12, r4, r11)
            goto L_0x0123
        L_0x016b:
            int r0 = com.google.android.gms.internal.measurement.zzgi.zzd(r12, r4, r11)
            goto L_0x0123
        L_0x0170:
            r25 = r34
            r10 = r2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x01cc
            int r0 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r4, r11)
            long r1 = r11.zzb
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x018c
            r1 = 1
            goto L_0x018d
        L_0x018c:
            r1 = 0
        L_0x018d:
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r8, (boolean) r1)
            goto L_0x023f
        L_0x0192:
            r25 = r34
            r10 = r2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01cc
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x023f
        L_0x01ab:
            r25 = r34
            r10 = r2
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01cc
            long r17 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r4)
            r0 = r10
            r1 = r32
            r2 = r8
            r8 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x023f
        L_0x01cc:
            r5 = r4
            goto L_0x0245
        L_0x01cf:
            r25 = r34
            r10 = r2
            r5 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x0245
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r5, r11)
        L_0x01e2:
            int r1 = r11.zza
        L_0x01e4:
            r10.putInt(r14, r8, r1)
            goto L_0x023f
        L_0x01e9:
            r25 = r34
            r10 = r2
            r5 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x0245
            int r17 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r5, r11)
            long r4 = r11.zzb
            r0 = r10
            r1 = r32
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r2 = r7
            r9 = r10
            r0 = r17
            goto L_0x029c
        L_0x020d:
            r25 = r34
            r10 = r2
            r5 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x0245
            float r0 = com.google.android.gms.internal.measurement.zzgi.zzd(r12, r5)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r8, (float) r0)
            int r0 = r5 + 4
            goto L_0x023f
        L_0x0226:
            r25 = r34
            r10 = r2
            r5 = r4
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x0245
            double r0 = com.google.android.gms.internal.measurement.zzgi.zzc(r12, r5)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r8, (double) r0)
            int r0 = r5 + 8
        L_0x023f:
            r6 = r6 | r23
            r2 = r7
            r9 = r10
            goto L_0x029c
        L_0x0245:
            r2 = r5
            r29 = r10
            r19 = -1
            r30 = r20
            r20 = r7
            r7 = r30
            goto L_0x035a
        L_0x0252:
            r25 = r34
            r5 = r4
            r20 = r7
            r4 = r18
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r2
            r0 = 27
            if (r10 != r0) goto L_0x02b3
            r0 = 2
            if (r3 != r0) goto L_0x02a6
            java.lang.Object r0 = r4.getObject(r14, r8)
            com.google.android.gms.internal.measurement.zzid r0 = (com.google.android.gms.internal.measurement.zzid) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x0282
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0279
            r1 = 10
            goto L_0x027b
        L_0x0279:
            int r1 = r1 << 1
        L_0x027b:
            com.google.android.gms.internal.measurement.zzid r0 = r0.zza(r1)
            r4.putObject(r14, r8, r0)
        L_0x0282:
            r8 = r0
            com.google.android.gms.internal.measurement.zzjv r0 = r15.zza((int) r7)
            r1 = r17
            r2 = r33
            r3 = r5
            r18 = r4
            r4 = r35
            r5 = r8
            r8 = r6
            r6 = r36
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r0, r1, r2, r3, r4, r5, r6)
            r2 = r7
            r6 = r8
            r9 = r18
        L_0x029c:
            r7 = r20
            r1 = r25
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            goto L_0x001e
        L_0x02a6:
            r29 = r4
            r15 = r5
            r27 = r6
            r28 = r20
            r19 = -1
            r20 = r7
            goto L_0x0336
        L_0x02b3:
            r18 = r4
            r0 = 49
            if (r10 > r0) goto L_0x0302
            r1 = r21
            long r1 = (long) r1
            r0 = r31
            r21 = r1
            r1 = r32
            r2 = r33
            r4 = r3
            r3 = r5
            r34 = r4
            r4 = r35
            r15 = r5
            r5 = r17
            r27 = r6
            r6 = r25
            r28 = r20
            r20 = r7
            r7 = r34
            r23 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r20
            r29 = r18
            r19 = -1
            r18 = r10
            r9 = r21
            r11 = r18
            r12 = r23
            r14 = r36
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.measurement.zzgl) r14)
            if (r0 != r15) goto L_0x02f4
            goto L_0x0358
        L_0x02f4:
            r12 = r33
            r11 = r36
            r2 = r20
            r1 = r25
            r6 = r27
            r7 = r28
            goto L_0x0372
        L_0x0302:
            r34 = r3
            r15 = r5
            r27 = r6
            r23 = r8
            r29 = r18
            r28 = r20
            r1 = r21
            r19 = -1
            r20 = r7
            r18 = r10
            r0 = 50
            r9 = r18
            if (r9 != r0) goto L_0x033c
            r7 = r34
            r0 = 2
            if (r7 != r0) goto L_0x0336
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r20
            r6 = r23
            r8 = r36
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.measurement.zzgl) r8)
            if (r0 != r15) goto L_0x02f4
            goto L_0x0358
        L_0x0336:
            r2 = r15
        L_0x0337:
            r6 = r27
            r7 = r28
            goto L_0x035a
        L_0x033c:
            r7 = r34
            r0 = r31
            r8 = r1
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r17
            r6 = r25
            r10 = r23
            r12 = r20
            r13 = r36
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.measurement.zzgl) r13)
            if (r0 != r15) goto L_0x02f4
        L_0x0358:
            r2 = r0
            goto L_0x0337
        L_0x035a:
            com.google.android.gms.internal.measurement.zzkq r4 = zze((java.lang.Object) r32)
            r0 = r17
            r1 = r33
            r3 = r35
            r5 = r36
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzkq) r4, (com.google.android.gms.internal.measurement.zzgl) r5)
            r12 = r33
            r11 = r36
            r2 = r20
            r1 = r25
        L_0x0372:
            r9 = r29
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r13 = r35
            r14 = r32
            r15 = r31
            goto L_0x001e
        L_0x0380:
            r27 = r6
            r29 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x0393
            long r1 = (long) r7
            r6 = r27
            r4 = r29
            r3 = r32
            r4.putInt(r3, r1, r6)
        L_0x0393:
            r4 = r35
            if (r0 != r4) goto L_0x0398
            return
        L_0x0398:
            com.google.android.gms.internal.measurement.zzig r0 = com.google.android.gms.internal.measurement.zzig.zzg()
            throw r0
        L_0x039d:
            r4 = r13
            r3 = r14
            r5 = 0
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r34
            r4 = r35
            r6 = r36
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzgl) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzgl):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (com.google.android.gms.internal.measurement.zzjx.zza(com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (com.google.android.gms.internal.measurement.zzjx.zza(com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (com.google.android.gms.internal.measurement.zzjx.zza(com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (com.google.android.gms.internal.measurement.zzjx.zza(com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)) != false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzkt.zzc(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0156, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0169, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017c, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0195, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzkt.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzkt.zzd(r11, r6))) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b0, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzkt.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzkt.zze(r11, r6))) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01b2, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.zzjx.zza(com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)) != false) goto L_0x01b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01ba
            int r4 = r9.zzd((int) r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x0198;
                case 1: goto L_0x017f;
                case 2: goto L_0x016c;
                case 3: goto L_0x0159;
                case 4: goto L_0x0148;
                case 5: goto L_0x0135;
                case 6: goto L_0x0124;
                case 7: goto L_0x0112;
                case 8: goto L_0x00fc;
                case 9: goto L_0x00e6;
                case 10: goto L_0x00d0;
                case 11: goto L_0x00be;
                case 12: goto L_0x00ac;
                case 13: goto L_0x009a;
                case 14: goto L_0x0086;
                case 15: goto L_0x0074;
                case 16: goto L_0x0060;
                case 17: goto L_0x004a;
                case 18: goto L_0x003c;
                case 19: goto L_0x003c;
                case 20: goto L_0x003c;
                case 21: goto L_0x003c;
                case 22: goto L_0x003c;
                case 23: goto L_0x003c;
                case 24: goto L_0x003c;
                case 25: goto L_0x003c;
                case 26: goto L_0x003c;
                case 27: goto L_0x003c;
                case 28: goto L_0x003c;
                case 29: goto L_0x003c;
                case 30: goto L_0x003c;
                case 31: goto L_0x003c;
                case 32: goto L_0x003c;
                case 33: goto L_0x003c;
                case 34: goto L_0x003c;
                case 35: goto L_0x003c;
                case 36: goto L_0x003c;
                case 37: goto L_0x003c;
                case 38: goto L_0x003c;
                case 39: goto L_0x003c;
                case 40: goto L_0x003c;
                case 41: goto L_0x003c;
                case 42: goto L_0x003c;
                case 43: goto L_0x003c;
                case 44: goto L_0x003c;
                case 45: goto L_0x003c;
                case 46: goto L_0x003c;
                case 47: goto L_0x003c;
                case 48: goto L_0x003c;
                case 49: goto L_0x003c;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01b3
        L_0x001c:
            int r4 = r9.zze((int) r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r4)
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r4)
            if (r8 != r4) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzjx.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x0197
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.zzjx.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01b3
        L_0x004a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzjx.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x01b2
        L_0x0060:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x0197
        L_0x0074:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x0086:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x0197
        L_0x009a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x00ac:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x0197
        L_0x00be:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x00d0:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzjx.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x0197
        L_0x00e6:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzjx.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x01b2
        L_0x00fc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzjx.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01b3
            goto L_0x0197
        L_0x0112:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            boolean r4 = com.google.android.gms.internal.measurement.zzkt.zzc(r10, r6)
            boolean r5 = com.google.android.gms.internal.measurement.zzkt.zzc(r11, r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x01b2
        L_0x0124:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x0197
        L_0x0135:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x01b2
        L_0x0148:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01b3
            goto L_0x0197
        L_0x0159:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x01b2
        L_0x016c:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            long r4 = com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
            goto L_0x0197
        L_0x017f:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            float r4 = com.google.android.gms.internal.measurement.zzkt.zzd(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.measurement.zzkt.zzd(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01b3
        L_0x0197:
            goto L_0x01b2
        L_0x0198:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01b2
            double r4 = com.google.android.gms.internal.measurement.zzkt.zze(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.measurement.zzkt.zze(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01b3
        L_0x01b2:
            r3 = 0
        L_0x01b3:
            if (r3 != 0) goto L_0x01b6
            return r1
        L_0x01b6:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01ba:
            com.google.android.gms.internal.measurement.zzkn<?, ?> r0 = r9.zzq
            java.lang.Object r0 = r0.zzb(r10)
            com.google.android.gms.internal.measurement.zzkn<?, ?> r2 = r9.zzq
            java.lang.Object r2 = r2.zzb(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01cd
            return r1
        L_0x01cd:
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x01e2
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r9.zzr
            com.google.android.gms.internal.measurement.zzho r10 = r0.zza((java.lang.Object) r10)
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r9.zzr
            com.google.android.gms.internal.measurement.zzho r11 = r0.zza((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01e2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0256, code lost:
        r13 = r13 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x025f, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzc(r3, (com.google.android.gms.internal.measurement.zzjg) com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5), zza(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0278, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzf(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0287, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzh(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0292, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzh(r3, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x029d, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzj(r3, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02ac, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzk(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02bb, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzg(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02c6, code lost:
        r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x02ca, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzc(r3, (com.google.android.gms.internal.measurement.zzgm) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02d7, code lost:
        r3 = com.google.android.gms.internal.measurement.zzjx.zza(r3, com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5), zza(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02f1, code lost:
        if ((r5 instanceof com.google.android.gms.internal.measurement.zzgm) != false) goto L_0x02ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x02f4, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzb(r3, (java.lang.String) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0302, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzb(r3, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x030e, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzi(r3, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x031a, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzg(r3, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x032a, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzf(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x033a, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zze(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x034a, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzd(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0356, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzb(r3, 0.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0362, code lost:
        r3 = com.google.android.gms.internal.measurement.zzhf.zzb(r3, 0.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x036a, code lost:
        r12 = r12 + 3;
        r3 = 267386880;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03b9, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x0635;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x03d9, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x0662;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x03e1, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x066d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0401, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x0692;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0409, code lost:
        if (zza(r1, r15, r3) != false) goto L_0x06a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0419, code lost:
        if ((r4 instanceof com.google.android.gms.internal.measurement.zzgm) != false) goto L_0x0696;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x04ba, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x04c8, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x04d6, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x04e4, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x04f2, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0500, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x050e, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x051b, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0528, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0535, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x0542, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x054f, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:258:0x055c, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0569, code lost:
        if (r4 > 0) goto L_0x056b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:261:0x056b, code lost:
        r8 = (com.google.android.gms.internal.measurement.zzhf.zze(r15) + com.google.android.gms.internal.measurement.zzhf.zzg(r4)) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x0618, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0628, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x062d, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0633, code lost:
        if ((r12 & r11) != 0) goto L_0x0635;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x0635, code lost:
        r4 = com.google.android.gms.internal.measurement.zzhf.zzc(r15, (com.google.android.gms.internal.measurement.zzjg) r2.getObject(r1, r8), zza(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x064c, code lost:
        r4 = com.google.android.gms.internal.measurement.zzhf.zzf(r15, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x0659, code lost:
        r4 = com.google.android.gms.internal.measurement.zzhf.zzh(r15, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x0660, code lost:
        if ((r12 & r11) != 0) goto L_0x0662;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x0662, code lost:
        r4 = com.google.android.gms.internal.measurement.zzhf.zzh(r15, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x066b, code lost:
        if ((r12 & r11) != 0) goto L_0x066d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x066d, code lost:
        r8 = com.google.android.gms.internal.measurement.zzhf.zzj(r15, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x0672, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x067c, code lost:
        r4 = com.google.android.gms.internal.measurement.zzhf.zzk(r15, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x0689, code lost:
        r4 = com.google.android.gms.internal.measurement.zzhf.zzg(r15, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:309:0x0690, code lost:
        if ((r12 & r11) != 0) goto L_0x0692;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x0692, code lost:
        r4 = r2.getObject(r1, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:311:0x0696, code lost:
        r4 = com.google.android.gms.internal.measurement.zzhf.zzc(r15, (com.google.android.gms.internal.measurement.zzgm) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:313:0x069f, code lost:
        if ((r12 & r11) != 0) goto L_0x06a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x06a1, code lost:
        r4 = com.google.android.gms.internal.measurement.zzjx.zza(r15, r2.getObject(r1, r8), zza(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x06b9, code lost:
        if ((r4 instanceof com.google.android.gms.internal.measurement.zzgm) != false) goto L_0x0696;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x06bc, code lost:
        r4 = com.google.android.gms.internal.measurement.zzhf.zzb(r15, (java.lang.String) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x071f, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x0742, code lost:
        r3 = r3 + 3;
        r9 = r13;
        r7 = 1048575;
        r8 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a8, code lost:
        if ((r5 instanceof com.google.android.gms.internal.measurement.zzgm) != false) goto L_0x02ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01d1, code lost:
        r3 = (com.google.android.gms.internal.measurement.zzhf.zze(r3) + com.google.android.gms.internal.measurement.zzhf.zzg(r5)) + r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            boolean r2 = r0.zzj
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x0378
            sun.misc.Unsafe r2 = zzb
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zzc
            int r14 = r14.length
            if (r12 >= r14) goto L_0x0370
            int r14 = r0.zzd((int) r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzc
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.gms.internal.measurement.zzhp r14 = com.google.android.gms.internal.measurement.zzhp.DOUBLE_LIST_PACKED
            int r14 = r14.zza()
            if (r15 < r14) goto L_0x003f
            com.google.android.gms.internal.measurement.zzhp r14 = com.google.android.gms.internal.measurement.zzhp.SINT64_LIST_PACKED
            int r14 = r14.zza()
            if (r15 > r14) goto L_0x003f
            int[] r14 = r0.zzc
            int r17 = r12 + 2
            r14 = r14[r17]
        L_0x003f:
            switch(r15) {
                case 0: goto L_0x035c;
                case 1: goto L_0x0350;
                case 2: goto L_0x0340;
                case 3: goto L_0x0330;
                case 4: goto L_0x0320;
                case 5: goto L_0x0314;
                case 6: goto L_0x0308;
                case 7: goto L_0x02fc;
                case 8: goto L_0x02e5;
                case 9: goto L_0x02d1;
                case 10: goto L_0x02c0;
                case 11: goto L_0x02b1;
                case 12: goto L_0x02a2;
                case 13: goto L_0x0297;
                case 14: goto L_0x028c;
                case 15: goto L_0x027d;
                case 16: goto L_0x026e;
                case 17: goto L_0x0259;
                case 18: goto L_0x024e;
                case 19: goto L_0x0245;
                case 20: goto L_0x023c;
                case 21: goto L_0x0233;
                case 22: goto L_0x022a;
                case 23: goto L_0x024e;
                case 24: goto L_0x0245;
                case 25: goto L_0x0221;
                case 26: goto L_0x0218;
                case 27: goto L_0x020b;
                case 28: goto L_0x0202;
                case 29: goto L_0x01f9;
                case 30: goto L_0x01f0;
                case 31: goto L_0x0245;
                case 32: goto L_0x024e;
                case 33: goto L_0x01e7;
                case 34: goto L_0x01dd;
                case 35: goto L_0x01c5;
                case 36: goto L_0x01b8;
                case 37: goto L_0x01ab;
                case 38: goto L_0x019e;
                case 39: goto L_0x0191;
                case 40: goto L_0x0184;
                case 41: goto L_0x0177;
                case 42: goto L_0x016a;
                case 43: goto L_0x015c;
                case 44: goto L_0x014e;
                case 45: goto L_0x0140;
                case 46: goto L_0x0132;
                case 47: goto L_0x0124;
                case 48: goto L_0x0116;
                case 49: goto L_0x0108;
                case 50: goto L_0x00f8;
                case 51: goto L_0x00f0;
                case 52: goto L_0x00e8;
                case 53: goto L_0x00dc;
                case 54: goto L_0x00d0;
                case 55: goto L_0x00c4;
                case 56: goto L_0x00bc;
                case 57: goto L_0x00b4;
                case 58: goto L_0x00ac;
                case 59: goto L_0x009c;
                case 60: goto L_0x0094;
                case 61: goto L_0x008c;
                case 62: goto L_0x0080;
                case 63: goto L_0x0074;
                case 64: goto L_0x006c;
                case 65: goto L_0x0064;
                case 66: goto L_0x0058;
                case 67: goto L_0x004c;
                case 68: goto L_0x0044;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x036a
        L_0x0044:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x036a
            goto L_0x025f
        L_0x004c:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x036a
            long r5 = zze(r1, r5)
            goto L_0x0278
        L_0x0058:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x036a
            int r5 = zzd(r1, r5)
            goto L_0x0287
        L_0x0064:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x036a
            goto L_0x0292
        L_0x006c:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x036a
            goto L_0x029d
        L_0x0074:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x036a
            int r5 = zzd(r1, r5)
            goto L_0x02ac
        L_0x0080:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x036a
            int r5 = zzd(r1, r5)
            goto L_0x02bb
        L_0x008c:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x036a
            goto L_0x02c6
        L_0x0094:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x036a
            goto L_0x02d7
        L_0x009c:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x036a
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.measurement.zzgm
            if (r6 == 0) goto L_0x02f4
            goto L_0x02f3
        L_0x00ac:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x036a
            goto L_0x0302
        L_0x00b4:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x036a
            goto L_0x030e
        L_0x00bc:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x036a
            goto L_0x031a
        L_0x00c4:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x036a
            int r5 = zzd(r1, r5)
            goto L_0x032a
        L_0x00d0:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x036a
            long r5 = zze(r1, r5)
            goto L_0x033a
        L_0x00dc:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x036a
            long r5 = zze(r1, r5)
            goto L_0x034a
        L_0x00e8:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x036a
            goto L_0x0356
        L_0x00f0:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x036a
            goto L_0x0362
        L_0x00f8:
            com.google.android.gms.internal.measurement.zziz r14 = r0.zzs
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            java.lang.Object r6 = r0.zzb((int) r12)
            int r3 = r14.zza(r3, r5, r6)
            goto L_0x0256
        L_0x0108:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.measurement.zzjv r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzb((int) r3, (java.util.List<com.google.android.gms.internal.measurement.zzjg>) r5, (com.google.android.gms.internal.measurement.zzjv) r6)
            goto L_0x0256
        L_0x0116:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzc(r5)
            if (r5 <= 0) goto L_0x036a
            goto L_0x01d1
        L_0x0124:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzg(r5)
            if (r5 <= 0) goto L_0x036a
            goto L_0x01d1
        L_0x0132:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzi(r5)
            if (r5 <= 0) goto L_0x036a
            goto L_0x01d1
        L_0x0140:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzh(r5)
            if (r5 <= 0) goto L_0x036a
            goto L_0x01d1
        L_0x014e:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzd(r5)
            if (r5 <= 0) goto L_0x036a
            goto L_0x01d1
        L_0x015c:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzf(r5)
            if (r5 <= 0) goto L_0x036a
            goto L_0x01d1
        L_0x016a:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzj(r5)
            if (r5 <= 0) goto L_0x036a
            goto L_0x01d1
        L_0x0177:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzh(r5)
            if (r5 <= 0) goto L_0x036a
            goto L_0x01d1
        L_0x0184:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzi(r5)
            if (r5 <= 0) goto L_0x036a
            goto L_0x01d1
        L_0x0191:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zze(r5)
            if (r5 <= 0) goto L_0x036a
            goto L_0x01d1
        L_0x019e:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzb(r5)
            if (r5 <= 0) goto L_0x036a
            goto L_0x01d1
        L_0x01ab:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zza((java.util.List<java.lang.Long>) r5)
            if (r5 <= 0) goto L_0x036a
            goto L_0x01d1
        L_0x01b8:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzh(r5)
            if (r5 <= 0) goto L_0x036a
            goto L_0x01d1
        L_0x01c5:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzi(r5)
            if (r5 <= 0) goto L_0x036a
        L_0x01d1:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x0256
        L_0x01dd:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzc(r3, r5, r11)
            goto L_0x0256
        L_0x01e7:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzg(r3, r5, r11)
            goto L_0x0256
        L_0x01f0:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzd(r3, r5, r11)
            goto L_0x0256
        L_0x01f9:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzf(r3, r5, r11)
            goto L_0x0256
        L_0x0202:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzb(r3, r5)
            goto L_0x0256
        L_0x020b:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.measurement.zzjv r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zza((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.measurement.zzjv) r6)
            goto L_0x0256
        L_0x0218:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zza((int) r3, (java.util.List<?>) r5)
            goto L_0x0256
        L_0x0221:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzj(r3, r5, r11)
            goto L_0x0256
        L_0x022a:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zze(r3, r5, r11)
            goto L_0x0256
        L_0x0233:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzb((int) r3, (java.util.List<java.lang.Long>) r5, (boolean) r11)
            goto L_0x0256
        L_0x023c:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zza((int) r3, (java.util.List<java.lang.Long>) r5, (boolean) r11)
            goto L_0x0256
        L_0x0245:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzh(r3, r5, r11)
            goto L_0x0256
        L_0x024e:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzi(r3, r5, r11)
        L_0x0256:
            int r13 = r13 + r3
            goto L_0x036a
        L_0x0259:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x036a
        L_0x025f:
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzjg r5 = (com.google.android.gms.internal.measurement.zzjg) r5
            com.google.android.gms.internal.measurement.zzjv r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzc(r3, r5, r6)
            goto L_0x0256
        L_0x026e:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x036a
            long r5 = com.google.android.gms.internal.measurement.zzkt.zzb(r1, r5)
        L_0x0278:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzf((int) r3, (long) r5)
            goto L_0x0256
        L_0x027d:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x036a
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r1, (long) r5)
        L_0x0287:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzh((int) r3, (int) r5)
            goto L_0x0256
        L_0x028c:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x036a
        L_0x0292:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzh((int) r3, (long) r9)
            goto L_0x0256
        L_0x0297:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x036a
        L_0x029d:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzj(r3, r11)
            goto L_0x0256
        L_0x02a2:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x036a
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r1, (long) r5)
        L_0x02ac:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzk(r3, r5)
            goto L_0x0256
        L_0x02b1:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x036a
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r1, (long) r5)
        L_0x02bb:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r3, (int) r5)
            goto L_0x0256
        L_0x02c0:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x036a
        L_0x02c6:
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
        L_0x02ca:
            com.google.android.gms.internal.measurement.zzgm r5 = (com.google.android.gms.internal.measurement.zzgm) r5
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzc((int) r3, (com.google.android.gms.internal.measurement.zzgm) r5)
            goto L_0x0256
        L_0x02d1:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x036a
        L_0x02d7:
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzjv r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zza((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.measurement.zzjv) r6)
            goto L_0x0256
        L_0x02e5:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x036a
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.measurement.zzgm
            if (r6 == 0) goto L_0x02f4
        L_0x02f3:
            goto L_0x02ca
        L_0x02f4:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r3, (java.lang.String) r5)
            goto L_0x0256
        L_0x02fc:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x036a
        L_0x0302:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r3, (boolean) r8)
            goto L_0x0256
        L_0x0308:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x036a
        L_0x030e:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzi(r3, r11)
            goto L_0x0256
        L_0x0314:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x036a
        L_0x031a:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r3, (long) r9)
            goto L_0x0256
        L_0x0320:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x036a
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r1, (long) r5)
        L_0x032a:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzf((int) r3, (int) r5)
            goto L_0x0256
        L_0x0330:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x036a
            long r5 = com.google.android.gms.internal.measurement.zzkt.zzb(r1, r5)
        L_0x033a:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3, (long) r5)
            goto L_0x0256
        L_0x0340:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x036a
            long r5 = com.google.android.gms.internal.measurement.zzkt.zzb(r1, r5)
        L_0x034a:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzd((int) r3, (long) r5)
            goto L_0x0256
        L_0x0350:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x036a
        L_0x0356:
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r3, (float) r4)
            goto L_0x0256
        L_0x035c:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x036a
        L_0x0362:
            r5 = 0
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r3, (double) r5)
            goto L_0x0256
        L_0x036a:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x0370:
            com.google.android.gms.internal.measurement.zzkn<?, ?> r2 = r0.zzq
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x0378:
            sun.misc.Unsafe r2 = zzb
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x0380:
            int[] r13 = r0.zzc
            int r13 = r13.length
            if (r3 >= r13) goto L_0x074d
            int r13 = r0.zzd((int) r3)
            int[] r14 = r0.zzc
            r15 = r14[r3]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r17 = r13 & r16
            int r4 = r17 >>> 20
            r11 = 17
            if (r4 > r11) goto L_0x03ac
            int r11 = r3 + 2
            r11 = r14[r11]
            r14 = r11 & r7
            int r11 = r11 >>> 20
            int r11 = r8 << r11
            if (r14 == r6) goto L_0x03a9
            long r8 = (long) r14
            int r12 = r2.getInt(r1, r8)
            goto L_0x03aa
        L_0x03a9:
            r14 = r6
        L_0x03aa:
            r6 = r14
            goto L_0x03ad
        L_0x03ac:
            r11 = 0
        L_0x03ad:
            r8 = r13 & r7
            long r8 = (long) r8
            switch(r4) {
                case 0: goto L_0x0732;
                case 1: goto L_0x0721;
                case 2: goto L_0x0710;
                case 3: goto L_0x0700;
                case 4: goto L_0x06f0;
                case 5: goto L_0x06e0;
                case 6: goto L_0x06d0;
                case 7: goto L_0x06c4;
                case 8: goto L_0x06af;
                case 9: goto L_0x069d;
                case 10: goto L_0x068e;
                case 11: goto L_0x0681;
                case 12: goto L_0x0674;
                case 13: goto L_0x0669;
                case 14: goto L_0x065e;
                case 15: goto L_0x0651;
                case 16: goto L_0x0644;
                case 17: goto L_0x0631;
                case 18: goto L_0x061d;
                case 19: goto L_0x060d;
                case 20: goto L_0x0601;
                case 21: goto L_0x05f5;
                case 22: goto L_0x05e9;
                case 23: goto L_0x05dd;
                case 24: goto L_0x060d;
                case 25: goto L_0x05d1;
                case 26: goto L_0x05c6;
                case 27: goto L_0x05b7;
                case 28: goto L_0x05ab;
                case 29: goto L_0x059e;
                case 30: goto L_0x0591;
                case 31: goto L_0x060d;
                case 32: goto L_0x05dd;
                case 33: goto L_0x0584;
                case 34: goto L_0x0577;
                case 35: goto L_0x055f;
                case 36: goto L_0x0552;
                case 37: goto L_0x0545;
                case 38: goto L_0x0538;
                case 39: goto L_0x052b;
                case 40: goto L_0x051e;
                case 41: goto L_0x0511;
                case 42: goto L_0x0504;
                case 43: goto L_0x04f6;
                case 44: goto L_0x04e8;
                case 45: goto L_0x04da;
                case 46: goto L_0x04cc;
                case 47: goto L_0x04be;
                case 48: goto L_0x04b0;
                case 49: goto L_0x04a0;
                case 50: goto L_0x0490;
                case 51: goto L_0x0482;
                case 52: goto L_0x0475;
                case 53: goto L_0x0465;
                case 54: goto L_0x0455;
                case 55: goto L_0x0445;
                case 56: goto L_0x0437;
                case 57: goto L_0x042a;
                case 58: goto L_0x041d;
                case 59: goto L_0x040d;
                case 60: goto L_0x0405;
                case 61: goto L_0x03fd;
                case 62: goto L_0x03f1;
                case 63: goto L_0x03e5;
                case 64: goto L_0x03dd;
                case 65: goto L_0x03d5;
                case 66: goto L_0x03c9;
                case 67: goto L_0x03bd;
                case 68: goto L_0x03b5;
                default: goto L_0x03b3;
            }
        L_0x03b3:
            goto L_0x0629
        L_0x03b5:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            goto L_0x0635
        L_0x03bd:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            long r8 = zze(r1, r8)
            goto L_0x064c
        L_0x03c9:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            int r4 = zzd(r1, r8)
            goto L_0x0659
        L_0x03d5:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            goto L_0x0662
        L_0x03dd:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            goto L_0x066d
        L_0x03e5:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            int r4 = zzd(r1, r8)
            goto L_0x067c
        L_0x03f1:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            int r4 = zzd(r1, r8)
            goto L_0x0689
        L_0x03fd:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            goto L_0x0692
        L_0x0405:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            goto L_0x06a1
        L_0x040d:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.measurement.zzgm
            if (r8 == 0) goto L_0x06bc
            goto L_0x06bb
        L_0x041d:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            r4 = 1
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (boolean) r4)
            goto L_0x0672
        L_0x042a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzi(r15, r4)
            goto L_0x0672
        L_0x0437:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r15, (long) r8)
            goto L_0x0628
        L_0x0445:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzf((int) r15, (int) r4)
            goto L_0x0628
        L_0x0455:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15, (long) r8)
            goto L_0x0628
        L_0x0465:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzd((int) r15, (long) r8)
            goto L_0x0628
        L_0x0475:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (float) r4)
            goto L_0x0672
        L_0x0482:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0629
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (double) r8)
            goto L_0x0628
        L_0x0490:
            com.google.android.gms.internal.measurement.zziz r4 = r0.zzs
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.lang.Object r9 = r0.zzb((int) r3)
            int r4 = r4.zza(r15, r8, r9)
            goto L_0x0628
        L_0x04a0:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzjv r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzb((int) r15, (java.util.List<com.google.android.gms.internal.measurement.zzjg>) r4, (com.google.android.gms.internal.measurement.zzjv) r8)
            goto L_0x0628
        L_0x04b0:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzc(r4)
            if (r4 <= 0) goto L_0x0629
            goto L_0x056b
        L_0x04be:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzg(r4)
            if (r4 <= 0) goto L_0x0629
            goto L_0x056b
        L_0x04cc:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzi(r4)
            if (r4 <= 0) goto L_0x0629
            goto L_0x056b
        L_0x04da:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzh(r4)
            if (r4 <= 0) goto L_0x0629
            goto L_0x056b
        L_0x04e8:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzd(r4)
            if (r4 <= 0) goto L_0x0629
            goto L_0x056b
        L_0x04f6:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzf(r4)
            if (r4 <= 0) goto L_0x0629
            goto L_0x056b
        L_0x0504:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzj(r4)
            if (r4 <= 0) goto L_0x0629
            goto L_0x056b
        L_0x0511:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzh(r4)
            if (r4 <= 0) goto L_0x0629
            goto L_0x056b
        L_0x051e:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzi(r4)
            if (r4 <= 0) goto L_0x0629
            goto L_0x056b
        L_0x052b:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zze(r4)
            if (r4 <= 0) goto L_0x0629
            goto L_0x056b
        L_0x0538:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzb(r4)
            if (r4 <= 0) goto L_0x0629
            goto L_0x056b
        L_0x0545:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zza((java.util.List<java.lang.Long>) r4)
            if (r4 <= 0) goto L_0x0629
            goto L_0x056b
        L_0x0552:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzh(r4)
            if (r4 <= 0) goto L_0x0629
            goto L_0x056b
        L_0x055f:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzi(r4)
            if (r4 <= 0) goto L_0x0629
        L_0x056b:
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x0672
        L_0x0577:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzc(r15, r4, r10)
            goto L_0x0618
        L_0x0584:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzg(r15, r4, r10)
            goto L_0x0618
        L_0x0591:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzd(r15, r4, r10)
            goto L_0x0618
        L_0x059e:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzf(r15, r4, r10)
            goto L_0x0628
        L_0x05ab:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzb(r15, r4)
            goto L_0x0628
        L_0x05b7:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzjv r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzjx.zza((int) r15, (java.util.List<?>) r4, (com.google.android.gms.internal.measurement.zzjv) r8)
            goto L_0x0628
        L_0x05c6:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zza((int) r15, (java.util.List<?>) r4)
            goto L_0x0628
        L_0x05d1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzj(r15, r4, r10)
            goto L_0x0618
        L_0x05dd:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzi(r15, r4, r10)
            goto L_0x0618
        L_0x05e9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zze(r15, r4, r10)
            goto L_0x0618
        L_0x05f5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzb((int) r15, (java.util.List<java.lang.Long>) r4, (boolean) r10)
            goto L_0x0618
        L_0x0601:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zza((int) r15, (java.util.List<java.lang.Long>) r4, (boolean) r10)
            goto L_0x0618
        L_0x060d:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzh(r15, r4, r10)
        L_0x0618:
            int r5 = r5 + r4
            r4 = 1
        L_0x061a:
            r7 = 0
            goto L_0x062d
        L_0x061d:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzi(r15, r4, r10)
        L_0x0628:
            int r5 = r5 + r4
        L_0x0629:
            r4 = 1
        L_0x062a:
            r7 = 0
            r10 = 0
        L_0x062d:
            r13 = 0
            goto L_0x0742
        L_0x0631:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x0629
        L_0x0635:
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzjg r4 = (com.google.android.gms.internal.measurement.zzjg) r4
            com.google.android.gms.internal.measurement.zzjv r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzc(r15, r4, r8)
            goto L_0x0628
        L_0x0644:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x0629
            long r8 = r2.getLong(r1, r8)
        L_0x064c:
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzf((int) r15, (long) r8)
            goto L_0x0628
        L_0x0651:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x0629
            int r4 = r2.getInt(r1, r8)
        L_0x0659:
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzh((int) r15, (int) r4)
            goto L_0x0628
        L_0x065e:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x0629
        L_0x0662:
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzh((int) r15, (long) r8)
            goto L_0x0628
        L_0x0669:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x0629
        L_0x066d:
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzj(r15, r4)
        L_0x0672:
            int r5 = r5 + r8
            goto L_0x0629
        L_0x0674:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x0629
            int r4 = r2.getInt(r1, r8)
        L_0x067c:
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzk(r15, r4)
            goto L_0x0628
        L_0x0681:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x0629
            int r4 = r2.getInt(r1, r8)
        L_0x0689:
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r15, (int) r4)
            goto L_0x0628
        L_0x068e:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x0629
        L_0x0692:
            java.lang.Object r4 = r2.getObject(r1, r8)
        L_0x0696:
            com.google.android.gms.internal.measurement.zzgm r4 = (com.google.android.gms.internal.measurement.zzgm) r4
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzc((int) r15, (com.google.android.gms.internal.measurement.zzgm) r4)
            goto L_0x0628
        L_0x069d:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x0629
        L_0x06a1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzjv r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzjx.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzjv) r8)
            goto L_0x0628
        L_0x06af:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x0629
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.measurement.zzgm
            if (r8 == 0) goto L_0x06bc
        L_0x06bb:
            goto L_0x0696
        L_0x06bc:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (java.lang.String) r4)
            goto L_0x0628
        L_0x06c4:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x0629
            r4 = 1
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (boolean) r4)
            int r5 = r5 + r8
            goto L_0x062a
        L_0x06d0:
            r4 = 1
            r8 = r12 & r11
            if (r8 == 0) goto L_0x06dd
            r10 = 0
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzi(r15, r10)
            int r5 = r5 + r8
            goto L_0x061a
        L_0x06dd:
            r10 = 0
            goto L_0x061a
        L_0x06e0:
            r4 = 1
            r10 = 0
            r8 = r12 & r11
            if (r8 == 0) goto L_0x06ed
            r13 = 0
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r15, (long) r13)
            goto L_0x071f
        L_0x06ed:
            r13 = 0
            goto L_0x072f
        L_0x06f0:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r11 & r12
            if (r11 == 0) goto L_0x072f
            int r8 = r2.getInt(r1, r8)
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzf((int) r15, (int) r8)
            goto L_0x071f
        L_0x0700:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r11 & r12
            if (r11 == 0) goto L_0x072f
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15, (long) r8)
            goto L_0x071f
        L_0x0710:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r11 & r12
            if (r11 == 0) goto L_0x072f
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzd((int) r15, (long) r8)
        L_0x071f:
            int r5 = r5 + r8
            goto L_0x072f
        L_0x0721:
            r4 = 1
            r10 = 0
            r13 = 0
            r8 = r12 & r11
            if (r8 == 0) goto L_0x072f
            r8 = 0
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (float) r8)
            int r5 = r5 + r9
        L_0x072f:
            r7 = 0
            goto L_0x0742
        L_0x0732:
            r4 = 1
            r8 = 0
            r10 = 0
            r13 = 0
            r9 = r12 & r11
            if (r9 == 0) goto L_0x072f
            r7 = 0
            int r11 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (double) r7)
            int r5 = r5 + r11
        L_0x0742:
            int r3 = r3 + 3
            r9 = r13
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r11 = 0
            goto L_0x0380
        L_0x074d:
            r10 = 0
            com.google.android.gms.internal.measurement.zzkn<?, ?> r2 = r0.zzq
            int r2 = zza(r2, r1)
            int r5 = r5 + r2
            boolean r2 = r0.zzh
            if (r2 == 0) goto L_0x07a7
            com.google.android.gms.internal.measurement.zzhk<?> r2 = r0.zzr
            com.google.android.gms.internal.measurement.zzho r1 = r2.zza((java.lang.Object) r1)
            r2 = 0
        L_0x0760:
            com.google.android.gms.internal.measurement.zzka<T, java.lang.Object> r3 = r1.zza
            int r3 = r3.zzc()
            if (r10 >= r3) goto L_0x0780
            com.google.android.gms.internal.measurement.zzka<T, java.lang.Object> r3 = r1.zza
            java.util.Map$Entry r3 = r3.zzb((int) r10)
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.measurement.zzhq r4 = (com.google.android.gms.internal.measurement.zzhq) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.measurement.zzho.zza((com.google.android.gms.internal.measurement.zzhq<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            int r10 = r10 + 1
            goto L_0x0760
        L_0x0780:
            com.google.android.gms.internal.measurement.zzka<T, java.lang.Object> r1 = r1.zza
            java.lang.Iterable r1 = r1.zzd()
            java.util.Iterator r1 = r1.iterator()
        L_0x078a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x07a6
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.measurement.zzhq r4 = (com.google.android.gms.internal.measurement.zzhq) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.measurement.zzho.zza((com.google.android.gms.internal.measurement.zzhq<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x078a
        L_0x07a6:
            int r5 = r5 + r2
        L_0x07a7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zzb(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
        com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.measurement.zzkt.zzf(r8, r2));
        zzb(r7, r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0089, code lost:
        com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.measurement.zzkt.zzf(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b3, code lost:
        com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c8, code lost:
        com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r7, r2, com.google.android.gms.internal.measurement.zzkt.zzb(r8, r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00eb, code lost:
        zzb(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ee, code lost:
        r0 = r0 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(T r7, T r8) {
        /*
            r6 = this;
            if (r8 == 0) goto L_0x0101
            r0 = 0
        L_0x0003:
            int[] r1 = r6.zzc
            int r1 = r1.length
            if (r0 >= r1) goto L_0x00f2
            int r1 = r6.zzd((int) r0)
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r1
            long r2 = (long) r2
            int[] r4 = r6.zzc
            r4 = r4[r0]
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r1 = r1 & r5
            int r1 = r1 >>> 20
            switch(r1) {
                case 0: goto L_0x00de;
                case 1: goto L_0x00d0;
                case 2: goto L_0x00c2;
                case 3: goto L_0x00bb;
                case 4: goto L_0x00ad;
                case 5: goto L_0x00a6;
                case 6: goto L_0x009f;
                case 7: goto L_0x0091;
                case 8: goto L_0x0083;
                case 9: goto L_0x007e;
                case 10: goto L_0x0077;
                case 11: goto L_0x0070;
                case 12: goto L_0x0069;
                case 13: goto L_0x0062;
                case 14: goto L_0x005a;
                case 15: goto L_0x0053;
                case 16: goto L_0x004b;
                case 17: goto L_0x007e;
                case 18: goto L_0x0044;
                case 19: goto L_0x0044;
                case 20: goto L_0x0044;
                case 21: goto L_0x0044;
                case 22: goto L_0x0044;
                case 23: goto L_0x0044;
                case 24: goto L_0x0044;
                case 25: goto L_0x0044;
                case 26: goto L_0x0044;
                case 27: goto L_0x0044;
                case 28: goto L_0x0044;
                case 29: goto L_0x0044;
                case 30: goto L_0x0044;
                case 31: goto L_0x0044;
                case 32: goto L_0x0044;
                case 33: goto L_0x0044;
                case 34: goto L_0x0044;
                case 35: goto L_0x0044;
                case 36: goto L_0x0044;
                case 37: goto L_0x0044;
                case 38: goto L_0x0044;
                case 39: goto L_0x0044;
                case 40: goto L_0x0044;
                case 41: goto L_0x0044;
                case 42: goto L_0x0044;
                case 43: goto L_0x0044;
                case 44: goto L_0x0044;
                case 45: goto L_0x0044;
                case 46: goto L_0x0044;
                case 47: goto L_0x0044;
                case 48: goto L_0x0044;
                case 49: goto L_0x0044;
                case 50: goto L_0x003d;
                case 51: goto L_0x002b;
                case 52: goto L_0x002b;
                case 53: goto L_0x002b;
                case 54: goto L_0x002b;
                case 55: goto L_0x002b;
                case 56: goto L_0x002b;
                case 57: goto L_0x002b;
                case 58: goto L_0x002b;
                case 59: goto L_0x002b;
                case 60: goto L_0x0026;
                case 61: goto L_0x001f;
                case 62: goto L_0x001f;
                case 63: goto L_0x001f;
                case 64: goto L_0x001f;
                case 65: goto L_0x001f;
                case 66: goto L_0x001f;
                case 67: goto L_0x001f;
                case 68: goto L_0x0026;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x00ee
        L_0x001f:
            boolean r1 = r6.zza(r8, (int) r4, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0031
        L_0x0026:
            r6.zzb(r7, r8, (int) r0)
            goto L_0x00ee
        L_0x002b:
            boolean r1 = r6.zza(r8, (int) r4, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x0031:
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkt.zzf(r8, r2)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            r6.zzb(r7, (int) r4, (int) r0)
            goto L_0x00ee
        L_0x003d:
            com.google.android.gms.internal.measurement.zziz r1 = r6.zzs
            com.google.android.gms.internal.measurement.zzjx.zza((com.google.android.gms.internal.measurement.zziz) r1, r7, r8, (long) r2)
            goto L_0x00ee
        L_0x0044:
            com.google.android.gms.internal.measurement.zziq r1 = r6.zzp
            r1.zza(r7, r8, r2)
            goto L_0x00ee
        L_0x004b:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0053:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x005a:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x0062:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x006f
        L_0x0069:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x006f:
            goto L_0x00b3
        L_0x0070:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x0077:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x0089
        L_0x007e:
            r6.zza(r7, r8, (int) r0)
            goto L_0x00ee
        L_0x0083:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x0089:
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkt.zzf(r8, r2)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r7, (long) r2, (java.lang.Object) r1)
            goto L_0x00eb
        L_0x0091:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            boolean r1 = com.google.android.gms.internal.measurement.zzkt.zzc(r8, r2)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r7, (long) r2, (boolean) r1)
            goto L_0x00eb
        L_0x009f:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00b3
        L_0x00a6:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00ad:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00b3:
            int r1 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r8, (long) r2)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r7, (long) r2, (int) r1)
            goto L_0x00eb
        L_0x00bb:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            goto L_0x00c8
        L_0x00c2:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
        L_0x00c8:
            long r4 = com.google.android.gms.internal.measurement.zzkt.zzb(r8, r2)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r7, (long) r2, (long) r4)
            goto L_0x00eb
        L_0x00d0:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            float r1 = com.google.android.gms.internal.measurement.zzkt.zzd(r8, r2)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r7, (long) r2, (float) r1)
            goto L_0x00eb
        L_0x00de:
            boolean r1 = r6.zza(r8, (int) r0)
            if (r1 == 0) goto L_0x00ee
            double r4 = com.google.android.gms.internal.measurement.zzkt.zze(r8, r2)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r7, (long) r2, (double) r4)
        L_0x00eb:
            r6.zzb(r7, (int) r0)
        L_0x00ee:
            int r0 = r0 + 3
            goto L_0x0003
        L_0x00f2:
            com.google.android.gms.internal.measurement.zzkn<?, ?> r0 = r6.zzq
            com.google.android.gms.internal.measurement.zzjx.zza(r0, r7, r8)
            boolean r0 = r6.zzh
            if (r0 == 0) goto L_0x0100
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r6.zzr
            com.google.android.gms.internal.measurement.zzjx.zza(r0, r7, r8)
        L_0x0100:
            return
        L_0x0101:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zzb(java.lang.Object, java.lang.Object):void");
    }

    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzkt.zzf(t, zzd2);
            if (zzf2 != null) {
                zzkt.zza((Object) t, zzd2, this.zzs.zzd(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0124, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(T r19) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = 0
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r1 = 0
            r10 = 0
        L_0x000d:
            int r2 = r6.zzm
            r11 = 1
            if (r10 >= r2) goto L_0x012c
            int[] r2 = r6.zzl
            r12 = r2[r10]
            int[] r2 = r6.zzc
            r13 = r2[r12]
            int r14 = r6.zzd((int) r12)
            int[] r2 = r6.zzc
            int r3 = r12 + 2
            r2 = r2[r3]
            r3 = r2 & r8
            int r2 = r2 >>> 20
            int r15 = r11 << r2
            if (r3 == r0) goto L_0x003d
            if (r3 == r8) goto L_0x0038
            sun.misc.Unsafe r0 = zzb
            long r1 = (long) r3
            int r0 = r0.getInt(r7, r1)
            r17 = r0
            goto L_0x003a
        L_0x0038:
            r17 = r1
        L_0x003a:
            r16 = r3
            goto L_0x0041
        L_0x003d:
            r16 = r0
            r17 = r1
        L_0x0041:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r0 = r0 & r14
            if (r0 == 0) goto L_0x0048
            r0 = 1
            goto L_0x0049
        L_0x0048:
            r0 = 0
        L_0x0049:
            if (r0 == 0) goto L_0x005c
            r0 = r18
            r1 = r19
            r2 = r12
            r3 = r16
            r4 = r17
            r5 = r15
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 != 0) goto L_0x005c
            return r9
        L_0x005c:
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r14
            int r0 = r0 >>> 20
            r1 = 9
            if (r0 == r1) goto L_0x0109
            r1 = 17
            if (r0 == r1) goto L_0x0109
            r1 = 27
            if (r0 == r1) goto L_0x00dd
            r1 = 60
            if (r0 == r1) goto L_0x00cc
            r1 = 68
            if (r0 == r1) goto L_0x00cc
            switch(r0) {
                case 49: goto L_0x00dd;
                case 50: goto L_0x007a;
                default: goto L_0x0078;
            }
        L_0x0078:
            goto L_0x0124
        L_0x007a:
            com.google.android.gms.internal.measurement.zziz r0 = r6.zzs
            r1 = r14 & r8
            long r1 = (long) r1
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkt.zzf(r7, r1)
            java.util.Map r0 = r0.zzb(r1)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x00c9
            java.lang.Object r1 = r6.zzb((int) r12)
            com.google.android.gms.internal.measurement.zziz r2 = r6.zzs
            com.google.android.gms.internal.measurement.zzix r1 = r2.zzf(r1)
            com.google.android.gms.internal.measurement.zzle r1 = r1.zzc
            com.google.android.gms.internal.measurement.zzlh r1 = r1.zza()
            com.google.android.gms.internal.measurement.zzlh r2 = com.google.android.gms.internal.measurement.zzlh.MESSAGE
            if (r1 != r2) goto L_0x00c9
            r1 = 0
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x00aa:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00c9
            java.lang.Object r2 = r0.next()
            if (r1 != 0) goto L_0x00c2
            com.google.android.gms.internal.measurement.zzjr r1 = com.google.android.gms.internal.measurement.zzjr.zza()
            java.lang.Class r3 = r2.getClass()
            com.google.android.gms.internal.measurement.zzjv r1 = r1.zza(r3)
        L_0x00c2:
            boolean r2 = r1.zzd(r2)
            if (r2 != 0) goto L_0x00aa
            r11 = 0
        L_0x00c9:
            if (r11 != 0) goto L_0x0124
            return r9
        L_0x00cc:
            boolean r0 = r6.zza(r7, (int) r13, (int) r12)
            if (r0 == 0) goto L_0x0124
            com.google.android.gms.internal.measurement.zzjv r0 = r6.zza((int) r12)
            boolean r0 = zza((java.lang.Object) r7, (int) r14, (com.google.android.gms.internal.measurement.zzjv) r0)
            if (r0 != 0) goto L_0x0124
            return r9
        L_0x00dd:
            r0 = r14 & r8
            long r0 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.measurement.zzkt.zzf(r7, r0)
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0106
            com.google.android.gms.internal.measurement.zzjv r1 = r6.zza((int) r12)
            r2 = 0
        L_0x00f1:
            int r3 = r0.size()
            if (r2 >= r3) goto L_0x0106
            java.lang.Object r3 = r0.get(r2)
            boolean r3 = r1.zzd(r3)
            if (r3 != 0) goto L_0x0103
            r11 = 0
            goto L_0x0106
        L_0x0103:
            int r2 = r2 + 1
            goto L_0x00f1
        L_0x0106:
            if (r11 != 0) goto L_0x0124
            return r9
        L_0x0109:
            r0 = r18
            r1 = r19
            r2 = r12
            r3 = r16
            r4 = r17
            r5 = r15
            boolean r0 = r0.zza(r1, (int) r2, (int) r3, (int) r4, (int) r5)
            if (r0 == 0) goto L_0x0124
            com.google.android.gms.internal.measurement.zzjv r0 = r6.zza((int) r12)
            boolean r0 = zza((java.lang.Object) r7, (int) r14, (com.google.android.gms.internal.measurement.zzjv) r0)
            if (r0 != 0) goto L_0x0124
            return r9
        L_0x0124:
            int r10 = r10 + 1
            r0 = r16
            r1 = r17
            goto L_0x000d
        L_0x012c:
            boolean r0 = r6.zzh
            if (r0 == 0) goto L_0x013d
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r6.zzr
            com.google.android.gms.internal.measurement.zzho r0 = r0.zza((java.lang.Object) r7)
            boolean r0 = r0.zzf()
            if (r0 != 0) goto L_0x013d
            return r9
        L_0x013d:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zzd(java.lang.Object):boolean");
    }
}
