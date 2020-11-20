package androidx.constraintlayout.p019a.p020a;

import androidx.constraintlayout.p019a.p020a.C0425f;
import java.util.ArrayList;

/* renamed from: androidx.constraintlayout.a.a.d */
public class C0419d {

    /* renamed from: a */
    protected C0425f f1424a;

    /* renamed from: b */
    protected C0425f f1425b;

    /* renamed from: c */
    protected C0425f f1426c;

    /* renamed from: d */
    protected C0425f f1427d;

    /* renamed from: e */
    protected C0425f f1428e;

    /* renamed from: f */
    protected C0425f f1429f;

    /* renamed from: g */
    protected C0425f f1430g;

    /* renamed from: h */
    protected ArrayList<C0425f> f1431h;

    /* renamed from: i */
    protected int f1432i;

    /* renamed from: j */
    protected int f1433j;

    /* renamed from: k */
    protected float f1434k = 0.0f;

    /* renamed from: l */
    protected boolean f1435l;

    /* renamed from: m */
    protected boolean f1436m;

    /* renamed from: n */
    protected boolean f1437n;

    /* renamed from: o */
    private int f1438o;

    /* renamed from: p */
    private boolean f1439p = false;

    /* renamed from: q */
    private boolean f1440q;

    public C0419d(C0425f fVar, int i, boolean z) {
        this.f1424a = fVar;
        this.f1438o = i;
        this.f1439p = z;
    }

    /* renamed from: a */
    private static boolean m1596a(C0425f fVar, int i) {
        return fVar.mo3073l() != 8 && fVar.f1472C[i] == C0425f.C0427a.MATCH_CONSTRAINT && (fVar.f1522g[i] == 0 || fVar.f1522g[i] == 3);
    }

    /* renamed from: b */
    private void m1597b() {
        int i = this.f1438o * 2;
        boolean z = false;
        C0425f fVar = this.f1424a;
        C0425f fVar2 = fVar;
        boolean z2 = false;
        while (!z2) {
            this.f1432i++;
            C0425f fVar3 = null;
            fVar.f1501af[this.f1438o] = null;
            fVar.f1500ae[this.f1438o] = null;
            if (fVar.mo3073l() != 8) {
                if (this.f1425b == null) {
                    this.f1425b = fVar;
                }
                this.f1427d = fVar;
                if (fVar.f1472C[this.f1438o] == C0425f.C0427a.MATCH_CONSTRAINT && (fVar.f1522g[this.f1438o] == 0 || fVar.f1522g[this.f1438o] == 3 || fVar.f1522g[this.f1438o] == 2)) {
                    this.f1433j++;
                    float f = fVar.f1499ad[this.f1438o];
                    if (f > 0.0f) {
                        this.f1434k += fVar.f1499ad[this.f1438o];
                    }
                    if (m1596a(fVar, this.f1438o)) {
                        if (f < 0.0f) {
                            this.f1435l = true;
                        } else {
                            this.f1436m = true;
                        }
                        if (this.f1431h == null) {
                            this.f1431h = new ArrayList<>();
                        }
                        this.f1431h.add(fVar);
                    }
                    if (this.f1429f == null) {
                        this.f1429f = fVar;
                    }
                    C0425f fVar4 = this.f1430g;
                    if (fVar4 != null) {
                        fVar4.f1500ae[this.f1438o] = fVar;
                    }
                    this.f1430g = fVar;
                }
            }
            if (fVar2 != fVar) {
                fVar2.f1501af[this.f1438o] = fVar;
            }
            C0420e eVar = fVar.f1470A[i + 1].f1443c;
            if (eVar != null) {
                C0425f fVar5 = eVar.f1441a;
                if (fVar5.f1470A[i].f1443c != null && fVar5.f1470A[i].f1443c.f1441a == fVar) {
                    fVar3 = fVar5;
                }
            }
            if (fVar3 == null) {
                fVar3 = fVar;
                z2 = true;
            }
            fVar2 = fVar;
            fVar = fVar3;
        }
        this.f1426c = fVar;
        this.f1428e = (this.f1438o != 0 || !this.f1439p) ? this.f1424a : this.f1426c;
        if (this.f1436m && this.f1435l) {
            z = true;
        }
        this.f1437n = z;
    }

    /* renamed from: a */
    public void mo3003a() {
        if (!this.f1440q) {
            m1597b();
        }
        this.f1440q = true;
    }
}
