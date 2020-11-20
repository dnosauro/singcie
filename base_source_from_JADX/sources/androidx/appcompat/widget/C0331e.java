package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.p009a.p010a.C0070a;
import androidx.core.p030h.C0655t;
import androidx.core.widget.C0687i;

/* renamed from: androidx.appcompat.widget.e */
public class C0331e extends AutoCompleteTextView implements C0655t {

    /* renamed from: a */
    private static final int[] f1195a = {16843126};

    /* renamed from: b */
    private final C0332f f1196b;

    /* renamed from: c */
    private final C0364z f1197c;

    public C0331e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0059a.C0060a.autoCompleteTextViewStyle);
    }

    public C0331e(Context context, AttributeSet attributeSet, int i) {
        super(C0299av.m1073a(context), attributeSet, i);
        C0302ay a = C0302ay.m1078a(getContext(), attributeSet, f1195a, i, 0);
        if (a.mo2424g(0)) {
            setDropDownBackgroundDrawable(a.mo2409a(0));
        }
        a.mo2410a();
        this.f1196b = new C0332f(this);
        this.f1196b.mo2504a(attributeSet, i);
        this.f1197c = new C0364z(this);
        this.f1197c.mo2692a(attributeSet, i);
        this.f1197c.mo2697b();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0332f fVar = this.f1196b;
        if (fVar != null) {
            fVar.mo2507c();
        }
        C0364z zVar = this.f1197c;
        if (zVar != null) {
            zVar.mo2697b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0332f fVar = this.f1196b;
        if (fVar != null) {
            return fVar.mo2499a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0332f fVar = this.f1196b;
        if (fVar != null) {
            return fVar.mo2505b();
        }
        return null;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0340m.m1261a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0332f fVar = this.f1196b;
        if (fVar != null) {
            fVar.mo2503a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C0332f fVar = this.f1196b;
        if (fVar != null) {
            fVar.mo2500a(i);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0687i.m2804a((TextView) this, callback));
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(C0070a.m63b(getContext(), i));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0332f fVar = this.f1196b;
        if (fVar != null) {
            fVar.mo2501a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0332f fVar = this.f1196b;
        if (fVar != null) {
            fVar.mo2502a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0364z zVar = this.f1197c;
        if (zVar != null) {
            zVar.mo2688a(context, i);
        }
    }
}
