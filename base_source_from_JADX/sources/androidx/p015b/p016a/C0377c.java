package androidx.p015b.p016a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* renamed from: androidx.b.a.c */
class C0377c implements C0381f {
    C0377c() {
    }

    /* renamed from: j */
    private C0382g m1366j(C0380e eVar) {
        return (C0382g) eVar.mo2738c();
    }

    /* renamed from: a */
    public float mo2742a(C0380e eVar) {
        return m1366j(eVar).mo2756a();
    }

    /* renamed from: a */
    public void mo2740a() {
    }

    /* renamed from: a */
    public void mo2743a(C0380e eVar, float f) {
        m1366j(eVar).mo2757a(f);
    }

    /* renamed from: a */
    public void mo2744a(C0380e eVar, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        eVar.mo2735a(new C0382g(colorStateList, f));
        View d = eVar.mo2739d();
        d.setClipToOutline(true);
        d.setElevation(f2);
        mo2747b(eVar, f3);
    }

    /* renamed from: a */
    public void mo2745a(C0380e eVar, ColorStateList colorStateList) {
        m1366j(eVar).mo2759a(colorStateList);
    }

    /* renamed from: b */
    public float mo2746b(C0380e eVar) {
        return mo2750d(eVar) * 2.0f;
    }

    /* renamed from: b */
    public void mo2747b(C0380e eVar, float f) {
        m1366j(eVar).mo2758a(f, eVar.mo2736a(), eVar.mo2737b());
        mo2752f(eVar);
    }

    /* renamed from: c */
    public float mo2748c(C0380e eVar) {
        return mo2750d(eVar) * 2.0f;
    }

    /* renamed from: c */
    public void mo2749c(C0380e eVar, float f) {
        eVar.mo2739d().setElevation(f);
    }

    /* renamed from: d */
    public float mo2750d(C0380e eVar) {
        return m1366j(eVar).mo2760b();
    }

    /* renamed from: e */
    public float mo2751e(C0380e eVar) {
        return eVar.mo2739d().getElevation();
    }

    /* renamed from: f */
    public void mo2752f(C0380e eVar) {
        if (!eVar.mo2736a()) {
            eVar.mo2734a(0, 0, 0, 0);
            return;
        }
        float a = mo2742a(eVar);
        float d = mo2750d(eVar);
        int ceil = (int) Math.ceil((double) C0383h.m1434b(a, d, eVar.mo2737b()));
        int ceil2 = (int) Math.ceil((double) C0383h.m1431a(a, d, eVar.mo2737b()));
        eVar.mo2734a(ceil, ceil2, ceil, ceil2);
    }

    /* renamed from: g */
    public void mo2753g(C0380e eVar) {
        mo2747b(eVar, mo2742a(eVar));
    }

    /* renamed from: h */
    public void mo2754h(C0380e eVar) {
        mo2747b(eVar, mo2742a(eVar));
    }

    /* renamed from: i */
    public ColorStateList mo2755i(C0380e eVar) {
        return m1366j(eVar).mo2761c();
    }
}
