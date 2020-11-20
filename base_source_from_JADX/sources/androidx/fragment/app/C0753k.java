package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.C0057c;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.p029g.C0580a;
import androidx.core.p029g.C0581b;
import androidx.core.p030h.C0653r;
import androidx.fragment.app.C0735d;
import androidx.fragment.app.C0750j;
import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0971u;
import androidx.p018c.C0402b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: androidx.fragment.app.k */
final class C0753k extends C0750j implements LayoutInflater.Factory2 {

    /* renamed from: D */
    static final Interpolator f2549D = new DecelerateInterpolator(2.5f);

    /* renamed from: E */
    static final Interpolator f2550E = new DecelerateInterpolator(1.5f);

    /* renamed from: b */
    static boolean f2551b = false;

    /* renamed from: A */
    SparseArray<Parcelable> f2552A = null;

    /* renamed from: B */
    ArrayList<C0767g> f2553B;

    /* renamed from: C */
    Runnable f2554C = new Runnable() {
        public void run() {
            C0753k.this.mo4444k();
        }
    };

    /* renamed from: F */
    private OnBackPressedDispatcher f2555F;

    /* renamed from: G */
    private final C0057c f2556G = new C0057c(false) {
        /* renamed from: c */
        public void mo680c() {
            C0753k.this.mo4433g();
        }
    };

    /* renamed from: H */
    private final CopyOnWriteArrayList<C0763c> f2557H = new CopyOnWriteArrayList<>();

    /* renamed from: I */
    private C0770m f2558I;

    /* renamed from: c */
    ArrayList<C0765e> f2559c;

    /* renamed from: d */
    boolean f2560d;

    /* renamed from: e */
    int f2561e = 0;

    /* renamed from: f */
    final ArrayList<C0735d> f2562f = new ArrayList<>();

    /* renamed from: g */
    final HashMap<String, C0735d> f2563g = new HashMap<>();

    /* renamed from: h */
    ArrayList<C0730a> f2564h;

    /* renamed from: i */
    ArrayList<C0735d> f2565i;

    /* renamed from: j */
    ArrayList<C0730a> f2566j;

    /* renamed from: k */
    ArrayList<Integer> f2567k;

    /* renamed from: l */
    ArrayList<C0750j.C0752b> f2568l;

    /* renamed from: m */
    int f2569m = 0;

    /* renamed from: n */
    C0749i f2570n;

    /* renamed from: o */
    C0746f f2571o;

    /* renamed from: p */
    C0735d f2572p;

    /* renamed from: q */
    C0735d f2573q;

    /* renamed from: r */
    boolean f2574r;

    /* renamed from: s */
    boolean f2575s;

    /* renamed from: t */
    boolean f2576t;

    /* renamed from: u */
    boolean f2577u;

    /* renamed from: v */
    boolean f2578v;

    /* renamed from: w */
    ArrayList<C0730a> f2579w;

    /* renamed from: x */
    ArrayList<Boolean> f2580x;

    /* renamed from: y */
    ArrayList<C0735d> f2581y;

    /* renamed from: z */
    Bundle f2582z = null;

    /* renamed from: androidx.fragment.app.k$a */
    private static class C0761a {

        /* renamed from: a */
        public final Animation f2598a;

        /* renamed from: b */
        public final Animator f2599b;

        C0761a(Animator animator) {
            this.f2598a = null;
            this.f2599b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        C0761a(Animation animation) {
            this.f2598a = animation;
            this.f2599b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* renamed from: androidx.fragment.app.k$b */
    private static class C0762b extends AnimationSet implements Runnable {

        /* renamed from: a */
        private final ViewGroup f2600a;

        /* renamed from: b */
        private final View f2601b;

        /* renamed from: c */
        private boolean f2602c;

        /* renamed from: d */
        private boolean f2603d;

        /* renamed from: e */
        private boolean f2604e = true;

        C0762b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f2600a = viewGroup;
            this.f2601b = view;
            addAnimation(animation);
            this.f2600a.post(this);
        }

        public boolean getTransformation(long j, Transformation transformation) {
            this.f2604e = true;
            if (this.f2602c) {
                return !this.f2603d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f2602c = true;
                C0653r.m2564a(this.f2600a, this);
            }
            return true;
        }

        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.f2604e = true;
            if (this.f2602c) {
                return !this.f2603d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.f2602c = true;
                C0653r.m2564a(this.f2600a, this);
            }
            return true;
        }

        public void run() {
            if (this.f2602c || !this.f2604e) {
                this.f2600a.endViewTransition(this.f2601b);
                this.f2603d = true;
                return;
            }
            this.f2604e = false;
            this.f2600a.post(this);
        }
    }

    /* renamed from: androidx.fragment.app.k$c */
    private static final class C0763c {

        /* renamed from: a */
        final C0750j.C0751a f2605a;

        /* renamed from: b */
        final boolean f2606b;

        C0763c(C0750j.C0751a aVar, boolean z) {
            this.f2605a = aVar;
            this.f2606b = z;
        }
    }

    /* renamed from: androidx.fragment.app.k$d */
    static class C0764d {

        /* renamed from: a */
        public static final int[] f2607a = {16842755, 16842960, 16842961};
    }

    /* renamed from: androidx.fragment.app.k$e */
    interface C0765e {
        /* renamed from: a */
        boolean mo4068a(ArrayList<C0730a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* renamed from: androidx.fragment.app.k$f */
    private class C0766f implements C0765e {

        /* renamed from: a */
        final String f2608a;

        /* renamed from: b */
        final int f2609b;

        /* renamed from: c */
        final int f2610c;

        C0766f(String str, int i, int i2) {
            this.f2608a = str;
            this.f2609b = i;
            this.f2610c = i2;
        }

        /* renamed from: a */
        public boolean mo4068a(ArrayList<C0730a> arrayList, ArrayList<Boolean> arrayList2) {
            if (C0753k.this.f2573q != null && this.f2609b < 0 && this.f2608a == null && C0753k.this.f2573q.getChildFragmentManager().mo4365b()) {
                return false;
            }
            return C0753k.this.mo4410a(arrayList, arrayList2, this.f2608a, this.f2609b, this.f2610c);
        }
    }

    /* renamed from: androidx.fragment.app.k$g */
    static class C0767g implements C0735d.C0741c {

        /* renamed from: a */
        final boolean f2612a;

        /* renamed from: b */
        final C0730a f2613b;

        /* renamed from: c */
        private int f2614c;

        C0767g(C0730a aVar, boolean z) {
            this.f2612a = z;
            this.f2613b = aVar;
        }

        /* renamed from: a */
        public void mo4274a() {
            this.f2614c--;
            if (this.f2614c == 0) {
                this.f2613b.f2497a.mo4441j();
            }
        }

        /* renamed from: b */
        public void mo4275b() {
            this.f2614c++;
        }

        /* renamed from: c */
        public boolean mo4482c() {
            return this.f2614c == 0;
        }

        /* renamed from: d */
        public void mo4483d() {
            boolean z = this.f2614c > 0;
            C0753k kVar = this.f2613b.f2497a;
            int size = kVar.f2562f.size();
            for (int i = 0; i < size; i++) {
                C0735d dVar = kVar.f2562f.get(i);
                dVar.setOnStartEnterTransitionListener((C0735d.C0741c) null);
                if (z && dVar.isPostponed()) {
                    dVar.startPostponedEnterTransition();
                }
            }
            this.f2613b.f2497a.mo4395a(this.f2613b, this.f2612a, !z, true);
        }

        /* renamed from: e */
        public void mo4484e() {
            this.f2613b.f2497a.mo4395a(this.f2613b, this.f2612a, false, false);
        }
    }

    C0753k() {
    }

    /* renamed from: C */
    private void m3057C() {
        ArrayList<C0765e> arrayList = this.f2559c;
        boolean z = true;
        if (arrayList == null || arrayList.isEmpty()) {
            C0057c cVar = this.f2556G;
            if (mo4436h() <= 0 || !mo4409a(this.f2572p)) {
                z = false;
            }
            cVar.mo676a(z);
            return;
        }
        this.f2556G.mo676a(true);
    }

    /* renamed from: D */
    private void m3058D() {
        if (mo4369f()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* renamed from: E */
    private void m3059E() {
        this.f2560d = false;
        this.f2580x.clear();
        this.f2579w.clear();
    }

    /* renamed from: F */
    private void m3060F() {
        if (this.f2553B != null) {
            while (!this.f2553B.isEmpty()) {
                this.f2553B.remove(0).mo4483d();
            }
        }
    }

    /* renamed from: G */
    private void m3061G() {
        for (C0735d next : this.f2563g.values()) {
            if (next != null) {
                if (next.getAnimatingAway() != null) {
                    int stateAfterAnimating = next.getStateAfterAnimating();
                    View animatingAway = next.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    next.setAnimatingAway((View) null);
                    mo4396a(next, stateAfterAnimating, 0, 0, false);
                } else if (next.getAnimator() != null) {
                    next.getAnimator().end();
                }
            }
        }
    }

    /* renamed from: H */
    private void m3062H() {
        this.f2563g.values().removeAll(Collections.singleton((Object) null));
    }

    /* renamed from: a */
    private int m3063a(ArrayList<C0730a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, C0402b<C0735d> bVar) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            C0730a aVar = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (aVar.mo4078g() && !aVar.mo4067a(arrayList, i4 + 1, i2)) {
                if (this.f2553B == null) {
                    this.f2553B = new ArrayList<>();
                }
                C0767g gVar = new C0767g(aVar, booleanValue);
                this.f2553B.add(gVar);
                aVar.mo4064a((C0735d.C0741c) gVar);
                if (booleanValue) {
                    aVar.mo4077f();
                } else {
                    aVar.mo4072b(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, aVar);
                }
                m3073b(bVar);
            }
        }
        return i3;
    }

    /* renamed from: a */
    static C0761a m3064a(float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f2550E);
        alphaAnimation.setDuration(220);
        return new C0761a((Animation) alphaAnimation);
    }

    /* renamed from: a */
    static C0761a m3065a(float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f2549D);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(f2550E);
        alphaAnimation.setDuration(220);
        animationSet.addAnimation(alphaAnimation);
        return new C0761a((Animation) animationSet);
    }

    /* renamed from: a */
    private void m3066a(C0402b<C0735d> bVar) {
        int size = bVar.size();
        for (int i = 0; i < size; i++) {
            C0735d b = bVar.mo2829b(i);
            if (!b.mAdded) {
                View requireView = b.requireView();
                b.mPostponedAlpha = requireView.getAlpha();
                requireView.setAlpha(0.0f);
            }
        }
    }

    /* renamed from: a */
    private void m3067a(final C0735d dVar, C0761a aVar, int i) {
        final View view = dVar.mView;
        final ViewGroup viewGroup = dVar.mContainer;
        viewGroup.startViewTransition(view);
        dVar.setStateAfterAnimating(i);
        if (aVar.f2598a != null) {
            C0762b bVar = new C0762b(aVar.f2598a, viewGroup, view);
            dVar.setAnimatingAway(dVar.mView);
            bVar.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    viewGroup.post(new Runnable() {
                        public void run() {
                            if (dVar.getAnimatingAway() != null) {
                                dVar.setAnimatingAway((View) null);
                                C0753k.this.mo4396a(dVar, dVar.getStateAfterAnimating(), 0, 0, false);
                            }
                        }
                    });
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            dVar.mView.startAnimation(bVar);
            return;
        }
        Animator animator = aVar.f2599b;
        dVar.setAnimator(aVar.f2599b);
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                viewGroup.endViewTransition(view);
                Animator animator2 = dVar.getAnimator();
                dVar.setAnimator((Animator) null);
                if (animator2 != null && viewGroup.indexOfChild(view) < 0) {
                    C0753k kVar = C0753k.this;
                    C0735d dVar = dVar;
                    kVar.mo4396a(dVar, dVar.getStateAfterAnimating(), 0, 0, false);
                }
            }
        });
        animator.setTarget(dVar.mView);
        animator.start();
    }

    /* renamed from: a */
    private void m3068a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0581b("FragmentManager"));
        C0749i iVar = this.f2570n;
        if (iVar != null) {
            try {
                iVar.mo4319a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            mo4364a("  ", (FileDescriptor) null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    /* renamed from: a */
    private void m3069a(ArrayList<C0730a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<C0767g> arrayList3 = this.f2553B;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            C0767g gVar = this.f2553B.get(i);
            if (arrayList == null || gVar.f2612a || (indexOf2 = arrayList.indexOf(gVar.f2613b)) == -1 || !arrayList2.get(indexOf2).booleanValue()) {
                if (gVar.mo4482c() || (arrayList != null && gVar.f2613b.mo4067a(arrayList, 0, arrayList.size()))) {
                    this.f2553B.remove(i);
                    i--;
                    size--;
                    if (arrayList == null || gVar.f2612a || (indexOf = arrayList.indexOf(gVar.f2613b)) == -1 || !arrayList2.get(indexOf).booleanValue()) {
                        gVar.mo4483d();
                    }
                }
                i++;
            } else {
                this.f2553B.remove(i);
                i--;
                size--;
            }
            gVar.mo4484e();
            i++;
        }
    }

    /* renamed from: a */
    private void m3070a(ArrayList<C0730a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        ArrayList<C0730a> arrayList3 = arrayList;
        ArrayList<Boolean> arrayList4 = arrayList2;
        int i4 = i;
        int i5 = i2;
        boolean z = arrayList3.get(i4).f2657t;
        ArrayList<C0735d> arrayList5 = this.f2581y;
        if (arrayList5 == null) {
            this.f2581y = new ArrayList<>();
        } else {
            arrayList5.clear();
        }
        this.f2581y.addAll(this.f2562f);
        C0735d z2 = mo4471z();
        boolean z3 = false;
        for (int i6 = i4; i6 < i5; i6++) {
            C0730a aVar = arrayList3.get(i6);
            z2 = !arrayList4.get(i6).booleanValue() ? aVar.mo4058a(this.f2581y, z2) : aVar.mo4070b(this.f2581y, z2);
            z3 = z3 || aVar.f2648k;
        }
        this.f2581y.clear();
        if (!z) {
            C0777q.m3236a(this, arrayList, arrayList2, i, i2, false);
        }
        m3075b(arrayList, arrayList2, i, i2);
        if (z) {
            C0402b bVar = new C0402b();
            m3073b((C0402b<C0735d>) bVar);
            int a = m3063a(arrayList, arrayList2, i, i2, (C0402b<C0735d>) bVar);
            m3066a((C0402b<C0735d>) bVar);
            i3 = a;
        } else {
            i3 = i5;
        }
        if (i3 != i4 && z) {
            C0777q.m3236a(this, arrayList, arrayList2, i, i3, true);
            mo4391a(this.f2569m, true);
        }
        while (i4 < i5) {
            C0730a aVar2 = arrayList3.get(i4);
            if (arrayList4.get(i4).booleanValue() && aVar2.f2499c >= 0) {
                mo4423c(aVar2.f2499c);
                aVar2.f2499c = -1;
            }
            aVar2.mo4061a();
            i4++;
        }
        if (z3) {
            mo4447m();
        }
    }

    /* renamed from: a */
    private boolean m3071a(String str, int i, int i2) {
        mo4444k();
        m3076c(true);
        C0735d dVar = this.f2573q;
        if (dVar != null && i < 0 && str == null && dVar.getChildFragmentManager().mo4365b()) {
            return true;
        }
        boolean a = mo4410a(this.f2579w, this.f2580x, str, i, i2);
        if (a) {
            this.f2560d = true;
            try {
                m3074b(this.f2579w, this.f2580x);
            } finally {
                m3059E();
            }
        }
        m3057C();
        mo4445l();
        m3062H();
        return a;
    }

    /* renamed from: b */
    public static int m3072b(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    /* renamed from: b */
    private void m3073b(C0402b<C0735d> bVar) {
        int i = this.f2569m;
        if (i >= 1) {
            int min = Math.min(i, 3);
            int size = this.f2562f.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0735d dVar = this.f2562f.get(i2);
                if (dVar.mState < min) {
                    mo4396a(dVar, min, dVar.getNextAnim(), dVar.getNextTransition(), false);
                    if (dVar.mView != null && !dVar.mHidden && dVar.mIsNewlyAdded) {
                        bVar.add(dVar);
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private void m3074b(ArrayList<C0730a> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
                throw new IllegalStateException("Internal error with the back stack records");
            }
            m3069a(arrayList, arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!arrayList.get(i).f2657t) {
                    if (i2 != i) {
                        m3070a(arrayList, arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (arrayList2.get(i).booleanValue()) {
                        while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).f2657t) {
                            i2++;
                        }
                    }
                    m3070a(arrayList, arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                m3070a(arrayList, arrayList2, i2, size);
            }
        }
    }

    /* renamed from: b */
    private static void m3075b(ArrayList<C0730a> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            C0730a aVar = arrayList.get(i);
            boolean z = true;
            if (arrayList2.get(i).booleanValue()) {
                aVar.mo4062a(-1);
                if (i != i2 - 1) {
                    z = false;
                }
                aVar.mo4072b(z);
            } else {
                aVar.mo4062a(1);
                aVar.mo4077f();
            }
            i++;
        }
    }

    /* renamed from: c */
    private void m3076c(boolean z) {
        if (this.f2560d) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.f2570n == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        } else if (Looper.myLooper() == this.f2570n.mo4357j().getLooper()) {
            if (!z) {
                m3058D();
            }
            if (this.f2579w == null) {
                this.f2579w = new ArrayList<>();
                this.f2580x = new ArrayList<>();
            }
            this.f2560d = true;
            try {
                m3069a((ArrayList<C0730a>) null, (ArrayList<Boolean>) null);
            } finally {
                this.f2560d = false;
            }
        } else {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        return false;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3077c(java.util.ArrayList<androidx.fragment.app.C0730a> r5, java.util.ArrayList<java.lang.Boolean> r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.ArrayList<androidx.fragment.app.k$e> r0 = r4.f2559c     // Catch:{ all -> 0x003c }
            r1 = 0
            if (r0 == 0) goto L_0x003a
            java.util.ArrayList<androidx.fragment.app.k$e> r0 = r4.f2559c     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            if (r0 != 0) goto L_0x000f
            goto L_0x003a
        L_0x000f:
            java.util.ArrayList<androidx.fragment.app.k$e> r0 = r4.f2559c     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            r2 = 0
        L_0x0016:
            if (r1 >= r0) goto L_0x0028
            java.util.ArrayList<androidx.fragment.app.k$e> r3 = r4.f2559c     // Catch:{ all -> 0x003c }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x003c }
            androidx.fragment.app.k$e r3 = (androidx.fragment.app.C0753k.C0765e) r3     // Catch:{ all -> 0x003c }
            boolean r3 = r3.mo4068a(r5, r6)     // Catch:{ all -> 0x003c }
            r2 = r2 | r3
            int r1 = r1 + 1
            goto L_0x0016
        L_0x0028:
            java.util.ArrayList<androidx.fragment.app.k$e> r5 = r4.f2559c     // Catch:{ all -> 0x003c }
            r5.clear()     // Catch:{ all -> 0x003c }
            androidx.fragment.app.i r5 = r4.f2570n     // Catch:{ all -> 0x003c }
            android.os.Handler r5 = r5.mo4357j()     // Catch:{ all -> 0x003c }
            java.lang.Runnable r6 = r4.f2554C     // Catch:{ all -> 0x003c }
            r5.removeCallbacks(r6)     // Catch:{ all -> 0x003c }
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r2
        L_0x003a:
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            return r1
        L_0x003c:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x003c }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0753k.m3077c(java.util.ArrayList, java.util.ArrayList):boolean");
    }

    /* renamed from: d */
    public static int m3078d(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: e */
    private void m3079e(int i) {
        try {
            this.f2560d = true;
            mo4391a(i, false);
            this.f2560d = false;
            mo4444k();
        } catch (Throwable th) {
            this.f2560d = false;
            throw th;
        }
    }

    /* renamed from: u */
    private C0735d m3080u(C0735d dVar) {
        ViewGroup viewGroup = dVar.mContainer;
        View view = dVar.mView;
        if (!(viewGroup == null || view == null)) {
            for (int indexOf = this.f2562f.indexOf(dVar) - 1; indexOf >= 0; indexOf--) {
                C0735d dVar2 = this.f2562f.get(indexOf);
                if (dVar2.mContainer == viewGroup && dVar2.mView != null) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    /* renamed from: v */
    private void m3081v(C0735d dVar) {
        if (dVar != null && this.f2563g.get(dVar.mWho) == dVar) {
            dVar.performPrimaryNavigationFragmentChanged();
        }
    }

    /* renamed from: w */
    private boolean m3082w(C0735d dVar) {
        return (dVar.mHasMenu && dVar.mMenuVisible) || dVar.mChildFragmentManager.mo4385A();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: A */
    public boolean mo4385A() {
        boolean z = false;
        for (C0735d next : this.f2563g.values()) {
            if (next != null) {
                z = m3082w(next);
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public LayoutInflater.Factory2 mo4386B() {
        return this;
    }

    /* renamed from: a */
    public int mo4387a(C0730a aVar) {
        synchronized (this) {
            if (this.f2567k != null) {
                if (this.f2567k.size() > 0) {
                    int intValue = this.f2567k.remove(this.f2567k.size() - 1).intValue();
                    if (f2551b) {
                        Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + aVar);
                    }
                    this.f2566j.set(intValue, aVar);
                    return intValue;
                }
            }
            if (this.f2566j == null) {
                this.f2566j = new ArrayList<>();
            }
            int size = this.f2566j.size();
            if (f2551b) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + aVar);
            }
            this.f2566j.add(aVar);
            return size;
        }
    }

    /* renamed from: a */
    public C0735d mo4388a(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        C0735d dVar = this.f2563g.get(string);
        if (dVar == null) {
            m3068a((RuntimeException) new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return dVar;
    }

    /* renamed from: a */
    public C0735d mo4358a(String str) {
        if (str != null) {
            for (int size = this.f2562f.size() - 1; size >= 0; size--) {
                C0735d dVar = this.f2562f.get(size);
                if (dVar != null && str.equals(dVar.mTag)) {
                    return dVar;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (C0735d next : this.f2563g.values()) {
            if (next != null && str.equals(next.mTag)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0761a mo4389a(C0735d dVar, int i, boolean z, int i2) {
        int b;
        int nextAnim = dVar.getNextAnim();
        boolean z2 = false;
        dVar.setNextAnim(0);
        if (dVar.mContainer != null && dVar.mContainer.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = dVar.onCreateAnimation(i, z, nextAnim);
        if (onCreateAnimation != null) {
            return new C0761a(onCreateAnimation);
        }
        Animator onCreateAnimator = dVar.onCreateAnimator(i, z, nextAnim);
        if (onCreateAnimator != null) {
            return new C0761a(onCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean equals = "anim".equals(this.f2570n.mo4356i().getResources().getResourceTypeName(nextAnim));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.f2570n.mo4356i(), nextAnim);
                    if (loadAnimation != null) {
                        return new C0761a(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.f2570n.mo4356i(), nextAnim);
                    if (loadAnimator != null) {
                        return new C0761a(loadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f2570n.mo4356i(), nextAnim);
                        if (loadAnimation2 != null) {
                            return new C0761a(loadAnimation2);
                        }
                    } else {
                        throw e2;
                    }
                }
            }
        }
        if (i == 0 || (b = m3072b(i, z)) < 0) {
            return null;
        }
        switch (b) {
            case 1:
                return m3065a(1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return m3065a(1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return m3065a(0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return m3065a(1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return m3064a(0.0f, 1.0f);
            case 6:
                return m3064a(1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f2570n.mo4326e()) {
                    i2 = this.f2570n.mo4327f();
                }
                if (i2 == 0) {
                }
                return null;
        }
    }

    /* renamed from: a */
    public C0775p mo4359a() {
        return new C0730a(this);
    }

    /* renamed from: a */
    public void mo4360a(int i, int i2) {
        if (i >= 0) {
            mo4403a((C0765e) new C0766f((String) null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    /* renamed from: a */
    public void mo4390a(int i, C0730a aVar) {
        synchronized (this) {
            if (this.f2566j == null) {
                this.f2566j = new ArrayList<>();
            }
            int size = this.f2566j.size();
            if (i < size) {
                if (f2551b) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + aVar);
                }
                this.f2566j.set(i, aVar);
            } else {
                while (size < i) {
                    this.f2566j.add((Object) null);
                    if (this.f2567k == null) {
                        this.f2567k = new ArrayList<>();
                    }
                    if (f2551b) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f2567k.add(Integer.valueOf(size));
                    size++;
                }
                if (f2551b) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + aVar);
                }
                this.f2566j.add(aVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4391a(int i, boolean z) {
        C0749i iVar;
        if (this.f2570n == null && i != 0) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.f2569m) {
            this.f2569m = i;
            int size = this.f2562f.size();
            for (int i2 = 0; i2 < size; i2++) {
                mo4442j(this.f2562f.get(i2));
            }
            for (C0735d next : this.f2563g.values()) {
                if (next != null && ((next.mRemoving || next.mDetached) && !next.mIsNewlyAdded)) {
                    mo4442j(next);
                }
            }
            mo4439i();
            if (this.f2574r && (iVar = this.f2570n) != null && this.f2569m == 4) {
                iVar.mo4325d();
                this.f2574r = false;
            }
        }
    }

    /* renamed from: a */
    public void mo4392a(Configuration configuration) {
        for (int i = 0; i < this.f2562f.size(); i++) {
            C0735d dVar = this.f2562f.get(i);
            if (dVar != null) {
                dVar.performConfigurationChanged(configuration);
            }
        }
    }

    /* renamed from: a */
    public void mo4393a(Bundle bundle, String str, C0735d dVar) {
        if (dVar.mFragmentManager != this) {
            m3068a((RuntimeException) new IllegalStateException("Fragment " + dVar + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, dVar.mWho);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4394a(Parcelable parcelable) {
        C0773o oVar;
        if (parcelable != null) {
            C0768l lVar = (C0768l) parcelable;
            if (lVar.f2615a != null) {
                for (C0735d next : this.f2558I.mo4495c()) {
                    if (f2551b) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + next);
                    }
                    Iterator<C0773o> it = lVar.f2615a.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            oVar = null;
                            break;
                        }
                        oVar = it.next();
                        if (oVar.f2628b.equals(next.mWho)) {
                            break;
                        }
                    }
                    if (oVar == null) {
                        if (f2551b) {
                            Log.v("FragmentManager", "Discarding retained Fragment " + next + " that was not found in the set of active Fragments " + lVar.f2615a);
                        }
                        C0735d dVar = next;
                        mo4396a(dVar, 1, 0, 0, false);
                        next.mRemoving = true;
                        mo4396a(dVar, 0, 0, 0, false);
                    } else {
                        oVar.f2640n = next;
                        next.mSavedViewState = null;
                        next.mBackStackNesting = 0;
                        next.mInLayout = false;
                        next.mAdded = false;
                        next.mTargetWho = next.mTarget != null ? next.mTarget.mWho : null;
                        next.mTarget = null;
                        if (oVar.f2639m != null) {
                            oVar.f2639m.setClassLoader(this.f2570n.mo4356i().getClassLoader());
                            next.mSavedViewState = oVar.f2639m.getSparseParcelableArray("android:view_state");
                            next.mSavedFragmentState = oVar.f2639m;
                        }
                    }
                }
                this.f2563g.clear();
                Iterator<C0773o> it2 = lVar.f2615a.iterator();
                while (it2.hasNext()) {
                    C0773o next2 = it2.next();
                    if (next2 != null) {
                        C0735d a = next2.mo4514a(this.f2570n.mo4356i().getClassLoader(), mo4368e());
                        a.mFragmentManager = this;
                        if (f2551b) {
                            Log.v("FragmentManager", "restoreSaveState: active (" + a.mWho + "): " + a);
                        }
                        this.f2563g.put(a.mWho, a);
                        next2.f2640n = null;
                    }
                }
                this.f2562f.clear();
                if (lVar.f2616b != null) {
                    Iterator<String> it3 = lVar.f2616b.iterator();
                    while (it3.hasNext()) {
                        String next3 = it3.next();
                        C0735d dVar2 = this.f2563g.get(next3);
                        if (dVar2 == null) {
                            m3068a((RuntimeException) new IllegalStateException("No instantiated fragment for (" + next3 + ")"));
                        }
                        dVar2.mAdded = true;
                        if (f2551b) {
                            Log.v("FragmentManager", "restoreSaveState: added (" + next3 + "): " + dVar2);
                        }
                        if (!this.f2562f.contains(dVar2)) {
                            synchronized (this.f2562f) {
                                this.f2562f.add(dVar2);
                            }
                        } else {
                            throw new IllegalStateException("Already added " + dVar2);
                        }
                    }
                }
                if (lVar.f2617c != null) {
                    this.f2564h = new ArrayList<>(lVar.f2617c.length);
                    for (int i = 0; i < lVar.f2617c.length; i++) {
                        C0730a a2 = lVar.f2617c[i].mo4082a(this);
                        if (f2551b) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + a2.f2499c + "): " + a2);
                            PrintWriter printWriter = new PrintWriter(new C0581b("FragmentManager"));
                            a2.mo4066a("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.f2564h.add(a2);
                        if (a2.f2499c >= 0) {
                            mo4390a(a2.f2499c, a2);
                        }
                    }
                } else {
                    this.f2564h = null;
                }
                if (lVar.f2618d != null) {
                    this.f2573q = this.f2563g.get(lVar.f2618d);
                    m3081v(this.f2573q);
                }
                this.f2561e = lVar.f2619e;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4395a(C0730a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.mo4072b(z3);
        } else {
            aVar.mo4077f();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            C0777q.m3236a(this, (ArrayList<C0730a>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            mo4391a(this.f2569m, true);
        }
        for (C0735d next : this.f2563g.values()) {
            if (next != null && next.mView != null && next.mIsNewlyAdded && aVar.mo4073b(next.mContainerId)) {
                if (next.mPostponedAlpha > 0.0f) {
                    next.mView.setAlpha(next.mPostponedAlpha);
                }
                if (z3) {
                    next.mPostponedAlpha = 0.0f;
                } else {
                    next.mPostponedAlpha = -1.0f;
                    next.mIsNewlyAdded = false;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* JADX WARNING: type inference failed for: r11v1 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01ea, code lost:
        android.util.Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0202, code lost:
        if (r7.mFromLayout != false) goto L_0x02c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0206, code lost:
        if (r7.mContainerId == 0) goto L_0x0278;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x020b, code lost:
        if (r7.mContainerId != -1) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x020d, code lost:
        m3068a((java.lang.RuntimeException) new java.lang.IllegalArgumentException("Cannot create fragment " + r15 + " for a container view with no id"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x022b, code lost:
        r0 = (android.view.ViewGroup) r6.f2571o.mo4272a(r7.mContainerId);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0235, code lost:
        if (r0 != null) goto L_0x0279;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0239, code lost:
        if (r7.mRestored != false) goto L_0x0279;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:?, code lost:
        r1 = r15.getResources().getResourceName(r7.mContainerId);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0246, code lost:
        r1 = "unknown";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0278, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0353, code lost:
        if (r11 >= 3) goto L_0x0375;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0357, code lost:
        if (f2551b == false) goto L_0x036f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0359, code lost:
        android.util.Log.v("FragmentManager", "movefrom STARTED: " + r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x036f, code lost:
        r15.performStop();
        mo4430e(r15, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0375, code lost:
        if (r11 >= 2) goto L_0x040a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0379, code lost:
        if (f2551b == false) goto L_0x0391;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x037b, code lost:
        android.util.Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0393, code lost:
        if (r7.mView == null) goto L_0x03a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x039b, code lost:
        if (r6.f2570n.mo4320a(r15) == false) goto L_0x03a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x039f, code lost:
        if (r7.mSavedViewState != null) goto L_0x03a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03a1, code lost:
        mo4460r(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x03a4, code lost:
        r15.performDestroyView();
        mo4432f(r15, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03ac, code lost:
        if (r7.mView == null) goto L_0x03fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x03b0, code lost:
        if (r7.mContainer == null) goto L_0x03fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03b2, code lost:
        r7.mContainer.endViewTransition(r7.mView);
        r7.mView.clearAnimation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x03c2, code lost:
        if (r15.getParentFragment() == null) goto L_0x03cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x03ca, code lost:
        if (r15.getParentFragment().mRemoving != false) goto L_0x03fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x03cf, code lost:
        if (r6.f2569m <= 0) goto L_0x03ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x03d3, code lost:
        if (r6.f2577u != false) goto L_0x03ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x03db, code lost:
        if (r7.mView.getVisibility() != 0) goto L_0x03ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x03e1, code lost:
        if (r7.mPostponedAlpha < 0.0f) goto L_0x03ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03e3, code lost:
        r0 = mo4389a(r15, r17, false, r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x03ec, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x03ed, code lost:
        r7.mPostponedAlpha = 0.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x03ef, code lost:
        if (r0 == null) goto L_0x03f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x03f1, code lost:
        m3067a(r15, r0, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x03f4, code lost:
        r7.mContainer.removeView(r7.mView);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x03fb, code lost:
        r7.mContainer = null;
        r7.mView = null;
        r7.mViewLifecycleOwner = null;
        r7.mViewLifecycleOwnerLiveData.mo4583b(null);
        r7.mInnerView = null;
        r7.mInLayout = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x040a, code lost:
        if (r11 >= 1) goto L_0x04df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x040e, code lost:
        if (r6.f2577u == false) goto L_0x0431;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0414, code lost:
        if (r15.getAnimatingAway() == null) goto L_0x0421;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0416, code lost:
        r0 = r15.getAnimatingAway();
        r15.setAnimatingAway((android.view.View) null);
        r0.clearAnimation();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0425, code lost:
        if (r15.getAnimator() == null) goto L_0x0431;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x0427, code lost:
        r0 = r15.getAnimator();
        r15.setAnimator((android.animation.Animator) null);
        r0.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0435, code lost:
        if (r15.getAnimatingAway() != null) goto L_0x04db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x043b, code lost:
        if (r15.getAnimator() == null) goto L_0x043f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0441, code lost:
        if (f2551b == false) goto L_0x0459;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0443, code lost:
        android.util.Log.v("FragmentManager", "movefrom CREATED: " + r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x045b, code lost:
        if (r7.mRemoving == false) goto L_0x0465;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0461, code lost:
        if (r15.isInBackStack() != false) goto L_0x0465;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0463, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0465, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x0466, code lost:
        if (r0 != false) goto L_0x0474;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x046e, code lost:
        if (r6.f2558I.mo4494b(r15) == false) goto L_0x0471;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0471, code lost:
        r7.mState = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0474, code lost:
        r1 = r6.f2570n;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0478, code lost:
        if ((r1 instanceof androidx.lifecycle.C0972v) == false) goto L_0x0481;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x047a, code lost:
        r8 = r6.f2558I.mo4493b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0487, code lost:
        if ((r1.mo4356i() instanceof android.app.Activity) == false) goto L_0x0496;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0489, code lost:
        r8 = true ^ ((android.app.Activity) r6.f2570n.mo4356i()).isChangingConfigurations();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0496, code lost:
        if (r0 != false) goto L_0x049a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0498, code lost:
        if (r8 == false) goto L_0x049f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x049a, code lost:
        r6.f2558I.mo4500f(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x049f, code lost:
        r15.performDestroy();
        mo4435g(r15, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x04a5, code lost:
        r15.performDetach();
        mo4438h(r15, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x04ab, code lost:
        if (r19 != false) goto L_0x04df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x04ad, code lost:
        if (r0 != false) goto L_0x04d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x04b5, code lost:
        if (r6.f2558I.mo4494b(r15) == false) goto L_0x04b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x04b8, code lost:
        r7.mHost = null;
        r7.mParentFragment = null;
        r7.mFragmentManager = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x04c0, code lost:
        if (r7.mTargetWho == null) goto L_0x04df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x04c2, code lost:
        r0 = r6.f2563g.get(r7.mTargetWho);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x04cc, code lost:
        if (r0 == null) goto L_0x04df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x04d2, code lost:
        if (r0.getRetainInstance() == false) goto L_0x04df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x04d4, code lost:
        r7.mTarget = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x04d7, code lost:
        mo4446l(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x04db, code lost:
        r15.setStateAfterAnimating(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01df, code lost:
        if (r11 <= 0) goto L_0x01e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01e1, code lost:
        mo4437h(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01e4, code lost:
        if (r11 <= 1) goto L_0x02db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01e8, code lost:
        if (f2551b == false) goto L_0x0200;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x04e4  */
    /* JADX WARNING: Removed duplicated region for block: B:251:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4396a(androidx.fragment.app.C0735d r15, int r16, int r17, int r18, boolean r19) {
        /*
            r14 = this;
            r6 = r14
            r7 = r15
            boolean r0 = r7.mAdded
            r8 = 1
            if (r0 == 0) goto L_0x000f
            boolean r0 = r7.mDetached
            if (r0 == 0) goto L_0x000c
            goto L_0x000f
        L_0x000c:
            r0 = r16
            goto L_0x0014
        L_0x000f:
            r0 = r16
            if (r0 <= r8) goto L_0x0014
            r0 = 1
        L_0x0014:
            boolean r1 = r7.mRemoving
            if (r1 == 0) goto L_0x002a
            int r1 = r7.mState
            if (r0 <= r1) goto L_0x002a
            int r0 = r7.mState
            if (r0 != 0) goto L_0x0028
            boolean r0 = r15.isInBackStack()
            if (r0 == 0) goto L_0x0028
            r0 = 1
            goto L_0x002a
        L_0x0028:
            int r0 = r7.mState
        L_0x002a:
            boolean r1 = r7.mDeferStart
            r9 = 3
            r10 = 2
            if (r1 == 0) goto L_0x0037
            int r1 = r7.mState
            if (r1 >= r9) goto L_0x0037
            if (r0 <= r10) goto L_0x0037
            r0 = 2
        L_0x0037:
            androidx.lifecycle.e$b r1 = r7.mMaxState
            androidx.lifecycle.e$b r2 = androidx.lifecycle.C0947e.C0949b.CREATED
            if (r1 != r2) goto L_0x0042
            int r0 = java.lang.Math.min(r0, r8)
            goto L_0x004c
        L_0x0042:
            androidx.lifecycle.e$b r1 = r7.mMaxState
            int r1 = r1.ordinal()
            int r0 = java.lang.Math.min(r0, r1)
        L_0x004c:
            r11 = r0
            int r0 = r7.mState
            r12 = 0
            r13 = 0
            if (r0 > r11) goto L_0x0325
            boolean r0 = r7.mFromLayout
            if (r0 == 0) goto L_0x005c
            boolean r0 = r7.mInLayout
            if (r0 != 0) goto L_0x005c
            return
        L_0x005c:
            android.view.View r0 = r15.getAnimatingAway()
            if (r0 != 0) goto L_0x0068
            android.animation.Animator r0 = r15.getAnimator()
            if (r0 == 0) goto L_0x007a
        L_0x0068:
            r15.setAnimatingAway(r13)
            r15.setAnimator(r13)
            int r2 = r15.getStateAfterAnimating()
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r14
            r1 = r15
            r0.mo4396a((androidx.fragment.app.C0735d) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
        L_0x007a:
            int r0 = r7.mState
            switch(r0) {
                case 0: goto L_0x0081;
                case 1: goto L_0x01df;
                case 2: goto L_0x02db;
                case 3: goto L_0x02fd;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x04df
        L_0x0081:
            if (r11 <= 0) goto L_0x01df
            boolean r0 = f2551b
            if (r0 == 0) goto L_0x009d
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto CREATED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x009d:
            android.os.Bundle r0 = r7.mSavedFragmentState
            if (r0 == 0) goto L_0x00fa
            android.os.Bundle r0 = r7.mSavedFragmentState
            androidx.fragment.app.i r1 = r6.f2570n
            android.content.Context r1 = r1.mo4356i()
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r0.setClassLoader(r1)
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:view_state"
            android.util.SparseArray r0 = r0.getSparseParcelableArray(r1)
            r7.mSavedViewState = r0
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:target_state"
            androidx.fragment.app.d r0 = r14.mo4388a((android.os.Bundle) r0, (java.lang.String) r1)
            if (r0 == 0) goto L_0x00c7
            java.lang.String r0 = r0.mWho
            goto L_0x00c8
        L_0x00c7:
            r0 = r13
        L_0x00c8:
            r7.mTargetWho = r0
            java.lang.String r0 = r7.mTargetWho
            if (r0 == 0) goto L_0x00d8
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:target_req_state"
            int r0 = r0.getInt(r1, r12)
            r7.mTargetRequestCode = r0
        L_0x00d8:
            java.lang.Boolean r0 = r7.mSavedUserVisibleHint
            if (r0 == 0) goto L_0x00e7
            java.lang.Boolean r0 = r7.mSavedUserVisibleHint
            boolean r0 = r0.booleanValue()
            r7.mUserVisibleHint = r0
            r7.mSavedUserVisibleHint = r13
            goto L_0x00f1
        L_0x00e7:
            android.os.Bundle r0 = r7.mSavedFragmentState
            java.lang.String r1 = "android:user_visible_hint"
            boolean r0 = r0.getBoolean(r1, r8)
            r7.mUserVisibleHint = r0
        L_0x00f1:
            boolean r0 = r7.mUserVisibleHint
            if (r0 != 0) goto L_0x00fa
            r7.mDeferStart = r8
            if (r11 <= r10) goto L_0x00fa
            r11 = 2
        L_0x00fa:
            androidx.fragment.app.i r0 = r6.f2570n
            r7.mHost = r0
            androidx.fragment.app.d r1 = r6.f2572p
            r7.mParentFragment = r1
            if (r1 == 0) goto L_0x0107
            androidx.fragment.app.k r0 = r1.mChildFragmentManager
            goto L_0x0109
        L_0x0107:
            androidx.fragment.app.k r0 = r0.f2543b
        L_0x0109:
            r7.mFragmentManager = r0
            androidx.fragment.app.d r0 = r7.mTarget
            if (r0 == 0) goto L_0x015c
            java.util.HashMap<java.lang.String, androidx.fragment.app.d> r0 = r6.f2563g
            androidx.fragment.app.d r1 = r7.mTarget
            java.lang.String r1 = r1.mWho
            java.lang.Object r0 = r0.get(r1)
            androidx.fragment.app.d r1 = r7.mTarget
            if (r0 != r1) goto L_0x0136
            androidx.fragment.app.d r0 = r7.mTarget
            int r0 = r0.mState
            if (r0 >= r8) goto L_0x012d
            androidx.fragment.app.d r1 = r7.mTarget
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r14
            r0.mo4396a((androidx.fragment.app.C0735d) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
        L_0x012d:
            androidx.fragment.app.d r0 = r7.mTarget
            java.lang.String r0 = r0.mWho
            r7.mTargetWho = r0
            r7.mTarget = r13
            goto L_0x015c
        L_0x0136:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Fragment "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r2 = " declared target fragment "
            r1.append(r2)
            androidx.fragment.app.d r2 = r7.mTarget
            r1.append(r2)
            java.lang.String r2 = " that does not belong to this FragmentManager!"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x015c:
            java.lang.String r0 = r7.mTargetWho
            if (r0 == 0) goto L_0x01a0
            java.util.HashMap<java.lang.String, androidx.fragment.app.d> r0 = r6.f2563g
            java.lang.String r1 = r7.mTargetWho
            java.lang.Object r0 = r0.get(r1)
            r1 = r0
            androidx.fragment.app.d r1 = (androidx.fragment.app.C0735d) r1
            if (r1 == 0) goto L_0x017a
            int r0 = r1.mState
            if (r0 >= r8) goto L_0x01a0
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 1
            r0 = r14
            r0.mo4396a((androidx.fragment.app.C0735d) r1, (int) r2, (int) r3, (int) r4, (boolean) r5)
            goto L_0x01a0
        L_0x017a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Fragment "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r2 = " declared target fragment "
            r1.append(r2)
            java.lang.String r2 = r7.mTargetWho
            r1.append(r2)
            java.lang.String r2 = " that does not belong to this FragmentManager!"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01a0:
            androidx.fragment.app.i r0 = r6.f2570n
            android.content.Context r0 = r0.mo4356i()
            r14.mo4397a((androidx.fragment.app.C0735d) r15, (android.content.Context) r0, (boolean) r12)
            r15.performAttach()
            androidx.fragment.app.d r0 = r7.mParentFragment
            if (r0 != 0) goto L_0x01b6
            androidx.fragment.app.i r0 = r6.f2570n
            r0.mo4323b(r15)
            goto L_0x01bb
        L_0x01b6:
            androidx.fragment.app.d r0 = r7.mParentFragment
            r0.onAttachFragment(r15)
        L_0x01bb:
            androidx.fragment.app.i r0 = r6.f2570n
            android.content.Context r0 = r0.mo4356i()
            r14.mo4416b((androidx.fragment.app.C0735d) r15, (android.content.Context) r0, (boolean) r12)
            boolean r0 = r7.mIsCreated
            if (r0 != 0) goto L_0x01d8
            android.os.Bundle r0 = r7.mSavedFragmentState
            r14.mo4398a((androidx.fragment.app.C0735d) r15, (android.os.Bundle) r0, (boolean) r12)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r15.performCreate(r0)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r14.mo4417b((androidx.fragment.app.C0735d) r15, (android.os.Bundle) r0, (boolean) r12)
            goto L_0x01df
        L_0x01d8:
            android.os.Bundle r0 = r7.mSavedFragmentState
            r15.restoreChildFragmentState(r0)
            r7.mState = r8
        L_0x01df:
            if (r11 <= 0) goto L_0x01e4
            r14.mo4437h(r15)
        L_0x01e4:
            if (r11 <= r8) goto L_0x02db
            boolean r0 = f2551b
            if (r0 == 0) goto L_0x0200
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto ACTIVITY_CREATED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0200:
            boolean r0 = r7.mFromLayout
            if (r0 != 0) goto L_0x02c6
            int r0 = r7.mContainerId
            if (r0 == 0) goto L_0x0278
            int r0 = r7.mContainerId
            r1 = -1
            if (r0 != r1) goto L_0x022b
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannot create fragment "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r2 = " for a container view with no id"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r14.m3068a((java.lang.RuntimeException) r0)
        L_0x022b:
            androidx.fragment.app.f r0 = r6.f2571o
            int r1 = r7.mContainerId
            android.view.View r0 = r0.mo4272a(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 != 0) goto L_0x0279
            boolean r1 = r7.mRestored
            if (r1 != 0) goto L_0x0279
            android.content.res.Resources r1 = r15.getResources()     // Catch:{ NotFoundException -> 0x0246 }
            int r2 = r7.mContainerId     // Catch:{ NotFoundException -> 0x0246 }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x0246 }
            goto L_0x0248
        L_0x0246:
            java.lang.String r1 = "unknown"
        L_0x0248:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "No view found for id 0x"
            r3.append(r4)
            int r4 = r7.mContainerId
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            r3.append(r4)
            java.lang.String r4 = " ("
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = ") for fragment "
            r3.append(r1)
            r3.append(r15)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            r14.m3068a((java.lang.RuntimeException) r2)
            goto L_0x0279
        L_0x0278:
            r0 = r13
        L_0x0279:
            r7.mContainer = r0
            android.os.Bundle r1 = r7.mSavedFragmentState
            android.view.LayoutInflater r1 = r15.performGetLayoutInflater(r1)
            android.os.Bundle r2 = r7.mSavedFragmentState
            r15.performCreateView(r1, r0, r2)
            android.view.View r1 = r7.mView
            if (r1 == 0) goto L_0x02c4
            android.view.View r1 = r7.mView
            r7.mInnerView = r1
            android.view.View r1 = r7.mView
            r1.setSaveFromParentEnabled(r12)
            if (r0 == 0) goto L_0x029a
            android.view.View r1 = r7.mView
            r0.addView(r1)
        L_0x029a:
            boolean r0 = r7.mHidden
            if (r0 == 0) goto L_0x02a5
            android.view.View r0 = r7.mView
            r1 = 8
            r0.setVisibility(r1)
        L_0x02a5:
            android.view.View r0 = r7.mView
            android.os.Bundle r1 = r7.mSavedFragmentState
            r15.onViewCreated(r0, r1)
            android.view.View r0 = r7.mView
            android.os.Bundle r1 = r7.mSavedFragmentState
            r14.mo4399a((androidx.fragment.app.C0735d) r15, (android.view.View) r0, (android.os.Bundle) r1, (boolean) r12)
            android.view.View r0 = r7.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x02c0
            android.view.ViewGroup r0 = r7.mContainer
            if (r0 == 0) goto L_0x02c0
            goto L_0x02c1
        L_0x02c0:
            r8 = 0
        L_0x02c1:
            r7.mIsNewlyAdded = r8
            goto L_0x02c6
        L_0x02c4:
            r7.mInnerView = r13
        L_0x02c6:
            android.os.Bundle r0 = r7.mSavedFragmentState
            r15.performActivityCreated(r0)
            android.os.Bundle r0 = r7.mSavedFragmentState
            r14.mo4424c(r15, r0, r12)
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x02d9
            android.os.Bundle r0 = r7.mSavedFragmentState
            r15.restoreViewState(r0)
        L_0x02d9:
            r7.mSavedFragmentState = r13
        L_0x02db:
            if (r11 <= r10) goto L_0x02fd
            boolean r0 = f2551b
            if (r0 == 0) goto L_0x02f7
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto STARTED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x02f7:
            r15.performStart()
            r14.mo4418b((androidx.fragment.app.C0735d) r15, (boolean) r12)
        L_0x02fd:
            if (r11 <= r9) goto L_0x04df
            boolean r0 = f2551b
            if (r0 == 0) goto L_0x0319
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveto RESUMED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0319:
            r15.performResume()
            r14.mo4425c((androidx.fragment.app.C0735d) r15, (boolean) r12)
            r7.mSavedFragmentState = r13
            r7.mSavedViewState = r13
            goto L_0x04df
        L_0x0325:
            int r0 = r7.mState
            if (r0 <= r11) goto L_0x04df
            int r0 = r7.mState
            switch(r0) {
                case 1: goto L_0x040a;
                case 2: goto L_0x0375;
                case 3: goto L_0x0353;
                case 4: goto L_0x0330;
                default: goto L_0x032e;
            }
        L_0x032e:
            goto L_0x04df
        L_0x0330:
            r0 = 4
            if (r11 >= r0) goto L_0x0353
            boolean r0 = f2551b
            if (r0 == 0) goto L_0x034d
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom RESUMED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x034d:
            r15.performPause()
            r14.mo4428d(r15, r12)
        L_0x0353:
            if (r11 >= r9) goto L_0x0375
            boolean r0 = f2551b
            if (r0 == 0) goto L_0x036f
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom STARTED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x036f:
            r15.performStop()
            r14.mo4430e(r15, r12)
        L_0x0375:
            if (r11 >= r10) goto L_0x040a
            boolean r0 = f2551b
            if (r0 == 0) goto L_0x0391
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom ACTIVITY_CREATED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0391:
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x03a4
            androidx.fragment.app.i r0 = r6.f2570n
            boolean r0 = r0.mo4320a((androidx.fragment.app.C0735d) r15)
            if (r0 == 0) goto L_0x03a4
            android.util.SparseArray<android.os.Parcelable> r0 = r7.mSavedViewState
            if (r0 != 0) goto L_0x03a4
            r14.mo4460r(r15)
        L_0x03a4:
            r15.performDestroyView()
            r14.mo4432f(r15, r12)
            android.view.View r0 = r7.mView
            if (r0 == 0) goto L_0x03fb
            android.view.ViewGroup r0 = r7.mContainer
            if (r0 == 0) goto L_0x03fb
            android.view.ViewGroup r0 = r7.mContainer
            android.view.View r1 = r7.mView
            r0.endViewTransition(r1)
            android.view.View r0 = r7.mView
            r0.clearAnimation()
            androidx.fragment.app.d r0 = r15.getParentFragment()
            if (r0 == 0) goto L_0x03cc
            androidx.fragment.app.d r0 = r15.getParentFragment()
            boolean r0 = r0.mRemoving
            if (r0 != 0) goto L_0x03fb
        L_0x03cc:
            int r0 = r6.f2569m
            r1 = 0
            if (r0 <= 0) goto L_0x03ec
            boolean r0 = r6.f2577u
            if (r0 != 0) goto L_0x03ec
            android.view.View r0 = r7.mView
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x03ec
            float r0 = r7.mPostponedAlpha
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x03ec
            r0 = r17
            r2 = r18
            androidx.fragment.app.k$a r0 = r14.mo4389a((androidx.fragment.app.C0735d) r15, (int) r0, (boolean) r12, (int) r2)
            goto L_0x03ed
        L_0x03ec:
            r0 = r13
        L_0x03ed:
            r7.mPostponedAlpha = r1
            if (r0 == 0) goto L_0x03f4
            r14.m3067a((androidx.fragment.app.C0735d) r15, (androidx.fragment.app.C0753k.C0761a) r0, (int) r11)
        L_0x03f4:
            android.view.ViewGroup r0 = r7.mContainer
            android.view.View r1 = r7.mView
            r0.removeView(r1)
        L_0x03fb:
            r7.mContainer = r13
            r7.mView = r13
            r7.mViewLifecycleOwner = r13
            androidx.lifecycle.n<androidx.lifecycle.h> r0 = r7.mViewLifecycleOwnerLiveData
            r0.mo4583b(r13)
            r7.mInnerView = r13
            r7.mInLayout = r12
        L_0x040a:
            if (r11 >= r8) goto L_0x04df
            boolean r0 = r6.f2577u
            if (r0 == 0) goto L_0x0431
            android.view.View r0 = r15.getAnimatingAway()
            if (r0 == 0) goto L_0x0421
            android.view.View r0 = r15.getAnimatingAway()
            r15.setAnimatingAway(r13)
            r0.clearAnimation()
            goto L_0x0431
        L_0x0421:
            android.animation.Animator r0 = r15.getAnimator()
            if (r0 == 0) goto L_0x0431
            android.animation.Animator r0 = r15.getAnimator()
            r15.setAnimator(r13)
            r0.cancel()
        L_0x0431:
            android.view.View r0 = r15.getAnimatingAway()
            if (r0 != 0) goto L_0x04db
            android.animation.Animator r0 = r15.getAnimator()
            if (r0 == 0) goto L_0x043f
            goto L_0x04db
        L_0x043f:
            boolean r0 = f2551b
            if (r0 == 0) goto L_0x0459
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "movefrom CREATED: "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.v(r0, r1)
        L_0x0459:
            boolean r0 = r7.mRemoving
            if (r0 == 0) goto L_0x0465
            boolean r0 = r15.isInBackStack()
            if (r0 != 0) goto L_0x0465
            r0 = 1
            goto L_0x0466
        L_0x0465:
            r0 = 0
        L_0x0466:
            if (r0 != 0) goto L_0x0474
            androidx.fragment.app.m r1 = r6.f2558I
            boolean r1 = r1.mo4494b(r15)
            if (r1 == 0) goto L_0x0471
            goto L_0x0474
        L_0x0471:
            r7.mState = r12
            goto L_0x04a5
        L_0x0474:
            androidx.fragment.app.i r1 = r6.f2570n
            boolean r2 = r1 instanceof androidx.lifecycle.C0972v
            if (r2 == 0) goto L_0x0481
            androidx.fragment.app.m r1 = r6.f2558I
            boolean r8 = r1.mo4493b()
            goto L_0x0496
        L_0x0481:
            android.content.Context r1 = r1.mo4356i()
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0496
            androidx.fragment.app.i r1 = r6.f2570n
            android.content.Context r1 = r1.mo4356i()
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r1 = r1.isChangingConfigurations()
            r8 = r8 ^ r1
        L_0x0496:
            if (r0 != 0) goto L_0x049a
            if (r8 == 0) goto L_0x049f
        L_0x049a:
            androidx.fragment.app.m r1 = r6.f2558I
            r1.mo4500f(r15)
        L_0x049f:
            r15.performDestroy()
            r14.mo4435g(r15, r12)
        L_0x04a5:
            r15.performDetach()
            r14.mo4438h(r15, r12)
            if (r19 != 0) goto L_0x04df
            if (r0 != 0) goto L_0x04d7
            androidx.fragment.app.m r0 = r6.f2558I
            boolean r0 = r0.mo4494b(r15)
            if (r0 == 0) goto L_0x04b8
            goto L_0x04d7
        L_0x04b8:
            r7.mHost = r13
            r7.mParentFragment = r13
            r7.mFragmentManager = r13
            java.lang.String r0 = r7.mTargetWho
            if (r0 == 0) goto L_0x04df
            java.util.HashMap<java.lang.String, androidx.fragment.app.d> r0 = r6.f2563g
            java.lang.String r1 = r7.mTargetWho
            java.lang.Object r0 = r0.get(r1)
            androidx.fragment.app.d r0 = (androidx.fragment.app.C0735d) r0
            if (r0 == 0) goto L_0x04df
            boolean r1 = r0.getRetainInstance()
            if (r1 == 0) goto L_0x04df
            r7.mTarget = r0
            goto L_0x04df
        L_0x04d7:
            r14.mo4446l(r15)
            goto L_0x04df
        L_0x04db:
            r15.setStateAfterAnimating(r11)
            goto L_0x04e0
        L_0x04df:
            r8 = r11
        L_0x04e0:
            int r0 = r7.mState
            if (r0 == r8) goto L_0x050e
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "moveToState: Fragment state for "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r2 = " not updated inline; expected state "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = " found "
            r1.append(r2)
            int r2 = r7.mState
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r0, r1)
            r7.mState = r8
        L_0x050e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0753k.mo4396a(androidx.fragment.app.d, int, int, int, boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4397a(C0735d dVar, Context context, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4397a(dVar, context, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4371a((C0750j) this, dVar, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4398a(C0735d dVar, Bundle bundle, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4398a(dVar, bundle, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4372a((C0750j) this, dVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4399a(C0735d dVar, View view, Bundle bundle, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4399a(dVar, view, bundle, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4373a(this, dVar, view, bundle);
            }
        }
    }

    /* renamed from: a */
    public void mo4400a(C0735d dVar, C0947e.C0949b bVar) {
        if (this.f2563g.get(dVar.mWho) == dVar && (dVar.mHost == null || dVar.getFragmentManager() == this)) {
            dVar.mMaxState = bVar;
            return;
        }
        throw new IllegalArgumentException("Fragment " + dVar + " is not an active fragment of FragmentManager " + this);
    }

    /* renamed from: a */
    public void mo4401a(C0735d dVar, boolean z) {
        if (f2551b) {
            Log.v("FragmentManager", "add: " + dVar);
        }
        mo4443k(dVar);
        if (dVar.mDetached) {
            return;
        }
        if (!this.f2562f.contains(dVar)) {
            synchronized (this.f2562f) {
                this.f2562f.add(dVar);
            }
            dVar.mAdded = true;
            dVar.mRemoving = false;
            if (dVar.mView == null) {
                dVar.mHiddenChanged = false;
            }
            if (m3082w(dVar)) {
                this.f2574r = true;
            }
            if (z) {
                mo4434g(dVar);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + dVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: androidx.activity.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: androidx.fragment.app.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: androidx.fragment.app.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: androidx.fragment.app.d} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4402a(androidx.fragment.app.C0749i r3, androidx.fragment.app.C0746f r4, androidx.fragment.app.C0735d r5) {
        /*
            r2 = this;
            androidx.fragment.app.i r0 = r2.f2570n
            if (r0 != 0) goto L_0x004a
            r2.f2570n = r3
            r2.f2571o = r4
            r2.f2572p = r5
            androidx.fragment.app.d r4 = r2.f2572p
            if (r4 == 0) goto L_0x0011
            r2.m3057C()
        L_0x0011:
            boolean r4 = r3 instanceof androidx.activity.C0058d
            if (r4 == 0) goto L_0x0028
            r4 = r3
            androidx.activity.d r4 = (androidx.activity.C0058d) r4
            androidx.activity.OnBackPressedDispatcher r0 = r4.getOnBackPressedDispatcher()
            r2.f2555F = r0
            if (r5 == 0) goto L_0x0021
            r4 = r5
        L_0x0021:
            androidx.activity.OnBackPressedDispatcher r0 = r2.f2555F
            androidx.activity.c r1 = r2.f2556G
            r0.mo662a(r4, r1)
        L_0x0028:
            if (r5 == 0) goto L_0x0033
            androidx.fragment.app.k r3 = r5.mFragmentManager
            androidx.fragment.app.m r3 = r3.mo4422c((androidx.fragment.app.C0735d) r5)
        L_0x0030:
            r2.f2558I = r3
            goto L_0x0049
        L_0x0033:
            boolean r4 = r3 instanceof androidx.lifecycle.C0972v
            if (r4 == 0) goto L_0x0042
            androidx.lifecycle.v r3 = (androidx.lifecycle.C0972v) r3
            androidx.lifecycle.u r3 = r3.getViewModelStore()
            androidx.fragment.app.m r3 = androidx.fragment.app.C0770m.m3189a((androidx.lifecycle.C0971u) r3)
            goto L_0x0030
        L_0x0042:
            androidx.fragment.app.m r3 = new androidx.fragment.app.m
            r4 = 0
            r3.<init>(r4)
            goto L_0x0030
        L_0x0049:
            return
        L_0x004a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "Already attached"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0753k.mo4402a(androidx.fragment.app.i, androidx.fragment.app.f, androidx.fragment.app.d):void");
    }

    /* renamed from: a */
    public void mo4362a(C0750j.C0751a aVar) {
        synchronized (this.f2557H) {
            int i = 0;
            int size = this.f2557H.size();
            while (true) {
                if (i >= size) {
                    break;
                } else if (this.f2557H.get(i).f2605a == aVar) {
                    this.f2557H.remove(i);
                    break;
                } else {
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo4363a(C0750j.C0751a aVar, boolean z) {
        this.f2557H.add(new C0763c(aVar, z));
    }

    /* renamed from: a */
    public void mo4403a(C0765e eVar, boolean z) {
        if (!z) {
            m3058D();
        }
        synchronized (this) {
            if (!this.f2577u) {
                if (this.f2570n != null) {
                    if (this.f2559c == null) {
                        this.f2559c = new ArrayList<>();
                    }
                    this.f2559c.add(eVar);
                    mo4441j();
                    return;
                }
            }
            if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    /* renamed from: a */
    public void mo4364a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String str2 = str + "    ";
        if (!this.f2563g.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (C0735d next : this.f2563g.values()) {
                printWriter.print(str);
                printWriter.println(next);
                if (next != null) {
                    next.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.f2562f.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size5; i++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(this.f2562f.get(i).toString());
            }
        }
        ArrayList<C0735d> arrayList = this.f2565i;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size4; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f2565i.get(i2).toString());
            }
        }
        ArrayList<C0730a> arrayList2 = this.f2564h;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                C0730a aVar = this.f2564h.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.mo4065a(str2, printWriter);
            }
        }
        synchronized (this) {
            if (this.f2566j != null && (size2 = this.f2566j.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i4 = 0; i4 < size2; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println(this.f2566j.get(i4));
                }
            }
            if (this.f2567k != null && this.f2567k.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f2567k.toArray()));
            }
        }
        ArrayList<C0765e> arrayList3 = this.f2559c;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i5 = 0; i5 < size; i5++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(this.f2559c.get(i5));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2570n);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2571o);
        if (this.f2572p != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2572p);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2569m);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f2575s);
        printWriter.print(" mStopped=");
        printWriter.print(this.f2576t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f2577u);
        if (this.f2574r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f2574r);
        }
    }

    /* renamed from: a */
    public void mo4404a(boolean z) {
        for (int size = this.f2562f.size() - 1; size >= 0; size--) {
            C0735d dVar = this.f2562f.get(size);
            if (dVar != null) {
                dVar.performMultiWindowModeChanged(z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4405a(int i) {
        return this.f2569m >= i;
    }

    /* renamed from: a */
    public boolean mo4406a(Menu menu) {
        if (this.f2569m < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f2562f.size(); i++) {
            C0735d dVar = this.f2562f.get(i);
            if (dVar != null && dVar.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public boolean mo4407a(Menu menu, MenuInflater menuInflater) {
        if (this.f2569m < 1) {
            return false;
        }
        ArrayList<C0735d> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.f2562f.size(); i++) {
            C0735d dVar = this.f2562f.get(i);
            if (dVar != null && dVar.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(dVar);
                z = true;
            }
        }
        if (this.f2565i != null) {
            for (int i2 = 0; i2 < this.f2565i.size(); i2++) {
                C0735d dVar2 = this.f2565i.get(i2);
                if (arrayList == null || !arrayList.contains(dVar2)) {
                    dVar2.onDestroyOptionsMenu();
                }
            }
        }
        this.f2565i = arrayList;
        return z;
    }

    /* renamed from: a */
    public boolean mo4408a(MenuItem menuItem) {
        if (this.f2569m < 1) {
            return false;
        }
        for (int i = 0; i < this.f2562f.size(); i++) {
            C0735d dVar = this.f2562f.get(i);
            if (dVar != null && dVar.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4409a(C0735d dVar) {
        if (dVar == null) {
            return true;
        }
        C0753k kVar = dVar.mFragmentManager;
        return dVar == kVar.mo4471z() && mo4409a(kVar.f2572p);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4410a(ArrayList<C0730a> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int i3;
        ArrayList<C0730a> arrayList3 = this.f2564h;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f2564h.remove(size));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                i3 = this.f2564h.size() - 1;
                while (i3 >= 0) {
                    C0730a aVar = this.f2564h.get(i3);
                    if ((str != null && str.equals(aVar.mo4079h())) || (i >= 0 && i == aVar.f2499c)) {
                        break;
                    }
                    i3--;
                }
                if (i3 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        i3--;
                        if (i3 < 0) {
                            break;
                        }
                        C0730a aVar2 = this.f2564h.get(i3);
                        if ((str == null || !str.equals(aVar2.mo4079h())) && (i < 0 || i != aVar2.f2499c)) {
                            break;
                        }
                    }
                }
            } else {
                i3 = -1;
            }
            if (i3 == this.f2564h.size() - 1) {
                return false;
            }
            for (int size2 = this.f2564h.size() - 1; size2 > i3; size2--) {
                arrayList.add(this.f2564h.remove(size2));
                arrayList2.add(true);
            }
        }
        return true;
    }

    /* renamed from: b */
    public C0735d mo4411b(int i) {
        for (int size = this.f2562f.size() - 1; size >= 0; size--) {
            C0735d dVar = this.f2562f.get(size);
            if (dVar != null && dVar.mFragmentId == i) {
                return dVar;
            }
        }
        for (C0735d next : this.f2563g.values()) {
            if (next != null && next.mFragmentId == i) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: b */
    public C0735d mo4412b(String str) {
        C0735d findFragmentByWho;
        for (C0735d next : this.f2563g.values()) {
            if (next != null && (findFragmentByWho = next.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0971u mo4413b(C0735d dVar) {
        return this.f2558I.mo4498e(dVar);
    }

    /* renamed from: b */
    public void mo4414b(Menu menu) {
        if (this.f2569m >= 1) {
            for (int i = 0; i < this.f2562f.size(); i++) {
                C0735d dVar = this.f2562f.get(i);
                if (dVar != null) {
                    dVar.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4415b(C0730a aVar) {
        if (this.f2564h == null) {
            this.f2564h = new ArrayList<>();
        }
        this.f2564h.add(aVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4416b(C0735d dVar, Context context, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4416b(dVar, context, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4375b((C0750j) this, dVar, context);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4417b(C0735d dVar, Bundle bundle, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4417b(dVar, bundle, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4376b((C0750j) this, dVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo4418b(C0735d dVar, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4418b(dVar, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4370a(this, dVar);
            }
        }
    }

    /* renamed from: b */
    public void mo4419b(C0765e eVar, boolean z) {
        if (!z || (this.f2570n != null && !this.f2577u)) {
            m3076c(z);
            if (eVar.mo4068a(this.f2579w, this.f2580x)) {
                this.f2560d = true;
                try {
                    m3074b(this.f2579w, this.f2580x);
                } finally {
                    m3059E();
                }
            }
            m3057C();
            mo4445l();
            m3062H();
        }
    }

    /* renamed from: b */
    public void mo4420b(boolean z) {
        for (int size = this.f2562f.size() - 1; size >= 0; size--) {
            C0735d dVar = this.f2562f.get(size);
            if (dVar != null) {
                dVar.performPictureInPictureModeChanged(z);
            }
        }
    }

    /* renamed from: b */
    public boolean mo4365b() {
        m3058D();
        return m3071a((String) null, -1, 0);
    }

    /* renamed from: b */
    public boolean mo4421b(MenuItem menuItem) {
        if (this.f2569m < 1) {
            return false;
        }
        for (int i = 0; i < this.f2562f.size(); i++) {
            C0735d dVar = this.f2562f.get(i);
            if (dVar != null && dVar.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0770m mo4422c(C0735d dVar) {
        return this.f2558I.mo4497d(dVar);
    }

    /* renamed from: c */
    public List<C0735d> mo4366c() {
        List<C0735d> list;
        if (this.f2562f.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f2562f) {
            list = (List) this.f2562f.clone();
        }
        return list;
    }

    /* renamed from: c */
    public void mo4423c(int i) {
        synchronized (this) {
            this.f2566j.set(i, (Object) null);
            if (this.f2567k == null) {
                this.f2567k = new ArrayList<>();
            }
            if (f2551b) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f2567k.add(Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4424c(C0735d dVar, Bundle bundle, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4424c(dVar, bundle, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4378c(this, dVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo4425c(C0735d dVar, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4425c(dVar, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4374b(this, dVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo4426d(C0735d dVar) {
        if (mo4369f()) {
            if (f2551b) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else if (this.f2558I.mo4492a(dVar) && f2551b) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + dVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo4427d(C0735d dVar, Bundle bundle, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4427d(dVar, bundle, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4380d(this, dVar, bundle);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo4428d(C0735d dVar, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4428d(dVar, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4377c(this, dVar);
            }
        }
    }

    /* renamed from: d */
    public boolean mo4367d() {
        return this.f2577u;
    }

    /* renamed from: e */
    public C0748h mo4368e() {
        if (super.mo4368e() == f2547a) {
            C0735d dVar = this.f2572p;
            if (dVar != null) {
                return dVar.mFragmentManager.mo4368e();
            }
            mo4361a((C0748h) new C0748h() {
                /* renamed from: c */
                public C0735d mo4354c(ClassLoader classLoader, String str) {
                    return C0753k.this.f2570n.mo4329a(C0753k.this.f2570n.mo4356i(), str, (Bundle) null);
                }
            });
        }
        return super.mo4368e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo4429e(C0735d dVar) {
        if (mo4369f()) {
            if (f2551b) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else if (this.f2558I.mo4496c(dVar) && f2551b) {
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + dVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo4430e(C0735d dVar, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4430e(dVar, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4379d(this, dVar);
            }
        }
    }

    /* renamed from: f */
    public void mo4431f(C0735d dVar) {
        if (!dVar.mDeferStart) {
            return;
        }
        if (this.f2560d) {
            this.f2578v = true;
            return;
        }
        dVar.mDeferStart = false;
        mo4396a(dVar, this.f2569m, 0, 0, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo4432f(C0735d dVar, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4432f(dVar, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4381e(this, dVar);
            }
        }
    }

    /* renamed from: f */
    public boolean mo4369f() {
        return this.f2575s || this.f2576t;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo4433g() {
        mo4444k();
        if (this.f2556G.mo677a()) {
            mo4365b();
        } else {
            this.f2555F.mo661a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo4434g(C0735d dVar) {
        mo4396a(dVar, this.f2569m, 0, 0, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo4435g(C0735d dVar, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4435g(dVar, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4382f(this, dVar);
            }
        }
    }

    /* renamed from: h */
    public int mo4436h() {
        ArrayList<C0730a> arrayList = this.f2564h;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo4437h(C0735d dVar) {
        if (dVar.mFromLayout && !dVar.mPerformedCreateView) {
            dVar.performCreateView(dVar.performGetLayoutInflater(dVar.mSavedFragmentState), (ViewGroup) null, dVar.mSavedFragmentState);
            if (dVar.mView != null) {
                dVar.mInnerView = dVar.mView;
                dVar.mView.setSaveFromParentEnabled(false);
                if (dVar.mHidden) {
                    dVar.mView.setVisibility(8);
                }
                dVar.onViewCreated(dVar.mView, dVar.mSavedFragmentState);
                mo4399a(dVar, dVar.mView, dVar.mSavedFragmentState, false);
                return;
            }
            dVar.mInnerView = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo4438h(C0735d dVar, boolean z) {
        C0735d dVar2 = this.f2572p;
        if (dVar2 != null) {
            C0750j fragmentManager = dVar2.getFragmentManager();
            if (fragmentManager instanceof C0753k) {
                ((C0753k) fragmentManager).mo4438h(dVar, true);
            }
        }
        Iterator<C0763c> it = this.f2557H.iterator();
        while (it.hasNext()) {
            C0763c next = it.next();
            if (!z || next.f2606b) {
                next.f2605a.mo4383g(this, dVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo4439i() {
        for (C0735d next : this.f2563g.values()) {
            if (next != null) {
                mo4431f(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo4440i(final C0735d dVar) {
        if (dVar.mView != null) {
            C0761a a = mo4389a(dVar, dVar.getNextTransition(), !dVar.mHidden, dVar.getNextTransitionStyle());
            if (a == null || a.f2599b == null) {
                if (a != null) {
                    dVar.mView.startAnimation(a.f2598a);
                    a.f2598a.start();
                }
                dVar.mView.setVisibility((!dVar.mHidden || dVar.isHideReplaced()) ? 0 : 8);
                if (dVar.isHideReplaced()) {
                    dVar.setHideReplaced(false);
                }
            } else {
                a.f2599b.setTarget(dVar.mView);
                if (!dVar.mHidden) {
                    dVar.mView.setVisibility(0);
                } else if (dVar.isHideReplaced()) {
                    dVar.setHideReplaced(false);
                } else {
                    final ViewGroup viewGroup = dVar.mContainer;
                    final View view = dVar.mView;
                    viewGroup.startViewTransition(view);
                    a.f2599b.addListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (dVar.mView != null && dVar.mHidden) {
                                dVar.mView.setVisibility(8);
                            }
                        }
                    });
                }
                a.f2599b.start();
            }
        }
        if (dVar.mAdded && m3082w(dVar)) {
            this.f2574r = true;
        }
        dVar.mHiddenChanged = false;
        dVar.onHiddenChanged(dVar.mHidden);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo4441j() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = this.f2553B != null && !this.f2553B.isEmpty();
            if (this.f2559c != null && this.f2559c.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.f2570n.mo4357j().removeCallbacks(this.f2554C);
                this.f2570n.mo4357j().post(this.f2554C);
                m3057C();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006a, code lost:
        r0 = r0.mView;
        r1 = r11.mContainer;
     */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo4442j(androidx.fragment.app.C0735d r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.HashMap<java.lang.String, androidx.fragment.app.d> r0 = r10.f2563g
            java.lang.String r1 = r11.mWho
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x003a
            boolean r0 = f2551b
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = "FragmentManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Ignoring moving "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = " to state "
            r1.append(r11)
            int r11 = r10.f2569m
            r1.append(r11)
            java.lang.String r11 = "since it is not added to "
            r1.append(r11)
            r1.append(r10)
            java.lang.String r11 = r1.toString()
            android.util.Log.v(r0, r11)
        L_0x0039:
            return
        L_0x003a:
            int r0 = r10.f2569m
            boolean r1 = r11.mRemoving
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0051
            boolean r1 = r11.isInBackStack()
            if (r1 == 0) goto L_0x004d
            int r0 = java.lang.Math.min(r0, r2)
            goto L_0x0051
        L_0x004d:
            int r0 = java.lang.Math.min(r0, r3)
        L_0x0051:
            r6 = r0
            int r7 = r11.getNextTransition()
            int r8 = r11.getNextTransitionStyle()
            r9 = 0
            r4 = r10
            r5 = r11
            r4.mo4396a((androidx.fragment.app.C0735d) r5, (int) r6, (int) r7, (int) r8, (boolean) r9)
            android.view.View r0 = r11.mView
            if (r0 == 0) goto L_0x00c2
            androidx.fragment.app.d r0 = r10.m3080u(r11)
            if (r0 == 0) goto L_0x0082
            android.view.View r0 = r0.mView
            android.view.ViewGroup r1 = r11.mContainer
            int r0 = r1.indexOfChild(r0)
            android.view.View r4 = r11.mView
            int r4 = r1.indexOfChild(r4)
            if (r4 >= r0) goto L_0x0082
            r1.removeViewAt(r4)
            android.view.View r4 = r11.mView
            r1.addView(r4, r0)
        L_0x0082:
            boolean r0 = r11.mIsNewlyAdded
            if (r0 == 0) goto L_0x00c2
            android.view.ViewGroup r0 = r11.mContainer
            if (r0 == 0) goto L_0x00c2
            float r0 = r11.mPostponedAlpha
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0098
            android.view.View r0 = r11.mView
            float r4 = r11.mPostponedAlpha
            r0.setAlpha(r4)
        L_0x0098:
            r11.mPostponedAlpha = r1
            r11.mIsNewlyAdded = r3
            int r0 = r11.getNextTransition()
            int r1 = r11.getNextTransitionStyle()
            androidx.fragment.app.k$a r0 = r10.mo4389a((androidx.fragment.app.C0735d) r11, (int) r0, (boolean) r2, (int) r1)
            if (r0 == 0) goto L_0x00c2
            android.view.animation.Animation r1 = r0.f2598a
            if (r1 == 0) goto L_0x00b6
            android.view.View r1 = r11.mView
            android.view.animation.Animation r0 = r0.f2598a
            r1.startAnimation(r0)
            goto L_0x00c2
        L_0x00b6:
            android.animation.Animator r1 = r0.f2599b
            android.view.View r2 = r11.mView
            r1.setTarget(r2)
            android.animation.Animator r0 = r0.f2599b
            r0.start()
        L_0x00c2:
            boolean r0 = r11.mHiddenChanged
            if (r0 == 0) goto L_0x00c9
            r10.mo4440i(r11)
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0753k.mo4442j(androidx.fragment.app.d):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo4443k(C0735d dVar) {
        if (this.f2563g.get(dVar.mWho) == null) {
            this.f2563g.put(dVar.mWho, dVar);
            if (dVar.mRetainInstanceChangedWhileDetached) {
                if (dVar.mRetainInstance) {
                    mo4426d(dVar);
                } else {
                    mo4429e(dVar);
                }
                dVar.mRetainInstanceChangedWhileDetached = false;
            }
            if (f2551b) {
                Log.v("FragmentManager", "Added fragment to active set " + dVar);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: k */
    public boolean mo4444k() {
        m3076c(true);
        boolean z = false;
        while (m3077c(this.f2579w, this.f2580x)) {
            this.f2560d = true;
            try {
                m3074b(this.f2579w, this.f2580x);
                m3059E();
                z = true;
            } catch (Throwable th) {
                m3059E();
                throw th;
            }
        }
        m3057C();
        mo4445l();
        m3062H();
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo4445l() {
        if (this.f2578v) {
            this.f2578v = false;
            mo4439i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo4446l(C0735d dVar) {
        if (this.f2563g.get(dVar.mWho) != null) {
            if (f2551b) {
                Log.v("FragmentManager", "Removed fragment from active set " + dVar);
            }
            for (C0735d next : this.f2563g.values()) {
                if (next != null && dVar.mWho.equals(next.mTargetWho)) {
                    next.mTarget = dVar;
                    next.mTargetWho = null;
                }
            }
            this.f2563g.put(dVar.mWho, (Object) null);
            mo4429e(dVar);
            if (dVar.mTargetWho != null) {
                dVar.mTarget = this.f2563g.get(dVar.mTargetWho);
            }
            dVar.initState();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo4447m() {
        if (this.f2568l != null) {
            for (int i = 0; i < this.f2568l.size(); i++) {
                this.f2568l.get(i).mo4384a();
            }
        }
    }

    /* renamed from: m */
    public void mo4448m(C0735d dVar) {
        if (f2551b) {
            Log.v("FragmentManager", "remove: " + dVar + " nesting=" + dVar.mBackStackNesting);
        }
        boolean z = !dVar.isInBackStack();
        if (!dVar.mDetached || z) {
            synchronized (this.f2562f) {
                this.f2562f.remove(dVar);
            }
            if (m3082w(dVar)) {
                this.f2574r = true;
            }
            dVar.mAdded = false;
            dVar.mRemoving = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public Parcelable mo4449n() {
        ArrayList<String> arrayList;
        int size;
        m3060F();
        m3061G();
        mo4444k();
        this.f2575s = true;
        C0731b[] bVarArr = null;
        if (this.f2563g.isEmpty()) {
            return null;
        }
        ArrayList<C0773o> arrayList2 = new ArrayList<>(this.f2563g.size());
        boolean z = false;
        for (C0735d next : this.f2563g.values()) {
            if (next != null) {
                if (next.mFragmentManager != this) {
                    m3068a((RuntimeException) new IllegalStateException("Failure saving state: active " + next + " was removed from the FragmentManager"));
                }
                C0773o oVar = new C0773o(next);
                arrayList2.add(oVar);
                if (next.mState <= 0 || oVar.f2639m != null) {
                    oVar.f2639m = next.mSavedFragmentState;
                } else {
                    oVar.f2639m = mo4461s(next);
                    if (next.mTargetWho != null) {
                        C0735d dVar = this.f2563g.get(next.mTargetWho);
                        if (dVar == null) {
                            m3068a((RuntimeException) new IllegalStateException("Failure saving state: " + next + " has target not in fragment manager: " + next.mTargetWho));
                        }
                        if (oVar.f2639m == null) {
                            oVar.f2639m = new Bundle();
                        }
                        mo4393a(oVar.f2639m, "android:target_state", dVar);
                        if (next.mTargetRequestCode != 0) {
                            oVar.f2639m.putInt("android:target_req_state", next.mTargetRequestCode);
                        }
                    }
                }
                if (f2551b) {
                    Log.v("FragmentManager", "Saved state of " + next + ": " + oVar.f2639m);
                }
                z = true;
            }
        }
        if (!z) {
            if (f2551b) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size2 = this.f2562f.size();
        if (size2 > 0) {
            arrayList = new ArrayList<>(size2);
            Iterator<C0735d> it = this.f2562f.iterator();
            while (it.hasNext()) {
                C0735d next2 = it.next();
                arrayList.add(next2.mWho);
                if (next2.mFragmentManager != this) {
                    m3068a((RuntimeException) new IllegalStateException("Failure saving state: active " + next2 + " was removed from the FragmentManager"));
                }
                if (f2551b) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next2.mWho + "): " + next2);
                }
            }
        } else {
            arrayList = null;
        }
        ArrayList<C0730a> arrayList3 = this.f2564h;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            bVarArr = new C0731b[size];
            for (int i = 0; i < size; i++) {
                bVarArr[i] = new C0731b(this.f2564h.get(i));
                if (f2551b) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i + ": " + this.f2564h.get(i));
                }
            }
        }
        C0768l lVar = new C0768l();
        lVar.f2615a = arrayList2;
        lVar.f2616b = arrayList;
        lVar.f2617c = bVarArr;
        C0735d dVar2 = this.f2573q;
        if (dVar2 != null) {
            lVar.f2618d = dVar2.mWho;
        }
        lVar.f2619e = this.f2561e;
        return lVar;
    }

    /* renamed from: n */
    public void mo4450n(C0735d dVar) {
        if (f2551b) {
            Log.v("FragmentManager", "hide: " + dVar);
        }
        if (!dVar.mHidden) {
            dVar.mHidden = true;
            dVar.mHiddenChanged = true ^ dVar.mHiddenChanged;
        }
    }

    /* renamed from: o */
    public void mo4451o() {
        this.f2575s = false;
        this.f2576t = false;
        int size = this.f2562f.size();
        for (int i = 0; i < size; i++) {
            C0735d dVar = this.f2562f.get(i);
            if (dVar != null) {
                dVar.noteStateNotSaved();
            }
        }
    }

    /* renamed from: o */
    public void mo4452o(C0735d dVar) {
        if (f2551b) {
            Log.v("FragmentManager", "show: " + dVar);
        }
        if (dVar.mHidden) {
            dVar.mHidden = false;
            dVar.mHiddenChanged = !dVar.mHiddenChanged;
        }
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        C0735d dVar;
        AttributeSet attributeSet2 = attributeSet;
        String str2 = str;
        C0735d dVar2 = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet2.getAttributeValue((String) null, "class");
        Context context2 = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet2, C0764d.f2607a);
        int i = 0;
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str3 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (str3 == null || !C0748h.m3009a(context.getClassLoader(), str3)) {
            return null;
        }
        if (view != null) {
            i = view.getId();
        }
        if (i == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str3);
        }
        if (resourceId != -1) {
            dVar2 = mo4411b(resourceId);
        }
        if (dVar2 == null && string != null) {
            dVar2 = mo4358a(string);
        }
        if (dVar2 == null && i != -1) {
            dVar2 = mo4411b(i);
        }
        if (f2551b) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str3 + " existing=" + dVar2);
        }
        if (dVar2 == null) {
            C0735d c = mo4368e().mo4354c(context.getClassLoader(), str3);
            c.mFromLayout = true;
            c.mFragmentId = resourceId != 0 ? resourceId : i;
            c.mContainerId = i;
            c.mTag = string;
            c.mInLayout = true;
            c.mFragmentManager = this;
            C0749i iVar = this.f2570n;
            c.mHost = iVar;
            c.onInflate(iVar.mo4356i(), attributeSet2, c.mSavedFragmentState);
            mo4401a(c, true);
            dVar = c;
        } else if (!dVar2.mInLayout) {
            dVar2.mInLayout = true;
            C0749i iVar2 = this.f2570n;
            dVar2.mHost = iVar2;
            dVar2.onInflate(iVar2.mo4356i(), attributeSet2, dVar2.mSavedFragmentState);
            dVar = dVar2;
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str3);
        }
        if (this.f2569m >= 1 || !dVar.mFromLayout) {
            mo4434g(dVar);
        } else {
            mo4396a(dVar, 1, 0, 0, false);
        }
        if (dVar.mView != null) {
            if (resourceId != 0) {
                dVar.mView.setId(resourceId);
            }
            if (dVar.mView.getTag() == null) {
                dVar.mView.setTag(string);
            }
            return dVar.mView;
        }
        throw new IllegalStateException("Fragment " + str3 + " did not create a view.");
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    /* renamed from: p */
    public void mo4455p() {
        this.f2575s = false;
        this.f2576t = false;
        m3079e(1);
    }

    /* renamed from: p */
    public void mo4456p(C0735d dVar) {
        if (f2551b) {
            Log.v("FragmentManager", "detach: " + dVar);
        }
        if (!dVar.mDetached) {
            dVar.mDetached = true;
            if (dVar.mAdded) {
                if (f2551b) {
                    Log.v("FragmentManager", "remove from detach: " + dVar);
                }
                synchronized (this.f2562f) {
                    this.f2562f.remove(dVar);
                }
                if (m3082w(dVar)) {
                    this.f2574r = true;
                }
                dVar.mAdded = false;
            }
        }
    }

    /* renamed from: q */
    public void mo4457q() {
        this.f2575s = false;
        this.f2576t = false;
        m3079e(2);
    }

    /* renamed from: q */
    public void mo4458q(C0735d dVar) {
        if (f2551b) {
            Log.v("FragmentManager", "attach: " + dVar);
        }
        if (dVar.mDetached) {
            dVar.mDetached = false;
            if (dVar.mAdded) {
                return;
            }
            if (!this.f2562f.contains(dVar)) {
                if (f2551b) {
                    Log.v("FragmentManager", "add from attach: " + dVar);
                }
                synchronized (this.f2562f) {
                    this.f2562f.add(dVar);
                }
                dVar.mAdded = true;
                if (m3082w(dVar)) {
                    this.f2574r = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + dVar);
        }
    }

    /* renamed from: r */
    public void mo4459r() {
        this.f2575s = false;
        this.f2576t = false;
        m3079e(3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public void mo4460r(C0735d dVar) {
        if (dVar.mInnerView != null) {
            SparseArray<Parcelable> sparseArray = this.f2552A;
            if (sparseArray == null) {
                this.f2552A = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            dVar.mInnerView.saveHierarchyState(this.f2552A);
            if (this.f2552A.size() > 0) {
                dVar.mSavedViewState = this.f2552A;
                this.f2552A = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s */
    public Bundle mo4461s(C0735d dVar) {
        Bundle bundle;
        if (this.f2582z == null) {
            this.f2582z = new Bundle();
        }
        dVar.performSaveInstanceState(this.f2582z);
        mo4427d(dVar, this.f2582z, false);
        if (!this.f2582z.isEmpty()) {
            bundle = this.f2582z;
            this.f2582z = null;
        } else {
            bundle = null;
        }
        if (dVar.mView != null) {
            mo4460r(dVar);
        }
        if (dVar.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", dVar.mSavedViewState);
        }
        if (!dVar.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", dVar.mUserVisibleHint);
        }
        return bundle;
    }

    /* renamed from: s */
    public void mo4462s() {
        this.f2575s = false;
        this.f2576t = false;
        m3079e(4);
    }

    /* renamed from: t */
    public void mo4463t() {
        m3079e(3);
    }

    /* renamed from: t */
    public void mo4464t(C0735d dVar) {
        if (dVar == null || (this.f2563g.get(dVar.mWho) == dVar && (dVar.mHost == null || dVar.getFragmentManager() == this))) {
            C0735d dVar2 = this.f2573q;
            this.f2573q = dVar;
            m3081v(dVar2);
            m3081v(this.f2573q);
            return;
        }
        throw new IllegalArgumentException("Fragment " + dVar + " is not an active fragment of FragmentManager " + this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Object obj = this.f2572p;
        if (obj == null) {
            obj = this.f2570n;
        }
        C0580a.m2253a(obj, sb);
        sb.append("}}");
        return sb.toString();
    }

    /* renamed from: u */
    public void mo4466u() {
        this.f2576t = true;
        m3079e(2);
    }

    /* renamed from: v */
    public void mo4467v() {
        m3079e(1);
    }

    /* renamed from: w */
    public void mo4468w() {
        this.f2577u = true;
        mo4444k();
        m3079e(0);
        this.f2570n = null;
        this.f2571o = null;
        this.f2572p = null;
        if (this.f2555F != null) {
            this.f2556G.mo678b();
            this.f2555F = null;
        }
    }

    /* renamed from: x */
    public void mo4469x() {
        for (int i = 0; i < this.f2562f.size(); i++) {
            C0735d dVar = this.f2562f.get(i);
            if (dVar != null) {
                dVar.performLowMemory();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: y */
    public void mo4470y() {
        m3057C();
        m3081v(this.f2573q);
    }

    /* renamed from: z */
    public C0735d mo4471z() {
        return this.f2573q;
    }
}
