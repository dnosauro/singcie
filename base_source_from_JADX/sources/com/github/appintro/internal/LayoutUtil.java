package com.github.appintro.internal;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;

public final class LayoutUtil {
    public static final LayoutUtil INSTANCE = new LayoutUtil();

    private LayoutUtil() {
    }

    public static final boolean isRtl(@NotNull Context context) {
        C3250h.m9056b(context, "ctx");
        if (Build.VERSION.SDK_INT >= 17) {
            Resources resources = context.getResources();
            C3250h.m9053a((Object) resources, "ctx.resources");
            Configuration configuration = resources.getConfiguration();
            C3250h.m9053a((Object) configuration, "ctx.resources.configuration");
            if (configuration.getLayoutDirection() == 1) {
                return true;
            }
        }
        return false;
    }
}
