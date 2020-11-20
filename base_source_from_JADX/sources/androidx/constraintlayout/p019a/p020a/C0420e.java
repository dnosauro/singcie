package androidx.constraintlayout.p019a.p020a;

import androidx.constraintlayout.p019a.C0442c;
import androidx.constraintlayout.p019a.C0450h;

/* renamed from: androidx.constraintlayout.a.a.e */
public class C0420e {

    /* renamed from: a */
    final C0425f f1441a;

    /* renamed from: b */
    final C0424c f1442b;

    /* renamed from: c */
    C0420e f1443c;

    /* renamed from: d */
    public int f1444d = 0;

    /* renamed from: e */
    int f1445e = -1;

    /* renamed from: f */
    C0450h f1446f;

    /* renamed from: g */
    private C0435m f1447g = new C0435m(this);

    /* renamed from: h */
    private C0423b f1448h = C0423b.NONE;

    /* renamed from: i */
    private C0422a f1449i = C0422a.RELAXED;

    /* renamed from: j */
    private int f1450j = 0;

    /* renamed from: androidx.constraintlayout.a.a.e$a */
    public enum C0422a {
        RELAXED,
        STRICT
    }

    /* renamed from: androidx.constraintlayout.a.a.e$b */
    public enum C0423b {
        NONE,
        STRONG,
        WEAK
    }

    /* renamed from: androidx.constraintlayout.a.a.e$c */
    public enum C0424c {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public C0420e(C0425f fVar, C0424c cVar) {
        this.f1441a = fVar;
        this.f1442b = cVar;
    }

    /* renamed from: a */
    public C0435m mo3004a() {
        return this.f1447g;
    }

    /* renamed from: a */
    public void mo3005a(C0442c cVar) {
        C0450h hVar = this.f1446f;
        if (hVar == null) {
            this.f1446f = new C0450h(C0450h.C0451a.UNRESTRICTED, (String) null);
        } else {
            hVar.mo3205b();
        }
    }

    /* renamed from: a */
    public boolean mo3006a(C0420e eVar) {
        if (eVar == null) {
            return false;
        }
        C0424c d = eVar.mo3011d();
        C0424c cVar = this.f1442b;
        if (d == cVar) {
            return cVar != C0424c.BASELINE || (eVar.mo3010c().mo3097z() && mo3010c().mo3097z());
        }
        switch (this.f1442b) {
            case CENTER:
                return (d == C0424c.BASELINE || d == C0424c.CENTER_X || d == C0424c.CENTER_Y) ? false : true;
            case LEFT:
            case RIGHT:
                boolean z = d == C0424c.LEFT || d == C0424c.RIGHT;
                return eVar.mo3010c() instanceof C0430i ? z || d == C0424c.CENTER_X : z;
            case TOP:
            case BOTTOM:
                boolean z2 = d == C0424c.TOP || d == C0424c.BOTTOM;
                return eVar.mo3010c() instanceof C0430i ? z2 || d == C0424c.CENTER_Y : z2;
            case BASELINE:
            case CENTER_X:
            case CENTER_Y:
            case NONE:
                return false;
            default:
                throw new AssertionError(this.f1442b.name());
        }
    }

    /* renamed from: a */
    public boolean mo3007a(C0420e eVar, int i, int i2, C0423b bVar, int i3, boolean z) {
        if (eVar == null) {
            this.f1443c = null;
            this.f1444d = 0;
            this.f1445e = -1;
            this.f1448h = C0423b.NONE;
            this.f1450j = 2;
            return true;
        } else if (!z && !mo3006a(eVar)) {
            return false;
        } else {
            this.f1443c = eVar;
            if (i > 0) {
                this.f1444d = i;
            } else {
                this.f1444d = 0;
            }
            this.f1445e = i2;
            this.f1448h = bVar;
            this.f1450j = i3;
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo3008a(C0420e eVar, int i, C0423b bVar, int i2) {
        return mo3007a(eVar, i, -1, bVar, i2, false);
    }

    /* renamed from: b */
    public C0450h mo3009b() {
        return this.f1446f;
    }

    /* renamed from: c */
    public C0425f mo3010c() {
        return this.f1441a;
    }

    /* renamed from: d */
    public C0424c mo3011d() {
        return this.f1442b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        r0 = r3.f1443c;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo3012e() {
        /*
            r3 = this;
            androidx.constraintlayout.a.a.f r0 = r3.f1441a
            int r0 = r0.mo3073l()
            r1 = 8
            if (r0 != r1) goto L_0x000c
            r0 = 0
            return r0
        L_0x000c:
            int r0 = r3.f1445e
            r2 = -1
            if (r0 <= r2) goto L_0x0020
            androidx.constraintlayout.a.a.e r0 = r3.f1443c
            if (r0 == 0) goto L_0x0020
            androidx.constraintlayout.a.a.f r0 = r0.f1441a
            int r0 = r0.mo3073l()
            if (r0 != r1) goto L_0x0020
            int r0 = r3.f1445e
            return r0
        L_0x0020:
            int r0 = r3.f1444d
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p019a.p020a.C0420e.mo3012e():int");
    }

    /* renamed from: f */
    public C0423b mo3013f() {
        return this.f1448h;
    }

    /* renamed from: g */
    public C0420e mo3014g() {
        return this.f1443c;
    }

    /* renamed from: h */
    public int mo3015h() {
        return this.f1450j;
    }

    /* renamed from: i */
    public void mo3016i() {
        this.f1443c = null;
        this.f1444d = 0;
        this.f1445e = -1;
        this.f1448h = C0423b.STRONG;
        this.f1450j = 0;
        this.f1449i = C0422a.RELAXED;
        this.f1447g.mo3130b();
    }

    /* renamed from: j */
    public boolean mo3017j() {
        return this.f1443c != null;
    }

    public String toString() {
        return this.f1441a.mo3075m() + ":" + this.f1442b.toString();
    }
}
