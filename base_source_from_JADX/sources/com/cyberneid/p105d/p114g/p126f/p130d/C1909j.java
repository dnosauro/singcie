package com.cyberneid.p105d.p114g.p126f.p130d;

import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p126f.p127a.C1876i;

/* renamed from: com.cyberneid.d.g.f.d.j */
public abstract class C1909j implements C1760c {

    /* renamed from: a */
    protected final C1903d f6069a;

    /* renamed from: b */
    protected final C1912m f6070b;

    /* renamed from: c */
    protected final C1607d f6071c;

    C1909j(C1903d dVar) {
        this(dVar, new C1607d(), (C1912m) null);
    }

    C1909j(C1903d dVar, C1607d dVar2, C1912m mVar) {
        this.f6069a = dVar;
        this.f6071c = dVar2;
        this.f6070b = mVar;
    }

    /* renamed from: a */
    static C1909j m7874a(C1903d dVar, C1607d dVar2, C1912m mVar) {
        return C1910k.m7883a(dVar, dVar2, mVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1605b mo8411a(C1613i iVar) {
        C1607d b;
        if (this.f6071c.mo7555l(iVar)) {
            b = this.f6071c;
        } else {
            C1912m mVar = this.f6070b;
            if (mVar != null) {
                return mVar.mo8411a(iVar);
            }
            b = this.f6069a.mo7505d();
        }
        return b.mo7539c(iVar);
    }

    /* renamed from: a */
    public void mo8412a(String str) {
        this.f6071c.mo7536b(C1613i.f5316ha, str);
    }

    /* renamed from: h */
    public C1876i mo8413h() {
        C1607d dVar = (C1607d) this.f6071c.mo7539c(C1613i.f4971b);
        if (dVar != null) {
            return new C1876i(dVar);
        }
        return null;
    }

    /* renamed from: i */
    public C1903d mo8414i() {
        return this.f6069a;
    }

    /* renamed from: j */
    public C1607d mo7505d() {
        return this.f6071c;
    }

    /* renamed from: k */
    public String mo8416k() {
        return this.f6071c.mo7545f(C1613i.f5316ha);
    }

    /* renamed from: l */
    public String mo8417l() {
        String k = mo8416k();
        C1912m mVar = this.f6070b;
        String l = mVar != null ? mVar.mo8417l() : null;
        if (l == null) {
            return k;
        }
        if (k == null) {
            return l;
        }
        return l + "." + k;
    }

    public String toString() {
        return mo8417l() + "{type: " + getClass().getSimpleName() + " value: " + mo8411a(C1613i.f5297hH) + "}";
    }
}
