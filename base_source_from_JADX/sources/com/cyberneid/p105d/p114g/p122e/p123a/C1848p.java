package com.cyberneid.p105d.p114g.p122e.p123a;

import android.graphics.Bitmap;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1612h;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1614j;
import com.cyberneid.p105d.p108b.C1615k;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p108b.C1622p;
import com.cyberneid.p105d.p114g.C1931h;
import com.cyberneid.p105d.p114g.p115a.C1764g;
import java.io.IOException;
import java.lang.reflect.Array;
import org.spongycastle.crypto.tls.CipherSuite;

/* renamed from: com.cyberneid.d.g.e.a.p */
public final class C1848p extends C1852t {

    /* renamed from: a */
    private final C1837e f5985a = new C1837e(new float[]{0.0f}, (C1838f) this);

    /* renamed from: b */
    private C1838f f5986b = null;

    /* renamed from: c */
    private byte[] f5987c;

    /* renamed from: d */
    private float[][] f5988d;

    /* renamed from: f */
    private int f5989f;

    /* renamed from: g */
    private int[][] f5990g;

    public C1848p() {
        this.f5960e = new C1604a();
        this.f5960e.mo7490a((C1605b) C1613i.f5123dt);
        this.f5960e.mo7490a((C1605b) C1613i.f5017bt);
        this.f5960e.mo7490a((C1605b) C1612h.m6455a(255));
        this.f5960e.mo7490a((C1605b) C1614j.f5368b);
    }

    public C1848p(C1604a aVar, C1931h hVar) {
        this.f5960e = aVar;
        this.f5986b = C1838f.m7590a(this.f5960e.mo7495b(1), hVar);
        m7650h();
        m7647a();
    }

    /* renamed from: a */
    private void m7647a() {
        int c = this.f5986b.mo8259c();
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f5989f + 1, 1, Bitmap.Config.ALPHA_8);
            int[] iArr = new int[c];
            int i = this.f5989f;
            for (int i2 = 0; i2 <= i; i2++) {
                for (int i3 = 0; i3 < c; i3++) {
                    iArr[i3] = (int) (this.f5988d[i2][i3] * 255.0f);
                }
                createBitmap.setPixel(i2, 0, ((((iArr[0] & 16711680) << ((iArr[1] & CipherSuite.DRAFT_TLS_DHE_RSA_WITH_AES_128_OCB) + 16)) << (iArr[0] + 8)) & 255) - 16777216);
            }
            Bitmap a = this.f5986b.mo8253a(createBitmap);
            this.f5990g = (int[][]) Array.newInstance(int.class, new int[]{this.f5989f + 1, 3});
            int i4 = this.f5989f;
            for (int i5 = 0; i5 <= i4; i5++) {
                int pixel = a.getPixel(i5, 0);
                int[][] iArr2 = this.f5990g;
                iArr2[i5][0] = (pixel >> 16) & 255;
                iArr2[i5][1] = (pixel >> 8) & 255;
                iArr2[i5][2] = pixel & 255;
            }
        } catch (IllegalArgumentException e) {
            throw new IOException(e);
        }
    }

    /* renamed from: f */
    private int m7648f() {
        return ((C1615k) this.f5960e.mo7485a(2)).mo7586c();
    }

    /* renamed from: g */
    private byte[] m7649g() {
        byte[] bArr;
        if (this.f5987c == null) {
            C1605b a = this.f5960e.mo7485a(3);
            if (a instanceof C1622p) {
                bArr = ((C1622p) a).mo7643c();
            } else if (a instanceof C1619o) {
                bArr = new C1764g((C1619o) a).mo7961g();
            } else if (a == null) {
                bArr = new byte[0];
            } else {
                throw new IOException("Error: Unknown type for lookup table " + a);
            }
            this.f5987c = bArr;
        }
        return this.f5987c;
    }

    /* renamed from: h */
    private void m7650h() {
        byte[] g = m7649g();
        int min = Math.min(m7648f(), 255);
        int c = this.f5986b.mo8259c();
        if (g.length / c < min + 1) {
            min = (g.length / c) - 1;
        }
        this.f5989f = min;
        this.f5988d = (float[][]) Array.newInstance(float.class, new int[]{min + 1, c});
        int i = 0;
        int i2 = 0;
        while (i <= min) {
            int i3 = i2;
            for (int i4 = 0; i4 < c; i4++) {
                this.f5988d[i][i4] = ((float) (g[i3] & 255)) / 255.0f;
                i3++;
            }
            i++;
            i2 = i3;
        }
    }

    /* renamed from: a */
    public Bitmap mo8253a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[1];
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                int pixel = createBitmap.getPixel(i2, i);
                iArr[0] = (pixel >> 16) & 255;
                iArr[1] = (pixel >> 8) & 255;
                iArr[2] = pixel & 255;
                int[] iArr2 = this.f5990g[Math.min(iArr[0], this.f5989f)];
                createBitmap.setPixel(i2, i, ((((iArr2[0] & 16711680) << ((iArr2[1] & CipherSuite.DRAFT_TLS_DHE_RSA_WITH_AES_128_OCB) + 16)) << (iArr2[0] + 8)) & 255) - 16777216);
            }
        }
        return createBitmap;
    }

    /* renamed from: a */
    public float[] mo8257a(float[] fArr) {
        if (fArr.length <= 1) {
            int[] iArr = this.f5990g[Math.min(Math.max(Math.round(fArr[0]), 0), this.f5989f)];
            return new float[]{((float) iArr[0]) / 255.0f, ((float) iArr[1]) / 255.0f, ((float) iArr[2]) / 255.0f};
        }
        throw new IllegalArgumentException("Indexed color spaces must have one color value");
    }

    /* renamed from: b */
    public String mo8258b() {
        return C1613i.f5123dt.mo7596a();
    }

    /* renamed from: c */
    public int mo8259c() {
        return 1;
    }

    /* renamed from: e */
    public C1837e mo8260e() {
        return this.f5985a;
    }

    public String toString() {
        return "Indexed{base:" + this.f5986b + " hival:" + m7648f() + " lookup:(" + this.f5988d.length + " entries)}";
    }
}
