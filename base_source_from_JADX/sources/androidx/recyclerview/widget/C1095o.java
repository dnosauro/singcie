package androidx.recyclerview.widget;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.o */
public abstract class C1095o extends RecyclerView.C1029l {

    /* renamed from: a */
    RecyclerView f3453a;

    /* renamed from: b */
    private Scroller f3454b;

    /* renamed from: c */
    private final RecyclerView.C1031n f3455c = new RecyclerView.C1031n() {

        /* renamed from: a */
        boolean f3456a = false;

        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f3456a) {
                this.f3456a = false;
                C1095o.this.mo6072a();
            }
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.f3456a = true;
            }
        }
    };

    /* renamed from: b */
    private void m4351b() {
        if (this.f3453a.getOnFlingListener() == null) {
            this.f3453a.addOnScrollListener(this.f3455c);
            this.f3453a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    /* renamed from: b */
    private boolean m4352b(RecyclerView.C1022i iVar, int i, int i2) {
        RecyclerView.C1039t c;
        int a;
        if (!(iVar instanceof RecyclerView.C1039t.C1041b) || (c = mo6075c(iVar)) == null || (a = mo6029a(iVar, i, i2)) == -1) {
            return false;
        }
        c.setTargetPosition(a);
        iVar.startSmoothScroll(c);
        return true;
    }

    /* renamed from: c */
    private void m4353c() {
        this.f3453a.removeOnScrollListener(this.f3455c);
        this.f3453a.setOnFlingListener((RecyclerView.C1029l) null);
    }

    /* renamed from: a */
    public abstract int mo6029a(RecyclerView.C1022i iVar, int i, int i2);

    /* renamed from: a */
    public abstract View mo6030a(RecyclerView.C1022i iVar);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6072a() {
        RecyclerView.C1022i layoutManager;
        View a;
        RecyclerView recyclerView = this.f3453a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (a = mo6030a(layoutManager)) != null) {
            int[] a2 = mo6031a(layoutManager, a);
            if (a2[0] != 0 || a2[1] != 0) {
                this.f3453a.smoothScrollBy(a2[0], a2[1]);
            }
        }
    }

    /* renamed from: a */
    public void mo6073a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f3453a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                m4353c();
            }
            this.f3453a = recyclerView;
            if (this.f3453a != null) {
                m4351b();
                this.f3454b = new Scroller(this.f3453a.getContext(), new DecelerateInterpolator());
                mo6072a();
            }
        }
    }

    /* renamed from: a */
    public boolean mo5706a(int i, int i2) {
        RecyclerView.C1022i layoutManager = this.f3453a.getLayoutManager();
        if (layoutManager == null || this.f3453a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f3453a.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && m4352b(layoutManager, i, i2);
    }

    /* renamed from: a */
    public abstract int[] mo6031a(RecyclerView.C1022i iVar, View view);

    /* access modifiers changed from: protected */
    @Deprecated
    /* renamed from: b */
    public C1082g mo6051b(RecyclerView.C1022i iVar) {
        if (!(iVar instanceof RecyclerView.C1039t.C1041b)) {
            return null;
        }
        return new C1082g(this.f3453a.getContext()) {
            /* access modifiers changed from: protected */
            public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            /* access modifiers changed from: protected */
            public void onTargetFound(View view, RecyclerView.C1042u uVar, RecyclerView.C1039t.C1040a aVar) {
                if (C1095o.this.f3453a != null) {
                    C1095o oVar = C1095o.this;
                    int[] a = oVar.mo6031a(oVar.f3453a.getLayoutManager(), view);
                    int i = a[0];
                    int i2 = a[1];
                    int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                    if (calculateTimeForDeceleration > 0) {
                        aVar.mo5787a(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                    }
                }
            }
        };
    }

    /* renamed from: b */
    public int[] mo6074b(int i, int i2) {
        this.f3454b.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f3454b.getFinalX(), this.f3454b.getFinalY()};
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public RecyclerView.C1039t mo6075c(RecyclerView.C1022i iVar) {
        return mo6051b(iVar);
    }
}
