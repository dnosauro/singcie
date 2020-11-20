package com.cyberneid.p105d.p114g.p126f.p130d;

import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p126f.p128b.C1888l;
import com.cyberneid.p105d.p114g.p126f.p129c.C1896c;
import java.util.HashSet;

/* renamed from: com.cyberneid.d.g.f.d.p */
public class C1915p extends C1916q {
    public C1915p(C1903d dVar) {
        super(dVar);
        this.f6071c.mo7521a(C1613i.f5044cT, (C1605b) C1613i.f5286gx);
        mo8423n().get(0).mo8344b(true);
        mo8423n().get(0).mo8342a(true);
        mo8412a(m7889e());
    }

    C1915p(C1903d dVar, C1607d dVar2, C1912m mVar) {
        super(dVar, dVar2, mVar);
    }

    /* renamed from: e */
    private String m7889e() {
        HashSet hashSet = new HashSet();
        for (C1909j next : this.f6069a.mo8398c()) {
            if (next instanceof C1915p) {
                hashSet.add(next.mo8416k());
            }
        }
        int i = 1;
        while (true) {
            if (hashSet.contains("Signature" + i)) {
                i++;
            } else {
                return "Signature" + i;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8401a() {
        C1888l lVar = mo8423n().get(0);
        if (lVar != null && lVar.mo8338a() != null) {
            if (!(lVar.mo8338a().mo7953i() == 0.0f && lVar.mo8338a().mo7952h() == 0.0f) && !lVar.mo8347f() && !lVar.mo8346e()) {
                throw new UnsupportedOperationException("not implemented");
            }
        }
    }

    /* renamed from: a */
    public void mo8420a(C1896c cVar) {
        this.f6071c.mo7522a(C1613i.f5297hH, (C1760c) cVar);
        mo8424o();
    }

    /* renamed from: b */
    public C1896c mo8421b() {
        return mo8422c();
    }

    /* renamed from: c */
    public C1896c mo8422c() {
        C1605b c = this.f6071c.mo7539c(C1613i.f5297hH);
        if (c == null) {
            return null;
        }
        return new C1896c((C1607d) c);
    }
}
