package com.cyberneid.p105d.p114g.p118b;

import java.lang.reflect.InvocationTargetException;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.jce.provider.BouncyCastleProvider;

/* renamed from: com.cyberneid.d.g.b.n */
public final class C1779n {

    /* renamed from: a */
    public static final C1779n f5768a = new C1779n();

    /* renamed from: b */
    private final Map<String, Class<? extends C1778m>> f5769b = new HashMap();

    /* renamed from: c */
    private final Map<Class<? extends C1772g>, Class<? extends C1778m>> f5770c = new HashMap();

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private C1779n() {
        mo8042a("Standard", (Class<? extends C1778m>) C1782q.class, (Class<? extends C1772g>) C1781p.class);
        mo8042a("Adobe.PubSec", (Class<? extends C1778m>) C1776k.class, (Class<? extends C1772g>) C1774i.class);
    }

    /* renamed from: a */
    private C1778m m7167a(Class<? extends C1778m> cls, Class<?>[] clsArr, Object[] objArr) {
        try {
            return (C1778m) cls.getDeclaredConstructor(clsArr).newInstance(objArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    /* renamed from: a */
    public C1778m mo8041a(String str) {
        Class cls = this.f5769b.get(str);
        if (cls == null) {
            return null;
        }
        return m7167a((Class<? extends C1778m>) cls, (Class<?>[]) new Class[0], new Object[0]);
    }

    /* renamed from: a */
    public void mo8042a(String str, Class<? extends C1778m> cls, Class<? extends C1772g> cls2) {
        if (!this.f5769b.containsKey(str)) {
            this.f5769b.put(str, cls);
            this.f5770c.put(cls2, cls);
            return;
        }
        throw new IllegalStateException("The security handler name is already registered");
    }
}
