package com.p084c.p085a.p086a;

import com.p084c.p085a.p086a.C1432c;

/* renamed from: com.c.a.a.g */
public class C1447g extends C1430a {

    /* renamed from: a */
    private final C1431b f4314a;

    public C1447g(String str, C1431b bVar) {
        super(str);
        this.f4314a = bVar;
    }

    /* renamed from: a */
    public void mo6900a(C1432c.C1433a aVar, String str, Throwable th) {
        C1431b bVar = this.f4314a;
        if (bVar != null) {
            bVar.mo6897a(mo6893a(), aVar, th, str);
        }
    }

    /* renamed from: a */
    public void mo6901a(C1432c.C1433a aVar, Throwable th, String str, Object... objArr) {
        C1431b bVar = this.f4314a;
        if (bVar != null) {
            bVar.mo6898a(mo6893a(), aVar, th, str, objArr);
        }
    }

    /* renamed from: a */
    public boolean mo6902a(C1432c.C1433a aVar) {
        C1431b bVar = this.f4314a;
        return bVar != null && bVar.mo6899a(aVar);
    }
}
