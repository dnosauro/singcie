package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.p025a.C0532c;
import androidx.core.p027e.C0550b;
import androidx.p018c.C0413g;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: androidx.core.graphics.e */
class C0601e extends C0605i {

    /* renamed from: a */
    private static final Class<?> f2220a;

    /* renamed from: b */
    private static final Constructor<?> f2221b;

    /* renamed from: c */
    private static final Method f2222c;

    /* renamed from: d */
    private static final Method f2223d;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method2 = null;
            method = null;
        }
        f2221b = constructor;
        f2220a = cls;
        f2222c = method;
        f2223d = method2;
    }

    C0601e() {
    }

    /* renamed from: a */
    private static Typeface m2344a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f2220a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f2223d.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m2345a() {
        if (f2222c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f2222c != null;
    }

    /* renamed from: a */
    private static boolean m2346a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f2222c.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: b */
    private static Object m2347b() {
        try {
            return f2221b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public Typeface mo3614a(Context context, CancellationSignal cancellationSignal, C0550b.C0556b[] bVarArr, int i) {
        Object b = m2347b();
        if (b == null) {
            return null;
        }
        C0413g gVar = new C0413g();
        for (C0550b.C0556b bVar : bVarArr) {
            Uri a = bVar.mo3556a();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(a);
            if (byteBuffer == null) {
                byteBuffer = C0609j.m2396a(context, cancellationSignal, a);
                gVar.put(a, byteBuffer);
            }
            if (byteBuffer == null || !m2346a(b, byteBuffer, bVar.mo3557b(), bVar.mo3558c(), bVar.mo3559d())) {
                return null;
            }
        }
        Typeface a2 = m2344a(b);
        if (a2 == null) {
            return null;
        }
        return Typeface.create(a2, i);
    }

    /* renamed from: a */
    public Typeface mo3615a(Context context, C0532c.C0534b bVar, Resources resources, int i) {
        Object b = m2347b();
        if (b == null) {
            return null;
        }
        for (C0532c.C0535c cVar : bVar.mo3526a()) {
            ByteBuffer a = C0609j.m2395a(context, resources, cVar.mo3532f());
            if (a == null || !m2346a(b, a, cVar.mo3531e(), cVar.mo3528b(), cVar.mo3529c())) {
                return null;
            }
        }
        return m2344a(b);
    }
}
