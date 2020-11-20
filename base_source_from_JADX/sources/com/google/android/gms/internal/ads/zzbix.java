package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;

public final class zzbix implements zzepf<zzdst> {
    private final zzeps<Context> zzevi;

    public zzbix(zzeps<Context> zzeps) {
        this.zzevi = zzeps;
    }

    public final /* synthetic */ Object get() {
        return (zzdst) zzepl.zza(new zzdst(this.zzevi.get(), zzp.zzle().zzyw()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
