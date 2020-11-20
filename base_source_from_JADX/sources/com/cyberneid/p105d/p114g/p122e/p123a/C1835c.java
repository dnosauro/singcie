package com.cyberneid.p105d.p114g.p122e.p123a;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1615k;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.e.a.c */
public final class C1835c extends C1834b {

    /* renamed from: f */
    private final C1837e f5954f = new C1837e(new float[]{0.0f}, (C1838f) this);

    /* renamed from: g */
    private final Map<Float, float[]> f5955g = new HashMap();

    public C1835c() {
        super(C1613i.f4952ah);
    }

    public C1835c(C1604a aVar) {
        super(aVar);
    }

    /* renamed from: a */
    public float[] mo8257a(float[] fArr) {
        if (this.f5951b == 1.0f && this.f5952c == 1.0f && this.f5953d == 1.0f) {
            float f = fArr[0];
            float[] fArr2 = this.f5955g.get(Float.valueOf(f));
            if (fArr2 != null) {
                return (float[]) fArr2.clone();
            }
            float pow = (float) Math.pow((double) f, (double) mo8261f());
            float[] a = mo8256a(pow, pow, pow);
            this.f5955g.put(Float.valueOf(f), a.clone());
            return a;
        }
        return new float[]{fArr[0], fArr[0], fArr[0]};
    }

    /* renamed from: b */
    public String mo8258b() {
        return C1613i.f4952ah.mo7596a();
    }

    /* renamed from: c */
    public int mo8259c() {
        return 1;
    }

    /* renamed from: e */
    public C1837e mo8260e() {
        return this.f5954f;
    }

    /* renamed from: f */
    public float mo8261f() {
        C1615k kVar = (C1615k) this.f5950a.mo7539c(C1613i.f5049cY);
        if (kVar != null) {
            return kVar.mo7583a();
        }
        return 1.0f;
    }
}
