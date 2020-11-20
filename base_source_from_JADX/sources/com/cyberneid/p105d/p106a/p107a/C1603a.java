package com.cyberneid.p105d.p106a.p107a;

import com.cyberneid.p105d.p108b.C1607d;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.cyberneid.d.a.a.a */
public final class C1603a {

    /* renamed from: d */
    private static final ConcurrentMap<String, C1603a> f4858d = new ConcurrentHashMap();

    /* renamed from: a */
    private final String f4859a;

    /* renamed from: b */
    private byte[] f4860b;

    /* renamed from: c */
    private C1607d f4861c;

    private C1603a(String str) {
        this.f4859a = str;
        if (str.startsWith("/")) {
            throw new IllegalArgumentException("Operators are not allowed to start with / '" + str + "'");
        }
    }

    /* renamed from: a */
    public static C1603a m6344a(String str) {
        if (str.equals("ID") || str.equals("BI")) {
            return new C1603a(str);
        }
        C1603a aVar = (C1603a) f4858d.get(str);
        if (aVar != null) {
            return aVar;
        }
        C1603a putIfAbsent = f4858d.putIfAbsent(str, new C1603a(str));
        return putIfAbsent == null ? (C1603a) f4858d.get(str) : putIfAbsent;
    }

    /* renamed from: a */
    public String mo7478a() {
        return this.f4859a;
    }

    /* renamed from: a */
    public void mo7479a(C1607d dVar) {
        this.f4861c = dVar;
    }

    /* renamed from: a */
    public void mo7480a(byte[] bArr) {
        this.f4860b = bArr;
    }

    /* renamed from: b */
    public byte[] mo7481b() {
        return this.f4860b;
    }

    /* renamed from: c */
    public C1607d mo7482c() {
        return this.f4861c;
    }

    public String toString() {
        return "PDFOperator{" + this.f4859a + "}";
    }
}
