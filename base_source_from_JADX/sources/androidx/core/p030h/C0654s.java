package androidx.core.p030h;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* renamed from: androidx.core.h.s */
public final class C0654s {

    /* renamed from: a */
    private Object f2309a;

    private C0654s(Object obj) {
        this.f2309a = obj;
    }

    /* renamed from: a */
    public static C0654s m2566a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 24 ? new C0654s(PointerIcon.getSystemIcon(context, i)) : new C0654s((Object) null);
    }

    /* renamed from: a */
    public Object mo3821a() {
        return this.f2309a;
    }
}
