package androidx.coordinatorlayout.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: androidx.coordinatorlayout.widget.b */
public class C0480b {

    /* renamed from: a */
    private static final ThreadLocal<Matrix> f1916a = new ThreadLocal<>();

    /* renamed from: b */
    private static final ThreadLocal<RectF> f1917b = new ThreadLocal<>();

    /* renamed from: a */
    static void m1936a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = f1916a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f1916a.set(matrix);
        } else {
            matrix.reset();
        }
        m1937a((ViewParent) viewGroup, view, matrix);
        RectF rectF = f1917b.get();
        if (rectF == null) {
            rectF = new RectF();
            f1917b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* renamed from: a */
    private static void m1937a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            m1937a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }

    /* renamed from: b */
    public static void m1938b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m1936a(viewGroup, view, rect);
    }
}
