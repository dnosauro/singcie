package com.nambimobile.widgets.efab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.C0529a;
import androidx.core.p030h.C0656u;
import com.nambimobile.widgets.efab.C2596k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.C3291h;
import p157d.p161d.p162a.C3218a;
import p157d.p161d.p163b.C3250h;

public final class Overlay extends FrameLayout {
    @NotNull

    /* renamed from: a */
    private C2594i f7018a = C2594i.PORTRAIT;

    /* renamed from: b */
    private int f7019b = C0529a.m2102c(getContext(), 17170443);

    /* renamed from: c */
    private float f7020c = 0.78431f;

    /* renamed from: d */
    private long f7021d = 300;

    /* renamed from: e */
    private long f7022e = 300;
    @Nullable

    /* renamed from: f */
    private C3218a<C3291h> f7023f;

    /* renamed from: g */
    private final C2583a f7024g = new C2583a(this);

    /* renamed from: com.nambimobile.widgets.efab.Overlay$a */
    public static final class C2583a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ Overlay f7025a;

        C2583a(Overlay overlay) {
            this.f7025a = overlay;
        }

        public void onAnimationEnd(@Nullable Animator animator) {
            this.f7025a.setVisibility(8);
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.Overlay$b */
    static final class C2584b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ Overlay f7026a;

        /* renamed from: b */
        final /* synthetic */ View.OnClickListener f7027b;

        C2584b(Overlay overlay, View.OnClickListener onClickListener) {
            this.f7026a = overlay;
            this.f7027b = onClickListener;
        }

        public final void onClick(View view) {
            C3218a<C3291h> defaultOnClickBehavior$expandable_fab_release = this.f7026a.getDefaultOnClickBehavior$expandable_fab_release();
            if (defaultOnClickBehavior$expandable_fab_release != null) {
                C3291h a = defaultOnClickBehavior$expandable_fab_release.mo22768a();
            }
            View.OnClickListener onClickListener = this.f7027b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Overlay(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        C3250h.m9056b(context, "context");
        C3250h.m9056b(attributeSet, "attributeSet");
        if (getId() == -1) {
            setId(C0656u.m2579a());
        }
        setVisibility(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C2596k.C2601e.Overlay, 0, 0);
        try {
            int i = obtainStyledAttributes.getInt(C2596k.C2601e.Overlay_overlay_orientation, C2594i.PORTRAIT.ordinal());
            String string = obtainStyledAttributes.getString(C2596k.C2601e.Overlay_overlay_openingAnimationDurationMs);
            long parseLong = string != null ? Long.parseLong(string) : this.f7021d;
            String string2 = obtainStyledAttributes.getString(C2596k.C2601e.Overlay_overlay_closingAnimationDurationMs);
            m8793a(C2594i.values()[i], obtainStyledAttributes.getColor(C2596k.C2601e.Overlay_overlay_color, this.f7019b), obtainStyledAttributes.getFloat(C2596k.C2601e.Overlay_overlay_alpha, this.f7020c), parseLong, string2 != null ? Long.parseLong(string2) : this.f7022e);
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
            String string3 = obtainStyledAttributes.getResources().getString(C2596k.C2600d.efab_overlay_illegal_optional_properties);
            C3250h.m9053a((Object) string3, "resources.getString(R.st…egal_optional_properties)");
            C2585a.m8798b(string3, e);
            throw null;
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* renamed from: a */
    private final void m8793a(C2594i iVar, int i, float f, long j, long j2) {
        this.f7018a = iVar;
        setOverlayAlpha(f);
        setOverlayColor(i);
        setOpeningAnimationDurationMs(j);
        setClosingAnimationDurationMs(j2);
        if (!hasOnClickListeners()) {
            setOnClickListener((View.OnClickListener) null);
        }
    }

    @NotNull
    /* renamed from: a */
    public final /* synthetic */ Animator mo22818a() {
        setAlpha(0.0f);
        setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, this.f7020c});
        C3250h.m9053a((Object) ofFloat, "this");
        ofFloat.setDuration(this.f7021d);
        C3250h.m9053a((Object) ofFloat, "ObjectAnimator.ofFloat(t…ationDurationMs\n        }");
        return ofFloat;
    }

    @NotNull
    /* renamed from: b */
    public final /* synthetic */ Animator mo22819b() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f});
        C3250h.m9053a((Object) ofFloat, "this");
        ofFloat.setDuration(this.f7022e);
        ofFloat.addListener(this.f7024g);
        C3250h.m9053a((Object) ofFloat, "ObjectAnimator.ofFloat(t…OnAnimationEnd)\n        }");
        return ofFloat;
    }

    public final long getClosingAnimationDurationMs() {
        return this.f7022e;
    }

    @Nullable
    public final /* synthetic */ C3218a<C3291h> getDefaultOnClickBehavior$expandable_fab_release() {
        C3218a<C3291h> aVar = this.f7023f;
        if (aVar != null) {
            return aVar;
        }
        String string = getResources().getString(C2596k.C2600d.efab_layout_must_be_child_of_expandablefab_layout);
        C3250h.m9053a((Object) string, "resources.getString(R.st…_of_expandablefab_layout)");
        C2585a.m8797a(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final long getOpeningAnimationDurationMs() {
        return this.f7021d;
    }

    @NotNull
    public final C2594i getOrientation() {
        return this.f7018a;
    }

    public final float getOverlayAlpha() {
        return this.f7020c;
    }

    public final int getOverlayColor() {
        return this.f7019b;
    }

    public final void setClosingAnimationDurationMs(long j) {
        if (j >= 0) {
            this.f7022e = j;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_overlay_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final /* synthetic */ void setDefaultOnClickBehavior$expandable_fab_release(@Nullable C3218a<C3291h> aVar) {
        this.f7023f = aVar;
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(new C2584b(this, onClickListener));
    }

    public final void setOpeningAnimationDurationMs(long j) {
        if (j >= 0) {
            this.f7021d = j;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_overlay_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final void setOverlayAlpha(float f) {
        setAlpha(f);
        this.f7020c = f;
    }

    public final void setOverlayColor(int i) {
        setBackgroundColor(i);
        this.f7019b = i;
    }
}
