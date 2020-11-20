package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.graphics.C0589a;

/* renamed from: androidx.appcompat.widget.at */
class C0297at {

    /* renamed from: a */
    static final int[] f1074a = {-16842910};

    /* renamed from: b */
    static final int[] f1075b = {16842908};

    /* renamed from: c */
    static final int[] f1076c = {16843518};

    /* renamed from: d */
    static final int[] f1077d = {16842919};

    /* renamed from: e */
    static final int[] f1078e = {16842912};

    /* renamed from: f */
    static final int[] f1079f = {16842913};

    /* renamed from: g */
    static final int[] f1080g = {-16842919, -16842908};

    /* renamed from: h */
    static final int[] f1081h = new int[0];

    /* renamed from: i */
    private static final ThreadLocal<TypedValue> f1082i = new ThreadLocal<>();

    /* renamed from: j */
    private static final int[] f1083j = new int[1];

    /* renamed from: a */
    public static int m1066a(Context context, int i) {
        int[] iArr = f1083j;
        iArr[0] = i;
        C0302ay a = C0302ay.m1077a(context, (AttributeSet) null, iArr);
        try {
            return a.mo2413b(0, 0);
        } finally {
            a.mo2410a();
        }
    }

    /* renamed from: a */
    static int m1067a(Context context, int i, float f) {
        int a = m1066a(context, i);
        return C0589a.m2272b(a, Math.round(((float) Color.alpha(a)) * f));
    }

    /* renamed from: a */
    private static TypedValue m1068a() {
        TypedValue typedValue = f1082i.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f1082i.set(typedValue2);
        return typedValue2;
    }

    /* renamed from: b */
    public static ColorStateList m1069b(Context context, int i) {
        int[] iArr = f1083j;
        iArr[0] = i;
        C0302ay a = C0302ay.m1077a(context, (AttributeSet) null, iArr);
        try {
            return a.mo2420e(0);
        } finally {
            a.mo2410a();
        }
    }

    /* renamed from: c */
    public static int m1070c(Context context, int i) {
        ColorStateList b = m1069b(context, i);
        if (b != null && b.isStateful()) {
            return b.getColorForState(f1074a, b.getDefaultColor());
        }
        TypedValue a = m1068a();
        context.getTheme().resolveAttribute(16842803, a, true);
        return m1067a(context, i, a.getFloat());
    }
}
