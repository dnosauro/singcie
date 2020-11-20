package androidx.viewpager2.p058a;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.C1089k;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.C1177c;
import com.google.android.material.badge.BadgeDrawable;

/* renamed from: androidx.viewpager2.a.f */
public final class C1166f extends ViewGroup {

    /* renamed from: a */
    static boolean f3660a = true;

    /* renamed from: b */
    int f3661b;

    /* renamed from: c */
    boolean f3662c;

    /* renamed from: d */
    RecyclerView f3663d;

    /* renamed from: e */
    C1164e f3664e;

    /* renamed from: f */
    C1167a f3665f;

    /* renamed from: g */
    private final Rect f3666g;

    /* renamed from: h */
    private final Rect f3667h;

    /* renamed from: i */
    private C1161b f3668i;

    /* renamed from: j */
    private RecyclerView.C1013c f3669j;

    /* renamed from: k */
    private LinearLayoutManager f3670k;

    /* renamed from: l */
    private int f3671l;

    /* renamed from: m */
    private Parcelable f3672m;

    /* renamed from: n */
    private C1089k f3673n;

    /* renamed from: o */
    private C1161b f3674o;

    /* renamed from: p */
    private C1162c f3675p;

    /* renamed from: q */
    private C1163d f3676q;

    /* renamed from: r */
    private RecyclerView.C1016f f3677r;

    /* renamed from: s */
    private boolean f3678s;

    /* renamed from: t */
    private boolean f3679t;

    /* renamed from: u */
    private int f3680u;

    /* renamed from: androidx.viewpager2.a.f$a */
    private abstract class C1167a {
        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6299a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6300a(RecyclerView.C1011a<?> aVar) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo6301a() {
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo6302a(int i, Bundle bundle) {
            return false;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public String mo6303b() {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo6304b(RecyclerView.C1011a<?> aVar) {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo6305b(int i, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public void mo6306c() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public void mo6307d() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public void mo6308e() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public void mo6309f() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public void mo6310g() {
        }
    }

    /* renamed from: androidx.viewpager2.a.f$b */
    public static abstract class C1168b {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    /* renamed from: androidx.viewpager2.a.f$c */
    public interface C1169c {
        /* renamed from: a */
        void mo6311a(View view, float f);
    }

    /* renamed from: androidx.viewpager2.a.f$d */
    static class C1170d extends View.BaseSavedState {
        public static final Parcelable.Creator<C1170d> CREATOR = new Parcelable.ClassLoaderCreator<C1170d>() {
            /* renamed from: a */
            public C1170d createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public C1170d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new C1170d(parcel, classLoader) : new C1170d(parcel);
            }

            /* renamed from: a */
            public C1170d[] newArray(int i) {
                return new C1170d[i];
            }
        };

        /* renamed from: a */
        int f3681a;

        /* renamed from: b */
        int f3682b;

        /* renamed from: c */
        Parcelable f3683c;

        C1170d(Parcel parcel) {
            super(parcel);
            m4646a(parcel, (ClassLoader) null);
        }

        C1170d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            m4646a(parcel, classLoader);
        }

        C1170d(Parcelable parcelable) {
            super(parcelable);
        }

        /* renamed from: a */
        private void m4646a(Parcel parcel, ClassLoader classLoader) {
            this.f3681a = parcel.readInt();
            this.f3682b = parcel.readInt();
            this.f3683c = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3681a);
            parcel.writeInt(this.f3682b);
            parcel.writeParcelable(this.f3683c, i);
        }
    }

    /* renamed from: androidx.viewpager2.a.f$e */
    private static class C1172e implements Runnable {

        /* renamed from: a */
        private final int f3684a;

        /* renamed from: b */
        private final RecyclerView f3685b;

        C1172e(int i, RecyclerView recyclerView) {
            this.f3684a = i;
            this.f3685b = recyclerView;
        }

        public void run() {
            this.f3685b.smoothScrollToPosition(this.f3684a);
        }
    }

    /* renamed from: a */
    private void m4622a(RecyclerView.C1011a<?> aVar) {
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.f3669j);
        }
    }

    /* renamed from: b */
    private void m4623b(RecyclerView.C1011a<?> aVar) {
        if (aVar != null) {
            aVar.unregisterAdapterDataObserver(this.f3669j);
        }
    }

    /* renamed from: e */
    private void m4624e() {
        RecyclerView.C1011a adapter;
        if (this.f3671l != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.f3672m;
            if (parcelable != null) {
                if (adapter instanceof C1177c) {
                    ((C1177c) adapter).mo6325a(parcelable);
                }
                this.f3672m = null;
            }
            this.f3661b = Math.max(0, Math.min(this.f3671l, adapter.getItemCount() - 1));
            this.f3671l = -1;
            this.f3663d.scrollToPosition(this.f3661b);
            this.f3665f.mo6306c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6266a() {
        C1089k kVar = this.f3673n;
        if (kVar != null) {
            View a = kVar.mo6030a(this.f3670k);
            if (a != null) {
                int position = this.f3670k.getPosition(a);
                if (position != this.f3661b && getScrollState() == 0) {
                    this.f3674o.onPageSelected(position);
                }
                this.f3662c = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    /* renamed from: a */
    public void mo6267a(int i, boolean z) {
        if (!mo6272c()) {
            mo6269b(i, z);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    /* renamed from: a */
    public void mo6268a(C1168b bVar) {
        this.f3668i.mo6252a(bVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6269b(int i, boolean z) {
        RecyclerView.C1011a adapter = getAdapter();
        if (adapter == null) {
            if (this.f3671l != -1) {
                this.f3671l = Math.max(i, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i, 0), adapter.getItemCount() - 1);
            if (min == this.f3661b && this.f3664e.mo6262b()) {
                return;
            }
            if (min != this.f3661b || !z) {
                double d = (double) this.f3661b;
                this.f3661b = min;
                this.f3665f.mo6308e();
                if (!this.f3664e.mo6262b()) {
                    d = this.f3664e.mo6264d();
                }
                this.f3664e.mo6261a(min, z);
                if (!z) {
                    this.f3663d.scrollToPosition(min);
                    return;
                }
                double d2 = (double) min;
                if (Math.abs(d2 - d) > 3.0d) {
                    this.f3663d.scrollToPosition(d2 > d ? min - 3 : min + 3);
                    RecyclerView recyclerView = this.f3663d;
                    recyclerView.post(new C1172e(min, recyclerView));
                    return;
                }
                this.f3663d.smoothScrollToPosition(min);
            }
        }
    }

    /* renamed from: b */
    public void mo6270b(C1168b bVar) {
        this.f3668i.mo6253b(bVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo6271b() {
        return this.f3670k.getLayoutDirection() == 1;
    }

    /* renamed from: c */
    public boolean mo6272c() {
        return this.f3675p.mo6257a();
    }

    public boolean canScrollHorizontally(int i) {
        return this.f3663d.canScrollHorizontally(i);
    }

    public boolean canScrollVertically(int i) {
        return this.f3663d.canScrollVertically(i);
    }

    /* renamed from: d */
    public void mo6275d() {
        if (this.f3676q.mo6258a() != null) {
            double d = this.f3664e.mo6264d();
            int i = (int) d;
            float f = (float) (d - ((double) i));
            this.f3676q.onPageScrolled(i, f, Math.round(((float) getPageSize()) * f));
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof C1170d) {
            int i = ((C1170d) parcelable).f3681a;
            sparseArray.put(this.f3663d.getId(), sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        m4624e();
    }

    public CharSequence getAccessibilityClassName() {
        return this.f3665f.mo6301a() ? this.f3665f.mo6303b() : super.getAccessibilityClassName();
    }

    public RecyclerView.C1011a getAdapter() {
        return this.f3663d.getAdapter();
    }

    public int getCurrentItem() {
        return this.f3661b;
    }

    public int getItemDecorationCount() {
        return this.f3663d.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.f3680u;
    }

    public int getOrientation() {
        return this.f3670k.getOrientation();
    }

    /* access modifiers changed from: package-private */
    public int getPageSize() {
        int i;
        int i2;
        RecyclerView recyclerView = this.f3663d;
        if (getOrientation() == 0) {
            i = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            i2 = recyclerView.getPaddingRight();
        } else {
            i = recyclerView.getHeight() - recyclerView.getPaddingTop();
            i2 = recyclerView.getPaddingBottom();
        }
        return i - i2;
    }

    public int getScrollState() {
        return this.f3664e.mo6260a();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f3665f.mo6299a(accessibilityNodeInfo);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.f3663d.getMeasuredWidth();
        int measuredHeight = this.f3663d.getMeasuredHeight();
        this.f3666g.left = getPaddingLeft();
        this.f3666g.right = (i3 - i) - getPaddingRight();
        this.f3666g.top = getPaddingTop();
        this.f3666g.bottom = (i4 - i2) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.f3666g, this.f3667h);
        this.f3663d.layout(this.f3667h.left, this.f3667h.top, this.f3667h.right, this.f3667h.bottom);
        if (this.f3662c) {
            mo6266a();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        measureChild(this.f3663d, i, i2);
        int measuredWidth = this.f3663d.getMeasuredWidth();
        int measuredHeight = this.f3663d.getMeasuredHeight();
        int measuredState = this.f3663d.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, measuredState), resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C1170d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C1170d dVar = (C1170d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        this.f3671l = dVar.f3682b;
        this.f3672m = dVar.f3683c;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        C1170d dVar = new C1170d(super.onSaveInstanceState());
        dVar.f3681a = this.f3663d.getId();
        int i = this.f3671l;
        if (i == -1) {
            i = this.f3661b;
        }
        dVar.f3682b = i;
        Parcelable parcelable = this.f3672m;
        if (parcelable == null) {
            RecyclerView.C1011a adapter = this.f3663d.getAdapter();
            if (adapter instanceof C1177c) {
                parcelable = ((C1177c) adapter).mo6326b();
            }
            return dVar;
        }
        dVar.f3683c = parcelable;
        return dVar;
    }

    public void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    public boolean performAccessibilityAction(int i, Bundle bundle) {
        return this.f3665f.mo6302a(i, bundle) ? this.f3665f.mo6305b(i, bundle) : super.performAccessibilityAction(i, bundle);
    }

    public void setAdapter(RecyclerView.C1011a aVar) {
        RecyclerView.C1011a adapter = this.f3663d.getAdapter();
        this.f3665f.mo6304b(adapter);
        m4623b((RecyclerView.C1011a<?>) adapter);
        this.f3663d.setAdapter(aVar);
        this.f3661b = 0;
        m4624e();
        this.f3665f.mo6300a((RecyclerView.C1011a<?>) aVar);
        m4622a((RecyclerView.C1011a<?>) aVar);
    }

    public void setCurrentItem(int i) {
        mo6267a(i, true);
    }

    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.f3665f.mo6310g();
    }

    public void setOffscreenPageLimit(int i) {
        if (i >= 1 || i == -1) {
            this.f3680u = i;
            this.f3663d.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i) {
        this.f3670k.setOrientation(i);
        this.f3665f.mo6307d();
    }

    public void setPageTransformer(C1169c cVar) {
        if (cVar != null) {
            if (!this.f3678s) {
                this.f3677r = this.f3663d.getItemAnimator();
                this.f3678s = true;
            }
            this.f3663d.setItemAnimator((RecyclerView.C1016f) null);
        } else if (this.f3678s) {
            this.f3663d.setItemAnimator(this.f3677r);
            this.f3677r = null;
            this.f3678s = false;
        }
        if (cVar != this.f3676q.mo6258a()) {
            this.f3676q.mo6259a(cVar);
            mo6275d();
        }
    }

    public void setUserInputEnabled(boolean z) {
        this.f3679t = z;
        this.f3665f.mo6309f();
    }
}
