package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;

final /* synthetic */ class zzbmk implements zzbtj {
    private final Context zzclq;
    private final zzazh zzftn;
    private final zzdmu zzfto;
    private final zzdnn zzftp;

    zzbmk(Context context, zzazh zzazh, zzdmu zzdmu, zzdnn zzdnn) {
        this.zzclq = context;
        this.zzftn = zzazh;
        this.zzfto = zzdmu;
        this.zzftp = zzdnn;
    }

    public final void onAdLoaded() {
        zzp.zzla().zzb(this.zzclq, this.zzftn.zzbrf, this.zzfto.zzhhc.toString(), this.zzftp.zzhip);
    }
}
