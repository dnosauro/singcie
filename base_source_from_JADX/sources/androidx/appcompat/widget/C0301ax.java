package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.widget.ax */
class C0301ax extends C0286ao {

    /* renamed from: a */
    private final WeakReference<Context> f1092a;

    public C0301ax(Context context, Resources resources) {
        super(resources);
        this.f1092a = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f1092a.get();
        if (!(drawable == null || context == null)) {
            C0279an.m994a().mo2246a(context, i, drawable);
        }
        return drawable;
    }
}
