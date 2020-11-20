package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.p009a.p010a.C0070a;
import androidx.core.graphics.C0589a;
import androidx.core.graphics.drawable.C0595a;
import androidx.core.graphics.drawable.C0596b;
import androidx.core.p028f.C0564a;
import com.google.android.material.C2246R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.spongycastle.asn1.eac.CertificateBody;

public class ChipDrawable extends MaterialShapeDrawable implements Drawable.Callback, C0596b, TextDrawableHelper.TextDrawableDelegate {
    private static final boolean DEBUG = false;
    private static final int[] DEFAULT_STATE = {16842910};
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private static final ShapeDrawable closeIconRippleMask = new ShapeDrawable(new OvalShape());
    private int alpha = 255;
    private boolean checkable;
    private Drawable checkedIcon;
    private boolean checkedIconVisible;
    private ColorStateList chipBackgroundColor;
    private float chipCornerRadius;
    private float chipEndPadding;
    private Drawable chipIcon;
    private float chipIconSize;
    private ColorStateList chipIconTint;
    private boolean chipIconVisible;
    private float chipMinHeight;
    private final Paint chipPaint = new Paint(1);
    private float chipStartPadding;
    private ColorStateList chipStrokeColor;
    private float chipStrokeWidth;
    private ColorStateList chipSurfaceColor;
    private Drawable closeIcon;
    private CharSequence closeIconContentDescription;
    private float closeIconEndPadding;
    private Drawable closeIconRipple;
    private float closeIconSize;
    private float closeIconStartPadding;
    private int[] closeIconStateSet;
    private ColorStateList closeIconTint;
    private boolean closeIconVisible;
    private ColorFilter colorFilter;
    private ColorStateList compatRippleColor;
    private final Context context;
    private boolean currentChecked;
    private int currentChipBackgroundColor;
    private int currentChipStrokeColor;
    private int currentChipSurfaceColor;
    private int currentCompatRippleColor;
    private int currentCompositeSurfaceBackgroundColor;
    private int currentTextColor;
    private int currentTint;
    private final Paint debugPaint;
    private WeakReference<Delegate> delegate = new WeakReference<>((Object) null);
    private final Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    private boolean hasChipIconTint;
    private MotionSpec hideMotionSpec;
    private float iconEndPadding;
    private float iconStartPadding;
    private boolean isShapeThemingEnabled;
    private int maxWidth;
    private final PointF pointF = new PointF();
    private final RectF rectF = new RectF();
    private ColorStateList rippleColor;
    private final Path shapePath = new Path();
    private boolean shouldDrawText;
    private MotionSpec showMotionSpec;
    private CharSequence text;
    private final TextDrawableHelper textDrawableHelper;
    private float textEndPadding;
    private float textStartPadding;
    private ColorStateList tint;
    private PorterDuffColorFilter tintFilter;
    private PorterDuff.Mode tintMode = PorterDuff.Mode.SRC_IN;
    private TextUtils.TruncateAt truncateAt;
    private boolean useCompatRipple;

    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    private ChipDrawable(Context context2, AttributeSet attributeSet, int i, int i2) {
        super(context2, attributeSet, i, i2);
        initializeElevationOverlay(context2);
        this.context = context2;
        this.textDrawableHelper = new TextDrawableHelper(this);
        this.text = "";
        this.textDrawableHelper.getTextPaint().density = context2.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        Paint paint = this.debugPaint;
        if (paint != null) {
            paint.setStyle(Paint.Style.STROKE);
        }
        setState(DEFAULT_STATE);
        setCloseIconState(DEFAULT_STATE);
        this.shouldDrawText = true;
        if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
            closeIconRippleMask.setTint(-1);
        }
    }

    private void applyChildDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            C0595a.m2325b(drawable, C0595a.m2332i(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.closeIcon) {
                if (drawable.isStateful()) {
                    drawable.setState(getCloseIconState());
                }
                C0595a.m2319a(drawable, this.closeIconTint);
                return;
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
            Drawable drawable2 = this.chipIcon;
            if (drawable == drawable2 && this.hasChipIconTint) {
                C0595a.m2319a(drawable2, this.chipIconTint);
            }
        }
    }

    private void calculateChipIconBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsChipIcon() || showsCheckedIcon()) {
            float f = this.chipStartPadding + this.iconStartPadding;
            if (C0595a.m2332i(this) == 0) {
                rectF2.left = ((float) rect.left) + f;
                rectF2.right = rectF2.left + this.chipIconSize;
            } else {
                rectF2.right = ((float) rect.right) - f;
                rectF2.left = rectF2.right - this.chipIconSize;
            }
            rectF2.top = rect.exactCenterY() - (this.chipIconSize / 2.0f);
            rectF2.bottom = rectF2.top + this.chipIconSize;
        }
    }

    private void calculateChipTouchBounds(Rect rect, RectF rectF2) {
        rectF2.set(rect);
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (C0595a.m2332i(this) == 0) {
                rectF2.right = ((float) rect.right) - f;
            } else {
                rectF2.left = ((float) rect.left) + f;
            }
        }
    }

    private void calculateCloseIconBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding;
            if (C0595a.m2332i(this) == 0) {
                rectF2.right = ((float) rect.right) - f;
                rectF2.left = rectF2.right - this.closeIconSize;
            } else {
                rectF2.left = ((float) rect.left) + f;
                rectF2.right = rectF2.left + this.closeIconSize;
            }
            rectF2.top = rect.exactCenterY() - (this.closeIconSize / 2.0f);
            rectF2.bottom = rectF2.top + this.closeIconSize;
        }
    }

    private void calculateCloseIconTouchBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (showsCloseIcon()) {
            float f = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if (C0595a.m2332i(this) == 0) {
                rectF2.right = (float) rect.right;
                rectF2.left = rectF2.right - f;
            } else {
                rectF2.left = (float) rect.left;
                rectF2.right = ((float) rect.left) + f;
            }
            rectF2.top = (float) rect.top;
            rectF2.bottom = (float) rect.bottom;
        }
    }

    private void calculateTextBounds(Rect rect, RectF rectF2) {
        rectF2.setEmpty();
        if (this.text != null) {
            float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            float calculateCloseIconWidth = this.chipEndPadding + calculateCloseIconWidth() + this.textEndPadding;
            if (C0595a.m2332i(this) == 0) {
                rectF2.left = ((float) rect.left) + calculateChipIconWidth;
                rectF2.right = ((float) rect.right) - calculateCloseIconWidth;
            } else {
                rectF2.left = ((float) rect.left) + calculateCloseIconWidth;
                rectF2.right = ((float) rect.right) - calculateChipIconWidth;
            }
            rectF2.top = (float) rect.top;
            rectF2.bottom = (float) rect.bottom;
        }
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        return (this.fontMetrics.descent + this.fontMetrics.ascent) / 2.0f;
    }

    private boolean canShowCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.checkable;
    }

    public static ChipDrawable createFromAttributes(Context context2, AttributeSet attributeSet, int i, int i2) {
        ChipDrawable chipDrawable = new ChipDrawable(context2, attributeSet, i, i2);
        chipDrawable.loadFromAttributes(attributeSet, i, i2);
        return chipDrawable;
    }

    public static ChipDrawable createFromResource(Context context2, int i) {
        AttributeSet parseDrawableXml = DrawableUtils.parseDrawableXml(context2, i, "chip");
        int styleAttribute = parseDrawableXml.getStyleAttribute();
        if (styleAttribute == 0) {
            styleAttribute = C2246R.C2250style.Widget_MaterialComponents_Chip_Entry;
        }
        return createFromAttributes(context2, parseDrawableXml, C2246R.attr.chipStandaloneStyle, styleAttribute);
    }

    private void drawCheckedIcon(Canvas canvas, Rect rect) {
        if (showsCheckedIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            float f = this.rectF.left;
            float f2 = this.rectF.top;
            canvas.translate(f, f2);
            this.checkedIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.checkedIcon.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void drawChipBackground(Canvas canvas, Rect rect) {
        if (!this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipBackgroundColor);
            this.chipPaint.setStyle(Paint.Style.FILL);
            this.chipPaint.setColorFilter(getTintColorFilter());
            this.rectF.set(rect);
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        }
    }

    private void drawChipIcon(Canvas canvas, Rect rect) {
        if (showsChipIcon()) {
            calculateChipIconBounds(rect, this.rectF);
            float f = this.rectF.left;
            float f2 = this.rectF.top;
            canvas.translate(f, f2);
            this.chipIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            this.chipIcon.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void drawChipStroke(Canvas canvas, Rect rect) {
        if (this.chipStrokeWidth > 0.0f && !this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipStrokeColor);
            this.chipPaint.setStyle(Paint.Style.STROKE);
            if (!this.isShapeThemingEnabled) {
                this.chipPaint.setColorFilter(getTintColorFilter());
            }
            this.rectF.set(((float) rect.left) + (this.chipStrokeWidth / 2.0f), ((float) rect.top) + (this.chipStrokeWidth / 2.0f), ((float) rect.right) - (this.chipStrokeWidth / 2.0f), ((float) rect.bottom) - (this.chipStrokeWidth / 2.0f));
            float f = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
            canvas.drawRoundRect(this.rectF, f, f, this.chipPaint);
        }
    }

    private void drawChipSurface(Canvas canvas, Rect rect) {
        if (!this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipSurfaceColor);
            this.chipPaint.setStyle(Paint.Style.FILL);
            this.rectF.set(rect);
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
        }
    }

    private void drawCloseIcon(Canvas canvas, Rect rect) {
        Drawable drawable;
        if (showsCloseIcon()) {
            calculateCloseIconBounds(rect, this.rectF);
            float f = this.rectF.left;
            float f2 = this.rectF.top;
            canvas.translate(f, f2);
            this.closeIcon.setBounds(0, 0, (int) this.rectF.width(), (int) this.rectF.height());
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.closeIconRipple.setBounds(this.closeIcon.getBounds());
                this.closeIconRipple.jumpToCurrentState();
                drawable = this.closeIconRipple;
            } else {
                drawable = this.closeIcon;
            }
            drawable.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    private void drawCompatRipple(Canvas canvas, Rect rect) {
        this.chipPaint.setColor(this.currentCompatRippleColor);
        this.chipPaint.setStyle(Paint.Style.FILL);
        this.rectF.set(rect);
        if (!this.isShapeThemingEnabled) {
            canvas.drawRoundRect(this.rectF, getChipCornerRadius(), getChipCornerRadius(), this.chipPaint);
            return;
        }
        calculatePathForSize(new RectF(rect), this.shapePath);
        super.drawShape(canvas, this.chipPaint, this.shapePath, getBoundsAsRectF());
    }

    private void drawDebug(Canvas canvas, Rect rect) {
        Paint paint = this.debugPaint;
        if (paint != null) {
            paint.setColor(C0589a.m2272b(-16777216, CertificateBody.profileType));
            canvas.drawRect(rect, this.debugPaint);
            if (showsChipIcon() || showsCheckedIcon()) {
                calculateChipIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            if (this.text != null) {
                canvas.drawLine((float) rect.left, rect.exactCenterY(), (float) rect.right, rect.exactCenterY(), this.debugPaint);
            }
            if (showsCloseIcon()) {
                calculateCloseIconBounds(rect, this.rectF);
                canvas.drawRect(this.rectF, this.debugPaint);
            }
            this.debugPaint.setColor(C0589a.m2272b(-65536, CertificateBody.profileType));
            calculateChipTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
            this.debugPaint.setColor(C0589a.m2272b(-16711936, CertificateBody.profileType));
            calculateCloseIconTouchBounds(rect, this.rectF);
            canvas.drawRect(this.rectF, this.debugPaint);
        }
    }

    private void drawText(Canvas canvas, Rect rect) {
        if (this.text != null) {
            Paint.Align calculateTextOriginAndAlignment = calculateTextOriginAndAlignment(rect, this.pointF);
            calculateTextBounds(rect, this.rectF);
            if (this.textDrawableHelper.getTextAppearance() != null) {
                this.textDrawableHelper.getTextPaint().drawableState = getState();
                this.textDrawableHelper.updateTextPaintDrawState(this.context);
            }
            this.textDrawableHelper.getTextPaint().setTextAlign(calculateTextOriginAndAlignment);
            int i = 0;
            boolean z = Math.round(this.textDrawableHelper.getTextWidth(getText().toString())) > Math.round(this.rectF.width());
            if (z) {
                i = canvas.save();
                canvas.clipRect(this.rectF);
            }
            CharSequence charSequence = this.text;
            if (z && this.truncateAt != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.textDrawableHelper.getTextPaint(), this.rectF.width(), this.truncateAt);
            }
            CharSequence charSequence2 = charSequence;
            canvas.drawText(charSequence2, 0, charSequence2.length(), this.pointF.x, this.pointF.y, this.textDrawableHelper.getTextPaint());
            if (z) {
                canvas.restoreToCount(i);
            }
        }
    }

    private ColorFilter getTintColorFilter() {
        ColorFilter colorFilter2 = this.colorFilter;
        return colorFilter2 != null ? colorFilter2 : this.tintFilter;
    }

    private static boolean hasState(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStateful(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private static boolean isStateful(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean isStateful(TextAppearance textAppearance) {
        return (textAppearance == null || textAppearance.textColor == null || !textAppearance.textColor.isStateful()) ? false : true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ca  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadFromAttributes(android.util.AttributeSet r8, int r9, int r10) {
        /*
            r7 = this;
            android.content.Context r0 = r7.context
            int[] r2 = com.google.android.material.C2246R.styleable.Chip
            r6 = 0
            int[] r5 = new int[r6]
            r1 = r8
            r3 = r9
            r4 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.C2246R.styleable.Chip_shapeAppearance
            boolean r10 = r9.hasValue(r10)
            r7.isShapeThemingEnabled = r10
            android.content.Context r10 = r7.context
            int r0 = com.google.android.material.C2246R.styleable.Chip_chipSurfaceColor
            android.content.res.ColorStateList r10 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r10, (android.content.res.TypedArray) r9, (int) r0)
            r7.setChipSurfaceColor(r10)
            android.content.Context r10 = r7.context
            int r0 = com.google.android.material.C2246R.styleable.Chip_chipBackgroundColor
            android.content.res.ColorStateList r10 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r10, (android.content.res.TypedArray) r9, (int) r0)
            r7.setChipBackgroundColor(r10)
            int r10 = com.google.android.material.C2246R.styleable.Chip_chipMinHeight
            r0 = 0
            float r10 = r9.getDimension(r10, r0)
            r7.setChipMinHeight(r10)
            int r10 = com.google.android.material.C2246R.styleable.Chip_chipCornerRadius
            boolean r10 = r9.hasValue(r10)
            if (r10 == 0) goto L_0x0047
            int r10 = com.google.android.material.C2246R.styleable.Chip_chipCornerRadius
            float r10 = r9.getDimension(r10, r0)
            r7.setChipCornerRadius(r10)
        L_0x0047:
            android.content.Context r10 = r7.context
            int r1 = com.google.android.material.C2246R.styleable.Chip_chipStrokeColor
            android.content.res.ColorStateList r10 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r10, (android.content.res.TypedArray) r9, (int) r1)
            r7.setChipStrokeColor(r10)
            int r10 = com.google.android.material.C2246R.styleable.Chip_chipStrokeWidth
            float r10 = r9.getDimension(r10, r0)
            r7.setChipStrokeWidth(r10)
            android.content.Context r10 = r7.context
            int r1 = com.google.android.material.C2246R.styleable.Chip_rippleColor
            android.content.res.ColorStateList r10 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r10, (android.content.res.TypedArray) r9, (int) r1)
            r7.setRippleColor(r10)
            int r10 = com.google.android.material.C2246R.styleable.Chip_android_text
            java.lang.CharSequence r10 = r9.getText(r10)
            r7.setText(r10)
            android.content.Context r10 = r7.context
            int r1 = com.google.android.material.C2246R.styleable.Chip_android_textAppearance
            com.google.android.material.resources.TextAppearance r10 = com.google.android.material.resources.MaterialResources.getTextAppearance(r10, r9, r1)
            r7.setTextAppearance(r10)
            int r10 = com.google.android.material.C2246R.styleable.Chip_android_ellipsize
            int r10 = r9.getInt(r10, r6)
            switch(r10) {
                case 1: goto L_0x008a;
                case 2: goto L_0x0087;
                case 3: goto L_0x0084;
                default: goto L_0x0083;
            }
        L_0x0083:
            goto L_0x008f
        L_0x0084:
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.END
            goto L_0x008c
        L_0x0087:
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.MIDDLE
            goto L_0x008c
        L_0x008a:
            android.text.TextUtils$TruncateAt r10 = android.text.TextUtils.TruncateAt.START
        L_0x008c:
            r7.setEllipsize(r10)
        L_0x008f:
            int r10 = com.google.android.material.C2246R.styleable.Chip_chipIconVisible
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setChipIconVisible((boolean) r10)
            if (r8 == 0) goto L_0x00b7
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            java.lang.String r1 = "chipIconEnabled"
            java.lang.String r10 = r8.getAttributeValue(r10, r1)
            if (r10 == 0) goto L_0x00b7
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            java.lang.String r1 = "chipIconVisible"
            java.lang.String r10 = r8.getAttributeValue(r10, r1)
            if (r10 != 0) goto L_0x00b7
            int r10 = com.google.android.material.C2246R.styleable.Chip_chipIconEnabled
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setChipIconVisible((boolean) r10)
        L_0x00b7:
            android.content.Context r10 = r7.context
            int r1 = com.google.android.material.C2246R.styleable.Chip_chipIcon
            android.graphics.drawable.Drawable r10 = com.google.android.material.resources.MaterialResources.getDrawable(r10, r9, r1)
            r7.setChipIcon(r10)
            int r10 = com.google.android.material.C2246R.styleable.Chip_chipIconTint
            boolean r10 = r9.hasValue(r10)
            if (r10 == 0) goto L_0x00d5
            android.content.Context r10 = r7.context
            int r1 = com.google.android.material.C2246R.styleable.Chip_chipIconTint
            android.content.res.ColorStateList r10 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r10, (android.content.res.TypedArray) r9, (int) r1)
            r7.setChipIconTint(r10)
        L_0x00d5:
            int r10 = com.google.android.material.C2246R.styleable.Chip_chipIconSize
            float r10 = r9.getDimension(r10, r0)
            r7.setChipIconSize(r10)
            int r10 = com.google.android.material.C2246R.styleable.Chip_closeIconVisible
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setCloseIconVisible((boolean) r10)
            if (r8 == 0) goto L_0x0106
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            java.lang.String r1 = "closeIconEnabled"
            java.lang.String r10 = r8.getAttributeValue(r10, r1)
            if (r10 == 0) goto L_0x0106
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            java.lang.String r1 = "closeIconVisible"
            java.lang.String r10 = r8.getAttributeValue(r10, r1)
            if (r10 != 0) goto L_0x0106
            int r10 = com.google.android.material.C2246R.styleable.Chip_closeIconEnabled
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setCloseIconVisible((boolean) r10)
        L_0x0106:
            android.content.Context r10 = r7.context
            int r1 = com.google.android.material.C2246R.styleable.Chip_closeIcon
            android.graphics.drawable.Drawable r10 = com.google.android.material.resources.MaterialResources.getDrawable(r10, r9, r1)
            r7.setCloseIcon(r10)
            android.content.Context r10 = r7.context
            int r1 = com.google.android.material.C2246R.styleable.Chip_closeIconTint
            android.content.res.ColorStateList r10 = com.google.android.material.resources.MaterialResources.getColorStateList((android.content.Context) r10, (android.content.res.TypedArray) r9, (int) r1)
            r7.setCloseIconTint(r10)
            int r10 = com.google.android.material.C2246R.styleable.Chip_closeIconSize
            float r10 = r9.getDimension(r10, r0)
            r7.setCloseIconSize(r10)
            int r10 = com.google.android.material.C2246R.styleable.Chip_android_checkable
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setCheckable(r10)
            int r10 = com.google.android.material.C2246R.styleable.Chip_checkedIconVisible
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setCheckedIconVisible((boolean) r10)
            if (r8 == 0) goto L_0x0156
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            java.lang.String r1 = "checkedIconEnabled"
            java.lang.String r10 = r8.getAttributeValue(r10, r1)
            if (r10 == 0) goto L_0x0156
            java.lang.String r10 = "http://schemas.android.com/apk/res-auto"
            java.lang.String r1 = "checkedIconVisible"
            java.lang.String r8 = r8.getAttributeValue(r10, r1)
            if (r8 != 0) goto L_0x0156
            int r8 = com.google.android.material.C2246R.styleable.Chip_checkedIconEnabled
            boolean r8 = r9.getBoolean(r8, r6)
            r7.setCheckedIconVisible((boolean) r8)
        L_0x0156:
            android.content.Context r8 = r7.context
            int r10 = com.google.android.material.C2246R.styleable.Chip_checkedIcon
            android.graphics.drawable.Drawable r8 = com.google.android.material.resources.MaterialResources.getDrawable(r8, r9, r10)
            r7.setCheckedIcon(r8)
            android.content.Context r8 = r7.context
            int r10 = com.google.android.material.C2246R.styleable.Chip_showMotionSpec
            com.google.android.material.animation.MotionSpec r8 = com.google.android.material.animation.MotionSpec.createFromAttribute(r8, r9, r10)
            r7.setShowMotionSpec(r8)
            android.content.Context r8 = r7.context
            int r10 = com.google.android.material.C2246R.styleable.Chip_hideMotionSpec
            com.google.android.material.animation.MotionSpec r8 = com.google.android.material.animation.MotionSpec.createFromAttribute(r8, r9, r10)
            r7.setHideMotionSpec(r8)
            int r8 = com.google.android.material.C2246R.styleable.Chip_chipStartPadding
            float r8 = r9.getDimension(r8, r0)
            r7.setChipStartPadding(r8)
            int r8 = com.google.android.material.C2246R.styleable.Chip_iconStartPadding
            float r8 = r9.getDimension(r8, r0)
            r7.setIconStartPadding(r8)
            int r8 = com.google.android.material.C2246R.styleable.Chip_iconEndPadding
            float r8 = r9.getDimension(r8, r0)
            r7.setIconEndPadding(r8)
            int r8 = com.google.android.material.C2246R.styleable.Chip_textStartPadding
            float r8 = r9.getDimension(r8, r0)
            r7.setTextStartPadding(r8)
            int r8 = com.google.android.material.C2246R.styleable.Chip_textEndPadding
            float r8 = r9.getDimension(r8, r0)
            r7.setTextEndPadding(r8)
            int r8 = com.google.android.material.C2246R.styleable.Chip_closeIconStartPadding
            float r8 = r9.getDimension(r8, r0)
            r7.setCloseIconStartPadding(r8)
            int r8 = com.google.android.material.C2246R.styleable.Chip_closeIconEndPadding
            float r8 = r9.getDimension(r8, r0)
            r7.setCloseIconEndPadding(r8)
            int r8 = com.google.android.material.C2246R.styleable.Chip_chipEndPadding
            float r8 = r9.getDimension(r8, r0)
            r7.setChipEndPadding(r8)
            int r8 = com.google.android.material.C2246R.styleable.Chip_android_maxWidth
            r10 = 2147483647(0x7fffffff, float:NaN)
            int r8 = r9.getDimensionPixelSize(r8, r10)
            r7.setMaxWidth(r8)
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.loadFromAttributes(android.util.AttributeSet, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean onStateChange(int[] r7, int[] r8) {
        /*
            r6 = this;
            boolean r0 = super.onStateChange(r7)
            android.content.res.ColorStateList r1 = r6.chipSurfaceColor
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r3 = r6.currentChipSurfaceColor
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            int r3 = r6.currentChipSurfaceColor
            r4 = 1
            if (r3 == r1) goto L_0x0019
            r6.currentChipSurfaceColor = r1
            r0 = 1
        L_0x0019:
            android.content.res.ColorStateList r3 = r6.chipBackgroundColor
            if (r3 == 0) goto L_0x0024
            int r5 = r6.currentChipBackgroundColor
            int r3 = r3.getColorForState(r7, r5)
            goto L_0x0025
        L_0x0024:
            r3 = 0
        L_0x0025:
            int r5 = r6.currentChipBackgroundColor
            if (r5 == r3) goto L_0x002c
            r6.currentChipBackgroundColor = r3
            r0 = 1
        L_0x002c:
            int r1 = com.google.android.material.color.MaterialColors.layer(r1, r3)
            int r3 = r6.currentCompositeSurfaceBackgroundColor
            if (r3 == r1) goto L_0x0036
            r3 = 1
            goto L_0x0037
        L_0x0036:
            r3 = 0
        L_0x0037:
            android.content.res.ColorStateList r5 = r6.getFillColor()
            if (r5 != 0) goto L_0x003f
            r5 = 1
            goto L_0x0040
        L_0x003f:
            r5 = 0
        L_0x0040:
            r3 = r3 | r5
            if (r3 == 0) goto L_0x004f
            r6.currentCompositeSurfaceBackgroundColor = r1
            int r0 = r6.currentCompositeSurfaceBackgroundColor
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r6.setFillColor(r0)
            r0 = 1
        L_0x004f:
            android.content.res.ColorStateList r1 = r6.chipStrokeColor
            if (r1 == 0) goto L_0x005a
            int r3 = r6.currentChipStrokeColor
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x005b
        L_0x005a:
            r1 = 0
        L_0x005b:
            int r3 = r6.currentChipStrokeColor
            if (r3 == r1) goto L_0x0062
            r6.currentChipStrokeColor = r1
            r0 = 1
        L_0x0062:
            android.content.res.ColorStateList r1 = r6.compatRippleColor
            if (r1 == 0) goto L_0x0075
            boolean r1 = com.google.android.material.ripple.RippleUtils.shouldDrawRippleCompat(r7)
            if (r1 == 0) goto L_0x0075
            android.content.res.ColorStateList r1 = r6.compatRippleColor
            int r3 = r6.currentCompatRippleColor
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x0076
        L_0x0075:
            r1 = 0
        L_0x0076:
            int r3 = r6.currentCompatRippleColor
            if (r3 == r1) goto L_0x0081
            r6.currentCompatRippleColor = r1
            boolean r1 = r6.useCompatRipple
            if (r1 == 0) goto L_0x0081
            r0 = 1
        L_0x0081:
            com.google.android.material.internal.TextDrawableHelper r1 = r6.textDrawableHelper
            com.google.android.material.resources.TextAppearance r1 = r1.getTextAppearance()
            if (r1 == 0) goto L_0x00a2
            com.google.android.material.internal.TextDrawableHelper r1 = r6.textDrawableHelper
            com.google.android.material.resources.TextAppearance r1 = r1.getTextAppearance()
            android.content.res.ColorStateList r1 = r1.textColor
            if (r1 == 0) goto L_0x00a2
            com.google.android.material.internal.TextDrawableHelper r1 = r6.textDrawableHelper
            com.google.android.material.resources.TextAppearance r1 = r1.getTextAppearance()
            android.content.res.ColorStateList r1 = r1.textColor
            int r3 = r6.currentTextColor
            int r1 = r1.getColorForState(r7, r3)
            goto L_0x00a3
        L_0x00a2:
            r1 = 0
        L_0x00a3:
            int r3 = r6.currentTextColor
            if (r3 == r1) goto L_0x00aa
            r6.currentTextColor = r1
            r0 = 1
        L_0x00aa:
            int[] r1 = r6.getState()
            r3 = 16842912(0x10100a0, float:2.3694006E-38)
            boolean r1 = hasState(r1, r3)
            if (r1 == 0) goto L_0x00bd
            boolean r1 = r6.checkable
            if (r1 == 0) goto L_0x00bd
            r1 = 1
            goto L_0x00be
        L_0x00bd:
            r1 = 0
        L_0x00be:
            boolean r3 = r6.currentChecked
            if (r3 == r1) goto L_0x00d8
            android.graphics.drawable.Drawable r3 = r6.checkedIcon
            if (r3 == 0) goto L_0x00d8
            float r0 = r6.calculateChipIconWidth()
            r6.currentChecked = r1
            float r1 = r6.calculateChipIconWidth()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00d7
            r0 = 1
            r1 = 1
            goto L_0x00d9
        L_0x00d7:
            r0 = 1
        L_0x00d8:
            r1 = 0
        L_0x00d9:
            android.content.res.ColorStateList r3 = r6.tint
            if (r3 == 0) goto L_0x00e4
            int r5 = r6.currentTint
            int r3 = r3.getColorForState(r7, r5)
            goto L_0x00e5
        L_0x00e4:
            r3 = 0
        L_0x00e5:
            int r5 = r6.currentTint
            if (r5 == r3) goto L_0x00f6
            r6.currentTint = r3
            android.content.res.ColorStateList r0 = r6.tint
            android.graphics.PorterDuff$Mode r3 = r6.tintMode
            android.graphics.PorterDuffColorFilter r0 = com.google.android.material.drawable.DrawableUtils.updateTintFilter(r6, r0, r3)
            r6.tintFilter = r0
            r0 = 1
        L_0x00f6:
            android.graphics.drawable.Drawable r3 = r6.chipIcon
            boolean r3 = isStateful((android.graphics.drawable.Drawable) r3)
            if (r3 == 0) goto L_0x0105
            android.graphics.drawable.Drawable r3 = r6.chipIcon
            boolean r3 = r3.setState(r7)
            r0 = r0 | r3
        L_0x0105:
            android.graphics.drawable.Drawable r3 = r6.checkedIcon
            boolean r3 = isStateful((android.graphics.drawable.Drawable) r3)
            if (r3 == 0) goto L_0x0114
            android.graphics.drawable.Drawable r3 = r6.checkedIcon
            boolean r3 = r3.setState(r7)
            r0 = r0 | r3
        L_0x0114:
            android.graphics.drawable.Drawable r3 = r6.closeIcon
            boolean r3 = isStateful((android.graphics.drawable.Drawable) r3)
            if (r3 == 0) goto L_0x0131
            int r3 = r7.length
            int r4 = r8.length
            int r3 = r3 + r4
            int[] r3 = new int[r3]
            int r4 = r7.length
            java.lang.System.arraycopy(r7, r2, r3, r2, r4)
            int r7 = r7.length
            int r4 = r8.length
            java.lang.System.arraycopy(r8, r2, r3, r7, r4)
            android.graphics.drawable.Drawable r7 = r6.closeIcon
            boolean r7 = r7.setState(r3)
            r0 = r0 | r7
        L_0x0131:
            boolean r7 = com.google.android.material.ripple.RippleUtils.USE_FRAMEWORK_RIPPLE
            if (r7 == 0) goto L_0x0144
            android.graphics.drawable.Drawable r7 = r6.closeIconRipple
            boolean r7 = isStateful((android.graphics.drawable.Drawable) r7)
            if (r7 == 0) goto L_0x0144
            android.graphics.drawable.Drawable r7 = r6.closeIconRipple
            boolean r7 = r7.setState(r8)
            r0 = r0 | r7
        L_0x0144:
            if (r0 == 0) goto L_0x0149
            r6.invalidateSelf()
        L_0x0149:
            if (r1 == 0) goto L_0x014e
            r6.onSizeChange()
        L_0x014e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.onStateChange(int[], int[]):boolean");
    }

    private void setChipSurfaceColor(ColorStateList colorStateList) {
        if (this.chipSurfaceColor != colorStateList) {
            this.chipSurfaceColor = colorStateList;
            onStateChange(getState());
        }
    }

    private boolean showsCheckedIcon() {
        return this.checkedIconVisible && this.checkedIcon != null && this.currentChecked;
    }

    private boolean showsChipIcon() {
        return this.chipIconVisible && this.chipIcon != null;
    }

    private boolean showsCloseIcon() {
        return this.closeIconVisible && this.closeIcon != null;
    }

    private void unapplyChildDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    private void updateCompatRippleColor() {
        this.compatRippleColor = this.useCompatRipple ? RippleUtils.sanitizeRippleDrawableColor(this.rippleColor) : null;
    }

    @TargetApi(21)
    private void updateFrameworkCloseIconRipple() {
        this.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(getRippleColor()), this.closeIcon, closeIconRippleMask);
    }

    /* access modifiers changed from: package-private */
    public float calculateChipIconWidth() {
        if (showsChipIcon() || showsCheckedIcon()) {
            return this.iconStartPadding + this.chipIconSize + this.iconEndPadding;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public float calculateCloseIconWidth() {
        if (showsCloseIcon()) {
            return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public Paint.Align calculateTextOriginAndAlignment(Rect rect, PointF pointF2) {
        pointF2.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.text != null) {
            float calculateChipIconWidth = this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding;
            if (C0595a.m2332i(this) == 0) {
                pointF2.x = ((float) rect.left) + calculateChipIconWidth;
                align = Paint.Align.LEFT;
            } else {
                pointF2.x = ((float) rect.right) - calculateChipIconWidth;
                align = Paint.Align.RIGHT;
            }
            pointF2.y = ((float) rect.centerY()) - calculateTextCenterFromBaseline();
        }
        return align;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i = 0;
            if (this.alpha < 255) {
                i = CanvasCompat.saveLayerAlpha(canvas, (float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, this.alpha);
            }
            drawChipSurface(canvas, bounds);
            drawChipBackground(canvas, bounds);
            if (this.isShapeThemingEnabled) {
                super.draw(canvas);
            }
            drawChipStroke(canvas, bounds);
            drawCompatRipple(canvas, bounds);
            drawChipIcon(canvas, bounds);
            drawCheckedIcon(canvas, bounds);
            if (this.shouldDrawText) {
                drawText(canvas, bounds);
            }
            drawCloseIcon(canvas, bounds);
            drawDebug(canvas, bounds);
            if (this.alpha < 255) {
                canvas.restoreToCount(i);
            }
        }
    }

    public int getAlpha() {
        return this.alpha;
    }

    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    public ColorStateList getChipBackgroundColor() {
        return this.chipBackgroundColor;
    }

    public float getChipCornerRadius() {
        return this.isShapeThemingEnabled ? getTopLeftCornerResolvedSize() : this.chipCornerRadius;
    }

    public float getChipEndPadding() {
        return this.chipEndPadding;
    }

    public Drawable getChipIcon() {
        Drawable drawable = this.chipIcon;
        if (drawable != null) {
            return C0595a.m2331h(drawable);
        }
        return null;
    }

    public float getChipIconSize() {
        return this.chipIconSize;
    }

    public ColorStateList getChipIconTint() {
        return this.chipIconTint;
    }

    public float getChipMinHeight() {
        return this.chipMinHeight;
    }

    public float getChipStartPadding() {
        return this.chipStartPadding;
    }

    public ColorStateList getChipStrokeColor() {
        return this.chipStrokeColor;
    }

    public float getChipStrokeWidth() {
        return this.chipStrokeWidth;
    }

    public void getChipTouchBounds(RectF rectF2) {
        calculateChipTouchBounds(getBounds(), rectF2);
    }

    public Drawable getCloseIcon() {
        Drawable drawable = this.closeIcon;
        if (drawable != null) {
            return C0595a.m2331h(drawable);
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        return this.closeIconContentDescription;
    }

    public float getCloseIconEndPadding() {
        return this.closeIconEndPadding;
    }

    public float getCloseIconSize() {
        return this.closeIconSize;
    }

    public float getCloseIconStartPadding() {
        return this.closeIconStartPadding;
    }

    public int[] getCloseIconState() {
        return this.closeIconStateSet;
    }

    public ColorStateList getCloseIconTint() {
        return this.closeIconTint;
    }

    public void getCloseIconTouchBounds(RectF rectF2) {
        calculateCloseIconTouchBounds(getBounds(), rectF2);
    }

    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public TextUtils.TruncateAt getEllipsize() {
        return this.truncateAt;
    }

    public MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getIconEndPadding() {
        return this.iconEndPadding;
    }

    public float getIconStartPadding() {
        return this.iconStartPadding;
    }

    public int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.chipStartPadding + calculateChipIconWidth() + this.textStartPadding + this.textDrawableHelper.getTextWidth(getText().toString()) + this.textEndPadding + calculateCloseIconWidth() + this.chipEndPadding), this.maxWidth);
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.isShapeThemingEnabled) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.chipCornerRadius);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.chipCornerRadius);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    public CharSequence getText() {
        return this.text;
    }

    public TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public float getTextEndPadding() {
        return this.textEndPadding;
    }

    public float getTextStartPadding() {
        return this.textStartPadding;
    }

    public boolean getUseCompatRipple() {
        return this.useCompatRipple;
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    @Deprecated
    public boolean isCheckedIconEnabled() {
        return isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        return this.checkedIconVisible;
    }

    @Deprecated
    public boolean isChipIconEnabled() {
        return isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        return this.chipIconVisible;
    }

    @Deprecated
    public boolean isCloseIconEnabled() {
        return isCloseIconVisible();
    }

    public boolean isCloseIconStateful() {
        return isStateful(this.closeIcon);
    }

    public boolean isCloseIconVisible() {
        return this.closeIconVisible;
    }

    /* access modifiers changed from: package-private */
    public boolean isShapeThemingEnabled() {
        return this.isShapeThemingEnabled;
    }

    public boolean isStateful() {
        return isStateful(this.chipSurfaceColor) || isStateful(this.chipBackgroundColor) || isStateful(this.chipStrokeColor) || (this.useCompatRipple && isStateful(this.compatRippleColor)) || isStateful(this.textDrawableHelper.getTextAppearance()) || canShowCheckedIcon() || isStateful(this.chipIcon) || isStateful(this.checkedIcon) || isStateful(this.tint);
    }

    public boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (showsChipIcon()) {
            onLayoutDirectionChanged |= C0595a.m2325b(this.chipIcon, i);
        }
        if (showsCheckedIcon()) {
            onLayoutDirectionChanged |= C0595a.m2325b(this.checkedIcon, i);
        }
        if (showsCloseIcon()) {
            onLayoutDirectionChanged |= C0595a.m2325b(this.closeIcon, i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (showsChipIcon()) {
            onLevelChange |= this.chipIcon.setLevel(i);
        }
        if (showsCheckedIcon()) {
            onLevelChange |= this.checkedIcon.setLevel(i);
        }
        if (showsCloseIcon()) {
            onLevelChange |= this.closeIcon.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    /* access modifiers changed from: protected */
    public void onSizeChange() {
        Delegate delegate2 = (Delegate) this.delegate.get();
        if (delegate2 != null) {
            delegate2.onChipDrawableSizeChange();
        }
    }

    public boolean onStateChange(int[] iArr) {
        if (this.isShapeThemingEnabled) {
            super.onStateChange(iArr);
        }
        return onStateChange(iArr, getCloseIconState());
    }

    public void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.alpha != i) {
            this.alpha = i;
            invalidateSelf();
        }
    }

    public void setCheckable(boolean z) {
        if (this.checkable != z) {
            this.checkable = z;
            float calculateChipIconWidth = calculateChipIconWidth();
            if (!z && this.currentChecked) {
                this.currentChecked = false;
            }
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCheckableResource(int i) {
        setCheckable(this.context.getResources().getBoolean(i));
    }

    public void setCheckedIcon(Drawable drawable) {
        if (this.checkedIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.checkedIcon = drawable;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(this.checkedIcon);
            applyChildDrawable(this.checkedIcon);
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(this.context.getResources().getBoolean(i));
    }

    public void setCheckedIconResource(int i) {
        setCheckedIcon(C0070a.m63b(this.context, i));
    }

    public void setCheckedIconVisible(int i) {
        setCheckedIconVisible(this.context.getResources().getBoolean(i));
    }

    public void setCheckedIconVisible(boolean z) {
        if (this.checkedIconVisible != z) {
            boolean showsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z;
            boolean showsCheckedIcon2 = showsCheckedIcon();
            if (showsCheckedIcon != showsCheckedIcon2) {
                if (showsCheckedIcon2) {
                    applyChildDrawable(this.checkedIcon);
                } else {
                    unapplyChildDrawable(this.checkedIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        if (this.chipBackgroundColor != colorStateList) {
            this.chipBackgroundColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setChipBackgroundColorResource(int i) {
        setChipBackgroundColor(C0070a.m60a(this.context, i));
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        if (this.chipCornerRadius != f) {
            this.chipCornerRadius = f;
            setShapeAppearanceModel(getShapeAppearanceModel().withCornerSize(f));
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        setChipCornerRadius(this.context.getResources().getDimension(i));
    }

    public void setChipEndPadding(float f) {
        if (this.chipEndPadding != f) {
            this.chipEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipEndPaddingResource(int i) {
        setChipEndPadding(this.context.getResources().getDimension(i));
    }

    public void setChipIcon(Drawable drawable) {
        Drawable chipIcon2 = getChipIcon();
        if (chipIcon2 != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIcon = drawable != null ? C0595a.m2330g(drawable).mutate() : null;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(chipIcon2);
            if (showsChipIcon()) {
                applyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        setChipIcon(C0070a.m63b(this.context, i));
    }

    public void setChipIconSize(float f) {
        if (this.chipIconSize != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIconSize = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setChipIconSizeResource(int i) {
        setChipIconSize(this.context.getResources().getDimension(i));
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        this.hasChipIconTint = true;
        if (this.chipIconTint != colorStateList) {
            this.chipIconTint = colorStateList;
            if (showsChipIcon()) {
                C0595a.m2319a(this.chipIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipIconTintResource(int i) {
        setChipIconTint(C0070a.m60a(this.context, i));
    }

    public void setChipIconVisible(int i) {
        setChipIconVisible(this.context.getResources().getBoolean(i));
    }

    public void setChipIconVisible(boolean z) {
        if (this.chipIconVisible != z) {
            boolean showsChipIcon = showsChipIcon();
            this.chipIconVisible = z;
            boolean showsChipIcon2 = showsChipIcon();
            if (showsChipIcon != showsChipIcon2) {
                if (showsChipIcon2) {
                    applyChildDrawable(this.chipIcon);
                } else {
                    unapplyChildDrawable(this.chipIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setChipMinHeight(float f) {
        if (this.chipMinHeight != f) {
            this.chipMinHeight = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipMinHeightResource(int i) {
        setChipMinHeight(this.context.getResources().getDimension(i));
    }

    public void setChipStartPadding(float f) {
        if (this.chipStartPadding != f) {
            this.chipStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setChipStartPaddingResource(int i) {
        setChipStartPadding(this.context.getResources().getDimension(i));
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        if (this.chipStrokeColor != colorStateList) {
            this.chipStrokeColor = colorStateList;
            if (this.isShapeThemingEnabled) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setChipStrokeColorResource(int i) {
        setChipStrokeColor(C0070a.m60a(this.context, i));
    }

    public void setChipStrokeWidth(float f) {
        if (this.chipStrokeWidth != f) {
            this.chipStrokeWidth = f;
            this.chipPaint.setStrokeWidth(f);
            if (this.isShapeThemingEnabled) {
                super.setStrokeWidth(f);
            }
            invalidateSelf();
        }
    }

    public void setChipStrokeWidthResource(int i) {
        setChipStrokeWidth(this.context.getResources().getDimension(i));
    }

    public void setCloseIcon(Drawable drawable) {
        Drawable closeIcon2 = getCloseIcon();
        if (closeIcon2 != drawable) {
            float calculateCloseIconWidth = calculateCloseIconWidth();
            this.closeIcon = drawable != null ? C0595a.m2330g(drawable).mutate() : null;
            if (RippleUtils.USE_FRAMEWORK_RIPPLE) {
                updateFrameworkCloseIconRipple();
            }
            float calculateCloseIconWidth2 = calculateCloseIconWidth();
            unapplyChildDrawable(closeIcon2);
            if (showsCloseIcon()) {
                applyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            if (calculateCloseIconWidth != calculateCloseIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        if (this.closeIconContentDescription != charSequence) {
            this.closeIconContentDescription = C0564a.m2205a().mo3569a(charSequence);
            invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        if (this.closeIconEndPadding != f) {
            this.closeIconEndPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        setCloseIconEndPadding(this.context.getResources().getDimension(i));
    }

    public void setCloseIconResource(int i) {
        setCloseIcon(C0070a.m63b(this.context, i));
    }

    public void setCloseIconSize(float f) {
        if (this.closeIconSize != f) {
            this.closeIconSize = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconSizeResource(int i) {
        setCloseIconSize(this.context.getResources().getDimension(i));
    }

    public void setCloseIconStartPadding(float f) {
        if (this.closeIconStartPadding != f) {
            this.closeIconStartPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        setCloseIconStartPadding(this.context.getResources().getDimension(i));
    }

    public boolean setCloseIconState(int[] iArr) {
        if (Arrays.equals(this.closeIconStateSet, iArr)) {
            return false;
        }
        this.closeIconStateSet = iArr;
        if (showsCloseIcon()) {
            return onStateChange(getState(), iArr);
        }
        return false;
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        if (this.closeIconTint != colorStateList) {
            this.closeIconTint = colorStateList;
            if (showsCloseIcon()) {
                C0595a.m2319a(this.closeIcon, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void setCloseIconTintResource(int i) {
        setCloseIconTint(C0070a.m60a(this.context, i));
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(this.context.getResources().getBoolean(i));
    }

    public void setCloseIconVisible(boolean z) {
        if (this.closeIconVisible != z) {
            boolean showsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z;
            boolean showsCloseIcon2 = showsCloseIcon();
            if (showsCloseIcon != showsCloseIcon2) {
                if (showsCloseIcon2) {
                    applyChildDrawable(this.closeIcon);
                } else {
                    unapplyChildDrawable(this.closeIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter2) {
        if (this.colorFilter != colorFilter2) {
            this.colorFilter = colorFilter2;
            invalidateSelf();
        }
    }

    public void setDelegate(Delegate delegate2) {
        this.delegate = new WeakReference<>(delegate2);
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt2) {
        this.truncateAt = truncateAt2;
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(MotionSpec.createFromResource(this.context, i));
    }

    public void setIconEndPadding(float f) {
        if (this.iconEndPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconEndPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setIconEndPaddingResource(int i) {
        setIconEndPadding(this.context.getResources().getDimension(i));
    }

    public void setIconStartPadding(float f) {
        if (this.iconStartPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconStartPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public void setIconStartPaddingResource(int i) {
        setIconStartPadding(this.context.getResources().getDimension(i));
    }

    public void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    public void setRippleColorResource(int i) {
        setRippleColor(C0070a.m60a(this.context, i));
    }

    /* access modifiers changed from: package-private */
    public void setShouldDrawText(boolean z) {
        this.shouldDrawText = z;
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(MotionSpec.createFromResource(this.context, i));
    }

    public void setText(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (!TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textDrawableHelper.setTextWidthDirty(true);
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextAppearance(TextAppearance textAppearance) {
        this.textDrawableHelper.setTextAppearance(textAppearance, this.context);
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(new TextAppearance(this.context, i));
    }

    public void setTextEndPadding(float f) {
        if (this.textEndPadding != f) {
            this.textEndPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextEndPaddingResource(int i) {
        setTextEndPadding(this.context.getResources().getDimension(i));
    }

    public void setTextResource(int i) {
        setText(this.context.getResources().getString(i));
    }

    public void setTextStartPadding(float f) {
        if (this.textStartPadding != f) {
            this.textStartPadding = f;
            invalidateSelf();
            onSizeChange();
        }
    }

    public void setTextStartPaddingResource(int i) {
        setTextStartPadding(this.context.getResources().getDimension(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.tintMode != mode) {
            this.tintMode = mode;
            this.tintFilter = DrawableUtils.updateTintFilter(this, this.tint, mode);
            invalidateSelf();
        }
    }

    public void setUseCompatRipple(boolean z) {
        if (this.useCompatRipple != z) {
            this.useCompatRipple = z;
            updateCompatRippleColor();
            onStateChange(getState());
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (showsChipIcon()) {
            visible |= this.chipIcon.setVisible(z, z2);
        }
        if (showsCheckedIcon()) {
            visible |= this.checkedIcon.setVisible(z, z2);
        }
        if (showsCloseIcon()) {
            visible |= this.closeIcon.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
