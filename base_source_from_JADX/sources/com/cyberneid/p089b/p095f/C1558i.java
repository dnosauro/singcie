package com.cyberneid.p089b.p095f;

import java.io.IOException;

/* renamed from: com.cyberneid.b.f.i */
public class C1558i extends C1578z {

    /* renamed from: a */
    private long[] f4657a;

    C1558i(C1544ab abVar) {
        super(abVar);
    }

    /* renamed from: a */
    public void mo7175a(C1544ab abVar, C1575w wVar) {
        C1555f n = abVar.mo7193n();
        int u = abVar.mo7201u() + 1;
        this.f4657a = new long[u];
        for (int i = 0; i < u; i++) {
            if (n.mo7227f() == 0) {
                this.f4657a[i] = (long) (wVar.mo7281d() * 2);
            } else if (n.mo7227f() == 1) {
                this.f4657a[i] = wVar.mo7358k();
            } else {
                throw new IOException("Error:TTF.loca unknown offset format.");
            }
        }
        this.f4757b = true;
    }

    /* renamed from: a */
    public long[] mo7256a() {
        return this.f4657a;
    }
}
