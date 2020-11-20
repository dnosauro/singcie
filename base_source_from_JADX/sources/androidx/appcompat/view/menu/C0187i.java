package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import androidx.appcompat.C0059a;
import androidx.appcompat.p009a.p010a.C0070a;
import androidx.appcompat.view.menu.C0200n;
import androidx.core.graphics.drawable.C0595a;
import androidx.core.p021a.p022a.C0487b;
import androidx.core.p030h.C0634b;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* renamed from: androidx.appcompat.view.menu.i */
public final class C0187i implements C0487b {

    /* renamed from: A */
    private View f626A;

    /* renamed from: B */
    private C0634b f627B;

    /* renamed from: C */
    private MenuItem.OnActionExpandListener f628C;

    /* renamed from: D */
    private boolean f629D = false;

    /* renamed from: E */
    private ContextMenu.ContextMenuInfo f630E;

    /* renamed from: a */
    C0183g f631a;

    /* renamed from: b */
    private final int f632b;

    /* renamed from: c */
    private final int f633c;

    /* renamed from: d */
    private final int f634d;

    /* renamed from: e */
    private final int f635e;

    /* renamed from: f */
    private CharSequence f636f;

    /* renamed from: g */
    private CharSequence f637g;

    /* renamed from: h */
    private Intent f638h;

    /* renamed from: i */
    private char f639i;

    /* renamed from: j */
    private int f640j = 4096;

    /* renamed from: k */
    private char f641k;

    /* renamed from: l */
    private int f642l = 4096;

    /* renamed from: m */
    private Drawable f643m;

    /* renamed from: n */
    private int f644n = 0;

    /* renamed from: o */
    private C0207r f645o;

    /* renamed from: p */
    private Runnable f646p;

    /* renamed from: q */
    private MenuItem.OnMenuItemClickListener f647q;

    /* renamed from: r */
    private CharSequence f648r;

    /* renamed from: s */
    private CharSequence f649s;

    /* renamed from: t */
    private ColorStateList f650t = null;

    /* renamed from: u */
    private PorterDuff.Mode f651u = null;

    /* renamed from: v */
    private boolean f652v = false;

    /* renamed from: w */
    private boolean f653w = false;

    /* renamed from: x */
    private boolean f654x = false;

    /* renamed from: y */
    private int f655y = 16;

    /* renamed from: z */
    private int f656z = 0;

    C0187i(C0183g gVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f631a = gVar;
        this.f632b = i2;
        this.f633c = i;
        this.f634d = i3;
        this.f635e = i4;
        this.f636f = charSequence;
        this.f656z = i5;
    }

    /* renamed from: a */
    private Drawable m600a(Drawable drawable) {
        if (drawable != null && this.f654x && (this.f652v || this.f653w)) {
            drawable = C0595a.m2330g(drawable).mutate();
            if (this.f652v) {
                C0595a.m2319a(drawable, this.f650t);
            }
            if (this.f653w) {
                C0595a.m2322a(drawable, this.f651u);
            }
            this.f654x = false;
        }
        return drawable;
    }

    /* renamed from: a */
    private static void m601a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    /* renamed from: a */
    public C0487b setActionView(int i) {
        Context context = this.f631a.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, new LinearLayout(context), false));
        return this;
    }

    /* renamed from: a */
    public C0487b setActionView(View view) {
        int i;
        this.f626A = view;
        this.f627B = null;
        if (view != null && view.getId() == -1 && (i = this.f632b) > 0) {
            view.setId(i);
        }
        this.f631a.onItemActionRequestChanged(this);
        return this;
    }

    /* renamed from: a */
    public C0487b mo1238a(C0634b bVar) {
        C0634b bVar2 = this.f627B;
        if (bVar2 != null) {
            bVar2.mo3795f();
        }
        this.f626A = null;
        this.f627B = bVar;
        this.f631a.onItemsChanged(true);
        C0634b bVar3 = this.f627B;
        if (bVar3 != null) {
            bVar3.mo1572a((C0634b.C0636b) new C0634b.C0636b() {
                /* renamed from: a */
                public void mo1511a(boolean z) {
                    C0187i.this.f631a.onItemVisibleChanged(C0187i.this);
                }
            });
        }
        return this;
    }

    /* renamed from: a */
    public C0487b setContentDescription(CharSequence charSequence) {
        this.f648r = charSequence;
        this.f631a.onItemsChanged(false);
        return this;
    }

    /* renamed from: a */
    public C0634b mo1240a() {
        return this.f627B;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CharSequence mo1453a(C0200n.C0201a aVar) {
        return (aVar == null || !aVar.prefersCondensedTitle()) ? getTitle() : getTitleCondensed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1454a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f630E = contextMenuInfo;
    }

    /* renamed from: a */
    public void mo1455a(C0207r rVar) {
        this.f645o = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    /* renamed from: a */
    public void mo1456a(boolean z) {
        this.f655y = (z ? 4 : 0) | (this.f655y & -5);
    }

    /* renamed from: b */
    public C0487b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    /* renamed from: b */
    public C0487b setTooltipText(CharSequence charSequence) {
        this.f649s = charSequence;
        this.f631a.onItemsChanged(false);
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1458b(boolean z) {
        int i = this.f655y;
        this.f655y = (z ? 2 : 0) | (i & -3);
        if (i != this.f655y) {
            this.f631a.onItemsChanged(false);
        }
    }

    /* renamed from: b */
    public boolean mo1459b() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f647q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        C0183g gVar = this.f631a;
        if (gVar.dispatchMenuItemSelected(gVar, this)) {
            return true;
        }
        Runnable runnable = this.f646p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f638h != null) {
            try {
                this.f631a.getContext().startActivity(this.f638h);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        C0634b bVar = this.f627B;
        return bVar != null && bVar.mo1569b();
    }

    /* renamed from: c */
    public int mo1460c() {
        return this.f635e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo1461c(boolean z) {
        int i = this.f655y;
        this.f655y = (z ? 0 : 8) | (i & -9);
        return i != this.f655y;
    }

    public boolean collapseActionView() {
        if ((this.f656z & 8) == 0) {
            return false;
        }
        if (this.f626A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f628C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f631a.collapseItemActionView(this);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public char mo1462d() {
        return this.f631a.isQwertyMode() ? this.f641k : this.f639i;
    }

    /* renamed from: d */
    public void mo1463d(boolean z) {
        this.f655y = z ? this.f655y | 32 : this.f655y & -33;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public String mo1464e() {
        int i;
        char d = mo1462d();
        if (d == 0) {
            return "";
        }
        Resources resources = this.f631a.getContext().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f631a.getContext()).hasPermanentMenuKey()) {
            sb.append(resources.getString(C0059a.C0067h.abc_prepend_shortcut_label));
        }
        int i2 = this.f631a.isQwertyMode() ? this.f642l : this.f640j;
        m601a(sb, i2, PKIFailureInfo.notAuthorized, resources.getString(C0059a.C0067h.abc_menu_meta_shortcut_label));
        m601a(sb, i2, 4096, resources.getString(C0059a.C0067h.abc_menu_ctrl_shortcut_label));
        m601a(sb, i2, 2, resources.getString(C0059a.C0067h.abc_menu_alt_shortcut_label));
        m601a(sb, i2, 1, resources.getString(C0059a.C0067h.abc_menu_shift_shortcut_label));
        m601a(sb, i2, 4, resources.getString(C0059a.C0067h.abc_menu_sym_shortcut_label));
        m601a(sb, i2, 8, resources.getString(C0059a.C0067h.abc_menu_function_shortcut_label));
        if (d == 8) {
            i = C0059a.C0067h.abc_menu_delete_shortcut_label;
        } else if (d == 10) {
            i = C0059a.C0067h.abc_menu_enter_shortcut_label;
        } else if (d != ' ') {
            sb.append(d);
            return sb.toString();
        } else {
            i = C0059a.C0067h.abc_menu_space_shortcut_label;
        }
        sb.append(resources.getString(i));
        return sb.toString();
    }

    /* renamed from: e */
    public void mo1465e(boolean z) {
        this.f629D = z;
        this.f631a.onItemsChanged(false);
    }

    public boolean expandActionView() {
        if (!mo1491n()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f628C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f631a.expandItemActionView(this);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo1466f() {
        return this.f631a.isShortcutsVisible() && mo1462d() != 0;
    }

    /* renamed from: g */
    public boolean mo1467g() {
        return (this.f655y & 4) != 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.f626A;
        if (view != null) {
            return view;
        }
        C0634b bVar = this.f627B;
        if (bVar == null) {
            return null;
        }
        this.f626A = bVar.mo1571a((MenuItem) this);
        return this.f626A;
    }

    public int getAlphabeticModifiers() {
        return this.f642l;
    }

    public char getAlphabeticShortcut() {
        return this.f641k;
    }

    public CharSequence getContentDescription() {
        return this.f648r;
    }

    public int getGroupId() {
        return this.f633c;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f643m;
        if (drawable != null) {
            return m600a(drawable);
        }
        if (this.f644n == 0) {
            return null;
        }
        Drawable b = C0070a.m63b(this.f631a.getContext(), this.f644n);
        this.f644n = 0;
        this.f643m = b;
        return m600a(b);
    }

    public ColorStateList getIconTintList() {
        return this.f650t;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f651u;
    }

    public Intent getIntent() {
        return this.f638h;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f632b;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f630E;
    }

    public int getNumericModifiers() {
        return this.f640j;
    }

    public char getNumericShortcut() {
        return this.f639i;
    }

    public int getOrder() {
        return this.f634d;
    }

    public SubMenu getSubMenu() {
        return this.f645o;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f636f;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f637g;
        if (charSequence == null) {
            charSequence = this.f636f;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public CharSequence getTooltipText() {
        return this.f649s;
    }

    /* renamed from: h */
    public void mo1480h() {
        this.f631a.onItemActionRequestChanged(this);
    }

    public boolean hasSubMenu() {
        return this.f645o != null;
    }

    /* renamed from: i */
    public boolean mo1482i() {
        return this.f631a.getOptionalIconsVisible();
    }

    public boolean isActionViewExpanded() {
        return this.f629D;
    }

    public boolean isCheckable() {
        return (this.f655y & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f655y & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f655y & 16) != 0;
    }

    public boolean isVisible() {
        C0634b bVar = this.f627B;
        return (bVar == null || !bVar.mo1573d()) ? (this.f655y & 8) == 0 : (this.f655y & 8) == 0 && this.f627B.mo1574e();
    }

    /* renamed from: j */
    public boolean mo1487j() {
        return (this.f655y & 32) == 32;
    }

    /* renamed from: k */
    public boolean mo1488k() {
        return (this.f656z & 1) == 1;
    }

    /* renamed from: l */
    public boolean mo1489l() {
        return (this.f656z & 2) == 2;
    }

    /* renamed from: m */
    public boolean mo1490m() {
        return (this.f656z & 4) == 4;
    }

    /* renamed from: n */
    public boolean mo1491n() {
        C0634b bVar;
        if ((this.f656z & 8) == 0) {
            return false;
        }
        if (this.f626A == null && (bVar = this.f627B) != null) {
            this.f626A = bVar.mo1571a((MenuItem) this);
        }
        return this.f626A != null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f641k == c) {
            return this;
        }
        this.f641k = Character.toLowerCase(c);
        this.f631a.onItemsChanged(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f641k == c && this.f642l == i) {
            return this;
        }
        this.f641k = Character.toLowerCase(c);
        this.f642l = KeyEvent.normalizeMetaState(i);
        this.f631a.onItemsChanged(false);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f655y;
        this.f655y = z | (i & true) ? 1 : 0;
        if (i != this.f655y) {
            this.f631a.onItemsChanged(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f655y & 4) != 0) {
            this.f631a.setExclusiveItemChecked(this);
        } else {
            mo1458b(z);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f655y = z ? this.f655y | 16 : this.f655y & -17;
        this.f631a.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f643m = null;
        this.f644n = i;
        this.f654x = true;
        this.f631a.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f644n = 0;
        this.f643m = drawable;
        this.f654x = true;
        this.f631a.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f650t = colorStateList;
        this.f652v = true;
        this.f654x = true;
        this.f631a.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f651u = mode;
        this.f653w = true;
        this.f654x = true;
        this.f631a.onItemsChanged(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f638h = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f639i == c) {
            return this;
        }
        this.f639i = c;
        this.f631a.onItemsChanged(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f639i == c && this.f640j == i) {
            return this;
        }
        this.f639i = c;
        this.f640j = KeyEvent.normalizeMetaState(i);
        this.f631a.onItemsChanged(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f628C = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f647q = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f639i = c;
        this.f641k = Character.toLowerCase(c2);
        this.f631a.onItemsChanged(false);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f639i = c;
        this.f640j = KeyEvent.normalizeMetaState(i);
        this.f641k = Character.toLowerCase(c2);
        this.f642l = KeyEvent.normalizeMetaState(i2);
        this.f631a.onItemsChanged(false);
        return this;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f656z = i;
                this.f631a.onItemActionRequestChanged(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public MenuItem setTitle(int i) {
        return setTitle((CharSequence) this.f631a.getContext().getString(i));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f636f = charSequence;
        this.f631a.onItemsChanged(false);
        C0207r rVar = this.f645o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f637g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f636f;
        }
        this.f631a.onItemsChanged(false);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        if (mo1461c(z)) {
            this.f631a.onItemVisibleChanged(this);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f636f;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }
}
