package androidx.p049j;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.p030h.C0656u;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* renamed from: androidx.j.aa */
class C0824aa implements C0827ac {

    /* renamed from: a */
    protected C0825a f2775a;

    /* renamed from: androidx.j.aa$a */
    static class C0825a extends ViewGroup {

        /* renamed from: a */
        static Method f2776a;

        /* renamed from: b */
        ViewGroup f2777b;

        /* renamed from: c */
        View f2778c;

        /* renamed from: d */
        ArrayList<Drawable> f2779d = null;

        /* renamed from: e */
        C0824aa f2780e;

        /* renamed from: f */
        private boolean f2781f;

        static {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                f2776a = cls.getDeclaredMethod("invalidateChildInParentFast", new Class[]{Integer.TYPE, Integer.TYPE, Rect.class});
            } catch (NoSuchMethodException unused) {
            }
        }

        C0825a(Context context, ViewGroup viewGroup, View view, C0824aa aaVar) {
            super(context);
            this.f2777b = viewGroup;
            this.f2778c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f2780e = aaVar;
        }

        /* renamed from: a */
        private void m3403a() {
            if (this.f2781f) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        /* renamed from: a */
        private void m3404a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f2777b.getLocationOnScreen(iArr2);
            this.f2778c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        /* renamed from: b */
        private void m3405b() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f2779d;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f2781f = true;
                    this.f2777b.removeView(this);
                }
            }
        }

        /* renamed from: a */
        public void mo4658a(Drawable drawable) {
            m3403a();
            if (this.f2779d == null) {
                this.f2779d = new ArrayList<>();
            }
            if (!this.f2779d.contains(drawable)) {
                this.f2779d.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        /* renamed from: a */
        public void mo4659a(View view) {
            m3403a();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f2777b || viewGroup.getParent() == null || !C0656u.m2569B(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f2777b.getLocationOnScreen(iArr2);
                    C0656u.m2620f(view, iArr[0] - iArr2[0]);
                    C0656u.m2618e(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        /* renamed from: b */
        public void mo4660b(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f2779d;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback((Drawable.Callback) null);
                m3405b();
            }
        }

        /* renamed from: b */
        public void mo4661b(View view) {
            super.removeView(view);
            m3405b();
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f2777b.getLocationOnScreen(iArr);
            this.f2778c.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.f2778c.getWidth(), this.f2778c.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f2779d;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f2779d.get(i).draw(canvas);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f2777b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f2777b instanceof ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                m3404a(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r0 = r1.f2779d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean verifyDrawable(android.graphics.drawable.Drawable r2) {
            /*
                r1 = this;
                boolean r0 = super.verifyDrawable(r2)
                if (r0 != 0) goto L_0x0013
                java.util.ArrayList<android.graphics.drawable.Drawable> r0 = r1.f2779d
                if (r0 == 0) goto L_0x0011
                boolean r2 = r0.contains(r2)
                if (r2 == 0) goto L_0x0011
                goto L_0x0013
            L_0x0011:
                r2 = 0
                goto L_0x0014
            L_0x0013:
                r2 = 1
            L_0x0014:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.p049j.C0824aa.C0825a.verifyDrawable(android.graphics.drawable.Drawable):boolean");
        }
    }

    C0824aa(Context context, ViewGroup viewGroup, View view) {
        this.f2775a = new C0825a(context, viewGroup, view, this);
    }

    /* renamed from: c */
    static ViewGroup m3399c(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    /* renamed from: d */
    static C0824aa m3400d(View view) {
        ViewGroup c = m3399c(view);
        if (c == null) {
            return null;
        }
        int childCount = c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = c.getChildAt(i);
            if (childAt instanceof C0825a) {
                return ((C0825a) childAt).f2780e;
            }
        }
        return new C0893v(c.getContext(), c, view);
    }

    /* renamed from: a */
    public void mo4656a(Drawable drawable) {
        this.f2775a.mo4658a(drawable);
    }

    /* renamed from: b */
    public void mo4657b(Drawable drawable) {
        this.f2775a.mo4660b(drawable);
    }
}
