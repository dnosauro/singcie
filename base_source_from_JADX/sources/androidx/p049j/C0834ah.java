package androidx.p049j;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* renamed from: androidx.j.ah */
class C0834ah extends C0833ag {

    /* renamed from: a */
    private static boolean f2791a = true;

    C0834ah() {
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo4683a(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.mo4683a(view, i);
        } else if (f2791a) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                f2791a = false;
            }
        }
    }
}
