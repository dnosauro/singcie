package androidx.constraintlayout.p019a.p020a;

import androidx.constraintlayout.p019a.C0444e;
import androidx.constraintlayout.p019a.C0450h;
import androidx.constraintlayout.p019a.p020a.C0420e;

/* renamed from: androidx.constraintlayout.a.a.m */
public class C0435m extends C0437o {

    /* renamed from: a */
    C0420e f1595a;

    /* renamed from: b */
    float f1596b;

    /* renamed from: c */
    C0435m f1597c;

    /* renamed from: d */
    float f1598d;

    /* renamed from: e */
    C0435m f1599e;

    /* renamed from: f */
    float f1600f;

    /* renamed from: g */
    int f1601g = 0;

    /* renamed from: j */
    private C0435m f1602j;

    /* renamed from: k */
    private float f1603k;

    /* renamed from: l */
    private C0436n f1604l = null;

    /* renamed from: m */
    private int f1605m = 1;

    /* renamed from: n */
    private C0436n f1606n = null;

    /* renamed from: o */
    private int f1607o = 1;

    public C0435m(C0420e eVar) {
        this.f1595a = eVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo3123a(int i) {
        return i == 1 ? "DIRECT" : i == 2 ? "CENTER" : i == 3 ? "MATCH" : i == 4 ? "CHAIN" : i == 5 ? "BARRIER" : "UNCONNECTED";
    }

    /* renamed from: a */
    public void mo3124a() {
        C0435m mVar;
        C0435m mVar2;
        C0435m mVar3;
        C0435m mVar4;
        C0435m mVar5;
        C0435m mVar6;
        C0435m mVar7;
        float f;
        float f2;
        float f3;
        C0435m mVar8;
        float f4;
        boolean z = true;
        if (this.f1610i != 1 && this.f1601g != 4) {
            C0436n nVar = this.f1604l;
            if (nVar != null) {
                if (nVar.f1610i == 1) {
                    this.f1598d = ((float) this.f1605m) * this.f1604l.f1608a;
                } else {
                    return;
                }
            }
            C0436n nVar2 = this.f1606n;
            if (nVar2 != null) {
                if (nVar2.f1610i == 1) {
                    this.f1603k = ((float) this.f1607o) * this.f1606n.f1608a;
                } else {
                    return;
                }
            }
            if (this.f1601g == 1 && ((mVar8 = this.f1597c) == null || mVar8.f1610i == 1)) {
                C0435m mVar9 = this.f1597c;
                if (mVar9 == null) {
                    this.f1599e = this;
                    f4 = this.f1598d;
                } else {
                    this.f1599e = mVar9.f1599e;
                    f4 = mVar9.f1600f + this.f1598d;
                }
                this.f1600f = f4;
                mo3141f();
                return;
            }
            if (this.f1601g == 2 && (mVar4 = this.f1597c) != null && mVar4.f1610i == 1 && (mVar5 = this.f1602j) != null && (mVar6 = mVar5.f1597c) != null && mVar6.f1610i == 1) {
                if (C0444e.m1810a() != null) {
                    C0444e.m1810a().f1674w++;
                }
                this.f1599e = this.f1597c.f1599e;
                C0435m mVar10 = this.f1602j;
                mVar10.f1599e = mVar10.f1597c.f1599e;
                int i = 0;
                if (!(this.f1595a.f1442b == C0420e.C0424c.RIGHT || this.f1595a.f1442b == C0420e.C0424c.BOTTOM)) {
                    z = false;
                }
                if (z) {
                    f = this.f1597c.f1600f;
                    mVar7 = this.f1602j.f1597c;
                } else {
                    f = this.f1602j.f1597c.f1600f;
                    mVar7 = this.f1597c;
                }
                float f5 = f - mVar7.f1600f;
                if (this.f1595a.f1442b == C0420e.C0424c.LEFT || this.f1595a.f1442b == C0420e.C0424c.RIGHT) {
                    f3 = f5 - ((float) this.f1595a.f1441a.mo3081p());
                    f2 = this.f1595a.f1441a.f1487S;
                } else {
                    f3 = f5 - ((float) this.f1595a.f1441a.mo3085r());
                    f2 = this.f1595a.f1441a.f1488T;
                }
                int e = this.f1595a.mo3012e();
                int e2 = this.f1602j.f1595a.mo3012e();
                if (this.f1595a.mo3014g() == this.f1602j.f1595a.mo3014g()) {
                    f2 = 0.5f;
                    e2 = 0;
                } else {
                    i = e;
                }
                float f6 = (float) i;
                float f7 = (float) e2;
                float f8 = (f3 - f6) - f7;
                if (z) {
                    C0435m mVar11 = this.f1602j;
                    mVar11.f1600f = mVar11.f1597c.f1600f + f7 + (f8 * f2);
                    this.f1600f = (this.f1597c.f1600f - f6) - (f8 * (1.0f - f2));
                } else {
                    this.f1600f = this.f1597c.f1600f + f6 + (f8 * f2);
                    C0435m mVar12 = this.f1602j;
                    mVar12.f1600f = (mVar12.f1597c.f1600f - f7) - (f8 * (1.0f - f2));
                }
            } else if (this.f1601g == 3 && (mVar = this.f1597c) != null && mVar.f1610i == 1 && (mVar2 = this.f1602j) != null && (mVar3 = mVar2.f1597c) != null && mVar3.f1610i == 1) {
                if (C0444e.m1810a() != null) {
                    C0444e.m1810a().f1675x++;
                }
                C0435m mVar13 = this.f1597c;
                this.f1599e = mVar13.f1599e;
                C0435m mVar14 = this.f1602j;
                C0435m mVar15 = mVar14.f1597c;
                mVar14.f1599e = mVar15.f1599e;
                this.f1600f = mVar13.f1600f + this.f1598d;
                mVar14.f1600f = mVar15.f1600f + mVar14.f1598d;
            } else if (this.f1601g == 5) {
                this.f1595a.f1441a.mo3002c();
                return;
            } else {
                return;
            }
            mo3141f();
            this.f1602j.mo3141f();
        }
    }

    /* renamed from: a */
    public void mo3125a(int i, C0435m mVar, int i2) {
        this.f1601g = i;
        this.f1597c = mVar;
        this.f1598d = (float) i2;
        this.f1597c.mo3139a(this);
    }

    /* renamed from: a */
    public void mo3126a(C0435m mVar, float f) {
        if (this.f1610i == 0 || !(this.f1599e == mVar || this.f1600f == f)) {
            this.f1599e = mVar;
            this.f1600f = f;
            if (this.f1610i == 1) {
                mo3140e();
            }
            mo3141f();
        }
    }

    /* renamed from: a */
    public void mo3127a(C0435m mVar, int i) {
        this.f1597c = mVar;
        this.f1598d = (float) i;
        this.f1597c.mo3139a(this);
    }

    /* renamed from: a */
    public void mo3128a(C0435m mVar, int i, C0436n nVar) {
        this.f1597c = mVar;
        this.f1597c.mo3139a(this);
        this.f1604l = nVar;
        this.f1605m = i;
        this.f1604l.mo3139a(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3129a(C0444e eVar) {
        C0450h b = this.f1595a.mo3009b();
        C0435m mVar = this.f1599e;
        if (mVar == null) {
            eVar.mo3184a(b, (int) (this.f1600f + 0.5f));
        } else {
            eVar.mo3194c(b, eVar.mo3179a((Object) mVar.f1595a), (int) (this.f1600f + 0.5f), 6);
        }
    }

    /* renamed from: b */
    public void mo3130b() {
        super.mo3130b();
        this.f1597c = null;
        this.f1598d = 0.0f;
        this.f1604l = null;
        this.f1605m = 1;
        this.f1606n = null;
        this.f1607o = 1;
        this.f1599e = null;
        this.f1600f = 0.0f;
        this.f1596b = 0.0f;
        this.f1602j = null;
        this.f1603k = 0.0f;
        this.f1601g = 0;
    }

    /* renamed from: b */
    public void mo3131b(int i) {
        this.f1601g = i;
    }

    /* renamed from: b */
    public void mo3132b(C0435m mVar, float f) {
        this.f1602j = mVar;
        this.f1603k = f;
    }

    /* renamed from: b */
    public void mo3133b(C0435m mVar, int i, C0436n nVar) {
        this.f1602j = mVar;
        this.f1606n = nVar;
        this.f1607o = i;
    }

    /* renamed from: c */
    public void mo3134c() {
        C0420e g = this.f1595a.mo3014g();
        if (g != null) {
            if (g.mo3014g() == this.f1595a) {
                this.f1601g = 4;
                g.mo3004a().f1601g = 4;
            }
            int e = this.f1595a.mo3012e();
            if (this.f1595a.f1442b == C0420e.C0424c.RIGHT || this.f1595a.f1442b == C0420e.C0424c.BOTTOM) {
                e = -e;
            }
            mo3127a(g.mo3004a(), e);
        }
    }

    /* renamed from: d */
    public float mo3135d() {
        return this.f1600f;
    }

    public String toString() {
        StringBuilder sb;
        String str;
        if (this.f1610i != 1) {
            sb = new StringBuilder();
            sb.append("{ ");
            sb.append(this.f1595a);
            str = " UNRESOLVED} type: ";
        } else if (this.f1599e == this) {
            sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f1595a);
            sb.append(", RESOLVED: ");
            sb.append(this.f1600f);
            str = "]  type: ";
        } else {
            sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f1595a);
            sb.append(", RESOLVED: ");
            sb.append(this.f1599e);
            sb.append(":");
            sb.append(this.f1600f);
            str = "] type: ";
        }
        sb.append(str);
        sb.append(mo3123a(this.f1601g));
        return sb.toString();
    }
}
