package androidx.work.impl.p059a.p061b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.work.C1196h;
import androidx.work.impl.utils.p065b.C1311a;

/* renamed from: androidx.work.impl.a.b.a */
public class C1213a extends C1215c<Boolean> {

    /* renamed from: d */
    private static final String f3787d = C1196h.m4737a("BatteryChrgTracker");

    public C1213a(Context context, C1311a aVar) {
        super(context, aVar);
    }

    /* renamed from: a */
    private boolean m4818a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            int intExtra = intent.getIntExtra("status", -1);
            if (intExtra == 2 || intExtra == 5) {
                return true;
            }
        } else if (intent.getIntExtra("plugged", 0) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public Boolean mo6460c() {
        Intent registerReceiver = this.f3794b.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return Boolean.valueOf(m4818a(registerReceiver));
        }
        C1196h.m4736a().mo6421e(f3787d, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6458a(android.content.Context r6, android.content.Intent r7) {
        /*
            r5 = this;
            java.lang.String r6 = r7.getAction()
            if (r6 != 0) goto L_0x0007
            return
        L_0x0007:
            androidx.work.h r7 = androidx.work.C1196h.m4736a()
            java.lang.String r0 = f3787d
            java.lang.String r1 = "Received %s"
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r4 = 0
            r3[r4] = r6
            java.lang.String r1 = java.lang.String.format(r1, r3)
            java.lang.Throwable[] r3 = new java.lang.Throwable[r4]
            r7.mo6418b(r0, r1, r3)
            r7 = -1
            int r0 = r6.hashCode()
            r1 = -1886648615(0xffffffff8f8c06d9, float:-1.3807703E-29)
            if (r0 == r1) goto L_0x0056
            r1 = -54942926(0xfffffffffcb9a332, float:-7.711079E36)
            if (r0 == r1) goto L_0x004c
            r1 = 948344062(0x388694fe, float:6.41737E-5)
            if (r0 == r1) goto L_0x0042
            r1 = 1019184907(0x3cbf870b, float:0.023379823)
            if (r0 == r1) goto L_0x0038
            goto L_0x0060
        L_0x0038:
            java.lang.String r0 = "android.intent.action.ACTION_POWER_CONNECTED"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0060
            r6 = 2
            goto L_0x0061
        L_0x0042:
            java.lang.String r0 = "android.os.action.CHARGING"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0060
            r6 = 0
            goto L_0x0061
        L_0x004c:
            java.lang.String r0 = "android.os.action.DISCHARGING"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0060
            r6 = 1
            goto L_0x0061
        L_0x0056:
            java.lang.String r0 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0060
            r6 = 3
            goto L_0x0061
        L_0x0060:
            r6 = -1
        L_0x0061:
            switch(r6) {
                case 0: goto L_0x006a;
                case 1: goto L_0x0065;
                case 2: goto L_0x006a;
                case 3: goto L_0x0065;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x0071
        L_0x0065:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            goto L_0x006e
        L_0x006a:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)
        L_0x006e:
            r5.mo6466a(r6)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.p059a.p061b.C1213a.mo6458a(android.content.Context, android.content.Intent):void");
    }

    /* renamed from: b */
    public IntentFilter mo6459b() {
        String str;
        IntentFilter intentFilter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            str = "android.os.action.DISCHARGING";
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            str = "android.intent.action.ACTION_POWER_DISCONNECTED";
        }
        intentFilter.addAction(str);
        return intentFilter;
    }
}
