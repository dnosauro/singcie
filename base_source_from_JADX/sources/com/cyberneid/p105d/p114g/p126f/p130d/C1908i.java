package com.cyberneid.p105d.p114g.p126f.p130d;

import com.cyberneid.p105d.p106a.p107a.C1603a;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1615k;
import com.cyberneid.p105d.p108b.C1622p;
import com.cyberneid.p105d.p112e.C1672g;
import com.cyberneid.p105d.p114g.C1867f;
import com.cyberneid.p105d.p114g.C1931h;
import com.cyberneid.p105d.p114g.p120d.C1820p;
import com.cyberneid.p105d.p114g.p126f.p128b.C1892p;
import java.io.IOException;
import java.util.List;

/* renamed from: com.cyberneid.d.g.f.d.i */
class C1908i {

    /* renamed from: a */
    private final List<Object> f6067a;

    /* renamed from: b */
    private final C1931h f6068b;

    C1908i(C1622p pVar, C1931h hVar) {
        if (pVar == null) {
            throw new IllegalArgumentException("/DA is a required entry");
        } else if (hVar != null) {
            C1672g gVar = new C1672g(pVar.mo7643c());
            gVar.mo7778r();
            this.f6067a = gVar.mo7779s();
            this.f6068b = hVar;
        } else {
            throw new IllegalArgumentException("/DR is a required entry");
        }
    }

    /* renamed from: c */
    private C1613i m7869c() {
        return (C1613i) this.f6067a.get(this.f6067a.indexOf(C1603a.m6344a("Tf")) - 2);
    }

    /* renamed from: a */
    public float mo8407a() {
        int indexOf;
        if (this.f6067a.isEmpty() || (indexOf = this.f6067a.indexOf(C1603a.m6344a("Tf"))) == -1) {
            return 12.0f;
        }
        return ((C1615k) this.f6067a.get(indexOf - 1)).mo7583a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8408a(C1892p pVar) {
        C1931h f = pVar.mo8297f();
        if (f == null) {
            f = new C1931h();
            pVar.mo8295a(f);
        }
        C1613i c = m7869c();
        if (f.mo8468a(c) == null) {
            f.mo8469a(c, mo8410b());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8409a(C1867f fVar, float f) {
        float a = mo8407a();
        if (a != 0.0f) {
            f = a;
        }
        fVar.mo8319a(mo8410b(), f);
    }

    /* renamed from: b */
    public C1820p mo8410b() {
        C1613i c = m7869c();
        C1820p a = this.f6068b.mo8468a(c);
        if (a != null) {
            return a;
        }
        throw new IOException("Could not find font: /" + c.mo7596a());
    }
}
