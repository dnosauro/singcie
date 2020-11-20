package androidx.p004a.p005a.p007b;

import androidx.p004a.p005a.p007b.C0044b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.a.a.b.a */
public class C0043a<K, V> extends C0044b<K, V> {

    /* renamed from: b */
    private HashMap<K, C0044b.C0047c<K, V>> f16b = new HashMap<>();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0044b.C0047c<K, V> mo629a(K k) {
        return this.f16b.get(k);
    }

    /* renamed from: a */
    public V mo630a(K k, V v) {
        C0044b.C0047c a = mo629a(k);
        if (a != null) {
            return a.f22b;
        }
        this.f16b.put(k, mo635b(k, v));
        return null;
    }

    /* renamed from: b */
    public V mo631b(K k) {
        V b = super.mo631b(k);
        this.f16b.remove(k);
        return b;
    }

    /* renamed from: c */
    public boolean mo632c(K k) {
        return this.f16b.containsKey(k);
    }

    /* renamed from: d */
    public Map.Entry<K, V> mo633d(K k) {
        if (mo632c(k)) {
            return this.f16b.get(k).f24d;
        }
        return null;
    }
}
