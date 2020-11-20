package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.p030h.C0656u;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: androidx.recyclerview.widget.d */
class C1072d extends RecyclerView.C1021h implements RecyclerView.C1030m {

    /* renamed from: k */
    private static final int[] f3381k = {16842919};

    /* renamed from: l */
    private static final int[] f3382l = new int[0];

    /* renamed from: A */
    private int f3383A = 0;

    /* renamed from: B */
    private final int[] f3384B = new int[2];

    /* renamed from: C */
    private final int[] f3385C = new int[2];

    /* renamed from: D */
    private final Runnable f3386D = new Runnable() {
        public void run() {
            C1072d.this.mo5999b(500);
        }
    };

    /* renamed from: E */
    private final RecyclerView.C1031n f3387E = new RecyclerView.C1031n() {
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            C1072d.this.mo5995a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    };

    /* renamed from: a */
    final StateListDrawable f3388a;

    /* renamed from: b */
    final Drawable f3389b;

    /* renamed from: c */
    int f3390c;

    /* renamed from: d */
    int f3391d;

    /* renamed from: e */
    float f3392e;

    /* renamed from: f */
    int f3393f;

    /* renamed from: g */
    int f3394g;

    /* renamed from: h */
    float f3395h;

    /* renamed from: i */
    final ValueAnimator f3396i = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});

    /* renamed from: j */
    int f3397j = 0;

    /* renamed from: m */
    private final int f3398m;

    /* renamed from: n */
    private final int f3399n;

    /* renamed from: o */
    private final int f3400o;

    /* renamed from: p */
    private final int f3401p;

    /* renamed from: q */
    private final StateListDrawable f3402q;

    /* renamed from: r */
    private final Drawable f3403r;

    /* renamed from: s */
    private final int f3404s;

    /* renamed from: t */
    private final int f3405t;

    /* renamed from: u */
    private int f3406u = 0;

    /* renamed from: v */
    private int f3407v = 0;

    /* renamed from: w */
    private RecyclerView f3408w;

    /* renamed from: x */
    private boolean f3409x = false;

    /* renamed from: y */
    private boolean f3410y = false;

    /* renamed from: z */
    private int f3411z = 0;

    /* renamed from: androidx.recyclerview.widget.d$a */
    private class C1075a extends AnimatorListenerAdapter {

        /* renamed from: b */
        private boolean f3415b = false;

        C1075a() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f3415b = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f3415b) {
                this.f3415b = false;
            } else if (((Float) C1072d.this.f3396i.getAnimatedValue()).floatValue() == 0.0f) {
                C1072d dVar = C1072d.this;
                dVar.f3397j = 0;
                dVar.mo5994a(0);
            } else {
                C1072d dVar2 = C1072d.this;
                dVar2.f3397j = 2;
                dVar2.mo5993a();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.d$b */
    private class C1076b implements ValueAnimator.AnimatorUpdateListener {
        C1076b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            C1072d.this.f3388a.setAlpha(floatValue);
            C1072d.this.f3389b.setAlpha(floatValue);
            C1072d.this.mo5993a();
        }
    }

    C1072d(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f3388a = stateListDrawable;
        this.f3389b = drawable;
        this.f3402q = stateListDrawable2;
        this.f3403r = drawable2;
        this.f3400o = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f3401p = Math.max(i, drawable.getIntrinsicWidth());
        this.f3404s = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f3405t = Math.max(i, drawable2.getIntrinsicWidth());
        this.f3398m = i2;
        this.f3399n = i3;
        this.f3388a.setAlpha(255);
        this.f3389b.setAlpha(255);
        this.f3396i.addListener(new C1075a());
        this.f3396i.addUpdateListener(new C1076b());
        mo5996a(recyclerView);
    }

    /* renamed from: a */
    private int m4204a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / ((float) i4)) * ((float) i5));
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    /* renamed from: a */
    private void m4205a(float f) {
        int[] g = m4214g();
        float max = Math.max((float) g[0], Math.min((float) g[1], f));
        if (Math.abs(((float) this.f3391d) - max) >= 2.0f) {
            int a = m4204a(this.f3392e, max, g, this.f3408w.computeVerticalScrollRange(), this.f3408w.computeVerticalScrollOffset(), this.f3407v);
            if (a != 0) {
                this.f3408w.scrollBy(0, a);
            }
            this.f3392e = max;
        }
    }

    /* renamed from: a */
    private void m4206a(Canvas canvas) {
        int i = this.f3406u;
        int i2 = this.f3400o;
        int i3 = i - i2;
        int i4 = this.f3391d;
        int i5 = this.f3390c;
        int i6 = i4 - (i5 / 2);
        this.f3388a.setBounds(0, 0, i2, i5);
        this.f3389b.setBounds(0, 0, this.f3401p, this.f3407v);
        if (m4212e()) {
            this.f3389b.draw(canvas);
            canvas.translate((float) this.f3400o, (float) i6);
            canvas.scale(-1.0f, 1.0f);
            this.f3388a.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            i3 = this.f3400o;
        } else {
            canvas.translate((float) i3, 0.0f);
            this.f3389b.draw(canvas);
            canvas.translate(0.0f, (float) i6);
            this.f3388a.draw(canvas);
        }
        canvas.translate((float) (-i3), (float) (-i6));
    }

    /* renamed from: b */
    private void m4207b(float f) {
        int[] h = m4215h();
        float max = Math.max((float) h[0], Math.min((float) h[1], f));
        if (Math.abs(((float) this.f3394g) - max) >= 2.0f) {
            int a = m4204a(this.f3395h, max, h, this.f3408w.computeHorizontalScrollRange(), this.f3408w.computeHorizontalScrollOffset(), this.f3406u);
            if (a != 0) {
                this.f3408w.scrollBy(a, 0);
            }
            this.f3395h = max;
        }
    }

    /* renamed from: b */
    private void m4208b(Canvas canvas) {
        int i = this.f3407v;
        int i2 = this.f3404s;
        int i3 = i - i2;
        int i4 = this.f3394g;
        int i5 = this.f3393f;
        int i6 = i4 - (i5 / 2);
        this.f3402q.setBounds(0, 0, i5, i2);
        this.f3403r.setBounds(0, 0, this.f3406u, this.f3405t);
        canvas.translate(0.0f, (float) i3);
        this.f3403r.draw(canvas);
        canvas.translate((float) i6, 0.0f);
        this.f3402q.draw(canvas);
        canvas.translate((float) (-i6), (float) (-i3));
    }

    /* renamed from: c */
    private void m4209c() {
        this.f3408w.addItemDecoration(this);
        this.f3408w.addOnItemTouchListener(this);
        this.f3408w.addOnScrollListener(this.f3387E);
    }

    /* renamed from: c */
    private void m4210c(int i) {
        m4213f();
        this.f3408w.postDelayed(this.f3386D, (long) i);
    }

    /* renamed from: d */
    private void m4211d() {
        this.f3408w.removeItemDecoration(this);
        this.f3408w.removeOnItemTouchListener(this);
        this.f3408w.removeOnScrollListener(this.f3387E);
        m4213f();
    }

    /* renamed from: e */
    private boolean m4212e() {
        return C0656u.m2621g(this.f3408w) == 1;
    }

    /* renamed from: f */
    private void m4213f() {
        this.f3408w.removeCallbacks(this.f3386D);
    }

    /* renamed from: g */
    private int[] m4214g() {
        int[] iArr = this.f3384B;
        int i = this.f3399n;
        iArr[0] = i;
        iArr[1] = this.f3407v - i;
        return iArr;
    }

    /* renamed from: h */
    private int[] m4215h() {
        int[] iArr = this.f3385C;
        int i = this.f3399n;
        iArr[0] = i;
        iArr[1] = this.f3406u - i;
        return iArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5993a() {
        this.f3408w.invalidate();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5994a(int i) {
        int i2;
        if (i == 2 && this.f3411z != 2) {
            this.f3388a.setState(f3381k);
            m4213f();
        }
        if (i == 0) {
            mo5993a();
        } else {
            mo5998b();
        }
        if (this.f3411z != 2 || i == 2) {
            if (i == 1) {
                i2 = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
            }
            this.f3411z = i;
        }
        this.f3388a.setState(f3382l);
        i2 = 1200;
        m4210c(i2);
        this.f3411z = i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5995a(int i, int i2) {
        int computeVerticalScrollRange = this.f3408w.computeVerticalScrollRange();
        int i3 = this.f3407v;
        this.f3409x = computeVerticalScrollRange - i3 > 0 && i3 >= this.f3398m;
        int computeHorizontalScrollRange = this.f3408w.computeHorizontalScrollRange();
        int i4 = this.f3406u;
        this.f3410y = computeHorizontalScrollRange - i4 > 0 && i4 >= this.f3398m;
        if (this.f3409x || this.f3410y) {
            if (this.f3409x) {
                float f = (float) i3;
                this.f3391d = (int) ((f * (((float) i2) + (f / 2.0f))) / ((float) computeVerticalScrollRange));
                this.f3390c = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
            }
            if (this.f3410y) {
                float f2 = (float) i4;
                this.f3394g = (int) ((f2 * (((float) i) + (f2 / 2.0f))) / ((float) computeHorizontalScrollRange));
                this.f3393f = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
            }
            int i5 = this.f3411z;
            if (i5 == 0 || i5 == 1) {
                mo5994a(1);
            }
        } else if (this.f3411z != 0) {
            mo5994a(0);
        }
    }

    /* renamed from: a */
    public void mo5996a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f3408w;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                m4211d();
            }
            this.f3408w = recyclerView;
            if (this.f3408w != null) {
                m4209c();
            }
        }
    }

    /* renamed from: a */
    public void mo5707a(boolean z) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5997a(float f, float f2) {
        if (!m4212e() ? f >= ((float) (this.f3406u - this.f3400o)) : f <= ((float) (this.f3400o / 2))) {
            int i = this.f3391d;
            int i2 = this.f3390c;
            return f2 >= ((float) (i - (i2 / 2))) && f2 <= ((float) (i + (i2 / 2)));
        }
    }

    /* renamed from: a */
    public boolean mo5708a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.f3411z;
        if (i != 1) {
            return i == 2;
        }
        boolean a = mo5997a(motionEvent.getX(), motionEvent.getY());
        boolean b = mo6000b(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (!a && !b) {
            return false;
        }
        if (b) {
            this.f3383A = 1;
            this.f3395h = (float) ((int) motionEvent.getX());
        } else if (a) {
            this.f3383A = 2;
            this.f3392e = (float) ((int) motionEvent.getY());
        }
        mo5994a(2);
    }

    /* renamed from: b */
    public void mo5998b() {
        int i = this.f3397j;
        if (i != 0) {
            if (i == 3) {
                this.f3396i.cancel();
            } else {
                return;
            }
        }
        this.f3397j = 1;
        ValueAnimator valueAnimator = this.f3396i;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f});
        this.f3396i.setDuration(500);
        this.f3396i.setStartDelay(0);
        this.f3396i.start();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5999b(int i) {
        switch (this.f3397j) {
            case 1:
                this.f3396i.cancel();
                break;
            case 2:
                break;
            default:
                return;
        }
        this.f3397j = 3;
        ValueAnimator valueAnimator = this.f3396i;
        valueAnimator.setFloatValues(new float[]{((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f});
        this.f3396i.setDuration((long) i);
        this.f3396i.start();
    }

    /* renamed from: b */
    public void mo5709b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f3411z != 0) {
            if (motionEvent.getAction() == 0) {
                boolean a = mo5997a(motionEvent.getX(), motionEvent.getY());
                boolean b = mo6000b(motionEvent.getX(), motionEvent.getY());
                if (a || b) {
                    if (b) {
                        this.f3383A = 1;
                        this.f3395h = (float) ((int) motionEvent.getX());
                    } else if (a) {
                        this.f3383A = 2;
                        this.f3392e = (float) ((int) motionEvent.getY());
                    }
                    mo5994a(2);
                }
            } else if (motionEvent.getAction() == 1 && this.f3411z == 2) {
                this.f3392e = 0.0f;
                this.f3395h = 0.0f;
                mo5994a(1);
                this.f3383A = 0;
            } else if (motionEvent.getAction() == 2 && this.f3411z == 2) {
                mo5998b();
                if (this.f3383A == 1) {
                    m4207b(motionEvent.getX());
                }
                if (this.f3383A == 2) {
                    m4205a(motionEvent.getY());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo6000b(float f, float f2) {
        if (f2 >= ((float) (this.f3407v - this.f3404s))) {
            int i = this.f3394g;
            int i2 = this.f3393f;
            return f >= ((float) (i - (i2 / 2))) && f <= ((float) (i + (i2 / 2)));
        }
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.C1042u uVar) {
        if (this.f3406u != this.f3408w.getWidth() || this.f3407v != this.f3408w.getHeight()) {
            this.f3406u = this.f3408w.getWidth();
            this.f3407v = this.f3408w.getHeight();
            mo5994a(0);
        } else if (this.f3397j != 0) {
            if (this.f3409x) {
                m4206a(canvas);
            }
            if (this.f3410y) {
                m4208b(canvas);
            }
        }
    }
}
