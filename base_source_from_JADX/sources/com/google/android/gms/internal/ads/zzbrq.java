package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbrq implements zzepf<zzawq> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdmu> zzfrp;
    private final zzbrr zzfxp;
    private final zzeps<zzazh> zzfxq;
    private final zzeps<zzaws> zzfxr;

    private zzbrq(zzbrr zzbrr, zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzaws> zzeps4) {
        this.zzfxp = zzbrr;
        this.zzevi = zzeps;
        this.zzfxq = zzeps2;
        this.zzfrp = zzeps3;
        this.zzfxr = zzeps4;
    }

    public static zzbrq zza(zzbrr zzbrr, zzeps<Context> zzeps, zzeps<zzazh> zzeps2, zzeps<zzdmu> zzeps3, zzeps<zzaws> zzeps4) {
        return new zzbrq(zzbrr, zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        Context context = this.zzevi.get();
        zzazh zzazh = this.zzfxq.get();
        zzdmu zzdmu = this.zzfrp.get();
        zzaws zzaws = this.zzfxr.get();
        if (zzdmu.zzhhb != null) {
            return new zzawh(context, zzazh, zzdmu.zzhhb, zzdmu.zzhgx.zzdrn, zzaws);
        }
        return null;
    }
}
