package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;
import com.github.barteksc.pdfviewer.p140a.C2155a;
import com.github.barteksc.pdfviewer.p141b.C2158a;
import com.github.barteksc.pdfviewer.p141b.C2159b;
import com.github.barteksc.pdfviewer.p142c.C2161a;
import com.github.barteksc.pdfviewer.p142c.C2162b;
import com.github.barteksc.pdfviewer.p142c.C2163c;
import com.github.barteksc.pdfviewer.p142c.C2164d;
import com.github.barteksc.pdfviewer.p142c.C2165e;
import com.github.barteksc.pdfviewer.p142c.C2166f;
import com.github.barteksc.pdfviewer.p142c.C2167g;
import com.github.barteksc.pdfviewer.p142c.C2168h;
import com.github.barteksc.pdfviewer.p142c.C2169i;
import com.github.barteksc.pdfviewer.p142c.C2170j;
import com.github.barteksc.pdfviewer.p142c.C2171k;
import com.github.barteksc.pdfviewer.p143d.C2174b;
import com.github.barteksc.pdfviewer.p144e.C2182b;
import com.github.barteksc.pdfviewer.p145f.C2184a;
import com.github.barteksc.pdfviewer.p145f.C2185b;
import com.github.barteksc.pdfviewer.p145f.C2186c;
import com.github.barteksc.pdfviewer.p146g.C2189a;
import com.github.barteksc.pdfviewer.p146g.C2192b;
import com.github.barteksc.pdfviewer.p146g.C2193c;
import com.github.barteksc.pdfviewer.p146g.C2196e;
import com.github.barteksc.pdfviewer.p146g.C2197f;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PDFView extends RelativeLayout {

    /* renamed from: e */
    private static final String f6604e = "PDFView";

    /* renamed from: A */
    private boolean f6605A = true;

    /* renamed from: B */
    private boolean f6606B = true;

    /* renamed from: C */
    private boolean f6607C = false;

    /* renamed from: D */
    private boolean f6608D = true;

    /* renamed from: E */
    private PdfiumCore f6609E;

    /* renamed from: F */
    private C2182b f6610F;

    /* renamed from: G */
    private boolean f6611G = false;

    /* renamed from: H */
    private boolean f6612H = false;

    /* renamed from: I */
    private boolean f6613I = false;

    /* renamed from: J */
    private boolean f6614J = false;

    /* renamed from: K */
    private boolean f6615K = true;

    /* renamed from: L */
    private PaintFlagsDrawFilter f6616L = new PaintFlagsDrawFilter(0, 3);

    /* renamed from: M */
    private int f6617M = 0;

    /* renamed from: N */
    private boolean f6618N = false;

    /* renamed from: O */
    private boolean f6619O = true;

    /* renamed from: P */
    private List<Integer> f6620P = new ArrayList(10);
    /* access modifiers changed from: private */

    /* renamed from: Q */
    public boolean f6621Q = false;
    /* access modifiers changed from: private */

    /* renamed from: R */
    public C2148a f6622R;

    /* renamed from: a */
    C2156b f6623a;

    /* renamed from: b */
    C2183f f6624b;

    /* renamed from: c */
    C2198h f6625c;

    /* renamed from: d */
    C2161a f6626d = new C2161a();

    /* renamed from: f */
    private float f6627f = 1.0f;

    /* renamed from: g */
    private float f6628g = 1.75f;

    /* renamed from: h */
    private float f6629h = 3.0f;

    /* renamed from: i */
    private C2149b f6630i = C2149b.NONE;

    /* renamed from: j */
    private C2151a f6631j;

    /* renamed from: k */
    private C2172d f6632k;

    /* renamed from: l */
    private int f6633l;

    /* renamed from: m */
    private float f6634m = 0.0f;

    /* renamed from: n */
    private float f6635n = 0.0f;

    /* renamed from: o */
    private float f6636o = 1.0f;

    /* renamed from: p */
    private boolean f6637p = true;

    /* renamed from: q */
    private C2150c f6638q = C2150c.DEFAULT;

    /* renamed from: r */
    private C2160c f6639r;

    /* renamed from: s */
    private HandlerThread f6640s = new HandlerThread("PDF renderer");

    /* renamed from: t */
    private C2175e f6641t;

    /* renamed from: u */
    private Paint f6642u;

    /* renamed from: v */
    private Paint f6643v;

    /* renamed from: w */
    private C2192b f6644w = C2192b.WIDTH;

    /* renamed from: x */
    private boolean f6645x = false;

    /* renamed from: y */
    private int f6646y = 0;

    /* renamed from: z */
    private boolean f6647z = true;

    /* renamed from: com.github.barteksc.pdfviewer.PDFView$a */
    public class C2148a {

        /* renamed from: A */
        private boolean f6648A;

        /* renamed from: B */
        private boolean f6649B;

        /* renamed from: C */
        private boolean f6650C;

        /* renamed from: D */
        private boolean f6651D;

        /* renamed from: b */
        private final C2185b f6653b;

        /* renamed from: c */
        private int[] f6654c;

        /* renamed from: d */
        private boolean f6655d;

        /* renamed from: e */
        private boolean f6656e;

        /* renamed from: f */
        private C2162b f6657f;

        /* renamed from: g */
        private C2162b f6658g;

        /* renamed from: h */
        private C2164d f6659h;

        /* renamed from: i */
        private C2163c f6660i;

        /* renamed from: j */
        private C2166f f6661j;

        /* renamed from: k */
        private C2169i f6662k;

        /* renamed from: l */
        private C2168h f6663l;

        /* renamed from: m */
        private C2170j f6664m;

        /* renamed from: n */
        private C2171k f6665n;

        /* renamed from: o */
        private C2165e f6666o;

        /* renamed from: p */
        private C2167g f6667p;

        /* renamed from: q */
        private C2159b f6668q;

        /* renamed from: r */
        private int f6669r;

        /* renamed from: s */
        private boolean f6670s;

        /* renamed from: t */
        private boolean f6671t;

        /* renamed from: u */
        private String f6672u;

        /* renamed from: v */
        private C2182b f6673v;

        /* renamed from: w */
        private boolean f6674w;

        /* renamed from: x */
        private int f6675x;

        /* renamed from: y */
        private boolean f6676y;

        /* renamed from: z */
        private C2192b f6677z;

        private C2148a(C2185b bVar) {
            this.f6654c = null;
            this.f6655d = true;
            this.f6656e = true;
            this.f6668q = new C2158a(PDFView.this);
            this.f6669r = 0;
            this.f6670s = false;
            this.f6671t = false;
            this.f6672u = null;
            this.f6673v = null;
            this.f6674w = true;
            this.f6675x = 0;
            this.f6676y = false;
            this.f6677z = C2192b.WIDTH;
            this.f6648A = false;
            this.f6649B = false;
            this.f6650C = false;
            this.f6651D = false;
            this.f6653b = bVar;
        }

        /* renamed from: a */
        public C2148a mo9024a(int i) {
            this.f6669r = i;
            return this;
        }

        /* renamed from: a */
        public C2148a mo9025a(C2164d dVar) {
            this.f6659h = dVar;
            return this;
        }

        /* renamed from: a */
        public C2148a mo9026a(C2166f fVar) {
            this.f6661j = fVar;
            return this;
        }

        /* renamed from: a */
        public C2148a mo9027a(C2167g gVar) {
            this.f6667p = gVar;
            return this;
        }

        /* renamed from: a */
        public C2148a mo9028a(C2169i iVar) {
            this.f6662k = iVar;
            return this;
        }

        /* renamed from: a */
        public C2148a mo9029a(C2182b bVar) {
            this.f6673v = bVar;
            return this;
        }

        /* renamed from: a */
        public C2148a mo9030a(boolean z) {
            this.f6671t = z;
            return this;
        }

        /* renamed from: a */
        public void mo9031a() {
            if (!PDFView.this.f6621Q) {
                C2148a unused = PDFView.this.f6622R = this;
                return;
            }
            PDFView.this.mo8975c();
            PDFView.this.f6626d.mo9081a(this.f6659h);
            PDFView.this.f6626d.mo9080a(this.f6660i);
            PDFView.this.f6626d.mo9079a(this.f6657f);
            PDFView.this.f6626d.mo9095b(this.f6658g);
            PDFView.this.f6626d.mo9083a(this.f6661j);
            PDFView.this.f6626d.mo9085a(this.f6663l);
            PDFView.this.f6626d.mo9087a(this.f6664m);
            PDFView.this.f6626d.mo9088a(this.f6665n);
            PDFView.this.f6626d.mo9082a(this.f6666o);
            PDFView.this.f6626d.mo9084a(this.f6667p);
            PDFView.this.f6626d.mo9086a(this.f6662k);
            PDFView.this.f6626d.mo9078a(this.f6668q);
            PDFView.this.setSwipeEnabled(this.f6655d);
            PDFView.this.setNightMode(this.f6651D);
            PDFView.this.mo8967a(this.f6656e);
            PDFView.this.setDefaultPage(this.f6669r);
            PDFView.this.setSwipeVertical(!this.f6670s);
            PDFView.this.mo8972b(this.f6671t);
            PDFView.this.setScrollHandle(this.f6673v);
            PDFView.this.mo8978c(this.f6674w);
            PDFView.this.setSpacing(this.f6675x);
            PDFView.this.setAutoSpacing(this.f6676y);
            PDFView.this.setPageFitPolicy(this.f6677z);
            PDFView.this.setFitEachPage(this.f6648A);
            PDFView.this.setPageSnap(this.f6650C);
            PDFView.this.setPageFling(this.f6649B);
            int[] iArr = this.f6654c;
            if (iArr != null) {
                PDFView.this.m8420a(this.f6653b, this.f6672u, iArr);
            } else {
                PDFView.this.m8419a(this.f6653b, this.f6672u);
            }
        }

        /* renamed from: b */
        public C2148a mo9032b(int i) {
            this.f6675x = i;
            return this;
        }

        /* renamed from: b */
        public C2148a mo9033b(boolean z) {
            this.f6676y = z;
            return this;
        }

        /* renamed from: c */
        public C2148a mo9034c(boolean z) {
            this.f6650C = z;
            return this;
        }

        /* renamed from: d */
        public C2148a mo9035d(boolean z) {
            this.f6649B = z;
            return this;
        }
    }

    /* renamed from: com.github.barteksc.pdfviewer.PDFView$b */
    enum C2149b {
        NONE,
        START,
        END
    }

    /* renamed from: com.github.barteksc.pdfviewer.PDFView$c */
    private enum C2150c {
        DEFAULT,
        LOADED,
        SHOWN,
        ERROR
    }

    public PDFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            this.f6623a = new C2156b();
            this.f6631j = new C2151a(this);
            this.f6632k = new C2172d(this, this.f6631j);
            this.f6641t = new C2175e(this);
            this.f6642u = new Paint();
            this.f6643v = new Paint();
            this.f6643v.setStyle(Paint.Style.STROKE);
            this.f6609E = new PdfiumCore(context);
            setWillNotDraw(false);
        }
    }

    /* renamed from: a */
    private void m8411a(Canvas canvas, int i, C2162b bVar) {
        float f;
        if (bVar != null) {
            float f2 = 0.0f;
            if (this.f6647z) {
                f2 = this.f6624b.mo9157d(i, this.f6636o);
                f = 0.0f;
            } else {
                f = this.f6624b.mo9157d(i, this.f6636o);
            }
            canvas.translate(f, f2);
            SizeF a = this.f6624b.mo9146a(i);
            bVar.mo9097a(canvas, mo8968b(a.mo24006a()), mo8968b(a.mo24007b()), i);
            canvas.translate(-f, -f2);
        }
    }

    /* renamed from: a */
    private void m8412a(Canvas canvas, C2174b bVar) {
        float f;
        float f2;
        RectF d = bVar.mo9123d();
        Bitmap c = bVar.mo9122c();
        if (!c.isRecycled()) {
            SizeF a = this.f6624b.mo9146a(bVar.mo9121b());
            if (this.f6647z) {
                f2 = this.f6624b.mo9157d(bVar.mo9121b(), this.f6636o);
                f = mo8968b(this.f6624b.mo9153c() - a.mo24006a()) / 2.0f;
            } else {
                f = this.f6624b.mo9157d(bVar.mo9121b(), this.f6636o);
                f2 = mo8968b(this.f6624b.mo9156d() - a.mo24007b()) / 2.0f;
            }
            canvas.translate(f, f2);
            Rect rect = new Rect(0, 0, c.getWidth(), c.getHeight());
            float b = mo8968b(d.left * a.mo24006a());
            float b2 = mo8968b(d.top * a.mo24007b());
            RectF rectF = new RectF((float) ((int) b), (float) ((int) b2), (float) ((int) (b + mo8968b(d.width() * a.mo24006a()))), (float) ((int) (b2 + mo8968b(d.height() * a.mo24007b()))));
            float f3 = this.f6634m + f;
            float f4 = this.f6635n + f2;
            if (rectF.left + f3 < ((float) getWidth()) && f3 + rectF.right > 0.0f && rectF.top + f4 < ((float) getHeight()) && f4 + rectF.bottom > 0.0f) {
                canvas.drawBitmap(c, rect, rectF, this.f6642u);
                if (C2189a.f6795a) {
                    this.f6643v.setColor(bVar.mo9121b() % 2 == 0 ? -65536 : -16776961);
                    canvas.drawRect(rectF, this.f6643v);
                }
            }
            canvas.translate(-f, -f2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8419a(C2185b bVar, String str) {
        m8420a(bVar, str, (int[]) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8420a(C2185b bVar, String str, int[] iArr) {
        if (this.f6637p) {
            this.f6637p = false;
            this.f6639r = new C2160c(bVar, str, iArr, this, this.f6609E);
            this.f6639r.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        throw new IllegalStateException("Don't call load on a PDF View without recycling it first.");
    }

    /* access modifiers changed from: private */
    public void setAutoSpacing(boolean z) {
        this.f6618N = z;
    }

    /* access modifiers changed from: private */
    public void setDefaultPage(int i) {
        this.f6646y = i;
    }

    /* access modifiers changed from: private */
    public void setFitEachPage(boolean z) {
        this.f6645x = z;
    }

    /* access modifiers changed from: private */
    public void setPageFitPolicy(C2192b bVar) {
        this.f6644w = bVar;
    }

    /* access modifiers changed from: private */
    public void setScrollHandle(C2182b bVar) {
        this.f6610F = bVar;
    }

    /* access modifiers changed from: private */
    public void setSpacing(int i) {
        this.f6617M = C2197f.m8626a(getContext(), i);
    }

    /* access modifiers changed from: private */
    public void setSwipeVertical(boolean z) {
        this.f6647z = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo8951a(int i, C2196e eVar) {
        float f;
        float d = this.f6624b.mo9157d(i, this.f6636o);
        float height = (float) (this.f6647z ? getHeight() : getWidth());
        float b = this.f6624b.mo9150b(i, this.f6636o);
        if (eVar == C2196e.CENTER) {
            f = d - (height / 2.0f);
            b /= 2.0f;
        } else if (eVar != C2196e.END) {
            return d;
        } else {
            f = d - height;
        }
        return f + b;
    }

    /* renamed from: a */
    public C2148a mo8952a(File file) {
        return new C2148a(new C2186c(file));
    }

    /* renamed from: a */
    public C2148a mo8953a(byte[] bArr) {
        return new C2148a(new C2184a(bArr));
    }

    /* renamed from: a */
    public void mo8954a() {
        this.f6631j.mo9043c();
    }

    /* renamed from: a */
    public void mo8955a(float f) {
        this.f6636o = f;
    }

    /* renamed from: a */
    public void mo8956a(float f, float f2) {
        mo8958a(f, f2, true);
    }

    /* renamed from: a */
    public void mo8957a(float f, float f2, float f3) {
        this.f6631j.mo9039a(f, f2, this.f6636o, f3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        if (r7 > r0) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        r0 = com.github.barteksc.pdfviewer.PDFView.C2149b.f6679b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        r0 = com.github.barteksc.pdfviewer.PDFView.C2149b.f6678a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f0, code lost:
        if (r6 > r0) goto L_0x007c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ee  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8958a(float r6, float r7, boolean r8) {
        /*
            r5 = this;
            boolean r0 = r5.f6647z
            r1 = 1073741824(0x40000000, float:2.0)
            r2 = 0
            if (r0 == 0) goto L_0x0082
            com.github.barteksc.pdfviewer.f r0 = r5.f6624b
            float r0 = r0.mo9153c()
            float r0 = r5.mo8968b((float) r0)
            int r3 = r5.getWidth()
            float r3 = (float) r3
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0024
            int r6 = r5.getWidth()
            int r6 = r6 / 2
            float r6 = (float) r6
            float r0 = r0 / r1
        L_0x0022:
            float r6 = r6 - r0
            goto L_0x003b
        L_0x0024:
            int r3 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x002a
            r6 = 0
            goto L_0x003b
        L_0x002a:
            float r3 = r6 + r0
            int r4 = r5.getWidth()
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x003b
            int r6 = r5.getWidth()
            float r6 = (float) r6
            goto L_0x0022
        L_0x003b:
            com.github.barteksc.pdfviewer.f r0 = r5.f6624b
            float r3 = r5.f6636o
            float r0 = r0.mo9142a((float) r3)
            int r3 = r5.getHeight()
            float r3 = (float) r3
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0054
            int r7 = r5.getHeight()
            float r7 = (float) r7
            float r7 = r7 - r0
            float r7 = r7 / r1
            goto L_0x006c
        L_0x0054:
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x005a
            r7 = 0
            goto L_0x006c
        L_0x005a:
            float r1 = r7 + r0
            int r2 = r5.getHeight()
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x006c
            float r7 = -r0
            int r0 = r5.getHeight()
            float r0 = (float) r0
            float r7 = r7 + r0
        L_0x006c:
            float r0 = r5.f6635n
            int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0078
        L_0x0072:
            com.github.barteksc.pdfviewer.PDFView$b r0 = com.github.barteksc.pdfviewer.PDFView.C2149b.END
        L_0x0074:
            r5.f6630i = r0
            goto L_0x00f3
        L_0x0078:
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x007f
        L_0x007c:
            com.github.barteksc.pdfviewer.PDFView$b r0 = com.github.barteksc.pdfviewer.PDFView.C2149b.START
            goto L_0x0074
        L_0x007f:
            com.github.barteksc.pdfviewer.PDFView$b r0 = com.github.barteksc.pdfviewer.PDFView.C2149b.NONE
            goto L_0x0074
        L_0x0082:
            com.github.barteksc.pdfviewer.f r0 = r5.f6624b
            float r0 = r0.mo9156d()
            float r0 = r5.mo8968b((float) r0)
            int r3 = r5.getHeight()
            float r3 = (float) r3
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x009f
            int r7 = r5.getHeight()
            int r7 = r7 / 2
            float r7 = (float) r7
            float r0 = r0 / r1
        L_0x009d:
            float r7 = r7 - r0
            goto L_0x00b6
        L_0x009f:
            int r3 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a5
            r7 = 0
            goto L_0x00b6
        L_0x00a5:
            float r3 = r7 + r0
            int r4 = r5.getHeight()
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x00b6
            int r7 = r5.getHeight()
            float r7 = (float) r7
            goto L_0x009d
        L_0x00b6:
            com.github.barteksc.pdfviewer.f r0 = r5.f6624b
            float r3 = r5.f6636o
            float r0 = r0.mo9142a((float) r3)
            int r3 = r5.getWidth()
            float r3 = (float) r3
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x00cf
            int r6 = r5.getWidth()
            float r6 = (float) r6
            float r6 = r6 - r0
            float r6 = r6 / r1
            goto L_0x00e7
        L_0x00cf:
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x00d5
            r6 = 0
            goto L_0x00e7
        L_0x00d5:
            float r1 = r6 + r0
            int r2 = r5.getWidth()
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x00e7
            float r6 = -r0
            int r0 = r5.getWidth()
            float r0 = (float) r0
            float r6 = r6 + r0
        L_0x00e7:
            float r0 = r5.f6634m
            int r1 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ee
            goto L_0x0072
        L_0x00ee:
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x007f
            goto L_0x007c
        L_0x00f3:
            r5.f6634m = r6
            r5.f6635n = r7
            float r6 = r5.getPositionOffset()
            if (r8 == 0) goto L_0x010c
            com.github.barteksc.pdfviewer.e.b r7 = r5.f6610F
            if (r7 == 0) goto L_0x010c
            boolean r7 = r5.mo9002i()
            if (r7 != 0) goto L_0x010c
            com.github.barteksc.pdfviewer.e.b r7 = r5.f6610F
            r7.setScroll(r6)
        L_0x010c:
            com.github.barteksc.pdfviewer.c.a r7 = r5.f6626d
            int r8 = r5.getCurrentPage()
            r7.mo9076a((int) r8, (float) r6)
            r5.mo8984e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PDFView.mo8958a(float, float, boolean):void");
    }

    /* renamed from: a */
    public void mo8959a(float f, PointF pointF) {
        float f2 = f / this.f6636o;
        mo8955a(f);
        mo8956a((this.f6634m * f2) + (pointF.x - (pointF.x * f2)), (this.f6635n * f2) + (pointF.y - (pointF.y * f2)));
    }

    /* renamed from: a */
    public void mo8960a(float f, boolean z) {
        if (this.f6647z) {
            mo8958a(this.f6634m, ((-this.f6624b.mo9142a(this.f6636o)) + ((float) getHeight())) * f, z);
        } else {
            mo8958a(((-this.f6624b.mo9142a(this.f6636o)) + ((float) getWidth())) * f, this.f6635n, z);
        }
        mo8985f();
    }

    /* renamed from: a */
    public void mo8961a(int i) {
        mo8962a(i, false);
    }

    /* renamed from: a */
    public void mo8962a(int i, boolean z) {
        C2183f fVar = this.f6624b;
        if (fVar != null) {
            int e = fVar.mo9160e(i);
            float f = e == 0 ? 0.0f : -this.f6624b.mo9157d(e, this.f6636o);
            if (this.f6647z) {
                if (z) {
                    this.f6631j.mo9042b(this.f6635n, f);
                } else {
                    mo8956a(this.f6634m, f);
                }
            } else if (z) {
                this.f6631j.mo9038a(this.f6634m, f);
            } else {
                mo8956a(f, this.f6635n);
            }
            mo8971b(e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8963a(C2155a aVar) {
        if (!this.f6626d.mo9090a(aVar.mo9056a(), aVar.getCause())) {
            String str = f6604e;
            Log.e(str, "Cannot open page " + aVar.mo9056a(), aVar.getCause());
        }
    }

    /* renamed from: a */
    public void mo8964a(C2174b bVar) {
        if (this.f6638q == C2150c.LOADED) {
            this.f6638q = C2150c.SHOWN;
            this.f6626d.mo9093b(this.f6624b.mo9143a());
        }
        if (bVar.mo9124e()) {
            this.f6623a.mo9062b(bVar);
        } else {
            this.f6623a.mo9058a(bVar);
        }
        mo8984e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8965a(C2183f fVar) {
        this.f6638q = C2150c.LOADED;
        this.f6624b = fVar;
        HandlerThread handlerThread = this.f6640s;
        if (handlerThread != null && !handlerThread.isAlive()) {
            this.f6640s.start();
        }
        HandlerThread handlerThread2 = this.f6640s;
        if (handlerThread2 != null) {
            this.f6625c = new C2198h(handlerThread2.getLooper(), this);
            this.f6625c.mo9171b();
        }
        C2182b bVar = this.f6610F;
        if (bVar != null) {
            bVar.setupLayout(this);
            this.f6611G = true;
        }
        this.f6632k.mo9103a();
        this.f6626d.mo9075a(fVar.mo9143a());
        mo8962a(this.f6646y, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8966a(Throwable th) {
        this.f6638q = C2150c.ERROR;
        C2163c a = this.f6626d.mo9073a();
        mo8975c();
        invalidate();
        if (a != null) {
            a.mo9098a(th);
        } else {
            Log.e(f6604e, "load pdf error", th);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo8967a(boolean z) {
        this.f6606B = z;
    }

    /* renamed from: b */
    public float mo8968b(float f) {
        return f * this.f6636o;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo8969b(float f, float f2) {
        if (this.f6647z) {
            f = f2;
        }
        float height = (float) (this.f6647z ? getHeight() : getWidth());
        if (f > -1.0f) {
            return 0;
        }
        if (f < (-this.f6624b.mo9142a(this.f6636o)) + height + 1.0f) {
            return this.f6624b.mo9143a() - 1;
        }
        return this.f6624b.mo9144a(-(f - (height / 2.0f)), this.f6636o);
    }

    /* renamed from: b */
    public void mo8970b(float f, PointF pointF) {
        mo8959a(this.f6636o * f, pointF);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo8971b(int i) {
        if (!this.f6637p) {
            this.f6633l = this.f6624b.mo9160e(i);
            mo8983d();
            if (this.f6610F != null && !mo9002i()) {
                this.f6610F.setPageNum(this.f6633l + 1);
            }
            this.f6626d.mo9077a(this.f6633l, this.f6624b.mo9143a());
        }
    }

    /* renamed from: b */
    public void mo8972b(boolean z) {
        this.f6613I = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo8973b() {
        return this.f6606B;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C2196e mo8974c(int i) {
        if (!this.f6608D || i < 0) {
            return C2196e.NONE;
        }
        float f = this.f6647z ? this.f6635n : this.f6634m;
        float f2 = -this.f6624b.mo9157d(i, this.f6636o);
        int height = this.f6647z ? getHeight() : getWidth();
        float b = this.f6624b.mo9150b(i, this.f6636o);
        float f3 = (float) height;
        return f3 >= b ? C2196e.CENTER : f >= f2 ? C2196e.START : f2 - b > f - f3 ? C2196e.END : C2196e.NONE;
    }

    /* renamed from: c */
    public void mo8975c() {
        this.f6622R = null;
        this.f6631j.mo9041b();
        this.f6632k.mo9104b();
        C2198h hVar = this.f6625c;
        if (hVar != null) {
            hVar.mo9169a();
            this.f6625c.removeMessages(1);
        }
        C2160c cVar = this.f6639r;
        if (cVar != null) {
            cVar.cancel(true);
        }
        this.f6623a.mo9064d();
        C2182b bVar = this.f6610F;
        if (bVar != null && this.f6611G) {
            bVar.mo9130a();
        }
        C2183f fVar = this.f6624b;
        if (fVar != null) {
            fVar.mo9164g();
            this.f6624b = null;
        }
        this.f6625c = null;
        this.f6610F = null;
        this.f6611G = false;
        this.f6635n = 0.0f;
        this.f6634m = 0.0f;
        this.f6636o = 1.0f;
        this.f6637p = true;
        this.f6626d = new C2161a();
        this.f6638q = C2150c.DEFAULT;
    }

    /* renamed from: c */
    public void mo8976c(float f) {
        this.f6631j.mo9039a((float) (getWidth() / 2), (float) (getHeight() / 2), this.f6636o, f);
    }

    /* renamed from: c */
    public void mo8977c(float f, float f2) {
        mo8956a(this.f6634m + f, this.f6635n + f2);
    }

    /* renamed from: c */
    public void mo8978c(boolean z) {
        this.f6615K = z;
    }

    public boolean canScrollHorizontally(int i) {
        if (this.f6624b == null) {
            return true;
        }
        if (this.f6647z) {
            if (i >= 0 || this.f6634m >= 0.0f) {
                return i > 0 && this.f6634m + mo8968b(this.f6624b.mo9153c()) > ((float) getWidth());
            }
            return true;
        } else if (i >= 0 || this.f6634m >= 0.0f) {
            return i > 0 && this.f6634m + this.f6624b.mo9142a(this.f6636o) > ((float) getWidth());
        } else {
            return true;
        }
    }

    public boolean canScrollVertically(int i) {
        if (this.f6624b == null) {
            return true;
        }
        if (this.f6647z) {
            if (i >= 0 || this.f6635n >= 0.0f) {
                return i > 0 && this.f6635n + this.f6624b.mo9142a(this.f6636o) > ((float) getHeight());
            }
            return true;
        } else if (i >= 0 || this.f6635n >= 0.0f) {
            return i > 0 && this.f6635n + mo8968b(this.f6624b.mo9156d()) > ((float) getHeight());
        } else {
            return true;
        }
    }

    public void computeScroll() {
        super.computeScroll();
        if (!isInEditMode()) {
            this.f6631j.mo9036a();
        }
    }

    /* renamed from: d */
    public SizeF mo8982d(int i) {
        C2183f fVar = this.f6624b;
        return fVar == null ? new SizeF(0.0f, 0.0f) : fVar.mo9146a(i);
    }

    /* renamed from: d */
    public void mo8983d() {
        C2198h hVar;
        if (this.f6624b != null && (hVar = this.f6625c) != null) {
            hVar.removeMessages(1);
            this.f6623a.mo9057a();
            this.f6641t.mo9126a();
            mo8984e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo8984e() {
        invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo8985f() {
        int i;
        float f;
        if (this.f6624b.mo9143a() != 0) {
            if (this.f6647z) {
                f = this.f6635n;
                i = getHeight();
            } else {
                f = this.f6634m;
                i = getWidth();
            }
            int a = this.f6624b.mo9144a(-(f - (((float) i) / 2.0f)), this.f6636o);
            if (a < 0 || a > this.f6624b.mo9143a() - 1 || a == getCurrentPage()) {
                mo8983d();
            } else {
                mo8971b(a);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = mo8969b(r3.f6634m, r3.f6635n);
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo8986g() {
        /*
            r3 = this;
            boolean r0 = r3.f6608D
            if (r0 == 0) goto L_0x0039
            com.github.barteksc.pdfviewer.f r0 = r3.f6624b
            if (r0 == 0) goto L_0x0039
            int r0 = r0.mo9143a()
            if (r0 != 0) goto L_0x000f
            goto L_0x0039
        L_0x000f:
            float r0 = r3.f6634m
            float r1 = r3.f6635n
            int r0 = r3.mo8969b((float) r0, (float) r1)
            com.github.barteksc.pdfviewer.g.e r1 = r3.mo8974c((int) r0)
            com.github.barteksc.pdfviewer.g.e r2 = com.github.barteksc.pdfviewer.p146g.C2196e.NONE
            if (r1 != r2) goto L_0x0020
            return
        L_0x0020:
            float r0 = r3.mo8951a((int) r0, (com.github.barteksc.pdfviewer.p146g.C2196e) r1)
            boolean r1 = r3.f6647z
            if (r1 == 0) goto L_0x0031
            com.github.barteksc.pdfviewer.a r1 = r3.f6631j
            float r2 = r3.f6635n
            float r0 = -r0
            r1.mo9042b(r2, r0)
            goto L_0x0039
        L_0x0031:
            com.github.barteksc.pdfviewer.a r1 = r3.f6631j
            float r2 = r3.f6634m
            float r0 = -r0
            r1.mo9038a((float) r2, (float) r0)
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PDFView.mo8986g():void");
    }

    public int getCurrentPage() {
        return this.f6633l;
    }

    public float getCurrentXOffset() {
        return this.f6634m;
    }

    public float getCurrentYOffset() {
        return this.f6635n;
    }

    public PdfDocument.Meta getDocumentMeta() {
        C2183f fVar = this.f6624b;
        if (fVar == null) {
            return null;
        }
        return fVar.mo9161e();
    }

    public float getMaxZoom() {
        return this.f6629h;
    }

    public float getMidZoom() {
        return this.f6628g;
    }

    public float getMinZoom() {
        return this.f6627f;
    }

    public int getPageCount() {
        C2183f fVar = this.f6624b;
        if (fVar == null) {
            return 0;
        }
        return fVar.mo9143a();
    }

    public C2192b getPageFitPolicy() {
        return this.f6644w;
    }

    public float getPositionOffset() {
        int i;
        float f;
        float f2;
        if (this.f6647z) {
            f2 = -this.f6635n;
            f = this.f6624b.mo9142a(this.f6636o);
            i = getHeight();
        } else {
            f2 = -this.f6634m;
            f = this.f6624b.mo9142a(this.f6636o);
            i = getWidth();
        }
        return C2193c.m8615a(f2 / (f - ((float) i)), 0.0f, 1.0f);
    }

    /* access modifiers changed from: package-private */
    public C2182b getScrollHandle() {
        return this.f6610F;
    }

    public int getSpacingPx() {
        return this.f6617M;
    }

    public List<PdfDocument.Bookmark> getTableOfContents() {
        C2183f fVar = this.f6624b;
        return fVar == null ? Collections.emptyList() : fVar.mo9163f();
    }

    public float getZoom() {
        return this.f6636o;
    }

    /* renamed from: h */
    public boolean mo9001h() {
        float f = -this.f6624b.mo9157d(this.f6633l, this.f6636o);
        float b = f - this.f6624b.mo9150b(this.f6633l, this.f6636o);
        if (mo9006m()) {
            float f2 = this.f6635n;
            return f > f2 && b < f2 - ((float) getHeight());
        }
        float f3 = this.f6634m;
        return f > f3 && b < f3 - ((float) getWidth());
    }

    /* renamed from: i */
    public boolean mo9002i() {
        float a = this.f6624b.mo9142a(1.0f);
        return this.f6647z ? a < ((float) getHeight()) : a < ((float) getWidth());
    }

    /* renamed from: j */
    public boolean mo9003j() {
        return this.f6636o != this.f6627f;
    }

    /* renamed from: k */
    public void mo9004k() {
        mo8976c(this.f6627f);
    }

    /* renamed from: l */
    public boolean mo9005l() {
        return this.f6612H;
    }

    /* renamed from: m */
    public boolean mo9006m() {
        return this.f6647z;
    }

    /* renamed from: n */
    public boolean mo9007n() {
        return this.f6605A;
    }

    /* renamed from: o */
    public boolean mo9008o() {
        return this.f6613I;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        mo8975c();
        if (this.f6640s != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.f6640s.quitSafely();
            } else {
                this.f6640s.quit();
            }
            this.f6640s = null;
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!isInEditMode()) {
            if (this.f6615K) {
                canvas.setDrawFilter(this.f6616L);
            }
            Drawable background = getBackground();
            if (background == null) {
                canvas.drawColor(this.f6607C ? -16777216 : -1);
            } else {
                background.draw(canvas);
            }
            if (!this.f6637p && this.f6638q == C2150c.SHOWN) {
                float f = this.f6634m;
                float f2 = this.f6635n;
                canvas.translate(f, f2);
                for (C2174b a : this.f6623a.mo9063c()) {
                    m8412a(canvas, a);
                }
                for (C2174b next : this.f6623a.mo9061b()) {
                    m8412a(canvas, next);
                    if (this.f6626d.mo9096c() != null && !this.f6620P.contains(Integer.valueOf(next.mo9121b()))) {
                        this.f6620P.add(Integer.valueOf(next.mo9121b()));
                    }
                }
                for (Integer intValue : this.f6620P) {
                    m8411a(canvas, intValue.intValue(), this.f6626d.mo9096c());
                }
                this.f6620P.clear();
                m8411a(canvas, this.f6633l, this.f6626d.mo9092b());
                canvas.translate(-f, -f2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        this.f6621Q = true;
        C2148a aVar = this.f6622R;
        if (aVar != null) {
            aVar.mo9031a();
        }
        if (!isInEditMode() && this.f6638q == C2150c.SHOWN) {
            float f5 = (-this.f6634m) + (((float) i3) * 0.5f);
            float f6 = (-this.f6635n) + (((float) i4) * 0.5f);
            if (this.f6647z) {
                f2 = f5 / this.f6624b.mo9153c();
                f = this.f6624b.mo9142a(this.f6636o);
            } else {
                f2 = f5 / this.f6624b.mo9142a(this.f6636o);
                f = this.f6624b.mo9156d();
            }
            float f7 = f6 / f;
            this.f6631j.mo9041b();
            this.f6624b.mo9149a(new Size(i, i2));
            if (this.f6647z) {
                this.f6634m = ((-f2) * this.f6624b.mo9153c()) + (((float) i) * 0.5f);
                f4 = -f7;
                f3 = this.f6624b.mo9142a(this.f6636o);
            } else {
                this.f6634m = ((-f2) * this.f6624b.mo9142a(this.f6636o)) + (((float) i) * 0.5f);
                f4 = -f7;
                f3 = this.f6624b.mo9156d();
            }
            this.f6635n = (f4 * f3) + (((float) i2) * 0.5f);
            mo8956a(this.f6634m, this.f6635n);
            mo8985f();
        }
    }

    /* renamed from: p */
    public boolean mo9012p() {
        return this.f6618N;
    }

    /* renamed from: q */
    public boolean mo9013q() {
        return this.f6619O;
    }

    /* renamed from: r */
    public boolean mo9014r() {
        return this.f6645x;
    }

    /* renamed from: s */
    public boolean mo9015s() {
        return this.f6614J;
    }

    public void setMaxZoom(float f) {
        this.f6629h = f;
    }

    public void setMidZoom(float f) {
        this.f6628g = f;
    }

    public void setMinZoom(float f) {
        this.f6627f = f;
    }

    public void setNightMode(boolean z) {
        Paint paint;
        ColorMatrixColorFilter colorMatrixColorFilter;
        this.f6607C = z;
        if (z) {
            colorMatrixColorFilter = new ColorMatrixColorFilter(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
            paint = this.f6642u;
        } else {
            paint = this.f6642u;
            colorMatrixColorFilter = null;
        }
        paint.setColorFilter(colorMatrixColorFilter);
    }

    public void setPageFling(boolean z) {
        this.f6619O = z;
    }

    public void setPageSnap(boolean z) {
        this.f6608D = z;
    }

    public void setPositionOffset(float f) {
        mo8960a(f, true);
    }

    public void setSwipeEnabled(boolean z) {
        this.f6605A = z;
    }
}
