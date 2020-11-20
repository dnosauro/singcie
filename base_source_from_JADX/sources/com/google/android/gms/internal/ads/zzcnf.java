package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

final class zzcnf implements zzdyo<zzdnj> {
    private final /* synthetic */ zzcne zzgmw;

    zzcnf(zzcne zzcne) {
        this.zzgmw = zzcne;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzdnj zzdnj = (zzdnj) obj;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue()) {
            this.zzgmw.zzgmu.zzea(zzdnj.zzhik.zzerj.responseCode);
            this.zzgmw.zzgmu.zzeq(zzdnj.zzhik.zzerj.zzgot);
        }
    }

    public final void zzb(Throwable th) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcwu)).booleanValue()) {
            Matcher matcher = zzcne.zzgmv.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zzgmw.zzgmu.zzea(Integer.parseInt(matcher.group(1)));
            }
        }
    }
}
