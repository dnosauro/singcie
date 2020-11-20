package androidx.core.p030h.p031a;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* renamed from: androidx.core.h.a.e */
public class C0621e {

    /* renamed from: a */
    private final AccessibilityRecord f2287a;

    /* renamed from: a */
    public static void m2488a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    /* renamed from: a */
    public static void m2489a(AccessibilityRecord accessibilityRecord, View view, int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            accessibilityRecord.setSource(view, i);
        }
    }

    /* renamed from: b */
    public static void m2490b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0621e)) {
            return false;
        }
        C0621e eVar = (C0621e) obj;
        AccessibilityRecord accessibilityRecord = this.f2287a;
        if (accessibilityRecord == null) {
            if (eVar.f2287a != null) {
                return false;
            }
        } else if (!accessibilityRecord.equals(eVar.f2287a)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f2287a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }
}
