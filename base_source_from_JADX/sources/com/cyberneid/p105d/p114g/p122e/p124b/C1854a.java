package com.cyberneid.p105d.p114g.p122e.p124b;

import com.cyberneid.p099c.p100a.p101a.C1592a;
import com.cyberneid.p105d.p106a.C1602a;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1609f;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.C1931h;
import com.cyberneid.p105d.p114g.C1932i;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p115a.C1763f;
import com.cyberneid.p105d.p114g.p115a.C1764g;
import com.cyberneid.p105d.p114g.p122e.C1832a;
import java.io.InputStream;

/* renamed from: com.cyberneid.d.g.e.b.a */
public class C1854a extends C1832a implements C1602a {

    /* renamed from: a */
    private final C1932i f6000a = null;

    public C1854a(C1619o oVar) {
        super(oVar, C1613i.f5041cQ);
    }

    public C1854a(C1764g gVar) {
        super(gVar, C1613i.f5041cQ);
    }

    public C1854a(C1783c cVar) {
        super(cVar, C1613i.f5041cQ);
    }

    /* renamed from: a */
    public InputStream mo7477a() {
        return mo8251b().mo7627l();
    }

    /* renamed from: a */
    public void mo8292a(int i) {
        mo8251b().mo7518a(C1613i.f5042cR, i);
    }

    /* renamed from: a */
    public void mo8293a(C1592a aVar) {
        C1604a aVar2 = new C1604a();
        double[] dArr = new double[6];
        aVar.mo7407a(dArr);
        for (double d : dArr) {
            aVar2.mo7490a((C1605b) new C1609f((float) d));
        }
        mo8251b().mo7521a(C1613i.f5167ek, (C1605b) aVar2);
    }

    /* renamed from: a */
    public void mo8294a(C1763f fVar) {
        if (fVar == null) {
            mo8251b().mo7553j(C1613i.f4902K);
        } else {
            mo8251b().mo7521a(C1613i.f4902K, (C1605b) fVar.mo7944b());
        }
    }

    /* renamed from: a */
    public void mo8295a(C1931h hVar) {
        mo8251b().mo7522a(C1613i.f5267ge, (C1760c) hVar);
    }

    /* renamed from: e */
    public C1764g mo8296e() {
        return new C1764g(mo8251b());
    }

    /* renamed from: f */
    public C1931h mo8297f() {
        C1607d dVar = (C1607d) mo8251b().mo7539c(C1613i.f5267ge);
        if (dVar != null) {
            return new C1931h(dVar, this.f6000a);
        }
        return null;
    }

    /* renamed from: g */
    public C1763f mo8298g() {
        C1604a aVar = (C1604a) mo8251b().mo7539c(C1613i.f4902K);
        if (aVar != null) {
            return new C1763f(aVar);
        }
        return null;
    }
}
