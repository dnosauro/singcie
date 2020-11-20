package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.C0735d;
import androidx.fragment.app.C0750j;
import androidx.fragment.app.C0775p;
import androidx.lifecycle.C0947e;
import androidx.p018c.C0405d;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.p058a.C1166f;

/* renamed from: androidx.viewpager2.adapter.a */
public abstract class C1173a extends RecyclerView.C1011a<C1176b> implements C1177c {

    /* renamed from: a */
    final C0947e f3691a;

    /* renamed from: b */
    final C0750j f3692b;

    /* renamed from: c */
    final C0405d<C0735d> f3693c;

    /* renamed from: d */
    private C1175a f3694d;

    /* renamed from: androidx.viewpager2.adapter.a$a */
    class C1175a {

        /* renamed from: a */
        final /* synthetic */ C1173a f3698a;

        /* renamed from: b */
        private C1166f f3699b;

        /* renamed from: c */
        private long f3700c;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6323a(boolean z) {
            int currentItem;
            C0735d a;
            if (!this.f3698a.mo6322a() && this.f3699b.getScrollState() == 0 && !this.f3698a.f3693c.mo2856c() && this.f3698a.getItemCount() != 0 && (currentItem = this.f3699b.getCurrentItem()) < this.f3698a.getItemCount()) {
                long itemId = this.f3698a.getItemId(currentItem);
                if ((itemId != this.f3700c || z) && (a = this.f3698a.f3693c.mo2846a(itemId)) != null && a.isAdded()) {
                    this.f3700c = itemId;
                    C0775p a2 = this.f3698a.f3692b.mo4359a();
                    C0735d dVar = null;
                    for (int i = 0; i < this.f3698a.f3693c.mo2849b(); i++) {
                        long b = this.f3698a.f3693c.mo2850b(i);
                        C0735d c = this.f3698a.f3693c.mo2853c(i);
                        if (c.isAdded()) {
                            if (b != this.f3700c) {
                                a2.mo4060a(c, C0947e.C0949b.STARTED);
                            } else {
                                dVar = c;
                            }
                            c.setMenuVisibility(b == this.f3700c);
                        }
                    }
                    if (dVar != null) {
                        a2.mo4060a(dVar, C0947e.C0949b.RESUMED);
                    }
                    if (!a2.mo4080i()) {
                        a2.mo4075d();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m4653a(final C0735d dVar, final FrameLayout frameLayout) {
        this.f3692b.mo4363a((C0750j.C0751a) new C0750j.C0751a() {
            /* renamed from: a */
            public void mo4373a(C0750j jVar, C0735d dVar, View view, Bundle bundle) {
                if (dVar == dVar) {
                    jVar.mo4362a((C0750j.C0751a) this);
                    C1173a.this.mo6320a(view, frameLayout);
                }
            }
        }, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6320a(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6321a(C1176b bVar) {
        C0735d a = this.f3693c.mo2846a(bVar.getItemId());
        if (a != null) {
            FrameLayout a2 = bVar.mo6324a();
            View view = a.getView();
            if (!a.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (a.isAdded() && view == null) {
                m4653a(a, a2);
            } else if (!a.isAdded() || view.getParent() == null) {
                if (a.isAdded()) {
                    mo6320a(view, a2);
                } else if (!mo6322a()) {
                    m4653a(a, a2);
                    C0775p a3 = this.f3692b.mo4359a();
                    a3.mo4524a(a, "f" + bVar.getItemId()).mo4060a(a, C0947e.C0949b.STARTED).mo4075d();
                    this.f3694d.mo6323a(false);
                } else if (!this.f3692b.mo4367d()) {
                    this.f3691a.mo5112a(new FragmentStateAdapter$2(this, bVar));
                }
            } else if (view.getParent() != a2) {
                mo6320a(view, a2);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6322a() {
        return this.f3692b.mo4369f();
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
