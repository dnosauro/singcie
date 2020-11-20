package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.C0967s;
import androidx.lifecycle.C0968t;
import androidx.lifecycle.C0971u;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: androidx.fragment.app.m */
class C0770m extends C0967s {

    /* renamed from: a */
    private static final C0968t.C0969a f2620a = new C0968t.C0969a() {
        /* renamed from: a */
        public <T extends C0967s> T mo4503a(Class<T> cls) {
            return new C0770m(true);
        }
    };

    /* renamed from: b */
    private final HashSet<C0735d> f2621b = new HashSet<>();

    /* renamed from: c */
    private final HashMap<String, C0770m> f2622c = new HashMap<>();

    /* renamed from: d */
    private final HashMap<String, C0971u> f2623d = new HashMap<>();

    /* renamed from: e */
    private final boolean f2624e;

    /* renamed from: f */
    private boolean f2625f = false;

    /* renamed from: g */
    private boolean f2626g = false;

    C0770m(boolean z) {
        this.f2624e = z;
    }

    /* renamed from: a */
    static C0770m m3189a(C0971u uVar) {
        return (C0770m) new C0968t(uVar, f2620a).mo5142a(C0770m.class);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo4491a() {
        if (C0753k.f2551b) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f2625f = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo4492a(C0735d dVar) {
        return this.f2621b.add(dVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4493b() {
        return this.f2625f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo4494b(C0735d dVar) {
        if (!this.f2621b.contains(dVar)) {
            return true;
        }
        return this.f2624e ? this.f2625f : !this.f2626g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Collection<C0735d> mo4495c() {
        return this.f2621b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo4496c(C0735d dVar) {
        return this.f2621b.remove(dVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public C0770m mo4497d(C0735d dVar) {
        C0770m mVar = this.f2622c.get(dVar.mWho);
        if (mVar != null) {
            return mVar;
        }
        C0770m mVar2 = new C0770m(this.f2624e);
        this.f2622c.put(dVar.mWho, mVar2);
        return mVar2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C0971u mo4498e(C0735d dVar) {
        C0971u uVar = this.f2623d.get(dVar.mWho);
        if (uVar != null) {
            return uVar;
        }
        C0971u uVar2 = new C0971u();
        this.f2623d.put(dVar.mWho, uVar2);
        return uVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0770m mVar = (C0770m) obj;
        return this.f2621b.equals(mVar.f2621b) && this.f2622c.equals(mVar.f2622c) && this.f2623d.equals(mVar.f2623d);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo4500f(C0735d dVar) {
        if (C0753k.f2551b) {
            Log.d("FragmentManager", "Clearing non-config state for " + dVar);
        }
        C0770m mVar = this.f2622c.get(dVar.mWho);
        if (mVar != null) {
            mVar.mo4491a();
            this.f2622c.remove(dVar.mWho);
        }
        C0971u uVar = this.f2623d.get(dVar.mWho);
        if (uVar != null) {
            uVar.mo5146a();
            this.f2623d.remove(dVar.mWho);
        }
    }

    public int hashCode() {
        return (((this.f2621b.hashCode() * 31) + this.f2622c.hashCode()) * 31) + this.f2623d.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<C0735d> it = this.f2621b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f2622c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f2623d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
