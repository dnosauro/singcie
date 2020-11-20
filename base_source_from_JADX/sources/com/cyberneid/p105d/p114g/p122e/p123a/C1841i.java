package com.cyberneid.p105d.p114g.p122e.p123a;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import com.cyberneid.p105d.p108b.C1613i;
import java.nio.ByteBuffer;

/* renamed from: com.cyberneid.d.g.e.a.i */
public final class C1841i extends C1840h {

    /* renamed from: a */
    public static final C1841i f5963a = new C1841i();

    /* renamed from: b */
    private final C1837e f5964b = new C1837e(new float[]{0.0f}, (C1838f) this);

    private C1841i() {
    }

    /* renamed from: a */
    public Bitmap mo8253a(Bitmap bitmap) {
        if (bitmap.getConfig() != Bitmap.Config.ALPHA_8) {
            Log.e("PdfBox-Android", "Raster in PDDevicGrey was not ALPHA_8");
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * height);
        bitmap.copyPixelsToBuffer(allocate);
        byte[] array = allocate.array();
        int i = width * height;
        int[] iArr = new int[i];
        createBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        for (int i2 = 0; i2 < i; i2++) {
            byte b = array[i2];
            iArr[i2] = Color.argb(255, b, b, b);
        }
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    /* renamed from: a */
    public float[] mo8257a(float[] fArr) {
        return new float[]{fArr[0], fArr[0], fArr[0]};
    }

    /* renamed from: b */
    public String mo8258b() {
        return C1613i.f5015br.mo7596a();
    }

    /* renamed from: c */
    public int mo8259c() {
        return 1;
    }

    /* renamed from: e */
    public C1837e mo8260e() {
        return this.f5964b;
    }
}
