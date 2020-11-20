package com.cyberneid.p105d.p114g.p120d;

import android.graphics.PointF;
import android.util.Log;
import com.cyberneid.p089b.C1470a;
import com.cyberneid.p089b.C1479b;
import com.cyberneid.p089b.p096g.C1583d;
import com.cyberneid.p089b.p097h.C1586a;
import com.cyberneid.p099c.p100a.p101a.C1592a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p120d.p121a.C1789c;
import com.cyberneid.p105d.p114g.p120d.p121a.C1793g;
import com.cyberneid.p105d.p114g.p120d.p121a.C1794h;
import com.cyberneid.p105d.p114g.p120d.p121a.C1795i;
import com.cyberneid.p105d.p131h.C1940d;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.d.z */
public class C1830z extends C1826v {

    /* renamed from: e */
    public static final C1830z f5924e = new C1830z("Times-Roman");

    /* renamed from: f */
    public static final C1830z f5925f = new C1830z("Times-Bold");

    /* renamed from: g */
    public static final C1830z f5926g = new C1830z("Times-Italic");

    /* renamed from: h */
    public static final C1830z f5927h = new C1830z("Times-BoldItalic");

    /* renamed from: i */
    public static final C1830z f5928i = new C1830z("Helvetica");

    /* renamed from: j */
    public static final C1830z f5929j = new C1830z("Helvetica-Bold");

    /* renamed from: k */
    public static final C1830z f5930k = new C1830z("Helvetica-Oblique");

    /* renamed from: l */
    public static final C1830z f5931l = new C1830z("Helvetica-BoldOblique");

    /* renamed from: m */
    public static final C1830z f5932m = new C1830z("Courier");

    /* renamed from: n */
    public static final C1830z f5933n = new C1830z("Courier-Bold");

    /* renamed from: o */
    public static final C1830z f5934o = new C1830z("Courier-Oblique");

    /* renamed from: p */
    public static final C1830z f5935p = new C1830z("Courier-BoldOblique");

    /* renamed from: q */
    public static final C1830z f5936q = new C1830z("Symbol");

    /* renamed from: r */
    public static final C1830z f5937r = new C1830z("ZapfDingbats");

    /* renamed from: s */
    private static final Map<String, String> f5938s = new HashMap();

    /* renamed from: t */
    private final C1583d f5939t;

    /* renamed from: u */
    private final C1479b f5940u;

    /* renamed from: v */
    private final boolean f5941v;

    /* renamed from: w */
    private final boolean f5942w;

    /* renamed from: x */
    private C1940d f5943x;

    /* renamed from: y */
    private final C1592a f5944y;

    static {
        f5938s.put("ff", "f_f");
        f5938s.put("ffi", "f_f_i");
        f5938s.put("ffl", "f_f_l");
        f5938s.put("fi", "f_i");
        f5938s.put("fl", "f_l");
        f5938s.put("st", "s_t");
        f5938s.put("IJ", "I_J");
        f5938s.put("ij", "i_j");
        f5938s.put("ellipsis", "elipsis");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1830z(com.cyberneid.p105d.p108b.C1607d r9) {
        /*
            r8 = this;
            r8.<init>((com.cyberneid.p105d.p108b.C1607d) r9)
            com.cyberneid.d.g.d.q r9 = r8.mo8163b()
            r0 = 1
            r1 = 0
            r2 = 0
            if (r9 == 0) goto L_0x0093
            com.cyberneid.d.g.a.g r3 = r9.mo8210q()
            if (r3 != 0) goto L_0x008b
            com.cyberneid.d.g.a.g r3 = r9.mo8208o()
            if (r3 == 0) goto L_0x0093
            com.cyberneid.d.b.o r4 = r3.mo7959e()     // Catch:{ a -> 0x006f, IOException -> 0x0053 }
            com.cyberneid.d.b.i r5 = com.cyberneid.p105d.p108b.C1613i.f5096dS     // Catch:{ a -> 0x006f, IOException -> 0x0053 }
            int r5 = r4.mo7547g(r5)     // Catch:{ a -> 0x006f, IOException -> 0x0053 }
            com.cyberneid.d.b.i r6 = com.cyberneid.p105d.p108b.C1613i.f5097dT     // Catch:{ a -> 0x006f, IOException -> 0x0053 }
            int r4 = r4.mo7547g(r6)     // Catch:{ a -> 0x006f, IOException -> 0x0053 }
            byte[] r3 = r3.mo7961g()     // Catch:{ a -> 0x006f, IOException -> 0x0053 }
            int r5 = r8.m7546a(r3, r5)     // Catch:{ a -> 0x006f, IOException -> 0x0053 }
            int r6 = r3.length     // Catch:{ a -> 0x006f, IOException -> 0x0053 }
            if (r6 <= 0) goto L_0x0040
            byte r6 = r3[r1]     // Catch:{ a -> 0x006f, IOException -> 0x0053 }
            r6 = r6 & 255(0xff, float:3.57E-43)
            r7 = 128(0x80, float:1.794E-43)
            if (r6 != r7) goto L_0x0040
            com.cyberneid.b.g.d r2 = com.cyberneid.p089b.p096g.C1583d.m6227a((byte[]) r3)     // Catch:{ a -> 0x006f, IOException -> 0x0053 }
            goto L_0x0093
        L_0x0040:
            byte[] r6 = java.util.Arrays.copyOfRange(r3, r1, r5)     // Catch:{ a -> 0x006f, IOException -> 0x0053 }
            int r7 = r5 + r4
            byte[] r3 = java.util.Arrays.copyOfRange(r3, r5, r7)     // Catch:{ a -> 0x006f, IOException -> 0x0053 }
            if (r5 <= 0) goto L_0x0093
            if (r4 <= 0) goto L_0x0093
            com.cyberneid.b.g.d r2 = com.cyberneid.p089b.p096g.C1583d.m6228a(r6, r3)     // Catch:{ a -> 0x006f, IOException -> 0x0053 }
            goto L_0x0093
        L_0x0053:
            r3 = move-exception
            java.lang.String r4 = "PdfBox-Android"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Can't read the embedded Type1 font "
            r5.append(r6)
            java.lang.String r6 = r9.mo8198g()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r4, r5, r3)
            goto L_0x0089
        L_0x006f:
            java.lang.String r3 = "PdfBox-Android"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Can't read damaged embedded Type1 font "
            r4.append(r5)
            java.lang.String r5 = r9.mo8198g()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.w(r3, r4)
        L_0x0089:
            r3 = 1
            goto L_0x0094
        L_0x008b:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Use PDType1CFont for FontFile3"
            r9.<init>(r0)
            throw r9
        L_0x0093:
            r3 = 0
        L_0x0094:
            if (r2 == 0) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r0 = 0
        L_0x0098:
            r8.f5941v = r0
            r8.f5942w = r3
            r8.f5939t = r2
            com.cyberneid.b.g.d r0 = r8.f5939t
            if (r0 == 0) goto L_0x00a5
            r8.f5940u = r0
            goto L_0x00e1
        L_0x00a5:
            java.lang.String r0 = r8.mo8240u()
            com.cyberneid.d.g.d.i r9 = com.cyberneid.p105d.p114g.p120d.C1810h.m7357b((java.lang.String) r0, (com.cyberneid.p105d.p114g.p120d.C1821q) r9)
            com.cyberneid.b.b r0 = r9.mo8137c()
            r8.f5940u = r0
            boolean r9 = r9.mo8138d()
            if (r9 == 0) goto L_0x00e1
            java.lang.String r9 = "PdfBox-Android"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Using fallback font "
            r0.append(r1)
            com.cyberneid.b.b r1 = r8.f5940u
            java.lang.String r1 = r1.mo7033b()
            r0.append(r1)
            java.lang.String r1 = " for "
            r0.append(r1)
            java.lang.String r1 = r8.mo8240u()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r9, r0)
        L_0x00e1:
            r8.mo8102m()
            com.cyberneid.d.h.d r9 = r8.mo8101i()
            com.cyberneid.c.a.a.a r9 = r9.mo8478a()
            r8.f5944y = r9
            com.cyberneid.c.a.a.a r9 = r8.f5944y
            r0 = 4652007308841189376(0x408f400000000000, double:1000.0)
            r9.mo7415e(r0, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p120d.C1830z.<init>(com.cyberneid.d.b.d):void");
    }

    private C1830z(String str) {
        super(str);
        String str2;
        this.f5884b.mo7521a(C1613i.f5258gV, (C1605b) C1613i.f5340hy);
        this.f5884b.mo7523a(C1613i.f4900I, str);
        this.f5896c = new C1795i();
        this.f5884b.mo7521a(C1613i.f5053cc, (C1605b) C1613i.f5310hU);
        this.f5939t = null;
        C1813i<C1479b> b = C1810h.m7357b(mo8240u(), mo8163b());
        this.f5940u = b.mo8137c();
        if (b.mo8138d()) {
            try {
                str2 = this.f5940u.mo7033b();
            } catch (IOException unused) {
                str2 = "?";
            }
            Log.w("PdfBox-Android", "Using fallback font " + str2 + " for base font " + mo8240u());
        }
        this.f5941v = false;
        this.f5942w = false;
        this.f5944y = new C1592a();
    }

    /* renamed from: a */
    private int m7546a(byte[] bArr, int i) {
        int i2;
        int max = Math.max(0, i - 4);
        while (true) {
            if (i2 <= 0) {
                break;
            } else if (bArr[i2 + 0] == 101 && bArr[i2 + 1] == 120 && bArr[i2 + 2] == 101 && bArr[i2 + 3] == 99) {
                i2 += 4;
                while (i2 < i && (bArr[i2] == 13 || bArr[i2] == 10 || bArr[i2] == 32)) {
                    i2++;
                }
            } else {
                max = i2 - 1;
            }
        }
        if (i - i2 == 0 || i2 <= 0) {
            return i;
        }
        Log.w("PdfBox-Android", "Ignored invalid Length1 for Type 1 font " + mo8099f());
        return i2;
    }

    /* renamed from: c */
    private String m7547c(String str) {
        if (mo8098e() || this.f5940u.mo7034b(str)) {
            return str;
        }
        String str2 = f5938s.get(str);
        if (str2 != null && !str.equals(".notdef") && this.f5940u.mo7034b(str2)) {
            return str2;
        }
        String a = mo8225p().mo8093a(str);
        if (a != null && a.length() == 1) {
            String format = String.format("uni%04X", new Object[]{Integer.valueOf(a.codePointAt(0))});
            if (this.f5940u.mo7034b(format)) {
                return format;
            }
        }
        return ".notdef";
    }

    /* renamed from: a */
    public int mo8095a(InputStream inputStream) {
        return inputStream.read();
    }

    /* renamed from: c */
    public float mo8096c(int i) {
        String g = mo8239g(i);
        if (!this.f5941v && g.equals(".notdef")) {
            return 250.0f;
        }
        PointF pointF = new PointF(this.f5940u.mo7032a_(g), 0.0f);
        this.f5944y.mo7402a(pointF, pointF);
        return pointF.x;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public byte[] mo8097d(int i) {
        if (i <= 255) {
            String a = mo8225p().mo8092a(i);
            String c = m7547c(a);
            Map<String, Integer> q = mo8226q();
            if (c.equals(".notdef") || !this.f5940u.mo7034b(c)) {
                throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s", new Object[]{Integer.valueOf(i), mo8099f()}));
            }
            return new byte[]{(byte) q.get(a).intValue()};
        }
        throw new IllegalArgumentException("This font type only supports 8-bit code points");
    }

    /* renamed from: e */
    public boolean mo8098e() {
        return this.f5941v;
    }

    /* renamed from: f */
    public String mo8099f() {
        return mo8240u();
    }

    /* renamed from: g */
    public C1586a mo8100g() {
        return this.f5940u.mo7035c();
    }

    /* renamed from: g */
    public String mo8239g(int i) {
        return m7547c(mo8224o().mo8088a(i));
    }

    /* renamed from: i */
    public final C1940d mo8101i() {
        if (this.f5943x == null) {
            List<Number> list = null;
            try {
                list = this.f5940u.mo7036d();
            } catch (IOException unused) {
                this.f5943x = f5883a;
            }
            if (list == null || list.size() != 6) {
                return super.mo8101i();
            }
            this.f5943x = new C1940d(list.get(0).floatValue(), list.get(1).floatValue(), list.get(2).floatValue(), list.get(3).floatValue(), list.get(4).floatValue(), list.get(5).floatValue());
        }
        return this.f5943x;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public C1789c mo8103n() {
        if (mo8157a() != null) {
            return new C1794h(mo8157a());
        }
        C1479b bVar = this.f5940u;
        return bVar instanceof C1470a ? C1794h.m7261a(((C1470a) bVar).mo6952a()) : C1793g.f5808c;
    }

    /* renamed from: u */
    public final String mo8240u() {
        return this.f5884b.mo7544e(C1613i.f4900I);
    }
}
