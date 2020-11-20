package androidx.work;

import androidx.work.C1192e;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class ArrayCreatingInputMerger extends C1195g {
    /* renamed from: a */
    private Object m4662a(Object obj) {
        Object newInstance = Array.newInstance(obj.getClass(), 1);
        Array.set(newInstance, 0, obj);
        return newInstance;
    }

    /* renamed from: a */
    private Object m4663a(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        return newInstance;
    }

    /* renamed from: b */
    private Object m4664b(Object obj, Object obj2) {
        Object newInstance = Array.newInstance(obj.getClass(), 2);
        Array.set(newInstance, 0, obj);
        Array.set(newInstance, 1, obj2);
        return newInstance;
    }

    /* renamed from: c */
    private Object m4665c(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        Object newInstance = Array.newInstance(obj2.getClass(), length + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        Array.set(newInstance, length, obj2);
        return newInstance;
    }

    /* renamed from: a */
    public C1192e mo6327a(List<C1192e> list) {
        C1192e.C1193a aVar = new C1192e.C1193a();
        HashMap hashMap = new HashMap();
        loop0:
        for (C1192e a : list) {
            Iterator<Map.Entry<String, Object>> it = a.mo6408a().entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry next = it.next();
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    Class<?> cls = value.getClass();
                    Object obj = hashMap.get(str);
                    if (obj != null) {
                        Class<?> cls2 = obj.getClass();
                        if (cls2.equals(cls)) {
                            value = cls2.isArray() ? m4663a(obj, value) : m4664b(obj, value);
                        } else if (cls2.isArray() && cls2.getComponentType().equals(cls)) {
                            value = m4665c(obj, value);
                        } else if (cls.isArray() && cls.getComponentType().equals(cls2)) {
                            value = m4665c(value, obj);
                        }
                    } else if (!cls.isArray()) {
                        value = m4662a(value);
                    }
                    hashMap.put(str, value);
                }
            }
            throw new IllegalArgumentException();
        }
        aVar.mo6415a((Map<String, Object>) hashMap);
        return aVar.mo6416a();
    }
}
