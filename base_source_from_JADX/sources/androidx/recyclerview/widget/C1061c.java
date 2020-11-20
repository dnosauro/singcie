package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.p030h.C0656u;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.c */
public class C1061c extends C1094n {

    /* renamed from: i */
    private static TimeInterpolator f3330i;

    /* renamed from: a */
    ArrayList<ArrayList<RecyclerView.C1045x>> f3331a = new ArrayList<>();

    /* renamed from: b */
    ArrayList<ArrayList<C1071b>> f3332b = new ArrayList<>();

    /* renamed from: c */
    ArrayList<ArrayList<C1070a>> f3333c = new ArrayList<>();

    /* renamed from: d */
    ArrayList<RecyclerView.C1045x> f3334d = new ArrayList<>();

    /* renamed from: e */
    ArrayList<RecyclerView.C1045x> f3335e = new ArrayList<>();

    /* renamed from: f */
    ArrayList<RecyclerView.C1045x> f3336f = new ArrayList<>();

    /* renamed from: g */
    ArrayList<RecyclerView.C1045x> f3337g = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<RecyclerView.C1045x> f3338j = new ArrayList<>();

    /* renamed from: k */
    private ArrayList<RecyclerView.C1045x> f3339k = new ArrayList<>();

    /* renamed from: l */
    private ArrayList<C1071b> f3340l = new ArrayList<>();

    /* renamed from: m */
    private ArrayList<C1070a> f3341m = new ArrayList<>();

    /* renamed from: androidx.recyclerview.widget.c$a */
    private static class C1070a {

        /* renamed from: a */
        public RecyclerView.C1045x f3370a;

        /* renamed from: b */
        public RecyclerView.C1045x f3371b;

        /* renamed from: c */
        public int f3372c;

        /* renamed from: d */
        public int f3373d;

        /* renamed from: e */
        public int f3374e;

        /* renamed from: f */
        public int f3375f;

        private C1070a(RecyclerView.C1045x xVar, RecyclerView.C1045x xVar2) {
            this.f3370a = xVar;
            this.f3371b = xVar2;
        }

        C1070a(RecyclerView.C1045x xVar, RecyclerView.C1045x xVar2, int i, int i2, int i3, int i4) {
            this(xVar, xVar2);
            this.f3372c = i;
            this.f3373d = i2;
            this.f3374e = i3;
            this.f3375f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f3370a + ", newHolder=" + this.f3371b + ", fromX=" + this.f3372c + ", fromY=" + this.f3373d + ", toX=" + this.f3374e + ", toY=" + this.f3375f + '}';
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$b */
    private static class C1071b {

        /* renamed from: a */
        public RecyclerView.C1045x f3376a;

        /* renamed from: b */
        public int f3377b;

        /* renamed from: c */
        public int f3378c;

        /* renamed from: d */
        public int f3379d;

        /* renamed from: e */
        public int f3380e;

        C1071b(RecyclerView.C1045x xVar, int i, int i2, int i3, int i4) {
            this.f3376a = xVar;
            this.f3377b = i;
            this.f3378c = i2;
            this.f3379d = i3;
            this.f3380e = i4;
        }
    }

    /* renamed from: a */
    private void m4185a(List<C1070a> list, RecyclerView.C1045x xVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C1070a aVar = list.get(size);
            if (m4186a(aVar, xVar) && aVar.f3370a == null && aVar.f3371b == null) {
                list.remove(aVar);
            }
        }
    }

    /* renamed from: a */
    private boolean m4186a(C1070a aVar, RecyclerView.C1045x xVar) {
        boolean z = false;
        if (aVar.f3371b == xVar) {
            aVar.f3371b = null;
        } else if (aVar.f3370a != xVar) {
            return false;
        } else {
            aVar.f3370a = null;
            z = true;
        }
        xVar.itemView.setAlpha(1.0f);
        xVar.itemView.setTranslationX(0.0f);
        xVar.itemView.setTranslationY(0.0f);
        mo6056a(xVar, z);
        return true;
    }

    /* renamed from: b */
    private void m4187b(C1070a aVar) {
        if (aVar.f3370a != null) {
            m4186a(aVar, aVar.f3370a);
        }
        if (aVar.f3371b != null) {
            m4186a(aVar, aVar.f3371b);
        }
    }

    /* renamed from: u */
    private void m4188u(final RecyclerView.C1045x xVar) {
        final View view = xVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f3336f.add(xVar);
        animate.setDuration(mo5563g()).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                view.setAlpha(1.0f);
                C1061c.this.mo6060i(xVar);
                C1061c.this.f3336f.remove(xVar);
                C1061c.this.mo5975c();
            }

            public void onAnimationStart(Animator animator) {
                C1061c.this.mo6063l(xVar);
            }
        }).start();
    }

    /* renamed from: v */
    private void m4189v(RecyclerView.C1045x xVar) {
        if (f3330i == null) {
            f3330i = new ValueAnimator().getInterpolator();
        }
        xVar.itemView.animate().setInterpolator(f3330i);
        mo5559d(xVar);
    }

    /* renamed from: a */
    public void mo5550a() {
        boolean z = !this.f3338j.isEmpty();
        boolean z2 = !this.f3340l.isEmpty();
        boolean z3 = !this.f3341m.isEmpty();
        boolean z4 = !this.f3339k.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.C1045x> it = this.f3338j.iterator();
            while (it.hasNext()) {
                m4188u(it.next());
            }
            this.f3338j.clear();
            if (z2) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f3340l);
                this.f3332b.add(arrayList);
                this.f3340l.clear();
                C10621 r6 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            C1071b bVar = (C1071b) it.next();
                            C1061c.this.mo5973b(bVar.f3376a, bVar.f3377b, bVar.f3378c, bVar.f3379d, bVar.f3380e);
                        }
                        arrayList.clear();
                        C1061c.this.f3332b.remove(arrayList);
                    }
                };
                if (z) {
                    C0656u.m2598a(((C1071b) arrayList.get(0)).f3376a.itemView, (Runnable) r6, mo5563g());
                } else {
                    r6.run();
                }
            }
            if (z3) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f3341m);
                this.f3333c.add(arrayList2);
                this.f3341m.clear();
                C10632 r62 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            C1061c.this.mo5968a((C1070a) it.next());
                        }
                        arrayList2.clear();
                        C1061c.this.f3333c.remove(arrayList2);
                    }
                };
                if (z) {
                    C0656u.m2598a(((C1070a) arrayList2.get(0)).f3370a.itemView, (Runnable) r62, mo5563g());
                } else {
                    r62.run();
                }
            }
            if (z4) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f3339k);
                this.f3331a.add(arrayList3);
                this.f3339k.clear();
                C10643 r5 = new Runnable() {
                    public void run() {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            C1061c.this.mo5976c((RecyclerView.C1045x) it.next());
                        }
                        arrayList3.clear();
                        C1061c.this.f3331a.remove(arrayList3);
                    }
                };
                if (z || z2 || z3) {
                    long j = 0;
                    long g = z ? mo5563g() : 0;
                    long e = z2 ? mo5560e() : 0;
                    if (z3) {
                        j = mo5565h();
                    }
                    C0656u.m2598a(((RecyclerView.C1045x) arrayList3.get(0)).itemView, (Runnable) r5, g + Math.max(e, j));
                    return;
                }
                r5.run();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5968a(final C1070a aVar) {
        RecyclerView.C1045x xVar = aVar.f3370a;
        final View view = null;
        final View view2 = xVar == null ? null : xVar.itemView;
        RecyclerView.C1045x xVar2 = aVar.f3371b;
        if (xVar2 != null) {
            view = xVar2.itemView;
        }
        if (view2 != null) {
            final ViewPropertyAnimator duration = view2.animate().setDuration(mo5565h());
            this.f3337g.add(aVar.f3370a);
            duration.translationX((float) (aVar.f3374e - aVar.f3372c));
            duration.translationY((float) (aVar.f3375f - aVar.f3373d));
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    duration.setListener((Animator.AnimatorListener) null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    C1061c.this.mo6056a(aVar.f3370a, true);
                    C1061c.this.f3337g.remove(aVar.f3370a);
                    C1061c.this.mo5975c();
                }

                public void onAnimationStart(Animator animator) {
                    C1061c.this.mo6057b(aVar.f3370a, true);
                }
            }).start();
        }
        if (view != null) {
            final ViewPropertyAnimator animate = view.animate();
            this.f3337g.add(aVar.f3371b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(mo5565h()).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    animate.setListener((Animator.AnimatorListener) null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    C1061c.this.mo6056a(aVar.f3371b, false);
                    C1061c.this.f3337g.remove(aVar.f3371b);
                    C1061c.this.mo5975c();
                }

                public void onAnimationStart(Animator animator) {
                    C1061c.this.mo6057b(aVar.f3371b, false);
                }
            }).start();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5969a(List<RecyclerView.C1045x> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    /* renamed from: a */
    public boolean mo5970a(RecyclerView.C1045x xVar) {
        m4189v(xVar);
        this.f3338j.add(xVar);
        return true;
    }

    /* renamed from: a */
    public boolean mo5971a(RecyclerView.C1045x xVar, int i, int i2, int i3, int i4) {
        View view = xVar.itemView;
        int translationX = i + ((int) xVar.itemView.getTranslationX());
        int translationY = i2 + ((int) xVar.itemView.getTranslationY());
        m4189v(xVar);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            mo6061j(xVar);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX((float) (-i5));
        }
        if (i6 != 0) {
            view.setTranslationY((float) (-i6));
        }
        this.f3340l.add(new C1071b(xVar, translationX, translationY, i3, i4));
        return true;
    }

    /* renamed from: a */
    public boolean mo5972a(RecyclerView.C1045x xVar, RecyclerView.C1045x xVar2, int i, int i2, int i3, int i4) {
        if (xVar == xVar2) {
            return mo5971a(xVar, i, i2, i3, i4);
        }
        float translationX = xVar.itemView.getTranslationX();
        float translationY = xVar.itemView.getTranslationY();
        float alpha = xVar.itemView.getAlpha();
        m4189v(xVar);
        int i5 = (int) (((float) (i3 - i)) - translationX);
        int i6 = (int) (((float) (i4 - i2)) - translationY);
        xVar.itemView.setTranslationX(translationX);
        xVar.itemView.setTranslationY(translationY);
        xVar.itemView.setAlpha(alpha);
        if (xVar2 != null) {
            m4189v(xVar2);
            xVar2.itemView.setTranslationX((float) (-i5));
            xVar2.itemView.setTranslationY((float) (-i6));
            xVar2.itemView.setAlpha(0.0f);
        }
        this.f3341m.add(new C1070a(xVar, xVar2, i, i2, i3, i4));
        return true;
    }

    /* renamed from: a */
    public boolean mo5554a(RecyclerView.C1045x xVar, List<Object> list) {
        return !list.isEmpty() || super.mo5554a(xVar, list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5973b(RecyclerView.C1045x xVar, int i, int i2, int i3, int i4) {
        final View view = xVar.itemView;
        final int i5 = i3 - i;
        final int i6 = i4 - i2;
        if (i5 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i6 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.f3335e.add(xVar);
        final RecyclerView.C1045x xVar2 = xVar;
        animate.setDuration(mo5560e()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                if (i5 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i6 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                C1061c.this.mo6061j(xVar2);
                C1061c.this.f3335e.remove(xVar2);
                C1061c.this.mo5975c();
            }

            public void onAnimationStart(Animator animator) {
                C1061c.this.mo6064m(xVar2);
            }
        }).start();
    }

    /* renamed from: b */
    public boolean mo5555b() {
        return !this.f3339k.isEmpty() || !this.f3341m.isEmpty() || !this.f3340l.isEmpty() || !this.f3338j.isEmpty() || !this.f3335e.isEmpty() || !this.f3336f.isEmpty() || !this.f3334d.isEmpty() || !this.f3337g.isEmpty() || !this.f3332b.isEmpty() || !this.f3331a.isEmpty() || !this.f3333c.isEmpty();
    }

    /* renamed from: b */
    public boolean mo5974b(RecyclerView.C1045x xVar) {
        m4189v(xVar);
        xVar.itemView.setAlpha(0.0f);
        this.f3339k.add(xVar);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5975c() {
        if (!mo5555b()) {
            mo5567i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5976c(final RecyclerView.C1045x xVar) {
        final View view = xVar.itemView;
        final ViewPropertyAnimator animate = view.animate();
        this.f3334d.add(xVar);
        animate.alpha(1.0f).setDuration(mo5561f()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                C1061c.this.mo6062k(xVar);
                C1061c.this.f3334d.remove(xVar);
                C1061c.this.mo5975c();
            }

            public void onAnimationStart(Animator animator) {
                C1061c.this.mo6065n(xVar);
            }
        }).start();
    }

    /* renamed from: d */
    public void mo5558d() {
        int size = this.f3340l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C1071b bVar = this.f3340l.get(size);
            View view = bVar.f3376a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            mo6061j(bVar.f3376a);
            this.f3340l.remove(size);
        }
        for (int size2 = this.f3338j.size() - 1; size2 >= 0; size2--) {
            mo6060i(this.f3338j.get(size2));
            this.f3338j.remove(size2);
        }
        int size3 = this.f3339k.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.C1045x xVar = this.f3339k.get(size3);
            xVar.itemView.setAlpha(1.0f);
            mo6062k(xVar);
            this.f3339k.remove(size3);
        }
        for (int size4 = this.f3341m.size() - 1; size4 >= 0; size4--) {
            m4187b(this.f3341m.get(size4));
        }
        this.f3341m.clear();
        if (mo5555b()) {
            for (int size5 = this.f3332b.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.f3332b.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    C1071b bVar2 = (C1071b) arrayList.get(size6);
                    View view2 = bVar2.f3376a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    mo6061j(bVar2.f3376a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f3332b.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f3331a.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.f3331a.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.C1045x xVar2 = (RecyclerView.C1045x) arrayList2.get(size8);
                    xVar2.itemView.setAlpha(1.0f);
                    mo6062k(xVar2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f3331a.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f3333c.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.f3333c.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    m4187b((C1070a) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f3333c.remove(arrayList3);
                    }
                }
            }
            mo5969a((List<RecyclerView.C1045x>) this.f3336f);
            mo5969a((List<RecyclerView.C1045x>) this.f3335e);
            mo5969a((List<RecyclerView.C1045x>) this.f3334d);
            mo5969a((List<RecyclerView.C1045x>) this.f3337g);
            mo5567i();
        }
    }

    /* renamed from: d */
    public void mo5559d(RecyclerView.C1045x xVar) {
        View view = xVar.itemView;
        view.animate().cancel();
        int size = this.f3340l.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f3340l.get(size).f3376a == xVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                mo6061j(xVar);
                this.f3340l.remove(size);
            }
        }
        m4185a((List<C1070a>) this.f3341m, xVar);
        if (this.f3338j.remove(xVar)) {
            view.setAlpha(1.0f);
            mo6060i(xVar);
        }
        if (this.f3339k.remove(xVar)) {
            view.setAlpha(1.0f);
            mo6062k(xVar);
        }
        for (int size2 = this.f3333c.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.f3333c.get(size2);
            m4185a((List<C1070a>) arrayList, xVar);
            if (arrayList.isEmpty()) {
                this.f3333c.remove(size2);
            }
        }
        for (int size3 = this.f3332b.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.f3332b.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((C1071b) arrayList2.get(size4)).f3376a == xVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    mo6061j(xVar);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f3332b.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f3331a.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.f3331a.get(size5);
            if (arrayList3.remove(xVar)) {
                view.setAlpha(1.0f);
                mo6062k(xVar);
                if (arrayList3.isEmpty()) {
                    this.f3331a.remove(size5);
                }
            }
        }
        this.f3336f.remove(xVar);
        this.f3334d.remove(xVar);
        this.f3337g.remove(xVar);
        this.f3335e.remove(xVar);
        mo5975c();
    }
}
