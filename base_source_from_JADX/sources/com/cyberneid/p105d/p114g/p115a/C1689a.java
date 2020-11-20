package com.cyberneid.p105d.p114g.p115a;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1609f;
import com.cyberneid.p105d.p108b.C1612h;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1614j;
import com.cyberneid.p105d.p108b.C1615k;
import com.cyberneid.p105d.p108b.C1616l;
import com.cyberneid.p105d.p108b.C1622p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.cyberneid.d.g.a.a */
public class C1689a<E> implements List<E> {

    /* renamed from: a */
    private final C1604a f5639a;

    /* renamed from: b */
    private final List<E> f5640b;

    /* renamed from: c */
    private C1607d f5641c;

    /* renamed from: d */
    private C1613i f5642d;

    public C1689a() {
        this.f5639a = new C1604a();
        this.f5640b = new ArrayList();
    }

    public C1689a(List<E> list, C1604a aVar) {
        this.f5640b = list;
        this.f5639a = aVar;
    }

    /* renamed from: a */
    public static C1604a m6903a(List<?> list) {
        C1605b bVar;
        C1605b fVar;
        if (list == null) {
            return null;
        }
        if (list instanceof C1689a) {
            return ((C1689a) list).f5639a;
        }
        C1604a aVar = new C1604a();
        for (Object next : list) {
            if (next instanceof String) {
                fVar = new C1622p((String) next);
            } else {
                if ((next instanceof Integer) || (next instanceof Long)) {
                    bVar = C1612h.m6455a(((Number) next).longValue());
                } else if ((next instanceof Float) || (next instanceof Double)) {
                    fVar = new C1609f(((Number) next).floatValue());
                } else if (next instanceof C1760c) {
                    bVar = ((C1760c) next).mo7505d();
                } else if (next == null) {
                    bVar = C1614j.f5368b;
                } else {
                    throw new IllegalArgumentException("Error: Don't know how to convert type to COSBase '" + next.getClass().getName() + "'");
                }
                aVar.mo7490a(bVar);
            }
            aVar.mo7490a(fVar);
        }
        return aVar;
    }

    /* renamed from: a */
    public static List<Integer> m6904a(C1604a aVar) {
        if (aVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aVar.mo7494b(); i++) {
            arrayList.add(Integer.valueOf(((C1615k) (aVar.mo7495b(i) instanceof C1616l ? ((C1616l) aVar.mo7495b(i)).mo7604a() : aVar.mo7495b(i))).mo7586c()));
        }
        return new C1689a(arrayList, aVar);
    }

    /* renamed from: a */
    private List<C1605b> m6905a(Collection<?> collection) {
        ArrayList arrayList = new ArrayList();
        for (Object next : collection) {
            if (next instanceof String) {
                arrayList.add(new C1622p((String) next));
            } else {
                arrayList.add(((C1760c) next).mo7505d());
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static List<String> m6906b(C1604a aVar) {
        if (aVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aVar.mo7494b(); i++) {
            arrayList.add(((C1613i) aVar.mo7485a(i)).mo7596a());
        }
        return new C1689a(arrayList, aVar);
    }

    /* renamed from: c */
    public static List<String> m6907c(C1604a aVar) {
        if (aVar == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < aVar.mo7494b(); i++) {
            arrayList.add(((C1622p) aVar.mo7485a(i)).mo7641b());
        }
        return new C1689a(arrayList, aVar);
    }

    /* renamed from: a */
    public C1604a mo7854a() {
        return this.f5639a;
    }

    public void add(int i, E e) {
        C1607d dVar = this.f5641c;
        if (dVar != null) {
            dVar.mo7521a(this.f5642d, (C1605b) this.f5639a);
            this.f5641c = null;
        }
        this.f5640b.add(i, e);
        if (e instanceof String) {
            this.f5639a.mo7488a(i, (C1605b) new C1622p((String) e));
        } else {
            this.f5639a.mo7488a(i, ((C1760c) e).mo7505d());
        }
    }

    public boolean add(E e) {
        C1604a aVar;
        C1605b d;
        C1607d dVar = this.f5641c;
        if (dVar != null) {
            dVar.mo7521a(this.f5642d, (C1605b) this.f5639a);
            this.f5641c = null;
        }
        if (e instanceof String) {
            aVar = this.f5639a;
            d = new C1622p((String) e);
        } else {
            aVar = this.f5639a;
            if (aVar != null) {
                d = ((C1760c) e).mo7505d();
            }
            return this.f5640b.add(e);
        }
        aVar.mo7490a(d);
        return this.f5640b.add(e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        if (this.f5641c != null && collection.size() > 0) {
            this.f5641c.mo7521a(this.f5642d, (C1605b) this.f5639a);
            this.f5641c = null;
        }
        this.f5639a.mo7489a(i, (Collection<C1605b>) m6905a((Collection<?>) collection));
        return this.f5640b.addAll(i, collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        if (this.f5641c != null && collection.size() > 0) {
            this.f5641c.mo7521a(this.f5642d, (C1605b) this.f5639a);
            this.f5641c = null;
        }
        this.f5639a.mo7499c((Collection<C1605b>) m6905a((Collection<?>) collection));
        return this.f5640b.addAll(collection);
    }

    public void clear() {
        C1607d dVar = this.f5641c;
        if (dVar != null) {
            dVar.mo7521a(this.f5642d, (C1605b) null);
        }
        this.f5640b.clear();
        this.f5639a.mo7487a();
    }

    public boolean contains(Object obj) {
        return this.f5640b.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.f5640b.containsAll(collection);
    }

    public boolean equals(Object obj) {
        return this.f5640b.equals(obj);
    }

    public E get(int i) {
        return this.f5640b.get(i);
    }

    public int hashCode() {
        return this.f5640b.hashCode();
    }

    public int indexOf(Object obj) {
        return this.f5640b.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.f5640b.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.f5640b.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.f5640b.indexOf(obj);
    }

    public ListIterator<E> listIterator() {
        return this.f5640b.listIterator();
    }

    public ListIterator<E> listIterator(int i) {
        return this.f5640b.listIterator(i);
    }

    public E remove(int i) {
        this.f5639a.mo7501d(i);
        return this.f5640b.remove(i);
    }

    public boolean remove(Object obj) {
        int indexOf = this.f5640b.indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        this.f5640b.remove(indexOf);
        this.f5639a.mo7501d(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        this.f5639a.mo7492a((Collection<C1605b>) m6905a(collection));
        return this.f5640b.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        this.f5639a.mo7497b((Collection<C1605b>) m6905a(collection));
        return this.f5640b.retainAll(collection);
    }

    public E set(int i, E e) {
        if (e instanceof String) {
            C1622p pVar = new C1622p((String) e);
            C1607d dVar = this.f5641c;
            if (dVar != null && i == 0) {
                dVar.mo7521a(this.f5642d, (C1605b) pVar);
            }
            this.f5639a.mo7496b(i, pVar);
        } else {
            C1607d dVar2 = this.f5641c;
            if (dVar2 != null && i == 0) {
                dVar2.mo7521a(this.f5642d, ((C1760c) e).mo7505d());
            }
            this.f5639a.mo7496b(i, ((C1760c) e).mo7505d());
        }
        return this.f5640b.set(i, e);
    }

    public int size() {
        return this.f5640b.size();
    }

    public List<E> subList(int i, int i2) {
        return this.f5640b.subList(i, i2);
    }

    public Object[] toArray() {
        return this.f5640b.toArray();
    }

    public <X> X[] toArray(X[] xArr) {
        return this.f5640b.toArray(xArr);
    }

    public String toString() {
        return "COSArrayList{" + this.f5639a.toString() + "}";
    }
}
