package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzdsw implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final Object lock = new Object();
    private boolean zzgnf = false;
    private boolean zzgng = false;
    private final zzdts zzhqi;
    private final zzdti zzhqj;

    zzdsw(Context context, Looper looper, zzdti zzdti) {
        this.zzhqj = zzdti;
        this.zzhqi = new zzdts(context, looper, this, this, 12800000);
    }

    private final void zzara() {
        synchronized (this.lock) {
            if (this.zzhqi.isConnected() || this.zzhqi.isConnecting()) {
                this.zzhqi.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(android.os.Bundle r4) {
        /*
            r3 = this;
            java.lang.Object r4 = r3.lock
            monitor-enter(r4)
            boolean r0 = r3.zzgng     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            return
        L_0x0009:
            r0 = 1
            r3.zzgng = r0     // Catch:{ all -> 0x002b }
            com.google.android.gms.internal.ads.zzdts r0 = r3.zzhqi     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            com.google.android.gms.internal.ads.zzdtv r0 = r0.zzaxq()     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            com.google.android.gms.internal.ads.zzdtq r1 = new com.google.android.gms.internal.ads.zzdtq     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            com.google.android.gms.internal.ads.zzdti r2 = r3.zzhqj     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            byte[] r2 = r2.toByteArray()     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            r0.zza((com.google.android.gms.internal.ads.zzdtq) r1)     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
        L_0x0020:
            r3.zzara()     // Catch:{ all -> 0x002b }
            goto L_0x0029
        L_0x0024:
            r0 = move-exception
            r3.zzara()     // Catch:{ all -> 0x002b }
            throw r0     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsw.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public final void onConnectionSuspended(int i) {
    }

    /* access modifiers changed from: package-private */
    public final void zzaxh() {
        synchronized (this.lock) {
            if (!this.zzgnf) {
                this.zzgnf = true;
                this.zzhqi.checkAvailabilityAndConnect();
            }
        }
    }
}
