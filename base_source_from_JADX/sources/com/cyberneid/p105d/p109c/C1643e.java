package com.cyberneid.p105d.p109c;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p109c.p110a.C1629b;
import com.cyberneid.p105d.p109c.p110a.C1637c;
import com.cyberneid.p105d.p109c.p110a.C1639e;
import com.cyberneid.p105d.p111d.C1654a;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.c.e */
final class C1643e extends C1647i {
    C1643e() {
    }

    /* renamed from: a */
    private void m6591a(byte[] bArr) {
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) ((~bArr[i]) & 255);
        }
    }

    /* renamed from: a */
    public C1646h mo7657a(InputStream inputStream, OutputStream outputStream, C1607d dVar, int i) {
        byte[] bArr;
        C1607d dVar2 = dVar;
        C1646h hVar = new C1646h(new C1607d());
        hVar.mo7692a().mo7516a(dVar2);
        C1607d a = m6599a(dVar, i);
        int b = a.mo7529b(C1613i.f4930aL, 1728);
        int b2 = a.mo7529b(C1613i.f5273gk, 0);
        int a2 = dVar2.mo7512a(C1613i.f5107dd, C1613i.f5105db, 0);
        int max = (b2 <= 0 || a2 <= 0) ? Math.max(b2, a2) : Math.min(b2, a2);
        int b3 = a.mo7529b(C1613i.f5082dE, 0);
        boolean b4 = a.mo7538b(C1613i.f5052cb, false);
        int i2 = ((b + 7) / 8) * max;
        if (b3 == 0) {
            C1637c cVar = new C1637c(new C1629b(inputStream, b, max, b4));
            byte[] a3 = C1654a.m6620a((InputStream) cVar);
            cVar.close();
            bArr = a3;
        } else {
            InputStream inputStream2 = inputStream;
            C1639e eVar = new C1639e(1, b, max);
            byte[] a4 = C1654a.m6620a(inputStream);
            bArr = new byte[i2];
            if (b3 > 0) {
                eVar.mo7679a(bArr, a4, 0, max, 0);
            } else {
                eVar.mo7680a(bArr, a4, 0, max, 0, b4);
            }
        }
        if (!a.mo7538b(C1613i.f4911T, false)) {
            m6591a(bArr);
        }
        if (!dVar2.mo7555l(C1613i.f4929aK)) {
            hVar.mo7692a().mo7523a(C1613i.f4929aK, C1613i.f5015br.mo7596a());
        }
        outputStream.write(bArr);
        return new C1646h(dVar2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7658a(InputStream inputStream, OutputStream outputStream, C1607d dVar) {
        Log.w("PdfBox-Android", "CCITTFaxDecode.encode is not implemented yet, skipping this stream.");
    }
}
