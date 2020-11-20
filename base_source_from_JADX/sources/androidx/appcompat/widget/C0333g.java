package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.core.p030h.C0655t;
import androidx.core.widget.C0680b;
import androidx.core.widget.C0687i;

/* renamed from: androidx.appcompat.widget.g */
public class C0333g extends Button implements C0655t, C0680b {
    private final C0332f mBackgroundTintHelper;
    private final C0364z mTextHelper;

    public C0333g(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0333g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.C0060a.buttonStyle);
    }

    public C0333g(Context context, AttributeSet attributeSet, int i) {
        super(C0299av.m1073a(context), attributeSet, i);
        this.mBackgroundTintHelper = new C0332f(this);
        this.mBackgroundTintHelper.mo2504a(attributeSet, i);
        this.mTextHelper = new C0364z(this);
        this.mTextHelper.mo2692a(attributeSet, i);
        this.mTextHelper.mo2697b();
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

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
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

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0687i.m2804a((TextView) this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2694a(z);
        }
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

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0364z zVar = this.mTextHelper;
        if (zVar != null) {
            zVar.mo2688a(context, i);
        }
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
}
