package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.p030h.C0637c;
import androidx.core.p030h.C0656u;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: androidx.core.widget.h */
public final class C0686h {

    /* renamed from: a */
    private static Method f2407a;

    /* renamed from: b */
    private static boolean f2408b;

    /* renamed from: c */
    private static Field f2409c;

    /* renamed from: d */
    private static boolean f2410d;

    /* renamed from: a */
    public static void m2798a(PopupWindow popupWindow, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i);
            return;
        }
        if (!f2408b) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                f2407a = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f2407a.setAccessible(true);
            } catch (Exception unused) {
            }
            f2408b = true;
        }
        Method method = f2407a;
        if (method != null) {
            try {
                method.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception unused2) {
            }
        }
    }

    /* renamed from: a */
    public static void m2799a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 19) {
            popupWindow.showAsDropDown(view, i, i2, i3);
            return;
        }
        if ((C0637c.m2519a(i3, C0656u.m2621g(view)) & 7) == 5) {
            i -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i, i2);
    }

    /* renamed from: a */
    public static void m2800a(PopupWindow popupWindow, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z);
        } else if (Build.VERSION.SDK_INT >= 21) {
            if (!f2410d) {
                try {
                    f2409c = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f2409c.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
                }
                f2410d = true;
            }
            Field field = f2409c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e2);
                }
            }
        }
    }
}
