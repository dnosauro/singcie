package androidx.core.p030h;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import androidx.core.p021a.p022a.C0487b;

/* renamed from: androidx.core.h.g */
public final class C0642g {
    /* renamed from: a */
    public static MenuItem m2533a(MenuItem menuItem, C0634b bVar) {
        if (menuItem instanceof C0487b) {
            return ((C0487b) menuItem).mo1238a(bVar);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    /* renamed from: a */
    public static void m2534a(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof C0487b) {
            ((C0487b) menuItem).setNumericShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c, i);
        }
    }

    /* renamed from: a */
    public static void m2535a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof C0487b) {
            ((C0487b) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    /* renamed from: a */
    public static void m2536a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof C0487b) {
            ((C0487b) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }

    /* renamed from: a */
    public static void m2537a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof C0487b) {
            ((C0487b) menuItem).mo1239a(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    /* renamed from: b */
    public static void m2538b(MenuItem menuItem, char c, int i) {
        if (menuItem instanceof C0487b) {
            ((C0487b) menuItem).setAlphabeticShortcut(c, i);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c, i);
        }
    }

    /* renamed from: b */
    public static void m2539b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof C0487b) {
            ((C0487b) menuItem).mo1242b(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }
}
