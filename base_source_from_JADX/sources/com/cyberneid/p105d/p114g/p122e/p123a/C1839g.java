package com.cyberneid.p105d.p114g.p122e.p123a;

import android.graphics.Bitmap;
import android.util.Log;
import com.cyberneid.p105d.p108b.C1613i;

/* renamed from: com.cyberneid.d.g.e.a.g */
public final class C1839g extends C1840h {

    /* renamed from: a */
    public static final C1839g f5961a = new C1839g();

    /* renamed from: b */
    private final C1837e f5962b = new C1837e(new float[]{0.0f, 0.0f, 0.0f, 1.0f}, (C1838f) this);

    private C1839g() {
    }

    /* renamed from: a */
    public Bitmap mo8253a(Bitmap bitmap) {
        if (bitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            Log.e("PdfBox-Android", "Raster in PDDeviceCYMK was ARGB_8888");
        }
        return bitmap;
    }

    /* renamed from: a */
    public float[] mo8257a(float[] fArr) {
        return fArr.length == 3 ? fArr : this.f5962b.mo8264a();
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
        return this.f5962b;
    }
}
