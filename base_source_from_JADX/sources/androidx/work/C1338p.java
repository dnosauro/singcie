package androidx.work;

import androidx.work.impl.p062b.C1240j;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* renamed from: androidx.work.p */
public abstract class C1338p {

    /* renamed from: a */
    private UUID f4121a;

    /* renamed from: b */
    private C1240j f4122b;

    /* renamed from: c */
    private Set<String> f4123c;

    /* renamed from: androidx.work.p$a */
    public static abstract class C1339a<B extends C1339a, W extends C1338p> {

        /* renamed from: a */
        boolean f4124a = false;

        /* renamed from: b */
        UUID f4125b = UUID.randomUUID();

        /* renamed from: c */
        C1240j f4126c;

        /* renamed from: d */
        Set<String> f4127d = new HashSet();

        C1339a(Class<? extends ListenableWorker> cls) {
            this.f4126c = new C1240j(this.f4125b.toString(), cls.getName());
            mo6686a(cls.getName());
        }

        /* renamed from: a */
        public final B mo6684a(C1188c cVar) {
            this.f4126c.f3846j = cVar;
            return mo6670c();
        }

        /* renamed from: a */
        public final B mo6685a(C1192e eVar) {
            this.f4126c.f3841e = eVar;
            return mo6670c();
        }

        /* renamed from: a */
        public final B mo6686a(String str) {
            this.f4127d.add(str);
            return mo6670c();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public abstract B mo6670c();

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public abstract W mo6671d();

        /* renamed from: e */
        public final W mo6687e() {
            W d = mo6671d();
            this.f4125b = UUID.randomUUID();
            this.f4126c = new C1240j(this.f4126c);
            this.f4126c.f3837a = this.f4125b.toString();
            return d;
        }
    }

    protected C1338p(UUID uuid, C1240j jVar, Set<String> set) {
        this.f4121a = uuid;
        this.f4122b = jVar;
        this.f4123c = set;
    }

    /* renamed from: a */
    public String mo6681a() {
        return this.f4121a.toString();
    }

    /* renamed from: b */
    public C1240j mo6682b() {
        return this.f4122b;
    }

    /* renamed from: c */
    public Set<String> mo6683c() {
        return this.f4123c;
    }
}
