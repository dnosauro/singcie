package com.cyberneid.p105d.p114g.p126f.p129c;

import com.cyberneid.p105d.p113f.C1685b;
import java.io.Closeable;
import java.io.InputStream;

/* renamed from: com.cyberneid.d.g.f.c.f */
public class C1899f implements C1895b, Closeable {

    /* renamed from: a */
    private C1685b f6055a;

    public C1899f(C1685b bVar) {
        this.f6055a = bVar;
    }

    /* renamed from: a */
    public InputStream mo8364a() {
        return this.f6055a.mo7840e();
    }

    /* renamed from: a */
    public void mo8365a(byte[] bArr) {
        this.f6055a.mo7829a(bArr);
    }

    public void close() {
        C1685b bVar = this.f6055a;
        if (bVar != null) {
            try {
                bVar.close();
            } finally {
                this.f6055a = null;
            }
        }
    }
}
