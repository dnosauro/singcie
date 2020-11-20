package com.cyberneid.p105d.p114g.p120d;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p108b.C1622p;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p115a.C1763f;
import com.cyberneid.p105d.p114g.p115a.C1764g;

/* renamed from: com.cyberneid.d.g.d.q */
public final class C1821q implements C1760c {

    /* renamed from: a */
    private final C1607d f5890a;

    /* renamed from: b */
    private float f5891b;

    /* renamed from: c */
    private float f5892c;

    /* renamed from: d */
    private int f5893d;

    C1821q() {
        this.f5891b = Float.NEGATIVE_INFINITY;
        this.f5892c = Float.NEGATIVE_INFINITY;
        this.f5893d = -1;
        this.f5890a = new C1607d();
        this.f5890a.mo7521a(C1613i.f5338hw, (C1605b) C1613i.f5032cH);
    }

    public C1821q(C1607d dVar) {
        this.f5891b = Float.NEGATIVE_INFINITY;
        this.f5892c = Float.NEGATIVE_INFINITY;
        this.f5893d = -1;
        this.f5890a = dVar;
    }

    /* renamed from: a */
    private void m7432a(int i, boolean z) {
        int i2 = mo8202i();
        mo8175a(z ? i | i2 : (i ^ -1) & i2);
    }

    /* renamed from: b */
    private boolean m7433b(int i) {
        return (i & mo8202i()) != 0;
    }

    /* renamed from: a */
    public void mo8174a(float f) {
        this.f5890a.mo7517a(C1613i.f5040cP, f);
    }

    /* renamed from: a */
    public void mo8175a(int i) {
        this.f5890a.mo7518a(C1613i.f5027cC, i);
        this.f5893d = i;
    }

    /* renamed from: a */
    public void mo8176a(C1763f fVar) {
        this.f5890a.mo7521a(C1613i.f5031cG, (C1605b) fVar != null ? fVar.mo7944b() : null);
    }

    /* renamed from: a */
    public void mo8177a(C1764g gVar) {
        this.f5890a.mo7522a(C1613i.f5035cK, (C1760c) gVar);
    }

    /* renamed from: a */
    public void mo8178a(String str) {
        this.f5890a.mo7521a(C1613i.f5038cN, (C1605b) str != null ? C1613i.m6461a(str) : null);
    }

    /* renamed from: a */
    public void mo8179a(boolean z) {
        m7432a(1, z);
    }

    /* renamed from: a */
    public boolean mo8180a() {
        return m7433b(1);
    }

    /* renamed from: b */
    public void mo8181b(float f) {
        this.f5890a.mo7517a(C1613i.f5128dy, f);
    }

    /* renamed from: b */
    public void mo8182b(C1764g gVar) {
        this.f5890a.mo7522a(C1613i.f4969ay, (C1760c) gVar);
    }

    /* renamed from: b */
    public void mo8183b(String str) {
        this.f5890a.mo7521a(C1613i.f5033cI, (C1605b) str != null ? new C1622p(str) : null);
    }

    /* renamed from: b */
    public void mo8184b(boolean z) {
        m7432a(2, z);
    }

    /* renamed from: b */
    public boolean mo8185b() {
        return m7433b(2);
    }

    /* renamed from: c */
    public void mo8186c(float f) {
        this.f5890a.mo7517a(C1613i.f5362x, f);
    }

    /* renamed from: c */
    public void mo8187c(String str) {
        this.f5890a.mo7521a(C1613i.f4964at, (C1605b) str != null ? new C1622p(str) : null);
    }

    /* renamed from: c */
    public void mo8188c(boolean z) {
        m7432a(4, z);
    }

    /* renamed from: c */
    public boolean mo8189c() {
        return m7433b(4);
    }

    /* renamed from: d */
    public void mo8190d(float f) {
        this.f5890a.mo7517a(C1613i.f5010bm, f);
    }

    /* renamed from: d */
    public void mo8191d(boolean z) {
        m7432a(8, z);
    }

    /* renamed from: e */
    public void mo8192e(float f) {
        this.f5890a.mo7517a(C1613i.f4955ak, f);
        this.f5892c = f;
    }

    /* renamed from: e */
    public void mo8193e(boolean z) {
        m7432a(32, z);
    }

    /* renamed from: e */
    public boolean mo8194e() {
        return m7433b(64);
    }

    /* renamed from: f */
    public C1607d mo7505d() {
        return this.f5890a;
    }

    /* renamed from: f */
    public void mo8196f(float f) {
        this.f5890a.mo7517a(C1613i.f5313hX, f);
        this.f5891b = f;
    }

    /* renamed from: f */
    public void mo8197f(boolean z) {
        m7432a(64, z);
    }

    /* renamed from: g */
    public String mo8198g() {
        C1613i iVar = (C1613i) this.f5890a.mo7539c(C1613i.f5038cN);
        if (iVar != null) {
            return iVar.mo7596a();
        }
        return null;
    }

    /* renamed from: g */
    public void mo8199g(float f) {
        this.f5890a.mo7517a(C1613i.f5248gL, f);
    }

    /* renamed from: h */
    public float mo8200h() {
        return this.f5890a.mo7528b(C1613i.f5040cP, 0.0f);
    }

    /* renamed from: h */
    public void mo8201h(float f) {
        this.f5890a.mo7517a(C1613i.f4896E, f);
    }

    /* renamed from: i */
    public int mo8202i() {
        if (this.f5893d == -1) {
            this.f5893d = this.f5890a.mo7529b(C1613i.f5027cC, 0);
        }
        return this.f5893d;
    }

    /* renamed from: j */
    public C1763f mo8203j() {
        C1604a aVar = (C1604a) this.f5890a.mo7539c(C1613i.f5031cG);
        if (aVar != null) {
            return new C1763f(aVar);
        }
        return null;
    }

    /* renamed from: k */
    public float mo8204k() {
        return this.f5890a.mo7528b(C1613i.f5362x, 0.0f);
    }

    /* renamed from: l */
    public float mo8205l() {
        return this.f5890a.mo7528b(C1613i.f5010bm, 0.0f);
    }

    /* renamed from: m */
    public float mo8206m() {
        if (this.f5892c == Float.NEGATIVE_INFINITY) {
            this.f5892c = Math.abs(this.f5890a.mo7528b(C1613i.f4955ak, 0.0f));
        }
        return this.f5892c;
    }

    /* renamed from: n */
    public float mo8207n() {
        return this.f5890a.mo7528b(C1613i.f5174er, 0.0f);
    }

    /* renamed from: o */
    public C1764g mo8208o() {
        C1605b c = this.f5890a.mo7539c(C1613i.f5034cJ);
        if (c instanceof C1619o) {
            return new C1764g((C1619o) c);
        }
        return null;
    }

    /* renamed from: p */
    public C1764g mo8209p() {
        C1605b c = this.f5890a.mo7539c(C1613i.f5035cK);
        if (c instanceof C1619o) {
            return new C1764g((C1619o) c);
        }
        return null;
    }

    /* renamed from: q */
    public C1764g mo8210q() {
        C1605b c = this.f5890a.mo7539c(C1613i.f5036cL);
        if (c instanceof C1619o) {
            return new C1764g((C1619o) c);
        }
        return null;
    }

    /* renamed from: r */
    public C1824t mo8211r() {
        C1607d dVar = (C1607d) this.f5890a.mo7539c(C1613i.f5254gR);
        if (dVar != null) {
            return new C1824t(((C1622p) dVar.mo7539c(C1613i.f5230fu)).mo7643c());
        }
        return null;
    }
}
