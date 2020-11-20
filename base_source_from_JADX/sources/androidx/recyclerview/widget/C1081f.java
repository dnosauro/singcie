package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.f */
class C1081f {

    /* renamed from: a */
    boolean f3432a = true;

    /* renamed from: b */
    int f3433b;

    /* renamed from: c */
    int f3434c;

    /* renamed from: d */
    int f3435d;

    /* renamed from: e */
    int f3436e;

    /* renamed from: f */
    int f3437f = 0;

    /* renamed from: g */
    int f3438g = 0;

    /* renamed from: h */
    boolean f3439h;

    /* renamed from: i */
    boolean f3440i;

    C1081f() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo6017a(RecyclerView.C1034p pVar) {
        View c = pVar.mo5742c(this.f3434c);
        this.f3434c += this.f3435d;
        return c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo6018a(RecyclerView.C1042u uVar) {
        int i = this.f3434c;
        return i >= 0 && i < uVar.mo5796e();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f3433b + ", mCurrentPosition=" + this.f3434c + ", mItemDirection=" + this.f3435d + ", mLayoutDirection=" + this.f3436e + ", mStartLine=" + this.f3437f + ", mEndLine=" + this.f3438g + '}';
    }
}
