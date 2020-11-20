package com.cyberneid.p105d.p114g.p120d.p121a;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1615k;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.d.a.b */
public class C1788b extends C1789c {

    /* renamed from: c */
    private final C1607d f5796c;

    /* renamed from: d */
    private final C1789c f5797d;

    /* renamed from: e */
    private final Map<Integer, String> f5798e = new HashMap();

    public C1788b(C1607d dVar) {
        this.f5796c = dVar;
        this.f5797d = null;
        m7243e();
    }

    public C1788b(C1607d dVar, boolean z, C1789c cVar) {
        this.f5796c = dVar;
        C1789c a = this.f5796c.mo7555l(C1613i.f4899H) ? C1789c.m7247a(this.f5796c.mo7543d(C1613i.f4899H)) : null;
        if (a != null) {
            cVar = a;
        } else if (z) {
            cVar = C1793g.f5808c;
        } else if (cVar == null) {
            throw new IllegalArgumentException("Symbolic fonts must have a built-in encoding");
        }
        this.f5797d = cVar;
        this.f5799a.putAll(this.f5797d.f5799a);
        this.f5800b.addAll(this.f5797d.f5800b);
        m7243e();
    }

    /* renamed from: e */
    private void m7243e() {
        C1604a aVar = (C1604a) this.f5796c.mo7539c(C1613i.f5020bw);
        int i = -1;
        int i2 = 0;
        while (aVar != null && i2 < aVar.mo7494b()) {
            C1605b a = aVar.mo7485a(i2);
            if (a instanceof C1615k) {
                i = ((C1615k) a).mo7586c();
            } else if (a instanceof C1613i) {
                C1613i iVar = (C1613i) a;
                mo8089a(i, iVar.mo7596a());
                this.f5798e.put(Integer.valueOf(i), iVar.mo7596a());
                i++;
            }
            i2++;
        }
    }

    /* renamed from: a */
    public C1789c mo8086a() {
        return this.f5797d;
    }

    /* renamed from: b */
    public Map<Integer, String> mo8087b() {
        return this.f5798e;
    }

    /* renamed from: d */
    public C1605b mo7505d() {
        return this.f5796c;
    }
}
