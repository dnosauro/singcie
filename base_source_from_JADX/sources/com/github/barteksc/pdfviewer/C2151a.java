package com.github.barteksc.pdfviewer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;

/* renamed from: com.github.barteksc.pdfviewer.a */
class C2151a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public PDFView f6687a;

    /* renamed from: b */
    private ValueAnimator f6688b;

    /* renamed from: c */
    private OverScroller f6689c;

    /* renamed from: d */
    private boolean f6690d = false;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f6691e = false;

    /* renamed from: com.github.barteksc.pdfviewer.a$a */
    class C2152a extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        C2152a() {
        }

        public void onAnimationCancel(Animator animator) {
            C2151a.this.f6687a.mo8983d();
            boolean unused = C2151a.this.f6691e = false;
            C2151a.this.m8485e();
        }

        public void onAnimationEnd(Animator animator) {
            C2151a.this.f6687a.mo8983d();
            boolean unused = C2151a.this.f6691e = false;
            C2151a.this.m8485e();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C2151a.this.f6687a.mo8956a(((Float) valueAnimator.getAnimatedValue()).floatValue(), C2151a.this.f6687a.getCurrentYOffset());
            C2151a.this.f6687a.mo8985f();
        }
    }

    /* renamed from: com.github.barteksc.pdfviewer.a$b */
    class C2153b extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        C2153b() {
        }

        public void onAnimationCancel(Animator animator) {
            C2151a.this.f6687a.mo8983d();
            boolean unused = C2151a.this.f6691e = false;
            C2151a.this.m8485e();
        }

        public void onAnimationEnd(Animator animator) {
            C2151a.this.f6687a.mo8983d();
            boolean unused = C2151a.this.f6691e = false;
            C2151a.this.m8485e();
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C2151a.this.f6687a.mo8956a(C2151a.this.f6687a.getCurrentXOffset(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
            C2151a.this.f6687a.mo8985f();
        }
    }

    /* renamed from: com.github.barteksc.pdfviewer.a$c */
    class C2154c implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b */
        private final float f6695b;

        /* renamed from: c */
        private final float f6696c;

        public C2154c(float f, float f2) {
            this.f6695b = f;
            this.f6696c = f2;
        }

        public void onAnimationCancel(Animator animator) {
            C2151a.this.f6687a.mo8983d();
            C2151a.this.m8485e();
        }

        public void onAnimationEnd(Animator animator) {
            C2151a.this.f6687a.mo8983d();
            C2151a.this.f6687a.mo8986g();
            C2151a.this.m8485e();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            C2151a.this.f6687a.mo8959a(((Float) valueAnimator.getAnimatedValue()).floatValue(), new PointF(this.f6695b, this.f6696c));
        }
    }

    public C2151a(PDFView pDFView) {
        this.f6687a = pDFView;
        this.f6689c = new OverScroller(pDFView.getContext());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m8485e() {
        if (this.f6687a.getScrollHandle() != null) {
            this.f6687a.getScrollHandle().mo9131b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9036a() {
        if (this.f6689c.computeScrollOffset()) {
            this.f6687a.mo8956a((float) this.f6689c.getCurrX(), (float) this.f6689c.getCurrY());
            this.f6687a.mo8985f();
        } else if (this.f6690d) {
            this.f6690d = false;
            this.f6687a.mo8983d();
            m8485e();
            this.f6687a.mo8986g();
        }
    }

    /* renamed from: a */
    public void mo9037a(float f) {
        if (this.f6687a.mo9006m()) {
            mo9042b(this.f6687a.getCurrentYOffset(), f);
        } else {
            mo9038a(this.f6687a.getCurrentXOffset(), f);
        }
        this.f6691e = true;
    }

    /* renamed from: a */
    public void mo9038a(float f, float f2) {
        mo9041b();
        this.f6688b = ValueAnimator.ofFloat(new float[]{f, f2});
        C2152a aVar = new C2152a();
        this.f6688b.setInterpolator(new DecelerateInterpolator());
        this.f6688b.addUpdateListener(aVar);
        this.f6688b.addListener(aVar);
        this.f6688b.setDuration(400);
        this.f6688b.start();
    }

    /* renamed from: a */
    public void mo9039a(float f, float f2, float f3, float f4) {
        mo9041b();
        this.f6688b = ValueAnimator.ofFloat(new float[]{f3, f4});
        this.f6688b.setInterpolator(new DecelerateInterpolator());
        C2154c cVar = new C2154c(f, f2);
        this.f6688b.addUpdateListener(cVar);
        this.f6688b.addListener(cVar);
        this.f6688b.setDuration(400);
        this.f6688b.start();
    }

    /* renamed from: a */
    public void mo9040a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        mo9041b();
        this.f6690d = true;
        this.f6689c.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    /* renamed from: b */
    public void mo9041b() {
        ValueAnimator valueAnimator = this.f6688b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f6688b = null;
        }
        mo9043c();
    }

    /* renamed from: b */
    public void mo9042b(float f, float f2) {
        mo9041b();
        this.f6688b = ValueAnimator.ofFloat(new float[]{f, f2});
        C2153b bVar = new C2153b();
        this.f6688b.setInterpolator(new DecelerateInterpolator());
        this.f6688b.addUpdateListener(bVar);
        this.f6688b.addListener(bVar);
        this.f6688b.setDuration(400);
        this.f6688b.start();
    }

    /* renamed from: c */
    public void mo9043c() {
        this.f6690d = false;
        this.f6689c.forceFinished(true);
    }

    /* renamed from: d */
    public boolean mo9044d() {
        return this.f6690d || this.f6691e;
    }
}
