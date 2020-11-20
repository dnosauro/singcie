package com.cyberneid.p089b.p090a;

import com.cyberneid.p089b.p097h.C1586a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.cyberneid.b.a.e */
public class C1475e {

    /* renamed from: A */
    private boolean f4376A;

    /* renamed from: B */
    private float f4377B;

    /* renamed from: C */
    private float f4378C;

    /* renamed from: D */
    private List<C1472b> f4379D = new ArrayList();

    /* renamed from: E */
    private final Map<String, C1472b> f4380E = new HashMap();

    /* renamed from: F */
    private List<C1478h> f4381F = new ArrayList();

    /* renamed from: G */
    private List<C1473c> f4382G = new ArrayList();

    /* renamed from: H */
    private List<C1476f> f4383H = new ArrayList();

    /* renamed from: I */
    private List<C1476f> f4384I = new ArrayList();

    /* renamed from: J */
    private List<C1476f> f4385J = new ArrayList();

    /* renamed from: a */
    private float f4386a;

    /* renamed from: b */
    private int f4387b = 0;

    /* renamed from: c */
    private String f4388c;

    /* renamed from: d */
    private String f4389d;

    /* renamed from: e */
    private String f4390e;

    /* renamed from: f */
    private String f4391f;

    /* renamed from: g */
    private C1586a f4392g;

    /* renamed from: h */
    private String f4393h;

    /* renamed from: i */
    private String f4394i;

    /* renamed from: j */
    private String f4395j;

    /* renamed from: k */
    private int f4396k;

    /* renamed from: l */
    private int f4397l;

    /* renamed from: m */
    private String f4398m;

    /* renamed from: n */
    private int f4399n;

    /* renamed from: o */
    private boolean f4400o;

    /* renamed from: p */
    private float[] f4401p;

    /* renamed from: q */
    private boolean f4402q;

    /* renamed from: r */
    private float f4403r;

    /* renamed from: s */
    private float f4404s;

    /* renamed from: t */
    private float f4405t;

    /* renamed from: u */
    private float f4406u;

    /* renamed from: v */
    private final List<String> f4407v = new ArrayList();

    /* renamed from: w */
    private float f4408w;

    /* renamed from: x */
    private float f4409x;

    /* renamed from: y */
    private float f4410y;

    /* renamed from: z */
    private float[] f4411z;

    /* renamed from: a */
    public float mo6974a() {
        float f = 0.0f;
        float f2 = 0.0f;
        for (C1472b next : this.f4380E.values()) {
            if (next.mo6964c() > 0.0f) {
                f += next.mo6964c();
                f2 += 1.0f;
            }
        }
        if (f > 0.0f) {
            return f / f2;
        }
        return 0.0f;
    }

    /* renamed from: a */
    public float mo6975a(String str) {
        C1472b bVar = this.f4380E.get(str);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.mo6964c();
    }

    /* renamed from: a */
    public void mo6976a(float f) {
        this.f4386a = f;
    }

    /* renamed from: a */
    public void mo6977a(int i) {
        this.f4396k = i;
    }

    /* renamed from: a */
    public void mo6978a(C1472b bVar) {
        this.f4379D.add(bVar);
        this.f4380E.put(bVar.mo6961b(), bVar);
    }

    /* renamed from: a */
    public void mo6979a(C1473c cVar) {
        this.f4382G.add(cVar);
    }

    /* renamed from: a */
    public void mo6980a(C1476f fVar) {
        this.f4383H.add(fVar);
    }

    /* renamed from: a */
    public void mo6981a(C1478h hVar) {
        this.f4381F.add(hVar);
    }

    /* renamed from: a */
    public void mo6982a(C1586a aVar) {
        this.f4392g = aVar;
    }

    /* renamed from: a */
    public void mo6983a(boolean z) {
        this.f4400o = z;
    }

    /* renamed from: a */
    public void mo6984a(float[] fArr) {
        this.f4401p = fArr;
    }

    /* renamed from: b */
    public String mo6985b() {
        return this.f4388c;
    }

    /* renamed from: b */
    public void mo6986b(float f) {
        this.f4403r = f;
    }

    /* renamed from: b */
    public void mo6987b(int i) {
        this.f4397l = i;
    }

    /* renamed from: b */
    public void mo6988b(C1476f fVar) {
        this.f4384I.add(fVar);
    }

    /* renamed from: b */
    public void mo6989b(String str) {
        this.f4407v.add(str);
    }

    /* renamed from: b */
    public void mo6990b(boolean z) {
        this.f4402q = z;
    }

    /* renamed from: b */
    public void mo6991b(float[] fArr) {
        this.f4411z = fArr;
    }

    /* renamed from: c */
    public String mo6992c() {
        return this.f4390e;
    }

    /* renamed from: c */
    public void mo6993c(float f) {
        this.f4404s = f;
    }

    /* renamed from: c */
    public void mo6994c(int i) {
        this.f4399n = i;
    }

    /* renamed from: c */
    public void mo6995c(C1476f fVar) {
        this.f4385J.add(fVar);
    }

    /* renamed from: c */
    public void mo6996c(String str) {
        this.f4388c = str;
    }

    /* renamed from: c */
    public void mo6997c(boolean z) {
        this.f4376A = z;
    }

    /* renamed from: d */
    public C1586a mo6998d() {
        return this.f4392g;
    }

    /* renamed from: d */
    public void mo6999d(float f) {
        this.f4405t = f;
    }

    /* renamed from: d */
    public void mo7000d(String str) {
        this.f4389d = str;
    }

    /* renamed from: e */
    public String mo7001e() {
        return this.f4395j;
    }

    /* renamed from: e */
    public void mo7002e(float f) {
        this.f4406u = f;
    }

    /* renamed from: e */
    public void mo7003e(String str) {
        this.f4390e = str;
    }

    /* renamed from: f */
    public String mo7004f() {
        return this.f4398m;
    }

    /* renamed from: f */
    public void mo7005f(float f) {
        this.f4408w = f;
    }

    /* renamed from: f */
    public void mo7006f(String str) {
        this.f4391f = str;
    }

    /* renamed from: g */
    public float mo7007g() {
        return this.f4403r;
    }

    /* renamed from: g */
    public void mo7008g(float f) {
        this.f4409x = f;
    }

    /* renamed from: g */
    public void mo7009g(String str) {
        this.f4394i = str;
    }

    /* renamed from: h */
    public float mo7010h() {
        return this.f4404s;
    }

    /* renamed from: h */
    public void mo7011h(float f) {
        this.f4410y = f;
    }

    /* renamed from: h */
    public void mo7012h(String str) {
        this.f4395j = str;
    }

    /* renamed from: i */
    public float mo7013i() {
        return this.f4405t;
    }

    /* renamed from: i */
    public void mo7014i(float f) {
        this.f4377B = f;
    }

    /* renamed from: i */
    public void mo7015i(String str) {
        this.f4398m = str;
    }

    /* renamed from: j */
    public float mo7016j() {
        return this.f4406u;
    }

    /* renamed from: j */
    public void mo7017j(float f) {
        this.f4378C = f;
    }

    /* renamed from: j */
    public void mo7018j(String str) {
        this.f4393h = str;
    }

    /* renamed from: k */
    public float mo7019k() {
        return this.f4410y;
    }

    /* renamed from: l */
    public List<C1472b> mo7020l() {
        return this.f4379D;
    }
}
