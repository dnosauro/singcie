package androidx.core.p030h;

import android.os.Build;
import android.view.WindowInsets;
import androidx.core.p029g.C0582c;
import java.util.Objects;

/* renamed from: androidx.core.h.ac */
public class C0633ac {

    /* renamed from: a */
    private final Object f2289a;

    C0633ac(Object obj) {
        this.f2289a = obj;
    }

    /* renamed from: a */
    public static C0633ac m2496a(WindowInsets windowInsets) {
        return new C0633ac(Objects.requireNonNull(windowInsets));
    }

    /* renamed from: a */
    public int mo3782a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2289a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    /* renamed from: a */
    public C0633ac mo3783a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new C0633ac(((WindowInsets) this.f2289a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    /* renamed from: b */
    public int mo3784b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2289a).getSystemWindowInsetTop();
        }
        return 0;
    }

    /* renamed from: c */
    public int mo3785c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2289a).getSystemWindowInsetRight();
        }
        return 0;
    }

    /* renamed from: d */
    public int mo3786d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2289a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    /* renamed from: e */
    public boolean mo3787e() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f2289a).hasSystemWindowInsets();
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0633ac)) {
            return false;
        }
        return C0582c.m2256a(this.f2289a, ((C0633ac) obj).f2289a);
    }

    /* renamed from: f */
    public boolean mo3789f() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((WindowInsets) this.f2289a).isConsumed();
        }
        return false;
    }

    /* renamed from: g */
    public C0633ac mo3790g() {
        if (Build.VERSION.SDK_INT >= 20) {
            return new C0633ac(((WindowInsets) this.f2289a).consumeSystemWindowInsets());
        }
        return null;
    }

    /* renamed from: h */
    public WindowInsets mo3791h() {
        return (WindowInsets) this.f2289a;
    }

    public int hashCode() {
        Object obj = this.f2289a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
