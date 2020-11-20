package com.cyberneid.p105d.p109c;

import com.cyberneid.p105d.p108b.C1607d;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.c.l */
final class C1650l extends C1647i {
    C1650l() {
    }

    /* renamed from: a */
    public C1646h mo7657a(InputStream inputStream, OutputStream outputStream, C1607d dVar, int i) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return new C1646h(dVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7658a(InputStream inputStream, OutputStream outputStream, C1607d dVar) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }
}
