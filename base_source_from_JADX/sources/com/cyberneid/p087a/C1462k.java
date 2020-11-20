package com.cyberneid.p087a;

import com.cyberneid.p087a.p088a.C1452a;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p111d.C1654a;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.p115a.C1763f;
import com.cyberneid.p105d.p114g.p120d.C1820p;
import com.cyberneid.p105d.p114g.p126f.p129c.C1895b;
import com.cyberneid.p105d.p114g.p126f.p129c.C1896c;
import com.cyberneid.p105d.p114g.p126f.p129c.C1897d;
import com.cyberneid.p105d.p114g.p126f.p129c.C1898e;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import org.spongycastle.cert.X509CertificateHolder;

/* renamed from: com.cyberneid.a.k */
public class C1462k {

    /* renamed from: a */
    public static String f4330a = "adbe.pkcs7.detached";

    /* renamed from: b */
    public static String f4331b = "ETSI.CAdES.detached";

    /* renamed from: c */
    C1783c f4332c;

    /* renamed from: d */
    ByteArrayOutputStream f4333d = new ByteArrayOutputStream();

    /* renamed from: e */
    ByteArrayOutputStream f4334e = new ByteArrayOutputStream();

    /* renamed from: f */
    C1896c f4335f;

    /* renamed from: g */
    C1460i f4336g;

    /* renamed from: h */
    C1454c f4337h;

    /* renamed from: i */
    boolean f4338i;

    /* renamed from: j */
    boolean f4339j;

    /* renamed from: k */
    C1468p f4340k;

    /* renamed from: l */
    X509CertificateHolder f4341l;

    /* renamed from: m */
    C1898e f4342m;

    /* renamed from: n */
    private final int f4343n = 9000;

    /* renamed from: com.cyberneid.a.k$a */
    public static class C1463a {

        /* renamed from: a */
        int f4344a;

        /* renamed from: b */
        int f4345b;

        /* renamed from: c */
        int f4346c;

        /* renamed from: d */
        int f4347d;

        /* renamed from: a */
        public int mo6931a() {
            return this.f4344a;
        }

        /* renamed from: a */
        public void mo6932a(int i) {
            this.f4344a = i;
        }

        /* renamed from: b */
        public int mo6933b() {
            return this.f4345b;
        }

        /* renamed from: b */
        public void mo6934b(int i) {
            this.f4345b = i;
        }

        /* renamed from: c */
        public int mo6935c() {
            return this.f4346c;
        }

        /* renamed from: c */
        public void mo6936c(int i) {
            this.f4346c = i;
        }

        /* renamed from: d */
        public int mo6937d() {
            return this.f4347d;
        }

        /* renamed from: d */
        public void mo6938d(int i) {
            this.f4347d = i;
        }
    }

    public C1462k() {
    }

    public C1462k(C1783c cVar) {
        this.f4332c = cVar;
    }

    /* renamed from: a */
    private C1763f m5506a(C1783c cVar, C1463a aVar, int i) {
        float a = (float) aVar.mo6931a();
        float b = (float) aVar.mo6933b();
        C1763f g = cVar.mo8054a(i).mo8248g();
        C1763f fVar = new C1763f();
        fVar.mo7943a(a);
        fVar.mo7947c(a + ((float) aVar.mo6935c()));
        fVar.mo7945b((g.mo7953i() - b) - ((float) aVar.mo6937d()));
        fVar.mo7948d(g.mo7953i() - b);
        return fVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01d2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01d3, code lost:
        r1 = r0;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01d6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01d7, code lost:
        r7 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01d9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01da, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01d2 A[ExcHandler: all (r0v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0011] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.InputStream m5507a(com.cyberneid.p105d.p114g.C1783c r19, int r20, com.cyberneid.p105d.p114g.p115a.C1763f r21, com.cyberneid.p105d.p114g.p120d.C1820p r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, byte[] r27) {
        /*
            r18 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            com.cyberneid.d.g.c r6 = new com.cyberneid.d.g.c
            r6.<init>()
            com.cyberneid.d.g.e r8 = new com.cyberneid.d.g.e     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.g.e r9 = r19.mo8054a((int) r20)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.g.a.f r9 = r9.mo8247f()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r8.<init>(r9)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r6.mo8057a((com.cyberneid.p105d.p114g.C1831e) r8)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.g.f.d.d r8 = new com.cyberneid.d.g.f.d.d     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r8.<init>(r6)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.g.d r9 = r6.mo8062b()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r9.mo8079a((com.cyberneid.p105d.p114g.p126f.p130d.C1903d) r8)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.g.f.d.p r9 = new com.cyberneid.d.g.f.d.p     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r9.<init>(r8)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            java.util.List r10 = r9.mo8423n()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r11 = 0
            java.lang.Object r10 = r10.get(r11)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.g.f.b.l r10 = (com.cyberneid.p105d.p114g.p126f.p128b.C1888l) r10     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            java.util.List r12 = r8.mo8398c()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r13 = 1
            r8.mo8395a((boolean) r13)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r8.mo8397b(r13)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.b.d r8 = r8.mo7505d()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r8.mo7504a((boolean) r13)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r12.add(r9)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r8 = r21
            r10.mo8339a((com.cyberneid.p105d.p114g.p115a.C1763f) r8)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.g.a.g r9 = new com.cyberneid.d.g.a.g     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r9.<init>((com.cyberneid.p105d.p114g.C1783c) r6)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.g.e.b.a r12 = new com.cyberneid.d.g.e.b.a     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r12.<init>((com.cyberneid.p105d.p114g.p115a.C1764g) r9)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.g.h r9 = new com.cyberneid.d.g.h     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r9.<init>()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r12.mo8295a((com.cyberneid.p105d.p114g.C1931h) r9)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r12.mo8292a((int) r13)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.g.a.f r9 = new com.cyberneid.d.g.a.f     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            float r14 = r21.mo7952h()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            float r15 = r21.mo7953i()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r9.<init>(r14, r15)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            float r14 = r9.mo7953i()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            float r15 = r9.mo7952h()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r12.mo8294a((com.cyberneid.p105d.p114g.p115a.C1763f) r9)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.g.f.b.n r9 = new com.cyberneid.d.g.f.b.n     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r9.<init>()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.b.d r7 = r9.mo7505d()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r7.mo7504a((boolean) r13)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.g.f.b.p r7 = new com.cyberneid.d.g.f.b.p     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.b.o r12 = r12.mo8251b()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r7.<init>((com.cyberneid.p105d.p108b.C1619o) r12)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r9.mo8354a(r7)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r10.mo8341a((com.cyberneid.p105d.p114g.p126f.p128b.C1890n) r9)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            com.cyberneid.d.g.f r9 = new com.cyberneid.d.g.f     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r9.<init>((com.cyberneid.p105d.p114g.C1783c) r6, (com.cyberneid.p105d.p114g.p126f.p128b.C1892p) r7)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r9.mo8327c()     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r7 = 0
            if (r5 == 0) goto L_0x012b
            java.lang.String r10 = "image"
            com.cyberneid.d.g.e.c.e r5 = com.cyberneid.p105d.p114g.p122e.p125c.C1861e.m7709a(r6, r5, r10)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            float r10 = r21.mo7953i()     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            int r12 = r5.mo8305e()     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            float r12 = (float) r12     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            float r10 = r10 / r12
            float r12 = r21.mo7952h()     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            int r13 = r5.mo8306f()     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            float r13 = (float) r13     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            float r12 = r12 / r13
            int r13 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r13 <= 0) goto L_0x00c9
            r10 = r12
        L_0x00c9:
            com.cyberneid.d.h.d r10 = com.cyberneid.p105d.p131h.C1940d.m7988a(r10, r10)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r9.mo8323a((com.cyberneid.p105d.p131h.C1940d) r10)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r9.mo8321a((com.cyberneid.p105d.p114g.p122e.p125c.C1861e) r5, (float) r7, (float) r7)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            java.io.PrintStream r10 = java.lang.System.out     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            java.lang.String r12 = "box: w: %f, h: %f, rect: w: %f, h: %f"
            r13 = 4
            java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            java.lang.Float r16 = java.lang.Float.valueOf(r15)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r13[r11] = r16     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            java.lang.Float r16 = java.lang.Float.valueOf(r14)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r17 = 1
            r13[r17] = r16     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            float r16 = r21.mo7952h()     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            java.lang.Float r16 = java.lang.Float.valueOf(r16)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r7 = 2
            r13[r7] = r16     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r16 = 3
            float r8 = r21.mo7953i()     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            java.lang.Float r8 = java.lang.Float.valueOf(r8)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r13[r16] = r8     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            java.lang.String r8 = java.lang.String.format(r12, r13)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r10.println(r8)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            java.io.PrintStream r8 = java.lang.System.out     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            java.lang.String r10 = "img: w: %d, h: %d"
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            int r12 = r5.mo8306f()     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r7[r11] = r12     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            int r5 = r5.mo8305e()     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r12 = 1
            r7[r12] = r5     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            java.lang.String r5 = java.lang.String.format(r10, r7)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r8.println(r5)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r9.mo8329d()     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
        L_0x012b:
            r5 = 1084227584(0x40a00000, float:5.0)
            r9.mo8312a()     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r9.mo8319a((com.cyberneid.p105d.p114g.p120d.C1820p) r0, (float) r5)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r9.mo8317a((int) r11)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r7 = 1103626240(0x41c80000, float:25.0)
            float r14 = r14 - r7
            r9.mo8315a((float) r5, (float) r14)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r7 = 1073741824(0x40000000, float:2.0)
            if (r1 == 0) goto L_0x014e
            float r8 = r22.mo8162b((java.lang.String) r23)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            float r8 = r8 + r15
            float r8 = r8 / r7
            double r10 = (double) r8     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r9.mo8313a((double) r10)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
        L_0x014a:
            r9.mo8324a((java.lang.String) r1)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            goto L_0x0151
        L_0x014e:
            java.lang.String r1 = ""
            goto L_0x014a
        L_0x0151:
            r1 = 1092616192(0x41200000, float:10.0)
            r8 = 0
            r9.mo8315a((float) r8, (float) r1)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            if (r2 == 0) goto L_0x0167
            float r1 = r0.mo8162b((java.lang.String) r2)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            float r1 = r1 + r15
            float r1 = r1 / r7
            double r10 = (double) r1     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r9.mo8313a((double) r10)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r9.mo8324a((java.lang.String) r2)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            goto L_0x016c
        L_0x0167:
            java.lang.String r1 = ""
            r9.mo8324a((java.lang.String) r1)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
        L_0x016c:
            r1 = 1094713344(0x41400000, float:12.0)
            r9.mo8315a((float) r5, (float) r1)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            if (r3 == 0) goto L_0x0181
            float r2 = r0.mo8162b((java.lang.String) r3)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            float r2 = r2 + r15
            float r2 = r2 / r7
            double r10 = (double) r2     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r9.mo8313a((double) r10)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r9.mo8324a((java.lang.String) r3)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            goto L_0x0186
        L_0x0181:
            java.lang.String r2 = ""
            r9.mo8324a((java.lang.String) r2)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
        L_0x0186:
            r9.mo8315a((float) r5, (float) r1)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            if (r4 == 0) goto L_0x0199
            float r0 = r0.mo8162b((java.lang.String) r4)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            float r15 = r15 + r0
            float r15 = r15 / r7
            double r0 = (double) r15     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r9.mo8313a((double) r0)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r9.mo8324a((java.lang.String) r4)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            goto L_0x019e
        L_0x0199:
            java.lang.String r0 = ""
            r9.mo8324a((java.lang.String) r0)     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
        L_0x019e:
            r9.mo8325b()     // Catch:{ Throwable -> 0x01bd, all -> 0x01b9 }
            r9.close()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r0.<init>()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r6.mo8061a((java.io.OutputStream) r0)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            byte[] r0 = r0.toByteArray()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r1.<init>(r0)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            r6.close()
            return r1
        L_0x01b9:
            r0 = move-exception
            r1 = r0
            r7 = 0
            goto L_0x01c2
        L_0x01bd:
            r0 = move-exception
            r7 = r0
            throw r7     // Catch:{ all -> 0x01c0 }
        L_0x01c0:
            r0 = move-exception
            r1 = r0
        L_0x01c2:
            if (r7 == 0) goto L_0x01ce
            r9.close()     // Catch:{ Throwable -> 0x01c8, all -> 0x01d2 }
            goto L_0x01d1
        L_0x01c8:
            r0 = move-exception
            r2 = r0
            r7.addSuppressed(r2)     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
            goto L_0x01d1
        L_0x01ce:
            r9.close()     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
        L_0x01d1:
            throw r1     // Catch:{ Throwable -> 0x01d6, all -> 0x01d2 }
        L_0x01d2:
            r0 = move-exception
            r1 = r0
            r7 = 0
            goto L_0x01db
        L_0x01d6:
            r0 = move-exception
            r7 = r0
            throw r7     // Catch:{ all -> 0x01d9 }
        L_0x01d9:
            r0 = move-exception
            r1 = r0
        L_0x01db:
            if (r7 == 0) goto L_0x01e7
            r6.close()     // Catch:{ Throwable -> 0x01e1 }
            goto L_0x01ea
        L_0x01e1:
            r0 = move-exception
            r2 = r0
            r7.addSuppressed(r2)
            goto L_0x01ea
        L_0x01e7:
            r6.close()
        L_0x01ea:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p087a.C1462k.m5507a(com.cyberneid.d.g.c, int, com.cyberneid.d.g.a.f, com.cyberneid.d.g.d.p, java.lang.String, java.lang.String, java.lang.String, java.lang.String, byte[]):java.io.InputStream");
    }

    /* renamed from: a */
    private byte[] m5508a() {
        this.f4333d = new ByteArrayOutputStream();
        C1895b b = this.f4332c.mo8063b(this.f4333d);
        b.mo8365a(m5509a(b.mo8364a()));
        C1654a.m6619a((Closeable) this.f4342m);
        return this.f4333d.toByteArray();
    }

    /* renamed from: a */
    private byte[] m5509a(InputStream inputStream) {
        this.f4334e = new ByteArrayOutputStream();
        C1452a.m5478a(inputStream, this.f4334e);
        byte[] byteArray = this.f4334e.toByteArray();
        C1454c cVar = this.f4337h;
        return (cVar != null ? this.f4336g.mo6925a(byteArray, cVar, this.f4338i, true, this.f4339j, this.f4340k) : this.f4336g.mo6926a(byteArray, this.f4341l, this.f4338i, true, this.f4339j, this.f4340k)).mo6915d();
    }

    /* renamed from: a */
    public void mo6929a(int i, float f, float f2, float f3, float f4, C1820p pVar, String str, String str2, String str3, String str4, String str5, String str6, byte[] bArr) {
        int i2 = i;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        this.f4335f = new C1896c();
        this.f4335f.mo8367a(C1896c.f6043a);
        this.f4335f.mo8372b(C1613i.m6461a(str6));
        if (str8 != null) {
            this.f4335f.mo8368a(str8);
        }
        if (str9 != null) {
            this.f4335f.mo8373b(str9);
        }
        if (str7 != null) {
            this.f4335f.mo8376c(str7);
        }
        C1763f g = this.f4332c.mo8054a(i2).mo8248g();
        this.f4335f.mo8369a(Calendar.getInstance());
        if (f3 * f4 != 0.0f) {
            C1463a aVar = new C1463a();
            aVar.mo6932a((int) (g.mo7952h() * f));
            aVar.mo6934b((int) (g.mo7953i() * f2));
            aVar.mo6936c((int) (g.mo7952h() * f3));
            aVar.mo6938d((int) (g.mo7953i() * f4));
            C1763f a = m5506a(this.f4332c, aVar, i2);
            this.f4342m = new C1898e();
            try {
                this.f4342m.mo8380a(m5507a(this.f4332c, i, a, pVar, str, str3, str4, str2, bArr));
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.f4342m.mo8379a(i2);
            try {
                this.f4332c.mo8059a(this.f4335f, (C1897d) null, this.f4342m);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } else {
            this.f4332c.mo8058a(this.f4335f, (C1897d) null);
        }
    }

    /* renamed from: a */
    public byte[] mo6930a(C1460i iVar, C1454c cVar, boolean z, boolean z2, C1468p pVar) {
        this.f4336g = iVar;
        this.f4337h = cVar;
        this.f4338i = z;
        this.f4339j = z2;
        this.f4340k = pVar;
        this.f4341l = null;
        return m5508a();
    }
}
