package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.C0203p;

/* renamed from: androidx.appcompat.widget.ai */
public abstract class C0263ai implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* renamed from: a */
    private final float f953a;

    /* renamed from: b */
    private final int f954b;

    /* renamed from: c */
    final View f955c;

    /* renamed from: d */
    private final int f956d;

    /* renamed from: e */
    private Runnable f957e;

    /* renamed from: f */
    private Runnable f958f;

    /* renamed from: g */
    private boolean f959g;

    /* renamed from: h */
    private int f960h;

    /* renamed from: i */
    private final int[] f961i = new int[2];

    /* renamed from: androidx.appcompat.widget.ai$a */
    private class C0264a implements Runnable {
        C0264a() {
        }

        public void run() {
            ViewParent parent = C0263ai.this.f955c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ai$b */
    private class C0265b implements Runnable {
        C0265b() {
        }

        public void run() {
            C0263ai.this.mo2150d();
        }
    }

    public C0263ai(View view) {
        this.f955c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f953a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f954b = ViewConfiguration.getTapTimeout();
        this.f956d = (this.f954b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* renamed from: a */
    private boolean m934a(MotionEvent motionEvent) {
        View view = this.f955c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f960h = motionEvent.getPointerId(0);
                if (this.f957e == null) {
                    this.f957e = new C0264a();
                }
                view.postDelayed(this.f957e, (long) this.f954b);
                if (this.f958f == null) {
                    this.f958f = new C0265b();
                }
                view.postDelayed(this.f958f, (long) this.f956d);
                break;
            case 1:
            case 3:
                m939e();
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.f960h);
                if (findPointerIndex >= 0 && !m935a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f953a)) {
                    m939e();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m935a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    /* renamed from: a */
    private boolean m936a(View view, MotionEvent motionEvent) {
        int[] iArr = this.f961i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    /* renamed from: b */
    private boolean m937b(MotionEvent motionEvent) {
        C0258ag agVar;
        View view = this.f955c;
        C0203p a = mo1218a();
        if (a == null || !a.mo1329c() || (agVar = (C0258ag) a.mo1332k_()) == null || !agVar.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m938b(view, obtainNoHistory);
        m936a(agVar, obtainNoHistory);
        boolean a2 = agVar.mo2133a(obtainNoHistory, this.f960h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return a2 && (actionMasked != 1 && actionMasked != 3);
    }

    /* renamed from: b */
    private boolean m938b(View view, MotionEvent motionEvent) {
        int[] iArr = this.f961i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    /* renamed from: e */
    private void m939e() {
        Runnable runnable = this.f958f;
        if (runnable != null) {
            this.f955c.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f957e;
        if (runnable2 != null) {
            this.f955c.removeCallbacks(runnable2);
        }
    }

    /* renamed from: a */
    public abstract C0203p mo1218a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo1219b() {
        C0203p a = mo1218a();
        if (a == null || a.mo1329c()) {
            return true;
        }
        a.mo1331j_();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo2149c() {
        C0203p a = mo1218a();
        if (a == null || !a.mo1329c()) {
            return true;
        }
        a.mo1325b();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo2150d() {
        m939e();
        View view = this.f955c;
        if (view.isEnabled() && !view.isLongClickable() && mo1219b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f959g = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f959g;
        if (z2) {
            z = m937b(motionEvent) || !mo2149c();
        } else {
            z = m934a(motionEvent) && mo1219b();
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f955c.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f959g = z;
        return z || z2;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.f959g = false;
        this.f960h = -1;
        Runnable runnable = this.f957e;
        if (runnable != null) {
            this.f955c.removeCallbacks(runnable);
        }
    }
}
