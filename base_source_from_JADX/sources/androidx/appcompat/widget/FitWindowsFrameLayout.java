package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.appcompat.widget.C0261ah;

public class FitWindowsFrameLayout extends FrameLayout implements C0261ah {

    /* renamed from: a */
    private C0261ah.C0262a f816a;

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        C0261ah.C0262a aVar = this.f816a;
        if (aVar != null) {
            aVar.mo908a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(C0261ah.C0262a aVar) {
        this.f816a = aVar;
    }
}
