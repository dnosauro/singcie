package com.cyberneid.p105d.p114g.p126f.p130d;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1622p;
import com.cyberneid.p105d.p114g.p115a.C1689a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.cyberneid.d.g.f.d.g */
public abstract class C1906g extends C1918s {
    C1906g(C1903d dVar, C1607d dVar2, C1912m mVar) {
        super(dVar, dVar2, mVar);
    }

    /* renamed from: b */
    private List<String> m7861b(C1613i iVar) {
        C1605b c = this.f6071c.mo7539c(iVar);
        if (!(c instanceof C1622p)) {
            return c instanceof C1604a ? C1689a.m6907c((C1604a) c) : Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(((C1622p) c).mo7641b());
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void mo8401a();

    /* renamed from: b */
    public List<String> mo8402b() {
        return C1902c.m7848a(this.f6071c.mo7539c(C1613i.f5213fd), 0);
    }

    /* renamed from: c */
    public List<String> mo8403c() {
        return C1902c.m7848a(this.f6071c.mo7539c(C1613i.f5213fd), 1);
    }

    /* renamed from: e */
    public List<String> mo8404e() {
        return mo8402b();
    }

    /* renamed from: f */
    public List<Integer> mo8405f() {
        C1605b c = this.f6071c.mo7539c(C1613i.f5111dh);
        return c != null ? C1689a.m6904a((C1604a) c) : Collections.emptyList();
    }

    /* renamed from: g */
    public List<String> mo8406g() {
        return m7861b(C1613i.f5297hH);
    }
}
