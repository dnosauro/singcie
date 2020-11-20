package androidx.core.p030h;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* renamed from: androidx.core.h.e */
public final class C0640e {

    /* renamed from: a */
    private static Field f2297a;

    /* renamed from: b */
    private static boolean f2298b;

    /* renamed from: a */
    public static void m2527a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                m2528b(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                m2528b(layoutInflater, factory2);
            }
        }
    }

    /* renamed from: b */
    private static void m2528b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f2298b) {
            try {
                f2297a = LayoutInflater.class.getDeclaredField("mFactory2");
                f2297a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f2298b = true;
        }
        Field field = f2297a;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
