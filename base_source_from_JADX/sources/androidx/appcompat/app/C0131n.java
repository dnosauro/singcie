package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.C0059a;
import androidx.appcompat.app.C0086a;
import androidx.appcompat.view.C0155a;
import androidx.appcompat.view.C0156b;
import androidx.appcompat.view.C0163g;
import androidx.appcompat.view.C0166h;
import androidx.appcompat.view.menu.C0183g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.C0256ae;
import androidx.appcompat.widget.C0288aq;
import androidx.appcompat.widget.Toolbar;
import androidx.core.p030h.C0631aa;
import androidx.core.p030h.C0632ab;
import androidx.core.p030h.C0656u;
import androidx.core.p030h.C0668y;
import androidx.core.p030h.C0672z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.app.n */
public class C0131n extends C0086a implements ActionBarOverlayLayout.C0213a {

    /* renamed from: s */
    static final /* synthetic */ boolean f316s = (!C0131n.class.desiredAssertionStatus());

    /* renamed from: t */
    private static final Interpolator f317t = new AccelerateInterpolator();

    /* renamed from: u */
    private static final Interpolator f318u = new DecelerateInterpolator();

    /* renamed from: A */
    private boolean f319A;

    /* renamed from: B */
    private boolean f320B;

    /* renamed from: C */
    private ArrayList<C0086a.C0088b> f321C = new ArrayList<>();

    /* renamed from: D */
    private boolean f322D;

    /* renamed from: E */
    private int f323E = 0;

    /* renamed from: F */
    private boolean f324F;

    /* renamed from: G */
    private boolean f325G = true;

    /* renamed from: H */
    private boolean f326H;

    /* renamed from: a */
    Context f327a;

    /* renamed from: b */
    ActionBarOverlayLayout f328b;

    /* renamed from: c */
    ActionBarContainer f329c;

    /* renamed from: d */
    C0256ae f330d;

    /* renamed from: e */
    ActionBarContextView f331e;

    /* renamed from: f */
    View f332f;

    /* renamed from: g */
    C0288aq f333g;

    /* renamed from: h */
    C0135a f334h;

    /* renamed from: i */
    C0156b f335i;

    /* renamed from: j */
    C0156b.C0157a f336j;

    /* renamed from: k */
    boolean f337k = true;

    /* renamed from: l */
    boolean f338l;

    /* renamed from: m */
    boolean f339m;

    /* renamed from: n */
    C0166h f340n;

    /* renamed from: o */
    boolean f341o;

    /* renamed from: p */
    final C0672z f342p = new C0631aa() {
        /* renamed from: b */
        public void mo913b(View view) {
            if (C0131n.this.f337k && C0131n.this.f332f != null) {
                C0131n.this.f332f.setTranslationY(0.0f);
                C0131n.this.f329c.setTranslationY(0.0f);
            }
            C0131n.this.f329c.setVisibility(8);
            C0131n.this.f329c.setTransitioning(false);
            C0131n nVar = C0131n.this;
            nVar.f340n = null;
            nVar.mo971h();
            if (C0131n.this.f328b != null) {
                C0656u.m2634q(C0131n.this.f328b);
            }
        }
    };

    /* renamed from: q */
    final C0672z f343q = new C0631aa() {
        /* renamed from: b */
        public void mo913b(View view) {
            C0131n nVar = C0131n.this;
            nVar.f340n = null;
            nVar.f329c.requestLayout();
        }
    };

    /* renamed from: r */
    final C0632ab f344r = new C0632ab() {
        /* renamed from: a */
        public void mo981a(View view) {
            ((View) C0131n.this.f329c.getParent()).invalidate();
        }
    };

    /* renamed from: v */
    private Context f345v;

    /* renamed from: w */
    private Activity f346w;

    /* renamed from: x */
    private Dialog f347x;

    /* renamed from: y */
    private ArrayList<Object> f348y = new ArrayList<>();

    /* renamed from: z */
    private int f349z = -1;

    /* renamed from: androidx.appcompat.app.n$a */
    public class C0135a extends C0156b implements C0183g.C0184a {

        /* renamed from: b */
        private final Context f354b;

        /* renamed from: c */
        private final C0183g f355c;

        /* renamed from: d */
        private C0156b.C0157a f356d;

        /* renamed from: e */
        private WeakReference<View> f357e;

        public C0135a(Context context, C0156b.C0157a aVar) {
            this.f354b = context;
            this.f356d = aVar;
            this.f355c = new C0183g(context).setDefaultShowAsAction(1);
            this.f355c.setCallback(this);
        }

        /* renamed from: a */
        public MenuInflater mo982a() {
            return new C0163g(this.f354b);
        }

        /* renamed from: a */
        public void mo983a(int i) {
            mo989b((CharSequence) C0131n.this.f327a.getResources().getString(i));
        }

        /* renamed from: a */
        public void mo984a(View view) {
            C0131n.this.f331e.setCustomView(view);
            this.f357e = new WeakReference<>(view);
        }

        /* renamed from: a */
        public void mo985a(CharSequence charSequence) {
            C0131n.this.f331e.setSubtitle(charSequence);
        }

        /* renamed from: a */
        public void mo986a(boolean z) {
            super.mo986a(z);
            C0131n.this.f331e.setTitleOptional(z);
        }

        /* renamed from: b */
        public Menu mo987b() {
            return this.f355c;
        }

        /* renamed from: b */
        public void mo988b(int i) {
            mo985a((CharSequence) C0131n.this.f327a.getResources().getString(i));
        }

        /* renamed from: b */
        public void mo989b(CharSequence charSequence) {
            C0131n.this.f331e.setTitle(charSequence);
        }

        /* renamed from: c */
        public void mo990c() {
            if (C0131n.this.f334h == this) {
                if (!C0131n.m311a(C0131n.this.f338l, C0131n.this.f339m, false)) {
                    C0131n nVar = C0131n.this;
                    nVar.f335i = this;
                    nVar.f336j = this.f356d;
                } else {
                    this.f356d.mo916a(this);
                }
                this.f356d = null;
                C0131n.this.mo978k(false);
                C0131n.this.f331e.mo1664b();
                C0131n.this.f330d.mo2102a().sendAccessibilityEvent(32);
                C0131n.this.f328b.setHideOnContentScrollEnabled(C0131n.this.f341o);
                C0131n.this.f334h = null;
            }
        }

        /* renamed from: d */
        public void mo991d() {
            if (C0131n.this.f334h == this) {
                this.f355c.stopDispatchingItemsChanged();
                try {
                    this.f356d.mo919b(this, this.f355c);
                } finally {
                    this.f355c.startDispatchingItemsChanged();
                }
            }
        }

        /* renamed from: e */
        public boolean mo992e() {
            this.f355c.stopDispatchingItemsChanged();
            try {
                return this.f356d.mo917a((C0156b) this, (Menu) this.f355c);
            } finally {
                this.f355c.startDispatchingItemsChanged();
            }
        }

        /* renamed from: f */
        public CharSequence mo993f() {
            return C0131n.this.f331e.getTitle();
        }

        /* renamed from: g */
        public CharSequence mo994g() {
            return C0131n.this.f331e.getSubtitle();
        }

        /* renamed from: h */
        public boolean mo995h() {
            return C0131n.this.f331e.mo1666d();
        }

        /* renamed from: i */
        public View mo996i() {
            WeakReference<View> weakReference = this.f357e;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public boolean onMenuItemSelected(C0183g gVar, MenuItem menuItem) {
            C0156b.C0157a aVar = this.f356d;
            if (aVar != null) {
                return aVar.mo918a((C0156b) this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(C0183g gVar) {
            if (this.f356d != null) {
                mo991d();
                C0131n.this.f331e.mo1663a();
            }
        }
    }

    public C0131n(Activity activity, boolean z) {
        this.f346w = activity;
        View decorView = activity.getWindow().getDecorView();
        m310a(decorView);
        if (!z) {
            this.f332f = decorView.findViewById(16908290);
        }
    }

    public C0131n(Dialog dialog) {
        this.f347x = dialog;
        m310a(dialog.getWindow().getDecorView());
    }

    /* renamed from: a */
    private void m310a(View view) {
        this.f328b = (ActionBarOverlayLayout) view.findViewById(C0059a.C0065f.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f328b;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f330d = m312b(view.findViewById(C0059a.C0065f.action_bar));
        this.f331e = (ActionBarContextView) view.findViewById(C0059a.C0065f.action_context_bar);
        this.f329c = (ActionBarContainer) view.findViewById(C0059a.C0065f.action_bar_container);
        C0256ae aeVar = this.f330d;
        if (aeVar == null || this.f331e == null || this.f329c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f327a = aeVar.mo2112b();
        boolean z = (this.f330d.mo2129o() & 4) != 0;
        if (z) {
            this.f319A = true;
        }
        C0155a a = C0155a.m446a(this.f327a);
        mo738b(a.mo1133f() || z);
        m313l(a.mo1131d());
        TypedArray obtainStyledAttributes = this.f327a.obtainStyledAttributes((AttributeSet) null, C0059a.C0069j.ActionBar, C0059a.C0060a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0059a.C0069j.ActionBar_hideOnContentScroll, false)) {
            mo739c(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0059a.C0069j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo731a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    static boolean m311a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return !z && !z2;
    }

    /* renamed from: b */
    private C0256ae m312b(View view) {
        if (view instanceof C0256ae) {
            return (C0256ae) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != null ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: l */
    private void m313l(boolean z) {
        this.f322D = z;
        if (!this.f322D) {
            this.f330d.mo2109a((C0288aq) null);
            this.f329c.setTabContainer(this.f333g);
        } else {
            this.f329c.setTabContainer((C0288aq) null);
            this.f330d.mo2109a(this.f333g);
        }
        boolean z2 = true;
        boolean z3 = mo973i() == 2;
        C0288aq aqVar = this.f333g;
        if (aqVar != null) {
            if (z3) {
                aqVar.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f328b;
                if (actionBarOverlayLayout != null) {
                    C0656u.m2634q(actionBarOverlayLayout);
                }
            } else {
                aqVar.setVisibility(8);
            }
        }
        this.f330d.mo2111a(!this.f322D && z3);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f328b;
        if (this.f322D || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z2);
    }

    /* renamed from: m */
    private void m314m(boolean z) {
        if (m311a(this.f338l, this.f339m, this.f324F)) {
            if (!this.f325G) {
                this.f325G = true;
                mo974i(z);
            }
        } else if (this.f325G) {
            this.f325G = false;
            mo976j(z);
        }
    }

    /* renamed from: n */
    private void m315n() {
        if (!this.f324F) {
            this.f324F = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f328b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            m314m(false);
        }
    }

    /* renamed from: o */
    private void m316o() {
        if (this.f324F) {
            this.f324F = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f328b;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            m314m(false);
        }
    }

    /* renamed from: p */
    private boolean m317p() {
        return C0656u.m2642y(this.f329c);
    }

    /* renamed from: a */
    public int mo729a() {
        return this.f330d.mo2129o();
    }

    /* renamed from: a */
    public C0156b mo730a(C0156b.C0157a aVar) {
        C0135a aVar2 = this.f334h;
        if (aVar2 != null) {
            aVar2.mo990c();
        }
        this.f328b.setHideOnContentScrollEnabled(false);
        this.f331e.mo1665c();
        C0135a aVar3 = new C0135a(this.f331e.getContext(), aVar);
        if (!aVar3.mo992e()) {
            return null;
        }
        this.f334h = aVar3;
        aVar3.mo991d();
        this.f331e.mo1662a(aVar3);
        mo978k(true);
        this.f331e.sendAccessibilityEvent(32);
        return aVar3;
    }

    /* renamed from: a */
    public void mo731a(float f) {
        C0656u.m2583a((View) this.f329c, f);
    }

    /* renamed from: a */
    public void mo968a(int i) {
        this.f323E = i;
    }

    /* renamed from: a */
    public void mo969a(int i, int i2) {
        int o = this.f330d.mo2129o();
        if ((i2 & 4) != 0) {
            this.f319A = true;
        }
        this.f330d.mo2115c((i & i2) | ((~i2) & o));
    }

    /* renamed from: a */
    public void mo732a(Configuration configuration) {
        m313l(C0155a.m446a(this.f327a).mo1131d());
    }

    /* renamed from: a */
    public void mo733a(CharSequence charSequence) {
        this.f330d.mo2110a(charSequence);
    }

    /* renamed from: a */
    public void mo734a(boolean z) {
        mo969a(z ? 8 : 0, 8);
    }

    /* renamed from: a */
    public boolean mo735a(int i, KeyEvent keyEvent) {
        Menu b;
        C0135a aVar = this.f334h;
        if (aVar == null || (b = aVar.mo987b()) == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        b.setQwertyMode(z);
        return b.performShortcut(i, keyEvent, 0);
    }

    /* renamed from: b */
    public Context mo737b() {
        if (this.f345v == null) {
            TypedValue typedValue = new TypedValue();
            this.f327a.getTheme().resolveAttribute(C0059a.C0060a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f345v = new ContextThemeWrapper(this.f327a, i);
            } else {
                this.f345v = this.f327a;
            }
        }
        return this.f345v;
    }

    /* renamed from: b */
    public void mo738b(boolean z) {
        this.f330d.mo2114b(z);
    }

    /* renamed from: c */
    public void mo739c(boolean z) {
        if (!z || this.f328b.mo1690a()) {
            this.f341o = z;
            this.f328b.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    /* renamed from: d */
    public void mo741d(boolean z) {
        if (!this.f319A) {
            mo970g(z);
        }
    }

    /* renamed from: e */
    public void mo743e(boolean z) {
        C0166h hVar;
        this.f326H = z;
        if (!z && (hVar = this.f340n) != null) {
            hVar.mo1182c();
        }
    }

    /* renamed from: f */
    public void mo745f(boolean z) {
        if (z != this.f320B) {
            this.f320B = z;
            int size = this.f321C.size();
            for (int i = 0; i < size; i++) {
                this.f321C.get(i).mo748a(z);
            }
        }
    }

    /* renamed from: f */
    public boolean mo746f() {
        C0256ae aeVar = this.f330d;
        if (aeVar == null || !aeVar.mo2116c()) {
            return false;
        }
        this.f330d.mo2117d();
        return true;
    }

    /* renamed from: g */
    public void mo970g(boolean z) {
        mo969a(z ? 4 : 0, 4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo971h() {
        C0156b.C0157a aVar = this.f336j;
        if (aVar != null) {
            aVar.mo916a(this.f335i);
            this.f335i = null;
            this.f336j = null;
        }
    }

    /* renamed from: h */
    public void mo972h(boolean z) {
        this.f337k = z;
    }

    /* renamed from: i */
    public int mo973i() {
        return this.f330d.mo2130p();
    }

    /* renamed from: i */
    public void mo974i(boolean z) {
        View view;
        View view2;
        C0166h hVar = this.f340n;
        if (hVar != null) {
            hVar.mo1182c();
        }
        this.f329c.setVisibility(0);
        if (this.f323E != 0 || (!this.f326H && !z)) {
            this.f329c.setAlpha(1.0f);
            this.f329c.setTranslationY(0.0f);
            if (this.f337k && (view = this.f332f) != null) {
                view.setTranslationY(0.0f);
            }
            this.f343q.mo913b((View) null);
        } else {
            this.f329c.setTranslationY(0.0f);
            float f = (float) (-this.f329c.getHeight());
            if (z) {
                int[] iArr = {0, 0};
                this.f329c.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            this.f329c.setTranslationY(f);
            C0166h hVar2 = new C0166h();
            C0668y b = C0656u.m2630m(this.f329c).mo3850b(0.0f);
            b.mo3848a(this.f344r);
            hVar2.mo1177a(b);
            if (this.f337k && (view2 = this.f332f) != null) {
                view2.setTranslationY(f);
                hVar2.mo1177a(C0656u.m2630m(this.f332f).mo3850b(0.0f));
            }
            hVar2.mo1176a(f318u);
            hVar2.mo1175a(250);
            hVar2.mo1179a(this.f343q);
            this.f340n = hVar2;
            hVar2.mo1180a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f328b;
        if (actionBarOverlayLayout != null) {
            C0656u.m2634q(actionBarOverlayLayout);
        }
    }

    /* renamed from: j */
    public void mo975j() {
        if (this.f339m) {
            this.f339m = false;
            m314m(true);
        }
    }

    /* renamed from: j */
    public void mo976j(boolean z) {
        View view;
        C0166h hVar = this.f340n;
        if (hVar != null) {
            hVar.mo1182c();
        }
        if (this.f323E != 0 || (!this.f326H && !z)) {
            this.f342p.mo913b((View) null);
            return;
        }
        this.f329c.setAlpha(1.0f);
        this.f329c.setTransitioning(true);
        C0166h hVar2 = new C0166h();
        float f = (float) (-this.f329c.getHeight());
        if (z) {
            int[] iArr = {0, 0};
            this.f329c.getLocationInWindow(iArr);
            f -= (float) iArr[1];
        }
        C0668y b = C0656u.m2630m(this.f329c).mo3850b(f);
        b.mo3848a(this.f344r);
        hVar2.mo1177a(b);
        if (this.f337k && (view = this.f332f) != null) {
            hVar2.mo1177a(C0656u.m2630m(view).mo3850b(f));
        }
        hVar2.mo1176a(f317t);
        hVar2.mo1175a(250);
        hVar2.mo1179a(this.f342p);
        this.f340n = hVar2;
        hVar2.mo1180a();
    }

    /* renamed from: k */
    public void mo977k() {
        if (!this.f339m) {
            this.f339m = true;
            m314m(true);
        }
    }

    /* renamed from: k */
    public void mo978k(boolean z) {
        C0668y yVar;
        C0668y yVar2;
        if (z) {
            m315n();
        } else {
            m316o();
        }
        if (m317p()) {
            if (z) {
                yVar = this.f330d.mo2103a(4, 100);
                yVar2 = this.f331e.mo1661a(0, 200);
            } else {
                yVar2 = this.f330d.mo2103a(0, 200);
                yVar = this.f331e.mo1661a(8, 100);
            }
            C0166h hVar = new C0166h();
            hVar.mo1178a(yVar, yVar2);
            hVar.mo1180a();
        } else if (z) {
            this.f330d.mo2118d(4);
            this.f331e.setVisibility(0);
        } else {
            this.f330d.mo2118d(0);
            this.f331e.setVisibility(8);
        }
    }

    /* renamed from: l */
    public void mo979l() {
        C0166h hVar = this.f340n;
        if (hVar != null) {
            hVar.mo1182c();
            this.f340n = null;
        }
    }

    /* renamed from: m */
    public void mo980m() {
    }
}
