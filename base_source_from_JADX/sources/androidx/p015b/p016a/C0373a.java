package androidx.p015b.p016a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.p015b.C0367a;

/* renamed from: androidx.b.a.a */
public class C0373a extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {16842801};
    private static final C0381f IMPL = (Build.VERSION.SDK_INT >= 21 ? new C0377c() : Build.VERSION.SDK_INT >= 17 ? new C0375b() : new C0378d());
    private final C0380e mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    static {
        IMPL.mo2740a();
    }

    public C0373a(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0373a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0367a.C0368a.cardViewStyle);
    }

    public C0373a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources;
        int i2;
        ColorStateList valueOf;
        this.mContentPadding = new Rect();
        this.mShadowBounds = new Rect();
        this.mCardViewDelegate = new C0380e() {

            /* renamed from: b */
            private Drawable f1294b;

            /* renamed from: a */
            public void mo2733a(int i, int i2) {
                if (i > C0373a.this.mUserSetMinWidth) {
                    C0373a.super.setMinimumWidth(i);
                }
                if (i2 > C0373a.this.mUserSetMinHeight) {
                    C0373a.super.setMinimumHeight(i2);
                }
            }

            /* renamed from: a */
            public void mo2734a(int i, int i2, int i3, int i4) {
                C0373a.this.mShadowBounds.set(i, i2, i3, i4);
                C0373a aVar = C0373a.this;
                C0373a.super.setPadding(i + aVar.mContentPadding.left, i2 + C0373a.this.mContentPadding.top, i3 + C0373a.this.mContentPadding.right, i4 + C0373a.this.mContentPadding.bottom);
            }

            /* renamed from: a */
            public void mo2735a(Drawable drawable) {
                this.f1294b = drawable;
                C0373a.this.setBackgroundDrawable(drawable);
            }

            /* renamed from: a */
            public boolean mo2736a() {
                return C0373a.this.getUseCompatPadding();
            }

            /* renamed from: b */
            public boolean mo2737b() {
                return C0373a.this.getPreventCornerOverlap();
            }

            /* renamed from: c */
            public Drawable mo2738c() {
                return this.f1294b;
            }

            /* renamed from: d */
            public View mo2739d() {
                return C0373a.this;
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0367a.C0372e.CardView, i, C0367a.C0371d.CardView);
        if (obtainStyledAttributes.hasValue(C0367a.C0372e.CardView_cardBackgroundColor)) {
            valueOf = obtainStyledAttributes.getColorStateList(C0367a.C0372e.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                resources = getResources();
                i2 = C0367a.C0369b.cardview_light_background;
            } else {
                resources = getResources();
                i2 = C0367a.C0369b.cardview_dark_background;
            }
            valueOf = ColorStateList.valueOf(resources.getColor(i2));
        }
        ColorStateList colorStateList = valueOf;
        float dimension = obtainStyledAttributes.getDimension(C0367a.C0372e.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(C0367a.C0372e.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(C0367a.C0372e.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(C0367a.C0372e.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(C0367a.C0372e.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0367a.C0372e.CardView_contentPadding, 0);
        this.mContentPadding.left = obtainStyledAttributes.getDimensionPixelSize(C0367a.C0372e.CardView_contentPaddingLeft, dimensionPixelSize);
        this.mContentPadding.top = obtainStyledAttributes.getDimensionPixelSize(C0367a.C0372e.CardView_contentPaddingTop, dimensionPixelSize);
        this.mContentPadding.right = obtainStyledAttributes.getDimensionPixelSize(C0367a.C0372e.CardView_contentPaddingRight, dimensionPixelSize);
        this.mContentPadding.bottom = obtainStyledAttributes.getDimensionPixelSize(C0367a.C0372e.CardView_contentPaddingBottom, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(C0367a.C0372e.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(C0367a.C0372e.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        IMPL.mo2744a(this.mCardViewDelegate, context, colorStateList, dimension, dimension2, f);
    }

    public ColorStateList getCardBackgroundColor() {
        return IMPL.mo2755i(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.mo2751e(this.mCardViewDelegate);
    }

    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.mo2742a(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.mo2750d(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!(IMPL instanceof C0377c)) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) IMPL.mo2746b(this.mCardViewDelegate)), View.MeasureSpec.getSize(i)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) IMPL.mo2748c(this.mCardViewDelegate)), View.MeasureSpec.getSize(i2)), mode2);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        IMPL.mo2745a(this.mCardViewDelegate, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        IMPL.mo2745a(this.mCardViewDelegate, colorStateList);
    }

    public void setCardElevation(float f) {
        IMPL.mo2749c(this.mCardViewDelegate, f);
    }

    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.mContentPadding.set(i, i2, i3, i4);
        IMPL.mo2752f(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f) {
        IMPL.mo2747b(this.mCardViewDelegate, f);
    }

    public void setMinimumHeight(int i) {
        this.mUserSetMinHeight = i;
        super.setMinimumHeight(i);
    }

    public void setMinimumWidth(int i) {
        this.mUserSetMinWidth = i;
        super.setMinimumWidth(i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            IMPL.mo2754h(this.mCardViewDelegate);
        }
    }

    public void setRadius(float f) {
        IMPL.mo2743a(this.mCardViewDelegate, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            IMPL.mo2753g(this.mCardViewDelegate);
        }
    }
}
