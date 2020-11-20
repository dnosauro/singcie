package com.p084c.p085a.p086a;

/* renamed from: com.c.a.a.c */
public interface C1432c {

    /* renamed from: com.c.a.a.c$a */
    public enum C1433a {
        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6),
        ASSERT(7);
        

        /* renamed from: g */
        private final int f4276g;

        private C1433a(int i) {
            this.f4276g = i;
        }

        /* renamed from: a */
        public int mo6903a() {
            return this.f4276g;
        }

        /* renamed from: a */
        public boolean mo6904a(C1433a aVar) {
            return aVar != null && mo6903a() <= aVar.mo6903a();
        }
    }

    /* renamed from: a */
    String mo6893a();

    /* renamed from: a */
    void mo6900a(C1433a aVar, String str, Throwable th);

    /* renamed from: a */
    void mo6901a(C1433a aVar, Throwable th, String str, Object... objArr);

    /* renamed from: a */
    void mo6894a(String str, Object... objArr);

    /* renamed from: a */
    void mo6895a(Throwable th, String str, Object... objArr);

    /* renamed from: a */
    boolean mo6902a(C1433a aVar);

    /* renamed from: b */
    void mo6896b(String str, Object... objArr);
}
