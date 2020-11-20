package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.C0158c;
import androidx.core.p021a.p022a.C0487b;
import androidx.core.p030h.C0634b;
import java.lang.reflect.Method;

/* renamed from: androidx.appcompat.view.menu.j */
public class C0189j extends C0173c implements MenuItem {

    /* renamed from: b */
    private final C0487b f658b;

    /* renamed from: c */
    private Method f659c;

    /* renamed from: androidx.appcompat.view.menu.j$a */
    private class C0190a extends C0634b {

        /* renamed from: a */
        final ActionProvider f660a;

        C0190a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f660a = actionProvider;
        }

        /* renamed from: a */
        public View mo1567a() {
            return this.f660a.onCreateActionView();
        }

        /* renamed from: a */
        public void mo1568a(SubMenu subMenu) {
            this.f660a.onPrepareSubMenu(C0189j.this.mo1316a(subMenu));
        }

        /* renamed from: b */
        public boolean mo1569b() {
            return this.f660a.onPerformDefaultAction();
        }

        /* renamed from: c */
        public boolean mo1570c() {
            return this.f660a.hasSubMenu();
        }
    }

    /* renamed from: androidx.appcompat.view.menu.j$b */
    private class C0191b extends C0190a implements ActionProvider.VisibilityListener {

        /* renamed from: d */
        private C0634b.C0636b f663d;

        C0191b(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        /* renamed from: a */
        public View mo1571a(MenuItem menuItem) {
            return this.f660a.onCreateActionView(menuItem);
        }

        /* renamed from: a */
        public void mo1572a(C0634b.C0636b bVar) {
            this.f663d = bVar;
            this.f660a.setVisibilityListener(bVar != null ? this : null);
        }

        /* renamed from: d */
        public boolean mo1573d() {
            return this.f660a.overridesItemVisibility();
        }

        /* renamed from: e */
        public boolean mo1574e() {
            return this.f660a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            C0634b.C0636b bVar = this.f663d;
            if (bVar != null) {
                bVar.mo1511a(z);
            }
        }
    }

    /* renamed from: androidx.appcompat.view.menu.j$c */
    static class C0192c extends FrameLayout implements C0158c {

        /* renamed from: a */
        final CollapsibleActionView f664a;

        C0192c(View view) {
            super(view.getContext());
            this.f664a = (CollapsibleActionView) view;
            addView(view);
        }

        /* renamed from: a */
        public void mo1138a() {
            this.f664a.onActionViewExpanded();
        }

        /* renamed from: b */
        public void mo1139b() {
            this.f664a.onActionViewCollapsed();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public View mo1576c() {
            return (View) this.f664a;
        }
    }

    /* renamed from: androidx.appcompat.view.menu.j$d */
    private class C0193d implements MenuItem.OnActionExpandListener {

        /* renamed from: b */
        private final MenuItem.OnActionExpandListener f666b;

        C0193d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f666b = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f666b.onMenuItemActionCollapse(C0189j.this.mo1315a(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f666b.onMenuItemActionExpand(C0189j.this.mo1315a(menuItem));
        }
    }

    /* renamed from: androidx.appcompat.view.menu.j$e */
    private class C0194e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: b */
        private final MenuItem.OnMenuItemClickListener f668b;

        C0194e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f668b = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f668b.onMenuItemClick(C0189j.this.mo1315a(menuItem));
        }
    }

    public C0189j(Context context, C0487b bVar) {
        super(context);
        if (bVar != null) {
            this.f658b = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    /* renamed from: a */
    public void mo1512a(boolean z) {
        try {
            if (this.f659c == null) {
                this.f659c = this.f658b.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f659c.invoke(this.f658b, new Object[]{Boolean.valueOf(z)});
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public boolean collapseActionView() {
        return this.f658b.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f658b.expandActionView();
    }

    public ActionProvider getActionProvider() {
        C0634b a = this.f658b.mo1240a();
        if (a instanceof C0190a) {
            return ((C0190a) a).f660a;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f658b.getActionView();
        return actionView instanceof C0192c ? ((C0192c) actionView).mo1576c() : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f658b.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f658b.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f658b.getContentDescription();
    }

    public int getGroupId() {
        return this.f658b.getGroupId();
    }

    public Drawable getIcon() {
        return this.f658b.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f658b.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f658b.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f658b.getIntent();
    }

    public int getItemId() {
        return this.f658b.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f658b.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f658b.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f658b.getNumericShortcut();
    }

    public int getOrder() {
        return this.f658b.getOrder();
    }

    public SubMenu getSubMenu() {
        return mo1316a(this.f658b.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f658b.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f658b.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f658b.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.f658b.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f658b.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f658b.isCheckable();
    }

    public boolean isChecked() {
        return this.f658b.isChecked();
    }

    public boolean isEnabled() {
        return this.f658b.isEnabled();
    }

    public boolean isVisible() {
        return this.f658b.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        C0634b bVar = Build.VERSION.SDK_INT >= 16 ? new C0191b(this.f564a, actionProvider) : new C0190a(this.f564a, actionProvider);
        C0487b bVar2 = this.f658b;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.mo1238a(bVar);
        return this;
    }

    public MenuItem setActionView(int i) {
        this.f658b.setActionView(i);
        View actionView = this.f658b.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f658b.setActionView((View) new C0192c(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0192c(view);
        }
        this.f658b.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f658b.setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f658b.setAlphabeticShortcut(c, i);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f658b.setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f658b.setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f658b.mo1239a(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f658b.setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f658b.setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f658b.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f658b.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f658b.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f658b.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f658b.setNumericShortcut(c);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int i) {
        this.f658b.setNumericShortcut(c, i);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f658b.setOnActionExpandListener(onActionExpandListener != null ? new C0193d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f658b.setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0194e(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f658b.setShortcut(c, c2);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f658b.setShortcut(c, c2, i, i2);
        return this;
    }

    public void setShowAsAction(int i) {
        this.f658b.setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        this.f658b.setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f658b.setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f658b.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f658b.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f658b.mo1242b(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return this.f658b.setVisible(z);
    }
}
