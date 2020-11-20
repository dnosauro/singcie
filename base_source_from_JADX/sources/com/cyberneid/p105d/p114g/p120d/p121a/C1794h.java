package com.cyberneid.p105d.p114g.p120d.p121a;

import com.cyberneid.p089b.p090a.C1472b;
import com.cyberneid.p089b.p090a.C1475e;
import com.cyberneid.p089b.p093d.C1539b;
import com.cyberneid.p105d.p108b.C1605b;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.d.a.h */
public class C1794h extends C1789c {
    public C1794h() {
    }

    public C1794h(C1475e eVar) {
        for (C1472b next : eVar.mo7020l()) {
            mo8089a(next.mo6954a(), next.mo6961b());
        }
    }

    /* renamed from: a */
    public static C1794h m7261a(C1539b bVar) {
        Map<Integer, String> b = bVar.mo7171b();
        C1794h hVar = new C1794h();
        for (Map.Entry next : b.entrySet()) {
            hVar.mo8089a(((Integer) next.getKey()).intValue(), (String) next.getValue());
        }
        return hVar;
    }

    /* renamed from: d */
    public C1605b mo7505d() {
        return null;
    }
}
