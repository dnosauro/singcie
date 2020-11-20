package p000a.p001a;

import javax.p169a.C3295a;

/* renamed from: a.a.a */
public final class C0000a<T> implements C3295a<T> {

    /* renamed from: a */
    static final /* synthetic */ boolean f0a = (!C0000a.class.desiredAssertionStatus());

    /* renamed from: b */
    private static final Object f1b = new Object();

    /* renamed from: c */
    private volatile C3295a<T> f2c;

    /* renamed from: d */
    private volatile Object f3d = f1b;

    private C0000a(C3295a<T> aVar) {
        if (f0a || aVar != null) {
            this.f2c = aVar;
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static Object m0a(Object obj, Object obj2) {
        if (!(obj != f1b && !(obj instanceof C0003d)) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    /* renamed from: a */
    public static <P extends C3295a<T>, T> C3295a<T> m1a(P p) {
        C0004e.m3a(p);
        return p instanceof C0000a ? p : new C0000a(p);
    }

    public T get() {
        T t = this.f3d;
        if (t == f1b) {
            synchronized (this) {
                t = this.f3d;
                if (t == f1b) {
                    t = this.f2c.get();
                    this.f3d = m0a(this.f3d, t);
                    this.f2c = null;
                }
            }
        }
        return t;
    }
}
