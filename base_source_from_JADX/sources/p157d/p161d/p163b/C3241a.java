package p157d.p161d.p163b;

import java.io.Serializable;
import p157d.p165f.C3267a;
import p157d.p165f.C3269c;

/* renamed from: d.d.b.a */
public abstract class C3241a implements C3267a, Serializable {

    /* renamed from: b */
    public static final Object f7290b = C3242a.f7293a;

    /* renamed from: a */
    protected final Object f7291a;

    /* renamed from: c */
    private transient C3267a f7292c;

    /* renamed from: d.d.b.a$a */
    private static class C3242a implements Serializable {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C3242a f7293a = new C3242a();

        private C3242a() {
        }
    }

    protected C3241a(Object obj) {
        this.f7291a = obj;
    }

    /* renamed from: c */
    public C3269c mo22787c() {
        throw new AbstractMethodError();
    }

    /* renamed from: d */
    public String mo22788d() {
        throw new AbstractMethodError();
    }

    /* renamed from: e */
    public String mo22789e() {
        throw new AbstractMethodError();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public abstract C3267a mo25689f();

    /* renamed from: g */
    public Object mo25690g() {
        return this.f7291a;
    }

    /* renamed from: h */
    public C3267a mo25691h() {
        C3267a aVar = this.f7292c;
        if (aVar != null) {
            return aVar;
        }
        C3267a f = mo25689f();
        this.f7292c = f;
        return f;
    }
}
