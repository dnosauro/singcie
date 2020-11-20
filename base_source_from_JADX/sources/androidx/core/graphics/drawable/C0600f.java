package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* renamed from: androidx.core.graphics.drawable.f */
final class C0600f extends Drawable.ConstantState {

    /* renamed from: a */
    int f2216a;

    /* renamed from: b */
    Drawable.ConstantState f2217b;

    /* renamed from: c */
    ColorStateList f2218c = null;

    /* renamed from: d */
    PorterDuff.Mode f2219d = C0598d.f2208a;

    C0600f(C0600f fVar) {
        if (fVar != null) {
            this.f2216a = fVar.f2216a;
            this.f2217b = fVar.f2217b;
            this.f2218c = fVar.f2218c;
            this.f2219d = fVar.f2219d;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo3661a() {
        return this.f2217b != null;
    }

    public int getChangingConfigurations() {
        int i = this.f2216a;
        Drawable.ConstantState constantState = this.f2217b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    public Drawable newDrawable() {
        return newDrawable((Resources) null);
    }

    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new C0599e(this, resources) : new C0598d(this, resources);
    }
}
