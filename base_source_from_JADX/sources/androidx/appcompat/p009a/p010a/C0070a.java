package androidx.appcompat.p009a.p010a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.C0279an;
import androidx.core.content.C0529a;
import androidx.core.content.p025a.C0530a;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.a.a.a */
public final class C0070a {

    /* renamed from: a */
    private static final ThreadLocal<TypedValue> f52a = new ThreadLocal<>();

    /* renamed from: b */
    private static final WeakHashMap<Context, SparseArray<C0071a>> f53b = new WeakHashMap<>(0);

    /* renamed from: c */
    private static final Object f54c = new Object();

    /* renamed from: androidx.appcompat.a.a.a$a */
    private static class C0071a {

        /* renamed from: a */
        final ColorStateList f55a;

        /* renamed from: b */
        final Configuration f56b;

        C0071a(ColorStateList colorStateList, Configuration configuration) {
            this.f55a = colorStateList;
            this.f56b = configuration;
        }
    }

    /* renamed from: a */
    public static ColorStateList m60a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList d = m65d(context, i);
        if (d != null) {
            return d;
        }
        ColorStateList c = m64c(context, i);
        if (c == null) {
            return C0529a.m2100b(context, i);
        }
        m62a(context, i, c);
        return c;
    }

    /* renamed from: a */
    private static TypedValue m61a() {
        TypedValue typedValue = f52a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f52a.set(typedValue2);
        return typedValue2;
    }

    /* renamed from: a */
    private static void m62a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f54c) {
            SparseArray sparseArray = f53b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f53b.put(context, sparseArray);
            }
            sparseArray.append(i, new C0071a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    /* renamed from: b */
    public static Drawable m63b(Context context, int i) {
        return C0279an.m994a().mo2241a(context, i);
    }

    /* renamed from: c */
    private static ColorStateList m64c(Context context, int i) {
        if (m66e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return C0530a.m2106a(resources, (XmlPullParser) resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        return null;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList m65d(android.content.Context r4, int r5) {
        /*
            java.lang.Object r0 = f54c
            monitor-enter(r0)
            java.util.WeakHashMap<android.content.Context, android.util.SparseArray<androidx.appcompat.a.a.a$a>> r1 = f53b     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0035 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0032
            int r2 = r1.size()     // Catch:{ all -> 0x0035 }
            if (r2 <= 0) goto L_0x0032
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0035 }
            androidx.appcompat.a.a.a$a r2 = (androidx.appcompat.p009a.p010a.C0070a.C0071a) r2     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0032
            android.content.res.Configuration r3 = r2.f56b     // Catch:{ all -> 0x0035 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0035 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0035 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x002f
            android.content.res.ColorStateList r4 = r2.f55a     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r4
        L_0x002f:
            r1.remove(r5)     // Catch:{ all -> 0x0035 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            r4 = 0
            return r4
        L_0x0035:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.p009a.p010a.C0070a.m65d(android.content.Context, int):android.content.res.ColorStateList");
    }

    /* renamed from: e */
    private static boolean m66e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue a = m61a();
        resources.getValue(i, a, true);
        return a.type >= 28 && a.type <= 31;
    }
}
