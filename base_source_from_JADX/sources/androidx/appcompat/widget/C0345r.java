package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.C0059a;
import androidx.core.widget.C0686h;

/* renamed from: androidx.appcompat.widget.r */
class C0345r extends PopupWindow {

    /* renamed from: a */
    private static final boolean f1230a = (Build.VERSION.SDK_INT < 21);

    /* renamed from: b */
    private boolean f1231b;

    public C0345r(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m1272a(context, attributeSet, i, i2);
    }

    /* renamed from: a */
    private void m1272a(Context context, AttributeSet attributeSet, int i, int i2) {
        C0302ay a = C0302ay.m1078a(context, attributeSet, C0059a.C0069j.PopupWindow, i, i2);
        if (a.mo2424g(C0059a.C0069j.PopupWindow_overlapAnchor)) {
            m1273a(a.mo2411a(C0059a.C0069j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.mo2409a(C0059a.C0069j.PopupWindow_android_popupBackground));
        a.mo2410a();
    }

    /* renamed from: a */
    private void m1273a(boolean z) {
        if (f1230a) {
            this.f1231b = z;
        } else {
            C0686h.m2800a((PopupWindow) this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f1230a && this.f1231b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f1230a && this.f1231b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (f1230a && this.f1231b) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }
}
