package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* renamed from: androidx.appcompat.view.menu.k */
abstract class C0195k implements AdapterView.OnItemClickListener, C0198m, C0203p {

    /* renamed from: a */
    private Rect f669a;

    C0195k() {
    }

    /* renamed from: a */
    protected static int m643a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    /* renamed from: a */
    protected static C0182f m644a(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (C0182f) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (C0182f) listAdapter;
    }

    /* renamed from: b */
    protected static boolean m645b(C0183g gVar) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public abstract void mo1320a(int i);

    /* renamed from: a */
    public void mo1580a(Rect rect) {
        this.f669a = rect;
    }

    /* renamed from: a */
    public abstract void mo1321a(View view);

    /* renamed from: a */
    public abstract void mo1322a(PopupWindow.OnDismissListener onDismissListener);

    /* renamed from: a */
    public abstract void mo1323a(C0183g gVar);

    /* renamed from: a */
    public abstract void mo1324a(boolean z);

    /* renamed from: b */
    public abstract void mo1326b(int i);

    /* renamed from: b */
    public abstract void mo1327b(boolean z);

    /* renamed from: c */
    public abstract void mo1328c(int i);

    public boolean collapseItemActionView(C0183g gVar, C0187i iVar) {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo1330e() {
        return true;
    }

    public boolean expandItemActionView(C0183g gVar, C0187i iVar) {
        return false;
    }

    /* renamed from: f */
    public Rect mo1581f() {
        return this.f669a;
    }

    public int getId() {
        return 0;
    }

    public void initForMenu(Context context, C0183g gVar) {
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m644a(listAdapter).f616a.performItemAction((MenuItem) listAdapter.getItem(i), this, mo1330e() ? 0 : 4);
    }
}
