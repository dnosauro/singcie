package com.cyberneid.p105d.p114g.p122e.p123a;

import android.graphics.Bitmap;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1614j;
import com.cyberneid.p105d.p114g.p115a.p116a.C1690a;
import com.cyberneid.p105d.p114g.p115a.p116a.C1758f;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.crypto.tls.CipherSuite;

/* renamed from: com.cyberneid.d.g.e.a.s */
public class C1851s extends C1852t {

    /* renamed from: a */
    private final C1837e f5995a = new C1837e(new float[]{1.0f}, (C1838f) this);

    /* renamed from: b */
    private C1838f f5996b = null;

    /* renamed from: c */
    private C1690a f5997c = null;

    /* renamed from: d */
    private Map<Integer, float[]> f5998d = null;

    public C1851s() {
        this.f5960e = new C1604a();
        this.f5960e.mo7490a((C1605b) C1613i.f5281gs);
        this.f5960e.mo7490a((C1605b) C1613i.m6461a(""));
        this.f5960e.mo7490a((C1605b) C1614j.f5368b);
        this.f5960e.mo7490a((C1605b) C1614j.f5368b);
        this.f5996b = C1845m.f5975a;
        this.f5997c = new C1758f((C1605b) null);
    }

    public C1851s(C1604a aVar) {
        this.f5960e = aVar;
        this.f5996b = C1838f.m7589a(this.f5960e.mo7485a(2));
        this.f5997c = C1690a.m6909a(this.f5960e.mo7485a(3));
    }

    /* renamed from: b */
    private Bitmap m7670b(Bitmap bitmap) {
        int[] iArr;
        if (this.f5997c == null) {
            this.f5997c = new C1758f((C1605b) null);
        }
        if (this.f5996b == null) {
            this.f5996b = C1845m.f5975a;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        float[] fArr = new float[1];
        HashMap hashMap = new HashMap();
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                int pixel = bitmap.getPixel(i2, i);
                fArr[0] = (float) ((pixel >> 16) & 255);
                fArr[1] = (float) ((pixel >> 8) & 255);
                fArr[2] = (float) (pixel & 255);
                Integer valueOf = Integer.valueOf(Float.floatToIntBits(fArr[0]));
                int[] iArr2 = (int[]) hashMap.get(valueOf);
                if (iArr2 == null) {
                    fArr[0] = fArr[0] / 255.0f;
                    float[] a = this.f5996b.mo8257a(this.f5997c.mo7885a(fArr));
                    iArr = new int[]{(int) (a[0] * 255.0f), (int) (a[1] * 255.0f), (int) (a[2] * 255.0f)};
                    hashMap.put(valueOf, iArr);
                } else {
                    iArr = iArr2;
                }
                createBitmap.setPixel(i2, i, ((((iArr[0] & 16711680) << ((iArr[1] & CipherSuite.DRAFT_TLS_DHE_RSA_WITH_AES_128_OCB) + 16)) << (iArr[0] + 8)) & 255) - 16777216);
            }
            Bitmap bitmap2 = bitmap;
        }
        return createBitmap;
    }

    /* renamed from: a */
    public Bitmap mo8253a(Bitmap bitmap) {
        if (this.f5997c == null) {
            this.f5997c = new C1758f((C1605b) null);
        }
        if (this.f5996b == null) {
            this.f5996b = C1845m.f5975a;
        }
        if (this.f5996b instanceof C1849q) {
            return m7670b(bitmap);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        int c = this.f5996b.mo8259c();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float[] fArr = new float[1];
        HashMap hashMap = new HashMap();
        for (int i = 0; i < height; i++) {
            for (int i2 = 0; i2 < width; i2++) {
                int pixel = bitmap.getPixel(i2, i);
                fArr[0] = (float) ((pixel >> 16) & 255);
                fArr[1] = (float) ((pixel >> 8) & 255);
                fArr[2] = (float) (pixel & 255);
                Integer valueOf = Integer.valueOf(Float.floatToIntBits(fArr[0]));
                int[] iArr = (int[]) hashMap.get(valueOf);
                if (iArr == null) {
                    iArr = new int[c];
                    mo8287a(fArr, iArr);
                    hashMap.put(valueOf, iArr);
                }
                createBitmap.setPixel(i2, i, ((((iArr[0] & 16711680) << ((iArr[1] & CipherSuite.DRAFT_TLS_DHE_RSA_WITH_AES_128_OCB) + 16)) << (iArr[0] + 8)) & 255) - 16777216);
            }
        }
        return this.f5996b.mo8253a(createBitmap);
    }

    /* renamed from: a */
    public String mo8286a() {
        return ((C1613i) this.f5960e.mo7485a(1)).mo7596a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8287a(float[] fArr, int[] iArr) {
        if (this.f5997c == null) {
            this.f5997c = new C1758f((C1605b) null);
        }
        if (this.f5996b == null) {
            this.f5996b = C1845m.f5975a;
        }
        fArr[0] = fArr[0] / 255.0f;
        float[] a = this.f5997c.mo7885a(fArr);
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = (int) (a[i] * 255.0f);
        }
    }

    /* renamed from: a */
    public float[] mo8257a(float[] fArr) {
        if (this.f5998d == null) {
            this.f5998d = new HashMap();
        }
        int i = (int) (fArr[0] * 255.0f);
        float[] fArr2 = this.f5998d.get(Integer.valueOf(i));
        if (fArr2 != null) {
            return fArr2;
        }
        try {
            if (this.f5997c == null) {
                this.f5997c = new C1758f((C1605b) null);
            }
            if (this.f5996b == null) {
                this.f5996b = C1845m.f5975a;
            }
            float[] a = this.f5996b.mo8257a(this.f5997c.mo7885a(fArr));
            this.f5998d.put(Integer.valueOf(i), a);
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return fArr;
        }
    }

    /* renamed from: b */
    public String mo8258b() {
        return C1613i.f5281gs.mo7596a();
    }

    /* renamed from: c */
    public int mo8259c() {
        return 1;
    }

    /* renamed from: e */
    public C1837e mo8260e() {
        return this.f5995a;
    }

    public String toString() {
        if (this.f5997c == null) {
            this.f5997c = new C1758f((C1605b) null);
        }
        if (this.f5996b == null) {
            this.f5996b = C1845m.f5975a;
        }
        return mo8258b() + "{\"" + mo8286a() + "\" " + this.f5996b.mo8258b() + " " + this.f5997c + "}";
    }
}
