package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.C1117c;
import androidx.room.C1120d;
import androidx.room.C1124f;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: androidx.room.g */
class C1129g {

    /* renamed from: a */
    Context f3543a;

    /* renamed from: b */
    final String f3544b;

    /* renamed from: c */
    int f3545c;

    /* renamed from: d */
    final C1124f f3546d;

    /* renamed from: e */
    final C1124f.C1127b f3547e;

    /* renamed from: f */
    C1120d f3548f;

    /* renamed from: g */
    final Executor f3549g;

    /* renamed from: h */
    final C1117c f3550h = new C1117c.C1118a() {
        /* renamed from: a */
        public void mo6124a(final String[] strArr) {
            C1129g.this.f3549g.execute(new Runnable() {
                public void run() {
                    C1129g.this.f3546d.mo6134a(strArr);
                }
            });
        }
    };

    /* renamed from: i */
    final AtomicBoolean f3551i = new AtomicBoolean(false);

    /* renamed from: j */
    final ServiceConnection f3552j = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C1129g.this.f3548f = C1120d.C1121a.m4428a(iBinder);
            C1129g.this.f3549g.execute(C1129g.this.f3553k);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            C1129g.this.f3549g.execute(C1129g.this.f3554l);
            C1129g gVar = C1129g.this;
            gVar.f3548f = null;
            gVar.f3543a = null;
        }
    };

    /* renamed from: k */
    final Runnable f3553k = new Runnable() {
        public void run() {
            try {
                C1120d dVar = C1129g.this.f3548f;
                if (dVar != null) {
                    C1129g.this.f3545c = dVar.mo6102a(C1129g.this.f3550h, C1129g.this.f3544b);
                    C1129g.this.f3546d.mo6133a(C1129g.this.f3547e);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e);
            }
        }
    };

    /* renamed from: l */
    final Runnable f3554l = new Runnable() {
        public void run() {
            C1129g.this.f3546d.mo6138b(C1129g.this.f3547e);
        }
    };

    /* renamed from: m */
    private final Runnable f3555m = new Runnable() {
        public void run() {
            C1129g.this.f3546d.mo6138b(C1129g.this.f3547e);
            try {
                C1120d dVar = C1129g.this.f3548f;
                if (dVar != null) {
                    dVar.mo6104a(C1129g.this.f3550h, C1129g.this.f3545c);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e);
            }
            if (C1129g.this.f3543a != null) {
                C1129g.this.f3543a.unbindService(C1129g.this.f3552j);
                C1129g.this.f3543a = null;
            }
        }
    };

    C1129g(Context context, String str, C1124f fVar, Executor executor) {
        this.f3543a = context.getApplicationContext();
        this.f3544b = str;
        this.f3546d = fVar;
        this.f3549g = executor;
        this.f3547e = new C1124f.C1127b(fVar.f3521b) {
            /* renamed from: a */
            public void mo6145a(Set<String> set) {
                if (!C1129g.this.f3551i.get()) {
                    try {
                        C1129g.this.f3548f.mo6103a(C1129g.this.f3545c, (String[]) set.toArray(new String[0]));
                    } catch (RemoteException e) {
                        Log.w("ROOM", "Cannot broadcast invalidation", e);
                    }
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: a */
            public boolean mo6146a() {
                return true;
            }
        };
        this.f3543a.bindService(new Intent(this.f3543a, MultiInstanceInvalidationService.class), this.f3552j, 1);
    }
}
