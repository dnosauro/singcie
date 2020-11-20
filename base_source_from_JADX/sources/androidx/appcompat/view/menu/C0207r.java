package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.C0183g;

/* renamed from: androidx.appcompat.view.menu.r */
public class C0207r extends C0183g implements SubMenu {
    private C0187i mItem;
    private C0183g mParentMenu;

    public C0207r(Context context, C0183g gVar, C0187i iVar) {
        super(context);
        this.mParentMenu = gVar;
        this.mItem = iVar;
    }

    public boolean collapseItemActionView(C0187i iVar) {
        return this.mParentMenu.collapseItemActionView(iVar);
    }

    /* access modifiers changed from: package-private */
    public boolean dispatchMenuItemSelected(C0183g gVar, MenuItem menuItem) {
        return super.dispatchMenuItemSelected(gVar, menuItem) || this.mParentMenu.dispatchMenuItemSelected(gVar, menuItem);
    }

    public boolean expandItemActionView(C0187i iVar) {
        return this.mParentMenu.expandItemActionView(iVar);
    }

    public String getActionViewStatesKey() {
        C0187i iVar = this.mItem;
        int itemId = iVar != null ? iVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }

    public MenuItem getItem() {
        return this.mItem;
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    public C0183g getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    public void setCallback(C0183g.C0184a aVar) {
        this.mParentMenu.setCallback(aVar);
    }

    public void setGroupDividerEnabled(boolean z) {
        this.mParentMenu.setGroupDividerEnabled(z);
    }

    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.setHeaderIconInt(i);
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.setHeaderTitleInt(i);
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    public SubMenu setIcon(int i) {
        this.mItem.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.mItem.setIcon(drawable);
        return this;
    }

    public void setQwertyMode(boolean z) {
        this.mParentMenu.setQwertyMode(z);
    }

    public void setShortcutsVisible(boolean z) {
        this.mParentMenu.setShortcutsVisible(z);
    }
}
