package com.nambimobile.widgets.efab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.p030h.C0656u;
import com.nambimobile.widgets.efab.C2596k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.C3266f;
import p157d.C3291h;
import p157d.p158a.C3191g;
import p157d.p161d.p162a.C3218a;
import p157d.p161d.p163b.C3249g;
import p157d.p161d.p163b.C3250h;
import p157d.p161d.p163b.C3251i;
import p157d.p161d.p163b.C3254k;
import p157d.p165f.C3269c;

public final class ExpandableFabLayout extends CoordinatorLayout {
    @NotNull

    /* renamed from: a */
    private C2595j f6984a = new C2595j();
    @NotNull

    /* renamed from: b */
    private C2595j f6985b = new C2595j();

    /* renamed from: c */
    private boolean f6986c = true;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f6987d = true;

    /* renamed from: e */
    private boolean f6988e;

    /* renamed from: f */
    private boolean f6989f;

    /* renamed from: g */
    private boolean f6990g;

    /* renamed from: h */
    private C2579h f6991h;

    /* renamed from: i */
    private C2578g f6992i;

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFabLayout$a */
    static final class C2572a extends C3251i implements C3218a<C3291h> {

        /* renamed from: a */
        final /* synthetic */ ExpandableFabLayout f6993a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2572a(ExpandableFabLayout expandableFabLayout) {
            super(0);
            this.f6993a = expandableFabLayout;
        }

        /* renamed from: a */
        public /* synthetic */ Object mo22768a() {
            mo22785b();
            return C3291h.f7327a;
        }

        /* renamed from: b */
        public final void mo22785b() {
            this.f6993a.setEfabAnimationsFinished$expandable_fab_release(false);
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFabLayout$b */
    static final /* synthetic */ class C2573b extends C3249g implements C3218a<C3291h> {
        C2573b(ExpandableFabLayout expandableFabLayout) {
            super(0, expandableFabLayout);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo22768a() {
            mo22786b();
            return C3291h.f7327a;
        }

        /* renamed from: b */
        public final void mo22786b() {
            ((ExpandableFabLayout) this.f7291a).m8761c();
        }

        /* renamed from: c */
        public final C3269c mo22787c() {
            return C3254k.m9059a(ExpandableFabLayout.class);
        }

        /* renamed from: d */
        public final String mo22788d() {
            return "defaultExpandableFabOnClickBehavior";
        }

        /* renamed from: e */
        public final String mo22789e() {
            return "defaultExpandableFabOnClickBehavior()V";
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFabLayout$c */
    static final /* synthetic */ class C2574c extends C3249g implements C3218a<Boolean> {
        C2574c(ExpandableFabLayout expandableFabLayout) {
            super(0, expandableFabLayout);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo22768a() {
            return Boolean.valueOf(mo22790b());
        }

        /* renamed from: b */
        public final boolean mo22790b() {
            return ((ExpandableFabLayout) this.f7291a).m8764d();
        }

        /* renamed from: c */
        public final C3269c mo22787c() {
            return C3254k.m9059a(ExpandableFabLayout.class);
        }

        /* renamed from: d */
        public final String mo22788d() {
            return "defaultFabOptionOnClickBehavior";
        }

        /* renamed from: e */
        public final String mo22789e() {
            return "defaultFabOptionOnClickBehavior()Z";
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFabLayout$d */
    static final /* synthetic */ class C2575d extends C3249g implements C3218a<C3291h> {
        C2575d(ExpandableFabLayout expandableFabLayout) {
            super(0, expandableFabLayout);
        }

        /* renamed from: a */
        public /* synthetic */ Object mo22768a() {
            mo22791b();
            return C3291h.f7327a;
        }

        /* renamed from: b */
        public final void mo22791b() {
            ((ExpandableFabLayout) this.f7291a).m8757b();
        }

        /* renamed from: c */
        public final C3269c mo22787c() {
            return C3254k.m9059a(ExpandableFabLayout.class);
        }

        /* renamed from: d */
        public final String mo22788d() {
            return "defaultOverlayOnClickBehavior";
        }

        /* renamed from: e */
        public final String mo22789e() {
            return "defaultOverlayOnClickBehavior()V";
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFabLayout$e */
    static final class C2576e extends C3251i implements C3218a<C3291h> {

        /* renamed from: a */
        final /* synthetic */ ExpandableFabLayout f6994a;

        /* renamed from: b */
        final /* synthetic */ C2595j f6995b;

        /* renamed from: c */
        final /* synthetic */ ExpandableFab f6996c;

        /* renamed from: d */
        final /* synthetic */ List f6997d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2576e(ExpandableFabLayout expandableFabLayout, C2595j jVar, ExpandableFab expandableFab, List list) {
            super(0);
            this.f6994a = expandableFabLayout;
            this.f6995b = jVar;
            this.f6996c = expandableFab;
            this.f6997d = list;
        }

        /* renamed from: a */
        public /* synthetic */ Object mo22768a() {
            mo22792b();
            return C3291h.f7327a;
        }

        /* renamed from: b */
        public final void mo22792b() {
            this.f6994a.setEfabAnimationsFinished$expandable_fab_release(true);
            this.f6994a.setState(false);
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFabLayout$f */
    static final class C2577f extends C3251i implements C3218a<C3291h> {

        /* renamed from: a */
        final /* synthetic */ ExpandableFabLayout f6998a;

        /* renamed from: b */
        final /* synthetic */ C2595j f6999b;

        /* renamed from: c */
        final /* synthetic */ ExpandableFab f7000c;

        /* renamed from: d */
        final /* synthetic */ List f7001d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2577f(ExpandableFabLayout expandableFabLayout, C2595j jVar, ExpandableFab expandableFab, List list) {
            super(0);
            this.f6998a = expandableFabLayout;
            this.f6999b = jVar;
            this.f7000c = expandableFab;
            this.f7001d = list;
        }

        /* renamed from: a */
        public /* synthetic */ Object mo22768a() {
            mo22793b();
            return C3291h.f7327a;
        }

        /* renamed from: b */
        public final void mo22793b() {
            this.f6998a.setEfabAnimationsFinished$expandable_fab_release(true);
            this.f6998a.setState(true);
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFabLayout$g */
    public static final class C2578g extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ExpandableFabLayout f7002a;

        C2578g(ExpandableFabLayout expandableFabLayout) {
            this.f7002a = expandableFabLayout;
        }

        public void onAnimationEnd(@Nullable Animator animator) {
            this.f7002a.f6987d = true;
            this.f7002a.setState(false);
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFabLayout$h */
    public static final class C2579h extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ExpandableFabLayout f7003a;

        C2579h(ExpandableFabLayout expandableFabLayout) {
            this.f7003a = expandableFabLayout;
        }

        public void onAnimationEnd(@Nullable Animator animator) {
            this.f7003a.f6987d = true;
            this.f7003a.setState(true);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandableFabLayout(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        C3250h.m9056b(context, "context");
        C3250h.m9056b(attributeSet, "attributeSet");
        if (getId() == -1) {
            setId(C0656u.m2579a());
        }
        this.f6991h = new C2579h(this);
        this.f6992i = new C2578g(this);
    }

    /* renamed from: a */
    private final Animator m8752a(C2595j jVar) {
        Animator animator;
        ExpandableFab b = jVar.mo22870b();
        if (b != null) {
            Iterable c = jVar.mo22871c();
            Collection arrayList = new ArrayList(C3191g.m8988a(c, 10));
            int i = 0;
            for (Object next : c) {
                int i2 = i + 1;
                if (i < 0) {
                    C3191g.m8987b();
                }
                arrayList.add(((FabOption) next).mo22797a(i, b.getFabOptionSize(), b.getFabOptionPosition(), b.getFirstFabOptionMarginPx(), b.getSuccessiveFabOptionMarginPx()));
                i = i2;
            }
            List list = (List) arrayList;
            AnimatorSet animatorSet = new AnimatorSet();
            Animator[] animatorArr = new Animator[3];
            Overlay a = jVar.mo22867a();
            if (a == null || (animator = a.mo22818a()) == null) {
                animator = new AnimatorSet();
            }
            animatorArr[0] = animator;
            animatorArr[1] = b.mo22733a(new C2577f(this, jVar, b, list));
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playSequentially(list);
            animatorArr[2] = animatorSet2;
            animatorSet.playTogether(animatorArr);
            animatorSet.addListener(this.f6991h);
            return animatorSet;
        }
        throw new C3266f("null cannot be cast to non-null type com.nambimobile.widgets.efab.ExpandableFab");
    }

    /* renamed from: a */
    private final void m8753a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        C2595j jVar;
        super.addView(view, i, layoutParams);
        if (view != null) {
            Overlay overlay = (Overlay) view;
            overlay.setDefaultOnClickBehavior$expandable_fab_release(new C2575d(this));
            switch (C2586b.f7028a[overlay.getOrientation().ordinal()]) {
                case 1:
                    jVar = this.f6984a;
                    break;
                case 2:
                    jVar = this.f6985b;
                    break;
                default:
                    return;
            }
            jVar.mo22869a(overlay);
            return;
        }
        throw new C3266f("null cannot be cast to non-null type com.nambimobile.widgets.efab.Overlay");
    }

    /* renamed from: b */
    private final Animator m8756b(C2595j jVar) {
        Animator animator;
        ExpandableFab b = jVar.mo22870b();
        if (b != null) {
            Iterable<FabOption> c = jVar.mo22871c();
            Collection arrayList = new ArrayList(C3191g.m8988a(c, 10));
            for (FabOption a : c) {
                arrayList.add(a.mo22796a());
            }
            List list = (List) arrayList;
            AnimatorSet animatorSet = new AnimatorSet();
            Animator[] animatorArr = new Animator[3];
            Overlay a2 = jVar.mo22867a();
            if (a2 == null || (animator = a2.mo22819b()) == null) {
                animator = new AnimatorSet();
            }
            animatorArr[0] = animator;
            animatorArr[1] = b.mo22734b(new C2576e(this, jVar, b, list));
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playSequentially(C3191g.m8991a(list));
            animatorArr[2] = animatorSet2;
            animatorSet.playTogether(animatorArr);
            animatorSet.addListener(this.f6992i);
            return animatorSet;
        }
        throw new C3266f("null cannot be cast to non-null type com.nambimobile.widgets.efab.ExpandableFab");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m8757b() {
        mo22777a();
    }

    /* renamed from: b */
    private final void m8758b(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view != null) {
            ExpandableFab expandableFab = (ExpandableFab) view;
            expandableFab.setDefaultOnClickBehavior$expandable_fab_release(new C2573b(this));
            expandableFab.setOnAnimationStart$expandable_fab_release(new C2572a(this));
            C2590f label = expandableFab.getLabel();
            addView(label);
            ViewGroup.LayoutParams layoutParams2 = label.getLayoutParams();
            if (layoutParams2 != null) {
                CoordinatorLayout.C0474e eVar = (CoordinatorLayout.C0474e) layoutParams2;
                eVar.mo3366a(expandableFab.getId());
                label.setLayoutParams(eVar);
                label.mo22838c();
                switch (C2586b.f7029b[expandableFab.getOrientation().ordinal()]) {
                    case 1:
                        if (this.f6984a.mo22870b() == null) {
                            this.f6984a.mo22868a(expandableFab);
                            expandableFab.show();
                            Resources resources = getResources();
                            C3250h.m9053a((Object) resources, "resources");
                            if (resources.getConfiguration().orientation == 1) {
                                expandableFab = this.f6985b.mo22870b();
                                if (expandableFab == null) {
                                    return;
                                }
                            } else if (this.f6985b.mo22870b() == null) {
                                return;
                            }
                        } else {
                            String string = getResources().getString(C2596k.C2600d.efab_layout_multiple_efabs, new Object[]{expandableFab.getOrientation()});
                            C3250h.m9053a((Object) string, "resources.getString(R.st…_efabs, efab.orientation)");
                            C2585a.m8797a(string, (Throwable) null, 2, (Object) null);
                            throw null;
                        }
                        break;
                    case 2:
                        if (this.f6985b.mo22870b() == null) {
                            this.f6985b.mo22868a(expandableFab);
                            expandableFab.show();
                            Resources resources2 = getResources();
                            C3250h.m9053a((Object) resources2, "resources");
                            if (resources2.getConfiguration().orientation == 2) {
                                expandableFab = this.f6984a.mo22870b();
                                if (expandableFab == null) {
                                    return;
                                }
                            } else if (this.f6984a.mo22870b() == null) {
                                return;
                            }
                        } else {
                            String string2 = getResources().getString(C2596k.C2600d.efab_layout_multiple_efabs, new Object[]{expandableFab.getOrientation()});
                            C3250h.m9053a((Object) string2, "resources.getString(R.st…_efabs, efab.orientation)");
                            C2585a.m8797a(string2, (Throwable) null, 2, (Object) null);
                            throw null;
                        }
                        break;
                    default:
                        return;
                }
                expandableFab.hide();
                return;
            }
            throw new C3266f("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        }
        throw new C3266f("null cannot be cast to non-null type com.nambimobile.widgets.efab.ExpandableFab");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m8761c() {
        if (this.f6988e || !m8766f()) {
            mo22777a();
        } else {
            m8765e();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0081  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m8762c(android.view.View r3, int r4, android.view.ViewGroup.LayoutParams r5) {
        /*
            r2 = this;
            super.addView(r3, r4, r5)
            if (r3 == 0) goto L_0x00a8
            com.nambimobile.widgets.efab.FabOption r3 = (com.nambimobile.widgets.efab.FabOption) r3
            com.nambimobile.widgets.efab.ExpandableFabLayout$c r4 = new com.nambimobile.widgets.efab.ExpandableFabLayout$c
            r5 = r2
            com.nambimobile.widgets.efab.ExpandableFabLayout r5 = (com.nambimobile.widgets.efab.ExpandableFabLayout) r5
            r4.<init>(r5)
            d.d.a.a r4 = (p157d.p161d.p162a.C3218a) r4
            r3.setDefaultOnClickBehavior$expandable_fab_release(r4)
            com.nambimobile.widgets.efab.i r4 = r3.getOrientation()
            int[] r5 = com.nambimobile.widgets.efab.C2586b.f7030c
            int r4 = r4.ordinal()
            r4 = r5[r4]
            switch(r4) {
                case 1: goto L_0x002c;
                case 2: goto L_0x0029;
                default: goto L_0x0023;
            }
        L_0x0023:
            d.c r3 = new d.c
            r3.<init>()
            throw r3
        L_0x0029:
            com.nambimobile.widgets.efab.j r4 = r2.f6985b
            goto L_0x002e
        L_0x002c:
            com.nambimobile.widgets.efab.j r4 = r2.f6984a
        L_0x002e:
            com.nambimobile.widgets.efab.f r5 = r3.getLabel()
            r0 = r5
            android.view.View r0 = (android.view.View) r0
            r2.addView(r0)
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            if (r0 == 0) goto L_0x00a0
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout.C0474e) r0
            int r1 = r3.getId()
            r0.mo3366a((int) r1)
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r5.setLayoutParams(r0)
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            if (r5 == 0) goto L_0x0098
            androidx.coordinatorlayout.widget.CoordinatorLayout$e r5 = (androidx.coordinatorlayout.widget.CoordinatorLayout.C0474e) r5
            java.util.List r0 = r4.mo22871c()
            boolean r0 = r0.isEmpty()
            r1 = 1
            if (r0 != r1) goto L_0x006a
            com.nambimobile.widgets.efab.ExpandableFab r0 = r4.mo22870b()
            if (r0 == 0) goto L_0x007b
            int r0 = r0.getId()
            goto L_0x0078
        L_0x006a:
            java.util.List r0 = r4.mo22871c()
            java.lang.Object r0 = p157d.p158a.C3191g.m8995d(r0)
            com.nambimobile.widgets.efab.FabOption r0 = (com.nambimobile.widgets.efab.FabOption) r0
            int r0 = r0.getId()
        L_0x0078:
            r5.mo3366a((int) r0)
        L_0x007b:
            com.nambimobile.widgets.efab.ExpandableFab r0 = r4.mo22870b()
            if (r0 == 0) goto L_0x008b
            com.nambimobile.widgets.efab.d r0 = r0.getFabOptionPosition()
            int r0 = r0.mo22834a()
            r5.f1895d = r0
        L_0x008b:
            android.view.ViewGroup$LayoutParams r5 = (android.view.ViewGroup.LayoutParams) r5
            r3.setLayoutParams(r5)
            java.util.List r4 = r4.mo22871c()
            r4.add(r3)
            return
        L_0x0098:
            d.f r3 = new d.f
            java.lang.String r4 = "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams"
            r3.<init>(r4)
            throw r3
        L_0x00a0:
            d.f r3 = new d.f
            java.lang.String r4 = "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams"
            r3.<init>(r4)
            throw r3
        L_0x00a8:
            d.f r3 = new d.f
            java.lang.String r4 = "null cannot be cast to non-null type com.nambimobile.widgets.efab.FabOption"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nambimobile.widgets.efab.ExpandableFabLayout.m8762c(android.view.View, int, android.view.ViewGroup$LayoutParams):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final boolean m8764d() {
        if (this.f6990g) {
            return false;
        }
        this.f6990g = true;
        mo22777a();
        return true;
    }

    /* renamed from: e */
    private final void m8765e() {
        if (!this.f6988e) {
            this.f6987d = false;
            m8752a(getCurrentConfiguration()).start();
        }
    }

    /* renamed from: f */
    private final boolean m8766f() {
        return this.f6986c && this.f6987d;
    }

    /* access modifiers changed from: private */
    public final void setState(boolean z) {
        if (!m8766f()) {
            return;
        }
        if (z) {
            this.f6988e = true;
            if (this.f6989f) {
                mo22777a();
                return;
            }
            return;
        }
        this.f6988e = false;
        this.f6989f = false;
        this.f6990g = false;
    }

    /* renamed from: a */
    public final void mo22777a() {
        if (!m8766f()) {
            this.f6989f = true;
        } else if (this.f6988e) {
            this.f6987d = false;
            m8756b(getCurrentConfiguration()).start();
        }
    }

    public void addView(@Nullable View view, int i, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Overlay) {
            m8753a(view, i, layoutParams);
        } else if (view instanceof ExpandableFab) {
            m8758b(view, i, layoutParams);
        } else if (view instanceof FabOption) {
            m8762c(view, i, layoutParams);
        } else {
            super.addView(view, i, layoutParams);
        }
    }

    @NotNull
    public final C2595j getCurrentConfiguration() {
        Resources resources = getResources();
        C3250h.m9053a((Object) resources, "resources");
        return (resources.getConfiguration().orientation == 1 ? this.f6984a.mo22870b() == null : this.f6985b.mo22870b() != null) ? this.f6985b : this.f6984a;
    }

    public final /* synthetic */ boolean getEfabAnimationsFinished$expandable_fab_release() {
        return this.f6986c;
    }

    @NotNull
    public final C2595j getLandscapeConfiguration() {
        return this.f6985b;
    }

    @NotNull
    public final C2595j getPortraitConfiguration() {
        return this.f6984a;
    }

    public void removeAllViews() {
        super.removeAllViews();
        this.f6984a = new C2595j();
        this.f6985b = new C2595j();
        this.f6986c = true;
        this.f6987d = true;
        this.f6988e = false;
        this.f6989f = false;
        this.f6990g = false;
    }

    public final /* synthetic */ void setEfabAnimationsFinished$expandable_fab_release(boolean z) {
        this.f6986c = z;
    }
}
