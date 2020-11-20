package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;

final /* synthetic */ class zzdfk implements Runnable {
    private final zzdfi zzhbm;
    private final long zzhbn;

    zzdfk(zzdfi zzdfi, long j) {
        this.zzhbm = zzdfi;
        this.zzhbn = j;
    }

    public final void run() {
        zzdfi zzdfi = this.zzhbm;
        long j = this.zzhbn;
        String canonicalName = zzdfi.getClass().getCanonicalName();
        long elapsedRealtime = zzp.zzkx().elapsedRealtime() - j;
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
        sb.append("Signal runtime : ");
        sb.append(canonicalName);
        sb.append(" = ");
        sb.append(elapsedRealtime);
        zzd.zzee(sb.toString());
    }
}
