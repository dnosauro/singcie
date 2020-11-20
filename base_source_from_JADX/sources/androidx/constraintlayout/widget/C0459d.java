package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.C0462f;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: androidx.constraintlayout.widget.d */
public class C0459d extends ViewGroup {

    /* renamed from: a */
    C0456c f1873a;

    /* renamed from: androidx.constraintlayout.widget.d$a */
    public static class C0460a extends ConstraintLayout.C0452a {

        /* renamed from: an */
        public float f1874an;

        /* renamed from: ao */
        public boolean f1875ao;

        /* renamed from: ap */
        public float f1876ap;

        /* renamed from: aq */
        public float f1877aq;

        /* renamed from: ar */
        public float f1878ar;

        /* renamed from: as */
        public float f1879as;

        /* renamed from: at */
        public float f1880at;

        /* renamed from: au */
        public float f1881au;

        /* renamed from: av */
        public float f1882av;

        /* renamed from: aw */
        public float f1883aw;

        /* renamed from: ax */
        public float f1884ax;

        /* renamed from: ay */
        public float f1885ay;

        /* renamed from: az */
        public float f1886az;

        public C0460a(int i, int i2) {
            super(i, i2);
            this.f1874an = 1.0f;
            this.f1875ao = false;
            this.f1876ap = 0.0f;
            this.f1877aq = 0.0f;
            this.f1878ar = 0.0f;
            this.f1879as = 0.0f;
            this.f1880at = 1.0f;
            this.f1881au = 1.0f;
            this.f1882av = 0.0f;
            this.f1883aw = 0.0f;
            this.f1884ax = 0.0f;
            this.f1885ay = 0.0f;
            this.f1886az = 0.0f;
        }

        public C0460a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            float f;
            this.f1874an = 1.0f;
            this.f1875ao = false;
            this.f1876ap = 0.0f;
            this.f1877aq = 0.0f;
            this.f1878ar = 0.0f;
            this.f1879as = 0.0f;
            this.f1880at = 1.0f;
            this.f1881au = 1.0f;
            this.f1882av = 0.0f;
            this.f1883aw = 0.0f;
            this.f1884ax = 0.0f;
            this.f1885ay = 0.0f;
            this.f1886az = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0462f.C0464b.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0462f.C0464b.ConstraintSet_android_alpha) {
                    this.f1874an = obtainStyledAttributes.getFloat(index, this.f1874an);
                } else if (index == C0462f.C0464b.ConstraintSet_android_elevation) {
                    this.f1876ap = obtainStyledAttributes.getFloat(index, this.f1876ap);
                    this.f1875ao = true;
                } else if (index == C0462f.C0464b.ConstraintSet_android_rotationX) {
                    this.f1878ar = obtainStyledAttributes.getFloat(index, this.f1878ar);
                } else if (index == C0462f.C0464b.ConstraintSet_android_rotationY) {
                    this.f1879as = obtainStyledAttributes.getFloat(index, this.f1879as);
                } else if (index == C0462f.C0464b.ConstraintSet_android_rotation) {
                    this.f1877aq = obtainStyledAttributes.getFloat(index, this.f1877aq);
                } else if (index == C0462f.C0464b.ConstraintSet_android_scaleX) {
                    this.f1880at = obtainStyledAttributes.getFloat(index, this.f1880at);
                } else if (index == C0462f.C0464b.ConstraintSet_android_scaleY) {
                    this.f1881au = obtainStyledAttributes.getFloat(index, this.f1881au);
                } else if (index == C0462f.C0464b.ConstraintSet_android_transformPivotX) {
                    this.f1882av = obtainStyledAttributes.getFloat(index, this.f1882av);
                } else if (index == C0462f.C0464b.ConstraintSet_android_transformPivotY) {
                    this.f1883aw = obtainStyledAttributes.getFloat(index, this.f1883aw);
                } else {
                    if (index == C0462f.C0464b.ConstraintSet_android_translationX) {
                        f = this.f1884ax;
                    } else if (index == C0462f.C0464b.ConstraintSet_android_translationY) {
                        this.f1885ay = obtainStyledAttributes.getFloat(index, this.f1885ay);
                    } else if (index == C0462f.C0464b.ConstraintSet_android_translationZ) {
                        f = this.f1886az;
                    }
                    this.f1884ax = obtainStyledAttributes.getFloat(index, f);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0460a generateDefaultLayoutParams() {
        return new C0460a(-2, -2);
    }

    /* renamed from: a */
    public C0460a generateLayoutParams(AttributeSet attributeSet) {
        return new C0460a(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.C0452a(layoutParams);
    }

    public C0456c getConstraintSet() {
        if (this.f1873a == null) {
            this.f1873a = new C0456c();
        }
        this.f1873a.mo3264a(this);
        return this.f1873a;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
