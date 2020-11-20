package com.cyberneid.p105d.p114g.p126f.p130d;

import com.cyberneid.p099c.p100a.p101a.C1592a;
import com.cyberneid.p105d.p106a.C1602a;
import com.cyberneid.p105d.p106a.p107a.C1603a;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p112e.C1672g;
import com.cyberneid.p105d.p113f.C1687d;
import com.cyberneid.p105d.p114g.C1867f;
import com.cyberneid.p105d.p114g.p115a.C1763f;
import com.cyberneid.p105d.p114g.p120d.C1820p;
import com.cyberneid.p105d.p114g.p122e.p123a.C1837e;
import com.cyberneid.p105d.p114g.p126f.p127a.C1876i;
import com.cyberneid.p105d.p114g.p126f.p128b.C1888l;
import com.cyberneid.p105d.p114g.p126f.p128b.C1889m;
import com.cyberneid.p105d.p114g.p126f.p128b.C1890n;
import com.cyberneid.p105d.p114g.p126f.p128b.C1891o;
import com.cyberneid.p105d.p114g.p126f.p128b.C1892p;
import com.cyberneid.p105d.p114g.p126f.p128b.C1893q;
import com.cyberneid.p105d.p114g.p126f.p130d.C1924u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import org.spongycastle.crypto.tls.CipherSuite;

/* renamed from: com.cyberneid.d.g.f.d.a */
class C1900a {

    /* renamed from: a */
    private static final C1603a f6056a = C1603a.m6344a("BMC");

    /* renamed from: b */
    private static final C1603a f6057b = C1603a.m6344a("EMC");

    /* renamed from: f */
    private static final int[] f6058f = {153, CipherSuite.TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256, 215};

    /* renamed from: c */
    private final C1918s f6059c;

    /* renamed from: d */
    private final C1908i f6060d;

    /* renamed from: e */
    private String f6061e;

    C1900a(C1918s sVar) {
        this.f6059c = sVar;
        this.f6060d = sVar.mo8432p();
    }

    /* renamed from: a */
    private float m7828a(C1820p pVar, C1763f fVar) {
        float a = this.f6060d.mo8407a();
        if (a != 0.0f) {
            return a;
        }
        if (m7836a()) {
            return 12.0f;
        }
        float d = pVar.mo8101i().mo8482d() * 1000.0f;
        float h = (fVar.mo7952h() / (pVar.mo8162b(this.f6061e) * pVar.mo8101i().mo8480c())) * pVar.mo8101i().mo8480c() * 1000.0f;
        float m = (pVar.mo8163b().mo8206m() + (-pVar.mo8163b().mo8205l())) * pVar.mo8101i().mo8482d();
        if (m <= 0.0f) {
            m = pVar.mo8100g().mo7396e() * pVar.mo8101i().mo8482d();
        }
        return Math.min((fVar.mo7953i() / m) * d, h);
    }

    /* renamed from: a */
    private C1763f m7829a(C1763f fVar, float f) {
        float c = fVar.mo7946c() + f;
        float e = fVar.mo7949e() + f;
        float f2 = f * 2.0f;
        return new C1763f(c, e, fVar.mo7952h() - f2, fVar.mo7953i() - f2);
    }

    /* renamed from: a */
    private List<Object> m7830a(C1892p pVar) {
        C1672g gVar = new C1672g((C1602a) pVar);
        gVar.mo7778r();
        return gVar.mo7779s();
    }

    /* renamed from: a */
    private void m7831a(C1888l lVar, C1892p pVar) {
        float f;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C1867f fVar = new C1867f(this.f6059c.mo8414i().mo8392a(), pVar, byteArrayOutputStream);
        C1889m g = lVar.mo8349g();
        if (g != null) {
            C1837e b = g.mo8352b();
            if (b != null) {
                fVar.mo8320a(b);
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            C1893q h = lVar.mo8350h();
            if (h != null && h.mo8359b() > 0.0f) {
                f = h.mo8359b();
            }
            if (f > 0.0f) {
                fVar.mo8314a(f);
                C1763f a = m7829a(m7840c(lVar, pVar), Math.max(0.5f, f / 2.0f));
                fVar.mo8316a(a.mo7946c(), a.mo7949e(), a.mo7952h(), a.mo7953i());
                fVar.mo8330e();
            }
        }
        fVar.close();
        byteArrayOutputStream.close();
        m7835a(byteArrayOutputStream.toByteArray(), pVar);
    }

    /* renamed from: a */
    private void m7832a(C1888l lVar, C1892p pVar, OutputStream outputStream) {
        float f;
        C1867f fVar = new C1867f(this.f6059c.mo8414i().mo8392a(), pVar, outputStream);
        pVar.mo8293a(new C1592a());
        pVar.mo8292a(1);
        float b = lVar.mo8350h() != null ? lVar.mo8350h().mo8359b() : 0.0f;
        C1763f a = m7829a(m7840c(lVar, pVar), Math.max(1.0f, b));
        C1763f a2 = m7829a(a, Math.max(1.0f, b));
        fVar.mo8327c();
        fVar.mo8316a(a.mo7946c(), a.mo7949e(), a.mo7952h(), a.mo7953i());
        fVar.mo8332g();
        C1820p b2 = this.f6059c.mo8432p().mo8410b();
        float a3 = m7828a(b2, a2);
        if (this.f6059c instanceof C1911l) {
            m7838b(fVar, pVar, b2, a3);
        }
        fVar.mo8312a();
        this.f6059c.mo8432p().mo8409a(fVar, a3);
        float f2 = a3 / 1000.0f;
        float e = b2.mo8100g().mo7396e() * f2;
        float m = b2.mo8163b().mo8206m() * f2;
        float l = b2.mo8163b().mo8205l() * f2;
        C1918s sVar = this.f6059c;
        if ((sVar instanceof C1917r) && ((C1917r) sVar).mo8425b()) {
            f = a2.mo7951g() - e;
        } else if (m > a.mo7953i()) {
            f = a.mo7949e() + (-l);
        } else {
            float e2 = a.mo7949e() + ((a.mo7953i() - m) / 2.0f);
            float f3 = -l;
            f = e2 - a.mo7949e() < f3 ? Math.min(f3 + a2.mo7949e(), Math.max(e2, (a2.mo7953i() - a2.mo7949e()) - m)) : e2;
        }
        float c = a2.mo7946c();
        if (m7839b()) {
            m7834a(fVar, pVar, b2, a3);
        } else if (this.f6059c instanceof C1911l) {
            m7833a(fVar, pVar, a2, b2, a3);
        } else {
            C1919t tVar = new C1919t(this.f6061e);
            C1901b bVar = new C1901b();
            bVar.mo8388a(b2);
            bVar.mo8387a(a3);
            bVar.mo8390b(b2.mo8100g().mo7396e() * f2);
            new C1924u.C1926a(fVar).mo8450a(bVar).mo8451a(tVar).mo8447a(a2.mo7952h()).mo8452a(m7836a()).mo8448a(c, f).mo8449a(this.f6059c.mo8433q()).mo8453a().mo8446a();
        }
        fVar.mo8325b();
        fVar.mo8329d();
        fVar.close();
    }

    /* renamed from: a */
    private void m7833a(C1867f fVar, C1892p pVar, C1763f fVar2, C1820p pVar2, float f) {
        fVar.mo8317a(0);
        int q = this.f6059c.mo8433q();
        if (q == 1 || q == 2) {
            float h = (pVar.mo8298g().mo7952h() - ((pVar2.mo8162b(this.f6061e) / 1000.0f) * f)) - 4.0f;
            if (q == 1) {
                h /= 2.0f;
            }
            fVar.mo8315a(h, 0.0f);
        } else if (q != 0) {
            throw new IOException("Error: Unknown justification value:" + q);
        }
        List<String> c = ((C1911l) this.f6059c).mo8403c();
        int size = c.size();
        float g = fVar2.mo7951g();
        int m = ((C1911l) this.f6059c).mo8419m();
        float f2 = g;
        for (int i = m; i < size; i++) {
            if (i == m) {
                f2 -= (pVar2.mo8163b().mo8204k() / 1000.0f) * f;
            } else {
                f2 -= (pVar2.mo8100g().mo7396e() / 1000.0f) * f;
                fVar.mo8312a();
            }
            fVar.mo8315a(fVar2.mo7946c(), f2);
            fVar.mo8324a(c.get(i));
            if (i - m != size - 1) {
                fVar.mo8325b();
            }
        }
    }

    /* renamed from: a */
    private void m7834a(C1867f fVar, C1892p pVar, C1820p pVar2, float f) {
        int g = ((C1917r) this.f6059c).mo8429g();
        int min = Math.min(this.f6061e.length(), g);
        C1763f a = m7829a(pVar.mo8298g(), 1.0f);
        float h = pVar.mo8298g().mo7952h() / ((float) g);
        float e = a.mo7949e() + ((pVar.mo8298g().mo7953i() - ((pVar2.mo8163b().mo8204k() / 1000.0f) * f)) / 2.0f);
        float f2 = h / 2.0f;
        int i = 0;
        float f3 = e;
        float f4 = 0.0f;
        while (i < min) {
            int i2 = i + 1;
            String substring = this.f6061e.substring(i, i2);
            float b = ((pVar2.mo8162b(substring) / 1000.0f) * f) / 2.0f;
            fVar.mo8315a((f2 + (f4 / 2.0f)) - (b / 2.0f), f3);
            fVar.mo8324a(substring);
            f2 = h;
            f4 = b;
            i = i2;
            f3 = 0.0f;
        }
    }

    /* renamed from: a */
    private void m7835a(byte[] bArr, C1892p pVar) {
        OutputStream o = pVar.mo8251b().mo7630o();
        o.write(bArr);
        o.close();
    }

    /* renamed from: a */
    private boolean m7836a() {
        C1918s sVar = this.f6059c;
        return (sVar instanceof C1917r) && ((C1917r) sVar).mo8425b();
    }

    /* renamed from: b */
    private void m7837b(C1888l lVar, C1892p pVar) {
        this.f6060d.mo8408a(pVar);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C1687d dVar = new C1687d(byteArrayOutputStream);
        List<Object> a = m7830a(pVar);
        int indexOf = a.indexOf(f6056a);
        if (indexOf == -1) {
            dVar.mo7848a((List) a);
            dVar.mo7849a(C1613i.f5337hv, f6056a);
        } else {
            dVar.mo7848a((List) a.subList(0, indexOf + 1));
        }
        m7832a(lVar, pVar, byteArrayOutputStream);
        int indexOf2 = a.indexOf(f6057b);
        if (indexOf2 == -1) {
            dVar.mo7849a(f6057b);
        } else {
            dVar.mo7848a((List) a.subList(indexOf2, a.size()));
        }
        byteArrayOutputStream.close();
        m7835a(byteArrayOutputStream.toByteArray(), pVar);
    }

    /* renamed from: b */
    private void m7838b(C1867f fVar, C1892p pVar, C1820p pVar2, float f) {
        List<Integer> f2 = ((C1911l) this.f6059c).mo8405f();
        List<String> g = ((C1911l) this.f6059c).mo8406g();
        List<String> e = ((C1911l) this.f6059c).mo8404e();
        int intValue = (g.isEmpty() || e.isEmpty()) ? 0 : !f2.isEmpty() ? f2.get(0).intValue() : e.indexOf(g.get(0));
        int m = ((C1911l) this.f6059c).mo8419m();
        float e2 = ((pVar2.mo8100g().mo7396e() * f) / 1000.0f) - 2.0f;
        C1763f a = m7829a(pVar.mo8298g(), 1.0f);
        int[] iArr = f6058f;
        fVar.mo8318a(iArr[0], iArr[1], iArr[2]);
        fVar.mo8316a(a.mo7946c(), a.mo7951g() - (((float) ((intValue - m) + 1)) * e2), a.mo7952h(), e2);
        fVar.mo8331f();
        fVar.mo8317a(0);
    }

    /* renamed from: b */
    private boolean m7839b() {
        C1918s sVar = this.f6059c;
        return (sVar instanceof C1917r) && ((C1917r) sVar).mo8428f() && !((C1917r) this.f6059c).mo8425b() && !((C1917r) this.f6059c).mo8426c() && !((C1917r) this.f6059c).mo8427e();
    }

    /* renamed from: c */
    private C1763f m7840c(C1888l lVar, C1892p pVar) {
        C1763f g = pVar.mo8298g();
        return g == null ? lVar.mo8338a().mo7942a() : g;
    }

    /* renamed from: a */
    public void mo8385a(String str) {
        C1892p pVar;
        this.f6061e = str;
        for (C1888l next : this.f6059c.mo8423n()) {
            C1876i h = this.f6059c.mo8413h();
            if (h == null || h.mo8337b() == null || next.mo7505d().mo7539c(C1613i.f5356r) != null) {
                C1890n c = next.mo8345c();
                if (c == null) {
                    c = new C1890n();
                    next.mo8341a(c);
                }
                C1891o b = c.mo8355b();
                if (b.mo8356a()) {
                    pVar = b.mo8357b();
                } else {
                    C1892p pVar2 = new C1892p(this.f6059c.mo8414i().mo8392a());
                    pVar2.mo8294a(next.mo8338a().mo7942a());
                    c.mo8354a(pVar2);
                    pVar = pVar2;
                }
                if (next.mo8349g() != null || pVar.mo8296e().mo7960f() == 0) {
                    m7831a(next, pVar);
                }
                m7837b(next, pVar);
            }
        }
    }
}
