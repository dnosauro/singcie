package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.C1188c;
import androidx.work.C1196h;
import androidx.work.C1198i;
import androidx.work.impl.p062b.C1240j;
import java.util.List;

abstract class ConstraintProxy extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f3888a = C1196h.m4737a("ConstraintProxy");

    public static class BatteryChargingProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    ConstraintProxy() {
    }

    /* renamed from: a */
    static void m4962a(Context context, List<C1240j> list) {
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        for (C1240j jVar : list) {
            C1188c cVar = jVar.f3846j;
            z |= cVar.mo6388d();
            z2 |= cVar.mo6384b();
            z3 |= cVar.mo6389e();
            z4 |= cVar.mo6377a() != C1198i.NOT_REQUIRED;
            if (z && z2 && z3 && z4) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.m4963a(context, z, z2, z3, z4));
    }

    public void onReceive(Context context, Intent intent) {
        C1196h.m4736a().mo6418b(f3888a, String.format("onReceive : %s", new Object[]{intent}), new Throwable[0]);
        context.startService(C1263b.m4970a(context));
    }
}
