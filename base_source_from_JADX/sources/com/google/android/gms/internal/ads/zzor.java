package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public final class zzor implements zzol {
    private final boolean zzbit;
    private final int zzbiu;
    private final byte[] zzbiv;
    private final zzoi[] zzbiw;
    private int zzbix;
    private int zzbiy;
    private int zzbiz;
    private zzoi[] zzbja;

    public zzor(boolean z, int i) {
        this(true, PKIFailureInfo.notAuthorized, 0);
    }

    private zzor(boolean z, int i, int i2) {
        zzpc.checkArgument(true);
        zzpc.checkArgument(true);
        this.zzbit = true;
        this.zzbiu = PKIFailureInfo.notAuthorized;
        this.zzbiz = 0;
        this.zzbja = new zzoi[100];
        this.zzbiv = null;
        this.zzbiw = new zzoi[1];
    }

    public final synchronized void reset() {
        if (this.zzbit) {
            zzbf(0);
        }
    }

    public final synchronized void zza(zzoi zzoi) {
        this.zzbiw[0] = zzoi;
        zza(this.zzbiw);
    }

    public final synchronized void zza(zzoi[] zzoiArr) {
        boolean z;
        if (this.zzbiz + zzoiArr.length >= this.zzbja.length) {
            this.zzbja = (zzoi[]) Arrays.copyOf(this.zzbja, Math.max(this.zzbja.length << 1, this.zzbiz + zzoiArr.length));
        }
        for (zzoi zzoi : zzoiArr) {
            if (zzoi.data != null) {
                if (zzoi.data.length != this.zzbiu) {
                    z = false;
                    zzpc.checkArgument(z);
                    zzoi[] zzoiArr2 = this.zzbja;
                    int i = this.zzbiz;
                    this.zzbiz = i + 1;
                    zzoiArr2[i] = zzoi;
                }
            }
            z = true;
            zzpc.checkArgument(z);
            zzoi[] zzoiArr22 = this.zzbja;
            int i2 = this.zzbiz;
            this.zzbiz = i2 + 1;
            zzoiArr22[i2] = zzoi;
        }
        this.zzbiy -= zzoiArr.length;
        notifyAll();
    }

    public final synchronized void zzbf(int i) {
        boolean z = i < this.zzbix;
        this.zzbix = i;
        if (z) {
            zzn();
        }
    }

    public final synchronized zzoi zzin() {
        zzoi zzoi;
        this.zzbiy++;
        if (this.zzbiz > 0) {
            zzoi[] zzoiArr = this.zzbja;
            int i = this.zzbiz - 1;
            this.zzbiz = i;
            zzoi = zzoiArr[i];
            this.zzbja[this.zzbiz] = null;
        } else {
            zzoi = new zzoi(new byte[this.zzbiu], 0);
        }
        return zzoi;
    }

    public final int zzio() {
        return this.zzbiu;
    }

    public final synchronized int zzir() {
        return this.zzbiy * this.zzbiu;
    }

    public final synchronized void zzn() {
        int max = Math.max(0, zzpt.zzf(this.zzbix, this.zzbiu) - this.zzbiy);
        if (max < this.zzbiz) {
            Arrays.fill(this.zzbja, max, this.zzbiz, (Object) null);
            this.zzbiz = max;
        }
    }
}
