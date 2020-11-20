package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.C0200n;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.f */
public class C0182f extends BaseAdapter {

    /* renamed from: a */
    C0183g f616a;

    /* renamed from: b */
    private int f617b = -1;

    /* renamed from: c */
    private boolean f618c;

    /* renamed from: d */
    private final boolean f619d;

    /* renamed from: e */
    private final LayoutInflater f620e;

    /* renamed from: f */
    private final int f621f;

    public C0182f(C0183g gVar, LayoutInflater layoutInflater, boolean z, int i) {
        this.f619d = z;
        this.f620e = layoutInflater;
        this.f616a = gVar;
        this.f621f = i;
        mo1359b();
    }

    /* renamed from: a */
    public C0183g mo1356a() {
        return this.f616a;
    }

    /* renamed from: a */
    public C0187i getItem(int i) {
        ArrayList<C0187i> nonActionItems = this.f619d ? this.f616a.getNonActionItems() : this.f616a.getVisibleItems();
        int i2 = this.f617b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return nonActionItems.get(i);
    }

    /* renamed from: a */
    public void mo1358a(boolean z) {
        this.f618c = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo1359b() {
        C0187i expandedItem = this.f616a.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<C0187i> nonActionItems = this.f616a.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.f617b = i;
                    return;
                }
            }
        }
        this.f617b = -1;
    }

    public int getCount() {
        ArrayList<C0187i> nonActionItems = this.f619d ? this.f616a.getNonActionItems() : this.f616a.getVisibleItems();
        return this.f617b < 0 ? nonActionItems.size() : nonActionItems.size() - 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f620e.inflate(this.f621f, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f616a.isGroupDividerEnabled() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        C0200n.C0201a aVar = (C0200n.C0201a) view;
        if (this.f618c) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(i), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        mo1359b();
        super.notifyDataSetChanged();
    }
}
