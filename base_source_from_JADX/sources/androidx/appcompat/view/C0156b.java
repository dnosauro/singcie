package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: androidx.appcompat.view.b */
public abstract class C0156b {

    /* renamed from: a */
    private Object f428a;

    /* renamed from: b */
    private boolean f429b;

    /* renamed from: androidx.appcompat.view.b$a */
    public interface C0157a {
        /* renamed from: a */
        void mo916a(C0156b bVar);

        /* renamed from: a */
        boolean mo917a(C0156b bVar, Menu menu);

        /* renamed from: a */
        boolean mo918a(C0156b bVar, MenuItem menuItem);

        /* renamed from: b */
        boolean mo919b(C0156b bVar, Menu menu);
    }

    /* renamed from: a */
    public abstract MenuInflater mo982a();

    /* renamed from: a */
    public abstract void mo983a(int i);

    /* renamed from: a */
    public abstract void mo984a(View view);

    /* renamed from: a */
    public abstract void mo985a(CharSequence charSequence);

    /* renamed from: a */
    public void mo1135a(Object obj) {
        this.f428a = obj;
    }

    /* renamed from: a */
    public void mo986a(boolean z) {
        this.f429b = z;
    }

    /* renamed from: b */
    public abstract Menu mo987b();

    /* renamed from: b */
    public abstract void mo988b(int i);

    /* renamed from: b */
    public abstract void mo989b(CharSequence charSequence);

    /* renamed from: c */
    public abstract void mo990c();

    /* renamed from: d */
    public abstract void mo991d();

    /* renamed from: f */
    public abstract CharSequence mo993f();

    /* renamed from: g */
    public abstract CharSequence mo994g();

    /* renamed from: h */
    public boolean mo995h() {
        return false;
    }

    /* renamed from: i */
    public abstract View mo996i();

    /* renamed from: j */
    public Object mo1136j() {
        return this.f428a;
    }

    /* renamed from: k */
    public boolean mo1137k() {
        return this.f429b;
    }
}
