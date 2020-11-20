package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbw;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
final class zzdsu implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final long startTime;
    private final HandlerThread zzefd;
    @VisibleForTesting
    private zzdts zzhpx;
    private final LinkedBlockingQueue<zzdud> zzhpz;
    private final String zzhqb;
    private final String zzhqc;
    private final int zzhqd = 1;
    private final zzdsi zzvs;
    private final zzgn zzvu;

    public zzdsu(Context context, int i, zzgn zzgn, String str, String str2, String str3, zzdsi zzdsi) {
        this.zzhqb = str;
        this.zzvu = zzgn;
        this.zzhqc = str2;
        this.zzvs = zzdsi;
        this.zzefd = new HandlerThread("GassDGClient");
        this.zzefd.start();
        this.startTime = System.currentTimeMillis();
        this.zzhpx = new zzdts(context, this.zzefd.getLooper(), this, this, 19621000);
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
    private static zzdud zzaxd() {
        return new zzdud((byte[]) null, 1);
    }

    private final void zzb(int i, long j, Exception exc) {
        zzdsi zzdsi = this.zzvs;
        if (zzdsi != null) {
            zzdsi.zza(i, System.currentTimeMillis() - j, exc);
        }
    }

    public final void onConnected(Bundle bundle) {
        zzdtv zzaxb = zzaxb();
        if (zzaxb != null) {
            try {
                zzdud zza = zzaxb.zza(new zzdub(this.zzhqd, this.zzvu, this.zzhqb, this.zzhqc));
                zzb(5011, this.startTime, (Exception) null);
                this.zzhpz.put(zza);
            } catch (Throwable th) {
                zzara();
                this.zzefd.quit();
                throw th;
            }
            zzara();
            this.zzefd.quit();
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zzb(4012, this.startTime, (Exception) null);
            this.zzhpz.put(zzaxd());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            zzb(4011, this.startTime, (Exception) null);
            this.zzhpz.put(zzaxd());
        } catch (InterruptedException unused) {
        }
    }

    public final zzdud zzeg(int i) {
        zzdud zzdud;
        try {
            zzdud = this.zzhpz.poll(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzb(2009, this.startTime, e);
            zzdud = null;
        }
        zzb(3004, this.startTime, (Exception) null);
        if (zzdud != null) {
            zzdsi.zzb(zzdud.status == 7 ? zzbw.zza.zzc.DISABLED : zzbw.zza.zzc.ENABLED);
        }
        return zzdud == null ? zzaxd() : zzdud;
    }
}
