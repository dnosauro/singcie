package com.cyberneid.p105d.p111d;

import java.io.EOFException;
import java.io.IOException;

/* renamed from: com.cyberneid.d.d.k */
class C1665k implements C1656c {

    /* renamed from: a */
    private final int f5500a;

    /* renamed from: b */
    private C1664j f5501b;

    /* renamed from: c */
    private long f5502c = 0;

    /* renamed from: d */
    private int f5503d;

    /* renamed from: e */
    private long f5504e;

    /* renamed from: f */
    private byte[] f5505f;

    /* renamed from: g */
    private int f5506g;

    /* renamed from: h */
    private boolean f5507h = false;

    /* renamed from: i */
    private int[] f5508i = new int[16];

    /* renamed from: j */
    private int f5509j = 0;

    C1665k(C1664j jVar) {
        jVar.mo7739c();
        this.f5501b = jVar;
        this.f5500a = this.f5501b.mo7738b();
        m6685f();
    }

    /* renamed from: a */
    private void m6683a() {
        C1664j jVar = this.f5501b;
        if (jVar != null) {
            jVar.mo7739c();
            return;
        }
        throw new IOException("Buffer already closed");
    }

    /* renamed from: a */
    private boolean m6684a(boolean z) {
        if (this.f5506g >= this.f5500a) {
            if (this.f5507h) {
                this.f5501b.mo7735a(this.f5508i[this.f5503d], this.f5505f);
                this.f5507h = false;
            }
            int i = this.f5503d;
            if (i + 1 < this.f5509j) {
                C1664j jVar = this.f5501b;
                int[] iArr = this.f5508i;
                int i2 = i + 1;
                this.f5503d = i2;
                this.f5505f = jVar.mo7737a(iArr[i2]);
                this.f5504e = ((long) this.f5503d) * ((long) this.f5500a);
                this.f5506g = 0;
            } else if (!z) {
                return false;
            } else {
                m6685f();
            }
        }
        return true;
    }

    /* renamed from: f */
    private void m6685f() {
        int i = this.f5509j + 1;
        int[] iArr = this.f5508i;
        if (i >= iArr.length) {
            int length = iArr.length * 2;
            if (length < iArr.length) {
                if (iArr.length != Integer.MAX_VALUE) {
                    length = Integer.MAX_VALUE;
                } else {
                    throw new IOException("Maximum buffer size reached.");
                }
            }
            int[] iArr2 = new int[length];
            System.arraycopy(this.f5508i, 0, iArr2, 0, this.f5509j);
            this.f5508i = iArr2;
        }
        int a = this.f5501b.mo7734a();
        int[] iArr3 = this.f5508i;
        int i2 = this.f5509j;
        iArr3[i2] = a;
        this.f5503d = i2;
        int i3 = this.f5500a;
        this.f5504e = ((long) i2) * ((long) i3);
        this.f5509j = i2 + 1;
        this.f5505f = new byte[i3];
        this.f5506g = 0;
    }

    /* renamed from: a */
    public void mo7705a(int i) {
        m6683a();
        m6684a(true);
        byte[] bArr = this.f5505f;
        int i2 = this.f5506g;
        this.f5506g = i2 + 1;
        bArr[i2] = (byte) i;
        this.f5507h = true;
        long j = this.f5504e;
        int i3 = this.f5506g;
        if (((long) i3) + j > this.f5502c) {
            this.f5502c = j + ((long) i3);
        }
    }

    /* renamed from: a */
    public void mo7706a(long j) {
        m6683a();
        if (j > this.f5502c) {
            throw new EOFException();
        } else if (j >= 0) {
            long j2 = this.f5504e;
            if (j < j2 || j > ((long) this.f5500a) + j2) {
                if (this.f5507h) {
                    this.f5501b.mo7735a(this.f5508i[this.f5503d], this.f5505f);
                    this.f5507h = false;
                }
                int i = (int) (j / ((long) this.f5500a));
                this.f5505f = this.f5501b.mo7737a(this.f5508i[i]);
                this.f5503d = i;
                this.f5504e = ((long) this.f5503d) * ((long) this.f5500a);
                j2 = this.f5504e;
            }
            this.f5506g = (int) (j - j2);
        } else {
            throw new IOException("Negative seek offset: " + j);
        }
    }

    /* renamed from: a */
    public void mo7707a(byte[] bArr) {
        mo7708a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void mo7708a(byte[] bArr, int i, int i2) {
        m6683a();
        while (i2 > 0) {
            m6684a(true);
            int min = Math.min(i2, this.f5500a - this.f5506g);
            System.arraycopy(bArr, i, this.f5505f, this.f5506g, min);
            this.f5506g += min;
            this.f5507h = true;
            i += min;
            i2 -= min;
        }
        long j = this.f5504e;
        int i3 = this.f5506g;
        if (((long) i3) + j > this.f5502c) {
            this.f5502c = j + ((long) i3);
        }
    }

    /* renamed from: b */
    public long mo7709b() {
        m6683a();
        return this.f5504e + ((long) this.f5506g);
    }

    /* renamed from: b */
    public void mo7710b(int i) {
        mo7706a((this.f5504e + ((long) this.f5506g)) - ((long) i));
    }

    /* renamed from: c */
    public long mo7711c() {
        return this.f5502c;
    }

    /* renamed from: c */
    public byte[] mo7712c(int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        do {
            int read = read(bArr, i2, i - i2);
            if (read >= 0) {
                i2 += read;
            } else {
                throw new EOFException();
            }
        } while (i2 < i);
        return bArr;
    }

    public void close() {
        C1664j jVar = this.f5501b;
        if (jVar != null) {
            jVar.mo7736a(this.f5508i, 0, this.f5509j);
            this.f5501b = null;
            this.f5508i = null;
            this.f5505f = null;
            this.f5504e = 0;
            this.f5503d = -1;
            this.f5506g = 0;
            this.f5502c = 0;
        }
    }

    /* renamed from: d */
    public boolean mo7715d() {
        return this.f5501b == null;
    }

    /* renamed from: e */
    public boolean mo7716e() {
        m6683a();
        return this.f5504e + ((long) this.f5506g) >= this.f5502c;
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
        m6683a();
        if (this.f5504e + ((long) this.f5506g) >= this.f5502c) {
            return -1;
        }
        if (m6684a(false)) {
            byte[] bArr = this.f5505f;
            int i = this.f5506g;
            this.f5506g = i + 1;
            return bArr[i] & 255;
        }
        throw new IOException("Unexpectedly no bytes available for read in buffer.");
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        m6683a();
        long j = this.f5504e;
        int i3 = this.f5506g;
        long j2 = this.f5502c;
        if (((long) i3) + j >= j2) {
            return -1;
        }
        int min = (int) Math.min((long) i2, j2 - (j + ((long) i3)));
        int i4 = i;
        int i5 = 0;
        while (min > 0) {
            if (m6684a(false)) {
                int min2 = Math.min(min, this.f5500a - this.f5506g);
                System.arraycopy(this.f5505f, this.f5506g, bArr, i4, min2);
                this.f5506g += min2;
                i5 += min2;
                i4 += min2;
                min -= min2;
            } else {
                throw new IOException("Unexpectedly no bytes available for read in buffer.");
            }
        }
        return i5;
    }
}
