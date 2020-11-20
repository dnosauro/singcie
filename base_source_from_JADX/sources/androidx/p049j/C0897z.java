package androidx.p049j;

import android.animation.LayoutTransition;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.j.z */
class C0897z {

    /* renamed from: a */
    private static LayoutTransition f2926a;

    /* renamed from: b */
    private static Field f2927b;

    /* renamed from: c */
    private static boolean f2928c;

    /* renamed from: d */
    private static Method f2929d;

    /* renamed from: e */
    private static boolean f2930e;

    /* renamed from: a */
    private static void m3591a(LayoutTransition layoutTransition) {
        String str;
        String str2;
        if (!f2930e) {
            try {
                f2929d = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                f2929d.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.i("ViewGroupUtilsApi14", "Failed to access cancel method by reflection");
            }
            f2930e = true;
        }
        Method method = f2929d;
        if (method != null) {
            try {
                method.invoke(layoutTransition, new Object[0]);
                return;
            } catch (IllegalAccessException unused2) {
                str = "ViewGroupUtilsApi14";
                str2 = "Failed to access cancel method by reflection";
            } catch (InvocationTargetException unused3) {
                str = "ViewGroupUtilsApi14";
                str2 = "Failed to invoke cancel method by reflection";
            }
        } else {
            return;
        }
        Log.i(str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void m3592a(android.view.ViewGroup r5, boolean r6) {
        /*
            android.animation.LayoutTransition r0 = f2926a
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x002a
            androidx.j.z$1 r0 = new androidx.j.z$1
            r0.<init>()
            f2926a = r0
            android.animation.LayoutTransition r0 = f2926a
            r4 = 2
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = f2926a
            r0.setAnimator(r2, r3)
            android.animation.LayoutTransition r0 = f2926a
            r0.setAnimator(r1, r3)
            android.animation.LayoutTransition r0 = f2926a
            r4 = 3
            r0.setAnimator(r4, r3)
            android.animation.LayoutTransition r0 = f2926a
            r4 = 4
            r0.setAnimator(r4, r3)
        L_0x002a:
            if (r6 == 0) goto L_0x004a
            android.animation.LayoutTransition r6 = r5.getLayoutTransition()
            if (r6 == 0) goto L_0x0044
            boolean r0 = r6.isRunning()
            if (r0 == 0) goto L_0x003b
            m3591a(r6)
        L_0x003b:
            android.animation.LayoutTransition r0 = f2926a
            if (r6 == r0) goto L_0x0044
            int r0 = androidx.p049j.C0869j.C0870a.transition_layout_save
            r5.setTag(r0, r6)
        L_0x0044:
            android.animation.LayoutTransition r6 = f2926a
        L_0x0046:
            r5.setLayoutTransition(r6)
            goto L_0x009a
        L_0x004a:
            r5.setLayoutTransition(r3)
            boolean r6 = f2928c
            if (r6 != 0) goto L_0x006a
            java.lang.Class<android.view.ViewGroup> r6 = android.view.ViewGroup.class
            java.lang.String r0 = "mLayoutSuppressed"
            java.lang.reflect.Field r6 = r6.getDeclaredField(r0)     // Catch:{ NoSuchFieldException -> 0x0061 }
            f2927b = r6     // Catch:{ NoSuchFieldException -> 0x0061 }
            java.lang.reflect.Field r6 = f2927b     // Catch:{ NoSuchFieldException -> 0x0061 }
            r6.setAccessible(r1)     // Catch:{ NoSuchFieldException -> 0x0061 }
            goto L_0x0068
        L_0x0061:
            java.lang.String r6 = "ViewGroupUtilsApi14"
            java.lang.String r0 = "Failed to access mLayoutSuppressed field by reflection"
            android.util.Log.i(r6, r0)
        L_0x0068:
            f2928c = r1
        L_0x006a:
            java.lang.reflect.Field r6 = f2927b
            if (r6 == 0) goto L_0x0085
            boolean r6 = r6.getBoolean(r5)     // Catch:{ IllegalAccessException -> 0x007e }
            if (r6 == 0) goto L_0x007c
            java.lang.reflect.Field r0 = f2927b     // Catch:{ IllegalAccessException -> 0x007a }
            r0.setBoolean(r5, r2)     // Catch:{ IllegalAccessException -> 0x007a }
            goto L_0x007c
        L_0x007a:
            r2 = r6
            goto L_0x007e
        L_0x007c:
            r2 = r6
            goto L_0x0085
        L_0x007e:
            java.lang.String r6 = "ViewGroupUtilsApi14"
            java.lang.String r0 = "Failed to get mLayoutSuppressed field by reflection"
            android.util.Log.i(r6, r0)
        L_0x0085:
            if (r2 == 0) goto L_0x008a
            r5.requestLayout()
        L_0x008a:
            int r6 = androidx.p049j.C0869j.C0870a.transition_layout_save
            java.lang.Object r6 = r5.getTag(r6)
            android.animation.LayoutTransition r6 = (android.animation.LayoutTransition) r6
            if (r6 == 0) goto L_0x009a
            int r0 = androidx.p049j.C0869j.C0870a.transition_layout_save
            r5.setTag(r0, r3)
            goto L_0x0046
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p049j.C0897z.m3592a(android.view.ViewGroup, boolean):void");
    }
}
