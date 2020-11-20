package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;

/* renamed from: androidx.appcompat.widget.bc */
class C0311bc {

    /* renamed from: a */
    private final Context f1132a;

    /* renamed from: b */
    private final View f1133b;

    /* renamed from: c */
    private final TextView f1134c;

    /* renamed from: d */
    private final WindowManager.LayoutParams f1135d = new WindowManager.LayoutParams();

    /* renamed from: e */
    private final Rect f1136e = new Rect();

    /* renamed from: f */
    private final int[] f1137f = new int[2];

    /* renamed from: g */
    private final int[] f1138g = new int[2];

    C0311bc(Context context) {
        this.f1132a = context;
        this.f1133b = LayoutInflater.from(this.f1132a).inflate(C0059a.C0066g.abc_tooltip, (ViewGroup) null);
        this.f1134c = (TextView) this.f1133b.findViewById(C0059a.C0065f.message);
        this.f1135d.setTitle(getClass().getSimpleName());
        this.f1135d.packageName = this.f1132a.getPackageName();
        WindowManager.LayoutParams layoutParams = this.f1135d;
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = C0059a.C0068i.Animation_AppCompat_Tooltip;
        this.f1135d.flags = 24;
    }

    /* renamed from: a */
    private static View m1153a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* renamed from: a */
    private void m1154a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int i3;
        int i4;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1132a.getResources().getDimensionPixelOffset(C0059a.C0063d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1132a.getResources().getDimensionPixelOffset(C0059a.C0063d.tooltip_precise_anchor_extra_offset);
            i4 = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            i4 = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1132a.getResources().getDimensionPixelOffset(z ? C0059a.C0063d.tooltip_y_offset_touch : C0059a.C0063d.tooltip_y_offset_non_touch);
        View a = m1153a(view);
        if (a == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        a.getWindowVisibleDisplayFrame(this.f1136e);
        if (this.f1136e.left < 0 && this.f1136e.top < 0) {
            Resources resources = this.f1132a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", AbstractSpiCall.ANDROID_CLIENT_TYPE);
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1136e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        a.getLocationOnScreen(this.f1138g);
        view.getLocationOnScreen(this.f1137f);
        int[] iArr = this.f1137f;
        int i5 = iArr[0];
        int[] iArr2 = this.f1138g;
        iArr[0] = i5 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i) - (a.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1133b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1133b.getMeasuredHeight();
        int[] iArr3 = this.f1137f;
        int i6 = ((iArr3[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i7 = iArr3[1] + i4 + dimensionPixelOffset3;
        if (!z ? measuredHeight + i7 > this.f1136e.height() : i6 >= 0) {
            layoutParams.y = i6;
        } else {
            layoutParams.y = i7;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2447a() {
        if (mo2449b()) {
            ((WindowManager) this.f1132a.getSystemService("window")).removeView(this.f1133b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2448a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (mo2449b()) {
            mo2447a();
        }
        this.f1134c.setText(charSequence);
        m1154a(view, i, i2, z, this.f1135d);
        ((WindowManager) this.f1132a.getSystemService("window")).addView(this.f1133b, this.f1135d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo2449b() {
        return this.f1133b.getParent() != null;
    }
}
