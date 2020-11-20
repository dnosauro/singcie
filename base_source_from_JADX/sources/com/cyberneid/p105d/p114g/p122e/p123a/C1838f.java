package com.cyberneid.p105d.p114g.p122e.p123a;

import android.graphics.Bitmap;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1616l;
import com.cyberneid.p105d.p114g.C1765b;
import com.cyberneid.p105d.p114g.C1931h;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import java.io.IOException;

/* renamed from: com.cyberneid.d.g.e.a.f */
public abstract class C1838f implements C1760c {

    /* renamed from: e */
    protected C1604a f5960e;

    /* renamed from: a */
    public static C1838f m7589a(C1605b bVar) {
        return m7590a(bVar, (C1931h) null);
    }

    /* renamed from: a */
    public static C1838f m7590a(C1605b bVar, C1931h hVar) {
        return m7591a(bVar, hVar, false);
    }

    /* renamed from: a */
    public static C1838f m7591a(C1605b bVar, C1931h hVar, boolean z) {
        if (bVar instanceof C1616l) {
            return m7592a((C1616l) bVar, hVar);
        }
        if (bVar instanceof C1613i) {
            C1613i iVar = (C1613i) bVar;
            if (hVar != null) {
                C1613i iVar2 = null;
                if (iVar.equals(C1613i.f5014bq) && hVar.mo8472c(C1613i.f5005bh)) {
                    iVar2 = C1613i.f5005bh;
                } else if (iVar.equals(C1613i.f5017bt) && hVar.mo8472c(C1613i.f5007bj)) {
                    iVar2 = C1613i.f5007bj;
                } else if (iVar.equals(C1613i.f5015br) && hVar.mo8472c(C1613i.f5006bi)) {
                    iVar2 = C1613i.f5006bi;
                }
                if (hVar.mo8472c(iVar2) && !z) {
                    return hVar.mo8470b(iVar2);
                }
            }
            if (iVar == C1613i.f5017bt) {
                return C1845m.f5975a;
            }
            if (iVar == C1613i.f5015br) {
                return C1841i.f5963a;
            }
            if (iVar == C1613i.f5235fz) {
                return new C1850r(hVar);
            }
            if (hVar == null) {
                throw new C1765b("Unknown color space: " + iVar.mo7596a());
            } else if (hVar.mo8472c(iVar)) {
                return hVar.mo8470b(iVar);
            } else {
                throw new C1765b("Missing color space: " + iVar.mo7596a());
            }
        } else if (bVar instanceof C1604a) {
            C1604a aVar = (C1604a) bVar;
            if (aVar.mo7494b() != 0) {
                C1605b a = aVar.mo7485a(0);
                if (a instanceof C1613i) {
                    C1613i iVar3 = (C1613i) a;
                    if (iVar3 == C1613i.f4952ah) {
                        return new C1835c(aVar);
                    }
                    if (iVar3 == C1613i.f4953ai) {
                        return new C1836d(aVar);
                    }
                    if (iVar3 == C1613i.f5016bs) {
                        return new C1842j(aVar);
                    }
                    if (iVar3 == C1613i.f5123dt) {
                        return new C1848p(aVar, hVar);
                    }
                    if (iVar3 == C1613i.f5281gs) {
                        return new C1851s(aVar);
                    }
                    if (iVar3 == C1613i.f5113dj) {
                        return C1847o.m7636a(aVar, hVar);
                    }
                    if (iVar3 == C1613i.f5086dI) {
                        return new C1849q(aVar);
                    }
                    if (iVar3 == C1613i.f5235fz) {
                        return aVar.mo7494b() == 1 ? new C1850r(hVar) : new C1850r(hVar, m7589a(aVar.mo7495b(1)));
                    }
                    if (iVar3 == C1613i.f5014bq || iVar3 == C1613i.f5017bt || iVar3 == C1613i.f5015br) {
                        return m7591a(iVar3, hVar, z);
                    }
                    throw new IOException("Invalid color space kind: " + iVar3);
                }
                throw new IOException("First element in colorspace array must be a name");
            }
            throw new IOException("Colorspace array is empty");
        } else {
            throw new IOException("Expected a name or array but got: " + bVar);
        }
    }

    /* renamed from: a */
    private static C1838f m7592a(C1616l lVar, C1931h hVar) {
        C1838f b;
        if (hVar != null && hVar.mo8471b() != null && (b = hVar.mo8471b().mo7853b(lVar)) != null) {
            return b;
        }
        C1838f a = m7590a(lVar.mo7604a(), hVar);
        if (!(hVar == null || hVar.mo8471b() == null || a == null)) {
            hVar.mo8471b().mo7852a(lVar, a);
        }
        return a;
    }

    /* renamed from: a */
    public abstract Bitmap mo8253a(Bitmap bitmap);

    /* renamed from: a */
    public abstract float[] mo8257a(float[] fArr);

    /* renamed from: b */
    public abstract String mo8258b();

    /* renamed from: c */
    public abstract int mo8259c();

    /* renamed from: d */
    public C1605b mo7505d() {
        return this.f5960e;
    }

    /* renamed from: e */
    public abstract C1837e mo8260e();
}
