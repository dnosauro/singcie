package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdkp {
    public static zzdkl<zzblg, zzbll> zza(Context context, zzdpa zzdpa, zzdpr zzdpr) {
        return zzc(context, zzdpa, zzdpr);
    }

    public static zzdkl<zzblp, zzblv> zzb(Context context, zzdpa zzdpa, zzdpr zzdpr) {
        return zzc(context, zzdpa, zzdpr);
    }

    private static <AppOpenAdRequestComponent extends zzbre<AppOpenAd>, AppOpenAd extends zzboc> zzdkl<AppOpenAdRequestComponent, AppOpenAd> zzc(Context context, zzdpa zzdpa, zzdpr zzdpr) {
        if (((Integer) zzwq.zzqe().zzd(zzabf.zzcxp)).intValue() <= 0) {
            return new zzdkd();
        }
        zzdpu zza = zzdpr.zza(zzdpj.AppOpen, context, zzdpa, new zzdjt(new zzdjk()));
        return new zzdjp(new zzdkc(new zzdkd()), new zzdju(zza.zzhez, zzazj.zzegp), zza.zzhmg, zzazj.zzegp);
    }
}
