package com.cyberneid.p105d.p114g.p122e.p123a;

import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p115a.C1759b;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.e.a.k */
public final class C1843k {

    /* renamed from: a */
    private final C1607d f5973a;

    public C1843k() {
        this.f5973a = new C1607d();
    }

    public C1843k(C1607d dVar) {
        this.f5973a = dVar;
    }

    /* renamed from: a */
    public Map<String, C1851s> mo8271a() {
        HashMap hashMap = new HashMap();
        C1607d a = this.f5973a.mo7514a(C1613i.f4927aI);
        if (a == null) {
            a = new C1607d();
            this.f5973a.mo7521a(C1613i.f4927aI, (C1605b) a);
        }
        for (C1613i next : a.mo7540c()) {
            hashMap.put(next.mo7596a(), (C1851s) C1838f.m7589a(a.mo7539c(next)));
        }
        return new C1759b(hashMap, a);
    }

    /* renamed from: b */
    public C1844l mo8272b() {
        C1607d a = this.f5973a.mo7514a(C1613i.f5195fL);
        if (a == null) {
            return null;
        }
        return new C1844l(a);
    }

    /* renamed from: c */
    public boolean mo8273c() {
        return "NChannel".equals(this.f5973a.mo7544e(C1613i.f5258gV));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.f5973a.mo7544e(C1613i.f5258gV));
        sb.append('{');
        if (mo8272b() != null) {
            sb.append(mo8272b());
            sb.append(' ');
        }
        try {
            Map<String, C1851s> a = mo8271a();
            sb.append("Colorants{");
            for (Map.Entry next : a.entrySet()) {
                sb.append('\"');
                sb.append((String) next.getKey());
                sb.append("\": ");
                sb.append(next.getValue());
                sb.append(' ');
            }
            sb.append('}');
        } catch (IOException unused) {
            sb.append("ERROR");
        }
        sb.append('}');
        return sb.toString();
    }
}
