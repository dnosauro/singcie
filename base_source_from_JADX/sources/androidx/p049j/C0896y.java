package androidx.p049j;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;

/* renamed from: androidx.j.y */
class C0896y {

    /* renamed from: a */
    private static boolean f2925a = true;

    /* renamed from: a */
    static C0895x m3588a(ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new C0894w(viewGroup) : C0893v.m3579a(viewGroup);
    }

    /* renamed from: a */
    static void m3589a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (Build.VERSION.SDK_INT >= 18) {
            m3590b(viewGroup, z);
        } else {
            C0897z.m3592a(viewGroup, z);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private static void m3590b(ViewGroup viewGroup, boolean z) {
        if (f2925a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f2925a = false;
            }
        }
    }
}
