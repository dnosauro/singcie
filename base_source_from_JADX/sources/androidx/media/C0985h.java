package androidx.media;

import android.text.TextUtils;
import androidx.core.p029g.C0582c;
import androidx.media.C0979e;

/* renamed from: androidx.media.h */
class C0985h {

    /* renamed from: a */
    private static final boolean f3132a = C0979e.f3128a;

    /* renamed from: androidx.media.h$a */
    static class C0986a implements C0979e.C0981b {

        /* renamed from: a */
        private String f3133a;

        /* renamed from: b */
        private int f3134b;

        /* renamed from: c */
        private int f3135c;

        C0986a(String str, int i, int i2) {
            this.f3133a = str;
            this.f3134b = i;
            this.f3135c = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0986a)) {
                return false;
            }
            C0986a aVar = (C0986a) obj;
            return TextUtils.equals(this.f3133a, aVar.f3133a) && this.f3134b == aVar.f3134b && this.f3135c == aVar.f3135c;
        }

        public int hashCode() {
            return C0582c.m2255a(this.f3133a, Integer.valueOf(this.f3134b), Integer.valueOf(this.f3135c));
        }
    }
}
