package com.google.android.gms.internal.ads;

import android.view.View;

public final class zzbll extends zzboc {
    private final View view;
    private final zzbdv zzdii;
    private final zzdmx zzfrz;
    private final int zzfsa;
    private final boolean zzfsb;
    private final boolean zzfsc;
    private zzsm zzfsp;
    private final zzble zzfsq;

    zzbll(zzbob zzbob, View view2, zzbdv zzbdv, zzdmx zzdmx, int i, boolean z, boolean z2, zzble zzble) {
        super(zzbob);
        this.view = view2;
        this.zzdii = zzbdv;
        this.zzfrz = zzdmx;
        this.zzfsa = i;
        this.zzfsb = z;
        this.zzfsc = z2;
        this.zzfsq = zzble;
    }

    public final void zza(zzsc zzsc) {
        zzbdv zzbdv = this.zzdii;
        if (zzbdv != null) {
            zzbdv.zza(zzsc);
        }
    }

    public final void zza(zzsm zzsm) {
        this.zzfsp = zzsm;
    }

    public final boolean zzaby() {
        zzbdv zzbdv = this.zzdii;
        return (zzbdv == null || zzbdv.zzacs() == null || !this.zzdii.zzacs().zzaby()) ? false : true;
    }

    public final int zzaip() {
        return this.zzfsa;
    }

    public final boolean zzaiq() {
        return this.zzfsb;
    }

    public final boolean zzair() {
        return this.zzfsc;
    }

    public final zzdmx zzaiy() {
        return zzdns.zza(this.zzeri.zzhgw, this.zzfrz);
    }

    public final View zzaiz() {
        return this.view;
    }

    public final boolean zzaja() {
        zzbdv zzbdv = this.zzdii;
        return zzbdv != null && zzbdv.zzacu();
    }

    public final zzsm zzajb() {
        return this.zzfsp;
    }

    public final void zzb(long j, int i) {
        this.zzfsq.zzb(j, i);
    }
}
