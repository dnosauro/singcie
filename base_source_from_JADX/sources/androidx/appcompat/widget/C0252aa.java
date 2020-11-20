package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.p009a.p010a.C0070a;
import androidx.core.graphics.C0593c;
import androidx.core.p028f.C0568c;
import androidx.core.p030h.C0655t;
import androidx.core.widget.C0680b;
import androidx.core.widget.C0687i;
import androidx.core.widget.C0690k;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* renamed from: androidx.appcompat.widget.aa */
public class C0252aa extends TextView implements C0655t, C0680b, C0690k {
    private final C0332f mBackgroundTintHelper;
    private Future<C0568c> mPrecomputedTextFuture;
    private final C0363y mTextClassifierHelper;
    private final C0364z mTextHelper;

    public C0252aa(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0252aa(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public C0252aa(Context context, AttributeSet attributeSet, int i) {
        super(C0299av.m1073a(context), attributeSet, i);
        this.mBackgroundTintHelper = new C0332f(this);
        this.mBackgroundTintHelper.mo2504a(attributeSet, i);
        this.mTextHelper = new C0364z(this);
        this.mTextHelper.mo2692a(attributeSet, i);
        this.mTextHelper.mo2697b();
        this.mTextClassifierHelper = new C0363y(this);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<C0568c> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                C0687i.m2811a((TextView) this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.mo2507c();
        }
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2697b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (f2403d) {
            return super.getAutoSizeMaxTextSize();
        }
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            return zVar.mo2703h();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (f2403d) {
            return super.getAutoSizeMinTextSize();
        }
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            return zVar.mo2702g();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (f2403d) {
            return super.getAutoSizeStepGranularity();
        }
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            return zVar.mo2701f();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (f2403d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0364z zVar = this.mTextHelper;
        return zVar != null ? zVar.mo2704i() : new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (f2403d) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            return zVar.mo2700e();
        }
        return 0;
    }

    public int getFirstBaselineToTopHeight() {
        return C0687i.m2814c(this);
    }

    public int getLastBaselineToBottomHeight() {
        return C0687i.m2816d(this);
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            return fVar.mo2499a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            return fVar.mo2505b();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.mo2705j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.mo2706k();
    }

    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.mTextClassifierHelper;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.textclassifier.TextClassifier getTextClassifier() {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L_0x0010
            androidx.appcompat.widget.y r0 = r2.mTextClassifierHelper
            if (r0 != 0) goto L_0x000b
            goto L_0x0010
        L_0x000b:
            android.view.textclassifier.TextClassifier r0 = r0.mo2682a()
            return r0
        L_0x0010:
            android.view.textclassifier.TextClassifier r0 = super.getTextClassifier()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0252aa.getTextClassifier():android.view.textclassifier.TextClassifier");
    }

    public C0568c.C0569a getTextMetricsParamsCompat() {
        return C0687i.m2818e(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0340m.m1261a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2695a(z, i, i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.mTextHelper != null && !f2403d && this.mTextHelper.mo2699d()) {
            this.mTextHelper.mo2698c();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (f2403d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2687a(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (f2403d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2696a(iArr, i);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (f2403d) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2685a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.mo2503a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.mo2500a(i);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2684a();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2684a();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b = i != 0 ? C0070a.m63b(context, i) : null;
        Drawable b2 = i2 != 0 ? C0070a.m63b(context, i2) : null;
        Drawable b3 = i3 != 0 ? C0070a.m63b(context, i3) : null;
        if (i4 != 0) {
            drawable = C0070a.m63b(context, i4);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b, b2, b3, drawable);
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2684a();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2684a();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b = i != 0 ? C0070a.m63b(context, i) : null;
        Drawable b2 = i2 != 0 ? C0070a.m63b(context, i2) : null;
        Drawable b3 = i3 != 0 ? C0070a.m63b(context, i3) : null;
        if (i4 != 0) {
            drawable = C0070a.m63b(context, i4);
        }
        setCompoundDrawablesWithIntrinsicBounds(b, b2, b3, drawable);
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2684a();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2684a();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0687i.m2804a((TextView) this, callback));
    }

    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            C0687i.m2812b(this, i);
        }
    }

    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            C0687i.m2815c(this, i);
        }
    }

    public void setLineHeight(int i) {
        C0687i.m2817d(this, i);
    }

    public void setPrecomputedText(C0568c cVar) {
        C0687i.m2811a((TextView) this, cVar);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.mo2501a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0332f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.mo2502a(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.mo2689a(colorStateList);
        this.mTextHelper.mo2697b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.mo2690a(mode);
        this.mTextHelper.mo2697b();
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2688a(context, i);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        C0363y yVar;
        if (Build.VERSION.SDK_INT >= 28 || (yVar = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            yVar.mo2683a(textClassifier);
        }
    }

    public void setTextFuture(Future<C0568c> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(C0568c.C0569a aVar) {
        C0687i.m2810a((TextView) this, aVar);
    }

    public void setTextSize(int i, float f) {
        if (f2403d) {
            super.setTextSize(i, f);
            return;
        }
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2686a(i, f);
        }
    }

    public void setTypeface(Typeface typeface, int i) {
        Typeface a = (typeface == null || i <= 0) ? null : C0593c.m2290a(getContext(), typeface, i);
        if (a != null) {
            typeface = a;
        }
        super.setTypeface(typeface, i);
    }
}
