package com.cyberneid.p105d.p113f;

import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1617m;

/* renamed from: com.cyberneid.d.f.c */
public class C1686c implements Comparable<C1686c> {

    /* renamed from: e */
    private static final C1686c f5624e = new C1686c(0, (C1605b) null, new C1617m(0, 65535));

    /* renamed from: a */
    private long f5625a;

    /* renamed from: b */
    private C1605b f5626b;

    /* renamed from: c */
    private C1617m f5627c;

    /* renamed from: d */
    private boolean f5628d = false;

    static {
        f5624e.mo7843a(true);
    }

    public C1686c(long j, C1605b bVar, C1617m mVar) {
        mo7842a(j);
        m6888a(bVar);
        m6889a(mVar);
    }

    /* renamed from: a */
    public static C1686c m6887a() {
        return f5624e;
    }

    /* renamed from: a */
    private void m6888a(C1605b bVar) {
        this.f5626b = bVar;
    }

    /* renamed from: a */
    private void m6889a(C1617m mVar) {
        this.f5627c = mVar;
    }

    /* renamed from: a */
    public int compareTo(C1686c cVar) {
        if (cVar == null || mo7844b().mo7613b() < cVar.mo7844b().mo7613b()) {
            return -1;
        }
        return mo7844b().mo7613b() > cVar.mo7844b().mo7613b() ? 1 : 0;
    }

    /* renamed from: a */
    public final void mo7842a(long j) {
        this.f5625a = j;
    }

    /* renamed from: a */
    public void mo7843a(boolean z) {
        this.f5628d = z;
    }

    /* renamed from: b */
    public C1617m mo7844b() {
        return this.f5627c;
    }

    /* renamed from: c */
    public long mo7845c() {
        return this.f5625a;
    }

    /* renamed from: d */
    public boolean mo7847d() {
        return this.f5628d;
    }
}
