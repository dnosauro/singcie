package com.cyberneid.p105d.p114g.p120d;

import com.cyberneid.p089b.C1479b;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.cyberneid.d.g.d.e */
public final class C1807e {

    /* renamed from: a */
    private final Map<C1809g, SoftReference<C1479b>> f5839a = new ConcurrentHashMap();

    /* renamed from: a */
    public C1479b mo8131a(C1809g gVar) {
        SoftReference softReference = this.f5839a.get(gVar);
        if (softReference != null) {
            return (C1479b) softReference.get();
        }
        return null;
    }

    /* renamed from: a */
    public void mo8132a(C1809g gVar, C1479b bVar) {
        this.f5839a.put(gVar, new SoftReference(bVar));
    }
}
