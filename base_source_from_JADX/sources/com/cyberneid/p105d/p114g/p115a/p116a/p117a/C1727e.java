package com.cyberneid.p105d.p114g.p115a.p116a.p117a;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* renamed from: com.cyberneid.d.g.a.a.a.e */
public class C1727e {

    /* renamed from: a */
    private final List<Object> f5651a = new ArrayList();

    /* renamed from: a */
    public void mo7902a(float f) {
        this.f5651a.add(Float.valueOf(f));
    }

    /* renamed from: a */
    public void mo7903a(int i) {
        this.f5651a.add(Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo7904a(C1726d dVar) {
        Stack<Object> a = dVar.mo7897a();
        for (Object next : this.f5651a) {
            if (next instanceof String) {
                String str = (String) next;
                C1729g a2 = dVar.mo7898b().mo7909a(str);
                if (a2 != null) {
                    a2.mo7894a(dVar);
                } else {
                    throw new UnsupportedOperationException("Unknown operator or name: " + str);
                }
            } else {
                a.push(next);
            }
        }
        while (!a.isEmpty() && (a.peek() instanceof C1727e)) {
            ((C1727e) a.pop()).mo7904a(dVar);
        }
    }

    /* renamed from: a */
    public void mo7905a(C1727e eVar) {
        this.f5651a.add(eVar);
    }

    /* renamed from: a */
    public void mo7906a(String str) {
        this.f5651a.add(str);
    }
}
