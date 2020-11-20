package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.C0529a;
import androidx.core.graphics.drawable.C0595a;
import androidx.core.p021a.p022a.C0487b;
import androidx.core.p030h.C0634b;

/* renamed from: androidx.appcompat.view.menu.a */
public class C0171a implements C0487b {

    /* renamed from: a */
    private final int f532a;

    /* renamed from: b */
    private final int f533b;

    /* renamed from: c */
    private final int f534c;

    /* renamed from: d */
    private final int f535d;

    /* renamed from: e */
    private CharSequence f536e;

    /* renamed from: f */
    private CharSequence f537f;

    /* renamed from: g */
    private Intent f538g;

    /* renamed from: h */
    private char f539h;

    /* renamed from: i */
    private int f540i = 4096;

    /* renamed from: j */
    private char f541j;

    /* renamed from: k */
    private int f542k = 4096;

    /* renamed from: l */
    private Drawable f543l;

    /* renamed from: m */
    private int f544m = 0;

    /* renamed from: n */
    private Context f545n;

    /* renamed from: o */
    private MenuItem.OnMenuItemClickListener f546o;

    /* renamed from: p */
    private CharSequence f547p;

    /* renamed from: q */
    private CharSequence f548q;

    /* renamed from: r */
    private ColorStateList f549r = null;

    /* renamed from: s */
    private PorterDuff.Mode f550s = null;

    /* renamed from: t */
    private boolean f551t = false;

    /* renamed from: u */
    private boolean f552u = false;

    /* renamed from: v */
    private int f553v = 16;

    public C0171a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f545n = context;
        this.f532a = i2;
        this.f533b = i;
        this.f534c = i3;
        this.f535d = i4;
        this.f536e = charSequence;
    }

    /* renamed from: b */
    private void m540b() {
        if (this.f543l == null) {
            return;
        }
        if (this.f551t || this.f552u) {
            this.f543l = C0595a.m2330g(this.f543l);
            this.f543l = this.f543l.mutate();
            if (this.f551t) {
                C0595a.m2319a(this.f543l, this.f549r);
            }
            if (this.f552u) {
                C0595a.m2322a(this.f543l, this.f550s);
            }
        }
    }

    /* renamed from: a */
    public C0487b setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0487b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0487b mo1238a(C0634b bVar) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0487b setContentDescription(CharSequence charSequence) {
        this.f547p = charSequence;
        return this;
    }

    /* renamed from: a */
    public C0634b mo1240a() {
        return null;
    }

    /* renamed from: b */
    public C0487b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    /* renamed from: b */
    public C0487b setTooltipText(CharSequence charSequence) {
        this.f548q = charSequence;
        return this;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public int getAlphabeticModifiers() {
        return this.f542k;
    }

    public char getAlphabeticShortcut() {
        return this.f541j;
    }

    public CharSequence getContentDescription() {
        return this.f547p;
    }

    public int getGroupId() {
        return this.f533b;
    }

    public Drawable getIcon() {
        return this.f543l;
    }

    public ColorStateList getIconTintList() {
        return this.f549r;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f550s;
    }

    public Intent getIntent() {
        return this.f538g;
    }

    public int getItemId() {
        return this.f532a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public int getNumericModifiers() {
        return this.f540i;
    }

    public char getNumericShortcut() {
        return this.f539h;
    }

    public int getOrder() {
        return this.f535d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f536e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f537f;
        return charSequence != null ? charSequence : this.f536e;
    }

    public CharSequence getTooltipText() {
        return this.f548q;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f553v & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f553v & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f553v & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f553v & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f541j = Character.toLowerCase(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f541j = Character.toLowerCase(c);
        this.f542k = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f553v = z | (this.f553v & true) ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f553v = (z ? 2 : 0) | (this.f553v & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f553v = (z ? 16 : 0) | (this.f553v & -17);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f544m = i;
        this.f543l = C0529a.m2093a(this.f545n, i);
        m540b();
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f543l = drawable;
        this.f544m = 0;
        m540b();
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f549r = colorStateList;
        this.f551t = true;
        m540b();
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f550s = mode;
        this.f552u = true;
        m540b();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f538g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f539h = c;
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        this.f539h = c;
        this.f540i = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f546o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f539h = c;
        this.f541j = Character.toLowerCase(c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f539h = c;
        this.f540i = KeyEvent.normalizeMetaState(i);
        this.f541j = Character.toLowerCase(c2);
        this.f542k = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public MenuItem setTitle(int i) {
        this.f536e = this.f545n.getResources().getString(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f536e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f537f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i = 8;
        int i2 = this.f553v & 8;
        if (z) {
            i = 0;
        }
        this.f553v = i2 | i;
        return this;
    }
}
