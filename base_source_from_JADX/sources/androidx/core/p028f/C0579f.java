package androidx.core.p028f;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* renamed from: androidx.core.f.f */
public final class C0579f {

    /* renamed from: a */
    private static final Locale f2174a = new Locale("", "");

    /* renamed from: a */
    public static int m2251a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale == null || locale.equals(f2174a)) {
            return 0;
        }
        String a = C0567b.m2227a(locale);
        return a == null ? m2252b(locale) : (a.equalsIgnoreCase("Arab") || a.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }

    /* renamed from: b */
    private static int m2252b(Locale locale) {
        switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
            case 1:
            case 2:
                return 1;
            default:
                return 0;
        }
    }
}
