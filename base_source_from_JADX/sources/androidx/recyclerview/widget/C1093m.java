package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.m */
class C1093m {
    /* renamed from: a */
    static int m4323a(RecyclerView.C1042u uVar, C1086j jVar, View view, View view2, RecyclerView.C1022i iVar, boolean z) {
        if (iVar.getChildCount() == 0 || uVar.mo5796e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1;
        }
        return Math.min(jVar.mo6046f(), jVar.mo6039b(view2) - jVar.mo6035a(view));
    }

    /* renamed from: a */
    static int m4324a(RecyclerView.C1042u uVar, C1086j jVar, View view, View view2, RecyclerView.C1022i iVar, boolean z, boolean z2) {
        if (iVar.getChildCount() == 0 || uVar.mo5796e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (uVar.mo5796e() - Math.max(iVar.getPosition(view), iVar.getPosition(view2))) - 1) : Math.max(0, Math.min(iVar.getPosition(view), iVar.getPosition(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(jVar.mo6039b(view2) - jVar.mo6035a(view))) / ((float) (Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1)))) + ((float) (jVar.mo6040c() - jVar.mo6035a(view))));
    }

    /* renamed from: b */
    static int m4325b(RecyclerView.C1042u uVar, C1086j jVar, View view, View view2, RecyclerView.C1022i iVar, boolean z) {
        if (iVar.getChildCount() == 0 || uVar.mo5796e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return uVar.mo5796e();
        }
        return (int) ((((float) (jVar.mo6039b(view2) - jVar.mo6035a(view))) / ((float) (Math.abs(iVar.getPosition(view) - iVar.getPosition(view2)) + 1))) * ((float) uVar.mo5796e()));
    }
}
