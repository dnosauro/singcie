package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.core.p026d.C0547b;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* renamed from: androidx.recyclerview.widget.e */
final class C1077e implements Runnable {

    /* renamed from: a */
    static final ThreadLocal<C1077e> f3417a = new ThreadLocal<>();

    /* renamed from: e */
    static Comparator<C1080b> f3418e = new Comparator<C1080b>() {
        /* renamed from: a */
        public int compare(C1080b bVar, C1080b bVar2) {
            if ((bVar.f3430d == null) != (bVar2.f3430d == null)) {
                return bVar.f3430d == null ? 1 : -1;
            }
            if (bVar.f3427a != bVar2.f3427a) {
                return bVar.f3427a ? -1 : 1;
            }
            int i = bVar2.f3428b - bVar.f3428b;
            if (i != 0) {
                return i;
            }
            int i2 = bVar.f3429c - bVar2.f3429c;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };

    /* renamed from: b */
    ArrayList<RecyclerView> f3419b = new ArrayList<>();

    /* renamed from: c */
    long f3420c;

    /* renamed from: d */
    long f3421d;

    /* renamed from: f */
    private ArrayList<C1080b> f3422f = new ArrayList<>();

    @SuppressLint({"VisibleForTests"})
    /* renamed from: androidx.recyclerview.widget.e$a */
    static class C1079a implements RecyclerView.C1022i.C1025a {

        /* renamed from: a */
        int f3423a;

        /* renamed from: b */
        int f3424b;

        /* renamed from: c */
        int[] f3425c;

        /* renamed from: d */
        int f3426d;

        C1079a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6012a() {
            int[] iArr = this.f3425c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3426d = 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6013a(int i, int i2) {
            this.f3423a = i;
            this.f3424b = i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6014a(RecyclerView recyclerView, boolean z) {
            this.f3426d = 0;
            int[] iArr = this.f3425c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.C1022i iVar = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && iVar != null && iVar.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.mo5935d()) {
                        iVar.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    iVar.collectAdjacentPrefetchPositions(this.f3423a, this.f3424b, recyclerView.mState, this);
                }
                if (this.f3426d > iVar.mPrefetchMaxCountObserved) {
                    iVar.mPrefetchMaxCountObserved = this.f3426d;
                    iVar.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.mo5738b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public boolean mo6015a(int i) {
            if (this.f3425c != null) {
                int i2 = this.f3426d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f3425c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: b */
        public void mo5699b(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.f3426d * 2;
                int[] iArr = this.f3425c;
                if (iArr == null) {
                    this.f3425c = new int[4];
                    Arrays.fill(this.f3425c, -1);
                } else if (i3 >= iArr.length) {
                    this.f3425c = new int[(i3 * 2)];
                    System.arraycopy(iArr, 0, this.f3425c, 0, iArr.length);
                }
                int[] iArr2 = this.f3425c;
                iArr2[i3] = i;
                iArr2[i3 + 1] = i2;
                this.f3426d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.e$b */
    static class C1080b {

        /* renamed from: a */
        public boolean f3427a;

        /* renamed from: b */
        public int f3428b;

        /* renamed from: c */
        public int f3429c;

        /* renamed from: d */
        public RecyclerView f3430d;

        /* renamed from: e */
        public int f3431e;

        C1080b() {
        }

        /* renamed from: a */
        public void mo6016a() {
            this.f3427a = false;
            this.f3428b = 0;
            this.f3429c = 0;
            this.f3430d = null;
            this.f3431e = 0;
        }
    }

    C1077e() {
    }

    /* renamed from: a */
    private RecyclerView.C1045x m4227a(RecyclerView recyclerView, int i, long j) {
        if (m4231a(recyclerView, i)) {
            return null;
        }
        RecyclerView.C1034p pVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.C1045x a = pVar.mo5724a(i, false, j);
            if (a != null) {
                if (!a.isBound() || a.isInvalid()) {
                    pVar.mo5734a(a, false);
                } else {
                    pVar.mo5730a(a.itemView);
                }
            }
            return a;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    /* renamed from: a */
    private void m4228a() {
        C1080b bVar;
        int size = this.f3419b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f3419b.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.mo6014a(recyclerView, false);
                i += recyclerView.mPrefetchRegistry.f3426d;
            }
        }
        this.f3422f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f3419b.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                C1079a aVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(aVar.f3423a) + Math.abs(aVar.f3424b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.f3426d * 2; i6 += 2) {
                    if (i5 >= this.f3422f.size()) {
                        bVar = new C1080b();
                        this.f3422f.add(bVar);
                    } else {
                        bVar = this.f3422f.get(i5);
                    }
                    int i7 = aVar.f3425c[i6 + 1];
                    bVar.f3427a = i7 <= abs;
                    bVar.f3428b = abs;
                    bVar.f3429c = i7;
                    bVar.f3430d = recyclerView2;
                    bVar.f3431e = aVar.f3425c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f3422f, f3418e);
    }

    /* renamed from: a */
    private void m4229a(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.mo5951c() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            C1079a aVar = recyclerView.mPrefetchRegistry;
            aVar.mo6014a(recyclerView, true);
            if (aVar.f3426d != 0) {
                try {
                    C0547b.m2169a("RV Nested Prefetch");
                    recyclerView.mState.mo5791a(recyclerView.mAdapter);
                    for (int i = 0; i < aVar.f3426d * 2; i += 2) {
                        m4227a(recyclerView, aVar.f3425c[i], j);
                    }
                } finally {
                    C0547b.m2168a();
                }
            }
        }
    }

    /* renamed from: a */
    private void m4230a(C1080b bVar, long j) {
        RecyclerView.C1045x a = m4227a(bVar.f3430d, bVar.f3431e, bVar.f3427a ? Long.MAX_VALUE : j);
        if (a != null && a.mNestedRecyclerView != null && a.isBound() && !a.isInvalid()) {
            m4229a((RecyclerView) a.mNestedRecyclerView.get(), j);
        }
    }

    /* renamed from: a */
    static boolean m4231a(RecyclerView recyclerView, int i) {
        int c = recyclerView.mChildHelper.mo5951c();
        for (int i2 = 0; i2 < c; i2++) {
            RecyclerView.C1045x childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.mo5954d(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m4232b(long j) {
        int i = 0;
        while (i < this.f3422f.size()) {
            C1080b bVar = this.f3422f.get(i);
            if (bVar.f3430d != null) {
                m4230a(bVar, j);
                bVar.mo6016a();
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6005a(long j) {
        m4228a();
        m4232b(j);
    }

    /* renamed from: a */
    public void mo6006a(RecyclerView recyclerView) {
        this.f3419b.add(recyclerView);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6007a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f3420c == 0) {
            this.f3420c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.mo6013a(i, i2);
    }

    /* renamed from: b */
    public void mo6008b(RecyclerView recyclerView) {
        this.f3419b.remove(recyclerView);
    }

    public void run() {
        try {
            C0547b.m2169a("RV Prefetch");
            if (!this.f3419b.isEmpty()) {
                int size = this.f3419b.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f3419b.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j != 0) {
                    mo6005a(TimeUnit.MILLISECONDS.toNanos(j) + this.f3421d);
                    this.f3420c = 0;
                    C0547b.m2168a();
                }
            }
        } finally {
            this.f3420c = 0;
            C0547b.m2168a();
        }
    }
}
