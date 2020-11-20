package androidx.constraintlayout.p019a.p020a;

import androidx.constraintlayout.p019a.C0444e;
import androidx.constraintlayout.p019a.C0450h;
import androidx.constraintlayout.p019a.p020a.C0420e;
import androidx.constraintlayout.p019a.p020a.C0425f;
import java.util.ArrayList;

/* renamed from: androidx.constraintlayout.a.a.i */
public class C0430i extends C0425f {

    /* renamed from: ai */
    protected float f1582ai = -1.0f;

    /* renamed from: aj */
    protected int f1583aj = -1;

    /* renamed from: ak */
    protected int f1584ak = -1;

    /* renamed from: al */
    private C0420e f1585al = this.f1535t;

    /* renamed from: am */
    private int f1586am;

    /* renamed from: an */
    private boolean f1587an;

    /* renamed from: ao */
    private int f1588ao;

    /* renamed from: ap */
    private C0434l f1589ap;

    /* renamed from: aq */
    private int f1590aq;

    public C0430i() {
        this.f1586am = 0;
        this.f1587an = false;
        this.f1588ao = 0;
        this.f1589ap = new C0434l();
        this.f1590aq = 8;
        this.f1471B.clear();
        this.f1471B.add(this.f1585al);
        int length = this.f1470A.length;
        for (int i = 0; i < length; i++) {
            this.f1470A[i] = this.f1585al;
        }
    }

    /* renamed from: C */
    public ArrayList<C0420e> mo3021C() {
        return this.f1471B;
    }

    /* renamed from: J */
    public int mo3098J() {
        return this.f1586am;
    }

    /* renamed from: a */
    public C0420e mo3028a(C0420e.C0424c cVar) {
        switch (cVar) {
            case LEFT:
            case RIGHT:
                if (this.f1586am == 1) {
                    return this.f1585al;
                }
                break;
            case TOP:
            case BOTTOM:
                if (this.f1586am == 0) {
                    return this.f1585al;
                }
                break;
            case BASELINE:
            case CENTER:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return null;
        }
        throw new AssertionError(cVar.name());
    }

    /* renamed from: a */
    public void mo2996a(int i) {
        if (this.f1586am != i) {
            this.f1586am = i;
            this.f1471B.clear();
            this.f1585al = this.f1586am == 1 ? this.f1534s : this.f1535t;
            this.f1471B.add(this.f1585al);
            int length = this.f1470A.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f1470A[i2] = this.f1585al;
            }
        }
    }

    /* renamed from: a */
    public void mo2997a(C0444e eVar) {
        C0428g gVar = (C0428g) mo3071k();
        if (gVar != null) {
            C0420e a = gVar.mo3028a(C0420e.C0424c.LEFT);
            C0420e a2 = gVar.mo3028a(C0420e.C0424c.RIGHT);
            boolean z = this.f1473D != null && this.f1473D.f1472C[0] == C0425f.C0427a.WRAP_CONTENT;
            if (this.f1586am == 0) {
                a = gVar.mo3028a(C0420e.C0424c.TOP);
                a2 = gVar.mo3028a(C0420e.C0424c.BOTTOM);
                z = this.f1473D != null && this.f1473D.f1472C[1] == C0425f.C0427a.WRAP_CONTENT;
            }
            if (this.f1583aj != -1) {
                C0450h a3 = eVar.mo3179a((Object) this.f1585al);
                eVar.mo3194c(a3, eVar.mo3179a((Object) a), this.f1583aj, 6);
                if (z) {
                    eVar.mo3186a(eVar.mo3179a((Object) a2), a3, 0, 5);
                }
            } else if (this.f1584ak != -1) {
                C0450h a4 = eVar.mo3179a((Object) this.f1585al);
                C0450h a5 = eVar.mo3179a((Object) a2);
                eVar.mo3194c(a4, a5, -this.f1584ak, 6);
                if (z) {
                    eVar.mo3186a(a4, eVar.mo3179a((Object) a), 0, 5);
                    eVar.mo3186a(a5, a4, 0, 5);
                }
            } else if (this.f1582ai != -1.0f) {
                eVar.mo3181a(C0444e.m1809a(eVar, eVar.mo3179a((Object) this.f1585al), eVar.mo3179a((Object) a), eVar.mo3179a((Object) a2), this.f1582ai, this.f1587an));
            }
        }
    }

    /* renamed from: a */
    public boolean mo2999a() {
        return true;
    }

    /* renamed from: b */
    public void mo3001b(int i) {
        C0420e eVar;
        C0435m mVar;
        int i2;
        C0420e eVar2;
        C0435m mVar2;
        C0435m a;
        int i3;
        C0420e eVar3;
        C0435m a2;
        C0425f k = mo3071k();
        if (k != null) {
            if (mo3098J() == 1) {
                this.f1535t.mo3004a().mo3125a(1, k.f1535t.mo3004a(), 0);
                this.f1537v.mo3004a().mo3125a(1, k.f1535t.mo3004a(), 0);
                if (this.f1583aj != -1) {
                    this.f1534s.mo3004a().mo3125a(1, k.f1534s.mo3004a(), this.f1583aj);
                    mVar2 = this.f1536u.mo3004a();
                    eVar3 = k.f1534s;
                } else if (this.f1584ak != -1) {
                    this.f1534s.mo3004a().mo3125a(1, k.f1536u.mo3004a(), -this.f1584ak);
                    a2 = this.f1536u.mo3004a();
                    eVar2 = k.f1536u;
                    a = eVar2.mo3004a();
                    i3 = -this.f1584ak;
                    mVar2.mo3125a(1, a, i3);
                } else if (this.f1582ai != -1.0f && k.mo3024F() == C0425f.C0427a.FIXED) {
                    i2 = (int) (((float) k.f1474E) * this.f1582ai);
                    this.f1534s.mo3004a().mo3125a(1, k.f1534s.mo3004a(), i2);
                    mVar = this.f1536u.mo3004a();
                    eVar = k.f1534s;
                    mVar.mo3125a(1, eVar.mo3004a(), i2);
                    return;
                } else {
                    return;
                }
            } else {
                this.f1534s.mo3004a().mo3125a(1, k.f1534s.mo3004a(), 0);
                this.f1536u.mo3004a().mo3125a(1, k.f1534s.mo3004a(), 0);
                if (this.f1583aj != -1) {
                    this.f1535t.mo3004a().mo3125a(1, k.f1535t.mo3004a(), this.f1583aj);
                    mVar2 = this.f1537v.mo3004a();
                    eVar3 = k.f1535t;
                } else if (this.f1584ak != -1) {
                    this.f1535t.mo3004a().mo3125a(1, k.f1537v.mo3004a(), -this.f1584ak);
                    a2 = this.f1537v.mo3004a();
                    eVar2 = k.f1537v;
                    a = eVar2.mo3004a();
                    i3 = -this.f1584ak;
                    mVar2.mo3125a(1, a, i3);
                } else if (this.f1582ai != -1.0f && k.mo3025G() == C0425f.C0427a.FIXED) {
                    i2 = (int) (((float) k.f1475F) * this.f1582ai);
                    this.f1535t.mo3004a().mo3125a(1, k.f1535t.mo3004a(), i2);
                    mVar = this.f1537v.mo3004a();
                    eVar = k.f1535t;
                    mVar.mo3125a(1, eVar.mo3004a(), i2);
                    return;
                } else {
                    return;
                }
            }
            a = eVar3.mo3004a();
            i3 = this.f1583aj;
            mVar2.mo3125a(1, a, i3);
        }
    }

    /* renamed from: c */
    public void mo3052c(C0444e eVar) {
        if (mo3071k() != null) {
            int b = eVar.mo3189b((Object) this.f1585al);
            if (this.f1586am == 1) {
                mo3065h(b);
                mo3068i(0);
                mo3072k(mo3071k().mo3085r());
                mo3070j(0);
                return;
            }
            mo3065h(0);
            mo3068i(b);
            mo3070j(mo3071k().mo3081p());
            mo3072k(0);
        }
    }

    /* renamed from: e */
    public void mo3119e(float f) {
        if (f > -1.0f) {
            this.f1582ai = f;
            this.f1583aj = -1;
            this.f1584ak = -1;
        }
    }

    /* renamed from: u */
    public void mo3120u(int i) {
        if (i > -1) {
            this.f1582ai = -1.0f;
            this.f1583aj = i;
            this.f1584ak = -1;
        }
    }

    /* renamed from: v */
    public void mo3121v(int i) {
        if (i > -1) {
            this.f1582ai = -1.0f;
            this.f1583aj = -1;
            this.f1584ak = i;
        }
    }
}
