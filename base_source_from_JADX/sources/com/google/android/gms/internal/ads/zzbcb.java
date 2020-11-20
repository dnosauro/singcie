package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public final class zzbcb implements zzht {
    private int zzbix;
    private final zzor zzenh;
    private long zzeni;
    private long zzenj;
    private long zzenk;
    private long zzenl;
    private boolean zzenm;

    zzbcb() {
        this(15000, 30000, 2500, 5000);
    }

    private zzbcb(int i, int i2, long j, long j2) {
        this.zzenh = new zzor(true, PKIFailureInfo.notAuthorized);
        this.zzeni = 15000000;
        this.zzenj = 30000000;
        this.zzenk = 2500000;
        this.zzenl = 5000000;
    }

    @VisibleForTesting
    private final void zzk(boolean z) {
        this.zzbix = 0;
        this.zzenm = false;
        if (z) {
            this.zzenh.reset();
        }
    }

    public final void onStopped() {
        zzk(true);
    }

    public final void zza(zzhy[] zzhyArr, zznq zznq, zzoe zzoe) {
        this.zzbix = 0;
        for (int i = 0; i < zzhyArr.length; i++) {
            if (zzoe.zzbe(i) != null) {
                this.zzbix += zzpt.zzbp(zzhyArr[i].getTrackType());
            }
        }
        this.zzenh.zzbf(this.zzbix);
    }

    public final synchronized boolean zzc(long j, boolean z) {
        long j2;
        j2 = z ? this.zzenl : this.zzenk;
        return j2 <= 0 || j >= j2;
    }

    public final synchronized void zzdn(int i) {
        this.zzenk = ((long) i) * 1000;
    }

    public final synchronized void zzdo(int i) {
        this.zzenl = ((long) i) * 1000;
    }

    public final synchronized void zzdt(int i) {
        this.zzeni = ((long) i) * 1000;
    }

    public final synchronized boolean zzdt(long j) {
        boolean z = false;
        char c = j > this.zzenj ? 0 : j < this.zzeni ? (char) 2 : 1;
        boolean z2 = this.zzenh.zzir() >= this.zzbix;
        if (c == 2 || (c == 1 && this.zzenm && !z2)) {
            z = true;
        }
        this.zzenm = z;
        return this.zzenm;
    }

    public final synchronized void zzdu(int i) {
        this.zzenj = ((long) i) * 1000;
    }

    public final void zzfb() {
        zzk(false);
    }

    public final void zzfc() {
        zzk(true);
    }

    public final zzol zzfd() {
        return this.zzenh;
    }
}
