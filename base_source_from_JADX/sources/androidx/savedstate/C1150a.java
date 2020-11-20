package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.C0947e;
import androidx.p004a.p005a.p007b.C0044b;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
/* renamed from: androidx.savedstate.a */
public final class C1150a {

    /* renamed from: a */
    boolean f3619a = true;

    /* renamed from: b */
    private C0044b<String, C1152b> f3620b = new C0044b<>();

    /* renamed from: c */
    private Bundle f3621c;

    /* renamed from: d */
    private boolean f3622d;

    /* renamed from: androidx.savedstate.a$a */
    public interface C1151a {
        /* renamed from: a */
        void mo6202a(C1154c cVar);
    }

    /* renamed from: androidx.savedstate.a$b */
    public interface C1152b {
        /* renamed from: a */
        Bundle mo6203a();
    }

    C1150a() {
    }

    /* renamed from: a */
    public Bundle mo6199a(String str) {
        if (this.f3622d) {
            Bundle bundle = this.f3621c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            this.f3621c.remove(str);
            if (this.f3621c.isEmpty()) {
                this.f3621c = null;
            }
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6200a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f3621c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C0044b<K, V>.d c = this.f3620b.mo637c();
        while (c.hasNext()) {
            Map.Entry entry = (Map.Entry) c.next();
            bundle2.putBundle((String) entry.getKey(), ((C1152b) entry.getValue()).mo6203a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6201a(C0947e eVar, Bundle bundle) {
        if (!this.f3622d) {
            if (bundle != null) {
                this.f3621c = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            eVar.mo5112a(new SavedStateRegistry$1(this));
            this.f3622d = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }
}
