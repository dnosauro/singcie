package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdet implements zzdfi<zzdeq> {
    private final Context context;
    private final zzawx zzbql;
    private final zzdzc zzggb;

    public zzdet(zzawx zzawx, zzdzc zzdzc, Context context2) {
        this.zzbql = zzawx;
        this.zzggb = zzdzc;
        this.context = context2;
    }

    public final zzdyz<zzdeq> zzasm() {
        return this.zzggb.zze(new zzdes(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdeq zzatb() {
        Long l;
        if (!this.zzbql.zzz(this.context)) {
            return new zzdeq((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zzac = this.zzbql.zzac(this.context);
        if (zzac == null) {
            zzac = "";
        }
        String str = zzac;
        String zzad = this.zzbql.zzad(this.context);
        if (zzad == null) {
            zzad = "";
        }
        String str2 = zzad;
        String zzae = this.zzbql.zzae(this.context);
        if (zzae == null) {
            zzae = "";
        }
        String str3 = zzae;
        String zzaf = this.zzbql.zzaf(this.context);
        if (zzaf == null) {
            zzaf = "";
        }
        String str4 = zzaf;
        if ("TIME_OUT".equals(str2)) {
            l = (Long) zzwq.zzqe().zzd(zzabf.zzcnq);
        } else {
            l = null;
        }
        return new zzdeq(str, str2, str3, str4, l);
    }
}
