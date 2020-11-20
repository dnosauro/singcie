package com.cyberneid.p089b.p091b;

import com.cyberneid.p089b.p096g.C1582c;
import com.parse.ParseQuery;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.cyberneid.b.b.a */
public class C1480a extends C1489h {

    /* renamed from: f */
    private String f4423f;

    /* renamed from: g */
    private String f4424g;

    /* renamed from: h */
    private int f4425h;

    /* renamed from: i */
    private List<Map<String, Object>> f4426i = new LinkedList();

    /* renamed from: j */
    private List<Map<String, Object>> f4427j = new LinkedList();

    /* renamed from: k */
    private C1523s f4428k;

    /* renamed from: l */
    private final Map<Integer, C1518o> f4429l = new ConcurrentHashMap();

    /* renamed from: m */
    private final C1482a f4430m = new C1482a();

    /* renamed from: com.cyberneid.b.b.a$a */
    private class C1482a implements C1582c {
        private C1482a() {
        }

        /* renamed from: a */
        public C1525u mo7048a(String str) {
            return C1480a.this.mo7041b(0);
        }
    }

    /* renamed from: c */
    private int m5637c(int i) {
        int a = this.f4428k.mo7091a(i);
        if (a == -1) {
            return ParseQuery.MAX_LIMIT;
        }
        Map map = this.f4427j.get(a);
        return map.containsKey("defaultWidthX") ? ((Number) map.get("defaultWidthX")).intValue() : ParseQuery.MAX_LIMIT;
    }

    /* renamed from: d */
    private int m5638d(int i) {
        int a = this.f4428k.mo7091a(i);
        if (a == -1) {
            return 0;
        }
        Map map = this.f4427j.get(a);
        if (map.containsKey("nominalWidthX")) {
            return ((Number) map.get("nominalWidthX")).intValue();
        }
        return 0;
    }

    /* renamed from: e */
    private C1524t m5639e(int i) {
        int a = this.f4428k.mo7091a(i);
        return a == -1 ? new C1524t(0) : (C1524t) this.f4427j.get(a).get("Subrs");
    }

    /* renamed from: f */
    private int m5640f(String str) {
        if (str.startsWith("\\")) {
            return Integer.parseInt(str.substring(1));
        }
        throw new IllegalArgumentException("Invalid selector");
    }

    /* renamed from: a */
    public String mo7037a() {
        return this.f4423f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7038a(int i) {
        this.f4425h = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7039a(C1523s sVar) {
        this.f4428k = sVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7040a(List<Map<String, Object>> list) {
        this.f4426i = list;
    }

    /* renamed from: a_ */
    public float mo7032a_(String str) {
        return (float) mo7041b(m5640f(str)).mo7135a();
    }

    /* renamed from: b */
    public C1518o mo7041b(int i) {
        C1518o oVar = this.f4429l.get(Integer.valueOf(i));
        if (oVar != null) {
            return oVar;
        }
        int c = this.f4444c.mo7054c(i);
        byte[] bArr = (byte[]) this.f4445d.get(c);
        if (bArr == null) {
            bArr = (byte[]) this.f4445d.get(0);
        }
        int i2 = i;
        C1518o oVar2 = new C1518o(this.f4430m, this.f4442a, i2, c, new C1530x(this.f4442a, i).mo7139a(bArr, this.f4446e, m5639e(c)), m5637c(i), m5638d(i));
        this.f4429l.put(Integer.valueOf(i), oVar2);
        return oVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo7042b(List<Map<String, Object>> list) {
        this.f4427j = list;
    }

    /* renamed from: b */
    public boolean mo7034b(String str) {
        return m5640f(str) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo7043c(String str) {
        this.f4423f = str;
    }

    /* renamed from: d */
    public List<Number> mo7036d() {
        return (List) this.f4443b.get("FontMatrix");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo7044d(String str) {
        this.f4424g = str;
    }

    /* renamed from: e */
    public String mo7045e() {
        return this.f4424g;
    }

    /* renamed from: f */
    public int mo7046f() {
        return this.f4425h;
    }

    /* renamed from: g */
    public List<Map<String, Object>> mo7047g() {
        return this.f4426i;
    }
}
