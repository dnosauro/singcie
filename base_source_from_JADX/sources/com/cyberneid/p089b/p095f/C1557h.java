package com.cyberneid.p089b.p095f;

/* renamed from: com.cyberneid.b.f.h */
public class C1557h extends C1578z {

    /* renamed from: a */
    private int[] f4653a;

    /* renamed from: d */
    private short[] f4654d;

    /* renamed from: e */
    private short[] f4655e;

    /* renamed from: f */
    private int f4656f;

    C1557h(C1544ab abVar) {
        super(abVar);
    }

    /* renamed from: a */
    public int mo7255a(int i) {
        if (i < this.f4656f) {
            return this.f4653a[i];
        }
        int[] iArr = this.f4653a;
        return iArr[iArr.length - 1];
    }

    /* renamed from: a */
    public void mo7175a(C1544ab abVar, C1575w wVar) {
        this.f4656f = abVar.mo7194o().mo7247j();
        int u = abVar.mo7201u();
        int i = this.f4656f;
        this.f4653a = new int[i];
        this.f4654d = new short[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f4656f; i3++) {
            this.f4653a[i3] = wVar.mo7281d();
            this.f4654d[i3] = wVar.mo7282e();
            i2 += 4;
        }
        if (((long) i2) < mo7367C()) {
            int i4 = u - this.f4656f;
            if (i4 >= 0) {
                u = i4;
            }
            this.f4655e = new short[u];
            for (int i5 = 0; i5 < u; i5++) {
                if (((long) i2) < mo7367C()) {
                    this.f4655e[i5] = wVar.mo7282e();
                    i2 += 2;
                }
            }
        }
        this.f4757b = true;
    }
}
