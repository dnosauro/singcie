package com.cyberneid.p105d.p114g.p122e.p125c;

import android.graphics.BitmapFactory;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.C1931h;
import com.cyberneid.p105d.p114g.p122e.C1832a;
import com.cyberneid.p105d.p114g.p122e.p123a.C1838f;
import com.cyberneid.p105d.p114g.p122e.p123a.C1841i;
import com.cyberneid.p105d.p131h.p132a.C1936b;
import com.cyberneid.p105d.p131h.p132a.C1937c;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.cyberneid.d.g.e.c.e */
public final class C1861e extends C1832a implements C1860d {

    /* renamed from: a */
    private C1838f f6004a = null;

    /* renamed from: b */
    private final C1931h f6005b = null;

    public C1861e(C1783c cVar, InputStream inputStream, C1605b bVar, int i, int i2, int i3, C1838f fVar) {
        super(m7708a(cVar, inputStream), C1613i.f5120dq);
        mo8251b().mo7521a(C1613i.f5074cx, bVar);
        mo8300a(i3);
        mo8304c(i);
        mo8303b(i2);
        mo8302a(fVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001b  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.cyberneid.p105d.p108b.C1619o m7708a(com.cyberneid.p105d.p114g.C1783c r1, java.io.InputStream r2) {
        /*
            com.cyberneid.d.b.e r1 = r1.mo8053a()
            com.cyberneid.d.b.o r1 = r1.mo7559a()
            java.io.OutputStream r0 = r1.mo7631p()     // Catch:{ all -> 0x0017 }
            com.cyberneid.p105d.p111d.C1654a.m6618a(r2, r0)     // Catch:{ all -> 0x0015 }
            if (r0 == 0) goto L_0x0014
            r0.close()
        L_0x0014:
            return r1
        L_0x0015:
            r1 = move-exception
            goto L_0x0019
        L_0x0017:
            r1 = move-exception
            r0 = 0
        L_0x0019:
            if (r0 == 0) goto L_0x001e
            r0.close()
        L_0x001e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p122e.p125c.C1861e.m7708a(com.cyberneid.d.g.c, java.io.InputStream):com.cyberneid.d.b.o");
    }

    /* renamed from: a */
    public static C1861e m7709a(C1783c cVar, byte[] bArr, String str) {
        C1861e a;
        try {
            C1936b a2 = C1937c.m7977a(bArr);
            if (a2 == null) {
                throw new IllegalArgumentException("Image type not supported: " + str);
            } else if (a2.equals(C1936b.JPEG)) {
                return C1856b.m7698a(cVar, bArr);
            } else {
                if (a2.equals(C1936b.PNG) && (a = C1862f.m7725a(cVar, bArr)) != null) {
                    return a;
                }
                if (a2.equals(C1936b.TIFF)) {
                    try {
                        return C1855a.m7693a(cVar, bArr);
                    } catch (IOException e) {
                        e.printStackTrace();
                        a2 = C1936b.PNG;
                    }
                }
                if (a2.equals(C1936b.BMP) || a2.equals(C1936b.GIF) || a2.equals(C1936b.PNG)) {
                    new ByteArrayInputStream(bArr);
                    return C1859c.m7705a(cVar, BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                }
                throw new IllegalArgumentException("Image type " + a2 + " not supported: " + str);
            }
        } catch (IOException e2) {
            throw new IOException("Could not determine file type: " + str, e2);
        }
    }

    /* renamed from: a */
    public C1838f mo8299a() {
        if (this.f6004a == null) {
            C1605b a = mo8251b().mo7513a(C1613i.f4929aK, C1613i.f4942aX);
            if (a != null) {
                this.f6004a = C1838f.m7590a(a, this.f6005b);
            } else if (mo8307g()) {
                return C1841i.f5963a;
            } else {
                throw new IOException("could not determine color space");
            }
        }
        return this.f6004a;
    }

    /* renamed from: a */
    public void mo8300a(int i) {
        mo8251b().mo7518a(C1613i.f4907P, i);
    }

    /* renamed from: a */
    public void mo8301a(C1604a aVar) {
        mo8251b().mo7521a(C1613i.f5002be, (C1605b) aVar);
    }

    /* renamed from: a */
    public void mo8302a(C1838f fVar) {
        mo8251b().mo7521a(C1613i.f4929aK, fVar != null ? fVar.mo7505d() : null);
    }

    /* renamed from: b */
    public void mo8303b(int i) {
        mo8251b().mo7518a(C1613i.f5107dd, i);
    }

    /* renamed from: c */
    public void mo8304c(int i) {
        mo8251b().mo7518a(C1613i.f5308hS, i);
    }

    /* renamed from: e */
    public int mo8305e() {
        return mo8251b().mo7547g(C1613i.f5107dd);
    }

    /* renamed from: f */
    public int mo8306f() {
        return mo8251b().mo7547g(C1613i.f5308hS);
    }

    /* renamed from: g */
    public boolean mo8307g() {
        return mo8251b().mo7538b(C1613i.f5121dr, false);
    }
}
