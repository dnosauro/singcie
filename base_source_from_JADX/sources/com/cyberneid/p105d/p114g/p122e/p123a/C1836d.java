package com.cyberneid.p105d.p114g.p122e.p123a;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1609f;
import com.cyberneid.p105d.p108b.C1613i;

/* renamed from: com.cyberneid.d.g.e.a.d */
public class C1836d extends C1834b {

    /* renamed from: f */
    private final C1837e f5956f = new C1837e(new float[]{0.0f, 0.0f, 0.0f}, (C1838f) this);

    public C1836d() {
        super(C1613i.f4953ai);
    }

    public C1836d(C1604a aVar) {
        super(aVar);
    }

    /* renamed from: a */
    public float[] mo8257a(float[] fArr) {
        if (this.f5951b == 1.0f && this.f5952c == 1.0f && this.f5953d == 1.0f) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            C1846n f4 = mo8262f();
            float pow = (float) Math.pow((double) f, (double) f4.mo8278a());
            float pow2 = (float) Math.pow((double) f2, (double) f4.mo8279b());
            float pow3 = (float) Math.pow((double) f3, (double) f4.mo8280c());
            float[] g = mo8263g();
            float f5 = g[0];
            float f6 = g[1];
            float f7 = g[2];
            float f8 = g[3];
            float f9 = g[4];
            float f10 = g[5];
            return mo8256a((f5 * pow) + (f8 * pow2) + (g[6] * pow3), (f6 * pow) + (f9 * pow2) + (g[7] * pow3), (f7 * pow) + (f10 * pow2) + (g[8] * pow3));
        }
        return new float[]{fArr[0], fArr[1], fArr[2]};
    }

    /* renamed from: b */
    public String mo8258b() {
        return C1613i.f4953ai.mo7596a();
    }

    /* renamed from: c */
    public int mo8259c() {
        return 3;
    }

    /* renamed from: e */
    public C1837e mo8260e() {
        return this.f5956f;
    }

    /* renamed from: f */
    public final C1846n mo8262f() {
        C1604a aVar = (C1604a) this.f5950a.mo7539c(C1613i.f5049cY);
        if (aVar == null) {
            aVar = new C1604a();
            aVar.mo7490a((C1605b) new C1609f(1.0f));
            aVar.mo7490a((C1605b) new C1609f(1.0f));
            aVar.mo7490a((C1605b) new C1609f(1.0f));
            this.f5950a.mo7521a(C1613i.f5049cY, (C1605b) aVar);
        }
        return new C1846n(aVar);
    }

    /* renamed from: g */
    public final float[] mo8263g() {
        C1604a aVar = (C1604a) this.f5950a.mo7539c(C1613i.f5167ek);
        return aVar == null ? new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f} : aVar.mo7500c();
    }
}
