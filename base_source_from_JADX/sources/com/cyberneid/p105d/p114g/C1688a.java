package com.cyberneid.p105d.p114g;

import com.cyberneid.p105d.p108b.C1616l;
import com.cyberneid.p105d.p114g.p120d.C1820p;
import com.cyberneid.p105d.p114g.p122e.C1832a;
import com.cyberneid.p105d.p114g.p122e.p123a.C1838f;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.a */
public class C1688a implements C1932i {

    /* renamed from: a */
    private final Map<C1616l, SoftReference<C1820p>> f5632a = new HashMap();

    /* renamed from: b */
    private final Map<C1616l, SoftReference<C1838f>> f5633b = new HashMap();

    /* renamed from: c */
    private final Map<C1616l, SoftReference<C1832a>> f5634c = new HashMap();

    /* renamed from: d */
    private final Map<C1616l, SoftReference<Object>> f5635d = new HashMap();

    /* renamed from: e */
    private final Map<C1616l, SoftReference<Object>> f5636e = new HashMap();

    /* renamed from: f */
    private final Map<C1616l, SoftReference<Object>> f5637f = new HashMap();

    /* renamed from: g */
    private final Map<C1616l, SoftReference<Object>> f5638g = new HashMap();

    /* renamed from: a */
    public C1820p mo7850a(C1616l lVar) {
        SoftReference softReference = this.f5632a.get(lVar);
        if (softReference != null) {
            return (C1820p) softReference.get();
        }
        return null;
    }

    /* renamed from: a */
    public void mo7851a(C1616l lVar, C1820p pVar) {
        this.f5632a.put(lVar, new SoftReference(pVar));
    }

    /* renamed from: a */
    public void mo7852a(C1616l lVar, C1838f fVar) {
        this.f5633b.put(lVar, new SoftReference(fVar));
    }

    /* renamed from: b */
    public C1838f mo7853b(C1616l lVar) {
        SoftReference softReference = this.f5633b.get(lVar);
        if (softReference != null) {
            return (C1838f) softReference.get();
        }
        return null;
    }
}
