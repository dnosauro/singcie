package com.cyberneid.p105d.p114g.p126f.p130d;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1622p;
import com.cyberneid.p105d.p114g.p115a.C1689a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.cyberneid.d.g.f.d.c */
public final class C1902c {
    /* renamed from: a */
    static List<String> m7848a(C1605b bVar, int i) {
        if (i < 0 || i > 1) {
            throw new IllegalArgumentException("Only 0 and 1 are allowed as an index into two-element arrays");
        } else if (bVar instanceof C1622p) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(((C1622p) bVar).mo7641b());
            return arrayList;
        } else if (!(bVar instanceof C1604a)) {
            return Collections.emptyList();
        } else {
            C1604a aVar = (C1604a) bVar;
            return aVar.mo7495b(0) instanceof C1622p ? C1689a.m6907c(aVar) : m7849b(bVar, i);
        }
    }

    /* renamed from: b */
    private static List<String> m7849b(C1605b bVar, int i) {
        ArrayList arrayList = new ArrayList();
        C1604a aVar = (C1604a) bVar;
        int b = aVar.mo7494b();
        for (int i2 = 0; i2 < b; i2++) {
            arrayList.add(((C1622p) ((C1604a) aVar.mo7495b(i2)).mo7495b(i)).mo7641b());
        }
        return arrayList;
    }
}
