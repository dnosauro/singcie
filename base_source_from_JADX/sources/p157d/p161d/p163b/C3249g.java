package p157d.p161d.p163b;

import p157d.p165f.C3267a;
import p157d.p165f.C3270d;

/* renamed from: d.d.b.g */
public class C3249g extends C3241a implements C3248f, C3270d {

    /* renamed from: c */
    private final int f7302c;

    public C3249g(int i, Object obj) {
        super(obj);
        this.f7302c = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C3249g) {
            C3249g gVar = (C3249g) obj;
            if (mo22787c() != null ? mo22787c().equals(gVar.mo22787c()) : gVar.mo22787c() == null) {
                return mo22788d().equals(gVar.mo22788d()) && mo22789e().equals(gVar.mo22789e()) && C3250h.m9055a(mo25690g(), gVar.mo25690g());
            }
        } else if (obj instanceof C3270d) {
            return obj.equals(mo25691h());
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public C3267a mo25689f() {
        return C3254k.m9060a(this);
    }

    public int hashCode() {
        return (((mo22787c() == null ? 0 : mo22787c().hashCode() * 31) + mo22788d().hashCode()) * 31) + mo22789e().hashCode();
    }

    public String toString() {
        C3267a h = mo25691h();
        if (h != this) {
            return h.toString();
        }
        if ("<init>".equals(mo22788d())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + mo22788d() + " (Kotlin reflection is not available)";
    }
}
