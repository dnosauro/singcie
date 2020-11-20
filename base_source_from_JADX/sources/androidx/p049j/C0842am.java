package androidx.p049j;

import android.view.View;
import android.view.WindowId;

/* renamed from: androidx.j.am */
class C0842am implements C0843an {

    /* renamed from: a */
    private final WindowId f2815a;

    C0842am(View view) {
        this.f2815a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0842am) && ((C0842am) obj).f2815a.equals(this.f2815a);
    }

    public int hashCode() {
        return this.f2815a.hashCode();
    }
}
