package androidx.p018c;

/* renamed from: androidx.c.h */
public class C0414h<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f1405a = new Object();

    /* renamed from: b */
    private boolean f1406b;

    /* renamed from: c */
    private int[] f1407c;

    /* renamed from: d */
    private Object[] f1408d;

    /* renamed from: e */
    private int f1409e;

    public C0414h() {
        this(10);
    }

    public C0414h(int i) {
        Object[] objArr;
        this.f1406b = false;
        if (i == 0) {
            this.f1407c = C0404c.f1375a;
            objArr = C0404c.f1377c;
        } else {
            int a = C0404c.m1493a(i);
            this.f1407c = new int[a];
            objArr = new Object[a];
        }
        this.f1408d = objArr;
    }

    /* renamed from: d */
    private void m1547d() {
        int i = this.f1409e;
        int[] iArr = this.f1407c;
        Object[] objArr = this.f1408d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1405a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1406b = false;
        this.f1409e = i2;
    }

    /* renamed from: a */
    public int mo2967a(E e) {
        if (this.f1406b) {
            m1547d();
        }
        for (int i = 0; i < this.f1409e; i++) {
            if (this.f1408d[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public C0414h<E> clone() {
        try {
            C0414h<E> hVar = (C0414h) super.clone();
            hVar.f1407c = (int[]) this.f1407c.clone();
            hVar.f1408d = (Object[]) this.f1408d.clone();
            return hVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public E mo2969a(int i) {
        return mo2970a(i, (Object) null);
    }

    /* renamed from: a */
    public E mo2970a(int i, E e) {
        int a = C0404c.m1494a(this.f1407c, this.f1409e, i);
        if (a >= 0) {
            E[] eArr = this.f1408d;
            if (eArr[a] != f1405a) {
                return eArr[a];
            }
        }
        return e;
    }

    /* renamed from: b */
    public int mo2971b() {
        if (this.f1406b) {
            m1547d();
        }
        return this.f1409e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.f1408d;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo2972b(int r4) {
        /*
            r3 = this;
            int[] r0 = r3.f1407c
            int r1 = r3.f1409e
            int r4 = androidx.p018c.C0404c.m1494a((int[]) r0, (int) r1, (int) r4)
            if (r4 < 0) goto L_0x0017
            java.lang.Object[] r0 = r3.f1408d
            r1 = r0[r4]
            java.lang.Object r2 = f1405a
            if (r1 == r2) goto L_0x0017
            r0[r4] = r2
            r4 = 1
            r3.f1406b = r4
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p018c.C0414h.mo2972b(int):void");
    }

    /* renamed from: b */
    public void mo2973b(int i, E e) {
        int a = C0404c.m1494a(this.f1407c, this.f1409e, i);
        if (a >= 0) {
            this.f1408d[a] = e;
            return;
        }
        int i2 = ~a;
        if (i2 < this.f1409e) {
            Object[] objArr = this.f1408d;
            if (objArr[i2] == f1405a) {
                this.f1407c[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.f1406b && this.f1409e >= this.f1407c.length) {
            m1547d();
            i2 = ~C0404c.m1494a(this.f1407c, this.f1409e, i);
        }
        int i3 = this.f1409e;
        if (i3 >= this.f1407c.length) {
            int a2 = C0404c.m1493a(i3 + 1);
            int[] iArr = new int[a2];
            Object[] objArr2 = new Object[a2];
            int[] iArr2 = this.f1407c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1408d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1407c = iArr;
            this.f1408d = objArr2;
        }
        int i4 = this.f1409e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f1407c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.f1408d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f1409e - i2);
        }
        this.f1407c[i2] = i;
        this.f1408d[i2] = e;
        this.f1409e++;
    }

    /* renamed from: c */
    public int mo2974c(int i) {
        if (this.f1406b) {
            m1547d();
        }
        return this.f1407c[i];
    }

    /* renamed from: c */
    public void mo2975c() {
        int i = this.f1409e;
        Object[] objArr = this.f1408d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1409e = 0;
        this.f1406b = false;
    }

    /* renamed from: c */
    public void mo2976c(int i, E e) {
        int i2 = this.f1409e;
        if (i2 == 0 || i > this.f1407c[i2 - 1]) {
            if (this.f1406b && this.f1409e >= this.f1407c.length) {
                m1547d();
            }
            int i3 = this.f1409e;
            if (i3 >= this.f1407c.length) {
                int a = C0404c.m1493a(i3 + 1);
                int[] iArr = new int[a];
                Object[] objArr = new Object[a];
                int[] iArr2 = this.f1407c;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.f1408d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1407c = iArr;
                this.f1408d = objArr;
            }
            this.f1407c[i3] = i;
            this.f1408d[i3] = e;
            this.f1409e = i3 + 1;
            return;
        }
        mo2973b(i, e);
    }

    /* renamed from: d */
    public E mo2978d(int i) {
        if (this.f1406b) {
            m1547d();
        }
        return this.f1408d[i];
    }

    /* renamed from: e */
    public int mo2979e(int i) {
        if (this.f1406b) {
            m1547d();
        }
        return C0404c.m1494a(this.f1407c, this.f1409e, i);
    }

    public String toString() {
        if (mo2971b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1409e * 28);
        sb.append('{');
        for (int i = 0; i < this.f1409e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(mo2974c(i));
            sb.append('=');
            Object d = mo2978d(i);
            if (d != this) {
                sb.append(d);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
