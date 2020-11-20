package com.cyberneid.p105d.p114g.p115a;

import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1610g;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p111d.C1654a;
import com.cyberneid.p105d.p114g.C1783c;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.g.a.g */
public class C1764g implements C1760c {

    /* renamed from: a */
    private final C1619o f5743a;

    public C1764g(C1619o oVar) {
        this.f5743a = oVar;
    }

    public C1764g(C1783c cVar) {
        this.f5743a = cVar.mo8053a().mo7559a();
    }

    private C1764g(C1783c cVar, InputStream inputStream, C1605b bVar) {
        OutputStream outputStream = null;
        try {
            this.f5743a = cVar.mo8053a().mo7559a();
            outputStream = this.f5743a.mo7623a(bVar);
            C1654a.m6618a(inputStream, outputStream);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public C1764g(C1783c cVar, InputStream inputStream, C1613i iVar) {
        this(cVar, inputStream, (C1605b) iVar);
    }

    /* renamed from: a */
    public C1619o mo7505d() {
        return this.f5743a;
    }

    /* renamed from: a */
    public OutputStream mo7956a(C1613i iVar) {
        return this.f5743a.mo7623a((C1605b) iVar);
    }

    /* renamed from: b */
    public OutputStream mo7957b() {
        return this.f5743a.mo7630o();
    }

    /* renamed from: c */
    public C1610g mo7958c() {
        return this.f5743a.mo7628m();
    }

    /* renamed from: e */
    public C1619o mo7959e() {
        return this.f5743a;
    }

    /* renamed from: f */
    public int mo7960f() {
        return this.f5743a.mo7529b(C1613i.f5095dR, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0029  */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] mo7961g() {
        /*
            r5 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]
            com.cyberneid.d.b.g r2 = r5.mo7958c()     // Catch:{ all -> 0x0025 }
        L_0x000d:
            int r3 = r2.read(r1)     // Catch:{ all -> 0x0023 }
            r4 = -1
            if (r3 == r4) goto L_0x0019
            r4 = 0
            r0.write(r1, r4, r3)     // Catch:{ all -> 0x0023 }
            goto L_0x000d
        L_0x0019:
            if (r2 == 0) goto L_0x001e
            r2.close()
        L_0x001e:
            byte[] r0 = r0.toByteArray()
            return r0
        L_0x0023:
            r0 = move-exception
            goto L_0x0027
        L_0x0025:
            r0 = move-exception
            r2 = 0
        L_0x0027:
            if (r2 == 0) goto L_0x002c
            r2.close()
        L_0x002c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p115a.C1764g.mo7961g():byte[]");
    }
}
