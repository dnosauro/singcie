package androidx.core.p029g;

/* renamed from: androidx.core.g.d */
public class C0583d<F, S> {

    /* renamed from: a */
    public final F f2177a;

    /* renamed from: b */
    public final S f2178b;

    public C0583d(F f, S s) {
        this.f2177a = f;
        this.f2178b = s;
    }

    /* renamed from: a */
    public static <A, B> C0583d<A, B> m2257a(A a, B b) {
        return new C0583d<>(a, b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0583d)) {
            return false;
        }
        C0583d dVar = (C0583d) obj;
        return C0582c.m2256a(dVar.f2177a, this.f2177a) && C0582c.m2256a(dVar.f2178b, this.f2178b);
    }

    public int hashCode() {
        F f = this.f2177a;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.f2178b;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f2177a) + " " + String.valueOf(this.f2178b) + "}";
    }
}
