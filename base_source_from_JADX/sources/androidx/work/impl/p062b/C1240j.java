package androidx.work.impl.p062b;

import androidx.p004a.p005a.p008c.C0051a;
import androidx.work.C1184a;
import androidx.work.C1188c;
import androidx.work.C1192e;
import androidx.work.C1196h;
import androidx.work.C1335n;
import java.util.List;

/* renamed from: androidx.work.impl.b.j */
public class C1240j {

    /* renamed from: q */
    public static final C0051a<List<Object>, List<C1335n>> f3835q = new C0051a<List<Object>, List<C1335n>>() {
    };

    /* renamed from: r */
    private static final String f3836r = C1196h.m4737a("WorkSpec");

    /* renamed from: a */
    public String f3837a;

    /* renamed from: b */
    public C1335n.C1336a f3838b = C1335n.C1336a.ENQUEUED;

    /* renamed from: c */
    public String f3839c;

    /* renamed from: d */
    public String f3840d;

    /* renamed from: e */
    public C1192e f3841e = C1192e.f3752a;

    /* renamed from: f */
    public C1192e f3842f = C1192e.f3752a;

    /* renamed from: g */
    public long f3843g;

    /* renamed from: h */
    public long f3844h;

    /* renamed from: i */
    public long f3845i;

    /* renamed from: j */
    public C1188c f3846j = C1188c.f3732a;

    /* renamed from: k */
    public int f3847k;

    /* renamed from: l */
    public C1184a f3848l = C1184a.EXPONENTIAL;

    /* renamed from: m */
    public long f3849m = 30000;

    /* renamed from: n */
    public long f3850n;

    /* renamed from: o */
    public long f3851o;

    /* renamed from: p */
    public long f3852p = -1;

    /* renamed from: androidx.work.impl.b.j$a */
    public static class C1242a {

        /* renamed from: a */
        public String f3853a;

        /* renamed from: b */
        public C1335n.C1336a f3854b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C1242a aVar = (C1242a) obj;
            if (this.f3854b != aVar.f3854b) {
                return false;
            }
            return this.f3853a.equals(aVar.f3853a);
        }

        public int hashCode() {
            return (this.f3853a.hashCode() * 31) + this.f3854b.hashCode();
        }
    }

    public C1240j(C1240j jVar) {
        this.f3837a = jVar.f3837a;
        this.f3839c = jVar.f3839c;
        this.f3838b = jVar.f3838b;
        this.f3840d = jVar.f3840d;
        this.f3841e = new C1192e(jVar.f3841e);
        this.f3842f = new C1192e(jVar.f3842f);
        this.f3843g = jVar.f3843g;
        this.f3844h = jVar.f3844h;
        this.f3845i = jVar.f3845i;
        this.f3846j = new C1188c(jVar.f3846j);
        this.f3847k = jVar.f3847k;
        this.f3848l = jVar.f3848l;
        this.f3849m = jVar.f3849m;
        this.f3850n = jVar.f3850n;
        this.f3851o = jVar.f3851o;
        this.f3852p = jVar.f3852p;
    }

    public C1240j(String str, String str2) {
        this.f3837a = str;
        this.f3839c = str2;
    }

    /* renamed from: a */
    public boolean mo6498a() {
        return this.f3844h != 0;
    }

    /* renamed from: b */
    public boolean mo6499b() {
        return this.f3838b == C1335n.C1336a.ENQUEUED && this.f3847k > 0;
    }

    /* renamed from: c */
    public long mo6500c() {
        boolean z = false;
        if (mo6499b()) {
            if (this.f3848l == C1184a.LINEAR) {
                z = true;
            }
            return this.f3850n + Math.min(18000000, z ? this.f3849m * ((long) this.f3847k) : (long) Math.scalb((float) this.f3849m, this.f3847k - 1));
        }
        long j = 0;
        if (mo6498a()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.f3850n;
            if (j2 == 0) {
                j2 = this.f3843g + currentTimeMillis;
            }
            if (this.f3845i != this.f3844h) {
                z = true;
            }
            if (z) {
                if (this.f3850n == 0) {
                    j = this.f3845i * -1;
                }
                return j2 + this.f3844h + j;
            }
            if (this.f3850n != 0) {
                j = this.f3844h;
            }
            return j2 + j;
        }
        long j3 = this.f3850n;
        if (j3 == 0) {
            j3 = System.currentTimeMillis();
        }
        return j3 + this.f3843g;
    }

    /* renamed from: d */
    public boolean mo6501d() {
        return !C1188c.f3732a.equals(this.f3846j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1240j jVar = (C1240j) obj;
        if (this.f3843g != jVar.f3843g || this.f3844h != jVar.f3844h || this.f3845i != jVar.f3845i || this.f3847k != jVar.f3847k || this.f3849m != jVar.f3849m || this.f3850n != jVar.f3850n || this.f3851o != jVar.f3851o || this.f3852p != jVar.f3852p || !this.f3837a.equals(jVar.f3837a) || this.f3838b != jVar.f3838b || !this.f3839c.equals(jVar.f3839c)) {
            return false;
        }
        String str = this.f3840d;
        if (str == null ? jVar.f3840d == null : str.equals(jVar.f3840d)) {
            return this.f3841e.equals(jVar.f3841e) && this.f3842f.equals(jVar.f3842f) && this.f3846j.equals(jVar.f3846j) && this.f3848l == jVar.f3848l;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f3837a.hashCode() * 31) + this.f3838b.hashCode()) * 31) + this.f3839c.hashCode()) * 31;
        String str = this.f3840d;
        int hashCode2 = str != null ? str.hashCode() : 0;
        long j = this.f3843g;
        long j2 = this.f3844h;
        long j3 = this.f3845i;
        long j4 = this.f3849m;
        long j5 = this.f3850n;
        long j6 = this.f3851o;
        long j7 = this.f3852p;
        return ((((((((((((((((((((((((hashCode + hashCode2) * 31) + this.f3841e.hashCode()) * 31) + this.f3842f.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.f3846j.hashCode()) * 31) + this.f3847k) * 31) + this.f3848l.hashCode()) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)));
    }

    public String toString() {
        return "{WorkSpec: " + this.f3837a + "}";
    }
}
