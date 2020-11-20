package com.github.appintro;

import android.view.View;
import org.jetbrains.annotations.NotNull;

public final class AppIntroBaseKt {
    /* access modifiers changed from: private */
    public static final boolean isVisible(@NotNull View view) {
        return view.getVisibility() == 0;
    }

    /* access modifiers changed from: private */
    public static final void setVisible(@NotNull View view, boolean z) {
        view.setVisibility(z ? 0 : 4);
    }
}
