package p076c.p078b;

@Deprecated
/* renamed from: c.b.a */
public class C1395a {
    protected C1395a() {
    }

    /* renamed from: a */
    public static void m5304a(String str) {
        if (str == null) {
            throw new C1396b();
        }
        throw new C1396b(str);
    }

    /* renamed from: a */
    public static void m5305a(String str, Object obj) {
        m5306a(str, obj != null);
    }

    /* renamed from: a */
    public static void m5306a(String str, boolean z) {
        if (!z) {
            m5304a(str);
        }
    }
}
