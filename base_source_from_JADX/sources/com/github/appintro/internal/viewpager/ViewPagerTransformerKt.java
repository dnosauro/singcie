package com.github.appintro.internal.viewpager;

import android.view.View;
import org.jetbrains.annotations.NotNull;

public final class ViewPagerTransformerKt {
    private static final float FLOW_ROTATION_ANGLE = -30.0f;
    private static final float MIN_ALPHA_SLIDE = 0.35f;
    private static final float MIN_ALPHA_ZOOM = 0.5f;
    private static final float MIN_SCALE_DEPTH = 0.75f;
    private static final float MIN_SCALE_ZOOM = 0.85f;
    private static final float SCALE_FACTOR_SLIDE = 0.85f;

    /* access modifiers changed from: private */
    public static final float getScaleXY(@NotNull View view) {
        return view.getScaleX();
    }

    /* access modifiers changed from: private */
    public static final void setScaleXY(@NotNull View view, float f) {
        view.setScaleX(f);
        view.setScaleY(f);
    }

    /* access modifiers changed from: private */
    public static final void transformDefaults(@NotNull View view) {
        view.setAlpha(1.0f);
        setScaleXY(view, 1.0f);
        view.setTranslationX(0.0f);
    }
}
