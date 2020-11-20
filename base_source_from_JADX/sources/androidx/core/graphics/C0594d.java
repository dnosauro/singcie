package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.core.content.p025a.C0532c;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.core.graphics.d */
class C0594d extends C0605i {

    /* renamed from: a */
    private static Class<?> f2189a = null;

    /* renamed from: b */
    private static Constructor<?> f2190b = null;

    /* renamed from: c */
    private static Method f2191c = null;

    /* renamed from: d */
    private static Method f2192d = null;

    /* renamed from: e */
    private static boolean f2193e = false;

    C0594d() {
    }

    /* renamed from: a */
    private static Typeface mo3666a(Object obj) {
        mo3667a();
        try {
            Object newInstance = Array.newInstance(f2189a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f2192d.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private File m2297a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    /* renamed from: a */
    private static void mo3667a() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f2193e) {
            f2193e = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e) {
                Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
                method2 = null;
                cls = null;
                method = null;
            }
            f2190b = constructor;
            f2189a = cls;
            f2191c = method;
            f2192d = method2;
        }
    }

    /* renamed from: a */
    private static boolean m2299a(Object obj, String str, int i, boolean z) {
        mo3667a();
        try {
            return ((Boolean) f2191c.invoke(obj, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    private static Object m2300b() {
        mo3667a();
        try {
            return f2190b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004d, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004e, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0052, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0053, code lost:
        r3 = r8;
        r8 = r5;
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0065, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0066, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006a, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x006b, code lost:
        r3 = r7;
        r7 = r5;
        r5 = r3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0065 A[ExcHandler: all (th java.lang.Throwable)] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface mo3614a(android.content.Context r5, android.os.CancellationSignal r6, androidx.core.p027e.C0550b.C0556b[] r7, int r8) {
        /*
            r4 = this;
            int r0 = r7.length
            r1 = 0
            r2 = 1
            if (r0 >= r2) goto L_0x0006
            return r1
        L_0x0006:
            androidx.core.e.b$b r7 = r4.mo3675a((androidx.core.p027e.C0550b.C0556b[]) r7, (int) r8)
            android.content.ContentResolver r8 = r5.getContentResolver()
            android.net.Uri r7 = r7.mo3556a()     // Catch:{ IOException -> 0x007f }
            java.lang.String r0 = "r"
            android.os.ParcelFileDescriptor r6 = r8.openFileDescriptor(r7, r0, r6)     // Catch:{ IOException -> 0x007f }
            if (r6 != 0) goto L_0x0020
            if (r6 == 0) goto L_0x001f
            r6.close()     // Catch:{ IOException -> 0x007f }
        L_0x001f:
            return r1
        L_0x0020:
            java.io.File r7 = r4.m2297a((android.os.ParcelFileDescriptor) r6)     // Catch:{ Throwable -> 0x0068, all -> 0x0065 }
            if (r7 == 0) goto L_0x0037
            boolean r8 = r7.canRead()     // Catch:{ Throwable -> 0x0068, all -> 0x0065 }
            if (r8 != 0) goto L_0x002d
            goto L_0x0037
        L_0x002d:
            android.graphics.Typeface r5 = android.graphics.Typeface.createFromFile(r7)     // Catch:{ Throwable -> 0x0068, all -> 0x0065 }
            if (r6 == 0) goto L_0x0036
            r6.close()     // Catch:{ IOException -> 0x007f }
        L_0x0036:
            return r5
        L_0x0037:
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0068, all -> 0x0065 }
            java.io.FileDescriptor r8 = r6.getFileDescriptor()     // Catch:{ Throwable -> 0x0068, all -> 0x0065 }
            r7.<init>(r8)     // Catch:{ Throwable -> 0x0068, all -> 0x0065 }
            android.graphics.Typeface r5 = super.mo3674a((android.content.Context) r5, (java.io.InputStream) r7)     // Catch:{ Throwable -> 0x0050, all -> 0x004d }
            r7.close()     // Catch:{ Throwable -> 0x0068, all -> 0x0065 }
            if (r6 == 0) goto L_0x004c
            r6.close()     // Catch:{ IOException -> 0x007f }
        L_0x004c:
            return r5
        L_0x004d:
            r5 = move-exception
            r8 = r1
            goto L_0x0056
        L_0x0050:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r8 = move-exception
            r3 = r8
            r8 = r5
            r5 = r3
        L_0x0056:
            if (r8 == 0) goto L_0x0061
            r7.close()     // Catch:{ Throwable -> 0x005c, all -> 0x0065 }
            goto L_0x0064
        L_0x005c:
            r7 = move-exception
            r8.addSuppressed(r7)     // Catch:{ Throwable -> 0x0068, all -> 0x0065 }
            goto L_0x0064
        L_0x0061:
            r7.close()     // Catch:{ Throwable -> 0x0068, all -> 0x0065 }
        L_0x0064:
            throw r5     // Catch:{ Throwable -> 0x0068, all -> 0x0065 }
        L_0x0065:
            r5 = move-exception
            r7 = r1
            goto L_0x006e
        L_0x0068:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x006a }
        L_0x006a:
            r7 = move-exception
            r3 = r7
            r7 = r5
            r5 = r3
        L_0x006e:
            if (r6 == 0) goto L_0x007e
            if (r7 == 0) goto L_0x007b
            r6.close()     // Catch:{ Throwable -> 0x0076 }
            goto L_0x007e
        L_0x0076:
            r6 = move-exception
            r7.addSuppressed(r6)     // Catch:{ IOException -> 0x007f }
            goto L_0x007e
        L_0x007b:
            r6.close()     // Catch:{ IOException -> 0x007f }
        L_0x007e:
            throw r5     // Catch:{ IOException -> 0x007f }
        L_0x007f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.C0594d.mo3614a(android.content.Context, android.os.CancellationSignal, androidx.core.e.b$b[], int):android.graphics.Typeface");
    }

    /* renamed from: a */
    public Typeface mo3615a(Context context, C0532c.C0534b bVar, Resources resources, int i) {
        Object b = m2300b();
        C0532c.C0535c[] a = bVar.mo3526a();
        int length = a.length;
        int i2 = 0;
        while (i2 < length) {
            C0532c.C0535c cVar = a[i2];
            File a2 = C0609j.m2394a(context);
            if (a2 == null) {
                return null;
            }
            try {
                if (!C0609j.m2399a(a2, resources, cVar.mo3532f())) {
                    a2.delete();
                    return null;
                } else if (!m2299a(b, a2.getPath(), cVar.mo3528b(), cVar.mo3529c())) {
                    return null;
                } else {
                    a2.delete();
                    i2++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                a2.delete();
            }
        }
        return mo3666a(b);
    }
}
