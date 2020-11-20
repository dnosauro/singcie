package androidx.p049j;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* renamed from: androidx.j.af */
class C0832af extends C0831ae {

    /* renamed from: a */
    private static boolean f2787a = true;

    /* renamed from: b */
    private static boolean f2788b = true;

    /* renamed from: c */
    private static boolean f2789c = true;

    C0832af() {
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo4680a(View view, Matrix matrix) {
        if (f2788b) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f2788b = false;
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public void mo4681b(View view, Matrix matrix) {
        if (f2789c) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f2789c = false;
            }
        }
    }
}
