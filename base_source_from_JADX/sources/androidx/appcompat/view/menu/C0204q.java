package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.C0198m;
import androidx.appcompat.widget.C0277am;
import androidx.core.p030h.C0656u;

/* renamed from: androidx.appcompat.view.menu.q */
final class C0204q extends C0195k implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, C0198m {

    /* renamed from: e */
    private static final int f684e = C0059a.C0066g.abc_popup_menu_item_layout;

    /* renamed from: a */
    final C0277am f685a;

    /* renamed from: b */
    final ViewTreeObserver.OnGlobalLayoutListener f686b = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (C0204q.this.mo1329c() && !C0204q.this.f685a.mo2218i()) {
                View view = C0204q.this.f687c;
                if (view == null || !view.isShown()) {
                    C0204q.this.mo1325b();
                } else {
                    C0204q.this.f685a.mo1331j_();
                }
            }
        }
    };

    /* renamed from: c */
    View f687c;

    /* renamed from: d */
    ViewTreeObserver f688d;

    /* renamed from: f */
    private final Context f689f;

    /* renamed from: g */
    private final C0183g f690g;

    /* renamed from: h */
    private final C0182f f691h;

    /* renamed from: i */
    private final boolean f692i;

    /* renamed from: j */
    private final int f693j;

    /* renamed from: k */
    private final int f694k;

    /* renamed from: l */
    private final int f695l;

    /* renamed from: m */
    private final View.OnAttachStateChangeListener f696m = new View.OnAttachStateChangeListener() {
        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            if (C0204q.this.f688d != null) {
                if (!C0204q.this.f688d.isAlive()) {
                    C0204q.this.f688d = view.getViewTreeObserver();
                }
                C0204q.this.f688d.removeGlobalOnLayoutListener(C0204q.this.f686b);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: n */
    private PopupWindow.OnDismissListener f697n;

    /* renamed from: o */
    private View f698o;

    /* renamed from: p */
    private C0198m.C0199a f699p;

    /* renamed from: q */
    private boolean f700q;

    /* renamed from: r */
    private boolean f701r;

    /* renamed from: s */
    private int f702s;

    /* renamed from: t */
    private int f703t = 0;

    /* renamed from: u */
    private boolean f704u;

    public C0204q(Context context, C0183g gVar, View view, int i, int i2, boolean z) {
        this.f689f = context;
        this.f690g = gVar;
        this.f692i = z;
        this.f691h = new C0182f(gVar, LayoutInflater.from(context), this.f692i, f684e);
        this.f694k = i;
        this.f695l = i2;
        Resources resources = context.getResources();
        this.f693j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0059a.C0063d.abc_config_prefDialogWidth));
        this.f698o = view;
        this.f685a = new C0277am(this.f689f, (AttributeSet) null, this.f694k, this.f695l);
        gVar.addMenuPresenter(this, context);
    }

    /* renamed from: g */
    private boolean m677g() {
        View view;
        if (mo1329c()) {
            return true;
        }
        if (this.f700q || (view = this.f698o) == null) {
            return false;
        }
        this.f687c = view;
        this.f685a.mo2204a((PopupWindow.OnDismissListener) this);
        this.f685a.mo2202a((AdapterView.OnItemClickListener) this);
        this.f685a.mo2205a(true);
        View view2 = this.f687c;
        boolean z = this.f688d == null;
        this.f688d = view2.getViewTreeObserver();
        if (z) {
            this.f688d.addOnGlobalLayoutListener(this.f686b);
        }
        view2.addOnAttachStateChangeListener(this.f696m);
        this.f685a.mo2207b(view2);
        this.f685a.mo2214f(this.f703t);
        if (!this.f701r) {
            this.f702s = m643a(this.f691h, (ViewGroup) null, this.f689f, this.f693j);
            this.f701r = true;
        }
        this.f685a.mo2216h(this.f702s);
        this.f685a.mo2217i(2);
        this.f685a.mo2200a(mo1581f());
        this.f685a.mo1331j_();
        ListView k_ = this.f685a.mo1332k_();
        k_.setOnKeyListener(this);
        if (this.f704u && this.f690g.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f689f).inflate(C0059a.C0066g.abc_popup_menu_header_item_layout, k_, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f690g.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            k_.addHeaderView(frameLayout, (Object) null, false);
        }
        this.f685a.mo2203a((ListAdapter) this.f691h);
        this.f685a.mo1331j_();
        return true;
    }

    /* renamed from: a */
    public void mo1320a(int i) {
        this.f703t = i;
    }

    /* renamed from: a */
    public void mo1321a(View view) {
        this.f698o = view;
    }

    /* renamed from: a */
    public void mo1322a(PopupWindow.OnDismissListener onDismissListener) {
        this.f697n = onDismissListener;
    }

    /* renamed from: a */
    public void mo1323a(C0183g gVar) {
    }

    /* renamed from: a */
    public void mo1324a(boolean z) {
        this.f691h.mo1358a(z);
    }

    /* renamed from: b */
    public void mo1325b() {
        if (mo1329c()) {
            this.f685a.mo1325b();
        }
    }

    /* renamed from: b */
    public void mo1326b(int i) {
        this.f685a.mo2206b(i);
    }

    /* renamed from: b */
    public void mo1327b(boolean z) {
        this.f704u = z;
    }

    /* renamed from: c */
    public void mo1328c(int i) {
        this.f685a.mo2199a(i);
    }

    /* renamed from: c */
    public boolean mo1329c() {
        return !this.f700q && this.f685a.mo1329c();
    }

    public boolean flagActionItems() {
        return false;
    }

    /* renamed from: j_ */
    public void mo1331j_() {
        if (!m677g()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    /* renamed from: k_ */
    public ListView mo1332k_() {
        return this.f685a.mo1332k_();
    }

    public void onCloseMenu(C0183g gVar, boolean z) {
        if (gVar == this.f690g) {
            mo1325b();
            C0198m.C0199a aVar = this.f699p;
            if (aVar != null) {
                aVar.mo914a(gVar, z);
            }
        }
    }

    public void onDismiss() {
        this.f700q = true;
        this.f690g.close();
        ViewTreeObserver viewTreeObserver = this.f688d;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f688d = this.f687c.getViewTreeObserver();
            }
            this.f688d.removeGlobalOnLayoutListener(this.f686b);
            this.f688d = null;
        }
        this.f687c.removeOnAttachStateChangeListener(this.f696m);
        PopupWindow.OnDismissListener onDismissListener = this.f697n;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        if (rVar.hasVisibleItems()) {
            C0196l lVar = new C0196l(this.f689f, rVar, this.f687c, this.f692i, this.f694k, this.f695l);
            lVar.mo1587a(this.f699p);
            lVar.mo1588a(C0195k.m645b((C0183g) rVar));
            lVar.mo1586a(this.f697n);
            this.f697n = null;
            this.f690g.close(false);
            int f = this.f685a.mo2213f();
            int e = this.f685a.mo2211e();
            if ((Gravity.getAbsoluteGravity(this.f703t, C0656u.m2621g(this.f698o)) & 7) == 5) {
                f += this.f698o.getWidth();
            }
            if (lVar.mo1589a(f, e)) {
                C0198m.C0199a aVar = this.f699p;
                if (aVar == null) {
                    return true;
                }
                aVar.mo915a(rVar);
                return true;
            }
        }
        return false;
    }

    public void setCallback(C0198m.C0199a aVar) {
        this.f699p = aVar;
    }

    public void updateMenuView(boolean z) {
        this.f701r = false;
        C0182f fVar = this.f691h;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }
}
