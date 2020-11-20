package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import androidx.media.C0983g;
import androidx.media.C0985h;

/* renamed from: androidx.media.e */
public final class C0979e {

    /* renamed from: a */
    static final boolean f3128a = Log.isLoggable("MediaSessionManager", 3);

    /* renamed from: b */
    private static final Object f3129b = new Object();

    /* renamed from: androidx.media.e$a */
    public static final class C0980a {

        /* renamed from: a */
        C0981b f3130a;

        public C0980a(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f3130a = new C0983g.C0984a(remoteUserInfo);
        }

        public C0980a(String str, int i, int i2) {
            this.f3130a = Build.VERSION.SDK_INT >= 28 ? new C0983g.C0984a(str, i, i2) : new C0985h.C0986a(str, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0980a)) {
                return false;
            }
            return this.f3130a.equals(((C0980a) obj).f3130a);
        }

        public int hashCode() {
            return this.f3130a.hashCode();
        }
    }

    /* renamed from: androidx.media.e$b */
    interface C0981b {
    }
}
