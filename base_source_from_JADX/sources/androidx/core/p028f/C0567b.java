package androidx.core.p028f;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* renamed from: androidx.core.f.b */
public final class C0567b {

    /* renamed from: a */
    private static Method f2146a;

    /* renamed from: b */
    private static Method f2147b;

    static {
        if (Build.VERSION.SDK_INT < 21) {
            try {
                Class<?> cls = Class.forName("libcore.icu.ICU");
                if (cls != null) {
                    f2146a = cls.getMethod("getScript", new Class[]{String.class});
                    f2147b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
                }
            } catch (Exception e) {
                f2146a = null;
                f2147b = null;
                Log.w("ICUCompat", e);
            }
        } else if (Build.VERSION.SDK_INT < 24) {
            try {
                f2147b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    /* renamed from: a */
    private static String m2226a(String str) {
        try {
            if (f2146a != null) {
                return (String) f2146a.invoke((Object) null, new Object[]{str});
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            Log.w("ICUCompat", e);
        }
        return null;
    }

    /* renamed from: a */
    public static String m2227a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return ((Locale) f2147b.invoke((Object) null, new Object[]{locale})).getScript();
            } catch (IllegalAccessException | InvocationTargetException e) {
                Log.w("ICUCompat", e);
                return locale.getScript();
            }
        } else {
            String b = m2228b(locale);
            if (b != null) {
                return m2226a(b);
            }
            return null;
        }
    }

    /* renamed from: b */
    private static String m2228b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f2147b != null) {
                return (String) f2147b.invoke((Object) null, new Object[]{locale2});
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            Log.w("ICUCompat", e);
        }
        return locale2;
    }
}
