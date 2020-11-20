package androidx.p004a.p005a.p006a;

import java.util.concurrent.Executor;

/* renamed from: androidx.a.a.a.a */
public class C0037a extends C0042c {

    /* renamed from: a */
    private static volatile C0037a f6a;

    /* renamed from: d */
    private static final Executor f7d = new Executor() {
        public void execute(Runnable runnable) {
            C0037a.m6a().mo624b(runnable);
        }
    };

    /* renamed from: e */
    private static final Executor f8e = new Executor() {
        public void execute(Runnable runnable) {
            C0037a.m6a().mo623a(runnable);
        }
    };

    /* renamed from: b */
    private C0042c f9b = this.f10c;

    /* renamed from: c */
    private C0042c f10c = new C0040b();

    private C0037a() {
    }

    /* renamed from: a */
    public static C0037a m6a() {
        if (f6a != null) {
            return f6a;
        }
        synchronized (C0037a.class) {
            if (f6a == null) {
                f6a = new C0037a();
            }
        }
        return f6a;
    }

    /* renamed from: b */
    public static Executor m7b() {
        return f8e;
    }

    /* renamed from: a */
    public void mo623a(Runnable runnable) {
        this.f9b.mo623a(runnable);
    }

    /* renamed from: b */
    public void mo624b(Runnable runnable) {
        this.f9b.mo624b(runnable);
    }

    /* renamed from: c */
    public boolean mo625c() {
        return this.f9b.mo625c();
    }
}
