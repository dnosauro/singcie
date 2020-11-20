package com.p084c.p085a.p086a;

import com.p084c.p085a.p086a.C1432c;

/* renamed from: com.c.a.a.a */
public abstract class C1430a implements C1432c {

    /* renamed from: a */
    private final String f4268a;

    public C1430a(String str) {
        this.f4268a = str;
    }

    /* renamed from: a */
    public String mo6893a() {
        return this.f4268a;
    }

    /* renamed from: a */
    public void mo6894a(String str, Object... objArr) {
        mo6901a(C1432c.C1433a.WARN, (Throwable) null, str, objArr);
    }

    /* renamed from: a */
    public void mo6895a(Throwable th, String str, Object... objArr) {
        mo6901a(C1432c.C1433a.ERROR, th, str, objArr);
    }

    /* renamed from: b */
    public void mo6896b(String str, Object... objArr) {
        mo6901a(C1432c.C1433a.ERROR, (Throwable) null, str, objArr);
    }
}
