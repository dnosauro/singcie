package androidx.work.impl.p062b;

/* renamed from: androidx.work.impl.b.d */
public class C1231d {

    /* renamed from: a */
    public final String f3823a;

    /* renamed from: b */
    public final int f3824b;

    public C1231d(String str, int i) {
        this.f3823a = str;
        this.f3824b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1231d dVar = (C1231d) obj;
        if (this.f3824b != dVar.f3824b) {
            return false;
        }
        return this.f3823a.equals(dVar.f3823a);
    }

    public int hashCode() {
        return (this.f3823a.hashCode() * 31) + this.f3824b;
    }
}
