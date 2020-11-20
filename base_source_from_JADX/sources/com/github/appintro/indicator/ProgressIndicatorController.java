package com.github.appintro.indicator;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

public final class ProgressIndicatorController extends ProgressBar implements IndicatorController {
    private int selectedIndicatorColor;
    private int unselectedIndicatorColor;

    public ProgressIndicatorController(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (C3247e) null);
    }

    public ProgressIndicatorController(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (C3247e) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressIndicatorController(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C3250h.m9056b(context, "context");
        this.selectedIndicatorColor = 1;
        this.unselectedIndicatorColor = 1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProgressIndicatorController(Context context, AttributeSet attributeSet, int i, int i2, C3247e eVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 16842872 : i);
    }

    public int getSelectedIndicatorColor() {
        return this.selectedIndicatorColor;
    }

    public int getUnselectedIndicatorColor() {
        return this.unselectedIndicatorColor;
    }

    public void initialize(int i) {
        setMax(i);
        selectPosition(0);
    }

    @NotNull
    public ProgressIndicatorController newInstance(@NotNull Context context) {
        C3250h.m9056b(context, "context");
        return this;
    }

    public void selectPosition(int i) {
        setProgress(i + 1);
    }

    public void setSelectedIndicatorColor(int i) {
        this.selectedIndicatorColor = i;
        getProgressDrawable().setColorFilter(i, PorterDuff.Mode.SRC_IN);
    }

    public void setUnselectedIndicatorColor(int i) {
        this.unselectedIndicatorColor = i;
        getIndeterminateDrawable().setColorFilter(i, PorterDuff.Mode.SRC_IN);
    }
}
