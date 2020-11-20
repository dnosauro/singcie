package com.cyberneid.p089b.p095f;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.cyberneid.b.f.ae */
public class C1547ae extends C1578z {

    /* renamed from: a */
    private float f4599a;

    /* renamed from: d */
    private int f4600d;

    /* renamed from: e */
    private Map<Integer, Integer> f4601e = new ConcurrentHashMap();

    C1547ae(C1544ab abVar) {
        super(abVar);
    }

    /* renamed from: a */
    public void mo7175a(C1544ab abVar, C1575w wVar) {
        this.f4599a = wVar.mo7355h();
        this.f4600d = wVar.mo7282e();
        int d = wVar.mo7281d();
        for (int i = 0; i < d; i++) {
            this.f4601e.put(Integer.valueOf(wVar.mo7281d()), Integer.valueOf(wVar.mo7282e()));
        }
        this.f4757b = true;
    }
}
