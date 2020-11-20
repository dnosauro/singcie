package androidx.p049j;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* renamed from: androidx.j.ab */
class C0826ab implements C0827ac {

    /* renamed from: a */
    private final ViewOverlay f2782a;

    C0826ab(View view) {
        this.f2782a = view.getOverlay();
    }

    /* renamed from: a */
    public void mo4656a(Drawable drawable) {
        this.f2782a.add(drawable);
    }

    /* renamed from: b */
    public void mo4657b(Drawable drawable) {
        this.f2782a.remove(drawable);
    }
}
