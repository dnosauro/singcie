package com.cyberneid.p105d.p114g.p122e.p123a;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.cyberneid.d.g.e.a.l */
public class C1844l {

    /* renamed from: a */
    private final C1607d f5974a;

    public C1844l() {
        this.f5974a = new C1607d();
    }

    public C1844l(C1607d dVar) {
        this.f5974a = dVar;
    }

    /* renamed from: a */
    public C1838f mo8275a() {
        C1605b c = this.f5974a.mo7539c(C1613i.f4929aK);
        if (c == null) {
            return null;
        }
        return C1838f.m7589a(c);
    }

    /* renamed from: b */
    public List<String> mo8276b() {
        ArrayList arrayList = new ArrayList();
        C1604a aVar = (C1604a) this.f5974a.mo7539c(C1613i.f4932aN);
        if (aVar == null) {
            return arrayList;
        }
        Iterator<C1605b> it = aVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((C1613i) it.next()).mo7596a());
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Process{");
        try {
            sb.append(mo8275a());
            for (String append : mo8276b()) {
                sb.append(" \"");
                sb.append(append);
                sb.append('\"');
            }
        } catch (IOException unused) {
            sb.append("ERROR");
        }
        sb.append('}');
        return sb.toString();
    }
}
