package androidx.work.impl.p059a;

/* renamed from: androidx.work.impl.a.b */
public class C1212b {

    /* renamed from: a */
    private boolean f3783a;

    /* renamed from: b */
    private boolean f3784b;

    /* renamed from: c */
    private boolean f3785c;

    /* renamed from: d */
    private boolean f3786d;

    public C1212b(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f3783a = z;
        this.f3784b = z2;
        this.f3785c = z3;
        this.f3786d = z4;
    }

    /* renamed from: a */
    public boolean mo6450a() {
        return this.f3783a;
    }

    /* renamed from: b */
    public boolean mo6451b() {
        return this.f3784b;
    }

    /* renamed from: c */
    public boolean mo6452c() {
        return this.f3785c;
    }

    /* renamed from: d */
    public boolean mo6453d() {
        return this.f3786d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1212b bVar = (C1212b) obj;
        return this.f3783a == bVar.f3783a && this.f3784b == bVar.f3784b && this.f3785c == bVar.f3785c && this.f3786d == bVar.f3786d;
    }

    public int hashCode() {
        int i = this.f3783a ? 1 : 0;
        if (this.f3784b) {
            i += 16;
        }
        if (this.f3785c) {
            i += 256;
        }
        return this.f3786d ? i + 4096 : i;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", new Object[]{Boolean.valueOf(this.f3783a), Boolean.valueOf(this.f3784b), Boolean.valueOf(this.f3785c), Boolean.valueOf(this.f3786d)});
    }
}
