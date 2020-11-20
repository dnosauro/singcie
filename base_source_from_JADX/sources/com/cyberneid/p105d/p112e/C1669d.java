package com.cyberneid.p105d.p112e;

import java.io.InputStream;
import java.io.PushbackInputStream;

/* renamed from: com.cyberneid.d.e.d */
final class C1669d implements C1679k {

    /* renamed from: a */
    private final PushbackInputStream f5537a;

    /* renamed from: b */
    private int f5538b = 0;

    C1669d(InputStream inputStream) {
        this.f5537a = new PushbackInputStream(inputStream, 32767);
    }

    /* renamed from: a */
    public int mo7788a() {
        int read = this.f5537a.read();
        this.f5538b++;
        return read;
    }

    /* renamed from: a */
    public int mo7789a(byte[] bArr) {
        int read = this.f5537a.read(bArr);
        this.f5538b += read;
        return read;
    }

    /* renamed from: a */
    public int mo7790a(byte[] bArr, int i, int i2) {
        int read = this.f5537a.read(bArr, i, i2);
        this.f5538b += read;
        return read;
    }

    /* renamed from: a */
    public void mo7791a(int i) {
        this.f5537a.unread(i);
        this.f5538b--;
    }

    /* renamed from: b */
    public long mo7792b() {
        return (long) this.f5538b;
    }

    /* renamed from: b */
    public void mo7793b(byte[] bArr) {
        this.f5537a.unread(bArr);
        this.f5538b -= bArr.length;
    }

    /* renamed from: b */
    public byte[] mo7794b(int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i > 0) {
            int a = mo7790a(bArr, i2, i);
            i2 += a;
            i -= a;
            this.f5538b += a;
        }
        return bArr;
    }

    /* renamed from: c */
    public int mo7795c() {
        int read = this.f5537a.read();
        if (read != -1) {
            this.f5537a.unread(read);
        }
        return read;
    }

    public void close() {
        this.f5537a.close();
    }

    /* renamed from: d */
    public boolean mo7797d() {
        return mo7795c() == -1;
    }
}
