package com.cyberneid.p105d.p109c;

import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.c.f */
final class C1644f extends C1647i {
    C1644f() {
    }

    /* renamed from: a */
    public C1646h mo7657a(InputStream inputStream, OutputStream outputStream, C1607d dVar, int i) {
        C1613i iVar = (C1613i) dVar.mo7539c(C1613i.f5181ey);
        if (iVar == null || iVar.equals(C1613i.f5116dm)) {
            new C1650l().mo7657a(inputStream, outputStream, dVar, i);
            return new C1646h(dVar);
        }
        throw new IOException("Unsupported crypt filter " + iVar.mo7596a());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7658a(InputStream inputStream, OutputStream outputStream, C1607d dVar) {
        C1613i iVar = (C1613i) dVar.mo7539c(C1613i.f5181ey);
        if (iVar == null || iVar.equals(C1613i.f5116dm)) {
            new C1650l().mo7658a(inputStream, outputStream, dVar);
            return;
        }
        throw new IOException("Unsupported crypt filter " + iVar.mo7596a());
    }
}
