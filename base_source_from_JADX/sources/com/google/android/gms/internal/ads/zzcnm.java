package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

final class zzcnm implements zzdyo<zzdnj> {
    private final /* synthetic */ zzcnh zzgmy;

    zzcnm(zzcnh zzcnh) {
        this.zzgmy = zzcnh;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdnj zzdnj = (zzdnj) obj;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue()) {
            this.zzgmy.zzgmu.zzea(zzdnj.zzhik.zzerj.responseCode);
            this.zzgmy.zzgmu.zzeq(zzdnj.zzhik.zzerj.zzgot);
        }
    }

    public final void zzb(Throwable th) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue()) {
            Matcher matcher = zzcnh.zzgmv.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zzgmy.zzgmu.zzea(Integer.parseInt(matcher.group(1)));
            }
        }
    }
}
