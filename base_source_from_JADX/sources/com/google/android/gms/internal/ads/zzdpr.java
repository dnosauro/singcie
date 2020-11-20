package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

public final class zzdpr {
    private HashMap<zzdpj, zzdpu<? extends zzboc>> zzhmf = new HashMap<>();

    public final <AdT extends zzboc> zzdpu<AdT> zza(zzdpj zzdpj, Context context, zzdpa zzdpa, zzdqc<AdT> zzdqc) {
        zzdpu<AdT> zzdpu = this.zzhmf.get(zzdpj);
        if (zzdpu != null) {
            return zzdpu;
        }
        zzdpg zzdpg = new zzdpg(zzdpk.zza(zzdpj, context));
        zzdpu<AdT> zzdpu2 = new zzdpu<>(zzdpg, new zzdpv(zzdpg, zzdpa, zzdqc));
        this.zzhmf.put(zzdpj, zzdpu2);
        return zzdpu2;
    }
}
