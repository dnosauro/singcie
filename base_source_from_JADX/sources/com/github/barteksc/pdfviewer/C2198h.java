package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.github.barteksc.pdfviewer.p140a.C2155a;
import com.github.barteksc.pdfviewer.p143d.C2174b;

/* renamed from: com.github.barteksc.pdfviewer.h */
class C2198h extends Handler {

    /* renamed from: a */
    private static final String f6822a = "com.github.barteksc.pdfviewer.h";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public PDFView f6823b;

    /* renamed from: c */
    private RectF f6824c = new RectF();

    /* renamed from: d */
    private Rect f6825d = new Rect();

    /* renamed from: e */
    private Matrix f6826e = new Matrix();

    /* renamed from: f */
    private boolean f6827f = false;

    /* renamed from: com.github.barteksc.pdfviewer.h$a */
    private class C2201a {

        /* renamed from: a */
        float f6832a;

        /* renamed from: b */
        float f6833b;

        /* renamed from: c */
        RectF f6834c;

        /* renamed from: d */
        int f6835d;

        /* renamed from: e */
        boolean f6836e;

        /* renamed from: f */
        int f6837f;

        /* renamed from: g */
        boolean f6838g;

        /* renamed from: h */
        boolean f6839h;

        C2201a(float f, float f2, RectF rectF, int i, boolean z, int i2, boolean z2, boolean z3) {
            this.f6835d = i;
            this.f6832a = f;
            this.f6833b = f2;
            this.f6834c = rectF;
            this.f6836e = z;
            this.f6837f = i2;
            this.f6838g = z2;
            this.f6839h = z3;
        }
    }

    C2198h(Looper looper, PDFView pDFView) {
        super(looper);
        this.f6823b = pDFView;
    }

    /* renamed from: a */
    private C2174b m8628a(C2201a aVar) {
        C2183f fVar = this.f6823b.f6624b;
        fVar.mo9152b(aVar.f6835d);
        int round = Math.round(aVar.f6832a);
        int round2 = Math.round(aVar.f6833b);
        if (!(round == 0 || round2 == 0 || fVar.mo9155c(aVar.f6835d))) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(round, round2, aVar.f6838g ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                m8629a(round, round2, aVar.f6834c);
                fVar.mo9148a(createBitmap, aVar.f6835d, this.f6825d, aVar.f6839h);
                return new C2174b(aVar.f6835d, createBitmap, aVar.f6834c, aVar.f6836e, aVar.f6837f);
            } catch (IllegalArgumentException e) {
                Log.e(f6822a, "Cannot create bitmap", e);
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m8629a(int i, int i2, RectF rectF) {
        this.f6826e.reset();
        float f = (float) i;
        float f2 = (float) i2;
        this.f6826e.postTranslate((-rectF.left) * f, (-rectF.top) * f2);
        this.f6826e.postScale(1.0f / rectF.width(), 1.0f / rectF.height());
        this.f6824c.set(0.0f, 0.0f, f, f2);
        this.f6826e.mapRect(this.f6824c);
        this.f6824c.round(this.f6825d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9169a() {
        this.f6827f = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9170a(int i, float f, float f2, RectF rectF, boolean z, int i2, boolean z2, boolean z3) {
        sendMessage(obtainMessage(1, new C2201a(f, f2, rectF, i, z, i2, z2, z3)));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9171b() {
        this.f6827f = true;
    }

    public void handleMessage(Message message) {
        try {
            final C2174b a = m8628a((C2201a) message.obj);
            if (a == null) {
                return;
            }
            if (this.f6827f) {
                this.f6823b.post(new Runnable() {
                    public void run() {
                        C2198h.this.f6823b.mo8964a(a);
                    }
                });
            } else {
                a.mo9122c().recycle();
            }
        } catch (C2155a e) {
            this.f6823b.post(new Runnable() {
                public void run() {
                    C2198h.this.f6823b.mo8963a(e);
                }
            });
        }
    }
}
