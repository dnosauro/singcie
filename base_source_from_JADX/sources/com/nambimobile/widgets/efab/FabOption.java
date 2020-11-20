package com.nambimobile.widgets.efab;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import androidx.core.content.C0529a;
import androidx.core.p030h.C0656u;
import androidx.core.widget.C0683e;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nambimobile.widgets.efab.C2596k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.C3214c;
import p157d.C3216d;
import p157d.p161d.p162a.C3218a;
import p157d.p161d.p163b.C3250h;

public final class FabOption extends FloatingActionButton {
    @NotNull

    /* renamed from: a */
    private C2594i f7004a = C2594i.PORTRAIT;

    /* renamed from: b */
    private int f7005b;
    @Nullable

    /* renamed from: c */
    private Drawable f7006c;

    /* renamed from: d */
    private boolean f7007d;

    /* renamed from: e */
    private long f7008e;

    /* renamed from: f */
    private long f7009f;

    /* renamed from: g */
    private float f7010g;
    @NotNull

    /* renamed from: h */
    private final C2590f f7011h;
    @Nullable

    /* renamed from: i */
    private C3218a<Boolean> f7012i;

    /* renamed from: j */
    private final C2580a f7013j;

    /* renamed from: com.nambimobile.widgets.efab.FabOption$a */
    public static final class C2580a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ FabOption f7014a;

        C2580a(FabOption fabOption) {
            this.f7014a = fabOption;
        }

        public void onAnimationEnd(@Nullable Animator animator) {
            this.f7014a.setVisibility(8);
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.FabOption$b */
    static final class C2581b implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ FabOption f7015a;

        C2581b(FabOption fabOption) {
            this.f7015a = fabOption;
        }

        public final void onClick(View view) {
            this.f7015a.callOnClick();
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.FabOption$c */
    static final class C2582c implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ FabOption f7016a;

        /* renamed from: b */
        final /* synthetic */ View.OnClickListener f7017b;

        C2582c(FabOption fabOption, View.OnClickListener onClickListener) {
            this.f7016a = fabOption;
            this.f7017b = onClickListener;
        }

        public final void onClick(View view) {
            View.OnClickListener onClickListener;
            C3218a<Boolean> defaultOnClickBehavior$expandable_fab_release = this.f7016a.getDefaultOnClickBehavior$expandable_fab_release();
            Boolean a = defaultOnClickBehavior$expandable_fab_release != null ? defaultOnClickBehavior$expandable_fab_release.mo22768a() : null;
            if ((a != null ? a.booleanValue() : false) && (onClickListener = this.f7017b) != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FabOption(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        AttributeSet attributeSet2 = attributeSet;
        C3250h.m9056b(context, "context");
        C3250h.m9056b(attributeSet2, "attributeSet");
        Context context2 = getContext();
        C3250h.m9053a((Object) context2, "context");
        this.f7005b = C2602l.m8813a(context2);
        this.f7007d = true;
        this.f7008e = 125;
        this.f7009f = 75;
        this.f7010g = 3.5f;
        Context context3 = getContext();
        C3250h.m9053a((Object) context3, "context");
        C2590f fVar = new C2590f(context3);
        fVar.setLabelText((CharSequence) null);
        fVar.setLabelTextColor(C0529a.m2102c(fVar.getContext(), 17170443));
        fVar.setLabelTextSize(fVar.getResources().getDimension(C2596k.C2598b.efab_label_text_size));
        fVar.setLabelBackgroundColor(C0529a.m2102c(fVar.getContext(), C2596k.C2597a.efab_label_background));
        fVar.setLabelElevation(fVar.getResources().getDimensionPixelSize(C2596k.C2598b.efab_label_elevation));
        fVar.setPosition(C2593h.LEFT);
        fVar.setMarginPx(50.0f);
        fVar.setTranslationXPx(100.0f);
        fVar.setVisibleToHiddenAnimationDurationMs(75);
        fVar.setHiddenToVisibleAnimationDurationMs(250);
        fVar.setOvershootTension(3.5f);
        this.f7011h = fVar;
        this.f7013j = new C2580a(this);
        if (getId() == -1) {
            setId(C0656u.m2579a());
        }
        C0683e.m2791a((ImageView) this, (ColorStateList) null);
        setVisibility(8);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, C2596k.C2601e.FabOption, 0, 0);
        try {
            int i = obtainStyledAttributes.getInt(C2596k.C2601e.FabOption_label_position, C2593h.LEFT.ordinal());
            String string = obtainStyledAttributes.getString(C2596k.C2601e.FabOption_label_visibleToHiddenAnimationDurationMs);
            long parseLong = string != null ? Long.parseLong(string) : this.f7011h.getVisibleToHiddenAnimationDurationMs();
            String string2 = obtainStyledAttributes.getString(C2596k.C2601e.FabOption_label_hiddenToVisibleAnimationDurationMs);
            long parseLong2 = string2 != null ? Long.parseLong(string2) : this.f7011h.getHiddenToVisibleAnimationDurationMs();
            C2590f fVar2 = this.f7011h;
            fVar2.setLabelText(obtainStyledAttributes.getString(C2596k.C2601e.FabOption_label_text));
            fVar2.setLabelTextColor(obtainStyledAttributes.getColor(C2596k.C2601e.FabOption_label_textColor, this.f7011h.getLabelTextColor()));
            fVar2.setLabelTextSize(obtainStyledAttributes.getDimension(C2596k.C2601e.FabOption_label_textSize, this.f7011h.getLabelTextSize()));
            fVar2.setLabelBackgroundColor(obtainStyledAttributes.getColor(C2596k.C2601e.FabOption_label_backgroundColor, this.f7011h.getLabelBackgroundColor()));
            fVar2.setLabelElevation(obtainStyledAttributes.getDimensionPixelSize(C2596k.C2601e.FabOption_label_elevation, this.f7011h.getLabelElevation()));
            fVar2.setPosition(C2593h.values()[i]);
            fVar2.setMarginPx(obtainStyledAttributes.getFloat(C2596k.C2601e.FabOption_label_marginPx, this.f7011h.getMarginPx()));
            fVar2.setVisibleToHiddenAnimationDurationMs(parseLong);
            fVar2.setHiddenToVisibleAnimationDurationMs(parseLong2);
            fVar2.setOvershootTension(obtainStyledAttributes.getFloat(C2596k.C2601e.FabOption_label_overshootTension, this.f7011h.getOvershootTension()));
            fVar2.setTranslationXPx(obtainStyledAttributes.getFloat(C2596k.C2601e.FabOption_label_translationXPx, this.f7011h.getTranslationXPx()));
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet2, C2596k.C2601e.FabOption, 0, 0);
            try {
                int i2 = obtainStyledAttributes2.getInt(C2596k.C2601e.FabOption_fab_orientation, C2594i.PORTRAIT.ordinal());
                String string3 = obtainStyledAttributes2.getString(C2596k.C2601e.FabOption_fab_openingAnimationDurationMs);
                long parseLong3 = string3 != null ? Long.parseLong(string3) : this.f7008e;
                String string4 = obtainStyledAttributes2.getString(C2596k.C2601e.FabOption_fab_closingAnimationDurationMs);
                m8789a(C2594i.values()[i2], obtainStyledAttributes2.getColor(C2596k.C2601e.FabOption_fab_color, this.f7005b), obtainStyledAttributes2.getDrawable(C2596k.C2601e.FabOption_fab_icon), obtainStyledAttributes2.getBoolean(C2596k.C2601e.FabOption_fab_enabled, true), parseLong3, string4 != null ? Long.parseLong(string4) : this.f7009f, obtainStyledAttributes2.getFloat(C2596k.C2601e.FabOption_fab_openingOvershootTension, this.f7010g));
                obtainStyledAttributes2.recycle();
            } catch (Exception e) {
                String string5 = obtainStyledAttributes2.getResources().getString(C2596k.C2600d.efab_faboption_illegal_optional_properties);
                C3250h.m9053a((Object) string5, "resources.getString(R.st…egal_optional_properties)");
                C2585a.m8798b(string5, e);
                throw null;
            } catch (Throwable th) {
                obtainStyledAttributes2.recycle();
                throw th;
            }
        } catch (Exception e2) {
            String string6 = obtainStyledAttributes.getResources().getString(C2596k.C2600d.efab_label_illegal_optional_properties);
            C3250h.m9053a((Object) string6, "resources.getString(R.st…egal_optional_properties)");
            C2585a.m8798b(string6, e2);
            throw null;
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    /* renamed from: a */
    private final void m8789a(C2594i iVar, int i, Drawable drawable, boolean z, long j, long j2, float f) {
        this.f7004a = iVar;
        setFabOptionColor(i);
        if (drawable != null) {
            setFabOptionIcon(drawable);
        }
        setFabOptionEnabled(z);
        setOpeningAnimationDurationMs(j);
        setClosingAnimationDurationMs(j2);
        setOpeningOvershootTension(f);
        if (hasOnClickListeners()) {
            m8790b();
        } else {
            setOnClickListener((View.OnClickListener) null);
        }
    }

    /* renamed from: b */
    private final void m8790b() {
        C2590f fVar = this.f7011h;
        if (fVar != null) {
            fVar.setOnClickListener(new C2581b(this));
        }
    }

    @NotNull
    /* renamed from: a */
    public final /* synthetic */ Animator mo22796a() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", new float[]{0.0f});
        C3250h.m9053a((Object) ofFloat, "this");
        ofFloat.setDuration(this.f7009f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{0.0f});
        C3250h.m9053a((Object) ofFloat2, "this");
        ofFloat2.setDuration(this.f7009f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f});
        C3250h.m9053a((Object) ofFloat3, "this");
        ofFloat3.setDuration(this.f7009f);
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        animatorSet.addListener(this.f7013j);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(new Animator[]{animatorSet, this.f7011h.mo22837b()});
        return animatorSet2;
    }

    @NotNull
    /* renamed from: a */
    public final /* synthetic */ Animator mo22797a(int i, @NotNull C2589e eVar, @NotNull C2588d dVar, float f, float f2) {
        C3216d dVar2;
        ObjectAnimator objectAnimator;
        C3250h.m9056b(eVar, "size");
        C3250h.m9056b(dVar, "position");
        setAlpha(0.0f);
        setVisibility(0);
        setSize(eVar.mo22835a());
        switch (C2587c.f7031a[dVar.ordinal()]) {
            case 1:
                dVar2 = new C3216d(Float.valueOf(-f), Float.valueOf(-f2));
                break;
            case 2:
                dVar2 = new C3216d(Float.valueOf(f), Float.valueOf(f2));
                break;
            default:
                throw new C3214c();
        }
        float floatValue = ((Number) dVar2.mo25684c()).floatValue();
        float floatValue2 = ((Number) dVar2.mo25685d()).floatValue();
        AnimatorSet animatorSet = new AnimatorSet();
        Animator[] animatorArr = new Animator[4];
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "scaleX", new float[]{0.0f, 1.0f});
        C3250h.m9053a((Object) ofFloat, "this");
        ofFloat.setDuration(this.f7008e);
        ofFloat.setInterpolator(new OvershootInterpolator(this.f7010g));
        animatorArr[0] = ofFloat;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{0.0f, 1.0f});
        C3250h.m9053a((Object) ofFloat2, "this");
        ofFloat2.setDuration(this.f7008e);
        ofFloat2.setInterpolator(new OvershootInterpolator(this.f7010g));
        animatorArr[1] = ofFloat2;
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f});
        C3250h.m9053a((Object) ofFloat3, "this");
        ofFloat3.setDuration(this.f7008e);
        animatorArr[2] = ofFloat3;
        if (i == 0) {
            objectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[]{floatValue});
        } else {
            objectAnimator = ObjectAnimator.ofFloat(this, "translationY", new float[]{floatValue2});
        }
        C3250h.m9053a((Object) objectAnimator, "this");
        objectAnimator.setDuration(1);
        animatorArr[3] = objectAnimator;
        animatorSet.playTogether(animatorArr);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(new Animator[]{animatorSet, this.f7011h.mo22836a()});
        return animatorSet2;
    }

    public final long getClosingAnimationDurationMs() {
        return this.f7009f;
    }

    @Nullable
    public final /* synthetic */ C3218a<Boolean> getDefaultOnClickBehavior$expandable_fab_release() {
        C3218a<Boolean> aVar = this.f7012i;
        if (aVar != null) {
            return aVar;
        }
        String string = getResources().getString(C2596k.C2600d.efab_layout_must_be_child_of_expandablefab_layout);
        C3250h.m9053a((Object) string, "resources.getString(R.st…_of_expandablefab_layout)");
        C2585a.m8797a(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final int getFabOptionColor() {
        return this.f7005b;
    }

    public final boolean getFabOptionEnabled() {
        return this.f7007d;
    }

    @Nullable
    public final Drawable getFabOptionIcon() {
        return this.f7006c;
    }

    @NotNull
    public final C2590f getLabel() {
        return this.f7011h;
    }

    public final long getOpeningAnimationDurationMs() {
        return this.f7008e;
    }

    public final float getOpeningOvershootTension() {
        return this.f7010g;
    }

    @NotNull
    public final C2594i getOrientation() {
        return this.f7004a;
    }

    public final void setClosingAnimationDurationMs(long j) {
        if (j >= 0) {
            this.f7009f = j;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_faboption_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final /* synthetic */ void setDefaultOnClickBehavior$expandable_fab_release(@Nullable C3218a<Boolean> aVar) {
        this.f7012i = aVar;
    }

    public final void setFabOptionColor(int i) {
        setBackgroundTintList(ColorStateList.valueOf(i));
        this.f7005b = i;
    }

    public final void setFabOptionEnabled(boolean z) {
        if (z) {
            setFabOptionColor(this.f7005b);
        } else {
            setBackgroundTintList(ColorStateList.valueOf(C0529a.m2102c(getContext(), C2596k.C2597a.efab_disabled)));
        }
        setEnabled(z);
        this.f7011h.setLabelEnabled$expandable_fab_release(z);
        this.f7007d = z;
    }

    public final void setFabOptionIcon(@Nullable Drawable drawable) {
        setImageDrawable(drawable);
        this.f7006c = drawable;
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(new C2582c(this, onClickListener));
        m8790b();
    }

    public final void setOpeningAnimationDurationMs(long j) {
        if (j >= 0) {
            this.f7008e = j;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_faboption_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final void setOpeningOvershootTension(float f) {
        if (f >= ((float) 0)) {
            this.f7010g = f;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_faboption_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public void setSize(int i) {
        if (i != C2589e.CUSTOM.mo22835a()) {
            super.setSize(i);
        }
    }
}
