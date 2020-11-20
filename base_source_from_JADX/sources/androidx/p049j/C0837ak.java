package androidx.p049j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.p049j.C0822a;
import androidx.p049j.C0874n;

/* renamed from: androidx.j.ak */
public abstract class C0837ak extends C0874n {

    /* renamed from: a */
    private static final String[] f2796a = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: b */
    private int f2797b = 3;

    /* renamed from: androidx.j.ak$a */
    private static class C0839a extends AnimatorListenerAdapter implements C0822a.C0823a, C0874n.C0881d {

        /* renamed from: a */
        boolean f2802a = false;

        /* renamed from: b */
        private final View f2803b;

        /* renamed from: c */
        private final int f2804c;

        /* renamed from: d */
        private final ViewGroup f2805d;

        /* renamed from: e */
        private final boolean f2806e;

        /* renamed from: f */
        private boolean f2807f;

        C0839a(View view, int i, boolean z) {
            this.f2803b = view;
            this.f2804c = i;
            this.f2805d = (ViewGroup) view.getParent();
            this.f2806e = z;
            m3462a(true);
        }

        /* renamed from: a */
        private void m3461a() {
            if (!this.f2802a) {
                C0828ad.m3416a(this.f2803b, this.f2804c);
                ViewGroup viewGroup = this.f2805d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            m3462a(false);
        }

        /* renamed from: a */
        private void m3462a(boolean z) {
            ViewGroup viewGroup;
            if (this.f2806e && this.f2807f != z && (viewGroup = this.f2805d) != null) {
                this.f2807f = z;
                C0896y.m3589a(viewGroup, z);
            }
        }

        /* renamed from: a */
        public void mo4697a(C0874n nVar) {
        }

        /* renamed from: b */
        public void mo4694b(C0874n nVar) {
            m3461a();
            nVar.removeListener(this);
        }

        /* renamed from: c */
        public void mo4695c(C0874n nVar) {
            m3462a(false);
        }

        /* renamed from: d */
        public void mo4696d(C0874n nVar) {
            m3462a(true);
        }

        /* renamed from: e */
        public void mo4698e(C0874n nVar) {
        }

        public void onAnimationCancel(Animator animator) {
            this.f2802a = true;
        }

        public void onAnimationEnd(Animator animator) {
            m3461a();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f2802a) {
                C0828ad.m3416a(this.f2803b, this.f2804c);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f2802a) {
                C0828ad.m3416a(this.f2803b, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: androidx.j.ak$b */
    private static class C0840b {

        /* renamed from: a */
        boolean f2808a;

        /* renamed from: b */
        boolean f2809b;

        /* renamed from: c */
        int f2810c;

        /* renamed from: d */
        int f2811d;

        /* renamed from: e */
        ViewGroup f2812e;

        /* renamed from: f */
        ViewGroup f2813f;

        C0840b() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0083, code lost:
        if (r0.f2811d == 0) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008d, code lost:
        if (r0.f2812e == null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009f, code lost:
        if (r0.f2810c == 0) goto L_0x00a1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.p049j.C0837ak.C0840b m3451a(androidx.p049j.C0891t r7, androidx.p049j.C0891t r8) {
        /*
            r6 = this;
            androidx.j.ak$b r0 = new androidx.j.ak$b
            r0.<init>()
            r1 = 0
            r0.f2808a = r1
            r0.f2809b = r1
            r2 = 0
            r3 = -1
            if (r7 == 0) goto L_0x0035
            java.util.Map<java.lang.String, java.lang.Object> r4 = r7.f2917a
            java.lang.String r5 = "android:visibility:visibility"
            boolean r4 = r4.containsKey(r5)
            if (r4 == 0) goto L_0x0035
            java.util.Map<java.lang.String, java.lang.Object> r4 = r7.f2917a
            java.lang.String r5 = "android:visibility:visibility"
            java.lang.Object r4 = r4.get(r5)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r0.f2810c = r4
            java.util.Map<java.lang.String, java.lang.Object> r4 = r7.f2917a
            java.lang.String r5 = "android:visibility:parent"
            java.lang.Object r4 = r4.get(r5)
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            r0.f2812e = r4
            goto L_0x0039
        L_0x0035:
            r0.f2810c = r3
            r0.f2812e = r2
        L_0x0039:
            if (r8 == 0) goto L_0x0060
            java.util.Map<java.lang.String, java.lang.Object> r4 = r8.f2917a
            java.lang.String r5 = "android:visibility:visibility"
            boolean r4 = r4.containsKey(r5)
            if (r4 == 0) goto L_0x0060
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.f2917a
            java.lang.String r3 = "android:visibility:visibility"
            java.lang.Object r2 = r2.get(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f2811d = r2
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.f2917a
            java.lang.String r3 = "android:visibility:parent"
            java.lang.Object r2 = r2.get(r3)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            goto L_0x0062
        L_0x0060:
            r0.f2811d = r3
        L_0x0062:
            r0.f2813f = r2
            r2 = 1
            if (r7 == 0) goto L_0x0090
            if (r8 == 0) goto L_0x0090
            int r7 = r0.f2810c
            int r8 = r0.f2811d
            if (r7 != r8) goto L_0x0076
            android.view.ViewGroup r7 = r0.f2812e
            android.view.ViewGroup r8 = r0.f2813f
            if (r7 != r8) goto L_0x0076
            return r0
        L_0x0076:
            int r7 = r0.f2810c
            int r8 = r0.f2811d
            if (r7 == r8) goto L_0x0086
            int r7 = r0.f2810c
            if (r7 != 0) goto L_0x0081
            goto L_0x00a1
        L_0x0081:
            int r7 = r0.f2811d
            if (r7 != 0) goto L_0x00a4
            goto L_0x0096
        L_0x0086:
            android.view.ViewGroup r7 = r0.f2813f
            if (r7 != 0) goto L_0x008b
            goto L_0x00a1
        L_0x008b:
            android.view.ViewGroup r7 = r0.f2812e
            if (r7 != 0) goto L_0x00a4
            goto L_0x0096
        L_0x0090:
            if (r7 != 0) goto L_0x009b
            int r7 = r0.f2811d
            if (r7 != 0) goto L_0x009b
        L_0x0096:
            r0.f2809b = r2
        L_0x0098:
            r0.f2808a = r2
            goto L_0x00a4
        L_0x009b:
            if (r8 != 0) goto L_0x00a4
            int r7 = r0.f2810c
            if (r7 != 0) goto L_0x00a4
        L_0x00a1:
            r0.f2809b = r1
            goto L_0x0098
        L_0x00a4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p049j.C0837ak.m3451a(androidx.j.t, androidx.j.t):androidx.j.ak$b");
    }

    /* renamed from: a */
    private void m3452a(C0891t tVar) {
        tVar.f2917a.put("android:visibility:visibility", Integer.valueOf(tVar.f2918b.getVisibility()));
        tVar.f2917a.put("android:visibility:parent", tVar.f2918b.getParent());
        int[] iArr = new int[2];
        tVar.f2918b.getLocationOnScreen(iArr);
        tVar.f2917a.put("android:visibility:screenLocation", iArr);
    }

    /* renamed from: a */
    public Animator mo4684a(ViewGroup viewGroup, View view, C0891t tVar, C0891t tVar2) {
        return null;
    }

    /* renamed from: a */
    public Animator mo4685a(ViewGroup viewGroup, C0891t tVar, int i, C0891t tVar2, int i2) {
        if ((this.f2797b & 1) != 1 || tVar2 == null) {
            return null;
        }
        if (tVar == null) {
            View view = (View) tVar2.f2918b.getParent();
            if (m3451a(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f2808a) {
                return null;
            }
        }
        return mo4684a(viewGroup, tVar2.f2918b, tVar, tVar2);
    }

    /* renamed from: a */
    public void mo4686a(int i) {
        if ((i & -4) == 0) {
            this.f2797b = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    /* renamed from: b */
    public Animator mo4687b(ViewGroup viewGroup, View view, C0891t tVar, C0891t tVar2) {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0080, code lost:
        if (r9.mCanRemoveViews != false) goto L_0x0082;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0040  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator mo4688b(final android.view.ViewGroup r10, androidx.p049j.C0891t r11, int r12, androidx.p049j.C0891t r13, int r14) {
        /*
            r9 = this;
            int r12 = r9.f2797b
            r0 = 2
            r12 = r12 & r0
            r1 = 0
            if (r12 == r0) goto L_0x0008
            return r1
        L_0x0008:
            if (r11 != 0) goto L_0x000b
            return r1
        L_0x000b:
            android.view.View r12 = r11.f2918b
            if (r13 == 0) goto L_0x0012
            android.view.View r2 = r13.f2918b
            goto L_0x0013
        L_0x0012:
            r2 = r1
        L_0x0013:
            int r3 = androidx.p049j.C0869j.C0870a.save_overlay_view
            java.lang.Object r3 = r12.getTag(r3)
            android.view.View r3 = (android.view.View) r3
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0023
            r6 = r1
            r2 = 1
            goto L_0x0084
        L_0x0023:
            if (r2 == 0) goto L_0x0035
            android.view.ViewParent r3 = r2.getParent()
            if (r3 != 0) goto L_0x002c
            goto L_0x0035
        L_0x002c:
            r3 = 4
            if (r14 != r3) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            if (r12 != r2) goto L_0x003b
        L_0x0032:
            r3 = r1
            r6 = r2
            goto L_0x0039
        L_0x0035:
            if (r2 == 0) goto L_0x003b
            r6 = r1
            r3 = r2
        L_0x0039:
            r2 = 0
            goto L_0x003e
        L_0x003b:
            r3 = r1
            r6 = r3
            r2 = 1
        L_0x003e:
            if (r2 == 0) goto L_0x0083
            android.view.ViewParent r2 = r12.getParent()
            if (r2 != 0) goto L_0x0047
            goto L_0x0082
        L_0x0047:
            android.view.ViewParent r2 = r12.getParent()
            boolean r2 = r2 instanceof android.view.View
            if (r2 == 0) goto L_0x0083
            android.view.ViewParent r2 = r12.getParent()
            android.view.View r2 = (android.view.View) r2
            androidx.j.t r7 = r9.getTransitionValues(r2, r5)
            androidx.j.t r8 = r9.getMatchedTransitionValues(r2, r5)
            androidx.j.ak$b r7 = r9.m3451a(r7, r8)
            boolean r7 = r7.f2808a
            if (r7 != 0) goto L_0x006b
            android.view.View r2 = androidx.p049j.C0890s.m3578a(r10, r12, r2)
            r3 = r2
            goto L_0x0083
        L_0x006b:
            int r7 = r2.getId()
            android.view.ViewParent r2 = r2.getParent()
            if (r2 != 0) goto L_0x0083
            r2 = -1
            if (r7 == r2) goto L_0x0083
            android.view.View r2 = r10.findViewById(r7)
            if (r2 == 0) goto L_0x0083
            boolean r2 = r9.mCanRemoveViews
            if (r2 == 0) goto L_0x0083
        L_0x0082:
            r3 = r12
        L_0x0083:
            r2 = 0
        L_0x0084:
            if (r3 == 0) goto L_0x00d6
            if (r2 != 0) goto L_0x00b8
            java.util.Map<java.lang.String, java.lang.Object> r14 = r11.f2917a
            java.lang.String r1 = "android:visibility:screenLocation"
            java.lang.Object r14 = r14.get(r1)
            int[] r14 = (int[]) r14
            r1 = r14[r4]
            r14 = r14[r5]
            int[] r0 = new int[r0]
            r10.getLocationOnScreen(r0)
            r4 = r0[r4]
            int r1 = r1 - r4
            int r4 = r3.getLeft()
            int r1 = r1 - r4
            r3.offsetLeftAndRight(r1)
            r0 = r0[r5]
            int r14 = r14 - r0
            int r0 = r3.getTop()
            int r14 = r14 - r0
            r3.offsetTopAndBottom(r14)
            androidx.j.x r14 = androidx.p049j.C0896y.m3588a(r10)
            r14.mo4834a(r3)
        L_0x00b8:
            android.animation.Animator r11 = r9.mo4687b(r10, r3, r11, r13)
            if (r2 != 0) goto L_0x00d5
            if (r11 != 0) goto L_0x00c8
            androidx.j.x r10 = androidx.p049j.C0896y.m3588a(r10)
            r10.mo4835b(r3)
            goto L_0x00d5
        L_0x00c8:
            int r13 = androidx.p049j.C0869j.C0870a.save_overlay_view
            r12.setTag(r13, r3)
            androidx.j.ak$1 r13 = new androidx.j.ak$1
            r13.<init>(r10, r3, r12)
            r9.addListener(r13)
        L_0x00d5:
            return r11
        L_0x00d6:
            if (r6 == 0) goto L_0x00f8
            int r12 = r6.getVisibility()
            androidx.p049j.C0828ad.m3416a((android.view.View) r6, (int) r4)
            android.animation.Animator r10 = r9.mo4687b(r10, r6, r11, r13)
            if (r10 == 0) goto L_0x00f4
            androidx.j.ak$a r11 = new androidx.j.ak$a
            r11.<init>(r6, r14, r5)
            r10.addListener(r11)
            androidx.p049j.C0822a.m3397a(r10, r11)
            r9.addListener(r11)
            goto L_0x00f7
        L_0x00f4:
            androidx.p049j.C0828ad.m3416a((android.view.View) r6, (int) r12)
        L_0x00f7:
            return r10
        L_0x00f8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p049j.C0837ak.mo4688b(android.view.ViewGroup, androidx.j.t, int, androidx.j.t, int):android.animation.Animator");
    }

    public void captureEndValues(C0891t tVar) {
        m3452a(tVar);
    }

    public void captureStartValues(C0891t tVar) {
        m3452a(tVar);
    }

    public Animator createAnimator(ViewGroup viewGroup, C0891t tVar, C0891t tVar2) {
        C0840b a = m3451a(tVar, tVar2);
        if (!a.f2808a) {
            return null;
        }
        if (a.f2812e == null && a.f2813f == null) {
            return null;
        }
        if (a.f2809b) {
            return mo4685a(viewGroup, tVar, a.f2810c, tVar2, a.f2811d);
        }
        return mo4688b(viewGroup, tVar, a.f2810c, tVar2, a.f2811d);
    }

    public String[] getTransitionProperties() {
        return f2796a;
    }

    public boolean isTransitionRequired(C0891t tVar, C0891t tVar2) {
        if (tVar == null && tVar2 == null) {
            return false;
        }
        if (tVar != null && tVar2 != null && tVar2.f2917a.containsKey("android:visibility:visibility") != tVar.f2917a.containsKey("android:visibility:visibility")) {
            return false;
        }
        C0840b a = m3451a(tVar, tVar2);
        if (a.f2808a) {
            return a.f2810c == 0 || a.f2811d == 0;
        }
        return false;
    }
}
