package com.github.appintro.internal;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;

public final class ScrollerCustomDuration extends Scroller {
    private double scrollDurationFactor = 6.0d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollerCustomDuration(@NotNull Context context, @NotNull Interpolator interpolator) {
        super(context, interpolator);
        C3250h.m9056b(context, "context");
        C3250h.m9056b(interpolator, "interpolator");
    }

    public final double getScrollDurationFactor() {
        return this.scrollDurationFactor;
    }

    public final void setScrollDurationFactor(double d) {
        this.scrollDurationFactor = d;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, (int) (((double) i5) * this.scrollDurationFactor));
    }
}
