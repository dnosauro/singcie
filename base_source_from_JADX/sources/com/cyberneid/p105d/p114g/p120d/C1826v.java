package com.cyberneid.p105d.p114g.p120d;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p114g.p120d.p121a.C1788b;
import com.cyberneid.p105d.p114g.p120d.p121a.C1789c;
import com.cyberneid.p105d.p114g.p120d.p121a.C1790d;
import com.cyberneid.p105d.p114g.p120d.p121a.C1792f;
import com.cyberneid.p105d.p114g.p120d.p121a.C1793g;
import com.cyberneid.p105d.p114g.p120d.p121a.C1795i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.cyberneid.d.g.d.v */
public abstract class C1826v extends C1820p {

    /* renamed from: c */
    protected C1789c f5896c;

    /* renamed from: d */
    protected C1790d f5897d;

    /* renamed from: e */
    private Boolean f5898e;

    /* renamed from: f */
    private final Set<Integer> f5899f;

    /* renamed from: g */
    private Map<String, Integer> f5900g;

    C1826v(C1607d dVar) {
        super(dVar);
        this.f5899f = new HashSet();
    }

    C1826v(String str) {
        super(str);
        this.f5899f = new HashSet();
        this.f5896c = C1795i.f5809c;
        this.f5897d = "ZapfDingbats".equals(str) ? C1790d.m7254b() : C1790d.m7252a();
    }

    /* renamed from: a */
    public String mo8159a(int i, C1790d dVar) {
        String str;
        String str2;
        String str3;
        if (this.f5897d != C1790d.m7252a()) {
            dVar = this.f5897d;
        }
        String e = super.mo8165e(i);
        if (e != null) {
            return e;
        }
        C1789c cVar = this.f5896c;
        if (cVar != null) {
            str = cVar.mo8088a(i);
            String a = dVar.mo8093a(str);
            if (a != null) {
                return a;
            }
        } else {
            str = null;
        }
        if (!this.f5899f.contains(Integer.valueOf(i))) {
            this.f5899f.add(Integer.valueOf(i));
            if (str != null) {
                str2 = "PdfBox-Android";
                str3 = "No Unicode mapping for " + str + " (" + i + ") in font " + mo8099f();
            } else {
                str2 = "PdfBox-Android";
                str3 = "No Unicode mapping for character code " + i + " in font " + mo8099f();
            }
            Log.w(str2, str3);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final float mo8161b(int i) {
        if (mo8157a() != null) {
            String a = mo8224o().mo8088a(i);
            if (a.equals(".notdef")) {
                return 250.0f;
            }
            return mo8157a().mo6975a(a);
        }
        throw new IllegalStateException("No AFM");
    }

    /* renamed from: e */
    public String mo8165e(int i) {
        return mo8159a(i, C1790d.m7252a());
    }

    /* renamed from: f */
    public void mo8167f(int i) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: j */
    public boolean mo8170j() {
        if (mo8224o() instanceof C1788b) {
            C1788b bVar = (C1788b) mo8224o();
            if (bVar.mo8087b().size() > 0) {
                C1789c a = bVar.mo8086a();
                for (Map.Entry next : bVar.mo8087b().entrySet()) {
                    if (!((String) next.getValue()).equals(a.mo8088a(((Integer) next.getKey()).intValue()))) {
                        return false;
                    }
                }
            }
        }
        return super.mo8170j();
    }

    /* renamed from: k */
    public void mo8171k() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: l */
    public boolean mo8172l() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0089  */
    /* renamed from: m */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8102m() {
        /*
            r7 = this;
            com.cyberneid.d.b.d r0 = r7.f5884b
            com.cyberneid.d.b.i r1 = com.cyberneid.p105d.p108b.C1613i.f5053cc
            com.cyberneid.d.b.b r0 = r0.mo7539c((com.cyberneid.p105d.p108b.C1613i) r1)
            if (r0 == 0) goto L_0x006e
            boolean r1 = r0 instanceof com.cyberneid.p105d.p108b.C1613i
            if (r1 == 0) goto L_0x0035
            com.cyberneid.d.b.i r0 = (com.cyberneid.p105d.p108b.C1613i) r0
            com.cyberneid.d.g.d.a.c r1 = com.cyberneid.p105d.p114g.p120d.p121a.C1789c.m7247a((com.cyberneid.p105d.p108b.C1613i) r0)
            r7.f5896c = r1
            com.cyberneid.d.g.d.a.c r1 = r7.f5896c
            if (r1 != 0) goto L_0x0074
            java.lang.String r1 = "PdfBox-Android"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Unknown encoding: "
            r2.append(r3)
            java.lang.String r0 = r0.mo7596a()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            android.util.Log.w(r1, r0)
            goto L_0x006e
        L_0x0035:
            boolean r1 = r0 instanceof com.cyberneid.p105d.p108b.C1607d
            if (r1 == 0) goto L_0x0074
            com.cyberneid.d.b.d r0 = (com.cyberneid.p105d.p108b.C1607d) r0
            r1 = 0
            java.lang.Boolean r2 = r7.mo8228t()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x004c
            boolean r5 = r2.booleanValue()
            if (r5 == 0) goto L_0x004c
            r5 = 1
            goto L_0x004d
        L_0x004c:
            r5 = 0
        L_0x004d:
            com.cyberneid.d.b.i r6 = com.cyberneid.p105d.p108b.C1613i.f4899H
            boolean r6 = r0.mo7555l(r6)
            if (r6 != 0) goto L_0x005b
            if (r5 == 0) goto L_0x005b
            com.cyberneid.d.g.d.a.c r1 = r7.mo8103n()
        L_0x005b:
            if (r2 != 0) goto L_0x0061
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r4)
        L_0x0061:
            com.cyberneid.d.g.d.a.b r4 = new com.cyberneid.d.g.d.a.b
            boolean r2 = r2.booleanValue()
            r2 = r2 ^ r3
            r4.<init>(r0, r2, r1)
            r7.f5896c = r4
            goto L_0x0074
        L_0x006e:
            com.cyberneid.d.g.d.a.c r0 = r7.mo8103n()
            r7.f5896c = r0
        L_0x0074:
            java.lang.String r0 = r7.mo8099f()
            java.lang.String r0 = com.cyberneid.p105d.p114g.p120d.C1798ac.m7281c(r0)
            java.lang.String r1 = "ZapfDingbats"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0089
            com.cyberneid.d.g.d.a.d r0 = com.cyberneid.p105d.p114g.p120d.p121a.C1790d.m7254b()
            goto L_0x008d
        L_0x0089:
            com.cyberneid.d.g.d.a.d r0 = com.cyberneid.p105d.p114g.p120d.p121a.C1790d.m7252a()
        L_0x008d:
            r7.f5897d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p120d.C1826v.mo8102m():void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public abstract C1789c mo8103n();

    /* renamed from: o */
    public C1789c mo8224o() {
        return this.f5896c;
    }

    /* renamed from: p */
    public C1790d mo8225p() {
        return this.f5897d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public Map<String, Integer> mo8226q() {
        Map<String, Integer> map = this.f5900g;
        if (map != null) {
            return map;
        }
        this.f5900g = new HashMap();
        for (Map.Entry next : this.f5896c.mo8091c().entrySet()) {
            if (!this.f5900g.containsKey(next.getValue())) {
                this.f5900g.put(next.getValue(), next.getKey());
            }
        }
        return this.f5900g;
    }

    /* renamed from: r */
    public final boolean mo8227r() {
        if (this.f5898e == null) {
            boolean s = mo8104s();
            if (s == null) {
                s = true;
            }
            this.f5898e = s;
        }
        return this.f5898e.booleanValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public Boolean mo8104s() {
        Boolean t = mo8228t();
        if (t != null) {
            return t;
        }
        boolean z = false;
        if (mo8170j()) {
            String c = C1798ac.m7281c(mo8099f());
            if (c.equals("Symbol") || c.equals("ZapfDingbats")) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        C1789c cVar = this.f5896c;
        if (cVar == null) {
            if (this instanceof C1827w) {
                return true;
            }
            throw new IllegalStateException("PDFBox bug: encoding should not be null!");
        } else if ((cVar instanceof C1795i) || (cVar instanceof C1792f) || (cVar instanceof C1793g)) {
            return false;
        } else {
            if (!(cVar instanceof C1788b)) {
                return null;
            }
            for (String next : ((C1788b) cVar).mo8087b().values()) {
                if (!next.equals(".notdef") && (!C1795i.f5809c.mo8090a(next) || !C1792f.f5807d.mo8090a(next) || !C1793g.f5808c.mo8090a(next))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public final Boolean mo8228t() {
        if (mo8163b() != null) {
            return Boolean.valueOf(mo8163b().mo8189c());
        }
        return null;
    }
}
