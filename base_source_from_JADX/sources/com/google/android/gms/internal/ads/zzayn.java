package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import javax.annotation.concurrent.GuardedBy;

public final class zzayn {
    private final Object lock = new Object();
    @VisibleForTesting
    private long zzebn = -1;
    @VisibleForTesting
    private long zzebo = -1;
    @GuardedBy("lock")
    @VisibleForTesting
    private int zzebp = -1;
    @VisibleForTesting
    int zzebq = -1;
    @VisibleForTesting
    private long zzebr = 0;
    @VisibleForTesting
    private final String zzebs;
    private final zzf zzebt;
    @GuardedBy("lock")
    @VisibleForTesting
    private int zzebu = 0;
    @GuardedBy("lock")
    @VisibleForTesting
    private int zzebv = 0;

    public zzayn(String str, zzf zzf) {
        this.zzebs = str;
        this.zzebt = zzf;
    }

    private static boolean zzak(Context context) {
        Context zzy = zzauc.zzy(context);
        int identifier = zzy.getResources().getIdentifier("Theme.Translucent", "style", AbstractSpiCall.ANDROID_CLIENT_TYPE);
        if (identifier != 0) {
            try {
                if (identifier == zzy.getPackageManager().getActivityInfo(new ComponentName(zzy.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                    return true;
                }
                zzd.zzez("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
                zzd.zzfa("Fail to fetch AdActivity theme");
            }
        }
        zzd.zzez("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0077, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzvk r11, long r12) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.lock
            monitor-enter(r0)
            com.google.android.gms.ads.internal.util.zzf r1 = r10.zzebt     // Catch:{ all -> 0x0078 }
            long r1 = r1.zzxw()     // Catch:{ all -> 0x0078 }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ all -> 0x0078 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0078 }
            long r5 = r10.zzebo     // Catch:{ all -> 0x0078 }
            r7 = -1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x003f
            long r1 = r3 - r1
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r5 = com.google.android.gms.internal.ads.zzabf.zzcop     // Catch:{ all -> 0x0078 }
            com.google.android.gms.internal.ads.zzabb r6 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x0078 }
            java.lang.Object r5 = r6.zzd(r5)     // Catch:{ all -> 0x0078 }
            java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x0078 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0078 }
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0033
            r1 = -1
            r10.zzebq = r1     // Catch:{ all -> 0x0078 }
            goto L_0x003b
        L_0x0033:
            com.google.android.gms.ads.internal.util.zzf r1 = r10.zzebt     // Catch:{ all -> 0x0078 }
            int r1 = r1.zzxx()     // Catch:{ all -> 0x0078 }
            r10.zzebq = r1     // Catch:{ all -> 0x0078 }
        L_0x003b:
            r10.zzebo = r12     // Catch:{ all -> 0x0078 }
            long r12 = r10.zzebo     // Catch:{ all -> 0x0078 }
        L_0x003f:
            r10.zzebn = r12     // Catch:{ all -> 0x0078 }
            r12 = 1
            if (r11 == 0) goto L_0x0055
            android.os.Bundle r13 = r11.extras     // Catch:{ all -> 0x0078 }
            if (r13 == 0) goto L_0x0055
            android.os.Bundle r11 = r11.extras     // Catch:{ all -> 0x0078 }
            java.lang.String r13 = "gw"
            r1 = 2
            int r11 = r11.getInt(r13, r1)     // Catch:{ all -> 0x0078 }
            if (r11 != r12) goto L_0x0055
            monitor-exit(r0)     // Catch:{ all -> 0x0078 }
            return
        L_0x0055:
            int r11 = r10.zzebp     // Catch:{ all -> 0x0078 }
            int r11 = r11 + r12
            r10.zzebp = r11     // Catch:{ all -> 0x0078 }
            int r11 = r10.zzebq     // Catch:{ all -> 0x0078 }
            int r11 = r11 + r12
            r10.zzebq = r11     // Catch:{ all -> 0x0078 }
            int r11 = r10.zzebq     // Catch:{ all -> 0x0078 }
            if (r11 != 0) goto L_0x006d
            r11 = 0
            r10.zzebr = r11     // Catch:{ all -> 0x0078 }
            com.google.android.gms.ads.internal.util.zzf r11 = r10.zzebt     // Catch:{ all -> 0x0078 }
            r11.zzfa(r3)     // Catch:{ all -> 0x0078 }
            goto L_0x0076
        L_0x006d:
            com.google.android.gms.ads.internal.util.zzf r11 = r10.zzebt     // Catch:{ all -> 0x0078 }
            long r11 = r11.zzxy()     // Catch:{ all -> 0x0078 }
            long r3 = r3 - r11
            r10.zzebr = r3     // Catch:{ all -> 0x0078 }
        L_0x0076:
            monitor-exit(r0)     // Catch:{ all -> 0x0078 }
            return
        L_0x0078:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0078 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayn.zza(com.google.android.gms.internal.ads.zzvk, long):void");
    }

    public final Bundle zzn(Context context, String str) {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzebs);
            bundle.putLong("basets", this.zzebo);
            bundle.putLong("currts", this.zzebn);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzebp);
            bundle.putInt("preqs_in_session", this.zzebq);
            bundle.putLong("time_in_session", this.zzebr);
            bundle.putInt("pclick", this.zzebu);
            bundle.putInt("pimp", this.zzebv);
            bundle.putBoolean("support_transparent_background", zzak(context));
        }
        return bundle;
    }

    public final void zzwp() {
        synchronized (this.lock) {
            this.zzebv++;
        }
    }

    public final void zzwq() {
        synchronized (this.lock) {
            this.zzebu++;
        }
    }
}
