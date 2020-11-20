package androidx.core.p026d;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: androidx.core.d.b */
public final class C0547b {

    /* renamed from: a */
    private static long f2076a;

    /* renamed from: b */
    private static Method f2077b;

    /* renamed from: c */
    private static Method f2078c;

    /* renamed from: d */
    private static Method f2079d;

    /* renamed from: e */
    private static Method f2080e;

    static {
        if (Build.VERSION.SDK_INT >= 18 && Build.VERSION.SDK_INT < 29) {
            try {
                f2076a = Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                f2077b = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});
                f2078c = Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                f2079d = Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                f2080e = Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});
            } catch (Exception e) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e);
            }
        }
    }

    /* renamed from: a */
    public static void m2168a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    /* renamed from: a */
    public static void m2169a(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }
}
