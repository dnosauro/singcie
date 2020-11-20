package com.cyberneid.p105d.p114g.p122e.p125c;

import com.cyberneid.p099c.p102b.p103a.p104a.C1599e;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1612h;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p109c.C1647i;
import com.cyberneid.p105d.p109c.C1648j;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p115a.C1764g;
import com.cyberneid.p105d.p114g.p122e.p123a.C1838f;
import com.cyberneid.p105d.p114g.p122e.p123a.C1841i;
import com.cyberneid.p105d.p114g.p122e.p123a.C1845m;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.cyberneid.d.g.e.c.f */
final class C1862f {

    /* renamed from: a */
    private static final int[] f6006a = new int[256];

    /* renamed from: com.cyberneid.d.g.e.c.f$a */
    static final class C1864a {

        /* renamed from: a */
        byte[] f6007a;

        /* renamed from: b */
        int f6008b;

        /* renamed from: c */
        int f6009c;

        /* renamed from: d */
        int f6010d;

        /* renamed from: e */
        int f6011e;

        C1864a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public byte[] mo8308a() {
            byte[] bArr = this.f6007a;
            int i = this.f6010d;
            return Arrays.copyOfRange(bArr, i, this.f6011e + i);
        }
    }

    /* renamed from: com.cyberneid.d.g.e.c.f$b */
    private static class C1865b extends InputStream {

        /* renamed from: a */
        List<InputStream> f6012a;

        /* renamed from: b */
        int f6013b;

        /* renamed from: c */
        InputStream f6014c;

        private C1865b() {
            this.f6012a = new ArrayList();
        }

        /* renamed from: a */
        private boolean m7737a() {
            if (this.f6014c != null) {
                return true;
            }
            if (this.f6013b >= this.f6012a.size()) {
                return false;
            }
            List<InputStream> list = this.f6012a;
            int i = this.f6013b;
            this.f6013b = i + 1;
            this.f6014c = list.get(i);
            return true;
        }

        public int available() {
            return !m7737a() ? 0 : 1;
        }

        public int read() {
            throw new IllegalStateException("Only bulk reads are expected!");
        }

        public int read(byte[] bArr, int i, int i2) {
            if (!m7737a()) {
                return -1;
            }
            int read = this.f6014c.read(bArr, i, i2);
            if (read != -1) {
                return read;
            }
            this.f6014c = null;
            return read(bArr, i, i2);
        }
    }

    /* renamed from: com.cyberneid.d.g.e.c.f$c */
    static final class C1866c {

        /* renamed from: a */
        List<C1864a> f6015a = new ArrayList();

        /* renamed from: b */
        C1864a f6016b;

        /* renamed from: c */
        C1864a f6017c;

        /* renamed from: d */
        C1864a f6018d;

        /* renamed from: e */
        C1864a f6019e;

        /* renamed from: f */
        C1864a f6020f;

        /* renamed from: g */
        C1864a f6021g;

        /* renamed from: h */
        C1864a f6022h;

        /* renamed from: i */
        int f6023i;

        /* renamed from: j */
        int f6024j;

        /* renamed from: k */
        int f6025k;

        C1866c() {
        }
    }

    static {
        m7727a();
    }

    /* renamed from: a */
    private static int m7719a(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << Tnaf.POW_2_WIDTH) | ((bArr[i + 2] & 255) << 8);
    }

    /* renamed from: a */
    static int m7720a(byte[] bArr, int i, int i2) {
        return ~m7732b(bArr, i, i2);
    }

    /* renamed from: a */
    private static C1607d m7721a(C1866c cVar, C1838f fVar) {
        C1607d dVar = new C1607d();
        dVar.mo7521a(C1613i.f4907P, (C1605b) C1612h.m6455a((long) cVar.f6025k));
        dVar.mo7521a(C1613i.f5189fF, (C1605b) C1612h.m6455a(15));
        dVar.mo7521a(C1613i.f4930aL, (C1605b) C1612h.m6455a((long) cVar.f6023i));
        dVar.mo7521a(C1613i.f4928aJ, (C1605b) C1612h.m6455a((long) fVar.mo8259c()));
        return dVar;
    }

    /* renamed from: a */
    static C1613i m7722a(int i) {
        switch (i) {
            case 0:
                return C1613i.f5148eR;
            case 1:
                return C1613i.f5149eS;
            case 2:
                return C1613i.f5150eT;
            case 3:
                return C1613i.f5151eU;
            default:
                return null;
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private static C1861e m7723a(C1783c cVar, C1861e eVar, C1866c cVar2) {
        C1647i a = C1648j.f5455a.mo7694a(C1613i.f5028cD);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C1607d a2 = m7721a(cVar2, (C1838f) C1841i.f5963a);
        C1607d dVar = new C1607d();
        dVar.mo7521a(C1613i.f5074cx, (C1605b) C1613i.f5028cD);
        dVar.mo7521a(C1613i.f5003bf, (C1605b) a2);
        a.mo7657a(m7734b(cVar2), byteArrayOutputStream, dVar, 0);
        byte[] bArr = new byte[(eVar.mo8306f() * eVar.mo8305e())];
        byte[] a3 = cVar2.f6019e.mo8308a();
        C1599e eVar2 = new C1599e(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        try {
            int i = cVar2.f6025k;
            int i2 = (cVar2.f6023i * i) % 8;
            int i3 = 0;
            for (int i4 = 0; i4 < bArr.length; i4++) {
                int a4 = (int) eVar2.mo7419a(i);
                bArr[i4] = a4 < a3.length ? a3[a4] : -1;
                i3++;
                if (i3 == cVar2.f6023i) {
                    eVar2.mo7419a(i2);
                    i3 = 0;
                }
            }
            eVar2.mo7420a();
            return C1859c.m7706a(cVar, bArr, eVar.mo8306f(), eVar.mo8305e(), 8, C1841i.f5963a);
        } catch (Throwable th) {
            eVar2.mo7420a();
            throw th;
        }
    }

    /* renamed from: a */
    private static C1861e m7724a(C1783c cVar, C1866c cVar2) {
        PrintStream printStream;
        String str;
        Object[] objArr;
        String str2;
        C1864a aVar = cVar2.f6016b;
        int i = aVar.f6010d;
        int a = m7719a(aVar.f6007a, i);
        int a2 = m7719a(aVar.f6007a, i + 4);
        byte b = aVar.f6007a[i + 8] & 255;
        byte b2 = aVar.f6007a[i + 9] & 255;
        byte b3 = aVar.f6007a[i + 10] & 255;
        byte b4 = aVar.f6007a[i + 11] & 255;
        byte b5 = aVar.f6007a[i + 12] & 255;
        if (b != 1 && b != 2 && b != 4 && b != 8 && b != 16) {
            printStream = System.out;
            str = "Invalid bit depth %d.";
            objArr = new Object[]{Integer.valueOf(b)};
        } else if (a <= 0 || a2 <= 0) {
            printStream = System.out;
            str = "Invalid image size %d x %d";
            objArr = new Object[]{Integer.valueOf(a), Integer.valueOf(a2)};
        } else if (b3 != 0) {
            printStream = System.out;
            str = "Unknown PNG compression method %d.";
            objArr = new Object[]{Integer.valueOf(b3)};
        } else if (b4 != 0) {
            printStream = System.out;
            str = "Unknown PNG filtering method %d.";
            objArr = new Object[]{Integer.valueOf(b3)};
        } else {
            if (b5 != 0) {
                printStream = System.out;
                str2 = String.format("Can't handle interlace method %d.", new Object[]{Integer.valueOf(b5)});
            } else {
                cVar2.f6023i = a;
                cVar2.f6024j = a2;
                cVar2.f6025k = b;
                if (b2 == 0) {
                    printStream = System.out;
                    str2 = "Can't handle grayscale yet.";
                } else if (b2 != 6) {
                    switch (b2) {
                        case 2:
                            if (cVar2.f6019e != null) {
                                printStream = System.out;
                                str2 = "Can't handle images with transparent colors.";
                                break;
                            } else {
                                return m7735c(cVar, cVar2);
                            }
                        case 3:
                            return m7733b(cVar, cVar2);
                        case 4:
                            printStream = System.out;
                            str2 = "Can't handle grayscale with alpha, would need to separate alpha from image data";
                            break;
                        default:
                            printStream = System.out;
                            str2 = "Unknown PNG color type " + b2;
                            break;
                    }
                } else {
                    printStream = System.out;
                    str2 = "Can't handle truecolor with alpha, would need to separate alpha from image data";
                }
            }
            printStream.println(str2);
            return null;
        }
        str2 = String.format(str, objArr);
        printStream.println(str2);
        return null;
    }

    /* renamed from: a */
    static C1861e m7725a(C1783c cVar, byte[] bArr) {
        C1866c a = m7726a(bArr);
        if (!m7730a(a)) {
            return null;
        }
        return m7724a(cVar, a);
    }

    /* renamed from: a */
    private static C1866c m7726a(byte[] bArr) {
        PrintStream printStream;
        String str;
        if (bArr.length < 20) {
            PrintStream printStream2 = System.out;
            printStream2.println("ByteArray way to small: " + bArr.length);
            return null;
        }
        C1866c cVar = new C1866c();
        int a = m7719a(bArr, 12);
        if (a != 1229472850) {
            System.out.println(String.format("First Chunktype was %08X, not IHDR", new Object[]{Integer.valueOf(a)}));
            return null;
        }
        int i = 8;
        while (i + 12 <= bArr.length) {
            int a2 = m7719a(bArr, i);
            int a3 = m7719a(bArr, i + 4);
            int i2 = i + 8;
            int i3 = i2 + a2;
            int i4 = i3 + 4;
            if (i4 > bArr.length) {
                PrintStream printStream3 = System.out;
                printStream3.println("Not enough bytes. At offset " + i2 + " are " + a2 + " bytes expected. Overall length is " + bArr.length);
                return null;
            }
            C1864a aVar = new C1864a();
            aVar.f6008b = a3;
            aVar.f6007a = bArr;
            aVar.f6010d = i2;
            aVar.f6011e = a2;
            switch (a3) {
                case 1229209940:
                    cVar.f6015a.add(aVar);
                    continue;
                case 1229278788:
                    return cVar;
                case 1229472850:
                    if (cVar.f6016b != null) {
                        System.out.println("Two IHDR chunks? There is something wrong.");
                        return null;
                    }
                    cVar.f6016b = aVar;
                    continue;
                case 1347179589:
                    if (cVar.f6017c != null) {
                        System.out.println("Two PLTE chunks? There is something wrong.");
                        return null;
                    }
                    cVar.f6017c = aVar;
                    continue;
                case 1665684045:
                    cVar.f6022h = aVar;
                    continue;
                case 1732332865:
                    cVar.f6021g = aVar;
                    continue;
                case 1749635924:
                case 1767135348:
                case 1799506759:
                case 1883789683:
                case 1934642260:
                case 1950701684:
                case 1950960965:
                case 2052348020:
                    break;
                case 1766015824:
                    cVar.f6018d = aVar;
                    continue;
                case 1933723988:
                    printStream = System.out;
                    str = "Can't convert PNGs with sBIT chunk.";
                    break;
                case 1934772034:
                    cVar.f6020f = aVar;
                    continue;
                case 1951551059:
                    if (cVar.f6019e != null) {
                        System.out.println("Two tRNS chunks? There is something wrong.");
                        return null;
                    }
                    cVar.f6019e = aVar;
                    continue;
                default:
                    printStream = System.out;
                    str = String.format("Unknown chunk type %08X, skipping.", new Object[]{Integer.valueOf(a3)});
                    break;
            }
            printStream.println(str);
            aVar.f6009c = m7719a(bArr, i3);
            i = i4;
        }
        System.out.println("No IEND chunk found.");
        return null;
    }

    /* renamed from: a */
    private static void m7727a() {
        for (int i = 0; i < 256; i++) {
            int i2 = i;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 = (i2 & 1) != 0 ? (i2 >>> 1) ^ -306674912 : i2 >>> 1;
            }
            f6006a[i] = i2;
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: a */
    private static void m7728a(C1783c cVar, C1864a aVar, C1861e eVar, int i) {
        C1604a aVar2 = new C1604a();
        aVar2.mo7490a((C1605b) C1613i.f5123dt);
        aVar2.mo7491a((C1760c) eVar.mo8299a());
        ((C1607d) eVar.mo8251b().mo7554k(C1613i.f5003bf)).mo7521a(C1613i.f4928aJ, (C1605b) C1612h.f4887b);
        aVar2.mo7490a((C1605b) C1612h.m6455a((long) i));
        C1764g gVar = new C1764g(cVar);
        OutputStream a = gVar.mo7956a(C1613i.f5028cD);
        try {
            a.write(aVar.f6007a, aVar.f6010d, aVar.f6011e);
            a.close();
            aVar2.mo7491a((C1760c) gVar);
        } catch (Throwable th) {
            a.close();
            throw th;
        }
    }

    /* renamed from: a */
    static boolean m7729a(C1864a aVar) {
        if (aVar == null) {
            return true;
        }
        if (aVar.f6010d + aVar.f6011e > aVar.f6007a.length || aVar.f6010d < 4) {
            return false;
        }
        int a = m7720a(aVar.f6007a, aVar.f6010d - 4, aVar.f6011e + 4);
        if (a == aVar.f6009c) {
            return true;
        }
        System.out.println(String.format("Invalid CRC %08X on chunk %08X, expected %08X.", new Object[]{Integer.valueOf(a), Integer.valueOf(aVar.f6008b), Integer.valueOf(aVar.f6009c)}));
        return false;
    }

    /* renamed from: a */
    static boolean m7730a(C1866c cVar) {
        PrintStream printStream;
        String str;
        if (cVar == null) {
            return false;
        }
        if (cVar.f6016b == null || !m7729a(cVar.f6016b)) {
            printStream = System.out;
            str = "Invalid IHDR chunk.";
        } else if (!m7729a(cVar.f6017c)) {
            printStream = System.out;
            str = "Invalid PLTE chunk.";
        } else if (!m7729a(cVar.f6018d)) {
            printStream = System.out;
            str = "Invalid iCCP chunk.";
        } else if (!m7729a(cVar.f6019e)) {
            printStream = System.out;
            str = "Invalid tRNS chunk.";
        } else if (!m7729a(cVar.f6020f)) {
            printStream = System.out;
            str = "Invalid sRGB chunk.";
        } else if (!m7729a(cVar.f6022h)) {
            printStream = System.out;
            str = "Invalid cHRM chunk.";
        } else if (!m7729a(cVar.f6021g)) {
            printStream = System.out;
            str = "Invalid gAMA chunk.";
        } else if (cVar.f6015a.isEmpty()) {
            printStream = System.out;
            str = "No IDAT chunks.";
        } else {
            for (C1864a a : cVar.f6015a) {
                if (!m7729a(a)) {
                    printStream = System.out;
                    str = "Invalid IDAT chunk.";
                }
            }
            return true;
        }
        printStream.println(str);
        return false;
    }

    /* renamed from: b */
    private static float m7731b(byte[] bArr, int i) {
        return ((float) m7719a(bArr, i)) / 100000.0f;
    }

    /* renamed from: b */
    private static int m7732b(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        byte b = -1;
        while (i < i3) {
            b = (b >>> 8) ^ f6006a[(bArr[i] ^ b) & 255];
            i++;
        }
        return b;
    }

    /* renamed from: b */
    private static C1861e m7733b(C1783c cVar, C1866c cVar2) {
        PrintStream printStream;
        String format;
        C1864a aVar = cVar2.f6017c;
        if (aVar == null) {
            printStream = System.out;
            format = "Indexed image without PLTE chunk.";
        } else if (aVar.f6011e % 3 != 0) {
            printStream = System.out;
            format = "PLTE table corrupted, last (r,g,b) tuple is not complete.";
        } else if (cVar2.f6025k > 8) {
            printStream = System.out;
            format = String.format("Can only convert indexed images with bit depth <= 8, not %d.", new Object[]{Integer.valueOf(cVar2.f6025k)});
        } else {
            C1861e c = m7735c(cVar, cVar2);
            if (c == null) {
                return null;
            }
            int i = (aVar.f6011e / 3) - 1;
            if (i > 255) {
                printStream = System.out;
                format = String.format("To much colors in PLTE, only 256 allowed, found %d colors.", new Object[]{Integer.valueOf(i + 1)});
            } else {
                m7728a(cVar, aVar, c, i);
                if (cVar2.f6019e != null) {
                    c.mo8251b().mo7522a(C1613i.f5238gB, (C1760c) m7723a(cVar, c, cVar2));
                }
                return c;
            }
        }
        printStream.println(format);
        return null;
    }

    /* renamed from: b */
    private static InputStream m7734b(C1866c cVar) {
        C1865b bVar = new C1865b();
        for (C1864a next : cVar.f6015a) {
            bVar.f6012a.add(new ByteArrayInputStream(next.f6007a, next.f6010d, next.f6011e));
        }
        return bVar;
    }

    /* renamed from: c */
    private static C1861e m7735c(C1783c cVar, C1866c cVar2) {
        PrintStream printStream;
        String str;
        Object[] objArr;
        PrintStream printStream2;
        String str2;
        StringBuilder sb;
        C1864a aVar;
        InputStream b = m7734b(cVar2);
        C1845m mVar = C1845m.f5975a;
        C1861e eVar = new C1861e(cVar, b, C1613i.f5028cD, cVar2.f6023i, cVar2.f6024j, cVar2.f6025k, mVar);
        eVar.mo8251b().mo7521a(C1613i.f5003bf, (C1605b) m7721a(cVar2, (C1838f) mVar));
        boolean z = (cVar2.f6020f == null && cVar2.f6018d == null) ? false : true;
        if (cVar2.f6021g != null && !z) {
            if (cVar2.f6021g.f6011e != 4) {
                printStream2 = System.out;
                sb = new StringBuilder();
                sb.append("Invalid gAMA chunk length ");
                aVar = cVar2.f6021g;
                sb.append(aVar.f6011e);
                str2 = sb.toString();
                printStream2.println(str2);
                return null;
            }
            float b2 = m7731b(cVar2.f6021g.f6007a, cVar2.f6021g.f6010d);
            if (((double) Math.abs(b2 - 0.45454544f)) > 1.0E-5d) {
                printStream = System.out;
                str = "We can't handle gamma of %f yet.";
                objArr = new Object[]{Float.valueOf(b2)};
                str2 = String.format(str, objArr);
                printStream2.println(str2);
                return null;
            }
        }
        if (cVar2.f6020f != null) {
            if (cVar2.f6020f.f6011e != 1) {
                printStream2 = System.out;
                str2 = String.format("sRGB chunk has an invalid length of %d", new Object[]{Integer.valueOf(cVar2.f6020f.f6011e)});
                printStream2.println(str2);
                return null;
            }
            eVar.mo8251b().mo7521a(C1613i.f5147eQ, (C1605b) m7722a((int) cVar2.f6020f.f6007a[cVar2.f6020f.f6010d]));
        }
        if (cVar2.f6022h == null || z) {
            if (!(cVar2.f6018d == null && cVar2.f6020f == null)) {
                C1619o a = new C1764g(cVar).mo7505d();
                a.mo7518a(C1613i.f5180ex, mVar.mo8259c());
                a.mo7521a(C1613i.f5352n, (C1605b) mVar.mo8259c() == 1 ? C1613i.f5015br : C1613i.f5017bt);
                if (cVar2.f6018d != null) {
                    int i = 0;
                    while (i < 80 && i < cVar2.f6018d.f6011e && cVar2.f6018d.f6007a[cVar2.f6018d.f6010d + i] != 0) {
                        i++;
                    }
                    if (i >= cVar2.f6018d.f6011e) {
                        printStream2 = System.out;
                        str2 = "Invalid iCCP chunk, to few bytes";
                        printStream2.println(str2);
                        return null;
                    }
                    byte b3 = cVar2.f6018d.f6007a[cVar2.f6018d.f6010d + i];
                    if (b3 != 0) {
                        printStream = System.out;
                        str = "iCCP chunk: invalid compression method %d";
                        objArr = new Object[]{Byte.valueOf(b3)};
                        str2 = String.format(str, objArr);
                        printStream2.println(str2);
                        return null;
                    }
                    int i2 = i + 1;
                    OutputStream p = a.mo7631p();
                    try {
                        p.write(cVar2.f6018d.f6007a, cVar2.f6018d.f6010d + i2, cVar2.f6018d.f6011e - i2);
                    } finally {
                        p.close();
                    }
                }
                eVar.mo8302a(C1838f.m7589a((C1605b) C1613i.f5017bt));
            }
            return eVar;
        } else if (cVar2.f6022h.f6011e != 32) {
            printStream2 = System.out;
            sb = new StringBuilder();
            sb.append("Invalid cHRM chunk length ");
            aVar = cVar2.f6022h;
            sb.append(aVar.f6011e);
            str2 = sb.toString();
            printStream2.println(str2);
            return null;
        } else {
            printStream2 = System.out;
            str2 = "We can not handle cHRM chunks yet.";
            printStream2.println(str2);
            return null;
        }
    }
}
