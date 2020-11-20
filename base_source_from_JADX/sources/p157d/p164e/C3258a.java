package p157d.p164e;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p158a.C3206v;
import p157d.p160c.C3215a;

/* renamed from: d.e.a */
public class C3258a implements Iterable<Integer> {

    /* renamed from: a */
    public static final C3259a f7308a = new C3259a((C3247e) null);

    /* renamed from: b */
    private final int f7309b;

    /* renamed from: c */
    private final int f7310c;

    /* renamed from: d */
    private final int f7311d;

    /* renamed from: d.e.a$a */
    public static final class C3259a {
        private C3259a() {
        }

        public /* synthetic */ C3259a(C3247e eVar) {
            this();
        }

        @NotNull
        /* renamed from: a */
        public final C3258a mo25716a(int i, int i2, int i3) {
            return new C3258a(i, i2, i3);
        }
    }

    public C3258a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.f7309b = i;
            this.f7310c = C3215a.m9025a(i, i2, i3);
            this.f7311d = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    /* renamed from: a */
    public final int mo25707a() {
        return this.f7309b;
    }

    /* renamed from: b */
    public final int mo25708b() {
        return this.f7310c;
    }

    /* renamed from: c */
    public final int mo25709c() {
        return this.f7311d;
    }

    @NotNull
    /* renamed from: d */
    public C3206v iterator() {
        return new C3260b(this.f7309b, this.f7310c, this.f7311d);
    }

    /* renamed from: e */
    public boolean mo25711e() {
        if (this.f7311d > 0) {
            if (this.f7309b > this.f7310c) {
                return true;
            }
        } else if (this.f7309b < this.f7310c) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C3258a) {
            if (!mo25711e() || !((C3258a) obj).mo25711e()) {
                C3258a aVar = (C3258a) obj;
                if (!(this.f7309b == aVar.f7309b && this.f7310c == aVar.f7310c && this.f7311d == aVar.f7311d)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (mo25711e()) {
            return -1;
        }
        return (((this.f7309b * 31) + this.f7310c) * 31) + this.f7311d;
    }

    @NotNull
    public String toString() {
        int i;
        StringBuilder sb;
        if (this.f7311d > 0) {
            sb = new StringBuilder();
            sb.append(this.f7309b);
            sb.append("..");
            sb.append(this.f7310c);
            sb.append(" step ");
            i = this.f7311d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f7309b);
            sb.append(" downTo ");
            sb.append(this.f7310c);
            sb.append(" step ");
            i = -this.f7311d;
        }
        sb.append(i);
        return sb.toString();
    }
}
