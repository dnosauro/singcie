package com.cyberneid.p105d.p114g.p122e.p123a;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1609f;
import com.cyberneid.p105d.p108b.C1613i;

/* renamed from: com.cyberneid.d.g.e.a.b */
public abstract class C1834b extends C1833a {

    /* renamed from: a */
    protected C1607d f5950a;

    /* renamed from: b */
    protected float f5951b = 1.0f;

    /* renamed from: c */
    protected float f5952c = 1.0f;

    /* renamed from: d */
    protected float f5953d = 1.0f;

    protected C1834b(C1604a aVar) {
        this.f5960e = aVar;
        this.f5950a = (C1607d) this.f5960e.mo7485a(1);
        m7573a(mo8255a());
    }

    protected C1834b(C1613i iVar) {
        this.f5960e = new C1604a();
        this.f5950a = new C1607d();
        this.f5960e.mo7490a((C1605b) iVar);
        this.f5960e.mo7490a((C1605b) this.f5950a);
        m7573a(mo8255a());
    }

    /* renamed from: a */
    private void m7573a(C1853u uVar) {
        this.f5951b = uVar.mo8289a();
        this.f5952c = uVar.mo8290b();
        this.f5953d = uVar.mo8291c();
    }

    /* renamed from: a */
    public final C1853u mo8255a() {
        C1604a aVar = (C1604a) this.f5950a.mo7539c(C1613i.f5307hR);
        if (aVar == null) {
            aVar = new C1604a();
            aVar.mo7490a((C1605b) new C1609f(1.0f));
            aVar.mo7490a((C1605b) new C1609f(1.0f));
            aVar.mo7490a((C1605b) new C1609f(1.0f));
        }
        return new C1853u(aVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public float[] mo8256a(float f, float f2, float f3) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        double d = (double) f;
        double d2 = (double) f2;
        double d3 = (double) f3;
        return new float[]{(float) (((3.2404542d * d) - (1.5371385d * d2)) - (0.4985314d * d3)), (float) ((-0.969266d * d) + (1.8760108d * d2) + (0.041556d * d3)), (float) (((d * 0.0556434d) - (d2 * 0.2040259d)) + (d3 * 1.0572252d))};
    }
}
