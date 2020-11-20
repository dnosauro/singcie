package com.cyberneid.p089b.p091b;

import com.cyberneid.p089b.C1470a;
import com.cyberneid.p089b.p096g.C1582c;
import com.parse.ParseQuery;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.cyberneid.b.b.n */
public class C1515n extends C1489h implements C1470a {

    /* renamed from: f */
    private final Map<String, Object> f4500f = new LinkedHashMap();

    /* renamed from: g */
    private C1485d f4501g;

    /* renamed from: h */
    private final Map<Integer, C1528w> f4502h = new ConcurrentHashMap();

    /* renamed from: i */
    private final C1517a f4503i = new C1517a();

    /* renamed from: com.cyberneid.b.b.n$a */
    private class C1517a implements C1582c {
        private C1517a() {
        }

        /* renamed from: a */
        public C1525u mo7048a(String str) {
            return C1515n.this.mo7105c(str);
        }
    }

    /* renamed from: a */
    private C1528w m5793a(int i, String str) {
        C1528w wVar = this.f4502h.get(Integer.valueOf(i));
        if (wVar != null) {
            return wVar;
        }
        byte[] bArr = null;
        if (i < this.f4445d.size()) {
            bArr = (byte[]) this.f4445d.get(i);
        }
        if (bArr == null) {
            bArr = (byte[]) this.f4445d.get(0);
        }
        String str2 = str;
        int i2 = i;
        C1528w wVar2 = new C1528w(this.f4503i, this.f4442a, str2, i2, new C1530x(this.f4442a, str).mo7139a(bArr, this.f4446e, m5794f()), m5796g(), m5797i());
        this.f4502h.put(Integer.valueOf(i), wVar2);
        return wVar2;
    }

    /* renamed from: f */
    private C1524t m5794f() {
        return (C1524t) this.f4500f.get("Subrs");
    }

    /* renamed from: f */
    private Object m5795f(String str) {
        Object obj = this.f4443b.get(str);
        if (obj != null) {
            return obj;
        }
        Object obj2 = this.f4500f.get(str);
        if (obj2 != null) {
            return obj2;
        }
        return null;
    }

    /* renamed from: g */
    private int m5796g() {
        Number number = (Number) m5795f("defaultWidthX");
        return number == null ? ParseQuery.MAX_LIMIT : number.intValue();
    }

    /* renamed from: i */
    private int m5797i() {
        Number number = (Number) m5795f("nominalWidthX");
        if (number == null) {
            return 0;
        }
        return number.intValue();
    }

    /* renamed from: a */
    public C1528w mo7102a(int i) {
        return m5793a(i, "GID+" + i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7103a(C1485d dVar) {
        this.f4501g = dVar;
    }

    /* renamed from: a_ */
    public float mo7032a_(String str) {
        return (float) mo7105c(str).mo7135a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo7104b(String str, Object obj) {
        if (obj != null) {
            this.f4500f.put(str, obj);
        }
    }

    /* renamed from: b */
    public boolean mo7034b(String str) {
        return this.f4444c.mo7053b(this.f4444c.mo7050a(str)) != 0;
    }

    /* renamed from: c */
    public C1525u mo7105c(String str) {
        return m5793a(mo7106d(str), str);
    }

    /* renamed from: d */
    public int mo7106d(String str) {
        return this.f4444c.mo7053b(this.f4444c.mo7050a(str));
    }

    /* renamed from: d */
    public List<Number> mo7036d() {
        return (List) this.f4443b.get("FontMatrix");
    }

    /* renamed from: e */
    public C1485d mo6952a() {
        return this.f4501g;
    }
}
