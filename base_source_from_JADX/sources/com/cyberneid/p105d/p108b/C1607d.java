package com.cyberneid.p105d.p108b;

import com.cyberneid.p105d.p114g.p115a.C1760c;
import com.cyberneid.p105d.p131h.C1938b;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.cyberneid.d.b.d */
public class C1607d extends C1605b implements C1623q {

    /* renamed from: a */
    protected Map<C1613i, C1605b> f4869a = new LinkedHashMap();

    /* renamed from: b */
    private boolean f4870b;

    /* renamed from: a */
    public float mo7510a(String str, float f) {
        return mo7528b(C1613i.m6461a(str), f);
    }

    /* renamed from: a */
    public int mo7511a() {
        return this.f4869a.size();
    }

    /* renamed from: a */
    public int mo7512a(C1613i iVar, C1613i iVar2, int i) {
        C1605b a = mo7513a(iVar, iVar2);
        return a instanceof C1615k ? ((C1615k) a).mo7586c() : i;
    }

    /* renamed from: a */
    public C1605b mo7513a(C1613i iVar, C1613i iVar2) {
        C1605b c = mo7539c(iVar);
        return (c != null || iVar2 == null) ? c : mo7539c(iVar2);
    }

    /* renamed from: a */
    public C1607d mo7514a(C1613i iVar) {
        C1605b c = mo7539c(iVar);
        if (c instanceof C1607d) {
            return (C1607d) c;
        }
        return null;
    }

    /* renamed from: a */
    public Object mo7486a(C1624r rVar) {
        return rVar.mo7649a(this);
    }

    /* renamed from: a */
    public String mo7515a(String str) {
        return mo7544e(C1613i.m6461a(str));
    }

    /* renamed from: a */
    public void mo7516a(C1607d dVar) {
        for (Map.Entry next : dVar.mo7546f()) {
            if (!((C1613i) next.getKey()).mo7596a().equals("Size") || !this.f4869a.containsKey(C1613i.m6461a("Size"))) {
                mo7521a((C1613i) next.getKey(), (C1605b) next.getValue());
            }
        }
    }

    /* renamed from: a */
    public void mo7517a(C1613i iVar, float f) {
        mo7521a(iVar, (C1605b) new C1609f(f));
    }

    /* renamed from: a */
    public void mo7518a(C1613i iVar, int i) {
        mo7521a(iVar, (C1605b) C1612h.m6455a((long) i));
    }

    /* renamed from: a */
    public void mo7519a(C1613i iVar, int i, boolean z) {
        int b = mo7529b(iVar, 0);
        mo7518a(iVar, z ? i | b : (~i) & b);
    }

    /* renamed from: a */
    public void mo7520a(C1613i iVar, long j) {
        mo7521a(iVar, (C1605b) C1612h.m6455a(j));
    }

    /* renamed from: a */
    public void mo7521a(C1613i iVar, C1605b bVar) {
        if (bVar == null) {
            mo7553j(iVar);
        } else {
            this.f4869a.put(iVar, bVar);
        }
    }

    /* renamed from: a */
    public void mo7522a(C1613i iVar, C1760c cVar) {
        mo7521a(iVar, cVar != null ? cVar.mo7505d() : null);
    }

    /* renamed from: a */
    public void mo7523a(C1613i iVar, String str) {
        mo7521a(iVar, (C1605b) str != null ? C1613i.m6461a(str) : null);
    }

    /* renamed from: a */
    public void mo7524a(C1613i iVar, Calendar calendar) {
        mo7536b(iVar, C1938b.m7980a(calendar));
    }

    /* renamed from: a */
    public void mo7525a(C1613i iVar, boolean z) {
        mo7521a(iVar, (C1605b) C1606c.m6372b(z));
    }

    /* renamed from: a */
    public boolean mo7526a(C1613i iVar, C1613i iVar2, boolean z) {
        C1605b a = mo7513a(iVar, iVar2);
        return a instanceof C1606c ? ((C1606c) a).mo7508a() : z;
    }

    /* renamed from: a */
    public boolean mo7527a(Object obj) {
        boolean containsValue = this.f4869a.containsValue(obj);
        return (containsValue || !(obj instanceof C1616l)) ? containsValue : this.f4869a.containsValue(((C1616l) obj).mo7604a());
    }

    /* renamed from: b */
    public float mo7528b(C1613i iVar, float f) {
        C1605b c = mo7539c(iVar);
        return c instanceof C1615k ? ((C1615k) c).mo7583a() : f;
    }

    /* renamed from: b */
    public int mo7529b(C1613i iVar, int i) {
        return mo7512a(iVar, (C1613i) null, i);
    }

    /* renamed from: b */
    public int mo7530b(String str) {
        return mo7529b(C1613i.m6461a(str), -1);
    }

    /* renamed from: b */
    public long mo7531b(C1613i iVar, long j) {
        C1605b c = mo7539c(iVar);
        return c instanceof C1615k ? ((C1615k) c).mo7585b() : j;
    }

    /* renamed from: b */
    public C1604a mo7532b(C1613i iVar) {
        C1605b c = mo7539c(iVar);
        if (c instanceof C1604a) {
            return (C1604a) c;
        }
        return null;
    }

    /* renamed from: b */
    public C1613i mo7533b(C1613i iVar, C1613i iVar2) {
        C1605b c = mo7539c(iVar);
        return c instanceof C1613i ? (C1613i) c : iVar2;
    }

    /* renamed from: b */
    public C1613i mo7534b(Object obj) {
        for (Map.Entry next : this.f4869a.entrySet()) {
            Object value = next.getValue();
            if (value.equals(obj) || ((value instanceof C1616l) && ((C1616l) value).mo7604a().equals(obj))) {
                return (C1613i) next.getKey();
            }
        }
        return null;
    }

    /* renamed from: b */
    public void mo7535b() {
        this.f4869a.clear();
    }

    /* renamed from: b */
    public void mo7536b(C1613i iVar, String str) {
        mo7521a(iVar, (C1605b) str != null ? new C1622p(str) : null);
    }

    /* renamed from: b */
    public void mo7537b(boolean z) {
        this.f4870b = z;
    }

    /* renamed from: b */
    public boolean mo7538b(C1613i iVar, boolean z) {
        return mo7526a(iVar, (C1613i) null, z);
    }

    /* renamed from: c */
    public C1605b mo7539c(C1613i iVar) {
        C1605b bVar = this.f4869a.get(iVar);
        if (bVar instanceof C1616l) {
            bVar = ((C1616l) bVar).mo7604a();
        }
        if (bVar instanceof C1614j) {
            return null;
        }
        return bVar;
    }

    /* renamed from: c */
    public Set<C1613i> mo7540c() {
        return this.f4869a.keySet();
    }

    /* renamed from: c */
    public boolean mo7541c(C1613i iVar, int i) {
        return (mo7529b(iVar, 0) & i) == i;
    }

    /* renamed from: c */
    public boolean mo7542c(String str) {
        return mo7555l(C1613i.m6461a(str));
    }

    /* renamed from: d */
    public C1613i mo7543d(C1613i iVar) {
        C1605b c = mo7539c(iVar);
        if (c instanceof C1613i) {
            return (C1613i) c;
        }
        return null;
    }

    /* renamed from: e */
    public String mo7544e(C1613i iVar) {
        C1605b c = mo7539c(iVar);
        if (c instanceof C1613i) {
            return ((C1613i) c).mo7596a();
        }
        if (c instanceof C1622p) {
            return ((C1622p) c).mo7641b();
        }
        return null;
    }

    /* renamed from: f */
    public String mo7545f(C1613i iVar) {
        C1605b c = mo7539c(iVar);
        if (c instanceof C1622p) {
            return ((C1622p) c).mo7641b();
        }
        return null;
    }

    /* renamed from: f */
    public Set<Map.Entry<C1613i, C1605b>> mo7546f() {
        return this.f4869a.entrySet();
    }

    /* renamed from: g */
    public int mo7547g(C1613i iVar) {
        return mo7529b(iVar, -1);
    }

    /* renamed from: g */
    public Collection<C1605b> mo7548g() {
        return this.f4869a.values();
    }

    /* renamed from: h */
    public long mo7549h(C1613i iVar) {
        return mo7531b(iVar, -1);
    }

    /* renamed from: h */
    public boolean mo7550h() {
        return this.f4870b;
    }

    /* renamed from: i */
    public float mo7551i(C1613i iVar) {
        return mo7528b(iVar, -1.0f);
    }

    /* renamed from: i */
    public C1607d mo7552i() {
        return new C1626t(this);
    }

    /* renamed from: j */
    public void mo7553j(C1613i iVar) {
        this.f4869a.remove(iVar);
    }

    /* renamed from: k */
    public C1605b mo7554k(C1613i iVar) {
        return this.f4869a.get(iVar);
    }

    /* renamed from: l */
    public boolean mo7555l(C1613i iVar) {
        return this.f4869a.containsKey(iVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("COSDictionary{");
        for (C1613i next : this.f4869a.keySet()) {
            sb.append("(");
            sb.append(next);
            sb.append(":");
            sb.append(mo7539c(next) != null ? mo7539c(next).toString() : "<null>");
            sb.append(") ");
        }
        sb.append("}");
        return sb.toString();
    }
}
