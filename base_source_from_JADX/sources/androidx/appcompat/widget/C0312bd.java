package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.widget.bd */
public class C0312bd extends Resources {

    /* renamed from: a */
    private static boolean f1139a = false;

    /* renamed from: b */
    private final WeakReference<Context> f1140b;

    public C0312bd(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1140b = new WeakReference<>(context);
    }

    /* renamed from: a */
    public static void m1158a(boolean z) {
        f1139a = z;
    }

    /* renamed from: a */
    public static boolean m1159a() {
        return m1160b() && Build.VERSION.SDK_INT <= 20;
    }

    /* renamed from: b */
    public static boolean m1160b() {
        return f1139a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Drawable mo2450a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f1140b.get();
        return context != null ? C0279an.m994a().mo2243a(context, this, i) : super.getDrawable(i);
    }
}
