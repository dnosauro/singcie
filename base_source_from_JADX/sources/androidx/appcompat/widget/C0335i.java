package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.appcompat.p009a.p010a.C0070a;
import androidx.core.widget.C0687i;

/* renamed from: androidx.appcompat.widget.i */
public class C0335i extends CheckedTextView {

    /* renamed from: a */
    private static final int[] f1204a = {16843016};

    /* renamed from: b */
    private final C0364z f1205b;

    public C0335i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public C0335i(Context context, AttributeSet attributeSet, int i) {
        super(C0299av.m1073a(context), attributeSet, i);
        this.f1205b = new C0364z(this);
        this.f1205b.mo2692a(attributeSet, i);
        this.f1205b.mo2697b();
        C0302ay a = C0302ay.m1078a(getContext(), attributeSet, f1204a, i, 0);
        setCheckMarkDrawable(a.mo2409a(0));
        a.mo2410a();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0364z zVar = this.f1205b;
        if (zVar != null) {
            zVar.mo2697b();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0340m.m1261a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(C0070a.m63b(getContext(), i));
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(C0687i.m2804a((TextView) this, callback));
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0364z zVar = this.f1205b;
        if (zVar != null) {
            zVar.mo2688a(context, i);
        }
    }
}
