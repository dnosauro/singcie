package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* renamed from: androidx.core.widget.c */
public final class C0681c {

    /* renamed from: a */
    private static Field f2404a;

    /* renamed from: b */
    private static boolean f2405b;

    /* renamed from: a */
    public static ColorStateList m2785a(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 21) {
            return compoundButton.getButtonTintList();
        }
        if (compoundButton instanceof C0689j) {
            return ((C0689j) compoundButton).getSupportButtonTintList();
        }
        return null;
    }

    /* renamed from: a */
    public static void m2786a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintList(colorStateList);
        } else if (compoundButton instanceof C0689j) {
            ((C0689j) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m2787a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            compoundButton.setButtonTintMode(mode);
        } else if (compoundButton instanceof C0689j) {
            ((C0689j) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    /* renamed from: b */
    public static Drawable m2788b(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!f2405b) {
            try {
                f2404a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f2404a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
            }
            f2405b = true;
        }
        Field field = f2404a;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException e2) {
                Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                f2404a = null;
            }
        }
        return null;
    }
}
