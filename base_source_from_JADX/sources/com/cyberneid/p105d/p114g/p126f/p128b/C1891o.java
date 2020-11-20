package com.cyberneid.p105d.p114g.p126f.p128b;

import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p114g.p115a.C1760c;

/* renamed from: com.cyberneid.d.g.f.b.o */
public class C1891o implements C1760c {

    /* renamed from: a */
    private C1605b f6039a;

    private C1891o() {
    }

    public C1891o(C1605b bVar) {
        this.f6039a = bVar;
    }

    /* renamed from: a */
    public boolean mo8356a() {
        return this.f6039a instanceof C1619o;
    }

    /* renamed from: b */
    public C1892p mo8357b() {
        if (mo8356a()) {
            return new C1892p((C1619o) this.f6039a);
        }
        throw new IllegalStateException();
    }

    /* renamed from: d */
    public C1605b mo7505d() {
        return this.f6039a;
    }
}
