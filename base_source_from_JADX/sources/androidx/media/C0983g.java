package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.core.p029g.C0582c;
import androidx.media.C0979e;

/* renamed from: androidx.media.g */
class C0983g extends C0982f {

    /* renamed from: androidx.media.g$a */
    static final class C0984a implements C0979e.C0981b {

        /* renamed from: a */
        final MediaSessionManager.RemoteUserInfo f3131a;

        C0984a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f3131a = remoteUserInfo;
        }

        C0984a(String str, int i, int i2) {
            this.f3131a = new MediaSessionManager.RemoteUserInfo(str, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0984a)) {
                return false;
            }
            return this.f3131a.equals(((C0984a) obj).f3131a);
        }

        public int hashCode() {
            return C0582c.m2255a(this.f3131a);
        }
    }
}
