package com.cyberneid.p105d.p114g.p122e.p123a;

import android.graphics.Bitmap;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p114g.C1931h;
import com.cyberneid.p105d.p114g.p115a.C1760c;

/* renamed from: com.cyberneid.d.g.e.a.r */
public final class C1850r extends C1852t {

    /* renamed from: a */
    private static C1837e f5992a = new C1837e(new float[0], (C1838f) null);

    /* renamed from: b */
    private final C1931h f5993b;

    /* renamed from: c */
    private C1838f f5994c;

    public C1850r(C1931h hVar) {
        this.f5993b = hVar;
        this.f5960e = new C1604a();
        this.f5960e.mo7490a((C1605b) C1613i.f5235fz);
        this.f5994c = C1845m.f5975a;
    }

    public C1850r(C1931h hVar, C1838f fVar) {
        this.f5993b = hVar;
        this.f5994c = fVar;
        this.f5960e = new C1604a();
        this.f5960e.mo7490a((C1605b) C1613i.f5235fz);
        this.f5960e.mo7491a((C1760c) fVar);
    }

    /* renamed from: a */
    public Bitmap mo8253a(Bitmap bitmap) {
        try {
            return this.f5994c.mo8253a(bitmap);
        } catch (Exception unused) {
            return C1845m.f5975a.mo8253a(bitmap);
        }
    }

    /* renamed from: a */
    public float[] mo8257a(float[] fArr) {
        try {
            return this.f5994c.mo8257a(fArr);
        } catch (Exception unused) {
            return C1845m.f5975a.mo8257a(fArr);
        }
    }

    /* renamed from: b */
    public String mo8258b() {
        return C1613i.f5235fz.mo7596a();
    }

    /* renamed from: c */
    public int mo8259c() {
        try {
            return this.f5994c.mo8259c();
        } catch (Exception unused) {
            return C1845m.f5975a.mo8259c();
        }
    }

    /* renamed from: e */
    public C1837e mo8260e() {
        return f5992a;
    }

    public String toString() {
        return "Pattern";
    }
}
