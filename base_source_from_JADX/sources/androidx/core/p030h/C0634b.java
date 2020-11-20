package androidx.core.p030h;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: androidx.core.h.b */
public abstract class C0634b {

    /* renamed from: a */
    private final Context f2290a;

    /* renamed from: b */
    private C0635a f2291b;

    /* renamed from: c */
    private C0636b f2292c;

    /* renamed from: androidx.core.h.b$a */
    public interface C0635a {
        /* renamed from: c */
        void mo2459c(boolean z);
    }

    /* renamed from: androidx.core.h.b$b */
    public interface C0636b {
        /* renamed from: a */
        void mo1511a(boolean z);
    }

    public C0634b(Context context) {
        this.f2290a = context;
    }

    /* renamed from: a */
    public abstract View mo1567a();

    /* renamed from: a */
    public View mo1571a(MenuItem menuItem) {
        return mo1567a();
    }

    /* renamed from: a */
    public void mo1568a(SubMenu subMenu) {
    }

    /* renamed from: a */
    public void mo3793a(C0635a aVar) {
        this.f2291b = aVar;
    }

    /* renamed from: a */
    public void mo1572a(C0636b bVar) {
        if (!(this.f2292c == null || bVar == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f2292c = bVar;
    }

    /* renamed from: a */
    public void mo3794a(boolean z) {
        C0635a aVar = this.f2291b;
        if (aVar != null) {
            aVar.mo2459c(z);
        }
    }

    /* renamed from: b */
    public boolean mo1569b() {
        return false;
    }

    /* renamed from: c */
    public boolean mo1570c() {
        return false;
    }

    /* renamed from: d */
    public boolean mo1573d() {
        return false;
    }

    /* renamed from: e */
    public boolean mo1574e() {
        return true;
    }

    /* renamed from: f */
    public void mo3795f() {
        this.f2292c = null;
        this.f2291b = null;
    }
}
