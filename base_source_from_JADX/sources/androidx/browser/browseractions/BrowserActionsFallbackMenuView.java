package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.browser.C0385a;

public class BrowserActionsFallbackMenuView extends LinearLayout {

    /* renamed from: a */
    private final int f1360a = getResources().getDimensionPixelOffset(C0385a.C0386a.browser_actions_context_menu_min_padding);

    /* renamed from: b */
    private final int f1361b = getResources().getDimensionPixelOffset(C0385a.C0386a.browser_actions_context_menu_max_width);

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.f1360a * 2), this.f1361b), 1073741824), i2);
    }
}
