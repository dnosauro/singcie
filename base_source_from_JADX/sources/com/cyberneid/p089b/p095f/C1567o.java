package com.cyberneid.p089b.p095f;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.spongycastle.i18n.LocalizedMessage;

/* renamed from: com.cyberneid.b.f.o */
public class C1567o extends C1578z {

    /* renamed from: a */
    private final List<C1566n> f4690a = new ArrayList();

    /* renamed from: d */
    private final Map<Integer, Map<Integer, Map<Integer, Map<Integer, String>>>> f4691d = new HashMap();

    /* renamed from: e */
    private String f4692e = null;

    /* renamed from: f */
    private String f4693f = null;

    /* renamed from: g */
    private String f4694g = null;

    C1567o(C1544ab abVar) {
        super(abVar);
    }

    /* renamed from: a */
    private String m6076a(int i) {
        String a = mo7295a(i, 3, 1, 1033);
        if (a != null) {
            return a;
        }
        String a2 = mo7295a(i, 1, 0, 0);
        if (a2 != null) {
            return a2;
        }
        return null;
    }

    /* renamed from: a */
    public String mo7295a(int i, int i2, int i3, int i4) {
        Map map;
        Map map2;
        Map map3 = this.f4691d.get(Integer.valueOf(i));
        if (map3 == null || (map = (Map) map3.get(Integer.valueOf(i2))) == null || (map2 = (Map) map.get(Integer.valueOf(i3))) == null) {
            return null;
        }
        return (String) map2.get(Integer.valueOf(i4));
    }

    /* renamed from: a */
    public List<C1566n> mo7296a() {
        return this.f4690a;
    }

    /* renamed from: a */
    public void mo7175a(C1544ab abVar, C1575w wVar) {
        String a;
        wVar.mo7281d();
        int d = wVar.mo7281d();
        wVar.mo7281d();
        for (int i = 0; i < d; i++) {
            C1566n nVar = new C1566n();
            nVar.mo7286a(abVar, wVar);
            this.f4690a.add(nVar);
        }
        for (int i2 = 0; i2 < d; i2++) {
            C1566n nVar2 = this.f4690a.get(i2);
            if (((long) nVar2.mo7288b()) > mo7367C()) {
                a = null;
            } else {
                wVar.mo7277a(mo7368D() + 6 + ((long) (d * 2 * 6)) + ((long) nVar2.mo7288b()));
                int f = nVar2.mo7292f();
                int e = nVar2.mo7291e();
                String str = LocalizedMessage.DEFAULT_ENCODING;
                if (f == 3 && (e == 1 || e == 0)) {
                    str = "UTF-16";
                } else if (f == 2) {
                    if (e == 0) {
                        str = "US-ASCII";
                    } else if (e == 1) {
                        str = "ISO-10646-1";
                    } else if (e == 2) {
                        str = LocalizedMessage.DEFAULT_ENCODING;
                    }
                }
                a = wVar.mo7351a(nVar2.mo7285a(), str);
            }
            nVar2.mo7287a(a);
        }
        for (C1566n next : this.f4690a) {
            if (!this.f4691d.containsKey(Integer.valueOf(next.mo7290d()))) {
                this.f4691d.put(Integer.valueOf(next.mo7290d()), new HashMap());
            }
            Map map = this.f4691d.get(Integer.valueOf(next.mo7290d()));
            if (!map.containsKey(Integer.valueOf(next.mo7292f()))) {
                map.put(Integer.valueOf(next.mo7292f()), new HashMap());
            }
            Map map2 = (Map) map.get(Integer.valueOf(next.mo7292f()));
            if (!map2.containsKey(Integer.valueOf(next.mo7291e()))) {
                map2.put(Integer.valueOf(next.mo7291e()), new HashMap());
            }
            ((Map) map2.get(Integer.valueOf(next.mo7291e()))).put(Integer.valueOf(next.mo7289c()), next.mo7293g());
        }
        this.f4692e = m6076a(1);
        this.f4693f = m6076a(2);
        this.f4694g = mo7295a(6, 1, 0, 0);
        if (this.f4694g == null) {
            this.f4694g = mo7295a(6, 3, 1, 1033);
        }
        this.f4757b = true;
    }

    /* renamed from: b */
    public String mo7297b() {
        return this.f4692e;
    }

    /* renamed from: c */
    public String mo7298c() {
        return this.f4693f;
    }

    /* renamed from: d */
    public String mo7299d() {
        return this.f4694g;
    }
}
