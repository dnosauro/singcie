package com.cyberneid.p105d.p114g.p115a.p116a;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1609f;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1615k;

/* renamed from: com.cyberneid.d.g.a.a.c */
public class C1755c extends C1690a {

    /* renamed from: a */
    private final C1604a f5721a;

    /* renamed from: b */
    private final C1604a f5722b;

    /* renamed from: c */
    private final float f5723c;

    public C1755c(C1605b bVar) {
        super(bVar);
        if (mo7505d().mo7539c(C1613i.f4948ad) == null) {
            this.f5721a = new C1604a();
            this.f5721a.mo7490a((C1605b) new C1609f(0.0f));
        } else {
            this.f5721a = (C1604a) mo7505d().mo7539c(C1613i.f4948ad);
        }
        if (mo7505d().mo7539c(C1613i.f4949ae) == null) {
            this.f5722b = new C1604a();
            this.f5722b.mo7490a((C1605b) new C1609f(1.0f));
        } else {
            this.f5722b = (C1604a) mo7505d().mo7539c(C1613i.f4949ae);
        }
        this.f5723c = mo7505d().mo7551i(C1613i.f5180ex);
    }

    /* renamed from: a */
    public int mo7883a() {
        return 2;
    }

    /* renamed from: a */
    public float[] mo7885a(float[] fArr) {
        float pow = (float) Math.pow((double) fArr[0], (double) this.f5723c);
        float[] fArr2 = new float[this.f5721a.mo7494b()];
        for (int i = 0; i < fArr2.length; i++) {
            float a = ((C1615k) this.f5721a.mo7495b(i)).mo7583a();
            fArr2[i] = a + ((((C1615k) this.f5722b.mo7495b(i)).mo7583a() - a) * pow);
        }
        return mo7888b(fArr2);
    }

    /* renamed from: h */
    public C1604a mo7917h() {
        return this.f5721a;
    }

    /* renamed from: i */
    public C1604a mo7920i() {
        return this.f5722b;
    }

    /* renamed from: j */
    public float mo7921j() {
        return this.f5723c;
    }

    public String toString() {
        return "FunctionType2{C0: " + mo7917h() + " C1: " + mo7920i() + " N: " + mo7921j() + "}";
    }
}
