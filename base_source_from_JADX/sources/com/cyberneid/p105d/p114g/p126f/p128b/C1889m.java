package com.cyberneid.p105d.p114g.p126f.p128b;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p122e.p123a.C1837e;
import com.cyberneid.p105d.p114g.p122e.p123a.C1838f;
import com.cyberneid.p105d.p114g.p122e.p123a.C1841i;
import com.cyberneid.p105d.p114g.p122e.p123a.C1845m;

/* renamed from: com.cyberneid.d.g.f.b.m */
public class C1889m implements C1760c {

    /* renamed from: a */
    private final C1607d f6037a;

    public C1889m(C1607d dVar) {
        this.f6037a = dVar;
    }

    /* renamed from: a */
    private C1837e m7789a(C1613i iVar) {
        C1605b k = mo7505d().mo7554k(iVar);
        C1838f fVar = null;
        if (!(k instanceof C1604a)) {
            return null;
        }
        C1604a aVar = (C1604a) k;
        int b = aVar.mo7494b();
        if (b == 1) {
            fVar = C1841i.f5963a;
        } else if (b == 3) {
            fVar = C1845m.f5975a;
        }
        return new C1837e(aVar, fVar);
    }

    /* renamed from: a */
    public C1607d mo7505d() {
        return this.f6037a;
    }

    /* renamed from: b */
    public C1837e mo8352b() {
        return m7789a(C1613i.f4903L);
    }
}
