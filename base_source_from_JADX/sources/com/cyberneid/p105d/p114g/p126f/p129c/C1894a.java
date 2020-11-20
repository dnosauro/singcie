package com.cyberneid.p105d.p114g.p126f.p129c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;

/* renamed from: com.cyberneid.d.g.f.c.a */
public class C1894a extends FilterInputStream {

    /* renamed from: a */
    private final int[] f6041a;

    /* renamed from: b */
    private long f6042b = 0;

    public C1894a(byte[] bArr, int[] iArr) {
        super(new ByteArrayInputStream(bArr));
        this.f6041a = iArr;
    }

    /* renamed from: b */
    private boolean m7803b() {
        long j = this.f6042b;
        int i = 0;
        while (true) {
            int[] iArr = this.f6041a;
            if (i >= iArr.length / 2) {
                return false;
            }
            int i2 = i * 2;
            if (((long) iArr[i2]) <= j && ((long) (iArr[i2] + iArr[i2 + 1])) > j) {
                return true;
            }
            i++;
        }
    }

    /* renamed from: c */
    private void m7804c() {
        while (!m7803b()) {
            this.f6042b++;
            if (super.read() < 0) {
                return;
            }
        }
    }

    /* renamed from: a */
    public byte[] mo8360a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public int read() {
        m7804c();
        int read = super.read();
        if (read > -1) {
            this.f6042b++;
        }
        return read;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int read = read();
        if (read == -1) {
            return -1;
        }
        bArr[i] = (byte) read;
        int i3 = 1;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            try {
                int read2 = read();
                if (read2 == -1) {
                    break;
                }
                bArr[i + i3] = (byte) read2;
                i3++;
            } catch (IOException unused) {
            }
        }
        return i3;
    }
}
