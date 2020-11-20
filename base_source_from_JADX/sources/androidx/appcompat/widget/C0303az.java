package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.C0059a;
import androidx.appcompat.p009a.p010a.C0070a;
import androidx.appcompat.view.menu.C0171a;
import androidx.appcompat.view.menu.C0183g;
import androidx.appcompat.view.menu.C0198m;
import androidx.appcompat.widget.Toolbar;
import androidx.core.p030h.C0631aa;
import androidx.core.p030h.C0656u;
import androidx.core.p030h.C0668y;
import androidx.core.p030h.C0672z;
import com.google.android.material.badge.BadgeDrawable;

/* renamed from: androidx.appcompat.widget.az */
public class C0303az implements C0256ae {

    /* renamed from: a */
    Toolbar f1096a;

    /* renamed from: b */
    CharSequence f1097b;

    /* renamed from: c */
    Window.Callback f1098c;

    /* renamed from: d */
    boolean f1099d;

    /* renamed from: e */
    private int f1100e;

    /* renamed from: f */
    private View f1101f;

    /* renamed from: g */
    private View f1102g;

    /* renamed from: h */
    private Drawable f1103h;

    /* renamed from: i */
    private Drawable f1104i;

    /* renamed from: j */
    private Drawable f1105j;

    /* renamed from: k */
    private boolean f1106k;

    /* renamed from: l */
    private CharSequence f1107l;

    /* renamed from: m */
    private CharSequence f1108m;

    /* renamed from: n */
    private C0315c f1109n;

    /* renamed from: o */
    private int f1110o;

    /* renamed from: p */
    private int f1111p;

    /* renamed from: q */
    private Drawable f1112q;

    public C0303az(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0059a.C0067h.abc_action_bar_up_description, C0059a.C0064e.abc_ic_ab_back_material);
    }

    public C0303az(Toolbar toolbar, boolean z, int i, int i2) {
        Drawable drawable;
        this.f1110o = 0;
        this.f1111p = 0;
        this.f1096a = toolbar;
        this.f1097b = toolbar.getTitle();
        this.f1107l = toolbar.getSubtitle();
        this.f1106k = this.f1097b != null;
        this.f1105j = toolbar.getNavigationIcon();
        C0302ay a = C0302ay.m1078a(toolbar.getContext(), (AttributeSet) null, C0059a.C0069j.ActionBar, C0059a.C0060a.actionBarStyle, 0);
        this.f1112q = a.mo2409a(C0059a.C0069j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c = a.mo2416c(C0059a.C0069j.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                mo2427b(c);
            }
            CharSequence c2 = a.mo2416c(C0059a.C0069j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c2)) {
                mo2429c(c2);
            }
            Drawable a2 = a.mo2409a(C0059a.C0069j.ActionBar_logo);
            if (a2 != null) {
                mo2426b(a2);
            }
            Drawable a3 = a.mo2409a(C0059a.C0069j.ActionBar_icon);
            if (a3 != null) {
                mo2105a(a3);
            }
            if (this.f1105j == null && (drawable = this.f1112q) != null) {
                mo2428c(drawable);
            }
            mo2115c(a.mo2407a(C0059a.C0069j.ActionBar_displayOptions, 0));
            int g = a.mo2423g(C0059a.C0069j.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                mo2425a(LayoutInflater.from(this.f1096a.getContext()).inflate(g, this.f1096a, false));
                mo2115c(this.f1100e | 16);
            }
            int f = a.mo2421f(C0059a.C0069j.ActionBar_height, 0);
            if (f > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1096a.getLayoutParams();
                layoutParams.height = f;
                this.f1096a.setLayoutParams(layoutParams);
            }
            int d = a.mo2417d(C0059a.C0069j.ActionBar_contentInsetStart, -1);
            int d2 = a.mo2417d(C0059a.C0069j.ActionBar_contentInsetEnd, -1);
            if (d >= 0 || d2 >= 0) {
                this.f1096a.setContentInsetsRelative(Math.max(d, 0), Math.max(d2, 0));
            }
            int g2 = a.mo2423g(C0059a.C0069j.ActionBar_titleTextStyle, 0);
            if (g2 != 0) {
                Toolbar toolbar2 = this.f1096a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), g2);
            }
            int g3 = a.mo2423g(C0059a.C0069j.ActionBar_subtitleTextStyle, 0);
            if (g3 != 0) {
                Toolbar toolbar3 = this.f1096a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), g3);
            }
            int g4 = a.mo2423g(C0059a.C0069j.ActionBar_popupTheme, 0);
            if (g4 != 0) {
                this.f1096a.setPopupTheme(g4);
            }
        } else {
            this.f1100e = m1099r();
        }
        a.mo2410a();
        mo2431e(i);
        this.f1108m = this.f1096a.getNavigationContentDescription();
        this.f1096a.setNavigationOnClickListener(new View.OnClickListener() {

            /* renamed from: a */
            final C0171a f1113a = new C0171a(C0303az.this.f1096a.getContext(), 0, 16908332, 0, 0, C0303az.this.f1097b);

            public void onClick(View view) {
                if (C0303az.this.f1098c != null && C0303az.this.f1099d) {
                    C0303az.this.f1098c.onMenuItemSelected(0, this.f1113a);
                }
            }
        });
    }

    /* renamed from: e */
    private void m1098e(CharSequence charSequence) {
        this.f1097b = charSequence;
        if ((this.f1100e & 8) != 0) {
            this.f1096a.setTitle(charSequence);
        }
    }

    /* renamed from: r */
    private int m1099r() {
        if (this.f1096a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1112q = this.f1096a.getNavigationIcon();
        return 15;
    }

    /* renamed from: s */
    private void m1100s() {
        Drawable drawable;
        int i = this.f1100e;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.f1104i) == null) {
            drawable = this.f1103h;
        }
        this.f1096a.setLogo(drawable);
    }

    /* renamed from: t */
    private void m1101t() {
        Drawable drawable;
        Toolbar toolbar;
        if ((this.f1100e & 4) != 0) {
            toolbar = this.f1096a;
            drawable = this.f1105j;
            if (drawable == null) {
                drawable = this.f1112q;
            }
        } else {
            toolbar = this.f1096a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    /* renamed from: u */
    private void m1102u() {
        if ((this.f1100e & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1108m)) {
            this.f1096a.setNavigationContentDescription(this.f1111p);
        } else {
            this.f1096a.setNavigationContentDescription(this.f1108m);
        }
    }

    /* renamed from: a */
    public ViewGroup mo2102a() {
        return this.f1096a;
    }

    /* renamed from: a */
    public C0668y mo2103a(final int i, long j) {
        return C0656u.m2630m(this.f1096a).mo3845a(i == 0 ? 1.0f : 0.0f).mo3846a(j).mo3849a((C0672z) new C0631aa() {

            /* renamed from: c */
            private boolean f1117c = false;

            /* renamed from: a */
            public void mo912a(View view) {
                C0303az.this.f1096a.setVisibility(0);
            }

            /* renamed from: b */
            public void mo913b(View view) {
                if (!this.f1117c) {
                    C0303az.this.f1096a.setVisibility(i);
                }
            }

            /* renamed from: c */
            public void mo2043c(View view) {
                this.f1117c = true;
            }
        });
    }

    /* renamed from: a */
    public void mo2104a(int i) {
        mo2105a(i != 0 ? C0070a.m63b(mo2112b(), i) : null);
    }

    /* renamed from: a */
    public void mo2105a(Drawable drawable) {
        this.f1103h = drawable;
        m1100s();
    }

    /* renamed from: a */
    public void mo2106a(Menu menu, C0198m.C0199a aVar) {
        if (this.f1109n == null) {
            this.f1109n = new C0315c(this.f1096a.getContext());
            this.f1109n.mo1300a(C0059a.C0065f.action_menu_presenter);
        }
        this.f1109n.setCallback(aVar);
        this.f1096a.setMenu((C0183g) menu, this.f1109n);
    }

    /* renamed from: a */
    public void mo2425a(View view) {
        View view2 = this.f1102g;
        if (!(view2 == null || (this.f1100e & 16) == 0)) {
            this.f1096a.removeView(view2);
        }
        this.f1102g = view;
        if (view != null && (this.f1100e & 16) != 0) {
            this.f1096a.addView(this.f1102g);
        }
    }

    /* renamed from: a */
    public void mo2107a(Window.Callback callback) {
        this.f1098c = callback;
    }

    /* renamed from: a */
    public void mo2108a(C0198m.C0199a aVar, C0183g.C0184a aVar2) {
        this.f1096a.setMenuCallbacks(aVar, aVar2);
    }

    /* renamed from: a */
    public void mo2109a(C0288aq aqVar) {
        Toolbar toolbar;
        View view = this.f1101f;
        if (view != null && view.getParent() == (toolbar = this.f1096a)) {
            toolbar.removeView(this.f1101f);
        }
        this.f1101f = aqVar;
        if (aqVar != null && this.f1110o == 2) {
            this.f1096a.addView(this.f1101f, 0);
            Toolbar.C0245b bVar = (Toolbar.C0245b) this.f1101f.getLayoutParams();
            bVar.width = -2;
            bVar.height = -2;
            bVar.f177a = BadgeDrawable.BOTTOM_START;
            aqVar.setAllowCollapse(true);
        }
    }

    /* renamed from: a */
    public void mo2110a(CharSequence charSequence) {
        if (!this.f1106k) {
            m1098e(charSequence);
        }
    }

    /* renamed from: a */
    public void mo2111a(boolean z) {
        this.f1096a.setCollapsible(z);
    }

    /* renamed from: b */
    public Context mo2112b() {
        return this.f1096a.getContext();
    }

    /* renamed from: b */
    public void mo2113b(int i) {
        mo2426b(i != 0 ? C0070a.m63b(mo2112b(), i) : null);
    }

    /* renamed from: b */
    public void mo2426b(Drawable drawable) {
        this.f1104i = drawable;
        m1100s();
    }

    /* renamed from: b */
    public void mo2427b(CharSequence charSequence) {
        this.f1106k = true;
        m1098e(charSequence);
    }

    /* renamed from: b */
    public void mo2114b(boolean z) {
    }

    /* renamed from: c */
    public void mo2115c(int i) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i2 = this.f1100e ^ i;
        this.f1100e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m1102u();
                }
                m1101t();
            }
            if ((i2 & 3) != 0) {
                m1100s();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1096a.setTitle(this.f1097b);
                    toolbar = this.f1096a;
                    charSequence = this.f1107l;
                } else {
                    charSequence = null;
                    this.f1096a.setTitle((CharSequence) null);
                    toolbar = this.f1096a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i2 & 16) != 0 && (view = this.f1102g) != null) {
                if ((i & 16) != 0) {
                    this.f1096a.addView(view);
                } else {
                    this.f1096a.removeView(view);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo2428c(Drawable drawable) {
        this.f1105j = drawable;
        m1101t();
    }

    /* renamed from: c */
    public void mo2429c(CharSequence charSequence) {
        this.f1107l = charSequence;
        if ((this.f1100e & 8) != 0) {
            this.f1096a.setSubtitle(charSequence);
        }
    }

    /* renamed from: c */
    public boolean mo2116c() {
        return this.f1096a.hasExpandedActionView();
    }

    /* renamed from: d */
    public void mo2117d() {
        this.f1096a.collapseActionView();
    }

    /* renamed from: d */
    public void mo2118d(int i) {
        this.f1096a.setVisibility(i);
    }

    /* renamed from: d */
    public void mo2430d(CharSequence charSequence) {
        this.f1108m = charSequence;
        m1102u();
    }

    /* renamed from: e */
    public CharSequence mo2119e() {
        return this.f1096a.getTitle();
    }

    /* renamed from: e */
    public void mo2431e(int i) {
        if (i != this.f1111p) {
            this.f1111p = i;
            if (TextUtils.isEmpty(this.f1096a.getNavigationContentDescription())) {
                mo2432f(this.f1111p);
            }
        }
    }

    /* renamed from: f */
    public void mo2120f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* renamed from: f */
    public void mo2432f(int i) {
        mo2430d((CharSequence) i == 0 ? null : mo2112b().getString(i));
    }

    /* renamed from: g */
    public void mo2121g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* renamed from: h */
    public boolean mo2122h() {
        return this.f1096a.canShowOverflowMenu();
    }

    /* renamed from: i */
    public boolean mo2123i() {
        return this.f1096a.isOverflowMenuShowing();
    }

    /* renamed from: j */
    public boolean mo2124j() {
        return this.f1096a.isOverflowMenuShowPending();
    }

    /* renamed from: k */
    public boolean mo2125k() {
        return this.f1096a.showOverflowMenu();
    }

    /* renamed from: l */
    public boolean mo2126l() {
        return this.f1096a.hideOverflowMenu();
    }

    /* renamed from: m */
    public void mo2127m() {
        this.f1099d = true;
    }

    /* renamed from: n */
    public void mo2128n() {
        this.f1096a.dismissPopupMenus();
    }

    /* renamed from: o */
    public int mo2129o() {
        return this.f1100e;
    }

    /* renamed from: p */
    public int mo2130p() {
        return this.f1110o;
    }

    /* renamed from: q */
    public Menu mo2131q() {
        return this.f1096a.getMenu();
    }
}
