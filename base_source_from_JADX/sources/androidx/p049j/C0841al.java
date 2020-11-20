package androidx.p049j;

import android.os.IBinder;

/* renamed from: androidx.j.al */
class C0841al implements C0843an {

    /* renamed from: a */
    private final IBinder f2814a;

    C0841al(IBinder iBinder) {
        this.f2814a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0841al) && ((C0841al) obj).f2814a.equals(this.f2814a);
    }

    public int hashCode() {
        return this.f2814a.hashCode();
    }
}
