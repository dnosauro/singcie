package com.cyberneid.p105d.p113f;

import java.io.FilterOutputStream;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.f.a */
public class C1684a extends FilterOutputStream {

    /* renamed from: a */
    public static final byte[] f5572a = {13, 10};

    /* renamed from: b */
    public static final byte[] f5573b = {10};

    /* renamed from: c */
    public static final byte[] f5574c = {10};

    /* renamed from: d */
    private long f5575d = 0;

    /* renamed from: e */
    private boolean f5576e = false;

    public C1684a(OutputStream outputStream) {
        super(outputStream);
    }

    public C1684a(OutputStream outputStream, int i) {
        super(outputStream);
        this.f5575d = (long) i;
    }

    /* renamed from: a */
    public long mo7816a() {
        return this.f5575d;
    }

    /* renamed from: a */
    public void mo7817a(boolean z) {
        this.f5576e = z;
    }

    /* renamed from: b */
    public boolean mo7818b() {
        return this.f5576e;
    }

    /* renamed from: c */
    public void mo7819c() {
        write(f5572a);
    }

    /* renamed from: d */
    public void mo7820d() {
        if (!mo7818b()) {
            write(f5574c);
            mo7817a(true);
        }
    }

    public void write(int i) {
        mo7817a(false);
        this.out.write(i);
        this.f5575d++;
    }

    public void write(byte[] bArr, int i, int i2) {
        mo7817a(false);
        this.out.write(bArr, i, i2);
        this.f5575d += (long) i2;
    }
}
