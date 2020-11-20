package androidx.p018c;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* renamed from: androidx.c.g */
public class C0413g<K, V> {

    /* renamed from: b */
    static Object[] f1398b;

    /* renamed from: c */
    static int f1399c;

    /* renamed from: d */
    static Object[] f1400d;

    /* renamed from: e */
    static int f1401e;

    /* renamed from: f */
    int[] f1402f;

    /* renamed from: g */
    Object[] f1403g;

    /* renamed from: h */
    int f1404h;

    public C0413g() {
        this.f1402f = C0404c.f1375a;
        this.f1403g = C0404c.f1377c;
        this.f1404h = 0;
    }

    public C0413g(int i) {
        if (i == 0) {
            this.f1402f = C0404c.f1375a;
            this.f1403g = C0404c.f1377c;
        } else {
            m1536e(i);
        }
        this.f1404h = 0;
    }

    public C0413g(C0413g<K, V> gVar) {
        this();
        if (gVar != null) {
            mo2946a(gVar);
        }
    }

    /* renamed from: a */
    private static int m1534a(int[] iArr, int i, int i2) {
        try {
            return C0404c.m1494a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: a */
    private static void m1535a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0413g.class) {
                if (f1401e < 10) {
                    objArr[0] = f1400d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1400d = objArr;
                    f1401e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0413g.class) {
                if (f1399c < 10) {
                    objArr[0] = f1398b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1398b = objArr;
                    f1399c++;
                }
            }
        }
    }

    /* renamed from: e */
    private void m1536e(int i) {
        if (i == 8) {
            synchronized (C0413g.class) {
                if (f1400d != null) {
                    Object[] objArr = f1400d;
                    this.f1403g = objArr;
                    f1400d = (Object[]) objArr[0];
                    this.f1402f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1401e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0413g.class) {
                if (f1398b != null) {
                    Object[] objArr2 = f1398b;
                    this.f1403g = objArr2;
                    f1398b = (Object[]) objArr2[0];
                    this.f1402f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1399c--;
                    return;
                }
            }
        }
        this.f1402f = new int[i];
        this.f1403g = new Object[(i << 1)];
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo2941a() {
        int i = this.f1404h;
        if (i == 0) {
            return -1;
        }
        int a = m1534a(this.f1402f, i, 0);
        if (a < 0 || this.f1403g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f1402f[i2] == 0) {
            if (this.f1403g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a - 1;
        while (i3 >= 0 && this.f1402f[i3] == 0) {
            if (this.f1403g[i3 << 1] == null) {
                return i3;
            }
            i3--;
        }
        return ~i2;
    }

    /* renamed from: a */
    public int mo2942a(Object obj) {
        return obj == null ? mo2941a() : mo2943a(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo2943a(Object obj, int i) {
        int i2 = this.f1404h;
        if (i2 == 0) {
            return -1;
        }
        int a = m1534a(this.f1402f, i2, i);
        if (a < 0 || obj.equals(this.f1403g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f1402f[i3] == i) {
            if (obj.equals(this.f1403g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        int i4 = a - 1;
        while (i4 >= 0 && this.f1402f[i4] == i) {
            if (obj.equals(this.f1403g[i4 << 1])) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    /* renamed from: a */
    public V mo2944a(int i, V v) {
        int i2 = (i << 1) + 1;
        V[] vArr = this.f1403g;
        V v2 = vArr[i2];
        vArr[i2] = v;
        return v2;
    }

    /* renamed from: a */
    public void mo2945a(int i) {
        int i2 = this.f1404h;
        int[] iArr = this.f1402f;
        if (iArr.length < i) {
            Object[] objArr = this.f1403g;
            m1536e(i);
            if (this.f1404h > 0) {
                System.arraycopy(iArr, 0, this.f1402f, 0, i2);
                System.arraycopy(objArr, 0, this.f1403g, 0, i2 << 1);
            }
            m1535a(iArr, objArr, i2);
        }
        if (this.f1404h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    /* renamed from: a */
    public void mo2946a(C0413g<? extends K, ? extends V> gVar) {
        int i = gVar.f1404h;
        mo2945a(this.f1404h + i);
        if (this.f1404h != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(gVar.mo2948b(i2), gVar.mo2949c(i2));
            }
        } else if (i > 0) {
            System.arraycopy(gVar.f1402f, 0, this.f1402f, 0, i);
            System.arraycopy(gVar.f1403g, 0, this.f1403g, 0, i << 1);
            this.f1404h = i;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo2947b(Object obj) {
        int i = this.f1404h * 2;
        Object[] objArr = this.f1403g;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public K mo2948b(int i) {
        return this.f1403g[i << 1];
    }

    /* renamed from: c */
    public V mo2949c(int i) {
        return this.f1403g[(i << 1) + 1];
    }

    public void clear() {
        int i = this.f1404h;
        if (i > 0) {
            int[] iArr = this.f1402f;
            Object[] objArr = this.f1403g;
            this.f1402f = C0404c.f1375a;
            this.f1403g = C0404c.f1377c;
            this.f1404h = 0;
            m1535a(iArr, objArr, i);
        }
        if (this.f1404h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return mo2942a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return mo2947b(obj) >= 0;
    }

    /* renamed from: d */
    public V mo2953d(int i) {
        int i2;
        V[] vArr = this.f1403g;
        int i3 = i << 1;
        V v = vArr[i3 + 1];
        int i4 = this.f1404h;
        if (i4 <= 1) {
            m1535a(this.f1402f, (Object[]) vArr, i4);
            this.f1402f = C0404c.f1375a;
            this.f1403g = C0404c.f1377c;
            i2 = 0;
        } else {
            i2 = i4 - 1;
            int[] iArr = this.f1402f;
            int i5 = 8;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i < i2) {
                    int[] iArr2 = this.f1402f;
                    int i6 = i + 1;
                    int i7 = i2 - i;
                    System.arraycopy(iArr2, i6, iArr2, i, i7);
                    Object[] objArr = this.f1403g;
                    System.arraycopy(objArr, i6 << 1, objArr, i3, i7 << 1);
                }
                Object[] objArr2 = this.f1403g;
                int i8 = i2 << 1;
                objArr2[i8] = null;
                objArr2[i8 + 1] = null;
            } else {
                if (i4 > 8) {
                    i5 = i4 + (i4 >> 1);
                }
                int[] iArr3 = this.f1402f;
                Object[] objArr3 = this.f1403g;
                m1536e(i5);
                if (i4 == this.f1404h) {
                    if (i > 0) {
                        System.arraycopy(iArr3, 0, this.f1402f, 0, i);
                        System.arraycopy(objArr3, 0, this.f1403g, 0, i3);
                    }
                    if (i < i2) {
                        int i9 = i + 1;
                        int i10 = i2 - i;
                        System.arraycopy(iArr3, i9, this.f1402f, i, i10);
                        System.arraycopy(objArr3, i9 << 1, this.f1403g, i3, i10 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
        }
        if (i4 == this.f1404h) {
            this.f1404h = i2;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0413g) {
            C0413g gVar = (C0413g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            int i = 0;
            while (i < this.f1404h) {
                try {
                    Object b = mo2948b(i);
                    Object c = mo2949c(i);
                    Object obj2 = gVar.get(b);
                    if (c == null) {
                        if (obj2 != null || !gVar.containsKey(b)) {
                            return false;
                        }
                    } else if (!c.equals(obj2)) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.f1404h) {
                try {
                    Object b2 = mo2948b(i2);
                    Object c2 = mo2949c(i2);
                    Object obj3 = map.get(b2);
                    if (c2 == null) {
                        if (obj3 != null || !map.containsKey(b2)) {
                            return false;
                        }
                    } else if (!c2.equals(obj3)) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v) {
        int a = mo2942a(obj);
        return a >= 0 ? this.f1403g[(a << 1) + 1] : v;
    }

    public int hashCode() {
        int[] iArr = this.f1402f;
        Object[] objArr = this.f1403g;
        int i = this.f1404h;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < i) {
            Object obj = objArr[i4];
            i3 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i4 += 2;
        }
        return i3;
    }

    public boolean isEmpty() {
        return this.f1404h <= 0;
    }

    public V put(K k, V v) {
        int i;
        int i2;
        int i3 = this.f1404h;
        if (k == null) {
            i2 = mo2941a();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            i2 = mo2943a((Object) k, hashCode);
        }
        if (i2 >= 0) {
            int i4 = (i2 << 1) + 1;
            V[] vArr = this.f1403g;
            V v2 = vArr[i4];
            vArr[i4] = v;
            return v2;
        }
        int i5 = ~i2;
        if (i3 >= this.f1402f.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f1402f;
            Object[] objArr = this.f1403g;
            m1536e(i6);
            if (i3 == this.f1404h) {
                int[] iArr2 = this.f1402f;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.f1403g, 0, objArr.length);
                }
                m1535a(iArr, objArr, i3);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i3) {
            int[] iArr3 = this.f1402f;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr2 = this.f1403g;
            System.arraycopy(objArr2, i5 << 1, objArr2, i7 << 1, (this.f1404h - i5) << 1);
        }
        int i8 = this.f1404h;
        if (i3 == i8) {
            int[] iArr4 = this.f1402f;
            if (i5 < iArr4.length) {
                iArr4[i5] = i;
                Object[] objArr3 = this.f1403g;
                int i9 = i5 << 1;
                objArr3[i9] = k;
                objArr3[i9 + 1] = v;
                this.f1404h = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public V remove(Object obj) {
        int a = mo2942a(obj);
        if (a >= 0) {
            return mo2953d(a);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int a = mo2942a(obj);
        if (a < 0) {
            return false;
        }
        Object c = mo2949c(a);
        if (obj2 != c && (obj2 == null || !obj2.equals(c))) {
            return false;
        }
        mo2953d(a);
        return true;
    }

    public V replace(K k, V v) {
        int a = mo2942a((Object) k);
        if (a >= 0) {
            return mo2944a(a, v);
        }
        return null;
    }

    public boolean replace(K k, V v, V v2) {
        int a = mo2942a((Object) k);
        if (a < 0) {
            return false;
        }
        V c = mo2949c(a);
        if (c != v && (v == null || !v.equals(c))) {
            return false;
        }
        mo2944a(a, v2);
        return true;
    }

    public int size() {
        return this.f1404h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1404h * 28);
        sb.append('{');
        for (int i = 0; i < this.f1404h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object b = mo2948b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object c = mo2949c(i);
            if (c != this) {
                sb.append(c);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
