package com.github.appintro.indicator;

import android.content.Context;
import android.view.View;
import org.jetbrains.annotations.NotNull;

public interface IndicatorController {
    int getSelectedIndicatorColor();

    int getUnselectedIndicatorColor();

    void initialize(int i);

    @NotNull
    View newInstance(@NotNull Context context);

    void selectPosition(int i);

    void setSelectedIndicatorColor(int i);

    void setUnselectedIndicatorColor(int i);
}
