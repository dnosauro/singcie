package com.cyberneid.p105d.p114g.p120d;

import android.util.Log;
import com.cyberneid.p089b.p092c.C1532b;
import com.cyberneid.p089b.p095f.C1544ab;
import com.cyberneid.p089b.p095f.C1549b;
import com.cyberneid.p089b.p097h.C1586a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p111d.C1654a;
import com.cyberneid.p105d.p131h.C1940d;
import java.io.Closeable;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.d.m */
public class C1817m extends C1815k {

    /* renamed from: c */
    private final C1544ab f5870c;

    /* renamed from: d */
    private final int[] f5871d;

    /* renamed from: e */
    private final Map<Integer, Integer> f5872e;

    /* renamed from: f */
    private final boolean f5873f;

    /* renamed from: g */
    private final boolean f5874g;

    /* renamed from: h */
    private final boolean f5875h;

    /* renamed from: i */
    private final C1549b f5876i;

    /* renamed from: j */
    private C1940d f5877j;

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1817m(com.cyberneid.p105d.p108b.C1607d r6, com.cyberneid.p105d.p114g.p120d.C1828x r7) {
        /*
            r5 = this;
            r5.<init>(r6, r7)
            com.cyberneid.d.g.d.q r6 = r5.mo8146e()
            com.cyberneid.d.g.a.g r7 = r6.mo8209p()
            com.cyberneid.d.g.a.g r0 = r6.mo8210q()
            if (r7 != 0) goto L_0x0017
            if (r0 != 0) goto L_0x0017
            com.cyberneid.d.g.a.g r7 = r6.mo8208o()
        L_0x0017:
            r6 = 0
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L_0x0051
            com.cyberneid.b.f.x r0 = new com.cyberneid.b.f.x     // Catch:{ NullPointerException -> 0x0034, IOException -> 0x002b }
            r0.<init>(r2)     // Catch:{ NullPointerException -> 0x0034, IOException -> 0x002b }
            com.cyberneid.d.b.g r7 = r7.mo7958c()     // Catch:{ NullPointerException -> 0x0034, IOException -> 0x002b }
            com.cyberneid.b.f.ab r6 = r0.mo7333b((java.io.InputStream) r7)     // Catch:{ NullPointerException -> 0x0034, IOException -> 0x002b }
            goto L_0x00bb
        L_0x002b:
            r7 = move-exception
            java.lang.String r0 = "PdfBox-Android"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x003c
        L_0x0034:
            r7 = move-exception
            java.lang.String r0 = "PdfBox-Android"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x003c:
            java.lang.String r4 = "Could not read embedded TTF for font "
        L_0x003e:
            r3.append(r4)
            java.lang.String r4 = r5.mo8142b()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.w(r0, r3, r7)
            r7 = 1
            goto L_0x00bc
        L_0x0051:
            if (r0 == 0) goto L_0x00bb
            com.cyberneid.b.f.q r7 = new com.cyberneid.b.f.q     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            r7.<init>(r2)     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            com.cyberneid.d.b.g r0 = r0.mo7958c()     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            com.cyberneid.b.f.s r6 = r7.mo7333b((java.io.InputStream) r0)     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            boolean r7 = r6.mo7338f()     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            if (r7 != 0) goto L_0x008c
            boolean r7 = r6.mo7339g()     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            if (r7 == 0) goto L_0x00bb
            java.lang.String r7 = "PdfBox-Android"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            r0.<init>()     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            java.lang.String r3 = "OpenType Layout tables used in font "
            r0.append(r3)     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            java.lang.String r3 = r5.mo8142b()     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            r0.append(r3)     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            java.lang.String r3 = " are not implemented in PDFBox and will be ignored"
            r0.append(r3)     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            java.lang.String r0 = r0.toString()     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            android.util.Log.e(r7, r0)     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            goto L_0x00bb
        L_0x008c:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            r0.<init>()     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            java.lang.String r3 = "Not implemented: OpenType font with CFF table "
            r0.append(r3)     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            java.lang.String r3 = r5.mo8142b()     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            r0.append(r3)     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            java.lang.String r0 = r0.toString()     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            r7.<init>(r0)     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
            throw r7     // Catch:{ NullPointerException -> 0x00b0, IOException -> 0x00a7 }
        L_0x00a7:
            r7 = move-exception
            java.lang.String r0 = "PdfBox-Android"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            goto L_0x00b8
        L_0x00b0:
            r7 = move-exception
            java.lang.String r0 = "PdfBox-Android"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
        L_0x00b8:
            java.lang.String r4 = "Could not read embedded OTF for font "
            goto L_0x003e
        L_0x00bb:
            r7 = 0
        L_0x00bc:
            if (r6 == 0) goto L_0x00c0
            r0 = 1
            goto L_0x00c1
        L_0x00c0:
            r0 = 0
        L_0x00c1:
            r5.f5874g = r0
            r5.f5875h = r7
            if (r6 != 0) goto L_0x0115
            java.lang.String r6 = r5.mo8142b()
            com.cyberneid.d.g.d.q r7 = r5.mo8146e()
            com.cyberneid.d.g.d.o r0 = r5.mo8150i()
            com.cyberneid.d.g.d.a r6 = com.cyberneid.p105d.p114g.p120d.C1810h.m7346a(r6, r7, r0)
            boolean r7 = r6.mo8085b()
            if (r7 == 0) goto L_0x00e2
            com.cyberneid.b.b r7 = r6.mo8137c()
            goto L_0x00e6
        L_0x00e2:
            com.cyberneid.b.b r7 = r6.mo8084a()
        L_0x00e6:
            com.cyberneid.b.f.ab r7 = (com.cyberneid.p089b.p095f.C1544ab) r7
            boolean r6 = r6.mo8138d()
            if (r6 == 0) goto L_0x0114
            java.lang.String r6 = "PdfBox-Android"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "Using fallback font "
            r0.append(r3)
            java.lang.String r3 = r7.mo7033b()
            r0.append(r3)
            java.lang.String r3 = " for CID-keyed TrueType font "
            r0.append(r3)
            java.lang.String r3 = r5.mo8142b()
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r6, r0)
        L_0x0114:
            r6 = r7
        L_0x0115:
            r5.f5870c = r6
            com.cyberneid.b.f.ab r6 = r5.f5870c
            com.cyberneid.b.f.b r6 = r6.mo7179a((boolean) r1)
            r5.f5876i = r6
            int[] r6 = r5.m7391j()
            r5.f5871d = r6
            int[] r6 = r5.f5871d
            java.util.Map r6 = r5.m7390a(r6)
            r5.f5872e = r6
            com.cyberneid.d.b.d r6 = r5.f5855b
            com.cyberneid.d.b.i r7 = com.cyberneid.p105d.p108b.C1613i.f4968ax
            com.cyberneid.d.b.b r6 = r6.mo7539c((com.cyberneid.p105d.p108b.C1613i) r7)
            boolean r7 = r6 instanceof com.cyberneid.p105d.p108b.C1613i
            if (r7 == 0) goto L_0x0148
            com.cyberneid.d.b.i r6 = (com.cyberneid.p105d.p108b.C1613i) r6
            java.lang.String r6 = r6.mo7596a()
            java.lang.String r7 = "Identity"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0148
            r1 = 1
        L_0x0148:
            r5.f5873f = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p120d.C1817m.<init>(com.cyberneid.d.b.d, com.cyberneid.d.g.d.x):void");
    }

    /* renamed from: a */
    private Map<Integer, Integer> m7390a(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < iArr.length; i++) {
            hashMap.put(Integer.valueOf(iArr[i]), Integer.valueOf(i));
        }
        return hashMap;
    }

    /* renamed from: j */
    private int[] m7391j() {
        C1605b c = this.f5855b.mo7539c(C1613i.f4968ax);
        if (!(c instanceof C1619o)) {
            return null;
        }
        InputStream l = ((C1619o) c).mo7627l();
        byte[] a = C1654a.m6620a(l);
        C1654a.m6619a((Closeable) l);
        int length = a.length / 2;
        int[] iArr = new int[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = ((a[i] & 255) << 8) | (a[i + 1] & 255);
            i += 2;
        }
        return iArr;
    }

    /* renamed from: b */
    public float mo8141b(int i) {
        int a = this.f5870c.mo7178a(mo8152e(i));
        int v = this.f5870c.mo7202v();
        if (v != 1000) {
            a = (int) (((float) a) * (1000.0f / ((float) v)));
        }
        return (float) a;
    }

    /* renamed from: c */
    public int mo8143c(int i) {
        C1532b o = this.f5854a.mo8235o();
        return (o.mo7149a() || !o.mo7152b()) ? o.mo7150b(i) : o.mo7142a(i).codePointAt(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] mo8145d(int r5) {
        /*
            r4 = this;
            boolean r0 = r4.f5874g
            r1 = 0
            if (r0 == 0) goto L_0x0039
            com.cyberneid.d.g.d.x r0 = r4.f5854a
            com.cyberneid.b.c.b r0 = r0.mo8235o()
            java.lang.String r0 = r0.mo7153c()
            java.lang.String r2 = "Identity-"
            boolean r0 = r0.startsWith(r2)
            r2 = -1
            if (r0 == 0) goto L_0x0021
            com.cyberneid.b.f.b r0 = r4.f5876i
            if (r0 == 0) goto L_0x0034
            int r0 = r0.mo7206a((int) r5)
            goto L_0x0035
        L_0x0021:
            com.cyberneid.d.g.d.x r0 = r4.f5854a
            com.cyberneid.b.c.b r0 = r0.mo8236p()
            if (r0 == 0) goto L_0x0034
            com.cyberneid.d.g.d.x r0 = r4.f5854a
            com.cyberneid.b.c.b r0 = r0.mo8236p()
            int r0 = r0.mo7150b((int) r5)
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            if (r0 != r2) goto L_0x003f
            r0 = 0
            goto L_0x003f
        L_0x0039:
            com.cyberneid.b.f.b r0 = r4.f5876i
            int r0 = r0.mo7206a((int) r5)
        L_0x003f:
            r2 = 1
            r3 = 2
            if (r0 == 0) goto L_0x0052
            byte[] r5 = new byte[r3]
            int r3 = r0 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = (byte) r3
            r5[r1] = r3
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r5[r2] = r0
            return r5
        L_0x0052:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r3[r1] = r5
            java.lang.String r5 = r4.mo8144c()
            r3[r2] = r5
            java.lang.String r5 = "No glyph for U+%04X in font %s"
            java.lang.String r5 = java.lang.String.format(r5, r3)
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p120d.C1817m.mo8145d(int):byte[]");
    }

    /* renamed from: e */
    public int mo8152e(int i) {
        if (!this.f5874g) {
            boolean z = this.f5854a.mo8236p() != null;
            if (this.f5871d != null) {
                return this.f5871d[mo8143c(i)];
            } else if (this.f5873f || !z) {
                return mo8143c(i);
            } else {
                String e = this.f5854a.mo8165e(i);
                if (e == null) {
                    Log.w("PdfBox-Android", "Failed to find a character mapping for " + i + " in " + mo8144c());
                    return 0;
                }
                if (e.length() > 1) {
                    Log.w("PdfBox-Android", "Trying to map multi-byte character using 'cmap', result will be poor");
                }
                return this.f5876i.mo7206a(e.codePointAt(0));
            }
        } else {
            int c = mo8143c(i);
            int[] iArr = this.f5871d;
            if (iArr != null) {
                if (c < iArr.length) {
                    return iArr[c];
                }
                return 0;
            } else if (c < this.f5870c.mo7201u()) {
                return c;
            } else {
                return 0;
            }
        }
    }

    /* renamed from: f */
    public C1940d mo8147f() {
        if (this.f5877j == null) {
            this.f5877j = new C1940d(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
        }
        return this.f5877j;
    }

    /* renamed from: g */
    public C1586a mo8148g() {
        return this.f5870c.mo7035c();
    }

    /* renamed from: h */
    public boolean mo8149h() {
        return this.f5874g;
    }
}
