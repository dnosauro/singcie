package com.cyberneid.p105d.p114g.p115a.p116a;

import com.cyberneid.p099c.p102b.p103a.p104a.C1599e;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1612h;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p115a.C1762e;
import java.io.IOException;
import java.lang.reflect.Array;

/* renamed from: com.cyberneid.d.g.a.a.b */
public class C1753b extends C1690a {

    /* renamed from: a */
    private C1604a f5711a = null;

    /* renamed from: b */
    private C1604a f5712b = null;

    /* renamed from: c */
    private C1604a f5713c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int[][] f5714d = null;

    /* renamed from: com.cyberneid.d.g.a.a.b$a */
    private class C1754a {

        /* renamed from: b */
        private final float[] f5716b;

        /* renamed from: c */
        private final int[] f5717c;

        /* renamed from: d */
        private final int[] f5718d;

        /* renamed from: e */
        private final int f5719e;

        /* renamed from: f */
        private final int f5720f = C1753b.this.mo7890e();

        C1754a(float[] fArr, int[] iArr, int[] iArr2) {
            this.f5716b = fArr;
            this.f5717c = iArr;
            this.f5718d = iArr2;
            this.f5719e = fArr.length;
        }

        /* renamed from: a */
        private int m7023a(int[] iArr) {
            float[] c = C1753b.this.mo7917h().mo7500c();
            int length = iArr.length;
            int i = 1;
            for (int i2 = length - 2; i2 >= 0; i2--) {
                i = (int) (((float) i) * c[i2]);
            }
            int i3 = 0;
            for (int i4 = length - 1; i4 >= 0; i4--) {
                i3 += iArr[i4] * i;
                int i5 = i4 - 1;
                if (i5 >= 0) {
                    i = (int) (((float) i) / c[i5]);
                }
            }
            return i3;
        }

        /* renamed from: a */
        private float[] m7024a(int[] iArr, int i) {
            float[] fArr = new float[this.f5720f];
            int i2 = 0;
            if (i == this.f5716b.length - 1) {
                int[] iArr2 = this.f5717c;
                if (iArr2[i] == this.f5718d[i]) {
                    iArr[i] = iArr2[i];
                    int[] iArr3 = m7025b()[m7023a(iArr)];
                    while (i2 < this.f5720f) {
                        fArr[i2] = (float) iArr3[i2];
                        i2++;
                    }
                    return fArr;
                }
                iArr[i] = iArr2[i];
                int[] iArr4 = m7025b()[m7023a(iArr)];
                iArr[i] = this.f5718d[i];
                int[] iArr5 = m7025b()[m7023a(iArr)];
                while (i2 < this.f5720f) {
                    fArr[i2] = C1753b.this.mo7882a(this.f5716b[i], (float) this.f5717c[i], (float) this.f5718d[i], (float) iArr4[i2], (float) iArr5[i2]);
                    i2++;
                }
                return fArr;
            }
            int[] iArr6 = this.f5717c;
            if (iArr6[i] == this.f5718d[i]) {
                iArr[i] = iArr6[i];
                return m7024a(iArr, i + 1);
            }
            iArr[i] = iArr6[i];
            int i3 = i + 1;
            float[] a = m7024a(iArr, i3);
            iArr[i] = this.f5718d[i];
            float[] a2 = m7024a(iArr, i3);
            while (i2 < this.f5720f) {
                fArr[i2] = C1753b.this.mo7882a(this.f5716b[i], (float) this.f5717c[i], (float) this.f5718d[i], a[i2], a2[i2]);
                i2++;
            }
            return fArr;
        }

        /* renamed from: b */
        private int[][] m7025b() {
            if (C1753b.this.f5714d == null) {
                int f = C1753b.this.mo7891f();
                int e = C1753b.this.mo7890e();
                C1604a h = C1753b.this.mo7917h();
                int i = 1;
                for (int i2 = 0; i2 < f; i2++) {
                    i *= h.mo7498c(i2);
                }
                int[][] unused = C1753b.this.f5714d = (int[][]) Array.newInstance(int.class, new int[]{i, e});
                int i3 = C1753b.this.mo7918i();
                try {
                    C1599e eVar = new C1599e(C1753b.this.mo7889c().mo7958c());
                    int i4 = 0;
                    for (int i5 = 0; i5 < i; i5++) {
                        for (int i6 = 0; i6 < e; i6++) {
                            C1753b.this.f5714d[i4][i6] = (int) eVar.mo7419a(i3);
                        }
                        i4++;
                    }
                    eVar.mo7420a();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return C1753b.this.f5714d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public float[] mo7919a() {
            return m7024a(new int[this.f5719e], 0);
        }
    }

    public C1753b(C1605b bVar) {
        super(bVar);
    }

    /* renamed from: j */
    private C1604a m7015j() {
        if (this.f5711a == null) {
            this.f5711a = (C1604a) mo7505d().mo7539c(C1613i.f5051ca);
            if (this.f5711a == null) {
                this.f5711a = new C1604a();
                C1604a h = mo7917h();
                int b = h.mo7494b();
                for (int i = 0; i < b; i++) {
                    this.f5711a.mo7490a((C1605b) C1612h.f4886a);
                    this.f5711a.mo7490a((C1605b) C1612h.m6455a((long) (h.mo7498c(i) - 1)));
                }
            }
        }
        return this.f5711a;
    }

    /* renamed from: k */
    private C1604a m7016k() {
        if (this.f5712b == null) {
            this.f5712b = (C1604a) mo7505d().mo7539c(C1613i.f5002be);
            if (this.f5712b == null) {
                this.f5712b = mo7892g();
            }
        }
        return this.f5712b;
    }

    /* renamed from: a */
    public int mo7883a() {
        return 0;
    }

    /* renamed from: a */
    public float[] mo7885a(float[] fArr) {
        float[] c = mo7917h().mo7500c();
        float pow = (float) (Math.pow(2.0d, (double) mo7918i()) - 1.0d);
        int length = fArr.length;
        int e = mo7890e();
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        float[] fArr2 = (float[]) fArr.clone();
        for (int i = 0; i < length; i++) {
            C1762e b = mo7887b(i);
            C1762e c2 = mo7915c(i);
            fArr2[i] = mo7881a(fArr2[i], b.mo7939a(), b.mo7940b());
            fArr2[i] = mo7882a(fArr2[i], b.mo7939a(), b.mo7940b(), c2.mo7939a(), c2.mo7940b());
            fArr2[i] = mo7881a(fArr2[i], 0.0f, c[i] - 1.0f);
            iArr[i] = (int) Math.floor((double) fArr2[i]);
            iArr2[i] = (int) Math.ceil((double) fArr2[i]);
        }
        float[] a = new C1754a(fArr2, iArr, iArr2).mo7919a();
        for (int i2 = 0; i2 < e; i2++) {
            C1762e a2 = mo7884a(i2);
            C1762e d = mo7916d(i2);
            a[i2] = mo7882a(a[i2], 0.0f, pow, d.mo7939a(), d.mo7940b());
            a[i2] = mo7881a(a[i2], a2.mo7939a(), a2.mo7940b());
        }
        return a;
    }

    /* renamed from: c */
    public C1762e mo7915c(int i) {
        C1604a j = m7015j();
        if (j == null || j.mo7494b() < (i * 2) + 1) {
            return null;
        }
        return new C1762e(j, i);
    }

    /* renamed from: d */
    public C1762e mo7916d(int i) {
        C1604a k = m7016k();
        if (k == null || k.mo7494b() < (i * 2) + 1) {
            return null;
        }
        return new C1762e(k, i);
    }

    /* renamed from: h */
    public C1604a mo7917h() {
        if (this.f5713c == null) {
            this.f5713c = (C1604a) mo7505d().mo7539c(C1613i.f5288gz);
        }
        return this.f5713c;
    }

    /* renamed from: i */
    public int mo7918i() {
        return mo7505d().mo7547g(C1613i.f4910S);
    }
}
