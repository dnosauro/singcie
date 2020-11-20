package com.github.barteksc.pdfviewer;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.github.barteksc.pdfviewer.p143d.C2173a;
import com.github.barteksc.pdfviewer.p144e.C2182b;
import com.github.barteksc.pdfviewer.p146g.C2189a;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.util.SizeF;

/* renamed from: com.github.barteksc.pdfviewer.d */
class C2172d implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {

    /* renamed from: a */
    private PDFView f6725a;

    /* renamed from: b */
    private C2151a f6726b;

    /* renamed from: c */
    private GestureDetector f6727c;

    /* renamed from: d */
    private ScaleGestureDetector f6728d;

    /* renamed from: e */
    private boolean f6729e = false;

    /* renamed from: f */
    private boolean f6730f = false;

    /* renamed from: g */
    private boolean f6731g = false;

    C2172d(PDFView pDFView, C2151a aVar) {
        this.f6725a = pDFView;
        this.f6726b = aVar;
        this.f6727c = new GestureDetector(pDFView.getContext(), this);
        this.f6728d = new ScaleGestureDetector(pDFView.getContext(), this);
        pDFView.setOnTouchListener(this);
    }

    /* renamed from: a */
    private void m8549a(MotionEvent motionEvent) {
        this.f6725a.mo8983d();
        m8553c();
        if (!this.f6726b.mo9044d()) {
            this.f6725a.mo8986g();
        }
    }

    /* renamed from: a */
    private void m8550a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float f3;
        float f4;
        if (m8554c(f, f2)) {
            int i = -1;
            if (!this.f6725a.mo9006m() ? f <= 0.0f : f2 <= 0.0f) {
                i = 1;
            }
            if (this.f6725a.mo9006m()) {
                f3 = motionEvent2.getY();
                f4 = motionEvent.getY();
            } else {
                f3 = motionEvent2.getX();
                f4 = motionEvent.getX();
            }
            float f5 = f3 - f4;
            int max = Math.max(0, Math.min(this.f6725a.getPageCount() - 1, this.f6725a.mo8969b(this.f6725a.getCurrentXOffset() - (this.f6725a.getZoom() * f5), this.f6725a.getCurrentYOffset() - (f5 * this.f6725a.getZoom())) + i));
            this.f6726b.mo9037a(-this.f6725a.mo8951a(max, this.f6725a.mo8974c(max)));
        }
    }

    /* renamed from: a */
    private boolean m8551a(float f, float f2) {
        int i;
        int i2;
        C2183f fVar = this.f6725a.f6624b;
        if (fVar == null) {
            return false;
        }
        float f3 = (-this.f6725a.getCurrentXOffset()) + f;
        float f4 = (-this.f6725a.getCurrentYOffset()) + f2;
        int a = fVar.mo9144a(this.f6725a.mo9006m() ? f4 : f3, this.f6725a.getZoom());
        SizeF a2 = fVar.mo9147a(a, this.f6725a.getZoom());
        if (this.f6725a.mo9006m()) {
            i2 = (int) fVar.mo9159e(a, this.f6725a.getZoom());
            i = (int) fVar.mo9157d(a, this.f6725a.getZoom());
        } else {
            i = (int) fVar.mo9159e(a, this.f6725a.getZoom());
            i2 = (int) fVar.mo9157d(a, this.f6725a.getZoom());
        }
        for (PdfDocument.Link next : fVar.mo9158d(a)) {
            RectF a3 = fVar.mo9145a(a, i2, i, (int) a2.mo24006a(), (int) a2.mo24007b(), next.mo23988c());
            a3.sort();
            if (a3.contains(f3, f4)) {
                this.f6725a.f6626d.mo9089a(new C2173a(f, f2, f3, f4, a3, next));
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m8552b(float f, float f2) {
        float f3;
        float f4;
        int currentXOffset = (int) this.f6725a.getCurrentXOffset();
        int currentYOffset = (int) this.f6725a.getCurrentYOffset();
        C2183f fVar = this.f6725a.f6624b;
        float f5 = -fVar.mo9157d(this.f6725a.getCurrentPage(), this.f6725a.getZoom());
        float b = f5 - fVar.mo9150b(this.f6725a.getCurrentPage(), this.f6725a.getZoom());
        float f6 = 0.0f;
        if (this.f6725a.mo9006m()) {
            f4 = -(this.f6725a.mo8968b(fVar.mo9153c()) - ((float) this.f6725a.getWidth()));
            f3 = b + ((float) this.f6725a.getHeight());
            f6 = f5;
            f5 = 0.0f;
        } else {
            float width = b + ((float) this.f6725a.getWidth());
            f3 = -(this.f6725a.mo8968b(fVar.mo9156d()) - ((float) this.f6725a.getHeight()));
            f4 = width;
        }
        this.f6726b.mo9040a(currentXOffset, currentYOffset, (int) f, (int) f2, (int) f4, (int) f5, (int) f3, (int) f6);
    }

    /* renamed from: c */
    private void m8553c() {
        C2182b scrollHandle = this.f6725a.getScrollHandle();
        if (scrollHandle != null && scrollHandle.mo9132c()) {
            scrollHandle.mo9131b();
        }
    }

    /* renamed from: c */
    private boolean m8554c(float f, float f2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if (this.f6725a.mo9006m()) {
            if (abs2 > abs) {
                return true;
            }
        } else if (abs > abs2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9103a() {
        this.f6731g = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo9104b() {
        this.f6731g = false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        float f;
        PDFView pDFView;
        float x;
        float y;
        if (!this.f6725a.mo8973b()) {
            return false;
        }
        float minZoom = this.f6725a.getMinZoom();
        if (this.f6725a.getZoom() < this.f6725a.getMidZoom()) {
            pDFView = this.f6725a;
            x = motionEvent.getX();
            y = motionEvent.getY();
            f = this.f6725a.getMidZoom();
        } else if (this.f6725a.getZoom() < this.f6725a.getMaxZoom()) {
            pDFView = this.f6725a;
            x = motionEvent.getX();
            y = motionEvent.getY();
            f = this.f6725a.getMaxZoom();
        } else {
            this.f6725a.mo9004k();
            f = minZoom;
            this.f6725a.f6626d.mo9074a(f / this.f6725a.getMinZoom());
            return true;
        }
        pDFView.mo8957a(x, y, f);
        this.f6725a.f6626d.mo9074a(f / this.f6725a.getMinZoom());
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.f6726b.mo9043c();
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float f3;
        float f4;
        if (!this.f6725a.mo9007n()) {
            return false;
        }
        if (this.f6725a.mo9013q()) {
            if (this.f6725a.mo9001h()) {
                m8552b(f, f2);
            } else {
                m8550a(motionEvent, motionEvent2, f, f2);
            }
            return true;
        }
        int currentXOffset = (int) this.f6725a.getCurrentXOffset();
        int currentYOffset = (int) this.f6725a.getCurrentYOffset();
        C2183f fVar = this.f6725a.f6624b;
        if (this.f6725a.mo9006m()) {
            f3 = -(this.f6725a.mo8968b(fVar.mo9153c()) - ((float) this.f6725a.getWidth()));
            f4 = fVar.mo9142a(this.f6725a.getZoom());
        } else {
            f3 = -(fVar.mo9142a(this.f6725a.getZoom()) - ((float) this.f6725a.getWidth()));
            f4 = this.f6725a.mo8968b(fVar.mo9156d());
        }
        this.f6726b.mo9040a(currentXOffset, currentYOffset, (int) f, (int) f2, (int) f3, 0, (int) (-(f4 - ((float) this.f6725a.getHeight()))), 0);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.f6725a.f6626d.mo9094b(motionEvent);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float zoom = this.f6725a.getZoom() * scaleFactor;
        float min = Math.min(C2189a.C2191b.f6802b, this.f6725a.getMinZoom());
        float min2 = Math.min(C2189a.C2191b.f6801a, this.f6725a.getMaxZoom());
        if (zoom < min) {
            scaleFactor = min / this.f6725a.getZoom();
        } else if (zoom > min2) {
            scaleFactor = min2 / this.f6725a.getZoom();
        }
        this.f6725a.mo8970b(scaleFactor, new PointF(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
        this.f6725a.f6626d.mo9074a(this.f6725a.getZoom() / this.f6725a.getMinZoom());
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.f6730f = true;
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.f6725a.mo8983d();
        m8553c();
        this.f6730f = false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f6729e = true;
        if (this.f6725a.mo9003j() || this.f6725a.mo9007n()) {
            this.f6725a.mo8977c(-f, -f2);
        }
        if (!this.f6730f || this.f6725a.mo9015s()) {
            this.f6725a.mo8985f();
        }
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        C2182b scrollHandle;
        boolean a = this.f6725a.f6626d.mo9091a(motionEvent);
        boolean a2 = m8551a(motionEvent.getX(), motionEvent.getY());
        if (!a && !a2 && (scrollHandle = this.f6725a.getScrollHandle()) != null && !this.f6725a.mo9002i()) {
            if (!scrollHandle.mo9132c()) {
                scrollHandle.mo9133d();
            } else {
                scrollHandle.mo9134e();
            }
        }
        this.f6725a.performClick();
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f6731g) {
            return false;
        }
        boolean z = this.f6727c.onTouchEvent(motionEvent) || this.f6728d.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.f6729e) {
            this.f6729e = false;
            m8549a(motionEvent);
        }
        return z;
    }
}
