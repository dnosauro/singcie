package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import androidx.appcompat.p011b.p012a.C0148c;
import androidx.core.graphics.drawable.C0597c;

@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.widget.af */
public class C0257af {

    /* renamed from: a */
    public static final Rect f933a = new Rect();

    /* renamed from: b */
    private static final int[] f934b = {16842912};

    /* renamed from: c */
    private static final int[] f935c = new int[0];

    /* renamed from: d */
    private static Class<?> f936d;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f936d = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException unused) {
            }
        }
    }

    /* renamed from: a */
    public static PorterDuff.Mode m914a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098 A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0099 A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a0 A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a7 A[Catch:{ Exception -> 0x00b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ae A[Catch:{ Exception -> 0x00b8 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Rect m915a(android.graphics.drawable.Drawable r10) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 < r1) goto L_0x0020
            android.graphics.Insets r10 = r10.getOpticalInsets()
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            int r1 = r10.left
            r0.left = r1
            int r1 = r10.right
            r0.right = r1
            int r1 = r10.top
            r0.top = r1
            int r10 = r10.bottom
            r0.bottom = r10
            return r0
        L_0x0020:
            java.lang.Class<?> r0 = f936d
            if (r0 == 0) goto L_0x00bf
            android.graphics.drawable.Drawable r10 = androidx.core.graphics.drawable.C0595a.m2331h(r10)     // Catch:{ Exception -> 0x00b8 }
            java.lang.Class r0 = r10.getClass()     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r1 = "getOpticalInsets"
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x00b8 }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch:{ Exception -> 0x00b8 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00b8 }
            java.lang.Object r10 = r0.invoke(r10, r1)     // Catch:{ Exception -> 0x00b8 }
            if (r10 == 0) goto L_0x00bf
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch:{ Exception -> 0x00b8 }
            r0.<init>()     // Catch:{ Exception -> 0x00b8 }
            java.lang.Class<?> r1 = f936d     // Catch:{ Exception -> 0x00b8 }
            java.lang.reflect.Field[] r1 = r1.getFields()     // Catch:{ Exception -> 0x00b8 }
            int r3 = r1.length     // Catch:{ Exception -> 0x00b8 }
            r4 = 0
        L_0x004a:
            if (r4 >= r3) goto L_0x00b7
            r5 = r1[r4]     // Catch:{ Exception -> 0x00b8 }
            java.lang.String r6 = r5.getName()     // Catch:{ Exception -> 0x00b8 }
            r7 = -1
            int r8 = r6.hashCode()     // Catch:{ Exception -> 0x00b8 }
            r9 = -1383228885(0xffffffffad8d9a2b, float:-1.6098308E-11)
            if (r8 == r9) goto L_0x008a
            r9 = 115029(0x1c155, float:1.6119E-40)
            if (r8 == r9) goto L_0x0080
            r9 = 3317767(0x32a007, float:4.649182E-39)
            if (r8 == r9) goto L_0x0076
            r9 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r8 == r9) goto L_0x006c
            goto L_0x0094
        L_0x006c:
            java.lang.String r8 = "right"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x00b8 }
            if (r6 == 0) goto L_0x0094
            r6 = 2
            goto L_0x0095
        L_0x0076:
            java.lang.String r8 = "left"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x00b8 }
            if (r6 == 0) goto L_0x0094
            r6 = 0
            goto L_0x0095
        L_0x0080:
            java.lang.String r8 = "top"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x00b8 }
            if (r6 == 0) goto L_0x0094
            r6 = 1
            goto L_0x0095
        L_0x008a:
            java.lang.String r8 = "bottom"
            boolean r6 = r6.equals(r8)     // Catch:{ Exception -> 0x00b8 }
            if (r6 == 0) goto L_0x0094
            r6 = 3
            goto L_0x0095
        L_0x0094:
            r6 = -1
        L_0x0095:
            switch(r6) {
                case 0: goto L_0x00ae;
                case 1: goto L_0x00a7;
                case 2: goto L_0x00a0;
                case 3: goto L_0x0099;
                default: goto L_0x0098;
            }     // Catch:{ Exception -> 0x00b8 }
        L_0x0098:
            goto L_0x00b4
        L_0x0099:
            int r5 = r5.getInt(r10)     // Catch:{ Exception -> 0x00b8 }
            r0.bottom = r5     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b4
        L_0x00a0:
            int r5 = r5.getInt(r10)     // Catch:{ Exception -> 0x00b8 }
            r0.right = r5     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b4
        L_0x00a7:
            int r5 = r5.getInt(r10)     // Catch:{ Exception -> 0x00b8 }
            r0.top = r5     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b4
        L_0x00ae:
            int r5 = r5.getInt(r10)     // Catch:{ Exception -> 0x00b8 }
            r0.left = r5     // Catch:{ Exception -> 0x00b8 }
        L_0x00b4:
            int r4 = r4 + 1
            goto L_0x004a
        L_0x00b7:
            return r0
        L_0x00b8:
            java.lang.String r10 = "DrawableUtils"
            java.lang.String r0 = "Couldn't obtain the optical insets. Ignoring."
            android.util.Log.e(r10, r0)
        L_0x00bf:
            android.graphics.Rect r10 = f933a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0257af.m915a(android.graphics.drawable.Drawable):android.graphics.Rect");
    }

    /* renamed from: b */
    static void m916b(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m918d(drawable);
        }
    }

    /* renamed from: c */
    public static boolean m917c(Drawable drawable) {
        Drawable drawable2;
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
                return true;
            }
            for (Drawable c : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                if (!m917c(c)) {
                    return false;
                }
            }
            return true;
        }
        if (drawable instanceof C0597c) {
            drawable2 = ((C0597c) drawable).mo3624a();
        } else if (drawable instanceof C0148c) {
            drawable2 = ((C0148c) drawable).getWrappedDrawable();
        } else if (!(drawable instanceof ScaleDrawable)) {
            return true;
        } else {
            drawable2 = ((ScaleDrawable) drawable).getDrawable();
        }
        return m917c(drawable2);
    }

    /* renamed from: d */
    private static void m918d(Drawable drawable) {
        int[] state = drawable.getState();
        drawable.setState((state == null || state.length == 0) ? f934b : f935c);
        drawable.setState(state);
    }
}
