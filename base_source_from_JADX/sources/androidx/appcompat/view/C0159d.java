package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.C0059a;

/* renamed from: androidx.appcompat.view.d */
public class C0159d extends ContextWrapper {

    /* renamed from: a */
    private int f430a;

    /* renamed from: b */
    private Resources.Theme f431b;

    /* renamed from: c */
    private LayoutInflater f432c;

    /* renamed from: d */
    private Configuration f433d;

    /* renamed from: e */
    private Resources f434e;

    public C0159d() {
        super((Context) null);
    }

    public C0159d(Context context, int i) {
        super(context);
        this.f430a = i;
    }

    public C0159d(Context context, Resources.Theme theme) {
        super(context);
        this.f431b = theme;
    }

    /* renamed from: b */
    private Resources m477b() {
        Resources resources;
        if (this.f434e == null) {
            if (this.f433d == null) {
                resources = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                resources = createConfigurationContext(this.f433d).getResources();
            }
            this.f434e = resources;
        }
        return this.f434e;
    }

    /* renamed from: c */
    private void m478c() {
        boolean z = this.f431b == null;
        if (z) {
            this.f431b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f431b.setTo(theme);
            }
        }
        mo1141a(this.f431b, this.f430a, z);
    }

    /* renamed from: a */
    public int mo1140a() {
        return this.f430a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1141a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        return m477b();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f432c == null) {
            this.f432c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f432c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f431b;
        if (theme != null) {
            return theme;
        }
        if (this.f430a == 0) {
            this.f430a = C0059a.C0068i.Theme_AppCompat_Light;
        }
        m478c();
        return this.f431b;
    }

    public void setTheme(int i) {
        if (this.f430a != i) {
            this.f430a = i;
            m478c();
        }
    }
}
