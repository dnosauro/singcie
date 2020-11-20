package com.cyberneid.p105d.p109c;

import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p111d.C1654a;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.c.a */
final class C1627a extends C1647i {
    C1627a() {
    }

    /* renamed from: a */
    public C1646h mo7657a(InputStream inputStream, OutputStream outputStream, C1607d dVar, int i) {
        C1640b bVar;
        try {
            bVar = new C1640b(inputStream);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bVar.read(bArr, 0, 1024);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        outputStream.flush();
                        C1654a.m6619a((Closeable) bVar);
                        return new C1646h(dVar);
                    }
                }
            } catch (Throwable th) {
                th = th;
                C1654a.m6619a((Closeable) bVar);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bVar = null;
            C1654a.m6619a((Closeable) bVar);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7658a(InputStream inputStream, OutputStream outputStream, C1607d dVar) {
        C1641c cVar = new C1641c(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                cVar.write(bArr, 0, read);
            } else {
                cVar.close();
                outputStream.flush();
                return;
            }
        }
    }
}
