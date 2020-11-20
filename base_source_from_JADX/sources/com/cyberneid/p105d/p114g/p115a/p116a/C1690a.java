package com.cyberneid.p105d.p114g.p115a.p116a;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1616l;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p114g.p115a.C1762e;
import com.cyberneid.p105d.p114g.p115a.C1764g;
import java.io.IOException;

/* renamed from: com.cyberneid.d.g.a.a.a */
public abstract class C1690a implements C1760c {

    /* renamed from: a */
    private C1764g f5643a = null;

    /* renamed from: b */
    private C1607d f5644b = null;

    /* renamed from: c */
    private C1604a f5645c = null;

    /* renamed from: d */
    private C1604a f5646d = null;

    /* renamed from: e */
    private int f5647e = -1;

    /* renamed from: f */
    private int f5648f = -1;

    public C1690a(C1605b bVar) {
        if (bVar instanceof C1619o) {
            this.f5643a = new C1764g((C1619o) bVar);
            this.f5643a.mo7959e().mo7521a(C1613i.f5338hw, (C1605b) C1613i.f5045cU);
        } else if (bVar instanceof C1607d) {
            this.f5644b = (C1607d) bVar;
        }
    }

    /* renamed from: a */
    public static C1690a m6909a(C1605b bVar) {
        if (bVar == C1613i.f5116dm) {
            return new C1758f((C1605b) null);
        }
        if (bVar instanceof C1616l) {
            bVar = ((C1616l) bVar).mo7604a();
        }
        C1607d dVar = (C1607d) bVar;
        int g = dVar.mo7547g(C1613i.f5046cV);
        if (g == 0) {
            return new C1753b(dVar);
        }
        if (g == 2) {
            return new C1755c(dVar);
        }
        if (g == 3) {
            return new C1756d(dVar);
        }
        if (g == 4) {
            return new C1757e(dVar);
        }
        throw new IOException("Error: Unknown function type " + g);
    }

    /* renamed from: h */
    private C1604a mo7917h() {
        if (this.f5645c == null) {
            this.f5645c = (C1604a) mo7505d().mo7539c(C1613i.f4982bK);
        }
        return this.f5645c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo7881a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float mo7882a(float f, float f2, float f3, float f4, float f5) {
        return f4 + (((f - f2) * (f5 - f4)) / (f3 - f2));
    }

    /* renamed from: a */
    public abstract int mo7883a();

    /* renamed from: a */
    public C1762e mo7884a(int i) {
        return new C1762e(mo7892g(), i);
    }

    /* renamed from: a */
    public abstract float[] mo7885a(float[] fArr);

    /* renamed from: b */
    public C1607d mo7505d() {
        C1764g gVar = this.f5643a;
        return gVar != null ? gVar.mo7959e() : this.f5644b;
    }

    /* renamed from: b */
    public C1762e mo7887b(int i) {
        return new C1762e(mo7917h(), i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public float[] mo7888b(float[] fArr) {
        C1604a g = mo7892g();
        if (g == null) {
            return fArr;
        }
        float[] c = g.mo7500c();
        int length = c.length / 2;
        float[] fArr2 = new float[length];
        for (int i = 0; i < length; i++) {
            int i2 = i << 1;
            fArr2[i] = mo7881a(fArr[i], c[i2], c[i2 + 1]);
        }
        return fArr2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C1764g mo7889c() {
        return this.f5643a;
    }

    /* renamed from: e */
    public int mo7890e() {
        if (this.f5648f == -1) {
            this.f5648f = mo7892g().mo7494b() / 2;
        }
        return this.f5648f;
    }

    /* renamed from: f */
    public int mo7891f() {
        if (this.f5647e == -1) {
            this.f5647e = mo7917h().mo7494b() / 2;
        }
        return this.f5647e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public C1604a mo7892g() {
        if (this.f5646d == null) {
            this.f5646d = (C1604a) mo7505d().mo7539c(C1613i.f5204fU);
        }
        return this.f5646d;
    }

    public String toString() {
        return "FunctionType" + mo7883a();
    }
}
