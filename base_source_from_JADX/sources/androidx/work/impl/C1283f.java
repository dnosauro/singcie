package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.C1194f;
import androidx.work.C1196h;
import androidx.work.C1326k;
import androidx.work.C1334m;
import androidx.work.C1338p;
import androidx.work.impl.utils.C1310b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: androidx.work.impl.f */
public class C1283f extends C1334m {

    /* renamed from: a */
    private static final String f3972a = C1196h.m4737a("WorkContinuationImpl");

    /* renamed from: b */
    private final C1289h f3973b;

    /* renamed from: c */
    private final String f3974c;

    /* renamed from: d */
    private final C1194f f3975d;

    /* renamed from: e */
    private final List<? extends C1338p> f3976e;

    /* renamed from: f */
    private final List<String> f3977f;

    /* renamed from: g */
    private final List<String> f3978g;

    /* renamed from: h */
    private final List<C1283f> f3979h;

    /* renamed from: i */
    private boolean f3980i;

    /* renamed from: j */
    private C1326k f3981j;

    C1283f(C1289h hVar, String str, C1194f fVar, List<? extends C1338p> list, List<C1283f> list2) {
        this.f3973b = hVar;
        this.f3974c = str;
        this.f3975d = fVar;
        this.f3976e = list;
        this.f3979h = list2;
        this.f3977f = new ArrayList(this.f3976e.size());
        this.f3978g = new ArrayList();
        if (list2 != null) {
            for (C1283f fVar2 : list2) {
                this.f3978g.addAll(fVar2.f3978g);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String a = ((C1338p) list.get(i)).mo6681a();
            this.f3977f.add(a);
            this.f3978g.add(a);
        }
    }

    C1283f(C1289h hVar, List<? extends C1338p> list) {
        this(hVar, (String) null, C1194f.KEEP, list, (List<C1283f>) null);
    }

    /* renamed from: a */
    public static Set<String> m5041a(C1283f fVar) {
        HashSet hashSet = new HashSet();
        List<C1283f> h = fVar.mo6581h();
        if (h != null && !h.isEmpty()) {
            for (C1283f e : h) {
                hashSet.addAll(e.mo6578e());
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    private static boolean m5042a(C1283f fVar, Set<String> set) {
        set.addAll(fVar.mo6578e());
        Set<String> a = m5041a(fVar);
        for (String contains : set) {
            if (a.contains(contains)) {
                return true;
            }
        }
        List<C1283f> h = fVar.mo6581h();
        if (h != null && !h.isEmpty()) {
            for (C1283f a2 : h) {
                if (m5042a(a2, set)) {
                    return true;
                }
            }
        }
        set.removeAll(fVar.mo6578e());
        return false;
    }

    /* renamed from: a */
    public C1289h mo6574a() {
        return this.f3973b;
    }

    /* renamed from: b */
    public String mo6575b() {
        return this.f3974c;
    }

    /* renamed from: c */
    public C1194f mo6576c() {
        return this.f3975d;
    }

    /* renamed from: d */
    public List<? extends C1338p> mo6577d() {
        return this.f3976e;
    }

    /* renamed from: e */
    public List<String> mo6578e() {
        return this.f3977f;
    }

    /* renamed from: f */
    public boolean mo6579f() {
        return this.f3980i;
    }

    /* renamed from: g */
    public void mo6580g() {
        this.f3980i = true;
    }

    /* renamed from: h */
    public List<C1283f> mo6581h() {
        return this.f3979h;
    }

    /* renamed from: i */
    public C1326k mo6582i() {
        if (!this.f3980i) {
            C1310b bVar = new C1310b(this);
            this.f3973b.mo6596g().mo6649a(bVar);
            this.f3981j = bVar.mo6644a();
        } else {
            C1196h.m4736a().mo6420d(f3972a, String.format("Already enqueued work ids (%s)", new Object[]{TextUtils.join(", ", this.f3977f)}), new Throwable[0]);
        }
        return this.f3981j;
    }

    /* renamed from: j */
    public boolean mo6583j() {
        return m5042a(this, new HashSet());
    }
}
