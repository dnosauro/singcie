package com.cyberneid.p105d.p114g.p118b;

import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.g.b.l */
class C1777l {

    /* renamed from: a */
    private final int[] f5757a = new int[256];

    /* renamed from: b */
    private int f5758b;

    /* renamed from: c */
    private int f5759c;

    C1777l() {
    }

    /* renamed from: a */
    private static int m7140a(byte b) {
        return b < 0 ? b + 256 : b;
    }

    /* renamed from: a */
    private static void m7141a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    /* renamed from: a */
    public void mo8026a(byte b, OutputStream outputStream) {
        this.f5758b = (this.f5758b + 1) % 256;
        int[] iArr = this.f5757a;
        int i = this.f5758b;
        this.f5759c = (iArr[i] + this.f5759c) % 256;
        m7141a(iArr, i, this.f5759c);
        int[] iArr2 = this.f5757a;
        outputStream.write(b ^ ((byte) iArr2[(iArr2[this.f5758b] + iArr2[this.f5759c]) % 256]));
    }

    /* renamed from: a */
    public void mo8027a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                mo8029a(bArr, 0, read, outputStream);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public void mo8028a(byte[] bArr) {
        this.f5758b = 0;
        this.f5759c = 0;
        if (bArr.length < 1 || bArr.length > 32) {
            throw new IllegalArgumentException("number of bytes must be between 1 and 32");
        }
        int i = 0;
        while (true) {
            int[] iArr = this.f5757a;
            if (i >= iArr.length) {
                break;
            }
            iArr[i] = i;
            i++;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f5757a.length; i4++) {
            int a = m7140a(bArr[i2]);
            int[] iArr2 = this.f5757a;
            i3 = ((a + iArr2[i4]) + i3) % 256;
            m7141a(iArr2, i4, i3);
            i2 = (i2 + 1) % bArr.length;
        }
    }

    /* renamed from: a */
    public void mo8029a(byte[] bArr, int i, int i2, OutputStream outputStream) {
        for (int i3 = i; i3 < i + i2; i3++) {
            mo8026a(bArr[i3], outputStream);
        }
    }

    /* renamed from: a */
    public void mo8030a(byte[] bArr, OutputStream outputStream) {
        for (byte a : bArr) {
            mo8026a(a, outputStream);
        }
    }
}
