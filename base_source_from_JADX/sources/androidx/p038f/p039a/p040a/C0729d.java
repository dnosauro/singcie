package androidx.p038f.p039a.p040a;

import android.view.animation.Interpolator;

/* renamed from: androidx.f.a.a.d */
abstract class C0729d implements Interpolator {

    /* renamed from: a */
    private final float[] f2494a;

    /* renamed from: b */
    private final float f2495b = (1.0f / ((float) (this.f2494a.length - 1)));

    protected C0729d(float[] fArr) {
        this.f2494a = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f2494a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.f2495b;
        float f3 = (f - (((float) min) * f2)) / f2;
        float[] fArr2 = this.f2494a;
        return fArr2[min] + (f3 * (fArr2[min + 1] - fArr2[min]));
    }
}
