package com.cyberneid.p105d.p114g.p122e.p123a;

import android.graphics.Bitmap;
import android.util.Log;
import com.cyberneid.p105d.p108b.C1613i;

/* renamed from: com.cyberneid.d.g.e.a.m */
public final class C1845m extends C1840h {

    /* renamed from: a */
    public static final C1845m f5975a = new C1845m();

    /* renamed from: b */
    private final C1837e f5976b = new C1837e(new float[]{0.0f, 0.0f, 0.0f}, (C1838f) this);

    private C1845m() {
    }

    /* renamed from: a */
    public Bitmap mo8253a(Bitmap bitmap) {
        if (bitmap.getConfig() == Bitmap.Config.ALPHA_8) {
            Log.e("PdfBox-Android", "Raster in PDDeviceRGB was ALPHA_8");
        }
        return bitmap;
    }

    /* renamed from: a */
    public float[] mo8257a(float[] fArr) {
        return fArr.length == 3 ? fArr : this.f5976b.mo8264a();
    }

    /* renamed from: b */
    public String mo8258b() {
        return C1613i.f5017bt.mo7596a();
    }

    /* renamed from: c */
    public int mo8259c() {
        return 3;
    }

    /* renamed from: e */
    public C1837e mo8260e() {
        return this.f5976b;
    }
}
