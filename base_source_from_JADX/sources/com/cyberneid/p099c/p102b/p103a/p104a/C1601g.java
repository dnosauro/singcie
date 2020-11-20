package com.cyberneid.p099c.p102b.p103a.p104a;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* renamed from: com.cyberneid.c.b.a.a.g */
public final class C1601g {

    /* renamed from: a */
    private long f4855a;

    /* renamed from: b */
    private int f4856b = 0;

    /* renamed from: c */
    private ArrayList<byte[]> f4857c = new ArrayList<>();

    /* renamed from: c */
    private void m6333c(long j) {
        int size = (((int) (j >> 9)) - this.f4857c.size()) + 1;
        for (int i = 0; i < size; i++) {
            this.f4857c.add(new byte[512]);
        }
        this.f4855a = j + 1;
    }

    /* renamed from: a */
    public int mo7468a(long j) {
        if (j >= this.f4855a) {
            return -1;
        }
        return this.f4857c.get((int) (j >> 9))[(int) (j & 511)] & 255;
    }

    /* renamed from: a */
    public int mo7469a(InputStream inputStream, int i) {
        if (i <= 0) {
            return 0;
        }
        long j = this.f4855a;
        m6333c((((long) i) + j) - 1);
        int i2 = (int) (j >> 9);
        int i3 = (int) (j & 511);
        int i4 = 0;
        while (i > 0) {
            byte[] bArr = this.f4857c.get(i2);
            int min = Math.min(512 - i3, i);
            i -= min;
            i4 += min;
            while (min > 0) {
                int read = inputStream.read(bArr, i3, min);
                if (read < 0) {
                    this.f4855a -= (long) (i - i4);
                    return i4;
                }
                min -= read;
                i3 += read;
            }
            i2++;
            i3 = 0;
        }
        return i4;
    }

    /* renamed from: a */
    public long mo7470a() {
        return this.f4855a;
    }

    /* renamed from: a */
    public void mo7471a(int i, long j) {
        if (j >= this.f4855a) {
            m6333c(j);
        }
        this.f4857c.get((int) (j >> 9))[(int) (j & 511)] = (byte) i;
    }

    /* renamed from: a */
    public void mo7472a(OutputStream outputStream, int i, long j) {
        if (((long) i) + j <= this.f4855a) {
            int i2 = (int) (j >> 9);
            int i3 = (int) (j & 511);
            if (i2 >= this.f4856b) {
                while (i > 0) {
                    int min = Math.min(512 - i3, i);
                    outputStream.write(this.f4857c.get(i2), i3, min);
                    i2++;
                    i3 = 0;
                    i -= min;
                }
                return;
            }
            throw new IndexOutOfBoundsException("The requested data are already disposed");
        }
        throw new IndexOutOfBoundsException("Argument out of cache");
    }

    /* renamed from: a */
    public void mo7473a(byte[] bArr, int i, int i2, long j) {
        if (i2 > bArr.length - i || i2 < 0 || i < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 != 0) {
            long j2 = (((long) i2) + j) - 1;
            if (j2 >= this.f4855a) {
                m6333c(j2);
            }
            while (i2 > 0) {
                int i3 = (int) (511 & j);
                int min = Math.min(512 - i3, i2);
                System.arraycopy(bArr, i, this.f4857c.get((int) (j >> 9)), i3, min);
                j += (long) min;
                i2 -= min;
                i += min;
            }
        }
    }

    /* renamed from: b */
    public int mo7474b(byte[] bArr, int i, int i2, long j) {
        if (i2 > bArr.length - i || i2 < 0 || i < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            long j2 = this.f4855a;
            if (j >= j2) {
                return -1;
            }
            if (((long) i2) + j > j2) {
                i2 = (int) (j2 - j);
            }
            int i3 = (int) (j & 511);
            int min = Math.min(i2, 512 - i3);
            System.arraycopy(this.f4857c.get((int) (j >> 9)), i3, bArr, i, min);
            return min;
        }
    }

    /* renamed from: b */
    public void mo7475b() {
        this.f4857c.clear();
        this.f4855a = 0;
    }

    /* renamed from: b */
    public void mo7476b(long j) {
        int i = (int) (j >> 9);
        int i2 = this.f4856b;
        if (i > i2) {
            while (i2 < i) {
                this.f4857c.set(i2, (Object) null);
                i2++;
            }
            this.f4856b = i;
        }
    }
}
