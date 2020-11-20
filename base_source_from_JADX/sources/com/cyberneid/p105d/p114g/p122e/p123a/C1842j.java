package com.cyberneid.p105d.p114g.p122e.p123a;

import android.graphics.Bitmap;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1614j;
import com.cyberneid.p105d.p114g.p115a.C1689a;
import com.cyberneid.p105d.p114g.p115a.p116a.C1690a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.spongycastle.crypto.tls.CipherSuite;

/* renamed from: com.cyberneid.d.g.e.a.j */
public class C1842j extends C1852t {

    /* renamed from: a */
    private C1838f f5965a = null;

    /* renamed from: b */
    private C1690a f5966b = null;

    /* renamed from: c */
    private C1843k f5967c;

    /* renamed from: d */
    private C1837e f5968d;

    /* renamed from: f */
    private int f5969f;

    /* renamed from: g */
    private int[] f5970g;

    /* renamed from: h */
    private C1838f f5971h;

    /* renamed from: i */
    private C1851s[] f5972i;

    public C1842j() {
        this.f5960e = new C1604a();
        this.f5960e.mo7490a((C1605b) C1613i.f5016bs);
        this.f5960e.mo7490a((C1605b) C1614j.f5368b);
        this.f5960e.mo7490a((C1605b) C1614j.f5368b);
        this.f5960e.mo7490a((C1605b) C1614j.f5368b);
    }

    public C1842j(C1604a aVar) {
        this.f5960e = aVar;
        this.f5965a = C1838f.m7589a(this.f5960e.mo7485a(2));
        this.f5966b = C1690a.m6909a(this.f5960e.mo7485a(3));
        if (this.f5960e.mo7494b() > 4) {
            this.f5967c = new C1843k((C1607d) this.f5960e.mo7485a(4));
        }
        m7614g();
        int c = mo8259c();
        float[] fArr = new float[c];
        for (int i = 0; i < c; i++) {
            fArr[i] = 1.0f;
        }
        this.f5968d = new C1837e(fArr, (C1838f) this);
    }

    /* renamed from: b */
    private Bitmap m7610b(Bitmap bitmap) {
        C1838f fVar;
        C1842j jVar = this;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(-1);
        int i = 0;
        while (i < jVar.f5969f) {
            if (jVar.f5970g[i] >= 0) {
                fVar = jVar.f5971h;
            } else {
                C1838f[] fVarArr = jVar.f5972i;
                if (fVarArr[i] == null) {
                    return m7612c(bitmap);
                }
                fVar = fVarArr[i];
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            int[] iArr = new int[jVar.f5969f];
            int[] iArr2 = new int[fVar.mo8259c()];
            boolean z = jVar.f5970g[i] >= 0;
            int i2 = jVar.f5970g[i];
            int i3 = 0;
            while (i3 < height) {
                int i4 = 0;
                while (i4 < width) {
                    int pixel = bitmap.getPixel(i4, i3);
                    iArr[0] = (pixel >> 16) & 255;
                    iArr[1] = (pixel >> 8) & 255;
                    iArr[2] = pixel & 255;
                    if (z) {
                        iArr2[i2] = iArr[i];
                    } else {
                        iArr2[0] = iArr[i];
                    }
                    createBitmap.setPixel(i4, i3, ((((iArr2[0] & 16711680) << ((iArr2[1] & CipherSuite.DRAFT_TLS_DHE_RSA_WITH_AES_128_OCB) + 16)) << (iArr2[0] + 8)) & 255) - 16777216);
                    i4++;
                }
                Bitmap bitmap2 = bitmap;
                i3++;
            }
            Bitmap bitmap3 = bitmap;
            Bitmap a = fVar.mo8253a(createBitmap2);
            int[] iArr3 = new int[3];
            int[] iArr4 = new int[3];
            for (int i5 = 0; i5 < height; i5++) {
                for (int i6 = 0; i6 < width; i6++) {
                    int pixel2 = a.getPixel(i6, i5);
                    iArr3[0] = (pixel2 >> 16) & 255;
                    iArr3[1] = (pixel2 >> 8) & 255;
                    iArr3[2] = pixel2 & 255;
                    int pixel3 = createBitmap.getPixel(i6, i5);
                    iArr4[0] = (pixel3 >> 16) & 255;
                    iArr4[1] = (pixel3 >> 8) & 255;
                    iArr4[2] = pixel3 & 255;
                    iArr3[0] = (iArr3[0] * iArr4[0]) >> 8;
                    iArr3[1] = (iArr3[1] * iArr4[1]) >> 8;
                    iArr3[2] = (iArr3[2] * iArr4[2]) >> 8;
                    createBitmap.setPixel(i6, i5, ((((iArr3[0] & 16711680) << ((iArr3[1] & CipherSuite.DRAFT_TLS_DHE_RSA_WITH_AES_128_OCB) + 16)) << (iArr3[0] + 8)) & 255) - 16777216);
                }
            }
            i++;
            jVar = this;
        }
        return createBitmap;
    }

    /* renamed from: b */
    private float[] m7611b(float[] fArr) {
        C1838f fVar;
        float[] fArr2 = {1.0f, 1.0f, 1.0f};
        for (int i = 0; i < this.f5969f; i++) {
            if (this.f5970g[i] >= 0) {
                fVar = this.f5971h;
            } else {
                C1838f[] fVarArr = this.f5972i;
                if (fVarArr[i] == null) {
                    return m7613c(fArr);
                }
                fVar = fVarArr[i];
            }
            boolean z = this.f5970g[i] >= 0;
            float[] fArr3 = new float[fVar.mo8259c()];
            int i2 = this.f5970g[i];
            if (z) {
                fArr3[i2] = fArr[i];
            } else {
                fArr3[0] = fArr[i];
            }
            float[] a = fVar.mo8257a(fArr3);
            fArr2[0] = fArr2[0] * a[0];
            fArr2[1] = fArr2[1] * a[1];
            fArr2[2] = fArr2[2] * a[2];
        }
        return fArr2;
    }

    /* renamed from: c */
    private Bitmap m7612c(Bitmap bitmap) {
        int i;
        HashMap hashMap = new HashMap();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] iArr = new int[3];
        int size = mo8269f().size();
        float[] fArr = new float[size];
        for (int i2 = 0; i2 < height; i2++) {
            for (int i3 = 0; i3 < width; i3++) {
                int pixel = bitmap.getPixel(i3, i2);
                fArr[0] = (float) ((pixel >> 16) & 255);
                fArr[1] = (float) ((pixel >> 8) & 255);
                fArr[2] = (float) (pixel & 255);
                String f = Float.toString(fArr[0]);
                for (int i4 = 1; i4 < size; i4++) {
                    f = f + "#" + Float.toString(fArr[i4]);
                }
                int[] iArr2 = (int[]) hashMap.get(f);
                int i5 = -16777216;
                if (iArr2 != null) {
                    i = (((iArr2[0] & 16711680) << ((iArr2[1] & CipherSuite.DRAFT_TLS_DHE_RSA_WITH_AES_128_OCB) + 16)) << (iArr2[0] + 8)) & 255;
                } else {
                    for (int i6 = 0; i6 < size; i6++) {
                        fArr[i6] = fArr[i6] / 255.0f;
                    }
                    float[] a = this.f5965a.mo8257a(this.f5966b.mo7885a(fArr));
                    for (int i7 = 0; i7 < 3; i7++) {
                        iArr[i7] = (int) (a[i7] * 255.0f);
                    }
                    hashMap.put(f, iArr.clone());
                    i = (((iArr[0] & 16711680) << ((iArr[1] & CipherSuite.DRAFT_TLS_DHE_RSA_WITH_AES_128_OCB) + 16)) << (iArr[0] + 8)) & 255;
                    i5 = -16777216;
                }
                createBitmap.setPixel(i3, i2, i + i5);
            }
            Bitmap bitmap2 = bitmap;
        }
        return createBitmap;
    }

    /* renamed from: c */
    private float[] m7613c(float[] fArr) {
        return this.f5965a.mo8257a(this.f5966b.mo7885a(fArr));
    }

    /* renamed from: g */
    private void m7614g() {
        if (this.f5967c != null) {
            List<String> f = mo8269f();
            this.f5969f = f.size();
            this.f5970g = new int[this.f5969f];
            for (int i = 0; i < this.f5969f; i++) {
                this.f5970g[i] = -1;
            }
            if (this.f5967c.mo8272b() != null) {
                List<String> b = this.f5967c.mo8272b().mo8276b();
                for (int i2 = 0; i2 < this.f5969f; i2++) {
                    this.f5970g[i2] = b.indexOf(f.get(i2));
                }
                this.f5971h = this.f5967c.mo8272b().mo8275a();
            }
            this.f5972i = new C1851s[this.f5969f];
            Map<String, C1851s> a = this.f5967c.mo8271a();
            for (int i3 = 0; i3 < this.f5969f; i3++) {
                C1851s sVar = a.get(f.get(i3));
                if (sVar != null) {
                    this.f5972i[i3] = sVar;
                    if (!mo8268a()) {
                        this.f5970g[i3] = -1;
                    }
                } else {
                    this.f5972i[i3] = null;
                }
            }
        }
    }

    /* renamed from: a */
    public Bitmap mo8253a(Bitmap bitmap) {
        return this.f5967c != null ? m7610b(bitmap) : m7612c(bitmap);
    }

    /* renamed from: a */
    public boolean mo8268a() {
        C1843k kVar = this.f5967c;
        return kVar != null && kVar.mo8273c();
    }

    /* renamed from: a */
    public float[] mo8257a(float[] fArr) {
        return this.f5967c != null ? m7611b(fArr) : m7613c(fArr);
    }

    /* renamed from: b */
    public String mo8258b() {
        return C1613i.f5016bs.mo7596a();
    }

    /* renamed from: c */
    public final int mo8259c() {
        return mo8269f().size();
    }

    /* renamed from: e */
    public C1837e mo8260e() {
        return this.f5968d;
    }

    /* renamed from: f */
    public List<String> mo8269f() {
        return C1689a.m6906b((C1604a) this.f5960e.mo7485a(1));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(mo8258b());
        sb.append('{');
        for (String append : mo8269f()) {
            sb.append('\"');
            sb.append(append);
            sb.append("\" ");
        }
        sb.append(this.f5965a.mo8258b());
        sb.append(' ');
        sb.append(this.f5966b);
        sb.append(' ');
        C1843k kVar = this.f5967c;
        if (kVar != null) {
            sb.append(kVar);
        }
        sb.append('}');
        return sb.toString();
    }
}
