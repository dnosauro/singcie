package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.C0198m;
import androidx.appcompat.view.menu.C0200n;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.b */
public abstract class C0172b implements C0198m {

    /* renamed from: a */
    protected Context f554a;

    /* renamed from: b */
    protected Context f555b;

    /* renamed from: c */
    protected C0183g f556c;

    /* renamed from: d */
    protected LayoutInflater f557d;

    /* renamed from: e */
    protected LayoutInflater f558e;

    /* renamed from: f */
    protected C0200n f559f;

    /* renamed from: g */
    private C0198m.C0199a f560g;

    /* renamed from: h */
    private int f561h;

    /* renamed from: i */
    private int f562i;

    /* renamed from: j */
    private int f563j;

    public C0172b(Context context, int i, int i2) {
        this.f554a = context;
        this.f557d = LayoutInflater.from(context);
        this.f561h = i;
        this.f562i = i2;
    }

    /* renamed from: a */
    public View mo1297a(C0187i iVar, View view, ViewGroup viewGroup) {
        C0200n.C0201a b = view instanceof C0200n.C0201a ? (C0200n.C0201a) view : mo1305b(viewGroup);
        mo1302a(iVar, b);
        return (View) b;
    }

    /* renamed from: a */
    public C0198m.C0199a mo1298a() {
        return this.f560g;
    }

    /* renamed from: a */
    public C0200n mo1299a(ViewGroup viewGroup) {
        if (this.f559f == null) {
            this.f559f = (C0200n) this.f557d.inflate(this.f561h, viewGroup, false);
            this.f559f.initialize(this.f556c);
            updateMenuView(true);
        }
        return this.f559f;
    }

    /* renamed from: a */
    public void mo1300a(int i) {
        this.f563j = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo1301a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f559f).addView(view, i);
    }

    /* renamed from: a */
    public abstract void mo1302a(C0187i iVar, C0200n.C0201a aVar);

    /* renamed from: a */
    public boolean mo1303a(int i, C0187i iVar) {
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo1304a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    /* renamed from: b */
    public C0200n.C0201a mo1305b(ViewGroup viewGroup) {
        return (C0200n.C0201a) this.f557d.inflate(this.f562i, viewGroup, false);
    }

    public boolean collapseItemActionView(C0183g gVar, C0187i iVar) {
        return false;
    }

    public boolean expandItemActionView(C0183g gVar, C0187i iVar) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getId() {
        return this.f563j;
    }

    public void initForMenu(Context context, C0183g gVar) {
        this.f555b = context;
        this.f558e = LayoutInflater.from(this.f555b);
        this.f556c = gVar;
    }

    public void onCloseMenu(C0183g gVar, boolean z) {
        C0198m.C0199a aVar = this.f560g;
        if (aVar != null) {
            aVar.mo914a(gVar, z);
        }
    }

    public boolean onSubMenuSelected(C0207r rVar) {
        C0198m.C0199a aVar = this.f560g;
        if (aVar != null) {
            return aVar.mo915a(rVar);
        }
        return false;
    }

    public void setCallback(C0198m.C0199a aVar) {
        this.f560g = aVar;
    }

    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f559f;
        if (viewGroup != null) {
            C0183g gVar = this.f556c;
            int i = 0;
            if (gVar != null) {
                gVar.flagActionItems();
                ArrayList<C0187i> visibleItems = this.f556c.getVisibleItems();
                int size = visibleItems.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    C0187i iVar = visibleItems.get(i3);
                    if (mo1303a(i2, iVar)) {
                        View childAt = viewGroup.getChildAt(i2);
                        C0187i itemData = childAt instanceof C0200n.C0201a ? ((C0200n.C0201a) childAt).getItemData() : null;
                        View a = mo1297a(iVar, childAt, viewGroup);
                        if (iVar != itemData) {
                            a.setPressed(false);
                            a.jumpDrawablesToCurrentState();
                        }
                        if (a != childAt) {
                            mo1301a(a, i2);
                        }
                        i2++;
                    }
                }
                i = i2;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo1304a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }
}
