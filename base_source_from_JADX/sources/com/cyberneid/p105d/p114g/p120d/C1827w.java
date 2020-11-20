package com.cyberneid.p105d.p114g.p120d;

import com.cyberneid.p089b.p095f.C1544ab;
import com.cyberneid.p089b.p095f.C1549b;
import com.cyberneid.p089b.p095f.C1552c;
import com.cyberneid.p089b.p095f.C1572t;
import com.cyberneid.p089b.p097h.C1586a;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p120d.p121a.C1787a;
import com.cyberneid.p105d.p114g.p120d.p121a.C1789c;
import com.cyberneid.p105d.p114g.p120d.p121a.C1790d;
import com.cyberneid.p105d.p114g.p120d.p121a.C1791e;
import com.cyberneid.p105d.p114g.p120d.p121a.C1793g;
import com.cyberneid.p105d.p114g.p120d.p121a.C1794h;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.d.g.d.w */
public class C1827w extends C1826v {

    /* renamed from: e */
    private static final Map<String, Integer> f5901e = new HashMap();

    /* renamed from: f */
    private C1549b f5902f = null;

    /* renamed from: g */
    private C1549b f5903g = null;

    /* renamed from: h */
    private C1549b f5904h = null;

    /* renamed from: i */
    private boolean f5905i;

    /* renamed from: j */
    private Map<Integer, Integer> f5906j;

    /* renamed from: k */
    private final C1544ab f5907k;

    /* renamed from: l */
    private final boolean f5908l;

    /* renamed from: m */
    private final boolean f5909m;

    static {
        for (Map.Entry next : C1791e.f5806c.mo8091c().entrySet()) {
            if (!f5901e.containsKey(next.getValue())) {
                f5901e.put(next.getValue(), next.getKey());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1827w(com.cyberneid.p105d.p108b.C1607d r7) {
        /*
            r6 = this;
            r6.<init>((com.cyberneid.p105d.p108b.C1607d) r7)
            r7 = 0
            r6.f5902f = r7
            r6.f5903g = r7
            r6.f5904h = r7
            r0 = 0
            r6.f5905i = r0
            com.cyberneid.d.g.d.q r1 = r6.mo8163b()
            r2 = 1
            if (r1 == 0) goto L_0x0052
            com.cyberneid.d.g.d.q r1 = super.mo8163b()
            com.cyberneid.d.g.a.g r1 = r1.mo8209p()
            if (r1 == 0) goto L_0x0052
            com.cyberneid.b.f.x r3 = new com.cyberneid.b.f.x     // Catch:{ NullPointerException -> 0x0035, IOException -> 0x002c }
            r3.<init>(r2)     // Catch:{ NullPointerException -> 0x0035, IOException -> 0x002c }
            com.cyberneid.d.b.g r1 = r1.mo7958c()     // Catch:{ NullPointerException -> 0x0035, IOException -> 0x002c }
            com.cyberneid.b.f.ab r7 = r3.mo7333b((java.io.InputStream) r1)     // Catch:{ NullPointerException -> 0x0035, IOException -> 0x002c }
            goto L_0x0052
        L_0x002c:
            r1 = move-exception
            java.lang.String r3 = "PdfBox-Android"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L_0x003d
        L_0x0035:
            r1 = move-exception
            java.lang.String r3 = "PdfBox-Android"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L_0x003d:
            java.lang.String r5 = "Could not read embedded TTF for font "
            r4.append(r5)
            java.lang.String r5 = r6.mo8230u()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            android.util.Log.w(r3, r4, r1)
            r1 = 1
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            if (r7 == 0) goto L_0x0056
            r0 = 1
        L_0x0056:
            r6.f5908l = r0
            r6.f5909m = r1
            if (r7 != 0) goto L_0x009c
            java.lang.String r7 = r6.mo8230u()
            com.cyberneid.d.g.d.q r0 = r6.mo8163b()
            com.cyberneid.d.g.d.i r7 = com.cyberneid.p105d.p114g.p120d.C1810h.m7347a((java.lang.String) r7, (com.cyberneid.p105d.p114g.p120d.C1821q) r0)
            com.cyberneid.b.b r0 = r7.mo8137c()
            com.cyberneid.b.f.ab r0 = (com.cyberneid.p089b.p095f.C1544ab) r0
            boolean r7 = r7.mo8138d()
            if (r7 == 0) goto L_0x009b
            java.lang.String r7 = "PdfBox-Android"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Using fallback font '"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r2 = "' for '"
            r1.append(r2)
            java.lang.String r2 = r6.mo8230u()
            r1.append(r2)
            java.lang.String r2 = "'"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r7, r1)
        L_0x009b:
            r7 = r0
        L_0x009c:
            r6.f5907k = r7
            r6.mo8102m()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p120d.C1827w.<init>(com.cyberneid.d.b.d):void");
    }

    /* renamed from: w */
    private void m7501w() {
        if (!this.f5905i) {
            C1552c r = this.f5907k.mo7197r();
            if (r != null) {
                for (C1549b bVar : r.mo7221a()) {
                    if (3 == bVar.mo7210b()) {
                        if (1 == bVar.mo7205a()) {
                            this.f5902f = bVar;
                        } else if (bVar.mo7205a() == 0) {
                            this.f5903g = bVar;
                        }
                    } else if (1 == bVar.mo7210b() && bVar.mo7205a() == 0) {
                        this.f5904h = bVar;
                    }
                }
            }
            this.f5905i = true;
        }
    }

    /* renamed from: a */
    public int mo8095a(InputStream inputStream) {
        return inputStream.read();
    }

    /* renamed from: c */
    public float mo8096c(int i) {
        float a = (float) this.f5907k.mo7178a(mo8229g(i));
        float v = (float) this.f5907k.mo7202v();
        return v != 1000.0f ? a * (1000.0f / v) : a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public byte[] mo8097d(int i) {
        if (mo8224o() == null) {
            String a = mo8225p().mo8092a(i);
            if (this.f5907k.mo7034b(a)) {
                Integer num = mo8231v().get(Integer.valueOf(this.f5907k.mo7183c(a)));
                if (num != null) {
                    return new byte[]{(byte) num.intValue()};
                }
                throw new IllegalArgumentException(String.format("U+%04X is not available in this font's Encoding", new Object[]{Integer.valueOf(i)}));
            }
            throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s", new Object[]{Integer.valueOf(i), mo8099f()}));
        } else if (mo8224o().mo8090a(mo8225p().mo8092a(i))) {
            String a2 = mo8225p().mo8092a(i);
            Map<String, Integer> q = mo8226q();
            if (!this.f5907k.mo7034b(a2)) {
                if (!this.f5907k.mo7034b(String.format("uni%04X", new Object[]{Integer.valueOf(i)}))) {
                    throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s", new Object[]{Integer.valueOf(i), mo8099f()}));
                }
            }
            return new byte[]{(byte) q.get(a2).intValue()};
        } else {
            throw new IllegalArgumentException(String.format("U+%04X is not available in this font's Encoding", new Object[]{Integer.valueOf(i)}));
        }
    }

    /* renamed from: e */
    public boolean mo8098e() {
        return this.f5908l;
    }

    /* renamed from: f */
    public String mo8099f() {
        return mo8230u();
    }

    /* renamed from: g */
    public int mo8229g(int i) {
        C1549b bVar;
        Integer num;
        String a;
        m7501w();
        int i2 = 0;
        if (!mo8227r()) {
            String a2 = this.f5896c.mo8088a(i);
            if (a2.equals(".notdef")) {
                return 0;
            }
            if (!(this.f5902f == null || (a = C1790d.m7252a().mo8093a(a2)) == null)) {
                i2 = this.f5902f.mo7206a(a.codePointAt(0));
            }
            if (!(i2 != 0 || this.f5904h == null || (num = f5901e.get(a2)) == null)) {
                i2 = this.f5904h.mo7206a(num.intValue());
            }
            return i2 == 0 ? this.f5907k.mo7183c(a2) : i2;
        }
        C1549b bVar2 = this.f5903g;
        if (bVar2 != null) {
            i2 = bVar2.mo7206a(i);
            if (i >= 0 && i <= 255) {
                if (i2 == 0) {
                    i2 = this.f5903g.mo7206a(61440 + i);
                }
                if (i2 == 0) {
                    i2 = this.f5903g.mo7206a(61696 + i);
                }
                if (i2 == 0) {
                    i2 = this.f5903g.mo7206a(61952 + i);
                }
            }
        }
        return (i2 != 0 || (bVar = this.f5904h) == null) ? i2 : bVar.mo7206a(i);
    }

    /* renamed from: g */
    public C1586a mo8100g() {
        return this.f5907k.mo7035c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public C1789c mo8103n() {
        if (mo8157a() != null) {
            return new C1794h(mo8157a());
        }
        if (mo8228t() != null && !mo8228t().booleanValue()) {
            return C1793g.f5808c;
        }
        String c = C1798ac.m7281c(mo8099f());
        if (mo8170j() && !c.equals("Symbol") && !c.equals("ZapfDingbats")) {
            return C1793g.f5808c;
        }
        C1572t k = this.f5907k.mo7190k();
        HashMap hashMap = new HashMap();
        for (int i = 0; i <= 256; i++) {
            int g = mo8229g(i);
            if (g > 0) {
                String str = null;
                if (k != null) {
                    str = k.mo7341a(g);
                }
                if (str == null) {
                    str = Integer.toString(g);
                }
                hashMap.put(Integer.valueOf(i), str);
            }
        }
        return new C1787a(hashMap);
    }

    /* renamed from: u */
    public final String mo8230u() {
        return this.f5884b.mo7544e(C1613i.f4900I);
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public Map<Integer, Integer> mo8231v() {
        Map<Integer, Integer> map = this.f5906j;
        if (map != null) {
            return map;
        }
        this.f5906j = new HashMap();
        for (int i = 0; i <= 255; i++) {
            int g = mo8229g(i);
            if (!this.f5906j.containsKey(Integer.valueOf(g))) {
                this.f5906j.put(Integer.valueOf(g), Integer.valueOf(i));
            }
        }
        return this.f5906j;
    }
}
