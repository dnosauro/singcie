package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.C1196h;
import androidx.work.impl.C1289h;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.utils.C1315d;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a */
    static final String f3889a = C1196h.m4737a("ConstrntProxyUpdtRecvr");

    /* renamed from: a */
    public static Intent m4963a(Context context, boolean z, boolean z2, boolean z3, boolean z4) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z2).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z3).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z4);
        return intent;
    }

    public void onReceive(final Context context, final Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            C1196h.m4736a().mo6418b(f3889a, String.format("Ignoring unknown action %s", new Object[]{action}), new Throwable[0]);
            return;
        }
        final BroadcastReceiver.PendingResult goAsync = goAsync();
        C1289h.m5059b(context).mo6596g().mo6649a(new Runnable() {
            public void run() {
                try {
                    boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                    boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                    C1196h.m4736a().mo6418b(ConstraintProxyUpdateReceiver.f3889a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", new Object[]{Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)}), new Throwable[0]);
                    C1315d.m5169a(context, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                    C1315d.m5169a(context, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                    C1315d.m5169a(context, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                    C1315d.m5169a(context, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
                } finally {
                    goAsync.finish();
                }
            }
        });
    }
}
