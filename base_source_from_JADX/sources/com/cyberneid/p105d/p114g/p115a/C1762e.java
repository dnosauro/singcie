package com.cyberneid.p105d.p114g.p115a;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1609f;
import com.cyberneid.p105d.p108b.C1615k;

/* renamed from: com.cyberneid.d.g.a.e */
public class C1762e implements C1760c {

    /* renamed from: a */
    private C1604a f5731a;

    /* renamed from: b */
    private int f5732b;

    public C1762e() {
        this.f5731a = new C1604a();
        this.f5731a.mo7490a((C1605b) new C1609f(0.0f));
        this.f5731a.mo7490a((C1605b) new C1609f(1.0f));
        this.f5732b = 0;
    }

    public C1762e(C1604a aVar, int i) {
        this.f5731a = aVar;
        this.f5732b = i;
    }

    /* renamed from: a */
    public float mo7939a() {
        return ((C1615k) this.f5731a.mo7485a(this.f5732b * 2)).mo7583a();
    }

    /* renamed from: b */
    public float mo7940b() {
        return ((C1615k) this.f5731a.mo7485a((this.f5732b * 2) + 1)).mo7583a();
    }

    /* renamed from: d */
    public C1605b mo7505d() {
        return this.f5731a;
    }

    public String toString() {
        return "PDRange{" + mo7939a() + ", " + mo7940b() + '}';
    }
}
