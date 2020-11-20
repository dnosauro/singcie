package com.cyberneid.p089b.p095f;

/* renamed from: com.cyberneid.b.f.s */
public class C1571s extends C1544ab {

    /* renamed from: b */
    private boolean f4732b;

    C1571s(C1575w wVar) {
        super(wVar);
    }

    /* renamed from: a */
    public synchronized C1542a mo7337a() {
        C1542a aVar;
        if (this.f4732b) {
            aVar = (C1542a) this.f4572a.get("CFF ");
            if (aVar != null && !aVar.mo7370F()) {
                mo7184c((C1578z) aVar);
            }
        } else {
            throw new UnsupportedOperationException("TTF fonts do not have a CFF table");
        }
        return aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7180a(float f) {
        this.f4732b = ((double) f) != 1.0d;
        super.mo7180a(f);
    }

    /* renamed from: e */
    public synchronized C1554e mo7186e() {
        if (!this.f4732b) {
        } else {
            throw new UnsupportedOperationException("OTF fonts do not have a glyf table");
        }
        return super.mo7186e();
    }

    /* renamed from: f */
    public boolean mo7338f() {
        return this.f4572a.containsKey("CFF ");
    }

    /* renamed from: g */
    public boolean mo7339g() {
        return this.f4572a.containsKey("BASE") || this.f4572a.containsKey("GDEF") || this.f4572a.containsKey("GPOS") || this.f4572a.containsKey("GSUB") || this.f4572a.containsKey("JSTF");
    }
}
