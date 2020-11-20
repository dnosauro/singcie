package com.cyberneid.p105d.p114g.p126f.p127a;

import com.cyberneid.p105d.p108b.C1607d;

/* renamed from: com.cyberneid.d.g.f.a.b */
public final class C1869b {
    /* renamed from: a */
    public static C1868a m7770a(C1607d dVar) {
        if (dVar != null) {
            String a = dVar.mo7515a("S");
            if ("JavaScript".equals(a)) {
                return new C1871d(dVar);
            }
            if ("GoTo".equals(a)) {
                return new C1870c(dVar);
            }
            if ("Launch".equals(a)) {
                return new C1872e(dVar);
            }
            if ("GoToR".equals(a)) {
                return new C1874g(dVar);
            }
            if ("URI".equals(a)) {
                return new C1875h(dVar);
            }
            if ("Named".equals(a)) {
                return new C1873f(dVar);
            }
        }
        return null;
    }
}
