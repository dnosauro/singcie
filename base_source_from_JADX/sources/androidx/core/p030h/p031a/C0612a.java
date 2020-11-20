package androidx.core.p030h.p031a;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* renamed from: androidx.core.h.a.a */
public final class C0612a extends ClickableSpan {

    /* renamed from: a */
    private final int f2235a;

    /* renamed from: b */
    private final C0614c f2236b;

    /* renamed from: c */
    private final int f2237c;

    public C0612a(int i, C0614c cVar, int i2) {
        this.f2235a = i;
        this.f2236b = cVar;
        this.f2237c = i2;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f2235a);
        this.f2236b.mo3712a(this.f2237c, bundle);
    }
}
