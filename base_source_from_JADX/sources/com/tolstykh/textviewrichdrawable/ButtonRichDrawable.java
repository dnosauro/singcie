package com.tolstykh.textviewrichdrawable;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.C0333g;
import com.tolstykh.textviewrichdrawable.p156a.C3119a;

public class ButtonRichDrawable extends C0333g {

    /* renamed from: a */
    private C3119a f7251a;

    public ButtonRichDrawable(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m8963a(context, attributeSet, 0, 0);
    }

    /* renamed from: a */
    private void m8963a(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f7251a = new C3119a(context, attributeSet, i, i2);
        this.f7251a.mo24019a((TextView) this);
    }

    public int getCompoundDrawableHeight() {
        return this.f7251a.mo24017a();
    }

    public int getCompoundDrawableWidth() {
        return this.f7251a.mo24020b();
    }

    public void setDrawableBottomVectorId(int i) {
        this.f7251a.mo24023d(i);
        this.f7251a.mo24019a((TextView) this);
    }

    public void setDrawableEndVectorId(int i) {
        this.f7251a.mo24021b(i);
        this.f7251a.mo24019a((TextView) this);
    }

    public void setDrawableStartVectorId(int i) {
        this.f7251a.mo24018a(i);
        this.f7251a.mo24019a((TextView) this);
    }

    public void setDrawableTopVectorId(int i) {
        this.f7251a.mo24022c(i);
        this.f7251a.mo24019a((TextView) this);
    }
}
