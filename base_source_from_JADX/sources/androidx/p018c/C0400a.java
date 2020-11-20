package androidx.p018c;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: androidx.c.a */
public class C0400a<K, V> extends C0413g<K, V> implements Map<K, V> {

    /* renamed from: a */
    C0407f<K, V> f1362a;

    public C0400a() {
    }

    public C0400a(int i) {
        super(i);
    }

    public C0400a(C0413g gVar) {
        super(gVar);
    }

    /* renamed from: b */
    private C0407f<K, V> m1464b() {
        if (this.f1362a == null) {
            this.f1362a = new C0407f<K, V>() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int mo2816a() {
                    return C0400a.this.f1404h;
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int mo2817a(Object obj) {
                    return C0400a.this.mo2942a(obj);
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public Object mo2818a(int i, int i2) {
                    return C0400a.this.f1403g[(i << 1) + i2];
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public V mo2819a(int i, V v) {
                    return C0400a.this.mo2944a(i, v);
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo2820a(int i) {
                    C0400a.this.mo2953d(i);
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo2821a(K k, V v) {
                    C0400a.this.put(k, v);
                }

                /* access modifiers changed from: protected */
                /* renamed from: b */
                public int mo2822b(Object obj) {
                    return C0400a.this.mo2947b(obj);
                }

                /* access modifiers changed from: protected */
                /* renamed from: b */
                public Map<K, V> mo2823b() {
                    return C0400a.this;
                }

                /* access modifiers changed from: protected */
                /* renamed from: c */
                public void mo2824c() {
                    C0400a.this.clear();
                }
            };
        }
        return this.f1362a;
    }

    /* renamed from: a */
    public boolean mo2811a(Collection<?> collection) {
        return C0407f.m1517c(this, collection);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return m1464b().mo2881d();
    }

    public Set<K> keySet() {
        return m1464b().mo2882e();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        mo2945a(this.f1404h + map.size());
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public Collection<V> values() {
        return m1464b().mo2883f();
    }
}
