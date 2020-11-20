package androidx.p049j;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.p030h.C0656u;

/* renamed from: androidx.j.ad */
class C0828ad {

    /* renamed from: a */
    static final Property<View, Float> f2783a = new Property<View, Float>(Float.class, "translationAlpha") {
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(C0828ad.m3421c(view));
        }

        /* renamed from: a */
        public void set(View view, Float f) {
            C0828ad.m3415a(view, f.floatValue());
        }
    };

    /* renamed from: b */
    static final Property<View, Rect> f2784b = new Property<View, Rect>(Rect.class, "clipBounds") {
        /* renamed from: a */
        public Rect get(View view) {
            return C0656u.m2568A(view);
        }

        /* renamed from: a */
        public void set(View view, Rect rect) {
            C0656u.m2589a(view, rect);
        }
    };

    /* renamed from: c */
    private static final C0836aj f2785c = (Build.VERSION.SDK_INT >= 29 ? new C0835ai() : Build.VERSION.SDK_INT >= 23 ? new C0834ah() : Build.VERSION.SDK_INT >= 22 ? new C0833ag() : Build.VERSION.SDK_INT >= 21 ? new C0832af() : Build.VERSION.SDK_INT >= 19 ? new C0831ae() : new C0836aj());

    /* renamed from: a */
    static C0827ac m3414a(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new C0826ab(view) : C0824aa.m3400d(view);
    }

    /* renamed from: a */
    static void m3415a(View view, float f) {
        f2785c.mo4677a(view, f);
    }

    /* renamed from: a */
    static void m3416a(View view, int i) {
        f2785c.mo4683a(view, i);
    }

    /* renamed from: a */
    static void m3417a(View view, int i, int i2, int i3, int i4) {
        f2785c.mo4682a(view, i, i2, i3, i4);
    }

    /* renamed from: a */
    static void m3418a(View view, Matrix matrix) {
        f2785c.mo4680a(view, matrix);
    }

    /* renamed from: b */
    static C0843an m3419b(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new C0842am(view) : new C0841al(view.getWindowToken());
    }

    /* renamed from: b */
    static void m3420b(View view, Matrix matrix) {
        f2785c.mo4681b(view, matrix);
    }

    /* renamed from: c */
    static float m3421c(View view) {
        return f2785c.mo4676a(view);
    }

    /* renamed from: d */
    static void m3422d(View view) {
        f2785c.mo4678b(view);
    }

    /* renamed from: e */
    static void m3423e(View view) {
        f2785c.mo4679c(view);
    }
}
