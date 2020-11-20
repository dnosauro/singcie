package com.nambimobile.widgets.efab;

import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import androidx.core.content.C0529a;
import com.nambimobile.widgets.efab.C2596k;
import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;

/* renamed from: com.nambimobile.widgets.efab.l */
public final class C2602l {
    /* renamed from: a */
    public static final /* synthetic */ int m8813a(@NotNull Context context) {
        C3250h.m9056b(context, "context");
        int identifier = Build.VERSION.SDK_INT >= 21 ? 16843829 : context.getResources().getIdentifier("colorAccent", "attr", context.getPackageName());
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(identifier, typedValue, true) ? typedValue.data : C0529a.m2102c(context, C2596k.C2597a.colorAccent);
    }
}
