package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcsv implements zzcqz<zzbyx> {
    private final Context context;
    private final zzazh zzbos;
    private final Executor zzfqx;
    private final zzdnn zzfvl;
    private final zzchp zzgey;
    private final zzbzx zzgrt;

    public zzcsv(Context context2, zzazh zzazh, zzdnn zzdnn, Executor executor, zzbzx zzbzx, zzchp zzchp) {
        this.context = context2;
        this.zzfvl = zzdnn;
        this.zzgrt = zzbzx;
        this.zzfqx = executor;
        this.zzbos = zzazh;
        this.zzgey = zzchp;
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return (zzdmu.zzhgx == null || zzdmu.zzhgx.zzdrp == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzb(zzdmu zzdmu, zzdnj zzdnj, zzcif zzcif, Object obj) {
        zzdyz<?> zzdyz;
        zzbdv zza = this.zzgey.zza(this.zzfvl.zzbpe, zzdmu, zzdnj.zzhik.zzerj, zzdmu.zzerh);
        zza.zzaw(zzdmu.zzdvo);
        zzcif.zzc(this.context, zza.getView());
        zzazq zzazq = new zzazq();
        zzbyz zza2 = this.zzgrt.zza(new zzbos(zzdnj, zzdmu, (String) null), new zzbzc(new zzctb(this.context, this.zzbos, zzazq, zzdmu, zza), zza));
        zzazq.set(zza2);
        zza2.zzaft().zza(new zzcta(zza), zzazj.zzegu);
        zza2.zzagr().zzb(zza, true);
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwz)).booleanValue() || !zzdmu.zzerh) {
            zza2.zzagr();
            zzdyz = zzchr.zza(zza, zzdmu.zzhgx.zzdrn, zzdmu.zzhgx.zzdrp);
        } else {
            zzdyz = zzdyr.zzag(null);
        }
        return zzdyr.zzb(zzdyz, new zzcsz(this, zza, zzdmu, zza2), this.zzfqx);
    }

    public final zzdyz<zzbyx> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        zzcif zzcif = new zzcif();
        zzdyz<zzbyx> zzb = zzdyr.zzb(zzdyr.zzag(null), new zzcsy(this, zzdmu, zzdnj, zzcif), this.zzfqx);
        zzcif.getClass();
        zzb.addListener(zzcsx.zza(zzcif), this.zzfqx);
        return zzb;
    }
}
