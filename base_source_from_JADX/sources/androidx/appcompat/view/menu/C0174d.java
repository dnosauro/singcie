package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.C0198m;
import androidx.appcompat.widget.C0276al;
import androidx.appcompat.widget.C0277am;
import androidx.core.p030h.C0637c;
import androidx.core.p030h.C0656u;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.appcompat.view.menu.d */
final class C0174d extends C0195k implements View.OnKeyListener, PopupWindow.OnDismissListener, C0198m {

    /* renamed from: g */
    private static final int f567g = C0059a.C0066g.abc_cascading_menu_item_layout;

    /* renamed from: A */
    private PopupWindow.OnDismissListener f568A;

    /* renamed from: a */
    final Handler f569a;

    /* renamed from: b */
    final List<C0179a> f570b = new ArrayList();

    /* renamed from: c */
    final ViewTreeObserver.OnGlobalLayoutListener f571c = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (C0174d.this.mo1329c() && C0174d.this.f570b.size() > 0 && !C0174d.this.f570b.get(0).f601a.mo2218i()) {
                View view = C0174d.this.f572d;
                if (view == null || !view.isShown()) {
                    C0174d.this.mo1325b();
                    return;
                }
                for (C0179a aVar : C0174d.this.f570b) {
                    aVar.f601a.mo1331j_();
                }
            }
        }
    };

    /* renamed from: d */
    View f572d;

    /* renamed from: e */
    ViewTreeObserver f573e;

    /* renamed from: f */
    boolean f574f;

    /* renamed from: h */
    private final Context f575h;

    /* renamed from: i */
    private final int f576i;

    /* renamed from: j */
    private final int f577j;

    /* renamed from: k */
    private final int f578k;

    /* renamed from: l */
    private final boolean f579l;

    /* renamed from: m */
    private final List<C0183g> f580m = new ArrayList();

    /* renamed from: n */
    private final View.OnAttachStateChangeListener f581n = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (C0174d.this.f573e != null) {
                if (!C0174d.this.f573e.isAlive()) {
                    C0174d.this.f573e = view.getViewTreeObserver();
                }
                C0174d.this.f573e.removeGlobalOnLayoutListener(C0174d.this.f571c);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: o */
    private final C0276al f582o = new C0276al() {
        /* renamed from: a */
        public void mo1340a(C0183g gVar, MenuItem menuItem) {
            C0174d.this.f569a.removeCallbacksAndMessages(gVar);
        }

        /* renamed from: b */
        public void mo1341b(final C0183g gVar, final MenuItem menuItem) {
            final C0179a aVar = null;
            C0174d.this.f569a.removeCallbacksAndMessages((Object) null);
            int size = C0174d.this.f570b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar == C0174d.this.f570b.get(i).f602b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < C0174d.this.f570b.size()) {
                    aVar = C0174d.this.f570b.get(i2);
                }
                C0174d.this.f569a.postAtTime(new Runnable() {
                    public void run() {
                        if (aVar != null) {
                            C0174d.this.f574f = true;
                            aVar.f602b.close(false);
                            C0174d.this.f574f = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            gVar.performItemAction(menuItem, 4);
                        }
                    }
                }, gVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };

    /* renamed from: p */
    private int f583p = 0;

    /* renamed from: q */
    private int f584q = 0;

    /* renamed from: r */
    private View f585r;

    /* renamed from: s */
    private int f586s;

    /* renamed from: t */
    private boolean f587t;

    /* renamed from: u */
    private boolean f588u;

    /* renamed from: v */
    private int f589v;

    /* renamed from: w */
    private int f590w;

    /* renamed from: x */
    private boolean f591x;

    /* renamed from: y */
    private boolean f592y;

    /* renamed from: z */
    private C0198m.C0199a f593z;

    /* renamed from: androidx.appcompat.view.menu.d$a */
    private static class C0179a {

        /* renamed from: a */
        public final C0277am f601a;

        /* renamed from: b */
        public final C0183g f602b;

        /* renamed from: c */
        public final int f603c;

        public C0179a(C0277am amVar, C0183g gVar, int i) {
            this.f601a = amVar;
            this.f602b = gVar;
            this.f603c = i;
        }

        /* renamed from: a */
        public ListView mo1343a() {
            return this.f601a.mo1332k_();
        }
    }

    public C0174d(Context context, View view, int i, int i2, boolean z) {
        this.f575h = context;
        this.f585r = view;
        this.f577j = i;
        this.f578k = i2;
        this.f579l = z;
        this.f591x = false;
        this.f586s = m568h();
        Resources resources = context.getResources();
        this.f576i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0059a.C0063d.abc_config_prefDialogWidth));
        this.f569a = new Handler();
    }

    /* renamed from: a */
    private MenuItem m562a(C0183g gVar, C0183g gVar2) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* renamed from: a */
    private View m563a(C0179a aVar, C0183g gVar) {
        int i;
        C0182f fVar;
        int firstVisiblePosition;
        MenuItem a = m562a(aVar.f602b, gVar);
        if (a == null) {
            return null;
        }
        ListView a2 = aVar.mo1343a();
        ListAdapter adapter = a2.getAdapter();
        int i2 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i = headerViewListAdapter.getHeadersCount();
            fVar = (C0182f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (C0182f) adapter;
            i = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i2 >= count) {
                i2 = -1;
                break;
            } else if (a == fVar.getItem(i2)) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1 && (firstVisiblePosition = (i2 + i) - a2.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a2.getChildCount()) {
            return a2.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    /* renamed from: c */
    private void m564c(C0183g gVar) {
        View view;
        C0179a aVar;
        int i;
        int i2;
        int i3;
        LayoutInflater from = LayoutInflater.from(this.f575h);
        C0182f fVar = new C0182f(gVar, from, this.f579l, f567g);
        if (!mo1329c() && this.f591x) {
            fVar.mo1358a(true);
        } else if (mo1329c()) {
            fVar.mo1358a(C0195k.m645b(gVar));
        }
        int a = m643a(fVar, (ViewGroup) null, this.f575h, this.f576i);
        C0277am g = m567g();
        g.mo2203a((ListAdapter) fVar);
        g.mo2216h(a);
        g.mo2214f(this.f584q);
        if (this.f570b.size() > 0) {
            List<C0179a> list = this.f570b;
            aVar = list.get(list.size() - 1);
            view = m563a(aVar, gVar);
        } else {
            aVar = null;
            view = null;
        }
        if (view != null) {
            g.mo2237c(false);
            g.mo2235a((Object) null);
            int d = m565d(a);
            boolean z = d == 1;
            this.f586s = d;
            if (Build.VERSION.SDK_INT >= 26) {
                g.mo2207b(view);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.f585r.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f584q & 7) == 5) {
                    iArr[0] = iArr[0] + this.f585r.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.f584q & 5) != 5) {
                if (z) {
                    a = view.getWidth();
                }
                i3 = i - a;
                g.mo2206b(i3);
                g.mo2208b(true);
                g.mo2199a(i2);
            } else if (!z) {
                a = view.getWidth();
                i3 = i - a;
                g.mo2206b(i3);
                g.mo2208b(true);
                g.mo2199a(i2);
            }
            i3 = i + a;
            g.mo2206b(i3);
            g.mo2208b(true);
            g.mo2199a(i2);
        } else {
            if (this.f587t) {
                g.mo2206b(this.f589v);
            }
            if (this.f588u) {
                g.mo2199a(this.f590w);
            }
            g.mo2200a(mo1581f());
        }
        this.f570b.add(new C0179a(g, gVar, this.f586s));
        g.mo1331j_();
        ListView k_ = g.mo1332k_();
        k_.setOnKeyListener(this);
        if (aVar == null && this.f592y && gVar.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(C0059a.C0066g.abc_popup_menu_header_item_layout, k_, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(gVar.getHeaderTitle());
            k_.addHeaderView(frameLayout, (Object) null, false);
            g.mo1331j_();
        }
    }

    /* renamed from: d */
    private int m565d(int i) {
        List<C0179a> list = this.f570b;
        ListView a = list.get(list.size() - 1).mo1343a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f572d.getWindowVisibleDisplayFrame(rect);
        return this.f586s == 1 ? (iArr[0] + a.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    /* renamed from: d */
    private int m566d(C0183g gVar) {
        int size = this.f570b.size();
        for (int i = 0; i < size; i++) {
            if (gVar == this.f570b.get(i).f602b) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: g */
    private C0277am m567g() {
        C0277am amVar = new C0277am(this.f575h, (AttributeSet) null, this.f577j, this.f578k);
        amVar.mo2234a(this.f582o);
        amVar.mo2202a((AdapterView.OnItemClickListener) this);
        amVar.mo2204a((PopupWindow.OnDismissListener) this);
        amVar.mo2207b(this.f585r);
        amVar.mo2214f(this.f584q);
        amVar.mo2205a(true);
        amVar.mo2217i(2);
        return amVar;
    }

    /* renamed from: h */
    private int m568h() {
        return C0656u.m2621g(this.f585r) == 1 ? 0 : 1;
    }

    /* renamed from: a */
    public void mo1320a(int i) {
        if (this.f583p != i) {
            this.f583p = i;
            this.f584q = C0637c.m2519a(i, C0656u.m2621g(this.f585r));
        }
    }

    /* renamed from: a */
    public void mo1321a(View view) {
        if (this.f585r != view) {
            this.f585r = view;
            this.f584q = C0637c.m2519a(this.f583p, C0656u.m2621g(this.f585r));
        }
    }

    /* renamed from: a */
    public void mo1322a(PopupWindow.OnDismissListener onDismissListener) {
        this.f568A = onDismissListener;
    }

    /* renamed from: a */
    public void mo1323a(C0183g gVar) {
        gVar.addMenuPresenter(this, this.f575h);
        if (mo1329c()) {
            m564c(gVar);
        } else {
            this.f580m.add(gVar);
        }
    }

    /* renamed from: a */
    public void mo1324a(boolean z) {
        this.f591x = z;
    }

    /* renamed from: b */
    public void mo1325b() {
        int size = this.f570b.size();
        if (size > 0) {
            C0179a[] aVarArr = (C0179a[]) this.f570b.toArray(new C0179a[size]);
            for (int i = size - 1; i >= 0; i--) {
                C0179a aVar = aVarArr[i];
                if (aVar.f601a.mo1329c()) {
                    aVar.f601a.mo1325b();
                }
            }
        }
    }

    /* renamed from: b */
    public void mo1326b(int i) {
        this.f587t = true;
        this.f589v = i;
    }

    /* renamed from: b */
    public void mo1327b(boolean z) {
        this.f592y = z;
    }

    /* renamed from: c */
    public void mo1328c(int i) {
        this.f588u = true;
        this.f590w = i;
    }

    /* renamed from: c */
    public boolean mo1329c() {
        return this.f570b.size() > 0 && this.f570b.get(0).f601a.mo1329c();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo1330e() {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    /* renamed from: j_ */
    public void mo1331j_() {
        if (!mo1329c()) {
            for (C0183g c : this.f580m) {
                m564c(c);
            }
            this.f580m.clear();
            this.f572d = this.f585r;
            if (this.f572d != null) {
                boolean z = this.f573e == null;
                this.f573e = this.f572d.getViewTreeObserver();
                if (z) {
                    this.f573e.addOnGlobalLayoutListener(this.f571c);
                }
                this.f572d.addOnAttachStateChangeListener(this.f581n);
            }
        }
    }

    /* renamed from: k_ */
    public ListView mo1332k_() {
        if (this.f570b.isEmpty()) {
            return null;
        }
        List<C0179a> list = this.f570b;
        return list.get(list.size() - 1).mo1343a();
    }

    public void onCloseMenu(C0183g gVar, boolean z) {
        int d = m566d(gVar);
        if (d >= 0) {
            int i = d + 1;
            if (i < this.f570b.size()) {
                this.f570b.get(i).f602b.close(false);
            }
            C0179a remove = this.f570b.remove(d);
            remove.f602b.removeMenuPresenter(this);
            if (this.f574f) {
                remove.f601a.mo2236b((Object) null);
                remove.f601a.mo2212e(0);
            }
            remove.f601a.mo1325b();
            int size = this.f570b.size();
            this.f586s = size > 0 ? this.f570b.get(size - 1).f603c : m568h();
            if (size == 0) {
                mo1325b();
                C0198m.C0199a aVar = this.f593z;
                if (aVar != null) {
                    aVar.mo914a(gVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.f573e;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f573e.removeGlobalOnLayoutListener(this.f571c);
                    }
                    this.f573e = null;
                }
                this.f572d.removeOnAttachStateChangeListener(this.f581n);
                this.f568A.onDismiss();
            } else if (z) {
                this.f570b.get(0).f602b.close(false);
            }
        }
    }

    public void onDismiss() {
        C0179a aVar;
        int size = this.f570b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f570b.get(i);
            if (!aVar.f601a.mo1329c()) {
                break;
            }
            i++;
        }
        if (aVar != null) {
            aVar.f602b.close(false);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo1325b();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(C0207r rVar) {
        for (C0179a next : this.f570b) {
            if (rVar == next.f602b) {
                next.mo1343a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        mo1323a((C0183g) rVar);
        C0198m.C0199a aVar = this.f593z;
        if (aVar != null) {
            aVar.mo915a(rVar);
        }
        return true;
    }

    public void setCallback(C0198m.C0199a aVar) {
        this.f593z = aVar;
    }

    public void updateMenuView(boolean z) {
        for (C0179a a : this.f570b) {
            m644a(a.mo1343a().getAdapter()).notifyDataSetChanged();
        }
    }
}
