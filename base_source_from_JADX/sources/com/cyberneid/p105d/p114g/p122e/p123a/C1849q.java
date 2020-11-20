package com.cyberneid.p105d.p114g.p122e.p123a;

import android.graphics.Bitmap;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1609f;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.p115a.C1762e;
import org.spongycastle.crypto.tls.CipherSuite;

/* renamed from: com.cyberneid.d.g.e.a.q */
public final class C1849q extends C1834b {

    /* renamed from: f */
    private C1837e f5991f;

    public C1849q() {
        super(C1613i.f5086dI);
    }

    public C1849q(C1604a aVar) {
        super(aVar);
    }

    /* renamed from: a */
    private float m7656a(float f) {
        return ((double) f) > 0.20689655172413793d ? f * f * f : (f - 0.13793103f) * 0.12841855f;
    }

    /* renamed from: h */
    private C1604a m7657h() {
        C1604a aVar = new C1604a();
        aVar.mo7490a((C1605b) new C1609f(-100.0f));
        aVar.mo7490a((C1605b) new C1609f(100.0f));
        aVar.mo7490a((C1605b) new C1609f(-100.0f));
        aVar.mo7490a((C1605b) new C1609f(100.0f));
        return aVar;
    }

    /* renamed from: a */
    public Bitmap mo8253a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        float a = mo8283f().mo7939a();
        float b = mo8283f().mo7940b();
        float a2 = mo8284g().mo7939a();
        float b2 = mo8284g().mo7940b();
        float[] fArr = new float[3];
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                int pixel = bitmap.getPixel(i2, i);
                fArr[0] = (float) ((pixel >> 16) & 255);
                fArr[1] = (float) ((pixel >> 8) & 255);
                fArr[2] = (float) (pixel & 255);
                fArr[0] = fArr[0] / 255.0f;
                fArr[1] = fArr[1] / 255.0f;
                fArr[2] = fArr[2] / 255.0f;
                fArr[0] = fArr[0] * 100.0f;
                fArr[1] = (fArr[1] * (b - a)) + a;
                fArr[2] = (fArr[2] * (b2 - a2)) + a2;
                float[] a3 = mo8257a(fArr);
                a3[0] = a3[0] * 255.0f;
                a3[1] = a3[1] * 255.0f;
                a3[2] = a3[2] * 255.0f;
                createBitmap.setPixel(i2, i, ((((((int) a3[0]) & 16711680) << ((((int) a3[1]) & CipherSuite.DRAFT_TLS_DHE_RSA_WITH_AES_128_OCB) + 16)) << (((int) a3[0]) + 8)) & 255) - 16777216);
            }
            Bitmap bitmap2 = bitmap;
        }
        return createBitmap;
    }

    /* renamed from: a */
    public float[] mo8257a(float[] fArr) {
        float f = (fArr[0] + 16.0f) * 0.00862069f;
        return mo8256a(this.f5951b * m7656a((fArr[1] * 0.002f) + f), this.f5952c * m7656a(f), this.f5953d * m7656a(f - (fArr[2] * 0.005f)));
    }

    /* renamed from: b */
    public String mo8258b() {
        return C1613i.f5086dI.mo7596a();
    }

    /* renamed from: c */
    public int mo8259c() {
        return 3;
    }

    /* renamed from: e */
    public C1837e mo8260e() {
        if (this.f5991f == null) {
            this.f5991f = new C1837e(new float[]{0.0f, Math.max(0.0f, mo8283f().mo7939a()), Math.max(0.0f, mo8284g().mo7939a())}, (C1838f) this);
        }
        return this.f5991f;
    }

    /* renamed from: f */
    public C1762e mo8283f() {
        C1604a aVar = (C1604a) this.f5950a.mo7539c(C1613i.f5204fU);
        if (aVar == null) {
            aVar = m7657h();
        }
        return new C1762e(aVar, 0);
    }

    /* renamed from: g */
    public C1762e mo8284g() {
        C1604a aVar = (C1604a) this.f5950a.mo7539c(C1613i.f5204fU);
        if (aVar == null) {
            aVar = m7657h();
        }
        return new C1762e(aVar, 1);
    }
}
