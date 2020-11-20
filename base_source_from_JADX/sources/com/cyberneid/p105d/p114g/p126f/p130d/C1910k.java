package com.cyberneid.p105d.p114g.p126f.p130d;

import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* renamed from: com.cyberneid.d.g.f.d.k */
final class C1910k {
    /* renamed from: a */
    static C1909j m7883a(C1903d dVar, C1607d dVar2, C1912m mVar) {
        String a = m7884a(dVar2);
        if ("Ch".equals(a)) {
            return m7885b(dVar, dVar2, mVar);
        }
        if ("Tx".equals(a)) {
            return new C1917r(dVar, dVar2, mVar);
        }
        if ("Sig".equals(a)) {
            return new C1915p(dVar, dVar2, mVar);
        }
        if ("Btn".equals(a)) {
            return m7886c(dVar, dVar2, mVar);
        }
        if (dVar2.mo7555l(C1613i.f5084dG)) {
            return new C1912m(dVar, dVar2, mVar);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r3 = (com.cyberneid.p105d.p108b.C1607d) r3.mo7513a(com.cyberneid.p105d.p108b.C1613i.f5232fw, com.cyberneid.p105d.p108b.C1613i.f5223fn);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m7884a(com.cyberneid.p105d.p108b.C1607d r3) {
        /*
            com.cyberneid.d.b.i r0 = com.cyberneid.p105d.p108b.C1613i.f5044cT
            java.lang.String r0 = r3.mo7544e(r0)
            if (r0 != 0) goto L_0x0018
            com.cyberneid.d.b.i r1 = com.cyberneid.p105d.p108b.C1613i.f5232fw
            com.cyberneid.d.b.i r2 = com.cyberneid.p105d.p108b.C1613i.f5223fn
            com.cyberneid.d.b.b r3 = r3.mo7513a((com.cyberneid.p105d.p108b.C1613i) r1, (com.cyberneid.p105d.p108b.C1613i) r2)
            com.cyberneid.d.b.d r3 = (com.cyberneid.p105d.p108b.C1607d) r3
            if (r3 == 0) goto L_0x0018
            java.lang.String r0 = m7884a(r3)
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p126f.p130d.C1910k.m7884a(com.cyberneid.d.b.d):java.lang.String");
    }

    /* renamed from: b */
    private static C1909j m7885b(C1903d dVar, C1607d dVar2, C1912m mVar) {
        return (dVar2.mo7529b(C1613i.f5071cu, 0) & 131072) != 0 ? new C1907h(dVar, dVar2, mVar) : new C1911l(dVar, dVar2, mVar);
    }

    /* renamed from: c */
    private static C1909j m7886c(C1903d dVar, C1607d dVar2, C1912m mVar) {
        int b = dVar2.mo7529b(C1613i.f5071cu, 0);
        return (32768 & b) != 0 ? new C1914o(dVar, dVar2, mVar) : (b & PKIFailureInfo.notAuthorized) != 0 ? new C1913n(dVar, dVar2, mVar) : new C1905f(dVar, dVar2, mVar);
    }
}
