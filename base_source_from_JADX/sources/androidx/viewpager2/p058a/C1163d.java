package androidx.viewpager2.p058a;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.p058a.C1166f;
import java.util.Locale;

/* renamed from: androidx.viewpager2.a.d */
final class C1163d extends C1166f.C1168b {

    /* renamed from: a */
    private final LinearLayoutManager f3642a;

    /* renamed from: b */
    private C1166f.C1169c f3643b;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C1166f.C1169c mo6258a() {
        return this.f3643b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6259a(C1166f.C1169c cVar) {
        this.f3643b = cVar;
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.f3643b != null) {
            float f2 = -f;
            int i3 = 0;
            while (i3 < this.f3642a.getChildCount()) {
                View childAt = this.f3642a.getChildAt(i3);
                if (childAt != null) {
                    this.f3643b.mo6311a(childAt, ((float) (this.f3642a.getPosition(childAt) - i)) + f2);
                    i3++;
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[]{Integer.valueOf(i3), Integer.valueOf(this.f3642a.getChildCount())}));
                }
            }
        }
    }

    public void onPageSelected(int i) {
    }
}
