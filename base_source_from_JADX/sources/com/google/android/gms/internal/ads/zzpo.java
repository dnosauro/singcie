package com.google.android.gms.internal.ads;

import android.os.SystemClock;

public final class zzpo implements zzpg {
    private boolean started;
    private zzhv zzafg = zzhv.zzahx;
    private long zzbki;
    private long zzbkj;

    public final void start() {
        if (!this.started) {
            this.zzbkj = SystemClock.elapsedRealtime();
            this.started = true;
        }
    }

    public final void stop() {
        if (this.started) {
            zzel(zzfz());
            this.started = false;
        }
    }

    public final void zza(zzpg zzpg) {
        zzel(zzpg.zzfz());
        this.zzafg = zzpg.zzfs();
    }

    public final zzhv zzb(zzhv zzhv) {
        if (this.started) {
            zzel(zzfz());
        }
        this.zzafg = zzhv;
        return zzhv;
    }

    public final void zzel(long j) {
        this.zzbki = j;
        if (this.started) {
            this.zzbkj = SystemClock.elapsedRealtime();
        }
    }

    public final zzhv zzfs() {
        return this.zzafg;
    }

    public final long zzfz() {
        long j = this.zzbki;
        if (!this.started) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzbkj;
        return j + (this.zzafg.zzahy == 1.0f ? zzhb.zzdn(elapsedRealtime) : this.zzafg.zzdu(elapsedRealtime));
    }
}
