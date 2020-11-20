package com.cyberneid.p105d.p114g;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1612h;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p115a.C1760c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* renamed from: com.cyberneid.d.g.g */
public class C1928g implements C1760c, Iterable<C1831e> {

    /* renamed from: a */
    private final C1607d f6102a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1783c f6103b;

    /* renamed from: com.cyberneid.d.g.g$a */
    private final class C1930a implements Iterator<C1831e> {

        /* renamed from: b */
        private final Queue<C1607d> f6105b;

        private C1930a(C1607d dVar) {
            this.f6105b = new ArrayDeque();
            m7950a(dVar);
        }

        /* renamed from: a */
        private void m7950a(C1607d dVar) {
            if (C1928g.this.m7944b(dVar)) {
                for (C1607d a : C1928g.this.m7941a(dVar)) {
                    m7950a(a);
                }
                return;
            }
            this.f6105b.add(dVar);
        }

        /* renamed from: a */
        public C1831e next() {
            C1607d poll = this.f6105b.poll();
            if (poll.mo7543d(C1613i.f5338hw) == C1613i.f5224fo) {
                return new C1831e(poll, C1928g.this.f6103b != null ? C1928g.this.f6103b.mo8076n() : null);
            }
            throw new IllegalStateException("Expected Page but got " + poll);
        }

        public boolean hasNext() {
            return !this.f6105b.isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public C1928g() {
        this.f6102a = new C1607d();
        this.f6102a.mo7521a(C1613i.f5338hw, (C1605b) C1613i.f5228fs);
        this.f6102a.mo7521a(C1613i.f5084dG, (C1605b) new C1604a());
        this.f6102a.mo7521a(C1613i.f4936aR, (C1605b) C1612h.f4886a);
        this.f6103b = null;
    }

    C1928g(C1607d dVar, C1783c cVar) {
        if (dVar != null) {
            this.f6102a = dVar;
            this.f6103b = cVar;
            return;
        }
        throw new IllegalArgumentException("root cannot be null");
    }

    /* renamed from: a */
    public static C1605b m7938a(C1607d dVar, C1613i iVar) {
        C1605b c = dVar.mo7539c(iVar);
        if (c != null) {
            return c;
        }
        C1607d dVar2 = (C1607d) dVar.mo7513a(C1613i.f5232fw, C1613i.f5223fn);
        if (dVar2 != null) {
            return m7938a(dVar2, iVar);
        }
        return null;
    }

    /* renamed from: a */
    private C1607d m7939a(int i, C1607d dVar, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + i);
        } else if (m7944b(dVar)) {
            if (i <= dVar.mo7529b(C1613i.f4936aR, 0) + i2) {
                for (C1607d next : m7941a(dVar)) {
                    if (m7944b(next)) {
                        int b = next.mo7529b(C1613i.f4936aR, 0) + i2;
                        if (i <= b) {
                            return m7939a(i, next, i2);
                        }
                        i2 = b;
                    } else {
                        i2++;
                        if (i == i2) {
                            return m7939a(i, next, i2);
                        }
                    }
                }
                throw new IllegalStateException();
            }
            throw new IndexOutOfBoundsException("Index out of bounds: " + i);
        } else if (i2 == i) {
            return dVar;
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public List<C1607d> m7941a(C1607d dVar) {
        ArrayList arrayList = new ArrayList();
        C1604a aVar = (C1604a) dVar.mo7539c(C1613i.f5084dG);
        if (aVar == null) {
            return arrayList;
        }
        int b = aVar.mo7494b();
        for (int i = 0; i < b; i++) {
            arrayList.add((C1607d) aVar.mo7485a(i));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m7944b(C1607d dVar) {
        return dVar.mo7543d(C1613i.f5338hw) == C1613i.f5228fs || dVar.mo7555l(C1613i.f5084dG);
    }

    /* renamed from: a */
    public int mo8455a() {
        return this.f6102a.mo7529b(C1613i.f4936aR, 0);
    }

    /* renamed from: a */
    public C1831e mo8456a(int i) {
        C1607d a = m7939a(i + 1, this.f6102a, 0);
        if (a.mo7543d(C1613i.f5338hw) == C1613i.f5224fo) {
            C1783c cVar = this.f6103b;
            return new C1831e(a, cVar != null ? cVar.mo8076n() : null);
        }
        throw new IllegalStateException("Expected Page but got " + a);
    }

    /* renamed from: a */
    public void mo8457a(C1831e eVar) {
        C1607d b = eVar.mo7505d();
        b.mo7521a(C1613i.f5232fw, (C1605b) this.f6102a);
        ((C1604a) this.f6102a.mo7539c(C1613i.f5084dG)).mo7490a((C1605b) b);
        do {
            b = (C1607d) b.mo7513a(C1613i.f5232fw, C1613i.f5223fn);
            if (b != null) {
                b.mo7518a(C1613i.f4936aR, b.mo7547g(C1613i.f4936aR) + 1);
                continue;
            }
        } while (b != null);
    }

    /* renamed from: b */
    public C1607d mo7505d() {
        return this.f6102a;
    }

    public Iterator<C1831e> iterator() {
        return new C1930a(this.f6102a);
    }
}
