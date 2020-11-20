package androidx.lifecycle;

import androidx.lifecycle.C0947e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.a */
class C0941a {

    /* renamed from: a */
    static C0941a f3074a = new C0941a();

    /* renamed from: b */
    private final Map<Class, C0942a> f3075b = new HashMap();

    /* renamed from: c */
    private final Map<Class, Boolean> f3076c = new HashMap();

    /* renamed from: androidx.lifecycle.a$a */
    static class C0942a {

        /* renamed from: a */
        final Map<C0947e.C0948a, List<C0943b>> f3077a = new HashMap();

        /* renamed from: b */
        final Map<C0943b, C0947e.C0948a> f3078b;

        C0942a(Map<C0943b, C0947e.C0948a> map) {
            this.f3078b = map;
            for (Map.Entry next : map.entrySet()) {
                C0947e.C0948a aVar = (C0947e.C0948a) next.getValue();
                List list = this.f3077a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f3077a.put(aVar, list);
                }
                list.add(next.getKey());
            }
        }

        /* renamed from: a */
        private static void m3704a(List<C0943b> list, C0952h hVar, C0947e.C0948a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).mo5101a(hVar, aVar, obj);
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5100a(C0952h hVar, C0947e.C0948a aVar, Object obj) {
            m3704a(this.f3077a.get(aVar), hVar, aVar, obj);
            m3704a(this.f3077a.get(C0947e.C0948a.ON_ANY), hVar, aVar, obj);
        }
    }

    /* renamed from: androidx.lifecycle.a$b */
    static class C0943b {

        /* renamed from: a */
        final int f3079a;

        /* renamed from: b */
        final Method f3080b;

        C0943b(int i, Method method) {
            this.f3079a = i;
            this.f3080b = method;
            this.f3080b.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo5101a(C0952h hVar, C0947e.C0948a aVar, Object obj) {
            try {
                switch (this.f3079a) {
                    case 0:
                        this.f3080b.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.f3080b.invoke(obj, new Object[]{hVar});
                        return;
                    case 2:
                        this.f3080b.invoke(obj, new Object[]{hVar, aVar});
                        return;
                    default:
                        return;
                }
            } catch (InvocationTargetException e) {
                throw new RuntimeException("Failed to call observer method", e.getCause());
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0943b bVar = (C0943b) obj;
            return this.f3079a == bVar.f3079a && this.f3080b.getName().equals(bVar.f3080b.getName());
        }

        public int hashCode() {
            return (this.f3079a * 31) + this.f3080b.getName().hashCode();
        }
    }

    C0941a() {
    }

    /* renamed from: a */
    private C0942a m3699a(Class cls, Method[] methodArr) {
        int i;
        C0942a b;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (b = mo5099b(superclass)) == null)) {
            hashMap.putAll(b.f3078b);
        }
        for (Class b2 : cls.getInterfaces()) {
            for (Map.Entry next : mo5099b(b2).f3078b.entrySet()) {
                m3700a(hashMap, (C0943b) next.getKey(), (C0947e.C0948a) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m3701c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            C0962p pVar = (C0962p) method.getAnnotation(C0962p.class);
            if (pVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (parameterTypes[0].isAssignableFrom(C0952h.class)) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                C0947e.C0948a a = pVar.mo5125a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(C0947e.C0948a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (a == C0947e.C0948a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    m3700a(hashMap, new C0943b(i, method), a, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0942a aVar = new C0942a(hashMap);
        this.f3075b.put(cls, aVar);
        this.f3076c.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    /* renamed from: a */
    private void m3700a(Map<C0943b, C0947e.C0948a> map, C0943b bVar, C0947e.C0948a aVar, Class cls) {
        C0947e.C0948a aVar2 = map.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f3080b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
        } else if (aVar2 == null) {
            map.put(bVar, aVar);
        }
    }

    /* renamed from: c */
    private Method[] m3701c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5098a(Class cls) {
        Boolean bool = this.f3076c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] c = m3701c(cls);
        for (Method annotation : c) {
            if (((C0962p) annotation.getAnnotation(C0962p.class)) != null) {
                m3699a(cls, c);
                return true;
            }
        }
        this.f3076c.put(cls, false);
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0942a mo5099b(Class cls) {
        C0942a aVar = this.f3075b.get(cls);
        return aVar != null ? aVar : m3699a(cls, (Method[]) null);
    }
}
