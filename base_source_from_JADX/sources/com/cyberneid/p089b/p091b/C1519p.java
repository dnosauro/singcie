package com.cyberneid.p089b.p091b;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.cyberneid.b.b.p */
public class C1519p {

    /* renamed from: a */
    public static final Map<C1520a, String> f4506a;

    /* renamed from: b */
    public static final Map<C1520a, String> f4507b;

    /* renamed from: c */
    private C1520a f4508c = null;

    /* renamed from: com.cyberneid.b.b.p$a */
    public static class C1520a {

        /* renamed from: a */
        private int[] f4509a = null;

        public C1520a(int i) {
            m5811a(new int[]{i});
        }

        public C1520a(int i, int i2) {
            m5811a(new int[]{i, i2});
        }

        public C1520a(int[] iArr) {
            m5811a(iArr);
        }

        /* renamed from: a */
        private void m5811a(int[] iArr) {
            this.f4509a = iArr;
        }

        /* renamed from: a */
        public int[] mo7112a() {
            return this.f4509a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1520a)) {
                return false;
            }
            C1520a aVar = (C1520a) obj;
            int[] iArr = this.f4509a;
            if (iArr[0] == 12) {
                int[] iArr2 = aVar.f4509a;
                if (iArr2[0] == 12) {
                    return (iArr.length <= 1 || iArr2.length <= 1) ? this.f4509a.length == aVar.f4509a.length : iArr[1] == iArr2[1];
                }
            }
            return this.f4509a[0] == aVar.f4509a[0];
        }

        public int hashCode() {
            int[] iArr = this.f4509a;
            if (iArr[0] != 12 || iArr.length <= 1) {
                return this.f4509a[0];
            }
            return iArr[1] ^ iArr[0];
        }

        public String toString() {
            return Arrays.toString(mo7112a());
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(new C1520a(1), "hstem");
        linkedHashMap.put(new C1520a(3), "vstem");
        linkedHashMap.put(new C1520a(4), "vmoveto");
        linkedHashMap.put(new C1520a(5), "rlineto");
        linkedHashMap.put(new C1520a(6), "hlineto");
        linkedHashMap.put(new C1520a(7), "vlineto");
        linkedHashMap.put(new C1520a(8), "rrcurveto");
        linkedHashMap.put(new C1520a(9), "closepath");
        linkedHashMap.put(new C1520a(10), "callsubr");
        linkedHashMap.put(new C1520a(11), "return");
        linkedHashMap.put(new C1520a(12), "escape");
        linkedHashMap.put(new C1520a(12, 0), "dotsection");
        linkedHashMap.put(new C1520a(12, 1), "vstem3");
        linkedHashMap.put(new C1520a(12, 2), "hstem3");
        linkedHashMap.put(new C1520a(12, 6), "seac");
        linkedHashMap.put(new C1520a(12, 7), "sbw");
        linkedHashMap.put(new C1520a(12, 12), "div");
        linkedHashMap.put(new C1520a(12, 16), "callothersubr");
        linkedHashMap.put(new C1520a(12, 17), "pop");
        linkedHashMap.put(new C1520a(12, 33), "setcurrentpoint");
        linkedHashMap.put(new C1520a(13), "hsbw");
        linkedHashMap.put(new C1520a(14), "endchar");
        linkedHashMap.put(new C1520a(21), "rmoveto");
        linkedHashMap.put(new C1520a(22), "hmoveto");
        linkedHashMap.put(new C1520a(30), "vhcurveto");
        linkedHashMap.put(new C1520a(31), "hvcurveto");
        f4506a = Collections.unmodifiableMap(linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        linkedHashMap2.put(new C1520a(1), "hstem");
        linkedHashMap2.put(new C1520a(3), "vstem");
        linkedHashMap2.put(new C1520a(4), "vmoveto");
        linkedHashMap2.put(new C1520a(5), "rlineto");
        linkedHashMap2.put(new C1520a(6), "hlineto");
        linkedHashMap2.put(new C1520a(7), "vlineto");
        linkedHashMap2.put(new C1520a(8), "rrcurveto");
        linkedHashMap2.put(new C1520a(10), "callsubr");
        linkedHashMap2.put(new C1520a(11), "return");
        linkedHashMap2.put(new C1520a(12), "escape");
        linkedHashMap2.put(new C1520a(12, 3), "and");
        linkedHashMap2.put(new C1520a(12, 4), "or");
        linkedHashMap2.put(new C1520a(12, 5), "not");
        linkedHashMap2.put(new C1520a(12, 9), "abs");
        linkedHashMap2.put(new C1520a(12, 10), "add");
        linkedHashMap2.put(new C1520a(12, 11), "sub");
        linkedHashMap2.put(new C1520a(12, 12), "div");
        linkedHashMap2.put(new C1520a(12, 14), "neg");
        linkedHashMap2.put(new C1520a(12, 15), "eq");
        linkedHashMap2.put(new C1520a(12, 18), "drop");
        linkedHashMap2.put(new C1520a(12, 20), "put");
        linkedHashMap2.put(new C1520a(12, 21), "get");
        linkedHashMap2.put(new C1520a(12, 22), "ifelse");
        linkedHashMap2.put(new C1520a(12, 23), "random");
        linkedHashMap2.put(new C1520a(12, 24), "mul");
        linkedHashMap2.put(new C1520a(12, 26), "sqrt");
        linkedHashMap2.put(new C1520a(12, 27), "dup");
        linkedHashMap2.put(new C1520a(12, 28), "exch");
        linkedHashMap2.put(new C1520a(12, 29), FirebaseAnalytics.Param.INDEX);
        linkedHashMap2.put(new C1520a(12, 30), "roll");
        linkedHashMap2.put(new C1520a(12, 34), "hflex");
        linkedHashMap2.put(new C1520a(12, 35), "flex");
        linkedHashMap2.put(new C1520a(12, 36), "hflex1");
        linkedHashMap2.put(new C1520a(12, 37), "flex1");
        linkedHashMap2.put(new C1520a(14), "endchar");
        linkedHashMap2.put(new C1520a(18), "hstemhm");
        linkedHashMap2.put(new C1520a(19), "hintmask");
        linkedHashMap2.put(new C1520a(20), "cntrmask");
        linkedHashMap2.put(new C1520a(21), "rmoveto");
        linkedHashMap2.put(new C1520a(22), "hmoveto");
        linkedHashMap2.put(new C1520a(23), "vstemhm");
        linkedHashMap2.put(new C1520a(24), "rcurveline");
        linkedHashMap2.put(new C1520a(25), "rlinecurve");
        linkedHashMap2.put(new C1520a(26), "vvcurveto");
        linkedHashMap2.put(new C1520a(27), "hhcurveto");
        linkedHashMap2.put(new C1520a(28), "shortint");
        linkedHashMap2.put(new C1520a(29), "callgsubr");
        linkedHashMap2.put(new C1520a(30), "vhcurveto");
        linkedHashMap2.put(new C1520a(31), "hvcurveto");
        f4507b = Collections.unmodifiableMap(linkedHashMap2);
    }

    public C1519p(int i) {
        m5809a(new C1520a(i));
    }

    public C1519p(int i, int i2) {
        m5809a(new C1520a(i, i2));
    }

    public C1519p(int[] iArr) {
        m5809a(new C1520a(iArr));
    }

    /* renamed from: a */
    private void m5809a(C1520a aVar) {
        this.f4508c = aVar;
    }

    /* renamed from: a */
    public C1520a mo7108a() {
        return this.f4508c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1519p) {
            return mo7108a().equals(((C1519p) obj).mo7108a());
        }
        return false;
    }

    public int hashCode() {
        return mo7108a().hashCode();
    }

    public String toString() {
        String str = f4507b.get(mo7108a());
        if (str == null) {
            str = f4506a.get(mo7108a());
        }
        if (str == null) {
            return mo7108a().toString() + '|';
        }
        return str + '|';
    }
}
