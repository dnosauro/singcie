package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.work.impl.utils.p065b.C1311a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {

    /* renamed from: a */
    private UUID f3704a;

    /* renamed from: b */
    private C1192e f3705b;

    /* renamed from: c */
    private Set<String> f3706c;

    /* renamed from: d */
    private C1183a f3707d;

    /* renamed from: e */
    private int f3708e;

    /* renamed from: f */
    private Executor f3709f;

    /* renamed from: g */
    private C1311a f3710g;

    /* renamed from: h */
    private C1340q f3711h;

    /* renamed from: androidx.work.WorkerParameters$a */
    public static class C1183a {

        /* renamed from: a */
        public List<String> f3712a = Collections.emptyList();

        /* renamed from: b */
        public List<Uri> f3713b = Collections.emptyList();

        /* renamed from: c */
        public Network f3714c;
    }

    public WorkerParameters(UUID uuid, C1192e eVar, Collection<String> collection, C1183a aVar, int i, Executor executor, C1311a aVar2, C1340q qVar) {
        this.f3704a = uuid;
        this.f3705b = eVar;
        this.f3706c = new HashSet(collection);
        this.f3707d = aVar;
        this.f3708e = i;
        this.f3709f = executor;
        this.f3710g = aVar2;
        this.f3711h = qVar;
    }

    /* renamed from: a */
    public UUID mo6358a() {
        return this.f3704a;
    }

    /* renamed from: b */
    public C1192e mo6359b() {
        return this.f3705b;
    }

    /* renamed from: c */
    public Set<String> mo6360c() {
        return this.f3706c;
    }

    /* renamed from: d */
    public List<Uri> mo6361d() {
        return this.f3707d.f3713b;
    }

    /* renamed from: e */
    public List<String> mo6362e() {
        return this.f3707d.f3712a;
    }

    /* renamed from: f */
    public Network mo6363f() {
        return this.f3707d.f3714c;
    }

    /* renamed from: g */
    public int mo6364g() {
        return this.f3708e;
    }

    /* renamed from: h */
    public Executor mo6365h() {
        return this.f3709f;
    }

    /* renamed from: i */
    public C1311a mo6366i() {
        return this.f3710g;
    }

    /* renamed from: j */
    public C1340q mo6367j() {
        return this.f3711h;
    }
}
