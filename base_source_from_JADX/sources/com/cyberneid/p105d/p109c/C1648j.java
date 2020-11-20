package com.cyberneid.p105d.p109c;

import com.cyberneid.p105d.p108b.C1613i;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.d.c.j */
public final class C1648j {

    /* renamed from: a */
    public static final C1648j f5455a = new C1648j();

    /* renamed from: b */
    private final Map<C1613i, C1647i> f5456b = new HashMap();

    private C1648j() {
        C1649k kVar = new C1649k();
        C1645g gVar = new C1645g();
        C1643e eVar = new C1643e();
        C1651m mVar = new C1651m();
        C1642d dVar = new C1642d();
        C1627a aVar = new C1627a();
        C1653o oVar = new C1653o();
        C1644f fVar = new C1644f();
        this.f5456b.put(C1613i.f5028cD, kVar);
        this.f5456b.put(C1613i.f5029cE, kVar);
        this.f5456b.put(C1613i.f5000bc, gVar);
        this.f5456b.put(C1613i.f5001bd, gVar);
        this.f5456b.put(C1613i.f4957am, eVar);
        this.f5456b.put(C1613i.f4958an, eVar);
        this.f5456b.put(C1613i.f5160ed, mVar);
        this.f5456b.put(C1613i.f5161ee, mVar);
        this.f5456b.put(C1613i.f5363y, dVar);
        this.f5456b.put(C1613i.f5364z, dVar);
        this.f5456b.put(C1613i.f4892A, aVar);
        this.f5456b.put(C1613i.f4893B, aVar);
        this.f5456b.put(C1613i.f5274gl, oVar);
        this.f5456b.put(C1613i.f5275gm, oVar);
        this.f5456b.put(C1613i.f4941aW, fVar);
    }

    /* renamed from: a */
    public C1647i mo7694a(C1613i iVar) {
        C1647i iVar2 = this.f5456b.get(iVar);
        if (iVar2 != null) {
            return iVar2;
        }
        throw new IOException("Invalid filter: " + iVar);
    }
}
