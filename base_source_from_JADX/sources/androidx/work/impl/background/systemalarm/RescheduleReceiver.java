package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.C1196h;
import androidx.work.impl.C1289h;

public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f3894a = C1196h.m4737a("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        C1196h.m4736a().mo6418b(f3894a, String.format("Received intent %s", new Object[]{intent}), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                C1289h.m5059b(context).mo6587a(goAsync());
            } catch (IllegalStateException unused) {
                C1196h.m4736a().mo6421e(f3894a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", new Throwable[0]);
            }
        } else {
            context.startService(C1263b.m4974b(context));
        }
    }
}
