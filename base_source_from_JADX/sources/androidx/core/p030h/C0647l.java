package androidx.core.p030h;

import android.view.View;
import android.view.ViewParent;

/* renamed from: androidx.core.h.l */
public class C0647l {

    /* renamed from: a */
    private ViewParent f2299a;

    /* renamed from: b */
    private ViewParent f2300b;

    /* renamed from: c */
    private final View f2301c;

    /* renamed from: d */
    private boolean f2302d;

    /* renamed from: e */
    private int[] f2303e;

    public C0647l(View view) {
        this.f2301c = view;
    }

    /* renamed from: a */
    private void m2541a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.f2299a = viewParent;
                return;
            case 1:
                this.f2300b = viewParent;
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private boolean m2542b(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent d;
        int i6;
        int i7;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (!mo3800a() || (d = m2543d(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        if (iArr4 != null) {
            this.f2301c.getLocationInWindow(iArr4);
            i7 = iArr4[0];
            i6 = iArr4[1];
        } else {
            i7 = 0;
            i6 = 0;
        }
        if (iArr2 == null) {
            int[] d2 = m2544d();
            d2[0] = 0;
            d2[1] = 0;
            iArr3 = d2;
        } else {
            iArr3 = iArr2;
        }
        C0667x.m2687a(d, this.f2301c, i, i2, i3, i4, i5, iArr3);
        if (iArr4 != null) {
            this.f2301c.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i7;
            iArr4[1] = iArr4[1] - i6;
        }
        return true;
    }

    /* renamed from: d */
    private ViewParent m2543d(int i) {
        switch (i) {
            case 0:
                return this.f2299a;
            case 1:
                return this.f2300b;
            default:
                return null;
        }
    }

    /* renamed from: d */
    private int[] m2544d() {
        if (this.f2303e == null) {
            this.f2303e = new int[2];
        }
        return this.f2303e;
    }

    /* renamed from: a */
    public void mo3798a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        m2542b(i, i2, i3, i4, iArr, i5, iArr2);
    }

    /* renamed from: a */
    public void mo3799a(boolean z) {
        if (this.f2302d) {
            C0656u.m2641x(this.f2301c);
        }
        this.f2302d = z;
    }

    /* renamed from: a */
    public boolean mo3800a() {
        return this.f2302d;
    }

    /* renamed from: a */
    public boolean mo3801a(float f, float f2) {
        ViewParent d;
        if (!mo3800a() || (d = m2543d(0)) == null) {
            return false;
        }
        return C0667x.m2689a(d, this.f2301c, f, f2);
    }

    /* renamed from: a */
    public boolean mo3802a(float f, float f2, boolean z) {
        ViewParent d;
        if (!mo3800a() || (d = m2543d(0)) == null) {
            return false;
        }
        return C0667x.m2690a(d, this.f2301c, f, f2, z);
    }

    /* renamed from: a */
    public boolean mo3803a(int i) {
        return m2543d(i) != null;
    }

    /* renamed from: a */
    public boolean mo3804a(int i, int i2) {
        if (mo3803a(i2)) {
            return true;
        }
        if (!mo3800a()) {
            return false;
        }
        View view = this.f2301c;
        for (ViewParent parent = this.f2301c.getParent(); parent != null; parent = parent.getParent()) {
            if (C0667x.m2691a(parent, view, this.f2301c, i, i2)) {
                m2541a(i2, parent);
                C0667x.m2693b(parent, view, this.f2301c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean mo3805a(int i, int i2, int i3, int i4, int[] iArr) {
        return m2542b(i, i2, i3, i4, iArr, 0, (int[]) null);
    }

    /* renamed from: a */
    public boolean mo3806a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return m2542b(i, i2, i3, i4, iArr, i5, (int[]) null);
    }

    /* renamed from: a */
    public boolean mo3807a(int i, int i2, int[] iArr, int[] iArr2) {
        return mo3808a(i, i2, iArr, iArr2, 0);
    }

    /* renamed from: a */
    public boolean mo3808a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent d;
        int i4;
        int i5;
        if (!mo3800a() || (d = m2543d(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f2301c.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i4 = iArr2[1];
        } else {
            i5 = 0;
            i4 = 0;
        }
        if (iArr == null) {
            iArr = m2544d();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        C0667x.m2688a(d, this.f2301c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.f2301c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i4;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    /* renamed from: b */
    public boolean mo3809b() {
        return mo3803a(0);
    }

    /* renamed from: b */
    public boolean mo3810b(int i) {
        return mo3804a(i, 0);
    }

    /* renamed from: c */
    public void mo3811c() {
        mo3812c(0);
    }

    /* renamed from: c */
    public void mo3812c(int i) {
        ViewParent d = m2543d(i);
        if (d != null) {
            C0667x.m2686a(d, this.f2301c, i);
            m2541a(i, (ViewParent) null);
        }
    }
}
