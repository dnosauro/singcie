package com.google.android.gms.internal.ads;

import java.util.List;

final /* synthetic */ class zzcly implements Runnable {
    private final String zzdgv;
    private final zzclp zzglj;
    private final zzdoe zzglo;
    private final zzajb zzglp;
    private final List zzglq;

    zzcly(zzclp zzclp, zzdoe zzdoe, zzajb zzajb, List list, String str) {
        this.zzglj = zzclp;
        this.zzglo = zzdoe;
        this.zzglp = zzajb;
        this.zzglq = list;
        this.zzdgv = str;
    }

    public final void run() {
        this.zzglj.zza(this.zzglo, this.zzglp, this.zzglq, this.zzdgv);
    }
}
