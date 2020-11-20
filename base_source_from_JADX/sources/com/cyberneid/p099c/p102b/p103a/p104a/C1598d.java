package com.cyberneid.p099c.p102b.p103a.p104a;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.ByteOrder;

/* renamed from: com.cyberneid.c.b.a.a.d */
public abstract class C1598d extends C1594b implements C1597c {

    /* renamed from: e */
    private final byte[] f4850e = new byte[8];

    /* renamed from: a */
    public void mo7451a(long j, int i) {
        mo7424b();
        if (this.f4843d > 0) {
            int i2 = this.f4843d;
            int d = mo7428d();
            if (d == -1) {
                d = 0;
            } else {
                mo7425b(mo7429e() - 1);
            }
            int i3 = 8 - i2;
            if (i >= i3) {
                int i4 = -1 >>> (32 - i3);
                i -= i3;
                write((int) ((((long) i4) & (j >> i)) | ((long) ((~i4) & d))));
            } else {
                int i5 = i2 + i;
                int i6 = -1 >>> i;
                int i7 = 8 - i5;
                write((int) (((((long) i6) & j) << i7) | ((long) (d & (~(i6 << i7))))));
                mo7425b(mo7429e() - 1);
                this.f4843d = i5;
                i = 0;
            }
        }
        while (i > 7) {
            write((int) (((long) 255) & (j >> (i - 8))));
            i -= 8;
        }
        if (i > 0) {
            write((int) ((j << (8 - i)) & ((long) 255)));
            mo7425b(mo7429e() - 1);
            this.f4843d = i;
        }
    }

    /* renamed from: a */
    public void mo7452a(char[] cArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > cArr.length) {
            throw new IndexOutOfBoundsException();
        }
        for (int i3 = 0; i3 < i2; i3++) {
            writeShort(cArr[i + i3]);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public final void mo7453k() {
        mo7424b();
        if (this.f4843d != 0) {
            int i = this.f4843d;
            int d = mo7428d();
            int i2 = 0;
            if (d == -1) {
                this.f4843d = 0;
            } else {
                mo7425b(mo7429e() - 1);
                i2 = d & (-1 << (8 - i));
            }
            write(i2);
        }
    }

    public abstract void write(int i);

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public abstract void write(byte[] bArr, int i, int i2);

    public void writeBoolean(boolean z) {
        write(z ? 1 : 0);
    }

    public void writeByte(int i) {
        write(i);
    }

    public void writeBytes(String str) {
        write(str.getBytes());
    }

    public void writeChar(int i) {
        writeShort(i);
    }

    public void writeChars(String str) {
        char[] charArray = str.toCharArray();
        mo7452a(charArray, 0, charArray.length);
    }

    public void writeDouble(double d) {
        writeLong(Double.doubleToLongBits(d));
    }

    public void writeFloat(float f) {
        writeInt(Float.floatToIntBits(f));
    }

    public void writeInt(int i) {
        if (this.f4840a == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.f4850e;
            bArr[0] = (byte) (i >> 24);
            bArr[1] = (byte) (i >> 16);
            bArr[2] = (byte) (i >> 8);
            bArr[3] = (byte) i;
        } else {
            byte[] bArr2 = this.f4850e;
            bArr2[3] = (byte) (i >> 24);
            bArr2[2] = (byte) (i >> 16);
            bArr2[1] = (byte) (i >> 8);
            bArr2[0] = (byte) i;
        }
        write(this.f4850e, 0, 4);
    }

    public void writeLong(long j) {
        long j2 = j;
        if (this.f4840a == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.f4850e;
            bArr[0] = (byte) ((int) (j2 >> 56));
            bArr[1] = (byte) ((int) (j2 >> 48));
            bArr[2] = (byte) ((int) (j2 >> 40));
            bArr[3] = (byte) ((int) (j2 >> 32));
            bArr[4] = (byte) ((int) (j2 >> 24));
            bArr[5] = (byte) ((int) (j2 >> 16));
            bArr[6] = (byte) ((int) (j2 >> 8));
            bArr[7] = (byte) ((int) j2);
        } else {
            byte[] bArr2 = this.f4850e;
            bArr2[7] = (byte) ((int) (j2 >> 56));
            bArr2[6] = (byte) ((int) (j2 >> 48));
            bArr2[5] = (byte) ((int) (j2 >> 40));
            bArr2[4] = (byte) ((int) (j2 >> 32));
            bArr2[3] = (byte) ((int) (j2 >> 24));
            bArr2[2] = (byte) ((int) (j2 >> 16));
            bArr2[1] = (byte) ((int) (j2 >> 8));
            bArr2[0] = (byte) ((int) j2);
        }
        write(this.f4850e, 0, 8);
    }

    public void writeShort(int i) {
        if (this.f4840a == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.f4850e;
            bArr[0] = (byte) (i >> 8);
            bArr[1] = (byte) i;
        } else {
            byte[] bArr2 = this.f4850e;
            bArr2[1] = (byte) (i >> 8);
            bArr2[0] = (byte) i;
        }
        write(this.f4850e, 0, 2);
    }

    public void writeUTF(String str) {
        ByteOrder c = mo7426c();
        mo7423a(ByteOrder.BIG_ENDIAN);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new DataOutputStream(byteArrayOutputStream).writeUTF(str);
        write(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
        mo7423a(c);
    }
}
