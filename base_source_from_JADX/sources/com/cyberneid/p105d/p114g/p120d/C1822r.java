package com.cyberneid.p105d.p114g.p120d;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import java.io.IOException;

/* renamed from: com.cyberneid.d.g.d.r */
public final class C1822r {
    /* renamed from: a */
    static C1815k m7473a(C1607d dVar, C1828x xVar) {
        C1613i b = dVar.mo7533b(C1613i.f5338hw, C1613i.f5030cF);
        if (C1613i.f5030cF.equals(b)) {
            C1613i d = dVar.mo7543d(C1613i.f5258gV);
            if (C1613i.f4966av.equals(d)) {
                return new C1816l(dVar, xVar);
            }
            if (C1613i.f4967aw.equals(d)) {
                return new C1817m(dVar, xVar);
            }
            throw new IOException("Invalid font type: " + b);
        }
        throw new IllegalArgumentException("Expected 'Font' dictionary but found '" + b.mo7596a() + "'");
    }

    /* renamed from: a */
    public static C1820p m7474a(C1607d dVar) {
        C1613i b = dVar.mo7533b(C1613i.f5338hw, C1613i.f5030cF);
        if (!C1613i.f5030cF.equals(b)) {
            Log.e("PdfBox-Android", "Expected 'Font' dictionary but found '" + b.mo7596a() + "'");
        }
        C1613i d = dVar.mo7543d(C1613i.f5258gV);
        if (C1613i.f5340hy.equals(d)) {
            C1605b c = dVar.mo7539c(C1613i.f5032cH);
            return (!(c instanceof C1607d) || !((C1607d) c).mo7555l(C1613i.f5036cL)) ? new C1830z(dVar) : new C1829y(dVar);
        } else if (C1613i.f5177eu.equals(d)) {
            C1605b c2 = dVar.mo7539c(C1613i.f5032cH);
            return (!(c2 instanceof C1607d) || !((C1607d) c2).mo7555l(C1613i.f5036cL)) ? new C1823s(dVar) : new C1829y(dVar);
        } else if (C1613i.f5334hs.equals(d)) {
            return new C1827w(dVar);
        } else {
            if (C1613i.f5341hz.equals(d)) {
                return new C1797ab(dVar);
            }
            if (C1613i.f5339hx.equals(d)) {
                return new C1828x(dVar);
            }
            if (C1613i.f4966av.equals(d)) {
                throw new IllegalArgumentException("Type 0 descendant font not allowed");
            } else if (!C1613i.f4967aw.equals(d)) {
                Log.w("PdfBox-Android", "Invalid font subtype '" + d + "'");
                return new C1830z(dVar);
            } else {
                throw new IllegalArgumentException("Type 2 descendant font not allowed");
            }
        }
    }
}
