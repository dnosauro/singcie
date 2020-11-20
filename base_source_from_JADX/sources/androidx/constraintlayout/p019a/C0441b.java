package androidx.constraintlayout.p019a;

import androidx.constraintlayout.p019a.C0444e;
import androidx.constraintlayout.p019a.C0450h;

/* renamed from: androidx.constraintlayout.a.b */
public class C0441b implements C0444e.C0445a {

    /* renamed from: a */
    C0450h f1622a = null;

    /* renamed from: b */
    float f1623b = 0.0f;

    /* renamed from: c */
    boolean f1624c = false;

    /* renamed from: d */
    public final C0415a f1625d;

    /* renamed from: e */
    boolean f1626e = false;

    public C0441b(C0442c cVar) {
        this.f1625d = new C0415a(this, cVar);
    }

    /* renamed from: a */
    public C0441b mo3151a(float f, float f2, float f3, C0450h hVar, C0450h hVar2, C0450h hVar3, C0450h hVar4) {
        this.f1623b = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.f1625d.mo2989a(hVar, 1.0f);
            this.f1625d.mo2989a(hVar2, -1.0f);
            this.f1625d.mo2989a(hVar4, 1.0f);
            this.f1625d.mo2989a(hVar3, -1.0f);
        } else if (f == 0.0f) {
            this.f1625d.mo2989a(hVar, 1.0f);
            this.f1625d.mo2989a(hVar2, -1.0f);
        } else if (f3 == 0.0f) {
            this.f1625d.mo2989a(hVar3, 1.0f);
            this.f1625d.mo2989a(hVar4, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.f1625d.mo2989a(hVar, 1.0f);
            this.f1625d.mo2989a(hVar2, -1.0f);
            this.f1625d.mo2989a(hVar4, f4);
            this.f1625d.mo2989a(hVar3, -f4);
        }
        return this;
    }

    /* renamed from: a */
    public C0441b mo3152a(C0444e eVar, int i) {
        this.f1625d.mo2989a(eVar.mo3178a(i, "ep"), 1.0f);
        this.f1625d.mo2989a(eVar.mo3178a(i, "em"), -1.0f);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0441b mo3153a(C0450h hVar, int i) {
        this.f1622a = hVar;
        float f = (float) i;
        hVar.f1688d = f;
        this.f1623b = f;
        this.f1626e = true;
        return this;
    }

    /* renamed from: a */
    public C0441b mo3154a(C0450h hVar, C0450h hVar2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1623b = (float) i;
        }
        if (!z) {
            this.f1625d.mo2989a(hVar, -1.0f);
            this.f1625d.mo2989a(hVar2, 1.0f);
        } else {
            this.f1625d.mo2989a(hVar, 1.0f);
            this.f1625d.mo2989a(hVar2, -1.0f);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0441b mo3155a(C0450h hVar, C0450h hVar2, int i, float f, C0450h hVar3, C0450h hVar4, int i2) {
        float f2;
        if (hVar2 == hVar3) {
            this.f1625d.mo2989a(hVar, 1.0f);
            this.f1625d.mo2989a(hVar4, 1.0f);
            this.f1625d.mo2989a(hVar2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.f1625d.mo2989a(hVar, 1.0f);
            this.f1625d.mo2989a(hVar2, -1.0f);
            this.f1625d.mo2989a(hVar3, -1.0f);
            this.f1625d.mo2989a(hVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                f2 = (float) ((-i) + i2);
            }
            return this;
        } else if (f <= 0.0f) {
            this.f1625d.mo2989a(hVar, -1.0f);
            this.f1625d.mo2989a(hVar2, 1.0f);
            f2 = (float) i;
        } else if (f >= 1.0f) {
            this.f1625d.mo2989a(hVar3, -1.0f);
            this.f1625d.mo2989a(hVar4, 1.0f);
            f2 = (float) i2;
        } else {
            float f3 = 1.0f - f;
            this.f1625d.mo2989a(hVar, f3 * 1.0f);
            this.f1625d.mo2989a(hVar2, f3 * -1.0f);
            this.f1625d.mo2989a(hVar3, -1.0f * f);
            this.f1625d.mo2989a(hVar4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                f2 = (((float) (-i)) * f3) + (((float) i2) * f);
            }
            return this;
        }
        this.f1623b = f2;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0441b mo3156a(C0450h hVar, C0450h hVar2, C0450h hVar3, float f) {
        this.f1625d.mo2989a(hVar, -1.0f);
        this.f1625d.mo2989a(hVar2, 1.0f - f);
        this.f1625d.mo2989a(hVar3, f);
        return this;
    }

    /* renamed from: a */
    public C0441b mo3157a(C0450h hVar, C0450h hVar2, C0450h hVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1623b = (float) i;
        }
        if (!z) {
            this.f1625d.mo2989a(hVar, -1.0f);
            this.f1625d.mo2989a(hVar2, 1.0f);
            this.f1625d.mo2989a(hVar3, 1.0f);
        } else {
            this.f1625d.mo2989a(hVar, 1.0f);
            this.f1625d.mo2989a(hVar2, -1.0f);
            this.f1625d.mo2989a(hVar3, -1.0f);
        }
        return this;
    }

    /* renamed from: a */
    public C0441b mo3158a(C0450h hVar, C0450h hVar2, C0450h hVar3, C0450h hVar4, float f) {
        this.f1625d.mo2989a(hVar, -1.0f);
        this.f1625d.mo2989a(hVar2, 1.0f);
        this.f1625d.mo2989a(hVar3, f);
        this.f1625d.mo2989a(hVar4, -f);
        return this;
    }

    /* renamed from: a */
    public C0450h mo3159a(C0444e eVar, boolean[] zArr) {
        return this.f1625d.mo2984a(zArr, (C0450h) null);
    }

    /* renamed from: a */
    public void mo3160a(C0444e.C0445a aVar) {
        if (aVar instanceof C0441b) {
            C0441b bVar = (C0441b) aVar;
            this.f1622a = null;
            this.f1625d.mo2985a();
            for (int i = 0; i < bVar.f1625d.f1410a; i++) {
                this.f1625d.mo2990a(bVar.f1625d.mo2982a(i), bVar.f1625d.mo2992b(i), true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3161a() {
        C0450h hVar = this.f1622a;
        return hVar != null && (hVar.f1690f == C0450h.C0451a.UNRESTRICTED || this.f1623b >= 0.0f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3162a(C0444e eVar) {
        boolean z;
        C0450h a = this.f1625d.mo2983a(eVar);
        if (a == null) {
            z = true;
        } else {
            mo3171c(a);
            z = false;
        }
        if (this.f1625d.f1410a == 0) {
            this.f1626e = true;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3163a(C0450h hVar) {
        return this.f1625d.mo2991a(hVar);
    }

    /* renamed from: b */
    public C0441b mo3164b(C0450h hVar, int i) {
        C0415a aVar;
        float f;
        if (i < 0) {
            this.f1623b = (float) (i * -1);
            aVar = this.f1625d;
            f = 1.0f;
        } else {
            this.f1623b = (float) i;
            aVar = this.f1625d;
            f = -1.0f;
        }
        aVar.mo2989a(hVar, f);
        return this;
    }

    /* renamed from: b */
    public C0441b mo3165b(C0450h hVar, C0450h hVar2, C0450h hVar3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f1623b = (float) i;
        }
        if (!z) {
            this.f1625d.mo2989a(hVar, -1.0f);
            this.f1625d.mo2989a(hVar2, 1.0f);
            this.f1625d.mo2989a(hVar3, -1.0f);
        } else {
            this.f1625d.mo2989a(hVar, 1.0f);
            this.f1625d.mo2989a(hVar2, -1.0f);
            this.f1625d.mo2989a(hVar3, 1.0f);
        }
        return this;
    }

    /* renamed from: b */
    public C0441b mo3166b(C0450h hVar, C0450h hVar2, C0450h hVar3, C0450h hVar4, float f) {
        this.f1625d.mo2989a(hVar3, 0.5f);
        this.f1625d.mo2989a(hVar4, 0.5f);
        this.f1625d.mo2989a(hVar, -0.5f);
        this.f1625d.mo2989a(hVar2, -0.5f);
        this.f1623b = -f;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0450h mo3167b(C0450h hVar) {
        return this.f1625d.mo2984a((boolean[]) null, hVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b7  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo3168b() {
        /*
            r10 = this;
            java.lang.String r0 = ""
            androidx.constraintlayout.a.h r1 = r10.f1622a
            if (r1 != 0) goto L_0x0014
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0"
            r1.append(r0)
            goto L_0x0021
        L_0x0014:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            androidx.constraintlayout.a.h r0 = r10.f1622a
            r1.append(r0)
        L_0x0021:
            java.lang.String r0 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " = "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r1 = r10.f1623b
            r2 = 0
            r3 = 1
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0052
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            float r0 = r10.f1623b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 1
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            androidx.constraintlayout.a.a r5 = r10.f1625d
            int r5 = r5.f1410a
        L_0x0057:
            if (r2 >= r5) goto L_0x00d2
            androidx.constraintlayout.a.a r6 = r10.f1625d
            androidx.constraintlayout.a.h r6 = r6.mo2982a((int) r2)
            if (r6 != 0) goto L_0x0062
            goto L_0x00cf
        L_0x0062:
            androidx.constraintlayout.a.a r7 = r10.f1625d
            float r7 = r7.mo2992b((int) r2)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L_0x006d
            goto L_0x00cf
        L_0x006d:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L_0x0084
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ab
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "- "
            goto L_0x00a2
        L_0x0084:
            if (r8 <= 0) goto L_0x0098
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " + "
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00ab
        L_0x0098:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = " - "
        L_0x00a2:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            float r7 = r7 * r9
        L_0x00ab:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00b7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            goto L_0x00c4
        L_0x00b7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
        L_0x00c4:
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            r1 = 1
        L_0x00cf:
            int r2 = r2 + 1
            goto L_0x0057
        L_0x00d2:
            if (r1 != 0) goto L_0x00e5
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0.0"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x00e5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.p019a.C0441b.mo3168b():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0441b mo3169c(C0450h hVar, int i) {
        this.f1625d.mo2989a(hVar, (float) i);
        return this;
    }

    /* renamed from: c */
    public void mo3170c() {
        this.f1622a = null;
        this.f1625d.mo2985a();
        this.f1623b = 0.0f;
        this.f1626e = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo3171c(C0450h hVar) {
        C0450h hVar2 = this.f1622a;
        if (hVar2 != null) {
            this.f1625d.mo2989a(hVar2, -1.0f);
            this.f1622a = null;
        }
        float a = this.f1625d.mo2981a(hVar, true) * -1.0f;
        this.f1622a = hVar;
        if (a != 1.0f) {
            this.f1623b /= a;
            this.f1625d.mo2986a(a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo3172d() {
        float f = this.f1623b;
        if (f < 0.0f) {
            this.f1623b = f * -1.0f;
            this.f1625d.mo2994b();
        }
    }

    /* renamed from: d */
    public void mo3173d(C0450h hVar) {
        float f = 1.0f;
        if (hVar.f1687c != 1) {
            if (hVar.f1687c == 2) {
                f = 1000.0f;
            } else if (hVar.f1687c == 3) {
                f = 1000000.0f;
            } else if (hVar.f1687c == 4) {
                f = 1.0E9f;
            } else if (hVar.f1687c == 5) {
                f = 1.0E12f;
            }
        }
        this.f1625d.mo2989a(hVar, f);
    }

    /* renamed from: e */
    public boolean mo3174e() {
        return this.f1622a == null && this.f1623b == 0.0f && this.f1625d.f1410a == 0;
    }

    /* renamed from: f */
    public void mo3175f() {
        this.f1625d.mo2985a();
        this.f1622a = null;
        this.f1623b = 0.0f;
    }

    /* renamed from: g */
    public C0450h mo3176g() {
        return this.f1622a;
    }

    public String toString() {
        return mo3168b();
    }
}
