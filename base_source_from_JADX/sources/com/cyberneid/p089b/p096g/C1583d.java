package com.cyberneid.p089b.p096g;

import com.cyberneid.p089b.C1470a;
import com.cyberneid.p089b.C1479b;
import com.cyberneid.p089b.p091b.C1525u;
import com.cyberneid.p089b.p091b.C1527v;
import com.cyberneid.p089b.p093d.C1539b;
import com.cyberneid.p089b.p094e.C1541a;
import com.cyberneid.p089b.p097h.C1586a;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.cyberneid.b.g.d */
public final class C1583d implements C1470a, C1479b, C1582c {

    /* renamed from: A */
    List<Number> f4787A = new ArrayList();

    /* renamed from: B */
    List<Number> f4788B = new ArrayList();

    /* renamed from: C */
    List<Number> f4789C = new ArrayList();

    /* renamed from: D */
    boolean f4790D;

    /* renamed from: E */
    int f4791E;

    /* renamed from: F */
    final List<byte[]> f4792F = new ArrayList();

    /* renamed from: G */
    final Map<String, byte[]> f4793G = new LinkedHashMap();

    /* renamed from: H */
    private final Map<String, C1525u> f4794H = new ConcurrentHashMap();

    /* renamed from: I */
    private final byte[] f4795I;

    /* renamed from: J */
    private final byte[] f4796J;

    /* renamed from: a */
    String f4797a = "";

    /* renamed from: b */
    C1539b f4798b = null;

    /* renamed from: c */
    int f4799c;

    /* renamed from: d */
    int f4800d;

    /* renamed from: e */
    List<Number> f4801e = new ArrayList();

    /* renamed from: f */
    List<Number> f4802f = new ArrayList();

    /* renamed from: g */
    int f4803g;

    /* renamed from: h */
    float f4804h;

    /* renamed from: i */
    String f4805i = "";

    /* renamed from: j */
    String f4806j = "";

    /* renamed from: k */
    String f4807k = "";

    /* renamed from: l */
    String f4808l = "";

    /* renamed from: m */
    String f4809m = "";

    /* renamed from: n */
    String f4810n = "";

    /* renamed from: o */
    float f4811o;

    /* renamed from: p */
    boolean f4812p;

    /* renamed from: q */
    float f4813q;

    /* renamed from: r */
    float f4814r;

    /* renamed from: s */
    List<Number> f4815s = new ArrayList();

    /* renamed from: t */
    List<Number> f4816t = new ArrayList();

    /* renamed from: u */
    List<Number> f4817u = new ArrayList();

    /* renamed from: v */
    List<Number> f4818v = new ArrayList();

    /* renamed from: w */
    float f4819w;

    /* renamed from: x */
    int f4820x;

    /* renamed from: y */
    int f4821y;

    /* renamed from: z */
    List<Number> f4822z = new ArrayList();

    C1583d(byte[] bArr, byte[] bArr2) {
        this.f4795I = bArr;
        this.f4796J = bArr2;
    }

    /* renamed from: a */
    public static C1583d m6226a(InputStream inputStream) {
        C1541a aVar = new C1541a(inputStream);
        return new C1585f().mo7387a(aVar.mo7172a(), aVar.mo7173b());
    }

    /* renamed from: a */
    public static C1583d m6227a(byte[] bArr) {
        C1541a aVar = new C1541a(bArr);
        return new C1585f().mo7387a(aVar.mo7172a(), aVar.mo7173b());
    }

    /* renamed from: a */
    public static C1583d m6228a(byte[] bArr, byte[] bArr2) {
        return new C1585f().mo7387a(bArr, bArr2);
    }

    /* renamed from: a */
    public C1525u mo7048a(String str) {
        C1525u uVar = this.f4794H.get(str);
        if (uVar != null) {
            return uVar;
        }
        byte[] bArr = this.f4793G.get(str);
        if (bArr == null) {
            bArr = this.f4793G.get(".notdef");
        }
        C1525u uVar2 = new C1525u(this, this.f4797a, str, new C1527v(this.f4797a, str).mo7138a(bArr, this.f4792F));
        this.f4794H.put(str, uVar2);
        return uVar2;
    }

    /* renamed from: a */
    public C1539b mo6952a() {
        return this.f4798b;
    }

    /* renamed from: a_ */
    public float mo7032a_(String str) {
        return (float) mo7048a(str).mo7135a();
    }

    /* renamed from: b */
    public String mo7033b() {
        return this.f4797a;
    }

    /* renamed from: b */
    public boolean mo7034b(String str) {
        return this.f4793G.get(str) != null;
    }

    /* renamed from: c */
    public C1586a mo7035c() {
        return new C1586a(this.f4802f);
    }

    /* renamed from: d */
    public List<Number> mo7036d() {
        return Collections.unmodifiableList(this.f4801e);
    }

    /* renamed from: e */
    public String mo7382e() {
        return this.f4809m;
    }

    /* renamed from: f */
    public String mo7383f() {
        return this.f4810n;
    }

    public String toString() {
        return getClass().getName() + "[fontName=" + this.f4797a + ", fullName=" + this.f4808l + ", encoding=" + this.f4798b + ", charStringsDict=" + this.f4793G + "]";
    }
}
