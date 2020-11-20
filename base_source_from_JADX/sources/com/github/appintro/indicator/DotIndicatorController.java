package com.github.appintro.indicator;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.C0529a;
import com.github.appintro.C2142R;
import org.jetbrains.annotations.NotNull;
import p157d.C3266f;
import p157d.p161d.p163b.C3250h;

public final class DotIndicatorController extends LinearLayout implements IndicatorController {
    private int currentPosition;
    private int selectedIndicatorColor = -1;
    private int slideCount;
    private int unselectedIndicatorColor = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DotIndicatorController(@NotNull Context context) {
        super(context);
        C3250h.m9056b(context, "context");
    }

    public int getSelectedIndicatorColor() {
        return this.selectedIndicatorColor;
    }

    public int getUnselectedIndicatorColor() {
        return this.unselectedIndicatorColor;
    }

    public void initialize(int i) {
        this.slideCount = i;
        for (int i2 = 0; i2 < i; i2++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(C0529a.m2093a(getContext(), C2142R.C2144drawable.ic_appintro_indicator_unselected));
            addView(imageView, new LinearLayout.LayoutParams(-2, -2));
        }
        selectPosition(0);
    }

    @NotNull
    public View newInstance(@NotNull Context context) {
        C3250h.m9056b(context, "context");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 16;
        setLayoutParams(layoutParams);
        setOrientation(0);
        setGravity(17);
        return this;
    }

    public void selectPosition(int i) {
        this.currentPosition = i;
        int i2 = this.slideCount;
        int i3 = 0;
        while (i3 < i2) {
            Drawable a = C0529a.m2093a(getContext(), i3 == i ? C2142R.C2144drawable.ic_appintro_indicator_selected : C2142R.C2144drawable.ic_appintro_indicator_unselected);
            if (getSelectedIndicatorColor() != 1 && i3 == i) {
                if (a == null) {
                    C3250h.m9052a();
                }
                a.mutate().setColorFilter(getSelectedIndicatorColor(), PorterDuff.Mode.SRC_IN);
            }
            if (!(getUnselectedIndicatorColor() == 1 || i3 == i)) {
                if (a == null) {
                    C3250h.m9052a();
                }
                a.mutate().setColorFilter(getUnselectedIndicatorColor(), PorterDuff.Mode.SRC_IN);
            }
            View childAt = getChildAt(i3);
            if (childAt != null) {
                ((ImageView) childAt).setImageDrawable(a);
                i3++;
            } else {
                throw new C3266f("null cannot be cast to non-null type android.widget.ImageView");
            }
        }
    }

    public void setSelectedIndicatorColor(int i) {
        this.selectedIndicatorColor = i;
        selectPosition(this.currentPosition);
    }

    public void setUnselectedIndicatorColor(int i) {
        this.unselectedIndicatorColor = i;
        selectPosition(this.currentPosition);
    }
}
