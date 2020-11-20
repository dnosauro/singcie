package com.cyberneid.p105d.p111d;

import java.io.OutputStream;

/* renamed from: com.cyberneid.d.d.g */
public class C1661g extends OutputStream {

    /* renamed from: a */
    private final C1663i f5487a;

    public C1661g(C1663i iVar) {
        this.f5487a = iVar;
    }

    public void write(int i) {
        this.f5487a.mo7705a(i);
    }

    public void write(byte[] bArr) {
        this.f5487a.mo7707a(bArr);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.f5487a.mo7708a(bArr, i, i2);
    }
}
