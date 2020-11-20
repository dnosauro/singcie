package com.cyberneid.p105d.p109c;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p111d.C1654a;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.c.g */
final class C1645g extends C1647i {
    C1645g() {
    }

    /* renamed from: a */
    public C1646h mo7657a(InputStream inputStream, OutputStream outputStream, C1607d dVar, int i) {
        C1654a.m6618a(inputStream, outputStream);
        return new C1646h(dVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7658a(InputStream inputStream, OutputStream outputStream, C1607d dVar) {
        Log.w("PdfBox-Android", "DCTFilter#encode is not implemented yet, skipping this stream.");
    }
}
