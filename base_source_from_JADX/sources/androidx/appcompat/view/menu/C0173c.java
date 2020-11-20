package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.p021a.p022a.C0487b;
import androidx.core.p021a.p022a.C0488c;
import androidx.p018c.C0400a;
import java.util.Iterator;
import java.util.Map;

/* renamed from: androidx.appcompat.view.menu.c */
abstract class C0173c {

    /* renamed from: a */
    final Context f564a;

    /* renamed from: b */
    private Map<C0487b, MenuItem> f565b;

    /* renamed from: c */
    private Map<C0488c, SubMenu> f566c;

    C0173c(Context context) {
        this.f564a = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final MenuItem mo1315a(MenuItem menuItem) {
        if (!(menuItem instanceof C0487b)) {
            return menuItem;
        }
        C0487b bVar = (C0487b) menuItem;
        if (this.f565b == null) {
            this.f565b = new C0400a();
        }
        MenuItem menuItem2 = this.f565b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        C0189j jVar = new C0189j(this.f564a, bVar);
        this.f565b.put(bVar, jVar);
        return jVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final SubMenu mo1316a(SubMenu subMenu) {
        if (!(subMenu instanceof C0488c)) {
            return subMenu;
        }
        C0488c cVar = (C0488c) subMenu;
        if (this.f566c == null) {
            this.f566c = new C0400a();
        }
        SubMenu subMenu2 = this.f566c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        C0208s sVar = new C0208s(this.f564a, cVar);
        this.f566c.put(cVar, sVar);
        return sVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo1317a() {
        Map<C0487b, MenuItem> map = this.f565b;
        if (map != null) {
            map.clear();
        }
        Map<C0488c, SubMenu> map2 = this.f566c;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo1318a(int i) {
        Map<C0487b, MenuItem> map = this.f565b;
        if (map != null) {
            Iterator<C0487b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo1319b(int i) {
        Map<C0487b, MenuItem> map = this.f565b;
        if (map != null) {
            Iterator<C0487b> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (i == it.next().getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
