package com.cyberneid.p105d.p111d;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cyberneid.d.d.d */
public class C1657d implements C1656c, Cloneable {

    /* renamed from: a */
    private int f5462a;

    /* renamed from: b */
    private List<byte[]> f5463b;

    /* renamed from: c */
    private byte[] f5464c;

    /* renamed from: d */
    private long f5465d;

    /* renamed from: e */
    private int f5466e;

    /* renamed from: f */
    private long f5467f;

    /* renamed from: g */
    private int f5468g;

    /* renamed from: h */
    private int f5469h;

    public C1657d() {
        this.f5462a = 1024;
        this.f5463b = null;
        this.f5463b = new ArrayList();
        this.f5464c = new byte[this.f5462a];
        this.f5463b.add(this.f5464c);
        this.f5465d = 0;
        this.f5466e = 0;
        this.f5467f = 0;
        this.f5468g = 0;
        this.f5469h = 0;
    }

    public C1657d(byte[] bArr) {
        this.f5462a = 1024;
        this.f5463b = null;
        this.f5463b = new ArrayList(1);
        this.f5462a = bArr.length;
        this.f5464c = bArr;
        this.f5463b.add(this.f5464c);
        this.f5465d = 0;
        this.f5466e = 0;
        this.f5467f = (long) this.f5462a;
        this.f5468g = 0;
        this.f5469h = 0;
    }

    /* renamed from: b */
    private int m6633b(byte[] bArr, int i, int i2) {
        long j = this.f5465d;
        long j2 = this.f5467f;
        if (j >= j2) {
            return 0;
        }
        int min = (int) Math.min((long) i2, j2 - j);
        int i3 = this.f5462a;
        int i4 = this.f5466e;
        int i5 = i3 - i4;
        if (i5 == 0) {
            return 0;
        }
        if (min >= i5) {
            System.arraycopy(this.f5464c, i4, bArr, i, i5);
            this.f5466e += i5;
            this.f5465d += (long) i5;
            return i5;
        }
        System.arraycopy(this.f5464c, i4, bArr, i, min);
        this.f5466e += min;
        this.f5465d += (long) min;
        return min;
    }

    /* renamed from: h */
    private void m6634h() {
        if (this.f5469h > this.f5468g) {
            m6635i();
            return;
        }
        this.f5464c = new byte[this.f5462a];
        this.f5463b.add(this.f5464c);
        this.f5466e = 0;
        this.f5469h++;
        this.f5468g++;
    }

    /* renamed from: i */
    private void m6635i() {
        int i = this.f5468g;
        if (i != this.f5469h) {
            this.f5466e = 0;
            List<byte[]> list = this.f5463b;
            int i2 = i + 1;
            this.f5468g = i2;
            this.f5464c = list.get(i2);
            return;
        }
        throw new IOException("No more chunks available, end of buffer reached");
    }

    /* renamed from: j */
    private void m6636j() {
        if (this.f5464c == null) {
            throw new IOException("RandomAccessBuffer already closed");
        }
    }

    /* renamed from: a */
    public C1657d clone() {
        byte[] bArr;
        C1657d dVar = new C1657d();
        dVar.f5463b = new ArrayList(this.f5463b.size());
        for (byte[] next : this.f5463b) {
            byte[] bArr2 = new byte[next.length];
            System.arraycopy(next, 0, bArr2, 0, next.length);
            dVar.f5463b.add(bArr2);
        }
        if (this.f5464c != null) {
            List<byte[]> list = dVar.f5463b;
            bArr = list.get(list.size() - 1);
        } else {
            bArr = null;
        }
        dVar.f5464c = bArr;
        dVar.f5465d = this.f5465d;
        dVar.f5466e = this.f5466e;
        dVar.f5467f = this.f5467f;
        dVar.f5468g = this.f5468g;
        dVar.f5469h = this.f5469h;
        return dVar;
    }

    /* renamed from: a */
    public void mo7705a(int i) {
        m6636j();
        int i2 = this.f5466e;
        int i3 = this.f5462a;
        if (i2 >= i3) {
            if (this.f5465d + ((long) i3) < 2147483647L) {
                m6634h();
            } else {
                throw new IOException("RandomAccessBuffer overflow");
            }
        }
        byte[] bArr = this.f5464c;
        int i4 = this.f5466e;
        this.f5466e = i4 + 1;
        bArr[i4] = (byte) i;
        this.f5465d++;
        long j = this.f5465d;
        if (j > this.f5467f) {
            this.f5467f = j;
        }
        int i5 = this.f5466e;
        int i6 = this.f5462a;
        if (i5 < i6) {
            return;
        }
        if (this.f5465d + ((long) i6) < 2147483647L) {
            m6634h();
            return;
        }
        throw new IOException("RandomAccessBuffer overflow");
    }

    /* renamed from: a */
    public void mo7706a(long j) {
        m6636j();
        if (j >= 0) {
            this.f5465d = j;
            long j2 = this.f5465d;
            if (j2 < this.f5467f) {
                int i = this.f5462a;
                this.f5468g = (int) (j2 / ((long) i));
                this.f5466e = (int) (j2 % ((long) i));
                this.f5464c = this.f5463b.get(this.f5468g);
                return;
            }
            this.f5468g = this.f5469h;
            this.f5464c = this.f5463b.get(this.f5468g);
            this.f5466e = (int) (this.f5467f % ((long) this.f5462a));
            return;
        }
        throw new IOException("Invalid position " + j);
    }

    /* renamed from: a */
    public void mo7707a(byte[] bArr) {
        mo7708a(bArr, 0, bArr.length);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7708a(byte[] r10, int r11, int r12) {
        /*
            r9 = this;
            r9.m6636j()
            long r0 = r9.f5465d
            long r2 = (long) r12
            long r0 = r0 + r2
            int r4 = r9.f5462a
            int r5 = r9.f5466e
            int r4 = r4 - r5
            if (r12 < r4) goto L_0x005a
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x0052
            byte[] r0 = r9.f5464c
            java.lang.System.arraycopy(r10, r11, r0, r5, r4)
            int r11 = r11 + r4
            int r12 = r12 - r4
            long r0 = (long) r12
            int r12 = (int) r0
            int r4 = r9.f5462a
            int r12 = r12 / r4
            r4 = 0
        L_0x0022:
            if (r4 >= r12) goto L_0x0036
            r9.m6634h()
            byte[] r5 = r9.f5464c
            int r6 = r9.f5466e
            int r7 = r9.f5462a
            java.lang.System.arraycopy(r10, r11, r5, r6, r7)
            int r5 = r9.f5462a
            int r11 = r11 + r5
            int r4 = r4 + 1
            goto L_0x0022
        L_0x0036:
            long r4 = (long) r12
            int r12 = r9.f5462a
            long r6 = (long) r12
            long r4 = r4 * r6
            long r0 = r0 - r4
            r4 = 0
            int r12 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r12 < 0) goto L_0x0064
            r9.m6634h()
            if (r12 <= 0) goto L_0x0050
            byte[] r12 = r9.f5464c
            int r4 = r9.f5466e
            int r5 = (int) r0
            java.lang.System.arraycopy(r10, r11, r12, r4, r5)
        L_0x0050:
            int r10 = (int) r0
            goto L_0x0062
        L_0x0052:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "RandomAccessBuffer overflow"
            r10.<init>(r11)
            throw r10
        L_0x005a:
            byte[] r0 = r9.f5464c
            java.lang.System.arraycopy(r10, r11, r0, r5, r12)
            int r10 = r9.f5466e
            int r10 = r10 + r12
        L_0x0062:
            r9.f5466e = r10
        L_0x0064:
            long r10 = r9.f5465d
            long r10 = r10 + r2
            r9.f5465d = r10
            long r10 = r9.f5465d
            long r0 = r9.f5467f
            int r12 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r12 <= 0) goto L_0x0073
            r9.f5467f = r10
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p111d.C1657d.mo7708a(byte[], int, int):void");
    }

    /* renamed from: b */
    public long mo7709b() {
        m6636j();
        return this.f5465d;
    }

    /* renamed from: b */
    public void mo7710b(int i) {
        m6636j();
        mo7706a(mo7709b() - ((long) i));
    }

    /* renamed from: c */
    public long mo7711c() {
        m6636j();
        return this.f5467f;
    }

    /* renamed from: c */
    public byte[] mo7712c(int i) {
        byte[] bArr = new byte[i];
        int read = read(bArr);
        while (read < i) {
            read += read(bArr, read, i - read);
        }
        return bArr;
    }

    public void close() {
        this.f5464c = null;
        this.f5463b.clear();
        this.f5465d = 0;
        this.f5466e = 0;
        this.f5467f = 0;
        this.f5468g = 0;
    }

    /* renamed from: d */
    public boolean mo7715d() {
        return this.f5464c == null;
    }

    /* renamed from: e */
    public boolean mo7716e() {
        m6636j();
        return this.f5465d >= this.f5467f;
    }

    /* renamed from: f */
    public int mo7717f() {
        return (int) Math.min(mo7711c() - mo7709b(), 2147483647L);
    }

    /* renamed from: g */
    public int mo7718g() {
        int read = read();
        if (read != -1) {
            mo7710b(1);
        }
        return read;
    }

    public int read() {
        m6636j();
        if (this.f5465d >= this.f5467f) {
            return -1;
        }
        if (this.f5466e >= this.f5462a) {
            int i = this.f5468g;
            if (i >= this.f5469h) {
                return -1;
            }
            List<byte[]> list = this.f5463b;
            int i2 = i + 1;
            this.f5468g = i2;
            this.f5464c = list.get(i2);
            this.f5466e = 0;
        }
        this.f5465d++;
        byte[] bArr = this.f5464c;
        int i3 = this.f5466e;
        this.f5466e = i3 + 1;
        return bArr[i3] & 255;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        m6636j();
        if (this.f5465d >= this.f5467f) {
            return 0;
        }
        int b = m6633b(bArr, i, i2);
        while (b < i2 && mo7717f() > 0) {
            b += m6633b(bArr, i + b, i2 - b);
            if (this.f5466e == this.f5462a) {
                m6635i();
            }
        }
        return b;
    }
}
