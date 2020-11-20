package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.widget.av */
public class C0299av extends ContextWrapper {

    /* renamed from: a */
    private static final Object f1084a = new Object();

    /* renamed from: b */
    private static ArrayList<WeakReference<C0299av>> f1085b;

    /* renamed from: c */
    private final Resources f1086c;

    /* renamed from: d */
    private final Resources.Theme f1087d;

    private C0299av(Context context) {
        super(context);
        if (C0312bd.m1159a()) {
            this.f1086c = new C0312bd(this, context.getResources());
            this.f1087d = this.f1086c.newTheme();
            this.f1087d.setTo(context.getTheme());
            return;
        }
        this.f1086c = new C0301ax(this, context.getResources());
        this.f1087d = null;
    }

    /* renamed from: a */
    public static Context m1073a(Context context) {
        if (!m1074b(context)) {
            return context;
        }
        synchronized (f1084a) {
            if (f1085b == null) {
                f1085b = new ArrayList<>();
            } else {
                for (int size = f1085b.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = f1085b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1085b.remove(size);
                    }
                }
                for (int size2 = f1085b.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = f1085b.get(size2);
                    C0299av avVar = weakReference2 != null ? (C0299av) weakReference2.get() : null;
                    if (avVar != null && avVar.getBaseContext() == context) {
                        return avVar;
                    }
                }
            }
            C0299av avVar2 = new C0299av(context);
            f1085b.add(new WeakReference(avVar2));
            return avVar2;
        }
    }

    /* renamed from: b */
    private static boolean m1074b(Context context) {
        if ((context instanceof C0299av) || (context.getResources() instanceof C0301ax) || (context.getResources() instanceof C0312bd)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || C0312bd.m1159a();
    }

    public AssetManager getAssets() {
        return this.f1086c.getAssets();
    }

    public Resources getResources() {
        return this.f1086c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1087d;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i) {
        Resources.Theme theme = this.f1087d;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
