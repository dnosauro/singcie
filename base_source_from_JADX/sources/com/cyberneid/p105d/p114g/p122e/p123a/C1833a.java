package com.cyberneid.p105d.p114g.p122e.p123a;

import android.graphics.Bitmap;
import org.spongycastle.crypto.tls.CipherSuite;

/* renamed from: com.cyberneid.d.g.e.a.a */
public abstract class C1833a extends C1838f {
    /* renamed from: a */
    public Bitmap mo8253a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
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
                float[] a = mo8257a(fArr);
                a[0] = a[0] * 255.0f;
                a[1] = a[1] * 255.0f;
                a[2] = a[2] * 255.0f;
                createBitmap.setPixel(i2, i, ((((((int) a[0]) & 16711680) << ((((int) a[1]) & CipherSuite.DRAFT_TLS_DHE_RSA_WITH_AES_128_OCB) + 16)) << (((int) a[0]) + 8)) & 255) - 16777216);
            }
        }
        return createBitmap;
    }

    public String toString() {
        return mo8258b();
    }
}
