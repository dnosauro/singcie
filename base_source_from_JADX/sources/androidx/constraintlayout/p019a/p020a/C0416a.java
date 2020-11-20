package androidx.constraintlayout.p019a.p020a;

import androidx.constraintlayout.p019a.p020a.C0420e;
import androidx.constraintlayout.p019a.p020a.C0425f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.constraintlayout.a.a.a */
public class C0416a {
    /* renamed from: a */
    private static int m1575a(C0425f fVar) {
        if (fVar.mo3024F() == C0425f.C0427a.MATCH_CONSTRAINT) {
            int r = (int) (fVar.f1477H == 0 ? ((float) fVar.mo3085r()) * fVar.f1476G : ((float) fVar.mo3085r()) / fVar.f1476G);
            fVar.mo3070j(r);
            return r;
        } else if (fVar.mo3025G() != C0425f.C0427a.MATCH_CONSTRAINT) {
            return -1;
        } else {
            int p = (int) (fVar.f1477H == 1 ? ((float) fVar.mo3081p()) * fVar.f1476G : ((float) fVar.mo3081p()) / fVar.f1476G);
            fVar.mo3072k(p);
            return p;
        }
    }

    /* renamed from: a */
    private static int m1576a(C0425f fVar, int i) {
        int i2 = i * 2;
        C0420e eVar = fVar.f1470A[i2];
        C0420e eVar2 = fVar.f1470A[i2 + 1];
        if (eVar.f1443c == null || eVar.f1443c.f1441a != fVar.f1473D || eVar2.f1443c == null || eVar2.f1443c.f1441a != fVar.f1473D) {
            return 0;
        }
        return (int) (((float) (((fVar.f1473D.mo3061f(i) - eVar.mo3012e()) - eVar2.mo3012e()) - fVar.mo3061f(i))) * (i == 0 ? fVar.f1487S : fVar.f1488T));
    }

    /* renamed from: a */
    private static int m1577a(C0425f fVar, int i, boolean z, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int p;
        int i9;
        int i10;
        C0425f k;
        int i11;
        C0425f fVar2 = fVar;
        int i12 = i;
        boolean z2 = z;
        int i13 = 0;
        if (!fVar2.f1491W) {
            return 0;
        }
        boolean z3 = fVar2.f1538w.f1443c != null && i12 == 1;
        if (z2) {
            i6 = fVar.mo3019A();
            i5 = fVar.mo3085r() - fVar.mo3019A();
            i4 = i12 * 2;
            i3 = i4 + 1;
        } else {
            i6 = fVar.mo3085r() - fVar.mo3019A();
            i5 = fVar.mo3019A();
            i3 = i12 * 2;
            i4 = i3 + 1;
        }
        if (fVar2.f1470A[i3].f1443c == null || fVar2.f1470A[i4].f1443c != null) {
            i7 = i3;
            i8 = 1;
        } else {
            i7 = i4;
            i4 = i3;
            i8 = -1;
        }
        int i14 = z3 ? i2 - i6 : i2;
        int e = (fVar2.f1470A[i4].mo3012e() * i8) + m1576a(fVar, i);
        int i15 = i14 + e;
        int p2 = (i12 == 0 ? fVar.mo3081p() : fVar.mo3085r()) * i8;
        Iterator it = fVar2.f1470A[i4].mo3004a().f1609h.iterator();
        while (it.hasNext()) {
            i13 = Math.max(i13, m1577a(((C0435m) ((C0437o) it.next())).f1595a.f1441a, i12, z2, i15));
        }
        int i16 = 0;
        for (Iterator it2 = fVar2.f1470A[i7].mo3004a().f1609h.iterator(); it2.hasNext(); it2 = it2) {
            i16 = Math.max(i16, m1577a(((C0435m) ((C0437o) it2.next())).f1595a.f1441a, i12, z2, p2 + i15));
        }
        if (z3) {
            i13 -= i6;
            p = i16 + i5;
        } else {
            p = i16 + ((i12 == 0 ? fVar.mo3081p() : fVar.mo3085r()) * i8);
        }
        int i17 = 1;
        if (i12 == 1) {
            Iterator it3 = fVar2.f1538w.mo3004a().f1609h.iterator();
            int i18 = 0;
            while (it3.hasNext()) {
                Iterator it4 = it3;
                C0435m mVar = (C0435m) ((C0437o) it3.next());
                if (i8 == i17) {
                    i18 = Math.max(i18, m1577a(mVar.f1595a.f1441a, i12, z2, i6 + i15));
                    i11 = i7;
                } else {
                    i11 = i7;
                    i18 = Math.max(i18, m1577a(mVar.f1595a.f1441a, i12, z2, (i5 * i8) + i15));
                }
                it3 = it4;
                i7 = i11;
                i17 = 1;
            }
            i9 = i7;
            int i19 = i18;
            i10 = (fVar2.f1538w.mo3004a().f1609h.size() <= 0 || z3) ? i19 : i8 == 1 ? i19 + i6 : i19 - i5;
        } else {
            i9 = i7;
            i10 = 0;
        }
        int max = e + Math.max(i13, Math.max(p, i10));
        int i20 = i15 + p2;
        if (i8 == -1) {
            int i21 = i15;
            i15 = i20;
            i20 = i21;
        }
        if (z2) {
            C0433k.m1742a(fVar2, i12, i15);
            fVar2.mo3031a(i15, i20, i12);
        } else {
            fVar2.f1533r.mo3116a(fVar2, i12);
            fVar2.mo3059e(i15, i12);
        }
        if (fVar.mo3090t(i) == C0425f.C0427a.MATCH_CONSTRAINT && fVar2.f1476G != 0.0f) {
            fVar2.f1533r.mo3116a(fVar2, i12);
        }
        if (fVar2.f1470A[i4].f1443c != null && fVar2.f1470A[i9].f1443c != null && fVar2.f1470A[i4].f1443c.f1441a == (k = fVar.mo3071k()) && fVar2.f1470A[i9].f1443c.f1441a == k) {
            fVar2.f1533r.mo3116a(fVar2, i12);
        }
        return max;
    }

    /* renamed from: a */
    private static int m1578a(C0429h hVar, int i) {
        int i2 = i * 2;
        List<C0425f> a = hVar.mo3115a(i);
        int size = a.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            C0425f fVar = a.get(i4);
            int i5 = i2 + 1;
            i3 = Math.max(i3, m1577a(fVar, i, fVar.f1470A[i5].f1443c == null || !(fVar.f1470A[i2].f1443c == null || fVar.f1470A[i5].f1443c == null), 0));
        }
        hVar.f1575e[i] = i3;
        return i3;
    }

    /* renamed from: a */
    private static void m1579a(C0420e eVar) {
        C0435m a = eVar.mo3004a();
        if (eVar.f1443c != null && eVar.f1443c.f1443c != eVar) {
            eVar.f1443c.mo3004a().mo3139a(a);
        }
    }

    /* renamed from: a */
    private static void m1580a(C0425f fVar, int i, int i2) {
        int i3 = i * 2;
        C0420e eVar = fVar.f1470A[i3];
        C0420e eVar2 = fVar.f1470A[i3 + 1];
        if ((eVar.f1443c == null || eVar2.f1443c == null) ? false : true) {
            C0433k.m1742a(fVar, i, m1576a(fVar, i) + eVar.mo3012e());
        } else if (fVar.f1476G == 0.0f || fVar.mo3090t(i) != C0425f.C0427a.MATCH_CONSTRAINT) {
            int p = i2 - fVar.mo3082p(i);
            int f = p - fVar.mo3061f(i);
            fVar.mo3031a(f, p, i);
            C0433k.m1742a(fVar, i, f);
        } else {
            int a = m1575a(fVar);
            int i4 = (int) fVar.f1470A[i3].mo3004a().f1600f;
            eVar2.mo3004a().f1599e = eVar.mo3004a();
            eVar2.mo3004a().f1600f = (float) a;
            eVar2.mo3004a().f1610i = 1;
            fVar.mo3031a(i4, i4 + a, i);
        }
    }

    /* renamed from: a */
    public static void m1581a(C0428g gVar) {
        if ((gVar.mo3098J() & 32) != 32) {
            m1586b(gVar);
            return;
        }
        gVar.f1569ax = true;
        gVar.f1564as = false;
        gVar.f1565at = false;
        gVar.f1566au = false;
        ArrayList<C0425f> arrayList = gVar.f1621az;
        List<C0429h> list = gVar.f1563ar;
        boolean z = gVar.mo3024F() == C0425f.C0427a.WRAP_CONTENT;
        boolean z2 = gVar.mo3025G() == C0425f.C0427a.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (C0425f fVar : arrayList) {
            fVar.f1533r = null;
            fVar.f1493Y = false;
            fVar.mo3000b();
        }
        for (C0425f fVar2 : arrayList) {
            if (fVar2.f1533r == null && !m1585a(fVar2, list, z3)) {
                m1586b(gVar);
                gVar.f1569ax = false;
                return;
            }
        }
        int i = 0;
        int i2 = 0;
        for (C0429h next : list) {
            i = Math.max(i, m1578a(next, 0));
            i2 = Math.max(i2, m1578a(next, 1));
        }
        if (z) {
            gVar.mo3035a(C0425f.C0427a.FIXED);
            gVar.mo3070j(i);
            gVar.f1564as = true;
            gVar.f1565at = true;
            gVar.f1567av = i;
        }
        if (z2) {
            gVar.mo3045b(C0425f.C0427a.FIXED);
            gVar.mo3072k(i2);
            gVar.f1564as = true;
            gVar.f1566au = true;
            gVar.f1568aw = i2;
        }
        m1583a(list, 0, gVar.mo3081p());
        m1583a(list, 1, gVar.mo3085r());
    }

    /* renamed from: a */
    private static void m1582a(C0428g gVar, C0425f fVar, C0429h hVar) {
        hVar.f1574d = false;
        gVar.f1569ax = false;
        fVar.f1491W = false;
    }

    /* renamed from: a */
    public static void m1583a(List<C0429h> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (C0425f next : list.get(i3).mo3117b(i)) {
                if (next.f1491W) {
                    m1580a(next, i, i2);
                }
            }
        }
    }

    /* renamed from: a */
    private static boolean m1584a(C0425f fVar, C0429h hVar, List<C0429h> list, boolean z) {
        if (fVar == null) {
            return true;
        }
        fVar.f1492X = false;
        C0428g gVar = (C0428g) fVar.mo3071k();
        if (fVar.f1533r == null) {
            fVar.f1491W = true;
            hVar.f1571a.add(fVar);
            fVar.f1533r = hVar;
            if (fVar.f1534s.f1443c == null && fVar.f1536u.f1443c == null && fVar.f1535t.f1443c == null && fVar.f1537v.f1443c == null && fVar.f1538w.f1443c == null && fVar.f1541z.f1443c == null) {
                m1582a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
            }
            if (!(fVar.f1535t.f1443c == null || fVar.f1537v.f1443c == null)) {
                C0425f.C0427a G = gVar.mo3025G();
                C0425f.C0427a aVar = C0425f.C0427a.WRAP_CONTENT;
                if (z) {
                    m1582a(gVar, fVar, hVar);
                    return false;
                } else if (!(fVar.f1535t.f1443c.f1441a == fVar.mo3071k() && fVar.f1537v.f1443c.f1441a == fVar.mo3071k())) {
                    m1582a(gVar, fVar, hVar);
                }
            }
            if (!(fVar.f1534s.f1443c == null || fVar.f1536u.f1443c == null)) {
                C0425f.C0427a F = gVar.mo3024F();
                C0425f.C0427a aVar2 = C0425f.C0427a.WRAP_CONTENT;
                if (z) {
                    m1582a(gVar, fVar, hVar);
                    return false;
                } else if (!(fVar.f1534s.f1443c.f1441a == fVar.mo3071k() && fVar.f1536u.f1443c.f1441a == fVar.mo3071k())) {
                    m1582a(gVar, fVar, hVar);
                }
            }
            if (((fVar.mo3024F() == C0425f.C0427a.MATCH_CONSTRAINT) ^ (fVar.mo3025G() == C0425f.C0427a.MATCH_CONSTRAINT)) && fVar.f1476G != 0.0f) {
                m1575a(fVar);
            } else if (fVar.mo3024F() == C0425f.C0427a.MATCH_CONSTRAINT || fVar.mo3025G() == C0425f.C0427a.MATCH_CONSTRAINT) {
                m1582a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
            }
            if (((fVar.f1534s.f1443c == null && fVar.f1536u.f1443c == null) || ((fVar.f1534s.f1443c != null && fVar.f1534s.f1443c.f1441a == fVar.f1473D && fVar.f1536u.f1443c == null) || ((fVar.f1536u.f1443c != null && fVar.f1536u.f1443c.f1441a == fVar.f1473D && fVar.f1534s.f1443c == null) || (fVar.f1534s.f1443c != null && fVar.f1534s.f1443c.f1441a == fVar.f1473D && fVar.f1536u.f1443c != null && fVar.f1536u.f1443c.f1441a == fVar.f1473D)))) && fVar.f1541z.f1443c == null && !(fVar instanceof C0430i) && !(fVar instanceof C0432j)) {
                hVar.f1576f.add(fVar);
            }
            if (((fVar.f1535t.f1443c == null && fVar.f1537v.f1443c == null) || ((fVar.f1535t.f1443c != null && fVar.f1535t.f1443c.f1441a == fVar.f1473D && fVar.f1537v.f1443c == null) || ((fVar.f1537v.f1443c != null && fVar.f1537v.f1443c.f1441a == fVar.f1473D && fVar.f1535t.f1443c == null) || (fVar.f1535t.f1443c != null && fVar.f1535t.f1443c.f1441a == fVar.f1473D && fVar.f1537v.f1443c != null && fVar.f1537v.f1443c.f1441a == fVar.f1473D)))) && fVar.f1541z.f1443c == null && fVar.f1538w.f1443c == null && !(fVar instanceof C0430i) && !(fVar instanceof C0432j)) {
                hVar.f1577g.add(fVar);
            }
            if (fVar instanceof C0432j) {
                m1582a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
                C0432j jVar = (C0432j) fVar;
                for (int i = 0; i < jVar.f1593aj; i++) {
                    if (!m1584a(jVar.f1592ai[i], hVar, list, z)) {
                        return false;
                    }
                }
            }
            for (C0420e eVar : fVar.f1470A) {
                if (!(eVar.f1443c == null || eVar.f1443c.f1441a == fVar.mo3071k())) {
                    if (eVar.f1442b == C0420e.C0424c.CENTER) {
                        m1582a(gVar, fVar, hVar);
                        if (z) {
                            return false;
                        }
                    } else {
                        m1579a(eVar);
                    }
                    if (!m1584a(eVar.f1443c.f1441a, hVar, list, z)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (fVar.f1533r != hVar) {
            hVar.f1571a.addAll(fVar.f1533r.f1571a);
            hVar.f1576f.addAll(fVar.f1533r.f1576f);
            hVar.f1577g.addAll(fVar.f1533r.f1577g);
            if (!fVar.f1533r.f1574d) {
                hVar.f1574d = false;
            }
            list.remove(fVar.f1533r);
            for (C0425f fVar2 : fVar.f1533r.f1571a) {
                fVar2.f1533r = hVar;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m1585a(C0425f fVar, List<C0429h> list, boolean z) {
        C0429h hVar = new C0429h(new ArrayList(), true);
        list.add(hVar);
        return m1584a(fVar, hVar, list, z);
    }

    /* renamed from: b */
    private static void m1586b(C0428g gVar) {
        gVar.f1563ar.clear();
        gVar.f1563ar.add(0, new C0429h(gVar.f1621az));
    }
}
