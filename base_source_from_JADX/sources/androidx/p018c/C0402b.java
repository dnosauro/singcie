package androidx.p018c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: androidx.c.b */
public final class C0402b<E> implements Collection<E>, Set<E> {

    /* renamed from: c */
    private static final int[] f1364c = new int[0];

    /* renamed from: d */
    private static final Object[] f1365d = new Object[0];

    /* renamed from: e */
    private static Object[] f1366e;

    /* renamed from: f */
    private static int f1367f;

    /* renamed from: g */
    private static Object[] f1368g;

    /* renamed from: h */
    private static int f1369h;

    /* renamed from: a */
    Object[] f1370a;

    /* renamed from: b */
    int f1371b;

    /* renamed from: i */
    private int[] f1372i;

    /* renamed from: j */
    private C0407f<E, E> f1373j;

    public C0402b() {
        this(0);
    }

    public C0402b(int i) {
        if (i == 0) {
            this.f1372i = f1364c;
            this.f1370a = f1365d;
        } else {
            m1479d(i);
        }
        this.f1371b = 0;
    }

    /* renamed from: a */
    private int m1475a() {
        int i = this.f1371b;
        if (i == 0) {
            return -1;
        }
        int a = C0404c.m1494a(this.f1372i, i, 0);
        if (a < 0 || this.f1370a[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f1372i[i2] == 0) {
            if (this.f1370a[i2] == null) {
                return i2;
            }
            i2++;
        }
        int i3 = a - 1;
        while (i3 >= 0 && this.f1372i[i3] == 0) {
            if (this.f1370a[i3] == null) {
                return i3;
            }
            i3--;
        }
        return ~i2;
    }

    /* renamed from: a */
    private int m1476a(Object obj, int i) {
        int i2 = this.f1371b;
        if (i2 == 0) {
            return -1;
        }
        int a = C0404c.m1494a(this.f1372i, i2, i);
        if (a < 0 || obj.equals(this.f1370a[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f1372i[i3] == i) {
            if (obj.equals(this.f1370a[i3])) {
                return i3;
            }
            i3++;
        }
        int i4 = a - 1;
        while (i4 >= 0 && this.f1372i[i4] == i) {
            if (obj.equals(this.f1370a[i4])) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    /* renamed from: a */
    private static void m1477a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0402b.class) {
                if (f1369h < 10) {
                    objArr[0] = f1368g;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1368g = objArr;
                    f1369h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0402b.class) {
                if (f1367f < 10) {
                    objArr[0] = f1366e;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1366e = objArr;
                    f1367f++;
                }
            }
        }
    }

    /* renamed from: b */
    private C0407f<E, E> m1478b() {
        if (this.f1373j == null) {
            this.f1373j = new C0407f<E, E>() {
                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int mo2816a() {
                    return C0402b.this.f1371b;
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public int mo2817a(Object obj) {
                    return C0402b.this.mo2825a(obj);
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public Object mo2818a(int i, int i2) {
                    return C0402b.this.f1370a[i];
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public E mo2819a(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo2820a(int i) {
                    C0402b.this.mo2830c(i);
                }

                /* access modifiers changed from: protected */
                /* renamed from: a */
                public void mo2821a(E e, E e2) {
                    C0402b.this.add(e);
                }

                /* access modifiers changed from: protected */
                /* renamed from: b */
                public int mo2822b(Object obj) {
                    return C0402b.this.mo2825a(obj);
                }

                /* access modifiers changed from: protected */
                /* renamed from: b */
                public Map<E, E> mo2823b() {
                    throw new UnsupportedOperationException("not a map");
                }

                /* access modifiers changed from: protected */
                /* renamed from: c */
                public void mo2824c() {
                    C0402b.this.clear();
                }
            };
        }
        return this.f1373j;
    }

    /* renamed from: d */
    private void m1479d(int i) {
        if (i == 8) {
            synchronized (C0402b.class) {
                if (f1368g != null) {
                    Object[] objArr = f1368g;
                    this.f1370a = objArr;
                    f1368g = (Object[]) objArr[0];
                    this.f1372i = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1369h--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0402b.class) {
                if (f1366e != null) {
                    Object[] objArr2 = f1366e;
                    this.f1370a = objArr2;
                    f1366e = (Object[]) objArr2[0];
                    this.f1372i = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1367f--;
                    return;
                }
            }
        }
        this.f1372i = new int[i];
        this.f1370a = new Object[i];
    }

    /* renamed from: a */
    public int mo2825a(Object obj) {
        return obj == null ? m1475a() : m1476a(obj, obj.hashCode());
    }

    /* renamed from: a */
    public void mo2826a(int i) {
        int[] iArr = this.f1372i;
        if (iArr.length < i) {
            Object[] objArr = this.f1370a;
            m1479d(i);
            int i2 = this.f1371b;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f1372i, 0, i2);
                System.arraycopy(objArr, 0, this.f1370a, 0, this.f1371b);
            }
            m1477a(iArr, objArr, this.f1371b);
        }
    }

    public boolean add(E e) {
        int i;
        int i2;
        if (e == null) {
            i2 = m1475a();
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            i2 = m1476a(e, hashCode);
        }
        if (i2 >= 0) {
            return false;
        }
        int i3 = ~i2;
        int i4 = this.f1371b;
        if (i4 >= this.f1372i.length) {
            int i5 = 4;
            if (i4 >= 8) {
                i5 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f1372i;
            Object[] objArr = this.f1370a;
            m1479d(i5);
            int[] iArr2 = this.f1372i;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1370a, 0, objArr.length);
            }
            m1477a(iArr, objArr, this.f1371b);
        }
        int i6 = this.f1371b;
        if (i3 < i6) {
            int[] iArr3 = this.f1372i;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr2 = this.f1370a;
            System.arraycopy(objArr2, i3, objArr2, i7, this.f1371b - i3);
        }
        this.f1372i[i3] = i;
        this.f1370a[i3] = e;
        this.f1371b++;
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        mo2826a(this.f1371b + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    /* renamed from: b */
    public E mo2829b(int i) {
        return this.f1370a[i];
    }

    /* renamed from: c */
    public E mo2830c(int i) {
        E[] eArr = this.f1370a;
        E e = eArr[i];
        int i2 = this.f1371b;
        if (i2 <= 1) {
            m1477a(this.f1372i, eArr, i2);
            this.f1372i = f1364c;
            this.f1370a = f1365d;
            this.f1371b = 0;
        } else {
            int[] iArr = this.f1372i;
            int i3 = 8;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                this.f1371b--;
                int i4 = this.f1371b;
                if (i < i4) {
                    int[] iArr2 = this.f1372i;
                    int i5 = i + 1;
                    System.arraycopy(iArr2, i5, iArr2, i, i4 - i);
                    Object[] objArr = this.f1370a;
                    System.arraycopy(objArr, i5, objArr, i, this.f1371b - i);
                }
                this.f1370a[this.f1371b] = null;
            } else {
                if (i2 > 8) {
                    i3 = i2 + (i2 >> 1);
                }
                int[] iArr3 = this.f1372i;
                Object[] objArr2 = this.f1370a;
                m1479d(i3);
                this.f1371b--;
                if (i > 0) {
                    System.arraycopy(iArr3, 0, this.f1372i, 0, i);
                    System.arraycopy(objArr2, 0, this.f1370a, 0, i);
                }
                int i6 = this.f1371b;
                if (i < i6) {
                    int i7 = i + 1;
                    System.arraycopy(iArr3, i7, this.f1372i, i, i6 - i);
                    System.arraycopy(objArr2, i7, this.f1370a, i, this.f1371b - i);
                }
            }
        }
        return e;
    }

    public void clear() {
        int i = this.f1371b;
        if (i != 0) {
            m1477a(this.f1372i, this.f1370a, i);
            this.f1372i = f1364c;
            this.f1370a = f1365d;
            this.f1371b = 0;
        }
    }

    public boolean contains(Object obj) {
        return mo2825a(obj) >= 0;
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
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i = 0;
            while (i < this.f1371b) {
                try {
                    if (!set.contains(mo2829b(i))) {
                        return false;
                    }
                    i++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int[] iArr = this.f1372i;
        int i = this.f1371b;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public boolean isEmpty() {
        return this.f1371b <= 0;
    }

    public Iterator<E> iterator() {
        return m1478b().mo2882e().iterator();
    }

    public boolean remove(Object obj) {
        int a = mo2825a(obj);
        if (a < 0) {
            return false;
        }
        mo2830c(a);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f1371b - 1; i >= 0; i--) {
            if (!collection.contains(this.f1370a[i])) {
                mo2830c(i);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.f1371b;
    }

    public Object[] toArray() {
        int i = this.f1371b;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f1370a, 0, objArr, 0, i);
        return objArr;
    }

    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1371b) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1371b);
        }
        System.arraycopy(this.f1370a, 0, tArr, 0, this.f1371b);
        int length = tArr.length;
        int i = this.f1371b;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1371b * 14);
        sb.append('{');
        for (int i = 0; i < this.f1371b; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object b = mo2829b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
