package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.p030h.C0656u;
import androidx.core.p030h.C0665v;

/* renamed from: androidx.appcompat.widget.bb */
class C0308bb implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {

    /* renamed from: j */
    private static C0308bb f1119j;

    /* renamed from: k */
    private static C0308bb f1120k;

    /* renamed from: a */
    private final View f1121a;

    /* renamed from: b */
    private final CharSequence f1122b;

    /* renamed from: c */
    private final int f1123c;

    /* renamed from: d */
    private final Runnable f1124d = new Runnable() {
        public void run() {
            C0308bb.this.mo2440a(false);
        }
    };

    /* renamed from: e */
    private final Runnable f1125e = new Runnable() {
        public void run() {
            C0308bb.this.mo2439a();
        }
    };

    /* renamed from: f */
    private int f1126f;

    /* renamed from: g */
    private int f1127g;

    /* renamed from: h */
    private C0311bc f1128h;

    /* renamed from: i */
    private boolean f1129i;

    private C0308bb(View view, CharSequence charSequence) {
        this.f1121a = view;
        this.f1122b = charSequence;
        this.f1123c = C0665v.m2681a(ViewConfiguration.get(this.f1121a.getContext()));
        m1150d();
        this.f1121a.setOnLongClickListener(this);
        this.f1121a.setOnHoverListener(this);
    }

    /* renamed from: a */
    public static void m1145a(View view, CharSequence charSequence) {
        C0308bb bbVar = f1119j;
        if (bbVar != null && bbVar.f1121a == view) {
            m1146a((C0308bb) null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            C0308bb bbVar2 = f1120k;
            if (bbVar2 != null && bbVar2.f1121a == view) {
                bbVar2.mo2439a();
            }
            view.setOnLongClickListener((View.OnLongClickListener) null);
            view.setLongClickable(false);
            view.setOnHoverListener((View.OnHoverListener) null);
            return;
        }
        new C0308bb(view, charSequence);
    }

    /* renamed from: a */
    private static void m1146a(C0308bb bbVar) {
        C0308bb bbVar2 = f1119j;
        if (bbVar2 != null) {
            bbVar2.m1149c();
        }
        f1119j = bbVar;
        C0308bb bbVar3 = f1119j;
        if (bbVar3 != null) {
            bbVar3.m1148b();
        }
    }

    /* renamed from: a */
    private boolean m1147a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.f1126f) <= this.f1123c && Math.abs(y - this.f1127g) <= this.f1123c) {
            return false;
        }
        this.f1126f = x;
        this.f1127g = y;
        return true;
    }

    /* renamed from: b */
    private void m1148b() {
        this.f1121a.postDelayed(this.f1124d, (long) ViewConfiguration.getLongPressTimeout());
    }

    /* renamed from: c */
    private void m1149c() {
        this.f1121a.removeCallbacks(this.f1124d);
    }

    /* renamed from: d */
    private void m1150d() {
        this.f1126f = Integer.MAX_VALUE;
        this.f1127g = Integer.MAX_VALUE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2439a() {
        if (f1120k == this) {
            f1120k = null;
            C0311bc bcVar = this.f1128h;
            if (bcVar != null) {
                bcVar.mo2447a();
                this.f1128h = null;
                m1150d();
                this.f1121a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1119j == this) {
            m1146a((C0308bb) null);
        }
        this.f1121a.removeCallbacks(this.f1125e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2440a(boolean z) {
        long j;
        if (C0656u.m2569B(this.f1121a)) {
            m1146a((C0308bb) null);
            C0308bb bbVar = f1120k;
            if (bbVar != null) {
                bbVar.mo2439a();
            }
            f1120k = this;
            this.f1129i = z;
            this.f1128h = new C0311bc(this.f1121a.getContext());
            this.f1128h.mo2448a(this.f1121a, this.f1126f, this.f1127g, this.f1129i, this.f1122b);
            this.f1121a.addOnAttachStateChangeListener(this);
            if (this.f1129i) {
                j = 2500;
            } else {
                j = ((C0656u.m2633p(this.f1121a) & 1) == 1 ? 3000 : 15000) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f1121a.removeCallbacks(this.f1125e);
            this.f1121a.postDelayed(this.f1125e, j);
        }
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1128h != null && this.f1129i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1121a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                m1150d();
                mo2439a();
            }
        } else if (this.f1121a.isEnabled() && this.f1128h == null && m1147a(motionEvent)) {
            m1146a(this);
        }
        return false;
    }

    public boolean onLongClick(View view) {
        this.f1126f = view.getWidth() / 2;
        this.f1127g = view.getHeight() / 2;
        mo2440a(true);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        mo2439a();
    }
}
