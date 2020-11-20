package com.google.android.gms.internal.ads;

public final class zzcpx {
    private int responseCode = 0;
    private long zzgpc = 0;
    private long zzgpd = 0;
    private long zzgpe = 0;
    private final Object zzgpf = new Object();
    private final Object zzgpg = new Object();
    private final Object zzgph = new Object();
    private final Object zzgpi = new Object();

    public final int getResponseCode() {
        int i;
        synchronized (this.zzgpf) {
            i = this.responseCode;
        }
        return i;
    }

    public final long zzard() {
        long j;
        synchronized (this.zzgpg) {
            j = this.zzgpc;
        }
        return j;
    }

    public final synchronized long zzare() {
        long j;
        synchronized (this.zzgph) {
            j = this.zzgpd;
        }
        return j;
    }

    public final synchronized long zzarf() {
        long j;
        synchronized (this.zzgpi) {
            j = this.zzgpe;
        }
        return j;
    }

    public final void zzea(int i) {
        synchronized (this.zzgpf) {
            this.responseCode = i;
        }
    }

    public final void zzeq(long j) {
        synchronized (this.zzgpg) {
            this.zzgpc = j;
        }
    }

    public final synchronized void zzer(long j) {
        synchronized (this.zzgpi) {
            this.zzgpe = j;
        }
    }

    public final synchronized void zzfe(long j) {
        synchronized (this.zzgph) {
            this.zzgpd = j;
        }
    }
}
