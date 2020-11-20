package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
/* renamed from: androidx.media.b */
class C0976b implements C0973a {

    /* renamed from: a */
    AudioAttributes f3122a;

    /* renamed from: b */
    int f3123b = -1;

    C0976b() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0976b)) {
            return false;
        }
        return this.f3122a.equals(((C0976b) obj).f3122a);
    }

    public int hashCode() {
        return this.f3122a.hashCode();
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3122a;
    }
}
