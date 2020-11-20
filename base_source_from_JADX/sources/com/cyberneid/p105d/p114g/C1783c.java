package com.cyberneid.p105d.p114g;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1608e;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1616l;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p111d.C1655b;
import com.cyberneid.p105d.p111d.C1657d;
import com.cyberneid.p105d.p111d.C1662h;
import com.cyberneid.p105d.p112e.C1671f;
import com.cyberneid.p105d.p113f.C1685b;
import com.cyberneid.p105d.p114g.p115a.C1689a;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p115a.C1763f;
import com.cyberneid.p105d.p114g.p118b.C1766a;
import com.cyberneid.p105d.p114g.p118b.C1771f;
import com.cyberneid.p105d.p114g.p120d.C1820p;
import com.cyberneid.p105d.p114g.p126f.p128b.C1877a;
import com.cyberneid.p105d.p114g.p126f.p128b.C1890n;
import com.cyberneid.p105d.p114g.p126f.p128b.C1892p;
import com.cyberneid.p105d.p114g.p126f.p129c.C1895b;
import com.cyberneid.p105d.p114g.p126f.p129c.C1896c;
import com.cyberneid.p105d.p114g.p126f.p129c.C1897d;
import com.cyberneid.p105d.p114g.p126f.p129c.C1898e;
import com.cyberneid.p105d.p114g.p126f.p129c.C1899f;
import com.cyberneid.p105d.p114g.p126f.p130d.C1903d;
import com.cyberneid.p105d.p114g.p126f.p130d.C1909j;
import com.cyberneid.p105d.p114g.p126f.p130d.C1915p;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: com.cyberneid.d.g.c */
public class C1783c implements Closeable {

    /* renamed from: a */
    private static final int[] f5779a = {0, 1000000000, 1000000000, 1000000000};

    /* renamed from: b */
    private final C1608e f5780b;

    /* renamed from: c */
    private C1785d f5781c;

    /* renamed from: d */
    private C1771f f5782d;

    /* renamed from: e */
    private boolean f5783e;

    /* renamed from: f */
    private Long f5784f;

    /* renamed from: g */
    private final C1662h f5785g;

    /* renamed from: h */
    private C1766a f5786h;

    /* renamed from: i */
    private final Set<C1820p> f5787i;

    /* renamed from: j */
    private C1897d f5788j;

    /* renamed from: k */
    private C1899f f5789k;

    /* renamed from: l */
    private C1932i f5790l;

    public C1783c() {
        this(false);
    }

    public C1783c(C1608e eVar, C1662h hVar, C1766a aVar) {
        this.f5787i = new HashSet();
        this.f5790l = new C1688a();
        this.f5780b = eVar;
        this.f5785g = hVar;
        this.f5786h = aVar;
    }

    public C1783c(boolean z) {
        this(z, (C1655b) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C1783c(boolean r5, com.cyberneid.p105d.p111d.C1655b r6) {
        /*
            r4 = this;
            r4.<init>()
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r4.f5787i = r0
            com.cyberneid.d.g.a r0 = new com.cyberneid.d.g.a
            r0.<init>()
            r4.f5790l = r0
            r0 = 0
            if (r6 == 0) goto L_0x0045
            com.cyberneid.d.d.j r1 = new com.cyberneid.d.d.j     // Catch:{ IOException -> 0x001b }
            r1.<init>((com.cyberneid.p105d.p111d.C1655b) r6)     // Catch:{ IOException -> 0x001b }
            r6 = r1
            goto L_0x0046
        L_0x001b:
            r6 = move-exception
            java.lang.String r1 = "PdfBox-Android"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error initializing scratch file: "
            r2.append(r3)
            java.lang.String r6 = r6.getMessage()
            r2.append(r6)
            java.lang.String r6 = ". Fall back to main memory usage only."
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            android.util.Log.w(r1, r6)
            com.cyberneid.d.d.j r6 = new com.cyberneid.d.d.j     // Catch:{ IOException -> 0x0045 }
            com.cyberneid.d.d.b r1 = com.cyberneid.p105d.p111d.C1655b.m6621a()     // Catch:{ IOException -> 0x0045 }
            r6.<init>((com.cyberneid.p105d.p111d.C1655b) r1)     // Catch:{ IOException -> 0x0045 }
            goto L_0x0046
        L_0x0045:
            r6 = r0
        L_0x0046:
            if (r6 == 0) goto L_0x004e
            com.cyberneid.d.b.e r5 = new com.cyberneid.d.b.e
            r5.<init>((com.cyberneid.p105d.p111d.C1664j) r6)
            goto L_0x0054
        L_0x004e:
            com.cyberneid.d.b.e r6 = new com.cyberneid.d.b.e
            r6.<init>((boolean) r5)
            r5 = r6
        L_0x0054:
            r4.f5780b = r5
            r4.f5785g = r0
            com.cyberneid.d.b.d r5 = new com.cyberneid.d.b.d
            r5.<init>()
            com.cyberneid.d.b.e r6 = r4.f5780b
            r6.mo7569c(r5)
            com.cyberneid.d.b.d r6 = new com.cyberneid.d.b.d
            r6.<init>()
            com.cyberneid.d.b.i r0 = com.cyberneid.p105d.p108b.C1613i.f5271gi
            r5.mo7521a((com.cyberneid.p105d.p108b.C1613i) r0, (com.cyberneid.p105d.p108b.C1605b) r6)
            com.cyberneid.d.b.i r5 = com.cyberneid.p105d.p108b.C1613i.f5338hw
            com.cyberneid.d.b.i r0 = com.cyberneid.p105d.p108b.C1613i.f4956al
            r6.mo7521a((com.cyberneid.p105d.p108b.C1613i) r5, (com.cyberneid.p105d.p108b.C1605b) r0)
            com.cyberneid.d.b.i r5 = com.cyberneid.p105d.p108b.C1613i.f5299hJ
            java.lang.String r0 = "1.4"
            com.cyberneid.d.b.i r0 = com.cyberneid.p105d.p108b.C1613i.m6461a((java.lang.String) r0)
            r6.mo7521a((com.cyberneid.p105d.p108b.C1613i) r5, (com.cyberneid.p105d.p108b.C1605b) r0)
            com.cyberneid.d.b.d r5 = new com.cyberneid.d.b.d
            r5.<init>()
            com.cyberneid.d.b.i r0 = com.cyberneid.p105d.p108b.C1613i.f5228fs
            r6.mo7521a((com.cyberneid.p105d.p108b.C1613i) r0, (com.cyberneid.p105d.p108b.C1605b) r5)
            com.cyberneid.d.b.i r6 = com.cyberneid.p105d.p108b.C1613i.f5338hw
            com.cyberneid.d.b.i r0 = com.cyberneid.p105d.p108b.C1613i.f5228fs
            r5.mo7521a((com.cyberneid.p105d.p108b.C1613i) r6, (com.cyberneid.p105d.p108b.C1605b) r0)
            com.cyberneid.d.b.a r6 = new com.cyberneid.d.b.a
            r6.<init>()
            com.cyberneid.d.b.i r0 = com.cyberneid.p105d.p108b.C1613i.f5084dG
            r5.mo7521a((com.cyberneid.p105d.p108b.C1613i) r0, (com.cyberneid.p105d.p108b.C1605b) r6)
            com.cyberneid.d.b.i r6 = com.cyberneid.p105d.p108b.C1613i.f4936aR
            com.cyberneid.d.b.h r0 = com.cyberneid.p105d.p108b.C1612h.f4886a
            r5.mo7521a((com.cyberneid.p105d.p108b.C1613i) r6, (com.cyberneid.p105d.p108b.C1605b) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.C1783c.<init>(boolean, com.cyberneid.d.d.b):void");
    }

    /* renamed from: a */
    public static C1783c m7200a(byte[] bArr) {
        return m7201a(bArr, "");
    }

    /* renamed from: a */
    public static C1783c m7201a(byte[] bArr, String str) {
        return m7202a(bArr, str, (InputStream) null, (String) null);
    }

    /* renamed from: a */
    public static C1783c m7202a(byte[] bArr, String str, InputStream inputStream, String str2) {
        C1671f fVar = new C1671f(new C1657d(bArr), str, inputStream, str2, false);
        fVar.mo7799B();
        return fVar.mo7800z();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        r1 = (com.cyberneid.p105d.p114g.p126f.p130d.C1915p) r1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.cyberneid.p105d.p114g.p126f.p130d.C1915p m7203a(java.util.List<com.cyberneid.p105d.p114g.p126f.p130d.C1909j> r5, com.cyberneid.p105d.p114g.p126f.p129c.C1896c r6) {
        /*
            r4 = this;
            java.util.Iterator r5 = r5.iterator()
            r0 = 0
        L_0x0005:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x002d
            java.lang.Object r1 = r5.next()
            com.cyberneid.d.g.f.d.j r1 = (com.cyberneid.p105d.p114g.p126f.p130d.C1909j) r1
            boolean r2 = r1 instanceof com.cyberneid.p105d.p114g.p126f.p130d.C1915p
            if (r2 == 0) goto L_0x0005
            com.cyberneid.d.g.f.d.p r1 = (com.cyberneid.p105d.p114g.p126f.p130d.C1915p) r1
            com.cyberneid.d.g.f.c.c r2 = r1.mo8421b()
            if (r2 == 0) goto L_0x0005
            com.cyberneid.d.b.d r2 = r2.mo7505d()
            com.cyberneid.d.b.d r3 = r6.mo7505d()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0005
            r0 = r1
            goto L_0x0005
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.C1783c.m7203a(java.util.List, com.cyberneid.d.g.f.c.c):com.cyberneid.d.g.f.d.p");
    }

    /* renamed from: a */
    private void m7204a(C1903d dVar, C1607d dVar2) {
        C1607d dVar3 = (C1607d) dVar2.mo7539c(C1613i.f4985bN);
        if (dVar3 != null) {
            dVar3.mo7504a(true);
            dVar3.mo7537b(true);
            dVar.mo7505d().mo7521a(C1613i.f4985bN, (C1605b) dVar3);
        }
    }

    /* renamed from: a */
    private void m7205a(C1915p pVar, C1607d dVar) {
        pVar.mo8423n().get(0).mo8339a(new C1763f((C1604a) dVar.mo7539c(C1613i.f5263ga)));
    }

    /* renamed from: a */
    private void m7206a(C1915p pVar, C1903d dVar) {
        pVar.mo8423n().get(0).mo8339a(new C1763f());
        dVar.mo8393a((C1931h) null);
        C1890n nVar = new C1890n();
        C1619o a = mo8053a().mo7559a();
        a.mo7629n().close();
        C1892p pVar2 = new C1892p(a);
        C1607d dVar2 = (C1607d) pVar2.mo7505d();
        dVar2.mo7521a(C1613i.f5258gV, (C1605b) C1613i.f5041cQ);
        dVar2.mo7522a(C1613i.f4902K, (C1760c) new C1763f());
        nVar.mo8354a(pVar2);
        nVar.mo7505d().mo7504a(true);
        pVar.mo8423n().get(0).mo8341a(nVar);
    }

    /* renamed from: a */
    private void m7207a(C1915p pVar, C1903d dVar, C1608e eVar) {
        boolean z = true;
        boolean z2 = true;
        for (C1616l next : eVar.mo7576j()) {
            if (!z && !z2) {
                break;
            }
            C1605b a = next.mo7604a();
            if (a instanceof C1607d) {
                C1607d dVar2 = (C1607d) a;
                C1605b c = dVar2.mo7539c(C1613i.f5338hw);
                if (z && C1613i.f5353o.equals(c)) {
                    m7205a(pVar, dVar2);
                    z = false;
                }
                C1605b c2 = dVar2.mo7539c(C1613i.f5044cT);
                C1605b c3 = dVar2.mo7539c(C1613i.f5356r);
                if (z2 && C1613i.f5286gx.equals(c2) && c3 != null) {
                    m7209b(pVar, dVar2);
                    m7204a(dVar, dVar2);
                    z2 = false;
                }
            }
        }
        if (z || z2) {
            throw new IllegalArgumentException("Template is missing required objects");
        }
    }

    /* renamed from: a */
    private boolean m7208a(List<C1909j> list, C1915p pVar) {
        boolean z;
        Iterator<C1909j> it = list.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                z = false;
                break;
            }
            C1909j next = it.next();
            if ((next instanceof C1915p) && next.mo7505d().equals(pVar.mo7505d())) {
                pVar.mo7505d().mo7537b(true);
                break;
            }
        }
        if (!z) {
            list.add(pVar);
        }
        return z;
    }

    /* renamed from: b */
    private void m7209b(C1915p pVar, C1607d dVar) {
        C1890n nVar = new C1890n((C1607d) dVar.mo7539c(C1613i.f5356r));
        nVar.mo7505d().mo7504a(true);
        pVar.mo8423n().get(0).mo8341a(nVar);
    }

    /* renamed from: a */
    public C1608e mo8053a() {
        return this.f5780b;
    }

    /* renamed from: a */
    public C1831e mo8054a(int i) {
        return mo8062b().mo8082c().mo8456a(i);
    }

    /* renamed from: a */
    public void mo8055a(float f) {
        float m = mo8075m();
        if (f != m) {
            if (f < m) {
                Log.e("PdfBox-Android", "It's not allowed to downgrade the version of a pdf.");
            } else if (mo8053a().mo7565b() >= 1.4f) {
                mo8062b().mo8080a(Float.toString(f));
            } else {
                mo8053a().mo7561a(f);
            }
        }
    }

    /* renamed from: a */
    public void mo8056a(C1771f fVar) {
        this.f5782d = fVar;
    }

    /* renamed from: a */
    public void mo8057a(C1831e eVar) {
        mo8070h().mo8457a(eVar);
    }

    /* renamed from: a */
    public void mo8058a(C1896c cVar, C1897d dVar) {
        mo8059a(cVar, dVar, new C1898e());
    }

    /* renamed from: a */
    public void mo8059a(C1896c cVar, C1897d dVar, C1898e eVar) {
        int c = eVar.mo8382c();
        if (c <= 0) {
            c = 9472;
        }
        cVar.mo8370a(new byte[c]);
        cVar.mo8371a(new int[]{0, 1000000000, 1000000000, 1000000000});
        this.f5788j = dVar;
        C1785d b = mo8062b();
        int a = b.mo8082c().mo8455a();
        if (a != 0) {
            C1831e a2 = b.mo8082c().mo8456a(Math.min(Math.max(eVar.mo8378a(), 0), a - 1));
            C1903d b2 = b.mo8081b();
            b.mo7505d().mo7537b(true);
            if (b2 == null) {
                b2 = new C1903d(this);
                b.mo8079a(b2);
            } else {
                b2.mo7505d().mo7537b(true);
            }
            List<C1877a> h = a2.mo8249h();
            List c2 = b2.mo8398c();
            if (c2 == null) {
                c2 = new ArrayList();
                b2.mo8394a((List<C1909j>) c2);
            }
            C1915p a3 = m7203a((List<C1909j>) c2, cVar);
            if (a3 == null) {
                a3 = new C1915p(b2);
                a3.mo8420a(cVar);
                a3.mo8423n().get(0).mo8340a(a2);
            }
            a3.mo8423n().get(0).mo8342a(true);
            List<C1909j> c3 = b2.mo8398c();
            b2.mo7505d().mo7504a(true);
            b2.mo8395a(true);
            b2.mo8397b(true);
            boolean a4 = m7208a(c3, a3);
            C1608e b3 = eVar.mo8381b();
            if (b3 == null) {
                m7206a(a3, b2);
            } else {
                m7207a(a3, b2, b3);
            }
            if (!(h instanceof C1689a) || !(c3 instanceof C1689a) || !((C1689a) h).mo7854a().equals(((C1689a) c3).mo7854a()) || !a4) {
                h.add(a3.mo8423n().get(0));
            }
            a2.mo7505d().mo7537b(true);
            return;
        }
        throw new IllegalStateException("Cannot sign an empty document");
    }

    /* renamed from: a */
    public void mo8060a(File file) {
        mo8061a((OutputStream) new FileOutputStream(file));
    }

    /* renamed from: a */
    public void mo8061a(OutputStream outputStream) {
        if (!this.f5780b.mo7579m()) {
            for (C1820p k : this.f5787i) {
                k.mo8171k();
            }
            this.f5787i.clear();
            C1685b bVar = new C1685b(outputStream);
            try {
                bVar.mo7827a(this);
                bVar.close();
            } finally {
                bVar.close();
            }
        } else {
            throw new IOException("Cannot save a document which has been closed");
        }
    }

    /* renamed from: b */
    public C1785d mo8062b() {
        if (this.f5781c == null) {
            C1605b c = this.f5780b.mo7577k().mo7539c(C1613i.f5271gi);
            if (c instanceof C1607d) {
                this.f5781c = new C1785d(this, (C1607d) c);
            } else {
                this.f5781c = new C1785d(this);
            }
        }
        return this.f5781c;
    }

    /* renamed from: b */
    public C1895b mo8063b(OutputStream outputStream) {
        if (this.f5785g != null) {
            C1896c cVar = null;
            Iterator<C1896c> it = mo8068f().iterator();
            while (it.hasNext()) {
                cVar = it.next();
                if (cVar.mo7505d().mo7550h()) {
                    break;
                }
            }
            if (Arrays.equals(cVar.mo8375b(), f5779a)) {
                C1685b bVar = new C1685b(outputStream, this.f5785g);
                bVar.mo7827a(this);
                this.f5789k = new C1899f(bVar);
                return this.f5789k;
            }
            throw new IllegalStateException("signature reserve byte range has been changed after addSignature(), please set the byte range that existed after addSignature()");
        }
        throw new IllegalStateException("document was not loaded from a file or a stream");
    }

    /* renamed from: c */
    public boolean mo8064c() {
        return this.f5780b.mo7571f();
    }

    public void close() {
        if (!this.f5780b.mo7579m()) {
            this.f5780b.close();
            C1662h hVar = this.f5785g;
            if (hVar != null) {
                hVar.close();
            }
        }
    }

    /* renamed from: d */
    public C1771f mo8066d() {
        if (this.f5782d == null && mo8064c()) {
            this.f5782d = new C1771f(this.f5780b.mo7573g());
        }
        return this.f5782d;
    }

    /* renamed from: e */
    public List<C1915p> mo8067e() {
        ArrayList arrayList = new ArrayList();
        C1903d b = mo8062b().mo8081b();
        if (b != null) {
            for (C1909j next : b.mo8398c()) {
                if (next instanceof C1915p) {
                    arrayList.add((C1915p) next);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: f */
    public List<C1896c> mo8068f() {
        ArrayList arrayList = new ArrayList();
        for (C1915p j : mo8067e()) {
            C1605b c = j.mo7505d().mo7539c(C1613i.f5297hH);
            if (c != null) {
                arrayList.add(new C1896c((C1607d) c));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public Set<C1820p> mo8069g() {
        return this.f5787i;
    }

    /* renamed from: h */
    public C1928g mo8070h() {
        return mo8062b().mo8082c();
    }

    /* renamed from: i */
    public int mo8071i() {
        return mo8062b().mo8082c().mo8455a();
    }

    /* renamed from: j */
    public C1766a mo8072j() {
        if (this.f5786h == null) {
            this.f5786h = C1766a.m7067a();
        }
        return this.f5786h;
    }

    /* renamed from: k */
    public boolean mo8073k() {
        return this.f5783e;
    }

    /* renamed from: l */
    public Long mo8074l() {
        return this.f5784f;
    }

    /* renamed from: m */
    public float mo8075m() {
        float b = mo8053a().mo7565b();
        if (b < 1.4f) {
            return b;
        }
        String e = mo8062b().mo8083e();
        float f = -1.0f;
        if (e != null) {
            try {
                f = Float.parseFloat(e);
            } catch (NumberFormatException e2) {
                Log.e("PdfBox-Android", "Can't extract the version number of the document catalog.", e2);
            }
        }
        return Math.max(f, b);
    }

    /* renamed from: n */
    public C1932i mo8076n() {
        return this.f5790l;
    }
}
