package com.cyberneid.p105d.p114g.p115a;

import com.cyberneid.p089b.p097h.C1586a;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1609f;
import com.cyberneid.p105d.p108b.C1615k;

/* renamed from: com.cyberneid.d.g.a.f */
public class C1763f implements C1760c {

    /* renamed from: a */
    public static final C1763f f5733a = new C1763f(612.0f, 792.0f);

    /* renamed from: b */
    public static final C1763f f5734b = new C1763f(612.0f, 1008.0f);

    /* renamed from: c */
    public static final C1763f f5735c = new C1763f(2383.937f, 3370.3938f);

    /* renamed from: d */
    public static final C1763f f5736d = new C1763f(1683.7795f, 2383.937f);

    /* renamed from: e */
    public static final C1763f f5737e = new C1763f(1190.5513f, 1683.7795f);

    /* renamed from: f */
    public static final C1763f f5738f = new C1763f(841.8898f, 1190.5513f);

    /* renamed from: g */
    public static final C1763f f5739g = new C1763f(595.27563f, 841.8898f);

    /* renamed from: h */
    public static final C1763f f5740h = new C1763f(419.52756f, 595.27563f);

    /* renamed from: i */
    public static final C1763f f5741i = new C1763f(297.63782f, 419.52756f);

    /* renamed from: j */
    private final C1604a f5742j;

    public C1763f() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public C1763f(float f, float f2) {
        this(0.0f, 0.0f, f, f2);
    }

    public C1763f(float f, float f2, float f3, float f4) {
        this.f5742j = new C1604a();
        this.f5742j.mo7490a((C1605b) new C1609f(f));
        this.f5742j.mo7490a((C1605b) new C1609f(f2));
        this.f5742j.mo7490a((C1605b) new C1609f(f + f3));
        this.f5742j.mo7490a((C1605b) new C1609f(f2 + f4));
    }

    public C1763f(C1586a aVar) {
        this.f5742j = new C1604a();
        this.f5742j.mo7490a((C1605b) new C1609f(aVar.mo7388a()));
        this.f5742j.mo7490a((C1605b) new C1609f(aVar.mo7390b()));
        this.f5742j.mo7490a((C1605b) new C1609f(aVar.mo7392c()));
        this.f5742j.mo7490a((C1605b) new C1609f(aVar.mo7394d()));
    }

    public C1763f(C1604a aVar) {
        float[] c = aVar.mo7500c();
        this.f5742j = new C1604a();
        this.f5742j.mo7490a((C1605b) new C1609f(Math.min(c[0], c[2])));
        this.f5742j.mo7490a((C1605b) new C1609f(Math.min(c[1], c[3])));
        this.f5742j.mo7490a((C1605b) new C1609f(Math.max(c[0], c[2])));
        this.f5742j.mo7490a((C1605b) new C1609f(Math.max(c[1], c[3])));
    }

    /* renamed from: a */
    public C1763f mo7942a() {
        C1763f fVar = new C1763f();
        fVar.mo7947c(mo7952h());
        fVar.mo7948d(mo7953i());
        return fVar;
    }

    /* renamed from: a */
    public void mo7943a(float f) {
        this.f5742j.mo7496b(0, new C1609f(f));
    }

    /* renamed from: b */
    public C1604a mo7944b() {
        return this.f5742j;
    }

    /* renamed from: b */
    public void mo7945b(float f) {
        this.f5742j.mo7496b(1, new C1609f(f));
    }

    /* renamed from: c */
    public float mo7946c() {
        return ((C1615k) this.f5742j.mo7495b(0)).mo7583a();
    }

    /* renamed from: c */
    public void mo7947c(float f) {
        this.f5742j.mo7496b(2, new C1609f(f));
    }

    /* renamed from: d */
    public C1605b mo7505d() {
        return this.f5742j;
    }

    /* renamed from: d */
    public void mo7948d(float f) {
        this.f5742j.mo7496b(3, new C1609f(f));
    }

    /* renamed from: e */
    public float mo7949e() {
        return ((C1615k) this.f5742j.mo7495b(1)).mo7583a();
    }

    /* renamed from: f */
    public float mo7950f() {
        return ((C1615k) this.f5742j.mo7495b(2)).mo7583a();
    }

    /* renamed from: g */
    public float mo7951g() {
        return ((C1615k) this.f5742j.mo7495b(3)).mo7583a();
    }

    /* renamed from: h */
    public float mo7952h() {
        return mo7950f() - mo7946c();
    }

    /* renamed from: i */
    public float mo7953i() {
        return mo7951g() - mo7949e();
    }

    public String toString() {
        return "[" + mo7946c() + "," + mo7949e() + "," + mo7950f() + "," + mo7951g() + "]";
    }
}
