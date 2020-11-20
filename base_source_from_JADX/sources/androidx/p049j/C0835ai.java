package androidx.p049j;

import android.graphics.Matrix;
import android.view.View;

/* renamed from: androidx.j.ai */
class C0835ai extends C0834ah {
    C0835ai() {
    }

    /* renamed from: a */
    public float mo4676a(View view) {
        return view.getTransitionAlpha();
    }

    /* renamed from: a */
    public void mo4677a(View view, float f) {
        view.setTransitionAlpha(f);
    }

    /* renamed from: a */
    public void mo4683a(View view, int i) {
        view.setTransitionVisibility(i);
    }

    /* renamed from: a */
    public void mo4682a(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    /* renamed from: a */
    public void mo4680a(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    /* renamed from: b */
    public void mo4681b(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
