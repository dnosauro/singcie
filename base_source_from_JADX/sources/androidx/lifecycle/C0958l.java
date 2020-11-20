package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.l */
public class C0958l {

    /* renamed from: a */
    private static Map<Class, Integer> f3100a = new HashMap();

    /* renamed from: b */
    private static Map<Class, List<Constructor<? extends C0945c>>> f3101b = new HashMap();

    /* renamed from: a */
    private static C0945c m3739a(Constructor<? extends C0945c> constructor, Object obj) {
        try {
            return (C0945c) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* renamed from: a */
    static C0950f m3740a(Object obj) {
        boolean z = obj instanceof C0950f;
        boolean z2 = obj instanceof C0944b;
        if (z && z2) {
            return new FullLifecycleObserverAdapter((C0944b) obj, (C0950f) obj);
        }
        if (z2) {
            return new FullLifecycleObserverAdapter((C0944b) obj, (C0950f) null);
        }
        if (z) {
            return (C0950f) obj;
        }
        Class<?> cls = obj.getClass();
        if (m3743b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = f3101b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(m3739a((Constructor) list.get(0), obj));
        }
        C0945c[] cVarArr = new C0945c[list.size()];
        for (int i = 0; i < list.size(); i++) {
            cVarArr[i] = m3739a((Constructor) list.get(i), obj);
        }
        return new CompositeGeneratedAdaptersObserver(cVarArr);
    }

    /* renamed from: a */
    public static String m3741a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    /* renamed from: a */
    private static Constructor<? extends C0945c> m3742a(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String a = m3741a(canonicalName);
            if (!name.isEmpty()) {
                a = name + "." + a;
            }
            Constructor<?> declaredConstructor = Class.forName(a).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    private static int m3743b(Class<?> cls) {
        Integer num = f3100a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int c = m3744c(cls);
        f3100a.put(cls, Integer.valueOf(c));
        return c;
    }

    /* renamed from: c */
    private static int m3744c(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends C0945c> a = m3742a(cls);
        if (a != null) {
            f3101b.put(cls, Collections.singletonList(a));
            return 2;
        } else if (C0941a.f3074a.mo5098a(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (m3745d(superclass)) {
                if (m3743b(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f3101b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (m3745d(cls2)) {
                    if (m3743b(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f3101b.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f3101b.put(cls, arrayList);
            return 2;
        }
    }

    /* renamed from: d */
    private static boolean m3745d(Class<?> cls) {
        return cls != null && C0951g.class.isAssignableFrom(cls);
    }
}
