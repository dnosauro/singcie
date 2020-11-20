package com.nambimobile.widgets.efab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import androidx.appcompat.widget.C0252aa;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.C0529a;
import androidx.core.p030h.C0656u;
import com.nambimobile.widgets.efab.C2596k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.C3214c;
import p157d.C3266f;
import p157d.p161d.p163b.C3250h;

/* renamed from: com.nambimobile.widgets.efab.f */
public final class C2590f extends C0252aa {
    @Nullable

    /* renamed from: a */
    private CharSequence f7042a;

    /* renamed from: b */
    private int f7043b = C0529a.m2102c(getContext(), 17170443);

    /* renamed from: c */
    private float f7044c = getResources().getDimension(C2596k.C2598b.efab_label_text_size);

    /* renamed from: e */
    private int f7045e = C0529a.m2102c(getContext(), C2596k.C2597a.efab_label_background);

    /* renamed from: f */
    private int f7046f = getResources().getDimensionPixelSize(C2596k.C2598b.efab_label_elevation);

    /* renamed from: g */
    private boolean f7047g = true;
    @NotNull

    /* renamed from: h */
    private C2593h f7048h = C2593h.LEFT;

    /* renamed from: i */
    private float f7049i = 50.0f;

    /* renamed from: j */
    private float f7050j = 100.0f;

    /* renamed from: k */
    private long f7051k = 250;

    /* renamed from: l */
    private long f7052l = 75;

    /* renamed from: m */
    private float f7053m = 3.5f;

    /* renamed from: n */
    private final C2591a f7054n = new C2591a(this);

    /* renamed from: com.nambimobile.widgets.efab.f$a */
    public static final class C2591a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ C2590f f7055a;

        C2591a(C2590f fVar) {
            this.f7055a = fVar;
        }

        public void onAnimationEnd(@Nullable Animator animator) {
            this.f7055a.setVisibility(8);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2590f(@NotNull Context context) {
        super(context);
        C3250h.m9056b(context, "context");
        setId(C0656u.m2579a());
        setBackgroundResource(C2596k.C2599c.efab_label_background);
        setVisibility(8);
        setLabelText(this.f7042a);
        setLabelTextColor(this.f7043b);
        setLabelTextSize(this.f7044c);
        setLabelBackgroundColor(this.f7045e);
        setLabelElevation(this.f7046f);
        this.f7048h = this.f7048h;
        setMarginPx(this.f7049i);
        this.f7050j = this.f7050j;
        setVisibleToHiddenAnimationDurationMs(this.f7051k);
        setHiddenToVisibleAnimationDurationMs(this.f7052l);
        setOvershootTension(this.f7053m);
    }

    /* renamed from: e */
    private final void m8802e() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            CoordinatorLayout.C0474e eVar = (CoordinatorLayout.C0474e) layoutParams;
            if (eVar.mo3365a() != -1) {
                eVar.f1895d = this.f7048h.mo22866a();
                eVar.f1894c = this.f7048h.mo22866a();
                setLayoutParams(eVar);
                return;
            }
            return;
        }
        throw new C3266f("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    @NotNull
    /* renamed from: a */
    public final /* synthetic */ Animator mo22836a() {
        float f;
        float f2;
        if (this.f7042a == null) {
            return new AnimatorSet();
        }
        m8802e();
        setAlpha(0.0f);
        setVisibility(0);
        switch (C2592g.f7056a[this.f7048h.ordinal()]) {
            case 1:
                f = -this.f7049i;
                break;
            case 2:
                f = this.f7049i;
                break;
            default:
                throw new C3214c();
        }
        float f3 = f + this.f7050j;
        switch (C2592g.f7057b[this.f7048h.ordinal()]) {
            case 1:
                f2 = -this.f7049i;
                break;
            case 2:
                f2 = this.f7049i;
                break;
            default:
                throw new C3214c();
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", new float[]{f3, f2});
        C3250h.m9053a((Object) ofFloat, "this");
        ofFloat.setDuration(this.f7052l);
        ofFloat.setInterpolator(new OvershootInterpolator(this.f7053m));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f});
        C3250h.m9053a((Object) ofFloat2, "this");
        ofFloat2.setDuration(this.f7052l);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        return animatorSet;
    }

    @NotNull
    /* renamed from: b */
    public final /* synthetic */ Animator mo22837b() {
        if (this.f7042a == null) {
            return new AnimatorSet();
        }
        float translationX = getTranslationX() + this.f7050j;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", new float[]{getTranslationX(), translationX});
        C3250h.m9053a((Object) ofFloat, "this");
        ofFloat.setDuration(this.f7051k);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f});
        C3250h.m9053a((Object) ofFloat2, "this");
        ofFloat2.setDuration(this.f7051k);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.addListener(this.f7054n);
        return animatorSet;
    }

    /* renamed from: c */
    public final /* synthetic */ void mo22838c() {
        float f;
        if (this.f7042a != null) {
            m8802e();
            setVisibility(0);
            switch (C2592g.f7058c[this.f7048h.ordinal()]) {
                case 1:
                    f = -this.f7049i;
                    break;
                case 2:
                    f = this.f7049i;
                    break;
                default:
                    return;
            }
            setTranslationX(f);
        }
    }

    /* renamed from: d */
    public final /* synthetic */ void mo22839d() {
        setVisibility(8);
    }

    public final long getHiddenToVisibleAnimationDurationMs() {
        return this.f7052l;
    }

    public final int getLabelBackgroundColor() {
        return this.f7045e;
    }

    public final int getLabelElevation() {
        return this.f7046f;
    }

    public final /* synthetic */ boolean getLabelEnabled$expandable_fab_release() {
        return this.f7047g;
    }

    @Nullable
    public final CharSequence getLabelText() {
        return this.f7042a;
    }

    public final int getLabelTextColor() {
        return this.f7043b;
    }

    public final float getLabelTextSize() {
        return this.f7044c;
    }

    public final float getMarginPx() {
        return this.f7049i;
    }

    public final float getOvershootTension() {
        return this.f7053m;
    }

    @NotNull
    public final C2593h getPosition() {
        return this.f7048h;
    }

    public final float getTranslationXPx() {
        return this.f7050j;
    }

    public final long getVisibleToHiddenAnimationDurationMs() {
        return this.f7051k;
    }

    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        float f;
        Integer valueOf = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            f = 0.925f;
        } else {
            if (valueOf != null && valueOf.intValue() == 1) {
                f = 1.0f;
            }
            return super.onTouchEvent(motionEvent);
        }
        setScaleX(f);
        setScaleY(f);
        return super.onTouchEvent(motionEvent);
    }

    public final void setHiddenToVisibleAnimationDurationMs(long j) {
        if (j >= 0) {
            this.f7052l = j;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_label_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final void setLabelBackgroundColor(int i) {
        getBackground().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        this.f7045e = i;
    }

    public final void setLabelElevation(int i) {
        if (i >= 0) {
            C0656u.m2583a((View) this, (float) i);
            this.f7046f = i;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_label_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final /* synthetic */ void setLabelEnabled$expandable_fab_release(boolean z) {
        if (z) {
            setLabelBackgroundColor(this.f7045e);
            setLabelTextColor(this.f7043b);
        } else {
            int c = C0529a.m2102c(getContext(), C2596k.C2597a.efab_disabled);
            int c2 = C0529a.m2102c(getContext(), C2596k.C2597a.efab_disabled_text);
            getBackground().setColorFilter(c, PorterDuff.Mode.SRC_ATOP);
            setTextColor(c2);
        }
        setEnabled(z);
        this.f7047g = z;
    }

    public final void setLabelText(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            setVisibility(8);
        }
        if (charSequence != null) {
            setText(charSequence);
        }
        this.f7042a = charSequence;
    }

    public final void setLabelTextColor(int i) {
        setTextColor(i);
        this.f7043b = i;
    }

    public final void setLabelTextSize(float f) {
        setTextSize(0, f);
        this.f7044c = f;
    }

    public final void setMarginPx(float f) {
        if (f >= ((float) 0)) {
            this.f7049i = f;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_label_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final void setOvershootTension(float f) {
        if (f >= ((float) 0)) {
            this.f7053m = f;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_label_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final void setPosition(@NotNull C2593h hVar) {
        C3250h.m9056b(hVar, "<set-?>");
        this.f7048h = hVar;
    }

    public final void setTranslationXPx(float f) {
        this.f7050j = f;
    }

    public final void setVisibleToHiddenAnimationDurationMs(long j) {
        if (j >= 0) {
            this.f7051k = j;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_label_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }
}
