package com.cyberneid.p099c.p102b.p103a.p104a;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteOrder;
import org.spongycastle.asn1.cmc.BodyPartID;

/* renamed from: com.cyberneid.c.b.a.a.b */
public abstract class C1594b implements C1593a {

    /* renamed from: a */
    protected ByteOrder f4840a = ByteOrder.BIG_ENDIAN;

    /* renamed from: b */
    protected long f4841b = 0;

    /* renamed from: c */
    protected long f4842c = 0;

    /* renamed from: d */
    protected int f4843d = 0;

    /* renamed from: e */
    private boolean f4844e = false;

    /* renamed from: f */
    private final C1596a f4845f = new C1596a();

    /* renamed from: g */
    private final C1596a f4846g = new C1596a();

    /* renamed from: h */
    private final byte[] f4847h = new byte[8];

    /* renamed from: com.cyberneid.c.b.a.a.b$a */
    private static class C1596a {

        /* renamed from: a */
        private long[] f4848a;

        /* renamed from: b */
        private int f4849b;

        private C1596a() {
            this.f4848a = new long[10];
            this.f4849b = 0;
        }
    }

    /* renamed from: a */
    public abstract int mo7421a(byte[] bArr, int i, int i2);

    /* renamed from: a */
    public long mo7419a(int i) {
        mo7424b();
        if (i < 0 || i > 64) {
            throw new IllegalArgumentException();
        }
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 1) | ((long) mo7432g());
        }
        return j;
    }

    /* renamed from: a */
    public long mo7422a(long j) {
        mo7425b(mo7429e() + j);
        return j;
    }

    /* renamed from: a */
    public void mo7420a() {
        mo7424b();
        this.f4844e = true;
    }

    /* renamed from: a */
    public void mo7423a(ByteOrder byteOrder) {
        this.f4840a = byteOrder;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo7424b() {
        if (this.f4844e) {
            throw new IOException("stream is closed");
        }
    }

    /* renamed from: b */
    public void mo7425b(long j) {
        mo7424b();
        if (j >= mo7435j()) {
            this.f4843d = 0;
            this.f4841b = j;
            return;
        }
        throw new IllegalArgumentException("trying to seek before flushed pos");
    }

    /* renamed from: c */
    public ByteOrder mo7426c() {
        return this.f4840a;
    }

    /* renamed from: c */
    public void mo7427c(long j) {
        if (j > mo7429e()) {
            throw new IndexOutOfBoundsException("Trying to flush outside of current position");
        } else if (j >= this.f4842c) {
            this.f4842c = j;
        } else {
            throw new IndexOutOfBoundsException("Trying to flush within already flushed portion");
        }
    }

    /* renamed from: d */
    public abstract int mo7428d();

    /* renamed from: e */
    public long mo7429e() {
        mo7424b();
        return this.f4841b;
    }

    /* renamed from: f */
    public int mo7430f() {
        mo7424b();
        return this.f4843d;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        if (!this.f4844e) {
            try {
                mo7420a();
            } finally {
                super.finalize();
            }
        }
    }

    /* renamed from: g */
    public int mo7432g() {
        mo7424b();
        int i = this.f4843d;
        int d = mo7428d();
        if (d != -1) {
            int i2 = (i + 1) & 7;
            if (i2 != 0) {
                d >>= 8 - i2;
                mo7425b(mo7429e() - 1);
            }
            this.f4843d = i2;
            return d & 1;
        }
        throw new EOFException();
    }

    /* renamed from: h */
    public long mo7433h() {
        return -1;
    }

    /* renamed from: i */
    public void mo7434i() {
        mo7427c(mo7429e());
    }

    /* renamed from: j */
    public long mo7435j() {
        return this.f4842c;
    }

    public boolean readBoolean() {
        int d = mo7428d();
        if (d >= 0) {
            return d != 0;
        }
        throw new EOFException("EOF reached");
    }

    public byte readByte() {
        int d = mo7428d();
        if (d >= 0) {
            return (byte) d;
        }
        throw new EOFException("EOF reached");
    }

    public char readChar() {
        return (char) readShort();
    }

    public double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    public float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    public void readFully(byte[] bArr) {
        readFully(bArr, 0, bArr.length);
    }

    public void readFully(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        while (i2 > 0) {
            int a = mo7421a(bArr, i, i2);
            if (a != -1) {
                i += a;
                i2 -= a;
            } else {
                throw new EOFException();
            }
        }
    }

    public int readInt() {
        if (mo7421a(this.f4847h, 0, 4) < 0) {
            throw new EOFException();
        } else if (this.f4840a == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.f4847h;
            return (bArr[3] & 255) | ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << Tnaf.POW_2_WIDTH) | ((bArr[2] & 255) << 8);
        } else {
            byte[] bArr2 = this.f4847h;
            return (bArr2[0] & 255) | ((bArr2[3] & 255) << 24) | ((bArr2[2] & 255) << Tnaf.POW_2_WIDTH) | ((bArr2[1] & 255) << 8);
        }
    }

    public String readLine() {
        StringBuilder sb = new StringBuilder(80);
        boolean z = true;
        while (true) {
            int d = mo7428d();
            if (d == -1) {
                break;
            }
            z = false;
            if (d == 10) {
                break;
            } else if (d == 13) {
                int d2 = mo7428d();
                if (d2 != 10 && d2 != -1) {
                    mo7425b(mo7429e() - 1);
                }
            } else {
                sb.append((char) d);
            }
        }
        if (z) {
            return null;
        }
        return sb.toString();
    }

    public long readLong() {
        if (mo7421a(this.f4847h, 0, 8) < 0) {
            throw new EOFException();
        } else if (this.f4840a == ByteOrder.BIG_ENDIAN) {
            byte[] bArr = this.f4847h;
            byte b = ((bArr[0] & 255) << 24) | ((bArr[1] & 255) << Tnaf.POW_2_WIDTH) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
            byte b2 = ((bArr[4] & 255) << 24) | ((bArr[5] & 255) << Tnaf.POW_2_WIDTH);
            return ((((long) b) & BodyPartID.bodyIdMax) << 32) | (((long) ((bArr[7] & 255) | ((bArr[6] & 255) << 8) | b2)) & BodyPartID.bodyIdMax);
        } else {
            byte[] bArr2 = this.f4847h;
            byte b3 = (bArr2[0] & 255) | ((bArr2[3] & 255) << 24) | ((bArr2[2] & 255) << Tnaf.POW_2_WIDTH) | ((bArr2[1] & 255) << 8);
            int i = (bArr2[5] & 255) << 8;
            byte b4 = bArr2[4] & 255;
            return (((long) b3) & BodyPartID.bodyIdMax) | ((((long) (b4 | (i | (((bArr2[7] & 255) << 24) | ((bArr2[6] & 255) << Tnaf.POW_2_WIDTH))))) & BodyPartID.bodyIdMax) << 32);
        }
    }

    public short readShort() {
        byte b;
        if (mo7421a(this.f4847h, 0, 2) >= 0) {
            if (this.f4840a == ByteOrder.BIG_ENDIAN) {
                byte[] bArr = this.f4847h;
                b = (bArr[1] & 255) | (bArr[0] << 8);
            } else {
                byte[] bArr2 = this.f4847h;
                b = (bArr2[0] & 255) | (bArr2[1] << 8);
            }
            return (short) b;
        }
        throw new EOFException();
    }

    public String readUTF() {
        ByteOrder c = mo7426c();
        mo7423a(ByteOrder.BIG_ENDIAN);
        int readUnsignedShort = readUnsignedShort();
        char[] cArr = new char[readUnsignedShort];
        readFully(new byte[readUnsignedShort], 0, readUnsignedShort);
        mo7423a(c);
        return new DataInputStream(new ByteArrayInputStream(this.f4847h)).readUTF();
    }

    public int readUnsignedByte() {
        int d = mo7428d();
        if (d >= 0) {
            return d;
        }
        throw new EOFException("EOF reached");
    }

    public int readUnsignedShort() {
        return readShort() & 65535;
    }

    public int skipBytes(int i) {
        return (int) mo7422a((long) i);
    }
}
