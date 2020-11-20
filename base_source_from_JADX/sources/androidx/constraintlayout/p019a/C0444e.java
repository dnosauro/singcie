package androidx.constraintlayout.p019a;

import androidx.constraintlayout.p019a.C0450h;
import androidx.constraintlayout.p019a.p020a.C0420e;
import androidx.constraintlayout.p019a.p020a.C0425f;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: androidx.constraintlayout.a.e */
public class C0444e {

    /* renamed from: g */
    public static C0446f f1630g = null;

    /* renamed from: h */
    private static int f1631h = 1000;

    /* renamed from: a */
    int f1632a = 0;

    /* renamed from: b */
    C0441b[] f1633b;

    /* renamed from: c */
    public boolean f1634c;

    /* renamed from: d */
    int f1635d;

    /* renamed from: e */
    int f1636e;

    /* renamed from: f */
    final C0442c f1637f;

    /* renamed from: i */
    private HashMap<String, C0450h> f1638i = null;

    /* renamed from: j */
    private C0445a f1639j;

    /* renamed from: k */
    private int f1640k = 32;

    /* renamed from: l */
    private int f1641l;

    /* renamed from: m */
    private boolean[] f1642m;

    /* renamed from: n */
    private int f1643n;

    /* renamed from: o */
    private C0450h[] f1644o;

    /* renamed from: p */
    private int f1645p;

    /* renamed from: q */
    private C0441b[] f1646q;

    /* renamed from: r */
    private final C0445a f1647r;

    /* renamed from: androidx.constraintlayout.a.e$a */
    interface C0445a {
        /* renamed from: a */
        C0450h mo3159a(C0444e eVar, boolean[] zArr);

        /* renamed from: a */
        void mo3160a(C0445a aVar);

        /* renamed from: d */
        void mo3173d(C0450h hVar);

        /* renamed from: f */
        void mo3175f();

        /* renamed from: g */
        C0450h mo3176g();
    }

    public C0444e() {
        int i = this.f1640k;
        this.f1641l = i;
        this.f1633b = null;
        this.f1634c = false;
        this.f1642m = new boolean[i];
        this.f1635d = 1;
        this.f1636e = 0;
        this.f1643n = i;
        this.f1644o = new C0450h[f1631h];
        this.f1645p = 0;
        this.f1646q = new C0441b[i];
        this.f1633b = new C0441b[i];
        m1817i();
        this.f1637f = new C0442c();
        this.f1639j = new C0443d(this.f1637f);
        this.f1647r = new C0441b(this.f1637f);
    }

    /* renamed from: a */
    private final int m1808a(C0445a aVar, boolean z) {
        C0446f fVar = f1630g;
        if (fVar != null) {
            fVar.f1659h++;
        }
        for (int i = 0; i < this.f1635d; i++) {
            this.f1642m[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            C0446f fVar2 = f1630g;
            if (fVar2 != null) {
                fVar2.f1660i++;
            }
            i2++;
            if (i2 >= this.f1635d * 2) {
                return i2;
            }
            if (aVar.mo3176g() != null) {
                this.f1642m[aVar.mo3176g().f1685a] = true;
            }
            C0450h a = aVar.mo3159a(this, this.f1642m);
            if (a != null) {
                if (this.f1642m[a.f1685a]) {
                    return i2;
                }
                this.f1642m[a.f1685a] = true;
            }
            if (a != null) {
                int i3 = -1;
                float f = Float.MAX_VALUE;
                for (int i4 = 0; i4 < this.f1636e; i4++) {
                    C0441b bVar = this.f1633b[i4];
                    if (bVar.f1622a.f1690f != C0450h.C0451a.UNRESTRICTED && !bVar.f1626e && bVar.mo3163a(a)) {
                        float b = bVar.f1625d.mo2993b(a);
                        if (b < 0.0f) {
                            float f2 = (-bVar.f1623b) / b;
                            if (f2 < f) {
                                i3 = i4;
                                f = f2;
                            }
                        }
                    }
                }
                if (i3 > -1) {
                    C0441b bVar2 = this.f1633b[i3];
                    bVar2.f1622a.f1686b = -1;
                    C0446f fVar3 = f1630g;
                    if (fVar3 != null) {
                        fVar3.f1661j++;
                    }
                    bVar2.mo3171c(a);
                    bVar2.f1622a.f1686b = i3;
                    bVar2.f1622a.mo3207c(bVar2);
                }
            }
            z2 = true;
        }
        return i2;
    }

    /* renamed from: a */
    public static C0441b m1809a(C0444e eVar, C0450h hVar, C0450h hVar2, C0450h hVar3, float f, boolean z) {
        C0441b c = eVar.mo3193c();
        if (z) {
            eVar.m1813b(c);
        }
        return c.mo3156a(hVar, hVar2, hVar3, f);
    }

    /* renamed from: a */
    public static C0446f m1810a() {
        return f1630g;
    }

    /* renamed from: a */
    private C0450h m1811a(C0450h.C0451a aVar, String str) {
        C0450h a = this.f1637f.f1628b.mo3200a();
        if (a == null) {
            a = new C0450h(aVar, str);
        } else {
            a.mo3205b();
        }
        a.mo3204a(aVar, str);
        int i = this.f1645p;
        int i2 = f1631h;
        if (i >= i2) {
            f1631h = i2 * 2;
            this.f1644o = (C0450h[]) Arrays.copyOf(this.f1644o, f1631h);
        }
        C0450h[] hVarArr = this.f1644o;
        int i3 = this.f1645p;
        this.f1645p = i3 + 1;
        hVarArr[i3] = a;
        return a;
    }

    /* renamed from: b */
    private int m1812b(C0445a aVar) {
        float f;
        boolean z;
        int i = 0;
        while (true) {
            f = 0.0f;
            if (i >= this.f1636e) {
                z = false;
                break;
            } else if (this.f1633b[i].f1622a.f1690f != C0450h.C0451a.UNRESTRICTED && this.f1633b[i].f1623b < 0.0f) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            C0446f fVar = f1630g;
            if (fVar != null) {
                fVar.f1662k++;
            }
            i2++;
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            float f2 = Float.MAX_VALUE;
            int i6 = 0;
            while (i3 < this.f1636e) {
                C0441b bVar = this.f1633b[i3];
                if (bVar.f1622a.f1690f != C0450h.C0451a.UNRESTRICTED && !bVar.f1626e && bVar.f1623b < f) {
                    int i7 = 1;
                    while (i7 < this.f1635d) {
                        C0450h hVar = this.f1637f.f1629c[i7];
                        float b = bVar.f1625d.mo2993b(hVar);
                        if (b > f) {
                            int i8 = i6;
                            float f3 = f2;
                            int i9 = i5;
                            int i10 = i4;
                            for (int i11 = 0; i11 < 7; i11++) {
                                float f4 = hVar.f1689e[i11] / b;
                                if ((f4 < f3 && i11 == i8) || i11 > i8) {
                                    i9 = i7;
                                    i10 = i3;
                                    f3 = f4;
                                    i8 = i11;
                                }
                            }
                            i4 = i10;
                            i5 = i9;
                            f2 = f3;
                            i6 = i8;
                        }
                        i7++;
                        f = 0.0f;
                    }
                }
                i3++;
                f = 0.0f;
            }
            if (i4 != -1) {
                C0441b bVar2 = this.f1633b[i4];
                bVar2.f1622a.f1686b = -1;
                C0446f fVar2 = f1630g;
                if (fVar2 != null) {
                    fVar2.f1661j++;
                }
                bVar2.mo3171c(this.f1637f.f1629c[i5]);
                bVar2.f1622a.f1686b = i4;
                bVar2.f1622a.mo3207c(bVar2);
            } else {
                z2 = true;
            }
            if (i2 > this.f1635d / 2) {
                z2 = true;
            }
            f = 0.0f;
        }
        return i2;
    }

    /* renamed from: b */
    private void m1813b(C0441b bVar) {
        bVar.mo3152a(this, 0);
    }

    /* renamed from: c */
    private final void m1814c(C0441b bVar) {
        if (this.f1636e > 0) {
            bVar.f1625d.mo2988a(bVar, this.f1633b);
            if (bVar.f1625d.f1410a == 0) {
                bVar.f1626e = true;
            }
        }
    }

    /* renamed from: d */
    private final void m1815d(C0441b bVar) {
        if (this.f1633b[this.f1636e] != null) {
            this.f1637f.f1627a.mo3202a(this.f1633b[this.f1636e]);
        }
        this.f1633b[this.f1636e] = bVar;
        C0450h hVar = bVar.f1622a;
        int i = this.f1636e;
        hVar.f1686b = i;
        this.f1636e = i + 1;
        bVar.f1622a.mo3207c(bVar);
    }

    /* renamed from: h */
    private void m1816h() {
        this.f1640k *= 2;
        this.f1633b = (C0441b[]) Arrays.copyOf(this.f1633b, this.f1640k);
        C0442c cVar = this.f1637f;
        cVar.f1629c = (C0450h[]) Arrays.copyOf(cVar.f1629c, this.f1640k);
        int i = this.f1640k;
        this.f1642m = new boolean[i];
        this.f1641l = i;
        this.f1643n = i;
        C0446f fVar = f1630g;
        if (fVar != null) {
            fVar.f1655d++;
            C0446f fVar2 = f1630g;
            fVar2.f1667p = Math.max(fVar2.f1667p, (long) this.f1640k);
            C0446f fVar3 = f1630g;
            fVar3.f1651D = fVar3.f1667p;
        }
    }

    /* renamed from: i */
    private void m1817i() {
        int i = 0;
        while (true) {
            C0441b[] bVarArr = this.f1633b;
            if (i < bVarArr.length) {
                C0441b bVar = bVarArr[i];
                if (bVar != null) {
                    this.f1637f.f1627a.mo3202a(bVar);
                }
                this.f1633b[i] = null;
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: j */
    private void m1818j() {
        for (int i = 0; i < this.f1636e; i++) {
            C0441b bVar = this.f1633b[i];
            bVar.f1622a.f1688d = bVar.f1623b;
        }
    }

    /* renamed from: a */
    public C0450h mo3178a(int i, String str) {
        C0446f fVar = f1630g;
        if (fVar != null) {
            fVar.f1664m++;
        }
        if (this.f1635d + 1 >= this.f1641l) {
            m1816h();
        }
        C0450h a = m1811a(C0450h.C0451a.ERROR, str);
        this.f1632a++;
        this.f1635d++;
        a.f1685a = this.f1632a;
        a.f1687c = i;
        this.f1637f.f1629c[this.f1632a] = a;
        this.f1639j.mo3173d(a);
        return a;
    }

    /* renamed from: a */
    public C0450h mo3179a(Object obj) {
        C0450h hVar = null;
        if (obj == null) {
            return null;
        }
        if (this.f1635d + 1 >= this.f1641l) {
            m1816h();
        }
        if (obj instanceof C0420e) {
            C0420e eVar = (C0420e) obj;
            hVar = eVar.mo3009b();
            if (hVar == null) {
                eVar.mo3005a(this.f1637f);
                hVar = eVar.mo3009b();
            }
            if (hVar.f1685a == -1 || hVar.f1685a > this.f1632a || this.f1637f.f1629c[hVar.f1685a] == null) {
                if (hVar.f1685a != -1) {
                    hVar.mo3205b();
                }
                this.f1632a++;
                this.f1635d++;
                hVar.f1685a = this.f1632a;
                hVar.f1690f = C0450h.C0451a.UNRESTRICTED;
                this.f1637f.f1629c[this.f1632a] = hVar;
            }
        }
        return hVar;
    }

    /* renamed from: a */
    public void mo3180a(C0425f fVar, C0425f fVar2, float f, int i) {
        C0425f fVar3 = fVar;
        C0425f fVar4 = fVar2;
        C0450h a = mo3179a((Object) fVar3.mo3028a(C0420e.C0424c.LEFT));
        C0450h a2 = mo3179a((Object) fVar3.mo3028a(C0420e.C0424c.TOP));
        C0450h a3 = mo3179a((Object) fVar3.mo3028a(C0420e.C0424c.RIGHT));
        C0450h a4 = mo3179a((Object) fVar3.mo3028a(C0420e.C0424c.BOTTOM));
        C0450h a5 = mo3179a((Object) fVar4.mo3028a(C0420e.C0424c.LEFT));
        C0450h a6 = mo3179a((Object) fVar4.mo3028a(C0420e.C0424c.TOP));
        C0450h a7 = mo3179a((Object) fVar4.mo3028a(C0420e.C0424c.RIGHT));
        C0450h a8 = mo3179a((Object) fVar4.mo3028a(C0420e.C0424c.BOTTOM));
        C0441b c = mo3193c();
        double d = (double) f;
        C0450h hVar = a3;
        double d2 = (double) i;
        c.mo3166b(a2, a4, a6, a8, (float) (Math.sin(d) * d2));
        mo3181a(c);
        C0441b c2 = mo3193c();
        c2.mo3166b(a, hVar, a5, a7, (float) (Math.cos(d) * d2));
        mo3181a(c2);
    }

    /* renamed from: a */
    public void mo3181a(C0441b bVar) {
        C0450h b;
        if (bVar != null) {
            C0446f fVar = f1630g;
            if (fVar != null) {
                fVar.f1657f++;
                if (bVar.f1626e) {
                    f1630g.f1658g++;
                }
            }
            if (this.f1636e + 1 >= this.f1643n || this.f1635d + 1 >= this.f1641l) {
                m1816h();
            }
            boolean z = false;
            if (!bVar.f1626e) {
                m1814c(bVar);
                if (!bVar.mo3174e()) {
                    bVar.mo3172d();
                    if (bVar.mo3162a(this)) {
                        C0450h e = mo3196e();
                        bVar.f1622a = e;
                        m1815d(bVar);
                        this.f1647r.mo3160a(bVar);
                        m1808a(this.f1647r, true);
                        if (e.f1686b == -1) {
                            if (bVar.f1622a == e && (b = bVar.mo3167b(e)) != null) {
                                C0446f fVar2 = f1630g;
                                if (fVar2 != null) {
                                    fVar2.f1661j++;
                                }
                                bVar.mo3171c(b);
                            }
                            if (!bVar.f1626e) {
                                bVar.f1622a.mo3207c(bVar);
                            }
                            this.f1636e--;
                        }
                        z = true;
                    }
                    if (!bVar.mo3161a()) {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!z) {
                m1815d(bVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3182a(C0441b bVar, int i, int i2) {
        bVar.mo3169c(mo3178a(i2, (String) null), i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3183a(C0445a aVar) {
        C0446f fVar = f1630g;
        if (fVar != null) {
            fVar.f1671t++;
            C0446f fVar2 = f1630g;
            fVar2.f1672u = Math.max(fVar2.f1672u, (long) this.f1635d);
            C0446f fVar3 = f1630g;
            fVar3.f1673v = Math.max(fVar3.f1673v, (long) this.f1636e);
        }
        m1814c((C0441b) aVar);
        m1812b(aVar);
        m1808a(aVar, false);
        m1818j();
    }

    /* renamed from: a */
    public void mo3184a(C0450h hVar, int i) {
        C0441b bVar;
        int i2 = hVar.f1686b;
        if (hVar.f1686b != -1) {
            C0441b bVar2 = this.f1633b[i2];
            if (!bVar2.f1626e) {
                if (bVar2.f1625d.f1410a == 0) {
                    bVar2.f1626e = true;
                } else {
                    bVar = mo3193c();
                    bVar.mo3164b(hVar, i);
                }
            }
            bVar2.f1623b = (float) i;
            return;
        }
        bVar = mo3193c();
        bVar.mo3153a(hVar, i);
        mo3181a(bVar);
    }

    /* renamed from: a */
    public void mo3185a(C0450h hVar, C0450h hVar2, int i, float f, C0450h hVar3, C0450h hVar4, int i2, int i3) {
        int i4 = i3;
        C0441b c = mo3193c();
        c.mo3155a(hVar, hVar2, i, f, hVar3, hVar4, i2);
        if (i4 != 6) {
            c.mo3152a(this, i4);
        }
        mo3181a(c);
    }

    /* renamed from: a */
    public void mo3186a(C0450h hVar, C0450h hVar2, int i, int i2) {
        C0441b c = mo3193c();
        C0450h d = mo3195d();
        d.f1687c = 0;
        c.mo3157a(hVar, hVar2, d, i);
        if (i2 != 6) {
            mo3182a(c, (int) (c.f1625d.mo2993b(d) * -1.0f), i2);
        }
        mo3181a(c);
    }

    /* renamed from: a */
    public void mo3187a(C0450h hVar, C0450h hVar2, C0450h hVar3, C0450h hVar4, float f, int i) {
        C0441b c = mo3193c();
        c.mo3158a(hVar, hVar2, hVar3, hVar4, f);
        if (i != 6) {
            c.mo3152a(this, i);
        }
        mo3181a(c);
    }

    /* renamed from: a */
    public void mo3188a(C0450h hVar, C0450h hVar2, boolean z) {
        C0441b c = mo3193c();
        C0450h d = mo3195d();
        d.f1687c = 0;
        c.mo3157a(hVar, hVar2, d, 0);
        if (z) {
            mo3182a(c, (int) (c.f1625d.mo2993b(d) * -1.0f), 1);
        }
        mo3181a(c);
    }

    /* renamed from: b */
    public int mo3189b(Object obj) {
        C0450h b = ((C0420e) obj).mo3009b();
        if (b != null) {
            return (int) (b.f1688d + 0.5f);
        }
        return 0;
    }

    /* renamed from: b */
    public void mo3190b() {
        for (C0450h hVar : this.f1637f.f1629c) {
            if (hVar != null) {
                hVar.mo3205b();
            }
        }
        this.f1637f.f1628b.mo3201a(this.f1644o, this.f1645p);
        this.f1645p = 0;
        Arrays.fill(this.f1637f.f1629c, (Object) null);
        HashMap<String, C0450h> hashMap = this.f1638i;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f1632a = 0;
        this.f1639j.mo3175f();
        this.f1635d = 1;
        for (int i = 0; i < this.f1636e; i++) {
            this.f1633b[i].f1624c = false;
        }
        m1817i();
        this.f1636e = 0;
    }

    /* renamed from: b */
    public void mo3191b(C0450h hVar, C0450h hVar2, int i, int i2) {
        C0441b c = mo3193c();
        C0450h d = mo3195d();
        d.f1687c = 0;
        c.mo3165b(hVar, hVar2, d, i);
        if (i2 != 6) {
            mo3182a(c, (int) (c.f1625d.mo2993b(d) * -1.0f), i2);
        }
        mo3181a(c);
    }

    /* renamed from: b */
    public void mo3192b(C0450h hVar, C0450h hVar2, boolean z) {
        C0441b c = mo3193c();
        C0450h d = mo3195d();
        d.f1687c = 0;
        c.mo3165b(hVar, hVar2, d, 0);
        if (z) {
            mo3182a(c, (int) (c.f1625d.mo2993b(d) * -1.0f), 1);
        }
        mo3181a(c);
    }

    /* renamed from: c */
    public C0441b mo3193c() {
        C0441b a = this.f1637f.f1627a.mo3200a();
        if (a == null) {
            a = new C0441b(this.f1637f);
        } else {
            a.mo3170c();
        }
        C0450h.m1851a();
        return a;
    }

    /* renamed from: c */
    public C0441b mo3194c(C0450h hVar, C0450h hVar2, int i, int i2) {
        C0441b c = mo3193c();
        c.mo3154a(hVar, hVar2, i);
        if (i2 != 6) {
            c.mo3152a(this, i2);
        }
        mo3181a(c);
        return c;
    }

    /* renamed from: d */
    public C0450h mo3195d() {
        C0446f fVar = f1630g;
        if (fVar != null) {
            fVar.f1665n++;
        }
        if (this.f1635d + 1 >= this.f1641l) {
            m1816h();
        }
        C0450h a = m1811a(C0450h.C0451a.SLACK, (String) null);
        this.f1632a++;
        this.f1635d++;
        a.f1685a = this.f1632a;
        this.f1637f.f1629c[this.f1632a] = a;
        return a;
    }

    /* renamed from: e */
    public C0450h mo3196e() {
        C0446f fVar = f1630g;
        if (fVar != null) {
            fVar.f1666o++;
        }
        if (this.f1635d + 1 >= this.f1641l) {
            m1816h();
        }
        C0450h a = m1811a(C0450h.C0451a.SLACK, (String) null);
        this.f1632a++;
        this.f1635d++;
        a.f1685a = this.f1632a;
        this.f1637f.f1629c[this.f1632a] = a;
        return a;
    }

    /* renamed from: f */
    public void mo3197f() {
        C0446f fVar = f1630g;
        if (fVar != null) {
            fVar.f1656e++;
        }
        if (this.f1634c) {
            C0446f fVar2 = f1630g;
            if (fVar2 != null) {
                fVar2.f1669r++;
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.f1636e) {
                    z = true;
                    break;
                } else if (!this.f1633b[i].f1626e) {
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                C0446f fVar3 = f1630g;
                if (fVar3 != null) {
                    fVar3.f1668q++;
                }
                m1818j();
                return;
            }
        }
        mo3183a(this.f1639j);
    }

    /* renamed from: g */
    public C0442c mo3198g() {
        return this.f1637f;
    }
}
