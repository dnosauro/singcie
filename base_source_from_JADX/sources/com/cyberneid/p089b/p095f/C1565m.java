package com.cyberneid.p089b.p095f;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import org.spongycastle.asn1.cmc.BodyPartID;

/* renamed from: com.cyberneid.b.f.m */
class C1565m extends C1575w {

    /* renamed from: a */
    private byte[] f4681a = null;

    /* renamed from: b */
    private int f4682b = 0;

    C1565m(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            this.f4681a = byteArrayOutputStream.toByteArray();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /* renamed from: a */
    public int mo7275a(byte[] bArr, int i, int i2) {
        int i3 = this.f4682b;
        byte[] bArr2 = this.f4681a;
        if (i3 >= bArr2.length) {
            return -1;
        }
        int min = Math.min(i2, bArr2.length - i3);
        System.arraycopy(this.f4681a, this.f4682b, bArr, i, min);
        this.f4682b += min;
        return min;
    }

    /* renamed from: a */
    public long mo7276a() {
        return (((long) mo7278b()) << 32) + (((long) mo7278b()) & BodyPartID.bodyIdMax);
    }

    /* renamed from: a */
    public void mo7277a(long j) {
        this.f4682b = (int) j;
    }

    /* renamed from: b */
    public int mo7278b() {
        int c = mo7279c();
        int c2 = mo7279c();
        int c3 = mo7279c();
        int c4 = mo7279c();
        if ((c | c2 | c3 | c4) >= 0) {
            return (c << 24) + (c2 << 16) + (c3 << 8) + (c4 << 0);
        }
        throw new EOFException();
    }

    /* renamed from: c */
    public int mo7279c() {
        int i = this.f4682b;
        byte[] bArr = this.f4681a;
        if (i >= bArr.length) {
            return -1;
        }
        byte b = bArr[i];
        this.f4682b = i + 1;
        return (b + 256) % 256;
    }

    public void close() {
        this.f4681a = null;
    }

    /* renamed from: d */
    public int mo7281d() {
        int c = mo7279c();
        int c2 = mo7279c();
        if ((c | c2) >= 0) {
            return (c << 8) + (c2 << 0);
        }
        throw new EOFException();
    }

    /* renamed from: e */
    public short mo7282e() {
        int c = mo7279c();
        int c2 = mo7279c();
        if ((c | c2) >= 0) {
            return (short) ((c << 8) + (c2 << 0));
        }
        throw new EOFException();
    }

    /* renamed from: f */
    public long mo7283f() {
        return (long) this.f4682b;
    }

    /* renamed from: g */
    public InputStream mo7284g() {
        return new ByteArrayInputStream(this.f4681a);
    }
}
