package com.cyberneid.p089b.p091b;

import java.io.EOFException;
import org.spongycastle.i18n.LocalizedMessage;

/* renamed from: com.cyberneid.b.b.r */
public class C1522r {

    /* renamed from: a */
    private byte[] f4510a = null;

    /* renamed from: b */
    private int f4511b = 0;

    public C1522r(byte[] bArr) {
        this.f4510a = bArr;
    }

    /* renamed from: a */
    private int mo7055a() {
        try {
            byte b = this.f4510a[this.f4511b] & 255;
            this.f4511b++;
            return b;
        } catch (RuntimeException unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private int mo7056a(int i) {
        try {
            return this.f4510a[this.f4511b + i] & 255;
        } catch (RuntimeException unused) {
            return -1;
        }
    }

    /* renamed from: b */
    public void mo7118b(int i) {
        this.f4511b = i;
    }

    /* renamed from: c */
    public int mo7119c(int i) {
        int a = mo7056a(i);
        if (a >= 0) {
            return a;
        }
        throw new EOFException();
    }

    /* renamed from: d */
    public byte[] mo7120d(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = mo7123g();
        }
        return bArr;
    }

    /* renamed from: e */
    public boolean mo7121e() {
        return this.f4511b < this.f4510a.length;
    }

    /* renamed from: f */
    public String mo7122f() {
        return new String(this.f4510a, LocalizedMessage.DEFAULT_ENCODING);
    }

    /* renamed from: g */
    public byte mo7123g() {
        return (byte) mo7124h();
    }

    /* renamed from: h */
    public int mo7124h() {
        int a = mo7055a();
        if (a >= 0) {
            return a;
        }
        throw new EOFException();
    }

    /* renamed from: i */
    public short mo7125i() {
        return (short) mo7126j();
    }

    /* renamed from: j */
    public int mo7126j() {
        int a = mo7055a();
        int a2 = mo7055a();
        if ((a | a2) >= 0) {
            return (a << 8) | a2;
        }
        throw new EOFException();
    }

    /* renamed from: k */
    public int mo7127k() {
        return this.f4510a.length;
    }
}
