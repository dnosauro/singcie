package com.cyberneid.p089b.p095f;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* renamed from: com.cyberneid.b.f.u */
class C1573u extends C1575w {

    /* renamed from: a */
    private RandomAccessFile f4743a = null;

    /* renamed from: b */
    private File f4744b = null;

    C1573u(File file, String str) {
        this.f4743a = new RandomAccessFile(file, str);
        this.f4744b = file;
    }

    /* renamed from: a */
    public int mo7275a(byte[] bArr, int i, int i2) {
        return this.f4743a.read(bArr, i, i2);
    }

    /* renamed from: a */
    public long mo7276a() {
        return this.f4743a.readLong();
    }

    /* renamed from: a */
    public void mo7277a(long j) {
        this.f4743a.seek(j);
    }

    /* renamed from: c */
    public int mo7279c() {
        return this.f4743a.read();
    }

    public void close() {
        this.f4743a.close();
        this.f4743a = null;
    }

    /* renamed from: d */
    public int mo7281d() {
        return this.f4743a.readUnsignedShort();
    }

    /* renamed from: e */
    public short mo7282e() {
        return this.f4743a.readShort();
    }

    /* renamed from: f */
    public long mo7283f() {
        return this.f4743a.getFilePointer();
    }

    /* renamed from: g */
    public InputStream mo7284g() {
        return new FileInputStream(this.f4744b);
    }
}
