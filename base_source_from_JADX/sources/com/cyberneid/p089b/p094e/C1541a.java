package com.cyberneid.p089b.p094e;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.cyberneid.b.e.a */
public class C1541a {

    /* renamed from: a */
    private static final int[] f4566a = {1, 2, 1};

    /* renamed from: b */
    private byte[] f4567b;

    /* renamed from: c */
    private int[] f4568c;

    public C1541a(InputStream inputStream) {
        m5924a(m5925a(inputStream));
    }

    public C1541a(byte[] bArr) {
        m5924a(bArr);
    }

    /* renamed from: a */
    private void m5924a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        this.f4567b = new byte[(bArr.length - 18)];
        this.f4568c = new int[f4566a.length];
        int i = 0;
        int i2 = 0;
        while (i < f4566a.length) {
            if (byteArrayInputStream.read() != 128) {
                throw new IOException("Start marker missing");
            } else if (byteArrayInputStream.read() == f4566a[i]) {
                int read = byteArrayInputStream.read() + (byteArrayInputStream.read() << 8) + (byteArrayInputStream.read() << 16) + (byteArrayInputStream.read() << 24);
                this.f4568c[i] = read;
                int read2 = byteArrayInputStream.read(this.f4567b, i2, read);
                if (read2 >= 0) {
                    i2 += read2;
                    i++;
                } else {
                    throw new EOFException();
                }
            } else {
                throw new IOException("Incorrect record type");
            }
        }
    }

    /* renamed from: a */
    private byte[] m5925a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[65535];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: a */
    public byte[] mo7172a() {
        return Arrays.copyOfRange(this.f4567b, 0, this.f4568c[0]);
    }

    /* renamed from: b */
    public byte[] mo7173b() {
        byte[] bArr = this.f4567b;
        int[] iArr = this.f4568c;
        return Arrays.copyOfRange(bArr, iArr[0], iArr[0] + iArr[1]);
    }
}
