package androidx.work;

import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* renamed from: androidx.work.b */
public final class C1185b {

    /* renamed from: a */
    private final Executor f3718a;

    /* renamed from: b */
    private final Executor f3719b;

    /* renamed from: c */
    private final C1340q f3720c;

    /* renamed from: d */
    private final int f3721d;

    /* renamed from: e */
    private final int f3722e;

    /* renamed from: f */
    private final int f3723f;

    /* renamed from: g */
    private final int f3724g;

    /* renamed from: androidx.work.b$a */
    public static final class C1186a {

        /* renamed from: a */
        Executor f3725a;

        /* renamed from: b */
        C1340q f3726b;

        /* renamed from: c */
        Executor f3727c;

        /* renamed from: d */
        int f3728d = 4;

        /* renamed from: e */
        int f3729e = 0;

        /* renamed from: f */
        int f3730f = Integer.MAX_VALUE;

        /* renamed from: g */
        int f3731g = 20;

        /* renamed from: a */
        public C1185b mo6375a() {
            return new C1185b(this);
        }
    }

    /* renamed from: androidx.work.b$b */
    public interface C1187b {
        /* renamed from: a */
        C1185b mo6376a();
    }

    C1185b(C1186a aVar) {
        this.f3718a = aVar.f3725a == null ? m4684h() : aVar.f3725a;
        this.f3719b = aVar.f3727c == null ? m4684h() : aVar.f3727c;
        this.f3720c = aVar.f3726b == null ? C1340q.m5202a() : aVar.f3726b;
        this.f3721d = aVar.f3728d;
        this.f3722e = aVar.f3729e;
        this.f3723f = aVar.f3730f;
        this.f3724g = aVar.f3731g;
    }

    /* renamed from: h */
    private Executor m4684h() {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)));
    }

    /* renamed from: a */
    public Executor mo6368a() {
        return this.f3718a;
    }

    /* renamed from: b */
    public Executor mo6369b() {
        return this.f3719b;
    }

    /* renamed from: c */
    public C1340q mo6370c() {
        return this.f3720c;
    }

    /* renamed from: d */
    public int mo6371d() {
        return this.f3721d;
    }

    /* renamed from: e */
    public int mo6372e() {
        return this.f3722e;
    }

    /* renamed from: f */
    public int mo6373f() {
        return this.f3723f;
    }

    /* renamed from: g */
    public int mo6374g() {
        return Build.VERSION.SDK_INT == 23 ? this.f3724g / 2 : this.f3724g;
    }
}
