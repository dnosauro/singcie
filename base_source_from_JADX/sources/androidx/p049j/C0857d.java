package androidx.p049j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p030h.C0656u;

/* renamed from: androidx.j.d */
public class C0857d extends C0837ak {

    /* renamed from: androidx.j.d$a */
    private static class C0859a extends AnimatorListenerAdapter {

        /* renamed from: a */
        private final View f2855a;

        /* renamed from: b */
        private boolean f2856b = false;

        C0859a(View view) {
            this.f2855a = view;
        }

        public void onAnimationEnd(Animator animator) {
            C0828ad.m3415a(this.f2855a, 1.0f);
            if (this.f2856b) {
                this.f2855a.setLayerType(0, (Paint) null);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (C0656u.m2636s(this.f2855a) && this.f2855a.getLayerType() == 0) {
                this.f2856b = true;
                this.f2855a.setLayerType(2, (Paint) null);
            }
        }
    }

    public C0857d() {
    }

    public C0857d(int i) {
        mo4686a(i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = (java.lang.Float) r1.f2917a.get("android:fade:transitionAlpha");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float m3490a(androidx.p049j.C0891t r1, float r2) {
        /*
            if (r1 == 0) goto L_0x0012
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.f2917a
            java.lang.String r0 = "android:fade:transitionAlpha"
            java.lang.Object r1 = r1.get(r0)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r1 == 0) goto L_0x0012
            float r2 = r1.floatValue()
        L_0x0012:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p049j.C0857d.m3490a(androidx.j.t, float):float");
    }

    /* renamed from: a */
    private Animator m3491a(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        C0828ad.m3415a(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, C0828ad.f2783a, new float[]{f2});
        ofFloat.addListener(new C0859a(view));
        addListener(new C0882o() {
            /* renamed from: b */
            public void mo4694b(C0874n nVar) {
                C0828ad.m3415a(view, 1.0f);
                C0828ad.m3423e(view);
                nVar.removeListener(this);
            }
        });
        return ofFloat;
    }

    /* renamed from: a */
    public Animator mo4684a(ViewGroup viewGroup, View view, C0891t tVar, C0891t tVar2) {
        float f = 0.0f;
        float a = m3490a(tVar, 0.0f);
        if (a != 1.0f) {
            f = a;
        }
        return m3491a(view, f, 1.0f);
    }

    /* renamed from: b */
    public Animator mo4687b(ViewGroup viewGroup, View view, C0891t tVar, C0891t tVar2) {
        C0828ad.m3422d(view);
        return m3491a(view, m3490a(tVar, 1.0f), 0.0f);
    }

    public void captureStartValues(C0891t tVar) {
        super.captureStartValues(tVar);
        tVar.f2917a.put("android:fade:transitionAlpha", Float.valueOf(C0828ad.m3421c(tVar.f2918b)));
    }
}
