package androidx.core.p030h.p031a;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: androidx.core.h.a.b */
public final class C0613b {
    /* renamed from: a */
    public static int m2401a(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return accessibilityEvent.getContentChangeTypes();
        }
        return 0;
    }

    /* renamed from: a */
    public static void m2402a(AccessibilityEvent accessibilityEvent, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }
}
