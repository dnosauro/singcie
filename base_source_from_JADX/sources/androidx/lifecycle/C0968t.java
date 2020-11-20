package androidx.lifecycle;

/* renamed from: androidx.lifecycle.t */
public class C0968t {

    /* renamed from: a */
    private final C0969a f3112a;

    /* renamed from: b */
    private final C0971u f3113b;

    /* renamed from: androidx.lifecycle.t$a */
    public interface C0969a {
        /* renamed from: a */
        <T extends C0967s> T mo4503a(Class<T> cls);
    }

    /* renamed from: androidx.lifecycle.t$b */
    static abstract class C0970b implements C0969a {
        C0970b() {
        }

        /* renamed from: a */
        public abstract <T extends C0967s> T mo5144a(String str, Class<T> cls);
    }

    public C0968t(C0971u uVar, C0969a aVar) {
        this.f3112a = aVar;
        this.f3113b = uVar;
    }

    /* renamed from: a */
    public <T extends C0967s> T mo5142a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return mo5143a("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* renamed from: a */
    public <T extends C0967s> T mo5143a(String str, Class<T> cls) {
        T a = this.f3113b.mo5145a(str);
        if (cls.isInstance(a)) {
            return a;
        }
        C0969a aVar = this.f3112a;
        T a2 = aVar instanceof C0970b ? ((C0970b) aVar).mo5144a(str, cls) : aVar.mo4503a(cls);
        this.f3113b.mo5147a(str, a2);
        return a2;
    }
}
