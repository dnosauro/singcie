package com.cyberneid.p105d.p109c;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.cyberneid.d.c.b */
final class C1640b extends FilterInputStream {

    /* renamed from: a */
    private int f5440a = 0;

    /* renamed from: b */
    private int f5441b = 0;

    /* renamed from: c */
    private boolean f5442c = false;

    /* renamed from: d */
    private byte[] f5443d = new byte[5];

    /* renamed from: e */
    private byte[] f5444e = new byte[4];

    C1640b(InputStream inputStream) {
        super(inputStream);
    }

    public int available() {
        return 0;
    }

    public void close() {
        this.f5443d = null;
        this.f5442c = true;
        this.f5444e = null;
        super.close();
    }

    public void mark(int i) {
    }

    public boolean markSupported() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0069, code lost:
        r13 = r14.f5443d;
        r13[r2] = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006d, code lost:
        if (r12 != 126) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006f, code lost:
        r13[r2] = 117;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read() {
        /*
            r14 = this;
            int r0 = r14.f5440a
            int r1 = r14.f5441b
            if (r0 < r1) goto L_0x00cf
            boolean r0 = r14.f5442c
            r1 = -1
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            r0 = 0
            r14.f5440a = r0
        L_0x000f:
            java.io.InputStream r2 = r14.in
            int r2 = r2.read()
            byte r2 = (byte) r2
            r3 = 1
            if (r2 != r1) goto L_0x001c
            r14.f5442c = r3
            return r1
        L_0x001c:
            byte r2 = (byte) r2
            r4 = 10
            if (r2 == r4) goto L_0x000f
            r5 = 13
            if (r2 == r5) goto L_0x000f
            r6 = 32
            if (r2 == r6) goto L_0x000f
            r7 = 126(0x7e, float:1.77E-43)
            r8 = 0
            if (r2 != r7) goto L_0x0037
            r14.f5442c = r3
            r14.f5444e = r8
            r14.f5443d = r8
            r14.f5441b = r0
            return r1
        L_0x0037:
            r9 = 122(0x7a, float:1.71E-43)
            r10 = 3
            if (r2 != r9) goto L_0x004c
            byte[] r1 = r14.f5444e
            r2 = 2
            r1[r10] = r0
            r1[r2] = r0
            r1[r3] = r0
            r1[r0] = r0
            r0 = 4
            r14.f5441b = r0
            goto L_0x00cf
        L_0x004c:
            byte[] r9 = r14.f5443d
            r9[r0] = r2
            r2 = 1
        L_0x0051:
            r9 = 117(0x75, float:1.64E-43)
            r11 = 5
            if (r2 >= r11) goto L_0x0075
        L_0x0056:
            java.io.InputStream r12 = r14.in
            int r12 = r12.read()
            byte r12 = (byte) r12
            if (r12 != r1) goto L_0x0062
            r14.f5442c = r3
            return r1
        L_0x0062:
            byte r12 = (byte) r12
            if (r12 == r4) goto L_0x0056
            if (r12 == r5) goto L_0x0056
            if (r12 == r6) goto L_0x0056
            byte[] r13 = r14.f5443d
            r13[r2] = r12
            if (r12 != r7) goto L_0x0072
            r13[r2] = r9
            goto L_0x0075
        L_0x0072:
            int r2 = r2 + 1
            goto L_0x0051
        L_0x0075:
            int r4 = r2 + -1
            r14.f5441b = r4
            int r4 = r14.f5441b
            if (r4 != 0) goto L_0x0084
            r14.f5442c = r3
            r14.f5443d = r8
            r14.f5444e = r8
            return r1
        L_0x0084:
            if (r2 >= r11) goto L_0x0092
            int r2 = r2 + r3
        L_0x0087:
            if (r2 >= r11) goto L_0x0090
            byte[] r1 = r14.f5443d
            r1[r2] = r9
            int r2 = r2 + 1
            goto L_0x0087
        L_0x0090:
            r14.f5442c = r3
        L_0x0092:
            r1 = 0
            r4 = r1
            r1 = 0
        L_0x0096:
            if (r1 >= r11) goto L_0x00be
            byte[] r2 = r14.f5443d
            byte r2 = r2[r1]
            int r2 = r2 + -33
            byte r2 = (byte) r2
            if (r2 < 0) goto L_0x00ae
            r6 = 93
            if (r2 > r6) goto L_0x00ae
            r6 = 85
            long r4 = r4 * r6
            long r6 = (long) r2
            long r4 = r4 + r6
            int r1 = r1 + 1
            goto L_0x0096
        L_0x00ae:
            r14.f5441b = r0
            r14.f5442c = r3
            r14.f5443d = r8
            r14.f5444e = r8
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Invalid data in Ascii85 stream"
            r0.<init>(r1)
            throw r0
        L_0x00be:
            if (r10 < 0) goto L_0x00cf
            byte[] r0 = r14.f5444e
            r1 = 255(0xff, double:1.26E-321)
            long r1 = r1 & r4
            int r2 = (int) r1
            byte r1 = (byte) r2
            r0[r10] = r1
            r0 = 8
            long r4 = r4 >>> r0
            int r10 = r10 + -1
            goto L_0x00be
        L_0x00cf:
            byte[] r0 = r14.f5444e
            int r1 = r14.f5440a
            int r2 = r1 + 1
            r14.f5440a = r2
            byte r0 = r0[r1]
            r0 = r0 & 255(0xff, float:3.57E-43)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p109c.C1640b.read():int");
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.f5442c && this.f5440a >= this.f5441b) {
            return -1;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f5440a;
            if (i4 < this.f5441b) {
                byte[] bArr2 = this.f5444e;
                this.f5440a = i4 + 1;
                bArr[i3 + i] = bArr2[i4];
            } else {
                int read = read();
                if (read == -1) {
                    return i3;
                }
                bArr[i3 + i] = (byte) read;
            }
        }
        return i2;
    }

    public void reset() {
        throw new IOException("Reset is not supported");
    }

    public long skip(long j) {
        return 0;
    }
}
