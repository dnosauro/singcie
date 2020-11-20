package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.core.content.p025a.C0532c;
import androidx.core.content.p025a.C0540f;
import androidx.core.p027e.C0550b;
import androidx.p018c.C0406e;

@SuppressLint({"NewApi"})
/* renamed from: androidx.core.graphics.c */
public class C0593c {

    /* renamed from: a */
    private static final C0605i f2187a = (Build.VERSION.SDK_INT >= 29 ? new C0604h() : Build.VERSION.SDK_INT >= 28 ? new C0603g() : Build.VERSION.SDK_INT >= 26 ? new C0602f() : (Build.VERSION.SDK_INT < 24 || !C0601e.m2345a()) ? Build.VERSION.SDK_INT >= 21 ? new C0594d() : new C0605i() : new C0601e());

    /* renamed from: b */
    private static final C0406e<String, Typeface> f2188b = new C0406e<>(16);

    /* renamed from: a */
    public static Typeface m2289a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a = f2187a.mo3665a(context, resources, i, str, i2);
        if (a != null) {
            f2188b.put(m2295b(resources, i, i2), a);
        }
        return a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r2 = m2294b(r2, r3, r4);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface m2290a(android.content.Context r2, android.graphics.Typeface r3, int r4) {
        /*
            if (r2 == 0) goto L_0x0014
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 >= r1) goto L_0x000f
            android.graphics.Typeface r2 = m2294b((android.content.Context) r2, (android.graphics.Typeface) r3, (int) r4)
            if (r2 == 0) goto L_0x000f
            return r2
        L_0x000f:
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r3, r4)
            return r2
        L_0x0014:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Context cannot be null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.C0593c.m2290a(android.content.Context, android.graphics.Typeface, int):android.graphics.Typeface");
    }

    /* renamed from: a */
    public static Typeface m2291a(Context context, CancellationSignal cancellationSignal, C0550b.C0556b[] bVarArr, int i) {
        return f2187a.mo3614a(context, cancellationSignal, bVarArr, i);
    }

    /* renamed from: a */
    public static Typeface m2292a(Context context, C0532c.C0533a aVar, Resources resources, int i, int i2, C0540f.C0541a aVar2, Handler handler, boolean z) {
        Typeface typeface;
        if (aVar instanceof C0532c.C0536d) {
            C0532c.C0536d dVar = (C0532c.C0536d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.mo3534b() == 0) {
                z2 = true;
            }
            typeface = C0550b.m2178a(context, dVar.mo3533a(), aVar2, handler, z2, z ? dVar.mo3535c() : -1, i2);
        } else {
            typeface = f2187a.mo3615a(context, (C0532c.C0534b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typeface != null) {
                    aVar2.callbackSuccessAsync(typeface, handler);
                } else {
                    aVar2.callbackFailAsync(-3, handler);
                }
            }
        }
        if (typeface != null) {
            f2188b.put(m2295b(resources, i, i2), typeface);
        }
        return typeface;
    }

    /* renamed from: a */
    public static Typeface m2293a(Resources resources, int i, int i2) {
        return f2188b.get(m2295b(resources, i, i2));
    }

    /* renamed from: b */
    private static Typeface m2294b(Context context, Typeface typeface, int i) {
        C0532c.C0534b a = f2187a.mo3676a(typeface);
        if (a == null) {
            return null;
        }
        return f2187a.mo3615a(context, a, context.getResources(), i);
    }

    /* renamed from: b */
    private static String m2295b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
