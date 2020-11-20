package com.cyberneid.p105d.p108b;

import com.cyberneid.p105d.p114g.p115a.C1760c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.cyberneid.d.b.a */
public class C1604a extends C1605b implements Iterable<C1605b> {

    /* renamed from: a */
    private final List<C1605b> f4862a = new ArrayList();

    /* renamed from: a */
    public int mo7484a(int i, int i2) {
        if (i >= mo7494b()) {
            return i2;
        }
        C1605b bVar = this.f4862a.get(i);
        return bVar instanceof C1615k ? ((C1615k) bVar).mo7586c() : i2;
    }

    /* renamed from: a */
    public C1605b mo7485a(int i) {
        C1605b bVar = this.f4862a.get(i);
        if (bVar instanceof C1616l) {
            bVar = ((C1616l) bVar).mo7604a();
        } else if (bVar instanceof C1614j) {
            bVar = null;
        }
        return bVar;
    }

    /* renamed from: a */
    public Object mo7486a(C1624r rVar) {
        return rVar.mo7647a(this);
    }

    /* renamed from: a */
    public void mo7487a() {
        this.f4862a.clear();
    }

    /* renamed from: a */
    public void mo7488a(int i, C1605b bVar) {
        this.f4862a.add(i, bVar);
    }

    /* renamed from: a */
    public void mo7489a(int i, Collection<C1605b> collection) {
        this.f4862a.addAll(i, collection);
    }

    /* renamed from: a */
    public void mo7490a(C1605b bVar) {
        this.f4862a.add(bVar);
    }

    /* renamed from: a */
    public void mo7491a(C1760c cVar) {
        this.f4862a.add(cVar.mo7505d());
    }

    /* renamed from: a */
    public void mo7492a(Collection<C1605b> collection) {
        this.f4862a.removeAll(collection);
    }

    /* renamed from: a */
    public void mo7493a(float[] fArr) {
        mo7487a();
        for (float fVar : fArr) {
            mo7490a((C1605b) new C1609f(fVar));
        }
    }

    /* renamed from: b */
    public int mo7494b() {
        return this.f4862a.size();
    }

    /* renamed from: b */
    public C1605b mo7495b(int i) {
        return this.f4862a.get(i);
    }

    /* renamed from: b */
    public void mo7496b(int i, C1605b bVar) {
        this.f4862a.set(i, bVar);
    }

    /* renamed from: b */
    public void mo7497b(Collection<C1605b> collection) {
        this.f4862a.retainAll(collection);
    }

    /* renamed from: c */
    public int mo7498c(int i) {
        return mo7484a(i, -1);
    }

    /* renamed from: c */
    public void mo7499c(Collection<C1605b> collection) {
        this.f4862a.addAll(collection);
    }

    /* renamed from: c */
    public float[] mo7500c() {
        float[] fArr = new float[mo7494b()];
        for (int i = 0; i < mo7494b(); i++) {
            fArr[i] = ((C1615k) mo7485a(i)).mo7583a();
        }
        return fArr;
    }

    /* renamed from: d */
    public C1605b mo7501d(int i) {
        return this.f4862a.remove(i);
    }

    public Iterator<C1605b> iterator() {
        return this.f4862a.iterator();
    }

    public String toString() {
        return "COSArray{" + this.f4862a + "}";
    }
}
