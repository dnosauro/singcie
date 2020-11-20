package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.util.Log;
import androidx.core.content.p025a.C0532c;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* renamed from: androidx.core.graphics.f */
public class C0602f extends C0594d {

    /* renamed from: a */
    protected final Class<?> f2224a;

    /* renamed from: b */
    protected final Constructor<?> f2225b;

    /* renamed from: c */
    protected final Method f2226c;

    /* renamed from: d */
    protected final Method f2227d;

    /* renamed from: e */
    protected final Method f2228e;

    /* renamed from: f */
    protected final Method f2229f;

    /* renamed from: g */
    protected final Method f2230g;

    public C0602f() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor<?> constructor;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> a = mo3667a();
            constructor = mo3668a(a);
            method4 = mo3669b(a);
            method3 = mo3670c(a);
            method2 = mo3671d(a);
            method = mo3672e(a);
            Class<?> cls2 = a;
            method5 = mo3673f(a);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            method5 = null;
            constructor = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f2224a = cls;
        this.f2225b = constructor;
        this.f2226c = method4;
        this.f2227d = method3;
        this.f2228e = method2;
        this.f2229f = method;
        this.f2230g = method5;
    }

    /* renamed from: a */
    private boolean m2350a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f2226c.invoke(obj, new Object[]{context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m2351a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.f2227d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: b */
    private boolean m2352b() {
        if (this.f2226c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f2226c != null;
    }

    /* renamed from: b */
    private boolean m2353b(Object obj) {
        try {
            return ((Boolean) this.f2228e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: c */
    private Object m2354c() {
        try {
            return this.f2225b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    /* renamed from: c */
    private void m2355c(Object obj) {
        try {
            this.f2229f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    /* renamed from: a */
    public Typeface mo3665a(Context context, Resources resources, int i, String str, int i2) {
        if (!m2352b()) {
            return super.mo3665a(context, resources, i, str, i2);
        }
        Object c = m2354c();
        if (c == null) {
            return null;
        }
        if (!m2350a(context, c, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            m2355c(c);
            return null;
        } else if (!m2353b(c)) {
            return null;
        } else {
            return mo3666a(c);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        r14 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        r10 = r14;
        r14 = r13;
        r13 = r10;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface mo3614a(android.content.Context r12, android.os.CancellationSignal r13, androidx.core.p027e.C0550b.C0556b[] r14, int r15) {
        /*
            r11 = this;
            int r0 = r14.length
            r1 = 1
            r2 = 0
            if (r0 >= r1) goto L_0x0006
            return r2
        L_0x0006:
            boolean r0 = r11.m2352b()
            if (r0 != 0) goto L_0x0064
            androidx.core.e.b$b r14 = r11.mo3675a((androidx.core.p027e.C0550b.C0556b[]) r14, (int) r15)
            android.content.ContentResolver r12 = r12.getContentResolver()
            android.net.Uri r15 = r14.mo3556a()     // Catch:{ IOException -> 0x0063 }
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r12 = r12.openFileDescriptor(r15, r0, r13)     // Catch:{ IOException -> 0x0063 }
            if (r12 != 0) goto L_0x0026
            if (r12 == 0) goto L_0x0025
            r12.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0025:
            return r2
        L_0x0026:
            android.graphics.Typeface$Builder r13 = new android.graphics.Typeface$Builder     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            java.io.FileDescriptor r15 = r12.getFileDescriptor()     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            r13.<init>(r15)     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            int r15 = r14.mo3558c()     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            android.graphics.Typeface$Builder r13 = r13.setWeight(r15)     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            boolean r14 = r14.mo3559d()     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            android.graphics.Typeface$Builder r13 = r13.setItalic(r14)     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            android.graphics.Typeface r13 = r13.build()     // Catch:{ Throwable -> 0x004c, all -> 0x0049 }
            if (r12 == 0) goto L_0x0048
            r12.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0048:
            return r13
        L_0x0049:
            r13 = move-exception
            r14 = r2
            goto L_0x0052
        L_0x004c:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x004e }
        L_0x004e:
            r14 = move-exception
            r10 = r14
            r14 = r13
            r13 = r10
        L_0x0052:
            if (r12 == 0) goto L_0x0062
            if (r14 == 0) goto L_0x005f
            r12.close()     // Catch:{ Throwable -> 0x005a }
            goto L_0x0062
        L_0x005a:
            r12 = move-exception
            r14.addSuppressed(r12)     // Catch:{ IOException -> 0x0063 }
            goto L_0x0062
        L_0x005f:
            r12.close()     // Catch:{ IOException -> 0x0063 }
        L_0x0062:
            throw r13     // Catch:{ IOException -> 0x0063 }
        L_0x0063:
            return r2
        L_0x0064:
            java.util.Map r12 = androidx.core.p027e.C0550b.m2183a((android.content.Context) r12, (androidx.core.p027e.C0550b.C0556b[]) r14, (android.os.CancellationSignal) r13)
            java.lang.Object r13 = r11.m2354c()
            if (r13 != 0) goto L_0x006f
            return r2
        L_0x006f:
            int r0 = r14.length
            r3 = 0
            r9 = 0
        L_0x0072:
            if (r9 >= r0) goto L_0x009f
            r4 = r14[r9]
            android.net.Uri r5 = r4.mo3556a()
            java.lang.Object r5 = r12.get(r5)
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            if (r5 != 0) goto L_0x0083
            goto L_0x009c
        L_0x0083:
            int r6 = r4.mo3557b()
            int r7 = r4.mo3558c()
            boolean r8 = r4.mo3559d()
            r3 = r11
            r4 = r13
            boolean r3 = r3.m2351a((java.lang.Object) r4, (java.nio.ByteBuffer) r5, (int) r6, (int) r7, (int) r8)
            if (r3 != 0) goto L_0x009b
            r11.m2355c((java.lang.Object) r13)
            return r2
        L_0x009b:
            r3 = 1
        L_0x009c:
            int r9 = r9 + 1
            goto L_0x0072
        L_0x009f:
            if (r3 != 0) goto L_0x00a5
            r11.m2355c((java.lang.Object) r13)
            return r2
        L_0x00a5:
            boolean r12 = r11.m2353b((java.lang.Object) r13)
            if (r12 != 0) goto L_0x00ac
            return r2
        L_0x00ac:
            android.graphics.Typeface r12 = r11.mo3666a((java.lang.Object) r13)
            if (r12 != 0) goto L_0x00b3
            return r2
        L_0x00b3:
            android.graphics.Typeface r12 = android.graphics.Typeface.create(r12, r15)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.C0602f.mo3614a(android.content.Context, android.os.CancellationSignal, androidx.core.e.b$b[], int):android.graphics.Typeface");
    }

    /* renamed from: a */
    public Typeface mo3615a(Context context, C0532c.C0534b bVar, Resources resources, int i) {
        if (!m2352b()) {
            return super.mo3615a(context, bVar, resources, i);
        }
        Object c = m2354c();
        if (c == null) {
            return null;
        }
        for (C0532c.C0535c cVar : bVar.mo3526a()) {
            if (!m2350a(context, c, cVar.mo3527a(), cVar.mo3531e(), cVar.mo3528b(), cVar.mo3529c() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.mo3530d()))) {
                m2355c(c);
                return null;
            }
        }
        if (!m2353b(c)) {
            return null;
        }
        return mo3666a(c);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Typeface mo3666a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f2224a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f2230g.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Class<?> mo3667a() {
        return Class.forName("android.graphics.FontFamily");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Constructor<?> mo3668a(Class<?> cls) {
        return cls.getConstructor(new Class[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Method mo3669b(Class<?> cls) {
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public Method mo3670c(Class<?> cls) {
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Method mo3671d(Class<?> cls) {
        return cls.getMethod("freeze", new Class[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Method mo3672e(Class<?> cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public Method mo3673f(Class<?> cls) {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
