package com.cyberneid.p089b.p095f;

/* renamed from: com.cyberneid.b.f.t */
public class C1572t extends C1578z {

    /* renamed from: a */
    private float f4733a;

    /* renamed from: d */
    private float f4734d;

    /* renamed from: e */
    private short f4735e;

    /* renamed from: f */
    private short f4736f;

    /* renamed from: g */
    private long f4737g;

    /* renamed from: h */
    private long f4738h;

    /* renamed from: i */
    private long f4739i;

    /* renamed from: j */
    private long f4740j;

    /* renamed from: k */
    private long f4741k;

    /* renamed from: l */
    private String[] f4742l = null;

    C1572t(C1544ab abVar) {
        super(abVar);
    }

    /* renamed from: a */
    public long mo7340a() {
        return this.f4737g;
    }

    /* renamed from: a */
    public String mo7341a(int i) {
        String[] strArr;
        if (i < 0 || (strArr = this.f4742l) == null || i > strArr.length) {
            return null;
        }
        return strArr[i];
    }

    /* renamed from: a */
    public void mo7175a(C1544ab abVar, C1575w wVar) {
        this.f4733a = wVar.mo7355h();
        this.f4734d = wVar.mo7355h();
        this.f4735e = wVar.mo7282e();
        this.f4736f = wVar.mo7282e();
        this.f4737g = wVar.mo7358k();
        this.f4738h = wVar.mo7358k();
        this.f4739i = wVar.mo7358k();
        this.f4740j = wVar.mo7358k();
        this.f4741k = wVar.mo7358k();
        float f = this.f4733a;
        int i = 0;
        if (f == 1.0f) {
            this.f4742l = new String[258];
            System.arraycopy(C1548af.f4602a, 0, this.f4742l, 0, 258);
        } else if (f == 2.0f) {
            int d = wVar.mo7281d();
            int[] iArr = new int[d];
            this.f4742l = new String[d];
            int i2 = Integer.MIN_VALUE;
            for (int i3 = 0; i3 < d; i3++) {
                int d2 = wVar.mo7281d();
                iArr[i3] = d2;
                if (d2 <= 32767) {
                    i2 = Math.max(i2, d2);
                }
            }
            String[] strArr = null;
            if (i2 >= 258) {
                int i4 = (i2 - 258) + 1;
                strArr = new String[i4];
                for (int i5 = 0; i5 < i4; i5++) {
                    strArr[i5] = wVar.mo7350a(wVar.mo7357j());
                }
            }
            while (i < d) {
                int i6 = iArr[i];
                if (i6 < 258) {
                    this.f4742l[i] = C1548af.f4602a[i6];
                } else if (i6 < 258 || i6 > 32767) {
                    this.f4742l[i] = ".undefined";
                } else {
                    this.f4742l[i] = strArr[i6 - 258];
                }
                i++;
            }
        } else if (f == 2.5f) {
            int[] iArr2 = new int[abVar.mo7201u()];
            int i7 = 0;
            while (i7 < iArr2.length) {
                int i8 = i7 + 1;
                iArr2[i7] = wVar.mo7356i() + i8;
                i7 = i8;
            }
            this.f4742l = new String[iArr2.length];
            while (i < this.f4742l.length) {
                String str = C1548af.f4602a[iArr2[i]];
                if (str != null) {
                    this.f4742l[i] = str;
                }
                i++;
            }
        }
        this.f4757b = true;
    }

    /* renamed from: b */
    public float mo7342b() {
        return this.f4734d;
    }

    /* renamed from: c */
    public long mo7343c() {
        return this.f4741k;
    }

    /* renamed from: d */
    public long mo7344d() {
        return this.f4739i;
    }

    /* renamed from: e */
    public long mo7345e() {
        return this.f4740j;
    }

    /* renamed from: f */
    public long mo7346f() {
        return this.f4738h;
    }

    /* renamed from: g */
    public short mo7347g() {
        return this.f4735e;
    }

    /* renamed from: h */
    public short mo7348h() {
        return this.f4736f;
    }

    /* renamed from: i */
    public String[] mo7349i() {
        return this.f4742l;
    }
}
