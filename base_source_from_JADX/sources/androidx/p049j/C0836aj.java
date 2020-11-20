package androidx.p049j;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import androidx.p049j.C0869j;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.j.aj */
class C0836aj {

    /* renamed from: a */
    private static Method f2792a;

    /* renamed from: b */
    private static boolean f2793b;

    /* renamed from: c */
    private static Field f2794c;

    /* renamed from: d */
    private static boolean f2795d;

    C0836aj() {
    }

    @SuppressLint({"PrivateApi"})
    /* renamed from: a */
    private void m3442a() {
        if (!f2793b) {
            Class<View> cls = View.class;
            try {
                f2792a = cls.getDeclaredMethod("setFrame", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                f2792a.setAccessible(true);
            } catch (NoSuchMethodException e) {
                Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e);
            }
            f2793b = true;
        }
    }

    /* renamed from: a */
    public float mo4676a(View view) {
        Float f = (Float) view.getTag(C0869j.C0870a.save_non_transition_alpha);
        return f != null ? view.getAlpha() / f.floatValue() : view.getAlpha();
    }

    /* renamed from: a */
    public void mo4677a(View view, float f) {
        Float f2 = (Float) view.getTag(C0869j.C0870a.save_non_transition_alpha);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    /* renamed from: a */
    public void mo4683a(View view, int i) {
        if (!f2795d) {
            try {
                f2794c = View.class.getDeclaredField("mViewFlags");
                f2794c.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f2795d = true;
        }
        Field field = f2794c;
        if (field != null) {
            try {
                f2794c.setInt(view, i | (field.getInt(view) & -13));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    /* renamed from: a */
    public void mo4682a(View view, int i, int i2, int i3, int i4) {
        m3442a();
        Method method = f2792a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    /* renamed from: a */
    public void mo4680a(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            mo4680a(view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    /* renamed from: b */
    public void mo4678b(View view) {
        if (view.getTag(C0869j.C0870a.save_non_transition_alpha) == null) {
            view.setTag(C0869j.C0870a.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    /* renamed from: b */
    public void mo4681b(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            mo4681b(view2, matrix);
            matrix.postTranslate((float) view2.getScrollX(), (float) view2.getScrollY());
        }
        matrix.postTranslate((float) (-view.getLeft()), (float) (-view.getTop()));
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }

    /* renamed from: c */
    public void mo4679c(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(C0869j.C0870a.save_non_transition_alpha, (Object) null);
        }
    }
}
