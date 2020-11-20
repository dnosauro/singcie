package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.C0155a;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.C0172b;
import androidx.appcompat.view.menu.C0183g;
import androidx.appcompat.view.menu.C0187i;
import androidx.appcompat.view.menu.C0196l;
import androidx.appcompat.view.menu.C0198m;
import androidx.appcompat.view.menu.C0200n;
import androidx.appcompat.view.menu.C0203p;
import androidx.appcompat.view.menu.C0207r;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.C0595a;
import androidx.core.p030h.C0634b;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.widget.c */
class C0315c extends C0172b implements C0634b.C0635a {

    /* renamed from: g */
    C0319d f1142g;

    /* renamed from: h */
    C0321e f1143h;

    /* renamed from: i */
    C0316a f1144i;

    /* renamed from: j */
    C0318c f1145j;

    /* renamed from: k */
    final C0322f f1146k = new C0322f();

    /* renamed from: l */
    int f1147l;

    /* renamed from: m */
    private Drawable f1148m;

    /* renamed from: n */
    private boolean f1149n;

    /* renamed from: o */
    private boolean f1150o;

    /* renamed from: p */
    private boolean f1151p;

    /* renamed from: q */
    private int f1152q;

    /* renamed from: r */
    private int f1153r;

    /* renamed from: s */
    private int f1154s;

    /* renamed from: t */
    private boolean f1155t;

    /* renamed from: u */
    private boolean f1156u;

    /* renamed from: v */
    private boolean f1157v;

    /* renamed from: w */
    private boolean f1158w;

    /* renamed from: x */
    private int f1159x;

    /* renamed from: y */
    private final SparseBooleanArray f1160y = new SparseBooleanArray();

    /* renamed from: z */
    private C0317b f1161z;

    /* renamed from: androidx.appcompat.widget.c$a */
    private class C0316a extends C0196l {
        public C0316a(Context context, C0207r rVar, View view) {
            super(context, rVar, view, false, C0059a.C0060a.actionOverflowMenuStyle);
            if (!((C0187i) rVar.getItem()).mo1487j()) {
                mo1585a(C0315c.this.f1142g == null ? (View) C0315c.this.f559f : C0315c.this.f1142g);
            }
            mo1587a((C0198m.C0199a) C0315c.this.f1146k);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public void mo1593e() {
            C0315c cVar = C0315c.this;
            cVar.f1144i = null;
            cVar.f1147l = 0;
            super.mo1593e();
        }
    }

    /* renamed from: androidx.appcompat.widget.c$b */
    private class C0317b extends ActionMenuItemView.C0170b {
        C0317b() {
        }

        /* renamed from: a */
        public C0203p mo1220a() {
            if (C0315c.this.f1144i != null) {
                return C0315c.this.f1144i.mo1590b();
            }
            return null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$c */
    private class C0318c implements Runnable {

        /* renamed from: b */
        private C0321e f1165b;

        public C0318c(C0321e eVar) {
            this.f1165b = eVar;
        }

        public void run() {
            if (C0315c.this.f556c != null) {
                C0315c.this.f556c.changeMenuMode();
            }
            View view = (View) C0315c.this.f559f;
            if (!(view == null || view.getWindowToken() == null || !this.f1165b.mo1591c())) {
                C0315c.this.f1143h = this.f1165b;
            }
            C0315c.this.f1145j = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$d */
    private class C0319d extends C0343p implements ActionMenuView.C0215a {

        /* renamed from: b */
        private final float[] f1167b = new float[2];

        public C0319d(Context context) {
            super(context, (AttributeSet) null, C0059a.C0060a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            C0307ba.m1144a(this, getContentDescription());
            setOnTouchListener(new C0263ai(this, C0315c.this) {
                /* renamed from: a */
                public C0203p mo1218a() {
                    if (C0315c.this.f1143h == null) {
                        return null;
                    }
                    return C0315c.this.f1143h.mo1590b();
                }

                /* renamed from: b */
                public boolean mo1219b() {
                    C0315c.this.mo2460c();
                    return true;
                }

                /* renamed from: c */
                public boolean mo2149c() {
                    if (C0315c.this.f1145j != null) {
                        return false;
                    }
                    C0315c.this.mo2461d();
                    return true;
                }
            });
        }

        /* renamed from: b */
        public boolean mo1200b() {
            return false;
        }

        /* renamed from: c */
        public boolean mo1201c() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            C0315c.this.mo2460c();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C0595a.m2318a(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* renamed from: androidx.appcompat.widget.c$e */
    private class C0321e extends C0196l {
        public C0321e(Context context, C0183g gVar, View view, boolean z) {
            super(context, gVar, view, z, C0059a.C0060a.actionOverflowMenuStyle);
            mo1584a(8388613);
            mo1587a((C0198m.C0199a) C0315c.this.f1146k);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public void mo1593e() {
            if (C0315c.this.f556c != null) {
                C0315c.this.f556c.close();
            }
            C0315c.this.f1143h = null;
            super.mo1593e();
        }
    }

    /* renamed from: androidx.appcompat.widget.c$f */
    private class C0322f implements C0198m.C0199a {
        C0322f() {
        }

        /* renamed from: a */
        public void mo914a(C0183g gVar, boolean z) {
            if (gVar instanceof C0207r) {
                gVar.getRootMenu().close(false);
            }
            C0198m.C0199a a = C0315c.this.mo1298a();
            if (a != null) {
                a.mo914a(gVar, z);
            }
        }

        /* renamed from: a */
        public boolean mo915a(C0183g gVar) {
            if (gVar == null) {
                return false;
            }
            C0315c.this.f1147l = ((C0207r) gVar).getItem().getItemId();
            C0198m.C0199a a = C0315c.this.mo1298a();
            if (a != null) {
                return a.mo915a(gVar);
            }
            return false;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* renamed from: androidx.appcompat.widget.c$g */
    private static class C0323g implements Parcelable {
        public static final Parcelable.Creator<C0323g> CREATOR = new Parcelable.Creator<C0323g>() {
            /* renamed from: a */
            public C0323g createFromParcel(Parcel parcel) {
                return new C0323g(parcel);
            }

            /* renamed from: a */
            public C0323g[] newArray(int i) {
                return new C0323g[i];
            }
        };

        /* renamed from: a */
        public int f1172a;

        C0323g() {
        }

        C0323g(Parcel parcel) {
            this.f1172a = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1172a);
        }
    }

    public C0315c(Context context) {
        super(context, C0059a.C0066g.abc_action_menu_layout, C0059a.C0066g.abc_action_menu_item_layout);
    }

    /* renamed from: a */
    private View m1166a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f559f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C0200n.C0201a) && ((C0200n.C0201a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: a */
    public View mo1297a(C0187i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.mo1491n()) {
            actionView = super.mo1297a(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    /* renamed from: a */
    public C0200n mo1299a(ViewGroup viewGroup) {
        C0200n nVar = this.f559f;
        C0200n a = super.mo1299a(viewGroup);
        if (nVar != a) {
            ((ActionMenuView) a).setPresenter(this);
        }
        return a;
    }

    /* renamed from: a */
    public void mo2453a(Configuration configuration) {
        if (!this.f1155t) {
            this.f1154s = C0155a.m446a(this.f555b).mo1128a();
        }
        if (this.f556c != null) {
            this.f556c.onItemsChanged(true);
        }
    }

    /* renamed from: a */
    public void mo2454a(Drawable drawable) {
        C0319d dVar = this.f1142g;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.f1149n = true;
        this.f1148m = drawable;
    }

    /* renamed from: a */
    public void mo1302a(C0187i iVar, C0200n.C0201a aVar) {
        aVar.initialize(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f559f);
        if (this.f1161z == null) {
            this.f1161z = new C0317b();
        }
        actionMenuItemView.setPopupCallback(this.f1161z);
    }

    /* renamed from: a */
    public void mo2455a(ActionMenuView actionMenuView) {
        this.f559f = actionMenuView;
        actionMenuView.initialize(this.f556c);
    }

    /* renamed from: a */
    public void mo2456a(boolean z) {
        this.f1150o = z;
        this.f1151p = true;
    }

    /* renamed from: a */
    public boolean mo1303a(int i, C0187i iVar) {
        return iVar.mo1487j();
    }

    /* renamed from: a */
    public boolean mo1304a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f1142g) {
            return false;
        }
        return super.mo1304a(viewGroup, i);
    }

    /* renamed from: b */
    public Drawable mo2457b() {
        C0319d dVar = this.f1142g;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f1149n) {
            return this.f1148m;
        }
        return null;
    }

    /* renamed from: b */
    public void mo2458b(boolean z) {
        this.f1158w = z;
    }

    /* renamed from: c */
    public void mo2459c(boolean z) {
        if (z) {
            super.onSubMenuSelected((C0207r) null);
        } else if (this.f556c != null) {
            this.f556c.close(false);
        }
    }

    /* renamed from: c */
    public boolean mo2460c() {
        if (!this.f1150o || mo2464g() || this.f556c == null || this.f559f == null || this.f1145j != null || this.f556c.getNonActionItems().isEmpty()) {
            return false;
        }
        this.f1145j = new C0318c(new C0321e(this.f555b, this.f556c, this.f1142g, true));
        ((View) this.f559f).post(this.f1145j);
        super.onSubMenuSelected((C0207r) null);
        return true;
    }

    /* renamed from: d */
    public boolean mo2461d() {
        if (this.f1145j == null || this.f559f == null) {
            C0321e eVar = this.f1143h;
            if (eVar == null) {
                return false;
            }
            eVar.mo1592d();
            return true;
        }
        ((View) this.f559f).removeCallbacks(this.f1145j);
        this.f1145j = null;
        return true;
    }

    /* renamed from: e */
    public boolean mo2462e() {
        return mo2461d() | mo2463f();
    }

    /* renamed from: f */
    public boolean mo2463f() {
        C0316a aVar = this.f1144i;
        if (aVar == null) {
            return false;
        }
        aVar.mo1592d();
        return true;
    }

    public boolean flagActionItems() {
        int i;
        ArrayList<C0187i> arrayList;
        int i2;
        int i3;
        int i4;
        boolean z;
        C0315c cVar = this;
        View view = null;
        int i5 = 0;
        if (cVar.f556c != null) {
            arrayList = cVar.f556c.getVisibleItems();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i6 = cVar.f1154s;
        int i7 = cVar.f1153r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.f559f;
        int i8 = i6;
        boolean z2 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            C0187i iVar = arrayList.get(i11);
            if (iVar.mo1489l()) {
                i9++;
            } else if (iVar.mo1488k()) {
                i10++;
            } else {
                z2 = true;
            }
            if (cVar.f1158w && iVar.isActionViewExpanded()) {
                i8 = 0;
            }
        }
        if (cVar.f1150o && (z2 || i10 + i9 > i8)) {
            i8--;
        }
        int i12 = i8 - i9;
        SparseBooleanArray sparseBooleanArray = cVar.f1160y;
        sparseBooleanArray.clear();
        if (cVar.f1156u) {
            int i13 = cVar.f1159x;
            i2 = i7 / i13;
            i3 = i13 + ((i7 % i13) / i2);
        } else {
            i3 = 0;
            i2 = 0;
        }
        int i14 = i7;
        int i15 = 0;
        int i16 = 0;
        while (i15 < i) {
            C0187i iVar2 = arrayList.get(i15);
            if (iVar2.mo1489l()) {
                View a = cVar.mo1297a(iVar2, view, viewGroup);
                if (cVar.f1156u) {
                    i2 -= ActionMenuView.m727a(a, i3, i2, makeMeasureSpec, i5);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = a.getMeasuredWidth();
                i14 -= measuredWidth;
                if (i16 != 0) {
                    measuredWidth = i16;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                iVar2.mo1463d(z);
                i16 = measuredWidth;
                i4 = i;
            } else if (iVar2.mo1488k()) {
                int groupId2 = iVar2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i12 > 0 || z3) && i14 > 0 && (!cVar.f1156u || i2 > 0);
                if (z4) {
                    boolean z5 = z4;
                    i4 = i;
                    View a2 = cVar.mo1297a(iVar2, (View) null, viewGroup);
                    if (cVar.f1156u) {
                        int a3 = ActionMenuView.m727a(a2, i3, i2, makeMeasureSpec, 0);
                        i2 -= a3;
                        z5 = a3 == 0 ? false : z5;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    int measuredWidth2 = a2.getMeasuredWidth();
                    i14 -= measuredWidth2;
                    if (i16 == 0) {
                        i16 = measuredWidth2;
                    }
                    z4 = z5 & (!cVar.f1156u ? i14 + i16 > 0 : i14 >= 0);
                } else {
                    boolean z6 = z4;
                    i4 = i;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    int i17 = 0;
                    while (i17 < i15) {
                        C0187i iVar3 = arrayList.get(i17);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.mo1487j()) {
                                i12++;
                            }
                            iVar3.mo1463d(false);
                        }
                        i17++;
                    }
                }
                if (z4) {
                    i12--;
                }
                iVar2.mo1463d(z4);
            } else {
                i4 = i;
                iVar2.mo1463d(false);
                i15++;
                i = i4;
                cVar = this;
                view = null;
                i5 = 0;
            }
            i15++;
            i = i4;
            cVar = this;
            view = null;
            i5 = 0;
        }
        return true;
    }

    /* renamed from: g */
    public boolean mo2464g() {
        C0321e eVar = this.f1143h;
        return eVar != null && eVar.mo1594f();
    }

    /* renamed from: h */
    public boolean mo2465h() {
        return this.f1145j != null || mo2464g();
    }

    public void initForMenu(Context context, C0183g gVar) {
        super.initForMenu(context, gVar);
        Resources resources = context.getResources();
        C0155a a = C0155a.m446a(context);
        if (!this.f1151p) {
            this.f1150o = a.mo1129b();
        }
        if (!this.f1157v) {
            this.f1152q = a.mo1130c();
        }
        if (!this.f1155t) {
            this.f1154s = a.mo1128a();
        }
        int i = this.f1152q;
        if (this.f1150o) {
            if (this.f1142g == null) {
                this.f1142g = new C0319d(this.f554a);
                if (this.f1149n) {
                    this.f1142g.setImageDrawable(this.f1148m);
                    this.f1148m = null;
                    this.f1149n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1142g.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f1142g.getMeasuredWidth();
        } else {
            this.f1142g = null;
        }
        this.f1153r = i;
        this.f1159x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void onCloseMenu(C0183g gVar, boolean z) {
        mo2462e();
        super.onCloseMenu(gVar, z);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (parcelable instanceof C0323g) {
            C0323g gVar = (C0323g) parcelable;
            if (gVar.f1172a > 0 && (findItem = this.f556c.findItem(gVar.f1172a)) != null) {
                onSubMenuSelected((C0207r) findItem.getSubMenu());
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        C0323g gVar = new C0323g();
        gVar.f1172a = this.f1147l;
        return gVar;
    }

    public boolean onSubMenuSelected(C0207r rVar) {
        boolean z = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        C0207r rVar2 = rVar;
        while (rVar2.getParentMenu() != this.f556c) {
            rVar2 = (C0207r) rVar2.getParentMenu();
        }
        View a = m1166a(rVar2.getItem());
        if (a == null) {
            return false;
        }
        this.f1147l = rVar.getItem().getItemId();
        int size = rVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.f1144i = new C0316a(this.f555b, rVar, a);
        this.f1144i.mo1588a(z);
        this.f1144i.mo1583a();
        super.onSubMenuSelected(rVar);
        return true;
    }

    public void updateMenuView(boolean z) {
        super.updateMenuView(z);
        ((View) this.f559f).requestLayout();
        boolean z2 = false;
        if (this.f556c != null) {
            ArrayList<C0187i> actionItems = this.f556c.getActionItems();
            int size = actionItems.size();
            for (int i = 0; i < size; i++) {
                C0634b a = actionItems.get(i).mo1240a();
                if (a != null) {
                    a.mo3793a((C0634b.C0635a) this);
                }
            }
        }
        ArrayList<C0187i> nonActionItems = this.f556c != null ? this.f556c.getNonActionItems() : null;
        if (this.f1150o && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z2 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f1142g == null) {
                this.f1142g = new C0319d(this.f554a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1142g.getParent();
            if (viewGroup != this.f559f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1142g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f559f;
                actionMenuView.addView(this.f1142g, actionMenuView.mo1752c());
            }
        } else {
            C0319d dVar = this.f1142g;
            if (dVar != null && dVar.getParent() == this.f559f) {
                ((ViewGroup) this.f559f).removeView(this.f1142g);
            }
        }
        ((ActionMenuView) this.f559f).setOverflowReserved(this.f1150o);
    }
}
