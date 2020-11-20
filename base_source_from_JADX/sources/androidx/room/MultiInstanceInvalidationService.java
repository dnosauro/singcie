package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.p018c.C0414h;
import androidx.room.C1120d;

public class MultiInstanceInvalidationService extends Service {

    /* renamed from: a */
    int f3472a = 0;

    /* renamed from: b */
    final C0414h<String> f3473b = new C0414h<>();

    /* renamed from: c */
    final RemoteCallbackList<C1117c> f3474c = new RemoteCallbackList<C1117c>() {
        /* renamed from: a */
        public void onCallbackDied(C1117c cVar, Object obj) {
            MultiInstanceInvalidationService.this.f3473b.mo2972b(((Integer) obj).intValue());
        }
    };

    /* renamed from: d */
    private final C1120d.C1121a f3475d = new C1120d.C1121a() {
        /* renamed from: a */
        public int mo6102a(C1117c cVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f3474c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.f3472a + 1;
                multiInstanceInvalidationService.f3472a = i;
                if (MultiInstanceInvalidationService.this.f3474c.register(cVar, Integer.valueOf(i))) {
                    MultiInstanceInvalidationService.this.f3473b.mo2976c(i, str);
                    return i;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f3472a--;
                return 0;
            }
        }

        /* renamed from: a */
        public void mo6103a(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f3474c) {
                String a = MultiInstanceInvalidationService.this.f3473b.mo2969a(i);
                if (a == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.f3474c.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.f3474c.getBroadcastCookie(i2)).intValue();
                        String a2 = MultiInstanceInvalidationService.this.f3473b.mo2969a(intValue);
                        if (i != intValue && a.equals(a2)) {
                            MultiInstanceInvalidationService.this.f3474c.getBroadcastItem(i2).mo6124a(strArr);
                        }
                    } catch (RemoteException e) {
                        Log.w("ROOM", "Error invoking a remote callback", e);
                    } catch (Throwable th) {
                        MultiInstanceInvalidationService.this.f3474c.finishBroadcast();
                        throw th;
                    }
                }
                MultiInstanceInvalidationService.this.f3474c.finishBroadcast();
            }
        }

        /* renamed from: a */
        public void mo6104a(C1117c cVar, int i) {
            synchronized (MultiInstanceInvalidationService.this.f3474c) {
                MultiInstanceInvalidationService.this.f3474c.unregister(cVar);
                MultiInstanceInvalidationService.this.f3473b.mo2972b(i);
            }
        }
    };

    public IBinder onBind(Intent intent) {
        return this.f3475d;
    }
}
