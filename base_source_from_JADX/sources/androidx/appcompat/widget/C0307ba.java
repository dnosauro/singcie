package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

/* renamed from: androidx.appcompat.widget.ba */
public class C0307ba {
    /* renamed from: a */
    public static void m1144a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            C0308bb.m1145a(view, charSequence);
        }
    }
}
