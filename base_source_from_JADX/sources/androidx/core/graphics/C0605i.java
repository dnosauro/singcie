package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.p025a.C0532c;
import androidx.core.p027e.C0550b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.core.graphics.i */
class C0605i {

    /* renamed from: a */
    private ConcurrentHashMap<Long, C0532c.C0534b> f2231a = new ConcurrentHashMap<>();

    /* renamed from: androidx.core.graphics.i$a */
    private interface C0608a<T> {
        /* renamed from: a */
        boolean mo3678a(T t);

        /* renamed from: b */
        int mo3679b(T t);
    }

    C0605i() {
    }

    /* renamed from: a */
    private C0532c.C0535c m2374a(C0532c.C0534b bVar, int i) {
        return (C0532c.C0535c) m2375a(bVar.mo3526a(), i, new C0608a<C0532c.C0535c>() {
            /* renamed from: a */
            public int mo3679b(C0532c.C0535c cVar) {
                return cVar.mo3528b();
            }

            /* renamed from: b */
            public boolean mo3678a(C0532c.C0535c cVar) {
                return cVar.mo3529c();
            }
        });
    }

    /* renamed from: a */
    private static <T> T m2375a(T[] tArr, int i, C0608a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(aVar.mo3679b(t2) - i2) * 2) + (aVar.mo3678a(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    /* renamed from: a */
    private void m2376a(Typeface typeface, C0532c.C0534b bVar) {
        long b = m2377b(typeface);
        if (b != 0) {
            this.f2231a.put(Long.valueOf(b), bVar);
        }
    }

    /* renamed from: b */
    private static long m2377b(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException | NoSuchFieldException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0;
        }
    }

    /* renamed from: a */
    public Typeface mo3665a(Context context, Resources resources, int i, String str, int i2) {
        File a = C0609j.m2394a(context);
        if (a == null) {
            return null;
        }
        try {
            if (!C0609j.m2399a(a, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a.getPath());
            a.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a.delete();
        }
    }

    /* renamed from: a */
    public Typeface mo3614a(Context context, CancellationSignal cancellationSignal, C0550b.C0556b[] bVarArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(mo3675a(bVarArr, i).mo3556a());
            try {
                Typeface a = mo3674a(context, inputStream);
                C0609j.m2398a((Closeable) inputStream);
                return a;
            } catch (IOException unused) {
                C0609j.m2398a((Closeable) inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                C0609j.m2398a((Closeable) inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            C0609j.m2398a((Closeable) inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            C0609j.m2398a((Closeable) inputStream2);
            throw th;
        }
    }

    /* renamed from: a */
    public Typeface mo3615a(Context context, C0532c.C0534b bVar, Resources resources, int i) {
        C0532c.C0535c a = m2374a(bVar, i);
        if (a == null) {
            return null;
        }
        Typeface a2 = C0593c.m2289a(context, resources, a.mo3532f(), a.mo3527a(), i);
        m2376a(a2, bVar);
        return a2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Typeface mo3674a(Context context, InputStream inputStream) {
        File a = C0609j.m2394a(context);
        if (a == null) {
            return null;
        }
        try {
            if (!C0609j.m2400a(a, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a.getPath());
            a.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a.delete();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0532c.C0534b mo3676a(Typeface typeface) {
        long b = m2377b(typeface);
        if (b == 0) {
            return null;
        }
        return this.f2231a.get(Long.valueOf(b));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0550b.C0556b mo3675a(C0550b.C0556b[] bVarArr, int i) {
        return (C0550b.C0556b) m2375a(bVarArr, i, new C0608a<C0550b.C0556b>() {
            /* renamed from: a */
            public int mo3679b(C0550b.C0556b bVar) {
                return bVar.mo3558c();
            }

            /* renamed from: b */
            public boolean mo3678a(C0550b.C0556b bVar) {
                return bVar.mo3559d();
            }
        });
    }
}
