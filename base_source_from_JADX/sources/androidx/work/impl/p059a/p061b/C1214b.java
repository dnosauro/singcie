package androidx.work.impl.p059a.p061b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.C1196h;
import androidx.work.impl.utils.p065b.C1311a;
import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: androidx.work.impl.a.b.b */
public class C1214b extends C1215c<Boolean> {

    /* renamed from: d */
    private static final String f3788d = C1196h.m4737a("BatteryNotLowTracker");

    public C1214b(Context context, C1311a aVar) {
        super(context, aVar);
    }

    /* renamed from: a */
    public Boolean mo6460c() {
        Intent registerReceiver = this.f3794b.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            C1196h.m4736a().mo6421e(f3788d, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        int intExtra = registerReceiver.getIntExtra("plugged", 0);
        int intExtra2 = registerReceiver.getIntExtra("status", -1);
        float intExtra3 = ((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
        boolean z = true;
        if (intExtra == 0 && intExtra2 != 1 && intExtra3 <= 0.15f) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: a */
    public void mo6458a(Context context, Intent intent) {
        boolean z;
        if (intent.getAction() != null) {
            C1196h.m4736a().mo6418b(f3788d, String.format("Received %s", new Object[]{intent.getAction()}), new Throwable[0]);
            String action = intent.getAction();
            char c = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -1980154005) {
                if (hashCode == 490310653 && action.equals("android.intent.action.BATTERY_LOW")) {
                    c = 1;
                }
            } else if (action.equals("android.intent.action.BATTERY_OKAY")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    z = true;
                    break;
                case 1:
                    z = false;
                    break;
                default:
                    return;
            }
            mo6466a(z);
        }
    }

    /* renamed from: b */
    public IntentFilter mo6459b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }
}
