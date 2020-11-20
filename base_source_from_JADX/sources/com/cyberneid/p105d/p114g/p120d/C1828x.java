package com.cyberneid.p105d.p114g.p120d;

import android.util.Log;
import com.cyberneid.p089b.p092c.C1532b;
import com.cyberneid.p089b.p097h.C1586a;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p131h.C1940d;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.cyberneid.d.g.d.x */
public class C1828x extends C1820p {

    /* renamed from: c */
    private final C1815k f5910c;

    /* renamed from: d */
    private C1532b f5911d;

    /* renamed from: e */
    private C1532b f5912e;

    /* renamed from: f */
    private boolean f5913f;

    /* renamed from: g */
    private boolean f5914g;

    /* renamed from: h */
    private C1818n f5915h;

    public C1828x(C1607d dVar) {
        super(dVar);
        C1607d dVar2 = (C1607d) ((C1604a) this.f5884b.mo7539c(C1613i.f5009bl)).mo7485a(0);
        if (dVar2 != null) {
            this.f5910c = C1822r.m7473a(dVar2, this);
            m7513q();
            m7514r();
            return;
        }
        throw new IOException("Missing descendant font dictionary");
    }

    /* renamed from: a */
    private String m7512a(C1819o oVar) {
        if (oVar.mo8154b().equals("GB1")) {
            return "Adobe-GB1-0";
        }
        if (oVar.mo8154b().equals("CNS1")) {
            return "Adobe-CNS1-0";
        }
        if (oVar.mo8154b().equals("Japan1")) {
            return "Adobe-Japan1-1";
        }
        if (oVar.mo8154b().equals("Korea1")) {
            return "Adobe-Korea1-0";
        }
        throw new IllegalStateException();
    }

    /* renamed from: q */
    private void m7513q() {
        C1605b c = this.f5884b.mo7539c(C1613i.f5053cc);
        boolean z = true;
        if (c instanceof C1613i) {
            this.f5911d = C1802c.m7302a(((C1613i) c).mo7596a());
            if (this.f5911d != null) {
                this.f5913f = true;
            } else {
                throw new IOException("Missing required CMap");
            }
        } else if (c != null) {
            this.f5911d = mo8158a(c);
            C1532b bVar = this.f5911d;
            if (bVar == null) {
                throw new IOException("Missing required CMap");
            } else if (!bVar.mo7149a()) {
                Log.w("PdfBox-Android", "Invalid Encoding CMap in font " + mo8099f());
            }
        }
        C1819o i = this.f5910c.mo8150i();
        if (i != null) {
            if (!i.mo8153a().equals("Adobe") || (!i.mo8154b().equals("GB1") && !i.mo8154b().equals("CNS1") && !i.mo8154b().equals("Japan1") && !i.mo8154b().equals("Korea1"))) {
                z = false;
            }
            this.f5914g = z;
        }
    }

    /* renamed from: r */
    private void m7514r() {
        C1532b a;
        if (this.f5913f) {
            String str = null;
            C1605b c = this.f5884b.mo7539c(C1613i.f5053cc);
            if (c instanceof C1613i) {
                str = ((C1613i) c).mo7596a();
            }
            if ("Identity-H".equals(str) || "Identity-V".equals(str)) {
                if (this.f5914g) {
                    str = m7512a(this.f5910c.mo8150i());
                } else {
                    return;
                }
            }
            if (str != null && (a = C1802c.m7302a(str)) != null) {
                C1532b a2 = C1802c.m7302a(a.mo7156d() + "-" + a.mo7159e() + "-UCS2");
                if (a2 != null) {
                    this.f5912e = a2;
                }
            }
        }
    }

    /* renamed from: a */
    public float mo8094a(int i) {
        return this.f5910c.mo8139a(i);
    }

    /* renamed from: a */
    public int mo8095a(InputStream inputStream) {
        return this.f5911d.mo7141a(inputStream);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public float mo8161b(int i) {
        throw new UnsupportedOperationException("not suppported");
    }

    /* renamed from: b */
    public C1821q mo8163b() {
        return this.f5910c.mo8146e();
    }

    /* renamed from: c */
    public float mo8096c(int i) {
        return this.f5910c.mo8141b(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public byte[] mo8097d(int i) {
        return this.f5910c.mo8145d(i);
    }

    /* renamed from: e */
    public String mo8165e(int i) {
        String e = super.mo8165e(i);
        if (e != null) {
            return e;
        }
        if (!this.f5913f || this.f5912e == null) {
            Log.w("PdfBox-Android", "No Unicode mapping for " + ("CID+" + mo8232g(i)) + " (" + i + ") in font " + mo8099f());
            return null;
        }
        return this.f5912e.mo7142a(mo8232g(i));
    }

    /* renamed from: e */
    public boolean mo8098e() {
        return this.f5910c.mo8149h();
    }

    /* renamed from: f */
    public String mo8099f() {
        return mo8233m();
    }

    /* renamed from: f */
    public void mo8167f(int i) {
        if (mo8172l()) {
            this.f5915h.mo8110a(i);
            return;
        }
        throw new IllegalStateException("This font was created with subsetting disabled");
    }

    /* renamed from: g */
    public int mo8232g(int i) {
        return this.f5910c.mo8143c(i);
    }

    /* renamed from: g */
    public C1586a mo8100g() {
        return this.f5910c.mo8148g();
    }

    /* renamed from: i */
    public C1940d mo8101i() {
        return this.f5910c.mo8147f();
    }

    /* renamed from: j */
    public boolean mo8170j() {
        return false;
    }

    /* renamed from: k */
    public void mo8171k() {
        if (mo8172l()) {
            this.f5915h.mo8113b();
            return;
        }
        throw new IllegalStateException("This font was created with subsetting disabled");
    }

    /* renamed from: l */
    public boolean mo8172l() {
        C1818n nVar = this.f5915h;
        return nVar != null && nVar.mo8114c();
    }

    /* renamed from: m */
    public String mo8233m() {
        return this.f5884b.mo7544e(C1613i.f4900I);
    }

    /* renamed from: n */
    public C1815k mo8234n() {
        return this.f5910c;
    }

    /* renamed from: o */
    public C1532b mo8235o() {
        return this.f5911d;
    }

    /* renamed from: p */
    public C1532b mo8236p() {
        return this.f5912e;
    }

    public String toString() {
        String simpleName = mo8234n() != null ? mo8234n().getClass().getSimpleName() : null;
        return getClass().getSimpleName() + "/" + simpleName + " " + mo8233m();
    }
}
