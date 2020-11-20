package androidx.fragment.app;

import androidx.fragment.app.C0735d;
import androidx.p018c.C0413g;
import java.lang.reflect.InvocationTargetException;

/* renamed from: androidx.fragment.app.h */
public class C0748h {

    /* renamed from: a */
    private static final C0413g<String, Class<?>> f2541a = new C0413g<>();

    /* renamed from: a */
    static boolean m3009a(ClassLoader classLoader, String str) {
        try {
            return C0735d.class.isAssignableFrom(m3011d(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static Class<? extends C0735d> m3010b(ClassLoader classLoader, String str) {
        try {
            return m3011d(classLoader, str);
        } catch (ClassNotFoundException e) {
            throw new C0735d.C0740b("Unable to instantiate fragment " + str + ": make sure class name exists", e);
        } catch (ClassCastException e2) {
            throw new C0735d.C0740b("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e2);
        }
    }

    /* renamed from: d */
    private static Class<?> m3011d(ClassLoader classLoader, String str) {
        Class<?> cls = f2541a.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        f2541a.put(str, cls2);
        return cls2;
    }

    /* renamed from: c */
    public C0735d mo4354c(ClassLoader classLoader, String str) {
        try {
            return (C0735d) m3010b(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (InstantiationException e) {
            throw new C0735d.C0740b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new C0735d.C0740b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new C0735d.C0740b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new C0735d.C0740b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }
}
