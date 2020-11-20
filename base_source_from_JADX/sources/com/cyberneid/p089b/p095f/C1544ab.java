package com.cyberneid.p089b.p095f;

import com.cyberneid.p089b.C1479b;
import com.cyberneid.p089b.p097h.C1586a;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.parse.ParseException;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.cyberneid.b.f.ab */
public class C1544ab implements C1479b, Closeable {

    /* renamed from: a */
    protected Map<String, C1578z> f4572a = new HashMap();

    /* renamed from: b */
    private float f4573b;

    /* renamed from: c */
    private int f4574c = -1;

    /* renamed from: d */
    private int f4575d = -1;

    /* renamed from: e */
    private final C1575w f4576e;

    /* renamed from: f */
    private Map<String, Integer> f4577f;

    C1544ab(C1575w wVar) {
        this.f4576e = wVar;
    }

    /* renamed from: a */
    private synchronized void mo7337a() {
        String[] i;
        if (this.f4577f == null) {
            this.f4577f = new HashMap();
            if (!(mo7190k() == null || (i = mo7190k().mo7349i()) == null)) {
                for (int i2 = 0; i2 < i.length; i2++) {
                    this.f4577f.put(i[i2], Integer.valueOf(i2));
                }
            }
        }
    }

    /* renamed from: d */
    private int m5932d(String str) {
        if (str.startsWith("uni") && str.length() == 7) {
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            int i = 3;
            while (true) {
                int i2 = i + 4;
                if (i2 > length) {
                    break;
                }
                try {
                    int parseInt = Integer.parseInt(str.substring(i, i2), 16);
                    if (parseInt <= 55295 || parseInt >= 57344) {
                        sb.append((char) parseInt);
                    }
                    i = i2;
                } catch (NumberFormatException unused) {
                }
            }
            String sb2 = sb.toString();
            if (sb2.length() == 0) {
                return -1;
            }
            return sb2.codePointAt(0);
        }
        return -1;
    }

    /* renamed from: a */
    public int mo7178a(int i) {
        C1557h p = mo7195p();
        return p != null ? p.mo7255a(i) : ParseException.LINKED_ID_MISSING;
    }

    /* renamed from: a */
    public C1549b mo7179a(boolean z) {
        C1552c r = mo7197r();
        if (r != null) {
            C1549b a = r.mo7220a(0, 4);
            if (a == null) {
                a = r.mo7220a(3, 10);
            }
            if (a == null) {
                a = r.mo7220a(0, 3);
            }
            if (a == null) {
                a = r.mo7220a(3, 1);
            }
            if (a == null) {
                a = r.mo7220a(3, 0);
            }
            if (a != null) {
                return a;
            }
            if (!z) {
                return r.mo7221a().length > 0 ? r.mo7221a()[0] : a;
            }
            throw new IOException("The TrueType font does not contain a Unicode cmap");
        } else if (!z) {
            return null;
        } else {
            throw new IOException("The TrueType font " + mo7033b() + " does not contain a 'cmap' table");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7180a(float f) {
        this.f4573b = f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7181a(C1578z zVar) {
        this.f4572a.put(zVar.mo7369E(), zVar);
    }

    /* renamed from: a_ */
    public float mo7032a_(String str) {
        return (float) mo7178a(Integer.valueOf(mo7183c(str)).intValue());
    }

    /* renamed from: b */
    public String mo7033b() {
        if (mo7189j() != null) {
            return mo7189j().mo7299d();
        }
        return null;
    }

    /* renamed from: b */
    public boolean mo7034b(String str) {
        return mo7183c(str) != 0;
    }

    /* renamed from: b */
    public synchronized byte[] mo7182b(C1578z zVar) {
        byte[] d;
        long f = this.f4576e.mo7283f();
        this.f4576e.mo7277a(zVar.mo7368D());
        d = this.f4576e.mo7354d((int) zVar.mo7367C());
        this.f4576e.mo7277a(f);
        return d;
    }

    /* renamed from: c */
    public int mo7183c(String str) {
        mo7337a();
        Integer num = this.f4577f.get(str);
        if (num != null && num.intValue() > 0 && num.intValue() < mo7192m().mo7274n()) {
            return num.intValue();
        }
        int d = m5932d(str);
        if (d > -1) {
            return mo7179a(false).mo7206a(d);
        }
        return 0;
    }

    /* renamed from: c */
    public C1586a mo7035c() {
        short n = mo7193n().mo7235n();
        short m = mo7193n().mo7234m();
        short p = mo7193n().mo7237p();
        short o = mo7193n().mo7236o();
        float v = 1000.0f / ((float) mo7202v());
        return new C1586a(((float) n) * v, ((float) p) * v, ((float) m) * v, ((float) o) * v);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo7184c(C1578z zVar) {
        long f = this.f4576e.mo7283f();
        this.f4576e.mo7277a(zVar.mo7368D());
        zVar.mo7175a(this, this.f4576e);
        this.f4576e.mo7277a(f);
    }

    public void close() {
        this.f4576e.close();
    }

    /* renamed from: d */
    public List<Number> mo7036d() {
        float v = (1000.0f / ((float) mo7202v())) * 0.001f;
        return Arrays.asList(new Number[]{Float.valueOf(v), 0, 0, Float.valueOf(v), 0, 0});
    }

    /* renamed from: e */
    public synchronized C1554e mo7186e() {
        C1554e eVar;
        eVar = (C1554e) this.f4572a.get("glyf");
        if (eVar != null && !eVar.mo7370F()) {
            mo7184c((C1578z) eVar);
        }
        return eVar;
    }

    /* renamed from: h */
    public Collection<C1578z> mo7187h() {
        return this.f4572a.values();
    }

    /* renamed from: i */
    public Map<String, C1578z> mo7188i() {
        return this.f4572a;
    }

    /* renamed from: j */
    public synchronized C1567o mo7189j() {
        C1567o oVar;
        oVar = (C1567o) this.f4572a.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (oVar != null && !oVar.mo7370F()) {
            mo7184c((C1578z) oVar);
        }
        return oVar;
    }

    /* renamed from: k */
    public synchronized C1572t mo7190k() {
        C1572t tVar;
        tVar = (C1572t) this.f4572a.get("post");
        if (tVar != null && !tVar.mo7370F()) {
            mo7184c((C1578z) tVar);
        }
        return tVar;
    }

    /* renamed from: l */
    public synchronized C1568p mo7191l() {
        C1568p pVar;
        pVar = (C1568p) this.f4572a.get("OS/2");
        if (pVar != null && !pVar.mo7370F()) {
            mo7184c((C1578z) pVar);
        }
        return pVar;
    }

    /* renamed from: m */
    public synchronized C1564l mo7192m() {
        C1564l lVar;
        lVar = (C1564l) this.f4572a.get("maxp");
        if (lVar != null && !lVar.mo7370F()) {
            mo7184c((C1578z) lVar);
        }
        return lVar;
    }

    /* renamed from: n */
    public synchronized C1555f mo7193n() {
        C1555f fVar;
        fVar = (C1555f) this.f4572a.get("head");
        if (fVar != null && !fVar.mo7370F()) {
            mo7184c((C1578z) fVar);
        }
        return fVar;
    }

    /* renamed from: o */
    public synchronized C1556g mo7194o() {
        C1556g gVar;
        gVar = (C1556g) this.f4572a.get("hhea");
        if (gVar != null && !gVar.mo7370F()) {
            mo7184c((C1578z) gVar);
        }
        return gVar;
    }

    /* renamed from: p */
    public synchronized C1557h mo7195p() {
        C1557h hVar;
        hVar = (C1557h) this.f4572a.get("hmtx");
        if (hVar != null && !hVar.mo7370F()) {
            mo7184c((C1578z) hVar);
        }
        return hVar;
    }

    /* renamed from: q */
    public synchronized C1558i mo7196q() {
        C1558i iVar;
        iVar = (C1558i) this.f4572a.get("loca");
        if (iVar != null && !iVar.mo7370F()) {
            mo7184c((C1578z) iVar);
        }
        return iVar;
    }

    /* renamed from: r */
    public synchronized C1552c mo7197r() {
        C1552c cVar;
        cVar = (C1552c) this.f4572a.get("cmap");
        if (cVar != null && !cVar.mo7370F()) {
            mo7184c((C1578z) cVar);
        }
        return cVar;
    }

    /* renamed from: s */
    public synchronized C1545ac mo7198s() {
        C1545ac acVar;
        acVar = (C1545ac) this.f4572a.get("vhea");
        if (acVar != null && !acVar.mo7370F()) {
            mo7184c((C1578z) acVar);
        }
        return acVar;
    }

    /* renamed from: t */
    public InputStream mo7199t() {
        return this.f4576e.mo7284g();
    }

    public String toString() {
        try {
            return mo7189j() != null ? mo7189j().mo7299d() : "(null)";
        } catch (IOException e) {
            return "(null - " + e.getMessage() + ")";
        }
    }

    /* renamed from: u */
    public int mo7201u() {
        if (this.f4574c == -1) {
            C1564l m = mo7192m();
            this.f4574c = m != null ? m.mo7274n() : 0;
        }
        return this.f4574c;
    }

    /* renamed from: v */
    public int mo7202v() {
        if (this.f4575d == -1) {
            C1555f n = mo7193n();
            this.f4575d = n != null ? n.mo7232k() : 0;
        }
        return this.f4575d;
    }

    /* renamed from: w */
    public C1549b mo7203w() {
        return mo7179a(true);
    }
}
