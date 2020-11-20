package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.C0059a;
import androidx.appcompat.p009a.p010a.C0070a;
import androidx.core.p030h.C0655t;
import androidx.core.widget.C0689j;

/* renamed from: androidx.appcompat.widget.t */
public class C0347t extends RadioButton implements C0655t, C0689j {
    private final C0332f mBackgroundTintHelper;
    private final C0336j mCompoundButtonHelper;
    private final C0364z mTextHelper;

    public C0347t(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0347t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.C0060a.radioButtonStyle);
    }

    public C0347t(Context context, AttributeSet attributeSet, int i) {
        super(C0299av.m1073a(context), attributeSet, i);
        this.mCompoundButtonHelper = new C0336j(this);
        this.mCompoundButtonHelper.mo2546a(attributeSet, i);
        this.mBackgroundTintHelper = new C0332f(this);
        this.mBackgroundTintHelper.mo2504a(attributeSet, i);
        this.mTextHelper = new C0364z(this);
        this.mTextHelper.mo2692a(attributeSet, i);
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

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0336j jVar = this.mCompoundButtonHelper;
        return jVar != null ? jVar.mo2542a(compoundPaddingLeft) : compoundPaddingLeft;
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

    public ColorStateList getSupportButtonTintList() {
        C0336j jVar = this.mCompoundButtonHelper;
        if (jVar != null) {
            return jVar.mo2543a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0336j jVar = this.mCompoundButtonHelper;
        if (jVar != null) {
            return jVar.mo2547b();
        }
        return null;
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

    public void setButtonDrawable(int i) {
        setButtonDrawable(C0070a.m63b(getContext(), i));
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0336j jVar = this.mCompoundButtonHelper;
        if (jVar != null) {
            jVar.mo2548c();
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

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0336j jVar = this.mCompoundButtonHelper;
        if (jVar != null) {
            jVar.mo2544a(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0336j jVar = this.mCompoundButtonHelper;
        if (jVar != null) {
            jVar.mo2545a(mode);
        }
    }
}
