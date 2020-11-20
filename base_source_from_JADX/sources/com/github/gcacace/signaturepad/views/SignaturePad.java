package com.github.gcacace.signaturepad.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.github.gcacace.signaturepad.C2202a;
import com.github.gcacace.signaturepad.p147a.C2204a;
import com.github.gcacace.signaturepad.p147a.C2205b;
import com.github.gcacace.signaturepad.p147a.C2206c;
import com.github.gcacace.signaturepad.p147a.C2209f;
import com.github.gcacace.signaturepad.p148b.C2210a;
import com.github.gcacace.signaturepad.p148b.C2211b;
import java.util.ArrayList;
import java.util.List;

public class SignaturePad extends View {

    /* renamed from: a */
    private List<C2209f> f6860a;

    /* renamed from: b */
    private boolean f6861b;

    /* renamed from: c */
    private Boolean f6862c;

    /* renamed from: d */
    private float f6863d;

    /* renamed from: e */
    private float f6864e;

    /* renamed from: f */
    private float f6865f;

    /* renamed from: g */
    private float f6866g;

    /* renamed from: h */
    private RectF f6867h;

    /* renamed from: i */
    private final C2206c f6868i = new C2206c();

    /* renamed from: j */
    private List<C2209f> f6869j = new ArrayList();

    /* renamed from: k */
    private C2205b f6870k = new C2205b();

    /* renamed from: l */
    private C2204a f6871l = new C2204a();

    /* renamed from: m */
    private int f6872m;

    /* renamed from: n */
    private int f6873n;

    /* renamed from: o */
    private float f6874o;

    /* renamed from: p */
    private C2214a f6875p;

    /* renamed from: q */
    private boolean f6876q;

    /* renamed from: r */
    private GestureDetector f6877r;

    /* renamed from: s */
    private final int f6878s = 3;

    /* renamed from: t */
    private final int f6879t = 7;

    /* renamed from: u */
    private final int f6880u = -16777216;

    /* renamed from: v */
    private final float f6881v = 0.9f;

    /* renamed from: w */
    private final boolean f6882w = false;

    /* renamed from: x */
    private Paint f6883x = new Paint();

    /* renamed from: y */
    private Bitmap f6884y = null;

    /* renamed from: z */
    private Canvas f6885z = null;

    /* renamed from: com.github.gcacace.signaturepad.views.SignaturePad$a */
    public interface C2214a {
        /* renamed from: a */
        void mo9211a();

        /* renamed from: b */
        void mo9212b();

        /* renamed from: c */
        void mo9213c();
    }

    /* JADX INFO: finally extract failed */
    public SignaturePad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C2202a.C2203a.SignaturePad, 0, 0);
        try {
            this.f6872m = obtainStyledAttributes.getDimensionPixelSize(C2202a.C2203a.SignaturePad_penMinWidth, m8660b(3.0f));
            this.f6873n = obtainStyledAttributes.getDimensionPixelSize(C2202a.C2203a.SignaturePad_penMaxWidth, m8660b(7.0f));
            this.f6883x.setColor(obtainStyledAttributes.getColor(C2202a.C2203a.SignaturePad_penColor, -16777216));
            this.f6874o = obtainStyledAttributes.getFloat(C2202a.C2203a.SignaturePad_velocityFilterWeight, 0.9f);
            this.f6876q = obtainStyledAttributes.getBoolean(C2202a.C2203a.SignaturePad_clearOnDoubleClick, false);
            obtainStyledAttributes.recycle();
            this.f6883x.setAntiAlias(true);
            this.f6883x.setStyle(Paint.Style.STROKE);
            this.f6883x.setStrokeCap(Paint.Cap.ROUND);
            this.f6883x.setStrokeJoin(Paint.Join.ROUND);
            this.f6867h = new RectF();
            mo9194a();
            this.f6877r = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    return SignaturePad.this.m8664c();
                }
            });
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: a */
    private float m8654a(float f) {
        return Math.max(((float) this.f6873n) / (f + 1.0f), (float) this.f6872m);
    }

    /* renamed from: a */
    private C2205b m8655a(C2209f fVar, C2209f fVar2, C2209f fVar3) {
        float f = fVar.f6857a - fVar2.f6857a;
        float f2 = fVar.f6858b - fVar2.f6858b;
        float f3 = fVar2.f6857a - fVar3.f6857a;
        float f4 = fVar2.f6858b - fVar3.f6858b;
        float f5 = (fVar.f6857a + fVar2.f6857a) / 2.0f;
        float f6 = (fVar.f6858b + fVar2.f6858b) / 2.0f;
        float f7 = (fVar2.f6857a + fVar3.f6857a) / 2.0f;
        float f8 = (fVar2.f6858b + fVar3.f6858b) / 2.0f;
        float sqrt = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        float sqrt2 = (float) Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
        float f9 = f5 - f7;
        float f10 = f6 - f8;
        float f11 = sqrt2 / (sqrt + sqrt2);
        if (Float.isNaN(f11)) {
            f11 = 0.0f;
        }
        float f12 = fVar2.f6857a - ((f9 * f11) + f7);
        float f13 = fVar2.f6858b - ((f10 * f11) + f8);
        return this.f6870k.mo9178a(m8656a(f5 + f12, f6 + f13), m8656a(f7 + f12, f8 + f13));
    }

    /* renamed from: a */
    private C2209f m8656a(float f, float f2) {
        int size = this.f6869j.size();
        return (size == 0 ? new C2209f() : this.f6869j.remove(size - 1)).mo9192a(f, f2);
    }

    /* renamed from: a */
    private void m8657a(C2204a aVar, float f, float f2) {
        this.f6868i.mo9179a(aVar, (f + f2) / 2.0f);
        m8665d();
        float strokeWidth = this.f6883x.getStrokeWidth();
        float f3 = f2 - f;
        float ceil = (float) Math.ceil((double) aVar.mo9176a());
        int i = 0;
        while (true) {
            float f4 = (float) i;
            if (f4 < ceil) {
                float f5 = f4 / ceil;
                float f6 = f5 * f5;
                float f7 = f6 * f5;
                float f8 = 1.0f - f5;
                float f9 = f8 * f8;
                float f10 = f9 * f8;
                float f11 = f9 * 3.0f * f5;
                float f12 = f8 * 3.0f * f6;
                float f13 = (aVar.f6841a.f6857a * f10) + (aVar.f6842b.f6857a * f11) + (aVar.f6843c.f6857a * f12) + (aVar.f6844d.f6857a * f7);
                float f14 = (f10 * aVar.f6841a.f6858b) + (f11 * aVar.f6842b.f6858b) + (f12 * aVar.f6843c.f6858b) + (aVar.f6844d.f6858b * f7);
                this.f6883x.setStrokeWidth((f7 * f3) + f);
                this.f6885z.drawPoint(f13, f14, this.f6883x);
                m8661b(f13, f14);
                i++;
            } else {
                this.f6883x.setStrokeWidth(strokeWidth);
                return;
            }
        }
    }

    /* renamed from: a */
    private void m8658a(C2209f fVar) {
        this.f6869j.add(fVar);
    }

    /* renamed from: b */
    private int m8660b(float f) {
        return Math.round(getContext().getResources().getDisplayMetrics().density * f);
    }

    /* renamed from: b */
    private void m8661b(float f, float f2) {
        if (f < this.f6867h.left) {
            this.f6867h.left = f;
        } else if (f > this.f6867h.right) {
            this.f6867h.right = f;
        }
        if (f2 < this.f6867h.top) {
            this.f6867h.top = f2;
        } else if (f2 > this.f6867h.bottom) {
            this.f6867h.bottom = f2;
        }
    }

    /* renamed from: b */
    private void m8662b(C2209f fVar) {
        this.f6860a.add(fVar);
        int size = this.f6860a.size();
        if (size > 3) {
            C2205b a = m8655a(this.f6860a.get(0), this.f6860a.get(1), this.f6860a.get(2));
            C2209f fVar2 = a.f6846b;
            m8658a(a.f6845a);
            C2205b a2 = m8655a(this.f6860a.get(1), this.f6860a.get(2), this.f6860a.get(3));
            C2209f fVar3 = a2.f6845a;
            m8658a(a2.f6846b);
            C2204a a3 = this.f6871l.mo9177a(this.f6860a.get(1), fVar2, fVar3, this.f6860a.get(2));
            float a4 = a3.f6844d.mo9191a(a3.f6841a);
            if (Float.isNaN(a4)) {
                a4 = 0.0f;
            }
            float f = this.f6874o;
            float f2 = (a4 * f) + ((1.0f - f) * this.f6865f);
            float a5 = m8654a(f2);
            m8657a(a3, this.f6866g, a5);
            this.f6865f = f2;
            this.f6866g = a5;
            m8658a(this.f6860a.remove(0));
            m8658a(fVar2);
            m8658a(fVar3);
        } else if (size == 1) {
            C2209f fVar4 = this.f6860a.get(0);
            this.f6860a.add(m8656a(fVar4.f6857a, fVar4.f6858b));
        }
        this.f6862c = true;
    }

    /* renamed from: c */
    private void m8663c(float f, float f2) {
        this.f6867h.left = Math.min(this.f6863d, f);
        this.f6867h.right = Math.max(this.f6863d, f);
        this.f6867h.top = Math.min(this.f6864e, f2);
        this.f6867h.bottom = Math.max(this.f6864e, f2);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m8664c() {
        if (!this.f6876q) {
            return false;
        }
        mo9194a();
        return true;
    }

    /* renamed from: d */
    private void m8665d() {
        if (this.f6884y == null && getWidth() * getHeight() > 0) {
            this.f6884y = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            this.f6885z = new Canvas(this.f6884y);
        }
    }

    private void setIsEmpty(boolean z) {
        this.f6861b = z;
        C2214a aVar = this.f6875p;
        if (aVar == null) {
            return;
        }
        if (this.f6861b) {
            aVar.mo9213c();
        } else {
            aVar.mo9212b();
        }
    }

    /* renamed from: a */
    public void mo9194a() {
        this.f6868i.mo9181a();
        this.f6860a = new ArrayList();
        this.f6865f = 0.0f;
        this.f6866g = (float) ((this.f6872m + this.f6873n) / 2);
        if (this.f6884y != null) {
            this.f6884y = null;
            m8665d();
        }
        setIsEmpty(true);
        invalidate();
    }

    /* renamed from: b */
    public void mo9195b() {
        mo9194a();
        this.f6862c = true;
    }

    public List<C2209f> getPoints() {
        return this.f6860a;
    }

    public Bitmap getSignatureBitmap() {
        Bitmap transparentSignatureBitmap = getTransparentSignatureBitmap();
        Bitmap createBitmap = Bitmap.createBitmap(transparentSignatureBitmap.getWidth(), transparentSignatureBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        canvas.drawBitmap(transparentSignatureBitmap, 0.0f, 0.0f, (Paint) null);
        return createBitmap;
    }

    public String getSignatureSvg() {
        return this.f6868i.mo9180a(getTransparentSignatureBitmap().getWidth(), getTransparentSignatureBitmap().getHeight());
    }

    public Bitmap getTransparentSignatureBitmap() {
        m8665d();
        return this.f6884y;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f6884y;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f6883x);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.isEnabled()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            float r0 = r6.getX()
            float r2 = r6.getY()
            int r3 = r6.getAction()
            r4 = 1
            switch(r3) {
                case 0: goto L_0x002b;
                case 1: goto L_0x0019;
                case 2: goto L_0x0052;
                default: goto L_0x0018;
            }
        L_0x0018:
            return r1
        L_0x0019:
            r5.m8663c(r0, r2)
            com.github.gcacace.signaturepad.a.f r6 = r5.m8656a(r0, r2)
            r5.m8662b((com.github.gcacace.signaturepad.p147a.C2209f) r6)
            android.view.ViewParent r6 = r5.getParent()
            r6.requestDisallowInterceptTouchEvent(r4)
            goto L_0x005f
        L_0x002b:
            android.view.ViewParent r3 = r5.getParent()
            r3.requestDisallowInterceptTouchEvent(r4)
            java.util.List<com.github.gcacace.signaturepad.a.f> r3 = r5.f6860a
            r3.clear()
            android.view.GestureDetector r3 = r5.f6877r
            boolean r6 = r3.onTouchEvent(r6)
            if (r6 == 0) goto L_0x0040
            goto L_0x005f
        L_0x0040:
            r5.f6863d = r0
            r5.f6864e = r2
            com.github.gcacace.signaturepad.a.f r6 = r5.m8656a(r0, r2)
            r5.m8662b((com.github.gcacace.signaturepad.p147a.C2209f) r6)
            com.github.gcacace.signaturepad.views.SignaturePad$a r6 = r5.f6875p
            if (r6 == 0) goto L_0x0052
            r6.mo9211a()
        L_0x0052:
            r5.m8663c(r0, r2)
            com.github.gcacace.signaturepad.a.f r6 = r5.m8656a(r0, r2)
            r5.m8662b((com.github.gcacace.signaturepad.p147a.C2209f) r6)
            r5.setIsEmpty(r1)
        L_0x005f:
            android.graphics.RectF r6 = r5.f6867h
            float r6 = r6.left
            int r0 = r5.f6873n
            float r0 = (float) r0
            float r6 = r6 - r0
            int r6 = (int) r6
            android.graphics.RectF r0 = r5.f6867h
            float r0 = r0.top
            int r1 = r5.f6873n
            float r1 = (float) r1
            float r0 = r0 - r1
            int r0 = (int) r0
            android.graphics.RectF r1 = r5.f6867h
            float r1 = r1.right
            int r2 = r5.f6873n
            float r2 = (float) r2
            float r1 = r1 + r2
            int r1 = (int) r1
            android.graphics.RectF r2 = r5.f6867h
            float r2 = r2.bottom
            int r3 = r5.f6873n
            float r3 = (float) r3
            float r2 = r2 + r3
            int r2 = (int) r2
            r5.invalidate(r6, r0, r1, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.gcacace.signaturepad.views.SignaturePad.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setMaxWidth(float f) {
        this.f6873n = m8660b(f);
    }

    public void setMinWidth(float f) {
        this.f6872m = m8660b(f);
    }

    public void setOnSignedListener(C2214a aVar) {
        this.f6875p = aVar;
    }

    public void setPenColor(int i) {
        this.f6883x.setColor(i);
    }

    public void setPenColorRes(int i) {
        try {
            setPenColor(getResources().getColor(i));
        } catch (Resources.NotFoundException unused) {
            setPenColor(Color.parseColor("#000000"));
        }
    }

    public void setSignatureBitmap(final Bitmap bitmap) {
        if (C2210a.m8652a(this)) {
            mo9194a();
            m8665d();
            RectF rectF = new RectF();
            RectF rectF2 = new RectF();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int width2 = getWidth();
            int height2 = getHeight();
            rectF.set(0.0f, 0.0f, (float) width, (float) height);
            rectF2.set(0.0f, 0.0f, (float) width2, (float) height2);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            new Canvas(this.f6884y).drawBitmap(bitmap, matrix, (Paint) null);
            setIsEmpty(false);
            invalidate();
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                C2211b.m8653a(SignaturePad.this.getViewTreeObserver(), this);
                SignaturePad.this.setSignatureBitmap(bitmap);
            }
        });
    }

    public void setVelocityFilterWeight(float f) {
        this.f6874o = f;
    }
}
