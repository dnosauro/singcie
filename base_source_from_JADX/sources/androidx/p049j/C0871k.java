package androidx.p049j;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* renamed from: androidx.j.k */
class C0871k implements TypeEvaluator<Rect> {

    /* renamed from: a */
    private Rect f2877a;

    C0871k() {
    }

    /* renamed from: a */
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i = rect.left + ((int) (((float) (rect2.left - rect.left)) * f));
        int i2 = rect.top + ((int) (((float) (rect2.top - rect.top)) * f));
        int i3 = rect.right + ((int) (((float) (rect2.right - rect.right)) * f));
        int i4 = rect.bottom + ((int) (((float) (rect2.bottom - rect.bottom)) * f));
        Rect rect3 = this.f2877a;
        if (rect3 == null) {
            return new Rect(i, i2, i3, i4);
        }
        rect3.set(i, i2, i3, i4);
        return this.f2877a;
    }
}
