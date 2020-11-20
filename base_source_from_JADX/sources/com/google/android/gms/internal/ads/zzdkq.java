package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdkq implements zzepf<zzdkl<zzchf, zzchc>> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdpa> zzexm;
    private final zzeps<zzdpr> zzexn;

    public zzdkq(zzeps<Context> zzeps, zzeps<zzdpa> zzeps2, zzeps<zzdpr> zzeps3) {
        this.zzevi = zzeps;
        this.zzexm = zzeps2;
        this.zzexn = zzeps3;
    }

    public final /* synthetic */ Object get() {
        Object obj;
        Context context = this.zzevi.get();
        zzdpa zzdpa = this.zzexm.get();
        zzdpr zzdpr = this.zzexn.get();
        if (((Integer) zzwq.zzqe().zzd(zzabf.zzcxb)).intValue() > 0) {
            zzdpu zza = zzdpr.zza(zzdpj.Rewarded, context, zzdpa, new zzdjt(new zzdjk()));
            obj = new zzdjp(new zzdkc(new zzdkd()), new zzdju(zza.zzhez, zzazj.zzegp), zza.zzhmg, zzazj.zzegp);
        } else {
            obj = new zzdkd();
        }
        return (zzdkl) zzepl.zza(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
