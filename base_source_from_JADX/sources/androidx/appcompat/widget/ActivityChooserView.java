package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.core.p030h.C0634b;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public class ActivityChooserView extends ViewGroup {

    /* renamed from: a */
    final C0220a f781a;

    /* renamed from: b */
    final FrameLayout f782b;

    /* renamed from: c */
    final FrameLayout f783c;

    /* renamed from: d */
    C0634b f784d;

    /* renamed from: e */
    final DataSetObserver f785e;

    /* renamed from: f */
    PopupWindow.OnDismissListener f786f;

    /* renamed from: g */
    boolean f787g;

    /* renamed from: h */
    int f788h;

    /* renamed from: i */
    private final C0221b f789i;

    /* renamed from: j */
    private final View f790j;

    /* renamed from: k */
    private final ImageView f791k;

    /* renamed from: l */
    private final int f792l;

    /* renamed from: m */
    private final ViewTreeObserver.OnGlobalLayoutListener f793m;

    /* renamed from: n */
    private C0268ak f794n;

    /* renamed from: o */
    private boolean f795o;

    /* renamed from: p */
    private int f796p;

    public static class InnerLayout extends LinearLayout {

        /* renamed from: a */
        private static final int[] f797a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            C0302ay a = C0302ay.m1077a(context, attributeSet, f797a);
            setBackgroundDrawable(a.mo2409a(0));
            a.mo2410a();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$a */
    private class C0220a extends BaseAdapter {

        /* renamed from: a */
        final /* synthetic */ ActivityChooserView f798a;

        /* renamed from: b */
        private C0325d f799b;

        /* renamed from: c */
        private int f800c;

        /* renamed from: d */
        private boolean f801d;

        /* renamed from: e */
        private boolean f802e;

        /* renamed from: f */
        private boolean f803f;

        /* renamed from: a */
        public int mo1796a() {
            int i = this.f800c;
            this.f800c = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                view = getView(i3, view, (ViewGroup) null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i2 = Math.max(i2, view.getMeasuredWidth());
            }
            this.f800c = i;
            return i2;
        }

        /* renamed from: a */
        public void mo1797a(int i) {
            if (this.f800c != i) {
                this.f800c = i;
                notifyDataSetChanged();
            }
        }

        /* renamed from: a */
        public void mo1798a(C0325d dVar) {
            C0325d d = this.f798a.f781a.mo1803d();
            if (d != null && this.f798a.isShown()) {
                d.unregisterObserver(this.f798a.f785e);
            }
            this.f799b = dVar;
            if (dVar != null && this.f798a.isShown()) {
                dVar.registerObserver(this.f798a.f785e);
            }
            notifyDataSetChanged();
        }

        /* renamed from: a */
        public void mo1799a(boolean z) {
            if (this.f803f != z) {
                this.f803f = z;
                notifyDataSetChanged();
            }
        }

        /* renamed from: a */
        public void mo1800a(boolean z, boolean z2) {
            if (this.f801d != z || this.f802e != z2) {
                this.f801d = z;
                this.f802e = z2;
                notifyDataSetChanged();
            }
        }

        /* renamed from: b */
        public ResolveInfo mo1801b() {
            return this.f799b.mo2479b();
        }

        /* renamed from: c */
        public int mo1802c() {
            return this.f799b.mo2475a();
        }

        /* renamed from: d */
        public C0325d mo1803d() {
            return this.f799b;
        }

        /* renamed from: e */
        public boolean mo1804e() {
            return this.f801d;
        }

        public int getCount() {
            int a = this.f799b.mo2475a();
            if (!this.f801d && this.f799b.mo2479b() != null) {
                a--;
            }
            int min = Math.min(a, this.f800c);
            return this.f803f ? min + 1 : min;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.f801d && this.f799b.mo2479b() != null) {
                        i++;
                    }
                    return this.f799b.mo2477a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return (!this.f803f || i != getCount() - 1) ? 0 : 1;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != C0059a.C0065f.list_item) {
                        view = LayoutInflater.from(this.f798a.getContext()).inflate(C0059a.C0066g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f798a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(C0059a.C0065f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(C0059a.C0065f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (!this.f801d || i != 0 || !this.f802e) {
                        view.setActivated(false);
                    } else {
                        view.setActivated(true);
                    }
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View inflate = LayoutInflater.from(this.f798a.getContext()).inflate(C0059a.C0066g.abc_activity_chooser_view_list_item, viewGroup, false);
                    inflate.setId(1);
                    ((TextView) inflate.findViewById(C0059a.C0065f.title)).setText(this.f798a.getContext().getString(C0059a.C0067h.abc_activity_chooser_view_see_all));
                    return inflate;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$b */
    private class C0221b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

        /* renamed from: a */
        final /* synthetic */ ActivityChooserView f804a;

        /* renamed from: a */
        private void m761a() {
            if (this.f804a.f786f != null) {
                this.f804a.f786f.onDismiss();
            }
        }

        public void onClick(View view) {
            if (view == this.f804a.f783c) {
                this.f804a.mo1781b();
                Intent b = this.f804a.f781a.mo1803d().mo2478b(this.f804a.f781a.mo1803d().mo2476a(this.f804a.f781a.mo1801b()));
                if (b != null) {
                    b.addFlags(PKIFailureInfo.signerNotTrusted);
                    this.f804a.getContext().startActivity(b);
                }
            } else if (view == this.f804a.f782b) {
                ActivityChooserView activityChooserView = this.f804a;
                activityChooserView.f787g = false;
                activityChooserView.mo1779a(activityChooserView.f788h);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            m761a();
            if (this.f804a.f784d != null) {
                this.f804a.f784d.mo3794a(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0220a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.f804a.mo1781b();
                    if (!this.f804a.f787g) {
                        if (!this.f804a.f781a.mo1804e()) {
                            i++;
                        }
                        Intent b = this.f804a.f781a.mo1803d().mo2478b(i);
                        if (b != null) {
                            b.addFlags(PKIFailureInfo.signerNotTrusted);
                            this.f804a.getContext().startActivity(b);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        this.f804a.f781a.mo1803d().mo2480c(i);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.f804a.mo1779a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f804a.f783c) {
                if (this.f804a.f781a.getCount() > 0) {
                    ActivityChooserView activityChooserView = this.f804a;
                    activityChooserView.f787g = true;
                    activityChooserView.mo1779a(activityChooserView.f788h);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1779a(int i) {
        C0220a aVar;
        if (this.f781a.mo1803d() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.f793m);
            boolean z = this.f783c.getVisibility() == 0;
            int c = this.f781a.mo1802c();
            if (i == Integer.MAX_VALUE || c <= i + (z ? 1 : 0)) {
                this.f781a.mo1799a(false);
                aVar = this.f781a;
            } else {
                this.f781a.mo1799a(true);
                aVar = this.f781a;
                i--;
            }
            aVar.mo1797a(i);
            C0268ak listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.mo1329c()) {
                if (this.f787g || !z) {
                    this.f781a.mo1800a(true, z);
                } else {
                    this.f781a.mo1800a(false, false);
                }
                listPopupWindow.mo2216h(Math.min(this.f781a.mo1796a(), this.f792l));
                listPopupWindow.mo1331j_();
                C0634b bVar = this.f784d;
                if (bVar != null) {
                    bVar.mo3794a(true);
                }
                listPopupWindow.mo1332k_().setContentDescription(getContext().getString(C0059a.C0067h.abc_activitychooserview_choose_application));
                listPopupWindow.mo1332k_().setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    /* renamed from: a */
    public boolean mo1780a() {
        if (mo1782c() || !this.f795o) {
            return false;
        }
        this.f787g = false;
        mo1779a(this.f788h);
        return true;
    }

    /* renamed from: b */
    public boolean mo1781b() {
        if (!mo1782c()) {
            return true;
        }
        getListPopupWindow().mo1325b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f793m);
        return true;
    }

    /* renamed from: c */
    public boolean mo1782c() {
        return getListPopupWindow().mo1329c();
    }

    public C0325d getDataModel() {
        return this.f781a.mo1803d();
    }

    /* access modifiers changed from: package-private */
    public C0268ak getListPopupWindow() {
        if (this.f794n == null) {
            this.f794n = new C0268ak(getContext());
            this.f794n.mo2203a((ListAdapter) this.f781a);
            this.f794n.mo2207b((View) this);
            this.f794n.mo2205a(true);
            this.f794n.mo2202a((AdapterView.OnItemClickListener) this.f789i);
            this.f794n.mo2204a((PopupWindow.OnDismissListener) this.f789i);
        }
        return this.f794n;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0325d d = this.f781a.mo1803d();
        if (d != null) {
            d.registerObserver(this.f785e);
        }
        this.f795o = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0325d d = this.f781a.mo1803d();
        if (d != null) {
            d.unregisterObserver(this.f785e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f793m);
        }
        if (mo1782c()) {
            mo1781b();
        }
        this.f795o = false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f790j.layout(0, 0, i3 - i, i4 - i2);
        if (!mo1782c()) {
            mo1781b();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        View view = this.f790j;
        if (this.f783c.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0325d dVar) {
        this.f781a.mo1798a(dVar);
        if (mo1782c()) {
            mo1781b();
            mo1780a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f796p = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f791k.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f791k.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f788h = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f786f = onDismissListener;
    }

    public void setProvider(C0634b bVar) {
        this.f784d = bVar;
    }
}
