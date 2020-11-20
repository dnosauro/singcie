package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.C0156b;
import androidx.appcompat.view.menu.C0189j;
import androidx.appcompat.view.menu.C0202o;
import androidx.core.p021a.p022a.C0486a;
import androidx.core.p021a.p022a.C0487b;
import androidx.p018c.C0413g;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.f */
public class C0161f extends ActionMode {

    /* renamed from: a */
    final Context f442a;

    /* renamed from: b */
    final C0156b f443b;

    /* renamed from: androidx.appcompat.view.f$a */
    public static class C0162a implements C0156b.C0157a {

        /* renamed from: a */
        final ActionMode.Callback f444a;

        /* renamed from: b */
        final Context f445b;

        /* renamed from: c */
        final ArrayList<C0161f> f446c = new ArrayList<>();

        /* renamed from: d */
        final C0413g<Menu, Menu> f447d = new C0413g<>();

        public C0162a(Context context, ActionMode.Callback callback) {
            this.f445b = context;
            this.f444a = callback;
        }

        /* renamed from: a */
        private Menu m495a(Menu menu) {
            Menu menu2 = this.f447d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            C0202o oVar = new C0202o(this.f445b, (C0486a) menu);
            this.f447d.put(menu, oVar);
            return oVar;
        }

        /* renamed from: a */
        public void mo916a(C0156b bVar) {
            this.f444a.onDestroyActionMode(mo1165b(bVar));
        }

        /* renamed from: a */
        public boolean mo917a(C0156b bVar, Menu menu) {
            return this.f444a.onCreateActionMode(mo1165b(bVar), m495a(menu));
        }

        /* renamed from: a */
        public boolean mo918a(C0156b bVar, MenuItem menuItem) {
            return this.f444a.onActionItemClicked(mo1165b(bVar), new C0189j(this.f445b, (C0487b) menuItem));
        }

        /* renamed from: b */
        public ActionMode mo1165b(C0156b bVar) {
            int size = this.f446c.size();
            for (int i = 0; i < size; i++) {
                C0161f fVar = this.f446c.get(i);
                if (fVar != null && fVar.f443b == bVar) {
                    return fVar;
                }
            }
            C0161f fVar2 = new C0161f(this.f445b, bVar);
            this.f446c.add(fVar2);
            return fVar2;
        }

        /* renamed from: b */
        public boolean mo919b(C0156b bVar, Menu menu) {
            return this.f444a.onPrepareActionMode(mo1165b(bVar), m495a(menu));
        }
    }

    public C0161f(Context context, C0156b bVar) {
        this.f442a = context;
        this.f443b = bVar;
    }

    public void finish() {
        this.f443b.mo990c();
    }

    public View getCustomView() {
        return this.f443b.mo996i();
    }

    public Menu getMenu() {
        return new C0202o(this.f442a, (C0486a) this.f443b.mo987b());
    }

    public MenuInflater getMenuInflater() {
        return this.f443b.mo982a();
    }

    public CharSequence getSubtitle() {
        return this.f443b.mo994g();
    }

    public Object getTag() {
        return this.f443b.mo1136j();
    }

    public CharSequence getTitle() {
        return this.f443b.mo993f();
    }

    public boolean getTitleOptionalHint() {
        return this.f443b.mo1137k();
    }

    public void invalidate() {
        this.f443b.mo991d();
    }

    public boolean isTitleOptional() {
        return this.f443b.mo995h();
    }

    public void setCustomView(View view) {
        this.f443b.mo984a(view);
    }

    public void setSubtitle(int i) {
        this.f443b.mo988b(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f443b.mo985a(charSequence);
    }

    public void setTag(Object obj) {
        this.f443b.mo1135a(obj);
    }

    public void setTitle(int i) {
        this.f443b.mo983a(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f443b.mo989b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f443b.mo986a(z);
    }
}
