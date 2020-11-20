package androidx.p049j;

import android.annotation.SuppressLint;
import android.view.View;

/* renamed from: androidx.j.ae */
class C0831ae extends C0836aj {

    /* renamed from: a */
    private static boolean f2786a = true;

    C0831ae() {
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public float mo4676a(View view) {
        if (f2786a) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f2786a = false;
            }
        }
        return view.getAlpha();
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void mo4677a(View view, float f) {
        if (f2786a) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                f2786a = false;
            }
        }
        view.setAlpha(f);
    }

    /* renamed from: b */
    public void mo4678b(View view) {
    }

    /* renamed from: c */
    public void mo4679c(View view) {
    }
}
