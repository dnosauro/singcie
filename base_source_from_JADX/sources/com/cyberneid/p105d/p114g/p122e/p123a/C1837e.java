package com.cyberneid.p105d.p114g.p122e.p123a;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1615k;
import java.util.Arrays;

/* renamed from: com.cyberneid.d.g.e.a.e */
public final class C1837e {

    /* renamed from: a */
    private final float[] f5957a;

    /* renamed from: b */
    private final C1613i f5958b;

    /* renamed from: c */
    private final C1838f f5959c;

    public C1837e(C1604a aVar, C1838f fVar) {
        C1613i iVar;
        int i = 0;
        if (aVar.mo7494b() <= 0 || !(aVar.mo7495b(aVar.mo7494b() - 1) instanceof C1613i)) {
            this.f5957a = new float[aVar.mo7494b()];
            while (i < aVar.mo7494b()) {
                this.f5957a[i] = ((C1615k) aVar.mo7495b(i)).mo7583a();
                i++;
            }
            iVar = null;
        } else {
            this.f5957a = new float[(aVar.mo7494b() - 1)];
            while (i < aVar.mo7494b() - 1) {
                this.f5957a[i] = ((C1615k) aVar.mo7495b(i)).mo7583a();
                i++;
            }
            iVar = (C1613i) aVar.mo7495b(aVar.mo7494b() - 1);
        }
        this.f5958b = iVar;
        this.f5959c = fVar;
    }

    public C1837e(float[] fArr, C1838f fVar) {
        this.f5957a = (float[]) fArr.clone();
        this.f5958b = null;
        this.f5959c = fVar;
    }

    /* renamed from: a */
    public float[] mo8264a() {
        return (float[]) this.f5957a.clone();
    }

    /* renamed from: b */
    public C1838f mo8265b() {
        return this.f5959c;
    }

    public String toString() {
        return "PDColor{components=" + Arrays.toString(this.f5957a) + ", patternName=" + this.f5958b + "}";
    }
}
