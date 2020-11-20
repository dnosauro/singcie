package com.cyberneid.p105d.p114g;

import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p126f.p130d.C1903d;

/* renamed from: com.cyberneid.d.g.d */
public class C1785d implements C1760c {

    /* renamed from: a */
    private final C1607d f5792a;

    /* renamed from: b */
    private final C1783c f5793b;

    /* renamed from: c */
    private C1903d f5794c;

    public C1785d(C1783c cVar) {
        this.f5793b = cVar;
        this.f5792a = new C1607d();
        this.f5792a.mo7521a(C1613i.f5338hw, (C1605b) C1613i.f4956al);
        this.f5793b.mo8053a().mo7577k().mo7521a(C1613i.f5271gi, (C1605b) this.f5792a);
    }

    public C1785d(C1783c cVar, C1607d dVar) {
        this.f5793b = cVar;
        this.f5792a = dVar;
    }

    /* renamed from: a */
    public C1607d mo7505d() {
        return this.f5792a;
    }

    /* renamed from: a */
    public void mo8079a(C1903d dVar) {
        this.f5792a.mo7522a(C1613i.f5024c, (C1760c) dVar);
        this.f5794c = null;
    }

    /* renamed from: a */
    public void mo8080a(String str) {
        this.f5792a.mo7523a(C1613i.f5299hJ, str);
    }

    /* renamed from: b */
    public C1903d mo8081b() {
        if (this.f5794c == null) {
            C1607d dVar = (C1607d) this.f5792a.mo7539c(C1613i.f5024c);
            this.f5794c = dVar == null ? null : new C1903d(this.f5793b, dVar);
        }
        return this.f5794c;
    }

    /* renamed from: c */
    public C1928g mo8082c() {
        return new C1928g((C1607d) this.f5792a.mo7539c(C1613i.f5228fs), this.f5793b);
    }

    /* renamed from: e */
    public String mo8083e() {
        return this.f5792a.mo7544e(C1613i.f5299hJ);
    }
}
