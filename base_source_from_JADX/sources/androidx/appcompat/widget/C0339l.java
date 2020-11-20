package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.core.p030h.C0655t;
import androidx.core.widget.C0687i;

/* renamed from: androidx.appcompat.widget.l */
public class C0339l extends EditText implements C0655t {
    private final C0332f mBackgroundTintHelper;
    private final C0363y mTextClassifierHelper;
    private final C0364z mTextHelper;

    public C0339l(Context context) {
        this(context, (AttributeSet) null);
    }

    public C0339l(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.C0060a.editTextStyle);
    }

    public C0339l(Context context, AttributeSet attributeSet, int i) {
        super(C0299av.m1073a(context), attributeSet, i);
        this.mBackgroundTintHelper = new C0332f(this);
        this.mBackgroundTintHelper.mo2504a(attributeSet, i);
        this.mTextHelper = new C0364z(this);
        this.mTextHelper.mo2692a(attributeSet, i);
        this.mTextHelper.mo2697b();
        this.mTextClassifierHelper = new C0363y(this);
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

    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0339l.getTextClassifier():android.view.textclassifier.TextClassifier");
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0340m.m1261a(super.onCreateInputConnection(editorInfo), editorInfo, this);
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

    public void setTextClassifier(TextClassifier textClassifier) {
        C0363y yVar;
        if (Build.VERSION.SDK_INT >= 28 || (yVar = this.mTextClassifierHelper) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            yVar.mo2683a(textClassifier);
        }
    }
}
