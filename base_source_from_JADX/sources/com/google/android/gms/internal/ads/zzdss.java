package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.p002v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcf;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
final class zzdss implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final String packageName;
    private final HandlerThread zzefd = new HandlerThread("GassClient");
    @VisibleForTesting
    private zzdts zzhpx;
    private final String zzhpy;
    private final LinkedBlockingQueue<zzcf.zza> zzhpz;

    public zzdss(Context context, String str, String str2) {
        this.packageName = str;
        this.zzhpy = str2;
        this.zzefd.start();
        this.zzhpx = new zzdts(context, this.zzefd.getLooper(), this, this, 9200000);
        this.zzhpz = new LinkedBlockingQueue<>();
        this.zzhpx.checkAvailabilityAndConnect();
    }

    private final void zzara() {
        zzdts zzdts = this.zzhpx;
        if (zzdts == null) {
            return;
        }
        if (zzdts.isConnected() || this.zzhpx.isConnecting()) {
            this.zzhpx.disconnect();
        }
    }

    private final zzdtv zzaxb() {
        try {
            return this.zzhpx.zzaxq();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @VisibleForTesting
    private static zzcf.zza zzaxc() {
        return (zzcf.zza) ((zzekh) zzcf.zza.zzaq().zzn(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID).zzbhv());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        zzara();
        r3.zzefd.quit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0025, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0027 */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0025 A[ExcHandler: all (r4v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:2:0x0006] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(android.os.Bundle r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzdtv r4 = r3.zzaxb()
            if (r4 == 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzdtr r0 = new com.google.android.gms.internal.ads.zzdtr     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.lang.String r1 = r3.packageName     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.lang.String r2 = r3.zzhpy     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            r0.<init>(r1, r2)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdtt r4 = r4.zza((com.google.android.gms.internal.ads.zzdtr) r0)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzcf$zza r4 = r4.zzaxr()     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzcf$zza> r0 = r3.zzhpz     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
            r0.put(r4)     // Catch:{ Throwable -> 0x0027, all -> 0x0025 }
        L_0x001c:
            r3.zzara()
            android.os.HandlerThread r4 = r3.zzefd
            r4.quit()
            return
        L_0x0025:
            r4 = move-exception
            goto L_0x0031
        L_0x0027:
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzcf$zza> r4 = r3.zzhpz     // Catch:{ InterruptedException -> 0x001c, all -> 0x0025 }
            com.google.android.gms.internal.ads.zzcf$zza r0 = zzaxc()     // Catch:{ InterruptedException -> 0x001c, all -> 0x0025 }
            r4.put(r0)     // Catch:{ InterruptedException -> 0x001c, all -> 0x0025 }
            goto L_0x001c
        L_0x0031:
            r3.zzara()
            android.os.HandlerThread r0 = r3.zzefd
            r0.quit()
            throw r4
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdss.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzhpz.put(zzaxc());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            this.zzhpz.put(zzaxc());
        } catch (InterruptedException unused) {
        }
    }

    public final zzcf.zza zzef(int i) {
        zzcf.zza zza;
        try {
            zza = this.zzhpz.poll(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zza = null;
        }
        return zza == null ? zzaxc() : zza;
    }
}
