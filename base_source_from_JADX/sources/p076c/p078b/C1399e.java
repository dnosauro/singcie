package p076c.p078b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* renamed from: c.b.e */
public abstract class C1399e extends C1395a implements C1398d {

    /* renamed from: a */
    private String f4199a;

    public C1399e() {
        this.f4199a = null;
    }

    public C1399e(String str) {
        this.f4199a = str;
    }

    /* renamed from: b */
    public static void m5311b(String str) {
        C1395a.m5304a(str);
    }

    /* renamed from: b */
    public static void m5312b(String str, Object obj) {
        C1395a.m5305a(str, obj);
    }

    /* renamed from: a */
    public int mo6835a() {
        return 1;
    }

    /* renamed from: b */
    public void mo6841b() {
        mo6844d();
        try {
            mo6842c();
            try {
                mo6845e();
                th = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable unused) {
        }
        if (th != null) {
            throw th;
        }
        return;
        throw th;
    }

    /* renamed from: b */
    public void mo6838b(C1402h hVar) {
        hVar.mo6857a(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo6842c() {
        m5312b("TestCase.fName cannot be null", this.f4199a);
        Method method = null;
        try {
            method = getClass().getMethod(this.f4199a, (Class[]) null);
        } catch (NoSuchMethodException unused) {
            m5311b("Method \"" + this.f4199a + "\" not found");
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            m5311b("Method \"" + this.f4199a + "\" should be public");
        }
        try {
            method.invoke(this, new Object[0]);
        } catch (InvocationTargetException e) {
            e.fillInStackTrace();
            throw e.getTargetException();
        } catch (IllegalAccessException e2) {
            e2.fillInStackTrace();
            throw e2;
        }
    }

    /* renamed from: c */
    public void mo6843c(String str) {
        this.f4199a = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo6844d() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo6845e() {
    }

    /* renamed from: f */
    public String mo6846f() {
        return this.f4199a;
    }

    public String toString() {
        return mo6846f() + "(" + getClass().getName() + ")";
    }
}
