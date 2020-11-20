package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdgq implements zzdfi<zzdgr> {
    Context context;
    private zzdzc zzggb;
    zzth zzhcj;

    public zzdgq(zzth zzth, zzdzc zzdzc, Context context2) {
        this.zzhcj = zzth;
        this.zzggb = zzdzc;
        this.context = context2;
    }

    public final zzdyz<zzdgr> zzasm() {
        return this.zzggb.zze(new zzdgt(this));
    }
}
