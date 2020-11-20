package androidx.media;

import android.os.Build;
import androidx.media.C0990j;

/* renamed from: androidx.media.i */
public abstract class C0987i {

    /* renamed from: a */
    private final int f3136a;

    /* renamed from: b */
    private final int f3137b;

    /* renamed from: c */
    private int f3138c;

    /* renamed from: d */
    private C0989a f3139d;

    /* renamed from: e */
    private Object f3140e;

    /* renamed from: androidx.media.i$a */
    public static abstract class C0989a {
        public abstract void onVolumeChanged(C0987i iVar);
    }

    /* renamed from: a */
    public final int mo5169a() {
        return this.f3138c;
    }

    /* renamed from: a */
    public void mo5170a(int i) {
    }

    /* renamed from: a */
    public void mo5171a(C0989a aVar) {
        this.f3139d = aVar;
    }

    /* renamed from: b */
    public final int mo5172b() {
        return this.f3136a;
    }

    /* renamed from: b */
    public void mo5173b(int i) {
    }

    /* renamed from: c */
    public final int mo5174c() {
        return this.f3137b;
    }

    /* renamed from: d */
    public Object mo5175d() {
        if (this.f3140e == null && Build.VERSION.SDK_INT >= 21) {
            this.f3140e = C0990j.m3795a(this.f3136a, this.f3137b, this.f3138c, new C0990j.C0992a() {
                /* renamed from: a */
                public void mo5176a(int i) {
                    C0987i.this.mo5170a(i);
                }

                /* renamed from: b */
                public void mo5177b(int i) {
                    C0987i.this.mo5173b(i);
                }
            });
        }
        return this.f3140e;
    }
}
