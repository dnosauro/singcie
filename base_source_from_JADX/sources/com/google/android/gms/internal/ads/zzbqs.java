package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzag;

final /* synthetic */ class zzbqs implements zzdvm {
    private final Context zzclq;
    private final zzazh zzftn;
    private final zzdnn zzfwk;

    zzbqs(Context context, zzazh zzazh, zzdnn zzdnn) {
        this.zzclq = context;
        this.zzftn = zzazh;
        this.zzfwk = zzdnn;
    }

    public final Object apply(Object obj) {
        Context context = this.zzclq;
        zzazh zzazh = this.zzftn;
        zzdnn zzdnn = this.zzfwk;
        zzdmu zzdmu = (zzdmu) obj;
        zzag zzag = new zzag(context);
        zzag.zzep(zzdmu.zzdus);
        zzag.zzeq(zzdmu.zzhhc.toString());
        zzag.zzad(zzazh.zzbrf);
        zzag.setAdUnitId(zzdnn.zzhip);
        return zzag;
    }
}
