package androidx.coordinatorlayout.widget;

import androidx.core.p029g.C0584e;
import androidx.p018c.C0413g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: androidx.coordinatorlayout.widget.a */
public final class C0479a<T> {

    /* renamed from: a */
    private final C0584e.C0585a<ArrayList<T>> f1912a = new C0584e.C0586b(10);

    /* renamed from: b */
    private final C0413g<T, ArrayList<T>> f1913b = new C0413g<>();

    /* renamed from: c */
    private final ArrayList<T> f1914c = new ArrayList<>();

    /* renamed from: d */
    private final HashSet<T> f1915d = new HashSet<>();

    /* renamed from: a */
    private void m1925a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList arrayList2 = this.f1913b.get(t);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i = 0; i < size; i++) {
                        m1925a(arrayList2.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    /* renamed from: a */
    private void m1926a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.f1912a.mo3612a(arrayList);
    }

    /* renamed from: c */
    private ArrayList<T> m1927c() {
        ArrayList<T> a = this.f1912a.mo3611a();
        return a == null ? new ArrayList<>() : a;
    }

    /* renamed from: a */
    public void mo3393a() {
        int size = this.f1913b.size();
        for (int i = 0; i < size; i++) {
            ArrayList c = this.f1913b.mo2949c(i);
            if (c != null) {
                m1926a(c);
            }
        }
        this.f1913b.clear();
    }

    /* renamed from: a */
    public void mo3394a(T t) {
        if (!this.f1913b.containsKey(t)) {
            this.f1913b.put(t, null);
        }
    }

    /* renamed from: a */
    public void mo3395a(T t, T t2) {
        if (!this.f1913b.containsKey(t) || !this.f1913b.containsKey(t2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.f1913b.get(t);
        if (arrayList == null) {
            arrayList = m1927c();
            this.f1913b.put(t, arrayList);
        }
        arrayList.add(t2);
    }

    /* renamed from: b */
    public ArrayList<T> mo3396b() {
        this.f1914c.clear();
        this.f1915d.clear();
        int size = this.f1913b.size();
        for (int i = 0; i < size; i++) {
            m1925a(this.f1913b.mo2948b(i), this.f1914c, this.f1915d);
        }
        return this.f1914c;
    }

    /* renamed from: b */
    public boolean mo3397b(T t) {
        return this.f1913b.containsKey(t);
    }

    /* renamed from: c */
    public List mo3398c(T t) {
        return this.f1913b.get(t);
    }

    /* renamed from: d */
    public List<T> mo3399d(T t) {
        int size = this.f1913b.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            ArrayList c = this.f1913b.mo2949c(i);
            if (c != null && c.contains(t)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1913b.mo2948b(i));
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public boolean mo3400e(T t) {
        int size = this.f1913b.size();
        for (int i = 0; i < size; i++) {
            ArrayList c = this.f1913b.mo2949c(i);
            if (c != null && c.contains(t)) {
                return true;
            }
        }
        return false;
    }
}
