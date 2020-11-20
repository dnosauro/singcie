package androidx.p049j;

import android.annotation.SuppressLint;
import android.view.View;

/* renamed from: androidx.j.ag */
class C0833ag extends C0832af {

    /* renamed from: a */
    private static boolean f2790a = true;

    C0833ag() {
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo4682a(View view, int i, int i2, int i3, int i4) {
        if (f2790a) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                f2790a = false;
            }
        }
    }
}
