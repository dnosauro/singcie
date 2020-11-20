package p157d.p161d.p163b;

import java.util.Arrays;
import p157d.C3183a;
import p157d.C3271g;

/* renamed from: d.d.b.h */
public class C3250h {
    private C3250h() {
    }

    /* renamed from: a */
    public static int m9049a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    /* renamed from: a */
    private static <T extends Throwable> T m9050a(T t) {
        return m9051a(t, C3250h.class.getName());
    }

    /* renamed from: a */
    static <T extends Throwable> T m9051a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    /* renamed from: a */
    public static void m9052a() {
        throw ((C3183a) m9050a(new C3183a()));
    }

    /* renamed from: a */
    public static void m9053a(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m9050a(new IllegalStateException(str + " must not be null")));
        }
    }

    /* renamed from: a */
    public static void m9054a(String str) {
        throw ((C3271g) m9050a(new C3271g(str)));
    }

    /* renamed from: a */
    public static boolean m9055a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* renamed from: b */
    public static void m9056b(Object obj, String str) {
        if (obj == null) {
            m9058c(str);
        }
    }

    /* renamed from: b */
    public static void m9057b(String str) {
        m9054a("lateinit property " + str + " has not been initialized");
    }

    /* renamed from: c */
    private static void m9058c(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        throw ((IllegalArgumentException) m9050a(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str)));
    }
}
