package androidx.viewpager2.p058a;

import androidx.viewpager2.p058a.C1166f;
import java.util.ConcurrentModificationException;
import java.util.List;

/* renamed from: androidx.viewpager2.a.b */
final class C1161b extends C1166f.C1168b {

    /* renamed from: a */
    private final List<C1166f.C1168b> f3640a;

    /* renamed from: a */
    private void m4602a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6252a(C1166f.C1168b bVar) {
        this.f3640a.add(bVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo6253b(C1166f.C1168b bVar) {
        this.f3640a.remove(bVar);
    }

    public void onPageScrollStateChanged(int i) {
        try {
            for (C1166f.C1168b onPageScrollStateChanged : this.f3640a) {
                onPageScrollStateChanged.onPageScrollStateChanged(i);
            }
        } catch (ConcurrentModificationException e) {
            m4602a(e);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        try {
            for (C1166f.C1168b onPageScrolled : this.f3640a) {
                onPageScrolled.onPageScrolled(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            m4602a(e);
        }
    }

    public void onPageSelected(int i) {
        try {
            for (C1166f.C1168b onPageSelected : this.f3640a) {
                onPageSelected.onPageSelected(i);
            }
        } catch (ConcurrentModificationException e) {
            m4602a(e);
        }
    }
}
