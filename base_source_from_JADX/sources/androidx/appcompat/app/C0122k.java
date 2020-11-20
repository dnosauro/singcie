package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.C0086a;
import androidx.appcompat.view.C0168i;
import androidx.appcompat.view.menu.C0183g;
import androidx.appcompat.view.menu.C0198m;
import androidx.appcompat.widget.C0256ae;
import androidx.appcompat.widget.C0303az;
import androidx.appcompat.widget.Toolbar;
import androidx.core.p030h.C0656u;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.app.k */
class C0122k extends C0086a {

    /* renamed from: a */
    C0256ae f288a;

    /* renamed from: b */
    boolean f289b;

    /* renamed from: c */
    Window.Callback f290c;

    /* renamed from: d */
    private boolean f291d;

    /* renamed from: e */
    private boolean f292e;

    /* renamed from: f */
    private ArrayList<C0086a.C0088b> f293f = new ArrayList<>();

    /* renamed from: g */
    private final Runnable f294g = new Runnable() {
        public void run() {
            C0122k.this.mo962i();
        }
    };

    /* renamed from: h */
    private final Toolbar.C0246c f295h = new Toolbar.C0246c() {
        /* renamed from: a */
        public boolean mo964a(MenuItem menuItem) {
            return C0122k.this.f290c.onMenuItemSelected(0, menuItem);
        }
    };

    /* renamed from: androidx.appcompat.app.k$a */
    private final class C0125a implements C0198m.C0199a {

        /* renamed from: b */
        private boolean f299b;

        C0125a() {
        }

        /* renamed from: a */
        public void mo914a(C0183g gVar, boolean z) {
            if (!this.f299b) {
                this.f299b = true;
                C0122k.this.f288a.mo2128n();
                if (C0122k.this.f290c != null) {
                    C0122k.this.f290c.onPanelClosed(108, gVar);
                }
                this.f299b = false;
            }
        }

        /* renamed from: a */
        public boolean mo915a(C0183g gVar) {
            if (C0122k.this.f290c == null) {
                return false;
            }
            C0122k.this.f290c.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* renamed from: androidx.appcompat.app.k$b */
    private final class C0126b implements C0183g.C0184a {
        C0126b() {
        }

        public boolean onMenuItemSelected(C0183g gVar, MenuItem menuItem) {
            return false;
        }

        public void onMenuModeChange(C0183g gVar) {
            if (C0122k.this.f290c == null) {
                return;
            }
            if (C0122k.this.f288a.mo2123i()) {
                C0122k.this.f290c.onPanelClosed(108, gVar);
            } else if (C0122k.this.f290c.onPreparePanel(0, (View) null, gVar)) {
                C0122k.this.f290c.onMenuOpened(108, gVar);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.k$c */
    private class C0127c extends C0168i {
        public C0127c(Window.Callback callback) {
            super(callback);
        }

        public View onCreatePanelView(int i) {
            return i == 0 ? new View(C0122k.this.f288a.mo2112b()) : super.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !C0122k.this.f289b) {
                C0122k.this.f288a.mo2127m();
                C0122k.this.f289b = true;
            }
            return onPreparePanel;
        }
    }

    C0122k(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f288a = new C0303az(toolbar, false);
        this.f290c = new C0127c(callback);
        this.f288a.mo2107a(this.f290c);
        toolbar.setOnMenuItemClickListener(this.f295h);
        this.f288a.mo2110a(charSequence);
    }

    /* renamed from: j */
    private Menu m278j() {
        if (!this.f291d) {
            this.f288a.mo2108a((C0198m.C0199a) new C0125a(), (C0183g.C0184a) new C0126b());
            this.f291d = true;
        }
        return this.f288a.mo2131q();
    }

    /* renamed from: a */
    public int mo729a() {
        return this.f288a.mo2129o();
    }

    /* renamed from: a */
    public void mo731a(float f) {
        C0656u.m2583a((View) this.f288a.mo2102a(), f);
    }

    /* renamed from: a */
    public void mo960a(int i, int i2) {
        this.f288a.mo2115c((i & i2) | ((~i2) & this.f288a.mo2129o()));
    }

    /* renamed from: a */
    public void mo732a(Configuration configuration) {
        super.mo732a(configuration);
    }

    /* renamed from: a */
    public void mo733a(CharSequence charSequence) {
        this.f288a.mo2110a(charSequence);
    }

    /* renamed from: a */
    public void mo734a(boolean z) {
        mo960a(z ? 8 : 0, 8);
    }

    /* renamed from: a */
    public boolean mo735a(int i, KeyEvent keyEvent) {
        Menu j = m278j();
        if (j == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        j.setQwertyMode(z);
        return j.performShortcut(i, keyEvent, 0);
    }

    /* renamed from: a */
    public boolean mo736a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            mo740c();
        }
        return true;
    }

    /* renamed from: b */
    public Context mo737b() {
        return this.f288a.mo2112b();
    }

    /* renamed from: b */
    public void mo738b(boolean z) {
    }

    /* renamed from: c */
    public boolean mo740c() {
        return this.f288a.mo2125k();
    }

    /* renamed from: d */
    public void mo741d(boolean z) {
    }

    /* renamed from: d */
    public boolean mo742d() {
        return this.f288a.mo2126l();
    }

    /* renamed from: e */
    public void mo743e(boolean z) {
    }

    /* renamed from: e */
    public boolean mo744e() {
        this.f288a.mo2102a().removeCallbacks(this.f294g);
        C0656u.m2597a((View) this.f288a.mo2102a(), this.f294g);
        return true;
    }

    /* renamed from: f */
    public void mo745f(boolean z) {
        if (z != this.f292e) {
            this.f292e = z;
            int size = this.f293f.size();
            for (int i = 0; i < size; i++) {
                this.f293f.get(i).mo748a(z);
            }
        }
    }

    /* renamed from: f */
    public boolean mo746f() {
        if (!this.f288a.mo2116c()) {
            return false;
        }
        this.f288a.mo2117d();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo747g() {
        this.f288a.mo2102a().removeCallbacks(this.f294g);
    }

    /* renamed from: h */
    public Window.Callback mo961h() {
        return this.f290c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo962i() {
        Menu j = m278j();
        C0183g gVar = j instanceof C0183g ? (C0183g) j : null;
        if (gVar != null) {
            gVar.stopDispatchingItemsChanged();
        }
        try {
            j.clear();
            if (!this.f290c.onCreatePanelMenu(0, j) || !this.f290c.onPreparePanel(0, (View) null, j)) {
                j.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.startDispatchingItemsChanged();
            }
        }
    }
}
