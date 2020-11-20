package p000a.p001a;

/* renamed from: a.a.c */
public final class C0002c<T> implements C0001b<T> {

    /* renamed from: a */
    private static final C0002c<Object> f4a = new C0002c<>((Object) null);

    /* renamed from: b */
    private final T f5b;

    private C0002c(T t) {
        this.f5b = t;
    }

    /* renamed from: a */
    public static <T> C0001b<T> m2a(T t) {
        return new C0002c(C0004e.m4a(t, "instance cannot be null"));
    }

    public T get() {
        return this.f5b;
    }
}
