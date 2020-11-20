package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.databinding.b */
public class C0708b<C, T, A> implements Cloneable {

    /* renamed from: a */
    private List<C> f2457a;

    /* renamed from: b */
    private long f2458b;

    /* renamed from: c */
    private long[] f2459c;

    /* renamed from: d */
    private int f2460d;

    /* renamed from: e */
    private final C0709a<C, T, A> f2461e;

    /* renamed from: androidx.databinding.b$a */
    public static abstract class C0709a<C, T, A> {
        /* renamed from: a */
        public abstract void mo3979a(C c, T t, int i, A a);
    }

    /* renamed from: a */
    private void m2852a(int i, long j) {
        long j2 = Long.MIN_VALUE;
        for (int i2 = (i + 64) - 1; i2 >= i; i2--) {
            if ((j & j2) != 0) {
                this.f2457a.remove(i2);
            }
            j2 >>>= 1;
        }
    }

    /* renamed from: a */
    private void m2853a(T t, int i, A a, int i2) {
        if (i2 < 0) {
            m2856b(t, i, a);
            return;
        }
        long j = this.f2459c[i2];
        int i3 = (i2 + 1) * 64;
        int min = Math.min(this.f2457a.size(), i3 + 64);
        m2853a(t, i, a, i2 - 1);
        m2854a(t, i, a, i3, min, j);
    }

    /* renamed from: a */
    private void m2854a(T t, int i, A a, int i2, int i3, long j) {
        long j2 = 1;
        while (i2 < i3) {
            if ((j & j2) == 0) {
                this.f2461e.mo3979a(this.f2457a.get(i2), t, i, a);
            }
            j2 <<= 1;
            i2++;
        }
    }

    /* renamed from: a */
    private boolean m2855a(int i) {
        int i2;
        if (i < 64) {
            return ((1 << i) & this.f2458b) != 0;
        }
        long[] jArr = this.f2459c;
        if (jArr == null || (i2 = (i / 64) - 1) >= jArr.length) {
            return false;
        }
        return ((1 << (i % 64)) & jArr[i2]) != 0;
    }

    /* renamed from: b */
    private void m2856b(T t, int i, A a) {
        m2854a(t, i, a, 0, Math.min(64, this.f2457a.size()), this.f2458b);
    }

    /* renamed from: c */
    private void m2857c(T t, int i, A a) {
        int size = this.f2457a.size();
        long[] jArr = this.f2459c;
        int length = jArr == null ? -1 : jArr.length - 1;
        m2853a(t, i, a, length);
        m2854a(t, i, a, (length + 2) * 64, size, 0);
    }

    /* renamed from: a */
    public synchronized C0708b<C, T, A> clone() {
        C0708b<C, T, A> bVar;
        CloneNotSupportedException e;
        try {
            bVar = (C0708b) super.clone();
            try {
                bVar.f2458b = 0;
                bVar.f2459c = null;
                bVar.f2460d = 0;
                bVar.f2457a = new ArrayList();
                int size = this.f2457a.size();
                for (int i = 0; i < size; i++) {
                    if (!m2855a(i)) {
                        bVar.f2457a.add(this.f2457a.get(i));
                    }
                }
            } catch (CloneNotSupportedException e2) {
                e = e2;
                e.printStackTrace();
                return bVar;
            }
        } catch (CloneNotSupportedException e3) {
            CloneNotSupportedException cloneNotSupportedException = e3;
            bVar = null;
            e = cloneNotSupportedException;
            e.printStackTrace();
            return bVar;
        }
        return bVar;
    }

    /* renamed from: a */
    public synchronized void mo3984a(T t, int i, A a) {
        this.f2460d++;
        m2857c(t, i, a);
        this.f2460d--;
        if (this.f2460d == 0) {
            if (this.f2459c != null) {
                for (int length = this.f2459c.length - 1; length >= 0; length--) {
                    long j = this.f2459c[length];
                    if (j != 0) {
                        m2852a((length + 1) * 64, j);
                        this.f2459c[length] = 0;
                    }
                }
            }
            if (this.f2458b != 0) {
                m2852a(0, this.f2458b);
                this.f2458b = 0;
            }
        }
    }
}
