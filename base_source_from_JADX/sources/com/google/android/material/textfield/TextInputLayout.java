package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.p009a.p010a.C0070a;
import androidx.appcompat.widget.C0252aa;
import androidx.appcompat.widget.C0257af;
import androidx.appcompat.widget.C0337k;
import androidx.core.content.C0529a;
import androidx.core.graphics.drawable.C0595a;
import androidx.core.p030h.C0610a;
import androidx.core.p030h.C0656u;
import androidx.core.p030h.p031a.C0614c;
import androidx.core.widget.C0687i;
import androidx.p035e.p036a.C0711a;
import com.google.android.material.C2246R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEF_STYLE_RES = C2246R.C2250style.Widget_Design_TextInputLayout;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator animator;
    private MaterialShapeDrawable boxBackground;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private final int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private final int boxStrokeWidthDefaultPx;
    private final int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    private MaterialShapeDrawable boxUnderline;
    final CollapsingTextHelper collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;
    private ColorStateList counterTextColor;
    private TextView counterView;
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;
    private final int defaultStrokeColor;
    private final int disabledColor;
    private final int disabledFilledBackgroundColor;
    EditText editText;
    private final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;
    private final LinkedHashSet<OnEndIconChangedListener> endIconChangedListeners;
    private final SparseArray<EndIconDelegate> endIconDelegates;
    private Drawable endIconDummyDrawable;
    private final FrameLayout endIconFrame;
    private int endIconMode;
    private View.OnLongClickListener endIconOnLongClickListener;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;
    /* access modifiers changed from: private */
    public final CheckableImageButton endIconView;
    private final CheckableImageButton errorIconView;
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasEndIconTintList;
    private boolean hasEndIconTintMode;
    private boolean hasStartIconTintList;
    private boolean hasStartIconTintMode;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private final int hoveredFilledBackgroundColor;
    private final int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    /* access modifiers changed from: private */
    public boolean restoringSavedState;
    private ShapeAppearanceModel shapeAppearanceModel;
    private Drawable startIconDummyDrawable;
    private View.OnLongClickListener startIconOnLongClickListener;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;
    private final CheckableImageButton startIconView;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class AccessibilityDelegate extends C0610a {
        private final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0614c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            EditText editText = this.layout.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.layout.getHint();
            CharSequence error = this.layout.getError();
            CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                cVar.mo3722c((CharSequence) text);
            } else if (z2) {
                cVar.mo3722c(hint);
            }
            if (z2) {
                cVar.mo3731f(hint);
                if (!z && z2) {
                    z4 = true;
                }
                cVar.mo3749m(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                cVar.mo3734g(error);
                cVar.mo3743j(true);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(TextInputLayout textInputLayout, int i);
    }

    static class SavedState extends C0711a {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        CharSequence error;
        boolean isEndIconChecked;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() != 1 ? false : true;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.error, parcel, i);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
        }
    }

    public TextInputLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C2246R.attr.textInputStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(android.content.Context r17, android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r1 = DEF_STYLE_RES
            r2 = r17
            android.content.Context r1 = com.google.android.material.internal.ThemeEnforcement.createThemedContext(r2, r7, r8, r1)
            r0.<init>(r1, r7, r8)
            com.google.android.material.textfield.IndicatorViewController r1 = new com.google.android.material.textfield.IndicatorViewController
            r1.<init>(r0)
            r0.indicatorViewController = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.tmpRect = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.tmpBoundsRect = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.tmpRectF = r1
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.editTextAttachedListeners = r1
            r9 = 0
            r0.endIconMode = r9
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r0.endIconDelegates = r1
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.endIconChangedListeners = r1
            com.google.android.material.internal.CollapsingTextHelper r1 = new com.google.android.material.internal.CollapsingTextHelper
            r1.<init>(r0)
            r0.collapsingTextHelper = r1
            android.content.Context r10 = r16.getContext()
            r11 = 1
            r0.setOrientation(r11)
            r0.setWillNotDraw(r9)
            r0.setAddStatesFromChildren(r11)
            android.widget.FrameLayout r1 = new android.widget.FrameLayout
            r1.<init>(r10)
            r0.inputFrame = r1
            android.widget.FrameLayout r1 = r0.inputFrame
            r1.setAddStatesFromChildren(r11)
            android.widget.FrameLayout r1 = r0.inputFrame
            r0.addView(r1)
            android.widget.FrameLayout r1 = new android.widget.FrameLayout
            r1.<init>(r10)
            r0.endIconFrame = r1
            android.widget.FrameLayout r1 = r0.endIconFrame
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r3 = -2
            r4 = 8388629(0x800015, float:1.1754973E-38)
            r2.<init>(r3, r3, r4)
            r1.setLayoutParams(r2)
            android.widget.FrameLayout r1 = r0.inputFrame
            android.widget.FrameLayout r2 = r0.endIconFrame
            r1.addView(r2)
            com.google.android.material.internal.CollapsingTextHelper r1 = r0.collapsingTextHelper
            android.animation.TimeInterpolator r2 = com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR
            r1.setTextSizeInterpolator(r2)
            com.google.android.material.internal.CollapsingTextHelper r1 = r0.collapsingTextHelper
            android.animation.TimeInterpolator r2 = com.google.android.material.animation.AnimationUtils.LINEAR_INTERPOLATOR
            r1.setPositionInterpolator(r2)
            com.google.android.material.internal.CollapsingTextHelper r1 = r0.collapsingTextHelper
            r2 = 8388659(0x800033, float:1.1755015E-38)
            r1.setCollapsedTextGravity(r2)
            int[] r3 = com.google.android.material.C2246R.styleable.TextInputLayout
            int r5 = DEF_STYLE_RES
            r1 = 5
            int[] r6 = new int[r1]
            int r1 = com.google.android.material.C2246R.styleable.TextInputLayout_counterTextAppearance
            r6[r9] = r1
            int r1 = com.google.android.material.C2246R.styleable.TextInputLayout_counterOverflowTextAppearance
            r6[r11] = r1
            int r1 = com.google.android.material.C2246R.styleable.TextInputLayout_errorTextAppearance
            r12 = 2
            r6[r12] = r1
            int r1 = com.google.android.material.C2246R.styleable.TextInputLayout_helperTextTextAppearance
            r13 = 3
            r6[r13] = r1
            int r1 = com.google.android.material.C2246R.styleable.TextInputLayout_hintTextAppearance
            r2 = 4
            r6[r2] = r1
            r1 = r10
            r2 = r18
            r4 = r19
            androidx.appcompat.widget.ay r1 = com.google.android.material.internal.ThemeEnforcement.obtainTintedStyledAttributes(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_hintEnabled
            boolean r2 = r1.mo2411a((int) r2, (boolean) r11)
            r0.hintEnabled = r2
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_android_hint
            java.lang.CharSequence r2 = r1.mo2416c(r2)
            r0.setHint(r2)
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_hintAnimationEnabled
            boolean r2 = r1.mo2411a((int) r2, (boolean) r11)
            r0.hintAnimationEnabled = r2
            int r2 = DEF_STYLE_RES
            com.google.android.material.shape.ShapeAppearanceModel$Builder r2 = com.google.android.material.shape.ShapeAppearanceModel.builder((android.content.Context) r10, (android.util.AttributeSet) r7, (int) r8, (int) r2)
            com.google.android.material.shape.ShapeAppearanceModel r2 = r2.build()
            r0.shapeAppearanceModel = r2
            android.content.res.Resources r2 = r10.getResources()
            int r3 = com.google.android.material.C2246R.dimen.mtrl_textinput_box_label_cutout_padding
            int r2 = r2.getDimensionPixelOffset(r3)
            r0.boxLabelCutoutPaddingPx = r2
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_boxCollapsedPaddingTop
            int r2 = r1.mo2417d(r2, r9)
            r0.boxCollapsedPaddingTopPx = r2
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_boxStrokeWidth
            android.content.res.Resources r3 = r10.getResources()
            int r4 = com.google.android.material.C2246R.dimen.mtrl_textinput_box_stroke_width_default
            int r3 = r3.getDimensionPixelSize(r4)
            int r2 = r1.mo2419e(r2, r3)
            r0.boxStrokeWidthDefaultPx = r2
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_boxStrokeWidthFocused
            android.content.res.Resources r3 = r10.getResources()
            int r4 = com.google.android.material.C2246R.dimen.mtrl_textinput_box_stroke_width_focused
            int r3 = r3.getDimensionPixelSize(r4)
            int r2 = r1.mo2419e(r2, r3)
            r0.boxStrokeWidthFocusedPx = r2
            int r2 = r0.boxStrokeWidthDefaultPx
            r0.boxStrokeWidthPx = r2
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_boxCornerRadiusTopStart
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r2 = r1.mo2412b((int) r2, (float) r3)
            int r4 = com.google.android.material.C2246R.styleable.TextInputLayout_boxCornerRadiusTopEnd
            float r4 = r1.mo2412b((int) r4, (float) r3)
            int r5 = com.google.android.material.C2246R.styleable.TextInputLayout_boxCornerRadiusBottomEnd
            float r5 = r1.mo2412b((int) r5, (float) r3)
            int r6 = com.google.android.material.C2246R.styleable.TextInputLayout_boxCornerRadiusBottomStart
            float r3 = r1.mo2412b((int) r6, (float) r3)
            com.google.android.material.shape.ShapeAppearanceModel r6 = r0.shapeAppearanceModel
            com.google.android.material.shape.ShapeAppearanceModel$Builder r6 = r6.toBuilder()
            r7 = 0
            int r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r8 < 0) goto L_0x014d
            r6.setTopLeftCornerSize((float) r2)
        L_0x014d:
            int r2 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x0154
            r6.setTopRightCornerSize((float) r4)
        L_0x0154:
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x015b
            r6.setBottomRightCornerSize((float) r5)
        L_0x015b:
            int r2 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x0162
            r6.setBottomLeftCornerSize((float) r3)
        L_0x0162:
            com.google.android.material.shape.ShapeAppearanceModel r2 = r6.build()
            r0.shapeAppearanceModel = r2
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_boxBackgroundColor
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r10, (androidx.appcompat.widget.C0302ay) r1, (int) r2)
            r3 = 16843623(0x1010367, float:2.3696E-38)
            r4 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
            r5 = -1
            if (r2 == 0) goto L_0x01b1
            int r6 = r2.getDefaultColor()
            r0.defaultFilledBackgroundColor = r6
            int r6 = r0.defaultFilledBackgroundColor
            r0.boxBackgroundColor = r6
            boolean r6 = r2.isStateful()
            if (r6 == 0) goto L_0x0196
            int[] r6 = new int[r11]
            r6[r9] = r4
            int r6 = r2.getColorForState(r6, r5)
            r0.disabledFilledBackgroundColor = r6
            int[] r6 = new int[r11]
            r6[r9] = r3
            goto L_0x01aa
        L_0x0196:
            int r2 = com.google.android.material.C2246R.C2247color.mtrl_filled_background_color
            android.content.res.ColorStateList r2 = androidx.appcompat.p009a.p010a.C0070a.m60a(r10, r2)
            int[] r6 = new int[r11]
            r6[r9] = r4
            int r6 = r2.getColorForState(r6, r5)
            r0.disabledFilledBackgroundColor = r6
            int[] r6 = new int[r11]
            r6[r9] = r3
        L_0x01aa:
            int r2 = r2.getColorForState(r6, r5)
            r0.hoveredFilledBackgroundColor = r2
            goto L_0x01b9
        L_0x01b1:
            r0.boxBackgroundColor = r9
            r0.defaultFilledBackgroundColor = r9
            r0.disabledFilledBackgroundColor = r9
            r0.hoveredFilledBackgroundColor = r9
        L_0x01b9:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_android_textColorHint
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x01cb
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_android_textColorHint
            android.content.res.ColorStateList r2 = r1.mo2420e(r2)
            r0.focusedTextColor = r2
            r0.defaultHintTextColor = r2
        L_0x01cb:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_boxStrokeColor
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r10, (androidx.appcompat.widget.C0302ay) r1, (int) r2)
            if (r2 == 0) goto L_0x0201
            boolean r6 = r2.isStateful()
            if (r6 == 0) goto L_0x0201
            int r6 = r2.getDefaultColor()
            r0.defaultStrokeColor = r6
            int[] r6 = new int[r11]
            r6[r9] = r4
            int r4 = r2.getColorForState(r6, r5)
            r0.disabledColor = r4
            int[] r4 = new int[r11]
            r4[r9] = r3
            int r3 = r2.getColorForState(r4, r5)
            r0.hoveredStrokeColor = r3
            int[] r3 = new int[r11]
            r4 = 16842908(0x101009c, float:2.3693995E-38)
            r3[r9] = r4
            int r2 = r2.getColorForState(r3, r5)
            r0.focusedStrokeColor = r2
            goto L_0x0221
        L_0x0201:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_boxStrokeColor
            int r2 = r1.mo2413b((int) r2, (int) r9)
            r0.focusedStrokeColor = r2
            int r2 = com.google.android.material.C2246R.C2247color.mtrl_textinput_default_box_stroke_color
            int r2 = androidx.core.content.C0529a.m2102c(r10, r2)
            r0.defaultStrokeColor = r2
            int r2 = com.google.android.material.C2246R.C2247color.mtrl_textinput_disabled_color
            int r2 = androidx.core.content.C0529a.m2102c(r10, r2)
            r0.disabledColor = r2
            int r2 = com.google.android.material.C2246R.C2247color.mtrl_textinput_hovered_box_stroke_color
            int r2 = androidx.core.content.C0529a.m2102c(r10, r2)
            r0.hoveredStrokeColor = r2
        L_0x0221:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_hintTextAppearance
            int r2 = r1.mo2423g(r2, r5)
            if (r2 == r5) goto L_0x0232
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_hintTextAppearance
            int r2 = r1.mo2423g(r2, r9)
            r0.setHintTextAppearance(r2)
        L_0x0232:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_errorTextAppearance
            int r2 = r1.mo2423g(r2, r9)
            int r3 = com.google.android.material.C2246R.styleable.TextInputLayout_errorEnabled
            boolean r3 = r1.mo2411a((int) r3, (boolean) r9)
            android.content.Context r4 = r16.getContext()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            int r6 = com.google.android.material.C2246R.layout.design_text_input_end_icon
            android.widget.FrameLayout r7 = r0.inputFrame
            android.view.View r4 = r4.inflate(r6, r7, r9)
            com.google.android.material.internal.CheckableImageButton r4 = (com.google.android.material.internal.CheckableImageButton) r4
            r0.errorIconView = r4
            android.widget.FrameLayout r4 = r0.inputFrame
            com.google.android.material.internal.CheckableImageButton r6 = r0.errorIconView
            r4.addView(r6)
            com.google.android.material.internal.CheckableImageButton r4 = r0.errorIconView
            r6 = 8
            r4.setVisibility(r6)
            int r4 = com.google.android.material.C2246R.styleable.TextInputLayout_errorIconDrawable
            boolean r4 = r1.mo2424g(r4)
            if (r4 == 0) goto L_0x0271
            int r4 = com.google.android.material.C2246R.styleable.TextInputLayout_errorIconDrawable
            android.graphics.drawable.Drawable r4 = r1.mo2409a(r4)
            r0.setErrorIconDrawable((android.graphics.drawable.Drawable) r4)
        L_0x0271:
            int r4 = com.google.android.material.C2246R.styleable.TextInputLayout_errorIconTint
            boolean r4 = r1.mo2424g(r4)
            if (r4 == 0) goto L_0x0282
            int r4 = com.google.android.material.C2246R.styleable.TextInputLayout_errorIconTint
            android.content.res.ColorStateList r4 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r10, (androidx.appcompat.widget.C0302ay) r1, (int) r4)
            r0.setErrorIconTintList(r4)
        L_0x0282:
            int r4 = com.google.android.material.C2246R.styleable.TextInputLayout_errorIconTintMode
            boolean r4 = r1.mo2424g(r4)
            r7 = 0
            if (r4 == 0) goto L_0x0298
            int r4 = com.google.android.material.C2246R.styleable.TextInputLayout_errorIconTintMode
            int r4 = r1.mo2407a((int) r4, (int) r5)
            android.graphics.PorterDuff$Mode r4 = com.google.android.material.internal.ViewUtils.parseTintMode(r4, r7)
            r0.setErrorIconTintMode(r4)
        L_0x0298:
            com.google.android.material.internal.CheckableImageButton r4 = r0.errorIconView
            android.content.res.Resources r8 = r16.getResources()
            int r14 = com.google.android.material.C2246R.string.error_icon_content_description
            java.lang.CharSequence r8 = r8.getText(r14)
            r4.setContentDescription(r8)
            com.google.android.material.internal.CheckableImageButton r4 = r0.errorIconView
            androidx.core.p030h.C0656u.m2606b((android.view.View) r4, (int) r12)
            com.google.android.material.internal.CheckableImageButton r4 = r0.errorIconView
            r4.setClickable(r9)
            com.google.android.material.internal.CheckableImageButton r4 = r0.errorIconView
            r4.setPressable(r9)
            com.google.android.material.internal.CheckableImageButton r4 = r0.errorIconView
            r4.setFocusable(r9)
            int r4 = com.google.android.material.C2246R.styleable.TextInputLayout_helperTextTextAppearance
            int r4 = r1.mo2423g(r4, r9)
            int r8 = com.google.android.material.C2246R.styleable.TextInputLayout_helperTextEnabled
            boolean r8 = r1.mo2411a((int) r8, (boolean) r9)
            int r14 = com.google.android.material.C2246R.styleable.TextInputLayout_helperText
            java.lang.CharSequence r14 = r1.mo2416c(r14)
            int r15 = com.google.android.material.C2246R.styleable.TextInputLayout_counterEnabled
            boolean r15 = r1.mo2411a((int) r15, (boolean) r9)
            int r13 = com.google.android.material.C2246R.styleable.TextInputLayout_counterMaxLength
            int r13 = r1.mo2407a((int) r13, (int) r5)
            r0.setCounterMaxLength(r13)
            int r13 = com.google.android.material.C2246R.styleable.TextInputLayout_counterTextAppearance
            int r13 = r1.mo2423g(r13, r9)
            r0.counterTextAppearance = r13
            int r13 = com.google.android.material.C2246R.styleable.TextInputLayout_counterOverflowTextAppearance
            int r13 = r1.mo2423g(r13, r9)
            r0.counterOverflowTextAppearance = r13
            android.content.Context r13 = r16.getContext()
            android.view.LayoutInflater r13 = android.view.LayoutInflater.from(r13)
            int r12 = com.google.android.material.C2246R.layout.design_text_input_start_icon
            android.widget.FrameLayout r5 = r0.inputFrame
            android.view.View r5 = r13.inflate(r12, r5, r9)
            com.google.android.material.internal.CheckableImageButton r5 = (com.google.android.material.internal.CheckableImageButton) r5
            r0.startIconView = r5
            android.widget.FrameLayout r5 = r0.inputFrame
            com.google.android.material.internal.CheckableImageButton r12 = r0.startIconView
            r5.addView(r12)
            com.google.android.material.internal.CheckableImageButton r5 = r0.startIconView
            r5.setVisibility(r6)
            r0.setStartIconOnClickListener(r7)
            r0.setStartIconOnLongClickListener(r7)
            int r5 = com.google.android.material.C2246R.styleable.TextInputLayout_startIconDrawable
            boolean r5 = r1.mo2424g(r5)
            if (r5 == 0) goto L_0x033d
            int r5 = com.google.android.material.C2246R.styleable.TextInputLayout_startIconDrawable
            android.graphics.drawable.Drawable r5 = r1.mo2409a(r5)
            r0.setStartIconDrawable((android.graphics.drawable.Drawable) r5)
            int r5 = com.google.android.material.C2246R.styleable.TextInputLayout_startIconContentDescription
            boolean r5 = r1.mo2424g(r5)
            if (r5 == 0) goto L_0x0334
            int r5 = com.google.android.material.C2246R.styleable.TextInputLayout_startIconContentDescription
            java.lang.CharSequence r5 = r1.mo2416c(r5)
            r0.setStartIconContentDescription((java.lang.CharSequence) r5)
        L_0x0334:
            int r5 = com.google.android.material.C2246R.styleable.TextInputLayout_startIconCheckable
            boolean r5 = r1.mo2411a((int) r5, (boolean) r11)
            r0.setStartIconCheckable(r5)
        L_0x033d:
            int r5 = com.google.android.material.C2246R.styleable.TextInputLayout_startIconTint
            boolean r5 = r1.mo2424g(r5)
            if (r5 == 0) goto L_0x034e
            int r5 = com.google.android.material.C2246R.styleable.TextInputLayout_startIconTint
            android.content.res.ColorStateList r5 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r10, (androidx.appcompat.widget.C0302ay) r1, (int) r5)
            r0.setStartIconTintList(r5)
        L_0x034e:
            int r5 = com.google.android.material.C2246R.styleable.TextInputLayout_startIconTintMode
            boolean r5 = r1.mo2424g(r5)
            if (r5 == 0) goto L_0x0364
            int r5 = com.google.android.material.C2246R.styleable.TextInputLayout_startIconTintMode
            r12 = -1
            int r5 = r1.mo2407a((int) r5, (int) r12)
            android.graphics.PorterDuff$Mode r5 = com.google.android.material.internal.ViewUtils.parseTintMode(r5, r7)
            r0.setStartIconTintMode(r5)
        L_0x0364:
            r0.setHelperTextEnabled(r8)
            r0.setHelperText(r14)
            r0.setHelperTextTextAppearance(r4)
            r0.setErrorEnabled(r3)
            r0.setErrorTextAppearance(r2)
            int r2 = r0.counterTextAppearance
            r0.setCounterTextAppearance(r2)
            int r2 = r0.counterOverflowTextAppearance
            r0.setCounterOverflowTextAppearance(r2)
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_errorTextColor
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x038e
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_errorTextColor
            android.content.res.ColorStateList r2 = r1.mo2420e(r2)
            r0.setErrorTextColor(r2)
        L_0x038e:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_helperTextTextColor
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x039f
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_helperTextTextColor
            android.content.res.ColorStateList r2 = r1.mo2420e(r2)
            r0.setHelperTextColor(r2)
        L_0x039f:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_hintTextColor
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x03b0
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_hintTextColor
            android.content.res.ColorStateList r2 = r1.mo2420e(r2)
            r0.setHintTextColor(r2)
        L_0x03b0:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_counterTextColor
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x03c1
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_counterTextColor
            android.content.res.ColorStateList r2 = r1.mo2420e(r2)
            r0.setCounterTextColor(r2)
        L_0x03c1:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_counterOverflowTextColor
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x03d2
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_counterOverflowTextColor
            android.content.res.ColorStateList r2 = r1.mo2420e(r2)
            r0.setCounterOverflowTextColor(r2)
        L_0x03d2:
            r0.setCounterEnabled(r15)
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_boxBackgroundMode
            int r2 = r1.mo2407a((int) r2, (int) r9)
            r0.setBoxBackgroundMode(r2)
            android.content.Context r2 = r16.getContext()
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            int r3 = com.google.android.material.C2246R.layout.design_text_input_end_icon
            android.widget.FrameLayout r4 = r0.endIconFrame
            android.view.View r2 = r2.inflate(r3, r4, r9)
            com.google.android.material.internal.CheckableImageButton r2 = (com.google.android.material.internal.CheckableImageButton) r2
            r0.endIconView = r2
            android.widget.FrameLayout r2 = r0.endIconFrame
            com.google.android.material.internal.CheckableImageButton r3 = r0.endIconView
            r2.addView(r3)
            com.google.android.material.internal.CheckableImageButton r2 = r0.endIconView
            r2.setVisibility(r6)
            android.util.SparseArray<com.google.android.material.textfield.EndIconDelegate> r2 = r0.endIconDelegates
            com.google.android.material.textfield.CustomEndIconDelegate r3 = new com.google.android.material.textfield.CustomEndIconDelegate
            r3.<init>(r0)
            r4 = -1
            r2.append(r4, r3)
            android.util.SparseArray<com.google.android.material.textfield.EndIconDelegate> r2 = r0.endIconDelegates
            com.google.android.material.textfield.NoEndIconDelegate r3 = new com.google.android.material.textfield.NoEndIconDelegate
            r3.<init>(r0)
            r2.append(r9, r3)
            android.util.SparseArray<com.google.android.material.textfield.EndIconDelegate> r2 = r0.endIconDelegates
            com.google.android.material.textfield.PasswordToggleEndIconDelegate r3 = new com.google.android.material.textfield.PasswordToggleEndIconDelegate
            r3.<init>(r0)
            r2.append(r11, r3)
            android.util.SparseArray<com.google.android.material.textfield.EndIconDelegate> r2 = r0.endIconDelegates
            com.google.android.material.textfield.ClearTextEndIconDelegate r3 = new com.google.android.material.textfield.ClearTextEndIconDelegate
            r3.<init>(r0)
            r4 = 2
            r2.append(r4, r3)
            android.util.SparseArray<com.google.android.material.textfield.EndIconDelegate> r2 = r0.endIconDelegates
            com.google.android.material.textfield.DropdownMenuEndIconDelegate r3 = new com.google.android.material.textfield.DropdownMenuEndIconDelegate
            r3.<init>(r0)
            r4 = 3
            r2.append(r4, r3)
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_endIconMode
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x0470
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_endIconMode
            int r2 = r1.mo2407a((int) r2, (int) r9)
            r0.setEndIconMode(r2)
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_endIconDrawable
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x0455
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_endIconDrawable
            android.graphics.drawable.Drawable r2 = r1.mo2409a(r2)
            r0.setEndIconDrawable((android.graphics.drawable.Drawable) r2)
        L_0x0455:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_endIconContentDescription
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x0466
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_endIconContentDescription
            java.lang.CharSequence r2 = r1.mo2416c(r2)
            r0.setEndIconContentDescription((java.lang.CharSequence) r2)
        L_0x0466:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_endIconCheckable
            boolean r2 = r1.mo2411a((int) r2, (boolean) r11)
            r0.setEndIconCheckable(r2)
            goto L_0x04ba
        L_0x0470:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_passwordToggleEnabled
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x04ba
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_passwordToggleEnabled
            boolean r2 = r1.mo2411a((int) r2, (boolean) r9)
            r0.setEndIconMode(r2)
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_passwordToggleDrawable
            android.graphics.drawable.Drawable r2 = r1.mo2409a(r2)
            r0.setEndIconDrawable((android.graphics.drawable.Drawable) r2)
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_passwordToggleContentDescription
            java.lang.CharSequence r2 = r1.mo2416c(r2)
            r0.setEndIconContentDescription((java.lang.CharSequence) r2)
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_passwordToggleTint
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x04a4
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_passwordToggleTint
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r10, (androidx.appcompat.widget.C0302ay) r1, (int) r2)
            r0.setEndIconTintList(r2)
        L_0x04a4:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_passwordToggleTintMode
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x04ba
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_passwordToggleTintMode
            r3 = -1
            int r2 = r1.mo2407a((int) r2, (int) r3)
            android.graphics.PorterDuff$Mode r2 = com.google.android.material.internal.ViewUtils.parseTintMode(r2, r7)
            r0.setEndIconTintMode(r2)
        L_0x04ba:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_passwordToggleEnabled
            boolean r2 = r1.mo2424g(r2)
            if (r2 != 0) goto L_0x04e9
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_endIconTint
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x04d3
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_endIconTint
            android.content.res.ColorStateList r2 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r10, (androidx.appcompat.widget.C0302ay) r1, (int) r2)
            r0.setEndIconTintList(r2)
        L_0x04d3:
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_endIconTintMode
            boolean r2 = r1.mo2424g(r2)
            if (r2 == 0) goto L_0x04e9
            int r2 = com.google.android.material.C2246R.styleable.TextInputLayout_endIconTintMode
            r3 = -1
            int r2 = r1.mo2407a((int) r2, (int) r3)
            android.graphics.PorterDuff$Mode r2 = com.google.android.material.internal.ViewUtils.parseTintMode(r2, r7)
            r0.setEndIconTintMode(r2)
        L_0x04e9:
            r1.mo2410a()
            r1 = 2
            androidx.core.p030h.C0656u.m2606b((android.view.View) r0, (int) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void applyBoxAttributes() {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
            if (canDrawOutlineStroke()) {
                this.boxBackground.setStroke((float) this.boxStrokeWidthPx, this.boxStrokeColor);
            }
            this.boxBackgroundColor = calculateBoxBackgroundColor();
            this.boxBackground.setFillColor(ColorStateList.valueOf(this.boxBackgroundColor));
            if (this.endIconMode == 3) {
                this.editText.getBackground().invalidateSelf();
            }
            applyBoxUnderlineAttributes();
            invalidate();
        }
    }

    private void applyBoxUnderlineAttributes() {
        if (this.boxUnderline != null) {
            if (canDrawStroke()) {
                this.boxUnderline.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
            }
            invalidate();
        }
    }

    private void applyCutoutPadding(RectF rectF) {
        rectF.left -= (float) this.boxLabelCutoutPaddingPx;
        rectF.top -= (float) this.boxLabelCutoutPaddingPx;
        rectF.right += (float) this.boxLabelCutoutPaddingPx;
        rectF.bottom += (float) this.boxLabelCutoutPaddingPx;
    }

    private void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
    }

    private void applyIconTint(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = C0595a.m2330g(drawable).mutate();
            if (z) {
                C0595a.m2319a(drawable, colorStateList);
            }
            if (z2) {
                C0595a.m2322a(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void applyStartIconTint() {
        applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
    }

    private void assignBoxBackgroundByMode() {
        switch (this.boxBackgroundMode) {
            case 0:
                this.boxBackground = null;
                break;
            case 1:
                this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
                this.boxUnderline = new MaterialShapeDrawable();
                return;
            case 2:
                this.boxBackground = (!this.hintEnabled || (this.boxBackground instanceof CutoutDrawable)) ? new MaterialShapeDrawable(this.shapeAppearanceModel) : new CutoutDrawable(this.shapeAppearanceModel);
                break;
            default:
                throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
        this.boxUnderline = null;
    }

    private int calculateBoxBackgroundColor() {
        return this.boxBackgroundMode == 1 ? MaterialColors.layer(MaterialColors.getColor((View) this, C2246R.attr.colorSurface, 0), this.boxBackgroundColor) : this.boxBackgroundColor;
    }

    private Rect calculateCollapsedTextBounds(Rect rect) {
        int i;
        int i2;
        int paddingRight;
        if (this.editText != null) {
            Rect rect2 = this.tmpBoundsRect;
            rect2.bottom = rect.bottom;
            switch (this.boxBackgroundMode) {
                case 1:
                    rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
                    i = rect.top + this.boxCollapsedPaddingTopPx;
                    break;
                case 2:
                    rect2.left = rect.left + this.editText.getPaddingLeft();
                    rect2.top = rect.top - calculateLabelMarginTop();
                    i2 = rect.right;
                    paddingRight = this.editText.getPaddingRight();
                    break;
                default:
                    rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
                    i = getPaddingTop();
                    break;
            }
            rect2.top = i;
            i2 = rect.right;
            paddingRight = this.editText.getCompoundPaddingRight();
            rect2.right = i2 - paddingRight;
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int calculateExpandedLabelBottom(Rect rect, Rect rect2, float f) {
        return this.boxBackgroundMode == 1 ? (int) (((float) rect2.top) + f) : rect.bottom - this.editText.getCompoundPaddingBottom();
    }

    private int calculateExpandedLabelTop(Rect rect, float f) {
        return isSingleLineFilledTextField() ? (int) (((float) rect.centerY()) - (f / 2.0f)) : rect.top + this.editText.getCompoundPaddingTop();
    }

    private Rect calculateExpandedTextBounds(Rect rect) {
        if (this.editText != null) {
            Rect rect2 = this.tmpBoundsRect;
            float expandedTextHeight = this.collapsingTextHelper.getExpandedTextHeight();
            rect2.left = rect.left + this.editText.getCompoundPaddingLeft();
            rect2.top = calculateExpandedLabelTop(rect, expandedTextHeight);
            rect2.right = rect.right - this.editText.getCompoundPaddingRight();
            rect2.bottom = calculateExpandedLabelBottom(rect, rect2, expandedTextHeight);
            return rect2;
        }
        throw new IllegalStateException();
    }

    private int calculateLabelMarginTop() {
        float collapsedTextHeight;
        if (!this.hintEnabled) {
            return 0;
        }
        switch (this.boxBackgroundMode) {
            case 0:
            case 1:
                collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight();
                break;
            case 2:
                collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
                break;
            default:
                return 0;
        }
        return (int) collapsedTextHeight;
    }

    private boolean canDrawOutlineStroke() {
        return this.boxBackgroundMode == 2 && canDrawStroke();
    }

    private boolean canDrawStroke() {
        return this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0;
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((CutoutDrawable) this.boxBackground).removeCutout();
        }
    }

    private void collapseHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (!z || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(1.0f);
        } else {
            animateToExpansionFraction(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
    }

    private boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof CutoutDrawable);
    }

    private void dispatchOnEditTextAttached() {
        Iterator it = this.editTextAttachedListeners.iterator();
        while (it.hasNext()) {
            ((OnEditTextAttachedListener) it.next()).onEditTextAttached(this);
        }
    }

    private void dispatchOnEndIconChanged(int i) {
        Iterator it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            ((OnEndIconChangedListener) it.next()).onEndIconChanged(this, i);
        }
    }

    private void drawBoxUnderline(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
        if (materialShapeDrawable != null) {
            Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.boxStrokeWidthPx;
            this.boxUnderline.draw(canvas);
        }
    }

    private void drawHint(Canvas canvas) {
        if (this.hintEnabled) {
            this.collapsingTextHelper.draw(canvas);
        }
    }

    private void expandHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (!z || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.setExpansionFraction(0.0f);
        } else {
            animateToExpansionFraction(0.0f);
        }
        if (cutoutEnabled() && ((CutoutDrawable) this.boxBackground).hasCutout()) {
            closeCutout();
        }
        this.hintExpanded = true;
    }

    private EndIconDelegate getEndIconDelegate() {
        EndIconDelegate endIconDelegate = this.endIconDelegates.get(this.endIconMode);
        return endIconDelegate != null ? endIconDelegate : this.endIconDelegates.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.errorIconView.getVisibility() == 0) {
            return this.errorIconView;
        }
        if (!hasEndIcon() || !isEndIconVisible()) {
            return null;
        }
        return this.endIconView;
    }

    private boolean hasEndIcon() {
        return this.endIconMode != 0;
    }

    private boolean hasStartIcon() {
        return getStartIconDrawable() != null;
    }

    private boolean isSingleLineFilledTextField() {
        return this.boxBackgroundMode == 1 && (Build.VERSION.SDK_INT < 16 || this.editText.getMinLines() <= 1);
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        setEditTextBoxBackground();
        updateTextInputBoxState();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.getCollapsedTextActualBounds(rectF);
            applyCutoutPadding(rectF);
            rectF.offset((float) (-getPaddingLeft()), 0.0f);
            ((CutoutDrawable) this.boxBackground).setCutout(rectF);
        }
    }

    private static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    private void setEditText(EditText editText2) {
        if (this.editText == null) {
            if (this.endIconMode != 3 && !(editText2 instanceof TextInputEditText)) {
                Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.editText = editText2;
            onApplyBoxBackgroundMode();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
            this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
            int gravity = this.editText.getGravity();
            this.collapsingTextHelper.setCollapsedTextGravity((gravity & -113) | 48);
            this.collapsingTextHelper.setExpandedTextGravity(gravity);
            this.editText.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.updateLabelState(!textInputLayout.restoringSavedState);
                    if (TextInputLayout.this.counterEnabled) {
                        TextInputLayout.this.updateCounter(editable.length());
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            if (this.defaultHintTextColor == null) {
                this.defaultHintTextColor = this.editText.getHintTextColors();
            }
            if (this.hintEnabled) {
                if (TextUtils.isEmpty(this.hint)) {
                    this.originalHint = this.editText.getHint();
                    setHint(this.originalHint);
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.counterView != null) {
                updateCounter(this.editText.getText().length());
            }
            updateEditTextBackground();
            this.indicatorViewController.adjustIndicatorPadding();
            this.startIconView.bringToFront();
            this.endIconFrame.bringToFront();
            this.errorIconView.bringToFront();
            dispatchOnEditTextAttached();
            updateLabelState(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setEditTextBoxBackground() {
        if (shouldUseEditTextBackgroundForBoxBackground()) {
            C0656u.m2590a((View) this.editText, (Drawable) this.boxBackground);
        }
    }

    private void setErrorIconVisible(boolean z) {
        int i = 0;
        this.errorIconView.setVisibility(z ? 0 : 8);
        FrameLayout frameLayout = this.endIconFrame;
        if (z) {
            i = 8;
        }
        frameLayout.setVisibility(i);
        if (!hasEndIcon()) {
            updateIconDummyDrawables();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.hint)) {
            this.hint = charSequence;
            this.collapsingTextHelper.setText(charSequence);
            if (!this.hintExpanded) {
                openCutout();
            }
        }
    }

    private static void setIconClickable(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean C = C0656u.m2570C(checkableImageButton);
        boolean z = false;
        int i = 1;
        boolean z2 = onLongClickListener != null;
        if (C || z2) {
            z = true;
        }
        checkableImageButton.setFocusable(z);
        checkableImageButton.setClickable(C);
        checkableImageButton.setPressable(C);
        checkableImageButton.setLongClickable(z2);
        if (!z) {
            i = 2;
        }
        C0656u.m2606b((View) checkableImageButton, i);
    }

    private static void setIconOnClickListener(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private static void setIconOnLongClickListener(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private boolean shouldUseEditTextBackgroundForBoxBackground() {
        EditText editText2 = this.editText;
        return (editText2 == null || this.boxBackground == null || editText2.getBackground() != null || this.boxBackgroundMode == 0) ? false : true;
    }

    private void tintEndIconOnError(boolean z) {
        if (!z || getEndIconDrawable() == null) {
            applyEndIconTint();
            return;
        }
        Drawable mutate = C0595a.m2330g(getEndIconDrawable()).mutate();
        C0595a.m2317a(mutate, this.indicatorViewController.getErrorViewCurrentTextColor());
        this.endIconView.setImageDrawable(mutate);
    }

    private void updateBoxUnderlineBounds(Rect rect) {
        if (this.boxUnderline != null) {
            this.boxUnderline.setBounds(rect.left, rect.bottom - this.boxStrokeWidthFocusedPx, rect.right, rect.bottom);
        }
    }

    private void updateCounter() {
        if (this.counterView != null) {
            EditText editText2 = this.editText;
            updateCounter(editText2 == null ? 0 : editText2.getText().length());
        }
    }

    private static void updateCounterContentDescription(Context context, TextView textView, int i, int i2, boolean z) {
        textView.setContentDescription(context.getString(z ? C2246R.string.character_counter_overflowed_content_description : C2246R.string.character_counter_content_description, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    private void updateCounterTextAppearanceAndColor() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.counterView;
        if (textView != null) {
            setTextAppearanceCompatWithErrorFallback(textView, this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (this.counterOverflowed && (colorStateList = this.counterOverflowTextColor) != null) {
                this.counterView.setTextColor(colorStateList);
            }
        }
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        int max;
        if (this.editText == null || this.editText.getMeasuredHeight() >= (max = Math.max(this.endIconView.getMeasuredHeight(), this.startIconView.getMeasuredHeight()))) {
            return false;
        }
        this.editText.setMinimumHeight(max);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean updateIconDummyDrawables() {
        /*
            r10 = this;
            android.widget.EditText r0 = r10.editText
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r10.hasStartIcon()
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r0 == 0) goto L_0x0060
            boolean r0 = r10.isStartIconVisible()
            if (r0 == 0) goto L_0x0060
            com.google.android.material.internal.CheckableImageButton r0 = r10.startIconView
            int r0 = r0.getMeasuredWidth()
            if (r0 <= 0) goto L_0x0060
            android.graphics.drawable.Drawable r0 = r10.startIconDummyDrawable
            if (r0 != 0) goto L_0x0048
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            r0.<init>()
            r10.startIconDummyDrawable = r0
            com.google.android.material.internal.CheckableImageButton r0 = r10.startIconView
            int r0 = r0.getMeasuredWidth()
            android.widget.EditText r6 = r10.editText
            int r6 = r6.getPaddingLeft()
            int r0 = r0 - r6
            com.google.android.material.internal.CheckableImageButton r6 = r10.startIconView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            int r6 = androidx.core.p030h.C0641f.m2531b(r6)
            int r0 = r0 + r6
            android.graphics.drawable.Drawable r6 = r10.startIconDummyDrawable
            r6.setBounds(r1, r1, r0, r5)
        L_0x0048:
            android.widget.EditText r0 = r10.editText
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.C0687i.m2813b(r0)
            r6 = r0[r1]
            android.graphics.drawable.Drawable r7 = r10.startIconDummyDrawable
            if (r6 == r7) goto L_0x0079
            android.widget.EditText r6 = r10.editText
            r8 = r0[r5]
            r9 = r0[r4]
            r0 = r0[r3]
            androidx.core.widget.C0687i.m2809a(r6, r7, r8, r9, r0)
            goto L_0x0077
        L_0x0060:
            android.graphics.drawable.Drawable r0 = r10.startIconDummyDrawable
            if (r0 == 0) goto L_0x0079
            android.widget.EditText r0 = r10.editText
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.C0687i.m2813b(r0)
            android.widget.EditText r6 = r10.editText
            r7 = r0[r5]
            r8 = r0[r4]
            r0 = r0[r3]
            androidx.core.widget.C0687i.m2809a(r6, r2, r7, r8, r0)
            r10.startIconDummyDrawable = r2
        L_0x0077:
            r0 = 1
            goto L_0x007a
        L_0x0079:
            r0 = 0
        L_0x007a:
            com.google.android.material.internal.CheckableImageButton r6 = r10.getEndIconToUpdateDummyDrawable()
            if (r6 == 0) goto L_0x00c9
            int r7 = r6.getMeasuredWidth()
            if (r7 <= 0) goto L_0x00c9
            android.graphics.drawable.Drawable r2 = r10.endIconDummyDrawable
            if (r2 != 0) goto L_0x00ac
            android.graphics.drawable.ColorDrawable r2 = new android.graphics.drawable.ColorDrawable
            r2.<init>()
            r10.endIconDummyDrawable = r2
            int r2 = r6.getMeasuredWidth()
            android.widget.EditText r7 = r10.editText
            int r7 = r7.getPaddingRight()
            int r2 = r2 - r7
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            int r6 = androidx.core.p030h.C0641f.m2529a(r6)
            int r2 = r2 + r6
            android.graphics.drawable.Drawable r6 = r10.endIconDummyDrawable
            r6.setBounds(r1, r1, r2, r5)
        L_0x00ac:
            android.widget.EditText r2 = r10.editText
            android.graphics.drawable.Drawable[] r2 = androidx.core.widget.C0687i.m2813b(r2)
            r6 = r2[r4]
            android.graphics.drawable.Drawable r7 = r10.endIconDummyDrawable
            if (r6 == r7) goto L_0x00e9
            r0 = r2[r4]
            r10.originalEditTextEndDrawable = r0
            android.widget.EditText r0 = r10.editText
            r1 = r2[r1]
            r4 = r2[r5]
            r2 = r2[r3]
            androidx.core.widget.C0687i.m2809a(r0, r1, r4, r7, r2)
            r0 = 1
            goto L_0x00e9
        L_0x00c9:
            android.graphics.drawable.Drawable r6 = r10.endIconDummyDrawable
            if (r6 == 0) goto L_0x00e9
            android.widget.EditText r6 = r10.editText
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.C0687i.m2813b(r6)
            r4 = r6[r4]
            android.graphics.drawable.Drawable r7 = r10.endIconDummyDrawable
            if (r4 != r7) goto L_0x00e7
            android.widget.EditText r0 = r10.editText
            r1 = r6[r1]
            r4 = r6[r5]
            android.graphics.drawable.Drawable r7 = r10.originalEditTextEndDrawable
            r3 = r6[r3]
            androidx.core.widget.C0687i.m2809a(r0, r1, r4, r7, r3)
            r0 = 1
        L_0x00e7:
            r10.endIconDummyDrawable = r2
        L_0x00e9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.updateIconDummyDrawables():boolean");
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
            int calculateLabelMarginTop = calculateLabelMarginTop();
            if (calculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = calculateLabelMarginTop;
                this.inputFrame.requestLayout();
            }
        }
    }

    private void updateLabelState(boolean z, boolean z2) {
        ColorStateList colorStateList;
        CollapsingTextHelper collapsingTextHelper2;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText2 = this.editText;
        boolean z3 = true;
        boolean z4 = editText2 != null && !TextUtils.isEmpty(editText2.getText());
        EditText editText3 = this.editText;
        if (editText3 == null || !editText3.hasFocus()) {
            z3 = false;
        }
        boolean errorShouldBeShown = this.indicatorViewController.errorShouldBeShown();
        ColorStateList colorStateList2 = this.defaultHintTextColor;
        if (colorStateList2 != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList2);
            this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
        }
        if (!isEnabled) {
            this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(this.disabledColor));
            this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(this.disabledColor));
        } else if (errorShouldBeShown) {
            this.collapsingTextHelper.setCollapsedTextColor(this.indicatorViewController.getErrorViewTextColors());
        } else {
            if (this.counterOverflowed && (textView = this.counterView) != null) {
                collapsingTextHelper2 = this.collapsingTextHelper;
                colorStateList = textView.getTextColors();
            } else if (z3 && (colorStateList = this.focusedTextColor) != null) {
                collapsingTextHelper2 = this.collapsingTextHelper;
            }
            collapsingTextHelper2.setCollapsedTextColor(colorStateList);
        }
        if (z4 || (isEnabled() && (z3 || errorShouldBeShown))) {
            if (z2 || this.hintExpanded) {
                collapseHint(z);
            }
        } else if (z2 || !this.hintExpanded) {
            expandHint(z);
        }
    }

    public void addOnEditTextAttachedListener(OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.add(onEditTextAttachedListener);
        if (this.editText != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    public void addOnEndIconChangedListener(OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.add(onEndIconChangedListener);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.inputFrame.addView(view, layoutParams2);
            this.inputFrame.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void animateToExpansionFraction(float f) {
        if (this.collapsingTextHelper.getExpansionFraction() != f) {
            if (this.animator == null) {
                this.animator = new ValueAnimator();
                this.animator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                this.animator.setDuration(167);
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.animator.setFloatValues(new float[]{this.collapsingTextHelper.getExpansionFraction(), f});
            this.animator.start();
        }
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    /* access modifiers changed from: package-private */
    public boolean cutoutIsOpen() {
        return cutoutEnabled() && ((CutoutDrawable) this.boxBackground).hasCutout();
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText2;
        if (this.originalHint == null || (editText2 = this.editText) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        boolean z = this.isProvidingHint;
        this.isProvidingHint = false;
        CharSequence hint2 = editText2.getHint();
        this.editText.setHint(this.originalHint);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.editText.setHint(hint2);
            this.isProvidingHint = z;
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawHint(canvas);
        drawBoxUnderline(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (!this.inDrawableStateChanged) {
            boolean z = true;
            this.inDrawableStateChanged = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTextHelper;
            boolean state = collapsingTextHelper2 != null ? collapsingTextHelper2.setState(drawableState) | false : false;
            if (!C0656u.m2642y(this) || !isEnabled()) {
                z = false;
            }
            updateLabelState(z);
            updateEditTextBackground();
            updateTextInputBoxState();
            if (state) {
                invalidate();
            }
            this.inDrawableStateChanged = false;
        }
    }

    public int getBaseline() {
        EditText editText2 = this.editText;
        return editText2 != null ? editText2.getBaseline() + getPaddingTop() + calculateLabelMarginTop() : super.getBaseline();
    }

    /* access modifiers changed from: package-private */
    public MaterialShapeDrawable getBoxBackground() {
        int i = this.boxBackgroundMode;
        if (i == 1 || i == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxBackground.getBottomLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxBackground.getBottomRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxBackground.getTopRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxBackground.getTopLeftCornerResolvedSize();
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.counterEnabled || !this.counterOverflowed || (textView = this.counterView) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    /* access modifiers changed from: package-private */
    public CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    public CharSequence getError() {
        if (this.indicatorViewController.isErrorEnabled()) {
            return this.indicatorViewController.getErrorText();
        }
        return null;
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public CharSequence getHelperText() {
        if (this.indicatorViewController.isHelperTextEnabled()) {
            return this.indicatorViewController.getHelperText();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    /* access modifiers changed from: package-private */
    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    public CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    public boolean isEndIconVisible() {
        return this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0;
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    /* access modifiers changed from: package-private */
    public final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    /* access modifiers changed from: package-private */
    public final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.endIconMode == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    public boolean isStartIconVisible() {
        return this.startIconView.getVisibility() == 0;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText2 = this.editText;
        if (editText2 != null) {
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(this, editText2, rect);
            updateBoxUnderlineBounds(rect);
            if (this.hintEnabled) {
                this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(rect));
                this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(rect));
                this.collapsingTextHelper.recalculate();
                if (cutoutEnabled() && !this.hintExpanded) {
                    openCutout();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        boolean updateEditTextHeightBasedOnIcon = updateEditTextHeightBasedOnIcon();
        boolean updateIconDummyDrawables = updateIconDummyDrawables();
        if (updateEditTextHeightBasedOnIcon || updateIconDummyDrawables) {
            this.editText.post(new Runnable() {
                public void run() {
                    TextInputLayout.this.editText.requestLayout();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            this.endIconView.post(new Runnable() {
                public void run() {
                    TextInputLayout.this.endIconView.performClick();
                    TextInputLayout.this.endIconView.jumpDrawablesToCurrentState();
                }
            });
        }
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.errorShouldBeShown()) {
            savedState.error = getError();
        }
        savedState.isEndIconChecked = hasEndIcon() && this.endIconView.isChecked();
        return savedState;
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean z) {
        if (this.endIconMode == 1) {
            this.endIconView.performClick();
            if (z) {
                this.endIconView.jumpDrawablesToCurrentState();
            }
        }
    }

    public void removeOnEditTextAttachedListener(OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.remove(onEditTextAttachedListener);
    }

    public void removeOnEndIconChangedListener(OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.remove(onEndIconChangedListener);
    }

    public void setBoxBackgroundColor(int i) {
        if (this.boxBackgroundColor != i) {
            this.boxBackgroundColor = i;
            this.defaultFilledBackgroundColor = i;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(C0529a.m2102c(getContext(), i));
    }

    public void setBoxBackgroundMode(int i) {
        if (i != this.boxBackgroundMode) {
            this.boxBackgroundMode = i;
            if (this.editText != null) {
                onApplyBoxBackgroundMode();
            }
        }
    }

    public void setBoxCornerRadii(float f, float f2, float f3, float f4) {
        if (this.boxBackground.getTopLeftCornerResolvedSize() != f || this.boxBackground.getTopRightCornerResolvedSize() != f2 || this.boxBackground.getBottomRightCornerResolvedSize() != f4 || this.boxBackground.getBottomLeftCornerResolvedSize() != f3) {
            this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(f).setTopRightCornerSize(f2).setBottomRightCornerSize(f4).setBottomLeftCornerSize(f3).build();
            applyBoxAttributes();
        }
    }

    public void setBoxCornerRadiiResources(int i, int i2, int i3, int i4) {
        setBoxCornerRadii(getContext().getResources().getDimension(i), getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i4), getContext().getResources().getDimension(i3));
    }

    public void setBoxStrokeColor(int i) {
        if (this.focusedStrokeColor != i) {
            this.focusedStrokeColor = i;
            updateTextInputBoxState();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.counterEnabled != z) {
            if (z) {
                this.counterView = new C0252aa(getContext());
                this.counterView.setId(C2246R.C2249id.textinput_counter);
                Typeface typeface2 = this.typeface;
                if (typeface2 != null) {
                    this.counterView.setTypeface(typeface2);
                }
                this.counterView.setMaxLines(1);
                this.indicatorViewController.addIndicator(this.counterView, 2);
                updateCounterTextAppearanceAndColor();
                updateCounter();
            } else {
                this.indicatorViewController.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.counterMaxLength != i) {
            if (i <= 0) {
                i = -1;
            }
            this.counterMaxLength = i;
            if (this.counterEnabled) {
                updateCounter();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.counterOverflowTextAppearance != i) {
            this.counterOverflowTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.counterTextAppearance != i) {
            this.counterTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.endIconView.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.endIconView.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? C0070a.m63b(getContext(), i) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    public void setEndIconMode(int i) {
        int i2 = this.endIconMode;
        this.endIconMode = i;
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().isBoxBackgroundModeSupported(this.boxBackgroundMode)) {
            getEndIconDelegate().initialize();
            applyEndIconTint();
            dispatchOnEndIconChanged(i2);
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.boxBackgroundMode + " is not supported by the end icon mode " + i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        setIconOnClickListener(this.endIconView, onClickListener, this.endIconOnLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.endIconView, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            this.hasEndIconTintList = true;
            applyEndIconTint();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            this.hasEndIconTintMode = true;
            applyEndIconTint();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (isEndIconVisible() != z) {
            this.endIconView.setVisibility(z ? 0 : 4);
            updateIconDummyDrawables();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.indicatorViewController.isErrorEnabled()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.showError(charSequence);
        } else {
            this.indicatorViewController.hideError();
        }
    }

    public void setErrorEnabled(boolean z) {
        this.indicatorViewController.setErrorEnabled(z);
    }

    public void setErrorIconDrawable(int i) {
        setErrorIconDrawable(i != 0 ? C0070a.m63b(getContext(), i) : null);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.errorIconView.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.indicatorViewController.isErrorEnabled());
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = C0595a.m2330g(drawable).mutate();
            C0595a.m2319a(drawable, colorStateList);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = C0595a.m2330g(drawable).mutate();
            C0595a.m2322a(drawable, mode);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i) {
        this.indicatorViewController.setErrorTextAppearance(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.setErrorViewTextColor(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.showHelper(charSequence);
        } else if (isHelperTextEnabled()) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.setHelperTextViewTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z) {
        this.indicatorViewController.setHelperTextEnabled(z);
    }

    public void setHelperTextTextAppearance(int i) {
        this.indicatorViewController.setHelperTextAppearance(i);
    }

    public void setHint(CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (!this.hintEnabled) {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence hint2 = this.editText.getHint();
                if (!TextUtils.isEmpty(hint2)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint2);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? C0070a.m63b(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.endIconMode != 1) {
            setEndIconMode(1);
        } else if (!z) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
    }

    public void setStartIconCheckable(boolean z) {
        this.startIconView.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.startIconView.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? C0070a.m63b(getContext(), i) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.startIconView.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            applyStartIconTint();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener((View.OnClickListener) null);
        setStartIconOnLongClickListener((View.OnLongClickListener) null);
        setStartIconContentDescription((CharSequence) null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        setIconOnClickListener(this.startIconView, onClickListener, this.startIconOnLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.startIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.startIconView, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.startIconTintList != colorStateList) {
            this.startIconTintList = colorStateList;
            this.hasStartIconTintList = true;
            applyStartIconTint();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.startIconTintMode != mode) {
            this.startIconTintMode = mode;
            this.hasStartIconTintMode = true;
            applyStartIconTint();
        }
    }

    public void setStartIconVisible(boolean z) {
        if (isStartIconVisible() != z) {
            this.startIconView.setVisibility(z ? 0 : 8);
            updateIconDummyDrawables();
        }
    }

    /* access modifiers changed from: package-private */
    public void setTextAppearanceCompatWithErrorFallback(TextView textView, int i) {
        boolean z = true;
        try {
            C0687i.m2806a(textView, i);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z = false;
            }
        } catch (Exception unused) {
        }
        if (z) {
            C0687i.m2806a(textView, C2246R.C2250style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(C0529a.m2102c(getContext(), C2246R.C2247color.design_error));
        }
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            C0656u.m2594a((View) editText2, (C0610a) accessibilityDelegate);
        }
    }

    public void setTypeface(Typeface typeface2) {
        if (typeface2 != this.typeface) {
            this.typeface = typeface2;
            this.collapsingTextHelper.setTypefaces(typeface2);
            this.indicatorViewController.setTypefaces(typeface2);
            TextView textView = this.counterView;
            if (textView != null) {
                textView.setTypeface(typeface2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void updateCounter(int i) {
        boolean z = this.counterOverflowed;
        if (this.counterMaxLength == -1) {
            this.counterView.setText(String.valueOf(i));
            this.counterView.setContentDescription((CharSequence) null);
            this.counterOverflowed = false;
        } else {
            if (C0656u.m2623h(this.counterView) == 1) {
                C0656u.m2614d(this.counterView, 0);
            }
            this.counterOverflowed = i > this.counterMaxLength;
            updateCounterContentDescription(getContext(), this.counterView, i, this.counterMaxLength, this.counterOverflowed);
            if (z != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
                if (this.counterOverflowed) {
                    C0656u.m2614d(this.counterView, 1);
                }
            }
            this.counterView.setText(getContext().getString(C2246R.string.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.counterMaxLength)}));
        }
        if (this.editText != null && z != this.counterOverflowed) {
            updateLabelState(false);
            updateTextInputBoxState();
            updateEditTextBackground();
        }
    }

    /* access modifiers changed from: package-private */
    public void updateEditTextBackground() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText2 = this.editText;
        if (editText2 != null && this.boxBackgroundMode == 0 && (background = editText2.getBackground()) != null) {
            if (C0257af.m917c(background)) {
                background = background.mutate();
            }
            if (this.indicatorViewController.errorShouldBeShown()) {
                currentTextColor = this.indicatorViewController.getErrorViewCurrentTextColor();
            } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
                C0595a.m2329f(background);
                this.editText.refreshDrawableState();
                return;
            } else {
                currentTextColor = textView.getCurrentTextColor();
            }
            background.setColorFilter(C0337k.m1240a(currentTextColor, PorterDuff.Mode.SRC_IN));
        }
    }

    /* access modifiers changed from: package-private */
    public void updateLabelState(boolean z) {
        updateLabelState(z, false);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r5.editText;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateTextInputBoxState() {
        /*
            r5 = this;
            com.google.android.material.shape.MaterialShapeDrawable r0 = r5.boxBackground
            if (r0 == 0) goto L_0x00c5
            int r0 = r5.boxBackgroundMode
            if (r0 != 0) goto L_0x000a
            goto L_0x00c5
        L_0x000a:
            boolean r0 = r5.isFocused()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001f
            android.widget.EditText r0 = r5.editText
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            boolean r3 = r5.isHovered()
            if (r3 != 0) goto L_0x0033
            android.widget.EditText r3 = r5.editText
            if (r3 == 0) goto L_0x0031
            boolean r3 = r3.isHovered()
            if (r3 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            goto L_0x0034
        L_0x0033:
            r3 = 1
        L_0x0034:
            boolean r4 = r5.isEnabled()
            if (r4 != 0) goto L_0x003f
            int r4 = r5.disabledColor
        L_0x003c:
            r5.boxStrokeColor = r4
            goto L_0x0068
        L_0x003f:
            com.google.android.material.textfield.IndicatorViewController r4 = r5.indicatorViewController
            boolean r4 = r4.errorShouldBeShown()
            if (r4 == 0) goto L_0x004e
            com.google.android.material.textfield.IndicatorViewController r4 = r5.indicatorViewController
            int r4 = r4.getErrorViewCurrentTextColor()
            goto L_0x003c
        L_0x004e:
            boolean r4 = r5.counterOverflowed
            if (r4 == 0) goto L_0x005b
            android.widget.TextView r4 = r5.counterView
            if (r4 == 0) goto L_0x005b
            int r4 = r4.getCurrentTextColor()
            goto L_0x003c
        L_0x005b:
            if (r0 == 0) goto L_0x0060
            int r4 = r5.focusedStrokeColor
            goto L_0x003c
        L_0x0060:
            if (r3 == 0) goto L_0x0065
            int r4 = r5.hoveredStrokeColor
            goto L_0x003c
        L_0x0065:
            int r4 = r5.defaultStrokeColor
            goto L_0x003c
        L_0x0068:
            com.google.android.material.textfield.IndicatorViewController r4 = r5.indicatorViewController
            boolean r4 = r4.errorShouldBeShown()
            if (r4 == 0) goto L_0x007c
            com.google.android.material.textfield.EndIconDelegate r4 = r5.getEndIconDelegate()
            boolean r4 = r4.shouldTintIconOnError()
            if (r4 == 0) goto L_0x007c
            r4 = 1
            goto L_0x007d
        L_0x007c:
            r4 = 0
        L_0x007d:
            r5.tintEndIconOnError(r4)
            android.graphics.drawable.Drawable r4 = r5.getErrorIconDrawable()
            if (r4 == 0) goto L_0x0097
            com.google.android.material.textfield.IndicatorViewController r4 = r5.indicatorViewController
            boolean r4 = r4.isErrorEnabled()
            if (r4 == 0) goto L_0x0097
            com.google.android.material.textfield.IndicatorViewController r4 = r5.indicatorViewController
            boolean r4 = r4.errorShouldBeShown()
            if (r4 == 0) goto L_0x0097
            r1 = 1
        L_0x0097:
            r5.setErrorIconVisible(r1)
            if (r3 != 0) goto L_0x009e
            if (r0 == 0) goto L_0x00a7
        L_0x009e:
            boolean r0 = r5.isEnabled()
            if (r0 == 0) goto L_0x00a7
            int r0 = r5.boxStrokeWidthFocusedPx
            goto L_0x00a9
        L_0x00a7:
            int r0 = r5.boxStrokeWidthDefaultPx
        L_0x00a9:
            r5.boxStrokeWidthPx = r0
            int r0 = r5.boxBackgroundMode
            if (r0 != r2) goto L_0x00c2
            boolean r0 = r5.isEnabled()
            if (r0 != 0) goto L_0x00ba
            int r0 = r5.disabledFilledBackgroundColor
        L_0x00b7:
            r5.boxBackgroundColor = r0
            goto L_0x00c2
        L_0x00ba:
            if (r3 == 0) goto L_0x00bf
            int r0 = r5.hoveredFilledBackgroundColor
            goto L_0x00b7
        L_0x00bf:
            int r0 = r5.defaultFilledBackgroundColor
            goto L_0x00b7
        L_0x00c2:
            r5.applyBoxAttributes()
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.updateTextInputBoxState():void");
    }
}
