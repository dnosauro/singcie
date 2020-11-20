package com.cyberneid.p105d.p114g.p126f.p130d;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.C1931h;
import com.cyberneid.p105d.p114g.p115a.C1689a;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.cyberneid.d.g.f.d.d */
public final class C1903d implements C1760c {

    /* renamed from: a */
    private final C1783c f6065a;

    /* renamed from: b */
    private final C1607d f6066b;

    public C1903d(C1783c cVar) {
        this.f6065a = cVar;
        this.f6066b = new C1607d();
        this.f6066b.mo7521a(C1613i.f5072cv, (C1605b) new C1604a());
    }

    public C1903d(C1783c cVar, C1607d dVar) {
        this.f6065a = cVar;
        this.f6066b = dVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1783c mo8392a() {
        return this.f6065a;
    }

    /* renamed from: a */
    public void mo8393a(C1931h hVar) {
        this.f6066b.mo7522a(C1613i.f4985bN, (C1760c) hVar);
    }

    /* renamed from: a */
    public void mo8394a(List<C1909j> list) {
        this.f6066b.mo7521a(C1613i.f5072cv, (C1605b) C1689a.m6903a((List<?>) list));
    }

    /* renamed from: a */
    public void mo8395a(boolean z) {
        this.f6066b.mo7519a(C1613i.f5287gy, 1, z);
    }

    /* renamed from: b */
    public C1607d mo7505d() {
        return this.f6066b;
    }

    /* renamed from: b */
    public void mo8397b(boolean z) {
        this.f6066b.mo7519a(C1613i.f5287gy, 2, z);
    }

    /* renamed from: c */
    public List<C1909j> mo8398c() {
        C1909j a;
        C1604a aVar = (C1604a) this.f6066b.mo7539c(C1613i.f5072cv);
        if (aVar == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aVar.mo7494b(); i++) {
            C1607d dVar = (C1607d) aVar.mo7485a(i);
            if (!(dVar == null || (a = C1909j.m7874a(this, dVar, (C1912m) null)) == null)) {
                arrayList.add(a);
            }
        }
        return new C1689a(arrayList, aVar);
    }

    /* renamed from: e */
    public boolean mo8399e() {
        return this.f6066b.mo7538b(C1613i.f5131eA, false);
    }

    /* renamed from: f */
    public C1931h mo8400f() {
        C1607d dVar = (C1607d) this.f6066b.mo7539c(C1613i.f4985bN);
        if (dVar != null) {
            return new C1931h(dVar);
        }
        return null;
    }
}
