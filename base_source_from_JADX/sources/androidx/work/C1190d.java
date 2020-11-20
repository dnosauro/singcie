package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

/* renamed from: androidx.work.d */
public final class C1190d {

    /* renamed from: a */
    private final Set<C1191a> f3749a = new HashSet();

    /* renamed from: androidx.work.d$a */
    public static final class C1191a {

        /* renamed from: a */
        private final Uri f3750a;

        /* renamed from: b */
        private final boolean f3751b;

        C1191a(Uri uri, boolean z) {
            this.f3750a = uri;
            this.f3751b = z;
        }

        /* renamed from: a */
        public Uri mo6403a() {
            return this.f3750a;
        }

        /* renamed from: b */
        public boolean mo6404b() {
            return this.f3751b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C1191a aVar = (C1191a) obj;
            return this.f3751b == aVar.f3751b && this.f3750a.equals(aVar.f3750a);
        }

        public int hashCode() {
            return (this.f3750a.hashCode() * 31) + (this.f3751b ? 1 : 0);
        }
    }

    /* renamed from: a */
    public Set<C1191a> mo6398a() {
        return this.f3749a;
    }

    /* renamed from: a */
    public void mo6399a(Uri uri, boolean z) {
        this.f3749a.add(new C1191a(uri, z));
    }

    /* renamed from: b */
    public int mo6400b() {
        return this.f3749a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f3749a.equals(((C1190d) obj).f3749a);
    }

    public int hashCode() {
        return this.f3749a.hashCode();
    }
}
