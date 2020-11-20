package androidx.p018c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* renamed from: androidx.c.f */
abstract class C0407f<K, V> {

    /* renamed from: b */
    C0407f<K, V>.b f1383b;

    /* renamed from: c */
    C0407f<K, V>.c f1384c;

    /* renamed from: d */
    C0407f<K, V>.e f1385d;

    /* renamed from: androidx.c.f$a */
    final class C0408a<T> implements Iterator<T> {

        /* renamed from: a */
        final int f1386a;

        /* renamed from: b */
        int f1387b;

        /* renamed from: c */
        int f1388c;

        /* renamed from: d */
        boolean f1389d = false;

        C0408a(int i) {
            this.f1386a = i;
            this.f1387b = C0407f.this.mo2816a();
        }

        public boolean hasNext() {
            return this.f1388c < this.f1387b;
        }

        public T next() {
            if (hasNext()) {
                T a = C0407f.this.mo2818a(this.f1388c, this.f1386a);
                this.f1388c++;
                this.f1389d = true;
                return a;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.f1389d) {
                this.f1388c--;
                this.f1387b--;
                this.f1389d = false;
                C0407f.this.mo2820a(this.f1388c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* renamed from: androidx.c.f$b */
    final class C0409b implements Set<Map.Entry<K, V>> {
        C0409b() {
        }

        /* renamed from: a */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int a = C0407f.this.mo2816a();
            for (Map.Entry entry : collection) {
                C0407f.this.mo2821a(entry.getKey(), entry.getValue());
            }
            return a != C0407f.this.mo2816a();
        }

        public void clear() {
            C0407f.this.mo2824c();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a = C0407f.this.mo2817a(entry.getKey());
            if (a < 0) {
                return false;
            }
            return C0404c.m1496a(C0407f.this.mo2818a(a, 1), entry.getValue());
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return C0407f.m1515a(this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = C0407f.this.mo2816a() - 1; a >= 0; a--) {
                Object a2 = C0407f.this.mo2818a(a, 0);
                Object a3 = C0407f.this.mo2818a(a, 1);
                i += (a2 == null ? 0 : a2.hashCode()) ^ (a3 == null ? 0 : a3.hashCode());
            }
            return i;
        }

        public boolean isEmpty() {
            return C0407f.this.mo2816a() == 0;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new C0411d();
        }

        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return C0407f.this.mo2816a();
        }

        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: androidx.c.f$c */
    final class C0410c implements Set<K> {
        C0410c() {
        }

        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            C0407f.this.mo2824c();
        }

        public boolean contains(Object obj) {
            return C0407f.this.mo2817a(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            return C0407f.m1514a(C0407f.this.mo2823b(), collection);
        }

        public boolean equals(Object obj) {
            return C0407f.m1515a(this, obj);
        }

        public int hashCode() {
            int i = 0;
            for (int a = C0407f.this.mo2816a() - 1; a >= 0; a--) {
                Object a2 = C0407f.this.mo2818a(a, 0);
                i += a2 == null ? 0 : a2.hashCode();
            }
            return i;
        }

        public boolean isEmpty() {
            return C0407f.this.mo2816a() == 0;
        }

        public Iterator<K> iterator() {
            return new C0408a(0);
        }

        public boolean remove(Object obj) {
            int a = C0407f.this.mo2817a(obj);
            if (a < 0) {
                return false;
            }
            C0407f.this.mo2820a(a);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return C0407f.m1516b(C0407f.this.mo2823b(), collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return C0407f.m1517c(C0407f.this.mo2823b(), collection);
        }

        public int size() {
            return C0407f.this.mo2816a();
        }

        public Object[] toArray() {
            return C0407f.this.mo2880b(0);
        }

        public <T> T[] toArray(T[] tArr) {
            return C0407f.this.mo2879a(tArr, 0);
        }
    }

    /* renamed from: androidx.c.f$d */
    final class C0411d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a */
        int f1393a;

        /* renamed from: b */
        int f1394b;

        /* renamed from: c */
        boolean f1395c = false;

        C0411d() {
            this.f1393a = C0407f.this.mo2816a() - 1;
            this.f1394b = -1;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (hasNext()) {
                this.f1394b++;
                this.f1395c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        public boolean equals(Object obj) {
            if (!this.f1395c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                return C0404c.m1496a(entry.getKey(), C0407f.this.mo2818a(this.f1394b, 0)) && C0404c.m1496a(entry.getValue(), C0407f.this.mo2818a(this.f1394b, 1));
            }
        }

        public K getKey() {
            if (this.f1395c) {
                return C0407f.this.mo2818a(this.f1394b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public V getValue() {
            if (this.f1395c) {
                return C0407f.this.mo2818a(this.f1394b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public boolean hasNext() {
            return this.f1394b < this.f1393a;
        }

        public int hashCode() {
            if (this.f1395c) {
                int i = 0;
                Object a = C0407f.this.mo2818a(this.f1394b, 0);
                Object a2 = C0407f.this.mo2818a(this.f1394b, 1);
                int hashCode = a == null ? 0 : a.hashCode();
                if (a2 != null) {
                    i = a2.hashCode();
                }
                return hashCode ^ i;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public void remove() {
            if (this.f1395c) {
                C0407f.this.mo2820a(this.f1394b);
                this.f1394b--;
                this.f1393a--;
                this.f1395c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public V setValue(V v) {
            if (this.f1395c) {
                return C0407f.this.mo2819a(this.f1394b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: androidx.c.f$e */
    final class C0412e implements Collection<V> {
        C0412e() {
        }

        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            C0407f.this.mo2824c();
        }

        public boolean contains(Object obj) {
            return C0407f.this.mo2822b(obj) >= 0;
        }

        public boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }

        public boolean isEmpty() {
            return C0407f.this.mo2816a() == 0;
        }

        public Iterator<V> iterator() {
            return new C0408a(1);
        }

        public boolean remove(Object obj) {
            int b = C0407f.this.mo2822b(obj);
            if (b < 0) {
                return false;
            }
            C0407f.this.mo2820a(b);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            int a = C0407f.this.mo2816a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (collection.contains(C0407f.this.mo2818a(i, 1))) {
                    C0407f.this.mo2820a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            int a = C0407f.this.mo2816a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (!collection.contains(C0407f.this.mo2818a(i, 1))) {
                    C0407f.this.mo2820a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public int size() {
            return C0407f.this.mo2816a();
        }

        public Object[] toArray() {
            return C0407f.this.mo2880b(1);
        }

        public <T> T[] toArray(T[] tArr) {
            return C0407f.this.mo2879a(tArr, 1);
        }
    }

    C0407f() {
    }

    /* renamed from: a */
    public static <K, V> boolean m1514a(Map<K, V> map, Collection<?> collection) {
        for (Object containsKey : collection) {
            if (!map.containsKey(containsKey)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static <T> boolean m1515a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* renamed from: b */
    public static <K, V> boolean m1516b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        for (Object remove : collection) {
            map.remove(remove);
        }
        return size != map.size();
    }

    /* renamed from: c */
    public static <K, V> boolean m1517c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo2816a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract int mo2817a(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract Object mo2818a(int i, int i2);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract V mo2819a(int i, V v);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo2820a(int i);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo2821a(K k, V v);

    /* renamed from: a */
    public <T> T[] mo2879a(T[] tArr, int i) {
        int a = mo2816a();
        if (tArr.length < a) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr[i2] = mo2818a(i2, i);
        }
        if (tArr.length > a) {
            tArr[a] = null;
        }
        return tArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract int mo2822b(Object obj);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Map<K, V> mo2823b();

    /* renamed from: b */
    public Object[] mo2880b(int i) {
        int a = mo2816a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = mo2818a(i2, i);
        }
        return objArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo2824c();

    /* renamed from: d */
    public Set<Map.Entry<K, V>> mo2881d() {
        if (this.f1383b == null) {
            this.f1383b = new C0409b();
        }
        return this.f1383b;
    }

    /* renamed from: e */
    public Set<K> mo2882e() {
        if (this.f1384c == null) {
            this.f1384c = new C0410c();
        }
        return this.f1384c;
    }

    /* renamed from: f */
    public Collection<V> mo2883f() {
        if (this.f1385d == null) {
            this.f1385d = new C0412e();
        }
        return this.f1385d;
    }
}
