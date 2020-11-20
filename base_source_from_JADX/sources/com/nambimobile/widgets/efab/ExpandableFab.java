package com.nambimobile.widgets.efab;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.C0529a;
import androidx.core.p030h.C0656u;
import androidx.core.widget.C0683e;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nambimobile.widgets.efab.C2596k;
import java.util.Timer;
import java.util.TimerTask;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.C3291h;
import p157d.p159b.C3213a;
import p157d.p161d.p162a.C3218a;
import p157d.p161d.p162a.C3230m;
import p157d.p161d.p163b.C3250h;
import p157d.p161d.p163b.C3251i;
import p157d.p161d.p163b.C3252j;

public final class ExpandableFab extends FloatingActionButton {
    @NotNull

    /* renamed from: a */
    private C2594i f6943a = C2594i.PORTRAIT;

    /* renamed from: b */
    private int f6944b;
    @Nullable

    /* renamed from: c */
    private Drawable f6945c;
    @NotNull

    /* renamed from: d */
    private C2589e f6946d;

    /* renamed from: e */
    private boolean f6947e;

    /* renamed from: f */
    private float f6948f;
    @NotNull

    /* renamed from: g */
    private C2589e f6949g;
    @NotNull

    /* renamed from: h */
    private C2588d f6950h;

    /* renamed from: i */
    private float f6951i;

    /* renamed from: j */
    private float f6952j;

    /* renamed from: k */
    private long f6953k;

    /* renamed from: l */
    private long f6954l;

    /* renamed from: m */
    private float f6955m;
    @NotNull

    /* renamed from: n */
    private final C2590f f6956n;
    @Nullable

    /* renamed from: o */
    private C3218a<C3291h> f6957o;
    @Nullable

    /* renamed from: p */
    private C3218a<C3291h> f6958p;

    /* renamed from: q */
    private Timer f6959q;

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFab$a */
    static final class C2562a extends C3251i implements C3230m<Long, Float, C3291h> {

        /* renamed from: a */
        final /* synthetic */ ExpandableFab f6960a;

        /* renamed from: b */
        final /* synthetic */ boolean f6961b;

        /* renamed from: c */
        final /* synthetic */ C3218a f6962c;

        /* renamed from: com.nambimobile.widgets.efab.ExpandableFab$a$a */
        public static final class C2563a extends TimerTask {

            /* renamed from: a */
            final /* synthetic */ C2562a f6963a;

            /* renamed from: b */
            final /* synthetic */ long f6964b;

            /* renamed from: c */
            final /* synthetic */ float f6965c;

            /* renamed from: com.nambimobile.widgets.efab.ExpandableFab$a$a$a */
            static final class C2564a extends C3251i implements C3218a<C3291h> {

                /* renamed from: a */
                final /* synthetic */ C2563a f6966a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C2564a(C2563a aVar) {
                    super(0);
                    this.f6966a = aVar;
                }

                /* renamed from: a */
                public /* synthetic */ Object mo22768a() {
                    mo22769b();
                    return C3291h.f7327a;
                }

                /* renamed from: b */
                public final void mo22769b() {
                    this.f6966a.f6963a.f6962c.mo22768a();
                }
            }

            public C2563a(C2562a aVar, long j, float f) {
                this.f6963a = aVar;
                this.f6964b = j;
                this.f6965c = f;
            }

            public void run() {
                TimerTask timerTask = this;
                this.f6963a.f6960a.m8740a(this.f6964b, this.f6965c, 0.0f, new C2564a(this));
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2562a(ExpandableFab expandableFab, boolean z, C3218a aVar) {
            super(2);
            this.f6960a = expandableFab;
            this.f6961b = z;
            this.f6962c = aVar;
        }

        /* renamed from: a */
        public final void mo22766a(long j, float f) {
            new Timer().schedule(new C2563a(this, j, f), this.f6961b ? 100 : 0);
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFab$b */
    static final class C2565b extends C3251i implements C3218a<C3291h> {

        /* renamed from: a */
        final /* synthetic */ ExpandableFab f6967a;

        /* renamed from: b */
        final /* synthetic */ C2562a f6968b;

        /* renamed from: c */
        final /* synthetic */ long f6969c;

        /* renamed from: d */
        final /* synthetic */ float f6970d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2565b(ExpandableFab expandableFab, C2562a aVar, long j, float f) {
            super(0);
            this.f6967a = expandableFab;
            this.f6968b = aVar;
            this.f6969c = j;
            this.f6970d = f;
        }

        /* renamed from: a */
        public /* synthetic */ Object mo22768a() {
            mo22770b();
            return C3291h.f7327a;
        }

        /* renamed from: b */
        public final void mo22770b() {
            this.f6968b.mo22766a(this.f6967a.getClosingAnimationDurationMs() - this.f6969c, this.f6970d);
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFab$c */
    public static final class C2566c extends TimerTask {

        /* renamed from: a */
        final /* synthetic */ ExpandableFab f6971a;

        /* renamed from: b */
        final /* synthetic */ C3252j.C3253a f6972b;

        /* renamed from: c */
        final /* synthetic */ float f6973c;

        /* renamed from: d */
        final /* synthetic */ float f6974d;

        /* renamed from: e */
        final /* synthetic */ Matrix f6975e;

        /* renamed from: f */
        final /* synthetic */ double f6976f;

        /* renamed from: g */
        final /* synthetic */ C3218a f6977g;

        /* renamed from: com.nambimobile.widgets.efab.ExpandableFab$c$a */
        static final class C2567a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C2566c f6978a;

            C2567a(C2566c cVar) {
                this.f6978a = cVar;
            }

            public final void run() {
                Drawable drawable = this.f6978a.f6971a.getDrawable();
                if (drawable != null) {
                    this.f6978a.f6975e.reset();
                    this.f6978a.f6971a.setScaleType(ImageView.ScaleType.MATRIX);
                    this.f6978a.f6975e.postRotate(this.f6978a.f6972b.f7304a, (float) (drawable.getBounds().width() / 2), (float) (drawable.getBounds().height() / 2));
                    this.f6978a.f6971a.setImageMatrix(this.f6978a.f6975e);
                }
            }
        }

        /* renamed from: com.nambimobile.widgets.efab.ExpandableFab$c$b */
        static final class C2568b implements Runnable {

            /* renamed from: a */
            final /* synthetic */ C2566c f6979a;

            C2568b(C2566c cVar) {
                this.f6979a = cVar;
            }

            public final void run() {
                this.f6979a.f6977g.mo22768a();
            }
        }

        public C2566c(ExpandableFab expandableFab, C3252j.C3253a aVar, float f, float f2, Matrix matrix, double d, C3218a aVar2) {
            this.f6971a = expandableFab;
            this.f6972b = aVar;
            this.f6973c = f;
            this.f6974d = f2;
            this.f6975e = matrix;
            this.f6976f = d;
            this.f6977g = aVar2;
        }

        public void run() {
            float f;
            TimerTask timerTask = this;
            C3252j.C3253a aVar = this.f6972b;
            if (this.f6973c > aVar.f7304a) {
                this.f6972b.f7304a += this.f6974d;
                f = Math.min(this.f6972b.f7304a, this.f6973c);
            } else {
                this.f6972b.f7304a -= this.f6974d;
                f = Math.max(this.f6972b.f7304a, this.f6973c);
            }
            aVar.f7304a = f;
            this.f6971a.post(new C2567a(this));
            if (((double) Math.abs(this.f6973c - this.f6972b.f7304a)) < this.f6976f) {
                timerTask.cancel();
                this.f6971a.post(new C2568b(this));
            }
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFab$d */
    static final class C2569d extends C3251i implements C3218a<C3291h> {

        /* renamed from: a */
        final /* synthetic */ C3218a f6980a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2569d(C3218a aVar) {
            super(0);
            this.f6980a = aVar;
        }

        /* renamed from: a */
        public /* synthetic */ Object mo22768a() {
            mo22774b();
            return C3291h.f7327a;
        }

        /* renamed from: b */
        public final void mo22774b() {
            this.f6980a.mo22768a();
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFab$e */
    static final class C2570e implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ ExpandableFab f6981a;

        C2570e(ExpandableFab expandableFab) {
            this.f6981a = expandableFab;
        }

        public final void onClick(View view) {
            this.f6981a.callOnClick();
        }
    }

    /* renamed from: com.nambimobile.widgets.efab.ExpandableFab$f */
    static final class C2571f implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ ExpandableFab f6982a;

        /* renamed from: b */
        final /* synthetic */ View.OnClickListener f6983b;

        C2571f(ExpandableFab expandableFab, View.OnClickListener onClickListener) {
            this.f6982a = expandableFab;
            this.f6983b = onClickListener;
        }

        public final void onClick(View view) {
            C3218a<C3291h> defaultOnClickBehavior$expandable_fab_release = this.f6982a.getDefaultOnClickBehavior$expandable_fab_release();
            if (defaultOnClickBehavior$expandable_fab_release != null) {
                C3291h a = defaultOnClickBehavior$expandable_fab_release.mo22768a();
            }
            View.OnClickListener onClickListener = this.f6983b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandableFab(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArray;
        Throwable th;
        AttributeSet attributeSet2 = attributeSet;
        C3250h.m9056b(context, "context");
        C3250h.m9056b(attributeSet2, "attributeSet");
        Context context2 = getContext();
        C3250h.m9053a((Object) context2, "context");
        this.f6944b = C2602l.m8813a(context2);
        this.f6945c = C0529a.m2093a(getContext(), C2596k.C2599c.ic_plus_white_24dp);
        this.f6946d = C2589e.NORMAL;
        this.f6947e = true;
        this.f6948f = -135.0f;
        this.f6949g = C2589e.MINI;
        this.f6950h = C2588d.ABOVE;
        this.f6951i = 80.0f;
        this.f6952j = 75.0f;
        this.f6953k = 250;
        this.f6954l = 500;
        this.f6955m = 2.0f;
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
        fVar.setVisibleToHiddenAnimationDurationMs(125);
        fVar.setHiddenToVisibleAnimationDurationMs(250);
        fVar.setOvershootTension(3.5f);
        this.f6956n = fVar;
        if (getId() == -1) {
            setId(C0656u.m2579a());
        }
        C0683e.m2791a((ImageView) this, (ColorStateList) null);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, C2596k.C2601e.ExpandableFab, 0, 0);
        try {
            int i = obtainStyledAttributes.getInt(C2596k.C2601e.ExpandableFab_label_position, C2593h.LEFT.ordinal());
            String string = obtainStyledAttributes.getString(C2596k.C2601e.ExpandableFab_label_visibleToHiddenAnimationDurationMs);
            long parseLong = string != null ? Long.parseLong(string) : this.f6956n.getVisibleToHiddenAnimationDurationMs();
            String string2 = obtainStyledAttributes.getString(C2596k.C2601e.ExpandableFab_label_hiddenToVisibleAnimationDurationMs);
            long parseLong2 = string2 != null ? Long.parseLong(string2) : this.f6956n.getHiddenToVisibleAnimationDurationMs();
            C2590f fVar2 = this.f6956n;
            fVar2.setLabelText(obtainStyledAttributes.getString(C2596k.C2601e.ExpandableFab_label_text));
            fVar2.setLabelTextColor(obtainStyledAttributes.getColor(C2596k.C2601e.ExpandableFab_label_textColor, this.f6956n.getLabelTextColor()));
            fVar2.setLabelTextSize(obtainStyledAttributes.getDimension(C2596k.C2601e.ExpandableFab_label_textSize, this.f6956n.getLabelTextSize()));
            fVar2.setLabelBackgroundColor(obtainStyledAttributes.getColor(C2596k.C2601e.ExpandableFab_label_backgroundColor, this.f6956n.getLabelBackgroundColor()));
            fVar2.setLabelElevation(obtainStyledAttributes.getDimensionPixelSize(C2596k.C2601e.ExpandableFab_label_elevation, this.f6956n.getLabelElevation()));
            fVar2.setPosition(C2593h.values()[i]);
            fVar2.setMarginPx(obtainStyledAttributes.getFloat(C2596k.C2601e.ExpandableFab_label_marginPx, this.f6956n.getMarginPx()));
            fVar2.setVisibleToHiddenAnimationDurationMs(parseLong);
            fVar2.setHiddenToVisibleAnimationDurationMs(parseLong2);
            fVar2.setOvershootTension(obtainStyledAttributes.getFloat(C2596k.C2601e.ExpandableFab_label_overshootTension, this.f6956n.getOvershootTension()));
            fVar2.setTranslationXPx(obtainStyledAttributes.getFloat(C2596k.C2601e.ExpandableFab_label_translationXPx, this.f6956n.getTranslationXPx()));
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(attributeSet2, C2596k.C2601e.ExpandableFab, 0, 0);
            try {
                int i2 = obtainStyledAttributes2.getInt(C2596k.C2601e.ExpandableFab_efab_orientation, C2594i.PORTRAIT.ordinal());
                int i3 = obtainStyledAttributes2.getInt(C2596k.C2601e.ExpandableFab_efab_fabOptionPosition, C2588d.ABOVE.ordinal());
                int i4 = obtainStyledAttributes2.getInt(C2596k.C2601e.ExpandableFab_efab_size, C2589e.NORMAL.ordinal());
                int i5 = obtainStyledAttributes2.getInt(C2596k.C2601e.ExpandableFab_efab_fabOptionSize, C2589e.MINI.ordinal());
                String string3 = obtainStyledAttributes2.getString(C2596k.C2601e.ExpandableFab_efab_openingAnimationDurationMs);
                long parseLong3 = string3 != null ? Long.parseLong(string3) : this.f6953k;
                String string4 = obtainStyledAttributes2.getString(C2596k.C2601e.ExpandableFab_efab_closingAnimationDurationMs);
                long parseLong4 = string4 != null ? Long.parseLong(string4) : this.f6954l;
                C2594i iVar = C2594i.values()[i2];
                int color = obtainStyledAttributes2.getColor(C2596k.C2601e.ExpandableFab_efab_color, this.f6944b);
                Drawable drawable = obtainStyledAttributes2.getDrawable(C2596k.C2601e.ExpandableFab_efab_icon);
                if (drawable == null) {
                    drawable = this.f6945c;
                }
                typedArray = obtainStyledAttributes2;
                th = null;
                try {
                    m8742a(iVar, color, drawable, C2589e.values()[i4], obtainStyledAttributes2.getBoolean(C2596k.C2601e.ExpandableFab_efab_enabled, true), obtainStyledAttributes2.getFloat(C2596k.C2601e.ExpandableFab_efab_iconAnimationRotationDeg, this.f6948f), C2589e.values()[i5], C2588d.values()[i3], obtainStyledAttributes2.getFloat(C2596k.C2601e.ExpandableFab_efab_firstFabOptionMarginPx, this.f6951i), obtainStyledAttributes2.getFloat(C2596k.C2601e.ExpandableFab_efab_successiveFabOptionMarginPx, this.f6952j), parseLong3, parseLong4, obtainStyledAttributes2.getFloat(C2596k.C2601e.ExpandableFab_efab_closingAnticipateTension, this.f6955m));
                    typedArray.recycle();
                } catch (Exception e) {
                    e = e;
                    try {
                        String string5 = typedArray.getResources().getString(C2596k.C2600d.efab_efab_illegal_optional_properties);
                        C3250h.m9053a((Object) string5, "resources.getString(R.st…egal_optional_properties)");
                        C2585a.m8798b(string5, e);
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                        typedArray.recycle();
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                typedArray = obtainStyledAttributes2;
                th = null;
                String string52 = typedArray.getResources().getString(C2596k.C2600d.efab_efab_illegal_optional_properties);
                C3250h.m9053a((Object) string52, "resources.getString(R.st…egal_optional_properties)");
                C2585a.m8798b(string52, e);
                throw th;
            } catch (Throwable th3) {
                th = th3;
                typedArray = obtainStyledAttributes2;
                typedArray.recycle();
                throw th;
            }
        } catch (Exception e3) {
            String string6 = obtainStyledAttributes.getResources().getString(C2596k.C2600d.efab_label_illegal_optional_properties);
            C3250h.m9053a((Object) string6, "resources.getString(R.st…egal_optional_properties)");
            C2585a.m8798b(string6, e3);
            throw null;
        } catch (Throwable th4) {
            obtainStyledAttributes.recycle();
            throw th4;
        }
    }

    /* renamed from: a */
    private final void m8739a() {
        C2590f fVar = this.f6956n;
        if (fVar != null) {
            fVar.setOnClickListener(new C2570e(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m8740a(long j, float f, float f2, C3218a<C3291h> aVar) {
        long j2 = j;
        float f3 = f;
        float abs = Math.abs(f2 - f3);
        if (j2 != 0) {
            abs = Math.abs(abs / ((float) j2));
        }
        float f4 = abs * ((float) 10);
        C3252j.C3253a aVar2 = new C3252j.C3253a();
        aVar2.f7304a = f3;
        Matrix matrix = new Matrix();
        C3218a<C3291h> onAnimationStart$expandable_fab_release = getOnAnimationStart$expandable_fab_release();
        if (onAnimationStart$expandable_fab_release != null) {
            C3291h a = onAnimationStart$expandable_fab_release.mo22768a();
        }
        Timer a2 = C3213a.m9023a((String) null, false);
        a2.schedule(new C2566c(this, aVar2, f2, f4, matrix, 0.01d, aVar), 0, 10);
        this.f6959q = a2;
    }

    /* renamed from: a */
    private final void m8742a(C2594i iVar, int i, Drawable drawable, C2589e eVar, boolean z, float f, C2589e eVar2, C2588d dVar, float f2, float f3, long j, long j2, float f4) {
        this.f6943a = iVar;
        setEfabColor(i);
        setEfabIcon(drawable);
        this.f6948f = f;
        setEfabSize(eVar);
        setEfabEnabled(z);
        this.f6949g = eVar2;
        this.f6950h = dVar;
        setFirstFabOptionMarginPx(f2);
        setSuccessiveFabOptionMarginPx(f3);
        setOpeningAnimationDurationMs(j);
        setClosingAnimationDurationMs(j2);
        setClosingAnticipateTension(f4);
        if (hasOnClickListeners()) {
            m8739a();
        } else {
            setOnClickListener((View.OnClickListener) null);
        }
    }

    @NotNull
    /* renamed from: a */
    public final /* synthetic */ Animator mo22733a(@NotNull C3218a<C3291h> aVar) {
        C3250h.m9056b(aVar, "onAnimationFinished");
        m8740a(this.f6953k, 0.0f, this.f6948f, new C2569d(aVar));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.f6956n.mo22837b());
        return animatorSet;
    }

    @NotNull
    /* renamed from: b */
    public final /* synthetic */ Animator mo22734b(@NotNull C3218a<C3291h> aVar) {
        C3250h.m9056b(aVar, "onAnimationFinished");
        float abs = Math.abs(this.f6948f / 10.0f) * this.f6955m;
        float f = this.f6948f;
        boolean z = false;
        float f2 = f < ((float) 0) ? f - abs : f + abs;
        long j = this.f6954l / 5;
        if (((double) Math.abs(abs - 0.0f)) > 0.01d) {
            z = true;
        }
        C2562a aVar2 = new C2562a(this, z, aVar);
        if (z) {
            m8740a(j, this.f6948f, f2, new C2565b(this, aVar2, j, f2));
        } else {
            aVar2.mo22766a(this.f6954l, this.f6948f);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(this.f6956n.mo22836a());
        return animatorSet;
    }

    public final long getClosingAnimationDurationMs() {
        return this.f6954l;
    }

    public final float getClosingAnticipateTension() {
        return this.f6955m;
    }

    @Nullable
    public final /* synthetic */ C3218a<C3291h> getDefaultOnClickBehavior$expandable_fab_release() {
        C3218a<C3291h> aVar = this.f6957o;
        if (aVar != null) {
            return aVar;
        }
        String string = getResources().getString(C2596k.C2600d.efab_layout_must_be_child_of_expandablefab_layout);
        C3250h.m9053a((Object) string, "resources.getString(R.st…_of_expandablefab_layout)");
        C2585a.m8797a(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final int getEfabColor() {
        return this.f6944b;
    }

    public final boolean getEfabEnabled() {
        return this.f6947e;
    }

    @Nullable
    public final Drawable getEfabIcon() {
        return this.f6945c;
    }

    @NotNull
    public final C2589e getEfabSize() {
        return this.f6946d;
    }

    @NotNull
    public final C2588d getFabOptionPosition() {
        return this.f6950h;
    }

    @NotNull
    public final C2589e getFabOptionSize() {
        return this.f6949g;
    }

    public final float getFirstFabOptionMarginPx() {
        return this.f6951i;
    }

    public final float getIconAnimationRotationDeg() {
        return this.f6948f;
    }

    @NotNull
    public final C2590f getLabel() {
        return this.f6956n;
    }

    @Nullable
    public final /* synthetic */ C3218a<C3291h> getOnAnimationStart$expandable_fab_release() {
        C3218a<C3291h> aVar = this.f6958p;
        if (aVar != null) {
            return aVar;
        }
        String string = getResources().getString(C2596k.C2600d.efab_layout_must_be_child_of_expandablefab_layout);
        C3250h.m9053a((Object) string, "resources.getString(R.st…_of_expandablefab_layout)");
        C2585a.m8797a(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final long getOpeningAnimationDurationMs() {
        return this.f6953k;
    }

    @NotNull
    public final C2594i getOrientation() {
        return this.f6943a;
    }

    public final float getSuccessiveFabOptionMarginPx() {
        return this.f6952j;
    }

    public void hide() {
        super.hide();
        this.f6956n.mo22839d();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Timer timer = this.f6959q;
        if (timer != null) {
            timer.cancel();
        }
    }

    public final void setClosingAnimationDurationMs(long j) {
        if (j >= 0) {
            this.f6954l = j;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_efab_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final void setClosingAnticipateTension(float f) {
        if (f >= ((float) 0)) {
            this.f6955m = f;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_efab_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final /* synthetic */ void setDefaultOnClickBehavior$expandable_fab_release(@Nullable C3218a<C3291h> aVar) {
        this.f6957o = aVar;
    }

    public final void setEfabColor(int i) {
        setBackgroundTintList(ColorStateList.valueOf(i));
        this.f6944b = i;
    }

    public final void setEfabEnabled(boolean z) {
        if (z) {
            setEfabColor(this.f6944b);
        } else {
            setBackgroundTintList(ColorStateList.valueOf(C0529a.m2102c(getContext(), C2596k.C2597a.efab_disabled)));
        }
        setEnabled(z);
        this.f6956n.setLabelEnabled$expandable_fab_release(z);
        this.f6947e = z;
    }

    public final void setEfabIcon(@Nullable Drawable drawable) {
        setImageDrawable(drawable);
        this.f6945c = drawable;
    }

    public final void setEfabSize(@NotNull C2589e eVar) {
        C3250h.m9056b(eVar, "value");
        if (eVar != C2589e.CUSTOM) {
            setSize(eVar.mo22835a());
        }
        this.f6946d = eVar;
    }

    public final void setFabOptionPosition(@NotNull C2588d dVar) {
        C3250h.m9056b(dVar, "<set-?>");
        this.f6950h = dVar;
    }

    public final void setFabOptionSize(@NotNull C2589e eVar) {
        C3250h.m9056b(eVar, "<set-?>");
        this.f6949g = eVar;
    }

    public final void setFirstFabOptionMarginPx(float f) {
        if (f >= ((float) 0)) {
            this.f6951i = f;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_efab_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public final void setIconAnimationRotationDeg(float f) {
        this.f6948f = f;
    }

    public final /* synthetic */ void setOnAnimationStart$expandable_fab_release(@Nullable C3218a<C3291h> aVar) {
        this.f6958p = aVar;
    }

    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(new C2571f(this, onClickListener));
        m8739a();
    }

    public final void setOpeningAnimationDurationMs(long j) {
        if (j >= 0) {
            this.f6953k = j;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_efab_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public void setSize(int i) {
        if (i != C2589e.CUSTOM.mo22835a()) {
            super.setSize(i);
        }
    }

    public final void setSuccessiveFabOptionMarginPx(float f) {
        if (f >= ((float) 0)) {
            this.f6952j = f;
            return;
        }
        String string = getResources().getString(C2596k.C2600d.efab_efab_illegal_optional_properties);
        C3250h.m9053a((Object) string, "resources.getString(R.st…egal_optional_properties)");
        C2585a.m8799b(string, (Throwable) null, 2, (Object) null);
        throw null;
    }

    public void show() {
        super.show();
        this.f6956n.mo22838c();
    }
}
