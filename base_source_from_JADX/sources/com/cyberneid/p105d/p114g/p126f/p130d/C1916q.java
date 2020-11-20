package com.cyberneid.p105d.p114g.p126f.p130d;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p126f.p128b.C1888l;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cyberneid.d.g.f.d.q */
public abstract class C1916q extends C1909j {
    protected C1916q(C1903d dVar) {
        super(dVar);
    }

    C1916q(C1903d dVar, C1607d dVar2, C1912m mVar) {
        super(dVar, dVar2, mVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo8401a();

    /* renamed from: n */
    public List<C1888l> mo8423n() {
        ArrayList arrayList = new ArrayList();
        C1604a aVar = (C1604a) this.f6071c.mo7539c(C1613i.f5084dG);
        if (aVar == null) {
            arrayList.add(new C1888l(this.f6071c));
        } else if (aVar.mo7494b() > 0) {
            for (int i = 0; i < aVar.mo7494b(); i++) {
                C1605b a = aVar.mo7485a(i);
                if (a instanceof C1607d) {
                    arrayList.add(new C1888l((C1607d) a));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public final void mo8424o() {
        if (!this.f6069a.mo8399e()) {
            mo8401a();
        }
    }
}
