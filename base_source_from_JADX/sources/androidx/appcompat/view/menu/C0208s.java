package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.p021a.p022a.C0488c;

/* renamed from: androidx.appcompat.view.menu.s */
class C0208s extends C0202o implements SubMenu {

    /* renamed from: b */
    private final C0488c f707b;

    C0208s(Context context, C0488c cVar) {
        super(context, cVar);
        this.f707b = cVar;
    }

    public void clearHeader() {
        this.f707b.clearHeader();
    }

    public MenuItem getItem() {
        return mo1315a(this.f707b.getItem());
    }

    public SubMenu setHeaderIcon(int i) {
        this.f707b.setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f707b.setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        this.f707b.setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f707b.setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        this.f707b.setHeaderView(view);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f707b.setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f707b.setIcon(drawable);
        return this;
    }
}
