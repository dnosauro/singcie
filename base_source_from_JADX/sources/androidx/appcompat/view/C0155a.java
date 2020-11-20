package androidx.appcompat.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import androidx.appcompat.C0059a;

/* renamed from: androidx.appcompat.view.a */
public class C0155a {

    /* renamed from: a */
    private Context f427a;

    private C0155a(Context context) {
        this.f427a = context;
    }

    /* renamed from: a */
    public static C0155a m446a(Context context) {
        return new C0155a(context);
    }

    /* renamed from: a */
    public int mo1128a() {
        Configuration configuration = this.f427a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i > 960 && i2 > 720) {
            return 5;
        }
        if (i > 720 && i2 > 960) {
            return 5;
        }
        if (i >= 500) {
            return 4;
        }
        if (i > 640 && i2 > 480) {
            return 4;
        }
        if (i <= 480 || i2 <= 640) {
            return i >= 360 ? 3 : 2;
        }
        return 4;
    }

    /* renamed from: b */
    public boolean mo1129b() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f427a).hasPermanentMenuKey();
    }

    /* renamed from: c */
    public int mo1130c() {
        return this.f427a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* renamed from: d */
    public boolean mo1131d() {
        return this.f427a.getResources().getBoolean(C0059a.C0061b.abc_action_bar_embed_tabs);
    }

    /* renamed from: e */
    public int mo1132e() {
        TypedArray obtainStyledAttributes = this.f427a.obtainStyledAttributes((AttributeSet) null, C0059a.C0069j.ActionBar, C0059a.C0060a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0059a.C0069j.ActionBar_height, 0);
        Resources resources = this.f427a.getResources();
        if (!mo1131d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0059a.C0063d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    /* renamed from: f */
    public boolean mo1133f() {
        return this.f427a.getApplicationInfo().targetSdkVersion < 14;
    }

    /* renamed from: g */
    public int mo1134g() {
        return this.f427a.getResources().getDimensionPixelSize(C0059a.C0063d.abc_action_bar_stacked_tab_max_width);
    }
}
