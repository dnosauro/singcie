package com.cyberneid.p105d.p114g.p122e.p125c;

import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p111d.C1656c;
import com.cyberneid.p105d.p111d.C1657d;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.p122e.p123a.C1841i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/* renamed from: com.cyberneid.d.g.e.c.a */
public final class C1855a {
    /* renamed from: a */
    private static int m7691a(char c, C1656c cVar) {
        int read;
        int read2;
        if (c == 'I') {
            read = cVar.read();
            read2 = cVar.read() << 8;
        } else {
            read = cVar.read() << 8;
            read2 = cVar.read();
        }
        return read | read2;
    }

    /* renamed from: a */
    private static C1861e m7692a(C1783c cVar, C1656c cVar2, int i) {
        C1607d dVar = new C1607d();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m7695a(cVar2, byteArrayOutputStream, dVar, i);
        if (byteArrayOutputStream.size() == 0) {
            return null;
        }
        C1861e eVar = new C1861e(cVar, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), C1613i.f4957am, dVar.mo7547g(C1613i.f4930aL), dVar.mo7547g(C1613i.f5273gk), 1, C1841i.f5963a);
        eVar.mo8251b().mo7521a(C1613i.f5003bf, (C1605b) dVar);
        return eVar;
    }

    /* renamed from: a */
    public static C1861e m7693a(C1783c cVar, byte[] bArr) {
        return m7694a(cVar, bArr, 0);
    }

    /* renamed from: a */
    public static C1861e m7694a(C1783c cVar, byte[] bArr, int i) {
        C1657d dVar = new C1657d(bArr);
        try {
            return m7692a(cVar, (C1656c) dVar, i);
        } finally {
            dVar.close();
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00bf, code lost:
        r11 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c3, code lost:
        r10 = r15;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m7695a(com.cyberneid.p105d.p111d.C1656c r16, java.io.OutputStream r17, com.cyberneid.p105d.p108b.C1607d r18, int r19) {
        /*
            r0 = r16
            r1 = r18
            r2 = 0
            r0.mo7706a(r2)     // Catch:{ all -> 0x0144 }
            int r2 = r16.read()     // Catch:{ all -> 0x0144 }
            char r2 = (char) r2     // Catch:{ all -> 0x0144 }
            int r3 = r16.read()     // Catch:{ all -> 0x0144 }
            char r3 = (char) r3     // Catch:{ all -> 0x0144 }
            if (r3 != r2) goto L_0x0138
            r3 = 77
            if (r2 == r3) goto L_0x0026
            r4 = 73
            if (r2 != r4) goto L_0x001e
            goto L_0x0026
        L_0x001e:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0144 }
            java.lang.String r1 = "Not a valid tiff file"
            r0.<init>(r1)     // Catch:{ all -> 0x0144 }
            throw r0     // Catch:{ all -> 0x0144 }
        L_0x0026:
            int r4 = m7691a((char) r2, (com.cyberneid.p105d.p111d.C1656c) r0)     // Catch:{ all -> 0x0144 }
            r5 = 42
            if (r4 != r5) goto L_0x012e
            int r4 = m7696b(r2, r0)     // Catch:{ all -> 0x0144 }
            long r5 = (long) r4     // Catch:{ all -> 0x0144 }
            r0.mo7706a(r5)     // Catch:{ all -> 0x0144 }
            r5 = 0
            r6 = r4
            r4 = 0
        L_0x0039:
            r7 = 50
            r8 = r19
            if (r4 >= r8) goto L_0x0067
            int r9 = m7691a((char) r2, (com.cyberneid.p105d.p111d.C1656c) r0)     // Catch:{ all -> 0x0144 }
            if (r9 > r7) goto L_0x005f
            int r6 = r6 + 2
            int r9 = r9 * 12
            int r6 = r6 + r9
            long r6 = (long) r6     // Catch:{ all -> 0x0144 }
            r0.mo7706a(r6)     // Catch:{ all -> 0x0144 }
            int r6 = m7696b(r2, r0)     // Catch:{ all -> 0x0144 }
            if (r6 != 0) goto L_0x0058
            r17.close()
            return
        L_0x0058:
            long r9 = (long) r6
            r0.mo7706a(r9)     // Catch:{ all -> 0x0144 }
            int r4 = r4 + 1
            goto L_0x0039
        L_0x005f:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0144 }
            java.lang.String r1 = "Not a valid tiff file"
            r0.<init>(r1)     // Catch:{ all -> 0x0144 }
            throw r0     // Catch:{ all -> 0x0144 }
        L_0x0067:
            int r4 = m7691a((char) r2, (com.cyberneid.p105d.p111d.C1656c) r0)     // Catch:{ all -> 0x0144 }
            if (r4 > r7) goto L_0x0124
            r6 = -1000(0xfffffffffffffc18, float:NaN)
            r8 = 0
            r9 = -1000(0xfffffffffffffc18, float:NaN)
            r10 = 0
            r11 = 0
        L_0x0074:
            if (r8 >= r4) goto L_0x00e8
            int r12 = m7691a((char) r2, (com.cyberneid.p105d.p111d.C1656c) r0)     // Catch:{ all -> 0x0144 }
            int r13 = m7691a((char) r2, (com.cyberneid.p105d.p111d.C1656c) r0)     // Catch:{ all -> 0x0144 }
            int r14 = m7696b(r2, r0)     // Catch:{ all -> 0x0144 }
            int r15 = m7696b(r2, r0)     // Catch:{ all -> 0x0144 }
            r7 = 1
            if (r2 != r3) goto L_0x0094
            if (r13 == r7) goto L_0x0092
            switch(r13) {
                case 3: goto L_0x008f;
                case 4: goto L_0x0094;
                default: goto L_0x008e;
            }     // Catch:{ all -> 0x0144 }
        L_0x008e:
            goto L_0x0094
        L_0x008f:
            int r15 = r15 >> 16
            goto L_0x0094
        L_0x0092:
            int r15 = r15 >> 24
        L_0x0094:
            switch(r12) {
                case 256: goto L_0x00e0;
                case 257: goto L_0x00da;
                case 259: goto L_0x00cd;
                case 262: goto L_0x00c5;
                case 273: goto L_0x00c1;
                case 279: goto L_0x00bd;
                case 292: goto L_0x009e;
                case 324: goto L_0x009b;
                case 325: goto L_0x0098;
                default: goto L_0x0097;
            }     // Catch:{ all -> 0x0144 }
        L_0x0097:
            goto L_0x00e3
        L_0x0098:
            if (r14 != r7) goto L_0x00e3
            goto L_0x00bf
        L_0x009b:
            if (r14 != r7) goto L_0x00e3
            goto L_0x00c3
        L_0x009e:
            r7 = r15 & 1
            if (r7 == 0) goto L_0x00a4
            r9 = 50
        L_0x00a4:
            r7 = r15 & 4
            if (r7 != 0) goto L_0x00b5
            r7 = r15 & 2
            if (r7 != 0) goto L_0x00ad
            goto L_0x00e3
        L_0x00ad:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0144 }
            java.lang.String r1 = "CCITT Group 3 'fill bits before EOL' is not supported"
            r0.<init>(r1)     // Catch:{ all -> 0x0144 }
            throw r0     // Catch:{ all -> 0x0144 }
        L_0x00b5:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0144 }
            java.lang.String r1 = "CCITT Group 3 'uncompressed mode' is not supported"
            r0.<init>(r1)     // Catch:{ all -> 0x0144 }
            throw r0     // Catch:{ all -> 0x0144 }
        L_0x00bd:
            if (r14 != r7) goto L_0x00e3
        L_0x00bf:
            r11 = r15
            goto L_0x00e3
        L_0x00c1:
            if (r14 != r7) goto L_0x00e3
        L_0x00c3:
            r10 = r15
            goto L_0x00e3
        L_0x00c5:
            if (r15 != r7) goto L_0x00e3
            com.cyberneid.d.b.i r12 = com.cyberneid.p105d.p108b.C1613i.f4911T     // Catch:{ all -> 0x0144 }
            r1.mo7525a((com.cyberneid.p105d.p108b.C1613i) r12, (boolean) r7)     // Catch:{ all -> 0x0144 }
            goto L_0x00e3
        L_0x00cd:
            r7 = 4
            if (r15 != r7) goto L_0x00d2
            r7 = -1
            goto L_0x00d3
        L_0x00d2:
            r7 = r9
        L_0x00d3:
            r9 = 3
            if (r15 != r9) goto L_0x00d8
            r9 = 0
            goto L_0x00e3
        L_0x00d8:
            r9 = r7
            goto L_0x00e3
        L_0x00da:
            com.cyberneid.d.b.i r7 = com.cyberneid.p105d.p108b.C1613i.f5273gk     // Catch:{ all -> 0x0144 }
        L_0x00dc:
            r1.mo7518a((com.cyberneid.p105d.p108b.C1613i) r7, (int) r15)     // Catch:{ all -> 0x0144 }
            goto L_0x00e3
        L_0x00e0:
            com.cyberneid.d.b.i r7 = com.cyberneid.p105d.p108b.C1613i.f4930aL     // Catch:{ all -> 0x0144 }
            goto L_0x00dc
        L_0x00e3:
            int r8 = r8 + 1
            r7 = 50
            goto L_0x0074
        L_0x00e8:
            if (r9 == r6) goto L_0x011a
            if (r10 == 0) goto L_0x0110
            com.cyberneid.d.b.i r2 = com.cyberneid.p105d.p108b.C1613i.f5082dE     // Catch:{ all -> 0x0144 }
            r1.mo7518a((com.cyberneid.p105d.p108b.C1613i) r2, (int) r9)     // Catch:{ all -> 0x0144 }
            long r1 = (long) r10     // Catch:{ all -> 0x0144 }
            r0.mo7706a(r1)     // Catch:{ all -> 0x0144 }
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r2 = new byte[r1]     // Catch:{ all -> 0x0144 }
        L_0x00f9:
            int r3 = java.lang.Math.min(r1, r11)     // Catch:{ all -> 0x0144 }
            int r3 = r0.read(r2, r5, r3)     // Catch:{ all -> 0x0144 }
            if (r3 <= 0) goto L_0x010a
            int r11 = r11 - r3
            r4 = r17
            r4.write(r2, r5, r3)     // Catch:{ all -> 0x0142 }
            goto L_0x00f9
        L_0x010a:
            r4 = r17
            r17.close()
            return
        L_0x0110:
            r4 = r17
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = "First image in tiff is not a single tile/strip"
            r0.<init>(r1)     // Catch:{ all -> 0x0142 }
            throw r0     // Catch:{ all -> 0x0142 }
        L_0x011a:
            r4 = r17
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = "First image in tiff is not CCITT T4 or T6 compressed"
            r0.<init>(r1)     // Catch:{ all -> 0x0142 }
            throw r0     // Catch:{ all -> 0x0142 }
        L_0x0124:
            r4 = r17
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = "Not a valid tiff file"
            r0.<init>(r1)     // Catch:{ all -> 0x0142 }
            throw r0     // Catch:{ all -> 0x0142 }
        L_0x012e:
            r4 = r17
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = "Not a valid tiff file"
            r0.<init>(r1)     // Catch:{ all -> 0x0142 }
            throw r0     // Catch:{ all -> 0x0142 }
        L_0x0138:
            r4 = r17
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0142 }
            java.lang.String r1 = "Not a valid tiff file"
            r0.<init>(r1)     // Catch:{ all -> 0x0142 }
            throw r0     // Catch:{ all -> 0x0142 }
        L_0x0142:
            r0 = move-exception
            goto L_0x0147
        L_0x0144:
            r0 = move-exception
            r4 = r17
        L_0x0147:
            r17.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p122e.p125c.C1855a.m7695a(com.cyberneid.d.d.c, java.io.OutputStream, com.cyberneid.d.b.d, int):void");
    }

    /* renamed from: b */
    private static int m7696b(char c, C1656c cVar) {
        int read;
        int read2;
        if (c == 'I') {
            read = cVar.read() | (cVar.read() << 8) | (cVar.read() << 16);
            read2 = cVar.read() << 24;
        } else {
            read = (cVar.read() << 24) | (cVar.read() << 16) | (cVar.read() << 8);
            read2 = cVar.read();
        }
        return read | read2;
    }
}
