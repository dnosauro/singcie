package androidx.lifecycle;

import java.util.HashMap;

/* renamed from: androidx.lifecycle.u */
public class C0971u {

    /* renamed from: a */
    private final HashMap<String, C0967s> f3114a = new HashMap<>();

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C0967s mo5145a(String str) {
        return this.f3114a.get(str);
    }

    /* renamed from: a */
    public final void mo5146a() {
        for (C0967s d : this.f3114a.values()) {
            d.mo5141d();
        }
        this.f3114a.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo5147a(String str, C0967s sVar) {
        C0967s put = this.f3114a.put(str, sVar);
        if (put != null) {
            put.mo4491a();
        }
    }
}
