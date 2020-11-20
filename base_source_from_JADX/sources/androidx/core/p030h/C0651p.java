package androidx.core.p030h;

import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.core.h.p */
public class C0651p {

    /* renamed from: a */
    private int f2304a;

    /* renamed from: b */
    private int f2305b;

    public C0651p(ViewGroup viewGroup) {
    }

    /* renamed from: a */
    public int mo3813a() {
        return this.f2304a | this.f2305b;
    }

    /* renamed from: a */
    public void mo3814a(View view, int i) {
        if (i == 1) {
            this.f2305b = 0;
        } else {
            this.f2304a = 0;
        }
    }

    /* renamed from: a */
    public void mo3815a(View view, View view2, int i) {
        mo3816a(view, view2, i, 0);
    }

    /* renamed from: a */
    public void mo3816a(View view, View view2, int i, int i2) {
        if (i2 == 1) {
            this.f2305b = i;
        } else {
            this.f2304a = i;
        }
    }
}
