package androidx.p035e.p037b;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.p030h.C0656u;
import com.parse.ParseQuery;
import java.util.Arrays;

/* renamed from: androidx.e.b.c */
public class C0722c {

    /* renamed from: v */
    private static final Interpolator f2467v = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a */
    private int f2468a;

    /* renamed from: b */
    private int f2469b;

    /* renamed from: c */
    private int f2470c = -1;

    /* renamed from: d */
    private float[] f2471d;

    /* renamed from: e */
    private float[] f2472e;

    /* renamed from: f */
    private float[] f2473f;

    /* renamed from: g */
    private float[] f2474g;

    /* renamed from: h */
    private int[] f2475h;

    /* renamed from: i */
    private int[] f2476i;

    /* renamed from: j */
    private int[] f2477j;

    /* renamed from: k */
    private int f2478k;

    /* renamed from: l */
    private VelocityTracker f2479l;

    /* renamed from: m */
    private float f2480m;

    /* renamed from: n */
    private float f2481n;

    /* renamed from: o */
    private int f2482o;

    /* renamed from: p */
    private int f2483p;

    /* renamed from: q */
    private OverScroller f2484q;

    /* renamed from: r */
    private final C0725a f2485r;

    /* renamed from: s */
    private View f2486s;

    /* renamed from: t */
    private boolean f2487t;

    /* renamed from: u */
    private final ViewGroup f2488u;

    /* renamed from: w */
    private final Runnable f2489w = new Runnable() {
        public void run() {
            C0722c.this.mo4034b(0);
        }
    };

    /* renamed from: androidx.e.b.c$a */
    public static abstract class C0725a {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    private C0722c(Context context, ViewGroup viewGroup, C0725a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar != null) {
            this.f2488u = viewGroup;
            this.f2485r = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f2482o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f2469b = viewConfiguration.getScaledTouchSlop();
            this.f2480m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f2481n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f2484q = new OverScroller(context, f2467v);
        } else {
            throw new IllegalArgumentException("Callback may not be null");
        }
    }

    /* renamed from: a */
    private float m2894a(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    /* renamed from: a */
    private float m2895a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        return abs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    /* renamed from: a */
    private int m2896a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f2488u.getWidth();
        float f = (float) (width / 2);
        float a = f + (m2894a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * f);
        int abs = Math.abs(i2);
        return Math.min(abs > 0 ? Math.round(Math.abs(a / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    /* renamed from: a */
    private int m2897a(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int b = m2905b(i3, (int) this.f2481n, (int) this.f2480m);
        int b2 = m2905b(i4, (int) this.f2481n, (int) this.f2480m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (b != 0) {
            f2 = (float) abs3;
            f = (float) i5;
        } else {
            f2 = (float) abs;
            f = (float) i6;
        }
        float f5 = f2 / f;
        if (b2 != 0) {
            f4 = (float) abs4;
            f3 = (float) i5;
        } else {
            f4 = (float) abs2;
            f3 = (float) i6;
        }
        float f6 = f4 / f3;
        return (int) ((((float) m2896a(i, b, this.f2485r.getViewHorizontalDragRange(view))) * f5) + (((float) m2896a(i2, b2, this.f2485r.getViewVerticalDragRange(view))) * f6));
    }

    /* renamed from: a */
    public static C0722c m2898a(ViewGroup viewGroup, float f, C0725a aVar) {
        C0722c a = m2899a(viewGroup, aVar);
        a.f2469b = (int) (((float) a.f2469b) * (1.0f / f));
        return a;
    }

    /* renamed from: a */
    public static C0722c m2899a(ViewGroup viewGroup, C0725a aVar) {
        return new C0722c(viewGroup.getContext(), viewGroup, aVar);
    }

    /* renamed from: a */
    private void m2900a(float f, float f2) {
        this.f2487t = true;
        this.f2485r.onViewReleased(this.f2486s, f, f2);
        this.f2487t = false;
        if (this.f2468a == 1) {
            mo4034b(0);
        }
    }

    /* renamed from: a */
    private void m2901a(float f, float f2, int i) {
        m2912d(i);
        float[] fArr = this.f2471d;
        this.f2473f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f2472e;
        this.f2474g[i] = f2;
        fArr2[i] = f2;
        this.f2475h[i] = m2910d((int) f, (int) f2);
        this.f2478k |= 1 << i;
    }

    /* renamed from: a */
    private boolean m2902a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f2475h[i] & i2) != i2 || (this.f2483p & i2) == 0 || (this.f2477j[i] & i2) == i2 || (this.f2476i[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f2469b;
        if (abs <= ((float) i3) && abs2 <= ((float) i3)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f2485r.onEdgeLock(i2)) {
            return (this.f2476i[i] & i2) == 0 && abs > ((float) this.f2469b);
        }
        int[] iArr = this.f2477j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    /* renamed from: a */
    private boolean m2903a(int i, int i2, int i3, int i4) {
        int left = this.f2486s.getLeft();
        int top = this.f2486s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f2484q.abortAnimation();
            mo4034b(0);
            return false;
        }
        this.f2484q.startScroll(left, top, i5, i6, m2897a(this.f2486s, i5, i6, i3, i4));
        mo4034b(2);
        return true;
    }

    /* renamed from: a */
    private boolean m2904a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f2485r.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.f2485r.getViewVerticalDragRange(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.f2469b) : z2 && Math.abs(f2) > ((float) this.f2469b);
        }
        int i = this.f2469b;
        return (f * f) + (f2 * f2) > ((float) (i * i));
    }

    /* renamed from: b */
    private int m2905b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    /* renamed from: b */
    private void m2906b(float f, float f2, int i) {
        int i2 = 1;
        if (!m2902a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m2902a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m2902a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m2902a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f2476i;
            iArr[i] = iArr[i] | i2;
            this.f2485r.onEdgeDragStarted(i2, i);
        }
    }

    /* renamed from: b */
    private void m2907b(int i, int i2, int i3, int i4) {
        int left = this.f2486s.getLeft();
        int top = this.f2486s.getTop();
        if (i3 != 0) {
            i = this.f2485r.clampViewPositionHorizontal(this.f2486s, i, i3);
            C0656u.m2620f(this.f2486s, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.f2485r.clampViewPositionVertical(this.f2486s, i2, i4);
            C0656u.m2618e(this.f2486s, i2 - top);
        }
        int i6 = i2;
        if (i3 != 0 || i4 != 0) {
            this.f2485r.onViewPositionChanged(this.f2486s, i5, i6, i5 - left, i6 - top);
        }
    }

    /* renamed from: c */
    private void m2908c(int i) {
        if (this.f2471d != null && mo4028a(i)) {
            this.f2471d[i] = 0.0f;
            this.f2472e[i] = 0.0f;
            this.f2473f[i] = 0.0f;
            this.f2474g[i] = 0.0f;
            this.f2475h[i] = 0;
            this.f2476i[i] = 0;
            this.f2477j[i] = 0;
            this.f2478k = (~(1 << i)) & this.f2478k;
        }
    }

    /* renamed from: c */
    private void m2909c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m2914e(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f2473f[pointerId] = x;
                this.f2474g[pointerId] = y;
            }
        }
    }

    /* renamed from: d */
    private int m2910d(int i, int i2) {
        int i3 = i < this.f2488u.getLeft() + this.f2482o ? 1 : 0;
        if (i2 < this.f2488u.getTop() + this.f2482o) {
            i3 |= 4;
        }
        if (i > this.f2488u.getRight() - this.f2482o) {
            i3 |= 2;
        }
        return i2 > this.f2488u.getBottom() - this.f2482o ? i3 | 8 : i3;
    }

    /* renamed from: d */
    private void m2911d() {
        float[] fArr = this.f2471d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f2472e, 0.0f);
            Arrays.fill(this.f2473f, 0.0f);
            Arrays.fill(this.f2474g, 0.0f);
            Arrays.fill(this.f2475h, 0);
            Arrays.fill(this.f2476i, 0);
            Arrays.fill(this.f2477j, 0);
            this.f2478k = 0;
        }
    }

    /* renamed from: d */
    private void m2912d(int i) {
        float[] fArr = this.f2471d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.f2471d;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f2472e;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f2473f;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.f2474g;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.f2475h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f2476i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f2477j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f2471d = fArr2;
            this.f2472e = fArr3;
            this.f2473f = fArr4;
            this.f2474g = fArr5;
            this.f2475h = iArr;
            this.f2476i = iArr2;
            this.f2477j = iArr3;
        }
    }

    /* renamed from: e */
    private void m2913e() {
        this.f2479l.computeCurrentVelocity(ParseQuery.MAX_LIMIT, this.f2480m);
        m2900a(m2895a(this.f2479l.getXVelocity(this.f2470c), this.f2481n, this.f2480m), m2895a(this.f2479l.getYVelocity(this.f2470c), this.f2481n, this.f2480m));
    }

    /* renamed from: e */
    private boolean m2914e(int i) {
        if (mo4028a(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    /* renamed from: a */
    public int mo4026a() {
        return this.f2468a;
    }

    /* renamed from: a */
    public void mo4027a(View view, int i) {
        if (view.getParent() == this.f2488u) {
            this.f2486s = view;
            this.f2470c = i;
            this.f2485r.onViewCaptured(view, i);
            mo4034b(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f2488u + ")");
    }

    /* renamed from: a */
    public boolean mo4028a(int i) {
        return ((1 << i) & this.f2478k) != 0;
    }

    /* renamed from: a */
    public boolean mo4029a(int i, int i2) {
        if (this.f2487t) {
            return m2903a(i, i2, (int) this.f2479l.getXVelocity(this.f2470c), (int) this.f2479l.getYVelocity(this.f2470c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d1, code lost:
        if (r12 != r11) goto L_0x00da;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo4030a(android.view.MotionEvent r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r17.getActionMasked()
            int r3 = r17.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r16.mo4040c()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f2479l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f2479l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f2479l
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            switch(r2) {
                case 0: goto L_0x00f8;
                case 1: goto L_0x00f3;
                case 2: goto L_0x0064;
                case 3: goto L_0x00f3;
                case 4: goto L_0x0025;
                case 5: goto L_0x0030;
                case 6: goto L_0x0028;
                default: goto L_0x0025;
            }
        L_0x0025:
            r5 = 0
            goto L_0x0129
        L_0x0028:
            int r1 = r1.getPointerId(r3)
            r0.m2908c((int) r1)
            goto L_0x0025
        L_0x0030:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.m2901a((float) r7, (float) r1, (int) r2)
            int r3 = r0.f2468a
            if (r3 != 0) goto L_0x0054
            int[] r1 = r0.f2475h
            r1 = r1[r2]
            int r3 = r0.f2483p
            r4 = r1 & r3
            if (r4 == 0) goto L_0x0025
            androidx.e.b.c$a r4 = r0.f2485r
            r1 = r1 & r3
            r4.onEdgeTouched(r1, r2)
            goto L_0x0025
        L_0x0054:
            if (r3 != r4) goto L_0x0025
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.mo4039c(r3, r1)
            android.view.View r3 = r0.f2486s
            if (r1 != r3) goto L_0x0025
            r0.mo4037b((android.view.View) r1, (int) r2)
            goto L_0x0025
        L_0x0064:
            float[] r2 = r0.f2471d
            if (r2 == 0) goto L_0x0025
            float[] r2 = r0.f2472e
            if (r2 != 0) goto L_0x006d
            goto L_0x0025
        L_0x006d:
            int r2 = r17.getPointerCount()
            r3 = 0
        L_0x0072:
            if (r3 >= r2) goto L_0x00ee
            int r4 = r1.getPointerId(r3)
            boolean r7 = r0.m2914e(r4)
            if (r7 != 0) goto L_0x0080
            goto L_0x00eb
        L_0x0080:
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.f2471d
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.f2472e
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.mo4039c(r7, r8)
            if (r7 == 0) goto L_0x00a4
            boolean r8 = r0.m2904a((android.view.View) r7, (float) r9, (float) r10)
            if (r8 == 0) goto L_0x00a4
            r8 = 1
            goto L_0x00a5
        L_0x00a4:
            r8 = 0
        L_0x00a5:
            if (r8 == 0) goto L_0x00da
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            androidx.e.b.c$a r14 = r0.f2485r
            int r12 = r14.clampViewPositionHorizontal(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            androidx.e.b.c$a r5 = r0.f2485r
            int r5 = r5.clampViewPositionVertical(r7, r15, r14)
            androidx.e.b.c$a r14 = r0.f2485r
            int r14 = r14.getViewHorizontalDragRange(r7)
            androidx.e.b.c$a r15 = r0.f2485r
            int r15 = r15.getViewVerticalDragRange(r7)
            if (r14 == 0) goto L_0x00d3
            if (r14 <= 0) goto L_0x00da
            if (r12 != r11) goto L_0x00da
        L_0x00d3:
            if (r15 == 0) goto L_0x00ee
            if (r15 <= 0) goto L_0x00da
            if (r5 != r13) goto L_0x00da
            goto L_0x00ee
        L_0x00da:
            r0.m2906b((float) r9, (float) r10, (int) r4)
            int r5 = r0.f2468a
            if (r5 != r6) goto L_0x00e2
            goto L_0x00ee
        L_0x00e2:
            if (r8 == 0) goto L_0x00eb
            boolean r4 = r0.mo4037b((android.view.View) r7, (int) r4)
            if (r4 == 0) goto L_0x00eb
            goto L_0x00ee
        L_0x00eb:
            int r3 = r3 + 1
            goto L_0x0072
        L_0x00ee:
            r16.m2909c((android.view.MotionEvent) r17)
            goto L_0x0025
        L_0x00f3:
            r16.mo4040c()
            goto L_0x0025
        L_0x00f8:
            float r2 = r17.getX()
            float r3 = r17.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.m2901a((float) r2, (float) r3, (int) r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.mo4039c(r2, r3)
            android.view.View r3 = r0.f2486s
            if (r2 != r3) goto L_0x0119
            int r3 = r0.f2468a
            if (r3 != r4) goto L_0x0119
            r0.mo4037b((android.view.View) r2, (int) r1)
        L_0x0119:
            int[] r2 = r0.f2475h
            r2 = r2[r1]
            int r3 = r0.f2483p
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0129
            androidx.e.b.c$a r4 = r0.f2485r
            r2 = r2 & r3
            r4.onEdgeTouched(r2, r1)
        L_0x0129:
            int r1 = r0.f2468a
            if (r1 != r6) goto L_0x012e
            r5 = 1
        L_0x012e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p035e.p037b.C0722c.mo4030a(android.view.MotionEvent):boolean");
    }

    /* renamed from: a */
    public boolean mo4031a(View view, int i, int i2) {
        this.f2486s = view;
        this.f2470c = -1;
        boolean a = m2903a(i, i2, 0, 0);
        if (!a && this.f2468a == 0 && this.f2486s != null) {
            this.f2486s = null;
        }
        return a;
    }

    /* renamed from: a */
    public boolean mo4032a(boolean z) {
        if (this.f2468a == 2) {
            boolean computeScrollOffset = this.f2484q.computeScrollOffset();
            int currX = this.f2484q.getCurrX();
            int currY = this.f2484q.getCurrY();
            int left = currX - this.f2486s.getLeft();
            int top = currY - this.f2486s.getTop();
            if (left != 0) {
                C0656u.m2620f(this.f2486s, left);
            }
            if (top != 0) {
                C0656u.m2618e(this.f2486s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f2485r.onViewPositionChanged(this.f2486s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f2484q.getFinalX() && currY == this.f2484q.getFinalY()) {
                this.f2484q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.f2488u.post(this.f2489w);
                } else {
                    mo4034b(0);
                }
            }
        }
        return this.f2468a == 2;
    }

    /* renamed from: b */
    public int mo4033b() {
        return this.f2469b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4034b(int i) {
        this.f2488u.removeCallbacks(this.f2489w);
        if (this.f2468a != i) {
            this.f2468a = i;
            this.f2485r.onViewDragStateChanged(i);
            if (this.f2468a == 0) {
                this.f2486s = null;
            }
        }
    }

    /* renamed from: b */
    public void mo4035b(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            mo4040c();
        }
        if (this.f2479l == null) {
            this.f2479l = VelocityTracker.obtain();
        }
        this.f2479l.addMovement(motionEvent);
        int i2 = 0;
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = motionEvent.getPointerId(0);
                View c = mo4039c((int) x, (int) y);
                m2901a(x, y, pointerId);
                mo4037b(c, pointerId);
                int i3 = this.f2475h[pointerId];
                int i4 = this.f2483p;
                if ((i3 & i4) != 0) {
                    this.f2485r.onEdgeTouched(i3 & i4, pointerId);
                    return;
                }
                return;
            case 1:
                if (this.f2468a == 1) {
                    m2913e();
                    break;
                }
                break;
            case 2:
                if (this.f2468a != 1) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i2 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        if (m2914e(pointerId2)) {
                            float x2 = motionEvent.getX(i2);
                            float y2 = motionEvent.getY(i2);
                            float f = x2 - this.f2471d[pointerId2];
                            float f2 = y2 - this.f2472e[pointerId2];
                            m2906b(f, f2, pointerId2);
                            if (this.f2468a != 1) {
                                View c2 = mo4039c((int) x2, (int) y2);
                                if (m2904a(c2, f, f2) && mo4037b(c2, pointerId2)) {
                                }
                            }
                        }
                        i2++;
                    }
                } else if (m2914e(this.f2470c)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f2470c);
                    float x3 = motionEvent.getX(findPointerIndex);
                    float y3 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f2473f;
                    int i5 = this.f2470c;
                    int i6 = (int) (x3 - fArr[i5]);
                    int i7 = (int) (y3 - this.f2474g[i5]);
                    m2907b(this.f2486s.getLeft() + i6, this.f2486s.getTop() + i7, i6, i7);
                } else {
                    return;
                }
                m2909c(motionEvent);
                return;
            case 3:
                if (this.f2468a == 1) {
                    m2900a(0.0f, 0.0f);
                    break;
                }
                break;
            case 5:
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                float x4 = motionEvent.getX(actionIndex);
                float y4 = motionEvent.getY(actionIndex);
                m2901a(x4, y4, pointerId3);
                if (this.f2468a == 0) {
                    mo4037b(mo4039c((int) x4, (int) y4), pointerId3);
                    int i8 = this.f2475h[pointerId3];
                    int i9 = this.f2483p;
                    if ((i8 & i9) != 0) {
                        this.f2485r.onEdgeTouched(i8 & i9, pointerId3);
                        return;
                    }
                    return;
                } else if (mo4036b((int) x4, (int) y4)) {
                    mo4037b(this.f2486s, pointerId3);
                    return;
                } else {
                    return;
                }
            case 6:
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.f2468a == 1 && pointerId4 == this.f2470c) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 < pointerCount2) {
                            int pointerId5 = motionEvent.getPointerId(i2);
                            if (pointerId5 != this.f2470c) {
                                View c3 = mo4039c((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                                View view = this.f2486s;
                                if (c3 == view && mo4037b(view, pointerId5)) {
                                    i = this.f2470c;
                                }
                            }
                            i2++;
                        } else {
                            i = -1;
                        }
                    }
                    if (i == -1) {
                        m2913e();
                    }
                }
                m2908c(pointerId4);
                return;
            default:
                return;
        }
        mo4040c();
    }

    /* renamed from: b */
    public boolean mo4036b(int i, int i2) {
        return mo4038b(this.f2486s, i, i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4037b(View view, int i) {
        if (view == this.f2486s && this.f2470c == i) {
            return true;
        }
        if (view == null || !this.f2485r.tryCaptureView(view, i)) {
            return false;
        }
        this.f2470c = i;
        mo4027a(view, i);
        return true;
    }

    /* renamed from: b */
    public boolean mo4038b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    /* renamed from: c */
    public View mo4039c(int i, int i2) {
        for (int childCount = this.f2488u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f2488u.getChildAt(this.f2485r.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: c */
    public void mo4040c() {
        this.f2470c = -1;
        m2911d();
        VelocityTracker velocityTracker = this.f2479l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2479l = null;
        }
    }
}
