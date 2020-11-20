package androidx.appcompat.p011b.p012a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.graphics.drawable.C0595a;

/* renamed from: androidx.appcompat.b.a.b */
class C0144b extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    private C0147b f373a;

    /* renamed from: b */
    private Rect f374b;

    /* renamed from: c */
    private Drawable f375c;

    /* renamed from: d */
    private Drawable f376d;

    /* renamed from: e */
    private int f377e = 255;

    /* renamed from: f */
    private boolean f378f;

    /* renamed from: g */
    private int f379g = -1;

    /* renamed from: h */
    private int f380h = -1;

    /* renamed from: i */
    private boolean f381i;

    /* renamed from: j */
    private Runnable f382j;

    /* renamed from: k */
    private long f383k;

    /* renamed from: l */
    private long f384l;

    /* renamed from: m */
    private C0146a f385m;

    /* renamed from: androidx.appcompat.b.a.b$a */
    static class C0146a implements Drawable.Callback {

        /* renamed from: a */
        private Drawable.Callback f387a;

        C0146a() {
        }

        /* renamed from: a */
        public Drawable.Callback mo1059a() {
            Drawable.Callback callback = this.f387a;
            this.f387a = null;
            return callback;
        }

        /* renamed from: a */
        public C0146a mo1060a(Drawable.Callback callback) {
            this.f387a = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f387a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f387a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* renamed from: androidx.appcompat.b.a.b$b */
    static abstract class C0147b extends Drawable.ConstantState {

        /* renamed from: A */
        boolean f388A;

        /* renamed from: B */
        int f389B;

        /* renamed from: C */
        int f390C;

        /* renamed from: D */
        int f391D;

        /* renamed from: E */
        boolean f392E;

        /* renamed from: F */
        ColorFilter f393F;

        /* renamed from: G */
        boolean f394G;

        /* renamed from: H */
        ColorStateList f395H;

        /* renamed from: I */
        PorterDuff.Mode f396I;

        /* renamed from: J */
        boolean f397J;

        /* renamed from: K */
        boolean f398K;

        /* renamed from: c */
        final C0144b f399c;

        /* renamed from: d */
        Resources f400d;

        /* renamed from: e */
        int f401e = 160;

        /* renamed from: f */
        int f402f;

        /* renamed from: g */
        int f403g;

        /* renamed from: h */
        SparseArray<Drawable.ConstantState> f404h;

        /* renamed from: i */
        Drawable[] f405i;

        /* renamed from: j */
        int f406j;

        /* renamed from: k */
        boolean f407k;

        /* renamed from: l */
        boolean f408l;

        /* renamed from: m */
        Rect f409m;

        /* renamed from: n */
        boolean f410n;

        /* renamed from: o */
        boolean f411o;

        /* renamed from: p */
        int f412p;

        /* renamed from: q */
        int f413q;

        /* renamed from: r */
        int f414r;

        /* renamed from: s */
        int f415s;

        /* renamed from: t */
        boolean f416t;

        /* renamed from: u */
        int f417u;

        /* renamed from: v */
        boolean f418v;

        /* renamed from: w */
        boolean f419w;

        /* renamed from: x */
        boolean f420x;

        /* renamed from: y */
        boolean f421y;

        /* renamed from: z */
        boolean f422z;

        C0147b(C0147b bVar, C0144b bVar2, Resources resources) {
            this.f407k = false;
            this.f410n = false;
            this.f422z = true;
            this.f390C = 0;
            this.f391D = 0;
            this.f399c = bVar2;
            this.f400d = resources != null ? resources : bVar != null ? bVar.f400d : null;
            this.f401e = C0144b.m398a(resources, bVar != null ? bVar.f401e : 0);
            if (bVar != null) {
                this.f402f = bVar.f402f;
                this.f403g = bVar.f403g;
                this.f420x = true;
                this.f421y = true;
                this.f407k = bVar.f407k;
                this.f410n = bVar.f410n;
                this.f422z = bVar.f422z;
                this.f388A = bVar.f388A;
                this.f389B = bVar.f389B;
                this.f390C = bVar.f390C;
                this.f391D = bVar.f391D;
                this.f392E = bVar.f392E;
                this.f393F = bVar.f393F;
                this.f394G = bVar.f394G;
                this.f395H = bVar.f395H;
                this.f396I = bVar.f396I;
                this.f397J = bVar.f397J;
                this.f398K = bVar.f398K;
                if (bVar.f401e == this.f401e) {
                    if (bVar.f408l) {
                        this.f409m = new Rect(bVar.f409m);
                        this.f408l = true;
                    }
                    if (bVar.f411o) {
                        this.f412p = bVar.f412p;
                        this.f413q = bVar.f413q;
                        this.f414r = bVar.f414r;
                        this.f415s = bVar.f415s;
                        this.f411o = true;
                    }
                }
                if (bVar.f416t) {
                    this.f417u = bVar.f417u;
                    this.f416t = true;
                }
                if (bVar.f418v) {
                    this.f419w = bVar.f419w;
                    this.f418v = true;
                }
                Drawable[] drawableArr = bVar.f405i;
                this.f405i = new Drawable[drawableArr.length];
                this.f406j = bVar.f406j;
                SparseArray<Drawable.ConstantState> sparseArray = bVar.f404h;
                this.f404h = sparseArray != null ? sparseArray.clone() : new SparseArray<>(this.f406j);
                int i = this.f406j;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null) {
                        Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.f404h.put(i2, constantState);
                        } else {
                            this.f405i[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.f405i = new Drawable[10];
            this.f406j = 0;
        }

        /* renamed from: b */
        private Drawable m409b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.f389B);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f399c);
            return mutate;
        }

        /* renamed from: o */
        private void m410o() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f404h;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.f405i[this.f404h.keyAt(i)] = m409b(this.f404h.valueAt(i).newDrawable(this.f400d));
                }
                this.f404h = null;
            }
        }

        /* renamed from: a */
        public final int mo1064a(Drawable drawable) {
            int i = this.f406j;
            if (i >= this.f405i.length) {
                mo1078e(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f399c);
            this.f405i[i] = drawable;
            this.f406j++;
            this.f403g = drawable.getChangingConfigurations() | this.f403g;
            mo1069b();
            this.f409m = null;
            this.f408l = false;
            this.f411o = false;
            this.f420x = false;
            return i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1041a() {
            int i = this.f406j;
            Drawable[] drawableArr = this.f405i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null) {
                    drawableArr[i2].mutate();
                }
            }
            this.f388A = true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo1065a(Resources.Theme theme) {
            if (theme != null) {
                m410o();
                int i = this.f406j;
                Drawable[] drawableArr = this.f405i;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.f403g |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                mo1066a(theme.getResources());
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo1066a(Resources resources) {
            if (resources != null) {
                this.f400d = resources;
                int a = C0144b.m398a(resources, this.f401e);
                int i = this.f401e;
                this.f401e = a;
                if (i != a) {
                    this.f411o = false;
                    this.f408l = false;
                }
            }
        }

        /* renamed from: a */
        public final void mo1067a(boolean z) {
            this.f407k = z;
        }

        /* renamed from: b */
        public final Drawable mo1068b(int i) {
            int indexOfKey;
            Drawable drawable = this.f405i[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f404h;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable b = m409b(this.f404h.valueAt(indexOfKey).newDrawable(this.f400d));
            this.f405i[i] = b;
            this.f404h.removeAt(indexOfKey);
            if (this.f404h.size() == 0) {
                this.f404h = null;
            }
            return b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo1069b() {
            this.f416t = false;
            this.f418v = false;
        }

        /* renamed from: b */
        public final void mo1070b(boolean z) {
            this.f410n = z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public final int mo1071c() {
            return this.f405i.length;
        }

        /* renamed from: c */
        public final void mo1072c(int i) {
            this.f390C = i;
        }

        public boolean canApplyTheme() {
            int i = this.f406j;
            Drawable[] drawableArr = this.f405i;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f404h.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: d */
        public final int mo1074d() {
            return this.f406j;
        }

        /* renamed from: d */
        public final void mo1075d(int i) {
            this.f391D = i;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public final boolean mo1076d(int i, int i2) {
            int i3 = this.f406j;
            Drawable[] drawableArr = this.f405i;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.f389B = i;
            return z;
        }

        /* renamed from: e */
        public final Rect mo1077e() {
            if (this.f407k) {
                return null;
            }
            if (this.f409m != null || this.f408l) {
                return this.f409m;
            }
            m410o();
            Rect rect = new Rect();
            int i = this.f406j;
            Drawable[] drawableArr = this.f405i;
            Rect rect2 = null;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect)) {
                    if (rect2 == null) {
                        rect2 = new Rect(0, 0, 0, 0);
                    }
                    if (rect.left > rect2.left) {
                        rect2.left = rect.left;
                    }
                    if (rect.top > rect2.top) {
                        rect2.top = rect.top;
                    }
                    if (rect.right > rect2.right) {
                        rect2.right = rect.right;
                    }
                    if (rect.bottom > rect2.bottom) {
                        rect2.bottom = rect.bottom;
                    }
                }
            }
            this.f408l = true;
            this.f409m = rect2;
            return rect2;
        }

        /* renamed from: e */
        public void mo1078e(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.f405i, 0, drawableArr, 0, i);
            this.f405i = drawableArr;
        }

        /* renamed from: f */
        public final boolean mo1079f() {
            return this.f410n;
        }

        /* renamed from: g */
        public final int mo1080g() {
            if (!this.f411o) {
                mo1085k();
            }
            return this.f412p;
        }

        public int getChangingConfigurations() {
            return this.f402f | this.f403g;
        }

        /* renamed from: h */
        public final int mo1082h() {
            if (!this.f411o) {
                mo1085k();
            }
            return this.f413q;
        }

        /* renamed from: i */
        public final int mo1083i() {
            if (!this.f411o) {
                mo1085k();
            }
            return this.f414r;
        }

        /* renamed from: j */
        public final int mo1084j() {
            if (!this.f411o) {
                mo1085k();
            }
            return this.f415s;
        }

        /* access modifiers changed from: protected */
        /* renamed from: k */
        public void mo1085k() {
            this.f411o = true;
            m410o();
            int i = this.f406j;
            Drawable[] drawableArr = this.f405i;
            this.f413q = -1;
            this.f412p = -1;
            this.f415s = 0;
            this.f414r = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f412p) {
                    this.f412p = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f413q) {
                    this.f413q = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f414r) {
                    this.f414r = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f415s) {
                    this.f415s = minimumHeight;
                }
            }
        }

        /* renamed from: l */
        public final int mo1086l() {
            if (this.f416t) {
                return this.f417u;
            }
            m410o();
            int i = this.f406j;
            Drawable[] drawableArr = this.f405i;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.f417u = opacity;
            this.f416t = true;
            return opacity;
        }

        /* renamed from: m */
        public final boolean mo1087m() {
            if (this.f418v) {
                return this.f419w;
            }
            m410o();
            int i = this.f406j;
            Drawable[] drawableArr = this.f405i;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                } else if (drawableArr[i2].isStateful()) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            this.f419w = z;
            this.f418v = true;
            return z;
        }

        /* renamed from: n */
        public synchronized boolean mo1088n() {
            if (this.f420x) {
                return this.f421y;
            }
            m410o();
            this.f420x = true;
            int i = this.f406j;
            Drawable[] drawableArr = this.f405i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.f421y = false;
                    return false;
                }
            }
            this.f421y = true;
            return true;
        }
    }

    C0144b() {
    }

    /* renamed from: a */
    static int m398a(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }

    /* renamed from: a */
    private void m399a(Drawable drawable) {
        if (this.f385m == null) {
            this.f385m = new C0146a();
        }
        drawable.setCallback(this.f385m.mo1060a(drawable.getCallback()));
        try {
            if (this.f373a.f390C <= 0 && this.f378f) {
                drawable.setAlpha(this.f377e);
            }
            if (this.f373a.f394G) {
                drawable.setColorFilter(this.f373a.f393F);
            } else {
                if (this.f373a.f397J) {
                    C0595a.m2319a(drawable, this.f373a.f395H);
                }
                if (this.f373a.f398K) {
                    C0595a.m2322a(drawable, this.f373a.f396I);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f373a.f422z);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f373a.f392E);
            }
            Rect rect = this.f374b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f385m.mo1059a());
        }
    }

    /* renamed from: a */
    private boolean mo997a() {
        return isAutoMirrored() && C0595a.m2332i(this) == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo1051a(Resources resources) {
        this.f373a.mo1066a(resources);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo998a(C0147b bVar) {
        this.f373a = bVar;
        int i = this.f379g;
        if (i >= 0) {
            this.f375c = bVar.mo1068b(i);
            Drawable drawable = this.f375c;
            if (drawable != null) {
                m399a(drawable);
            }
        }
        this.f380h = -1;
        this.f376d = null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1052a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f378f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f375c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L_0x0038
            long r9 = r13.f383k
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x003a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0020
            int r9 = r13.f377e
            r3.setAlpha(r9)
            goto L_0x0038
        L_0x0020:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r3 = (int) r9
            androidx.appcompat.b.a.b$b r9 = r13.f373a
            int r9 = r9.f390C
            int r3 = r3 / r9
            android.graphics.drawable.Drawable r9 = r13.f375c
            int r3 = 255 - r3
            int r10 = r13.f377e
            int r3 = r3 * r10
            int r3 = r3 / 255
            r9.setAlpha(r3)
            r3 = 1
            goto L_0x003b
        L_0x0038:
            r13.f383k = r7
        L_0x003a:
            r3 = 0
        L_0x003b:
            android.graphics.drawable.Drawable r9 = r13.f376d
            if (r9 == 0) goto L_0x0068
            long r10 = r13.f384l
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x006a
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0053
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f376d = r0
            r0 = -1
            r13.f380h = r0
            goto L_0x0068
        L_0x0053:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.b.a.b$b r4 = r13.f373a
            int r4 = r4.f391D
            int r3 = r3 / r4
            android.graphics.drawable.Drawable r4 = r13.f376d
            int r5 = r13.f377e
            int r3 = r3 * r5
            int r3 = r3 / 255
            r4.setAlpha(r3)
            goto L_0x006b
        L_0x0068:
            r13.f384l = r7
        L_0x006a:
            r0 = r3
        L_0x006b:
            if (r14 == 0) goto L_0x0077
            if (r0 == 0) goto L_0x0077
            java.lang.Runnable r14 = r13.f382j
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.p011b.p012a.C0144b.mo1052a(boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo1053a(int i) {
        if (i == this.f379g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f373a.f391D > 0) {
            Drawable drawable = this.f376d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f375c;
            if (drawable2 != null) {
                this.f376d = drawable2;
                this.f380h = this.f379g;
                this.f384l = ((long) this.f373a.f391D) + uptimeMillis;
            } else {
                this.f376d = null;
                this.f380h = -1;
                this.f384l = 0;
            }
        } else {
            Drawable drawable3 = this.f375c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i < 0 || i >= this.f373a.f406j) {
            this.f375c = null;
            this.f379g = -1;
        } else {
            Drawable b = this.f373a.mo1068b(i);
            this.f375c = b;
            this.f379g = i;
            if (b != null) {
                if (this.f373a.f390C > 0) {
                    this.f383k = uptimeMillis + ((long) this.f373a.f390C);
                }
                m399a(b);
            }
        }
        if (!(this.f383k == 0 && this.f384l == 0)) {
            Runnable runnable = this.f382j;
            if (runnable == null) {
                this.f382j = new Runnable() {
                    public void run() {
                        C0144b.this.mo1052a(true);
                        C0144b.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(runnable);
            }
            mo1052a(true);
        }
        invalidateSelf();
        return true;
    }

    public void applyTheme(Resources.Theme theme) {
        this.f373a.mo1065a(theme);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0147b mo1002c() {
        return this.f373a;
    }

    public boolean canApplyTheme() {
        return this.f373a.canApplyTheme();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo1054d() {
        return this.f379g;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f375c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f376d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public int getAlpha() {
        return this.f377e;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f373a.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.f373a.mo1088n()) {
            return null;
        }
        this.f373a.f402f = getChangingConfigurations();
        return this.f373a;
    }

    public Drawable getCurrent() {
        return this.f375c;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f374b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.f373a.mo1079f()) {
            return this.f373a.mo1082h();
        }
        Drawable drawable = this.f375c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.f373a.mo1079f()) {
            return this.f373a.mo1080g();
        }
        Drawable drawable = this.f375c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.f373a.mo1079f()) {
            return this.f373a.mo1084j();
        }
        Drawable drawable = this.f375c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.f373a.mo1079f()) {
            return this.f373a.mo1083i();
        }
        Drawable drawable = this.f375c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.f375c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f373a.mo1086l();
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.f375c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z;
        Rect e = this.f373a.mo1077e();
        if (e != null) {
            rect.set(e);
            z = (e.right | ((e.left | e.top) | e.bottom)) != 0;
        } else {
            Drawable drawable = this.f375c;
            z = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (mo997a()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return z;
    }

    public void invalidateDrawable(Drawable drawable) {
        C0147b bVar = this.f373a;
        if (bVar != null) {
            bVar.mo1069b();
        }
        if (drawable == this.f375c && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f373a.f392E;
    }

    public boolean isStateful() {
        return this.f373a.mo1087m();
    }

    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f376d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f376d = null;
            this.f380h = -1;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f375c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f378f) {
                this.f375c.setAlpha(this.f377e);
            }
        }
        if (this.f384l != 0) {
            this.f384l = 0;
            z = true;
        }
        if (this.f383k != 0) {
            this.f383k = 0;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.f381i && super.mutate() == this) {
            C0147b c = mo1002c();
            c.mo1041a();
            mo998a(c);
            this.f381i = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f376d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f375c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i) {
        return this.f373a.mo1076d(i, mo1054d());
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f376d;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f375c;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f376d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f375c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable == this.f375c && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (!this.f378f || this.f377e != i) {
            this.f378f = true;
            this.f377e = i;
            Drawable drawable = this.f375c;
            if (drawable == null) {
                return;
            }
            if (this.f383k == 0) {
                drawable.setAlpha(i);
            } else {
                mo1052a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.f373a.f392E != z) {
            C0147b bVar = this.f373a;
            bVar.f392E = z;
            Drawable drawable = this.f375c;
            if (drawable != null) {
                C0595a.m2323a(drawable, bVar.f392E);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        C0147b bVar = this.f373a;
        bVar.f394G = true;
        if (bVar.f393F != colorFilter) {
            this.f373a.f393F = colorFilter;
            Drawable drawable = this.f375c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z) {
        if (this.f373a.f422z != z) {
            C0147b bVar = this.f373a;
            bVar.f422z = z;
            Drawable drawable = this.f375c;
            if (drawable != null) {
                drawable.setDither(bVar.f422z);
            }
        }
    }

    public void setHotspot(float f, float f2) {
        Drawable drawable = this.f375c;
        if (drawable != null) {
            C0595a.m2316a(drawable, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.f374b;
        if (rect == null) {
            this.f374b = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.f375c;
        if (drawable != null) {
            C0595a.m2318a(drawable, i, i2, i3, i4);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        C0147b bVar = this.f373a;
        bVar.f397J = true;
        if (bVar.f395H != colorStateList) {
            this.f373a.f395H = colorStateList;
            C0595a.m2319a(this.f375c, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        C0147b bVar = this.f373a;
        bVar.f398K = true;
        if (bVar.f396I != mode) {
            this.f373a.f396I = mode;
            C0595a.m2322a(this.f375c, mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f376d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f375c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f375c && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
