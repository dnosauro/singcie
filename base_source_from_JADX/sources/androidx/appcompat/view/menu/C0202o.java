package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.p021a.p022a.C0486a;

/* renamed from: androidx.appcompat.view.menu.o */
public class C0202o extends C0173c implements Menu {

    /* renamed from: b */
    private final C0486a f683b;

    public C0202o(Context context, C0486a aVar) {
        super(context);
        if (aVar != null) {
            this.f683b = aVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(int i) {
        return mo1315a(this.f683b.add(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return mo1315a(this.f683b.add(i, i2, i3, i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return mo1315a(this.f683b.add(i, i2, i3, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return mo1315a(this.f683b.add(charSequence));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = this.f683b.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr2[i5] = mo1315a(menuItemArr3[i5]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(int i) {
        return mo1316a(this.f683b.addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return mo1316a(this.f683b.addSubMenu(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return mo1316a(this.f683b.addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return mo1316a(this.f683b.addSubMenu(charSequence));
    }

    public void clear() {
        mo1317a();
        this.f683b.clear();
    }

    public void close() {
        this.f683b.close();
    }

    public MenuItem findItem(int i) {
        return mo1315a(this.f683b.findItem(i));
    }

    public MenuItem getItem(int i) {
        return mo1315a(this.f683b.getItem(i));
    }

    public boolean hasVisibleItems() {
        return this.f683b.hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f683b.isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return this.f683b.performIdentifierAction(i, i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f683b.performShortcut(i, keyEvent, i2);
    }

    public void removeGroup(int i) {
        mo1318a(i);
        this.f683b.removeGroup(i);
    }

    public void removeItem(int i) {
        mo1319b(i);
        this.f683b.removeItem(i);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f683b.setGroupCheckable(i, z, z2);
    }

    public void setGroupEnabled(int i, boolean z) {
        this.f683b.setGroupEnabled(i, z);
    }

    public void setGroupVisible(int i, boolean z) {
        this.f683b.setGroupVisible(i, z);
    }

    public void setQwertyMode(boolean z) {
        this.f683b.setQwertyMode(z);
    }

    public int size() {
        return this.f683b.size();
    }
}
