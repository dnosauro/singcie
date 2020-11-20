package androidx.work;

import android.os.Build;
import androidx.work.C1338p;

/* renamed from: androidx.work.j */
public final class C1324j extends C1338p {

    /* renamed from: androidx.work.j$a */
    public static final class C1325a extends C1338p.C1339a<C1325a, C1324j> {
        public C1325a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f4126c.f3840d = OverwritingInputMerger.class.getName();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public C1324j mo6671d() {
            if (!this.f4124a || Build.VERSION.SDK_INT < 23 || !this.f4126c.f3846j.mo6386c()) {
                return new C1324j(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public C1325a mo6670c() {
            return this;
        }
    }

    C1324j(C1325a aVar) {
        super(aVar.f4125b, aVar.f4126c, aVar.f4127d);
    }
}
