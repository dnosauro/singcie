package androidx.p049j;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.p030h.C0656u;
import androidx.p018c.C0400a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: androidx.j.p */
public class C0883p {

    /* renamed from: a */
    static ArrayList<ViewGroup> f2899a = new ArrayList<>();

    /* renamed from: b */
    private static C0874n f2900b = new C0844b();

    /* renamed from: c */
    private static ThreadLocal<WeakReference<C0400a<ViewGroup, ArrayList<C0874n>>>> f2901c = new ThreadLocal<>();

    /* renamed from: androidx.j.p$a */
    private static class C0884a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a */
        C0874n f2902a;

        /* renamed from: b */
        ViewGroup f2903b;

        C0884a(C0874n nVar, ViewGroup viewGroup) {
            this.f2902a = nVar;
            this.f2903b = viewGroup;
        }

        /* renamed from: a */
        private void m3548a() {
            this.f2903b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f2903b.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            m3548a();
            if (!C0883p.f2899a.remove(this.f2903b)) {
                return true;
            }
            final C0400a<ViewGroup, ArrayList<C0874n>> a = C0883p.m3544a();
            ArrayList arrayList = a.get(this.f2903b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                a.put(this.f2903b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f2902a);
            this.f2902a.addListener(new C0882o() {
                /* renamed from: b */
                public void mo4694b(C0874n nVar) {
                    ((ArrayList) a.get(C0884a.this.f2903b)).remove(nVar);
                    nVar.removeListener(this);
                }
            });
            this.f2902a.captureValues(this.f2903b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((C0874n) it.next()).resume(this.f2903b);
                }
            }
            this.f2902a.playTransition(this.f2903b);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            m3548a();
            C0883p.f2899a.remove(this.f2903b);
            ArrayList arrayList = C0883p.m3544a().get(this.f2903b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((C0874n) it.next()).resume(this.f2903b);
                }
            }
            this.f2902a.clearValues(true);
        }
    }

    /* renamed from: a */
    static C0400a<ViewGroup, ArrayList<C0874n>> m3544a() {
        C0400a<ViewGroup, ArrayList<C0874n>> aVar;
        WeakReference weakReference = f2901c.get();
        if (weakReference != null && (aVar = (C0400a) weakReference.get()) != null) {
            return aVar;
        }
        C0400a<ViewGroup, ArrayList<C0874n>> aVar2 = new C0400a<>();
        f2901c.set(new WeakReference(aVar2));
        return aVar2;
    }

    /* renamed from: a */
    public static void m3545a(ViewGroup viewGroup, C0874n nVar) {
        if (!f2899a.contains(viewGroup) && C0656u.m2642y(viewGroup)) {
            f2899a.add(viewGroup);
            if (nVar == null) {
                nVar = f2900b;
            }
            C0874n clone = nVar.clone();
            m3547c(viewGroup, clone);
            C0872l.m3528a(viewGroup, (C0872l) null);
            m3546b(viewGroup, clone);
        }
    }

    /* renamed from: b */
    private static void m3546b(ViewGroup viewGroup, C0874n nVar) {
        if (nVar != null && viewGroup != null) {
            C0884a aVar = new C0884a(nVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    /* renamed from: c */
    private static void m3547c(ViewGroup viewGroup, C0874n nVar) {
        ArrayList arrayList = m3544a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((C0874n) it.next()).pause(viewGroup);
            }
        }
        if (nVar != null) {
            nVar.captureValues(viewGroup, true);
        }
        C0872l a = C0872l.m3527a(viewGroup);
        if (a != null) {
            a.mo4746a();
        }
    }
}
