package com.cyberneid.p089b.p095f;

/* renamed from: com.cyberneid.b.f.ad */
public class C1546ad extends C1578z {

    /* renamed from: a */
    private int[] f4595a;

    /* renamed from: d */
    private short[] f4596d;

    /* renamed from: e */
    private short[] f4597e;

    /* renamed from: f */
    private int f4598f;

    C1546ad(C1544ab abVar) {
        super(abVar);
    }

    /* renamed from: a */
    public void mo7175a(C1544ab abVar, C1575w wVar) {
        this.f4598f = abVar.mo7198s().mo7204a();
        int u = abVar.mo7201u();
        int i = this.f4598f;
        this.f4595a = new int[i];
        this.f4596d = new short[i];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f4598f; i3++) {
            this.f4595a[i3] = wVar.mo7281d();
            this.f4596d[i3] = wVar.mo7282e();
            i2 += 4;
        }
        if (((long) i2) < mo7367C()) {
            int i4 = u - this.f4598f;
            if (i4 >= 0) {
                u = i4;
            }
            this.f4597e = new short[u];
            for (int i5 = 0; i5 < u; i5++) {
                if (((long) i2) < mo7367C()) {
                    this.f4597e[i5] = wVar.mo7282e();
                    i2 += 2;
                }
            }
        }
        this.f4757b = true;
    }
}
