package androidx.p018c;

/* renamed from: androidx.c.d */
public class C0405d<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f1378a = new Object();

    /* renamed from: b */
    private boolean f1379b;

    /* renamed from: c */
    private long[] f1380c;

    /* renamed from: d */
    private Object[] f1381d;

    /* renamed from: e */
    private int f1382e;

    public C0405d() {
        this(10);
    }

    public C0405d(int i) {
        Object[] objArr;
        this.f1379b = false;
        if (i == 0) {
            this.f1380c = C0404c.f1376b;
            objArr = C0404c.f1377c;
        } else {
            int b = C0404c.m1497b(i);
            this.f1380c = new long[b];
            objArr = new Object[b];
        }
        this.f1381d = objArr;
    }

    /* renamed from: e */
    private void m1499e() {
        int i = this.f1382e;
        long[] jArr = this.f1380c;
        Object[] objArr = this.f1381d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1378a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1379b = false;
        this.f1382e = i2;
    }

    /* renamed from: a */
    public C0405d<E> clone() {
        try {
            C0405d<E> dVar = (C0405d) super.clone();
            dVar.f1380c = (long[]) this.f1380c.clone();
            dVar.f1381d = (Object[]) this.f1381d.clone();
            return dVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a */
    public E mo2846a(long j) {
        return mo2847a(j, (Object) null);
    }

    /* renamed from: a */
    public E mo2847a(long j, E e) {
        int a = C0404c.m1495a(this.f1380c, this.f1382e, j);
        if (a >= 0) {
            E[] eArr = this.f1381d;
            if (eArr[a] != f1378a) {
                return eArr[a];
            }
        }
        return e;
    }

    /* renamed from: a */
    public void mo2848a(int i) {
        Object[] objArr = this.f1381d;
        Object obj = objArr[i];
        Object obj2 = f1378a;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f1379b = true;
        }
    }

    /* renamed from: b */
    public int mo2849b() {
        if (this.f1379b) {
            m1499e();
        }
        return this.f1382e;
    }

    /* renamed from: b */
    public long mo2850b(int i) {
        if (this.f1379b) {
            m1499e();
        }
        return this.f1380c[i];
    }

    @Deprecated
    /* renamed from: b */
    public void mo2851b(long j) {
        mo2854c(j);
    }

    /* renamed from: b */
    public void mo2852b(long j, E e) {
        int a = C0404c.m1495a(this.f1380c, this.f1382e, j);
        if (a >= 0) {
            this.f1381d[a] = e;
            return;
        }
        int i = ~a;
        if (i < this.f1382e) {
            Object[] objArr = this.f1381d;
            if (objArr[i] == f1378a) {
                this.f1380c[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.f1379b && this.f1382e >= this.f1380c.length) {
            m1499e();
            i = ~C0404c.m1495a(this.f1380c, this.f1382e, j);
        }
        int i2 = this.f1382e;
        if (i2 >= this.f1380c.length) {
            int b = C0404c.m1497b(i2 + 1);
            long[] jArr = new long[b];
            Object[] objArr2 = new Object[b];
            long[] jArr2 = this.f1380c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1381d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1380c = jArr;
            this.f1381d = objArr2;
        }
        int i3 = this.f1382e;
        if (i3 - i != 0) {
            long[] jArr3 = this.f1380c;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.f1381d;
            System.arraycopy(objArr4, i, objArr4, i4, this.f1382e - i);
        }
        this.f1380c[i] = j;
        this.f1381d[i] = e;
        this.f1382e++;
    }

    /* renamed from: c */
    public E mo2853c(int i) {
        if (this.f1379b) {
            m1499e();
        }
        return this.f1381d[i];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.f1381d;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo2854c(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.f1380c
            int r1 = r2.f1382e
            int r3 = androidx.p018c.C0404c.m1495a((long[]) r0, (int) r1, (long) r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.f1381d
            r0 = r4[r3]
            java.lang.Object r1 = f1378a
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.f1379b = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p018c.C0405d.mo2854c(long):void");
    }

    /* renamed from: c */
    public void mo2855c(long j, E e) {
        int i = this.f1382e;
        if (i == 0 || j > this.f1380c[i - 1]) {
            if (this.f1379b && this.f1382e >= this.f1380c.length) {
                m1499e();
            }
            int i2 = this.f1382e;
            if (i2 >= this.f1380c.length) {
                int b = C0404c.m1497b(i2 + 1);
                long[] jArr = new long[b];
                Object[] objArr = new Object[b];
                long[] jArr2 = this.f1380c;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.f1381d;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.f1380c = jArr;
                this.f1381d = objArr;
            }
            this.f1380c[i2] = j;
            this.f1381d[i2] = e;
            this.f1382e = i2 + 1;
            return;
        }
        mo2852b(j, e);
    }

    /* renamed from: c */
    public boolean mo2856c() {
        return mo2849b() == 0;
    }

    /* renamed from: d */
    public int mo2858d(long j) {
        if (this.f1379b) {
            m1499e();
        }
        return C0404c.m1495a(this.f1380c, this.f1382e, j);
    }

    /* renamed from: d */
    public void mo2859d() {
        int i = this.f1382e;
        Object[] objArr = this.f1381d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1382e = 0;
        this.f1379b = false;
    }

    public String toString() {
        if (mo2849b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1382e * 28);
        sb.append('{');
        for (int i = 0; i < this.f1382e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(mo2850b(i));
            sb.append('=');
            Object c = mo2853c(i);
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
