package p157d;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

/* renamed from: d.d */
public final class C3216d<A, B> implements Serializable {

    /* renamed from: a */
    private final A f7288a;

    /* renamed from: b */
    private final B f7289b;

    public C3216d(A a, B b) {
        this.f7288a = a;
        this.f7289b = b;
    }

    /* renamed from: a */
    public final A mo25682a() {
        return this.f7288a;
    }

    /* renamed from: b */
    public final B mo25683b() {
        return this.f7289b;
    }

    /* renamed from: c */
    public final A mo25684c() {
        return this.f7288a;
    }

    /* renamed from: d */
    public final B mo25685d() {
        return this.f7289b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3216d)) {
            return false;
        }
        C3216d dVar = (C3216d) obj;
        return C3250h.m9055a((Object) this.f7288a, (Object) dVar.f7288a) && C3250h.m9055a((Object) this.f7289b, (Object) dVar.f7289b);
    }

    public int hashCode() {
        A a = this.f7288a;
        int i = 0;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.f7289b;
        if (b != null) {
            i = b.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return '(' + this.f7288a + ", " + this.f7289b + ')';
    }
}
