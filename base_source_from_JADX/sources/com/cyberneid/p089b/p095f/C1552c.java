package com.cyberneid.p089b.p095f;

/* renamed from: com.cyberneid.b.f.c */
public class C1552c extends C1578z {

    /* renamed from: a */
    private C1549b[] f4614a;

    C1552c(C1544ab abVar) {
        super(abVar);
    }

    /* renamed from: a */
    public C1549b mo7220a(int i, int i2) {
        for (C1549b bVar : this.f4614a) {
            if (bVar.mo7210b() == i && bVar.mo7205a() == i2) {
                return bVar;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void mo7175a(C1544ab abVar, C1575w wVar) {
        wVar.mo7281d();
        int d = wVar.mo7281d();
        this.f4614a = new C1549b[d];
        for (int i = 0; i < d; i++) {
            C1549b bVar = new C1549b();
            bVar.mo7208a(wVar);
            this.f4614a[i] = bVar;
        }
        for (int i2 = 0; i2 < d; i2++) {
            this.f4614a[i2].mo7207a(this, abVar.mo7201u(), wVar);
        }
        this.f4757b = true;
    }

    /* renamed from: a */
    public C1549b[] mo7221a() {
        return this.f4614a;
    }
}
