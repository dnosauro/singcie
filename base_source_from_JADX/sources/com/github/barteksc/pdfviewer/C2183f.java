package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseBooleanArray;
import com.github.barteksc.pdfviewer.p140a.C2155a;
import com.github.barteksc.pdfviewer.p146g.C2192b;
import com.github.barteksc.pdfviewer.p146g.C2194d;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.github.barteksc.pdfviewer.f */
class C2183f {

    /* renamed from: a */
    private static final Object f6773a = new Object();

    /* renamed from: b */
    private PdfDocument f6774b;

    /* renamed from: c */
    private PdfiumCore f6775c;

    /* renamed from: d */
    private int f6776d = 0;

    /* renamed from: e */
    private List<Size> f6777e = new ArrayList();

    /* renamed from: f */
    private List<SizeF> f6778f = new ArrayList();

    /* renamed from: g */
    private SparseBooleanArray f6779g = new SparseBooleanArray();

    /* renamed from: h */
    private Size f6780h = new Size(0, 0);

    /* renamed from: i */
    private Size f6781i = new Size(0, 0);

    /* renamed from: j */
    private SizeF f6782j = new SizeF(0.0f, 0.0f);

    /* renamed from: k */
    private SizeF f6783k = new SizeF(0.0f, 0.0f);

    /* renamed from: l */
    private boolean f6784l;

    /* renamed from: m */
    private int f6785m;

    /* renamed from: n */
    private boolean f6786n;

    /* renamed from: o */
    private List<Float> f6787o = new ArrayList();

    /* renamed from: p */
    private List<Float> f6788p = new ArrayList();

    /* renamed from: q */
    private float f6789q = 0.0f;

    /* renamed from: r */
    private final C2192b f6790r;

    /* renamed from: s */
    private final boolean f6791s;

    /* renamed from: t */
    private int[] f6792t;

    C2183f(PdfiumCore pdfiumCore, PdfDocument pdfDocument, C2192b bVar, Size size, int[] iArr, boolean z, int i, boolean z2, boolean z3) {
        this.f6775c = pdfiumCore;
        this.f6774b = pdfDocument;
        this.f6790r = bVar;
        this.f6792t = iArr;
        this.f6784l = z;
        this.f6785m = i;
        this.f6786n = z2;
        this.f6791s = z3;
        m8584b(size);
    }

    /* renamed from: b */
    private void m8584b(Size size) {
        int[] iArr = this.f6792t;
        this.f6776d = iArr != null ? iArr.length : this.f6775c.mo23989a(this.f6774b);
        for (int i = 0; i < this.f6776d; i++) {
            Size b = this.f6775c.mo23996b(this.f6774b, mo9162f(i));
            if (b.mo24001a() > this.f6780h.mo24001a()) {
                this.f6780h = b;
            }
            if (b.mo24002b() > this.f6781i.mo24002b()) {
                this.f6781i = b;
            }
            this.f6777e.add(b);
        }
        mo9149a(size);
    }

    /* renamed from: c */
    private void m8585c(Size size) {
        float f;
        float f2;
        this.f6788p.clear();
        for (int i = 0; i < mo9143a(); i++) {
            SizeF sizeF = this.f6778f.get(i);
            if (this.f6784l) {
                f = (float) size.mo24002b();
                f2 = sizeF.mo24007b();
            } else {
                f = (float) size.mo24001a();
                f2 = sizeF.mo24006a();
            }
            float max = Math.max(0.0f, f - f2);
            if (i < mo9143a() - 1) {
                max += (float) this.f6785m;
            }
            this.f6788p.add(Float.valueOf(max));
        }
    }

    /* renamed from: h */
    private void m8586h() {
        float f;
        float f2 = 0.0f;
        for (int i = 0; i < mo9143a(); i++) {
            SizeF sizeF = this.f6778f.get(i);
            f2 += this.f6784l ? sizeF.mo24007b() : sizeF.mo24006a();
            if (this.f6786n) {
                f = this.f6788p.get(i).floatValue();
            } else if (i < mo9143a() - 1) {
                f = (float) this.f6785m;
            }
            f2 += f;
        }
        this.f6789q = f2;
    }

    /* renamed from: i */
    private void m8587i() {
        float f;
        float f2;
        this.f6787o.clear();
        float f3 = 0.0f;
        for (int i = 0; i < mo9143a(); i++) {
            SizeF sizeF = this.f6778f.get(i);
            float b = this.f6784l ? sizeF.mo24007b() : sizeF.mo24006a();
            if (this.f6786n) {
                f += this.f6788p.get(i).floatValue() / 2.0f;
                if (i == 0) {
                    f -= ((float) this.f6785m) / 2.0f;
                } else if (i == mo9143a() - 1) {
                    f += ((float) this.f6785m) / 2.0f;
                }
                this.f6787o.add(Float.valueOf(f));
                f2 = this.f6788p.get(i).floatValue() / 2.0f;
            } else {
                this.f6787o.add(Float.valueOf(f));
                f2 = (float) this.f6785m;
            }
            f3 = f + b + f2;
        }
    }

    /* renamed from: a */
    public float mo9142a(float f) {
        return this.f6789q * f;
    }

    /* renamed from: a */
    public int mo9143a() {
        return this.f6776d;
    }

    /* renamed from: a */
    public int mo9144a(float f, float f2) {
        int i = 0;
        int i2 = 0;
        while (i < mo9143a() && (this.f6787o.get(i).floatValue() * f2) - (mo9154c(i, f2) / 2.0f) < f) {
            i2++;
            i++;
        }
        int i3 = i2 - 1;
        if (i3 >= 0) {
            return i3;
        }
        return 0;
    }

    /* renamed from: a */
    public RectF mo9145a(int i, int i2, int i3, int i4, int i5, RectF rectF) {
        return this.f6775c.mo23992a(this.f6774b, mo9162f(i), i2, i3, i4, i5, 0, rectF);
    }

    /* renamed from: a */
    public SizeF mo9146a(int i) {
        return mo9162f(i) < 0 ? new SizeF(0.0f, 0.0f) : this.f6778f.get(i);
    }

    /* renamed from: a */
    public SizeF mo9147a(int i, float f) {
        SizeF a = mo9146a(i);
        return new SizeF(a.mo24006a() * f, a.mo24007b() * f);
    }

    /* renamed from: a */
    public void mo9148a(Bitmap bitmap, int i, Rect rect, boolean z) {
        Bitmap bitmap2 = bitmap;
        this.f6775c.mo23995a(this.f6774b, bitmap2, mo9162f(i), rect.left, rect.top, rect.width(), rect.height(), z);
    }

    /* renamed from: a */
    public void mo9149a(Size size) {
        this.f6778f.clear();
        C2194d dVar = new C2194d(this.f6790r, this.f6780h, this.f6781i, size, this.f6791s);
        this.f6783k = dVar.mo9166a();
        this.f6782j = dVar.mo9168b();
        for (Size a : this.f6777e) {
            this.f6778f.add(dVar.mo9167a(a));
        }
        if (this.f6786n) {
            m8585c(size);
        }
        m8586h();
        m8587i();
    }

    /* renamed from: b */
    public float mo9150b(int i, float f) {
        SizeF a = mo9146a(i);
        return (this.f6784l ? a.mo24007b() : a.mo24006a()) * f;
    }

    /* renamed from: b */
    public SizeF mo9151b() {
        return this.f6784l ? this.f6783k : this.f6782j;
    }

    /* renamed from: b */
    public boolean mo9152b(int i) {
        int f = mo9162f(i);
        if (f < 0) {
            return false;
        }
        synchronized (f6773a) {
            if (this.f6779g.indexOfKey(f) >= 0) {
                return false;
            }
            try {
                this.f6775c.mo23990a(this.f6774b, f);
                this.f6779g.put(f, true);
                return true;
            } catch (Exception e) {
                this.f6779g.put(f, false);
                throw new C2155a(i, e);
            }
        }
    }

    /* renamed from: c */
    public float mo9153c() {
        return mo9151b().mo24006a();
    }

    /* renamed from: c */
    public float mo9154c(int i, float f) {
        return (this.f6786n ? this.f6788p.get(i).floatValue() : (float) this.f6785m) * f;
    }

    /* renamed from: c */
    public boolean mo9155c(int i) {
        return !this.f6779g.get(mo9162f(i), false);
    }

    /* renamed from: d */
    public float mo9156d() {
        return mo9151b().mo24007b();
    }

    /* renamed from: d */
    public float mo9157d(int i, float f) {
        if (mo9162f(i) < 0) {
            return 0.0f;
        }
        return this.f6787o.get(i).floatValue() * f;
    }

    /* renamed from: d */
    public List<PdfDocument.Link> mo9158d(int i) {
        return this.f6775c.mo23999c(this.f6774b, mo9162f(i));
    }

    /* renamed from: e */
    public float mo9159e(int i, float f) {
        float d;
        float b;
        SizeF a = mo9146a(i);
        if (this.f6784l) {
            d = mo9153c();
            b = a.mo24006a();
        } else {
            d = mo9156d();
            b = a.mo24007b();
        }
        return (f * (d - b)) / 2.0f;
    }

    /* renamed from: e */
    public int mo9160e(int i) {
        int a;
        if (i <= 0) {
            return 0;
        }
        int[] iArr = this.f6792t;
        if (iArr != null) {
            if (i >= iArr.length) {
                a = iArr.length;
            }
            return i;
        }
        if (i >= mo9143a()) {
            a = mo9143a();
        }
        return i;
        return a - 1;
    }

    /* renamed from: e */
    public PdfDocument.Meta mo9161e() {
        PdfDocument pdfDocument = this.f6774b;
        if (pdfDocument == null) {
            return null;
        }
        return this.f6775c.mo23998c(pdfDocument);
    }

    /* renamed from: f */
    public int mo9162f(int i) {
        int i2;
        int[] iArr = this.f6792t;
        if (iArr == null) {
            i2 = i;
        } else if (i < 0 || i >= iArr.length) {
            return -1;
        } else {
            i2 = iArr[i];
        }
        if (i2 < 0 || i >= mo9143a()) {
            return -1;
        }
        return i2;
    }

    /* renamed from: f */
    public List<PdfDocument.Bookmark> mo9163f() {
        PdfDocument pdfDocument = this.f6774b;
        return pdfDocument == null ? new ArrayList() : this.f6775c.mo24000d(pdfDocument);
    }

    /* renamed from: g */
    public void mo9164g() {
        PdfDocument pdfDocument;
        PdfiumCore pdfiumCore = this.f6775c;
        if (!(pdfiumCore == null || (pdfDocument = this.f6774b) == null)) {
            pdfiumCore.mo23997b(pdfDocument);
        }
        this.f6774b = null;
        this.f6792t = null;
    }
}
