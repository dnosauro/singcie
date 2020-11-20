package com.cyberneid.p105d.p114g.p120d;

import com.cyberneid.p089b.p095f.C1544ab;
import com.cyberneid.p089b.p095f.C1576x;
import com.cyberneid.p089b.p095f.C1577y;
import com.cyberneid.p105d.p108b.C1610g;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p111d.C1654a;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.p115a.C1764g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/* renamed from: com.cyberneid.d.g.d.ae */
abstract class C1800ae {

    /* renamed from: a */
    protected C1544ab f5816a;

    /* renamed from: b */
    protected C1821q f5817b;

    /* renamed from: c */
    private final C1783c f5818c;

    /* renamed from: d */
    private final Set<Integer> f5819d;

    /* renamed from: e */
    private final boolean f5820e;

    /* renamed from: a */
    private boolean m7288a(C1544ab abVar) {
        if (abVar.mo7191l() != null) {
            short g = abVar.mo7191l().mo7308g() & 8;
            return ((g & 1) == 1 || (g & 512) == 512) ? false : true;
        }
    }

    /* renamed from: b */
    private boolean m7289b(C1544ab abVar) {
        return abVar.mo7191l() == null || (abVar.mo7191l().mo7308g() & 256) != 256;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e3  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.cyberneid.p105d.p114g.p120d.C1821q m7290c(com.cyberneid.p089b.p095f.C1544ab r11) {
        /*
            r10 = this;
            com.cyberneid.d.g.d.q r0 = new com.cyberneid.d.g.d.q
            r0.<init>()
            java.lang.String r1 = r11.mo7033b()
            r0.mo8178a((java.lang.String) r1)
            com.cyberneid.b.f.p r1 = r11.mo7191l()
            com.cyberneid.b.f.t r2 = r11.mo7190k()
            long r3 = r2.mo7340a()
            r5 = 0
            r6 = 1
            r7 = 0
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x002d
            com.cyberneid.b.f.g r3 = r11.mo7194o()
            int r3 = r3.mo7247j()
            if (r3 != r6) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r3 = 0
            goto L_0x002e
        L_0x002d:
            r3 = 1
        L_0x002e:
            r0.mo8179a((boolean) r3)
            int r3 = r1.mo7307f()
            r4 = r3 & 1
            if (r4 == r3) goto L_0x0040
            r4 = r3 & 256(0x100, float:3.59E-43)
            if (r4 != r3) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r3 = 0
            goto L_0x0041
        L_0x0040:
            r3 = 1
        L_0x0041:
            r0.mo8197f((boolean) r3)
            int r3 = r1.mo7306e()
            if (r3 == r6) goto L_0x0059
            r4 = 7
            if (r3 == r4) goto L_0x0059
            r4 = 10
            if (r3 == r4) goto L_0x0055
            switch(r3) {
                case 3: goto L_0x0059;
                case 4: goto L_0x0059;
                case 5: goto L_0x0059;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x005c
        L_0x0055:
            r0.mo8191d((boolean) r6)
            goto L_0x005c
        L_0x0059:
            r0.mo8184b((boolean) r6)
        L_0x005c:
            int r3 = r1.mo7324w()
            float r3 = (float) r3
            r0.mo8174a((float) r3)
            r0.mo8188c((boolean) r6)
            r0.mo8193e((boolean) r5)
            float r2 = r2.mo7342b()
            r0.mo8181b((float) r2)
            com.cyberneid.b.f.f r2 = r11.mo7193n()
            com.cyberneid.d.g.a.f r3 = new com.cyberneid.d.g.a.f
            r3.<init>()
            r4 = 1148846080(0x447a0000, float:1000.0)
            int r5 = r2.mo7232k()
            float r5 = (float) r5
            float r4 = r4 / r5
            short r5 = r2.mo7235n()
            float r5 = (float) r5
            float r5 = r5 * r4
            r3.mo7943a(r5)
            short r5 = r2.mo7237p()
            float r5 = (float) r5
            float r5 = r5 * r4
            r3.mo7945b(r5)
            short r5 = r2.mo7234m()
            float r5 = (float) r5
            float r5 = r5 * r4
            r3.mo7947c(r5)
            short r2 = r2.mo7236o()
            float r2 = (float) r2
            float r2 = r2 * r4
            r3.mo7948d(r2)
            r0.mo8176a((com.cyberneid.p105d.p114g.p115a.C1763f) r3)
            com.cyberneid.b.f.g r11 = r11.mo7194o()
            short r2 = r11.mo7239b()
            float r2 = (float) r2
            float r2 = r2 * r4
            r0.mo8186c((float) r2)
            short r11 = r11.mo7242e()
            float r11 = (float) r11
            float r11 = r11 * r4
            r0.mo8190d((float) r11)
            int r11 = r1.mo7323v()
            double r2 = (double) r11
            r5 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            int r11 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r11 < 0) goto L_0x00e3
            int r11 = r1.mo7301B()
            float r11 = (float) r11
            float r11 = r11 * r4
            r0.mo8192e((float) r11)
            int r11 = r1.mo7300A()
            float r11 = (float) r11
            goto L_0x00fa
        L_0x00e3:
            int r11 = r1.mo7321t()
            int r2 = r1.mo7322u()
            int r11 = r11 + r2
            float r11 = (float) r11
            float r11 = r11 * r4
            r0.mo8192e((float) r11)
            int r11 = r1.mo7321t()
            float r11 = (float) r11
            r1 = 1073741824(0x40000000, float:2.0)
            float r11 = r11 / r1
        L_0x00fa:
            float r11 = r11 * r4
            r0.mo8196f((float) r11)
            com.cyberneid.d.g.a.f r11 = r0.mo8203j()
            float r11 = r11.mo7952h()
            r1 = 1040522936(0x3e051eb8, float:0.13)
            float r11 = r11 * r1
            r0.mo8199g(r11)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p120d.C1800ae.m7290c(com.cyberneid.b.f.ab):com.cyberneid.d.g.d.q");
    }

    /* renamed from: a */
    public C1544ab mo8108a() {
        return this.f5816a;
    }

    /* renamed from: a */
    public String mo8109a(Map<Integer, Integer> map) {
        long hashCode = (long) map.hashCode();
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j = hashCode / 25;
            sb.append("BCDEFGHIJKLMNOPQRSTUVWXYZ".charAt((int) (hashCode % 25)));
            if (j != 0 && sb.length() < 6) {
                hashCode = j;
            }
        }
        while (sb.length() < 6) {
            sb.insert(0, 'A');
        }
        sb.append('+');
        return sb.toString();
    }

    /* renamed from: a */
    public void mo8110a(int i) {
        this.f5819d.add(Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo8111a(InputStream inputStream) {
        C1610g gVar;
        C1764g gVar2 = new C1764g(this.f5818c, inputStream, C1613i.f5028cD);
        gVar2.mo7959e().mo7518a(C1613i.f5096dS, gVar2.mo7961g().length);
        try {
            gVar = gVar2.mo7958c();
            try {
                this.f5816a = new C1576x().mo7361c((InputStream) gVar);
                if (m7288a(this.f5816a)) {
                    if (this.f5817b == null) {
                        this.f5817b = m7290c(this.f5816a);
                    }
                    C1654a.m6619a((Closeable) gVar);
                    this.f5817b.mo8177a(gVar2);
                    return;
                }
                throw new IOException("This font does not permit embedding");
            } catch (Throwable th) {
                th = th;
                C1654a.m6619a((Closeable) gVar);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            gVar = null;
            C1654a.m6619a((Closeable) gVar);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo8112a(InputStream inputStream, String str, Map<Integer, Integer> map);

    /* renamed from: b */
    public void mo8113b() {
        if (!m7289b(this.f5816a)) {
            throw new IOException("This font does not permit subsetting");
        } else if (this.f5820e) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("head");
            arrayList.add("hhea");
            arrayList.add("loca");
            arrayList.add("maxp");
            arrayList.add("cvt ");
            arrayList.add("prep");
            arrayList.add("glyf");
            arrayList.add("hmtx");
            arrayList.add("fpgm");
            arrayList.add("gasp");
            C1577y yVar = new C1577y(mo8108a(), arrayList);
            yVar.mo7366a(this.f5819d);
            Map<Integer, Integer> a = yVar.mo7362a();
            String a2 = mo8109a(a);
            yVar.mo7365a(a2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yVar.mo7364a((OutputStream) byteArrayOutputStream);
            mo8112a(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), a2, a);
        } else {
            throw new IllegalStateException("Subsetting is disabled");
        }
    }

    /* renamed from: c */
    public boolean mo8114c() {
        return this.f5820e;
    }
}
