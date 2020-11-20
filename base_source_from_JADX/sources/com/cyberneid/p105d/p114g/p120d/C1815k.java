package com.cyberneid.p105d.p114g.p120d;

import com.cyberneid.p089b.p097h.C1586a;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1615k;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p131h.C1940d;
import com.cyberneid.p105d.p131h.C1943f;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.d.k */
public abstract class C1815k implements C1760c {

    /* renamed from: a */
    protected final C1828x f5854a;

    /* renamed from: b */
    protected final C1607d f5855b;

    /* renamed from: c */
    private Map<Integer, Float> f5856c;

    /* renamed from: d */
    private float f5857d;

    /* renamed from: e */
    private final Map<Integer, Float> f5858e = new HashMap();

    /* renamed from: f */
    private final Map<Integer, C1943f> f5859f = new HashMap();

    /* renamed from: g */
    private float[] f5860g;

    /* renamed from: h */
    private C1821q f5861h;

    C1815k(C1607d dVar, C1828x xVar) {
        this.f5855b = dVar;
        this.f5854a = xVar;
        m7366j();
        m7367k();
    }

    /* renamed from: j */
    private void m7366j() {
        this.f5856c = new HashMap();
        C1604a aVar = (C1604a) this.f5855b.mo7539c(C1613i.f5305hP);
        if (aVar != null) {
            int b = aVar.mo7494b();
            int i = 0;
            while (i < b) {
                int i2 = i + 1;
                C1615k kVar = (C1615k) aVar.mo7485a(i);
                int i3 = i2 + 1;
                C1605b a = aVar.mo7485a(i2);
                if (a instanceof C1604a) {
                    C1604a aVar2 = (C1604a) a;
                    int c = kVar.mo7586c();
                    int b2 = aVar2.mo7494b();
                    for (int i4 = 0; i4 < b2; i4++) {
                        this.f5856c.put(Integer.valueOf(c + i4), Float.valueOf(((C1615k) aVar2.mo7495b(i4)).mo7583a()));
                    }
                    i = i3;
                } else {
                    int i5 = i3 + 1;
                    int c2 = ((C1615k) a).mo7586c();
                    float a2 = ((C1615k) aVar.mo7485a(i3)).mo7583a();
                    for (int c3 = kVar.mo7586c(); c3 <= c2; c3++) {
                        this.f5856c.put(Integer.valueOf(c3), Float.valueOf(a2));
                    }
                    i = i5;
                }
            }
        }
    }

    /* renamed from: k */
    private void m7367k() {
        C1604a aVar = (C1604a) this.f5855b.mo7539c(C1613i.f4991bT);
        if (aVar != null) {
            this.f5860g = new float[2];
            this.f5860g[0] = ((C1615k) aVar.mo7495b(0)).mo7583a();
            this.f5860g[1] = ((C1615k) aVar.mo7495b(1)).mo7583a();
        } else {
            this.f5860g = new float[]{880.0f, -1000.0f};
        }
        C1604a aVar2 = (C1604a) this.f5855b.mo7539c(C1613i.f5306hQ);
        if (aVar2 != null) {
            int i = 0;
            while (i < aVar2.mo7494b()) {
                C1615k kVar = (C1615k) aVar2.mo7495b(i);
                int i2 = i + 1;
                C1605b b = aVar2.mo7495b(i2);
                if (b instanceof C1604a) {
                    C1604a aVar3 = (C1604a) b;
                    int i3 = 0;
                    while (i3 < aVar3.mo7494b()) {
                        int c = kVar.mo7586c() + i3;
                        int i4 = i3 + 1;
                        int i5 = i4 + 1;
                        this.f5858e.put(Integer.valueOf(c), Float.valueOf(((C1615k) aVar3.mo7495b(i3)).mo7583a()));
                        this.f5859f.put(Integer.valueOf(c), new C1943f(((C1615k) aVar3.mo7495b(i4)).mo7583a(), ((C1615k) aVar3.mo7495b(i5)).mo7583a()));
                        i3 = i5 + 1;
                    }
                } else {
                    int c2 = ((C1615k) b).mo7586c();
                    int i6 = i2 + 1;
                    C1615k kVar2 = (C1615k) aVar2.mo7495b(i6);
                    int i7 = i6 + 1;
                    C1615k kVar3 = (C1615k) aVar2.mo7495b(i7);
                    i2 = i7 + 1;
                    C1615k kVar4 = (C1615k) aVar2.mo7495b(i2);
                    for (int c3 = kVar.mo7586c(); c3 <= c2; c3++) {
                        this.f5858e.put(Integer.valueOf(c3), Float.valueOf(kVar2.mo7583a()));
                        this.f5859f.put(Integer.valueOf(c3), new C1943f(kVar3.mo7583a(), kVar4.mo7583a()));
                    }
                }
                i = i2 + 1;
            }
        }
    }

    /* renamed from: l */
    private float m7368l() {
        if (this.f5857d == 0.0f) {
            C1615k kVar = (C1615k) this.f5855b.mo7539c(C1613i.f4990bS);
            this.f5857d = kVar != null ? kVar.mo7583a() : 1000.0f;
        }
        return this.f5857d;
    }

    /* renamed from: a */
    public float mo8139a(int i) {
        int c = mo8143c(i);
        if (!this.f5856c.containsKey(Integer.valueOf(c))) {
            return mo8141b(i);
        }
        Float f = this.f5856c.get(Integer.valueOf(c));
        return f != null ? f.floatValue() : m7368l();
    }

    /* renamed from: a */
    public C1607d mo7505d() {
        return this.f5855b;
    }

    /* renamed from: b */
    public abstract float mo8141b(int i);

    /* renamed from: b */
    public String mo8142b() {
        return this.f5855b.mo7544e(C1613i.f4900I);
    }

    /* renamed from: c */
    public abstract int mo8143c(int i);

    /* renamed from: c */
    public String mo8144c() {
        return mo8142b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public abstract byte[] mo8145d(int i);

    /* renamed from: e */
    public C1821q mo8146e() {
        C1607d dVar;
        if (this.f5861h == null && (dVar = (C1607d) this.f5855b.mo7539c(C1613i.f5032cH)) != null) {
            this.f5861h = new C1821q(dVar);
        }
        return this.f5861h;
    }

    /* renamed from: f */
    public abstract C1940d mo8147f();

    /* renamed from: g */
    public abstract C1586a mo8148g();

    /* renamed from: h */
    public abstract boolean mo8149h();

    /* renamed from: i */
    public C1819o mo8150i() {
        C1607d dVar = (C1607d) this.f5855b.mo7539c(C1613i.f4970az);
        if (dVar != null) {
            return new C1819o(dVar);
        }
        return null;
    }
}
