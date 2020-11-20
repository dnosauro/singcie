package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.C0156b;
import androidx.appcompat.view.menu.C0183g;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.view.e */
public class C0160e extends C0156b implements C0183g.C0184a {

    /* renamed from: a */
    private Context f435a;

    /* renamed from: b */
    private ActionBarContextView f436b;

    /* renamed from: c */
    private C0156b.C0157a f437c;

    /* renamed from: d */
    private WeakReference<View> f438d;

    /* renamed from: e */
    private boolean f439e;

    /* renamed from: f */
    private boolean f440f;

    /* renamed from: g */
    private C0183g f441g;

    public C0160e(Context context, ActionBarContextView actionBarContextView, C0156b.C0157a aVar, boolean z) {
        this.f435a = context;
        this.f436b = actionBarContextView;
        this.f437c = aVar;
        this.f441g = new C0183g(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f441g.setCallback(this);
        this.f440f = z;
    }

    /* renamed from: a */
    public MenuInflater mo982a() {
        return new C0163g(this.f436b.getContext());
    }

    /* renamed from: a */
    public void mo983a(int i) {
        mo989b((CharSequence) this.f435a.getString(i));
    }

    /* renamed from: a */
    public void mo984a(View view) {
        this.f436b.setCustomView(view);
        this.f438d = view != null ? new WeakReference<>(view) : null;
    }

    /* renamed from: a */
    public void mo985a(CharSequence charSequence) {
        this.f436b.setSubtitle(charSequence);
    }

    /* renamed from: a */
    public void mo986a(boolean z) {
        super.mo986a(z);
        this.f436b.setTitleOptional(z);
    }

    /* renamed from: b */
    public Menu mo987b() {
        return this.f441g;
    }

    /* renamed from: b */
    public void mo988b(int i) {
        mo985a((CharSequence) this.f435a.getString(i));
    }

    /* renamed from: b */
    public void mo989b(CharSequence charSequence) {
        this.f436b.setTitle(charSequence);
    }

    /* renamed from: c */
    public void mo990c() {
        if (!this.f439e) {
            this.f439e = true;
            this.f436b.sendAccessibilityEvent(32);
            this.f437c.mo916a(this);
        }
    }

    /* renamed from: d */
    public void mo991d() {
        this.f437c.mo919b(this, this.f441g);
    }

    /* renamed from: f */
    public CharSequence mo993f() {
        return this.f436b.getTitle();
    }

    /* renamed from: g */
    public CharSequence mo994g() {
        return this.f436b.getSubtitle();
    }

    /* renamed from: h */
    public boolean mo995h() {
        return this.f436b.mo1666d();
    }

    /* renamed from: i */
    public View mo996i() {
        WeakReference<View> weakReference = this.f438d;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    public boolean onMenuItemSelected(C0183g gVar, MenuItem menuItem) {
        return this.f437c.mo918a((C0156b) this, menuItem);
    }

    public void onMenuModeChange(C0183g gVar) {
        mo991d();
        this.f436b.mo1663a();
    }
}
