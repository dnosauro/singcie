package androidx.p004a.p005a.p007b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: androidx.a.a.b.b */
public class C0044b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* renamed from: a */
    C0047c<K, V> f17a;

    /* renamed from: b */
    private C0047c<K, V> f18b;

    /* renamed from: c */
    private WeakHashMap<C0050f<K, V>, Boolean> f19c = new WeakHashMap<>();

    /* renamed from: d */
    private int f20d = 0;

    /* renamed from: androidx.a.a.b.b$a */
    static class C0045a<K, V> extends C0049e<K, V> {
        C0045a(C0047c<K, V> cVar, C0047c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0047c<K, V> mo644a(C0047c<K, V> cVar) {
            return cVar.f23c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C0047c<K, V> mo645b(C0047c<K, V> cVar) {
            return cVar.f24d;
        }
    }

    /* renamed from: androidx.a.a.b.b$b */
    private static class C0046b<K, V> extends C0049e<K, V> {
        C0046b(C0047c<K, V> cVar, C0047c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C0047c<K, V> mo644a(C0047c<K, V> cVar) {
            return cVar.f24d;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C0047c<K, V> mo645b(C0047c<K, V> cVar) {
            return cVar.f23c;
        }
    }

    /* renamed from: androidx.a.a.b.b$c */
    static class C0047c<K, V> implements Map.Entry<K, V> {

        /* renamed from: a */
        final K f21a;

        /* renamed from: b */
        final V f22b;

        /* renamed from: c */
        C0047c<K, V> f23c;

        /* renamed from: d */
        C0047c<K, V> f24d;

        C0047c(K k, V v) {
            this.f21a = k;
            this.f22b = v;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0047c)) {
                return false;
            }
            C0047c cVar = (C0047c) obj;
            return this.f21a.equals(cVar.f21a) && this.f22b.equals(cVar.f22b);
        }

        public K getKey() {
            return this.f21a;
        }

        public V getValue() {
            return this.f22b;
        }

        public int hashCode() {
            return this.f21a.hashCode() ^ this.f22b.hashCode();
        }

        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f21a + "=" + this.f22b;
        }
    }

    /* renamed from: androidx.a.a.b.b$d */
    private class C0048d implements C0050f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: b */
        private C0047c<K, V> f26b;

        /* renamed from: c */
        private boolean f27c = true;

        C0048d() {
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            C0047c<K, V> cVar;
            if (this.f27c) {
                this.f27c = false;
                cVar = C0044b.this.f17a;
            } else {
                C0047c<K, V> cVar2 = this.f26b;
                cVar = cVar2 != null ? cVar2.f23c : null;
            }
            this.f26b = cVar;
            return this.f26b;
        }

        /* renamed from: a_ */
        public void mo653a_(C0047c<K, V> cVar) {
            C0047c<K, V> cVar2 = this.f26b;
            if (cVar == cVar2) {
                this.f26b = cVar2.f24d;
                this.f27c = this.f26b == null;
            }
        }

        public boolean hasNext() {
            if (this.f27c) {
                return C0044b.this.f17a != null;
            }
            C0047c<K, V> cVar = this.f26b;
            return (cVar == null || cVar.f23c == null) ? false : true;
        }
    }

    /* renamed from: androidx.a.a.b.b$e */
    private static abstract class C0049e<K, V> implements C0050f<K, V>, Iterator<Map.Entry<K, V>> {

        /* renamed from: a */
        C0047c<K, V> f28a;

        /* renamed from: b */
        C0047c<K, V> f29b;

        C0049e(C0047c<K, V> cVar, C0047c<K, V> cVar2) {
            this.f28a = cVar2;
            this.f29b = cVar;
        }

        /* renamed from: b */
        private C0047c<K, V> m37b() {
            C0047c<K, V> cVar = this.f29b;
            C0047c<K, V> cVar2 = this.f28a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return mo644a(cVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public abstract C0047c<K, V> mo644a(C0047c<K, V> cVar);

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            C0047c<K, V> cVar = this.f29b;
            this.f29b = m37b();
            return cVar;
        }

        /* renamed from: a_ */
        public void mo653a_(C0047c<K, V> cVar) {
            if (this.f28a == cVar && cVar == this.f29b) {
                this.f29b = null;
                this.f28a = null;
            }
            C0047c<K, V> cVar2 = this.f28a;
            if (cVar2 == cVar) {
                this.f28a = mo645b(cVar2);
            }
            if (this.f29b == cVar) {
                this.f29b = m37b();
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public abstract C0047c<K, V> mo645b(C0047c<K, V> cVar);

        public boolean hasNext() {
            return this.f29b != null;
        }
    }

    /* renamed from: androidx.a.a.b.b$f */
    interface C0050f<K, V> {
        /* renamed from: a_ */
        void mo653a_(C0047c<K, V> cVar);
    }

    /* renamed from: a */
    public int mo634a() {
        return this.f20d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0047c<K, V> mo629a(K k) {
        C0047c<K, V> cVar = this.f17a;
        while (cVar != null && !cVar.f21a.equals(k)) {
            cVar = cVar.f23c;
        }
        return cVar;
    }

    /* renamed from: a */
    public V mo630a(K k, V v) {
        C0047c a = mo629a(k);
        if (a != null) {
            return a.f22b;
        }
        mo635b(k, v);
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0047c<K, V> mo635b(K k, V v) {
        C0047c<K, V> cVar = new C0047c<>(k, v);
        this.f20d++;
        C0047c<K, V> cVar2 = this.f18b;
        if (cVar2 == null) {
            this.f17a = cVar;
            this.f18b = this.f17a;
            return cVar;
        }
        cVar2.f23c = cVar;
        cVar.f24d = cVar2;
        this.f18b = cVar;
        return cVar;
    }

    /* renamed from: b */
    public V mo631b(K k) {
        C0047c a = mo629a(k);
        if (a == null) {
            return null;
        }
        this.f20d--;
        if (!this.f19c.isEmpty()) {
            for (C0050f<K, V> a_ : this.f19c.keySet()) {
                a_.mo653a_(a);
            }
        }
        if (a.f24d != null) {
            a.f24d.f23c = a.f23c;
        } else {
            this.f17a = a.f23c;
        }
        if (a.f23c != null) {
            a.f23c.f24d = a.f24d;
        } else {
            this.f18b = a.f24d;
        }
        a.f23c = null;
        a.f24d = null;
        return a.f22b;
    }

    /* renamed from: b */
    public Iterator<Map.Entry<K, V>> mo636b() {
        C0046b bVar = new C0046b(this.f18b, this.f17a);
        this.f19c.put(bVar, false);
        return bVar;
    }

    /* renamed from: c */
    public C0044b<K, V>.d mo637c() {
        C0044b<K, V>.d dVar = new C0048d();
        this.f19c.put(dVar, false);
        return dVar;
    }

    /* renamed from: d */
    public Map.Entry<K, V> mo638d() {
        return this.f17a;
    }

    /* renamed from: e */
    public Map.Entry<K, V> mo639e() {
        return this.f18b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0044b)) {
            return false;
        }
        C0044b bVar = (C0044b) obj;
        if (mo634a() != bVar.mo634a()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return !it.hasNext() && !it2.hasNext();
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Map.Entry) it.next()).hashCode();
        }
        return i;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        C0045a aVar = new C0045a(this.f17a, this.f18b);
        this.f19c.put(aVar, false);
        return aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
