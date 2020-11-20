package com.cyberneid.p105d.p114g;

import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1616l;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p120d.C1820p;
import com.cyberneid.p105d.p114g.p120d.C1822r;
import com.cyberneid.p105d.p114g.p122e.p123a.C1838f;
import com.cyberneid.p105d.p114g.p122e.p125c.C1861e;

/* renamed from: com.cyberneid.d.g.h */
public final class C1931h implements C1760c {

    /* renamed from: a */
    private final C1607d f6106a;

    /* renamed from: b */
    private final C1932i f6107b;

    public C1931h() {
        this.f6106a = new C1607d();
        this.f6107b = null;
    }

    public C1931h(C1607d dVar) {
        if (dVar != null) {
            this.f6106a = dVar;
            this.f6107b = null;
            return;
        }
        throw new IllegalArgumentException("resourceDictionary is null");
    }

    public C1931h(C1607d dVar, C1932i iVar) {
        if (dVar != null) {
            this.f6106a = dVar;
            this.f6107b = iVar;
            return;
        }
        throw new IllegalArgumentException("resourceDictionary is null");
    }

    /* renamed from: a */
    private C1613i m7952a(C1613i iVar, String str) {
        String str2;
        C1607d dVar = (C1607d) this.f6106a.mo7539c(iVar);
        if (dVar == null) {
            return C1613i.m6461a(str + 1);
        }
        int size = dVar.mo7540c().size();
        do {
            size++;
            str2 = str + size;
        } while (dVar.mo7542c(str2));
        return C1613i.m6461a(str2);
    }

    /* renamed from: a */
    private C1613i m7953a(C1613i iVar, String str, C1760c cVar) {
        C1607d dVar = (C1607d) this.f6106a.mo7539c(iVar);
        if (dVar != null && dVar.mo7527a((Object) cVar.mo7505d())) {
            return dVar.mo7534b((Object) cVar.mo7505d());
        }
        C1613i a = m7952a(iVar, str);
        m7955a(iVar, a, cVar);
        return a;
    }

    /* renamed from: a */
    private C1616l m7954a(C1613i iVar, C1613i iVar2) {
        C1607d dVar = (C1607d) this.f6106a.mo7539c(iVar);
        if (dVar == null) {
            return null;
        }
        C1605b k = dVar.mo7554k(iVar2);
        if (k instanceof C1616l) {
            return (C1616l) k;
        }
        return null;
    }

    /* renamed from: a */
    private void m7955a(C1613i iVar, C1613i iVar2, C1760c cVar) {
        C1607d dVar = (C1607d) this.f6106a.mo7539c(iVar);
        if (dVar == null) {
            dVar = new C1607d();
            this.f6106a.mo7521a(iVar, (C1605b) dVar);
        }
        dVar.mo7522a(iVar2, cVar);
    }

    /* renamed from: b */
    private C1605b m7956b(C1613i iVar, C1613i iVar2) {
        C1607d dVar = (C1607d) this.f6106a.mo7539c(iVar);
        if (dVar == null) {
            return null;
        }
        return dVar.mo7539c(iVar2);
    }

    /* renamed from: a */
    public C1607d mo7505d() {
        return this.f6106a;
    }

    /* renamed from: a */
    public C1613i mo8465a(C1820p pVar) {
        return m7953a(C1613i.f5030cF, "F", (C1760c) pVar);
    }

    /* renamed from: a */
    public C1613i mo8466a(C1838f fVar) {
        return m7953a(C1613i.f4929aK, "cs", (C1760c) fVar);
    }

    /* renamed from: a */
    public C1613i mo8467a(C1861e eVar) {
        return m7953a(C1613i.f5314hY, "Im", (C1760c) eVar);
    }

    /* renamed from: a */
    public C1820p mo8468a(C1613i iVar) {
        C1820p a;
        C1616l a2 = m7954a(C1613i.f5030cF, iVar);
        C1932i iVar2 = this.f6107b;
        if (iVar2 != null && a2 != null && (a = iVar2.mo7850a(a2)) != null) {
            return a;
        }
        C1820p pVar = null;
        C1607d dVar = (C1607d) m7956b(C1613i.f5030cF, iVar);
        if (dVar != null) {
            pVar = C1822r.m7474a(dVar);
        }
        C1932i iVar3 = this.f6107b;
        if (iVar3 != null) {
            iVar3.mo7851a(a2, pVar);
        }
        return pVar;
    }

    /* renamed from: a */
    public void mo8469a(C1613i iVar, C1820p pVar) {
        m7955a(C1613i.f5030cF, iVar, (C1760c) pVar);
    }

    /* renamed from: b */
    public C1838f mo8470b(C1613i iVar) {
        C1838f b;
        C1616l a = m7954a(C1613i.f5030cF, iVar);
        C1932i iVar2 = this.f6107b;
        if (iVar2 != null && a != null && (b = iVar2.mo7853b(a)) != null) {
            return b;
        }
        C1605b b2 = m7956b(C1613i.f4929aK, iVar);
        C1838f a2 = b2 != null ? C1838f.m7590a(b2, this) : C1838f.m7590a((C1605b) iVar, this);
        C1932i iVar3 = this.f6107b;
        if (iVar3 != null) {
            iVar3.mo7852a(a, a2);
        }
        return a2;
    }

    /* renamed from: b */
    public C1932i mo8471b() {
        return this.f6107b;
    }

    /* renamed from: c */
    public boolean mo8472c(C1613i iVar) {
        return m7956b(C1613i.f4929aK, iVar) != null;
    }
}
