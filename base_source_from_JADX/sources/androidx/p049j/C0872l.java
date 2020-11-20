package androidx.p049j;

import android.view.ViewGroup;
import androidx.p049j.C0869j;

/* renamed from: androidx.j.l */
public class C0872l {

    /* renamed from: a */
    private ViewGroup f2878a;

    /* renamed from: b */
    private Runnable f2879b;

    /* renamed from: a */
    public static C0872l m3527a(ViewGroup viewGroup) {
        return (C0872l) viewGroup.getTag(C0869j.C0870a.transition_current_scene);
    }

    /* renamed from: a */
    static void m3528a(ViewGroup viewGroup, C0872l lVar) {
        viewGroup.setTag(C0869j.C0870a.transition_current_scene, lVar);
    }

    /* renamed from: a */
    public void mo4746a() {
        Runnable runnable;
        if (m3527a(this.f2878a) == this && (runnable = this.f2879b) != null) {
            runnable.run();
        }
    }
}
