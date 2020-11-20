package androidx.p049j;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* renamed from: androidx.j.w */
class C0894w implements C0895x {

    /* renamed from: a */
    private final ViewGroupOverlay f2924a;

    C0894w(ViewGroup viewGroup) {
        this.f2924a = viewGroup.getOverlay();
    }

    /* renamed from: a */
    public void mo4656a(Drawable drawable) {
        this.f2924a.add(drawable);
    }

    /* renamed from: a */
    public void mo4834a(View view) {
        this.f2924a.add(view);
    }

    /* renamed from: b */
    public void mo4657b(Drawable drawable) {
        this.f2924a.remove(drawable);
    }

    /* renamed from: b */
    public void mo4835b(View view) {
        this.f2924a.remove(view);
    }
}
