package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.C0198m;
import androidx.appcompat.view.menu.C0200n;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.e */
public class C0180e implements AdapterView.OnItemClickListener, C0198m {

    /* renamed from: a */
    Context f604a;

    /* renamed from: b */
    LayoutInflater f605b;

    /* renamed from: c */
    C0183g f606c;

    /* renamed from: d */
    ExpandedMenuView f607d;

    /* renamed from: e */
    int f608e;

    /* renamed from: f */
    int f609f;

    /* renamed from: g */
    int f610g;

    /* renamed from: h */
    C0181a f611h;

    /* renamed from: i */
    private C0198m.C0199a f612i;

    /* renamed from: j */
    private int f613j;

    /* renamed from: androidx.appcompat.view.menu.e$a */
    private class C0181a extends BaseAdapter {

        /* renamed from: b */
        private int f615b = -1;

        public C0181a() {
            mo1350a();
        }

        /* renamed from: a */
        public C0187i getItem(int i) {
            ArrayList<C0187i> nonActionItems = C0180e.this.f606c.getNonActionItems();
            int i2 = i + C0180e.this.f608e;
            int i3 = this.f615b;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1350a() {
            C0187i expandedItem = C0180e.this.f606c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<C0187i> nonActionItems = C0180e.this.f606c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.f615b = i;
                        return;
                    }
                }
            }
            this.f615b = -1;
        }

        public int getCount() {
            int size = C0180e.this.f606c.getNonActionItems().size() - C0180e.this.f608e;
            return this.f615b < 0 ? size : size - 1;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = C0180e.this.f605b.inflate(C0180e.this.f610g, viewGroup, false);
            }
            ((C0200n.C0201a) view).initialize(getItem(i), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            mo1350a();
            super.notifyDataSetChanged();
        }
    }

    public C0180e(int i, int i2) {
        this.f610g = i;
        this.f609f = i2;
    }

    public C0180e(Context context, int i) {
        this(i, 0);
        this.f604a = context;
        this.f605b = LayoutInflater.from(this.f604a);
    }

    /* renamed from: a */
    public ListAdapter mo1344a() {
        if (this.f611h == null) {
            this.f611h = new C0181a();
        }
        return this.f611h;
    }

    /* renamed from: a */
    public C0200n mo1345a(ViewGroup viewGroup) {
        if (this.f607d == null) {
            this.f607d = (ExpandedMenuView) this.f605b.inflate(C0059a.C0066g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f611h == null) {
                this.f611h = new C0181a();
            }
            this.f607d.setAdapter(this.f611h);
            this.f607d.setOnItemClickListener(this);
        }
        return this.f607d;
    }

    /* renamed from: a */
    public void mo1346a(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.f607d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    /* renamed from: b */
    public void mo1347b(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f607d.restoreHierarchyState(sparseParcelableArray);
        }
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
        return this.f613j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r2.f605b == null) goto L_0x000b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initForMenu(android.content.Context r3, androidx.appcompat.view.menu.C0183g r4) {
        /*
            r2 = this;
            int r0 = r2.f609f
            if (r0 == 0) goto L_0x0014
            android.view.ContextThemeWrapper r1 = new android.view.ContextThemeWrapper
            r1.<init>(r3, r0)
            r2.f604a = r1
        L_0x000b:
            android.content.Context r3 = r2.f604a
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            r2.f605b = r3
            goto L_0x001f
        L_0x0014:
            android.content.Context r0 = r2.f604a
            if (r0 == 0) goto L_0x001f
            r2.f604a = r3
            android.view.LayoutInflater r3 = r2.f605b
            if (r3 != 0) goto L_0x001f
            goto L_0x000b
        L_0x001f:
            r2.f606c = r4
            androidx.appcompat.view.menu.e$a r3 = r2.f611h
            if (r3 == 0) goto L_0x0028
            r3.notifyDataSetChanged()
        L_0x0028:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.C0180e.initForMenu(android.content.Context, androidx.appcompat.view.menu.g):void");
    }

    public void onCloseMenu(C0183g gVar, boolean z) {
        C0198m.C0199a aVar = this.f612i;
        if (aVar != null) {
            aVar.mo914a(gVar, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f606c.performItemAction(this.f611h.getItem(i), this, 0);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        mo1347b((Bundle) parcelable);
    }

    public Parcelable onSaveInstanceState() {
        if (this.f607d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        mo1346a(bundle);
        return bundle;
    }

    public boolean onSubMenuSelected(C0207r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new C0186h(rVar).mo1447a((IBinder) null);
        C0198m.C0199a aVar = this.f612i;
        if (aVar == null) {
            return true;
        }
        aVar.mo915a(rVar);
        return true;
    }

    public void setCallback(C0198m.C0199a aVar) {
        this.f612i = aVar;
    }

    public void updateMenuView(boolean z) {
        C0181a aVar = this.f611h;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }
}
